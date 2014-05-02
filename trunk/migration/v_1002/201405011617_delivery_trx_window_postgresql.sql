-- May 1, 2014 1:48:51 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Reference (AD_Client_ID,AD_Org_ID,AD_Reference_ID,Created,CreatedBy,EntityType,IsActive,IsOrderByValue,Name,Updated,UpdatedBy,ValidationType) VALUES (0,0,80005,TO_TIMESTAMP('2014-05-01 13:48:50','YYYY-MM-DD HH24:MI:SS'),100,'pasta','Y','N','Delivery Line Status',TO_TIMESTAMP('2014-05-01 13:48:50','YYYY-MM-DD HH24:MI:SS'),100,'L')
;

-- May 1, 2014 1:48:51 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Reference_Trl (AD_Language,AD_Reference_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Reference_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Reference t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Reference_ID=80005 AND NOT EXISTS (SELECT * FROM AD_Reference_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Reference_ID=t.AD_Reference_ID)
;

-- May 1, 2014 1:49:06 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Ref_List (AD_Client_ID,AD_Org_ID,AD_Ref_List_ID,AD_Reference_ID,Created,CreatedBy,EntityType,IsActive,Name,Updated,UpdatedBy,Value) VALUES (0,0,1000000,80005,TO_TIMESTAMP('2014-05-01 13:49:05','YYYY-MM-DD HH24:MI:SS'),100,'pasta','Y','Shipped',TO_TIMESTAMP('2014-05-01 13:49:05','YYYY-MM-DD HH24:MI:SS'),100,'S')
;

-- May 1, 2014 1:49:06 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Ref_List_Trl (AD_Language,AD_Ref_List_ID, Description,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Ref_List_ID, t.Description,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Ref_List t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Ref_List_ID=1000000 AND NOT EXISTS (SELECT * FROM AD_Ref_List_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Ref_List_ID=t.AD_Ref_List_ID)
;

-- May 1, 2014 1:49:17 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Ref_List (AD_Client_ID,AD_Org_ID,AD_Ref_List_ID,AD_Reference_ID,Created,CreatedBy,EntityType,IsActive,Name,Updated,UpdatedBy,Value) VALUES (0,0,1000001,80005,TO_TIMESTAMP('2014-05-01 13:49:17','YYYY-MM-DD HH24:MI:SS'),100,'pasta','Y','Returned',TO_TIMESTAMP('2014-05-01 13:49:17','YYYY-MM-DD HH24:MI:SS'),100,'R')
;

-- May 1, 2014 1:49:17 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Ref_List_Trl (AD_Language,AD_Ref_List_ID, Description,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Ref_List_ID, t.Description,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Ref_List t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Ref_List_ID=1000001 AND NOT EXISTS (SELECT * FROM AD_Ref_List_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Ref_List_ID=t.AD_Ref_List_ID)
;

-- May 1, 2014 1:49:39 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Column (AD_Client_ID,AD_Column_ID,AD_Element_ID,AD_Org_ID,AD_Reference_ID,AD_Reference_Value_ID,AD_Table_ID,ColumnName,Created,CreatedBy,Description,EntityType,FieldLength,Help,IsActive,IsAllowLogging,IsAlwaysUpdateable,IsAutocomplete,IsEncrypted,IsIdentifier,IsKey,IsMandatory,IsParent,IsSelectionColumn,IsSyncDatabase,IsTranslated,IsUpdateable,Name,SeqNo,Updated,UpdatedBy,Version) VALUES (0,80256,3020,0,17,80005,80014,'Status',TO_TIMESTAMP('2014-05-01 13:49:39','YYYY-MM-DD HH24:MI:SS'),100,'Status of the currently running check','pasta',1,'Status of the currently running check','Y','Y','N','N','N','N','N','N','N','N','N','N','Y','Status',0,TO_TIMESTAMP('2014-05-01 13:49:39','YYYY-MM-DD HH24:MI:SS'),100,0)
;

-- May 1, 2014 1:50:52 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Sequence SET CurrentNext=80373,Updated=TO_TIMESTAMP('2014-05-01 13:50:52','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Sequence_ID=1000627
;

-- May 1, 2014 1:51:00 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Column (AD_Client_ID,AD_Column_ID,AD_Element_ID,AD_Org_ID,AD_Reference_ID,AD_Reference_Value_ID,AD_Table_ID,ColumnName,Created,CreatedBy,Description,EntityType,FieldLength,Help,IsActive,IsAllowLogging,IsAlwaysUpdateable,IsAutocomplete,IsEncrypted,IsIdentifier,IsKey,IsMandatory,IsParent,IsSelectionColumn,IsSyncDatabase,IsTranslated,IsUpdateable,Name,SeqNo,Updated,UpdatedBy,Version) VALUES (0,80257,3020,0,17,80005,80014,'Status',TO_TIMESTAMP('2014-05-01 13:51:00','YYYY-MM-DD HH24:MI:SS'),100,'Status of the currently running check','pasta',1,'Status of the currently running check','Y','Y','N','N','N','N','N','N','N','N','N','N','Y','Status',0,TO_TIMESTAMP('2014-05-01 13:51:00','YYYY-MM-DD HH24:MI:SS'),100,0)
;

-- May 1, 2014 1:51:32 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Column (AD_Client_ID,AD_Column_ID,AD_Element_ID,AD_Org_ID,AD_Reference_ID,AD_Reference_Value_ID,AD_Table_ID,ColumnName,Created,CreatedBy,Description,EntityType,FieldLength,Help,IsActive,IsAllowLogging,IsAlwaysUpdateable,IsAutocomplete,IsEncrypted,IsIdentifier,IsKey,IsMandatory,IsParent,IsSelectionColumn,IsSyncDatabase,IsTranslated,IsUpdateable,Name,SeqNo,Updated,UpdatedBy,Version) VALUES (0,80258,3020,0,17,80005,80014,'Status',TO_TIMESTAMP('2014-05-01 13:51:32','YYYY-MM-DD HH24:MI:SS'),100,'Status of the currently running check','pasta',1,'Status of the currently running check','Y','Y','N','N','N','N','N','N','N','N','N','N','Y','Status',0,TO_TIMESTAMP('2014-05-01 13:51:32','YYYY-MM-DD HH24:MI:SS'),100,0)
;

-- May 1, 2014 1:51:34 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Column (AD_Client_ID,AD_Column_ID,AD_Element_ID,AD_Org_ID,AD_Reference_ID,AD_Reference_Value_ID,AD_Table_ID,ColumnName,Created,CreatedBy,Description,EntityType,FieldLength,Help,IsActive,IsAllowLogging,IsAlwaysUpdateable,IsAutocomplete,IsEncrypted,IsIdentifier,IsKey,IsMandatory,IsParent,IsSelectionColumn,IsSyncDatabase,IsTranslated,IsUpdateable,Name,SeqNo,Updated,UpdatedBy,Version) VALUES (0,80259,3020,0,17,80005,80014,'Status',TO_TIMESTAMP('2014-05-01 13:51:34','YYYY-MM-DD HH24:MI:SS'),100,'Status of the currently running check','pasta',1,'Status of the currently running check','Y','Y','N','N','N','N','N','N','N','N','N','N','Y','Status',0,TO_TIMESTAMP('2014-05-01 13:51:34','YYYY-MM-DD HH24:MI:SS'),100,0)
;

-- May 1, 2014 1:52:59 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Sequence SET CurrentNext=80373,Updated=TO_TIMESTAMP('2014-05-01 13:52:59','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Sequence_ID=3
;

-- May 1, 2014 1:53:04 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Column (AD_Client_ID,AD_Column_ID,AD_Element_ID,AD_Org_ID,AD_Reference_ID,AD_Reference_Value_ID,AD_Table_ID,ColumnName,Created,CreatedBy,Description,EntityType,FieldLength,Help,IsActive,IsAllowLogging,IsAlwaysUpdateable,IsAutocomplete,IsEncrypted,IsIdentifier,IsKey,IsMandatory,IsParent,IsSelectionColumn,IsSyncDatabase,IsTranslated,IsUpdateable,Name,SeqNo,Updated,UpdatedBy,Version) VALUES (0,80373,3020,0,17,80005,80014,'Status',TO_TIMESTAMP('2014-05-01 13:53:04','YYYY-MM-DD HH24:MI:SS'),100,'Status of the currently running check','pasta',1,'Status of the currently running check','Y','Y','N','N','N','N','N','N','N','N','N','N','Y','Status',0,TO_TIMESTAMP('2014-05-01 13:53:04','YYYY-MM-DD HH24:MI:SS'),100,0)
;

-- May 1, 2014 1:53:04 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Column_Trl (AD_Language,AD_Column_ID, Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Column_ID, t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Column t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Column_ID=80373 AND NOT EXISTS (SELECT * FROM AD_Column_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Column_ID=t.AD_Column_ID)
;

-- May 1, 2014 1:53:34 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO t_alter_column values('sd_deliveryline','AD_Client_ID','NUMERIC(10)',null,null)
;

-- May 1, 2014 1:53:43 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
ALTER TABLE SD_DeliveryLine ADD COLUMN Status CHAR(1) DEFAULT NULL 
;

-- May 1, 2014 1:58:43 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Column (AD_Client_ID,AD_Column_ID,AD_Element_ID,AD_Org_ID,AD_Reference_ID,AD_Table_ID,ColumnName,ColumnSQL,Created,CreatedBy,Description,EntityType,FieldLength,IsActive,IsAllowLogging,IsAlwaysUpdateable,IsAutocomplete,IsEncrypted,IsIdentifier,IsKey,IsMandatory,IsParent,IsSelectionColumn,IsSyncDatabase,IsTranslated,IsUpdateable,Name,SeqNo,Updated,UpdatedBy,Version) VALUES (0,80374,264,0,15,80014,'DateDelivered','SELECT d.datedelivered  FROM SD_Delivery d WHERE d.SD_Delivery _ID = SD_DeliveryLine.SD_Delivery_ID',TO_TIMESTAMP('2014-05-01 13:58:43','YYYY-MM-DD HH24:MI:SS'),100,'Date when the product was delivered','pasta',10,'Y','Y','N','N','N','N','N','N','N','N','N','N','N','Date Delivered',0,TO_TIMESTAMP('2014-05-01 13:58:43','YYYY-MM-DD HH24:MI:SS'),100,0)
;

-- May 1, 2014 1:58:43 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Column_Trl (AD_Language,AD_Column_ID, Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Column_ID, t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Column t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Column_ID=80374 AND NOT EXISTS (SELECT * FROM AD_Column_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Column_ID=t.AD_Column_ID)
;

-- May 1, 2014 2:00:44 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Column (AD_Client_ID,AD_Column_ID,AD_Element_ID,AD_Org_ID,AD_Reference_ID,AD_Table_ID,ColumnName,ColumnSQL,Created,CreatedBy,Description,EntityType,FieldLength,Help,IsActive,IsAllowLogging,IsAlwaysUpdateable,IsAutocomplete,IsEncrypted,IsIdentifier,IsKey,IsMandatory,IsParent,IsSelectionColumn,IsSyncDatabase,IsTranslated,IsUpdateable,Name,SeqNo,Updated,UpdatedBy,Version) VALUES (0,80375,290,0,10,80014,'DocumentNo','SELECT d.DocumentNo  FROM SD_Delivery d WHERE d.SD_Delivery _ID = SD_DeliveryLine.SD_Delivery_ID',TO_TIMESTAMP('2014-05-01 14:00:44','YYYY-MM-DD HH24:MI:SS'),100,'Document sequence number of the document','pasta',10,'The document number is usually automatically generated by the system and determined by the document type of the document. If the document is not saved, the preliminary number is displayed in "<>".

If the document type of your document has no automatic document sequence defined, the field is empty if you create a new document. This is for documents which usually have an external number (like vendor invoice).  If you leave the field empty, the system will generate a document number for you. The document sequence used for this fallback number is defined in the "Maintain Sequence" window with the name "DocumentNo_<TableName>", where TableName is the actual name of the table (e.g. C_Order).','Y','Y','N','N','N','N','N','N','N','N','N','N','N','Document No',0,TO_TIMESTAMP('2014-05-01 14:00:44','YYYY-MM-DD HH24:MI:SS'),100,0)
;

-- May 1, 2014 2:00:44 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Column_Trl (AD_Language,AD_Column_ID, Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Column_ID, t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Column t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Column_ID=80375 AND NOT EXISTS (SELECT * FROM AD_Column_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Column_ID=t.AD_Column_ID)
;

-- May 1, 2014 2:04:36 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Column (AD_Client_ID,AD_Column_ID,AD_Element_ID,AD_Org_ID,AD_Reference_ID,AD_Table_ID,ColumnName,ColumnSQL,Created,CreatedBy,Description,EntityType,FieldLength,Help,IsActive,IsAllowLogging,IsAlwaysUpdateable,IsAutocomplete,IsEncrypted,IsIdentifier,IsKey,IsMandatory,IsParent,IsSelectionColumn,IsSyncDatabase,IsTranslated,IsUpdateable,Name,SeqNo,Updated,UpdatedBy,Version) VALUES (0,80376,455,0,19,80014,'M_Shipper_ID','SELECT d.M_Shipper_ID  FROM SD_Delivery d WHERE d.SD_Delivery _ID = SD_DeliveryLine.SD_Delivery_ID',TO_TIMESTAMP('2014-05-01 14:04:36','YYYY-MM-DD HH24:MI:SS'),100,'Method or manner of product delivery','pasta',10,'The Shipper indicates the method of delivering product','Y','Y','N','N','N','N','N','N','N','N','N','N','N','Shipper',0,TO_TIMESTAMP('2014-05-01 14:04:36','YYYY-MM-DD HH24:MI:SS'),100,0)
;

-- May 1, 2014 2:04:36 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Column_Trl (AD_Language,AD_Column_ID, Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Column_ID, t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Column t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Column_ID=80376 AND NOT EXISTS (SELECT * FROM AD_Column_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Column_ID=t.AD_Column_ID)
;

-- May 1, 2014 2:11:16 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Column (AD_Client_ID,AD_Column_ID,AD_Element_ID,AD_Org_ID,AD_Reference_ID,AD_Table_ID,ColumnName,ColumnSQL,Created,CreatedBy,Description,EntityType,FieldLength,Help,IsActive,IsAllowLogging,IsAlwaysUpdateable,IsAutocomplete,IsEncrypted,IsIdentifier,IsKey,IsMandatory,IsParent,IsSelectionColumn,IsSyncDatabase,IsTranslated,IsUpdateable,Name,SeqNo,Updated,UpdatedBy,Version) VALUES (0,80377,187,0,30,80014,'C_BPartner_ID','SELECT o.C_Bpartner_ID FROM MM_Package p INNER JOIN C_Order o ON o.C_Order_ID = p.C_Order_ID WHERE SD_DeliveryLine.MM_Package_Id = p.MM_Package_ID',TO_TIMESTAMP('2014-05-01 14:11:16','YYYY-MM-DD HH24:MI:SS'),100,'Identifies a Business Partner','pasta',10,'A Business Partner is anyone with whom you transact.  This can include Vendor, Customer, Employee or Salesperson','Y','Y','N','N','N','N','N','N','N','N','N','N','N','Business Partner ',0,TO_TIMESTAMP('2014-05-01 14:11:16','YYYY-MM-DD HH24:MI:SS'),100,0)
;

-- May 1, 2014 2:11:17 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Column_Trl (AD_Language,AD_Column_ID, Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Column_ID, t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Column t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Column_ID=80377 AND NOT EXISTS (SELECT * FROM AD_Column_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Column_ID=t.AD_Column_ID)
;

-- May 1, 2014 2:12:48 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Column (AD_Client_ID,AD_Column_ID,AD_Element_ID,AD_Org_ID,AD_Reference_ID,AD_Table_ID,ColumnName,ColumnSQL,Created,CreatedBy,Description,EntityType,FieldLength,Help,IsActive,IsAllowLogging,IsAlwaysUpdateable,IsAutocomplete,IsEncrypted,IsIdentifier,IsKey,IsMandatory,IsParent,IsSelectionColumn,IsSyncDatabase,IsTranslated,IsUpdateable,Name,SeqNo,Updated,UpdatedBy,Version) VALUES (0,80378,558,0,30,80014,'C_Order_ID','SELECT p.C_Order_ID FROM MM_Package p WHERE SD_DeliveryLine.MM_Package_Id = p.MM_Package_ID',TO_TIMESTAMP('2014-05-01 14:12:47','YYYY-MM-DD HH24:MI:SS'),100,'Order','pasta',10,'The Order is a control document.  The  Order is complete when the quantity ordered is the same as the quantity shipped and invoiced.  When you close an order, unshipped (backordered) quantities are cancelled.','Y','Y','N','N','N','N','N','N','N','N','N','N','N','Order',0,TO_TIMESTAMP('2014-05-01 14:12:47','YYYY-MM-DD HH24:MI:SS'),100,0)
;

-- May 1, 2014 2:12:48 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Column_Trl (AD_Language,AD_Column_ID, Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Column_ID, t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Column t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Column_ID=80378 AND NOT EXISTS (SELECT * FROM AD_Column_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Column_ID=t.AD_Column_ID)
;

-- May 1, 2014 2:15:15 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Column (AD_Client_ID,AD_Column_ID,AD_Element_ID,AD_Org_ID,AD_Reference_ID,AD_Table_ID,ColumnName,ColumnSQL,Created,CreatedBy,Description,EntityType,FieldLength,Help,IsActive,IsAllowLogging,IsAlwaysUpdateable,IsAutocomplete,IsEncrypted,IsIdentifier,IsKey,IsMandatory,IsParent,IsSelectionColumn,IsSyncDatabase,IsTranslated,IsUpdateable,Name,SeqNo,Updated,UpdatedBy,Version) VALUES (0,80379,204,0,19,80014,'C_PaymentTerm_ID','SELECT iv.C_PaymentTerm_ID FROM MM_Package p INNER JOIN C_Invoice iv ON iv.C_Order_ID = p.C_Order_ID AND iv.DocStatus = ''CO'' WHERE SD_DeliveryLine.MM_Package_Id = p.MM_Package_ID',TO_TIMESTAMP('2014-05-01 14:15:15','YYYY-MM-DD HH24:MI:SS'),100,'The terms of Payment (timing, discount)','pasta',10,'Payment Terms identify the method and timing of payment.','Y','Y','N','N','N','N','N','N','N','N','N','N','N','Payment Term',0,TO_TIMESTAMP('2014-05-01 14:15:15','YYYY-MM-DD HH24:MI:SS'),100,0)
;

-- May 1, 2014 2:15:15 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Column_Trl (AD_Language,AD_Column_ID, Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Column_ID, t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Column t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Column_ID=80379 AND NOT EXISTS (SELECT * FROM AD_Column_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Column_ID=t.AD_Column_ID)
;

-- May 1, 2014 2:36:49 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Column (AD_Client_ID,AD_Column_ID,AD_Element_ID,AD_Org_ID,AD_Reference_ID,AD_Table_ID,ColumnName,ColumnSQL,Created,CreatedBy,Description,EntityType,FieldLength,Help,IsActive,IsAllowLogging,IsAlwaysUpdateable,IsAutocomplete,IsEncrypted,IsIdentifier,IsKey,IsMandatory,IsParent,IsSelectionColumn,IsSyncDatabase,IsTranslated,IsUpdateable,Name,SeqNo,Updated,UpdatedBy,Version) VALUES (0,80380,2000,0,15,80014,'DueDate','SELECT adddays(d.datedelivered,pt.netdays) as duedate FROM SD_Delivery d INNER JOIN MM_Package p ON p.MM_Package_Id = SD_DeliveryLine.MM_Package_ID INNER JOIN C_Invoice iv ON iv.C_Order_ID = p.C_Order_ID AND iv.DocStatus = ''CO'' INNER JOIN C_PaymentTerm pt ON iv.C_PaymentTerm_Id = pt.C_PaymentTerm_ID WHERE d.SD_Delivery_ID = SD_DeliveryLine.SD_Delivery_ID',TO_TIMESTAMP('2014-05-01 14:36:49','YYYY-MM-DD HH24:MI:SS'),100,'Date when the payment is due','pasta',10,'Date when the payment is due without deductions or discount','Y','Y','N','N','N','N','N','N','N','N','N','N','N','Due Date',0,TO_TIMESTAMP('2014-05-01 14:36:49','YYYY-MM-DD HH24:MI:SS'),100,0)
;

-- May 1, 2014 2:36:49 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Column_Trl (AD_Language,AD_Column_ID, Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Column_ID, t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Column t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Column_ID=80380 AND NOT EXISTS (SELECT * FROM AD_Column_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Column_ID=t.AD_Column_ID)
;

-- May 1, 2014 2:37:31 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Window (AD_Client_ID,AD_Org_ID,AD_Window_ID,Created,CreatedBy,EntityType,IsActive,IsBetaFunctionality,IsDefault,IsSOTrx,Name,Processing,Updated,UpdatedBy,WindowType,WinHeight,WinWidth) VALUES (0,0,80005,TO_TIMESTAMP('2014-05-01 14:37:31','YYYY-MM-DD HH24:MI:SS'),100,'pasta','Y','N','N','Y','GBV_โปรแกรมเช็คของขึ้นรถ','N',TO_TIMESTAMP('2014-05-01 14:37:31','YYYY-MM-DD HH24:MI:SS'),100,'T',0,0)
;

-- May 1, 2014 2:38:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Sequence SET CurrentNext=80015,Updated=TO_TIMESTAMP('2014-05-01 14:38:33','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Sequence_ID=21
;

-- May 1, 2014 2:39:29 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Sequence SET CurrentNext=80007,Updated=TO_TIMESTAMP('2014-05-01 14:39:29','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Sequence_ID=27
;

-- May 1, 2014 2:39:34 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Window (AD_Client_ID,AD_Org_ID,AD_Window_ID,Created,CreatedBy,EntityType,IsActive,IsBetaFunctionality,IsDefault,IsSOTrx,Name,Processing,Updated,UpdatedBy,WindowType,WinHeight,WinWidth) VALUES (0,0,80007,TO_TIMESTAMP('2014-05-01 14:39:34','YYYY-MM-DD HH24:MI:SS'),100,'pasta','Y','N','N','Y','GBV_โปรแกรมเช็คของขึ้นรถ','N',TO_TIMESTAMP('2014-05-01 14:39:34','YYYY-MM-DD HH24:MI:SS'),100,'T',0,0)
;

-- May 1, 2014 2:39:34 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Window_Trl (AD_Language,AD_Window_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Window_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Window t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Window_ID=80007 AND NOT EXISTS (SELECT * FROM AD_Window_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Window_ID=t.AD_Window_ID)
;

-- May 1, 2014 2:40:28 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Tab (AD_Client_ID,AD_Org_ID,AD_Tab_ID,AD_Table_ID,AD_Window_ID,Created,CreatedBy,EntityType,HasTree,ImportFields,IsActive,IsAdvancedTab,IsInfoTab,IsInsertRecord,IsReadOnly,IsSingleRow,IsSortTab,IsTranslationTab,Name,Processing,SeqNo,TabLevel,Updated,UpdatedBy) VALUES (0,0,80012,80014,80007,TO_TIMESTAMP('2014-05-01 14:40:28','YYYY-MM-DD HH24:MI:SS'),100,'pasta','N','N','Y','N','N','N','N','N','N','N','Delivery','N',10,0,TO_TIMESTAMP('2014-05-01 14:40:28','YYYY-MM-DD HH24:MI:SS'),100)
;

-- May 1, 2014 2:41:03 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Sequence SET CurrentNext=80016,Updated=TO_TIMESTAMP('2014-05-01 14:41:03','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Sequence_ID=19
;

-- May 1, 2014 2:41:09 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Tab (AD_Client_ID,AD_Org_ID,AD_Tab_ID,AD_Table_ID,AD_Window_ID,Created,CreatedBy,EntityType,HasTree,ImportFields,IsActive,IsAdvancedTab,IsInfoTab,IsInsertRecord,IsReadOnly,IsSingleRow,IsSortTab,IsTranslationTab,Name,Processing,SeqNo,TabLevel,Updated,UpdatedBy) VALUES (0,0,80016,80014,80007,TO_TIMESTAMP('2014-05-01 14:41:09','YYYY-MM-DD HH24:MI:SS'),100,'pasta','N','N','Y','N','N','N','N','N','N','N','Delivery','N',10,0,TO_TIMESTAMP('2014-05-01 14:41:09','YYYY-MM-DD HH24:MI:SS'),100)
;

-- May 1, 2014 2:41:09 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Tab_Trl (AD_Language,AD_Tab_ID, CommitWarning,Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Tab_ID, t.CommitWarning,t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Tab t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Tab_ID=80016 AND NOT EXISTS (SELECT * FROM AD_Tab_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Tab_ID=t.AD_Tab_ID)
;

-- May 1, 2014 2:41:17 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,Description,DisplayLength,EntityType,Help,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,80365,80273,0,80016,TO_TIMESTAMP('2014-05-01 14:41:17','YYYY-MM-DD HH24:MI:SS'),100,'The record is active in the system',1,'pasta','There are two methods of making records unavailable in the system: One is to delete the record, the other is to de-activate the record. A de-activated record is not available for selection, but available for reports.
There are two reasons for de-activating and not deleting records:
(1) The system requires the record for audit purposes.
(2) The record is referenced by other records. E.g., you cannot delete a Business Partner, if there are invoices for this partner record existing. You de-activate the Business Partner and prevent that this record is used for future entries.','Y','Y','Y','N','N','N','N','N','Active',TO_TIMESTAMP('2014-05-01 14:41:17','YYYY-MM-DD HH24:MI:SS'),100)
;

-- May 1, 2014 2:41:18 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,Description,DisplayLength,EntityType,Help,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,80377,80274,0,80016,TO_TIMESTAMP('2014-05-01 14:41:18','YYYY-MM-DD HH24:MI:SS'),100,'Identifies a Business Partner',10,'pasta','A Business Partner is anyone with whom you transact.  This can include Vendor, Customer, Employee or Salesperson','Y','Y','Y','N','N','N','N','N','Business Partner ',TO_TIMESTAMP('2014-05-01 14:41:18','YYYY-MM-DD HH24:MI:SS'),100)
;

-- May 1, 2014 2:41:18 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,Description,DisplayLength,EntityType,Help,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,80357,80275,0,80016,TO_TIMESTAMP('2014-05-01 14:41:18','YYYY-MM-DD HH24:MI:SS'),100,'Client/Tenant for this installation.',10,'pasta','A Client is a company or a legal entity. You cannot share data between Clients. Tenant is a synonym for Client.','Y','Y','Y','N','N','N','N','N','Client',TO_TIMESTAMP('2014-05-01 14:41:18','YYYY-MM-DD HH24:MI:SS'),100)
;

-- May 1, 2014 2:41:18 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,Description,DisplayLength,EntityType,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,80374,80276,0,80016,TO_TIMESTAMP('2014-05-01 14:41:18','YYYY-MM-DD HH24:MI:SS'),100,'Date when the product was delivered',10,'pasta','Y','Y','Y','N','N','N','N','N','Date Delivered',TO_TIMESTAMP('2014-05-01 14:41:18','YYYY-MM-DD HH24:MI:SS'),100)
;

-- May 1, 2014 2:41:18 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,DisplayLength,EntityType,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,80368,80277,0,80016,TO_TIMESTAMP('2014-05-01 14:41:18','YYYY-MM-DD HH24:MI:SS'),100,10,'pasta','Y','Y','N','N','N','N','N','N','Delivery Line',TO_TIMESTAMP('2014-05-01 14:41:18','YYYY-MM-DD HH24:MI:SS'),100)
;

-- May 1, 2014 2:41:18 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=80277 AND NOT EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Field_ID=t.AD_Field_ID)
;

-- May 1, 2014 2:41:18 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,DisplayLength,EntityType,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,80372,80278,0,80016,TO_TIMESTAMP('2014-05-01 14:41:18','YYYY-MM-DD HH24:MI:SS'),100,10,'pasta','Y','Y','Y','N','N','N','N','N','Delivery Transaction',TO_TIMESTAMP('2014-05-01 14:41:18','YYYY-MM-DD HH24:MI:SS'),100)
;

-- May 1, 2014 2:41:18 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,Description,DisplayLength,EntityType,Help,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,80363,80279,0,80016,TO_TIMESTAMP('2014-05-01 14:41:18','YYYY-MM-DD HH24:MI:SS'),100,'Optional short description of the record',255,'pasta','A description is limited to 255 characters.','Y','Y','Y','N','N','N','N','N','Description',TO_TIMESTAMP('2014-05-01 14:41:18','YYYY-MM-DD HH24:MI:SS'),100)
;

-- May 1, 2014 2:41:18 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,Description,DisplayLength,EntityType,Help,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,80375,80280,0,80016,TO_TIMESTAMP('2014-05-01 14:41:18','YYYY-MM-DD HH24:MI:SS'),100,'Document sequence number of the document',10,'pasta','The document number is usually automatically generated by the system and determined by the document type of the document. If the document is not saved, the preliminary number is displayed in "<>".

If the document type of your document has no automatic document sequence defined, the field is empty if you create a new document. This is for documents which usually have an external number (like vendor invoice).  If you leave the field empty, the system will generate a document number for you. The document sequence used for this fallback number is defined in the "Maintain Sequence" window with the name "DocumentNo_<TableName>", where TableName is the actual name of the table (e.g. C_Order).','Y','Y','Y','N','N','N','N','N','Document No',TO_TIMESTAMP('2014-05-01 14:41:18','YYYY-MM-DD HH24:MI:SS'),100)
;

-- May 1, 2014 2:41:18 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,Description,DisplayLength,EntityType,Help,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,80380,80281,0,80016,TO_TIMESTAMP('2014-05-01 14:41:18','YYYY-MM-DD HH24:MI:SS'),100,'Date when the payment is due',10,'pasta','Date when the payment is due without deductions or discount','Y','Y','Y','N','N','N','N','N','Due Date',TO_TIMESTAMP('2014-05-01 14:41:18','YYYY-MM-DD HH24:MI:SS'),100)
;

-- May 1, 2014 2:41:18 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,Description,DisplayLength,EntityType,Help,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,80378,80282,0,80016,TO_TIMESTAMP('2014-05-01 14:41:18','YYYY-MM-DD HH24:MI:SS'),100,'Order',10,'pasta','The Order is a control document.  The  Order is complete when the quantity ordered is the same as the quantity shipped and invoiced.  When you close an order, unshipped (backordered) quantities are cancelled.','Y','Y','Y','N','N','N','N','N','Order',TO_TIMESTAMP('2014-05-01 14:41:18','YYYY-MM-DD HH24:MI:SS'),100)
;

-- May 1, 2014 2:41:19 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,Description,DisplayLength,EntityType,Help,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,80358,80283,0,80016,TO_TIMESTAMP('2014-05-01 14:41:18','YYYY-MM-DD HH24:MI:SS'),100,'Organizational entity within client',10,'pasta','An organization is a unit of your client or legal entity - examples are store, department. You can share data between organizations.','Y','Y','Y','N','N','N','N','N','Organization',TO_TIMESTAMP('2014-05-01 14:41:18','YYYY-MM-DD HH24:MI:SS'),100)
;

-- May 1, 2014 2:41:19 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,DisplayLength,EntityType,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,80371,80284,0,80016,TO_TIMESTAMP('2014-05-01 14:41:19','YYYY-MM-DD HH24:MI:SS'),100,10,'pasta','Y','Y','Y','N','N','N','N','N','Package to Customer',TO_TIMESTAMP('2014-05-01 14:41:19','YYYY-MM-DD HH24:MI:SS'),100)
;

-- May 1, 2014 2:41:19 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,Description,DisplayLength,EntityType,Help,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,80379,80285,0,80016,TO_TIMESTAMP('2014-05-01 14:41:19','YYYY-MM-DD HH24:MI:SS'),100,'The terms of Payment (timing, discount)',10,'pasta','Payment Terms identify the method and timing of payment.','Y','Y','Y','N','N','N','N','N','Payment Term',TO_TIMESTAMP('2014-05-01 14:41:19','YYYY-MM-DD HH24:MI:SS'),100)
;

-- May 1, 2014 2:41:19 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,Description,DisplayLength,EntityType,Help,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,80376,80286,0,80016,TO_TIMESTAMP('2014-05-01 14:41:19','YYYY-MM-DD HH24:MI:SS'),100,'Method or manner of product delivery',10,'pasta','The Shipper indicates the method of delivering product','Y','Y','Y','N','N','N','N','N','Shipper',TO_TIMESTAMP('2014-05-01 14:41:19','YYYY-MM-DD HH24:MI:SS'),100)
;

-- May 1, 2014 2:41:19 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,Description,DisplayLength,EntityType,Help,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,80373,80287,0,80016,TO_TIMESTAMP('2014-05-01 14:41:19','YYYY-MM-DD HH24:MI:SS'),100,'Status of the currently running check',1,'pasta','Status of the currently running check','Y','Y','Y','N','N','N','N','N','Status',TO_TIMESTAMP('2014-05-01 14:41:19','YYYY-MM-DD HH24:MI:SS'),100)
;

-- May 1, 2014 2:42:05 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Sequence SET CurrentNext=80327,Updated=TO_TIMESTAMP('2014-05-01 14:42:05','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Sequence_ID=4
;

-- May 1, 2014 2:42:22 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,Description,DisplayLength,EntityType,Help,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,80365,80327,0,80016,TO_TIMESTAMP('2014-05-01 14:42:22','YYYY-MM-DD HH24:MI:SS'),100,'The record is active in the system',1,'pasta','There are two methods of making records unavailable in the system: One is to delete the record, the other is to de-activate the record. A de-activated record is not available for selection, but available for reports.
There are two reasons for de-activating and not deleting records:
(1) The system requires the record for audit purposes.
(2) The record is referenced by other records. E.g., you cannot delete a Business Partner, if there are invoices for this partner record existing. You de-activate the Business Partner and prevent that this record is used for future entries.','Y','Y','Y','N','N','N','N','N','Active',TO_TIMESTAMP('2014-05-01 14:42:22','YYYY-MM-DD HH24:MI:SS'),100)
;

-- May 1, 2014 2:42:22 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=80327 AND NOT EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Field_ID=t.AD_Field_ID)
;

-- May 1, 2014 2:42:22 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,Description,DisplayLength,EntityType,Help,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,80377,80328,0,80016,TO_TIMESTAMP('2014-05-01 14:42:22','YYYY-MM-DD HH24:MI:SS'),100,'Identifies a Business Partner',10,'pasta','A Business Partner is anyone with whom you transact.  This can include Vendor, Customer, Employee or Salesperson','Y','Y','Y','N','N','N','N','N','Business Partner ',TO_TIMESTAMP('2014-05-01 14:42:22','YYYY-MM-DD HH24:MI:SS'),100)
;

-- May 1, 2014 2:42:22 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=80328 AND NOT EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Field_ID=t.AD_Field_ID)
;

-- May 1, 2014 2:42:22 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,Description,DisplayLength,EntityType,Help,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,80357,80329,0,80016,TO_TIMESTAMP('2014-05-01 14:42:22','YYYY-MM-DD HH24:MI:SS'),100,'Client/Tenant for this installation.',10,'pasta','A Client is a company or a legal entity. You cannot share data between Clients. Tenant is a synonym for Client.','Y','Y','Y','N','N','N','N','N','Client',TO_TIMESTAMP('2014-05-01 14:42:22','YYYY-MM-DD HH24:MI:SS'),100)
;

-- May 1, 2014 2:42:22 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=80329 AND NOT EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Field_ID=t.AD_Field_ID)
;

-- May 1, 2014 2:42:22 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,Description,DisplayLength,EntityType,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,80374,80330,0,80016,TO_TIMESTAMP('2014-05-01 14:42:22','YYYY-MM-DD HH24:MI:SS'),100,'Date when the product was delivered',10,'pasta','Y','Y','Y','N','N','N','N','N','Date Delivered',TO_TIMESTAMP('2014-05-01 14:42:22','YYYY-MM-DD HH24:MI:SS'),100)
;

-- May 1, 2014 2:42:22 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=80330 AND NOT EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Field_ID=t.AD_Field_ID)
;

-- May 1, 2014 2:42:22 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,DisplayLength,EntityType,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,80372,80331,0,80016,TO_TIMESTAMP('2014-05-01 14:42:22','YYYY-MM-DD HH24:MI:SS'),100,10,'pasta','Y','Y','Y','N','N','N','N','N','Delivery Transaction',TO_TIMESTAMP('2014-05-01 14:42:22','YYYY-MM-DD HH24:MI:SS'),100)
;

-- May 1, 2014 2:42:22 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=80331 AND NOT EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Field_ID=t.AD_Field_ID)
;

-- May 1, 2014 2:42:22 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,Description,DisplayLength,EntityType,Help,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,80363,80332,0,80016,TO_TIMESTAMP('2014-05-01 14:42:22','YYYY-MM-DD HH24:MI:SS'),100,'Optional short description of the record',255,'pasta','A description is limited to 255 characters.','Y','Y','Y','N','N','N','N','N','Description',TO_TIMESTAMP('2014-05-01 14:42:22','YYYY-MM-DD HH24:MI:SS'),100)
;

-- May 1, 2014 2:42:22 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=80332 AND NOT EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Field_ID=t.AD_Field_ID)
;

-- May 1, 2014 2:42:22 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,Description,DisplayLength,EntityType,Help,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,80375,80333,0,80016,TO_TIMESTAMP('2014-05-01 14:42:22','YYYY-MM-DD HH24:MI:SS'),100,'Document sequence number of the document',10,'pasta','The document number is usually automatically generated by the system and determined by the document type of the document. If the document is not saved, the preliminary number is displayed in "<>".

If the document type of your document has no automatic document sequence defined, the field is empty if you create a new document. This is for documents which usually have an external number (like vendor invoice).  If you leave the field empty, the system will generate a document number for you. The document sequence used for this fallback number is defined in the "Maintain Sequence" window with the name "DocumentNo_<TableName>", where TableName is the actual name of the table (e.g. C_Order).','Y','Y','Y','N','N','N','N','N','Document No',TO_TIMESTAMP('2014-05-01 14:42:22','YYYY-MM-DD HH24:MI:SS'),100)
;

-- May 1, 2014 2:42:22 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=80333 AND NOT EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Field_ID=t.AD_Field_ID)
;

-- May 1, 2014 2:42:22 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,Description,DisplayLength,EntityType,Help,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,80380,80334,0,80016,TO_TIMESTAMP('2014-05-01 14:42:22','YYYY-MM-DD HH24:MI:SS'),100,'Date when the payment is due',10,'pasta','Date when the payment is due without deductions or discount','Y','Y','Y','N','N','N','N','N','Due Date',TO_TIMESTAMP('2014-05-01 14:42:22','YYYY-MM-DD HH24:MI:SS'),100)
;

-- May 1, 2014 2:42:22 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=80334 AND NOT EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Field_ID=t.AD_Field_ID)
;

-- May 1, 2014 2:42:22 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,Description,DisplayLength,EntityType,Help,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,80378,80335,0,80016,TO_TIMESTAMP('2014-05-01 14:42:22','YYYY-MM-DD HH24:MI:SS'),100,'Order',10,'pasta','The Order is a control document.  The  Order is complete when the quantity ordered is the same as the quantity shipped and invoiced.  When you close an order, unshipped (backordered) quantities are cancelled.','Y','Y','Y','N','N','N','N','N','Order',TO_TIMESTAMP('2014-05-01 14:42:22','YYYY-MM-DD HH24:MI:SS'),100)
;

-- May 1, 2014 2:42:22 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=80335 AND NOT EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Field_ID=t.AD_Field_ID)
;

-- May 1, 2014 2:42:22 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,Description,DisplayLength,EntityType,Help,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,80358,80336,0,80016,TO_TIMESTAMP('2014-05-01 14:42:22','YYYY-MM-DD HH24:MI:SS'),100,'Organizational entity within client',10,'pasta','An organization is a unit of your client or legal entity - examples are store, department. You can share data between organizations.','Y','Y','Y','N','N','N','N','N','Organization',TO_TIMESTAMP('2014-05-01 14:42:22','YYYY-MM-DD HH24:MI:SS'),100)
;

-- May 1, 2014 2:42:22 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=80336 AND NOT EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Field_ID=t.AD_Field_ID)
;

-- May 1, 2014 2:42:22 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,DisplayLength,EntityType,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,80371,80337,0,80016,TO_TIMESTAMP('2014-05-01 14:42:22','YYYY-MM-DD HH24:MI:SS'),100,10,'pasta','Y','Y','Y','N','N','N','N','N','Package to Customer',TO_TIMESTAMP('2014-05-01 14:42:22','YYYY-MM-DD HH24:MI:SS'),100)
;

-- May 1, 2014 2:42:22 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=80337 AND NOT EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Field_ID=t.AD_Field_ID)
;

-- May 1, 2014 2:42:22 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,Description,DisplayLength,EntityType,Help,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,80379,80338,0,80016,TO_TIMESTAMP('2014-05-01 14:42:22','YYYY-MM-DD HH24:MI:SS'),100,'The terms of Payment (timing, discount)',10,'pasta','Payment Terms identify the method and timing of payment.','Y','Y','Y','N','N','N','N','N','Payment Term',TO_TIMESTAMP('2014-05-01 14:42:22','YYYY-MM-DD HH24:MI:SS'),100)
;

-- May 1, 2014 2:42:22 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=80338 AND NOT EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Field_ID=t.AD_Field_ID)
;

-- May 1, 2014 2:42:22 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,Description,DisplayLength,EntityType,Help,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,80376,80339,0,80016,TO_TIMESTAMP('2014-05-01 14:42:22','YYYY-MM-DD HH24:MI:SS'),100,'Method or manner of product delivery',10,'pasta','The Shipper indicates the method of delivering product','Y','Y','Y','N','N','N','N','N','Shipper',TO_TIMESTAMP('2014-05-01 14:42:22','YYYY-MM-DD HH24:MI:SS'),100)
;

-- May 1, 2014 2:42:22 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=80339 AND NOT EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Field_ID=t.AD_Field_ID)
;

-- May 1, 2014 2:42:22 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,Description,DisplayLength,EntityType,Help,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,80373,80340,0,80016,TO_TIMESTAMP('2014-05-01 14:42:22','YYYY-MM-DD HH24:MI:SS'),100,'Status of the currently running check',1,'pasta','Status of the currently running check','Y','Y','Y','N','N','N','N','N','Status',TO_TIMESTAMP('2014-05-01 14:42:22','YYYY-MM-DD HH24:MI:SS'),100)
;

-- May 1, 2014 2:42:22 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=80340 AND NOT EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Field_ID=t.AD_Field_ID)
;

-- May 1, 2014 2:43:31 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET SeqNo=0,IsDisplayed='N' WHERE AD_Field_ID=80327
;

-- May 1, 2014 2:43:31 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET SeqNo=0,IsDisplayed='N' WHERE AD_Field_ID=80331
;

-- May 1, 2014 2:43:31 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET SeqNo=0,IsDisplayed='N' WHERE AD_Field_ID=80332
;

-- May 1, 2014 2:43:31 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET SeqNo=10,IsDisplayed='Y' WHERE AD_Field_ID=80329
;

-- May 1, 2014 2:43:31 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET SeqNo=20,IsDisplayed='Y' WHERE AD_Field_ID=80336
;

-- May 1, 2014 2:43:31 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET SeqNo=30,IsDisplayed='Y' WHERE AD_Field_ID=80333
;

-- May 1, 2014 2:43:31 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET SeqNo=40,IsDisplayed='Y' WHERE AD_Field_ID=80330
;

-- May 1, 2014 2:43:31 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET SeqNo=50,IsDisplayed='Y' WHERE AD_Field_ID=80337
;

-- May 1, 2014 2:43:31 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET SeqNo=60,IsDisplayed='Y' WHERE AD_Field_ID=80328
;

-- May 1, 2014 2:43:31 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET SeqNo=70,IsDisplayed='Y' WHERE AD_Field_ID=80335
;

-- May 1, 2014 2:43:31 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET SeqNo=80,IsDisplayed='Y' WHERE AD_Field_ID=80338
;

-- May 1, 2014 2:43:31 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET SeqNo=90,IsDisplayed='Y' WHERE AD_Field_ID=80334
;

-- May 1, 2014 2:43:31 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET SeqNo=100,IsDisplayed='Y' WHERE AD_Field_ID=80340
;

-- May 1, 2014 2:43:31 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET SeqNo=110,IsDisplayed='Y' WHERE AD_Field_ID=80339
;

-- May 1, 2014 2:44:04 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET IsCentrallyMaintained='N', Name='Delivered Date',Updated=TO_TIMESTAMP('2014-05-01 14:44:04','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=80330
;

-- May 1, 2014 2:44:04 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field_Trl SET IsTranslated='N' WHERE AD_Field_ID=80330
;

-- May 1, 2014 2:44:16 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET Name='Package No',Updated=TO_TIMESTAMP('2014-05-01 14:44:16','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=80337
;

-- May 1, 2014 2:44:16 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field_Trl SET IsTranslated='N' WHERE AD_Field_ID=80337
;

-- May 1, 2014 2:44:19 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET IsCentrallyMaintained='N',Updated=TO_TIMESTAMP('2014-05-01 14:44:19','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=80337
;

-- May 1, 2014 2:44:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET IsCentrallyMaintained='N', Name='Customer Name',Updated=TO_TIMESTAMP('2014-05-01 14:44:33','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=80328
;

-- May 1, 2014 2:44:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field_Trl SET IsTranslated='N' WHERE AD_Field_ID=80328
;

-- May 1, 2014 2:44:51 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET IsCentrallyMaintained='N', Name='Delivery Status',Updated=TO_TIMESTAMP('2014-05-01 14:44:51','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=80340
;

-- May 1, 2014 2:44:51 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field_Trl SET IsTranslated='N' WHERE AD_Field_ID=80340
;

-- May 1, 2014 2:45:34 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Menu ("action",AD_Client_ID,AD_Menu_ID,AD_Org_ID,AD_Window_ID,Created,CreatedBy,EntityType,IsActive,IsCentrallyMaintained,IsReadOnly,IsSOTrx,IsSummary,Name,Updated,UpdatedBy) VALUES ('W',0,80044,0,80007,TO_TIMESTAMP('2014-05-01 14:45:34','YYYY-MM-DD HH24:MI:SS'),100,'pasta','Y','Y','N','Y','N','GBV_โปรแกรมเช็คของขึ้นรถ',TO_TIMESTAMP('2014-05-01 14:45:34','YYYY-MM-DD HH24:MI:SS'),100)
;

-- May 1, 2014 2:45:34 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_TreeNodeMM (AD_Client_ID,AD_Org_ID, IsActive,Created,CreatedBy,Updated,UpdatedBy, AD_Tree_ID, Node_ID, Parent_ID, SeqNo) SELECT t.AD_Client_ID, 0, 'Y', CURRENT_TIMESTAMP, 100, CURRENT_TIMESTAMP, 100,t.AD_Tree_ID, 80044, 0, 999 FROM AD_Tree t WHERE t.AD_Client_ID=0 AND t.IsActive='Y' AND t.IsAllNodes='Y' AND t.TreeType='MM' AND NOT EXISTS (SELECT * FROM AD_TreeNodeMM e WHERE e.AD_Tree_ID=t.AD_Tree_ID AND Node_ID=80044)
;

-- May 1, 2014 2:46:23 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Sequence SET CurrentNext=80053,Updated=TO_TIMESTAMP('2014-05-01 14:46:23','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Sequence_ID=7
;

-- May 1, 2014 2:46:26 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Menu ("action",AD_Client_ID,AD_Menu_ID,AD_Org_ID,AD_Window_ID,Created,CreatedBy,EntityType,IsActive,IsCentrallyMaintained,IsReadOnly,IsSOTrx,IsSummary,Name,Updated,UpdatedBy) VALUES ('W',0,80053,0,80007,TO_TIMESTAMP('2014-05-01 14:46:26','YYYY-MM-DD HH24:MI:SS'),100,'pasta','Y','Y','N','Y','N','GBV_โปรแกรมเช็คของขึ้นรถ',TO_TIMESTAMP('2014-05-01 14:46:26','YYYY-MM-DD HH24:MI:SS'),100)
;

-- May 1, 2014 2:46:26 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Menu_Trl (AD_Language,AD_Menu_ID, Description,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Menu_ID, t.Description,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Menu t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Menu_ID=80053 AND NOT EXISTS (SELECT * FROM AD_Menu_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Menu_ID=t.AD_Menu_ID)
;

-- May 1, 2014 2:46:27 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_TreeNodeMM (AD_Client_ID,AD_Org_ID, IsActive,Created,CreatedBy,Updated,UpdatedBy, AD_Tree_ID, Node_ID, Parent_ID, SeqNo) SELECT t.AD_Client_ID, 0, 'Y', CURRENT_TIMESTAMP, 100, CURRENT_TIMESTAMP, 100,t.AD_Tree_ID, 80053, 0, 999 FROM AD_Tree t WHERE t.AD_Client_ID=0 AND t.IsActive='Y' AND t.IsAllNodes='Y' AND t.TreeType='MM' AND NOT EXISTS (SELECT * FROM AD_TreeNodeMM e WHERE e.AD_Tree_ID=t.AD_Tree_ID AND Node_ID=80053)
;

-- May 1, 2014 2:46:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=80048, SeqNo=0, Updated=CURRENT_TIMESTAMP WHERE AD_Tree_ID=10 AND Node_ID=80049
;

-- May 1, 2014 2:46:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=80048, SeqNo=1, Updated=CURRENT_TIMESTAMP WHERE AD_Tree_ID=10 AND Node_ID=80052
;

-- May 1, 2014 2:46:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=80048, SeqNo=2, Updated=CURRENT_TIMESTAMP WHERE AD_Tree_ID=10 AND Node_ID=80050
;

-- May 1, 2014 2:46:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=80048, SeqNo=3, Updated=CURRENT_TIMESTAMP WHERE AD_Tree_ID=10 AND Node_ID=80051
;

-- May 1, 2014 2:46:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=80048, SeqNo=4, Updated=CURRENT_TIMESTAMP WHERE AD_Tree_ID=10 AND Node_ID=80037
;

-- May 1, 2014 2:46:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=80048, SeqNo=5, Updated=CURRENT_TIMESTAMP WHERE AD_Tree_ID=10 AND Node_ID=80038
;

-- May 1, 2014 2:46:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=80048, SeqNo=6, Updated=CURRENT_TIMESTAMP WHERE AD_Tree_ID=10 AND Node_ID=80042
;

-- May 1, 2014 2:46:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=80048, SeqNo=7, Updated=CURRENT_TIMESTAMP WHERE AD_Tree_ID=10 AND Node_ID=80041
;

-- May 1, 2014 2:46:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=80048, SeqNo=8, Updated=CURRENT_TIMESTAMP WHERE AD_Tree_ID=10 AND Node_ID=80044
;

-- May 1, 2014 2:46:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=80048, SeqNo=9, Updated=CURRENT_TIMESTAMP WHERE AD_Tree_ID=10 AND Node_ID=80053
;

-- May 1, 2014 2:46:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=80048, SeqNo=10, Updated=CURRENT_TIMESTAMP WHERE AD_Tree_ID=10 AND Node_ID=80043
;

-- May 1, 2014 2:49:28 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Column SET ColumnSQL='(SELECT adddays(d.datedelivered,pt.netdays) as duedate FROM SD_Delivery d INNER JOIN MM_Package p ON p.MM_Package_Id = SD_DeliveryLine.MM_Package_ID INNER JOIN C_Invoice iv ON iv.C_Order_ID = p.C_Order_ID AND iv.DocStatus = ''CO'' INNER JOIN C_PaymentTerm pt ON iv.C_PaymentTerm_Id = pt.C_PaymentTerm_ID WHERE d.SD_Delivery_ID = SD_DeliveryLine.SD_Delivery_ID)',Updated=TO_TIMESTAMP('2014-05-01 14:49:28','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=80380
;

-- May 1, 2014 2:49:47 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Column SET ColumnSQL='(SELECT o.C_Bpartner_ID FROM MM_Package p INNER JOIN C_Order o ON o.C_Order_ID = p.C_Order_ID WHERE SD_DeliveryLine.MM_Package_Id = p.MM_Package_ID)',Updated=TO_TIMESTAMP('2014-05-01 14:49:47','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=80377
;

-- May 1, 2014 2:49:59 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Column SET ColumnSQL='(SELECT p.C_Order_ID FROM MM_Package p WHERE SD_DeliveryLine.MM_Package_Id = p.MM_Package_ID)',Updated=TO_TIMESTAMP('2014-05-01 14:49:59','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=80378
;

-- May 1, 2014 2:50:07 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Column SET ColumnSQL='(SELECT iv.C_PaymentTerm_ID FROM MM_Package p INNER JOIN C_Invoice iv ON iv.C_Order_ID = p.C_Order_ID AND iv.DocStatus = ''CO'' WHERE SD_DeliveryLine.MM_Package_Id = p.MM_Package_ID)',Updated=TO_TIMESTAMP('2014-05-01 14:50:07','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=80379
;

-- May 1, 2014 2:50:15 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Column SET ColumnSQL='(SELECT d.datedelivered  FROM SD_Delivery d WHERE d.SD_Delivery _ID = SD_DeliveryLine.SD_Delivery_ID)',Updated=TO_TIMESTAMP('2014-05-01 14:50:15','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=80374
;

-- May 1, 2014 2:50:23 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Column SET ColumnSQL='(SELECT d.DocumentNo  FROM SD_Delivery d WHERE d.SD_Delivery _ID = SD_DeliveryLine.SD_Delivery_ID)',Updated=TO_TIMESTAMP('2014-05-01 14:50:23','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=80375
;

-- May 1, 2014 2:50:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Column SET ColumnSQL='(SELECT d.M_Shipper_ID  FROM SD_Delivery d WHERE d.SD_Delivery _ID = SD_DeliveryLine.SD_Delivery_ID)',Updated=TO_TIMESTAMP('2014-05-01 14:50:33','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=80376
;

-- May 1, 2014 2:52:42 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Column SET ColumnSQL='(SELECT d.DocumentNo  FROM SD_Delivery d WHERE d.SD_Delivery_ID = SD_DeliveryLine.SD_Delivery_ID)',Updated=TO_TIMESTAMP('2014-05-01 14:52:42','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=80375
;

-- May 1, 2014 2:52:47 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Column SET ColumnSQL='(SELECT d.M_Shipper_ID  FROM SD_Delivery d WHERE d.SD_Delivery_ID = SD_DeliveryLine.SD_Delivery_ID)',Updated=TO_TIMESTAMP('2014-05-01 14:52:47','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=80376
;

-- May 1, 2014 2:52:53 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Column SET ColumnSQL='(SELECT d.datedelivered  FROM SD_Delivery d WHERE d.SD_Delivery_ID = SD_DeliveryLine.SD_Delivery_ID)',Updated=TO_TIMESTAMP('2014-05-01 14:52:53','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=80374
;

-- May 1, 2014 3:04:13 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET IsReadOnly='Y',Updated=TO_TIMESTAMP('2014-05-01 15:04:13','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=80339
;

-- May 1, 2014 3:04:24 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Table SET IsDeleteable='N',Updated=TO_TIMESTAMP('2014-05-01 15:04:24','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Table_ID=80014
;

-- May 1, 2014 3:05:03 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET IsReadOnly='Y',Updated=TO_TIMESTAMP('2014-05-01 15:05:03','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=80337
;

-- May 1, 2014 4:05:36 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Column SET IsIdentifier='Y',Updated=TO_TIMESTAMP('2014-05-01 16:05:36','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=80306
;

-- May 1, 2014 4:16:57 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Message (AD_Client_ID,AD_Message_ID,AD_Org_ID,Created,CreatedBy,EntityType,IsActive,MsgText,MsgType,Updated,UpdatedBy,Value) VALUES (0,80009,0,TO_TIMESTAMP('2014-05-01 16:16:57','YYYY-MM-DD HH24:MI:SS'),100,'pasta','Y','Cannot Update Package Status To Return','E',TO_TIMESTAMP('2014-05-01 16:16:57','YYYY-MM-DD HH24:MI:SS'),100,'CANNOT_UPDATE_PACKAGE_STATUS_TO_RETURN')
;

-- May 1, 2014 4:16:57 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Message_Trl (AD_Language,AD_Message_ID, MsgText,MsgTip, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Message_ID, t.MsgText,t.MsgTip, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Message t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Message_ID=80009 AND NOT EXISTS (SELECT * FROM AD_Message_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Message_ID=t.AD_Message_ID)
;

