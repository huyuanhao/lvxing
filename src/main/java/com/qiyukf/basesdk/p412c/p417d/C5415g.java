package com.qiyukf.basesdk.p412c.p417d;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
import com.qiyukf.basesdk.p412c.C5361a;

/* renamed from: com.qiyukf.basesdk.c.d.g */
public final class C5415g {
    /* renamed from: a */
    private static Handler f17386a;
    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static Context f17387b;
    /* access modifiers changed from: private|static */
    /* renamed from: c */
    public static Toast f17388c;

    /* renamed from: a */
    public static void m22161a(final int i) {
        m22167c().post(new Runnable() {
            public final void run() {
                if (C5415g.f17388c != null) {
                    C5415g.f17388c.setText(i);
                    C5415g.f17388c.setDuration(0);
                } else {
                    C5415g.f17388c = Toast.makeText(C5415g.f17387b, i, 0);
                }
                C5415g.f17388c.show();
            }
        });
    }

    /* renamed from: a */
    public static void m22162a(Context context) {
        f17387b = context.getApplicationContext();
    }

    /* renamed from: a */
    public static void m22163a(final String str) {
        m22167c().post(new Runnable() {
            public final void run() {
                if (C5415g.f17388c != null) {
                    C5415g.f17388c.setText(str);
                    C5415g.f17388c.setDuration(0);
                } else {
                    C5415g.f17388c = Toast.makeText(C5415g.f17387b, str, 0);
                }
                C5415g.f17388c.show();
            }
        });
    }

    /* renamed from: b */
    public static void m22165b(final int i) {
        m22167c().post(new Runnable() {
            public final void run() {
                if (C5415g.f17388c != null) {
                    C5415g.f17388c.setText(i);
                    C5415g.f17388c.setDuration(1);
                } else {
                    C5415g.f17388c = Toast.makeText(C5415g.f17387b, i, 1);
                }
                C5415g.f17388c.show();
            }
        });
    }

    /* renamed from: b */
    public static void m22166b(final String str) {
        m22167c().post(new Runnable() {
            public final void run() {
                if (C5415g.f17388c != null) {
                    C5415g.f17388c.setText(str);
                    C5415g.f17388c.setDuration(1);
                } else {
                    C5415g.f17388c = Toast.makeText(C5415g.f17387b, str, 1);
                }
                C5415g.f17388c.show();
            }
        });
    }

    /* renamed from: c */
    private static Handler m22167c() {
        if (f17386a == null) {
            f17386a = C5361a.m22014b();
        }
        return f17386a;
    }
}
