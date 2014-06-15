-- May 31, 2014 12:50:53 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Message (AD_Client_ID,AD_Message_ID,AD_Org_ID,Created,CreatedBy,EntityType,IsActive,MsgText,MsgType,Updated,UpdatedBy,Value) VALUES (0,80017,0,TO_DATE('2014-05-31 12:50:52','YYYY-MM-DD HH24:MI:SS'),100,'pasta','Y','Please check your Client , Organization , Business partner, Price list and currency , They are not matched with reference tax invoice.','E',TO_DATE('2014-05-31 12:50:52','YYYY-MM-DD HH24:MI:SS'),100,'CREDIT_NOTE_INFO_NOT_MATCH_INVOICE')
;

-- May 31, 2014 12:50:53 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Message_Trl (AD_Language,AD_Message_ID, MsgText,MsgTip, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Message_ID, t.MsgText,t.MsgTip, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Message t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Message_ID=80017 AND NOT EXISTS (SELECT * FROM AD_Message_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Message_ID=t.AD_Message_ID)
;

-- May 31, 2014 12:51:57 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Message_Trl SET MsgText='กรุณาตรวจสอบชื่อ บริษัท, ฝ่าย/หน่วยงาน, ชื่อลูกค้า, สมุดราคา และสกุลเงิน ให้ตรงกันกับใบกำกับภาษีที่ต้องการอ้างอิง',Updated=TO_DATE('2014-05-31 12:51:57','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Message_ID=80017 AND AD_Language='th_TH'
;

-- May 31, 2014 12:53:50 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Message (AD_Client_ID,AD_Message_ID,AD_Org_ID,Created,CreatedBy,EntityType,IsActive,MsgText,MsgTip,MsgType,Updated,UpdatedBy,Value) VALUES (0,80018,0,TO_DATE('2014-05-31 12:53:49','YYYY-MM-DD HH24:MI:SS'),100,'pasta','Y','Credit Note should be open after Reference Invoice!','Credit Note Date is before Reference Invoice Date','E',TO_DATE('2014-05-31 12:53:49','YYYY-MM-DD HH24:MI:SS'),100,'CREDIT_NOTE_DATE_BEFORE_INVOICE_DATE')
;

-- May 31, 2014 12:53:50 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Message_Trl (AD_Language,AD_Message_ID, MsgText,MsgTip, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Message_ID, t.MsgText,t.MsgTip, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Message t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Message_ID=80018 AND NOT EXISTS (SELECT * FROM AD_Message_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Message_ID=t.AD_Message_ID)
;

