-- Apr 27, 2014 11:48:48 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Form SET Name='GBV_โปรแกรมเช็คของขึ้นรถ',Updated=TO_TIMESTAMP('2014-04-27 23:48:48','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Form_ID=80000
;

-- Apr 27, 2014 11:48:48 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Form_Trl SET IsTranslated='N' WHERE AD_Form_ID=80000
;

-- Apr 27, 2014 11:49:56 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Message (AD_Client_ID,AD_Message_ID,AD_Org_ID,Created,CreatedBy,EntityType,IsActive,MsgText,MsgType,Updated,UpdatedBy,Value) VALUES (0,80005,0,TO_TIMESTAMP('2014-04-27 23:49:56','YYYY-MM-DD HH24:MI:SS'),100,'pasta','Y','โปรแกรมเช็คของขึ้นรถ','I',TO_TIMESTAMP('2014-04-27 23:49:56','YYYY-MM-DD HH24:MI:SS'),100,'CreateDelivery')
;

-- Apr 27, 2014 11:49:56 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Message_Trl (AD_Language,AD_Message_ID, MsgText,MsgTip, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Message_ID, t.MsgText,t.MsgTip, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Message t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Message_ID=80005 AND NOT EXISTS (SELECT * FROM AD_Message_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Message_ID=t.AD_Message_ID)
;

-- Apr 27, 2014 11:50:42 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Message (AD_Client_ID,AD_Message_ID,AD_Org_ID,Created,CreatedBy,EntityType,IsActive,MsgText,MsgType,Updated,UpdatedBy,Value) VALUES (0,80006,0,TO_TIMESTAMP('2014-04-27 23:50:42','YYYY-MM-DD HH24:MI:SS'),100,'pasta','Y','Enter Package No:','I',TO_TIMESTAMP('2014-04-27 23:50:42','YYYY-MM-DD HH24:MI:SS'),100,'EnterPackNo')
;

-- Apr 27, 2014 11:50:42 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Message_Trl (AD_Language,AD_Message_ID, MsgText,MsgTip, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Message_ID, t.MsgText,t.MsgTip, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Message t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Message_ID=80006 AND NOT EXISTS (SELECT * FROM AD_Message_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Message_ID=t.AD_Message_ID)
;

-- Apr 27, 2014 11:51:12 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Message (AD_Client_ID,AD_Message_ID,AD_Org_ID,Created,CreatedBy,EntityType,IsActive,MsgText,MsgType,Updated,UpdatedBy,Value) VALUES (0,80007,0,TO_TIMESTAMP('2014-04-27 23:51:12','YYYY-MM-DD HH24:MI:SS'),100,'pasta','Y','Package List','I',TO_TIMESTAMP('2014-04-27 23:51:12','YYYY-MM-DD HH24:MI:SS'),100,'PackageList')
;

-- Apr 27, 2014 11:51:12 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Message_Trl (AD_Language,AD_Message_ID, MsgText,MsgTip, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Message_ID, t.MsgText,t.MsgTip, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Message t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Message_ID=80007 AND NOT EXISTS (SELECT * FROM AD_Message_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Message_ID=t.AD_Message_ID)
;

-- Apr 28, 2014 12:07:58 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Message (AD_Client_ID,AD_Message_ID,AD_Org_ID,Created,CreatedBy,EntityType,IsActive,MsgText,MsgType,Updated,UpdatedBy,Value) VALUES (0,80008,0,TO_TIMESTAMP('2014-04-28 00:07:58','YYYY-MM-DD HH24:MI:SS'),100,'pasta','Y','Cannot found package no Or Package was shipped','E',TO_TIMESTAMP('2014-04-28 00:07:58','YYYY-MM-DD HH24:MI:SS'),100,'CannotFoundPackageNoOrPackageWasShipped Package No')
;

-- Apr 28, 2014 12:07:58 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Message_Trl (AD_Language,AD_Message_ID, MsgText,MsgTip, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Message_ID, t.MsgText,t.MsgTip, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Message t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Message_ID=80008 AND NOT EXISTS (SELECT * FROM AD_Message_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Message_ID=t.AD_Message_ID)
;

