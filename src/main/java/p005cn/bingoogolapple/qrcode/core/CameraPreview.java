package p005cn.bingoogolapple.qrcode.core;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View.MeasureSpec;

/* renamed from: cn.bingoogolapple.qrcode.core.CameraPreview */
public class CameraPreview extends SurfaceView implements Callback {
    /* renamed from: a */
    AutoFocusCallback f1108a = new AutoFocusCallback() {
        public void onAutoFocus(boolean z, Camera camera) {
            if (z) {
                CameraPreview cameraPreview = CameraPreview.this;
                cameraPreview.postDelayed(cameraPreview.f1115h, CameraPreview.this.getAutoFocusSuccessDelay());
                return;
            }
            CameraPreview cameraPreview2 = CameraPreview.this;
            cameraPreview2.postDelayed(cameraPreview2.f1115h, CameraPreview.this.getAutoFocusFailureDelay());
        }
    };
    /* renamed from: b */
    private long f1109b = 1000;
    /* renamed from: c */
    private long f1110c = 500;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public Camera f1111d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public boolean f1112e = true;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public boolean f1113f = false;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public CameraConfigurationManager f1114g;
    /* access modifiers changed from: private */
    /* renamed from: h */
    public Runnable f1115h = new Runnable() {
        public void run() {
            if (CameraPreview.this.f1111d != null && CameraPreview.this.f1112e && CameraPreview.this.f1113f) {
                try {
                    CameraPreview.this.f1111d.autoFocus(CameraPreview.this.f1108a);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    };

    public CameraPreview(Context context) {
        super(context);
    }

    /* access modifiers changed from: 0000 */
    public void setCamera(Camera camera) {
        this.f1111d = camera;
        if (this.f1111d != null) {
            this.f1114g = new CameraConfigurationManager(getContext());
            this.f1114g.mo9718a(this.f1111d);
            getHolder().addCallback(this);
            if (this.f1112e) {
                requestLayout();
            } else {
                m995b();
            }
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f1113f = true;
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (surfaceHolder.getSurface() != null) {
            mo9613a();
            m995b();
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f1113f = false;
        mo9613a();
    }

    /* renamed from: b */
    private void m995b() {
        post(new Runnable() {
            public void run() {
                if (CameraPreview.this.f1111d != null) {
                    try {
                        CameraPreview.this.f1112e = true;
                        CameraPreview.this.f1111d.setPreviewDisplay(CameraPreview.this.getHolder());
                        CameraPreview.this.f1114g.mo9719b(CameraPreview.this.f1111d);
                        CameraPreview.this.f1111d.startPreview();
                        CameraPreview.this.f1111d.autoFocus(CameraPreview.this.f1108a);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo9613a() {
        if (this.f1111d != null) {
            try {
                removeCallbacks(this.f1115h);
                this.f1112e = false;
                this.f1111d.cancelAutoFocus();
                this.f1111d.setOneShotPreviewCallback(null);
                this.f1111d.stopPreview();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(getSuggestedMinimumWidth(), i);
        int defaultSize2 = getDefaultSize(getSuggestedMinimumHeight(), i2);
        CameraConfigurationManager bVar = this.f1114g;
        if (!(bVar == null || bVar.mo9717a() == null)) {
            Point a = this.f1114g.mo9717a();
            float f = (float) defaultSize;
            float f2 = (float) defaultSize2;
            float f3 = (float) a.x;
            float f4 = (float) a.y;
            float f5 = (f3 * 1.0f) / f4;
            if ((f * 1.0f) / f2 < f5) {
                defaultSize = (int) ((f2 / ((f4 * 1.0f) / f3)) + 0.5f);
            } else {
                defaultSize2 = (int) ((f / f5) + 0.5f);
            }
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(defaultSize, 1073741824), MeasureSpec.makeMeasureSpec(defaultSize2, 1073741824));
    }

    public long getAutoFocusSuccessDelay() {
        return this.f1109b;
    }

    public void setAutoFocusSuccessDelay(long j) {
        this.f1109b = j;
    }

    public long getAutoFocusFailureDelay() {
        return this.f1110c;
    }

    public void setAutoFocusFailureDelay(long j) {
        this.f1110c = j;
    }
}
