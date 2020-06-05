package com.yanzhenjie.album.widget.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import androidx.core.view.MotionEventCompat;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.yanzhenjie.album.widget.photoview.gestures.OnGestureListener;
import com.yanzhenjie.album.widget.photoview.gestures.VersionedGestureDetector;
import com.yanzhenjie.album.widget.photoview.scrollerproxy.ScrollerProxy;
import java.lang.ref.WeakReference;

/* renamed from: com.yanzhenjie.album.widget.photoview.d */
public class PhotoViewAttacher implements OnTouchListener, OnGlobalLayoutListener, IPhotoView, OnGestureListener {
    /* renamed from: b */
    static int f26359b = 1;
    /* renamed from: A */
    private C7771b f26360A;
    /* renamed from: B */
    private int f26361B;
    /* renamed from: C */
    private float f26362C;
    /* renamed from: D */
    private boolean f26363D;
    /* renamed from: E */
    private ScaleType f26364E;
    /* renamed from: a */
    int f26365a;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public Interpolator f26366c;
    /* renamed from: d */
    private float f26367d;
    /* renamed from: e */
    private float f26368e;
    /* renamed from: f */
    private float f26369f;
    /* renamed from: g */
    private boolean f26370g;
    /* renamed from: h */
    private boolean f26371h;
    /* renamed from: i */
    private WeakReference<ImageView> f26372i;
    /* renamed from: j */
    private GestureDetector f26373j;
    /* renamed from: k */
    private com.yanzhenjie.album.widget.photoview.gestures.GestureDetector f26374k;
    /* renamed from: l */
    private final Matrix f26375l;
    /* renamed from: m */
    private final Matrix f26376m;
    /* access modifiers changed from: private|final */
    /* renamed from: n */
    public final Matrix f26377n;
    /* renamed from: o */
    private final RectF f26378o;
    /* renamed from: p */
    private final float[] f26379p;
    /* renamed from: q */
    private C7772c f26380q;
    /* renamed from: r */
    private C7773d f26381r;
    /* renamed from: s */
    private C7776g f26382s;
    /* access modifiers changed from: private */
    /* renamed from: t */
    public OnLongClickListener f26383t;
    /* renamed from: u */
    private C7774e f26384u;
    /* access modifiers changed from: private */
    /* renamed from: v */
    public C7775f f26385v;
    /* renamed from: w */
    private int f26386w;
    /* renamed from: x */
    private int f26387x;
    /* renamed from: y */
    private int f26388y;
    /* renamed from: z */
    private int f26389z;

    /* compiled from: PhotoViewAttacher */
    /* renamed from: com.yanzhenjie.album.widget.photoview.d$2 */
    static /* synthetic */ class C77692 {
        /* renamed from: a */
        static final /* synthetic */ int[] f26391a = new int[ScaleType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
     */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
            android.widget.ImageView$ScaleType[] r0 = android.widget.ImageView.ScaleType.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f26391a = r0
            int[] r0 = f26391a     // Catch:{ NoSuchFieldError -> 0x0014 }
            android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.MATRIX     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = f26391a     // Catch:{ NoSuchFieldError -> 0x001f }
            android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_START     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            int[] r0 = f26391a     // Catch:{ NoSuchFieldError -> 0x002a }
            android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_END     // Catch:{ NoSuchFieldError -> 0x002a }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            int[] r0 = f26391a     // Catch:{ NoSuchFieldError -> 0x0035 }
            android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x0035 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            int[] r0 = f26391a     // Catch:{ NoSuchFieldError -> 0x0040 }
            android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_XY     // Catch:{ NoSuchFieldError -> 0x0040 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
            r2 = 5
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
        L_0x0040:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.yanzhenjie.album.widget.photoview.PhotoViewAttacher.C77692.m54085clinit():void");
        }
    }

    /* compiled from: PhotoViewAttacher */
    /* renamed from: com.yanzhenjie.album.widget.photoview.d$a */
    private class C7770a implements Runnable {
        /* renamed from: b */
        private final float f26393b;
        /* renamed from: c */
        private final float f26394c;
        /* renamed from: d */
        private final long f26395d = System.currentTimeMillis();
        /* renamed from: e */
        private final float f26396e;
        /* renamed from: f */
        private final float f26397f;

        public C7770a(float f, float f2, float f3, float f4) {
            this.f26393b = f3;
            this.f26394c = f4;
            this.f26396e = f;
            this.f26397f = f2;
        }

        public void run() {
            ImageView c = PhotoViewAttacher.this.mo37740c();
            if (c != null) {
                float a = m33699a();
                float f = this.f26396e;
                PhotoViewAttacher.this.mo37735a((f + ((this.f26397f - f) * a)) / PhotoViewAttacher.this.mo37744g(), this.f26393b, this.f26394c);
                if (a < 1.0f) {
                    Compat.m33660a(c, this);
                }
            }
        }

        /* renamed from: a */
        private float m33699a() {
            return PhotoViewAttacher.this.f26366c.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.f26395d)) * 1.0f) / ((float) PhotoViewAttacher.this.f26365a)));
        }
    }

    /* compiled from: PhotoViewAttacher */
    /* renamed from: com.yanzhenjie.album.widget.photoview.d$b */
    private class C7771b implements Runnable {
        /* renamed from: b */
        private final ScrollerProxy f26399b;
        /* renamed from: c */
        private int f26400c;
        /* renamed from: d */
        private int f26401d;

        public C7771b(Context context) {
            this.f26399b = ScrollerProxy.m33740a(context);
        }

        /* renamed from: a */
        public void mo37753a() {
            this.f26399b.mo37772a(true);
        }

        /* renamed from: a */
        public void mo37754a(int i, int i2, int i3, int i4) {
            int i5;
            int i6;
            int i7;
            int i8;
            RectF b = PhotoViewAttacher.this.mo37739b();
            if (b != null) {
                int round = Math.round(-b.left);
                float f = (float) i;
                if (f < b.width()) {
                    i5 = Math.round(b.width() - f);
                    i6 = 0;
                } else {
                    i6 = round;
                    i5 = i6;
                }
                int round2 = Math.round(-b.top);
                float f2 = (float) i2;
                if (f2 < b.height()) {
                    i7 = Math.round(b.height() - f2);
                    i8 = 0;
                } else {
                    i8 = round2;
                    i7 = i8;
                }
                this.f26400c = round;
                this.f26401d = round2;
                if (!(round == i5 && round2 == i7)) {
                    this.f26399b.mo37771a(round, round2, i3, i4, i6, i5, i8, i7, 0, 0);
                }
            }
        }

        public void run() {
            if (!this.f26399b.mo37774b()) {
                ImageView c = PhotoViewAttacher.this.mo37740c();
                if (c != null && this.f26399b.mo37773a()) {
                    int c2 = this.f26399b.mo37775c();
                    int d = this.f26399b.mo37776d();
                    PhotoViewAttacher.this.f26377n.postTranslate((float) (this.f26400c - c2), (float) (this.f26401d - d));
                    PhotoViewAttacher dVar = PhotoViewAttacher.this;
                    dVar.m33670b(dVar.m33677k());
                    this.f26400c = c2;
                    this.f26401d = d;
                    Compat.m33660a(c, this);
                }
            }
        }
    }

    /* compiled from: PhotoViewAttacher */
    /* renamed from: com.yanzhenjie.album.widget.photoview.d$c */
    public interface C7772c {
        /* renamed from: a */
        void mo37756a(RectF rectF);
    }

    /* compiled from: PhotoViewAttacher */
    /* renamed from: com.yanzhenjie.album.widget.photoview.d$d */
    public interface C7773d {
        /* renamed from: a */
        void mo37757a();

        /* renamed from: a */
        void mo37758a(View view, float f, float f2);
    }

    /* compiled from: PhotoViewAttacher */
    /* renamed from: com.yanzhenjie.album.widget.photoview.d$e */
    public interface C7774e {
        /* renamed from: a */
        void mo37759a(float f, float f2, float f3);
    }

    /* compiled from: PhotoViewAttacher */
    /* renamed from: com.yanzhenjie.album.widget.photoview.d$f */
    public interface C7775f {
        /* renamed from: a */
        boolean mo37760a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2);
    }

    /* compiled from: PhotoViewAttacher */
    /* renamed from: com.yanzhenjie.album.widget.photoview.d$g */
    public interface C7776g {
        /* renamed from: a */
        void mo37761a(View view, float f, float f2);
    }

    /* renamed from: a */
    private static boolean m33668a(ImageView imageView) {
        return (imageView == null || imageView.getDrawable() == null) ? false : true;
    }

    /* renamed from: b */
    private static void m33671b(ImageView imageView) {
        if (imageView != null && !(imageView instanceof IPhotoView) && !ScaleType.MATRIX.equals(imageView.getScaleType())) {
            imageView.setScaleType(ScaleType.MATRIX);
        }
    }

    public PhotoViewAttacher(ImageView imageView) {
        this(imageView, true);
    }

    public PhotoViewAttacher(ImageView imageView, boolean z) {
        this.f26366c = new AccelerateDecelerateInterpolator();
        this.f26365a = 200;
        this.f26367d = 1.0f;
        this.f26368e = 1.75f;
        this.f26369f = 3.0f;
        this.f26370g = true;
        this.f26371h = false;
        this.f26375l = new Matrix();
        this.f26376m = new Matrix();
        this.f26377n = new Matrix();
        this.f26378o = new RectF();
        this.f26379p = new float[9];
        this.f26361B = 2;
        this.f26364E = ScaleType.FIT_CENTER;
        this.f26372i = new WeakReference<>(imageView);
        imageView.setDrawingCacheEnabled(true);
        imageView.setOnTouchListener(this);
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        m33671b(imageView);
        if (!imageView.isInEditMode()) {
            this.f26374k = VersionedGestureDetector.m33726a(imageView.getContext(), this);
            this.f26373j = new GestureDetector(imageView.getContext(), new SimpleOnGestureListener() {
                public void onLongPress(MotionEvent motionEvent) {
                    if (PhotoViewAttacher.this.f26383t != null) {
                        PhotoViewAttacher.this.f26383t.onLongClick(PhotoViewAttacher.this.mo37740c());
                    }
                }

                public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                    if (PhotoViewAttacher.this.f26385v == null || PhotoViewAttacher.this.mo37744g() > 1.0f || MotionEventCompat.getPointerCount(motionEvent) > PhotoViewAttacher.f26359b || MotionEventCompat.getPointerCount(motionEvent2) > PhotoViewAttacher.f26359b) {
                        return false;
                    }
                    return PhotoViewAttacher.this.f26385v.mo37760a(motionEvent, motionEvent2, f, f2);
                }
            });
            this.f26373j.setOnDoubleTapListener(new DefaultOnDoubleTapListener(this));
            this.f26362C = 0.0f;
            mo37738a(z);
        }
    }

    /* renamed from: a */
    public void mo37732a() {
        WeakReference<ImageView> weakReference = this.f26372i;
        if (weakReference != null) {
            ImageView imageView = (ImageView) weakReference.get();
            if (imageView != null) {
                ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                imageView.setOnTouchListener(null);
                m33678l();
            }
            GestureDetector gestureDetector = this.f26373j;
            if (gestureDetector != null) {
                gestureDetector.setOnDoubleTapListener(null);
            }
            this.f26380q = null;
            this.f26381r = null;
            this.f26382s = null;
            this.f26372i = null;
        }
    }

    /* renamed from: b */
    public RectF mo37739b() {
        m33681o();
        return m33664a(m33677k());
    }

    /* renamed from: a */
    public void mo37733a(float f) {
        this.f26377n.postRotate(f % 360.0f);
        m33679m();
    }

    /* renamed from: c */
    public ImageView mo37740c() {
        WeakReference<ImageView> weakReference = this.f26372i;
        ImageView imageView = weakReference != null ? (ImageView) weakReference.get() : null;
        if (imageView == null) {
            mo37732a();
        }
        return imageView;
    }

    /* renamed from: d */
    public float mo37741d() {
        return this.f26367d;
    }

    /* renamed from: e */
    public float mo37742e() {
        return this.f26368e;
    }

    /* renamed from: f */
    public float mo37743f() {
        return this.f26369f;
    }

    /* renamed from: g */
    public float mo37744g() {
        return (float) Math.sqrt((double) (((float) Math.pow((double) m33663a(this.f26377n, 0), 2.0d)) + ((float) Math.pow((double) m33663a(this.f26377n, 3), 2.0d))));
    }

    /* renamed from: a */
    public void mo37734a(float f, float f2) {
        if (!this.f26374k.mo37764a()) {
            ImageView c = mo37740c();
            this.f26377n.postTranslate(f, f2);
            m33679m();
            ViewParent parent = c.getParent();
            if (this.f26370g && !this.f26374k.mo37764a() && !this.f26371h) {
                int i = this.f26361B;
                if ((i == 2 || ((i == 0 && f >= 1.0f) || (this.f26361B == 1 && f <= -1.0f))) && parent != null) {
                    parent.requestDisallowInterceptTouchEvent(false);
                }
            } else if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* renamed from: a */
    public void mo37736a(float f, float f2, float f3, float f4) {
        ImageView c = mo37740c();
        this.f26360A = new C7771b(c.getContext());
        this.f26360A.mo37754a(m33672c(c), m33674d(c), (int) f3, (int) f4);
        c.post(this.f26360A);
    }

    public void onGlobalLayout() {
        ImageView c = mo37740c();
        if (c == null) {
            return;
        }
        if (this.f26363D) {
            int top = c.getTop();
            int right = c.getRight();
            int bottom = c.getBottom();
            int left = c.getLeft();
            if (top != this.f26386w || bottom != this.f26388y || left != this.f26389z || right != this.f26387x) {
                m33666a(c.getDrawable());
                this.f26386w = top;
                this.f26387x = right;
                this.f26388y = bottom;
                this.f26389z = left;
                return;
            }
            return;
        }
        m33666a(c.getDrawable());
    }

    /* renamed from: a */
    public void mo37735a(float f, float f2, float f3) {
        if (mo37744g() >= this.f26369f && f >= 1.0f) {
            return;
        }
        if (mo37744g() > this.f26367d || f > 1.0f) {
            C7774e eVar = this.f26384u;
            if (eVar != null) {
                eVar.mo37759a(f, f2, f3);
            }
            this.f26377n.postScale(f, f, f2, f3);
            m33679m();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0089  */
    public boolean onTouch(android.view.View r11, android.view.MotionEvent r12) {
        /*
        r10 = this;
        boolean r0 = r10.f26363D
        r1 = 0
        r2 = 1
        if (r0 == 0) goto L_0x0095
        r0 = r11
        android.widget.ImageView r0 = (android.widget.ImageView) r0
        boolean r0 = m33668a(r0)
        if (r0 == 0) goto L_0x0095
        android.view.ViewParent r0 = r11.getParent()
        int r3 = r12.getAction()
        if (r3 == 0) goto L_0x0049
        if (r3 == r2) goto L_0x001f
        r0 = 3
        if (r3 == r0) goto L_0x001f
        goto L_0x0051
    L_0x001f:
        float r0 = r10.mo37744g()
        float r3 = r10.f26367d
        int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
        if (r0 >= 0) goto L_0x0051
        android.graphics.RectF r0 = r10.mo37739b()
        if (r0 == 0) goto L_0x0051
        com.yanzhenjie.album.widget.photoview.d$a r9 = new com.yanzhenjie.album.widget.photoview.d$a
        float r5 = r10.mo37744g()
        float r6 = r10.f26367d
        float r7 = r0.centerX()
        float r8 = r0.centerY()
        r3 = r9
        r4 = r10
        r3.m54086init(r5, r6, r7, r8)
        r11.post(r9)
        r11 = 1
        goto L_0x0052
    L_0x0049:
        if (r0 == 0) goto L_0x004e
        r0.requestDisallowInterceptTouchEvent(r2)
    L_0x004e:
        r10.m33678l()
    L_0x0051:
        r11 = 0
    L_0x0052:
        com.yanzhenjie.album.widget.photoview.gestures.a r0 = r10.f26374k
        if (r0 == 0) goto L_0x0089
        boolean r11 = r0.mo37764a()
        com.yanzhenjie.album.widget.photoview.gestures.a r0 = r10.f26374k
        boolean r0 = r0.mo37766b()
        com.yanzhenjie.album.widget.photoview.gestures.a r3 = r10.f26374k
        boolean r3 = r3.mo37767c(r12)
        if (r11 != 0) goto L_0x0072
        com.yanzhenjie.album.widget.photoview.gestures.a r11 = r10.f26374k
        boolean r11 = r11.mo37764a()
        if (r11 != 0) goto L_0x0072
        r11 = 1
        goto L_0x0073
    L_0x0072:
        r11 = 0
    L_0x0073:
        if (r0 != 0) goto L_0x007f
        com.yanzhenjie.album.widget.photoview.gestures.a r0 = r10.f26374k
        boolean r0 = r0.mo37766b()
        if (r0 != 0) goto L_0x007f
        r0 = 1
        goto L_0x0080
    L_0x007f:
        r0 = 0
    L_0x0080:
        if (r11 == 0) goto L_0x0085
        if (r0 == 0) goto L_0x0085
        r1 = 1
    L_0x0085:
        r10.f26371h = r1
        r1 = r3
        goto L_0x008a
    L_0x0089:
        r1 = r11
    L_0x008a:
        android.view.GestureDetector r11 = r10.f26373j
        if (r11 == 0) goto L_0x0095
        boolean r11 = r11.onTouchEvent(r12)
        if (r11 == 0) goto L_0x0095
        r1 = 1
    L_0x0095:
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yanzhenjie.album.widget.photoview.PhotoViewAttacher.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public C7773d mo37745h() {
        return this.f26381r;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public C7776g mo37746i() {
        return this.f26382s;
    }

    /* renamed from: a */
    public void mo37737a(float f, float f2, float f3, boolean z) {
        ImageView c = mo37740c();
        if (c != null && f >= this.f26367d && f <= this.f26369f) {
            if (z) {
                C7770a aVar = new C7770a(mo37744g(), f, f2, f3);
                c.post(aVar);
                return;
            }
            this.f26377n.setScale(f, f, f2, f3);
            m33679m();
        }
    }

    /* renamed from: a */
    public void mo37738a(boolean z) {
        this.f26363D = z;
        mo37747j();
    }

    /* renamed from: j */
    public void mo37747j() {
        ImageView c = mo37740c();
        if (c == null) {
            return;
        }
        if (this.f26363D) {
            m33671b(c);
            m33666a(c.getDrawable());
            return;
        }
        m33682p();
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public Matrix m33677k() {
        this.f26376m.set(this.f26375l);
        this.f26376m.postConcat(this.f26377n);
        return this.f26376m;
    }

    /* renamed from: l */
    private void m33678l() {
        C7771b bVar = this.f26360A;
        if (bVar != null) {
            bVar.mo37753a();
            this.f26360A = null;
        }
    }

    /* renamed from: m */
    private void m33679m() {
        if (m33681o()) {
            m33670b(m33677k());
        }
    }

    /* renamed from: n */
    private void m33680n() {
        ImageView c = mo37740c();
        if (c != null && !(c instanceof IPhotoView) && !ScaleType.MATRIX.equals(c.getScaleType())) {
            throw new IllegalStateException("The ImageView's ScaleType has been changed since attaching a PhotoViewAttacher. You should call setScaleType on the PhotoViewAttacher instead of on the ImageView");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0083  */
    /* renamed from: o */
    private boolean m33681o() {
        /*
        r12 = this;
        android.widget.ImageView r0 = r12.mo37740c()
        r1 = 0
        if (r0 != 0) goto L_0x0008
        return r1
    L_0x0008:
        android.graphics.Matrix r2 = r12.m33677k()
        android.graphics.RectF r2 = r12.m33664a(r2)
        if (r2 != 0) goto L_0x0013
        return r1
    L_0x0013:
        float r3 = r2.height()
        float r4 = r2.width()
        int r5 = r12.m33674d(r0)
        float r5 = (float) r5
        r6 = 1073741824(0x40000000, float:2.0)
        r7 = 3
        r8 = 2
        r9 = 0
        int r10 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
        if (r10 > 0) goto L_0x0045
        int[] r10 = com.yanzhenjie.album.widget.photoview.PhotoViewAttacher.C77692.f26391a
        android.widget.ImageView$ScaleType r11 = r12.f26364E
        int r11 = r11.ordinal()
        r10 = r10[r11]
        if (r10 == r8) goto L_0x0042
        if (r10 == r7) goto L_0x003e
        float r5 = r5 - r3
        float r5 = r5 / r6
        float r3 = r2.top
    L_0x003b:
        float r3 = r5 - r3
        goto L_0x0059
    L_0x003e:
        float r5 = r5 - r3
        float r3 = r2.top
        goto L_0x003b
    L_0x0042:
        float r3 = r2.top
        goto L_0x004d
    L_0x0045:
        float r3 = r2.top
        int r3 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
        if (r3 <= 0) goto L_0x004f
        float r3 = r2.top
    L_0x004d:
        float r3 = -r3
        goto L_0x0059
    L_0x004f:
        float r3 = r2.bottom
        int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
        if (r3 >= 0) goto L_0x0058
        float r3 = r2.bottom
        goto L_0x003b
    L_0x0058:
        r3 = 0
    L_0x0059:
        int r0 = r12.m33672c(r0)
        float r0 = (float) r0
        r5 = 1
        int r10 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
        if (r10 > 0) goto L_0x0083
        int[] r1 = com.yanzhenjie.album.widget.photoview.PhotoViewAttacher.C77692.f26391a
        android.widget.ImageView$ScaleType r9 = r12.f26364E
        int r9 = r9.ordinal()
        r1 = r1[r9]
        if (r1 == r8) goto L_0x007c
        if (r1 == r7) goto L_0x0078
        float r0 = r0 - r4
        float r0 = r0 / r6
        float r1 = r2.left
    L_0x0075:
        float r0 = r0 - r1
    L_0x0076:
        r9 = r0
        goto L_0x0080
    L_0x0078:
        float r0 = r0 - r4
        float r1 = r2.left
        goto L_0x0075
    L_0x007c:
        float r0 = r2.left
        float r0 = -r0
        goto L_0x0076
    L_0x0080:
        r12.f26361B = r8
        goto L_0x009f
    L_0x0083:
        float r4 = r2.left
        int r4 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
        if (r4 <= 0) goto L_0x008f
        r12.f26361B = r1
        float r0 = r2.left
        float r9 = -r0
        goto L_0x009f
    L_0x008f:
        float r1 = r2.right
        int r1 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
        if (r1 >= 0) goto L_0x009c
        float r1 = r2.right
        float r9 = r0 - r1
        r12.f26361B = r5
        goto L_0x009f
    L_0x009c:
        r0 = -1
        r12.f26361B = r0
    L_0x009f:
        android.graphics.Matrix r0 = r12.f26377n
        r0.postTranslate(r9, r3)
        return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yanzhenjie.album.widget.photoview.PhotoViewAttacher.m33681o():boolean");
    }

    /* renamed from: a */
    private RectF m33664a(Matrix matrix) {
        ImageView c = mo37740c();
        if (c != null) {
            Drawable drawable = c.getDrawable();
            if (drawable != null) {
                this.f26378o.set(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
                matrix.mapRect(this.f26378o);
                return this.f26378o;
            }
        }
        return null;
    }

    /* renamed from: a */
    private float m33663a(Matrix matrix, int i) {
        matrix.getValues(this.f26379p);
        return this.f26379p[i];
    }

    /* renamed from: p */
    private void m33682p() {
        this.f26377n.reset();
        mo37733a(this.f26362C);
        m33670b(m33677k());
        m33681o();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m33670b(Matrix matrix) {
        ImageView c = mo37740c();
        if (c != null) {
            m33680n();
            c.setImageMatrix(matrix);
            if (this.f26380q != null) {
                RectF a = m33664a(matrix);
                if (a != null) {
                    this.f26380q.mo37756a(a);
                }
            }
        }
    }

    /* renamed from: a */
    private void m33666a(Drawable drawable) {
        ImageView c = mo37740c();
        if (c != null && drawable != null) {
            float c2 = (float) m33672c(c);
            float d = (float) m33674d(c);
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.f26375l.reset();
            float f = (float) intrinsicWidth;
            float f2 = c2 / f;
            float f3 = (float) intrinsicHeight;
            float f4 = d / f3;
            if (this.f26364E == ScaleType.CENTER) {
                this.f26375l.postTranslate((c2 - f) / 2.0f, (d - f3) / 2.0f);
            } else if (this.f26364E == ScaleType.CENTER_CROP) {
                float max = Math.max(f2, f4);
                this.f26375l.postScale(max, max);
                this.f26375l.postTranslate((c2 - (f * max)) / 2.0f, (d - (f3 * max)) / 2.0f);
            } else if (this.f26364E == ScaleType.CENTER_INSIDE) {
                float min = Math.min(1.0f, Math.min(f2, f4));
                this.f26375l.postScale(min, min);
                this.f26375l.postTranslate((c2 - (f * min)) / 2.0f, (d - (f3 * min)) / 2.0f);
            } else {
                RectF rectF = new RectF(0.0f, 0.0f, f, f3);
                RectF rectF2 = new RectF(0.0f, 0.0f, c2, d);
                if (((int) this.f26362C) % TinkerReport.KEY_APPLIED_VERSION_CHECK != 0) {
                    rectF = new RectF(0.0f, 0.0f, f3, f);
                }
                int i = C77692.f26391a[this.f26364E.ordinal()];
                if (i == 2) {
                    this.f26375l.setRectToRect(rectF, rectF2, ScaleToFit.START);
                } else if (i == 3) {
                    this.f26375l.setRectToRect(rectF, rectF2, ScaleToFit.END);
                } else if (i == 4) {
                    this.f26375l.setRectToRect(rectF, rectF2, ScaleToFit.CENTER);
                } else if (i == 5) {
                    this.f26375l.setRectToRect(rectF, rectF2, ScaleToFit.FILL);
                }
            }
            m33682p();
        }
    }

    /* renamed from: c */
    private int m33672c(ImageView imageView) {
        if (imageView == null) {
            return 0;
        }
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    /* renamed from: d */
    private int m33674d(ImageView imageView) {
        if (imageView == null) {
            return 0;
        }
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }
}
