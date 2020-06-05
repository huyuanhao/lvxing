package com.kwad.sdk.core.p334h;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.p334h.C4183b.C4184a;
import java.io.IOException;

/* renamed from: com.kwad.sdk.core.h.a */
public class C4164a implements C4183b {
    /* renamed from: a */
    private MediaPlayer f13893a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public TextureView f13894b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public SurfaceTexture f13895c;
    /* renamed from: d */
    private Surface f13896d;
    /* renamed from: e */
    private String f13897e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public C4184a f13898f;

    public C4164a(TextureView textureView) {
        this.f13894b = textureView;
    }

    /* renamed from: j */
    private void m17250j() {
        if (this.f13893a == null) {
            this.f13893a = new MediaPlayer();
            this.f13893a.setAudioStreamType(3);
            this.f13893a.setOnPreparedListener(new OnPreparedListener() {
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mediaPlayer.start();
                    C4065b.m16867b("DefaultAdVideoPlayer", "onPrepared");
                    if (C4164a.this.f13898f != null) {
                        C4164a.this.f13898f.mo23925a(C4164a.this);
                    }
                }
            });
            this.f13893a.setOnInfoListener(new OnInfoListener() {
                public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("onInfo,what:--extra:");
                    sb.append(i2);
                    C4065b.m16867b("DefaultAdVideoPlayer", sb.toString());
                    return true;
                }
            });
            this.f13893a.setOnBufferingUpdateListener(new OnBufferingUpdateListener() {
                public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                    if (C4164a.this.f13898f != null) {
                        C4164a.this.f13898f.mo23926a(C4164a.this, i);
                    }
                }
            });
            this.f13893a.setOnCompletionListener(new OnCompletionListener() {
                public void onCompletion(MediaPlayer mediaPlayer) {
                    C4065b.m16867b("DefaultAdVideoPlayer", "onCompletion");
                    if (C4164a.this.f13898f != null) {
                        C4164a.this.f13898f.mo23929c(C4164a.this);
                    }
                }
            });
            this.f13893a.setOnErrorListener(new OnErrorListener() {
                public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("onError,what:--extra:");
                    sb.append(i2);
                    C4065b.m16867b("DefaultAdVideoPlayer", sb.toString());
                    if (!(i == -38 || i == Integer.MIN_VALUE || i2 == -38 || i2 == Integer.MIN_VALUE || C4164a.this.f13898f == null)) {
                        C4164a.this.f13898f.mo23927a(C4164a.this, i, i2);
                    }
                    return true;
                }
            });
        }
    }

    /* renamed from: k */
    private void m17251k() {
        this.f13894b.setSurfaceTextureListener(new SurfaceTextureListener() {
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (C4164a.this.f13895c == null) {
                    C4164a.this.f13895c = surfaceTexture;
                    C4164a.this.m17252l();
                    return;
                }
                C4164a.this.f13894b.setSurfaceTexture(C4164a.this.f13895c);
            }

            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                return false;
            }

            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m17252l() {
        try {
            this.f13893a.setDataSource(this.f13897e);
            if (this.f13896d == null) {
                this.f13896d = new Surface(this.f13895c);
            }
            this.f13893a.setSurface(this.f13896d);
            this.f13893a.prepareAsync();
        } catch (IOException e) {
            C4065b.m16865a(e);
            C4065b.m16864a("DefaultAdVideoPlayer", "打开播放器发生错误", e);
        }
    }

    /* renamed from: m */
    private void m17253m() {
        MediaPlayer mediaPlayer = this.f13893a;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.f13893a = null;
        }
        Surface surface = this.f13896d;
        if (surface != null) {
            surface.release();
            this.f13896d = null;
        }
        SurfaceTexture surfaceTexture = this.f13895c;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.f13895c = null;
        }
    }

    /* renamed from: n */
    private void m17254n() {
        this.f13893a.setVolume(0.0f, 0.0f);
    }

    /* renamed from: o */
    private void m17255o() {
        this.f13893a.setVolume(1.0f, 1.0f);
    }

    /* renamed from: a */
    public void mo23864a(C4184a aVar) {
        this.f13898f = aVar;
    }

    /* renamed from: a */
    public void mo23865a(String str) {
        try {
            this.f13897e = str;
            m17250j();
            m17251k();
        } catch (Exception e) {
            C4065b.m16865a(e);
        }
    }

    /* renamed from: a */
    public void mo23866a(boolean z) {
        if (z) {
            m17255o();
        } else {
            m17254n();
        }
    }

    /* renamed from: a */
    public boolean mo23867a() {
        return this.f13893a.isPlaying();
    }

    /* renamed from: b */
    public void mo23868b() {
        if (this.f13893a.isPlaying()) {
            this.f13893a.stop();
            this.f13893a.reset();
            C4184a aVar = this.f13898f;
            if (aVar != null) {
                aVar.mo23928b(this);
            }
        }
    }

    /* renamed from: c */
    public void mo23869c() {
        m17253m();
    }

    /* renamed from: d */
    public void mo23870d() {
        this.f13893a.pause();
    }

    /* renamed from: e */
    public void mo23871e() {
        this.f13893a.start();
    }

    /* renamed from: f */
    public int mo23872f() {
        return this.f13893a.getVideoWidth();
    }

    /* renamed from: g */
    public int mo23873g() {
        return this.f13893a.getVideoHeight();
    }

    /* renamed from: h */
    public long mo23874h() {
        return (long) this.f13893a.getDuration();
    }

    /* renamed from: i */
    public long mo23875i() {
        return (long) this.f13893a.getCurrentPosition();
    }
}
