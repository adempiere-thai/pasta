-- Apr 14, 2011 1:26:15 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Process_Para SET DefaultValue='-1',Updated=TO_TIMESTAMP('2011-04-14 01:26:15','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Process_Para_ID=80001
;

-- Apr 14, 2011 1:27:32 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
DELETE FROM AD_Attachment WHERE AD_Attachment_ID=80000
;

-- Apr 14, 2011 1:28:12 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Attachment (AD_Attachment_ID,AD_Client_ID,AD_Org_ID,AD_Table_ID,Created,CreatedBy,IsActive,Record_ID,TextMsg,Title,Updated,UpdatedBy) VALUES (80001,0,0,284,TO_TIMESTAMP('2011-04-14 01:27:34','YYYY-MM-DD HH24:MI:SS'),100,'Y',80002,NULL,'zip',TO_TIMESTAMP('2011-04-14 01:27:34','YYYY-MM-DD HH24:MI:SS'),100)
;

