package com.bytedance.sdk.adnet.p159b;

import com.bytedance.sdk.adnet.core.C1982p;
import com.bytedance.sdk.adnet.core.C1982p.C1983a;
import com.bytedance.sdk.adnet.core.NetworkResponse;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.VNetLog;
import java.io.UnsupportedEncodingException;

/* renamed from: com.bytedance.sdk.adnet.b.g */
public abstract class JsonRequest<T> extends Request<T> {
    /* renamed from: c */
    private static final String f6138c = String.format("application/json; charset=%s", new Object[]{"utf-8"});
    /* renamed from: d */
    private final Object f6139d = new Object();
    /* renamed from: e */
    private C1983a<T> f6140e;
    /* renamed from: f */
    private final String f6141f;

    /* renamed from: a */
    public abstract C1982p<T> mo14188a(NetworkResponse lVar);

    public JsonRequest(int i, String str, String str2, C1983a<T> aVar) {
        super(i, str, aVar);
        this.f6140e = aVar;
        this.f6141f = str2;
    }

    public void cancel() {
        super.cancel();
        synchronized (this.f6139d) {
            this.f6140e = null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo14190a(C1982p<T> pVar) {
        C1983a<T> aVar;
        synchronized (this.f6139d) {
            aVar = this.f6140e;
        }
        if (aVar != null) {
            aVar.mo14171a(pVar);
        }
    }

    @Deprecated
    public byte[] getPostBody() {
        return getBody();
    }

    public String getBodyContentType() {
        return f6138c;
    }

    public byte[] getBody() {
        String str = "utf-8";
        byte[] bArr = null;
        try {
            if (this.f6141f != null) {
                bArr = this.f6141f.getBytes(str);
            }
            return bArr;
        } catch (UnsupportedEncodingException unused) {
            VNetLog.m7930d("Unsupported Encoding while trying to get the bytes of %s using %s", this.f6141f, str);
            return null;
        }
    }
}
