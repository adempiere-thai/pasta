-- Dec 15, 2013 1:29:57 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Element (AD_Client_ID,AD_Element_ID,AD_Org_ID,ColumnName,Created,CreatedBy,EntityType,IsActive,Name,PrintName,Updated,UpdatedBy) VALUES (0,80075,0,'PackingNo',TO_DATE('2013-12-15 13:29:57','YYYY-MM-DD HH24:MI:SS'),100,'pasta','Y','Packing No','Packing No',TO_DATE('2013-12-15 13:29:57','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Dec 15, 2013 1:29:57 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Element_Trl (AD_Language,AD_Element_ID, Description,Help,Name,PO_Description,PO_Help,PO_Name,PO_PrintName,PrintName, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Element_ID, t.Description,t.Help,t.Name,t.PO_Description,t.PO_Help,t.PO_Name,t.PO_PrintName,t.PrintName, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Element t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Element_ID=80075 AND NOT EXISTS (SELECT * FROM AD_Element_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Element_ID=t.AD_Element_ID)
;

-- Dec 15, 2013 1:30:35 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Column (AD_Client_ID,AD_Column_ID,AD_Element_ID,AD_Org_ID,AD_Reference_ID,AD_Table_ID,ColumnName,Created,CreatedBy,EntityType,FieldLength,IsActive,IsAllowLogging,IsAlwaysUpdateable,IsAutocomplete,IsEncrypted,IsIdentifier,IsKey,IsMandatory,IsParent,IsSelectionColumn,IsSyncDatabase,IsTranslated,IsUpdateable,Name,SeqNo,Updated,UpdatedBy,Version) VALUES (0,80259,80075,0,14,318,'PackingNo',TO_DATE('2013-12-15 13:30:35','YYYY-MM-DD HH24:MI:SS'),100,'pasta',500,'Y','Y','N','N','N','N','N','N','N','N','N','N','Y','Packing No',0,TO_DATE('2013-12-15 13:30:35','YYYY-MM-DD HH24:MI:SS'),100,0)
;

-- Dec 15, 2013 1:30:35 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Column_Trl (AD_Language,AD_Column_ID, Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Column_ID, t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Column t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Column_ID=80259 AND NOT EXISTS (SELECT * FROM AD_Column_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Column_ID=t.AD_Column_ID)
;

-- Dec 15, 2013 1:30:37 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
ALTER TABLE C_Invoice ADD PackingNo NVARCHAR2(500) DEFAULT NULL 
;

-- Dec 15, 2013 1:34:04 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,DisplayLength,EntityType,HideInListView,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,PreferredWidth,SeqNo,SortNo,Updated,UpdatedBy) VALUES (0,80259,80276,0,263,TO_DATE('2013-12-15 13:34:04','YYYY-MM-DD HH24:MI:SS'),100,0,'pasta','N','Y','Y','Y','N','N','N','N','N','Packing No',0,440,0,TO_DATE('2013-12-15 13:34:04','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Dec 15, 2013 1:34:04 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=80276 AND NOT EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Field_ID=t.AD_Field_ID)
;

-- Dec 15, 2013 1:36:36 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET AD_Reference_ID=36,Updated=TO_DATE('2013-12-15 13:36:36','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=80276
;

-- Dec 15, 2013 1:37:40 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET AD_Reference_ID=14,Updated=TO_DATE('2013-12-15 13:37:40','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=80276
;

-- Dec 15, 2013 1:38:04 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET DisplayLength=60,Updated=TO_DATE('2013-12-15 13:38:04','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=80276
;

-- Dec 15, 2013 1:39:11 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Column SET IsAlwaysUpdateable='Y',Updated=TO_DATE('2013-12-15 13:39:11','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=80259
;

-- Dec 15, 2013 1:41:28 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Menu SET Name='GBV Tax Invoice',Updated=TO_DATE('2013-12-15 13:41:28','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Menu_ID=80046
;

-- Dec 15, 2013 1:41:28 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Menu_Trl SET IsTranslated='N' WHERE AD_Menu_ID=80046
;

-- Dec 15, 2013 1:42:26 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
DELETE FROM AD_Attachment WHERE AD_Attachment_ID=1000031
;

-- Dec 15, 2013 1:43:04 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Attachment (AD_Attachment_ID,AD_Client_ID,AD_Org_ID,AD_Table_ID,Created,CreatedBy,IsActive,Record_ID,TextMsg,Title,Updated,UpdatedBy) VALUES (1000033,0,0,284,TO_DATE('2013-12-15 13:42:28','YYYY-MM-DD HH24:MI:SS'),100,'Y',80021,NULL,'zip',TO_DATE('2013-12-15 13:42:28','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Dec 15, 2013 1:51:37 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
DELETE FROM AD_Attachment WHERE AD_Attachment_ID=1000033
;

-- Dec 15, 2013 1:51:58 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Attachment (AD_Attachment_ID,AD_Client_ID,AD_Org_ID,AD_Table_ID,Created,CreatedBy,IsActive,Record_ID,TextMsg,Title,Updated,UpdatedBy) VALUES (1000034,0,0,284,TO_DATE('2013-12-15 13:51:38','YYYY-MM-DD HH24:MI:SS'),100,'Y',80021,NULL,'zip',TO_DATE('2013-12-15 13:51:38','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Dec 15, 2013 1:53:09 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
DELETE FROM AD_Attachment WHERE AD_Attachment_ID=1000034
;

-- Dec 15, 2013 1:53:28 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Attachment (AD_Attachment_ID,AD_Client_ID,AD_Org_ID,AD_Table_ID,Created,CreatedBy,IsActive,Record_ID,TextMsg,Title,Updated,UpdatedBy) VALUES (1000035,0,0,284,TO_DATE('2013-12-15 13:53:14','YYYY-MM-DD HH24:MI:SS'),100,'Y',80021,NULL,'zip',TO_DATE('2013-12-15 13:53:14','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Dec 15, 2013 1:54:36 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
DELETE FROM AD_Attachment WHERE AD_Attachment_ID=1000035
;

-- Dec 15, 2013 1:54:54 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Attachment (AD_Attachment_ID,AD_Client_ID,AD_Org_ID,AD_Table_ID,Created,CreatedBy,IsActive,Record_ID,TextMsg,Title,Updated,UpdatedBy) VALUES (1000036,0,0,284,TO_DATE('2013-12-15 13:54:37','YYYY-MM-DD HH24:MI:SS'),100,'Y',80021,NULL,'zip',TO_DATE('2013-12-15 13:54:37','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Dec 15, 2013 1:58:59 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
DELETE FROM AD_Attachment WHERE AD_Attachment_ID=1000036
;

-- Dec 15, 2013 1:59:30 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Attachment (AD_Attachment_ID,AD_Client_ID,AD_Org_ID,AD_Table_ID,Created,CreatedBy,IsActive,Record_ID,TextMsg,Title,Updated,UpdatedBy) VALUES (1000037,0,0,284,TO_DATE('2013-12-15 13:59:00','YYYY-MM-DD HH24:MI:SS'),100,'Y',80021,NULL,'zip',TO_DATE('2013-12-15 13:59:00','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Dec 15, 2013 2:04:55 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
DELETE FROM AD_Attachment WHERE AD_Attachment_ID=1000037
;

-- Dec 15, 2013 2:05:14 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Attachment (AD_Attachment_ID,AD_Client_ID,AD_Org_ID,AD_Table_ID,Created,CreatedBy,IsActive,Record_ID,TextMsg,Title,Updated,UpdatedBy) VALUES (1000038,0,0,284,TO_DATE('2013-12-15 14:04:57','YYYY-MM-DD HH24:MI:SS'),100,'Y',80021,NULL,'zip',TO_DATE('2013-12-15 14:04:57','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Dec 15, 2013 2:07:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Process SET AccessLevel='3', AD_Form_ID=NULL, AD_PrintFormat_ID=NULL, AD_ReportView_ID=NULL, AD_Workflow_ID=NULL, Classname=NULL, Description=NULL, Help=NULL, IsBetaFunctionality='N', IsDirectPrint='N', IsReport='Y', IsServerProcess='N', JasperReport='attachment:gbv_do_inv_frm.jasper', ProcedureName=NULL, ShowHelp='Y',Updated=TO_DATE('2013-12-15 14:07:33','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Process_ID=80022
;

-- Dec 15, 2013 2:07:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Process_Trl SET IsTranslated='N' WHERE AD_Process_ID=80022
;

-- Dec 15, 2013 2:07:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Menu SET Description=NULL, IsActive='Y', Name='GBV Tax Invoice',Updated=TO_DATE('2013-12-15 14:07:33','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Menu_ID=80046
;

-- Dec 15, 2013 2:07:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Menu_Trl SET IsTranslated='N' WHERE AD_Menu_ID=80046
;

-- Dec 15, 2013 2:07:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Process_Para (AD_Client_ID,AD_Element_ID,AD_Org_ID,AD_Process_ID,AD_Process_Para_ID,AD_Reference_ID,AD_Val_Rule_ID,ColumnName,Created,CreatedBy,DefaultValue,EntityType,FieldLength,IsActive,IsCentrallyMaintained,IsMandatory,IsRange,Name,ReadOnlyLogic,SeqNo,Updated,UpdatedBy) VALUES (0,102,0,80022,80087,19,116,'AD_Client_ID',TO_DATE('2013-12-15 14:07:33','YYYY-MM-DD HH24:MI:SS'),100,'@#AD_Client_ID@','pasta',0,'Y','Y','Y','N','Client','1=1',10,TO_DATE('2013-12-15 14:07:33','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Dec 15, 2013 2:07:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Process_Para_Trl (AD_Language,AD_Process_Para_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Process_Para_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Process_Para t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Process_Para_ID=80087 AND NOT EXISTS (SELECT * FROM AD_Process_Para_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Process_Para_ID=t.AD_Process_Para_ID)
;

-- Dec 15, 2013 2:07:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
DELETE FROM AD_Process_Para_Trl WHERE AD_Process_Para_ID = ?
;

-- Dec 15, 2013 2:07:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Process_Para_Trl (AD_Process_Para_ID, AD_Language,  AD_Client_ID, AD_Org_ID, IsActive, Created, CreatedBy, Updated, UpdatedBy,  Name, Description, Help, IsTranslated)  SELECT ?, AD_Language, AD_Client_ID, AD_Org_ID, IsActive, Created, CreatedBy,  Updated, UpdatedBy, Name, Description, Help, IsTranslated  FROM AD_Process_Para_Trl WHERE AD_Process_Para_ID = ? 
;

-- Dec 15, 2013 2:07:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Process_Para (AD_Client_ID,AD_Element_ID,AD_Org_ID,AD_Process_ID,AD_Process_Para_ID,AD_Reference_ID,AD_Val_Rule_ID,ColumnName,Created,CreatedBy,DefaultValue,EntityType,FieldLength,IsActive,IsCentrallyMaintained,IsMandatory,IsRange,Name,SeqNo,Updated,UpdatedBy) VALUES (0,113,0,80022,80088,19,202,'AD_Org_ID',TO_DATE('2013-12-15 14:07:33','YYYY-MM-DD HH24:MI:SS'),100,'@#AD_Org_ID@','pasta',0,'Y','Y','Y','N','Organization',20,TO_DATE('2013-12-15 14:07:33','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Dec 15, 2013 2:07:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Process_Para_Trl (AD_Language,AD_Process_Para_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Process_Para_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Process_Para t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Process_Para_ID=80088 AND NOT EXISTS (SELECT * FROM AD_Process_Para_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Process_Para_ID=t.AD_Process_Para_ID)
;

-- Dec 15, 2013 2:07:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
DELETE FROM AD_Process_Para_Trl WHERE AD_Process_Para_ID = ?
;

-- Dec 15, 2013 2:07:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Process_Para_Trl (AD_Process_Para_ID, AD_Language,  AD_Client_ID, AD_Org_ID, IsActive, Created, CreatedBy, Updated, UpdatedBy,  Name, Description, Help, IsTranslated)  SELECT ?, AD_Language, AD_Client_ID, AD_Org_ID, IsActive, Created, CreatedBy,  Updated, UpdatedBy, Name, Description, Help, IsTranslated  FROM AD_Process_Para_Trl WHERE AD_Process_Para_ID = ? 
;

-- Dec 15, 2013 2:07:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Process_Para (AD_Client_ID,AD_Element_ID,AD_Org_ID,AD_Process_ID,AD_Process_Para_ID,AD_Reference_ID,ColumnName,Created,CreatedBy,EntityType,FieldLength,IsActive,IsCentrallyMaintained,IsMandatory,IsRange,Name,SeqNo,Updated,UpdatedBy) VALUES (0,290,0,80022,80089,10,'DocumentNo',TO_DATE('2013-12-15 14:07:33','YYYY-MM-DD HH24:MI:SS'),100,'pasta',12,'Y','Y','Y','Y','Delivery Note/ Invoice No.',30,TO_DATE('2013-12-15 14:07:33','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Dec 15, 2013 2:07:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Process_Para_Trl (AD_Language,AD_Process_Para_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Process_Para_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Process_Para t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Process_Para_ID=80089 AND NOT EXISTS (SELECT * FROM AD_Process_Para_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Process_Para_ID=t.AD_Process_Para_ID)
;

-- Dec 15, 2013 2:07:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
DELETE FROM AD_Process_Para_Trl WHERE AD_Process_Para_ID = ?
;

-- Dec 15, 2013 2:07:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Process_Para_Trl (AD_Process_Para_ID, AD_Language,  AD_Client_ID, AD_Org_ID, IsActive, Created, CreatedBy, Updated, UpdatedBy,  Name, Description, Help, IsTranslated)  SELECT ?, AD_Language, AD_Client_ID, AD_Org_ID, IsActive, Created, CreatedBy,  Updated, UpdatedBy, Name, Description, Help, IsTranslated  FROM AD_Process_Para_Trl WHERE AD_Process_Para_ID = ? 
;

-- Dec 15, 2013 2:07:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Process_Para (AD_Client_ID,AD_Element_ID,AD_Org_ID,AD_Process_ID,AD_Process_Para_ID,AD_Reference_ID,ColumnName,Created,CreatedBy,EntityType,FieldLength,IsActive,IsCentrallyMaintained,IsMandatory,IsRange,Name,SeqNo,Updated,UpdatedBy) VALUES (0,267,0,80022,80090,15,'DateInvoiced',TO_DATE('2013-12-15 14:07:33','YYYY-MM-DD HH24:MI:SS'),100,'pasta',10,'Y','Y','N','Y','Invoice Date',40,TO_DATE('2013-12-15 14:07:33','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Dec 15, 2013 2:07:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Process_Para_Trl (AD_Language,AD_Process_Para_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Process_Para_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Process_Para t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Process_Para_ID=80090 AND NOT EXISTS (SELECT * FROM AD_Process_Para_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Process_Para_ID=t.AD_Process_Para_ID)
;

-- Dec 15, 2013 2:07:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
DELETE FROM AD_Process_Para_Trl WHERE AD_Process_Para_ID = ?
;

-- Dec 15, 2013 2:07:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Process_Para_Trl (AD_Process_Para_ID, AD_Language,  AD_Client_ID, AD_Org_ID, IsActive, Created, CreatedBy, Updated, UpdatedBy,  Name, Description, Help, IsTranslated)  SELECT ?, AD_Language, AD_Client_ID, AD_Org_ID, IsActive, Created, CreatedBy,  Updated, UpdatedBy, Name, Description, Help, IsTranslated  FROM AD_Process_Para_Trl WHERE AD_Process_Para_ID = ? 
;

-- Dec 15, 2013 2:07:38 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Process SET JasperReport='attachment:gbv_taxinvoice.jasper',Updated=TO_DATE('2013-12-15 14:07:38','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Process_ID=80022
;

-- Dec 15, 2013 2:08:04 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Process_Para SET Name='Tax Invoice No.',Updated=TO_DATE('2013-12-15 14:08:04','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Process_Para_ID=80089
;

-- Dec 15, 2013 2:08:04 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Process_Para_Trl SET IsTranslated='N' WHERE AD_Process_Para_ID=80089
;

-- Dec 15, 2013 2:17:32 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
DELETE FROM AD_Attachment WHERE AD_Attachment_ID=1000032
;

-- Dec 15, 2013 2:17:52 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Attachment (AD_Attachment_ID,AD_Client_ID,AD_Org_ID,AD_Table_ID,Created,CreatedBy,IsActive,Record_ID,TextMsg,Title,Updated,UpdatedBy) VALUES (1000039,0,0,284,TO_DATE('2013-12-15 14:17:34','YYYY-MM-DD HH24:MI:SS'),100,'Y',80022,NULL,'zip',TO_DATE('2013-12-15 14:17:34','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Dec 15, 2013 2:20:51 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
DELETE FROM AD_Attachment WHERE AD_Attachment_ID=1000039
;

-- Dec 15, 2013 2:21:06 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Attachment (AD_Attachment_ID,AD_Client_ID,AD_Org_ID,AD_Table_ID,Created,CreatedBy,IsActive,Record_ID,TextMsg,Title,Updated,UpdatedBy) VALUES (1000040,0,0,284,TO_DATE('2013-12-15 14:20:52','YYYY-MM-DD HH24:MI:SS'),100,'Y',80022,NULL,'zip',TO_DATE('2013-12-15 14:20:52','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Dec 15, 2013 2:22:37 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
DELETE FROM AD_Attachment WHERE AD_Attachment_ID=1000040
;

-- Dec 15, 2013 2:22:59 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Attachment (AD_Attachment_ID,AD_Client_ID,AD_Org_ID,AD_Table_ID,Created,CreatedBy,IsActive,Record_ID,TextMsg,Title,Updated,UpdatedBy) VALUES (1000041,0,0,284,TO_DATE('2013-12-15 14:22:39','YYYY-MM-DD HH24:MI:SS'),100,'Y',80022,NULL,'zip',TO_DATE('2013-12-15 14:22:39','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Dec 15, 2013 2:23:39 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
DELETE FROM AD_Attachment WHERE AD_Attachment_ID=1000041
;

-- Dec 15, 2013 2:24:06 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Attachment (AD_Attachment_ID,AD_Client_ID,AD_Org_ID,AD_Table_ID,Created,CreatedBy,IsActive,Record_ID,TextMsg,Title,Updated,UpdatedBy) VALUES (1000042,0,0,284,TO_DATE('2013-12-15 14:23:41','YYYY-MM-DD HH24:MI:SS'),100,'Y',80022,NULL,'zip',TO_DATE('2013-12-15 14:23:41','YYYY-MM-DD HH24:MI:SS'),100)
;

