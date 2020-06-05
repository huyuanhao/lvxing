package com.bytedance.sdk.p145a.p147b;

import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.p145a.p147b.p148a.NamedRunnable;
import com.bytedance.sdk.p145a.p147b.p148a.p149a.CacheInterceptor;
import com.bytedance.sdk.p145a.p147b.p148a.p150b.ConnectInterceptor;
import com.bytedance.sdk.p145a.p147b.p148a.p151c.BridgeInterceptor;
import com.bytedance.sdk.p145a.p147b.p148a.p151c.CallServerInterceptor;
import com.bytedance.sdk.p145a.p147b.p148a.p151c.RealInterceptorChain;
import com.bytedance.sdk.p145a.p147b.p148a.p151c.RetryAndFollowUpInterceptor;
import com.bytedance.sdk.p145a.p147b.p148a.p155g.Platform;
import java.io.IOException;
import java.util.ArrayList;

/* renamed from: com.bytedance.sdk.a.b.aa */
final class RealCall implements Call {
    /* renamed from: a */
    final OkHttpClient f5700a;
    /* renamed from: b */
    final RetryAndFollowUpInterceptor f5701b;
    /* renamed from: c */
    final C1918ab f5702c;
    /* renamed from: d */
    final boolean f5703d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public EventListener f5704e;
    /* renamed from: f */
    private boolean f5705f;

    /* compiled from: RealCall */
    /* renamed from: com.bytedance.sdk.a.b.aa$a */
    final class C1917a extends NamedRunnable {
        /* renamed from: b */
        final /* synthetic */ RealCall f5706b;
        /* renamed from: c */
        private final Callback f5707c;

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public String mo13909b() {
            return this.f5706b.f5702c.mo13910a().mo14092f();
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x003d A[SYNTHETIC, Splitter:B:13:0x003d] */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x005d A[Catch:{ all -> 0x0036 }] */
        /* renamed from: a */
        public void mo13684a() {
            /*
            r5 = this;
            r0 = 1
            r1 = 0
            com.bytedance.sdk.a.b.aa r2 = r5.f5706b     // Catch:{ IOException -> 0x0038 }
            com.bytedance.sdk.a.b.b r2 = r2.mo13908f()     // Catch:{ IOException -> 0x0038 }
            com.bytedance.sdk.a.b.aa r3 = r5.f5706b     // Catch:{ IOException -> 0x0038 }
            com.bytedance.sdk.a.b.a.c.j r3 = r3.f5701b     // Catch:{ IOException -> 0x0038 }
            boolean r1 = r3.mo13747a()     // Catch:{ IOException -> 0x0038 }
            if (r1 == 0) goto L_0x0021
            com.bytedance.sdk.a.b.i r1 = r5.f5707c     // Catch:{ IOException -> 0x0034 }
            com.bytedance.sdk.a.b.aa r2 = r5.f5706b     // Catch:{ IOException -> 0x0034 }
            java.io.IOException r3 = new java.io.IOException     // Catch:{ IOException -> 0x0034 }
            java.lang.String r4 = "Canceled"
            r3.<init>(r4)     // Catch:{ IOException -> 0x0034 }
            r1.mo13995a(r2, r3)     // Catch:{ IOException -> 0x0034 }
            goto L_0x0028
        L_0x0021:
            com.bytedance.sdk.a.b.i r1 = r5.f5707c     // Catch:{ IOException -> 0x0034 }
            com.bytedance.sdk.a.b.aa r3 = r5.f5706b     // Catch:{ IOException -> 0x0034 }
            r1.mo13994a(r3, r2)     // Catch:{ IOException -> 0x0034 }
        L_0x0028:
            com.bytedance.sdk.a.b.aa r0 = r5.f5706b
            com.bytedance.sdk.a.b.z r0 = r0.f5700a
            com.bytedance.sdk.a.b.q r0 = r0.mo14137s()
            r0.mo14039a(r5)
            goto L_0x0070
        L_0x0034:
            r1 = move-exception
            goto L_0x003b
        L_0x0036:
            r0 = move-exception
            goto L_0x0071
        L_0x0038:
            r0 = move-exception
            r1 = r0
            r0 = 0
        L_0x003b:
            if (r0 == 0) goto L_0x005d
            com.bytedance.sdk.a.b.a.g.e r0 = com.bytedance.sdk.p145a.p147b.p148a.p155g.Platform.m7295b()     // Catch:{ all -> 0x0036 }
            r2 = 4
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0036 }
            r3.<init>()     // Catch:{ all -> 0x0036 }
            java.lang.String r4 = "Callback failure for "
            r3.append(r4)     // Catch:{ all -> 0x0036 }
            com.bytedance.sdk.a.b.aa r4 = r5.f5706b     // Catch:{ all -> 0x0036 }
            java.lang.String r4 = r4.mo13906d()     // Catch:{ all -> 0x0036 }
            r3.append(r4)     // Catch:{ all -> 0x0036 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0036 }
            r0.mo13872a(r2, r3, r1)     // Catch:{ all -> 0x0036 }
            goto L_0x0028
        L_0x005d:
            com.bytedance.sdk.a.b.aa r0 = r5.f5706b     // Catch:{ all -> 0x0036 }
            com.bytedance.sdk.a.b.s r0 = r0.f5704e     // Catch:{ all -> 0x0036 }
            com.bytedance.sdk.a.b.aa r2 = r5.f5706b     // Catch:{ all -> 0x0036 }
            r0.mo14050a(r2, r1)     // Catch:{ all -> 0x0036 }
            com.bytedance.sdk.a.b.i r0 = r5.f5707c     // Catch:{ all -> 0x0036 }
            com.bytedance.sdk.a.b.aa r2 = r5.f5706b     // Catch:{ all -> 0x0036 }
            r0.mo13995a(r2, r1)     // Catch:{ all -> 0x0036 }
            goto L_0x0028
        L_0x0070:
            return
        L_0x0071:
            com.bytedance.sdk.a.b.aa r1 = r5.f5706b
            com.bytedance.sdk.a.b.z r1 = r1.f5700a
            com.bytedance.sdk.a.b.q r1 = r1.mo14137s()
            r1.mo14039a(r5)
            throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.p145a.p147b.RealCall.C1917a.mo13684a():void");
        }
    }

    private RealCall(OkHttpClient zVar, C1918ab abVar, boolean z) {
        this.f5700a = zVar;
        this.f5702c = abVar;
        this.f5703d = z;
        this.f5701b = new RetryAndFollowUpInterceptor(zVar, z);
    }

    /* renamed from: a */
    static RealCall m7333a(OkHttpClient zVar, C1918ab abVar, boolean z) {
        RealCall aaVar = new RealCall(zVar, abVar, z);
        aaVar.f5704e = zVar.mo14142x().mo14064a(aaVar);
        return aaVar;
    }

    /* renamed from: a */
    public Response mo13902a() throws IOException {
        synchronized (this) {
            if (!this.f5705f) {
                this.f5705f = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        m7335g();
        this.f5704e.mo14044a((Call) this);
        try {
            this.f5700a.mo14137s().mo14040a(this);
            Response f = mo13908f();
            if (f != null) {
                this.f5700a.mo14137s().mo14042b(this);
                return f;
            }
            throw new IOException("Canceled");
        } catch (IOException e) {
            this.f5704e.mo14050a((Call) this, e);
            throw e;
        } catch (Throwable th) {
            this.f5700a.mo14137s().mo14042b(this);
            throw th;
        }
    }

    /* renamed from: g */
    private void m7335g() {
        this.f5701b.mo13746a(Platform.m7295b().mo13870a("response.body().close()"));
    }

    /* renamed from: b */
    public boolean mo13903b() {
        return this.f5701b.mo13747a();
    }

    /* renamed from: c */
    public RealCall clone() {
        return m7333a(this.f5700a, this.f5702c, this.f5703d);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public String mo13906d() {
        StringBuilder sb = new StringBuilder();
        sb.append(mo13903b() ? "canceled " : "");
        sb.append(this.f5703d ? "web socket" : NotificationCompat.CATEGORY_CALL);
        sb.append(" to ");
        sb.append(mo13907e());
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public String mo13907e() {
        return this.f5702c.mo13910a().mo14100m();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public Response mo13908f() throws IOException {
        ArrayList arrayList = new ArrayList(this.f5700a.mo14140v());
        arrayList.add(this.f5701b);
        arrayList.add(new BridgeInterceptor(this.f5700a.mo14124f()));
        arrayList.add(new CacheInterceptor(this.f5700a.mo14125g()));
        arrayList.add(new ConnectInterceptor(this.f5700a));
        if (!this.f5703d) {
            arrayList.addAll(this.f5700a.mo14141w());
        }
        arrayList.add(new CallServerInterceptor(this.f5703d));
        RealInterceptorChain gVar = new RealInterceptorChain(arrayList, null, null, null, 0, this.f5702c, this, this.f5704e, this.f5700a.mo14118a(), this.f5700a.mo14120b(), this.f5700a.mo14121c());
        return gVar.mo13733a(this.f5702c);
    }
}
