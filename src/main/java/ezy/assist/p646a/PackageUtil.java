package ezy.assist.p646a;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;

/* renamed from: ezy.assist.a.a */
public class PackageUtil {
    /* renamed from: a */
    public static synchronized boolean m34782a(Context context, String str) {
        boolean z;
        synchronized (PackageUtil.class) {
            z = false;
            try {
                if (context.getPackageManager().getPackageInfo(str, 64) != null) {
                    z = true;
                }
            } catch (NameNotFoundException e) {
                e.printStackTrace();
                return false;
            }
        }
        return z;
    }
}
