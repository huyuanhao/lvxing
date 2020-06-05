package com.bumptech.glide.p134d;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.bumptech.glide.load.Key;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: com.bumptech.glide.d.a */
public final class ApplicationVersionSignature {
    /* renamed from: a */
    private static final ConcurrentMap<String, Key> f4259a = new ConcurrentHashMap();

    /* renamed from: a */
    public static Key m5164a(Context context) {
        String packageName = context.getPackageName();
        Key cVar = (Key) f4259a.get(packageName);
        if (cVar != null) {
            return cVar;
        }
        Key b = m5166b(context);
        Key cVar2 = (Key) f4259a.putIfAbsent(packageName, b);
        return cVar2 == null ? b : cVar2;
    }

    /* renamed from: b */
    private static Key m5166b(Context context) {
        return new ObjectKey(m5165a(m5167c(context)));
    }

    /* renamed from: a */
    private static String m5165a(PackageInfo packageInfo) {
        if (packageInfo != null) {
            return String.valueOf(packageInfo.versionCode);
        }
        return UUID.randomUUID().toString();
    }

    /* JADX WARNING: type inference failed for: r3v1, types: [android.content.Context] */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: c */
    private static android.content.pm.PackageInfo m5167c(android.content.Context r3) {
        /*
        android.content.pm.PackageManager r0 = r3.getPackageManager()     // Catch:{ NameNotFoundException -> 0x000e }
        java.lang.String r1 = r3.getPackageName()     // Catch:{ NameNotFoundException -> 0x000e }
        r2 = 0
        android.content.pm.PackageInfo r3 = r0.getPackageInfo(r1, r2)     // Catch:{ NameNotFoundException -> 0x000e }
        return r3
    L_0x000e:
        r0 = move-exception
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        java.lang.String r2 = "Cannot resolve info for"
        r1.append(r2)
        java.lang.String r3 = r3.getPackageName()
        r1.append(r3)
        java.lang.String r3 = r1.toString()
        java.lang.String r1 = "AppVersionSignature"
        android.util.Log.e(r1, r3, r0)
        r3 = 0
        return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.p134d.ApplicationVersionSignature.m5167c(android.content.Context):android.content.pm.PackageInfo");
    }
}
