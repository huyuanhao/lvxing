package com.p368pw.inner.p369a.p379e.p380a.p381a;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.base.p387d.C5208r;
import com.p368pw.inner.p369a.p379e.p380a.p381a.C4920e.C4922a;
import com.p368pw.inner.p369a.p379e.p380a.p381a.C4920e.C4923b;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.pw.inner.a.e.a.a.d */
public class C4916d implements OnBufferingUpdateListener, OnCompletionListener, OnErrorListener, OnPreparedListener, OnVideoSizeChangedListener, C4913a {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public MediaPlayer f15883a = new MediaPlayer();
    /* renamed from: b */
    private Timer f15884b;
    /* renamed from: c */
    private C4919a f15885c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public boolean f15886d;
    /* renamed from: e */
    private int f15887e = -1;
    /* access modifiers changed from: private|volatile */
    /* renamed from: f */
    public volatile boolean f15888f = false;
    /* renamed from: g */
    private int f15889g;
    /* access modifiers changed from: private */
    /* renamed from: h */
    public String f15890h;
    /* renamed from: i */
    private boolean f15891i = false;
    /* renamed from: j */
    private boolean f15892j = false;
    /* renamed from: k */
    private C4914b f15893k;
    /* renamed from: l */
    private C4923b f15894l;
    /* renamed from: m */
    private int f15895m;
    /* renamed from: n */
    private int f15896n;
    /* access modifiers changed from: private */
    /* renamed from: o */
    public boolean f15897o = false;
    /* access modifiers changed from: private */
    /* renamed from: p */
    public boolean f15898p = true;
    /* renamed from: q */
    private boolean f15899q = false;

    /* renamed from: com.pw.inner.a.e.a.a.d$a */
    private class C4919a extends TimerTask {
        /* renamed from: a */
        int f15903a;

        private C4919a() {
            this.f15903a = C4916d.this.f15883a.getDuration();
        }

        public void run() {
            try {
                int currentPosition = C4916d.this.f15883a.getCurrentPosition();
                if (currentPosition >= 0) {
                    if (currentPosition <= this.f15903a) {
                        if (C4916d.this.f15898p && currentPosition > 0) {
                            C4916d.this.f15898p = false;
                            C4916d.this.m20351j().mo26076l();
                        }
                        C4916d.this.m20351j().mo26069d(currentPosition);
                        if (currentPosition <= 0 || C4916d.this.f15888f) {
                            int i = (currentPosition * 100) / this.f15903a;
                            if ((currentPosition / 1000) + 1 != this.f15903a / 1000 || C4916d.this.f15886d) {
                                C4916d.this.m20347f(i);
                            } else {
                                C5205o.m21462a("mp callback 100 percent");
                                C4916d.this.f15886d = true;
                                C4916d.this.m20347f(100);
                                C4916d.this.m20353l();
                                C4916d.this.m20351j().mo26075k();
                            }
                        } else {
                            C4916d.this.m20351j().mo26072h();
                            C4916d.this.f15888f = true;
                            C5205o.m21462a("mp callback 0 percent");
                            C4916d.this.m20347f(0);
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public C4916d() {
        this.f15883a.setOnCompletionListener(this);
        this.f15883a.setOnErrorListener(this);
        this.f15883a.setOnPreparedListener(this);
        this.f15883a.setOnVideoSizeChangedListener(this);
        this.f15883a.setAudioStreamType(3);
        this.f15883a.setScreenOnWhilePlaying(true);
        this.f15883a.setOnBufferingUpdateListener(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m20347f(int i) {
        if (i > this.f15887e) {
            this.f15887e = i;
            m20351j().mo26070e(i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public C4914b m20351j() {
        if (this.f15893k == null) {
            this.f15893k = new C4922a();
        }
        return this.f15893k;
    }

    /* renamed from: k */
    private void m20352k() {
        m20353l();
        this.f15884b = new Timer();
        this.f15885c = new C4919a();
        StringBuilder sb = new StringBuilder();
        sb.append("mp duration: ");
        sb.append(this.f15883a.getDuration());
        C5205o.m21462a(sb.toString());
        this.f15884b.scheduleAtFixedRate(this.f15885c, 0, 20);
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m20353l() {
        try {
            if (this.f15884b != null) {
                this.f15884b.cancel();
            }
            if (this.f15885c != null) {
                this.f15885c.cancel();
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: a */
    public C4913a mo26052a(int i) {
        return this;
    }

    /* renamed from: a */
    public C4913a mo26054a(C4915c cVar) {
        return this;
    }

    /* renamed from: a */
    public void mo26057a(SurfaceHolder surfaceHolder) {
        C5205o.m21462a("mp restart");
        this.f15892j = true;
        try {
            if (TextUtils.isEmpty(this.f15890h)) {
                m20351j().mo26068b("dataUrl can't be empty.");
                return;
            }
            if (!this.f15883a.isPlaying()) {
                this.f15883a.reset();
                this.f15883a.setDataSource(this.f15890h);
                this.f15883a.setDisplay(surfaceHolder);
                this.f15883a.prepareAsync();
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: b */
    public C4913a mo26059b(SurfaceHolder surfaceHolder) {
        this.f15883a.setDisplay(surfaceHolder);
        return this;
    }

    /* renamed from: b */
    public C4916d mo26053a(C4914b bVar) {
        this.f15893k = bVar;
        return this;
    }

    /* renamed from: b */
    public C4916d mo26055a(String str) {
        this.f15890h = str;
        return this;
    }

    /* renamed from: b */
    public C4916d mo26056a(boolean z) {
        if (z) {
            try {
                this.f15883a.setVolume(1.0f, 1.0f);
            } catch (Exception e) {
                C5205o.m21464a((Throwable) e);
            }
        } else {
            this.f15883a.setVolume(0.0f, 0.0f);
        }
        return this;
    }

    /* renamed from: b */
    public void mo26060b() {
        if (this.f15897o && !this.f15891i) {
            StringBuilder sb = new StringBuilder();
            sb.append("mp play, play time: ");
            sb.append(System.currentTimeMillis());
            C5205o.m21462a(sb.toString());
            m20351j().mo26071g();
            this.f15883a.start();
            m20352k();
        }
    }

    /* renamed from: c */
    public void mo26062c() {
        C5205o.m21462a("mp resume");
        if (this.f15891i && !this.f15892j && this.f15897o) {
            this.f15891i = false;
            this.f15892j = true;
            this.f15883a.start();
            m20352k();
        }
    }

    /* renamed from: c */
    public void mo26086c(SurfaceHolder surfaceHolder) {
        try {
            C5205o.m21462a("mp restore");
            this.f15899q = true;
            if (!this.f15883a.isPlaying()) {
                this.f15883a.reset();
                this.f15883a.setDataSource(this.f15890h);
                this.f15883a.setDisplay(surfaceHolder);
                this.f15883a.prepareAsync();
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: d */
    public C4916d mo26058b(int i) {
        return this;
    }

    /* renamed from: d */
    public void mo26063d() {
        this.f15891i = true;
        this.f15892j = false;
        try {
            if (this.f15883a != null && this.f15883a.isPlaying()) {
                m20353l();
                this.f15889g = this.f15883a.getCurrentPosition();
                this.f15883a.pause();
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: e */
    public C4916d mo26061c(int i) {
        return this;
    }

    /* renamed from: e */
    public void mo26064e() {
        try {
            if (this.f15883a != null) {
                if (this.f15883a.isPlaying()) {
                    this.f15883a.stop();
                }
                this.f15883a.release();
                this.f15883a = null;
                m20353l();
                this.f15884b = null;
                this.f15885c = null;
                this.f15893k = null;
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: f */
    public boolean mo26065f() {
        try {
            return this.f15883a != null && this.f15883a.isPlaying();
        } catch (Throwable th) {
            C5205o.m21464a(th);
            return false;
        }
    }

    /* renamed from: g */
    public int mo26089g() {
        return this.f15895m;
    }

    public int getCurrentPosition() {
        return this.f15883a.getCurrentPosition();
    }

    public int getDuration() {
        if (this.f15897o) {
            return this.f15883a.getDuration();
        }
        return 0;
    }

    /* renamed from: h */
    public int mo26090h() {
        return this.f15896n;
    }

    /* renamed from: i */
    public C4916d mo26051a() {
        try {
            if (TextUtils.isEmpty(this.f15890h)) {
                m20351j().mo26068b("video url can't be empty");
                return this;
            }
            C5208r.m21483b(new Runnable() {
                public void run() {
                    try {
                        if (!C4916d.this.f15897o) {
                            C4916d.this.f15883a.reset();
                            C4916d.this.f15883a.setDataSource(C4916d.this.f15890h);
                            C4916d.this.f15883a.prepare();
                            StringBuilder sb = new StringBuilder();
                            sb.append("mp prepare: ");
                            sb.append(C4916d.this.f15890h);
                            C5205o.m21462a(sb.toString());
                        }
                    } catch (Throwable th) {
                        C5208r.m21479a(new Runnable() {
                            public void run() {
                                C4916d.this.m20351j().mo26068b(th.getMessage());
                            }
                        });
                        C5205o.m21464a(th);
                    }
                }
            }, 0);
            return this;
        } catch (Exception e) {
            m20351j().mo26068b(e.getMessage());
            C5205o.m21464a((Throwable) e);
        }
    }

    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        C5205o.m21462a("mp onComplete");
        this.f15889g = this.f15883a.getCurrentPosition();
        this.f15883a.seekTo(this.f15889g);
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        C5205o.m21462a("mp onError");
        try {
            m20351j().mo26068b(String.format("what:%d,extra:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        } catch (Throwable unused) {
        }
        return false;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        C5205o.m21462a("mp onPrepared");
        if (this.f15883a != null) {
            this.f15895m = mediaPlayer.getVideoWidth();
            this.f15896n = mediaPlayer.getVideoHeight();
            StringBuilder sb = new StringBuilder();
            sb.append("mp video width = ");
            sb.append(this.f15895m);
            sb.append(", height = ");
            sb.append(this.f15896n);
            C5205o.m21462a(sb.toString());
            if (this.f15892j) {
                this.f15883a.seekTo(this.f15889g);
                this.f15883a.start();
                m20352k();
                m20351j().mo26074j();
            } else if (this.f15899q) {
                this.f15883a.seekTo(this.f15889g);
            } else {
                this.f15897o = true;
                m20351j().mo26073i();
            }
        }
    }

    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        C5205o.m21462a("mp onVideoSizeChanged");
        C4923b bVar = this.f15894l;
        if (bVar != null) {
            bVar.mo26113a(mediaPlayer, i, i2);
        }
    }
}
