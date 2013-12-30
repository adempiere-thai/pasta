-- Dec 21, 2013 11:37:44 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_SysConfig (AD_Client_ID,AD_Org_ID,AD_SysConfig_ID,ConfigurationLevel,Created,CreatedBy,EntityType,IsActive,Name,Updated,UpdatedBy,Value) VALUES (0,0,80004,'C',TO_DATE('2013-12-21 23:37:44','YYYY-MM-DD HH24:MI:SS'),100,'pasta','Y','ASK_TO_PRINT_FORM',TO_DATE('2013-12-21 23:37:44','YYYY-MM-DD HH24:MI:SS'),100,'N')
;

-- Dec 21, 2013 11:37:48 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_SysConfig SET ConfigurationLevel='S',Updated=TO_DATE('2013-12-21 23:37:48','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_SysConfig_ID=80004
;

