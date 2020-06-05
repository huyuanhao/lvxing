package p641de.hdodenhof.circleimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import androidx.core.view.ViewCompat;

/* renamed from: de.hdodenhof.circleimageview.CircleImageView */
public class CircleImageView extends ImageView {
    /* renamed from: a */
    private static final ScaleType f26700a = ScaleType.CENTER_CROP;
    /* renamed from: b */
    private static final Config f26701b = Config.ARGB_8888;
    /* renamed from: c */
    private final RectF f26702c;
    /* access modifiers changed from: private|final */
    /* renamed from: d */
    public final RectF f26703d;
    /* renamed from: e */
    private final Matrix f26704e;
    /* renamed from: f */
    private final Paint f26705f;
    /* renamed from: g */
    private final Paint f26706g;
    /* renamed from: h */
    private final Paint f26707h;
    /* renamed from: i */
    private int f26708i;
    /* renamed from: j */
    private int f26709j;
    /* renamed from: k */
    private int f26710k;
    /* renamed from: l */
    private Bitmap f26711l;
    /* renamed from: m */
    private BitmapShader f26712m;
    /* renamed from: n */
    private int f26713n;
    /* renamed from: o */
    private int f26714o;
    /* renamed from: p */
    private float f26715p;
    /* renamed from: q */
    private float f26716q;
    /* renamed from: r */
    private ColorFilter f26717r;
    /* renamed from: s */
    private boolean f26718s;
    /* renamed from: t */
    private boolean f26719t;
    /* renamed from: u */
    private boolean f26720u;
    /* renamed from: v */
    private boolean f26721v;

    /* renamed from: de.hdodenhof.circleimageview.CircleImageView$a */
    private class C7849a extends ViewOutlineProvider {
        private C7849a() {
        }

        public void getOutline(View view, Outline outline) {
            Rect rect = new Rect();
            CircleImageView.this.f26703d.roundOut(rect);
            outline.setRoundRect(rect, ((float) rect.width()) / 2.0f);
        }
    }

    public CircleImageView(Context context) {
        super(context);
        this.f26702c = new RectF();
        this.f26703d = new RectF();
        this.f26704e = new Matrix();
        this.f26705f = new Paint();
        this.f26706g = new Paint();
        this.f26707h = new Paint();
        this.f26708i = ViewCompat.MEASURED_STATE_MASK;
        this.f26709j = 0;
        this.f26710k = 0;
        m34143a();
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f26702c = new RectF();
        this.f26703d = new RectF();
        this.f26704e = new Matrix();
        this.f26705f = new Paint();
        this.f26706g = new Paint();
        this.f26707h = new Paint();
        this.f26708i = ViewCompat.MEASURED_STATE_MASK;
        this.f26709j = 0;
        this.f26710k = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CircleImageView, i, 0);
        this.f26709j = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleImageView_civ_border_width, 0);
        this.f26708i = obtainStyledAttributes.getColor(R.styleable.CircleImageView_civ_border_color, ViewCompat.MEASURED_STATE_MASK);
        this.f26720u = obtainStyledAttributes.getBoolean(R.styleable.CircleImageView_civ_border_overlay, false);
        this.f26710k = obtainStyledAttributes.getColor(R.styleable.CircleImageView_civ_circle_background_color, 0);
        obtainStyledAttributes.recycle();
        m34143a();
    }

    /* renamed from: a */
    private void m34143a() {
        super.setScaleType(f26700a);
        this.f26718s = true;
        if (VERSION.SDK_INT >= 21) {
            setOutlineProvider(new C7849a());
        }
        if (this.f26719t) {
            m34147d();
            this.f26719t = false;
        }
    }

    public ScaleType getScaleType() {
        return f26700a;
    }

    public void setScaleType(ScaleType scaleType) {
        if (scaleType != f26700a) {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[]{scaleType}));
        }
    }

    public void setAdjustViewBounds(boolean z) {
        if (z) {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f26721v) {
            super.onDraw(canvas);
        } else if (this.f26711l != null) {
            if (this.f26710k != 0) {
                canvas.drawCircle(this.f26702c.centerX(), this.f26702c.centerY(), this.f26715p, this.f26707h);
            }
            canvas.drawCircle(this.f26702c.centerX(), this.f26702c.centerY(), this.f26715p, this.f26705f);
            if (this.f26709j > 0) {
                canvas.drawCircle(this.f26703d.centerX(), this.f26703d.centerY(), this.f26716q, this.f26706g);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        m34147d();
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
        m34147d();
    }

    public void setPaddingRelative(int i, int i2, int i3, int i4) {
        super.setPaddingRelative(i, i2, i3, i4);
        m34147d();
    }

    public int getBorderColor() {
        return this.f26708i;
    }

    public void setBorderColor(int i) {
        if (i != this.f26708i) {
            this.f26708i = i;
            this.f26706g.setColor(this.f26708i);
            invalidate();
        }
    }

    public int getCircleBackgroundColor() {
        return this.f26710k;
    }

    public void setCircleBackgroundColor(int i) {
        if (i != this.f26710k) {
            this.f26710k = i;
            this.f26707h.setColor(i);
            invalidate();
        }
    }

    public void setCircleBackgroundColorResource(int i) {
        setCircleBackgroundColor(getContext().getResources().getColor(i));
    }

    public int getBorderWidth() {
        return this.f26709j;
    }

    public void setBorderWidth(int i) {
        if (i != this.f26709j) {
            this.f26709j = i;
            m34147d();
        }
    }

    public void setBorderOverlay(boolean z) {
        if (z != this.f26720u) {
            this.f26720u = z;
            m34147d();
        }
    }

    public void setDisableCircularTransformation(boolean z) {
        if (this.f26721v != z) {
            this.f26721v = z;
            m34146c();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        m34146c();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        m34146c();
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        m34146c();
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        m34146c();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter != this.f26717r) {
            this.f26717r = colorFilter;
            m34145b();
            invalidate();
        }
    }

    public ColorFilter getColorFilter() {
        return this.f26717r;
    }

    /* renamed from: b */
    private void m34145b() {
        this.f26705f.setColorFilter(this.f26717r);
    }

    /* renamed from: a */
    private Bitmap m34141a(Drawable drawable) {
        Bitmap bitmap;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            if (drawable instanceof ColorDrawable) {
                bitmap = Bitmap.createBitmap(2, 2, f26701b);
            } else {
                bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), f26701b);
            }
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    private void m34146c() {
        if (this.f26721v) {
            this.f26711l = null;
        } else {
            this.f26711l = m34141a(getDrawable());
        }
        m34147d();
    }

    /* renamed from: d */
    private void m34147d() {
        if (!this.f26718s) {
            this.f26719t = true;
        } else if (getWidth() != 0 || getHeight() != 0) {
            Bitmap bitmap = this.f26711l;
            if (bitmap == null) {
                invalidate();
                return;
            }
            this.f26712m = new BitmapShader(bitmap, TileMode.CLAMP, TileMode.CLAMP);
            this.f26705f.setAntiAlias(true);
            this.f26705f.setShader(this.f26712m);
            this.f26706g.setStyle(Style.STROKE);
            this.f26706g.setAntiAlias(true);
            this.f26706g.setColor(this.f26708i);
            this.f26706g.setStrokeWidth((float) this.f26709j);
            this.f26707h.setStyle(Style.FILL);
            this.f26707h.setAntiAlias(true);
            this.f26707h.setColor(this.f26710k);
            this.f26714o = this.f26711l.getHeight();
            this.f26713n = this.f26711l.getWidth();
            this.f26703d.set(m34148e());
            this.f26716q = Math.min((this.f26703d.height() - ((float) this.f26709j)) / 2.0f, (this.f26703d.width() - ((float) this.f26709j)) / 2.0f);
            this.f26702c.set(this.f26703d);
            if (!this.f26720u) {
                int i = this.f26709j;
                if (i > 0) {
                    this.f26702c.inset(((float) i) - 1.0f, ((float) i) - 1.0f);
                }
            }
            this.f26715p = Math.min(this.f26702c.height() / 2.0f, this.f26702c.width() / 2.0f);
            m34145b();
            m34149f();
            invalidate();
        }
    }

    /* renamed from: e */
    private RectF m34148e() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int min = Math.min(width, height);
        float paddingLeft = ((float) getPaddingLeft()) + (((float) (width - min)) / 2.0f);
        float paddingTop = ((float) getPaddingTop()) + (((float) (height - min)) / 2.0f);
        float f = (float) min;
        return new RectF(paddingLeft, paddingTop, paddingLeft + f, f + paddingTop);
    }

    /* renamed from: f */
    private void m34149f() {
        float f;
        float f2;
        this.f26704e.set(null);
        float f3 = 0.0f;
        if (((float) this.f26713n) * this.f26702c.height() > this.f26702c.width() * ((float) this.f26714o)) {
            f2 = this.f26702c.height() / ((float) this.f26714o);
            f = (this.f26702c.width() - (((float) this.f26713n) * f2)) * 0.5f;
        } else {
            f2 = this.f26702c.width() / ((float) this.f26713n);
            f3 = (this.f26702c.height() - (((float) this.f26714o) * f2)) * 0.5f;
            f = 0.0f;
        }
        this.f26704e.setScale(f2, f2);
        this.f26704e.postTranslate(((float) ((int) (f + 0.5f))) + this.f26702c.left, ((float) ((int) (f3 + 0.5f))) + this.f26702c.top);
        this.f26712m.setLocalMatrix(this.f26704e);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f26721v) {
            return super.onTouchEvent(motionEvent);
        }
        boolean z = m34144a(motionEvent.getX(), motionEvent.getY()) && super.onTouchEvent(motionEvent);
        return z;
    }

    /* renamed from: a */
    private boolean m34144a(float f, float f2) {
        boolean z = true;
        if (this.f26703d.isEmpty()) {
            return true;
        }
        if (Math.pow((double) (f - this.f26703d.centerX()), 2.0d) + Math.pow((double) (f2 - this.f26703d.centerY()), 2.0d) > Math.pow((double) this.f26716q, 2.0d)) {
            z = false;
        }
        return z;
    }
}
