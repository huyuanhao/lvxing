package com.tencent.android.tpush.stat.p597b;

import android.content.Context;
import com.tencent.android.tpush.service.channel.p593c.C7037d;
import com.tencent.android.tpush.stat.p596a.C7069f;
import com.tencent.mid.core.Constants;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.stat.b.g */
public class C7078g extends C7079h {
    /* renamed from: a */
    public int mo34177a() {
        return 1;
    }

    public C7078g(Context context, int i) {
        super(context, i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo34179b() {
        return C7069f.m30292a(this.f23535b, Constants.PERMISSION_WRITE_SETTINGS);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public String mo34180c() {
        String a;
        synchronized (this) {
            a = C7037d.m30095a(this.f23535b).mo33478a(mo34202f());
        }
        return a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo34178a(String str) {
        synchronized (this) {
            this.f23534a.mo34169b((Object) "write mid to Settings.System");
            C7037d.m30095a(this.f23535b).mo33482a(mo34202f(), str);
        }
    }
}
