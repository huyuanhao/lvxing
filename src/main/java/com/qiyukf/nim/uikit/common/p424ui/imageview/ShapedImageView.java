package com.qiyukf.nim.uikit.common.p424ui.imageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import androidx.core.view.ViewCompat;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.unicorn.C5961R;

/* renamed from: com.qiyukf.nim.uikit.common.ui.imageview.ShapedImageView */
public class ShapedImageView extends ImageView {
    /* renamed from: a */
    private static final ScaleType f17622a = ScaleType.CENTER_CROP;
    /* renamed from: b */
    private static final Config f17623b = Config.ARGB_8888;
    /* renamed from: c */
    private final RectF f17624c;
    /* renamed from: d */
    private final RectF f17625d;
    /* renamed from: e */
    private final Matrix f17626e;
    /* renamed from: f */
    private final Paint f17627f;
    /* renamed from: g */
    private final Paint f17628g;
    /* renamed from: h */
    private final Paint f17629h;
    /* renamed from: i */
    private int f17630i;
    /* renamed from: j */
    private int f17631j;
    /* renamed from: k */
    private int f17632k;
    /* renamed from: l */
    private int f17633l;
    /* renamed from: m */
    private Bitmap f17634m;
    /* renamed from: n */
    private BitmapShader f17635n;
    /* renamed from: o */
    private int f17636o;
    /* renamed from: p */
    private int f17637p;
    /* renamed from: q */
    private float f17638q;
    /* renamed from: r */
    private float f17639r;
    /* renamed from: s */
    private ColorFilter f17640s;
    /* renamed from: t */
    private boolean f17641t;
    /* renamed from: u */
    private boolean f17642u;
    /* renamed from: v */
    private boolean f17643v;

    public ShapedImageView(Context context) {
        super(context);
        this.f17624c = new RectF();
        this.f17625d = new RectF();
        this.f17626e = new Matrix();
        this.f17627f = new Paint();
        this.f17628g = new Paint();
        this.f17629h = new Paint();
        this.f17630i = ViewCompat.MEASURED_STATE_MASK;
        this.f17631j = 0;
        this.f17632k = 0;
        this.f17633l = 0;
        m22345a();
    }

    public ShapedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShapedImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17624c = new RectF();
        this.f17625d = new RectF();
        this.f17626e = new Matrix();
        this.f17627f = new Paint();
        this.f17628g = new Paint();
        this.f17629h = new Paint();
        this.f17630i = ViewCompat.MEASURED_STATE_MASK;
        this.f17631j = 0;
        this.f17632k = 0;
        this.f17633l = 0;
        TypedArray obtainAttributes = getResources().obtainAttributes(attributeSet, C5961R.styleable.ShapedImageView);
        this.f17631j = obtainAttributes.getDimensionPixelSize(C5961R.styleable.ShapedImageView_ysf_siv_border_width, 0);
        this.f17630i = obtainAttributes.getColor(C5961R.styleable.ShapedImageView_ysf_siv_border_color, ViewCompat.MEASURED_STATE_MASK);
        this.f17643v = obtainAttributes.getBoolean(C5961R.styleable.ShapedImageView_ysf_siv_border_overlay, false);
        this.f17632k = obtainAttributes.getColor(C5961R.styleable.ShapedImageView_ysf_siv_fill_color, 0);
        this.f17633l = obtainAttributes.getInteger(C5961R.styleable.ShapedImageView_ysf_siv_shape, 0);
        obtainAttributes.recycle();
        m22345a();
    }

    /* renamed from: a */
    private static Bitmap m22344a(Drawable drawable) {
        String str = "";
        String str2 = "getBitmapFromDrawable is error";
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap createBitmap = drawable instanceof ColorDrawable ? Bitmap.createBitmap(2, 2, f17623b) : Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), f17623b);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Exception e) {
            C5264a.m21621b(str2, str, e);
            return null;
        } catch (OutOfMemoryError e2) {
            C5264a.m21621b(str2, str, e2);
            return null;
        }
    }

    /* renamed from: a */
    private void m22345a() {
        super.setScaleType(f17622a);
        this.f17641t = true;
        if (this.f17642u) {
            m22346b();
            this.f17642u = false;
        }
    }

    /* renamed from: b */
    private void m22346b() {
        float f;
        float f2;
        if (!this.f17641t) {
            this.f17642u = true;
        } else if (getWidth() != 0 || getHeight() != 0) {
            Bitmap bitmap = this.f17634m;
            if (bitmap == null) {
                invalidate();
                return;
            }
            this.f17635n = new BitmapShader(bitmap, TileMode.CLAMP, TileMode.CLAMP);
            this.f17627f.setAntiAlias(true);
            this.f17627f.setShader(this.f17635n);
            this.f17628g.setStyle(Style.STROKE);
            this.f17628g.setAntiAlias(true);
            this.f17628g.setColor(this.f17630i);
            this.f17628g.setStrokeWidth((float) this.f17631j);
            this.f17629h.setStyle(Style.FILL);
            this.f17629h.setAntiAlias(true);
            this.f17629h.setColor(this.f17632k);
            this.f17637p = this.f17634m.getHeight();
            this.f17636o = this.f17634m.getWidth();
            float f3 = 0.0f;
            this.f17625d.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.f17639r = Math.min((this.f17625d.height() - ((float) this.f17631j)) / 2.0f, (this.f17625d.width() - ((float) this.f17631j)) / 2.0f);
            this.f17624c.set(this.f17625d);
            if (!this.f17643v) {
                RectF rectF = this.f17624c;
                int i = this.f17631j;
                rectF.inset((float) i, (float) i);
            }
            this.f17638q = Math.min(this.f17624c.height() / 2.0f, this.f17624c.width() / 2.0f);
            this.f17626e.set(null);
            if (((float) this.f17636o) * this.f17624c.height() > this.f17624c.width() * ((float) this.f17637p)) {
                f2 = this.f17624c.height() / ((float) this.f17637p);
                f = (this.f17624c.width() - (((float) this.f17636o) * f2)) * 0.5f;
            } else {
                f2 = this.f17624c.width() / ((float) this.f17636o);
                f3 = (this.f17624c.height() - (((float) this.f17637p) * f2)) * 0.5f;
                f = 0.0f;
            }
            this.f17626e.setScale(f2, f2);
            this.f17626e.postTranslate(((float) ((int) (f + 0.5f))) + this.f17624c.left, ((float) ((int) (f3 + 0.5f))) + this.f17624c.top);
            this.f17635n.setLocalMatrix(this.f17626e);
            invalidate();
        }
    }

    /* renamed from: a */
    public final void mo27550a(int i) {
        if (this.f17633l == i) {
            return;
        }
        if (i >= 0 || i <= 1) {
            this.f17633l = i;
        }
    }

    public ScaleType getScaleType() {
        return f17622a;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f17634m != null) {
            if (this.f17633l != 1) {
                if (this.f17632k != 0) {
                    canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, this.f17638q, this.f17629h);
                }
                canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, this.f17638q, this.f17627f);
                if (this.f17631j != 0) {
                    canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, this.f17639r, this.f17628g);
                }
                return;
            }
            if (this.f17632k != 0) {
                canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), this.f17629h);
            }
            canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), this.f17627f);
            if (this.f17631j != 0) {
                canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), this.f17628g);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        m22346b();
    }

    public void setAdjustViewBounds(boolean z) {
        if (z) {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter != this.f17640s) {
            this.f17640s = colorFilter;
            this.f17627f.setColorFilter(this.f17640s);
            invalidate();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.f17634m = bitmap;
        m22346b();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.f17634m = m22344a(drawable);
        m22346b();
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        this.f17634m = m22344a(getDrawable());
        m22346b();
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        this.f17634m = uri != null ? m22344a(getDrawable()) : null;
        m22346b();
    }

    public void setScaleType(ScaleType scaleType) {
        if (scaleType != f17622a) {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[]{scaleType}));
        }
    }
}
