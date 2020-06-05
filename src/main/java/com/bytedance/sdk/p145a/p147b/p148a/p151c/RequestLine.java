package com.bytedance.sdk.p145a.p147b.p148a.p151c;

import com.bytedance.sdk.p145a.p147b.C1918ab;
import com.bytedance.sdk.p145a.p147b.HttpUrl;
import java.net.Proxy.Type;

/* renamed from: com.bytedance.sdk.a.b.a.c.i */
public final class RequestLine {
    /* renamed from: a */
    public static String m7017a(C1918ab abVar, Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(abVar.mo13912b());
        sb.append(' ');
        if (m7019b(abVar, type)) {
            sb.append(abVar.mo13910a());
        } else {
            sb.append(m7018a(abVar.mo13910a()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    /* renamed from: b */
    private static boolean m7019b(C1918ab abVar, Type type) {
        return !abVar.mo13917g() && type == Type.HTTP;
    }

    /* renamed from: a */
    public static String m7018a(HttpUrl vVar) {
        String h = vVar.mo14094h();
        String j = vVar.mo14097j();
        if (j == null) {
            return h;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(h);
        sb.append('?');
        sb.append(j);
        return sb.toString();
    }
}
