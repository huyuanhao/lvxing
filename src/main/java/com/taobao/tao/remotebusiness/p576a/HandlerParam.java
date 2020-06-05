package com.taobao.tao.remotebusiness.p576a;

import com.taobao.tao.remotebusiness.MtopBusiness;
import java.io.Serializable;
import mtopsdk.mtop.common.MtopEvent;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.MtopResponse;

/* renamed from: com.taobao.tao.remotebusiness.a.c */
public final class HandlerParam implements Serializable {
    /* renamed from: a */
    public MtopListener f22563a;
    /* renamed from: b */
    public MtopEvent f22564b;
    /* renamed from: c */
    public BaseOutDo f22565c;
    /* renamed from: d */
    public MtopBusiness f22566d;
    /* renamed from: e */
    public MtopResponse f22567e;

    public HandlerParam(MtopListener gVar, MtopEvent dVar, MtopBusiness fVar) {
        this.f22563a = gVar;
        this.f22564b = dVar;
        this.f22566d = fVar;
    }
}
