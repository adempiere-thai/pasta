-- May 4, 2014 1:29:58 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Column SET ColumnSQL='(SELECT od.C_PaymentTerm_ID FROM MM_Package p INNER JOIN C_Order od ON od.C_Order_ID = p.C_Order_ID WHERE SD_DeliveryLine.MM_Package_Id = p.MM_Package_ID)',Updated=TO_TIMESTAMP('2014-05-04 13:29:58','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=80379
;

-- May 4, 2014 1:31:52 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Column SET ColumnSQL='(SELECT adddays(d.datedelivered,pt.netdays) as duedate FROM SD_Delivery d INNER JOIN MM_Package p ON p.MM_Package_Id = SD_DeliveryLine.MM_Package_ID INNER JOIN C_Order od ON od.C_Order_ID = p.C_Order_ID INNER JOIN C_PaymentTerm pt ON od.C_PaymentTerm_Id = pt.C_PaymentTerm_ID WHERE d.SD_Delivery_ID = SD_DeliveryLine.SD_Delivery_ID)',Updated=TO_TIMESTAMP('2014-05-04 13:31:52','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=80380
;

