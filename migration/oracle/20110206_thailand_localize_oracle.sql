-- Feb 6, 2011 2:34:48 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_EntityType (AD_Client_ID,AD_EntityType_ID,AD_Org_ID,Created,CreatedBy,Description,EntityType,IsActive,ModelPackage,Name,Processing,Updated,UpdatedBy,Version) VALUES (0,80000,0,TO_DATE('2011-02-06 02:34:48','YYYY-MM-DD HH24:MI:SS'),0,'Pasuwat & Sukritta','pasta','Y','org.pasta.model','Pasta','N',TO_DATE('2011-02-06 02:34:48','YYYY-MM-DD HH24:MI:SS'),0,'001')
;

-- Feb 6, 2011 2:36:18 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Element (AD_Client_ID,AD_Element_ID,AD_Org_ID,ColumnName,Created,CreatedBy,Description,EntityType,IsActive,Name,PrintName,Updated,UpdatedBy) VALUES (0,80000,0,'ActualTaxAddress',TO_DATE('2011-02-06 02:36:18','YYYY-MM-DD HH24:MI:SS'),0,'Address For Tax Invoice','U','Y','Tax Address','Tax Address',TO_DATE('2011-02-06 02:36:18','YYYY-MM-DD HH24:MI:SS'),0)
;

-- Feb 6, 2011 2:36:18 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Element_Trl (AD_Language,AD_Element_ID, Description,Help,Name,PO_Description,PO_Help,PO_Name,PO_PrintName,PrintName, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Element_ID, t.Description,t.Help,t.Name,t.PO_Description,t.PO_Help,t.PO_Name,t.PO_PrintName,t.PrintName, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Element t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Element_ID=80000 AND NOT EXISTS (SELECT * FROM AD_Element_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Element_ID=t.AD_Element_ID)
;

-- Feb 6, 2011 2:36:40 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Element SET EntityType='pasta',Updated=TO_DATE('2011-02-06 02:36:40','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=0 WHERE AD_Element_ID=80000
;

-- Feb 6, 2011 2:37:56 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Element (AD_Client_ID,AD_Element_ID,AD_Org_ID,ColumnName,Created,CreatedBy,Description,EntityType,IsActive,Name,PO_Description,PO_Name,PO_PrintName,PrintName,Updated,UpdatedBy) VALUES (0,80001,0,'ActualTaxBPartnerName',TO_DATE('2011-02-06 02:37:56','YYYY-MM-DD HH24:MI:SS'),0,'Tax Customer Name','pasta','Y','Tax Customer Name','Tax Vendor Name','Tax Vendor Name','Tax Vendor Name','Tax Customer Name',TO_DATE('2011-02-06 02:37:56','YYYY-MM-DD HH24:MI:SS'),0)
;

-- Feb 6, 2011 2:37:56 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Element_Trl (AD_Language,AD_Element_ID, Description,Help,Name,PO_Description,PO_Help,PO_Name,PO_PrintName,PrintName, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Element_ID, t.Description,t.Help,t.Name,t.PO_Description,t.PO_Help,t.PO_Name,t.PO_PrintName,t.PrintName, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Element t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Element_ID=80001 AND NOT EXISTS (SELECT * FROM AD_Element_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Element_ID=t.AD_Element_ID)
;

-- Feb 6, 2011 2:39:07 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Element (AD_Client_ID,AD_Element_ID,AD_Org_ID,ColumnName,Created,CreatedBy,EntityType,IsActive,Name,PrintName,Updated,UpdatedBy) VALUES (0,80002,0,'TaxInvoiceNo',TO_DATE('2011-02-06 02:39:07','YYYY-MM-DD HH24:MI:SS'),0,'pasta','Y','Tax Invoice No.','Tax Invoice No.',TO_DATE('2011-02-06 02:39:07','YYYY-MM-DD HH24:MI:SS'),0)
;

-- Feb 6, 2011 2:39:07 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Element_Trl (AD_Language,AD_Element_ID, Description,Help,Name,PO_Description,PO_Help,PO_Name,PO_PrintName,PrintName, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Element_ID, t.Description,t.Help,t.Name,t.PO_Description,t.PO_Help,t.PO_Name,t.PO_PrintName,t.PrintName, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Element t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Element_ID=80002 AND NOT EXISTS (SELECT * FROM AD_Element_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Element_ID=t.AD_Element_ID)
;

-- Feb 6, 2011 2:40:44 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Column (AD_Client_ID,AD_Column_ID,AD_Element_ID,AD_Org_ID,AD_Reference_ID,AD_Table_ID,ColumnName,Created,CreatedBy,EntityType,FieldLength,IsActive,IsAllowLogging,IsAlwaysUpdateable,IsAutocomplete,IsEncrypted,IsIdentifier,IsKey,IsMandatory,IsParent,IsSelectionColumn,IsSyncDatabase,IsTranslated,IsUpdateable,Name,SeqNo,Updated,UpdatedBy,Version) VALUES (0,80000,80002,0,10,334,'TaxInvoiceNo',TO_DATE('2011-02-06 02:40:44','YYYY-MM-DD HH24:MI:SS'),0,'U',10,'Y','Y','N','N','N','N','N','N','N','N','N','N','Y','Tax Invoice No.',0,TO_DATE('2011-02-06 02:40:44','YYYY-MM-DD HH24:MI:SS'),0,0)
;

-- Feb 6, 2011 2:40:44 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Column_Trl (AD_Language,AD_Column_ID, Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Column_ID, t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Column t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Column_ID=80000 AND NOT EXISTS (SELECT * FROM AD_Column_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Column_ID=t.AD_Column_ID)
;

-- Feb 6, 2011 2:40:48 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
ALTER TABLE C_InvoiceTax ADD TaxInvoiceNo NVARCHAR2(10) DEFAULT NULL 
;

-- Feb 6, 2011 2:41:25 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Column (AD_Client_ID,AD_Column_ID,AD_Element_ID,AD_Org_ID,AD_Reference_ID,AD_Table_ID,ColumnName,Created,CreatedBy,Description,EntityType,FieldLength,IsActive,IsAllowLogging,IsAlwaysUpdateable,IsAutocomplete,IsEncrypted,IsIdentifier,IsKey,IsMandatory,IsParent,IsSelectionColumn,IsSyncDatabase,IsTranslated,IsUpdateable,Name,SeqNo,Updated,UpdatedBy,Version) VALUES (0,80001,80001,0,10,334,'ActualTaxBPartnerName',TO_DATE('2011-02-06 02:41:25','YYYY-MM-DD HH24:MI:SS'),0,'Tax Customer Name','U',150,'Y','Y','N','N','N','N','N','N','N','N','N','N','Y','Tax Customer Name',0,TO_DATE('2011-02-06 02:41:25','YYYY-MM-DD HH24:MI:SS'),0,0)
;

-- Feb 6, 2011 2:41:25 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Column_Trl (AD_Language,AD_Column_ID, Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Column_ID, t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Column t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Column_ID=80001 AND NOT EXISTS (SELECT * FROM AD_Column_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Column_ID=t.AD_Column_ID)
;

-- Feb 6, 2011 2:41:27 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
ALTER TABLE C_InvoiceTax ADD ActualTaxBPartnerName NVARCHAR2(150) DEFAULT NULL 
;

-- Feb 6, 2011 2:41:59 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Column (AD_Client_ID,AD_Column_ID,AD_Element_ID,AD_Org_ID,AD_Reference_ID,AD_Table_ID,ColumnName,Created,CreatedBy,Description,EntityType,FieldLength,IsActive,IsAllowLogging,IsAlwaysUpdateable,IsAutocomplete,IsEncrypted,IsIdentifier,IsKey,IsMandatory,IsParent,IsSelectionColumn,IsSyncDatabase,IsTranslated,IsUpdateable,Name,SeqNo,Updated,UpdatedBy,Version) VALUES (0,80002,80000,0,14,334,'ActualTaxAddress',TO_DATE('2011-02-06 02:41:59','YYYY-MM-DD HH24:MI:SS'),0,'Address For Tax Invoice','U',255,'Y','Y','N','N','N','N','N','N','N','N','N','N','Y','Tax Address',0,TO_DATE('2011-02-06 02:41:59','YYYY-MM-DD HH24:MI:SS'),0,0)
;

-- Feb 6, 2011 2:41:59 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Column_Trl (AD_Language,AD_Column_ID, Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Column_ID, t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Column t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Column_ID=80002 AND NOT EXISTS (SELECT * FROM AD_Column_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Column_ID=t.AD_Column_ID)
;

-- Feb 6, 2011 2:42:01 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
ALTER TABLE C_InvoiceTax ADD ActualTaxAddress NVARCHAR2(255) DEFAULT NULL 
;

-- Feb 6, 2011 2:43:53 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Element (AD_Client_ID,AD_Element_ID,AD_Org_ID,ColumnName,Created,CreatedBy,Description,EntityType,IsActive,Name,PO_Name,PO_PrintName,PrintName,Updated,UpdatedBy) VALUES (0,80003,0,'ActualTaxAmt',TO_DATE('2011-02-06 02:43:53','YYYY-MM-DD HH24:MI:SS'),0,'Actual Tax Amount','pasta','Y','Actual Tax Amount','Actual Tax Amount','Actual Tax Amount','Actual Tax Amount',TO_DATE('2011-02-06 02:43:53','YYYY-MM-DD HH24:MI:SS'),0)
;

-- Feb 6, 2011 2:43:54 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Element_Trl (AD_Language,AD_Element_ID, Description,Help,Name,PO_Description,PO_Help,PO_Name,PO_PrintName,PrintName, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Element_ID, t.Description,t.Help,t.Name,t.PO_Description,t.PO_Help,t.PO_Name,t.PO_PrintName,t.PrintName, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Element t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Element_ID=80003 AND NOT EXISTS (SELECT * FROM AD_Element_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Element_ID=t.AD_Element_ID)
;

-- Feb 6, 2011 2:44:46 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Element (AD_Client_ID,AD_Element_ID,AD_Org_ID,ColumnName,Created,CreatedBy,EntityType,IsActive,Name,PO_Name,PO_PrintName,PrintName,Updated,UpdatedBy) VALUES (0,80004,0,'ActualTaxBaseAmt',TO_DATE('2011-02-06 02:44:46','YYYY-MM-DD HH24:MI:SS'),0,'U','Y','Actual Tax Base Amount','Actual Tax Base Amount','Actual Tax Base Amount','Actual Tax Base Amount',TO_DATE('2011-02-06 02:44:46','YYYY-MM-DD HH24:MI:SS'),0)
;

-- Feb 6, 2011 2:44:46 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Element_Trl (AD_Language,AD_Element_ID, Description,Help,Name,PO_Description,PO_Help,PO_Name,PO_PrintName,PrintName, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Element_ID, t.Description,t.Help,t.Name,t.PO_Description,t.PO_Help,t.PO_Name,t.PO_PrintName,t.PrintName, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Element t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Element_ID=80004 AND NOT EXISTS (SELECT * FROM AD_Element_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Element_ID=t.AD_Element_ID)
;

-- Feb 6, 2011 2:46:55 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Column (AD_Client_ID,AD_Column_ID,AD_Element_ID,AD_Org_ID,AD_Reference_ID,AD_Table_ID,ColumnName,Created,CreatedBy,Description,EntityType,FieldLength,IsActive,IsAllowLogging,IsAlwaysUpdateable,IsAutocomplete,IsEncrypted,IsIdentifier,IsKey,IsMandatory,IsParent,IsSelectionColumn,IsSyncDatabase,IsTranslated,IsUpdateable,Name,SeqNo,Updated,UpdatedBy,Version) VALUES (0,80003,80003,0,12,334,'ActualTaxAmt',TO_DATE('2011-02-06 02:46:55','YYYY-MM-DD HH24:MI:SS'),0,'Actual Tax Amount','U',22,'Y','Y','N','N','N','N','N','N','N','N','N','N','Y','Actual Tax Amount',0,TO_DATE('2011-02-06 02:46:55','YYYY-MM-DD HH24:MI:SS'),0,0)
;

-- Feb 6, 2011 2:46:55 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Column_Trl (AD_Language,AD_Column_ID, Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Column_ID, t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Column t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Column_ID=80003 AND NOT EXISTS (SELECT * FROM AD_Column_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Column_ID=t.AD_Column_ID)
;

-- Feb 6, 2011 2:47:00 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
ALTER TABLE C_InvoiceTax ADD ActualTaxAmt NUMBER DEFAULT NULL 
;

-- Feb 6, 2011 2:47:49 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Column (AD_Client_ID,AD_Column_ID,AD_Element_ID,AD_Org_ID,AD_Reference_ID,AD_Table_ID,ColumnName,Created,CreatedBy,EntityType,FieldLength,IsActive,IsAllowLogging,IsAlwaysUpdateable,IsAutocomplete,IsEncrypted,IsIdentifier,IsKey,IsMandatory,IsParent,IsSelectionColumn,IsSyncDatabase,IsTranslated,IsUpdateable,Name,SeqNo,Updated,UpdatedBy,Version) VALUES (0,80004,80004,0,12,334,'ActualTaxBaseAmt',TO_DATE('2011-02-06 02:47:49','YYYY-MM-DD HH24:MI:SS'),0,'U',22,'Y','Y','N','N','N','N','N','N','N','N','N','N','Y','Actual Tax Base Amount',0,TO_DATE('2011-02-06 02:47:49','YYYY-MM-DD HH24:MI:SS'),0,0)
;

-- Feb 6, 2011 2:47:49 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Column_Trl (AD_Language,AD_Column_ID, Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Column_ID, t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Column t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Column_ID=80004 AND NOT EXISTS (SELECT * FROM AD_Column_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Column_ID=t.AD_Column_ID)
;

-- Feb 6, 2011 2:47:54 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
ALTER TABLE C_InvoiceTax ADD ActualTaxBaseAmt NUMBER DEFAULT NULL 
;

-- Feb 6, 2011 2:48:04 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Column SET DefaultValue='0',Updated=TO_DATE('2011-02-06 02:48:04','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=0 WHERE AD_Column_ID=80004
;

-- Feb 6, 2011 2:48:07 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
ALTER TABLE C_InvoiceTax MODIFY ActualTaxBaseAmt NUMBER DEFAULT 0
;

-- Feb 6, 2011 2:48:19 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Column SET DefaultValue='0',Updated=TO_DATE('2011-02-06 02:48:19','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=0 WHERE AD_Column_ID=80003
;

-- Feb 6, 2011 2:48:22 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Column SET IsMandatory='Y',Updated=TO_DATE('2011-02-06 02:48:22','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=0 WHERE AD_Column_ID=80003
;

-- Feb 6, 2011 2:48:25 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
ALTER TABLE C_InvoiceTax MODIFY ActualTaxAmt NUMBER DEFAULT 0
;

-- Feb 6, 2011 2:48:25 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE C_InvoiceTax SET ActualTaxAmt=0 WHERE ActualTaxAmt IS NULL
;

-- Feb 6, 2011 2:48:25 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
ALTER TABLE C_InvoiceTax MODIFY ActualTaxAmt NOT NULL
;

-- Feb 6, 2011 2:48:53 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Column SET IsMandatory='Y',Updated=TO_DATE('2011-02-06 02:48:53','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=0 WHERE AD_Column_ID=80004
;

-- Feb 6, 2011 2:48:55 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
ALTER TABLE C_InvoiceTax MODIFY ActualTaxBaseAmt NUMBER DEFAULT 0
;

-- Feb 6, 2011 2:48:55 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE C_InvoiceTax SET ActualTaxBaseAmt=0 WHERE ActualTaxBaseAmt IS NULL
;

-- Feb 6, 2011 2:48:55 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
ALTER TABLE C_InvoiceTax MODIFY ActualTaxBaseAmt NOT NULL
;

-- Feb 6, 2011 2:49:35 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Column SET EntityType='pasta',Updated=TO_DATE('2011-02-06 02:49:35','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=0 WHERE AD_Column_ID=80004
;

-- Feb 6, 2011 2:49:43 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Column SET EntityType='pasta',Updated=TO_DATE('2011-02-06 02:49:43','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=0 WHERE AD_Column_ID=80003
;

-- Feb 6, 2011 2:49:51 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Column SET EntityType='pasta',Updated=TO_DATE('2011-02-06 02:49:51','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=0 WHERE AD_Column_ID=80000
;

-- Feb 6, 2011 2:50:10 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Column SET EntityType='pasta',Updated=TO_DATE('2011-02-06 02:50:10','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=0 WHERE AD_Column_ID=80002
;

-- Feb 6, 2011 2:50:15 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Column SET EntityType='pasta',Updated=TO_DATE('2011-02-06 02:50:15','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=0 WHERE AD_Column_ID=80001
;

-- Feb 6, 2011 2:57:21 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_FieldGroup (AD_Client_ID,AD_FieldGroup_ID,AD_Org_ID,Created,CreatedBy,EntityType,FieldGroupType,IsActive,IsCollapsedByDefault,Name,Updated,UpdatedBy) VALUES (0,80000,0,TO_DATE('2011-02-06 02:57:21','YYYY-MM-DD HH24:MI:SS'),0,'pasta','C','Y','N','Tax Information',TO_DATE('2011-02-06 02:57:21','YYYY-MM-DD HH24:MI:SS'),0)
;

-- Feb 6, 2011 2:57:21 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_FieldGroup_Trl (AD_Language,AD_FieldGroup_ID, Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_FieldGroup_ID, t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_FieldGroup t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_FieldGroup_ID=80000 AND NOT EXISTS (SELECT * FROM AD_FieldGroup_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_FieldGroup_ID=t.AD_FieldGroup_ID)
;

-- Feb 6, 2011 2:57:48 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,Description,DisplayLength,EntityType,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,80003,80000,0,292,TO_DATE('2011-02-06 02:57:48','YYYY-MM-DD HH24:MI:SS'),0,'Actual Tax Amount',22,'pasta','Y','Y','Y','N','N','N','N','N','Actual Tax Amount',TO_DATE('2011-02-06 02:57:48','YYYY-MM-DD HH24:MI:SS'),0)
;

-- Feb 6, 2011 2:57:48 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=80000 AND NOT EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Field_ID=t.AD_Field_ID)
;

-- Feb 6, 2011 2:57:48 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,DisplayLength,EntityType,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,80004,80001,0,292,TO_DATE('2011-02-06 02:57:48','YYYY-MM-DD HH24:MI:SS'),0,22,'pasta','Y','Y','Y','N','N','N','N','N','Actual Tax Base Amount',TO_DATE('2011-02-06 02:57:48','YYYY-MM-DD HH24:MI:SS'),0)
;

-- Feb 6, 2011 2:57:48 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=80001 AND NOT EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Field_ID=t.AD_Field_ID)
;

-- Feb 6, 2011 2:57:48 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,Description,DisplayLength,EntityType,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,80002,80002,0,292,TO_DATE('2011-02-06 02:57:48','YYYY-MM-DD HH24:MI:SS'),0,'Address For Tax Invoice',255,'pasta','Y','Y','Y','N','N','N','N','N','Tax Address',TO_DATE('2011-02-06 02:57:48','YYYY-MM-DD HH24:MI:SS'),0)
;

-- Feb 6, 2011 2:57:48 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=80002 AND NOT EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Field_ID=t.AD_Field_ID)
;

-- Feb 6, 2011 2:57:48 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,Description,DisplayLength,EntityType,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,80001,80003,0,292,TO_DATE('2011-02-06 02:57:48','YYYY-MM-DD HH24:MI:SS'),0,'Tax Customer Name',150,'pasta','Y','Y','Y','N','N','N','N','N','Tax Customer Name',TO_DATE('2011-02-06 02:57:48','YYYY-MM-DD HH24:MI:SS'),0)
;

-- Feb 6, 2011 2:57:48 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=80003 AND NOT EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Field_ID=t.AD_Field_ID)
;

-- Feb 6, 2011 2:57:48 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,DisplayLength,EntityType,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,80000,80004,0,292,TO_DATE('2011-02-06 02:57:48','YYYY-MM-DD HH24:MI:SS'),0,10,'pasta','Y','Y','Y','N','N','N','N','N','Tax Invoice No.',TO_DATE('2011-02-06 02:57:48','YYYY-MM-DD HH24:MI:SS'),0)
;

-- Feb 6, 2011 2:57:48 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=80004 AND NOT EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Field_ID=t.AD_Field_ID)
;

-- Feb 6, 2011 2:58:14 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET SeqNo=80,IsDisplayed='Y' WHERE AD_Field_ID=80004
;

-- Feb 6, 2011 2:58:14 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET SeqNo=90,IsDisplayed='Y' WHERE AD_Field_ID=80003
;

-- Feb 6, 2011 2:58:14 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET SeqNo=100,IsDisplayed='Y' WHERE AD_Field_ID=80002
;

-- Feb 6, 2011 2:58:14 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET SeqNo=110,IsDisplayed='Y' WHERE AD_Field_ID=80001
;

-- Feb 6, 2011 2:58:14 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET SeqNo=120,IsDisplayed='Y' WHERE AD_Field_ID=80000
;

-- Feb 6, 2011 2:58:29 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET AD_FieldGroup_ID=80000,Updated=TO_DATE('2011-02-06 02:58:29','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=0 WHERE AD_Field_ID=80004
;

-- Feb 6, 2011 2:58:37 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET AD_FieldGroup_ID=80000,Updated=TO_DATE('2011-02-06 02:58:37','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=0 WHERE AD_Field_ID=80003
;

-- Feb 6, 2011 2:58:42 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET AD_FieldGroup_ID=80000,Updated=TO_DATE('2011-02-06 02:58:42','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=0 WHERE AD_Field_ID=80000
;

-- Feb 6, 2011 2:58:49 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET AD_FieldGroup_ID=80000,Updated=TO_DATE('2011-02-06 02:58:49','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=0 WHERE AD_Field_ID=80001
;

-- Feb 6, 2011 2:58:54 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET IsSameLine='Y',Updated=TO_DATE('2011-02-06 02:58:54','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=0 WHERE AD_Field_ID=80000
;

-- Feb 6, 2011 2:59:06 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET DisplayLength=0,Updated=TO_DATE('2011-02-06 02:59:06','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=0 WHERE AD_Field_ID=80002
;

-- Feb 6, 2011 2:59:18 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET DisplayLength=50,Updated=TO_DATE('2011-02-06 02:59:18','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=0 WHERE AD_Field_ID=80003
;

-- Feb 6, 2011 3:00:18 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET DisplayLength=40,Updated=TO_DATE('2011-02-06 03:00:18','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=0 WHERE AD_Field_ID=80003
;

-- Feb 6, 2011 3:00:23 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET DisplayLength=40,Updated=TO_DATE('2011-02-06 03:00:23','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=0 WHERE AD_Field_ID=80002
;

-- Feb 6, 2011 10:34:28 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Tab SET IsReadOnly='N',Updated=TO_DATE('2011-02-06 22:34:28','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tab_ID=292
;

-- Feb 6, 2011 10:34:38 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET IsReadOnly='Y',Updated=TO_DATE('2011-02-06 22:34:38','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=3377
;

-- Feb 6, 2011 10:34:46 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET IsReadOnly='Y',Updated=TO_DATE('2011-02-06 22:34:45','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=3378
;

