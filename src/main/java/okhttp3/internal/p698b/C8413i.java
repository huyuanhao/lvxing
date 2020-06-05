package okhttp3.internal.p698b;

import java.net.Proxy.Type;
import okhttp3.C8506t;
import okhttp3.C8518z;

/* compiled from: RequestLine */
/* renamed from: okhttp3.internal.b.i */
public final class C8413i {
    /* renamed from: a */
    public static String m36010a(C8518z zVar, Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(zVar.mo40646b());
        sb.append(' ');
        if (m36011b(zVar, type)) {
            sb.append(zVar.mo40645a());
        } else {
            sb.append(m36009a(zVar.mo40645a()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    /* renamed from: b */
    private static boolean m36011b(C8518z zVar, Type type) {
        return !zVar.mo40652g() && type == Type.HTTP;
    }

    /* renamed from: a */
    public static String m36009a(C8506t tVar) {
        String i = tVar.mo40560i();
        String l = tVar.mo40563l();
        if (l == null) {
            return i;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append('?');
        sb.append(l);
        return sb.toString();
    }
}
