package com.p530ss.android.downloadlib.p549e;

import android.text.TextUtils;
import com.p530ss.android.downloadlib.activity.TTDelegateActivity;
import com.p530ss.android.downloadlib.p541a.C6565j;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.ss.android.downloadlib.e.e */
public class PermissionUtils {
    /* renamed from: a */
    private static Map<String, C6586a> f21429a = Collections.synchronizedMap(new HashMap());

    /* compiled from: PermissionUtils */
    /* renamed from: com.ss.android.downloadlib.e.e$a */
    public interface C6586a {
        /* renamed from: a */
        void mo31347a();

        /* renamed from: a */
        void mo31348a(String str);
    }

    /* renamed from: a */
    public static void m26499a(String[] strArr, C6586a aVar) {
        if (strArr != null && strArr.length > 0) {
            String valueOf = String.valueOf(System.currentTimeMillis());
            m26497a(valueOf, aVar);
            TTDelegateActivity.m26394a(valueOf, strArr);
        }
    }

    /* renamed from: a */
    public static void m26496a(String str) {
        if (!TextUtils.isEmpty(str)) {
            C6586a c = m26501c(str);
            if (c != null) {
                c.mo31347a();
            }
        }
    }

    /* renamed from: a */
    public static void m26498a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            C6586a c = m26501c(str);
            if (c != null) {
                c.mo31348a(str2);
            }
        }
    }

    /* renamed from: a */
    private static void m26497a(String str, C6586a aVar) {
        if (!TextUtils.isEmpty(str) && aVar != null) {
            f21429a.put(str, aVar);
        }
    }

    /* renamed from: c */
    private static C6586a m26501c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (C6586a) f21429a.remove(str);
    }

    /* renamed from: b */
    public static boolean m26500b(String str) {
        return C6565j.m26372f().mo16482a(C6565j.m26357a(), str);
    }
}
