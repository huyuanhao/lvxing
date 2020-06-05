package discoveryAD;

/* renamed from: discoveryAD.e */
public class C7895e {
    /* renamed from: Bc */
    public static final int f26887Bc = 3600000;
    /* renamed from: Cc */
    public static final int f26888Cc = 120000;

    /* renamed from: J */
    public static boolean m34311J(int i) {
        long O = C7862G.getInstance().mo38133fb().mo38204O(i);
        return O < System.currentTimeMillis() || O - System.currentTimeMillis() > 3600000;
    }

    /* renamed from: K */
    public static boolean m34312K(int i) {
        boolean N = C7862G.getInstance().mo38133fb().mo38203N(i);
        StringBuilder sb = new StringBuilder();
        sb.append("getPreRequestResult() positionId=");
        sb.append(i);
        sb.append(" state=");
        sb.append(N);
        C7852Aa.m34153d(sb.toString());
        return N;
    }

    /* renamed from: a */
    public static void m34313a(int i, boolean z) {
        C7862G.getInstance().mo38133fb().mo38207b(i, z);
    }

    /* renamed from: c */
    public static void m34314c(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("updateRequestTime() positionId=");
        sb.append(i);
        C7852Aa.m34153d(sb.toString());
        C7862G.getInstance().mo38133fb().mo38206a(i, System.currentTimeMillis() + ((long) i2));
    }
}
