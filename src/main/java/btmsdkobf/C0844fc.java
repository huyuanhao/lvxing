package btmsdkobf;

import android.content.Context;

/* renamed from: btmsdkobf.fc */
public class C0844fc {
    /* renamed from: C */
    public static int m896C(String str) {
        if (str == null) {
            return -1;
        }
        if (str.startsWith("46000") || str.startsWith("46002") || str.startsWith("46007")) {
            return 0;
        }
        if (str.startsWith("46001")) {
            return 1;
        }
        return str.startsWith("46003") ? 2 : -1;
    }

    /* renamed from: b */
    public static int m897b(Context context, String str) {
        return m896C(str);
    }
}
