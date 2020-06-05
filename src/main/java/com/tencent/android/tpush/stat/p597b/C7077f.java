package com.tencent.android.tpush.stat.p597b;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.android.tpush.stat.p596a.C7066c;
import com.tencent.android.tpush.stat.p596a.C7067d;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.stat.b.f */
public class C7077f extends C7079h {
    /* renamed from: a */
    public int mo34177a() {
        return 4;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo34179b() {
        return true;
    }

    public C7077f(Context context, int i) {
        super(context, i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public String mo34180c() {
        return mo34196b(mo34202f());
    }

    /* renamed from: b */
    public String mo34196b(String str) {
        String string;
        synchronized (this) {
            if (this.f23534a == null) {
                this.f23534a = C7066c.m30259b();
            }
            C7067d dVar = this.f23534a;
            StringBuilder sb = new StringBuilder();
            sb.append("read mid from sharedPreferences， key=");
            sb.append(str);
            dVar.mo34169b((Object) sb.toString());
            string = PreferenceManager.getDefaultSharedPreferences(this.f23535b).getString(str, null);
        }
        return string;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo34178a(String str) {
        mo34195a(mo34202f(), str);
    }

    /* renamed from: a */
    public void mo34195a(String str, String str2) {
        synchronized (this) {
            if (this.f23534a == null) {
                this.f23534a = C7066c.m30259b();
            }
            C7067d dVar = this.f23534a;
            StringBuilder sb = new StringBuilder();
            sb.append("write mid to sharedPreferences ");
            sb.append(str);
            dVar.mo34169b((Object) sb.toString());
            Editor edit = PreferenceManager.getDefaultSharedPreferences(this.f23535b).edit();
            edit.putString(str, str2);
            edit.commit();
        }
    }
}
