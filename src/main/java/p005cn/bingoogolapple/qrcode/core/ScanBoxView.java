package p005cn.bingoogolapple.qrcode.core;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

/* renamed from: cn.bingoogolapple.qrcode.core.ScanBoxView */
public class ScanBoxView extends View {
    /* renamed from: A */
    private int f1136A;
    /* renamed from: B */
    private boolean f1137B;
    /* renamed from: C */
    private String f1138C;
    /* renamed from: D */
    private String f1139D;
    /* renamed from: E */
    private String f1140E;
    /* renamed from: F */
    private int f1141F;
    /* renamed from: G */
    private int f1142G;
    /* renamed from: H */
    private boolean f1143H;
    /* renamed from: I */
    private int f1144I;
    /* renamed from: J */
    private boolean f1145J;
    /* renamed from: K */
    private int f1146K;
    /* renamed from: L */
    private boolean f1147L;
    /* renamed from: M */
    private boolean f1148M;
    /* renamed from: N */
    private boolean f1149N;
    /* renamed from: O */
    private Drawable f1150O;
    /* renamed from: P */
    private Bitmap f1151P;
    /* renamed from: Q */
    private float f1152Q;
    /* renamed from: R */
    private float f1153R;
    /* renamed from: S */
    private Bitmap f1154S;
    /* renamed from: T */
    private Bitmap f1155T;
    /* renamed from: U */
    private Bitmap f1156U;
    /* renamed from: V */
    private Bitmap f1157V;
    /* renamed from: W */
    private float f1158W;
    /* renamed from: a */
    private int f1159a;
    /* renamed from: aa */
    private StaticLayout f1160aa;
    /* renamed from: ab */
    private int f1161ab;
    /* renamed from: ac */
    private boolean f1162ac;
    /* renamed from: ad */
    private boolean f1163ad;
    /* renamed from: ae */
    private QRCodeView f1164ae;
    /* renamed from: b */
    private int f1165b;
    /* renamed from: c */
    private Rect f1166c;
    /* renamed from: d */
    private float f1167d;
    /* renamed from: e */
    private float f1168e;
    /* renamed from: f */
    private Paint f1169f = new Paint();
    /* renamed from: g */
    private TextPaint f1170g;
    /* renamed from: h */
    private int f1171h;
    /* renamed from: i */
    private int f1172i;
    /* renamed from: j */
    private int f1173j;
    /* renamed from: k */
    private int f1174k;
    /* renamed from: l */
    private int f1175l;
    /* renamed from: m */
    private int f1176m;
    /* renamed from: n */
    private int f1177n;
    /* renamed from: o */
    private int f1178o;
    /* renamed from: p */
    private int f1179p;
    /* renamed from: q */
    private int f1180q;
    /* renamed from: r */
    private int f1181r;
    /* renamed from: s */
    private boolean f1182s;
    /* renamed from: t */
    private Drawable f1183t;
    /* renamed from: u */
    private Bitmap f1184u;
    /* renamed from: v */
    private int f1185v;
    /* renamed from: w */
    private int f1186w;
    /* renamed from: x */
    private int f1187x;
    /* renamed from: y */
    private float f1188y;
    /* renamed from: z */
    private int f1189z;

    public ScanBoxView(Context context) {
        super(context);
        this.f1169f.setAntiAlias(true);
        this.f1171h = Color.parseColor("#33FFFFFF");
        this.f1172i = -1;
        this.f1173j = BGAQRCodeUtil.m1026a(context, 20.0f);
        this.f1174k = BGAQRCodeUtil.m1026a(context, 3.0f);
        this.f1179p = BGAQRCodeUtil.m1026a(context, 1.0f);
        this.f1180q = -1;
        this.f1178o = BGAQRCodeUtil.m1026a(context, 90.0f);
        this.f1175l = BGAQRCodeUtil.m1026a(context, 200.0f);
        this.f1177n = BGAQRCodeUtil.m1026a(context, 140.0f);
        this.f1181r = 0;
        this.f1182s = false;
        this.f1183t = null;
        this.f1184u = null;
        this.f1185v = BGAQRCodeUtil.m1026a(context, 1.0f);
        this.f1186w = -1;
        this.f1187x = 1000;
        this.f1188y = -1.0f;
        this.f1189z = 1;
        this.f1136A = 0;
        this.f1137B = false;
        this.f1159a = BGAQRCodeUtil.m1026a(context, 2.0f);
        this.f1140E = null;
        this.f1141F = BGAQRCodeUtil.m1031b(context, 14.0f);
        this.f1142G = -1;
        this.f1143H = false;
        this.f1144I = BGAQRCodeUtil.m1026a(context, 20.0f);
        this.f1145J = false;
        this.f1146K = Color.parseColor("#22000000");
        this.f1147L = false;
        this.f1148M = false;
        this.f1149N = false;
        this.f1170g = new TextPaint();
        this.f1170g.setAntiAlias(true);
        this.f1161ab = BGAQRCodeUtil.m1026a(context, 4.0f);
        this.f1162ac = false;
        this.f1163ad = false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo9646a(QRCodeView qRCodeView, AttributeSet attributeSet) {
        this.f1164ae = qRCodeView;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            m1013a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        m1016c();
    }

    /* renamed from: a */
    private void m1013a(int i, TypedArray typedArray) {
        if (i == R.styleable.QRCodeView_qrcv_topOffset) {
            this.f1178o = typedArray.getDimensionPixelSize(i, this.f1178o);
        } else if (i == R.styleable.QRCodeView_qrcv_cornerSize) {
            this.f1174k = typedArray.getDimensionPixelSize(i, this.f1174k);
        } else if (i == R.styleable.QRCodeView_qrcv_cornerLength) {
            this.f1173j = typedArray.getDimensionPixelSize(i, this.f1173j);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineSize) {
            this.f1179p = typedArray.getDimensionPixelSize(i, this.f1179p);
        } else if (i == R.styleable.QRCodeView_qrcv_rectWidth) {
            this.f1175l = typedArray.getDimensionPixelSize(i, this.f1175l);
        } else if (i == R.styleable.QRCodeView_qrcv_maskColor) {
            this.f1171h = typedArray.getColor(i, this.f1171h);
        } else if (i == R.styleable.QRCodeView_qrcv_cornerColor) {
            this.f1172i = typedArray.getColor(i, this.f1172i);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineColor) {
            this.f1180q = typedArray.getColor(i, this.f1180q);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineMargin) {
            this.f1181r = typedArray.getDimensionPixelSize(i, this.f1181r);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowDefaultScanLineDrawable) {
            this.f1182s = typedArray.getBoolean(i, this.f1182s);
        } else if (i == R.styleable.QRCodeView_qrcv_customScanLineDrawable) {
            this.f1183t = typedArray.getDrawable(i);
        } else if (i == R.styleable.QRCodeView_qrcv_borderSize) {
            this.f1185v = typedArray.getDimensionPixelSize(i, this.f1185v);
        } else if (i == R.styleable.QRCodeView_qrcv_borderColor) {
            this.f1186w = typedArray.getColor(i, this.f1186w);
        } else if (i == R.styleable.QRCodeView_qrcv_animTime) {
            this.f1187x = typedArray.getInteger(i, this.f1187x);
        } else if (i == R.styleable.QRCodeView_qrcv_verticalBias) {
            this.f1188y = typedArray.getFloat(i, this.f1188y);
        } else if (i == R.styleable.QRCodeView_qrcv_cornerDisplayType) {
            this.f1189z = typedArray.getInteger(i, this.f1189z);
        } else if (i == R.styleable.QRCodeView_qrcv_toolbarHeight) {
            this.f1136A = typedArray.getDimensionPixelSize(i, this.f1136A);
        } else if (i == R.styleable.QRCodeView_qrcv_barcodeRectHeight) {
            this.f1177n = typedArray.getDimensionPixelSize(i, this.f1177n);
        } else if (i == R.styleable.QRCodeView_qrcv_isBarcode) {
            this.f1137B = typedArray.getBoolean(i, this.f1137B);
        } else if (i == R.styleable.QRCodeView_qrcv_barCodeTipText) {
            this.f1139D = typedArray.getString(i);
        } else if (i == R.styleable.QRCodeView_qrcv_qrCodeTipText) {
            this.f1138C = typedArray.getString(i);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextSize) {
            this.f1141F = typedArray.getDimensionPixelSize(i, this.f1141F);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextColor) {
            this.f1142G = typedArray.getColor(i, this.f1142G);
        } else if (i == R.styleable.QRCodeView_qrcv_isTipTextBelowRect) {
            this.f1143H = typedArray.getBoolean(i, this.f1143H);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextMargin) {
            this.f1144I = typedArray.getDimensionPixelSize(i, this.f1144I);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowTipTextAsSingleLine) {
            this.f1145J = typedArray.getBoolean(i, this.f1145J);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowTipBackground) {
            this.f1147L = typedArray.getBoolean(i, this.f1147L);
        } else if (i == R.styleable.QRCodeView_qrcv_tipBackgroundColor) {
            this.f1146K = typedArray.getColor(i, this.f1146K);
        } else if (i == R.styleable.QRCodeView_qrcv_isScanLineReverse) {
            this.f1148M = typedArray.getBoolean(i, this.f1148M);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowDefaultGridScanLineDrawable) {
            this.f1149N = typedArray.getBoolean(i, this.f1149N);
        } else if (i == R.styleable.QRCodeView_qrcv_customGridScanLineDrawable) {
            this.f1150O = typedArray.getDrawable(i);
        } else if (i == R.styleable.QRCodeView_qrcv_isOnlyDecodeScanBoxArea) {
            this.f1162ac = typedArray.getBoolean(i, this.f1162ac);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowLocationPoint) {
            this.f1163ad = typedArray.getBoolean(i, this.f1163ad);
        }
    }

    /* renamed from: c */
    private void m1016c() {
        Drawable drawable = this.f1150O;
        if (drawable != null) {
            this.f1156U = ((BitmapDrawable) drawable).getBitmap();
        }
        if (this.f1156U == null) {
            this.f1156U = BitmapFactory.decodeResource(getResources(), R.mipmap.qrcode_default_grid_scan_line);
            this.f1156U = BGAQRCodeUtil.m1032b(this.f1156U, this.f1180q);
        }
        this.f1157V = BGAQRCodeUtil.m1027a(this.f1156U, 90);
        this.f1157V = BGAQRCodeUtil.m1027a(this.f1157V, 90);
        this.f1157V = BGAQRCodeUtil.m1027a(this.f1157V, 90);
        Drawable drawable2 = this.f1183t;
        if (drawable2 != null) {
            this.f1154S = ((BitmapDrawable) drawable2).getBitmap();
        }
        if (this.f1154S == null) {
            this.f1154S = BitmapFactory.decodeResource(getResources(), R.mipmap.qrcode_default_scan_line);
            this.f1154S = BGAQRCodeUtil.m1032b(this.f1154S, this.f1180q);
        }
        this.f1155T = BGAQRCodeUtil.m1027a(this.f1154S, 90);
        this.f1178o += this.f1136A;
        this.f1158W = (((float) this.f1174k) * 1.0f) / 2.0f;
        this.f1170g.setTextSize((float) this.f1141F);
        this.f1170g.setColor(this.f1142G);
        setIsBarcode(this.f1137B);
    }

    public void onDraw(Canvas canvas) {
        if (this.f1166c != null) {
            m1014a(canvas);
            m1015b(canvas);
            m1017c(canvas);
            m1019d(canvas);
            m1021e(canvas);
            m1018d();
        }
    }

    /* renamed from: a */
    private void m1014a(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.f1171h != 0) {
            this.f1169f.setStyle(Style.FILL);
            this.f1169f.setColor(this.f1171h);
            float f = (float) width;
            canvas.drawRect(0.0f, 0.0f, f, (float) this.f1166c.top, this.f1169f);
            canvas.drawRect(0.0f, (float) this.f1166c.top, (float) this.f1166c.left, (float) (this.f1166c.bottom + 1), this.f1169f);
            Canvas canvas2 = canvas;
            float f2 = f;
            canvas2.drawRect((float) (this.f1166c.right + 1), (float) this.f1166c.top, f2, (float) (this.f1166c.bottom + 1), this.f1169f);
            canvas2.drawRect(0.0f, (float) (this.f1166c.bottom + 1), f2, (float) height, this.f1169f);
        }
    }

    /* renamed from: b */
    private void m1015b(Canvas canvas) {
        if (this.f1185v > 0) {
            this.f1169f.setStyle(Style.STROKE);
            this.f1169f.setColor(this.f1186w);
            this.f1169f.setStrokeWidth((float) this.f1185v);
            canvas.drawRect(this.f1166c, this.f1169f);
        }
    }

    /* renamed from: c */
    private void m1017c(Canvas canvas) {
        if (this.f1158W > 0.0f) {
            this.f1169f.setStyle(Style.STROKE);
            this.f1169f.setColor(this.f1172i);
            this.f1169f.setStrokeWidth((float) this.f1174k);
            int i = this.f1189z;
            if (i == 1) {
                canvas.drawLine(((float) this.f1166c.left) - this.f1158W, (float) this.f1166c.top, (((float) this.f1166c.left) - this.f1158W) + ((float) this.f1173j), (float) this.f1166c.top, this.f1169f);
                canvas.drawLine((float) this.f1166c.left, ((float) this.f1166c.top) - this.f1158W, (float) this.f1166c.left, (((float) this.f1166c.top) - this.f1158W) + ((float) this.f1173j), this.f1169f);
                canvas.drawLine(((float) this.f1166c.right) + this.f1158W, (float) this.f1166c.top, (((float) this.f1166c.right) + this.f1158W) - ((float) this.f1173j), (float) this.f1166c.top, this.f1169f);
                canvas.drawLine((float) this.f1166c.right, ((float) this.f1166c.top) - this.f1158W, (float) this.f1166c.right, (((float) this.f1166c.top) - this.f1158W) + ((float) this.f1173j), this.f1169f);
                canvas.drawLine(((float) this.f1166c.left) - this.f1158W, (float) this.f1166c.bottom, (((float) this.f1166c.left) - this.f1158W) + ((float) this.f1173j), (float) this.f1166c.bottom, this.f1169f);
                canvas.drawLine((float) this.f1166c.left, ((float) this.f1166c.bottom) + this.f1158W, (float) this.f1166c.left, (((float) this.f1166c.bottom) + this.f1158W) - ((float) this.f1173j), this.f1169f);
                canvas.drawLine(((float) this.f1166c.right) + this.f1158W, (float) this.f1166c.bottom, (((float) this.f1166c.right) + this.f1158W) - ((float) this.f1173j), (float) this.f1166c.bottom, this.f1169f);
                canvas.drawLine((float) this.f1166c.right, ((float) this.f1166c.bottom) + this.f1158W, (float) this.f1166c.right, (((float) this.f1166c.bottom) + this.f1158W) - ((float) this.f1173j), this.f1169f);
            } else if (i == 2) {
                canvas.drawLine((float) this.f1166c.left, ((float) this.f1166c.top) + this.f1158W, (float) (this.f1166c.left + this.f1173j), ((float) this.f1166c.top) + this.f1158W, this.f1169f);
                canvas.drawLine(((float) this.f1166c.left) + this.f1158W, (float) this.f1166c.top, ((float) this.f1166c.left) + this.f1158W, (float) (this.f1166c.top + this.f1173j), this.f1169f);
                canvas.drawLine((float) this.f1166c.right, ((float) this.f1166c.top) + this.f1158W, (float) (this.f1166c.right - this.f1173j), ((float) this.f1166c.top) + this.f1158W, this.f1169f);
                canvas.drawLine(((float) this.f1166c.right) - this.f1158W, (float) this.f1166c.top, ((float) this.f1166c.right) - this.f1158W, (float) (this.f1166c.top + this.f1173j), this.f1169f);
                canvas.drawLine((float) this.f1166c.left, ((float) this.f1166c.bottom) - this.f1158W, (float) (this.f1166c.left + this.f1173j), ((float) this.f1166c.bottom) - this.f1158W, this.f1169f);
                canvas.drawLine(((float) this.f1166c.left) + this.f1158W, (float) this.f1166c.bottom, ((float) this.f1166c.left) + this.f1158W, (float) (this.f1166c.bottom - this.f1173j), this.f1169f);
                canvas.drawLine((float) this.f1166c.right, ((float) this.f1166c.bottom) - this.f1158W, (float) (this.f1166c.right - this.f1173j), ((float) this.f1166c.bottom) - this.f1158W, this.f1169f);
                canvas.drawLine(((float) this.f1166c.right) - this.f1158W, (float) this.f1166c.bottom, ((float) this.f1166c.right) - this.f1158W, (float) (this.f1166c.bottom - this.f1173j), this.f1169f);
            }
        }
    }

    /* renamed from: d */
    private void m1019d(Canvas canvas) {
        if (this.f1137B) {
            if (this.f1151P != null) {
                RectF rectF = new RectF(((float) this.f1166c.left) + this.f1158W + 0.5f, ((float) this.f1166c.top) + this.f1158W + ((float) this.f1181r), this.f1153R, (((float) this.f1166c.bottom) - this.f1158W) - ((float) this.f1181r));
                Rect rect = new Rect((int) (((float) this.f1151P.getWidth()) - rectF.width()), 0, this.f1151P.getWidth(), this.f1151P.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - ((float) rect.width());
                }
                canvas.drawBitmap(this.f1151P, rect, rectF, this.f1169f);
            } else if (this.f1184u != null) {
                canvas.drawBitmap(this.f1184u, null, new RectF(this.f1168e, ((float) this.f1166c.top) + this.f1158W + ((float) this.f1181r), this.f1168e + ((float) this.f1184u.getWidth()), (((float) this.f1166c.bottom) - this.f1158W) - ((float) this.f1181r)), this.f1169f);
            } else {
                this.f1169f.setStyle(Style.FILL);
                this.f1169f.setColor(this.f1180q);
                canvas.drawRect(this.f1168e, ((float) this.f1166c.top) + this.f1158W + ((float) this.f1181r), this.f1168e + ((float) this.f1179p), (((float) this.f1166c.bottom) - this.f1158W) - ((float) this.f1181r), this.f1169f);
            }
        } else if (this.f1151P != null) {
            RectF rectF2 = new RectF(((float) this.f1166c.left) + this.f1158W + ((float) this.f1181r), ((float) this.f1166c.top) + this.f1158W + 0.5f, (((float) this.f1166c.right) - this.f1158W) - ((float) this.f1181r), this.f1152Q);
            Rect rect2 = new Rect(0, (int) (((float) this.f1151P.getHeight()) - rectF2.height()), this.f1151P.getWidth(), this.f1151P.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - ((float) rect2.height());
            }
            canvas.drawBitmap(this.f1151P, rect2, rectF2, this.f1169f);
        } else if (this.f1184u != null) {
            canvas.drawBitmap(this.f1184u, null, new RectF(((float) this.f1166c.left) + this.f1158W + ((float) this.f1181r), this.f1167d, (((float) this.f1166c.right) - this.f1158W) - ((float) this.f1181r), this.f1167d + ((float) this.f1184u.getHeight())), this.f1169f);
        } else {
            this.f1169f.setStyle(Style.FILL);
            this.f1169f.setColor(this.f1180q);
            canvas.drawRect(((float) this.f1166c.left) + this.f1158W + ((float) this.f1181r), this.f1167d, (((float) this.f1166c.right) - this.f1158W) - ((float) this.f1181r), this.f1167d + ((float) this.f1179p), this.f1169f);
        }
    }

    /* renamed from: e */
    private void m1021e(Canvas canvas) {
        if (!TextUtils.isEmpty(this.f1140E) && this.f1160aa != null) {
            if (this.f1143H) {
                if (this.f1147L) {
                    this.f1169f.setColor(this.f1146K);
                    this.f1169f.setStyle(Style.FILL);
                    if (this.f1145J) {
                        Rect rect = new Rect();
                        TextPaint textPaint = this.f1170g;
                        String str = this.f1140E;
                        textPaint.getTextBounds(str, 0, str.length(), rect);
                        float width = (float) (((canvas.getWidth() - rect.width()) / 2) - this.f1161ab);
                        RectF rectF = new RectF(width, (float) ((this.f1166c.bottom + this.f1144I) - this.f1161ab), ((float) rect.width()) + width + ((float) (this.f1161ab * 2)), (float) (this.f1166c.bottom + this.f1144I + this.f1160aa.getHeight() + this.f1161ab));
                        int i = this.f1161ab;
                        canvas.drawRoundRect(rectF, (float) i, (float) i, this.f1169f);
                    } else {
                        RectF rectF2 = new RectF((float) this.f1166c.left, (float) ((this.f1166c.bottom + this.f1144I) - this.f1161ab), (float) this.f1166c.right, (float) (this.f1166c.bottom + this.f1144I + this.f1160aa.getHeight() + this.f1161ab));
                        int i2 = this.f1161ab;
                        canvas.drawRoundRect(rectF2, (float) i2, (float) i2, this.f1169f);
                    }
                }
                canvas.save();
                if (this.f1145J) {
                    canvas.translate(0.0f, (float) (this.f1166c.bottom + this.f1144I));
                } else {
                    canvas.translate((float) (this.f1166c.left + this.f1161ab), (float) (this.f1166c.bottom + this.f1144I));
                }
                this.f1160aa.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.f1147L) {
                this.f1169f.setColor(this.f1146K);
                this.f1169f.setStyle(Style.FILL);
                if (this.f1145J) {
                    Rect rect2 = new Rect();
                    TextPaint textPaint2 = this.f1170g;
                    String str2 = this.f1140E;
                    textPaint2.getTextBounds(str2, 0, str2.length(), rect2);
                    float width2 = (float) (((canvas.getWidth() - rect2.width()) / 2) - this.f1161ab);
                    RectF rectF3 = new RectF(width2, (float) (((this.f1166c.top - this.f1144I) - this.f1160aa.getHeight()) - this.f1161ab), ((float) rect2.width()) + width2 + ((float) (this.f1161ab * 2)), (float) ((this.f1166c.top - this.f1144I) + this.f1161ab));
                    int i3 = this.f1161ab;
                    canvas.drawRoundRect(rectF3, (float) i3, (float) i3, this.f1169f);
                } else {
                    RectF rectF4 = new RectF((float) this.f1166c.left, (float) (((this.f1166c.top - this.f1144I) - this.f1160aa.getHeight()) - this.f1161ab), (float) this.f1166c.right, (float) ((this.f1166c.top - this.f1144I) + this.f1161ab));
                    int i4 = this.f1161ab;
                    canvas.drawRoundRect(rectF4, (float) i4, (float) i4, this.f1169f);
                }
            }
            canvas.save();
            if (this.f1145J) {
                canvas.translate(0.0f, (float) ((this.f1166c.top - this.f1144I) - this.f1160aa.getHeight()));
            } else {
                canvas.translate((float) (this.f1166c.left + this.f1161ab), (float) ((this.f1166c.top - this.f1144I) - this.f1160aa.getHeight()));
            }
            this.f1160aa.draw(canvas);
            canvas.restore();
        }
    }

    /* renamed from: d */
    private void m1018d() {
        if (this.f1137B) {
            if (this.f1151P == null) {
                this.f1168e += (float) this.f1159a;
                int i = this.f1179p;
                Bitmap bitmap = this.f1184u;
                if (bitmap != null) {
                    i = bitmap.getWidth();
                }
                if (this.f1148M) {
                    if (this.f1168e + ((float) i) > ((float) this.f1166c.right) - this.f1158W || this.f1168e < ((float) this.f1166c.left) + this.f1158W) {
                        this.f1159a = -this.f1159a;
                    }
                } else if (this.f1168e + ((float) i) > ((float) this.f1166c.right) - this.f1158W) {
                    this.f1168e = ((float) this.f1166c.left) + this.f1158W + 0.5f;
                }
            } else {
                this.f1153R += (float) this.f1159a;
                if (this.f1153R > ((float) this.f1166c.right) - this.f1158W) {
                    this.f1153R = ((float) this.f1166c.left) + this.f1158W + 0.5f;
                }
            }
        } else if (this.f1151P == null) {
            this.f1167d += (float) this.f1159a;
            int i2 = this.f1179p;
            Bitmap bitmap2 = this.f1184u;
            if (bitmap2 != null) {
                i2 = bitmap2.getHeight();
            }
            if (this.f1148M) {
                if (this.f1167d + ((float) i2) > ((float) this.f1166c.bottom) - this.f1158W || this.f1167d < ((float) this.f1166c.top) + this.f1158W) {
                    this.f1159a = -this.f1159a;
                }
            } else if (this.f1167d + ((float) i2) > ((float) this.f1166c.bottom) - this.f1158W) {
                this.f1167d = ((float) this.f1166c.top) + this.f1158W + 0.5f;
            }
        } else {
            this.f1152Q += (float) this.f1159a;
            if (this.f1152Q > ((float) this.f1166c.bottom) - this.f1158W) {
                this.f1152Q = ((float) this.f1166c.top) + this.f1158W + 0.5f;
            }
        }
        postInvalidateDelayed((long) this.f1165b, this.f1166c.left, this.f1166c.top, this.f1166c.right, this.f1166c.bottom);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        m1020e();
    }

    /* renamed from: e */
    private void m1020e() {
        int width = getWidth();
        int i = this.f1175l;
        int i2 = (width - i) / 2;
        int i3 = this.f1178o;
        this.f1166c = new Rect(i2, i3, i + i2, this.f1176m + i3);
        if (this.f1137B) {
            float f = ((float) this.f1166c.left) + this.f1158W + 0.5f;
            this.f1168e = f;
            this.f1153R = f;
        } else {
            float f2 = ((float) this.f1166c.top) + this.f1158W + 0.5f;
            this.f1167d = f2;
            this.f1152Q = f2;
        }
        if (this.f1164ae != null && mo9647a()) {
            this.f1164ae.mo9629a(new Rect(this.f1166c));
        }
    }

    /* renamed from: a */
    public Rect mo9645a(int i) {
        if (!this.f1162ac || getVisibility() != 0) {
            return null;
        }
        Rect rect = new Rect(this.f1166c);
        float measuredHeight = (((float) i) * 1.0f) / ((float) getMeasuredHeight());
        float exactCenterX = rect.exactCenterX();
        float exactCenterY = rect.exactCenterY();
        float width = (((float) rect.width()) / 2.0f) * measuredHeight;
        float height = (((float) rect.height()) / 2.0f) * measuredHeight;
        rect.left = (int) (exactCenterX - width);
        rect.right = (int) (exactCenterX + width);
        rect.top = (int) (exactCenterY - height);
        rect.bottom = (int) (exactCenterY + height);
        return rect;
    }

    public void setIsBarcode(boolean z) {
        this.f1137B = z;
        if (this.f1150O != null || this.f1149N) {
            if (this.f1137B) {
                this.f1151P = this.f1157V;
            } else {
                this.f1151P = this.f1156U;
            }
        } else if (this.f1183t != null || this.f1182s) {
            if (this.f1137B) {
                this.f1184u = this.f1155T;
            } else {
                this.f1184u = this.f1154S;
            }
        }
        if (this.f1137B) {
            this.f1140E = this.f1139D;
            this.f1176m = this.f1177n;
            this.f1165b = (int) (((((float) this.f1187x) * 1.0f) * ((float) this.f1159a)) / ((float) this.f1175l));
        } else {
            this.f1140E = this.f1138C;
            this.f1176m = this.f1175l;
            this.f1165b = (int) (((((float) this.f1187x) * 1.0f) * ((float) this.f1159a)) / ((float) this.f1176m));
        }
        if (!TextUtils.isEmpty(this.f1140E)) {
            if (this.f1145J) {
                StaticLayout staticLayout = new StaticLayout(this.f1140E, this.f1170g, BGAQRCodeUtil.m1033b(getContext()).x, Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
                this.f1160aa = staticLayout;
            } else {
                StaticLayout staticLayout2 = new StaticLayout(this.f1140E, this.f1170g, this.f1175l - (this.f1161ab * 2), Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
                this.f1160aa = staticLayout2;
            }
        }
        if (this.f1188y != -1.0f) {
            int i = BGAQRCodeUtil.m1033b(getContext()).y;
            int i2 = this.f1136A;
            if (i2 == 0) {
                this.f1178o = (int) ((((float) i) * this.f1188y) - ((float) (this.f1176m / 2)));
            } else {
                this.f1178o = (int) ((((float) (i + i2)) * this.f1188y) - ((float) (this.f1176m / 2)));
            }
        }
        m1020e();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.f1137B;
    }

    public int getMaskColor() {
        return this.f1171h;
    }

    public void setMaskColor(int i) {
        this.f1171h = i;
    }

    public int getCornerColor() {
        return this.f1172i;
    }

    public void setCornerColor(int i) {
        this.f1172i = i;
    }

    public int getCornerLength() {
        return this.f1173j;
    }

    public void setCornerLength(int i) {
        this.f1173j = i;
    }

    public int getCornerSize() {
        return this.f1174k;
    }

    public void setCornerSize(int i) {
        this.f1174k = i;
    }

    public int getRectWidth() {
        return this.f1175l;
    }

    public void setRectWidth(int i) {
        this.f1175l = i;
    }

    public int getRectHeight() {
        return this.f1176m;
    }

    public void setRectHeight(int i) {
        this.f1176m = i;
    }

    public int getBarcodeRectHeight() {
        return this.f1177n;
    }

    public void setBarcodeRectHeight(int i) {
        this.f1177n = i;
    }

    public int getTopOffset() {
        return this.f1178o;
    }

    public void setTopOffset(int i) {
        this.f1178o = i;
    }

    public int getScanLineSize() {
        return this.f1179p;
    }

    public void setScanLineSize(int i) {
        this.f1179p = i;
    }

    public int getScanLineColor() {
        return this.f1180q;
    }

    public void setScanLineColor(int i) {
        this.f1180q = i;
    }

    public int getScanLineMargin() {
        return this.f1181r;
    }

    public void setScanLineMargin(int i) {
        this.f1181r = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.f1182s = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.f1183t;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.f1183t = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.f1184u;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.f1184u = bitmap;
    }

    public int getBorderSize() {
        return this.f1185v;
    }

    public void setBorderSize(int i) {
        this.f1185v = i;
    }

    public int getBorderColor() {
        return this.f1186w;
    }

    public void setBorderColor(int i) {
        this.f1186w = i;
    }

    public int getAnimTime() {
        return this.f1187x;
    }

    public void setAnimTime(int i) {
        this.f1187x = i;
    }

    public float getVerticalBias() {
        return this.f1188y;
    }

    public void setVerticalBias(float f) {
        this.f1188y = f;
    }

    public int getToolbarHeight() {
        return this.f1136A;
    }

    public void setToolbarHeight(int i) {
        this.f1136A = i;
    }

    public String getQRCodeTipText() {
        return this.f1138C;
    }

    public void setQRCodeTipText(String str) {
        this.f1138C = str;
    }

    public String getBarCodeTipText() {
        return this.f1139D;
    }

    public void setBarCodeTipText(String str) {
        this.f1139D = str;
    }

    public String getTipText() {
        return this.f1140E;
    }

    public void setTipText(String str) {
        this.f1140E = str;
    }

    public int getTipTextColor() {
        return this.f1142G;
    }

    public void setTipTextColor(int i) {
        this.f1142G = i;
    }

    public int getTipTextSize() {
        return this.f1141F;
    }

    public void setTipTextSize(int i) {
        this.f1141F = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.f1143H = z;
    }

    public int getTipTextMargin() {
        return this.f1144I;
    }

    public void setTipTextMargin(int i) {
        this.f1144I = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.f1145J = z;
    }

    public void setShowTipBackground(boolean z) {
        this.f1147L = z;
    }

    public int getTipBackgroundColor() {
        return this.f1146K;
    }

    public void setTipBackgroundColor(int i) {
        this.f1146K = i;
    }

    public void setScanLineReverse(boolean z) {
        this.f1148M = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.f1149N = z;
    }

    public float getHalfCornerSize() {
        return this.f1158W;
    }

    public void setHalfCornerSize(float f) {
        this.f1158W = f;
    }

    public StaticLayout getTipTextSl() {
        return this.f1160aa;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.f1160aa = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.f1161ab;
    }

    public void setTipBackgroundRadius(int i) {
        this.f1161ab = i;
    }

    /* renamed from: a */
    public boolean mo9647a() {
        return this.f1162ac;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.f1162ac = z;
    }

    /* renamed from: b */
    public boolean mo9648b() {
        return this.f1163ad;
    }

    public void setShowLocationPoint(boolean z) {
        this.f1163ad = z;
    }
}
