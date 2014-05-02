-- Apr 24, 2014 10:15:23 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Val_Rule (AD_Client_ID,AD_Org_ID,AD_Val_Rule_ID,Code,Created,CreatedBy,EntityType,IsActive,Name,Type,Updated,UpdatedBy) VALUES (0,0,80007,'(C_Order.IsSOTrx=''@IsSOTrx@'' AND C_Order.DocStatus=''CO'') AND C_Order.AD_Org_ID = @AD_Org_ID@',TO_TIMESTAMP('2014-04-24 22:15:23','YYYY-MM-DD HH24:MI:SS'),100,'pasta','Y','C_Order in Pick List AD_Org','S',TO_TIMESTAMP('2014-04-24 22:15:23','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Apr 24, 2014 10:15:35 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Process_Para SET AD_Val_Rule_ID=80007,Updated=TO_TIMESTAMP('2014-04-24 22:15:35','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Process_Para_ID=80049
;

-- Apr 24, 2014 10:24:28 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Menu SET Name='พิมพ์ GBV_ใบจัดของ',Updated=TO_TIMESTAMP('2014-04-24 22:24:28','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Menu_ID=80042
;

-- Apr 24, 2014 10:24:28 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Menu_Trl SET IsTranslated='N' WHERE AD_Menu_ID=80042
;

-- Apr 24, 2014 10:30:40 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Menu SET Name='GBV_Package',Updated=TO_TIMESTAMP('2014-04-24 22:30:40','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Menu_ID=80041
;

-- Apr 24, 2014 10:30:40 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Menu_Trl SET IsTranslated='N' WHERE AD_Menu_ID=80041
;

-- Apr 24, 2014 10:31:13 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Tab SET IsInsertRecord='N',Updated=TO_TIMESTAMP('2014-04-24 22:31:13','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tab_ID=80014
;

-- Apr 24, 2014 10:31:31 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Tab SET IsReadOnly='Y',Updated=TO_TIMESTAMP('2014-04-24 22:31:31','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tab_ID=80014
;

-- Apr 24, 2014 10:31:36 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Tab SET IsReadOnly='N',Updated=TO_TIMESTAMP('2014-04-24 22:31:36','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tab_ID=80014
;

-- Apr 24, 2014 10:31:44 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET IsReadOnly='Y',Updated=TO_TIMESTAMP('2014-04-24 22:31:44','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=80311
;

-- Apr 24, 2014 10:31:47 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET IsReadOnly='Y',Updated=TO_TIMESTAMP('2014-04-24 22:31:47','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=80309
;

-- Apr 24, 2014 10:31:50 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET IsReadOnly='Y',Updated=TO_TIMESTAMP('2014-04-24 22:31:50','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=80310
;

-- Apr 24, 2014 10:31:56 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET IsReadOnly='Y',Updated=TO_TIMESTAMP('2014-04-24 22:31:56','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=80325
;

-- Apr 24, 2014 10:31:58 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET IsReadOnly='Y',Updated=TO_TIMESTAMP('2014-04-24 22:31:58','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=80313
;

-- Apr 24, 2014 10:32:02 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET IsReadOnly='Y',Updated=TO_TIMESTAMP('2014-04-24 22:32:02','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=80314
;

-- Apr 24, 2014 10:32:09 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET IsReadOnly='Y',Updated=TO_TIMESTAMP('2014-04-24 22:32:09','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=80306
;

-- Apr 24, 2014 10:32:13 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET IsReadOnly='Y',Updated=TO_TIMESTAMP('2014-04-24 22:32:13','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=80316
;

-- Apr 24, 2014 10:32:23 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Tab SET IsInsertRecord='N', IsReadOnly='Y',Updated=TO_TIMESTAMP('2014-04-24 22:32:23','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tab_ID=80015
;

