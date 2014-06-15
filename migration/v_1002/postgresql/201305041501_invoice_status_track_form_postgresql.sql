-- May 4, 2014 1:56:55 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Form (AccessLevel,AD_Client_ID,AD_Form_ID,AD_Org_ID,Classname,Created,CreatedBy,Description,EntityType,IsActive,IsBetaFunctionality,Name,Updated,UpdatedBy) VALUES ('3',0,80000,0,'org.pasta.apps.form.VInvoiceReturn',TO_TIMESTAMP('2014-05-04 13:56:54','YYYY-MM-DD HH24:MI:SS'),100,'Invoice Status Tracking','pasta','Y','N','GBV_โปรแกรมตรวจสอบและระบุสถานะของใบแจ้งหนี้',TO_TIMESTAMP('2014-05-04 13:56:54','YYYY-MM-DD HH24:MI:SS'),100)
;

-- May 4, 2014 2:36:37 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Message (AD_Client_ID,AD_Message_ID,AD_Org_ID,Created,CreatedBy,EntityType,IsActive,MsgText,MsgType,Updated,UpdatedBy,Value) VALUES (0,80010,0,TO_TIMESTAMP('2014-05-04 14:36:37','YYYY-MM-DD HH24:MI:SS'),100,'pasta','Y','Invoice Number','I',TO_TIMESTAMP('2014-05-04 14:36:37','YYYY-MM-DD HH24:MI:SS'),100,'InvoiceNo')
;

-- May 4, 2014 2:36:37 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Message_Trl (AD_Language,AD_Message_ID, MsgText,MsgTip, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Message_ID, t.MsgText,t.MsgTip, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Message t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Message_ID=80010 AND NOT EXISTS (SELECT * FROM AD_Message_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Message_ID=t.AD_Message_ID)
;

