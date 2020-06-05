package com.alipay.android.phone.mrpc.core.p102a;

import com.alipay.android.phone.mrpc.core.RpcException;
import com.alipay.p099a.p100a.C1387f;
import java.util.ArrayList;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

/* renamed from: com.alipay.android.phone.mrpc.core.a.e */
public final class C1402e extends C1399b {
    /* renamed from: c */
    private int f3608c;
    /* renamed from: d */
    private Object f3609d;

    public C1402e(int i, String str, Object obj) {
        super(str, obj);
        this.f3608c = i;
    }

    /* renamed from: a */
    public final void mo11935a(Object obj) {
        this.f3609d = obj;
    }

    /* renamed from: a */
    public final byte[] mo11936a() {
        try {
            ArrayList arrayList = new ArrayList();
            if (this.f3609d != null) {
                arrayList.add(new BasicNameValuePair("extParam", C1387f.m4046a(this.f3609d)));
            }
            arrayList.add(new BasicNameValuePair("operationType", this.f3606a));
            StringBuilder sb = new StringBuilder();
            sb.append(this.f3608c);
            arrayList.add(new BasicNameValuePair("id", sb.toString()));
            new StringBuilder("mParams is:").append(this.f3607b);
            arrayList.add(new BasicNameValuePair("requestData", this.f3607b == null ? "[]" : C1387f.m4046a(this.f3607b)));
            return URLEncodedUtils.format(arrayList, "utf-8").getBytes();
        } catch (Exception e) {
            Integer valueOf = Integer.valueOf(9);
            StringBuilder sb2 = new StringBuilder("request  =");
            sb2.append(this.f3607b);
            sb2.append(":");
            sb2.append(e);
            throw new RpcException(valueOf, sb2.toString() == null ? "" : e.getMessage(), e);
        }
    }
}
