package com.kwad.sdk.core.p334h.p335a;

import android.media.MediaDataSource;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.MediaPlayer.OnTimedTextListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.media.TimedText;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Surface;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* renamed from: com.kwad.sdk.core.h.a.b */
public class C4172b extends C4171a {
    /* renamed from: a */
    private final MediaPlayer f13913a;
    /* renamed from: b */
    private final C4173a f13914b;
    /* renamed from: c */
    private String f13915c;
    /* renamed from: d */
    private MediaDataSource f13916d;
    /* renamed from: e */
    private final Object f13917e = new Object();
    /* renamed from: f */
    private boolean f13918f;

    /* renamed from: com.kwad.sdk.core.h.a.b$a */
    private class C4173a implements OnBufferingUpdateListener, OnCompletionListener, OnErrorListener, OnInfoListener, OnPreparedListener, OnSeekCompleteListener, OnTimedTextListener, OnVideoSizeChangedListener {
        /* renamed from: a */
        final WeakReference<C4172b> f13919a;

        C4173a(C4172b bVar) {
            this.f13919a = new WeakReference<>(bVar);
        }

        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (((C4172b) this.f13919a.get()) != null) {
                C4172b.this.mo23886a(i);
            }
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            if (((C4172b) this.f13919a.get()) != null) {
                C4172b.this.mo23898c();
            }
        }

        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            return ((C4172b) this.f13919a.get()) != null && C4172b.this.mo23897b(i, i2);
        }

        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            return ((C4172b) this.f13919a.get()) != null && C4172b.this.mo23899c(i, i2);
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            if (((C4172b) this.f13919a.get()) != null) {
                C4172b.this.mo23896b();
            }
        }

        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (((C4172b) this.f13919a.get()) != null) {
                C4172b.this.mo23900d();
            }
        }

        public void onTimedText(MediaPlayer mediaPlayer, TimedText timedText) {
            if (((C4172b) this.f13919a.get()) != null) {
                C4172b.this.mo23888a(timedText);
            }
        }

        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            if (((C4172b) this.f13919a.get()) != null) {
                C4172b.this.mo23887a(i, i2);
            }
        }
    }

    public C4172b() {
        synchronized (this.f13917e) {
            this.f13913a = new MediaPlayer();
        }
        this.f13913a.setAudioStreamType(3);
        this.f13914b = new C4173a(this);
        m17285n();
    }

    /* renamed from: m */
    private void m17284m() {
        MediaDataSource mediaDataSource = this.f13916d;
        if (mediaDataSource != null) {
            try {
                mediaDataSource.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.f13916d = null;
        }
    }

    /* renamed from: n */
    private void m17285n() {
        this.f13913a.setOnPreparedListener(this.f13914b);
        this.f13913a.setOnBufferingUpdateListener(this.f13914b);
        this.f13913a.setOnCompletionListener(this.f13914b);
        this.f13913a.setOnSeekCompleteListener(this.f13914b);
        this.f13913a.setOnVideoSizeChangedListener(this.f13914b);
        this.f13913a.setOnErrorListener(this.f13914b);
        this.f13913a.setOnInfoListener(this.f13914b);
        this.f13913a.setOnTimedTextListener(this.f13914b);
    }

    /* renamed from: a */
    public void mo23901a(float f, float f2) {
        this.f13913a.setVolume(f, f2);
    }

    /* renamed from: a */
    public void mo23902a(long j) {
        this.f13913a.seekTo((int) j);
    }

    /* renamed from: a */
    public void mo23903a(Surface surface) {
        this.f13913a.setSurface(surface);
    }

    /* renamed from: a */
    public void mo23904a(String str) {
        this.f13915c = str;
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (TextUtils.isEmpty(scheme) || !scheme.equalsIgnoreCase("file")) {
            this.f13913a.setDataSource(str);
        } else {
            this.f13913a.setDataSource(parse.getPath());
        }
    }

    /* renamed from: a */
    public void mo23905a(boolean z) {
        this.f13913a.setLooping(z);
    }

    /* renamed from: b */
    public void mo23906b(int i) {
        this.f13913a.setAudioStreamType(i);
    }

    /* renamed from: e */
    public void mo23907e() {
        this.f13913a.prepareAsync();
    }

    /* renamed from: f */
    public void mo23908f() {
        this.f13913a.start();
    }

    /* renamed from: g */
    public void mo23909g() {
        this.f13913a.pause();
    }

    /* renamed from: h */
    public boolean mo23910h() {
        try {
            return this.f13913a.isPlaying();
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    /* renamed from: i */
    public long mo23911i() {
        try {
            return (long) this.f13913a.getCurrentPosition();
        } catch (IllegalStateException unused) {
            return 0;
        }
    }

    /* renamed from: j */
    public long mo23912j() {
        try {
            return (long) this.f13913a.getDuration();
        } catch (IllegalStateException unused) {
            return 0;
        }
    }

    /* renamed from: k */
    public void mo23913k() {
        this.f13918f = true;
        this.f13913a.release();
        m17284m();
        mo23885a();
        m17285n();
    }

    /* renamed from: l */
    public void mo23914l() {
        try {
            this.f13913a.reset();
        } catch (IllegalStateException unused) {
        }
        m17284m();
        mo23885a();
        m17285n();
    }
}
