-- Apr 7, 2013 1:08:25 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Process_Para SET AD_Val_Rule_ID=133,Updated=TO_DATE('2013-04-07 13:08:25','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=0 WHERE AD_Process_Para_ID=670
;

-- Apr 7, 2013 1:09:54 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Menu SET IsSOTrx='Y',Updated=TO_DATE('2013-04-07 13:09:54','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=0 WHERE AD_Menu_ID=543
;

-- Apr 7, 2013 1:10:22 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Menu (Action,AD_Client_ID,AD_Menu_ID,AD_Org_ID,AD_Process_ID,Created,CreatedBy,Description,EntityType,IsActive,IsCentrallyMaintained,IsReadOnly,IsSOTrx,IsSummary,Name,Updated,UpdatedBy) VALUES ('R',0,80035,0,333,TO_DATE('2013-04-07 13:10:22','YYYY-MM-DD HH24:MI:SS'),0,'Purchase Order Detail','pasta','Y','Y','N','N','N','Purchase Order Detail',TO_DATE('2013-04-07 13:10:22','YYYY-MM-DD HH24:MI:SS'),0)
;

-- Apr 7, 2013 1:10:22 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Menu_Trl (AD_Language,AD_Menu_ID, Description,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Menu_ID, t.Description,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Menu t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Menu_ID=80035 AND NOT EXISTS (SELECT * FROM AD_Menu_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Menu_ID=t.AD_Menu_ID)
;

-- Apr 7, 2013 1:10:22 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_TreeNodeMM (AD_Client_ID,AD_Org_ID, IsActive,Created,CreatedBy,Updated,UpdatedBy, AD_Tree_ID, Node_ID, Parent_ID, SeqNo) SELECT t.AD_Client_ID, 0, 'Y', SysDate(), 0, SysDate(), 0,t.AD_Tree_ID, 80035, 0, 999 FROM AD_Tree t WHERE t.AD_Client_ID=0 AND t.IsActive='Y' AND t.IsAllNodes='Y' AND t.TreeType='MM' AND NOT EXISTS (SELECT * FROM AD_TreeNodeMM e WHERE e.AD_Tree_ID=t.AD_Tree_ID AND Node_ID=80035)
;

-- Apr 7, 2013 1:10:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=203, SeqNo=0, Updated=SysDate() WHERE AD_Tree_ID=10 AND Node_ID=452
;

-- Apr 7, 2013 1:10:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=203, SeqNo=1, Updated=SysDate() WHERE AD_Tree_ID=10 AND Node_ID=454
;

-- Apr 7, 2013 1:10:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=203, SeqNo=2, Updated=SysDate() WHERE AD_Tree_ID=10 AND Node_ID=466
;

-- Apr 7, 2013 1:10:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=203, SeqNo=3, Updated=SysDate() WHERE AD_Tree_ID=10 AND Node_ID=468
;

-- Apr 7, 2013 1:10:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=203, SeqNo=4, Updated=SysDate() WHERE AD_Tree_ID=10 AND Node_ID=467
;

-- Apr 7, 2013 1:10:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=203, SeqNo=5, Updated=SysDate() WHERE AD_Tree_ID=10 AND Node_ID=463
;

-- Apr 7, 2013 1:10:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=203, SeqNo=6, Updated=SysDate() WHERE AD_Tree_ID=10 AND Node_ID=549
;

-- Apr 7, 2013 1:10:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=203, SeqNo=7, Updated=SysDate() WHERE AD_Tree_ID=10 AND Node_ID=471
;

-- Apr 7, 2013 1:10:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=203, SeqNo=8, Updated=SysDate() WHERE AD_Tree_ID=10 AND Node_ID=205
;

-- Apr 7, 2013 1:10:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=203, SeqNo=9, Updated=SysDate() WHERE AD_Tree_ID=10 AND Node_ID=80035
;

-- Apr 7, 2013 1:10:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=203, SeqNo=10, Updated=SysDate() WHERE AD_Tree_ID=10 AND Node_ID=204
;

-- Apr 7, 2013 1:10:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=203, SeqNo=11, Updated=SysDate() WHERE AD_Tree_ID=10 AND Node_ID=493
;

-- Apr 7, 2013 1:10:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=203, SeqNo=12, Updated=SysDate() WHERE AD_Tree_ID=10 AND Node_ID=206
;

-- Apr 7, 2013 1:10:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=203, SeqNo=13, Updated=SysDate() WHERE AD_Tree_ID=10 AND Node_ID=360
;

-- Apr 7, 2013 1:10:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=203, SeqNo=14, Updated=SysDate() WHERE AD_Tree_ID=10 AND Node_ID=516
;

-- Apr 7, 2013 1:10:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=203, SeqNo=15, Updated=SysDate() WHERE AD_Tree_ID=10 AND Node_ID=312
;

-- Apr 7, 2013 1:10:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=203, SeqNo=16, Updated=SysDate() WHERE AD_Tree_ID=10 AND Node_ID=316
;

-- Apr 7, 2013 1:10:33 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=203, SeqNo=17, Updated=SysDate() WHERE AD_Tree_ID=10 AND Node_ID=315
;

