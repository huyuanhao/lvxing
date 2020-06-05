package com.pgl.sys.ces;

import android.content.Context;
import com.p522qq.p523e.comm.constants.ErrorCode.OtherError;
import com.pgl.p359a.p361b.C4782a;
import com.pgl.sys.ces.p365a.C4796a;
import java.security.MessageDigest;
import java.util.Calendar;

/* renamed from: com.pgl.sys.ces.c */
public final class C4809c {
    /* renamed from: a */
    public static String m19676a() {
        try {
            Context applicationContext = C4804b.m19658a().f15459b != null ? C4804b.m19658a().f15459b : C4796a.m19631a().getApplicationContext();
            return C4782a.m19607a(MessageDigest.getInstance("SHA1").digest(applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 64).signatures[0].toByteArray())).toUpperCase();
        } catch (Throwable unused) {
            return "0000000000000000000000000000000000000000";
        }
    }

    /* renamed from: a */
    public static String m19677a(String str) {
        String str2 = "_";
        int timeInMillis = (int) (Calendar.getInstance().getTimeInMillis() / 1000);
        C4804b.m19658a();
        String b = C4804b.m19664b();
        String c = C4804b.m19665c();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(str2);
            sb.append(b);
            sb.append(str2);
            sb.append(c);
            sb.append(str2);
            sb.append(timeInMillis);
            return C4782a.m19607a((byte[]) C4795a.meta(OtherError.NETWORK_TYPE_ERROR, null, sb.toString().getBytes()));
        } catch (Throwable unused) {
            return "";
        }
    }
}
