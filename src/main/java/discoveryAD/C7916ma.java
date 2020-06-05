package discoveryAD;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.p605ep.commonbase.api.Log;
import java.util.ArrayList;

/* renamed from: discoveryAD.ma */
public class C7916ma {
    private static final String TAG = "PermissionsUtil";
    /* renamed from: pe */
    public static final int f26917pe = -2;
    /* renamed from: qe */
    public static final int f26918qe = -1;
    /* renamed from: re */
    public static final int f26919re = 0;
    /* renamed from: se */
    public static final int f26920se = 1;

    /* renamed from: a */
    public static int m34329a(Context context, String... strArr) {
        return m34330a(context, strArr, new ArrayList());
    }

    /* renamed from: a */
    static int m34330a(Context context, String[] strArr, ArrayList<String> arrayList) {
        String str;
        if (!m34331jb()) {
            return 1;
        }
        if (context == null || strArr == null || strArr.length == 0 || arrayList == null) {
            return -2;
        }
        for (String str2 : strArr) {
            StringBuilder sb = new StringBuilder();
            sb.append("check permission ");
            sb.append(str2);
            String sb2 = sb.toString();
            String str3 = TAG;
            Log.m31483i(str3, sb2);
            if (-1 == context.checkCallingOrSelfPermission(str2)) {
                arrayList.add(str2);
                str = "check result - denied";
            } else {
                str = "check result - granted";
            }
            Log.m31483i(str3, str);
        }
        int size = arrayList.size();
        if (size == 0) {
            return 1;
        }
        return size < strArr.length ? 0 : -1;
    }

    /* renamed from: jb */
    public static boolean m34331jb() {
        return VERSION.SDK_INT >= 23;
    }
}
