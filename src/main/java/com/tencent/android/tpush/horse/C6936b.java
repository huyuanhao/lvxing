package com.tencent.android.tpush.horse;

import com.tencent.android.tpush.service.C6973b;
import com.tencent.android.tpush.service.p588a.C6971a;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.horse.b */
public class C6936b {
    /* renamed from: a */
    public static boolean m29628a(long j) {
        if (j != 0 && j + (m29627a() * 1000 * 60) > System.currentTimeMillis()) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public static long m29627a() {
        return (long) C6971a.m29749a(C6973b.m29776f()).f23158q;
    }

    /* renamed from: b */
    public static int m29629b() {
        return C6971a.m29749a(C6973b.m29776f()).f23156o;
    }

    /* renamed from: c */
    public static int m29630c() {
        return C6971a.m29749a(C6973b.m29776f()).f23157p;
    }
}
