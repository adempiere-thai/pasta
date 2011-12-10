package org.pasta.process;

import java.awt.Desktop;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.logging.Level;

import org.adempiere.exceptions.AdempiereException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.compiere.model.MAttachment;
import org.compiere.model.MAttachmentEntry;
import org.compiere.model.MLocation;
import org.compiere.model.MOrg;
import org.compiere.model.MProcess;
import org.compiere.model.MRefList;
import org.compiere.model.MSession;
import org.compiere.model.Query;
import org.compiere.process.ClientProcess;
import org.compiere.process.ProcessCall;
import org.compiere.process.ProcessInfo;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.ProcessInfoUtil;
import org.compiere.report.ReportStarter;
import org.compiere.util.AmtInWords;
import org.compiere.util.AmtInWords_TH;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.compiere.util.Trx;
import org.compiere.utils.DigestOfFile;

import org.pasta.model.MWHTaxTrans;
import org.pasta.model.MBPartner;
import org.pasta.model.X_C_WHTaxTrans;
import org.pasta.model.X_C_WHTaxTransLine;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.AcroFields;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfCopyFields;
import com.lowagie.text.pdf.PdfDictionary;
import com.lowagie.text.pdf.PdfName;
import com.lowagie.text.pdf.PdfNumber;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;

public class WithholdingCertificate implements ProcessCall, ClientProcess{
	
	private static CLogger log = CLogger.getCLogger(WithholdingCertificate.class);
	
	DecimalFormat dcFmt = new DecimalFormat("###,###,###");

	int p_C_BPartner_ID = 0;

	Timestamp p_dateDocFrom = null;
	Timestamp p_dateDocTo = null;

	String p_pndType = null;

	String p_DocNoFrom = null;
	String p_DocNoTo = null;

	String p_BookNo = null;

	String p_WHTaxStatus = null;

	protected String doIt() throws Exception {
		StringBuffer whereClause = new StringBuffer();

		List<Object> params = new ArrayList<Object>();

		whereClause.append(X_C_WHTaxTrans.COLUMNNAME_IsActive + " ='Y' ");

		if (p_dateDocFrom != null) {
			whereClause.append("AND " + X_C_WHTaxTrans.COLUMNNAME_DateDoc
					+ " >= ? ");
			params.add(p_dateDocFrom);
		}
		if (p_dateDocTo != null) {
			whereClause.append("AND " + X_C_WHTaxTrans.COLUMNNAME_DateDoc
					+ " <= ? ");
			params.add(p_dateDocTo);
		}

		if (p_WHTaxStatus != null) {
			whereClause.append("AND "
					+ X_C_WHTaxTrans.COLUMNNAME_WHTCertifiedStatus + " = ? ");
			params.add(p_WHTaxStatus);
		}

		if (p_pndType != null && p_pndType.length() > 0) {
			whereClause.append("AND " + X_C_WHTaxTrans.COLUMNNAME_PNDType
					+ " = ? ");
			params.add(p_pndType);
		}

		if (!StringUtils.isEmpty(p_DocNoFrom)) {
			whereClause.append("AND " + X_C_WHTaxTrans.COLUMNNAME_DocumentNo
					+ " >= ? ");
			params.add(p_DocNoFrom);
		}

		if (!StringUtils.isEmpty(p_DocNoTo)) {
			whereClause.append("AND " + X_C_WHTaxTrans.COLUMNNAME_DocumentNo
					+ " <= ? ");
			params.add(p_DocNoFrom);
		}

		if (p_C_BPartner_ID > 0) {
			whereClause.append("AND " + X_C_WHTaxTrans.COLUMNNAME_C_BPartner_ID
					+ " = ? ");
			params.add(p_C_BPartner_ID);
		}

		log.info("WHTax Transaction Condition => " + whereClause.toString());

		String orderBy = X_C_WHTaxTrans.COLUMNNAME_DateDoc;

		List<MWHTaxTrans> transL = new Query(getCtx(), MWHTaxTrans.Table_Name,
				whereClause.toString(), get_TrxName()).setOrderBy(orderBy)
				.setParameters(params).list();

		if (transL.size() <= 0)
			throw new AdempiereException(
					"NO_WITHHOLDING_TRANSACTION_IN_CRITERIA");

		log.info("Transaction => " + transL.size());

		// Get Withholding Tax Form
		File pdfForm = getPDFForm();
		if (pdfForm == null)
			throw new AdempiereException("NO_WITHHOLDING_FORM");

		File certified = createWHTaxForm(pdfForm, transL);

		return openFile(certified);// .getPath() + " " + certified.getName();
	}

	private String get_TrxName() {
		// TODO Auto-generated method stub
		return this.trxName;
	}

	private Properties getCtx() {
		// TODO Auto-generated method stub
		return this.m_ctx;
	}

	private String openFile(File certified) throws Exception {
		// TODO Auto-generated method stub
		
		MSession session = MSession.get(this.getCtx(), false);
		
		if(StringUtils.isEmpty(session.getWebSession())){
			java.awt.Desktop desktop = Desktop.getDesktop();
			desktop.open(certified);
		}
		else{
			ReportStarter.viewPdfWebUI(certified.getName(), new FileInputStream(certified));
		}
		
		return "";
	}

	private ProcessInfo getProcessInfo() {
		// TODO Auto-generated method stub
		return this.m_pi;
	}

	private File createWHTaxForm(File pdfForm, List<MWHTaxTrans> transL)
			throws Exception {
		PdfDictionary pageDict;

		// FileInputStream fInput = new FileInputStream(pdfForm);
		PdfReader reader = new PdfReader(pdfForm.toURI().toString());

		// Rotate Page
		int rot = reader.getPageRotation(1);
		pageDict = reader.getPageN(1);
		pageDict.put(PdfName.ROTATE, new PdfNumber(rot - 90));

		PdfCopy copy = null;// new PdfCopyFields(new
		// FileOutputStream(destPath));
		ByteArrayOutputStream baos = null;
		Document document = null;

		MOrg reportOrg = getReportingOrg();
		if (reportOrg == null)
			throw new AdempiereException("NO_REPORTING_ORG");

		String orgTaxId = reportOrg.getInfo().getTaxID();
		if (orgTaxId.length() != 10)
			throw new AdempiereException("REPORTING_ORG_TAXID_NOT_10");

		MLocation loc = (MLocation) reportOrg.getInfo().getC_Location();
		String reportOrgAddress = getAddressString(loc);
		// boolean isFirst = true;

		List<File> certifieds = new ArrayList<File>();

		for (X_C_WHTaxTrans trans : transL) {
			File certified = new File(trans.getDocumentNo() + ".pdf");

			// baos = new ByteArrayOutputStream();

			PdfReader r2 = new PdfReader(reader);

			OutputStream output = new FileOutputStream(certified);
			
			// Stamp Field Value
			PdfStamper stamper = new PdfStamper(r2, output);
			AcroFields form = stamper.getAcroFields();

			// Clear Form
			// clearFormValue(form);

			/** Start Set Form **/
			// 1 Set Client Information
			form.setField("book_no", p_BookNo);
			form.setField("run_no", trans.getDocumentNo());
			form.setField("name1", reportOrg.getName());
			form.setField("add1", reportOrgAddress);

			int idx = 0;
			for (char id : orgTaxId.toCharArray()) {
				idx++;
				form.setField("tin" + idx, String.valueOf(id));
			}

			// 2 Set Vendor Information
			MBPartner partner = new MBPartner(getCtx(), trans
					.getC_BPartner_ID(), get_TrxName());

			String partnerName = trans.getActualTaxBPartnerName();
			if (StringUtils.isEmpty(partnerName)) {
				partnerName = partner.getName();
			}
			form.setField("name2", partnerName);

			String partnerAddr = trans.getActualTaxAddress();
			if (StringUtils.isEmpty(partnerAddr)) {
				MLocation bploc = MLocation.getBPLocation(getCtx(), trans
						.getC_BPartner_Location_ID(), get_TrxName());
				partnerAddr = this.getAddressString(bploc);
			}

			form.setField("add2", partnerAddr);

			String bpTaxId = trans.getTaxID();
			if (StringUtils.isEmpty(bpTaxId)) {
				bpTaxId = partner.getTaxID();
			}

			if (!StringUtils.isEmpty(bpTaxId)) {
				idx = 0;
				for (char id : bpTaxId.toCharArray()) {
					idx++;
					form.setField("tin" + idx + "_2", String.valueOf(id));
				}
			} else {
				String bpCitizenId = trans.getCitizenID();
				if (!StringUtils.isEmpty(bpCitizenId)) {
					bpCitizenId = partner.getCitizenID();
					idx = 0;
					for (char id : bpCitizenId.toCharArray()) {
						idx++;
						form.setField("id" + idx + "_2", String.valueOf(id));
					}
				}
			}

			form.setField("item", String.valueOf(trans.getSeqNo()));

			String pndType = getPNDType(trans.getPNDType());
			if (!StringUtils.isEmpty(pndType))
				form.setField(pndType, "Yes");

			// 3 Set Detail
			List<X_C_WHTaxTransLine> lineL = MWHTaxTrans.getLines(getCtx(),
					trans.getC_WHTaxTrans_ID(), get_TrxName());

			SimpleDateFormat sdFmt = new SimpleDateFormat("dd/MM/yyyy",
					new Locale("th", "TH"));

			BigDecimal totalTaxAmt = Env.ZERO;
			BigDecimal totalBaseAmt = Env.ZERO;
			
			for (X_C_WHTaxTransLine line : lineL) {
				int no = getNoOfItem(line);

				if (no > 0) {
					Date trxDate = new Date(line.getDateTrx().getTime());
					BigDecimal baseAmt = line.getTaxBaseAmt().setScale(2,
							BigDecimal.ROUND_HALF_UP);
					String[] baseAmtTxt = baseAmt.toString().split("[.]");

					BigDecimal taxAmt = line.getTaxAmt().setScale(2,
							BigDecimal.ROUND_HALF_UP);
					String[] taxAmtTxt = taxAmt.toString().split("[.]");

					form.setField("date" + no, sdFmt.format(trxDate));
					form.setField("pay" + no,  dcFmt.format(Double.valueOf(baseAmtTxt[0]) ));
					form.setField("tax" + no, dcFmt.format(Double.valueOf(taxAmtTxt[0])));
					form.setField("st" + no, baseAmtTxt[1]);
					form.setField("st_tax" + no, taxAmtTxt[1]);

					totalTaxAmt = totalTaxAmt.add(taxAmt);
					totalBaseAmt = totalBaseAmt.add(baseAmt);

					String remark = line.getRemarks();
					if (StringUtils.isEmpty(remark)) {
						String remarkLabel = null;
						switch (no) {
						case (8):
							remarkLabel = "remarkLeabel";
							break;
						case (12):
							remarkLabel = "spec1";
							break;
						case (13):
							remarkLabel = "spec2";
							break;
						case (14):
							remarkLabel = "spec3";
							break;
						default:
							break;
						}

						if (remarkLabel != null)
							form.setField(remarkLabel, remark);
					}
				}
			}
			// 4 Set Summary
			String[] totalBaseTxt = totalBaseAmt.setScale(2,
					BigDecimal.ROUND_HALF_UP).toString().split("[.]");
			String[] totalTaxTxt = totalTaxAmt.setScale(2,
					BigDecimal.ROUND_HALF_UP).toString().split("[.]");

			form.setField("pay15", dcFmt.format(Double.valueOf(totalBaseTxt[0])));
			form.setField("st15", totalBaseTxt[1]);

			form.setField("tax15", dcFmt.format(Double.valueOf(totalTaxTxt[0])));
			form.setField("st_tax15", totalTaxTxt[1]);

			AmtInWords wordUtils = new AmtInWords_TH();
			String amtInWord = wordUtils.getAmtInWords(totalTaxAmt.setScale(2,
					BigDecimal.ROUND_HALF_UP).toString());
			form.setField("total", amtInWord);

			int type = Integer.valueOf(trans.getWHTaxType()) + 7;
			form.setField("chk" + type, "Yes");

			if (!StringUtils.isEmpty(trans.getWHTaxTypeOthers()))
				form.setField("spec4", trans.getWHTaxTypeOthers());

			SimpleDateFormat sdfm = new SimpleDateFormat("dd.MM.yyyy",
					new Locale("th", "TH"));
			String printDate = sdfm.format(new Date());
			String[] dateTxt = printDate.split("[.]");

			form.setField("date_pay", dateTxt[0]);
			form.setField("month_pay", dateTxt[1]);
			form.setField("year_pay", dateTxt[2]);

			/** End Set Form **/
			stamper.setFormFlattening(true);
			stamper.close();
			r2.close();
			output.close();		
			certifieds.add(certified);
		}
		/*
		 * if (document != null) document.close(); if (copy != null)
		 * copy.close();
		 */

		if (certifieds.size() == 1)
			return certifieds.get(0);
		else if (certifieds.size() > 1)
			return merge(certifieds);

		return null;
	}

	private File merge(List<File> certifieds) throws Exception {
		File retFile = new File(Env.getAD_Client_ID(getCtx()) + "_"
				+ (new Date()).getTime() + ".pdf");

		OutputStream output = new FileOutputStream(retFile);
		
		PdfCopyFields copy = new PdfCopyFields(output);
		
		int page_idx = 0;
		
		for (File certified : certifieds) {
			//page_idx++;
			InputStream input = new FileInputStream(certified);
			PdfReader reader = new PdfReader(input);
			copy.addDocument(reader);
			reader.close();
			input.close();
			FileUtils.forceDelete(certified);
		}
		copy.close();
		

		return retFile;
	}

	private int getNoOfItem(X_C_WHTaxTransLine line) {
		int no = 0;
		switch (line.getC_RevenueType_ID()) {
		case (1000000):
			no = 1;
			break;// 1
		case (1000001):
			no = 2;
			break;// 2
		case (1000002):
			no = 3;
			break;// 3
		case (1000003):
			no = 4;
			break;// 4. (ก)
		case (1000004):
			no = 5;
			break;// 4. (ข) 1.1
		case (1000005):
			no = 6;
			break;// 4. (ข) 1.2
		case (1000006):
			no = 7;
			break;// 4. (ข) 1.3
		case (1000014):
			no = 8;
			break;// 4. (ข) 1.3
		case (1000007):
			no = 9;
			break;// 4. (ข) 2.1
		case (1000008):
			no = 10;
			break;// 4. (ข) 2.2
		case (1000009):
			no = 11;
			break;// 4. (ข) 2.3
		case (1000010):
			no = 12;
			break;// 4. (ข) 2.4
		case (1000011):
			no = 12;
			break;// 4. (ข) 2.5
		case (1000012):
			no = 13;
			break;// 5
		case (1000013):
			no = 14;
			break;// 6
		default:
			no = 0;
			break;
		}
		return no;
	}

	private String getPNDType(String pndType) {
		// FIXED CODE REFERENCE ID FOR PND TYPE LIST
		int referenceId = 80000;
		MRefList option = MRefList.get(getCtx(), referenceId, pndType,
				get_TrxName());

		String label = null;
		switch (option.getAD_Ref_List_ID()) {
		case (80000):
			label = "chk1";
			break;// ภ.ง.ด.1 ก
		case (80001):
			label = "chk2";
			break;// ภ.ง.ด.1ก พิเศษ
		case (80002):
			label = "chk3";
			break;// ภ.ง.ด.2
		case (80003):
			label = "chk5";
			break;// ภ.ง.ด.2ก
		case (80004):
			label = "chk4";
			break;// ภ.ง.ด.3
		case (80005):
			label = "chk6";
			break;// ภ.ง.ด.3ก
		case (80006):
			label = "chk7";
			break;// ภ.ง.ด.53
		default:
			label = "";
			break;
		}

		return label;
	}

	private String getAddressString(MLocation loc) {
		List<String> addressL = new ArrayList<String>();
		if (loc.getAddress1() != null && loc.getAddress1().trim().length() > 0)
			addressL.add(loc.getAddress1().trim());

		if (loc.getAddress2() != null && loc.getAddress2().trim().length() > 0)
			addressL.add(loc.getAddress2().trim());

		if (loc.getAddress3() != null && loc.getAddress3().trim().length() > 0)
			addressL.add(loc.getAddress3().trim());

		if (loc.getAddress4() != null && loc.getAddress4().trim().length() > 0)
			addressL.add(loc.getAddress4().trim());

		if (loc.getCity() != null && loc.getCity().trim().length() > 0)
			addressL.add(loc.getCity().trim());

		if (loc.getPostal() != null && loc.getPostal().trim().length() > 0)
			addressL.add(loc.getPostal().trim());

		if (addressL.size() > 0)
			return StringUtils.join(addressL.iterator(), " ");

		return null;
	}

	private MOrg getReportingOrg() {
		MOrg reportOrg = null;
		String whereClause = "IsReportingOrg = 'Y' AND AD_CLIENT_ID = ?";
		Object[] params = { Env.getAD_Client_ID(getCtx()) };

		reportOrg = new Query(getCtx(), MOrg.Table_Name, whereClause,
				get_TrxName()).setParameters(params).first();

		return reportOrg;
	}

	private File getPDFForm() {
		File reportFile = null;
		String name = "approve_wh.pdf";
		MProcess process = new MProcess(getCtx(), getProcessInfo()
				.getAD_Process_ID(), getProcessInfo().getTransactionName());
		MAttachment attachment = process.getAttachment();

		if (attachment != null) {
			MAttachmentEntry[] entries = attachment.getEntries();
			MAttachmentEntry entry = null;
			for (int i = 0; i < entries.length; i++) {
				if (entries[i].getName().equals(name)) {
					entry = entries[i];
					break;
				}
			}
			if (entry != null) {
				reportFile = getAttachmentEntryFile(entry);
			}
		}
		return reportFile;
	}

	private File getAttachmentEntryFile(MAttachmentEntry entry) {
		String localFile = System.getProperty("java.io.tmpdir")
				+ System.getProperty("file.separator") + entry.getName();
		String downloadedLocalFile = System.getProperty("java.io.tmpdir")
				+ System.getProperty("file.separator") + "TMP"
				+ entry.getName();
		File reportFile = new File(localFile);
		if (reportFile.exists()) {
			String localMD5hash = DigestOfFile.GetLocalMD5Hash(reportFile);
			String entryMD5hash = DigestOfFile.getMD5Hash(entry.getData());
			if (localMD5hash.equals(entryMD5hash)) {
				log.info(" no need to download: local report is up-to-date");
			} else {
				log
						.info(" report on server is different that local one, download and replace");
				File downloadedFile = new File(downloadedLocalFile);
				entry.getFile(downloadedFile);
				if (!reportFile.delete()) {
					throw new AdempiereException(
							"Cannot delete temporary file "
									+ reportFile.toString());
				}
				if (!downloadedFile.renameTo(reportFile)) {
					throw new AdempiereException(
							"Cannot rename temporary file "
									+ downloadedFile.toString() + " to "
									+ reportFile.toString());
				}
			}
		} else {
			entry.getFile(reportFile);
		}
		return reportFile;
	}

	protected void prepare() {
		ProcessInfoParameter[] params = getParameter();
		
		for (ProcessInfoParameter param : params) {
			String paramName = param.getParameterName();

			if (param.getParameter() == null) {
				;
			} else if ("PNDType".equals(paramName)) {
				p_pndType = (String) param.getParameter();
			} else if ("C_BPartner_ID".equals(paramName)) {
				p_C_BPartner_ID = param.getParameterAsInt();
			} else if ("p_BookNo".equals(paramName)) {
				p_BookNo = (String) param.getParameter();
			} else if ("p_WHTaxStatus".equals(paramName)) {
				p_WHTaxStatus = (String) param.getParameter();
			} else if ("p_DocNo".equals(paramName)) {
				p_DocNoFrom = (String) param.getParameter();
				p_DocNoTo = (String) param.getParameter_To();
			} else if ("DateDoc".equals(paramName)) {
				p_dateDocFrom = (Timestamp) param.getParameter();
				p_dateDocTo = (Timestamp) param.getParameter_To();
			} else
				log.log(Level.SEVERE, "Unknown Parameter: " + paramName);
		}
	}
	
	private ProcessInfoParameter[] getParameter() {
		ProcessInfoParameter[] retValue = m_pi.getParameter();
		if (retValue == null)
		{
			ProcessInfoUtil.setParameterFromDB(m_pi);
			retValue = m_pi.getParameter();
		}
		return retValue;
	}

	private Properties  		m_ctx;
	private ProcessInfo			m_pi;
	private String				trxName ;

	@Override
	public boolean startProcess(Properties ctx, ProcessInfo pi, Trx trx) {
		// TODO Auto-generated method stub
		this.m_ctx = ctx;
		this.m_pi = pi;
		this.trxName = null;
		if (trx != null) {
        	this.trxName = trx.getTrxName();
        }
		
		try{
			prepare();
			doIt();
		}
		catch(Exception ex){
			log.saveError("ERROR", ex);
			return false;
		}
		
		return true;
	}
}
