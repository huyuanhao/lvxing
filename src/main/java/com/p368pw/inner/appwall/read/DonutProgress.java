package com.p368pw.inner.appwall.read;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import androidx.core.app.NotificationCompat;
import com.p368pw.inner.p369a.p379e.p380a.p382b.C4925a;
import com.pw.R;

/* renamed from: com.pw.inner.appwall.read.DonutProgress */
public class DonutProgress extends View {
    /* renamed from: A */
    private final float f16481A;
    /* renamed from: B */
    private final int f16482B;
    /* renamed from: C */
    private final int f16483C;
    /* renamed from: D */
    private final int f16484D;
    /* renamed from: E */
    private final int f16485E;
    /* renamed from: F */
    private final int f16486F;
    /* renamed from: G */
    private final int f16487G;
    /* renamed from: H */
    private final int f16488H;
    /* renamed from: I */
    private final float f16489I;
    /* renamed from: J */
    private final float f16490J;
    /* renamed from: K */
    private final int f16491K;
    /* renamed from: a */
    protected Paint f16492a;
    /* renamed from: b */
    protected Paint f16493b;
    /* renamed from: c */
    private Paint f16494c;
    /* renamed from: d */
    private Paint f16495d;
    /* renamed from: e */
    private Paint f16496e;
    /* renamed from: f */
    private RectF f16497f;
    /* renamed from: g */
    private RectF f16498g;
    /* renamed from: h */
    private int f16499h;
    /* renamed from: i */
    private boolean f16500i;
    /* renamed from: j */
    private float f16501j;
    /* renamed from: k */
    private int f16502k;
    /* renamed from: l */
    private int f16503l;
    /* renamed from: m */
    private float f16504m;
    /* renamed from: n */
    private int f16505n;
    /* renamed from: o */
    private int f16506o;
    /* renamed from: p */
    private int f16507p;
    /* renamed from: q */
    private int f16508q;
    /* renamed from: r */
    private float f16509r;
    /* renamed from: s */
    private float f16510s;
    /* renamed from: t */
    private int f16511t;
    /* renamed from: u */
    private String f16512u;
    /* renamed from: v */
    private String f16513v;
    /* renamed from: w */
    private String f16514w;
    /* renamed from: x */
    private float f16515x;
    /* renamed from: y */
    private String f16516y;
    /* renamed from: z */
    private float f16517z;

    public DonutProgress(Context context) {
        this(context, null);
    }

    public DonutProgress(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DonutProgress(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f16497f = new RectF();
        this.f16498g = new RectF();
        this.f16499h = 0;
        this.f16504m = 0.0f;
        this.f16512u = "";
        this.f16513v = "%";
        this.f16514w = null;
        this.f16482B = Color.rgb(66, 145, 241);
        this.f16483C = Color.rgb(204, 204, 204);
        this.f16484D = Color.rgb(66, 145, 241);
        this.f16485E = Color.rgb(66, 145, 241);
        this.f16486F = 0;
        this.f16487G = 100;
        this.f16488H = 0;
        this.f16489I = (float) C4925a.m20443a(context, 18.0f);
        this.f16491K = C4925a.m20443a(context, 100.0f);
        this.f16481A = (float) C4925a.m20443a(context, 10.0f);
        this.f16490J = (float) C4925a.m20443a(context, 18.0f);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.DonutProgress, i, 0);
        mo26492a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        mo26491a();
    }

    /* renamed from: a */
    private int m21060a(int i) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        int i2 = this.f16491K;
        return mode == Integer.MIN_VALUE ? Math.min(i2, size) : i2;
    }

    private float getProgressAngle() {
        return (getProgress() / ((float) this.f16505n)) * 360.0f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo26491a() {
        if (this.f16500i) {
            this.f16492a = new TextPaint();
            this.f16492a.setColor(this.f16502k);
            this.f16492a.setTextSize(this.f16501j);
            this.f16492a.setAntiAlias(true);
            this.f16493b = new TextPaint();
            this.f16493b.setColor(this.f16503l);
            this.f16493b.setTextSize(this.f16515x);
            this.f16493b.setAntiAlias(true);
        }
        this.f16494c = new Paint();
        this.f16494c.setColor(this.f16506o);
        this.f16494c.setStyle(Style.STROKE);
        this.f16494c.setAntiAlias(true);
        this.f16494c.setStrokeWidth(this.f16509r);
        this.f16495d = new Paint();
        this.f16495d.setColor(this.f16507p);
        this.f16495d.setStyle(Style.STROKE);
        this.f16495d.setAntiAlias(true);
        this.f16495d.setStrokeWidth(this.f16510s);
        this.f16496e = new Paint();
        this.f16496e.setColor(this.f16511t);
        this.f16496e.setAntiAlias(true);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo26492a(TypedArray typedArray) {
        this.f16506o = typedArray.getColor(R.styleable.DonutProgress_donut_finished_color, this.f16482B);
        this.f16507p = typedArray.getColor(R.styleable.DonutProgress_donut_unfinished_color, this.f16483C);
        this.f16500i = typedArray.getBoolean(R.styleable.DonutProgress_donut_show_text, true);
        this.f16499h = typedArray.getResourceId(R.styleable.DonutProgress_donut_inner_drawable, 0);
        setMax(typedArray.getInt(R.styleable.DonutProgress_donut_max, 100));
        setProgress(typedArray.getFloat(R.styleable.DonutProgress_donut_progress, 0.0f));
        this.f16509r = typedArray.getDimension(R.styleable.DonutProgress_donut_finished_stroke_width, this.f16481A);
        this.f16510s = typedArray.getDimension(R.styleable.DonutProgress_donut_unfinished_stroke_width, this.f16481A);
        if (this.f16500i) {
            if (typedArray.getString(R.styleable.DonutProgress_donut_prefix_text) != null) {
                this.f16512u = typedArray.getString(R.styleable.DonutProgress_donut_prefix_text);
            }
            if (typedArray.getString(R.styleable.DonutProgress_donut_suffix_text) != null) {
                this.f16513v = typedArray.getString(R.styleable.DonutProgress_donut_suffix_text);
            }
            if (typedArray.getString(R.styleable.DonutProgress_donut_text) != null) {
                this.f16514w = typedArray.getString(R.styleable.DonutProgress_donut_text);
            }
            this.f16502k = typedArray.getColor(R.styleable.DonutProgress_donut_text_color, this.f16484D);
            this.f16501j = typedArray.getDimension(R.styleable.DonutProgress_donut_text_size, this.f16489I);
            this.f16515x = typedArray.getDimension(R.styleable.DonutProgress_donut_inner_bottom_text_size, this.f16490J);
            this.f16503l = typedArray.getColor(R.styleable.DonutProgress_donut_inner_bottom_text_color, this.f16485E);
            this.f16516y = typedArray.getString(R.styleable.DonutProgress_donut_inner_bottom_text);
        }
        this.f16515x = typedArray.getDimension(R.styleable.DonutProgress_donut_inner_bottom_text_size, this.f16490J);
        this.f16503l = typedArray.getColor(R.styleable.DonutProgress_donut_inner_bottom_text_color, this.f16485E);
        this.f16516y = typedArray.getString(R.styleable.DonutProgress_donut_inner_bottom_text);
        this.f16508q = typedArray.getInt(R.styleable.DonutProgress_donut_circle_starting_degree, 0);
        this.f16511t = typedArray.getColor(R.styleable.DonutProgress_donut_background_color, 0);
    }

    public int getAttributeResourceId() {
        return this.f16499h;
    }

    public int getFinishedStrokeColor() {
        return this.f16506o;
    }

    public float getFinishedStrokeWidth() {
        return this.f16509r;
    }

    public int getInnerBackgroundColor() {
        return this.f16511t;
    }

    public String getInnerBottomText() {
        return this.f16516y;
    }

    public int getInnerBottomTextColor() {
        return this.f16503l;
    }

    public float getInnerBottomTextSize() {
        return this.f16515x;
    }

    public int getMax() {
        return this.f16505n;
    }

    public String getPrefixText() {
        return this.f16512u;
    }

    public float getProgress() {
        return this.f16504m;
    }

    public int getStartingDegree() {
        return this.f16508q;
    }

    public String getSuffixText() {
        return this.f16513v;
    }

    public String getText() {
        return this.f16514w;
    }

    public int getTextColor() {
        return this.f16502k;
    }

    public float getTextSize() {
        return this.f16501j;
    }

    public int getUnfinishedStrokeColor() {
        return this.f16507p;
    }

    public float getUnfinishedStrokeWidth() {
        return this.f16510s;
    }

    public void invalidate() {
        mo26491a();
        super.invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float max = Math.max(this.f16509r, this.f16510s);
        this.f16497f.set(max, max, ((float) getWidth()) - max, ((float) getHeight()) - max);
        this.f16498g.set(max, max, ((float) getWidth()) - max, ((float) getHeight()) - max);
        canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, ((((float) getWidth()) - Math.min(this.f16509r, this.f16510s)) + Math.abs(this.f16509r - this.f16510s)) / 2.0f, this.f16496e);
        canvas.drawArc(this.f16497f, (float) getStartingDegree(), getProgressAngle(), false, this.f16494c);
        Canvas canvas2 = canvas;
        canvas2.drawArc(this.f16498g, getProgressAngle() + ((float) getStartingDegree()), 360.0f - getProgressAngle(), false, this.f16495d);
        if (this.f16500i) {
            String str = this.f16514w;
            if (str == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f16512u);
                sb.append(this.f16504m);
                sb.append(this.f16513v);
                str = sb.toString();
            }
            if (!TextUtils.isEmpty(str)) {
                canvas.drawText(str, (((float) getWidth()) - this.f16492a.measureText(str)) / 2.0f, (((float) getWidth()) - (this.f16492a.descent() + this.f16492a.ascent())) / 2.0f, this.f16492a);
            }
            if (!TextUtils.isEmpty(getInnerBottomText())) {
                this.f16493b.setTextSize(this.f16515x);
                canvas.drawText(getInnerBottomText(), (((float) getWidth()) - this.f16493b.measureText(getInnerBottomText())) / 2.0f, (((float) getHeight()) - this.f16517z) - ((this.f16492a.descent() + this.f16492a.ascent()) / 2.0f), this.f16493b);
            }
        }
        if (this.f16499h != 0) {
            Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), this.f16499h);
            canvas.drawBitmap(decodeResource, ((float) (getWidth() - decodeResource.getWidth())) / 2.0f, ((float) (getHeight() - decodeResource.getHeight())) / 2.0f, null);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(m21060a(i), m21060a(i2));
        this.f16517z = (float) (getHeight() - ((getHeight() * 3) / 4));
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.f16502k = bundle.getInt("text_color");
            this.f16501j = bundle.getFloat("text_size");
            this.f16515x = bundle.getFloat("inner_bottom_text_size");
            this.f16516y = bundle.getString("inner_bottom_text");
            this.f16503l = bundle.getInt("inner_bottom_text_color");
            this.f16506o = bundle.getInt("finished_stroke_color");
            this.f16507p = bundle.getInt("unfinished_stroke_color");
            this.f16509r = bundle.getFloat("finished_stroke_width");
            this.f16510s = bundle.getFloat("unfinished_stroke_width");
            this.f16511t = bundle.getInt("inner_background_color");
            this.f16499h = bundle.getInt("inner_drawable");
            mo26491a();
            setMax(bundle.getInt("max"));
            setStartingDegree(bundle.getInt("starting_degree"));
            setProgress(bundle.getFloat(NotificationCompat.CATEGORY_PROGRESS));
            this.f16512u = bundle.getString("prefix");
            this.f16513v = bundle.getString("suffix");
            this.f16514w = bundle.getString("text");
            super.onRestoreInstanceState(bundle.getParcelable("saved_instance"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("saved_instance", super.onSaveInstanceState());
        bundle.putInt("text_color", getTextColor());
        bundle.putFloat("text_size", getTextSize());
        bundle.putFloat("inner_bottom_text_size", getInnerBottomTextSize());
        String str = "inner_bottom_text_color";
        bundle.putFloat(str, (float) getInnerBottomTextColor());
        bundle.putString("inner_bottom_text", getInnerBottomText());
        bundle.putInt(str, getInnerBottomTextColor());
        bundle.putInt("finished_stroke_color", getFinishedStrokeColor());
        bundle.putInt("unfinished_stroke_color", getUnfinishedStrokeColor());
        bundle.putInt("max", getMax());
        bundle.putInt("starting_degree", getStartingDegree());
        bundle.putFloat(NotificationCompat.CATEGORY_PROGRESS, getProgress());
        bundle.putString("suffix", getSuffixText());
        bundle.putString("prefix", getPrefixText());
        bundle.putString("text", getText());
        bundle.putFloat("finished_stroke_width", getFinishedStrokeWidth());
        bundle.putFloat("unfinished_stroke_width", getUnfinishedStrokeWidth());
        bundle.putInt("inner_background_color", getInnerBackgroundColor());
        bundle.putInt("inner_drawable", getAttributeResourceId());
        return bundle;
    }

    public void setAttributeResourceId(int i) {
        this.f16499h = i;
    }

    public void setDonut_progress(String str) {
        if (!TextUtils.isEmpty(str)) {
            setProgress((float) Integer.parseInt(str));
        }
    }

    public void setFinishedStrokeColor(int i) {
        this.f16506o = i;
        invalidate();
    }

    public void setFinishedStrokeWidth(float f) {
        this.f16509r = f;
        invalidate();
    }

    public void setInnerBackgroundColor(int i) {
        this.f16511t = i;
        invalidate();
    }

    public void setInnerBottomText(String str) {
        this.f16516y = str;
        invalidate();
    }

    public void setInnerBottomTextColor(int i) {
        this.f16503l = i;
        invalidate();
    }

    public void setInnerBottomTextSize(float f) {
        this.f16515x = f;
        invalidate();
    }

    public void setMax(int i) {
        if (i > 0) {
            this.f16505n = i;
            invalidate();
        }
    }

    public void setPrefixText(String str) {
        this.f16512u = str;
        invalidate();
    }

    public void setProgress(float f) {
        this.f16504m = f;
        if (this.f16504m > ((float) getMax())) {
            this.f16504m %= (float) getMax();
        }
        invalidate();
    }

    public void setShowText(boolean z) {
        this.f16500i = z;
    }

    public void setStartingDegree(int i) {
        this.f16508q = i;
        invalidate();
    }

    public void setSuffixText(String str) {
        this.f16513v = str;
        invalidate();
    }

    public void setText(String str) {
        this.f16514w = str;
        invalidate();
    }

    public void setTextColor(int i) {
        this.f16502k = i;
        invalidate();
    }

    public void setTextSize(float f) {
        this.f16501j = f;
        invalidate();
    }

    public void setUnfinishedStrokeColor(int i) {
        this.f16507p = i;
        invalidate();
    }

    public void setUnfinishedStrokeWidth(float f) {
        this.f16510s = f;
        invalidate();
    }
}
