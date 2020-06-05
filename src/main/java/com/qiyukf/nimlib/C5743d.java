package com.qiyukf.nimlib;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p412c.p417d.C5413e;
import com.qiyukf.nimlib.p429a.C5645a;
import com.qiyukf.nimlib.sdk.StatusCode;
import com.qiyukf.nimlib.service.NimService;
import java.util.ArrayList;

/* renamed from: com.qiyukf.nimlib.d */
public final class C5743d {
    /* renamed from: a */
    private static StatusCode f18308a = StatusCode.UNLOGIN;
    /* renamed from: b */
    private static boolean f18309b;
    /* renamed from: c */
    private static boolean f18310c;
    /* renamed from: d */
    private static boolean f18311d;
    /* renamed from: e */
    private static String f18312e = "";
    /* renamed from: f */
    private static int f18313f;
    /* renamed from: g */
    private static int f18314g;
    /* renamed from: h */
    private static ArrayList<C5645a> f18315h;

    /* renamed from: a */
    public static void m23106a(int i) {
        f18314g = i;
    }

    /* renamed from: a */
    public static void m23107a(Context context) {
        String str = context.getApplicationInfo().processName;
        String b = m23113b(context);
        String a = C5413e.m22152a(context);
        if (TextUtils.equals(a, str)) {
            m23114b(1);
        }
        if (TextUtils.equals(a, b)) {
            m23114b(2);
        }
    }

    /* renamed from: a */
    public static void m23108a(StatusCode statusCode) {
        f18308a = statusCode;
    }

    /* renamed from: a */
    public static void m23109a(String str) {
        f18312e = str;
    }

    /* renamed from: a */
    public static void m23110a(ArrayList<C5645a> arrayList) {
        f18315h = arrayList;
    }

    /* renamed from: a */
    public static final void m23111a(boolean z) {
        f18309b = z;
    }

    /* renamed from: a */
    public static final boolean m23112a() {
        return f18309b;
    }

    /* renamed from: b */
    private static String m23113b(Context context) {
        try {
            return context.getPackageManager().getServiceInfo(new ComponentName(context, NimService.class), 128).processName;
        } catch (NameNotFoundException e) {
            C5264a.m21621b("getServiceProcessName is error", "", e);
            return null;
        }
    }

    /* renamed from: b */
    private static void m23114b(int i) {
        f18313f = i | f18313f;
    }

    /* renamed from: b */
    public static final void m23115b(boolean z) {
        f18310c = z;
    }

    /* renamed from: b */
    public static final boolean m23116b() {
        return f18310c;
    }

    /* renamed from: c */
    public static final void m23117c(boolean z) {
        f18311d = z;
    }

    /* renamed from: c */
    public static final boolean m23118c() {
        return f18311d;
    }

    /* renamed from: d */
    public static String m23119d() {
        return f18312e;
    }

    /* renamed from: e */
    public static StatusCode m23120e() {
        return f18308a;
    }

    /* renamed from: f */
    public static boolean m23121f() {
        return (f18313f & 1) != 0;
    }

    /* renamed from: g */
    public static boolean m23122g() {
        return (f18313f & 2) != 0;
    }

    /* renamed from: h */
    public static int m23123h() {
        return f18314g;
    }

    /* renamed from: i */
    public static ArrayList<C5645a> m23124i() {
        return f18315h;
    }
}
