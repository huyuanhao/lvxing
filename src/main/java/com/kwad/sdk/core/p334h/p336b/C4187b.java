package com.kwad.sdk.core.p334h.p336b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.net.NetworkInfo;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.ksad.download.p297c.C3607b;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.p334h.C4199c;
import com.kwad.sdk.core.p334h.p335a.C4172b;
import com.kwad.sdk.core.p334h.p335a.C4174c;
import com.kwad.sdk.core.p334h.p335a.C4174c.C4175a;
import com.kwad.sdk.core.p334h.p335a.C4174c.C4176b;
import com.kwad.sdk.core.p334h.p335a.C4174c.C4177c;
import com.kwad.sdk.core.p334h.p335a.C4174c.C4178d;
import com.kwad.sdk.core.p334h.p335a.C4174c.C4179e;
import com.kwad.sdk.core.p334h.p335a.C4174c.C4182h;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.p306a.C3810m;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.kwad.sdk.core.h.b.b */
public class C4187b extends AdBaseFrameLayout implements SurfaceTextureListener, C4198d {
    /* renamed from: o */
    private static AtomicBoolean f13933o = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    /* renamed from: a */
    public int f13934a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public Context f13935b;
    /* renamed from: c */
    private AudioManager f13936c;
    /* renamed from: d */
    private C4174c f13937d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public FrameLayout f13938e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public C4199c f13939f;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public C4195c f13940g;
    /* renamed from: h */
    private SurfaceTexture f13941h;
    /* renamed from: i */
    private Surface f13942i;
    /* access modifiers changed from: private */
    /* renamed from: j */
    public String f13943j;
    /* renamed from: k */
    private Map<String, String> f13944k;
    /* access modifiers changed from: private */
    /* renamed from: l */
    public int f13945l;
    /* access modifiers changed from: private */
    /* renamed from: m */
    public boolean f13946m;
    /* access modifiers changed from: private */
    /* renamed from: n */
    public long f13947n;
    /* renamed from: p */
    private boolean f13948p;
    /* access modifiers changed from: private */
    /* renamed from: q */
    public boolean f13949q;
    /* renamed from: r */
    private C4179e f13950r;
    /* renamed from: s */
    private C4182h f13951s;
    /* renamed from: t */
    private C4176b f13952t;
    /* renamed from: u */
    private C4177c f13953u;
    /* renamed from: v */
    private C4178d f13954v;
    /* renamed from: w */
    private C4175a f13955w;
    /* renamed from: x */
    private BroadcastReceiver f13956x;

    public C4187b(Context context) {
        this(context, null);
    }

    public C4187b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13934a = 0;
        this.f13946m = false;
        this.f13948p = false;
        this.f13949q = false;
        this.f13950r = new C4179e() {
            /* renamed from: a */
            public void mo23545a(C4174c cVar) {
                C4187b.this.f13934a = 2;
                C4187b.this.f13940g.mo23931a(C4187b.this.f13934a);
                C4065b.m16867b("KSVideoPlayerViewView", "onPrepared ——> STATE_PREPARED");
                cVar.mo23908f();
                if (C4187b.this.f13946m) {
                    cVar.mo23902a((long) ((int) C3810m.m15799a(C4187b.this.f13935b, C4187b.this.f13943j)));
                }
                if (C4187b.this.f13947n != 0) {
                    cVar.mo23902a((long) ((int) C4187b.this.f13947n));
                }
            }
        };
        this.f13951s = new C4182h() {
            /* renamed from: a */
            public void mo23546a(C4174c cVar, int i, int i2) {
                if (!C4187b.this.f13949q || i2 <= i) {
                    C4187b.this.f13939f.mo23973a(i, i2);
                    StringBuilder sb = new StringBuilder();
                    sb.append("onVideoSizeChanged ——> width：");
                    sb.append(i);
                    sb.append("， height：");
                    sb.append(i2);
                    C4065b.m16867b("KSVideoPlayerViewView", sb.toString());
                }
            }
        };
        this.f13952t = new C4176b() {
            /* renamed from: a */
            public void mo23547a(C4174c cVar) {
                C4187b.this.f13934a = 7;
                C4187b.this.f13940g.mo23931a(C4187b.this.f13934a);
                C4065b.m16867b("KSVideoPlayerViewView", "onCompletion ——> STATE_COMPLETED");
                C4187b.this.f13938e.setKeepScreenOn(false);
            }
        };
        this.f13953u = new C4177c() {
            /* renamed from: a */
            public boolean mo23548a(C4174c cVar, int i, int i2) {
                if (!(i == -38 || i == Integer.MIN_VALUE || i2 == -38 || i2 == Integer.MIN_VALUE)) {
                    C4187b.this.f13934a = -1;
                    C4187b.this.f13940g.mo23931a(C4187b.this.f13934a);
                    StringBuilder sb = new StringBuilder();
                    sb.append("onError ——> STATE_ERROR ———— what：");
                    sb.append(i);
                    sb.append(", extra: ");
                    sb.append(i2);
                    C4065b.m16867b("KSVideoPlayerViewView", sb.toString());
                }
                return true;
            }
        };
        this.f13954v = new C4178d() {
            /* renamed from: a */
            public boolean mo23549a(C4174c cVar, int i, int i2) {
                StringBuilder sb;
                String sb2;
                String str;
                String str2 = "KSVideoPlayerViewView";
                if (i == 3) {
                    C4187b.this.f13934a = 3;
                    C4187b.this.f13940g.mo23931a(C4187b.this.f13934a);
                    sb2 = "onInfo ——> MEDIA_INFO_VIDEO_RENDERING_START：STATE_PLAYING";
                } else {
                    if (i == 701) {
                        if (C4187b.this.f13934a == 4 || C4187b.this.f13934a == 6) {
                            C4187b.this.f13934a = 6;
                            str = "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PAUSED";
                        } else {
                            C4187b.this.f13934a = 5;
                            str = "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PLAYING";
                        }
                        C4065b.m16867b(str2, str);
                        C4187b.this.f13940g.mo23931a(C4187b.this.f13934a);
                    } else if (i == 702) {
                        if (C4187b.this.f13934a == 5) {
                            C4187b.this.f13934a = 3;
                            C4187b.this.f13940g.mo23931a(C4187b.this.f13934a);
                            C4065b.m16867b(str2, "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PLAYING");
                        }
                        if (C4187b.this.f13934a == 6) {
                            C4187b.this.f13934a = 4;
                            C4187b.this.f13940g.mo23931a(C4187b.this.f13934a);
                            sb2 = "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PAUSED";
                        }
                    } else {
                        if (i == 10001) {
                            if (C4187b.this.f13939f != null) {
                                C4187b.this.f13939f.setRotation((float) i2);
                                sb = new StringBuilder();
                                sb.append("视频旋转角度：");
                                sb.append(i2);
                            }
                        } else if (i == 801) {
                            sb2 = "视频不能seekTo，为直播视频";
                        } else {
                            sb = new StringBuilder();
                            sb.append("onInfo ——> what：");
                            sb.append(i);
                        }
                        sb2 = sb.toString();
                    }
                    return true;
                }
                C4065b.m16867b(str2, sb2);
                return true;
            }
        };
        this.f13955w = new C4175a() {
            /* renamed from: a */
            public void mo23550a(C4174c cVar, int i) {
                C4187b.this.f13945l = i;
            }
        };
        this.f13956x = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                NetworkInfo c = C3607b.m15047c(context);
                if (c != null) {
                    c.isConnected();
                }
            }
        };
        this.f13935b = context;
        m17373l();
    }

    /* renamed from: l */
    private void m17373l() {
        this.f13938e = new FrameLayout(this.f13935b);
        addView(this.f13938e, new LayoutParams(-1, -1));
    }

    /* renamed from: m */
    private void m17374m() {
        if (this.f13937d == null) {
            this.f13937d = new C4172b();
            this.f13937d.mo23906b(3);
            if (!this.f13948p) {
                this.f13937d.mo23901a(0.0f, 0.0f);
            }
        }
    }

    /* renamed from: n */
    private void m17375n() {
        if (this.f13939f == null) {
            this.f13939f = new C4199c(this.f13935b);
            this.f13939f.setSurfaceTextureListener(this);
        }
    }

    /* renamed from: o */
    private void m17376o() {
        this.f13938e.removeView(this.f13939f);
        this.f13938e.addView(this.f13939f, 0, new LayoutParams(-1, -1, 17));
    }

    /* renamed from: p */
    private void m17377p() {
        String str = "KSVideoPlayerViewView";
        this.f13938e.setKeepScreenOn(true);
        this.f13937d.mo23893a(this.f13950r);
        this.f13937d.mo23895a(this.f13951s);
        this.f13937d.mo23890a(this.f13952t);
        this.f13937d.mo23891a(this.f13953u);
        this.f13937d.mo23892a(this.f13954v);
        this.f13937d.mo23889a(this.f13955w);
        try {
            this.f13937d.mo23904a(this.f13943j);
            if (this.f13942i == null) {
                this.f13942i = new Surface(this.f13941h);
            }
            this.f13937d.mo23903a(this.f13942i);
            this.f13937d.mo23907e();
            this.f13934a = 1;
            this.f13940g.mo23931a(this.f13934a);
            C4065b.m16867b(str, "STATE_PREPARING");
        } catch (IOException e) {
            C4065b.m16865a(e);
            C4065b.m16864a(str, "打开播放器发生错误", e);
        }
    }

    /* renamed from: a */
    public void mo23943a() {
        if (this.f13934a == 0) {
            m17374m();
            m17375n();
            m17376o();
            return;
        }
        C4065b.m16867b("KSVideoPlayerViewView", "KSVideoPlayer只有在状态为STATE_IDLE时才能调用start方法.");
    }

    /* renamed from: a */
    public void mo23944a(String str, Map<String, String> map) {
        this.f13943j = str;
        this.f13944k = map;
    }

    /* renamed from: b */
    public void mo23945b() {
        String sb;
        int i = this.f13934a;
        String str = "KSVideoPlayerViewView";
        if (i == 4) {
            this.f13937d.mo23908f();
            this.f13934a = 3;
            this.f13940g.mo23931a(this.f13934a);
            sb = "STATE_PLAYING";
        } else if (i == 6) {
            this.f13937d.mo23908f();
            this.f13934a = 5;
            this.f13940g.mo23931a(this.f13934a);
            sb = "STATE_BUFFERING_PLAYING";
        } else if (i == 7 || i == -1) {
            this.f13937d.mo23914l();
            m17377p();
            return;
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("KSVideoPlayer在状态为 ");
            sb2.append(this.f13934a);
            sb2.append(" 时不能调用restart()方法.");
            sb = sb2.toString();
        }
        C4065b.m16867b(str, sb);
    }

    /* renamed from: c */
    public void mo23946c() {
        String str = "KSVideoPlayerViewView";
        if (this.f13934a == 3) {
            this.f13937d.mo23909g();
            this.f13934a = 4;
            this.f13940g.mo23931a(this.f13934a);
            C4065b.m16867b(str, "STATE_PAUSED");
        }
        if (this.f13934a == 5) {
            this.f13937d.mo23909g();
            this.f13934a = 6;
            this.f13940g.mo23931a(this.f13934a);
            C4065b.m16867b(str, "STATE_BUFFERING_PAUSED");
        }
    }

    /* renamed from: d */
    public boolean mo23947d() {
        return this.f13934a == 0;
    }

    /* renamed from: e */
    public boolean mo23948e() {
        return this.f13934a == 5;
    }

    /* renamed from: f */
    public boolean mo23949f() {
        return this.f13934a == 6;
    }

    /* renamed from: g */
    public boolean mo23950g() {
        return this.f13934a == 3;
    }

    public int getBufferPercentage() {
        return this.f13945l;
    }

    public long getCurrentPosition() {
        C4174c cVar = this.f13937d;
        if (cVar != null) {
            return cVar.mo23911i();
        }
        return 0;
    }

    public long getDuration() {
        C4174c cVar = this.f13937d;
        if (cVar != null) {
            return cVar.mo23912j();
        }
        return 0;
    }

    public int getMaxVolume() {
        AudioManager audioManager = this.f13936c;
        if (audioManager != null) {
            return audioManager.getStreamMaxVolume(3);
        }
        return 0;
    }

    public int getVolume() {
        AudioManager audioManager = this.f13936c;
        if (audioManager != null) {
            return audioManager.getStreamVolume(3);
        }
        return 0;
    }

    /* renamed from: h */
    public boolean mo23956h() {
        return this.f13934a == 4;
    }

    /* renamed from: i */
    public boolean mo23957i() {
        return this.f13934a == 7;
    }

    /* renamed from: j */
    public void mo23958j() {
        AudioManager audioManager = this.f13936c;
        if (audioManager != null) {
            audioManager.abandonAudioFocus(null);
            this.f13936c = null;
        }
        C4174c cVar = this.f13937d;
        if (cVar != null) {
            cVar.mo23913k();
            this.f13937d = null;
        }
        this.f13938e.removeView(this.f13939f);
        Surface surface = this.f13942i;
        if (surface != null) {
            surface.release();
            this.f13942i = null;
        }
        SurfaceTexture surfaceTexture = this.f13941h;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.f13941h = null;
        }
        this.f13934a = 0;
    }

    /* renamed from: k */
    public void mo23959k() {
        long j;
        String str;
        Context context;
        if (this.f13946m) {
            if (mo23950g() || mo23948e() || mo23949f() || mo23956h()) {
                context = this.f13935b;
                str = this.f13943j;
                j = getCurrentPosition();
            } else if (mo23957i()) {
                context = this.f13935b;
                str = this.f13943j;
                j = 0;
            }
            C3810m.m15800a(context, str, j);
        }
        mo23958j();
        C4195c cVar = this.f13940g;
        if (cVar != null) {
            cVar.mo23933c();
        }
        Runtime.getRuntime().gc();
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        SurfaceTexture surfaceTexture2 = this.f13941h;
        if (surfaceTexture2 == null) {
            this.f13941h = surfaceTexture;
            m17377p();
            return;
        }
        this.f13939f.setSurfaceTexture(surfaceTexture2);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void setController(C4195c cVar) {
        this.f13938e.removeView(this.f13940g);
        this.f13940g = cVar;
        this.f13940g.mo23933c();
        this.f13938e.addView(this.f13940g, new LayoutParams(-1, -1));
    }

    public void setPortraitFullscreen(boolean z) {
        this.f13949q = z;
    }

    public void setVideoSoundEnable(boolean z) {
        this.f13948p = z;
    }

    public void setVolume(int i) {
        AudioManager audioManager = this.f13936c;
        if (audioManager != null) {
            audioManager.setStreamVolume(3, i, 0);
        }
    }
}
