-- Apr 15, 2011 12:09:48 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Ref_List (AD_Client_ID,AD_Org_ID,AD_Ref_List_ID,AD_Reference_ID,Created,CreatedBy,EntityType,IsActive,Name,Updated,UpdatedBy,Value) VALUES (0,0,80015,183,TO_TIMESTAMP('2011-04-15 00:09:48','YYYY-MM-DD HH24:MI:SS'),100,'U','Y','AP Debit Note',TO_TIMESTAMP('2011-04-15 00:09:48','YYYY-MM-DD HH24:MI:SS'),100,'APD')
;

-- Apr 15, 2011 12:09:48 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Ref_List_Trl (AD_Language,AD_Ref_List_ID, Description,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Ref_List_ID, t.Description,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Ref_List t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Ref_List_ID=80015 AND NOT EXISTS (SELECT * FROM AD_Ref_List_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Ref_List_ID=t.AD_Ref_List_ID)
;

-- Apr 15, 2011 12:10:15 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Ref_List (AD_Client_ID,AD_Org_ID,AD_Ref_List_ID,AD_Reference_ID,Created,CreatedBy,EntityType,IsActive,Name,Updated,UpdatedBy,Value) VALUES (0,0,80016,183,TO_TIMESTAMP('2011-04-15 00:10:15','YYYY-MM-DD HH24:MI:SS'),100,'U','Y','AR Debit Note',TO_TIMESTAMP('2011-04-15 00:10:15','YYYY-MM-DD HH24:MI:SS'),100,'ARD')
;

-- Apr 15, 2011 12:10:15 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Ref_List_Trl (AD_Language,AD_Ref_List_ID, Description,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Ref_List_ID, t.Description,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Ref_List t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Ref_List_ID=80016 AND NOT EXISTS (SELECT * FROM AD_Ref_List_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Ref_List_ID=t.AD_Ref_List_ID)
;

-- Apr 15, 2011 12:15:23 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Ref_List SET EntityType='pasta',Updated=TO_TIMESTAMP('2011-04-15 00:15:23','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Ref_List_ID=80016
;

-- Apr 15, 2011 12:15:41 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Ref_List SET EntityType='pasta',Updated=TO_TIMESTAMP('2011-04-15 00:15:41','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Ref_List_ID=80015
;

-- Apr 15, 2011 12:25:48 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Val_Rule SET Code='C_DocType.DocBaseType IN (''ARI'', ''API'',''ARC'',''APC'',''APD'',''ARD'') AND C_DocType.IsSOTrx=''@IsSOTrx@''',Updated=TO_TIMESTAMP('2011-04-15 00:25:48','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Val_Rule_ID=124
;

-- Apr 15, 2011 12:30:01 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Column SET Callout='org.compiere.model.CalloutInvoice.docType,org.pasta.model.CalloutInvoice.docType',Updated=TO_TIMESTAMP('2011-04-15 00:30:01','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=3781
;

-- Apr 15, 2011 12:33:37 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Column SET AD_Reference_ID=30, AD_Reference_Value_ID=336,Updated=TO_TIMESTAMP('2011-04-15 00:33:37','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=10788
;

-- Apr 15, 2011 12:37:13 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Val_Rule (AD_Client_ID,AD_Org_ID,AD_Val_Rule_ID,Code,Created,CreatedBy,EntityType,IsActive,Name,Type,Updated,UpdatedBy) VALUES (0,0,80001,'C_Invoice.IsDebitCredit = ''N''',TO_TIMESTAMP('2011-04-15 00:37:13','YYYY-MM-DD HH24:MI:SS'),100,'pasta','Y','C_Invoice Invoice','S',TO_TIMESTAMP('2011-04-15 00:37:13','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Apr 15, 2011 12:37:45 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Val_Rule SET Code='C_Invoice.IsDebitCredit = ''N'' AND C_Invoice.DocStatus = ''CO''',Updated=TO_TIMESTAMP('2011-04-15 00:37:45','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Val_Rule_ID=80001
;

-- Apr 15, 2011 12:37:50 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Column SET AD_Val_Rule_ID=80001,Updated=TO_TIMESTAMP('2011-04-15 00:37:50','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=10788
;

-- Apr 15, 2011 12:38:58 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Val_Rule SET Code='C_Invoice.IsCreditDebit = ''N'' AND C_Invoice.DocStatus = ''CO''',Updated=TO_TIMESTAMP('2011-04-15 00:38:58','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Val_Rule_ID=80001
;

-- Apr 15, 2011 12:49:34 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET IsSameLine='N', SeqNo=75,Updated=TO_TIMESTAMP('2011-04-15 00:49:34','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=6565
;

-- Apr 15, 2011 12:50:34 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET DisplayLogic='@IsCreditDebit@=Y',Updated=TO_TIMESTAMP('2011-04-15 00:50:34','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=9228
;

-- Apr 15, 2011 12:53:43 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Column SET IsAlwaysUpdateable='Y',Updated=TO_TIMESTAMP('2011-04-15 00:53:43','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=80051
;

-- Apr 15, 2011 12:55:22 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Attachment SET UpdatedBy=100, TextMsg=NULL,Updated=TO_TIMESTAMP('2011-04-15 00:55:22','YYYY-MM-DD HH24:MI:SS') WHERE AD_Attachment_ID=80001
;

-- Apr 15, 2011 12:55:44 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Attachment SET UpdatedBy=100, TextMsg=NULL,Updated=TO_TIMESTAMP('2011-04-15 00:55:44','YYYY-MM-DD HH24:MI:SS') WHERE AD_Attachment_ID=80002
;

-- Apr 15, 2011 12:58:03 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Attachment SET UpdatedBy=100, TextMsg=NULL,Updated=TO_TIMESTAMP('2011-04-15 00:58:03','YYYY-MM-DD HH24:MI:SS') WHERE AD_Attachment_ID=80002
;

