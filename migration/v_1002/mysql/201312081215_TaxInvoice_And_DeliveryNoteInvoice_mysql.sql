-- Dec 7, 2013 7:27:02 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Sequence (AD_Client_ID,AD_Org_ID,AD_Sequence_ID,Created,CreatedBy,CurrentNext,CurrentNextSys,IncrementNo,IsActive,IsAudited,IsAutoSequence,IsTableID,Name,StartNewYear,StartNo,Updated,UpdatedBy) VALUES (1000003,1000005,1000615,TO_DATE('2013-12-07 19:27:02','YYYY-MM-DD HH24:MI:SS'),100,1000000,100,1,'Y','N','Y','N','(GBV) Tax Invoice Sequence','N',1000000,TO_DATE('2013-12-07 19:27:02','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Dec 7, 2013 7:28:28 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Sequence SET CurrentNext=1, DecimalPattern='000', Prefix='2013-',Updated=TO_DATE('2013-12-07 19:28:28','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Sequence_ID=1000615
;

-- Dec 7, 2013 7:28:50 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO C_DocType (AD_Client_ID,AD_Org_ID,C_DocType_ID,Created,CreatedBy,DocBaseType,DocNoSequence_ID,DocumentCopies,GL_Category_ID,HasCharges,HasProforma,IsActive,IsCreateCounter,IsDefault,IsDefaultCounterDoc,IsDocNoControlled,IsIndexed,IsInTransit,IsOverwriteDateOnComplete,IsOverwriteSeqOnComplete,IsPickQAConfirm,IsPrepareSplitDocument,IsShipConfirm,IsSOTrx,IsSplitWhenDifference,IsTaxInvoice,Name,PrintName,Updated,UpdatedBy) VALUES (1000003,1000005,1000128,TO_DATE('2013-12-07 19:28:50','YYYY-MM-DD HH24:MI:SS'),100,'ARI',1000615,1,1000015,'N','N','Y','Y','N','N','Y','Y','N','N','N','N','Y','N','Y','N','Y','(GBV) Tax Invoice','(GBV) Tax Invoice',TO_DATE('2013-12-07 19:28:50','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Dec 7, 2013 7:28:50 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO C_DocType_Trl (AD_Language,C_DocType_ID, DocumentNote,Name,PrintName, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.C_DocType_ID, t.DocumentNote,t.Name,t.PrintName, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, C_DocType t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.C_DocType_ID=1000128 AND NOT EXISTS (SELECT * FROM C_DocType_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.C_DocType_ID=t.C_DocType_ID)
;

-- Dec 7, 2013 7:28:50 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Document_Action_Access (AD_Client_ID,AD_Org_ID,IsActive,Created,CreatedBy,Updated,UpdatedBy,C_DocType_ID , AD_Ref_List_ID, AD_Role_ID) (SELECT 1000003,0,'Y', SysDate(),100, SysDate(),100, doctype.C_DocType_ID, action.AD_Ref_List_ID, rol.AD_Role_ID FROM AD_Client client INNER JOIN C_DocType doctype ON (doctype.AD_Client_ID=client.AD_Client_ID) INNER JOIN AD_Ref_List action ON (action.AD_Reference_ID=135) INNER JOIN AD_Role rol ON (rol.AD_Client_ID=client.AD_Client_ID) WHERE client.AD_Client_ID=1000003 AND doctype.C_DocType_ID=1000128 AND rol.IsManual='N')
;

-- Dec 7, 2013 7:33:00 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Sequence (AD_Client_ID,AD_Org_ID,AD_Sequence_ID,Created,CreatedBy,CurrentNext,CurrentNextSys,DecimalPattern,IncrementNo,IsActive,IsAudited,IsAutoSequence,IsTableID,Name,Prefix,StartNewYear,StartNo,Updated,UpdatedBy) VALUES (1000003,1000006,1000616,TO_DATE('2013-12-07 19:33:00','YYYY-MM-DD HH24:MI:SS'),100,1,100,'000',1,'Y','N','Y','N','(MNP) Tax Invoice Sequence','2013-','N',1000000,TO_DATE('2013-12-07 19:33:00','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Dec 7, 2013 7:33:18 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO C_DocType (AD_Client_ID,AD_Org_ID,C_DocType_ID,Created,CreatedBy,DocBaseType,DocNoSequence_ID,DocumentCopies,GL_Category_ID,HasCharges,HasProforma,IsActive,IsCreateCounter,IsDefault,IsDefaultCounterDoc,IsDocNoControlled,IsIndexed,IsInTransit,IsOverwriteDateOnComplete,IsOverwriteSeqOnComplete,IsPickQAConfirm,IsPrepareSplitDocument,IsShipConfirm,IsSOTrx,IsSplitWhenDifference,IsTaxInvoice,Name,PrintName,Updated,UpdatedBy) VALUES (1000003,1000006,1000129,TO_DATE('2013-12-07 19:33:18','YYYY-MM-DD HH24:MI:SS'),100,'ARI',1000616,1,1000015,'N','N','Y','Y','N','N','Y','Y','N','N','N','N','Y','N','Y','N','Y','(MNP) Tax Invoice','(MNP) Tax Invoice',TO_DATE('2013-12-07 19:33:18','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Dec 7, 2013 7:33:18 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO C_DocType_Trl (AD_Language,C_DocType_ID, DocumentNote,Name,PrintName, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.C_DocType_ID, t.DocumentNote,t.Name,t.PrintName, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, C_DocType t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.C_DocType_ID=1000129 AND NOT EXISTS (SELECT * FROM C_DocType_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.C_DocType_ID=t.C_DocType_ID)
;

-- Dec 7, 2013 7:33:18 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Document_Action_Access (AD_Client_ID,AD_Org_ID,IsActive,Created,CreatedBy,Updated,UpdatedBy,C_DocType_ID , AD_Ref_List_ID, AD_Role_ID) (SELECT 1000003,0,'Y', SysDate(),100, SysDate(),100, doctype.C_DocType_ID, action.AD_Ref_List_ID, rol.AD_Role_ID FROM AD_Client client INNER JOIN C_DocType doctype ON (doctype.AD_Client_ID=client.AD_Client_ID) INNER JOIN AD_Ref_List action ON (action.AD_Reference_ID=135) INNER JOIN AD_Role rol ON (rol.AD_Client_ID=client.AD_Client_ID) WHERE client.AD_Client_ID=1000003 AND doctype.C_DocType_ID=1000129 AND rol.IsManual='N')
;

