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
 * 2007, Modified by Pasta
 */

package org.pasta.apps.form;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;

import org.adempiere.webui.component.Button;
import org.adempiere.webui.component.Combobox;
import org.adempiere.webui.component.Label;
import org.adempiere.webui.component.ListModelTable;
import org.adempiere.webui.component.Panel;
import org.adempiere.webui.component.Textbox;
import org.adempiere.webui.component.WListbox;
import org.adempiere.webui.panel.ADForm;
import org.adempiere.webui.panel.CustomForm;
import org.adempiere.webui.panel.IFormController;
import org.adempiere.webui.session.SessionManager;
import org.adempiere.webui.window.FDialog;
import org.apache.commons.lang.StringUtils;
import org.compiere.model.MShipper;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.compiere.util.Msg;
import org.zkoss.zhtml.Div;
import org.zkoss.zhtml.Span;
import org.zkoss.zhtml.Table;
import org.zkoss.zhtml.Td;
import org.zkoss.zhtml.Tr;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zkex.zul.Borderlayout;
import org.zkoss.zkex.zul.Center;
import org.zkoss.zkex.zul.North;
import org.zkoss.zkex.zul.South;
import org.zkoss.zul.Separator;
import org.zkoss.zul.Space;

/**
 * This class represents the Custom Form for generating Delivery
 *
 * @author Pasuwat Wang
 *
 */
public class WDelivery extends Delivery implements IFormController, EventListener
{
    /**
	 *
	 */
	private static final long serialVersionUID = 4210542409436277344L;

	private CustomForm form = new CustomForm();

    /** Logger.          */
    private static CLogger log = CLogger.getCLogger(WDelivery.class);
    
    private Button m_btnAdd = new Button();
    private Button m_btnRemove = new Button();
    private Button m_btnSave = new Button();
    
    private Combobox m_shipperList = new Combobox();
    private Textbox packageNoTxtInput = new  Textbox();
    
    private Label no_of_rows = new Label();

    // new panel
    private Panel m_inputPanel = new Panel();// Input Section Panel
    private Panel m_ListPanel = new Panel();// Package List Section Panel
    private Panel m_confirmPanel = new Panel();// Confirm Section Panel

    /** Table to hold data of accounts. */
    private WListbox m_tblData = new WListbox(); // Package List Table Grid


    /**
     * Default constructor.
     */
    public WDelivery()
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
    
    Properties ctx = Env.getCtx();

    private void dynamicFieldsSetup() {
    	//  Shipper
    	createShipper(ctx,m_shipperList);
	}


	public void createShipper(Properties ctx, Combobox m_shipperList) {
		// TODO Auto-generated method stub
		List<MShipper> shippers = getShippers(ctx);
		
		for(MShipper shipper : shippers){
			m_shipperList.appendItem(shipper.getName(), shipper.getM_Shipper_ID());
		}
	}


	/**
     * Initialises the static components of the form.
     */
    private void staticInitialise()
    {
        createInputPackNoPanel();
        createPackageListPanel();
        createConfirmPanel();

        return;
    }

    private void zkInit()
	{
		Borderlayout contentPane = new Borderlayout();
		form.appendChild(contentPane);

		North north = new North();
		contentPane.appendChild(north);
		north.appendChild(m_inputPanel);

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

    private void createPackageListPanel()
    {
    	Borderlayout borderlayout = new Borderlayout();
    	borderlayout.setStyle("position: absolute");
    	borderlayout.setWidth("100%");
    	borderlayout.setHeight("100%");
    	m_ListPanel.appendChild(borderlayout);

		North north = new North();
		north.setBorder("none");
		borderlayout.appendChild(north);
        Label label = new Label(Msg.getMsg(Env.getCtx(), "PackageList"));
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

        return;
    }

    private void createInputPackNoPanel()
    {
        
        Label label = new Label(Msg.getMsg(Env.getCtx(), "CreateDelivery"));
        label.setStyle("font-size:small;font-weight: bold;");
        
        Table table = new Table();
        m_inputPanel.appendChild(table);
        
        Tr tr = new Tr();
        Td td = new Td();
        
        // Add Label First Line
        td.appendChild(label);
        td.setAttribute("colspan", "2");
        tr.appendChild(td);
        table.appendChild(tr);
        
        tr = new Tr();
        td = new Td();
        td.setStyle("padding-left:180px;");
        Div div = new Div();
        div.setStyle("display:block;");
        label = new Label(Msg.getMsg(Env.getCtx(), "EnterPackNo"));
        label.setStyle("font-size:small;font-weight: bold;");
        Span span = new Span();
        span.appendChild(label);
        div.appendChild(span);
        td.appendChild(div);
        
        div = new Div();
        div.setStyle("display:block;");
        
        packageNoTxtInput.addEventListener(Events.ON_CHANGE, this);
        packageNoTxtInput.setStyle("height:50px;width:320px;font-size:30pt;padding-left:10;padding-right:10;");
        
        div.appendChild(packageNoTxtInput);
        td.appendChild(div);
        
        tr.appendChild(td);
        
        td = new Td();
        td.setStyle("padding-left:30px;vertical-align:bottom;");
        td.setAttribute("valign", "buttom");
        
        
        div = new Div();
        div.setStyle("display:block;");
        
        m_btnAdd.setLabel(Msg.getMsg(Env.getCtx(), "ADD"));
        m_btnAdd.addEventListener(Events.ON_CLICK, this);
        m_btnAdd.setStyle("height:50px;width:150px;font-size:22pt;");
        div.appendChild(m_btnAdd);
        
        div.appendChild(new Space());
        m_btnRemove.setLabel(Msg.getMsg(Env.getCtx(), "REMOVE"));
        m_btnRemove.addEventListener(Events.ON_CLICK, this);
        m_btnRemove.setStyle("height:50px;width:150px;font-size:22pt;");
        div.appendChild(m_btnRemove);
        
        td.appendChild(div);
        tr.appendChild(td);
        table.appendChild(tr);

        return;
    }

    /**
     *  Create Confirmation Panel with OK Button.
     */
    private void createConfirmPanel()
    {
    	Table table = new Table();
        m_confirmPanel.appendChild(table);
        table.setStyle("width:100%;");
        
        Tr tr = new Tr();
        Td td = new Td();
        td.setStyle("padding-left:150px;width:75%");
        
        Table innerTab = new Table();
        Tr iTr = new Tr();
        Td iTd = new Td();
        
        Label label = new Label(Msg.getMsg(Env.getCtx(), "Total Line :"));
        label.setStyle("font-size:small;font-weight: bold;font-size:22px;");
        iTd.appendChild(label);
        iTr.appendChild(iTd);
        
        iTd = new Td();
        no_of_rows.setText(""+m_tblData.getRowCount());
        no_of_rows.setStyle("font-size:small;font-size:22px;color:#FFA500;");
        iTd.appendChild(no_of_rows);
        iTr.appendChild(iTd);
        innerTab.appendChild(iTr);
        
        iTr = new Tr();
        iTd = new Td();
        
        label = new Label();
        label.setText(Msg.translate(Env.getCtx(), "M_Shipper_ID"));
        label.setStyle("font-size:small;font-weight: bold;font-size:22px;");
        iTd.appendChild(label);
        iTr.appendChild(iTd);
        
        iTd = new Td();
        iTd.appendChild(m_shipperList);
        iTr.appendChild(iTd);
        innerTab.appendChild(iTr);
        
        td.appendChild(innerTab);
        
        tr.appendChild(td);
        
        td = new Td();
        
        String name = "Save";

        m_btnSave.setName(name);
        m_btnSave.setImage("images/"+name+"24.png");
        m_btnSave.setStyle("height:80px;width:80px;");
        m_btnSave.addEventListener(Events.ON_CLICK, this);
        //button.setLabel("Save");
        
        td.appendChild(m_btnSave);
        tr.appendChild(td);
        table.appendChild(tr);
        
        return;
    }   //  ConfirmPanel

    public void close()
    {
        SessionManager.getAppDesktop().closeActiveWindow();
    }

	public ADForm getForm() {
		return form;
	}
	
	private void reloadData(){
		ListModelTable model = new ListModelTable(getData());
        m_tblData.setData(model, getColumnNames());
		setColumnClass(m_tblData);
		
		no_of_rows.setText(""+m_tblData.getRowCount());
		packageNoTxtInput.setText("");
	}
	
	/**
     *  Event Listener.
     *
     *  @param event event that has been fired.
     */
    public void onEvent(Event event)
    {
        log.info(event.getName());
        //
        
        if(event.getTarget().equals(m_btnAdd)){
        	System.out.println("Button Add");
        	String packageNo = packageNoTxtInput.getValue();
        	
        	if(StringUtils.isEmpty(packageNo)){
        		FDialog.error(form.getWindowNo(), form, "PackageNoIsRequired", "Package No");
        	}
        	
        	if(!addDeliveryPackage(ctx, packageNo, this.toString())){
        		FDialog.error(form.getWindowNo(), form, "CannotFoundPackageNoOrPackageWasShipped",packageNo );
        	}
        	
        	reloadData();
        }
        else if (event.getTarget().equals(m_btnRemove)){
        	System.out.println("Button Remove");
        	m_tblData.getSelectedItem();
        	
        	int n = m_tblData.getRowCount();
        	List<String> removeList = new ArrayList<String>();
        	
        	for(int i=0 ; i<n ;i++  ){
        		boolean isChecked = (Boolean)m_tblData.getValueAt(i, 0);
        		if(isChecked)
        			removeList.add(""+m_tblData.getValueAt(i, 1));
        	}
        	
        	if(removeList.size() > 0){
        		removeDeliveryPackage(removeList);
        		reloadData();
        	}
        }
        else if(event.getTarget().equals(m_btnSave)){
        	System.out.println("Button Save");
        	
        	if(FDialog.ask(form.getWindowNo(), form, "Do you want to create delivery transaction?")){
	        	if(m_tblData.getRowCount()==0){
	        		FDialog.error(form.getWindowNo(), form, "NoDeliveryPackageInList", "Package No");
	        		return;
	        	}
	        	
	        	if(m_shipperList.getSelectedIndex() <= 0){
	        		FDialog.error(form.getWindowNo(), form, "ShipperIsRequired", "Shipper");
	    			return;
	        	}
	        	
	        	int shipperId = (Integer)m_shipperList.getSelectedItem().getValue();
	        		
	        	if(!createDeliveryTrx(shipperId)){
	        		FDialog.error(form.getWindowNo(), form, "CannotCreateDelivertTrx", "Package No");
	        		return;
	        	}
	        	FDialog.info(form.getWindowNo(), form, "Delivery "+getDeliveryNo()+" was created (Total Lines:"+getDeliveryTotalLines()+")");
        	}
        	else
        		return;
        	
        	//close();
        	clearData();
        	reloadData();
        }
        else if(event.getTarget().equals(packageNoTxtInput)){
        	System.out.println("Package No input");
        }

        return;
    }
}
