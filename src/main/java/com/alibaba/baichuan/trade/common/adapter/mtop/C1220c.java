package com.alibaba.baichuan.trade.common.adapter.mtop;

import com.alibaba.baichuan.trade.common.adapter.mtop.C1221d.C1222a;
import java.io.Serializable;
import java.util.Map;

/* renamed from: com.alibaba.baichuan.trade.common.adapter.mtop.c */
public abstract class C1220c {
    /* renamed from: a */
    protected String f2508a = "";
    /* renamed from: b */
    protected String f2509b = "1.0";
    /* renamed from: c */
    protected boolean f2510c = false;
    /* renamed from: d */
    protected Boolean f2511d = Boolean.valueOf(false);
    /* renamed from: e */
    protected boolean f2512e = false;
    /* renamed from: f */
    protected boolean f2513f = true;
    /* renamed from: g */
    protected int f2514g = -1;

    /* renamed from: a */
    private NetworkRequest m2393a(Map<String, Serializable> map) {
        NetworkRequest networkRequest = new NetworkRequest();
        networkRequest.apiName = this.f2508a;
        networkRequest.apiVersion = this.f2509b;
        networkRequest.needLogin = this.f2510c;
        networkRequest.needWua = this.f2511d.booleanValue();
        networkRequest.needAuth = this.f2512e;
        networkRequest.isPost = this.f2513f;
        networkRequest.timeOut = this.f2514g;
        networkRequest.requestType = networkRequest.hashCode();
        networkRequest.paramMap = map;
        return networkRequest;
    }

    /* renamed from: a */
    public boolean mo10880a(Map<String, Serializable> map, C1222a aVar) {
        return C1213a.m2377a().mo10876a(aVar, m2393a(map));
    }
}
