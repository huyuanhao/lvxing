package p005cn.bingoogolapple.qrcode.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.AsyncTask.Status;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

/* renamed from: cn.bingoogolapple.qrcode.core.QRCodeView */
public abstract class QRCodeView extends RelativeLayout implements PreviewCallback {
    /* renamed from: l */
    private static long f1119l;
    /* renamed from: a */
    protected Camera f1120a;
    /* renamed from: b */
    protected CameraPreview f1121b;
    /* renamed from: c */
    protected ScanBoxView f1122c;
    /* renamed from: d */
    protected C0897a f1123d;
    /* renamed from: e */
    protected Handler f1124e;
    /* renamed from: f */
    protected boolean f1125f;
    /* renamed from: g */
    protected ProcessDataTask f1126g;
    /* renamed from: h */
    protected int f1127h;
    /* renamed from: i */
    protected BarcodeType f1128i;
    /* access modifiers changed from: private */
    /* renamed from: j */
    public PointF[] f1129j;
    /* renamed from: k */
    private Paint f1130k;
    /* renamed from: m */
    private Runnable f1131m;

    /* renamed from: cn.bingoogolapple.qrcode.core.QRCodeView$a */
    public interface C0897a {
        /* renamed from: a */
        void mo9644a(String str);
    }

    /* renamed from: a */
    public abstract ScanResult mo9626a(Bitmap bitmap);

    /* renamed from: a */
    public abstract ScanResult mo9627a(byte[] bArr, int i, int i2, boolean z);

    /* renamed from: a */
    public abstract void mo9628a();

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo9629a(Rect rect) {
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1125f = false;
        this.f1127h = 0;
        this.f1128i = BarcodeType.HIGH_FREQUENCY;
        this.f1131m = new Runnable() {
            public void run() {
                if (QRCodeView.this.f1120a != null && QRCodeView.this.f1125f) {
                    try {
                        QRCodeView.this.f1120a.setOneShotPreviewCallback(QRCodeView.this);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        this.f1124e = new Handler();
        m1002a(context, attributeSet);
        mo9628a();
    }

    /* renamed from: a */
    private void m1002a(Context context, AttributeSet attributeSet) {
        this.f1121b = new CameraPreview(context);
        this.f1122c = new ScanBoxView(context);
        this.f1122c.mo9646a(this, attributeSet);
        this.f1121b.setId(R.id.bgaqrcode_camera_preview);
        addView(this.f1121b);
        LayoutParams layoutParams = new LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.f1121b.getId());
        layoutParams.addRule(8, this.f1121b.getId());
        addView(this.f1122c, layoutParams);
        this.f1130k = new Paint();
        this.f1130k.setColor(getScanBoxView().getCornerColor());
        this.f1130k.setStyle(Style.FILL);
    }

    public void setDelegate(C0897a aVar) {
        this.f1123d = aVar;
    }

    public CameraPreview getCameraPreview() {
        return this.f1121b;
    }

    public void setAutoFocusSuccessDelay(long j) {
        this.f1121b.setAutoFocusSuccessDelay(j);
    }

    public void setAutoFocusFailureDelay(long j) {
        this.f1121b.setAutoFocusSuccessDelay(j);
    }

    public ScanBoxView getScanBoxView() {
        return this.f1122c;
    }

    public boolean getIsScanBarcodeStyle() {
        return this.f1122c.getIsBarcode();
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (BGAQRCodeUtil.m1029a()) {
            StringBuilder sb = new StringBuilder();
            sb.append("两次 onPreviewFrame 时间间隔：");
            sb.append(System.currentTimeMillis() - f1119l);
            BGAQRCodeUtil.m1028a(sb.toString());
            f1119l = System.currentTimeMillis();
        }
        if (this.f1125f) {
            ProcessDataTask cVar = this.f1126g;
            if (cVar == null || !(cVar.getStatus() == Status.PENDING || this.f1126g.getStatus() == Status.RUNNING)) {
                this.f1126g = new ProcessDataTask(camera, bArr, this, BGAQRCodeUtil.m1030a(getContext())).mo9720a();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo9630a(ScanResult dVar) {
        String str;
        if (this.f1125f) {
            if (dVar == null) {
                str = null;
            } else {
                str = dVar.f1202a;
            }
            if (TextUtils.isEmpty(str)) {
                try {
                    if (this.f1120a != null) {
                        this.f1120a.setOneShotPreviewCallback(this);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    if (this.f1123d != null) {
                        this.f1123d.mo9644a(str);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo9632b(ScanResult dVar) {
        String str;
        if (this.f1123d != null) {
            if (dVar == null) {
                str = null;
            } else {
                str = dVar.f1202a;
            }
            this.f1123d.mo9644a(str);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (mo9633b()) {
            PointF[] pointFArr = this.f1129j;
            if (pointFArr != null) {
                for (PointF pointF : pointFArr) {
                    canvas.drawCircle(pointF.x, pointF.y, 10.0f, this.f1130k);
                }
                this.f1129j = null;
                postInvalidateDelayed(2000);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo9633b() {
        ScanBoxView scanBoxView = this.f1122c;
        return scanBoxView != null && scanBoxView.mo9648b();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9631a(final PointF[] pointFArr, final Rect rect) {
        if (pointFArr != null && pointFArr.length != 0) {
            new Thread() {
                public void run() {
                    PointF[] pointFArr;
                    try {
                        Size previewSize = QRCodeView.this.f1120a.getParameters().getPreviewSize();
                        boolean z = true;
                        if (QRCodeView.this.f1127h != 1) {
                            z = false;
                        }
                        int c = BGAQRCodeUtil.m1035c(QRCodeView.this.getContext());
                        PointF[] pointFArr2 = new PointF[pointFArr.length];
                        int i = 0;
                        for (PointF pointF : pointFArr) {
                            pointFArr2[i] = QRCodeView.this.m1000a(pointF.x, pointF.y, (float) previewSize.width, (float) previewSize.height, z, c, rect);
                            i++;
                        }
                        QRCodeView.this.f1129j = pointFArr2;
                        QRCodeView.this.postInvalidate();
                    } catch (Exception e) {
                        QRCodeView.this.f1129j = null;
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public PointF m1000a(float f, float f2, float f3, float f4, boolean z, int i, Rect rect) {
        PointF pointF;
        int width = getWidth();
        int height = getHeight();
        if (BGAQRCodeUtil.m1030a(getContext())) {
            float f5 = (float) width;
            float f6 = (float) height;
            pointF = new PointF((f4 - f) * (f5 / f4), (f3 - f2) * (f6 / f3));
            pointF.y = f6 - pointF.y;
            pointF.x = f5 - pointF.x;
            if (rect == null) {
                pointF.y += (float) i;
            }
        } else {
            float f7 = (float) width;
            pointF = new PointF(f * (f7 / f3), f2 * (((float) height) / f4));
            if (z) {
                pointF.x = f7 - pointF.x;
            }
        }
        if (rect != null) {
            pointF.y += (float) rect.top;
            pointF.x += (float) rect.left;
        }
        return pointF;
    }
}
