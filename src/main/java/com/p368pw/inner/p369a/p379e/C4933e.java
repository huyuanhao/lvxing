package com.p368pw.inner.p369a.p379e;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.base.p387d.C5208r;
import com.p368pw.inner.base.p387d.p391d.C5183b;
import com.p368pw.inner.p369a.p370a.p371a.C4827e;
import com.p368pw.inner.p369a.p379e.C4942g.C4954c;
import com.p368pw.inner.p369a.p379e.C4942g.C4956e;
import com.p368pw.inner.p369a.p379e.p380a.p381a.C4914b;
import com.p368pw.inner.p369a.p379e.p380a.p381a.C4920e.C4922a;
import com.p368pw.view.VideoAdActivity;

/* renamed from: com.pw.inner.a.e.e */
public class C4933e {
    /* access modifiers changed from: private */
    /* renamed from: A */
    public C4956e f15960A = new C4956e() {
        /* renamed from: a */
        public void mo26155a() {
            C4960j.m20732a(C4933e.this.f15976m, C4933e.this.f15970g, 13);
        }

        /* renamed from: a */
        public void mo26156a(int i) {
            C5205o.m21462a("vad onEventClose");
            if (C4933e.this.f15971h != null) {
                C4933e.this.f15971h.mo25788a(i);
            }
        }

        /* renamed from: a */
        public void mo26157a(C5183b bVar, boolean z) {
            C5205o.m21462a("vad event skip");
            if (C4933e.this.f15971h != null) {
                C4933e.this.f15971h.mo25803h();
            }
            if (!TextUtils.isEmpty(C4933e.this.f15970g.mo26239l())) {
                C4960j.m20733a(C4933e.this.f15976m, C4933e.this.f15970g, 1, bVar, C4933e.this.f15971h, C4933e.this.f15961B, z);
            }
            C4960j.m20732a(C4933e.this.f15976m, C4933e.this.f15970g, 8);
        }

        /* renamed from: b */
        public void mo26158b() {
            C4960j.m20732a(C4933e.this.f15976m, C4933e.this.f15970g, 14);
        }

        /* renamed from: b */
        public void mo26159b(C5183b bVar, boolean z) {
            C5205o.m21462a("vad down click");
            C4960j.m20733a(C4933e.this.f15976m, C4933e.this.f15970g, 1, bVar, C4933e.this.f15971h, C4933e.this.f15961B, z);
            if (C4933e.this.f15971h != null) {
                C4933e.this.f15971h.mo25806k();
            }
        }

        /* renamed from: c */
        public void mo26160c() {
            C4960j.m20732a(C4933e.this.f15976m, C4933e.this.f15970g, 15);
        }

        /* renamed from: d */
        public void mo26161d() {
            C4960j.m20732a(C4933e.this.f15976m, C4933e.this.f15970g, 16);
        }
    };
    /* access modifiers changed from: private */
    /* renamed from: B */
    public C4940a f15961B = new C4940a() {
        /* renamed from: a */
        public void mo26162a(int i) {
        }

        /* renamed from: a */
        public void mo26163a(String str, String str2) {
            if (C4933e.this.f15975l != null) {
                C4933e.this.f15975l.mo26196w();
            }
        }

        /* renamed from: b */
        public void mo26164b(String str, String str2) {
            if (C4933e.this.f15975l != null) {
                C4933e.this.f15975l.mo26194u();
            }
        }
    };
    /* access modifiers changed from: private */
    /* renamed from: C */
    public C4914b f15962C = new C4922a() {
        /* renamed from: b */
        public void mo26068b(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("vad onPrepareFailed = ");
            sb.append(str);
            C5205o.m21462a(sb.toString());
        }

        /* renamed from: d */
        public void mo26069d(int i) {
            if (C4933e.this.f15971h != null) {
                C4933e.this.f15971h.mo25797c(i);
            }
        }

        /* renamed from: e */
        public void mo26070e(int i) {
            if (C4933e.this.f15971h != null) {
                C4933e.this.f15971h.mo25793b(i);
            }
            C4960j.m20731a(C4933e.this.f15976m, i, C4933e.this.f15970g);
        }

        /* renamed from: g */
        public void mo26071g() {
            C5205o.m21462a("vad onBufferStart");
        }

        /* renamed from: h */
        public void mo26072h() {
            C5205o.m21462a("vad onBufferEnd");
        }

        /* renamed from: i */
        public void mo26073i() {
            C5205o.m21462a("vad onPrepareSuccess");
            if (C4933e.this.f15972i != null) {
                C4933e.this.f15972i.mo26127a();
            }
        }

        /* renamed from: j */
        public void mo26074j() {
            C5205o.m21462a("vad onRestarted");
        }

        /* renamed from: k */
        public void mo26075k() {
            C5205o.m21462a("vad onPlayCompleted");
            C5208r.m21479a(new Runnable() {
                public void run() {
                    if (C4933e.this.f15971h != null) {
                        C4933e.this.f15971h.mo25796c();
                    }
                }
            });
        }

        /* renamed from: l */
        public void mo26076l() {
            C5205o.m21462a("vad onPlayStart");
            if (C4933e.this.f15971h != null) {
                C4933e.this.f15971h.mo25804i();
            }
            C4960j.m20732a(C4933e.this.f15976m, C4933e.this.f15970g, 2);
        }

        /* renamed from: m */
        public void mo26077m() {
            C5205o.m21462a("vad onPlayerDestroy");
        }
    };
    /* access modifiers changed from: private */
    /* renamed from: D */
    public C4954c f15963D = new C4954c() {
        /* renamed from: a */
        public void mo26166a() {
            C5205o.m21462a("vad onEndpageShowed");
            if (C4933e.this.f15971h != null) {
                C4933e.this.f15971h.mo25801f();
            }
            C4960j.m20732a(C4933e.this.f15976m, C4933e.this.f15970g, 7);
        }

        /* renamed from: a */
        public void mo26125a(String str, C5183b bVar, boolean z) {
            StringBuilder sb = new StringBuilder();
            sb.append("vad onEndpageValidClick: ");
            sb.append(str);
            C5205o.m21462a(sb.toString());
            if (!str.equals("video://close")) {
                str.equals("video://retain.close");
            }
            C4960j.m20733a(C4933e.this.f15976m, C4933e.this.f15970g, 1, bVar, C4933e.this.f15971h, C4933e.this.f15961B, z);
            if (C4933e.this.f15971h != null) {
                C4933e.this.f15971h.mo25794b(str);
            }
            if (!C4933e.this.f15975l.mo26197x()) {
                C4933e.this.f15975l.f16013a = true;
                C4933e.this.f15975l.getClickViewGroup().performClick();
            }
        }

        /* renamed from: b */
        public void mo26167b() {
            C5205o.m21462a("vad onRetainpageShowed");
            if (C4933e.this.f15971h != null) {
                C4933e.this.f15971h.mo25802g();
            }
        }

        /* renamed from: s */
        public void mo26126s() {
            C5205o.m21462a("vad onEndpageClose");
        }
    };
    /* renamed from: a */
    public boolean f15964a = false;
    /* renamed from: b */
    public boolean f15965b = false;
    /* renamed from: c */
    public boolean f15966c = false;
    /* renamed from: d */
    public boolean f15967d = false;
    /* renamed from: e */
    public boolean f15968e = false;
    /* renamed from: f */
    public boolean f15969f = false;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public C4958h f15970g;
    /* access modifiers changed from: private */
    /* renamed from: h */
    public C4827e f15971h;
    /* access modifiers changed from: private */
    /* renamed from: i */
    public C4931c f15972i;
    /* access modifiers changed from: private */
    /* renamed from: j */
    public int f15973j = 2;
    /* access modifiers changed from: private */
    /* renamed from: k */
    public int f15974k = 1;
    /* access modifiers changed from: private */
    /* renamed from: l */
    public C4942g f15975l;
    /* access modifiers changed from: private */
    /* renamed from: m */
    public Context f15976m;
    /* access modifiers changed from: private */
    /* renamed from: n */
    public String f15977n;
    /* access modifiers changed from: private */
    /* renamed from: o */
    public boolean f15978o = true;
    /* access modifiers changed from: private */
    /* renamed from: p */
    public int f15979p = 15;
    /* access modifiers changed from: private */
    /* renamed from: q */
    public int f15980q = 0;
    /* access modifiers changed from: private */
    /* renamed from: r */
    public int f15981r = 0;
    /* access modifiers changed from: private */
    /* renamed from: s */
    public String f15982s;
    /* access modifiers changed from: private */
    /* renamed from: t */
    public String f15983t = "app";
    /* access modifiers changed from: private */
    /* renamed from: u */
    public String f15984u = "~~~";
    /* access modifiers changed from: private */
    /* renamed from: v */
    public String f15985v;
    /* renamed from: w */
    private String f15986w;
    /* access modifiers changed from: private */
    /* renamed from: x */
    public String f15987x;
    /* renamed from: y */
    private int f15988y;
    /* renamed from: z */
    private int f15989z = -1;

    /* renamed from: com.pw.inner.a.e.e$a */
    public interface C4940a {
        /* renamed from: a */
        void mo26162a(int i);

        /* renamed from: a */
        void mo26163a(String str, String str2);

        /* renamed from: b */
        void mo26164b(String str, String str2);
    }

    public C4933e(Context context) {
        this.f15976m = context;
        this.f15988y = System.identityHashCode(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public C4964k m20476a(Context context) {
        if (TextUtils.isEmpty(this.f15982s)) {
            this.f15982s = "";
        }
        int q = this.f15970g.mo26245q();
        String str = q == 111 ? "https://adx-api.zzpolarb.com/static/adtemp/video_end_rain_0.html" : "https://adx-api.zzpolarb.com/static/adtemp/video_0.html";
        if (q == 112) {
            str = "https://adx-api.zzpolarb.com/static/adtemp/video_end_marquee_0.html";
        }
        if (q == 113) {
            str = "https://adx-api.zzpolarb.com/static/adtemp/video_3.html";
        }
        if (q == 114) {
            str = "https://adx-api.zzpolarb.com/static/adtemp/video_end_marquee_1.html";
        }
        return new C4964k(context).mo26279b(this.f15982s).mo26281c(this.f15983t).mo26284d(this.f15984u).mo26286e(this.f15987x).mo26276a(1).mo26287f(this.f15985v).mo26278b(this.f15973j).mo26288g(str).mo26277a(context);
    }

    /* renamed from: h */
    private void m20485h() {
        C5208r.m21479a(new Runnable() {
            public void run() {
                C4933e eVar = C4933e.this;
                C4942g t = new C4942g(eVar.f15976m).mo26193t();
                C4933e eVar2 = C4933e.this;
                eVar.f15975l = t.mo26172a(eVar2.m20476a(eVar2.f15976m)).mo26053a(C4933e.this.f15962C).mo26171a(C4933e.this.f15960A).mo26170a(C4933e.this.f15963D).mo26055a(C4933e.this.f15977n).mo26056a(C4933e.this.f15978o).mo26189h(C4933e.this.f15979p).mo26061c(C4933e.this.f15980q).mo26058b(C4933e.this.f15981r).mo26182d(C4933e.this.f15982s).mo26173a(C4933e.this.f15983t, C4933e.this.f15984u).mo26168a(C4933e.this.f15973j, C4933e.this.f15974k).mo26183e(C4933e.this.f15985v).mo26185f(C4933e.this.f15987x).mo26175b(C4933e.this.f15970g.mo26245q(), C4933e.this.f15970g.mo26246r()).mo26051a();
            }
        });
    }

    /* renamed from: a */
    public void mo26144a() {
        m20485h();
        C4960j.m20732a(this.f15976m, this.f15970g, 0);
    }

    /* renamed from: a */
    public void mo26145a(Context context, C4931c cVar) {
        this.f15972i = cVar;
        mo26144a();
    }

    /* renamed from: a */
    public void mo26146a(C4827e eVar, int i) {
        if (!this.f15969f) {
            this.f15971h = eVar;
            this.f15989z = i;
            mo26148b();
            C4827e eVar2 = this.f15971h;
            if (eVar2 != null) {
                eVar2.mo25787a();
            }
            C4960j.m20732a(this.f15976m, this.f15970g, 1);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a2 A[Catch:{ all -> 0x00c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b6 A[Catch:{ all -> 0x00c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c0 A[Catch:{ all -> 0x00c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    public void mo26147a(com.p368pw.inner.p369a.p379e.C4958h r3, int r4, int r5, int r6, int r7) {
        /*
        r2 = this;
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c4 }
        r0.<init>()     // Catch:{ all -> 0x00c4 }
        java.lang.String r1 = "vad skipsec = "
        r0.append(r1)     // Catch:{ all -> 0x00c4 }
        r0.append(r4)     // Catch:{ all -> 0x00c4 }
        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00c4 }
        com.p368pw.inner.base.p387d.C5205o.m21462a(r0)     // Catch:{ all -> 0x00c4 }
        r2.f15970g = r3     // Catch:{ all -> 0x00c4 }
        r2.f15973j = r5     // Catch:{ all -> 0x00c4 }
        r2.f15974k = r6     // Catch:{ all -> 0x00c4 }
        com.pw.inner.a.e.h r3 = r2.f15970g     // Catch:{ all -> 0x00c4 }
        java.lang.String r3 = r3.mo26214a()     // Catch:{ all -> 0x00c4 }
        r2.f15977n = r3     // Catch:{ all -> 0x00c4 }
        int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00c4 }
        r5 = 28
        if (r3 < r5) goto L_0x0034
        java.lang.String r3 = r2.f15977n     // Catch:{ all -> 0x00c4 }
        java.lang.String r5 = "http://"
        java.lang.String r6 = "https://"
        java.lang.String r3 = r3.replace(r5, r6)     // Catch:{ all -> 0x00c4 }
        r2.f15977n = r3     // Catch:{ all -> 0x00c4 }
    L_0x0034:
        if (r4 <= 0) goto L_0x0038
        r2.f15979p = r4     // Catch:{ all -> 0x00c4 }
    L_0x0038:
        com.pw.inner.a.e.h r3 = r2.f15970g     // Catch:{ all -> 0x00c4 }
        java.lang.String r3 = r3.mo26231h()     // Catch:{ all -> 0x00c4 }
        boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x00c4 }
        if (r3 != 0) goto L_0x004c
        com.pw.inner.a.e.h r3 = r2.f15970g     // Catch:{ all -> 0x00c4 }
        java.lang.String r3 = r3.mo26231h()     // Catch:{ all -> 0x00c4 }
        r2.f15982s = r3     // Catch:{ all -> 0x00c4 }
    L_0x004c:
        com.pw.inner.a.e.h r3 = r2.f15970g     // Catch:{ all -> 0x00c4 }
        java.lang.String r3 = r3.mo26235j()     // Catch:{ all -> 0x00c4 }
        boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x00c4 }
        if (r3 != 0) goto L_0x0060
        com.pw.inner.a.e.h r3 = r2.f15970g     // Catch:{ all -> 0x00c4 }
        java.lang.String r3 = r3.mo26235j()     // Catch:{ all -> 0x00c4 }
        r2.f15983t = r3     // Catch:{ all -> 0x00c4 }
    L_0x0060:
        com.pw.inner.a.e.h r3 = r2.f15970g     // Catch:{ all -> 0x00c4 }
        java.lang.String r3 = r3.mo26233i()     // Catch:{ all -> 0x00c4 }
        boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x00c4 }
        if (r3 != 0) goto L_0x0074
        com.pw.inner.a.e.h r3 = r2.f15970g     // Catch:{ all -> 0x00c4 }
        java.lang.String r3 = r3.mo26233i()     // Catch:{ all -> 0x00c4 }
        r2.f15984u = r3     // Catch:{ all -> 0x00c4 }
    L_0x0074:
        com.pw.inner.a.e.h r3 = r2.f15970g     // Catch:{ all -> 0x00c4 }
        int r3 = r3.mo26215b()     // Catch:{ all -> 0x00c4 }
        r4 = 1
        if (r3 != r4) goto L_0x0086
        com.pw.inner.a.e.h r3 = r2.f15970g     // Catch:{ all -> 0x00c4 }
        java.lang.String r3 = r3.mo26220c()     // Catch:{ all -> 0x00c4 }
    L_0x0083:
        r2.f15986w = r3     // Catch:{ all -> 0x00c4 }
        goto L_0x0096
    L_0x0086:
        com.pw.inner.a.e.h r3 = r2.f15970g     // Catch:{ all -> 0x00c4 }
        int r3 = r3.mo26215b()     // Catch:{ all -> 0x00c4 }
        r4 = 2
        if (r3 != r4) goto L_0x0096
        com.pw.inner.a.e.h r3 = r2.f15970g     // Catch:{ all -> 0x00c4 }
        java.lang.String r3 = r3.mo26223d()     // Catch:{ all -> 0x00c4 }
        goto L_0x0083
    L_0x0096:
        com.pw.inner.a.e.h r3 = r2.f15970g     // Catch:{ all -> 0x00c4 }
        java.lang.String r3 = r3.mo26229g()     // Catch:{ all -> 0x00c4 }
        boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x00c4 }
        if (r3 != 0) goto L_0x00aa
        com.pw.inner.a.e.h r3 = r2.f15970g     // Catch:{ all -> 0x00c4 }
        java.lang.String r3 = r3.mo26229g()     // Catch:{ all -> 0x00c4 }
        r2.f15985v = r3     // Catch:{ all -> 0x00c4 }
    L_0x00aa:
        com.pw.inner.a.e.h r3 = r2.f15970g     // Catch:{ all -> 0x00c4 }
        java.lang.String r3 = r3.mo26239l()     // Catch:{ all -> 0x00c4 }
        boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x00c4 }
        if (r3 != 0) goto L_0x00be
        com.pw.inner.a.e.h r3 = r2.f15970g     // Catch:{ all -> 0x00c4 }
        java.lang.String r3 = r3.mo26239l()     // Catch:{ all -> 0x00c4 }
        r2.f15987x = r3     // Catch:{ all -> 0x00c4 }
    L_0x00be:
        if (r7 != 0) goto L_0x00c8
        r3 = 0
        r2.f15978o = r3     // Catch:{ all -> 0x00c4 }
        goto L_0x00c8
    L_0x00c4:
        r3 = move-exception
        com.p368pw.inner.base.p387d.C5205o.m21464a(r3)
    L_0x00c8:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p368pw.inner.p369a.p379e.C4933e.mo26147a(com.pw.inner.a.e.h, int, int, int, int):void");
    }

    /* renamed from: b */
    public void mo26148b() {
        C4941f.m20537a(this.f15988y, this);
        Intent intent = new Intent(this.f15976m, VideoAdActivity.class);
        intent.putExtra(VideoAdActivity.PARAMS_IDENTITY_HASHCODE, this.f15988y);
        intent.putExtra(VideoAdActivity.PARAMS_VIDEO_ORIENTATION, 1);
        intent.putExtra(VideoAdActivity.PARAMS_SETTING_ORIENTATION, this.f15989z);
        intent.addFlags(268435456);
        this.f15976m.startActivity(intent);
    }

    /* renamed from: c */
    public C4958h mo26149c() {
        return this.f15970g;
    }

    /* renamed from: d */
    public int mo26150d() {
        C4942g gVar = this.f15975l;
        if (gVar == null) {
            return 0;
        }
        return gVar.getDuration();
    }

    /* renamed from: e */
    public int mo26151e() {
        C4942g gVar = this.f15975l;
        if (gVar == null) {
            return 0;
        }
        return gVar.getCurrentPosition();
    }

    /* renamed from: f */
    public C4942g mo26152f() {
        return this.f15975l;
    }

    /* renamed from: g */
    public void mo26153g() {
        C5205o.m21462a("vad destroy VideoAd:");
        this.f15969f = true;
        C4827e eVar = this.f15971h;
        if (eVar != null) {
            eVar.mo25792b();
        }
    }
}
