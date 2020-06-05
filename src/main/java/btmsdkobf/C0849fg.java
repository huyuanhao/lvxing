package btmsdkobf;

import android.util.Log;

/* renamed from: btmsdkobf.fg */
public class C0849fg {
    /* renamed from: bA */
    private static boolean f983bA = false;

    /* renamed from: a */
    private static void m909a(int i, String str, String str2) {
        if (f983bA) {
            if (str2 == null) {
                str2 = "(null)";
            }
            StringBuilder sb = new StringBuilder();
            sb.append("TMSDK_SK_");
            sb.append(str);
            Log.println(i, sb.toString(), str2);
        }
    }

    /* renamed from: a */
    public static void m910a(String str, String str2, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(th.getMessage());
        m909a(6, str, sb.toString());
    }

    /* renamed from: d */
    public static void m911d(String str, String str2) {
        m909a(3, str, str2);
    }

    /* renamed from: e */
    public static void m912e(String str, String str2) {
        m909a(6, str, str2);
    }

    /* renamed from: e */
    public static void m913e(String str, String str2, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(th.getMessage());
        m909a(6, str, sb.toString());
    }

    /* renamed from: i */
    public static void m914i(String str, String str2) {
        m909a(4, str, str2);
    }

    /* renamed from: v */
    public static void m915v(String str, String str2) {
        m909a(2, str, str2);
    }

    /* renamed from: w */
    public static void m916w(String str, String str2) {
        m909a(5, str, str2);
    }
}
