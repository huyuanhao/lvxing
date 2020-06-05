package com.qiyukf.unicorn.p515i;

import android.app.Activity;
import android.app.Fragment;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p393a.C5268c;
import com.qiyukf.basesdk.p412c.C5361a;
import com.qiyukf.basesdk.p412c.C5366b;
import com.qiyukf.unicorn.C6029d;
import com.qiyukf.unicorn.p499b.C6014b;
import com.qiyukf.unicorn.p502e.C6055m;
import com.qiyukf.unicorn.p503f.C6168c;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.util.UUID;
import org.json.JSONObject;

/* renamed from: com.qiyukf.unicorn.i.b */
public final class C6200b {
    /* renamed from: a */
    private SparseArray<String> f19369a = new SparseArray<>();
    /* renamed from: b */
    private Handler f19370b = C5361a.m22013a().mo27316a("StatisticsManager");

    /* renamed from: com.qiyukf.unicorn.i.b$a */
    private static class C6205a {
        /* access modifiers changed from: private|static */
        /* renamed from: a */
        public static C6200b f19385a;
    }

    private C6200b() {
        this.f19370b.post(new Runnable() {
            public final void run() {
                JSONObject f = C5366b.m22040f(C6168c.m24479b(), ArgKey.KEY_RESULT);
                if (f != null) {
                    boolean z = true;
                    if (C5366b.m22034b(f, "track") != 1) {
                        z = false;
                    }
                    C6014b.m23952d(z);
                }
                StringBuilder sb = new StringBuilder("track switch ");
                sb.append(C6014b.m23983s());
                C5264a.m21617a("StatisticsManager", sb.toString());
            }
        });
    }

    /* renamed from: a */
    public static C6200b m24602a() {
        if (C6205a.f19385a == null) {
            C6205a.f19385a = new C6200b();
        }
        return C6205a.f19385a;
    }

    /* renamed from: a */
    private String m24603a(Object obj, int i) {
        String str = "";
        String str2 = "-";
        if (i == 0) {
            String lowerCase = UUID.randomUUID().toString().replaceAll(str2, str).toLowerCase();
            this.f19369a.put(obj.hashCode(), lowerCase);
            return lowerCase;
        }
        String str3 = (String) this.f19369a.get(obj.hashCode());
        if (TextUtils.isEmpty(str3)) {
            str3 = UUID.randomUUID().toString().replaceAll(str2, str).toLowerCase();
        }
        this.f19369a.remove(obj.hashCode());
        return str3;
    }

    /* renamed from: a */
    private void m24604a(Object obj, CharSequence charSequence, int i) {
        if (C6014b.m23983s()) {
            final String name = obj.getClass().getName();
            final String a = m24603a(obj, i);
            final long currentTimeMillis = System.currentTimeMillis();
            Handler handler = this.f19370b;
            final CharSequence charSequence2 = charSequence;
            final int i2 = i;
            C62033 r1 = new Runnable() {
                public final void run() {
                    try {
                        C6200b.m24606a(name, charSequence2, a, i2, currentTimeMillis);
                    } catch (Throwable th) {
                        C5264a.m21625d("StatisticsManager", "handle action error", th);
                    }
                }
            };
            handler.post(r1);
        }
    }

    /* renamed from: a */
    private void m24605a(Object obj, CharSequence charSequence, JSONObject jSONObject) {
        if (C6014b.m23983s()) {
            final String name = obj.getClass().getName();
            final String a = m24603a(obj, 0);
            final long currentTimeMillis = System.currentTimeMillis();
            Handler handler = this.f19370b;
            final CharSequence charSequence2 = charSequence;
            final JSONObject jSONObject2 = jSONObject;
            C62044 r1 = new Runnable() {
                public final void run() {
                    try {
                        C6200b.m24607a(name, charSequence2, a, currentTimeMillis, jSONObject2);
                    } catch (Throwable th) {
                        C5264a.m21625d("StatisticsManager", "handle action error", th);
                    }
                }
            };
            handler.post(r1);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m24606a(String str, CharSequence charSequence, String str2, int i, long j) {
        String e = m24610e();
        String a = C6206c.m24625a(str, charSequence, str2, i, j, "0", null);
        if (m24609d()) {
            C6206c.m24627a(e, a);
        } else {
            C6206c.m24629b(e, a);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m24607a(String str, CharSequence charSequence, String str2, long j, JSONObject jSONObject) {
        String e = m24610e();
        String a = C6206c.m24625a(str, charSequence, str2, 0, j, "1", jSONObject);
        if (m24609d()) {
            C6206c.m24627a(e, a);
        } else {
            C6206c.m24629b(e, a);
        }
    }

    /* renamed from: d */
    private static boolean m24609d() {
        for (C6055m mVar : C6029d.m24047g().mo29300e().values()) {
            if (mVar != null && mVar.f18945g == 0) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private|static */
    /* renamed from: e */
    public static String m24610e() {
        C5268c a = C5264a.m21615a();
        if (a == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(a.mo27108a());
        sb.append("/statistics/record.log");
        return sb.toString();
    }

    /* renamed from: a */
    public final void mo29390a(Activity activity) {
        if (activity != null) {
            mo29391a(activity, activity.getTitle());
        }
    }

    /* renamed from: a */
    public final void mo29391a(Activity activity, CharSequence charSequence) {
        if (activity != null) {
            m24604a((Object) activity, charSequence, 0);
        }
    }

    /* renamed from: a */
    public final void mo29392a(Activity activity, CharSequence charSequence, JSONObject jSONObject) {
        if (activity != null) {
            m24605a((Object) activity, charSequence, jSONObject);
        }
    }

    /* renamed from: a */
    public final void mo29393a(Fragment fragment, CharSequence charSequence) {
        if (fragment != null) {
            m24604a((Object) fragment.getClass().getName(), charSequence, 0);
        }
    }

    /* renamed from: a */
    public final void mo29394a(Fragment fragment, CharSequence charSequence, JSONObject jSONObject) {
        if (fragment != null) {
            m24605a((Object) fragment, charSequence, jSONObject);
        }
    }

    /* renamed from: a */
    public final void mo29395a(androidx.fragment.app.Fragment fragment, CharSequence charSequence) {
        if (fragment != null) {
            m24604a((Object) fragment, charSequence, 0);
        }
    }

    /* renamed from: a */
    public final void mo29396a(androidx.fragment.app.Fragment fragment, CharSequence charSequence, JSONObject jSONObject) {
        if (fragment != null) {
            m24605a((Object) fragment, charSequence, jSONObject);
        }
    }

    /* renamed from: b */
    public final void mo29397b() {
        if (C6014b.m23983s()) {
            this.f19370b.post(new Runnable() {
                public final void run() {
                    C6206c.m24628a(C6200b.m24610e());
                }
            });
        }
    }

    /* renamed from: b */
    public final void mo29398b(Activity activity) {
        if (activity != null) {
            mo29399b(activity, activity.getTitle());
        }
    }

    /* renamed from: b */
    public final void mo29399b(Activity activity, CharSequence charSequence) {
        if (activity != null) {
            m24604a((Object) activity, charSequence, 1);
        }
    }

    /* renamed from: b */
    public final void mo29400b(Fragment fragment, CharSequence charSequence) {
        if (fragment != null) {
            m24604a((Object) fragment, charSequence, 1);
        }
    }

    /* renamed from: b */
    public final void mo29401b(androidx.fragment.app.Fragment fragment, CharSequence charSequence) {
        if (fragment != null) {
            m24604a((Object) fragment, charSequence, 1);
        }
    }
}
