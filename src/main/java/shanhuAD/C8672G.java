package shanhuAD;

import android.content.Context;
import android.graphics.Canvas;
import android.media.AudioManager;
import android.media.MediaFormat;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.MediaController;
import android.widget.MediaController.MediaPlayerControl;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

/* renamed from: shanhuAD.G */
public class C8672G extends SurfaceView implements MediaPlayerControl {
    /* renamed from: Li */
    public static final int f29470Li = 0;
    /* renamed from: Mi */
    public static final int f29471Mi = 1;
    /* renamed from: Ni */
    public static final int f29472Ni = 2;
    /* renamed from: Oi */
    public static final int f29473Oi = 5;
    /* renamed from: Pi */
    private static final int f29474Pi = 1;
    /* renamed from: Qi */
    private static final int f29475Qi = 2;
    public static final int STATE_ERROR = -1;
    public static final int STATE_PAUSED = 4;
    public static final int STATE_PLAYING = 3;
    /* renamed from: Ri */
    private Uri f29476Ri;
    /* renamed from: Si */
    private Map<String, String> f29477Si;
    /* access modifiers changed from: private */
    public String TAG;
    /* renamed from: Ti */
    public int f29478Ti;
    /* renamed from: Ui */
    public int f29479Ui;
    /* access modifiers changed from: private */
    /* renamed from: Vi */
    public SurfaceHolder f29480Vi;
    /* access modifiers changed from: private */
    /* renamed from: Wi */
    public MediaPlayer f29481Wi;
    /* renamed from: Xi */
    private C8674b f29482Xi;
    /* renamed from: Yi */
    private int f29483Yi;
    /* access modifiers changed from: private */
    /* renamed from: Zi */
    public int f29484Zi;
    /* access modifiers changed from: private */
    /* renamed from: _i */
    public int f29485_i;
    /* access modifiers changed from: private */
    /* renamed from: aj */
    public int f29486aj;
    /* access modifiers changed from: private */
    /* renamed from: bj */
    public int f29487bj;
    /* access modifiers changed from: private */
    /* renamed from: cj */
    public MediaController f29488cj;
    /* access modifiers changed from: private */
    /* renamed from: dj */
    public OnCompletionListener f29489dj;
    /* access modifiers changed from: private */
    /* renamed from: ej */
    public OnPreparedListener f29490ej;
    /* renamed from: fj */
    private C8673a f29491fj;
    /* access modifiers changed from: private */
    /* renamed from: gj */
    public int f29492gj;
    /* access modifiers changed from: private */
    /* renamed from: hj */
    public OnErrorListener f29493hj;
    /* access modifiers changed from: private */
    /* renamed from: ij */
    public OnInfoListener f29494ij;
    /* access modifiers changed from: private */
    /* renamed from: jj */
    public int f29495jj;
    /* access modifiers changed from: private */
    /* renamed from: kj */
    public boolean f29496kj;
    /* access modifiers changed from: private */
    /* renamed from: lj */
    public boolean f29497lj;
    private Context mContext;
    /* access modifiers changed from: private */
    /* renamed from: mj */
    public boolean f29498mj;
    /* renamed from: nj */
    private int f29499nj;
    /* access modifiers changed from: private */
    /* renamed from: oj */
    public int f29500oj;
    /* renamed from: pj */
    private float f29501pj;
    /* renamed from: qj */
    private float f29502qj;
    /* renamed from: rj */
    private float f29503rj;
    /* renamed from: sj */
    private Vector<Pair<InputStream, MediaFormat>> f29504sj;
    /* renamed from: tj */
    OnVideoSizeChangedListener f29505tj;
    /* renamed from: uj */
    OnPreparedListener f29506uj;
    /* renamed from: vj */
    private OnCompletionListener f29507vj;
    /* renamed from: wj */
    private OnInfoListener f29508wj;
    /* renamed from: xj */
    private OnErrorListener f29509xj;
    /* renamed from: yj */
    private OnBufferingUpdateListener f29510yj;
    /* renamed from: zj */
    Callback f29511zj;

    /* renamed from: shanhuAD.G$a */
    public interface C8673a {
        void onStop();
    }

    /* renamed from: shanhuAD.G$b */
    public interface C8674b {
        void videoStart(int i);
    }

    public C8672G(Context context) {
        super(context);
        this.TAG = "VideoView";
        this.f29478Ti = 0;
        this.f29479Ui = 0;
        this.f29480Vi = null;
        this.f29481Wi = null;
        this.f29501pj = 1.0f;
        this.f29502qj = 1.0f;
        this.f29503rj = 1.0f;
        this.f29505tj = new C8704z(this);
        this.f29506uj = new C8666A(this);
        this.f29507vj = new C8667B(this);
        this.f29508wj = new C8668C(this);
        this.f29509xj = new C8669D(this);
        this.f29510yj = new C8670E(this);
        this.f29511zj = new C8671F(this);
        this.mContext = context;
        m37653Eb();
    }

    /* renamed from: Db */
    private void m37652Db() {
        if (this.f29481Wi != null) {
            MediaController mediaController = this.f29488cj;
            if (mediaController != null) {
                mediaController.setMediaPlayer(this);
                this.f29488cj.setAnchorView(getParent() instanceof View ? (View) getParent() : this);
                this.f29488cj.setEnabled(m37654Fb());
            }
        }
    }

    /* renamed from: Eb */
    private void m37653Eb() {
        this.f29484Zi = 0;
        this.f29485_i = 0;
        getHolder().addCallback(this.f29511zj);
        getHolder().setType(3);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.f29504sj = new Vector<>();
        this.f29478Ti = 0;
        this.f29479Ui = 0;
    }

    /* renamed from: Fb */
    private boolean m37654Fb() {
        if (this.f29481Wi != null) {
            int i = this.f29478Ti;
            if (!(i == -1 || i == 0 || i == 1)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: Gb */
    public void m37655Gb() {
        String str = "Unable to open content: ";
        if (this.f29476Ri != null && this.f29480Vi != null) {
            m37679k(false);
            ((AudioManager) this.mContext.getSystemService("audio")).requestAudioFocus(null, 3, 1);
            try {
                this.f29481Wi = new MediaPlayer();
                getContext();
                if (this.f29483Yi != 0) {
                    this.f29481Wi.setAudioSessionId(this.f29483Yi);
                } else {
                    this.f29483Yi = this.f29481Wi.getAudioSessionId();
                }
                this.f29481Wi.setOnPreparedListener(this.f29506uj);
                this.f29481Wi.setOnVideoSizeChangedListener(this.f29505tj);
                this.f29481Wi.setOnCompletionListener(this.f29507vj);
                this.f29481Wi.setOnErrorListener(this.f29509xj);
                this.f29481Wi.setOnInfoListener(this.f29508wj);
                this.f29481Wi.setOnBufferingUpdateListener(this.f29510yj);
                this.f29492gj = 0;
                this.f29481Wi.setDataSource(this.mContext, this.f29476Ri, this.f29477Si);
                this.f29481Wi.setDisplay(this.f29480Vi);
                this.f29481Wi.setAudioStreamType(3);
                this.f29481Wi.setScreenOnWhilePlaying(true);
                this.f29481Wi.prepareAsync();
                this.f29481Wi.setVolume(this.f29501pj, this.f29502qj);
                Iterator it = this.f29504sj.iterator();
                while (it.hasNext()) {
                    Pair pair = (Pair) it.next();
                    this.f29508wj.onInfo(this.f29481Wi, 901, 0);
                }
                this.f29478Ti = 1;
                m37652Db();
            } catch (IOException e) {
                String str2 = this.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(this.f29476Ri);
                Log.w(str2, sb.toString(), e);
                this.f29478Ti = -1;
                this.f29479Ui = -1;
                this.f29509xj.onError(this.f29481Wi, 1, 0);
            } catch (IllegalArgumentException e2) {
                String str3 = this.TAG;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(this.f29476Ri);
                Log.w(str3, sb2.toString(), e2);
                this.f29478Ti = -1;
                this.f29479Ui = -1;
                this.f29509xj.onError(this.f29481Wi, 1, 0);
            } finally {
                this.f29504sj.clear();
            }
        }
    }

    /* renamed from: Hb */
    private void m37656Hb() {
        if (this.f29488cj.isShowing()) {
            this.f29488cj.hide();
        } else {
            this.f29488cj.show();
        }
    }

    public boolean canPause() {
        return this.f29496kj;
    }

    public boolean canSeekBackward() {
        return this.f29497lj;
    }

    public boolean canSeekForward() {
        return this.f29498mj;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public CharSequence getAccessibilityClassName() {
        return C8672G.class.getName();
    }

    public int getAudioSessionId() {
        if (this.f29483Yi == 0) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f29483Yi = mediaPlayer.getAudioSessionId();
            mediaPlayer.release();
        }
        return this.f29483Yi;
    }

    public int getBufferPercentage() {
        if (this.f29481Wi != null) {
            return this.f29492gj;
        }
        return 0;
    }

    public int getCurrentPosition() {
        if (m37654Fb()) {
            return this.f29481Wi.getCurrentPosition();
        }
        return 0;
    }

    public int getDuration() {
        if (m37654Fb()) {
            return this.f29481Wi.getDuration();
        }
        return -1;
    }

    public boolean isPlaying() {
        return m37654Fb() && this.f29481Wi.isPlaying();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int defaultSize = SurfaceView.getDefaultSize(this.f29484Zi, i);
        int defaultSize2 = SurfaceView.getDefaultSize(this.f29485_i, i2);
        if (this.f29484Zi <= 0 || this.f29485_i <= 0) {
            i3 = defaultSize;
        } else {
            int mode = MeasureSpec.getMode(i);
            i3 = MeasureSpec.getSize(i);
            int mode2 = MeasureSpec.getMode(i2);
            int size = MeasureSpec.getSize(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                int i4 = this.f29485_i;
                int i5 = this.f29484Zi;
                if (i4 < i5) {
                    if (this.f29499nj == 2) {
                        int i6 = i5 * size;
                        int i7 = i3 * i4;
                        if (i6 < i7) {
                            size = i7 / i5;
                        } else if (i6 > i7) {
                            i3 = i6 / i4;
                        }
                    } else {
                        size = (i4 * i3) / i5;
                    }
                } else if (this.f29499nj == 1) {
                    int i8 = i5 * size;
                    int i9 = i3 * i4;
                    if (i8 < i9) {
                        i3 = i8 / i4;
                    } else if (i8 > i9) {
                        size = i9 / i5;
                    }
                } else {
                    int i10 = i5 * size;
                    int i11 = i3 * i4;
                    if (i10 < i11) {
                        size = i11 / i5;
                    } else if (i10 > i11) {
                        i3 = i10 / i4;
                    }
                }
                float f = (float) i3;
                float f2 = this.f29503rj;
                i3 = (int) (f * f2);
                defaultSize2 = (int) (((float) size) * f2);
            } else {
                if (mode == 1073741824) {
                    int i12 = (this.f29485_i * i3) / this.f29484Zi;
                    if (mode2 != Integer.MIN_VALUE || i12 <= size) {
                        defaultSize2 = i12;
                    }
                } else if (mode2 == 1073741824) {
                    int i13 = (this.f29484Zi * size) / this.f29485_i;
                    if (mode != Integer.MIN_VALUE || i13 <= i3) {
                        i3 = i13;
                    }
                } else {
                    int i14 = this.f29484Zi;
                    int i15 = this.f29485_i;
                    if (mode2 != Integer.MIN_VALUE || i15 <= size) {
                        defaultSize2 = i15;
                    } else {
                        i14 = (i14 * size) / i15;
                        defaultSize2 = size;
                    }
                    if (mode != Integer.MIN_VALUE || i14 <= i3) {
                        i3 = i14;
                    } else {
                        defaultSize2 = (this.f29485_i * i3) / this.f29484Zi;
                    }
                }
                defaultSize2 = size;
            }
        }
        setMeasuredDimension(i3, defaultSize2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (m37654Fb() && this.f29488cj != null) {
            m37656Hb();
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (m37654Fb() && this.f29488cj != null) {
            m37656Hb();
        }
        return false;
    }

    public void pause() {
        if (m37654Fb() && this.f29481Wi.isPlaying()) {
            this.f29481Wi.pause();
            this.f29500oj = this.f29481Wi.getCurrentPosition();
            this.f29478Ti = 4;
        }
        this.f29479Ui = 4;
    }

    /* renamed from: rb */
    public void mo41420rb() {
        this.f29499nj = 2;
    }

    public int resolveAdjustedSize(int i, int i2) {
        return SurfaceView.getDefaultSize(i, i2);
    }

    public void resume() {
        m37655Gb();
    }

    /* renamed from: sb */
    public void mo41423sb() {
        this.f29499nj = 1;
    }

    public void seekTo(int i) {
        if (m37654Fb()) {
            this.f29481Wi.seekTo(i);
            this.f29495jj = 0;
            return;
        }
        this.f29495jj = i;
    }

    public void setMediaController(MediaController mediaController) {
        MediaController mediaController2 = this.f29488cj;
        if (mediaController2 != null) {
            mediaController2.hide();
        }
        this.f29488cj = mediaController;
        m37652Db();
    }

    public void setOnCompletionListener(OnCompletionListener onCompletionListener) {
        this.f29489dj = onCompletionListener;
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.f29493hj = onErrorListener;
    }

    public void setOnInfoListener(OnInfoListener onInfoListener) {
        this.f29494ij = onInfoListener;
    }

    public void setOnPreparedListener(OnPreparedListener onPreparedListener) {
        this.f29490ej = onPreparedListener;
    }

    public void setOnStopListener(C8673a aVar) {
        this.f29491fj = aVar;
    }

    public void setScale(float f) {
        this.f29503rj = f;
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    public void setVideoStartListener(C8674b bVar) {
        this.f29482Xi = bVar;
    }

    public void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    public void setVolume(float f, float f2) {
        this.f29501pj = f;
        this.f29502qj = f2;
        MediaPlayer mediaPlayer = this.f29481Wi;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(f, f2);
        }
    }

    public void start() {
        setVisibility(0);
        if (m37654Fb()) {
            if (this.f29478Ti == 2) {
                int i = this.f29500oj;
                if (i > 0) {
                    this.f29481Wi.seekTo(i);
                }
            }
            this.f29481Wi.start();
            C8674b bVar = this.f29482Xi;
            if (bVar != null) {
                bVar.videoStart(this.f29481Wi.getDuration());
            }
            if (this.f29478Ti == 5) {
                OnInfoListener onInfoListener = this.f29494ij;
                if (onInfoListener != null) {
                    onInfoListener.onInfo(this.f29481Wi, 3, 0);
                }
            }
            this.f29478Ti = 3;
        }
        this.f29479Ui = 3;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:4|5|6|7|8) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x001b */
    public void stop() {
        /*
        r1 = this;
        r0 = 8
        r1.setVisibility(r0)
        boolean r0 = r1.m37654Fb()
        if (r0 == 0) goto L_0x0023
        android.media.MediaPlayer r0 = r1.f29481Wi
        boolean r0 = r0.isPlaying()
        if (r0 == 0) goto L_0x0023
        android.media.MediaPlayer r0 = r1.f29481Wi     // Catch:{ all -> 0x001b }
        r0.stop()     // Catch:{ all -> 0x001b }
        r0 = 0
        r1.f29500oj = r0     // Catch:{ all -> 0x001b }
    L_0x001b:
        android.media.MediaPlayer r0 = r1.f29481Wi     // Catch:{ all -> 0x0020 }
        r0.prepareAsync()     // Catch:{ all -> 0x0020 }
    L_0x0020:
        r0 = 1
        r1.f29478Ti = r0
    L_0x0023:
        shanhuAD.G$a r0 = r1.f29491fj
        if (r0 == 0) goto L_0x002a
        r0.onStop()
    L_0x002a:
        r0 = 4
        r1.f29479Ui = r0
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: shanhuAD.C8672G.stop():void");
    }

    public void stopPlayback() {
        MediaPlayer mediaPlayer = this.f29481Wi;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.f29481Wi.release();
            this.f29481Wi = null;
            this.f29478Ti = 0;
            this.f29479Ui = 0;
            ((AudioManager) this.mContext.getSystemService("audio")).abandonAudioFocus(null);
        }
    }

    public void suspend() {
        m37679k(false);
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m37679k(boolean z) {
        MediaPlayer mediaPlayer = this.f29481Wi;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.f29481Wi.release();
            this.f29481Wi = null;
            this.f29504sj.clear();
            this.f29478Ti = 0;
            if (z) {
                this.f29479Ui = 0;
            }
            ((AudioManager) this.mContext.getSystemService("audio")).abandonAudioFocus(null);
        }
    }

    public void setVideoURI(Uri uri, Map<String, String> map) {
        if (uri == null || this.f29476Ri == null || !uri.toString().equals(this.f29476Ri.toString())) {
            this.f29476Ri = uri;
            this.f29477Si = map;
            this.f29495jj = 0;
            m37655Gb();
            requestLayout();
            invalidate();
        }
    }

    public C8672G(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.mContext = context;
        m37653Eb();
    }

    public C8672G(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public C8672G(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.TAG = "VideoView";
        this.f29478Ti = 0;
        this.f29479Ui = 0;
        this.f29480Vi = null;
        this.f29481Wi = null;
        this.f29501pj = 1.0f;
        this.f29502qj = 1.0f;
        this.f29503rj = 1.0f;
        this.f29505tj = new C8704z(this);
        this.f29506uj = new C8666A(this);
        this.f29507vj = new C8667B(this);
        this.f29508wj = new C8668C(this);
        this.f29509xj = new C8669D(this);
        this.f29510yj = new C8670E(this);
        this.f29511zj = new C8671F(this);
        this.mContext = context;
        m37653Eb();
    }
}
