package com.taobao.tao.remotebusiness.p577b;

import com.taobao.tao.remotebusiness.IRemoteCacheListener;
import com.taobao.tao.remotebusiness.IRemoteProcessListener;
import com.taobao.tao.remotebusiness.MtopBusiness;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import mtopsdk.mtop.common.ApiID;
import mtopsdk.mtop.common.MtopCallback.C8332a;
import mtopsdk.mtop.common.MtopCallback.C8333b;
import mtopsdk.mtop.common.MtopCallback.C8334c;
import mtopsdk.mtop.common.MtopCallback.C8335d;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.common.MtopNetworkProp;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.p690b.Mtop;
import mtopsdk.mtop.p690b.MtopBuilder;
import mtopsdk.mtop.util.MtopStatistics;

/* renamed from: com.taobao.tao.remotebusiness.b.e */
public class MtopListenerProxyFactory {
    /* renamed from: a */
    public Mtop f22575a;
    /* renamed from: b */
    public MtopRequest f22576b;
    /* renamed from: c */
    public MtopResponse f22577c;
    /* renamed from: d */
    public MtopNetworkProp f22578d = new MtopNetworkProp();
    /* renamed from: e */
    public MtopListener f22579e;
    /* renamed from: f */
    public ApiID f22580f;
    /* renamed from: g */
    public MtopStatistics f22581g;
    /* renamed from: h */
    public String f22582h;
    /* renamed from: i */
    public MtopBuilder f22583i;

    /* renamed from: a */
    public static MtopListener m29127a(MtopBusiness fVar, MtopListener gVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(C8333b.class);
        if (gVar instanceof IRemoteProcessListener) {
            arrayList.add(C8335d.class);
            arrayList.add(C8334c.class);
        }
        if ((gVar instanceof IRemoteCacheListener) || fVar.f27899k.useCache) {
            arrayList.add(C8332a.class);
        }
        return (MtopListener) Proxy.newProxyInstance(MtopListener.class.getClassLoader(), (Class[]) arrayList.toArray(new Class[arrayList.size()]), new DynamicProxyHandler(fVar, gVar));
    }
}
