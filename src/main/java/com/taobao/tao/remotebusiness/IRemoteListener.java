package com.taobao.tao.remotebusiness;

import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.MtopResponse;

@Deprecated
/* renamed from: com.taobao.tao.remotebusiness.c */
public interface IRemoteListener extends MtopListener {
    /* renamed from: a */
    void mo10878a(int i, MtopResponse mtopResponse, BaseOutDo aVar, Object obj);

    /* renamed from: b */
    void mo10879b(int i, MtopResponse mtopResponse, Object obj);
}
