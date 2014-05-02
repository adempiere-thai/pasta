-- Apr 28, 2014 9:17:59 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Message SET Value='CannotFoundPackageNoOrPackageWasShipped',Updated=TO_DATE('2014-04-28 21:17:59','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Message_ID=80008
;

-- Apr 28, 2014 9:22:06 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Message SET MsgText='Cannot Found Package Or Package Was Shipped',Updated=TO_DATE('2014-04-28 21:22:06','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Message_ID=80008
;

-- Apr 28, 2014 9:22:06 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Message_Trl SET IsTranslated='N' WHERE AD_Message_ID=80008
;
