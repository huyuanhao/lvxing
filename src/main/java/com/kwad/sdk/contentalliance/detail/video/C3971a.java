package com.kwad.sdk.contentalliance.detail.video;

import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.p334h.p335a.C4172b;
import com.kwad.sdk.core.p334h.p335a.C4174c;
import com.kwad.sdk.core.p334h.p335a.C4174c.C4175a;
import com.kwad.sdk.core.p334h.p335a.C4174c.C4176b;
import com.kwad.sdk.core.p334h.p335a.C4174c.C4177c;
import com.kwad.sdk.core.p334h.p335a.C4174c.C4178d;
import com.kwad.sdk.core.p334h.p335a.C4174c.C4179e;
import com.kwad.sdk.core.p334h.p335a.C4174c.C4180f;
import com.kwad.sdk.core.p334h.p335a.C4174c.C4182h;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.kwad.sdk.contentalliance.detail.video.a */
public class C3971a {
    /* access modifiers changed from: private|static */
    /* renamed from: a */
    public static String f13367a = "DetailMediaPlayerImpl";
    /* access modifiers changed from: private */
    /* renamed from: b */
    public int f13368b = 0;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public C4174c f13369c;
    /* renamed from: d */
    private Surface f13370d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public int f13371e;
    /* renamed from: f */
    private long f13372f;
    /* renamed from: g */
    private Timer f13373g;
    /* renamed from: h */
    private TimerTask f13374h;
    /* access modifiers changed from: private */
    /* renamed from: i */
    public Handler f13375i = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    /* renamed from: j */
    public DetailVideoView f13376j;
    /* access modifiers changed from: private */
    /* renamed from: k */
    public int f13377k;
    /* access modifiers changed from: private */
    /* renamed from: l */
    public int f13378l;
    /* access modifiers changed from: private */
    /* renamed from: m */
    public List<C4179e> f13379m = new ArrayList();
    /* renamed from: n */
    private C4179e f13380n = new C4179e() {
        /* renamed from: a */
        public void mo23545a(C4174c cVar) {
            C3971a.this.f13368b = 2;
            C3971a aVar = C3971a.this;
            aVar.mo23522a(aVar.f13368b);
            C4065b.m16867b(C3971a.f13367a, "onPrepared ——> STATE_PREPARED");
            for (C4179e a : C3971a.this.f13379m) {
                a.mo23545a(C3971a.this.f13369c);
            }
        }
    };
    /* renamed from: o */
    private C4182h f13381o = new C4182h() {
        /* renamed from: a */
        public void mo23546a(C4174c cVar, int i, int i2) {
            C3971a.this.f13376j.mo23513a(i, i2);
            String q = C3971a.f13367a;
            StringBuilder sb = new StringBuilder();
            sb.append("onVideoSizeChanged ——> width：");
            sb.append(i);
            sb.append("， height：");
            sb.append(i2);
            C4065b.m16867b(q, sb.toString());
        }
    };
    /* renamed from: p */
    private C4176b f13382p = new C4176b() {
        /* renamed from: a */
        public void mo23547a(C4174c cVar) {
            C3971a.this.f13368b = 9;
            C3971a aVar = C3971a.this;
            aVar.mo23522a(aVar.f13368b);
            C4065b.m16867b(C3971a.f13367a, "onCompletion ——> STATE_COMPLETED");
            C3971a.this.f13376j.setKeepScreenOn(true);
        }
    };
    /* renamed from: q */
    private C4177c f13383q = new C4177c() {
        /* renamed from: a */
        public boolean mo23548a(C4174c cVar, int i, int i2) {
            if (!(i == -38 || i == Integer.MIN_VALUE || i2 == -38 || i2 == Integer.MIN_VALUE)) {
                C3971a.this.f13368b = -1;
                C3971a.this.f13377k = i;
                C3971a.this.f13378l = i2;
                C3971a aVar = C3971a.this;
                aVar.mo23522a(aVar.f13368b);
                String q = C3971a.f13367a;
                StringBuilder sb = new StringBuilder();
                sb.append("onError ——> STATE_ERROR ———— what：");
                sb.append(i);
                sb.append(", extra: ");
                sb.append(i2);
                C4065b.m16867b(q, sb.toString());
            }
            return true;
        }
    };
    /* renamed from: r */
    private C4178d f13384r = new C4178d() {
        /* renamed from: a */
        public boolean mo23549a(C4174c cVar, int i, int i2) {
            String q;
            String sb;
            String str;
            String str2;
            if (i == 3) {
                C3971a.this.f13368b = 4;
                C3971a aVar = C3971a.this;
                aVar.mo23522a(aVar.f13368b);
                q = C3971a.f13367a;
                sb = "onInfo ——> MEDIA_INFO_VIDEO_RENDERING_START：STATE_PLAYING";
            } else {
                if (i == 701) {
                    if (C3971a.this.f13368b == 5 || C3971a.this.f13368b == 7) {
                        C3971a.this.f13368b = 7;
                        str2 = C3971a.f13367a;
                        str = "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PAUSED";
                    } else {
                        C3971a.this.f13368b = 6;
                        str2 = C3971a.f13367a;
                        str = "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PLAYING";
                    }
                    C4065b.m16867b(str2, str);
                    C3971a aVar2 = C3971a.this;
                    aVar2.mo23522a(aVar2.f13368b);
                } else if (i == 702) {
                    if (C3971a.this.f13368b == 6) {
                        C3971a.this.f13368b = 4;
                        C3971a aVar3 = C3971a.this;
                        aVar3.mo23522a(aVar3.f13368b);
                        C4065b.m16867b(C3971a.f13367a, "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PLAYING");
                    }
                    if (C3971a.this.f13368b == 7) {
                        C3971a.this.f13368b = 5;
                        C3971a aVar4 = C3971a.this;
                        aVar4.mo23522a(aVar4.f13368b);
                        q = C3971a.f13367a;
                        sb = "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PAUSED";
                    }
                } else if (i != 10001) {
                    if (i == 801) {
                        q = C3971a.f13367a;
                        sb = "视频不能seekTo，为直播视频";
                    } else {
                        q = C3971a.f13367a;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("onInfo ——> what：");
                        sb2.append(i);
                        sb = sb2.toString();
                    }
                }
                return true;
            }
            C4065b.m16867b(q, sb);
            return true;
        }
    };
    /* renamed from: s */
    private C4175a f13385s = new C4175a() {
        /* renamed from: a */
        public void mo23550a(C4174c cVar, int i) {
            C3971a.this.f13371e = i;
        }
    };
    /* renamed from: t */
    private List<C3989e> f13386t = new ArrayList();

    /* renamed from: com.kwad.sdk.contentalliance.detail.video.a$a */
    public interface C3981a {
        /* renamed from: a */
        void mo23554a();
    }

    public C3971a(DetailVideoView detailVideoView) {
        this.f13376j = detailVideoView;
    }

    /* renamed from: r */
    private void m16443r() {
        C4174c cVar = this.f13369c;
        if (cVar != null) {
            cVar.mo23891a((C4177c) null);
            this.f13369c.mo23890a((C4176b) null);
            this.f13369c.mo23893a((C4179e) null);
            this.f13369c.mo23892a((C4178d) null);
            this.f13369c.mo23894a((C4180f) null);
            this.f13369c.mo23889a((C4175a) null);
        }
    }

    /* renamed from: s */
    private void m16444s() {
        C4174c cVar = this.f13369c;
        if (cVar != null) {
            cVar.mo23901a(0.0f, 0.0f);
            this.f13369c.mo23903a((Surface) null);
            m16443r();
        }
    }

    /* renamed from: t */
    private void m16445t() {
        m16446u();
        if (this.f13373g == null) {
            this.f13373g = new Timer();
        }
        if (this.f13374h == null) {
            this.f13374h = new TimerTask() {
                public void run() {
                    C3971a.this.f13375i.post(new Runnable() {
                        public void run() {
                            C3971a.this.m16447v();
                        }
                    });
                }
            };
        }
        this.f13373g.schedule(this.f13374h, 0, 1000);
    }

    /* renamed from: u */
    private void m16446u() {
        Timer timer = this.f13373g;
        if (timer != null) {
            timer.cancel();
            this.f13373g = null;
        }
        TimerTask timerTask = this.f13374h;
        if (timerTask != null) {
            timerTask.cancel();
            this.f13374h = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: v */
    public void m16447v() {
        long o = mo23543o();
        long n = mo23542n();
        for (C3989e a : this.f13386t) {
            a.mo23345a(n, o);
        }
    }

    /* renamed from: a */
    public C4174c mo23520a() {
        return this.f13369c;
    }

    /* renamed from: a */
    public void mo23521a(float f, float f2) {
        C4174c cVar = this.f13369c;
        if (cVar != null) {
            cVar.mo23901a(f, f2);
        }
    }

    /* renamed from: a */
    public void mo23522a(int i) {
        switch (i) {
            case -1:
                m16446u();
                for (C3989e a : this.f13386t) {
                    a.mo23377a(this.f13377k, this.f13378l);
                }
                return;
            case 1:
                for (C3989e d : this.f13386t) {
                    d.mo23378d();
                }
                return;
            case 2:
                for (C3989e h : this.f13386t) {
                    h.mo23571h();
                }
                return;
            case 3:
                for (C3989e c : this.f13386t) {
                    c.mo23347c();
                }
                return;
            case 4:
                for (C3989e a2 : this.f13386t) {
                    a2.mo23373a();
                }
                return;
            case 5:
                for (C3989e g : this.f13386t) {
                    g.mo23431g();
                }
                return;
            case 6:
                for (C3989e f : this.f13386t) {
                    f.mo23380f();
                }
                return;
            case 7:
                for (C3989e e : this.f13386t) {
                    e.mo23379e();
                }
                return;
            case 9:
                m16446u();
                for (C3989e b : this.f13386t) {
                    b.mo23346b();
                }
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public void mo23523a(Surface surface) {
        this.f13370d = surface;
        C4174c cVar = this.f13369c;
        if (cVar != null) {
            cVar.mo23903a(surface);
        }
    }

    /* renamed from: a */
    public void mo23524a(final C3981a aVar) {
        if (this.f13369c != null) {
            this.f13376j.setKeepScreenOn(false);
            this.f13375i.removeCallbacksAndMessages(null);
            m16446u();
            m16444s();
            final C4174c cVar = this.f13369c;
            if (cVar != null) {
                new Thread() {
                    public void run() {
                        cVar.mo23913k();
                        C3981a aVar = aVar;
                        if (aVar != null) {
                            aVar.mo23554a();
                        }
                    }
                }.start();
                this.f13369c = null;
            }
            this.f13368b = 0;
        }
    }

    /* renamed from: a */
    public void mo23525a(C3989e eVar) {
        this.f13386t.add(eVar);
    }

    /* renamed from: a */
    public void mo23526a(C4179e eVar) {
        this.f13379m.add(eVar);
    }

    /* renamed from: a */
    public void mo23527a(String str) {
        try {
            this.f13369c.mo23904a(str);
        } catch (Exception e) {
            C4065b.m16865a(e);
        }
    }

    /* renamed from: b */
    public void mo23528b() {
        this.f13370d = this.f13376j.f13362b;
        this.f13376j.setMediaPlayer(this);
        this.f13369c = new C4172b();
        this.f13369c.mo23905a(false);
        this.f13369c.mo23903a(this.f13370d);
        this.f13369c.mo23906b(3);
        mo23531c();
    }

    /* renamed from: b */
    public void mo23529b(C3989e eVar) {
        this.f13386t.remove(eVar);
    }

    /* renamed from: b */
    public void mo23530b(String str) {
        String str2 = "resetAndPlay";
        if (this.f13369c == null) {
            C4065b.m16868c(str2, "mMediaPlayer is null");
            return;
        }
        int i = this.f13368b;
        if (i == 2 || i == 3 || i == 4 || i == 5) {
            StringBuilder sb = new StringBuilder();
            sb.append("can not resetAndPlay in sate:");
            sb.append(this.f13368b);
            C4065b.m16868c(str2, sb.toString());
            return;
        }
        mo23538j();
        mo23527a(str);
        m16443r();
        mo23531c();
        mo23534f();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo23531c() {
        this.f13369c.mo23893a(this.f13380n);
        this.f13369c.mo23895a(this.f13381o);
        this.f13369c.mo23890a(this.f13382p);
        this.f13369c.mo23891a(this.f13383q);
        this.f13369c.mo23892a(this.f13384r);
        this.f13369c.mo23889a(this.f13385s);
    }

    /* renamed from: d */
    public boolean mo23532d() {
        int i = this.f13368b;
        return i == 2 || i == 3 || i == 5 || i == 7 || i == 9;
    }

    /* renamed from: e */
    public boolean mo23533e() {
        return this.f13368b == 1;
    }

    /* renamed from: f */
    public void mo23534f() {
        this.f13376j.setKeepScreenOn(true);
        try {
            this.f13369c.mo23907e();
            this.f13368b = 1;
            mo23522a(this.f13368b);
            C4065b.m16867b(f13367a, "STATE_PREPARING");
        } catch (IllegalStateException e) {
            C4065b.m16865a(e);
        }
    }

    /* renamed from: g */
    public void mo23535g() {
        this.f13369c.mo23908f();
        long j = this.f13372f;
        if (j != 0) {
            this.f13369c.mo23902a((long) ((int) j));
        }
        this.f13368b = 3;
        mo23522a(this.f13368b);
        C4065b.m16867b(f13367a, "STATE_STARTED");
        m16445t();
    }

    /* renamed from: h */
    public void mo23536h() {
        if (this.f13368b == 9 && this.f13369c != null) {
            mo23535g();
        }
    }

    /* renamed from: i */
    public void mo23537i() {
        String str;
        String sb;
        int i = this.f13368b;
        if (i == 2) {
            mo23535g();
            return;
        }
        if (i == 5) {
            this.f13369c.mo23908f();
            this.f13368b = 4;
            mo23522a(this.f13368b);
            str = f13367a;
            sb = "STATE_PAUSED-->STATE_PLAYING";
        } else if (i == 7) {
            this.f13369c.mo23908f();
            this.f13368b = 6;
            mo23522a(this.f13368b);
            str = f13367a;
            sb = "STATE_BUFFERING_PAUSED-->STATE_BUFFERING_PLAYING";
        } else if (i != 4 && i != 9) {
            str = f13367a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("KSVideoPlayer在mCurrentState == ");
            sb2.append(this.f13368b);
            sb2.append("时不能调用restart()方法.");
            sb = sb2.toString();
        } else {
            return;
        }
        C4065b.m16867b(str, sb);
    }

    /* renamed from: j */
    public void mo23538j() {
        this.f13369c.mo23914l();
        this.f13368b = 0;
    }

    /* renamed from: k */
    public boolean mo23539k() {
        C4174c cVar = this.f13369c;
        if (cVar != null) {
            return cVar.mo23910h();
        }
        return false;
    }

    /* renamed from: l */
    public void mo23540l() {
        String str = f13367a;
        StringBuilder sb = new StringBuilder();
        sb.append("pause mCurrentState=");
        sb.append(this.f13368b);
        C4065b.m16867b(str, sb.toString());
        if (this.f13368b == 4) {
            this.f13369c.mo23909g();
            this.f13368b = 5;
            mo23522a(this.f13368b);
            C4065b.m16867b(f13367a, "STATE_PAUSED");
        }
        if (this.f13368b == 6) {
            this.f13369c.mo23909g();
            this.f13368b = 7;
            mo23522a(this.f13368b);
            C4065b.m16867b(f13367a, "STATE_BUFFERING_PAUSED");
        }
        if (this.f13368b == 3) {
            this.f13369c.mo23909g();
            this.f13368b = 5;
            mo23522a(this.f13368b);
            C4065b.m16867b(f13367a, "STATE_STARTED -> STATE_PAUSED");
        }
    }

    /* renamed from: m */
    public void mo23541m() {
        mo23524a((C3981a) null);
    }

    /* renamed from: n */
    public long mo23542n() {
        C4174c cVar = this.f13369c;
        if (cVar != null) {
            return cVar.mo23912j();
        }
        return 0;
    }

    /* renamed from: o */
    public long mo23543o() {
        C4174c cVar = this.f13369c;
        if (cVar != null) {
            return cVar.mo23911i();
        }
        return 0;
    }

    /* renamed from: p */
    public void mo23544p() {
        this.f13386t.clear();
    }
}
