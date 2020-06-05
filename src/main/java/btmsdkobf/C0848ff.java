package btmsdkobf;

import android.util.Log;

/* renamed from: btmsdkobf.ff */
public final class C0848ff {
    /* renamed from: bA */
    private static boolean f982bA = true;

    /* renamed from: a */
    static void m904a(int i, String str, String str2) {
        if (f982bA) {
            if (str2 == null) {
                str2 = "(null)";
            }
            StringBuilder sb = new StringBuilder();
            sb.append("TMSDK_");
            sb.append(str);
            Log.println(i, sb.toString(), str2);
        }
    }

    /* renamed from: d */
    public static void m905d(String str, String str2) {
        m904a(3, str, str2);
    }

    /* renamed from: e */
    public static void m906e(String str, String str2) {
        m904a(6, str, str2);
    }

    /* renamed from: i */
    public static void m907i(String str, String str2) {
        m904a(4, str, str2);
    }

    public static void setLogEnable(boolean z) {
        f982bA = z;
    }

    /* renamed from: w */
    public static void m908w(String str, String str2) {
        m904a(5, str, str2);
    }
}
