package com.ali.auth.third.p016a.p019c;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.ali.auth.third.core.model.C1025f;
import com.ali.auth.third.core.model.C1029j;
import com.ali.auth.third.core.p024c.C0989a;
import com.ali.auth.third.core.p027f.C0999a;
import com.ali.auth.third.core.p027f.C1000b;
import com.ali.auth.third.core.p032i.C1017b;
import com.ali.auth.third.core.p033j.C1018a;
import com.ali.auth.third.p016a.C0961c;
import com.ali.auth.third.p016a.p017a.C0957a;
import com.ali.auth.third.p034ui.LoginWebViewActivity;
import com.ali.auth.third.p034ui.p035a.C1067a;

/* renamed from: com.ali.auth.third.a.c.a */
public abstract class C0962a extends C1017b<String, Void, Void> {
    public C0962a(Activity activity) {
        super(activity);
    }

    /* access modifiers changed from: protected|varargs */
    /* renamed from: a */
    public Void mo10274a(String... strArr) {
        final C1029j b = mo10277b(strArr);
        if (b == null) {
            return null;
        }
        final int i = b.f2054a;
        StringBuilder sb = new StringBuilder();
        sb.append("asyncExecute code = ");
        sb.append(i);
        String str = "AbsLoginByCodeTask";
        C1018a.m1964b(str, sb.toString());
        if (i == 3000) {
            try {
                if (b.f2056c != null) {
                    C0957a.f1835b.mo10330a((C1025f) b.f2056c);
                }
                C0989a.f1901p.mo10335a(new Runnable() {
                    public void run() {
                        C0962a.this.mo10278b();
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (i == 13060) {
            String str2 = ((C1025f) b.f2056c).f2032d;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("asyncExecute doubleCheckUrl = ");
            sb2.append(str2);
            C1018a.m1964b(str, sb2.toString());
            if (!TextUtils.isEmpty(str2)) {
                Activity activity = this.f1976a;
                C1067a.m2074a(activity);
                Intent intent = new Intent(activity, LoginWebViewActivity.class);
                intent.putExtra("url", str2);
                intent.putExtra("token", ((C1025f) b.f2056c).f2029a);
                intent.putExtra("scene", ((C1025f) b.f2056c).f2030b);
                LoginWebViewActivity.f2090b = ((C1025f) b.f2056c).f2029a;
                LoginWebViewActivity.f2091c = ((C1025f) b.f2056c).f2030b;
                this.f1976a.startActivityForResult(intent, C0961c.f1840d);
            }
        } else {
            C0989a.f1901p.mo10335a(new Runnable() {
                public void run() {
                    StringBuilder sb = new StringBuilder();
                    sb.append("code ");
                    sb.append(i);
                    sb.append(" ");
                    sb.append(b.f2055b);
                    C0999a a = C1000b.m1914a(15, "login", sb.toString());
                    C1018a.m1964b("AbsLoginByCodeTask", a.toString());
                    C0962a.this.mo10276a(a.f1942a, a.f1944c);
                }
            });
        }
        return null;
    }

    /* renamed from: a */
    public abstract void mo10276a(int i, String str);

    /* renamed from: b */
    public abstract C1029j<C1025f> mo10277b(String[] strArr);

    /* renamed from: b */
    public abstract void mo10278b();
}
