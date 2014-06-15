-- May 31, 2014 1:29:04 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET IsReadOnly='Y',Updated=TO_TIMESTAMP('2014-05-31 13:29:04','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=80271
;

-- May 31, 2014 1:29:10 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET IsReadOnly='Y',Updated=TO_TIMESTAMP('2014-05-31 13:29:10','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=80272
;

-- May 31, 2014 2:05:49 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET IsDisplayed='N',Updated=TO_TIMESTAMP('2014-05-31 14:05:49','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=57746
;

-- May 31, 2014 2:06:06 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET IsDisplayed='N',Updated=TO_TIMESTAMP('2014-05-31 14:06:06','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=57738
;

-- May 31, 2014 2:29:00 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Column SET EntityType='pasta',Updated=TO_TIMESTAMP('2014-05-31 14:29:00','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=80054
;

-- May 31, 2014 2:54:02 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Val_Rule (AD_Client_ID,AD_Org_ID,AD_Val_Rule_ID,Code,Created,CreatedBy,EntityType,IsActive,Name,Type,Updated,UpdatedBy) VALUES (0,0,80008,'NOT EXISTS (SELECT 1 FROM M_InOut io WHERE io.MovementType = ''C+'' AND io.DocStatus = ''CO'' AND M_RMA.M_RMA_ID = io.M_RMA_ID)',TO_TIMESTAMP('2014-05-31 14:54:02','YYYY-MM-DD HH24:MI:SS'),100,'pasta','Y','RMA was not created','S',TO_TIMESTAMP('2014-05-31 14:54:02','YYYY-MM-DD HH24:MI:SS'),100)
;

-- May 31, 2014 2:56:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET AD_Reference_ID=30,Updated=TO_TIMESTAMP('2014-05-31 14:56:33','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=57713
;

-- May 31, 2014 2:57:06 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Val_Rule (AD_Client_ID,AD_Org_ID,AD_Val_Rule_ID,Code,Created,CreatedBy,EntityType,IsActive,Name,Type,Updated,UpdatedBy) VALUES (0,0,80014,'NOT EXISTS (SELECT 1 FROM M_InOut io WHERE io.MovementType = ''C+'' AND io.DocStatus = ''CO'' AND M_RMA.M_RMA_ID = io.M_RMA_ID)',TO_TIMESTAMP('2014-05-31 14:57:06','YYYY-MM-DD HH24:MI:SS'),100,'pasta','Y','RMA was not created','S',TO_TIMESTAMP('2014-05-31 14:57:06','YYYY-MM-DD HH24:MI:SS'),100)
;

-- May 31, 2014 2:57:28 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET AD_Val_Rule_ID=80014,Updated=TO_TIMESTAMP('2014-05-31 14:57:28','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=57713
;

-- May 31, 2014 2:57:42 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Val_Rule SET Code='NOT EXISTS (SELECT 1 FROM M_InOut io WHERE io.MovementType = ''C+'' AND io.DocStatus = ''CO'' AND M_RMA.M_RMA_ID = io.M_RMA_ID AND io.DocStatus=''CO'')',Updated=TO_TIMESTAMP('2014-05-31 14:57:42','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Val_Rule_ID=80014
;

