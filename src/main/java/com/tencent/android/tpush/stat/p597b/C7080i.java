package com.tencent.android.tpush.stat.p597b;

import android.content.Context;
import android.util.Log;
import com.tencent.android.tpush.C6860a;
import com.tencent.android.tpush.common.C6914l;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.stat.p596a.C7066c;
import com.tencent.android.tpush.stat.p596a.C7067d;
import com.tencent.mid.sotrage.StorageInterface;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.stat.b.i */
public class C7080i {
    /* renamed from: h */
    private static C7080i f23537h;
    /* renamed from: a */
    Map<Integer, C7079h> f23538a = null;
    /* renamed from: b */
    C7075d f23539b = null;
    /* renamed from: c */
    Map<Integer, C7079h> f23540c = null;
    /* renamed from: d */
    boolean f23541d = true;
    /* renamed from: e */
    private Map<Integer, C7079h> f23542e = null;
    /* renamed from: f */
    private Context f23543f = null;
    /* renamed from: g */
    private C7067d f23544g = C7066c.m30259b();
    /* renamed from: i */
    private C7075d f23545i = null;

    private C7080i(Context context) {
        this.f23543f = context.getApplicationContext();
        this.f23542e = new HashMap(3);
        this.f23542e.put(Integer.valueOf(1), new C7078g(context, 3));
        this.f23542e.put(Integer.valueOf(2), new C7073b(context, 3));
        this.f23542e.put(Integer.valueOf(4), new C7077f(context, 3));
    }

    /* renamed from: a */
    public static synchronized C7080i m30362a(Context context) {
        C7080i iVar;
        synchronized (C7080i.class) {
            if (f23537h == null) {
                f23537h = new C7080i(context);
            }
            iVar = f23537h;
        }
        return iVar;
    }

    /* renamed from: e */
    private Map<Integer, C7079h> m30363e() {
        if (this.f23538a == null) {
            this.f23538a = new HashMap(3);
            this.f23538a.put(Integer.valueOf(1), new C7078g(this.f23543f, StorageInterface.VER_NEW));
            this.f23538a.put(Integer.valueOf(2), new C7073b(this.f23543f, StorageInterface.VER_NEW));
            this.f23538a.put(Integer.valueOf(4), new C7077f(this.f23543f, StorageInterface.VER_NEW));
        }
        return this.f23538a;
    }

    /* renamed from: a */
    public void mo34205a(C7075d dVar) {
        mo34206a(dVar, true);
    }

    /* renamed from: a */
    public void mo34206a(C7075d dVar, boolean z) {
        if (dVar.mo34183b() <= 0) {
            dVar.mo34184b(System.currentTimeMillis());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("writeNewVersionMidEntity midEntity:");
        sb.append(dVar);
        String sb2 = sb.toString();
        String str = Constants.LogTag;
        C6864a.m29298c(str, sb2);
        for (Entry entry : m30363e().entrySet()) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("writeMidEntity new ver:");
            sb3.append(dVar);
            C6864a.m29298c(str, sb3.toString());
            ((C7079h) entry.getValue()).mo34197a(dVar);
        }
        if (z) {
            Context context = this.f23543f;
            C6860a.m29258b(context, context.getPackageName(), dVar.toString());
        }
    }

    /* renamed from: b */
    public void mo34208b(C7075d dVar) {
        mo34209b(dVar, true);
    }

    /* renamed from: b */
    public void mo34209b(C7075d dVar, boolean z) {
        if (dVar.mo34183b() <= 0) {
            dVar.mo34184b(System.currentTimeMillis());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("writeOldVersionMidEntity midEntity:");
        sb.append(dVar);
        String sb2 = sb.toString();
        String str = Constants.LogTag;
        C6864a.m29298c(str, sb2);
        for (Entry entry : m30364f().entrySet()) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("writeMidEntity old ver:");
            sb3.append(dVar);
            C6864a.m29298c(str, sb3.toString());
            ((C7079h) entry.getValue()).mo34197a(dVar);
        }
        if (z) {
            Context context = this.f23543f;
            C6860a.m29260c(context, context.getPackageName(), dVar.toString());
        }
    }

    /* renamed from: a */
    public C7075d mo34204a() {
        return m30361a(4, m30363e());
    }

    /* renamed from: f */
    private Map<Integer, C7079h> m30364f() {
        if (this.f23540c == null) {
            this.f23540c = new HashMap(3);
            this.f23540c.put(Integer.valueOf(1), new C7078g(this.f23543f, 3));
            this.f23540c.put(Integer.valueOf(2), new C7073b(this.f23543f, 3));
            this.f23540c.put(Integer.valueOf(4), new C7077f(this.f23543f, 3));
        }
        return this.f23540c;
    }

    /* renamed from: b */
    public C7075d mo34207b() {
        if (!C6914l.m29515a(this.f23545i)) {
            this.f23545i = mo34204a();
            C7075d dVar = this.f23545i;
            if (dVar == null || !dVar.mo34187c()) {
                this.f23545i = mo34212d();
            }
        }
        if (!C6914l.m29515a(this.f23545i)) {
            String d = C6860a.m29261d(this.f23543f);
            if (C7074c.m30319a(d)) {
                this.f23545i = new C7075d();
                this.f23545i.mo34185b(d);
            }
        }
        if (this.f23541d) {
            this.f23544g.mo34176h("firstRead");
            C7075d d2 = mo34212d();
            if (d2 == null || !d2.mo34187c()) {
                mo34211c(this.f23545i);
            }
            this.f23541d = false;
        }
        C7075d dVar2 = this.f23545i;
        return dVar2 != null ? dVar2 : new C7075d();
    }

    /* renamed from: c */
    public void mo34211c(C7075d dVar) {
        C7079h hVar = (C7079h) this.f23542e.get(Integer.valueOf(4));
        if (hVar != null) {
            hVar.mo34197a(dVar);
        }
    }

    /* renamed from: c */
    public String mo34210c() {
        C7075d a = mo34204a();
        if (a == null || !a.mo34187c()) {
            a = mo34212d();
        }
        return (a == null || !a.mo34187c()) ? "" : a.mo34190e();
    }

    /* renamed from: d */
    public C7075d mo34212d() {
        return m30361a(4, this.f23542e);
    }

    /* renamed from: a */
    private C7075d m30361a(int i, Map<Integer, C7079h> map) {
        if (this.f23542e != null) {
            C7079h hVar = (C7079h) map.get(Integer.valueOf(i));
            if (hVar != null) {
                return hVar.mo34203g();
            }
        }
        return null;
    }

    /* renamed from: d */
    public void mo34213d(C7075d dVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("writeMidEntity:");
        sb.append(dVar);
        Log.d(Constants.LogTag, sb.toString());
        mo34205a(dVar);
        mo34208b(dVar);
    }
}
