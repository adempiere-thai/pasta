-- Aug 6, 2011 3:26:44 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Process (AD_Client_ID,AD_Org_ID,AD_Process_ID,AccessLevel,CopyFromProcess,Created,CreatedBy,EntityType,IsActive,IsBetaFunctionality,IsDirectPrint,IsReport,IsServerProcess,Name,ShowHelp,Statistic_Count,Statistic_Seconds,Updated,UpdatedBy,Value) VALUES (0,0,80007,'1','N',TO_TIMESTAMP('2011-08-06 15:26:44','YYYY-MM-DD HH24:MI:SS'),100,'pasta','Y','N','N','Y','N','ใบส่งของช่าง','Y',0,0,TO_TIMESTAMP('2011-08-06 15:26:44','YYYY-MM-DD HH24:MI:SS'),100,'shipment')
;

-- Aug 6, 2011 3:26:44 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Process_Trl (AD_Language,AD_Process_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Process_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Process t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Process_ID=80007 AND NOT EXISTS (SELECT * FROM AD_Process_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Process_ID=t.AD_Process_ID)
;

-- Aug 6, 2011 3:27:17 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Attachment (AD_Attachment_ID,AD_Client_ID,AD_Org_ID,AD_Table_ID,Created,CreatedBy,IsActive,Record_ID,TextMsg,Title,Updated,UpdatedBy) VALUES (80004,0,0,284,TO_TIMESTAMP('2011-08-06 15:26:51','YYYY-MM-DD HH24:MI:SS'),100,'Y',80007,NULL,'zip',TO_TIMESTAMP('2011-08-06 15:26:51','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Aug 6, 2011 3:29:51 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Process SET JasperReport='attachment:shipmentFrm.jrxml',Updated=TO_TIMESTAMP('2011-08-06 15:29:51','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Process_ID=80007
;

-- Aug 6, 2011 3:30:10 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_PrintFormat SET JasperProcess_ID=80007,Updated=TO_TIMESTAMP('2011-08-06 15:30:10','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_PrintFormat_ID=104
;

