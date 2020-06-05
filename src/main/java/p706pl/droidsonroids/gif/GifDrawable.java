package p706pl.droidsonroids.gif;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.widget.MediaController.MediaPlayerControl;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p706pl.droidsonroids.gif.p707a.Transform;

/* renamed from: pl.droidsonroids.gif.c */
public class GifDrawable extends Drawable implements Animatable, MediaPlayerControl {
    /* renamed from: a */
    final ScheduledThreadPoolExecutor f29260a;
    /* renamed from: b */
    volatile boolean f29261b;
    /* renamed from: c */
    long f29262c;
    /* renamed from: d */
    protected final Paint f29263d;
    /* renamed from: e */
    final Bitmap f29264e;
    /* renamed from: f */
    final GifInfoHandle f29265f;
    /* renamed from: g */
    final ConcurrentLinkedQueue<C8591a> f29266g;
    /* renamed from: h */
    final boolean f29267h;
    /* renamed from: i */
    final InvalidationHandler f29268i;
    /* renamed from: j */
    ScheduledFuture<?> f29269j;
    /* renamed from: k */
    private final Rect f29270k;
    /* renamed from: l */
    private ColorStateList f29271l;
    /* renamed from: m */
    private PorterDuffColorFilter f29272m;
    /* renamed from: n */
    private Mode f29273n;
    /* renamed from: o */
    private final RenderTask f29274o;
    /* renamed from: p */
    private final Rect f29275p;
    /* renamed from: q */
    private int f29276q;
    /* renamed from: r */
    private int f29277r;
    /* renamed from: s */
    private Transform f29278s;

    public boolean canPause() {
        return true;
    }

    public int getAudioSessionId() {
        return 0;
    }

    public int getBufferPercentage() {
        return 100;
    }

    public GifDrawable(Resources resources, int i) throws NotFoundException, IOException {
        this(resources.openRawResourceFd(i));
        float a = GifViewUtils.m37435a(resources, i);
        this.f29277r = (int) (((float) this.f29265f.mo41175q()) * a);
        this.f29276q = (int) (((float) this.f29265f.mo41174p()) * a);
    }

    public GifDrawable(AssetFileDescriptor assetFileDescriptor) throws IOException {
        this(new GifInfoHandle(assetFileDescriptor), null, null, true);
    }

    public GifDrawable(ContentResolver contentResolver, Uri uri) throws IOException {
        this(GifInfoHandle.m37370a(contentResolver, uri), null, null, true);
    }

    GifDrawable(GifInfoHandle gifInfoHandle, GifDrawable cVar, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, boolean z) {
        this.f29261b = true;
        this.f29262c = Long.MIN_VALUE;
        this.f29270k = new Rect();
        this.f29263d = new Paint(6);
        this.f29266g = new ConcurrentLinkedQueue<>();
        this.f29274o = new RenderTask(this);
        this.f29267h = z;
        if (scheduledThreadPoolExecutor == null) {
            scheduledThreadPoolExecutor = GifRenderingExecutor.m37433a();
        }
        this.f29260a = scheduledThreadPoolExecutor;
        this.f29265f = gifInfoHandle;
        Bitmap bitmap = null;
        if (cVar != null) {
            synchronized (cVar.f29265f) {
                if (!cVar.f29265f.mo41171m() && cVar.f29265f.mo41175q() >= this.f29265f.mo41175q() && cVar.f29265f.mo41174p() >= this.f29265f.mo41174p()) {
                    cVar.m37422g();
                    Bitmap bitmap2 = cVar.f29264e;
                    bitmap2.eraseColor(0);
                    bitmap = bitmap2;
                }
            }
        }
        if (bitmap == null) {
            this.f29264e = Bitmap.createBitmap(this.f29265f.mo41174p(), this.f29265f.mo41175q(), Config.ARGB_8888);
        } else {
            this.f29264e = bitmap;
        }
        if (VERSION.SDK_INT >= 12) {
            this.f29264e.setHasAlpha(!gifInfoHandle.mo41177s());
        }
        this.f29275p = new Rect(0, 0, this.f29265f.mo41174p(), this.f29265f.mo41175q());
        this.f29268i = new InvalidationHandler(this);
        this.f29274o.mo41260a();
        this.f29276q = this.f29265f.mo41174p();
        this.f29277r = this.f29265f.mo41175q();
    }

    /* renamed from: g */
    private void m37422g() {
        this.f29261b = false;
        this.f29268i.removeMessages(-1);
        this.f29265f.mo41154a();
    }

    /* renamed from: a */
    public boolean mo41224a() {
        return this.f29265f.mo41171m();
    }

    public int getIntrinsicHeight() {
        return this.f29277r;
    }

    public int getIntrinsicWidth() {
        return this.f29276q;
    }

    public void setAlpha(int i) {
        this.f29263d.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f29263d.setColorFilter(colorFilter);
    }

    public int getOpacity() {
        return (!this.f29265f.mo41177s() || this.f29263d.getAlpha() < 255) ? -2 : -1;
    }

    public void start() {
        synchronized (this) {
            if (!this.f29261b) {
                this.f29261b = true;
                mo41223a(this.f29265f.mo41159b());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo41223a(long j) {
        if (this.f29267h) {
            this.f29262c = 0;
            this.f29268i.sendEmptyMessageAtTime(-1, 0);
            return;
        }
        m37423h();
        this.f29269j = this.f29260a.schedule(this.f29274o, Math.max(j, 0), TimeUnit.MILLISECONDS);
    }

    /* renamed from: b */
    public void mo41225b() {
        this.f29260a.execute(new SafeRunnable(this) {
            /* renamed from: a */
            public void mo41260a() {
                if (GifDrawable.this.f29265f.mo41160c()) {
                    GifDrawable.this.start();
                }
            }
        });
    }

    public void stop() {
        synchronized (this) {
            if (this.f29261b) {
                this.f29261b = false;
                m37423h();
                this.f29265f.mo41161d();
            }
        }
    }

    /* renamed from: h */
    private void m37423h() {
        ScheduledFuture<?> scheduledFuture = this.f29269j;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.f29268i.removeMessages(-1);
    }

    public boolean isRunning() {
        return this.f29261b;
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "GIF: size: %dx%d, frames: %d, error: %d", new Object[]{Integer.valueOf(this.f29265f.mo41174p()), Integer.valueOf(this.f29265f.mo41175q()), Integer.valueOf(this.f29265f.mo41176r()), Integer.valueOf(this.f29265f.mo41163f())});
    }

    /* renamed from: c */
    public int mo41226c() {
        return this.f29265f.mo41176r();
    }

    public void pause() {
        stop();
    }

    public int getDuration() {
        return this.f29265f.mo41165g();
    }

    public int getCurrentPosition() {
        return this.f29265f.mo41166h();
    }

    public void seekTo(final int i) {
        if (i >= 0) {
            this.f29260a.execute(new SafeRunnable(this) {
                /* renamed from: a */
                public void mo41260a() {
                    GifDrawable.this.f29265f.mo41157a(i, GifDrawable.this.f29264e);
                    this.f29296c.f29268i.sendEmptyMessageAtTime(-1, 0);
                }
            });
            return;
        }
        throw new IllegalArgumentException("Position is not positive");
    }

    public boolean isPlaying() {
        return this.f29261b;
    }

    public boolean canSeekBackward() {
        return mo41226c() > 1;
    }

    public boolean canSeekForward() {
        return mo41226c() > 1;
    }

    /* renamed from: d */
    public int mo41230d() {
        return this.f29264e.getRowBytes() * this.f29264e.getHeight();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f29270k.set(rect);
        Transform aVar = this.f29278s;
        if (aVar != null) {
            aVar.mo41218a(rect);
        }
    }

    public void draw(Canvas canvas) {
        boolean z;
        if (this.f29272m == null || this.f29263d.getColorFilter() != null) {
            z = false;
        } else {
            this.f29263d.setColorFilter(this.f29272m);
            z = true;
        }
        Transform aVar = this.f29278s;
        if (aVar == null) {
            canvas.drawBitmap(this.f29264e, this.f29275p, this.f29270k, this.f29263d);
        } else {
            aVar.mo41217a(canvas, this.f29263d, this.f29264e);
        }
        if (z) {
            this.f29263d.setColorFilter(null);
        }
        if (this.f29267h && this.f29261b) {
            long j = this.f29262c;
            if (j != Long.MIN_VALUE) {
                long max = Math.max(0, j - SystemClock.uptimeMillis());
                this.f29262c = Long.MIN_VALUE;
                this.f29260a.remove(this.f29274o);
                this.f29269j = this.f29260a.schedule(this.f29274o, max, TimeUnit.MILLISECONDS);
            }
        }
    }

    public int getAlpha() {
        return this.f29263d.getAlpha();
    }

    public void setFilterBitmap(boolean z) {
        this.f29263d.setFilterBitmap(z);
        invalidateSelf();
    }

    @Deprecated
    public void setDither(boolean z) {
        this.f29263d.setDither(z);
        invalidateSelf();
    }

    public ColorFilter getColorFilter() {
        return this.f29263d.getColorFilter();
    }

    /* renamed from: a */
    private PorterDuffColorFilter m37421a(ColorStateList colorStateList, Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f29271l = colorStateList;
        this.f29272m = m37421a(colorStateList, this.f29273n);
        invalidateSelf();
    }

    public void setTintMode(Mode mode) {
        this.f29273n = mode;
        this.f29272m = m37421a(this.f29271l, mode);
        invalidateSelf();
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.f29271l;
        if (colorStateList != null) {
            Mode mode = this.f29273n;
            if (mode != null) {
                this.f29272m = m37421a(colorStateList, mode);
                return true;
            }
        }
        return false;
    }

    public boolean isStateful() {
        if (!super.isStateful()) {
            ColorStateList colorStateList = this.f29271l;
            if (colorStateList == null || !colorStateList.isStateful()) {
                return false;
            }
        }
        return true;
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (!this.f29267h) {
            if (z) {
                if (z2) {
                    mo41225b();
                }
                if (visible) {
                    start();
                }
            } else if (visible) {
                stop();
            }
        }
        return visible;
    }

    /* renamed from: e */
    public int mo41232e() {
        return this.f29265f.mo41167i();
    }

    /* renamed from: f */
    public int mo41233f() {
        int j = this.f29265f.mo41168j();
        return (j == 0 || j < this.f29265f.mo41162e()) ? j : j - 1;
    }
}
