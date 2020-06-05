package com.qiyukf.basesdk.p412c;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.SparseArray;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.qiyukf.basesdk.p393a.C5264a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.qiyukf.basesdk.c.c */
public final class C5399c {
    /* renamed from: a */
    private static AtomicInteger f17365a = new AtomicInteger(0);
    /* renamed from: b */
    private static SparseArray<C5400a> f17366b = new SparseArray<>();
    /* renamed from: c */
    private static Set<String> f17367c;
    /* renamed from: d */
    private Object f17368d;
    /* renamed from: e */
    private String[] f17369e;
    /* renamed from: f */
    private C5400a f17370f;

    /* renamed from: com.qiyukf.basesdk.c.c$a */
    public interface C5400a {
        void onDenied();

        void onGranted();
    }

    private C5399c(Object obj) {
        this.f17368d = obj;
    }

    /* renamed from: a */
    public static C5399c m22099a(Activity activity) {
        return new C5399c(activity);
    }

    /* renamed from: a */
    public static C5399c m22100a(Fragment fragment) {
        return new C5399c(fragment);
    }

    /* renamed from: a */
    private static List<String> m22101a(Context context, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (ContextCompat.checkSelfPermission(context, str) != 0) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static void m22102a(int i, int[] iArr) {
        C5400a aVar = (C5400a) f17366b.get(i);
        if (aVar == null) {
            String str = "失败了";
            C5264a.m21617a(str, str);
            return;
        }
        f17366b.remove(i);
        for (int i2 : iArr) {
            if (i2 != 0) {
                aVar.onDenied();
                return;
            }
        }
        aVar.onGranted();
    }

    /* renamed from: a */
    private static synchronized void m22103a(Context context) {
        synchronized (C5399c.class) {
            if (f17367c == null) {
                f17367c = new HashSet();
                try {
                    Collections.addAll(f17367c, context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions);
                } catch (NameNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    public final C5399c mo27353a(C5400a aVar) {
        this.f17370f = aVar;
        return this;
    }

    /* renamed from: a */
    public final C5399c mo27354a(String... strArr) {
        this.f17369e = strArr;
        return this;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0019  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0088  */
    /* renamed from: a */
    public final void mo27355a() {
        /*
        r6 = this;
        java.lang.Object r0 = r6.f17368d
        if (r0 == 0) goto L_0x0016
        boolean r1 = r0 instanceof android.app.Activity
        if (r1 == 0) goto L_0x000b
        android.app.Activity r0 = (android.app.Activity) r0
        goto L_0x0017
    L_0x000b:
        boolean r1 = r0 instanceof androidx.fragment.app.Fragment
        if (r1 == 0) goto L_0x0016
        androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0
        androidx.fragment.app.FragmentActivity r0 = r0.getActivity()
        goto L_0x0017
    L_0x0016:
        r0 = 0
    L_0x0017:
        if (r0 == 0) goto L_0x0088
        m22103a(r0)
        java.lang.String[] r1 = r6.f17369e
        int r2 = r1.length
        r3 = 0
    L_0x0020:
        if (r3 >= r2) goto L_0x0037
        r4 = r1[r3]
        java.util.Set<java.lang.String> r5 = f17367c
        boolean r4 = r5.contains(r4)
        if (r4 != 0) goto L_0x0034
        com.qiyukf.basesdk.c.c$a r0 = r6.f17370f
        if (r0 == 0) goto L_0x0033
        r0.onDenied()
    L_0x0033:
        return
    L_0x0034:
        int r3 = r3 + 1
        goto L_0x0020
    L_0x0037:
        int r1 = android.os.Build.VERSION.SDK_INT
        r2 = 23
        if (r1 >= r2) goto L_0x0045
        com.qiyukf.basesdk.c.c$a r0 = r6.f17370f
        if (r0 == 0) goto L_0x0044
        r0.onGranted()
    L_0x0044:
        return
    L_0x0045:
        java.lang.String[] r1 = r6.f17369e
        java.util.List r0 = m22101a(r0, r1)
        boolean r1 = r0.isEmpty()
        if (r1 == 0) goto L_0x0059
        com.qiyukf.basesdk.c.c$a r0 = r6.f17370f
        if (r0 == 0) goto L_0x0058
        r0.onGranted()
    L_0x0058:
        return
    L_0x0059:
        java.util.concurrent.atomic.AtomicInteger r1 = f17365a
        int r1 = r1.incrementAndGet()
        int r2 = r0.size()
        java.lang.String[] r2 = new java.lang.String[r2]
        java.lang.Object[] r0 = r0.toArray(r2)
        java.lang.String[] r0 = (java.lang.String[]) r0
        java.lang.Object r2 = r6.f17368d
        boolean r3 = r2 instanceof android.app.Activity
        if (r3 == 0) goto L_0x0077
        android.app.Activity r2 = (android.app.Activity) r2
        r2.requestPermissions(r0, r1)
        goto L_0x0080
    L_0x0077:
        boolean r3 = r2 instanceof androidx.fragment.app.Fragment
        if (r3 == 0) goto L_0x0080
        androidx.fragment.app.Fragment r2 = (androidx.fragment.app.Fragment) r2
        r2.requestPermissions(r0, r1)
    L_0x0080:
        android.util.SparseArray<com.qiyukf.basesdk.c.c$a> r0 = f17366b
        com.qiyukf.basesdk.c.c$a r2 = r6.f17370f
        r0.put(r1, r2)
        return
    L_0x0088:
        java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        java.lang.Object r2 = r6.f17368d
        java.lang.Class r2 = r2.getClass()
        java.lang.String r2 = r2.getName()
        r1.append(r2)
        java.lang.String r2 = " is not supported"
        r1.append(r2)
        java.lang.String r1 = r1.toString()
        r0.<init>(r1)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.basesdk.p412c.C5399c.mo27355a():void");
    }
}
