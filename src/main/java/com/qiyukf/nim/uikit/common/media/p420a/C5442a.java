package com.qiyukf.nim.uikit.common.media.p420a;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Handler;
import android.text.TextUtils;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.nimlib.sdk.media.player.AudioPlayer;
import com.qiyukf.nimlib.sdk.media.player.OnPlayListener;
import com.qiyukf.unicorn.C5961R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.qiyukf.nim.uikit.common.media.a.a */
public abstract class C5442a<T> {
    /* renamed from: a */
    protected boolean f17446a = true;
    /* renamed from: b */
    protected final List<C5445a> f17447b = new ArrayList();
    /* renamed from: c */
    protected Context f17448c;
    /* renamed from: d */
    protected AudioPlayer f17449d;
    /* renamed from: e */
    protected C5447b f17450e;
    /* renamed from: f */
    protected boolean f17451f = false;
    /* renamed from: g */
    protected long f17452g;
    /* renamed from: h */
    protected Handler f17453h = new Handler();
    /* renamed from: i */
    Runnable f17454i = new Runnable() {
        public final void run() {
            if (C5442a.this.f17449d == null) {
                C5264a.m21617a("AudioRecorder", "playRunnable run when currentAudioPlayer == null");
                return;
            }
            C5442a.this.f17449d.start(C5442a.this.f17460o);
        }
    };
    /* access modifiers changed from: private */
    /* renamed from: j */
    public int f17455j;
    /* access modifiers changed from: private */
    /* renamed from: k */
    public MediaPlayer f17456k = null;
    /* renamed from: l */
    private boolean f17457l = false;
    /* renamed from: m */
    private C5446b f17458m = null;
    /* renamed from: n */
    private int f17459n;
    /* access modifiers changed from: private */
    /* renamed from: o */
    public int f17460o;

    /* renamed from: com.qiyukf.nim.uikit.common.media.a.a$a */
    public interface C5445a {
        /* renamed from: a */
        void mo27442a(C5447b bVar);

        /* renamed from: b */
        void mo27443b(C5447b bVar);
    }

    /* renamed from: com.qiyukf.nim.uikit.common.media.a.a$b */
    public class C5446b implements OnPlayListener {
        /* renamed from: a */
        protected AudioPlayer f17463a;
        /* renamed from: b */
        protected C5447b f17464b;

        public C5446b(AudioPlayer audioPlayer, C5447b bVar) {
            this.f17463a = audioPlayer;
            this.f17464b = bVar;
        }

        /* access modifiers changed from: protected|final */
        /* renamed from: a */
        public final boolean mo27444a() {
            return C5442a.this.f17449d == this.f17463a;
        }

        public void onCompletion() {
            if (mo27444a()) {
                C5442a.this.mo27434c();
                C5442a aVar = C5442a.this;
                aVar.mo27433b(aVar.f17450e);
                C5442a.this.mo27427a();
            }
        }

        public void onError(String str) {
            if (mo27444a()) {
                C5442a.this.mo27434c();
                C5442a aVar = C5442a.this;
                aVar.mo27433b(aVar.f17450e);
            }
        }

        public void onInterrupt() {
            if (mo27444a()) {
                C5442a.this.mo27434c();
                C5442a aVar = C5442a.this;
                aVar.mo27433b(aVar.f17450e);
            }
        }

        public void onPlaying(long j) {
            if (mo27444a()) {
                C5442a.this.mo27439h();
            }
        }

        public void onPrepared() {
            if (mo27444a()) {
                C5442a.this.f17455j = 2;
                if (C5442a.this.f17451f) {
                    C5442a aVar = C5442a.this;
                    aVar.f17451f = false;
                    this.f17463a.seekTo((int) aVar.f17452g);
                }
            }
        }
    }

    public C5442a(Context context) {
        this.f17448c = context;
        this.f17457l = true;
    }

    /* renamed from: a */
    private void m22225a(int i) {
        if (this.f17449d.isPlaying()) {
            this.f17452g = this.f17449d.getCurrentPosition();
            this.f17451f = true;
            this.f17460o = i;
            this.f17449d.start(i);
            return;
        }
        this.f17460o = this.f17459n;
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final void mo27427a() {
        if (this.f17457l) {
            this.f17456k = MediaPlayer.create(this.f17448c, C5961R.raw.ysf_audio_end_tip);
            this.f17456k.setLooping(false);
            this.f17456k.setAudioStreamType(3);
            this.f17456k.setOnCompletionListener(new OnCompletionListener() {
                public final void onCompletion(MediaPlayer mediaPlayer) {
                    C5442a.this.f17456k.release();
                    C5442a.this.f17456k = null;
                }
            });
            this.f17456k.start();
        }
    }

    /* renamed from: a */
    public final void mo27428a(C5445a aVar) {
        synchronized (this.f17447b) {
            this.f17447b.add(aVar);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo27429a(C5447b bVar) {
        this.f17458m = new C5446b<>(this.f17449d, bVar);
        this.f17449d.setOnPlayListener(this.f17458m);
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final boolean mo27430a(C5447b bVar, int i, boolean z, long j) {
        String b = bVar.mo27452b();
        if (TextUtils.isEmpty(b)) {
            return false;
        }
        if (mo27435d()) {
            mo27436e();
            if (this.f17450e.mo27451a(bVar)) {
                return false;
            }
        }
        this.f17455j = 0;
        this.f17450e = bVar;
        this.f17449d = new AudioPlayer(this.f17448c);
        this.f17449d.setDataSource(b);
        mo27429a(this.f17450e);
        if (z) {
            this.f17459n = i;
        }
        this.f17460o = i;
        this.f17453h.postDelayed(this.f17454i, j);
        this.f17455j = 1;
        C5447b bVar2 = this.f17450e;
        synchronized (this.f17447b) {
            for (C5445a a : this.f17447b) {
                a.mo27442a(bVar2);
            }
        }
        return true;
    }

    /* renamed from: b */
    public final int mo27431b() {
        return this.f17460o;
    }

    /* renamed from: b */
    public final void mo27432b(C5445a aVar) {
        synchronized (this.f17447b) {
            this.f17447b.remove(aVar);
        }
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: b */
    public final void mo27433b(C5447b bVar) {
        synchronized (this.f17447b) {
            for (C5445a b : this.f17447b) {
                b.mo27443b(bVar);
            }
        }
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: c */
    public final void mo27434c() {
        this.f17449d.setOnPlayListener(null);
        this.f17449d = null;
        this.f17455j = 0;
    }

    /* renamed from: d */
    public final boolean mo27435d() {
        if (this.f17449d == null) {
            return false;
        }
        int i = this.f17455j;
        return i == 2 || i == 1;
    }

    /* renamed from: e */
    public void mo27436e() {
        int i = this.f17455j;
        if (i == 2) {
            this.f17449d.stop();
            return;
        }
        if (i == 1) {
            this.f17453h.removeCallbacks(this.f17454i);
            mo27434c();
            mo27433b(this.f17450e);
        }
    }

    /* renamed from: f */
    public final boolean mo27437f() {
        if (!mo27435d() || this.f17460o == 0) {
            return false;
        }
        m22225a(0);
        return true;
    }

    /* renamed from: g */
    public final boolean mo27438g() {
        if (!mo27435d()) {
            return false;
        }
        int i = this.f17459n;
        if (i == this.f17460o) {
            return false;
        }
        m22225a(i);
        return true;
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: h */
    public final void mo27439h() {
        synchronized (this.f17447b) {
            Iterator it = this.f17447b.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }
}
