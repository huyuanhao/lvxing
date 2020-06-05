package com.qiyukf.nimlib.p429a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p412c.C5420e;
import com.qiyukf.basesdk.sdk.ResponseCode;
import com.qiyukf.nimlib.C5718b;
import com.qiyukf.nimlib.C5743d;
import com.qiyukf.nimlib.p429a.p431b.C5655b;
import com.qiyukf.nimlib.p429a.p436c.C5669a;
import com.qiyukf.nimlib.p429a.p442d.C5686a;
import com.qiyukf.nimlib.p429a.p442d.C5686a.C5687a;
import com.qiyukf.nimlib.p429a.p449f.C5713a;
import com.qiyukf.nimlib.p429a.p449f.C5714b;
import com.qiyukf.nimlib.p429a.p449f.C5715c;
import com.qiyukf.nimlib.p429a.p449f.C5716d;
import com.qiyukf.nimlib.p451c.C5742c;
import com.qiyukf.nimlib.p469e.C5805a;
import com.qiyukf.nimlib.p469e.C5817i;
import com.qiyukf.nimlib.p470f.C5831b;
import com.qiyukf.nimlib.p470f.p471a.C5826a;
import com.qiyukf.nimlib.p470f.p471a.C5830b;
import com.qiyukf.nimlib.p473h.p481c.p484c.C5898f;
import com.qiyukf.nimlib.p485i.C5913b;
import com.qiyukf.nimlib.p486j.C5926a;
import com.qiyukf.nimlib.sdk.StatusCode;
import com.qiyukf.nimlib.sdk.auth.AuthServiceObserver;
import com.qiyukf.nimlib.sdk.auth.LoginInfo;
import com.qiyukf.unicorn.api.SavePowerConfig;
import java.util.ArrayList;

/* renamed from: com.qiyukf.nimlib.a.c */
public class C5668c {
    /* renamed from: f */
    private static C5668c f18194f;
    /* renamed from: h */
    private static long f18195h;
    /* renamed from: a */
    private C5716d f18196a = new C5716d();
    /* renamed from: b */
    private C5420e f18197b = new C5420e("Response", C5420e.f17395c, false);
    /* renamed from: c */
    private C5655b f18198c = new C5655b(false, this.f18197b, this.f18196a);
    /* renamed from: d */
    private C5831b f18199d = new C5831b(C5718b.m23009a());
    /* renamed from: e */
    private C5817i f18200e;
    /* renamed from: g */
    private StatusCode f18201g = StatusCode.UNLOGIN;

    /* renamed from: a */
    public static C5668c m22861a() {
        if (f18194f == null) {
            synchronized (C5668c.class) {
                if (f18194f == null) {
                    f18194f = new C5668c();
                }
            }
        }
        return f18194f;
    }

    /* renamed from: a */
    public static void m22862a(ArrayList<C5645a> arrayList) {
        C5743d.m23110a(arrayList);
        StringBuilder sb = new StringBuilder();
        sb.append(AuthServiceObserver.class.getSimpleName());
        sb.append("/observeOtherClients");
        C5805a.m23312a(sb.toString(), arrayList);
    }

    /* renamed from: e */
    private void m22863e() {
        C5718b.m23013a((LoginInfo) null);
        C5913b.m23694a().mo28326b();
        this.f18197b.mo27366b();
        this.f18196a.mo27963b();
        C5742c.m23101a().mo28017c();
        mo27867b();
    }

    /* renamed from: f */
    private synchronized void m22864f() {
        if (!TextUtils.isEmpty(C5718b.m23015b()) && !C5742c.m23101a().mo28016b()) {
            C5742c.m23101a().mo28015a(C5718b.m23009a(), C5718b.m23015b());
        }
    }

    /* renamed from: a */
    public final C5669a mo27856a(C5686a aVar) {
        return this.f18196a.mo27964c(aVar);
    }

    /* renamed from: a */
    public final void mo27857a(int i) {
        this.f18199d.mo28140a(i);
    }

    /* renamed from: a */
    public final void mo27858a(C5687a aVar) {
        this.f18198c.mo27843a(aVar);
    }

    /* renamed from: a */
    public final void mo27859a(C5817i iVar, LoginInfo loginInfo) {
        if (C5743d.m23120e() == StatusCode.LOGINED) {
            iVar.mo28116b((Object) C5718b.m23018e());
            C5805a.m23315c(iVar);
            return;
        }
        C5718b.m23013a(loginInfo);
        this.f18200e = iVar;
        this.f18199d.mo28142a(loginInfo);
    }

    /* renamed from: a */
    public final void mo27860a(C5826a aVar) {
        C5687a aVar2 = new C5687a();
        aVar2.f18231a = aVar.mo28133b();
        if (aVar.mo28134c() != null) {
            aVar2.f18232b = new C5898f(aVar.mo28134c());
        }
        this.f18198c.mo27843a(aVar2);
    }

    /* renamed from: a */
    public final void mo27861a(C5830b bVar) {
        C5743d.m23106a(bVar.f18507c);
        C5718b.m23013a(bVar.f18506b);
        StringBuilder sb = new StringBuilder("set status from ");
        sb.append(this.f18201g);
        sb.append(" to ");
        sb.append(bVar.f18505a);
        C5264a.m21617a("uicore", sb.toString());
        if ((bVar.f18505a != StatusCode.CONNECTING && bVar.f18505a != StatusCode.LOGINING) || this.f18201g != StatusCode.LOGINED) {
            C5743d.m23108a(bVar.f18505a);
            if (bVar.f18505a.logined()) {
                m22864f();
            } else if (bVar.f18505a.wontAutoLogin()) {
                m22863e();
            } else if (this.f18200e != null && !this.f18201g.shouldReLogin() && bVar.f18505a.shouldReLogin()) {
                mo27863a((short) ResponseCode.RES_ECONNECTION);
            }
            if ((!this.f18201g.logined() || bVar.f18505a.logined()) && this.f18201g != bVar.f18505a && bVar.f18505a == StatusCode.LOGINED) {
                this.f18196a.mo27965c();
                C5926a.m23780a().mo28363a(C5718b.m23009a());
            }
            this.f18201g = bVar.f18505a;
            StatusCode statusCode = this.f18201g;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(AuthServiceObserver.class.getSimpleName());
            sb2.append("/observeOnlineStatus");
            C5805a.m23312a(sb2.toString(), statusCode);
        }
    }

    /* renamed from: a */
    public final void mo27862a(SavePowerConfig savePowerConfig) {
        this.f18199d.mo28143a(savePowerConfig);
    }

    /* renamed from: a */
    public final void mo27863a(short s) {
        C5817i iVar = this.f18200e;
        if (iVar != null) {
            iVar.mo28111a((int) s);
            if (s == 200) {
                m22864f();
                this.f18200e.mo28112a((Object) C5718b.m23018e());
            } else {
                C5718b.m23013a((LoginInfo) null);
            }
            C5805a.m23315c(this.f18200e);
            this.f18200e = null;
        }
    }

    /* renamed from: a */
    public final boolean mo27864a(C5669a aVar) {
        return mo27865a(aVar, C5713a.f18254a);
    }

    /* renamed from: a */
    public final boolean mo27865a(C5669a aVar, C5713a aVar2) {
        return mo27866a((C5715c) new C5714b(aVar, aVar2));
    }

    /* renamed from: a */
    public final boolean mo27866a(C5715c cVar) {
        boolean z = false;
        if (cVar == null) {
            return false;
        }
        C5669a b = cVar.mo27955b();
        b.mo27870a().mo28225a(C5648b.m22819a(false));
        if (C5743d.m23120e() == StatusCode.LOGINED) {
            z = true;
        }
        boolean a = cVar.mo27958d() > 0 ? this.f18196a.mo27962a(cVar) : z;
        mo27869d();
        if (z) {
            this.f18199d.mo28141a(new C5826a(b));
        }
        if (!a) {
            cVar.mo27956a((short) ResponseCode.RES_ECONNECTION);
        }
        return a;
    }

    /* renamed from: b */
    public final void mo27867b() {
        this.f18197b.mo27364a();
        this.f18196a.mo27961a();
        m22864f();
    }

    /* renamed from: c */
    public final void mo27868c() {
        this.f18200e = null;
        this.f18199d.mo28139a();
        C5743d.m23108a(StatusCode.UNLOGIN);
        m22863e();
    }

    /* renamed from: d */
    public final void mo27869d() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - f18195h > 10000) {
            f18195h = elapsedRealtime;
            this.f18199d.mo28144b();
        }
    }
}
