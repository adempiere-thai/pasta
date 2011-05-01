package org.pasta.util.jasper;

import net.sf.jasperreports.engine.JRDefaultScriptlet;
import java.text.SimpleDateFormat;
import java.text.DecimalFormat;
import java.math.BigDecimal;
import java.util.Locale;
import java.util.logging.Level;

import org.compiere.Adempiere;
import org.compiere.model.MLocation;
import org.compiere.util.CLogMgt;
import org.compiere.util.Env;
import org.compiere.util.Ini;
import org.compiere.util.Login;

public class Scriptlet extends JRDefaultScriptlet {
	private static final String[] majorNames = { "",
			"\u0e25\u0e49\u0e32\u0e19 ", };
	private static final String[] hundredThousandNames = { "",
			"\u0e2b\u0e19\u0e36\u0e48\u0e07\u0e41\u0e2a\u0e19",
			"\u0e2a\u0e2d\u0e07\u0e41\u0e2a\u0e19",
			"\u0e2a\u0e32\u0e21\u0e41\u0e2a\u0e19",
			"\u0e2a\u0e35\u0e48\u0e41\u0e2a\u0e19",
			"\u0e2b\u0e49\u0e32\u0e41\u0e2a\u0e19",
			"\u0e2b\u0e01\u0e41\u0e2a\u0e19",
			"\u0e40\u0e08\u0e47\u0e14\u0e41\u0e2a\u0e19",
			"\u0e41\u0e1b\u0e14\u0e41\u0e2a\u0e19",
			"\u0e40\u0e01\u0e49\u0e32\u0e41\u0e2a\u0e19" };

	private static final String[] tenThousandNames = { "",
			"\u0e2b\u0e19\u0e36\u0e48\u0e07\u0e2b\u0e21\u0e37\u0e48\u0e19",
			"\u0e2a\u0e2d\u0e07\u0e2b\u0e21\u0e37\u0e48\u0e19",
			"\u0e2a\u0e32\u0e21\u0e2b\u0e21\u0e37\u0e48\u0e19",
			"\u0e2a\u0e35\u0e48\u0e2b\u0e21\u0e37\u0e48\u0e19",
			"\u0e2b\u0e49\u0e32\u0e2b\u0e21\u0e37\u0e48\u0e19",
			"\u0e2b\u0e01\u0e2b\u0e21\u0e37\u0e48\u0e19",
			"\u0e40\u0e08\u0e47\u0e14\u0e2b\u0e21\u0e37\u0e48\u0e19",
			"\u0e41\u0e1b\u0e14\u0e2b\u0e21\u0e37\u0e48\u0e19",
			"\u0e40\u0e01\u0e49\u0e32\u0e2b\u0e21\u0e37\u0e48\u0e19" };

	private static final String[] thousandNames = { "",
			"\u0e2b\u0e19\u0e36\u0e48\u0e07\u0e1e\u0e31\u0e19",
			"\u0e2a\u0e2d\u0e07\u0e1e\u0e31\u0e19",
			"\u0e2a\u0e32\u0e21\u0e1e\u0e31\u0e19",
			"\u0e2a\u0e35\u0e48\u0e1e\u0e31\u0e19",
			"\u0e2b\u0e49\u0e32\u0e1e\u0e31\u0e19",
			"\u0e2b\u0e01\u0e1e\u0e31\u0e19",
			"\u0e40\u0e08\u0e47\u0e14\u0e1e\u0e31\u0e19",
			"\u0e41\u0e1b\u0e14\u0e1e\u0e31\u0e19",
			"\u0e40\u0e01\u0e49\u0e32\u0e1e\u0e31\u0e19" };

	private static final String[] hundredNames = { "",
			"\u0e2b\u0e19\u0e36\u0e48\u0e07\u0e23\u0e49\u0e2d\u0e22",
			"\u0e2a\u0e2d\u0e07\u0e23\u0e49\u0e2d\u0e22",
			"\u0e2a\u0e32\u0e21\u0e23\u0e49\u0e2d\u0e22",
			"\u0e2a\u0e35\u0e48\u0e23\u0e49\u0e2d\u0e22",
			"\u0e2b\u0e49\u0e32\u0e23\u0e49\u0e2d\u0e22",
			"\u0e2b\u0e01\u0e23\u0e49\u0e2d\u0e22",
			"\u0e40\u0e08\u0e47\u0e14\u0e23\u0e49\u0e2d\u0e22",
			"\u0e41\u0e1b\u0e14\u0e23\u0e49\u0e2d\u0e22",
			"\u0e40\u0e01\u0e49\u0e32\u0e23\u0e49\u0e2d\u0e22" };

	private static final String[] tensNames = { "", "\u0e2a\u0e34\u0e1a",
			"\u0e22\u0e35\u0e48\u0e2a\u0e34\u0e1a",
			"\u0e2a\u0e32\u0e21\u0e2a\u0e34\u0e1a",
			"\u0e2a\u0e35\u0e48\u0e2a\u0e34\u0e1a",
			"\u0e2b\u0e49\u0e32\u0e2a\u0e34\u0e1a",
			"\u0e2b\u0e01\u0e2a\u0e34\u0e1a",
			"\u0e40\u0e08\u0e47\u0e14\u0e2a\u0e34\u0e1a",
			"\u0e41\u0e1b\u0e14\u0e2a\u0e34\u0e1a",
			"\u0e40\u0e01\u0e49\u0e32\u0e2a\u0e34\u0e1a" };

	private static final String[] numNames = { "",
			"\u0e2b\u0e19\u0e36\u0e48\u0e07", "\u0e2a\u0e2d\u0e07",
			"\u0e2a\u0e32\u0e21", "\u0e2a\u0e35\u0e48", "\u0e2b\u0e49\u0e32",
			"\u0e2b\u0e01", "\u0e40\u0e08\u0e47\u0e14", "\u0e41\u0e1b\u0e14",
			"\u0e40\u0e01\u0e49\u0e32", "\u0e2a\u0e34\u0e1a",
			"\u0e2a\u0e34\u0e1a\u0e40\u0e2d\u0e47\u0e14",
			"\u0e2a\u0e34\u0e1a\u0e2a\u0e2d\u0e07",
			"\u0e2a\u0e34\u0e1a\u0e2a\u0e32\u0e21",
			"\u0e2a\u0e34\u0e1a\u0e2a\u0e35\u0e48",
			"\u0e2a\u0e34\u0e1a\u0e2b\u0e49\u0e32",
			"\u0e2a\u0e34\u0e1a\u0e2b\u0e01",
			"\u0e2a\u0e34\u0e1a\u0e40\u0e08\u0e47\u0e14",
			"\u0e2a\u0e34\u0e1a\u0e41\u0e1b\u0e14",
			"\u0e2a\u0e34\u0e1a\u0e40\u0e01\u0e49\u0e32" };

	/**
	 * Convert Less Than One Thousand
	 * 
	 * @param number
	 * @return
	 */
	private static String convertLessThanOneMillion(int number) {
		String soFar = new String();
		// Esta dentro de los 1os. diecinueve?? ISCAP
		/*
		 * if (number % 100 < 20) { soFar = numNames[(number % 100)]; number /=
		 * 100; }
		 */
		if (number != 0) {
			soFar = numNames[number % 10];
			if (number != 1 && soFar.equals("\u0e2b\u0e19\u0e36\u0e48\u0e07")) {
				soFar = "\u0e40\u0e2d\u0e47\u0e14";
			}
			number /= 10;

			soFar = tensNames[number % 10] + soFar;
			number /= 10;

			soFar = hundredNames[number % 10] + soFar;
			number /= 10;

			soFar = thousandNames[number % 10] + soFar;
			number /= 10;

			soFar = tenThousandNames[number % 10] + soFar;
			number /= 10;

			soFar = hundredThousandNames[number % 10] + soFar;
			number /= 10;

		}
		if (number == 0) {
			return soFar;
		}
		return numNames[number]
				+ "\u0e23\u0e49\u0e2d\u0e22\u0e25\u0e49\u0e32\u0e19" + soFar;
	} // convertLessThanOneThousand

	/**
	 * Convert
	 * 
	 * @param number
	 * @return
	 */
	private static String convert(int number) {
		/* special case */
		if (number == 0) {
			return "\u0e28\u0e39\u0e19\u0e22\u0e4c";
		}
		String prefix = "";
		// ï¿½Ò·
		// String subfix = "\u0e1a\u0e32\u0e17";

		if (number < 0) {
			number = -number;
			prefix = "\u0e25\u0e1a ";
		}
		String soFar = "";
		int place = 0;
		do {
			double d = number % 1000000;
			int n = (int) d;
			if (n != 0) {
				String s = convertLessThanOneMillion(n);
				place = place > 0 ? 1 : 0;

				soFar = s + majorNames[place] + soFar;
			}
			place++;
			number /= 1000000d;
		} while (number > 0);

		return (prefix + soFar).trim();
		// return (prefix + soFar + subfix).trim ();
	} // convert

	/***************************************************************************
	 * Get Amount in Words
	 * 
	 * @param amount
	 *            numeric amount (352.80)
	 * @return amount in words (three*five*two 80/100)
	 */
	public static String getAmtInWords(String amount) throws Exception {
		if (amount == null)
			return amount;

		StringBuffer sb = new StringBuffer();
		int pos = amount.lastIndexOf('.');
		int pos2 = amount.lastIndexOf(',');
		if (pos2 > pos)
			pos = pos2;
		String oldamt = amount;
		amount = amount.replaceAll(",", "");
		int newpos = amount.lastIndexOf('.');
		if (newpos != -1) {
			int pesos = Integer.parseInt(amount.substring(0, newpos));
			sb.append(convert(pesos)).append("\u0e1a\u0e32\u0e17");
			for (int i = 0; i < oldamt.length(); i++) {
				if (pos == i) { // we are done
					String cents = oldamt.substring(i + 1);
					int stang = Integer.parseInt(cents);
					if (stang != 0) {
						sb.append(convert(stang)).append("\u0e2a\u0e15\u0e32\u0e07\u0e04\u0e4c");
					} else {
						sb.append("\u0e16\u0e49\u0e27\u0e19");
					}
					// sb.append (' ').append (cents).append ("/100");
					break;
				}
			}
		} else {
            int pesos = Integer.parseInt(amount);
            sb.append(convert(pesos)).append("\u0e1a\u0e32\u0e17").append("\u0e16\u0e49\u0e27\u0e19");
        }
        return sb.toString ();
	}

	/***************************************************************************
	 * Get Amount in Words
	 * 
	 * @param amount
	 *            numeric amount (352.80)
	 * @return amount in words (three*five*two 80/100)
	 */
	public static String getAmtInWords(String amount, String iso)
			throws Exception {
		if (amount == null)
			return amount;
		//
		StringBuffer sb = new StringBuffer();
		int pos = amount.lastIndexOf('.');
		int pos2 = amount.lastIndexOf(',');
		if (pos2 > pos)
			pos = pos2;
		String oldamt = amount;
		amount = amount.replaceAll(",", "");
		int newpos = amount.lastIndexOf('.');
		if (newpos != -1) {
			int pesos = Integer.parseInt(amount.substring(0, newpos));
			System.out.println(pesos);
			if (iso.equals("THB")) {
				sb.append(convert(pesos)).append("\u0e1a\u0e32\u0e17");
				for (int i = 0; i < oldamt.length(); i++) {
					if (pos == i) { // we are done
						String cents = oldamt.substring(i + 1);
						int stang = Integer.parseInt(cents);
						if (stang != 0) {
							sb.append(convert(stang)).append("\u0e2a\u0e15\u0e32\u0e07\u0e04\u0e4c");
						} else {
							sb.append("\u0e16\u0e49\u0e27\u0e19");
						}
						// sb.append (' ').append (cents).append ("/100");
						break;
					}
				}
			} else {
                sb.append(convert(pesos)).append("\u0e40\u0e2b\u0e23\u0e35\u0e22\u0e0d");
                for (int i = 0; i < oldamt.length(); i++) {
                    if (pos == i) { //        we are done
                        String cents = oldamt.substring(i + 1);
                        int stang = Integer.parseInt(cents);
                        if (stang != 0) {
                            sb.append(convert(stang)).append("\u0e40\u0e0b\u0e47\u0e19\u0e15\u0e4c").append( " [" +iso +"]");
                        }
                        break;
                    }
                }
            }
		} else {
            int pesos = Integer.parseInt(amount);
            if (iso.equals("THB")) {
                sb.append(convert(pesos)).append("\u0e1a\u0e32\u0e17").
                        append("\u0e16\u0e49\u0e27\u0e19");
            } else {
                sb.append(convert(pesos)).append("\u0e40\u0e2b\u0e23\u0e35\u0e22\u0e0d").append( " [" +iso +"]");
            }
        }
        return sb.toString ();
	}

	public static String getDateInFormat(java.util.Date date, String pattern){
		if(date==null)
			return "" ;
		
		String fmt = (pattern==null)?"dd/MMM/yy":pattern;//Default Pattern to dd/MMM/yy
		SimpleDateFormat sdf = new SimpleDateFormat(fmt ,th_Locale);
		return sdf.format(date);
	}
	
	public static String getDateInFormat(java.sql.Timestamp time, String pattern){
		if(time==null)
			return "" ;
		
		java.util.Date date = new java.util.Date(time.getTime());
		
		String fmt = (pattern==null)?"dd/MMM/yy":pattern;//Default Pattern to dd/MMM/yy
		SimpleDateFormat sdf = new SimpleDateFormat(fmt ,th_Locale);
		return sdf.format(date);
	}
	
	public static String getNumberInFormat(Integer x, String pattern){
		if(!(x > 0))
			return "" ;
		
		String fmt = (pattern==null)?"###,###,###,###.00":pattern;//Default Pattern to dd/MMM/yy
		DecimalFormat nbf = new DecimalFormat(fmt);
		return nbf.format(x);
	}
	
	public static String getDecimal(BigDecimal i_bd, int scale){
		if(i_bd==null)
			return "" ;
		
		String bdtext = i_bd.setScale(scale,2).toString();
		int end = bdtext.length();
		int start = end - scale ;
		return bdtext.substring(start,end);
	}
	
	public static String getInteger(BigDecimal i_bd, int scale){
		if(i_bd==null)
			return "" ;
		
		DecimalFormat dcf = new DecimalFormat("###,###,###,###.00");
		String bdtext = dcf.format(i_bd);
		
		int end = bdtext.length();
		int start = end - scale ;
		return bdtext.substring(0,start-1);
	}
	
	public static String getAddress(String address1,String address2,String address3,String address4,String city ,String postal )
	{
		StringBuffer strbuf = new StringBuffer();
		if(address1 != null && address1.trim().length() >0)
			strbuf.append(address1+" ");
			
		if(address2 != null && address2.trim().length() >0)
			strbuf.append(address2+" ");
		
		if(address3 != null && address3.trim().length() >0)
			strbuf.append(address3+" ");
		
		if(address4 != null && address4.trim().length() >0)
			strbuf.append(address4+" ");
		
		if(city != null && city.trim().length() >0)
			strbuf.append(city+" ");
		
		if(postal != null && postal.trim().length() >0)
			strbuf.append(postal+" ");
		
		return strbuf.toString().trim();
	}
	
	
	private static Locale th_Locale = new Locale("th","TH");
}
