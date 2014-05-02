-- Mar 19, 2014 11:16:46 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Val_Rule SET Code='(C_Order.IsSOTrx=''@IsSOTrx@'' AND C_Order.DocStatus=''CO'') AND EXISTS (SELECT 1 FROM M_Picklist p WHERE p.C_Order_ID =C_Order.C_Order_ID) ', Name='C_Order in Pick List (Complete and IsSOTrx)',Updated=TO_DATE('2014-03-19 23:16:46','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Val_Rule_ID=80012
;

-- Mar 19, 2014 11:17:09 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Process_Para SET SeqNo=30,Updated=TO_DATE('2014-03-19 23:17:09','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Process_Para_ID=80051
;

-- Mar 19, 2014 11:17:18 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Process_Para SET SeqNo=40,Updated=TO_DATE('2014-03-19 23:17:18','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Process_Para_ID=80051
;

-- Mar 19, 2014 11:23:25 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
DELETE  FROM  AD_Process_Para_Trl WHERE AD_Process_Para_ID=80074
;

-- Mar 19, 2014 11:23:25 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
DELETE FROM AD_Process_Para WHERE AD_Process_Para_ID=80074
;

-- Mar 19, 2014 11:23:31 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Process_Para SET SeqNo=30,Updated=TO_DATE('2014-03-19 23:23:31','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Process_Para_ID=80075
;

-- Mar 19, 2014 11:23:48 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Process_Para SET AD_Val_Rule_ID=80012,Updated=TO_DATE('2014-03-19 23:23:48','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Process_Para_ID=80075
;

-- Mar 19, 2014 11:24:07 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Process_Para SET SeqNo=40,Updated=TO_DATE('2014-03-19 23:24:07','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Process_Para_ID=80076
;

