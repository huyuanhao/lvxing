package com.bytedance.sdk.adnet.p159b;

import com.bytedance.sdk.adnet.core.C1982p;
import com.bytedance.sdk.adnet.core.C1982p.C1983a;
import com.bytedance.sdk.adnet.core.NetworkResponse;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.p161d.HttpHeaderParser;
import java.io.UnsupportedEncodingException;

/* renamed from: com.bytedance.sdk.adnet.b.j */
public class StringRequest extends Request<String> {
    /* renamed from: c */
    private final Object f6145c = new Object();
    /* renamed from: d */
    private C1983a<String> f6146d;

    public StringRequest(int i, String str, C1983a<String> aVar) {
        super(i, str, aVar);
        this.f6146d = aVar;
    }

    public void cancel() {
        super.cancel();
        synchronized (this.f6145c) {
            this.f6146d = null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo14190a(C1982p<String> pVar) {
        C1983a<String> aVar;
        synchronized (this.f6145c) {
            aVar = this.f6146d;
        }
        if (aVar != null) {
            aVar.mo14171a(pVar);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C1982p<String> mo14188a(NetworkResponse lVar) {
        String str;
        try {
            str = new String(lVar.f6275b, HttpHeaderParser.m7941a(lVar.f6276c));
        } catch (UnsupportedEncodingException unused) {
            str = new String(lVar.f6275b);
        }
        return C1982p.m7917a(str, HttpHeaderParser.m7939a(lVar));
    }
}
