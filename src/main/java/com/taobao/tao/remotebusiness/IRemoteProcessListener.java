package com.taobao.tao.remotebusiness;

import mtopsdk.mtop.common.MtopHeaderEvent;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.common.MtopProgressEvent;

/* renamed from: com.taobao.tao.remotebusiness.e */
public interface IRemoteProcessListener extends MtopListener {
    /* renamed from: a */
    void mo32727a(MtopHeaderEvent fVar, Object obj);

    /* renamed from: a */
    void mo32728a(MtopProgressEvent hVar, Object obj);
}
