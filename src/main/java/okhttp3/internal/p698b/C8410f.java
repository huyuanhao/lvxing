package okhttp3.internal.p698b;

/* compiled from: HttpMethod */
/* renamed from: okhttp3.internal.b.f */
public final class C8410f {
    /* renamed from: a */
    public static boolean m35990a(String str) {
        return str.equals("POST") || str.equals("PATCH") || str.equals("PUT") || str.equals("DELETE") || str.equals("MOVE");
    }

    /* renamed from: b */
    public static boolean m35991b(String str) {
        return str.equals("POST") || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT");
    }

    /* renamed from: c */
    public static boolean m35992c(String str) {
        return !str.equals("GET") && !str.equals("HEAD");
    }

    /* renamed from: d */
    public static boolean m35993d(String str) {
        return str.equals("PROPFIND");
    }

    /* renamed from: e */
    public static boolean m35994e(String str) {
        return !str.equals("PROPFIND");
    }
}
