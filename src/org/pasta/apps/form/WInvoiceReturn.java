/******************************************************************************
 * Product: Adempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2006 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software; you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program; if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/

/**
 * 2007, Modified by Posterita Ltd.
 */

package org.pasta.apps.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;

import org.adempiere.exceptions.AdempiereException;
import org.adempiere.webui.component.Button;
import org.adempiere.webui.component.Combobox;
import org.adempiere.webui.component.Grid;
import org.adempiere.webui.component.GridFactory;
import org.adempiere.webui.component.Label;
import org.adempiere.webui.component.ListCell;
import org.adempiere.webui.component.ListHead;
import org.adempiere.webui.component.ListHeader;
import org.adempiere.webui.component.ListItem;
import org.adempiere.webui.component.ListModelTable;
import org.adempiere.webui.component.Listbox;
import org.adempiere.webui.component.ListboxFactory;
import org.adempiere.webui.component.Panel;
import org.adempiere.webui.component.Row;
import org.adempiere.webui.component.Rows;
import org.adempiere.webui.component.Searchbox;
import org.adempiere.webui.component.Textbox;
import org.adempiere.webui.component.WListItemRenderer;
import org.adempiere.webui.component.WListbox;
import org.adempiere.webui.editor.WDateEditor;
import org.adempiere.webui.editor.WSearchEditor;
import org.adempiere.webui.editor.WTableDirEditor;
import org.adempiere.webui.event.ValueChangeEvent;
import org.adempiere.webui.event.ValueChangeListener;
import org.adempiere.webui.panel.ADForm;
import org.adempiere.webui.panel.CustomForm;
import org.adempiere.webui.panel.IFormController;
import org.adempiere.webui.session.SessionManager;
import org.adempiere.webui.window.FDialog;
import org.apache.commons.lang.StringUtils;
import org.compiere.minigrid.IMiniTable;
import org.compiere.model.MLookup;
import org.compiere.model.MLookupFactory;
import org.compiere.util.CLogger;
import org.compiere.util.DisplayType;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;
import org.compiere.util.Msg;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zkex.zul.Borderlayout;
import org.zkoss.zkex.zul.Center;
import org.zkoss.zkex.zul.North;
import org.zkoss.zkex.zul.South;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Separator;
import org.zkoss.zul.Space;

/**
 * This class represents the Custom Form for generating charges
 * from natural accounts.
 *
 * The form is comprised of two parts.
 * The upper portion can be used to create new charges using the general charge accounts.
 * The lower portion can be used to create charges based on the natural account.
 *
 * @author Andrew Kimball
 *
 */
public class WInvoiceReturn extends InvoiceReturn implements IFormController, EventListener , ValueChangeListener
{
    /**
	 *
	 */
	private static final long serialVersionUID = 4210542409436277344L;

	private CustomForm form = new CustomForm();

    /** Logger.          */
    private static CLogger log = CLogger.getCLogger(WInvoiceReturn.class);

    /** Table to hold data of accounts. */
    private WListbox m_tblData = new WListbox();
    
    // new panel
    private Grid m_paramPanel = GridFactory.newGridLayout();// Parameter Section Panel
    private Panel m_ListPanel = new Panel();// Invoice List Section Panel
    private Grid m_confirmPanel = GridFactory.newGridLayout();// Confirm Section Panel
    
	private WTableDirEditor organizationPick;
    
	private Textbox invoiceNoFromField = new Textbox();
	private Textbox invoiceNoToField = new Textbox();
	
    private WDateEditor dateFromField = new WDateEditor();
    private WDateEditor dateToField = new WDateEditor();
    
	private Listbox invoiceDocTypePick= ListboxFactory.newDropdownListbox();
    
	private WSearchEditor bpartnerSearch = null;
	
	private Combobox sentToCustList = new Combobox();
	
	private Button m_btnSave = new Button();
	private Button m_btnFind = new Button();

    /**
     * Default constructor.
     */
    public WInvoiceReturn()
    {
        super();
        initForm();
    }


    /**
     * Initialises the panel.
     *
     * @param adFormId  The Adempiere identifier for the form
     * @param name      The name of the form
     */
    protected void initForm()
    {
        log.info("");
        try
        {
        	Env.setContext(getCtx(), this.getForm().getWindowNo(), "IsSOTrx", "Y");
        	dynamicFieldsSetup();
            staticInitialise();
            zkInit();
        }
        catch(Exception e)
        {
            log.log(Level.SEVERE, "", e);
        }

        return;
    }


    private void dynamicFieldsSetup() {
		// TODO Auto-generated method stub
    	int AD_Column_ID = 839; //C_Period.AD_Org_ID (needed to allow org 0)
		MLookup lookupOrg = MLookupFactory.get(Env.getCtx(), form.getWindowNo(), 0, AD_Column_ID, DisplayType.TableDir);
		organizationPick = new WTableDirEditor("AD_Org_ID", true, false, true, lookupOrg);
		organizationPick.setValue(Env.getAD_Org_ID(Env.getCtx()));
		organizationPick.addValueChangeListener(this);
		
		ArrayList<KeyNamePair> docTypeData = getDocTypeData(Env.getAD_Org_ID(Env.getCtx()));
		for(KeyNamePair pp : docTypeData)
			invoiceDocTypePick.appendItem(pp.getName(), pp);
		
		AD_Column_ID = 3499;        //  C_Invoice.C_BPartner_ID
		MLookup lookupBP = MLookupFactory.get (Env.getCtx(), form.getWindowNo(), 0, AD_Column_ID, DisplayType.Search);
		bpartnerSearch = new WSearchEditor("C_BPartner_ID", false, false, true, lookupBP);
		//bpartnerSearch.addValueChangeListener(this);
		
		sentToCustList.appendItem("Yes", "Y");
		sentToCustList.appendItem("No", "N");
	}


	/**
     * Initialises the static components of the form.
     */
    private void staticInitialise()
    {
        createParametersPanel();
        createInvoiceListPanel();
        createConfirmPanel();

        return;
    }

    private void zkInit()
	{
    	Borderlayout contentPane = new Borderlayout();
		form.appendChild(contentPane);

		North north = new North();
		contentPane.appendChild(north);
		north.appendChild(m_paramPanel);

		Center center = new Center();
        contentPane.appendChild(center);
		center.appendChild(m_ListPanel);

		South south = new South();
		contentPane.appendChild(south);
		Panel southPanel = new Panel();
		south.appendChild(southPanel);
		southPanel.appendChild(new Separator());
		southPanel.appendChild(m_confirmPanel);
	}

    /**
     * Creates the account panel.
     *
     * The account panel contains:
     * <li>a table detailing all accounts
     * <li>a button for creating charges for selected accounts
     */
    private void createInvoiceListPanel()
    {
    	Borderlayout borderlayout = new Borderlayout();
    	borderlayout.setStyle("position: absolute");
    	borderlayout.setWidth("100%");
    	borderlayout.setHeight("100%");
    	m_ListPanel.appendChild(borderlayout);

		North north = new North();
		north.setBorder("none");
		borderlayout.appendChild(north);
        Label label = new Label(Msg.getMsg(Env.getCtx(), "InvoiceStatus"));
        label.setStyle("font-weight: bold;");
		north.appendChild(label);

		Center center = new Center();
		center.setBorder("none");
		center.setFlex(true);
		center.setAutoscroll(true);
		borderlayout.appendChild(center);
		center.appendChild(m_tblData);

		South south = new South();
		south.setBorder("none");
		borderlayout.appendChild(south);
		Panel southPanel = new Panel();
		southPanel.setAlign("right");
		south.appendChild(southPanel);
		/*m_btnAccount.setLabel(Msg.getMsg(Env.getCtx(), AD_MESSAGE_CREATE) + " " + Msg.getMsg(Env.getCtx(), "From") + " " + Msg.getElement(Env.getCtx(), "Account_ID"));
        m_btnAccount.addEventListener(Events.ON_CLICK, this);
		southPanel.appendChild(m_btnAccount);*/

        return;
    }


    private void createParametersPanel()
    {
    	Rows rows = new Rows();
    	m_paramPanel.appendChild(rows);
    	
    	Space space = new Space();
    	space.setWidth("400");
    	
    	Row row = new Row();
        rows.appendChild(row);
        //row.setSpans("4");
        //row.setWidth("30");
        Label m_lblValue = new Label(Msg.translate(Env.getCtx(), "AD_Org_ID"));
        m_lblValue.setStyle("font-weight: bold;");
        row.appendChild(m_lblValue.rightAlign());
        Combobox organizationL = organizationPick.getComponent();
        organizationL.setWidth("140");
        row.appendChild(organizationL);
        row.appendChild(space);
        row.appendChild(space);
        row.setSpans("1,3,1,1");

        m_lblValue = new Label(Msg.getMsg(Env.getCtx(), "InvoiceNo"));
    	row = new Row();
    	//row.setSpans("4");
        rows.appendChild(row);
        row.appendChild(m_lblValue.rightAlign());
        row.appendChild(invoiceNoFromField);
        m_lblValue = new Label(Msg.getMsg(Env.getCtx(), "-"));
        row.appendChild(m_lblValue);
        row.appendChild(invoiceNoToField);
        row.appendChild(space);
        row.appendChild(space);
        
        m_lblValue = new Label(Msg.translate(Env.getCtx(), "DateInvoiced"));
    	row = new Row();
    	//row.setSpans("4");
        rows.appendChild(row);
        row.appendChild(m_lblValue.rightAlign());
        row.appendChild(dateFromField.getComponent());
        m_lblValue = new Label(Msg.getMsg(Env.getCtx(), "-"));
        row.appendChild(m_lblValue);
        row.appendChild(dateToField.getComponent());
        row.appendChild(space);
        row.appendChild(space);
        
        m_lblValue = new Label(Msg.getMsg(Env.getCtx(), "InvDoctype"));
    	row = new Row();
    	//row.setSpans("4");
        rows.appendChild(row);
        row.appendChild(m_lblValue.rightAlign());
        //Combobox invDocTypeL = invoiceDocTypePick.getComponent();
        invoiceDocTypePick.setWidth("140");
        row.appendChild(invoiceDocTypePick);
        row.appendChild(space);
        row.appendChild(space);
        row.setSpans("1,3,1,1");
        
        row = new Row();
    	//row.setSpans("4");
        rows.appendChild(row);
        m_lblValue = new Label(Msg.getMsg(Env.getCtx(), "Customer"));
        //m_lblValue.setStyle("font-weight: bold;");
        row.appendChild(m_lblValue.rightAlign());
        Searchbox customerSch = bpartnerSearch.getComponent();
        customerSch.setWidth("140");
        row.appendChild(customerSch);
        row.appendChild(space);
        row.appendChild(space);
        row.setSpans("1,3,1,1");
        

        String name = "Find";

        m_btnFind.setName(name);
        m_btnFind.setImage("images/"+name+"24.png");
        //m_btnRequery.setStyle("height:80px;width:80px;");
        m_btnFind.addEventListener(Events.ON_CLICK, this);
        
        row = new Row();
    	//row.setSpans("4");
        rows.appendChild(row);
        m_lblValue = new Label(Msg.getMsg(Env.getCtx(), "SentToCust"));
        //m_lblValue.setStyle("font-weight: bold;");
        row.appendChild(m_lblValue.rightAlign());
        sentToCustList.setWidth("140");
        row.appendChild(sentToCustList);
        row.appendChild(space);
        row.appendChild(space);
        row.appendChild(space);
        row.appendChild(m_btnFind);
        
        row = new Row();
    	//row.setSpans("4");
        rows.appendChild(row);
        //row.appendChild(new Space());
        
        return;
    }

    /**
     *  Event Listener.
     *
     *  @param event event that has been fired.
     */
    public void onEvent(Event event)
    {
        log.info(event.getName());
        System.out.println(event.getName());
        
        if(event.getTarget().equals(m_btnFind)){
        	log.finer("Find Button");
        	
        	int orgId = (Integer)organizationPick.getValue();
        	String invoiceFrom = invoiceNoFromField.getValue();
        	String invoiceTo = invoiceNoToField.getValue();
        	Date invoiceDateFrom = dateFromField.getComponent().getValue();
        	Date invoiceDateTo = dateToField.getComponent().getValue();
        	
        	int invoiceDocType = 0;
        	if(invoiceDocTypePick.getSelectedIndex() >0){
        		invoiceDocType = ((KeyNamePair)invoiceDocTypePick.getSelectedItem().getValue()).getKey() ;
        	}
        	
        	int customerId = 0 ;
        	if(bpartnerSearch.getValue() != null)
        		customerId = (Integer)bpartnerSearch.getValue();
        	 
        	String invoiceSent = "";
        	if(sentToCustList.getSelectedIndex() >= 0)
        		invoiceSent = (String)sentToCustList.getSelectedItem().getValue();
        	
        	reloadData(orgId,invoiceFrom,invoiceTo,invoiceDateFrom,invoiceDateTo,invoiceDocType,customerId,invoiceSent);
        }
        else if (event.getTarget().equals(m_btnSave)){
        	log.finer("Save Button");
        	
        	if(FDialog.ask(form.getWindowNo(), form, "Do you want to update Invoice Status?")){
        		List<ListItem> itemL = m_tblData.getItems();
            	
            	for(ListItem item :itemL){
            		List objL = item.getChildren();
            		ListCell cell = (ListCell)objL.get(0);
            		//System.out.println(cell.getValue());
            		
            		if(cell != null && cell.getValue() != null ){
	            		boolean isSelected = (Boolean)cell.getValue();
	            		if(isSelected){
	            			cell = (ListCell)objL.get(1);
	            			int C_Invoice_ID = (Integer)getIds().get(cell.getValue());
	            			
	            			cell = (ListCell)objL.get(5);
	            			String invoiceStatus = "";
	            			if(cell.getValue()!= null)
	            				invoiceStatus = cell.getValue().toString();
	            			
	            			cell = (ListCell)objL.get(6);
	            			//System.out.println(cell.getValue());
	            			boolean isSent = (Boolean)cell.getValue();
	            			System.out.println("Invoice IsSent "+isSent);
	            			
	            			if(!updateInvoice(C_Invoice_ID,invoiceStatus,isSent))
	            				throw new AdempiereException("CANNOT_UPDATE_INVOCIE");
	            		}
            		}
            	}
        	}
        	else
        		return;
        	
        	clearData();
        }
    }

   
    private void clearData() {
		// TODO Auto-generated method stub
    	invoiceNoFromField.setValue(null);
    	invoiceNoToField.setValue(null);
    	dateFromField.getComponent().setValue(null);
    	dateToField.getComponent().setValue(null);
    	invoiceDocTypePick.setValue(null);
    	bpartnerSearch.setValue(null);
    	sentToCustList.setValue(null);
    	m_tblData.clear();
	}


	/**
     *  Create Confirmation Panel with OK Button.
     */
    public void createConfirmPanel()
    {
    	Rows rows = new Rows();
    	m_confirmPanel.appendChild(rows);
    	
    	String name = "Save";

        m_btnSave.setName(name);
        m_btnSave.setImage("images/"+name+"24.png");
        m_btnSave.setStyle("height:45px;width:45px;");
        m_btnSave.addEventListener(Events.ON_CLICK, this);
        
        Space space = new Space();
    	space.setWidth("400");
        
        Row row = new Row();
        rows.appendChild(row);
        row.appendChild(m_btnSave);
        row.appendChild(space);
        row.appendChild(space);
        row.setAlign("right");
        
        return;
    }   //  ConfirmPanel


    public void close()
    {
        SessionManager.getAppDesktop().closeActiveWindow();
    }


	public ADForm getForm() {
		return form;
	}

	public void valueChange(ValueChangeEvent evt) {
		// TODO Auto-generated method stub
		log.info(evt.getSource().toString());
        
        if(evt.getSource().equals(organizationPick)){
        	reloadInvDocType(Integer.valueOf(organizationPick.getValue().toString()));
        }
	}

	private void reloadInvDocType(int AD_Org_ID) {
		// TODO Auto-generated method stub
		invoiceDocTypePick.removeAllItems();
		ArrayList<KeyNamePair> docTypeData = getDocTypeData(AD_Org_ID);
		for(KeyNamePair pp : docTypeData)
			invoiceDocTypePick.appendItem(pp.getName(), pp);
	}
	
	private void reloadData(int orgId, String invoiceFrom, String invoiceTo, Date invoiceDateFrom, Date invoiceDateTo, int invoiceDocType, int customerId, String invoiceSent){
		ListModelTable model = new ListModelTable(getData(orgId,invoiceFrom,invoiceTo,invoiceDateFrom,invoiceDateTo,invoiceDocType,customerId,invoiceSent));
        m_tblData.setData(model, getColumnNames());
		setColumnClass(m_tblData);
	}
}


