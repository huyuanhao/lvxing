package com.bytedance.embedapplog.p141a;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.embedapplog.AppLog;
import com.bytedance.embedapplog.p142b.C1821h;
import com.bytedance.embedapplog.p142b.C1822i;
import com.bytedance.embedapplog.p144d.C1838a;
import com.bytedance.embedapplog.p144d.C1844f;
import com.bytedance.embedapplog.p144d.C1846h;
import com.bytedance.embedapplog.p144d.C1848j;
import com.bytedance.embedapplog.util.C1856h;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

/* renamed from: com.bytedance.embedapplog.a.k */
public class C1811k {
    /* renamed from: f */
    private static long f5076f;
    /* renamed from: o */
    private static C1813a f5077o;
    /* renamed from: a */
    String f5078a;
    /* renamed from: b */
    private final C1821h f5079b;
    /* renamed from: c */
    private final C1822i f5080c;
    /* renamed from: d */
    private C1846h f5081d;
    /* renamed from: e */
    private C1846h f5082e;
    /* renamed from: g */
    private long f5083g;
    /* renamed from: h */
    private int f5084h;
    /* renamed from: i */
    private long f5085i = -1;
    /* renamed from: j */
    private volatile boolean f5086j;
    /* renamed from: k */
    private long f5087k;
    /* renamed from: l */
    private int f5088l;
    /* renamed from: m */
    private String f5089m;
    /* renamed from: n */
    private C1844f f5090n;

    /* renamed from: com.bytedance.embedapplog.a.k$a */
    private static class C1813a extends C1848j {
        private C1813a() {
        }
    }

    C1811k(C1822i iVar, C1821h hVar) {
        this.f5080c = iVar;
        this.f5079b = hVar;
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: a */
    public synchronized C1844f mo13359a() {
        return this.f5090n;
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: a */
    public synchronized Bundle mo13358a(long j, long j2) {
        Bundle bundle;
        bundle = null;
        if (this.f5079b.mo13402e() && mo13363c() && j - this.f5083g > j2) {
            bundle = new Bundle();
            bundle.putInt("session_no", this.f5088l);
            int i = this.f5084h + 1;
            this.f5084h = i;
            bundle.putInt("send_times", i);
            bundle.putLong("current_duration", (j - this.f5083g) / 1000);
            bundle.putString("session_start_time", C1838a.m6448a(this.f5085i));
            this.f5083g = j;
        }
        return bundle;
    }

    /* renamed from: b */
    public boolean mo13362b() {
        return this.f5086j;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo13363c() {
        return mo13362b() && this.f5087k == 0;
    }

    /* renamed from: a */
    private synchronized void m6304a(C1838a aVar, ArrayList<C1838a> arrayList, boolean z) {
        long j = aVar instanceof C1813a ? -1 : aVar.f5155a;
        this.f5078a = UUID.randomUUID().toString();
        f5076f = this.f5079b.mo13371F();
        this.f5085i = j;
        this.f5086j = z;
        this.f5087k = 0;
        if (C1856h.f5226b) {
            StringBuilder sb = new StringBuilder();
            sb.append("startSession, ");
            sb.append(this.f5078a);
            sb.append(", hadUi:");
            sb.append(z);
            sb.append(" data:");
            sb.append(aVar);
            C1856h.m6581a(sb.toString(), null);
        }
        if (z) {
            Calendar instance = Calendar.getInstance();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("");
            sb2.append(instance.get(1));
            sb2.append(instance.get(2));
            sb2.append(instance.get(5));
            String sb3 = sb2.toString();
            if (TextUtils.isEmpty(this.f5089m)) {
                this.f5089m = this.f5079b.mo13394b();
                this.f5088l = this.f5079b.mo13397c();
            }
            if (!sb3.equals(this.f5089m)) {
                this.f5089m = sb3;
                this.f5088l = 1;
            } else {
                this.f5088l++;
            }
            this.f5079b.mo13389a(sb3, this.f5088l);
            this.f5084h = 0;
        }
        if (j != -1) {
            C1844f fVar = new C1844f();
            fVar.f5157c = this.f5078a;
            fVar.f5156b = m6303a(this.f5079b);
            fVar.f5155a = this.f5085i;
            fVar.f5183i = this.f5080c.mo13434d();
            fVar.f5182h = this.f5080c.mo13432c();
            if (this.f5079b.mo13422y()) {
                fVar.f5159e = AppLog.getAbConfigVersion();
                fVar.f5160f = AppLog.getAbSDKVersion();
            }
            arrayList.add(fVar);
            this.f5090n = fVar;
            if (C1856h.f5226b) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("gen launch, ");
                sb4.append(fVar.f5157c);
                sb4.append(", hadUi:");
                sb4.append(z);
                C1856h.m6581a(sb4.toString(), null);
            }
        }
    }

    /* renamed from: a */
    public static boolean m6305a(C1838a aVar) {
        if (aVar instanceof C1846h) {
            return ((C1846h) aVar).mo13488i();
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo13360a(C1838a aVar, ArrayList<C1838a> arrayList) {
        boolean z = aVar instanceof C1846h;
        boolean a = m6305a(aVar);
        boolean z2 = true;
        if (this.f5085i == -1) {
            m6304a(aVar, arrayList, m6305a(aVar));
        } else if (!this.f5086j && a) {
            m6304a(aVar, arrayList, true);
        } else if (this.f5087k != 0 && aVar.f5155a > this.f5087k + this.f5079b.mo13366A()) {
            m6304a(aVar, arrayList, a);
        } else if (this.f5085i > aVar.f5155a + 7200000) {
            m6304a(aVar, arrayList, a);
        } else {
            z2 = false;
        }
        if (z) {
            C1846h hVar = (C1846h) aVar;
            if (hVar.mo13488i()) {
                this.f5083g = aVar.f5155a;
                this.f5087k = 0;
                arrayList.add(aVar);
                if (TextUtils.isEmpty(hVar.f5197i)) {
                    if (this.f5082e != null && (hVar.f5155a - this.f5082e.f5155a) - this.f5082e.f5196h < 500) {
                        hVar.f5197i = this.f5082e.f5198j;
                    } else if (this.f5081d != null && (hVar.f5155a - this.f5081d.f5155a) - this.f5081d.f5196h < 500) {
                        hVar.f5197i = this.f5081d.f5198j;
                    }
                }
            } else {
                Bundle a2 = mo13358a(aVar.f5155a, 0);
                if (a2 != null) {
                    AppLog.onEventV3("play_session", a2);
                }
                this.f5083g = 0;
                this.f5087k = hVar.f5155a;
                arrayList.add(aVar);
                if (hVar.mo13489j()) {
                    this.f5081d = hVar;
                } else {
                    this.f5082e = hVar;
                    this.f5081d = null;
                }
            }
        } else if (!(aVar instanceof C1813a)) {
            arrayList.add(aVar);
        }
        mo13361b(aVar);
        return z2;
    }

    /* renamed from: b */
    public void mo13361b(C1838a aVar) {
        if (aVar != null) {
            aVar.f5158d = this.f5080c.mo13436f();
            aVar.f5157c = this.f5078a;
            aVar.f5156b = m6303a(this.f5079b);
            if (this.f5079b.mo13422y()) {
                aVar.f5159e = AppLog.getAbConfigVersion();
                aVar.f5160f = AppLog.getAbSDKVersion();
            }
        }
    }

    /* renamed from: a */
    public static long m6303a(C1821h hVar) {
        f5076f++;
        long j = f5076f;
        if (j % 1000 == 0) {
            hVar.mo13387a(j + 1000);
        }
        return f5076f;
    }

    /* renamed from: d */
    static C1813a m6306d() {
        if (f5077o == null) {
            f5077o = new C1813a();
        }
        f5077o.f5155a = System.currentTimeMillis();
        return f5077o;
    }
}
