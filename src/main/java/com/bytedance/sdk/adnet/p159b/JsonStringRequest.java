package com.bytedance.sdk.adnet.p159b;

import com.bytedance.sdk.adnet.core.C1982p;
import com.bytedance.sdk.adnet.core.C1982p.C1983a;
import com.bytedance.sdk.adnet.core.NetworkResponse;
import com.bytedance.sdk.adnet.err.ParseError;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.adnet.p161d.HttpHeaderParser;
import java.io.UnsupportedEncodingException;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.adnet.b.h */
public class JsonStringRequest extends JsonRequest<String> {
    public JsonStringRequest(int i, String str, JSONObject jSONObject, C1983a<String> aVar) {
        super(i, str, jSONObject == null ? null : jSONObject.toString(), aVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C1982p<String> mo14188a(NetworkResponse lVar) {
        try {
            return C1982p.m7917a(new String(lVar.f6275b, HttpHeaderParser.m7942a(lVar.f6276c, "utf-8")), HttpHeaderParser.m7939a(lVar));
        } catch (UnsupportedEncodingException e) {
            return C1982p.m7916a((VAdError) new ParseError((Throwable) e));
        }
    }
}
