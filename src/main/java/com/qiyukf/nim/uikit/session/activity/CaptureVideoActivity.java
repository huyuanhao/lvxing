package com.qiyukf.nim.uikit.session.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.kwad.sdk.core.response.model.AdConfigData;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p412c.p413a.C5362a;
import com.qiyukf.basesdk.p412c.p417d.C5414f;
import com.qiyukf.basesdk.p412c.p417d.C5415g;
import com.qiyukf.nim.uikit.common.activity.BaseFragmentActivity;
import com.qiyukf.unicorn.C5961R;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.tencent.p605ep.commonbase.utils.ScreenUtil;
import java.io.File;
import java.util.Date;
import java.util.LinkedList;

public class CaptureVideoActivity extends BaseFragmentActivity implements Callback, OnClickListener {
    /* renamed from: A */
    private LinkedList<Point> f17689A = new LinkedList<>();
    /* renamed from: B */
    private Runnable f17690B = new Runnable() {
        public final void run() {
            String str;
            int i;
            ImageView imageView;
            CaptureVideoActivity.this.f17712v = new Date().getTime();
            CaptureVideoActivity captureVideoActivity = CaptureVideoActivity.this;
            captureVideoActivity.f17713w = captureVideoActivity.f17712v - CaptureVideoActivity.this.f17711u;
            int c = (int) (CaptureVideoActivity.this.f17713w / 1000);
            TextView d = CaptureVideoActivity.this.f17694d;
            StringBuilder sb = new StringBuilder();
            sb.append(c);
            sb.append("秒");
            d.setText(sb.toString());
            CaptureVideoActivity.this.f17693c.setProgress(c);
            TextView f = CaptureVideoActivity.this.f17704n;
            if (c <= 0) {
                str = "00:00";
            } else {
                int i2 = c / 60;
                String str2 = ":";
                if (i2 < 60) {
                    int i3 = c % 60;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(C5414f.m22158a(i2));
                    sb2.append(str2);
                    sb2.append(C5414f.m22158a(i3));
                    str = sb2.toString();
                } else {
                    int i4 = i2 / 60;
                    if (i4 > 99) {
                        str = "99:59:59";
                    } else {
                        int i5 = i2 % 60;
                        int i6 = (c - (i4 * AdConfigData.DEFAULT_REQUEST_INTERVAL)) - (i5 * 60);
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(C5414f.m22158a(i4));
                        sb3.append(str2);
                        sb3.append(C5414f.m22158a(i5));
                        sb3.append(str2);
                        sb3.append(C5414f.m22158a(i6));
                        str = sb3.toString();
                    }
                }
            }
            f.setText(str);
            if (c % 2 == 0) {
                imageView = CaptureVideoActivity.this.f17703m;
                i = C5961R.C5962drawable.ysf_record_start;
            } else {
                imageView = CaptureVideoActivity.this.f17703m;
                i = C5961R.C5962drawable.ysf_record_video;
            }
            imageView.setBackgroundResource(i);
            if (c >= 30) {
                CaptureVideoActivity.this.f17693c.setProgress(100);
                CaptureVideoActivity.this.f17694d.setText("30秒");
                CaptureVideoActivity.this.m22391h();
                return;
            }
            CaptureVideoActivity.this.f17692b.postDelayed(this, 1000);
        }
    };
    /* renamed from: C */
    private Point f17691C = null;
    /* renamed from: b */
    public Handler f17692b = new Handler();
    /* access modifiers changed from: private */
    /* renamed from: c */
    public ProgressBar f17693c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public TextView f17694d;
    /* renamed from: e */
    private ImageView f17695e;
    /* renamed from: f */
    private ImageView f17696f;
    /* renamed from: g */
    private ImageView f17697g;
    /* renamed from: h */
    private MediaRecorder f17698h;
    /* renamed from: i */
    private Camera f17699i;
    /* renamed from: j */
    private SurfaceView f17700j;
    /* renamed from: k */
    private SurfaceHolder f17701k;
    /* renamed from: l */
    private ImageView f17702l;
    /* access modifiers changed from: private */
    /* renamed from: m */
    public ImageView f17703m;
    /* access modifiers changed from: private */
    /* renamed from: n */
    public TextView f17704n;
    /* renamed from: o */
    private ImageView f17705o;
    /* renamed from: p */
    private int f17706p = 0;
    /* renamed from: q */
    private String f17707q;
    /* renamed from: r */
    private boolean f17708r = false;
    /* renamed from: s */
    private boolean f17709s = false;
    /* renamed from: t */
    private boolean f17710t = false;
    /* access modifiers changed from: private */
    /* renamed from: u */
    public long f17711u;
    /* access modifiers changed from: private */
    /* renamed from: v */
    public long f17712v;
    /* access modifiers changed from: private */
    /* renamed from: w */
    public long f17713w = 0;
    /* renamed from: x */
    private boolean f17714x = false;
    /* renamed from: y */
    private int f17715y = 0;
    /* renamed from: z */
    private LinkedList<Point> f17716z = new LinkedList<>();

    /* renamed from: a */
    private void m22382a(boolean z) {
        int i = (VERSION.SDK_INT < 9 || !z) ? 0 : 1;
        String str = "Back Camera";
        String str2 = "Front Camera";
        String str3 = "video";
        if (VERSION.SDK_INT >= 11) {
            if (CamcorderProfile.hasProfile(i, 4)) {
                CamcorderProfile camcorderProfile = CamcorderProfile.get(i, 4);
                if (camcorderProfile != null) {
                    Point point = new Point();
                    point.x = camcorderProfile.videoFrameWidth;
                    point.y = camcorderProfile.videoFrameHeight;
                    (z ? this.f17689A : this.f17716z).addLast(point);
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(z ? str : str2);
                sb.append(" no QUALITY_480P");
                C5264a.m21622c(str3, sb.toString());
            }
            if (CamcorderProfile.hasProfile(i, 3)) {
                CamcorderProfile camcorderProfile2 = CamcorderProfile.get(i, 3);
                if (camcorderProfile2 != null) {
                    Point point2 = new Point();
                    point2.x = camcorderProfile2.videoFrameWidth;
                    point2.y = camcorderProfile2.videoFrameHeight;
                    (z ? this.f17689A : this.f17716z).addLast(point2);
                }
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(z ? str : str2);
                sb2.append(" no QUALITY_CIF");
                C5264a.m21622c(str3, sb2.toString());
            }
            if (VERSION.SDK_INT >= 15) {
                if (CamcorderProfile.hasProfile(i, 7)) {
                    CamcorderProfile camcorderProfile3 = CamcorderProfile.get(i, 7);
                    if (camcorderProfile3 != null) {
                        Point point3 = new Point();
                        point3.x = camcorderProfile3.videoFrameWidth;
                        point3.y = camcorderProfile3.videoFrameHeight;
                        (z ? this.f17689A : this.f17716z).addLast(point3);
                    }
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(z ? str : str2);
                    sb3.append(" no QUALITY_QVGA");
                    C5264a.m21622c(str3, sb3.toString());
                }
            }
        }
        if (VERSION.SDK_INT >= 9) {
            CamcorderProfile camcorderProfile4 = CamcorderProfile.get(i, 0);
            if (camcorderProfile4 == null) {
                Point point4 = new Point();
                point4.x = 320;
                point4.y = ScreenUtil.G8_WIDTH;
                (z ? this.f17689A : this.f17716z).addLast(point4);
                StringBuilder sb4 = new StringBuilder();
                if (!z) {
                    str = str2;
                }
                sb4.append(str);
                sb4.append(" no QUALITY_LOW");
                C5264a.m21622c(str3, sb4.toString());
                return;
            }
            Point point5 = new Point();
            point5.x = camcorderProfile4.videoFrameWidth;
            point5.y = camcorderProfile4.videoFrameHeight;
            if (z) {
                this.f17689A.addLast(point5);
            } else {
                this.f17716z.addLast(point5);
            }
        } else {
            if (!z) {
                CamcorderProfile camcorderProfile5 = CamcorderProfile.get(0);
                if (camcorderProfile5 == null) {
                    Point point6 = new Point();
                    point6.x = 320;
                    point6.y = ScreenUtil.G8_WIDTH;
                    this.f17716z.addLast(point6);
                    return;
                }
                Point point7 = new Point();
                point7.x = camcorderProfile5.videoFrameWidth;
                point7.y = camcorderProfile5.videoFrameHeight;
                this.f17716z.addLast(point7);
            }
        }
    }

    /* renamed from: g */
    private void m22390g() {
        Point point = (Point) (this.f17706p == 0 ? this.f17716z : this.f17689A).getFirst();
        Point point2 = this.f17691C;
        if (point2 == null || !point.equals(point2)) {
            this.f17691C = point;
            int width = getWindowManager().getDefaultDisplay().getWidth();
            int i = (point.x * width) / point.y;
            SurfaceView surfaceView = this.f17700j;
            if (surfaceView != null) {
                LayoutParams layoutParams = (LayoutParams) surfaceView.getLayoutParams();
                layoutParams.width = width;
                layoutParams.height = i;
                layoutParams.addRule(13);
                this.f17700j.setLayoutParams(layoutParams);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m22391h() {
        MediaRecorder mediaRecorder = this.f17698h;
        if (mediaRecorder != null) {
            try {
                mediaRecorder.stop();
            } catch (Exception unused) {
                C5264a.m21626e("video", getString(C5961R.string.ysf_stop_fail_maybe_stopped));
            }
            this.f17698h.release();
            this.f17698h = null;
        }
        Camera camera = this.f17699i;
        if (camera != null) {
            camera.release();
            this.f17699i = null;
        }
        this.f17692b.removeCallbacks(this.f17690B);
        this.f17703m.setBackgroundResource(C5961R.C5962drawable.ysf_record_start);
        this.f17710t = false;
        if (this.f17713w <= 1) {
            m22394j();
        } else {
            updateRecordUI(false);
        }
    }

    /* renamed from: i */
    private void m22393i() {
        String str;
        File file = new File(this.f17707q);
        if (file.exists()) {
            int length = ((int) file.length()) / 1024;
            float f = ((float) length) / 1024.0f;
            StringBuilder sb = new StringBuilder();
            sb.append("");
            if (f > 1.0f) {
                str = getString(C5961R.string.ysf_capture_video_size_in_mb, new Object[]{Float.valueOf(f)});
            } else {
                str = getString(C5961R.string.ysf_capture_video_size_in_kb, new Object[]{Integer.valueOf(length)});
            }
            sb.append(str);
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            sb3.append(getString(C5961R.string.ysf_is_send_video));
            if (f <= 1.0f && length < 10) {
                m22394j();
                return;
            }
        }
        Intent intent = new Intent();
        intent.putExtra("duration", this.f17713w);
        intent.putExtra("EXTRA_DATA_FILE_NAME", this.f17707q);
        setResult(-1, intent);
        finish();
    }

    /* renamed from: j */
    private void m22394j() {
        this.f17713w = 0;
        C5415g.m22165b(C5961R.string.ysf_video_record_short);
        m22395k();
    }

    /* renamed from: k */
    private void m22395k() {
        C5362a.m22021b(this.f17707q);
        this.f17704n.setText("00:00");
        this.f17694d.setText("30秒");
        this.f17693c.setProgress(0);
        updateRecordUI(true);
        m22397m();
        m22396l();
        m22398n();
        checkMultiCamera();
    }

    /* renamed from: l */
    private boolean m22396l() {
        String str = "video";
        try {
            this.f17699i = this.f17709s ? Camera.open(this.f17706p) : Camera.open();
            Camera camera = this.f17699i;
            if (camera != null) {
                Parameters parameters = camera.getParameters();
                if (VERSION.SDK_INT >= 15 && parameters.isVideoStabilizationSupported()) {
                    parameters.setVideoStabilization(true);
                }
                String str2 = "continuous-video";
                if (parameters.getSupportedFocusModes().contains(str2)) {
                    parameters.setFocusMode(str2);
                }
                if (parameters != null) {
                    this.f17715y = setCameraDisplayOrientation(this, this.f17706p, this.f17699i);
                    StringBuilder sb = new StringBuilder("camera angle = ");
                    sb.append(this.f17715y);
                    Log.i(str, sb.toString());
                }
                parameters.setPreviewSize(this.f17691C.x, this.f17691C.y);
                try {
                    this.f17699i.setParameters(parameters);
                } catch (RuntimeException e) {
                    C5264a.m21621b(str, "setParameters failed", e);
                }
            }
            return this.f17699i != null;
        } catch (RuntimeException e2) {
            StringBuilder sb2 = new StringBuilder("init camera failed: ");
            sb2.append(e2);
            C5264a.m21622c(str, sb2.toString());
            Toast.makeText(this, C5961R.string.ysf_connect_vedio_device_fail, 0).show();
            return false;
        }
    }

    /* renamed from: m */
    private void m22397m() {
        Camera camera = this.f17699i;
        if (camera != null) {
            if (this.f17708r) {
                camera.stopPreview();
            }
            this.f17699i.release();
            this.f17699i = null;
            this.f17708r = false;
        }
    }

    /* renamed from: n */
    private void m22398n() {
        try {
            this.f17699i.setPreviewDisplay(this.f17701k);
            this.f17699i.startPreview();
            this.f17708r = true;
        } catch (Exception e) {
            Toast.makeText(this, C5961R.string.ysf_connect_vedio_device_fail, 0).show();
            m22397m();
            e.printStackTrace();
        }
    }

    public static void start(Fragment fragment, String str, int i) {
        Intent intent = new Intent();
        intent.setClass(fragment.getActivity(), CaptureVideoActivity.class);
        intent.putExtra("EXTRA_DATA_FILE_NAME", str);
        fragment.startActivityForResult(intent, i);
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final boolean mo27411a() {
        return false;
    }

    public void checkMultiCamera() {
        ImageView imageView;
        int i = 8;
        if (VERSION.SDK_INT < 9 || Camera.getNumberOfCameras() <= 1) {
            imageView = this.f17705o;
        } else {
            this.f17709s = true;
            imageView = this.f17705o;
            i = 0;
        }
        imageView.setVisibility(i);
    }

    public void onBackPressed() {
        if (this.f17710t) {
            m22391h();
        }
        m22397m();
        setResult(0);
        finish();
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a2 A[Catch:{ Exception -> 0x012a }] */
    public void onClick(android.view.View r7) {
        /*
        r6 = this;
        int r0 = r7.getId()
        int r1 = com.qiyukf.unicorn.C5961R.C5963id.ysf_iv_capture_cancel
        if (r0 != r1) goto L_0x000c
        r6.m22395k()
        return
    L_0x000c:
        int r0 = r7.getId()
        int r1 = com.qiyukf.unicorn.C5961R.C5963id.ysf_iv_capture_send
        if (r0 != r1) goto L_0x0018
        r6.m22393i()
        return
    L_0x0018:
        int r0 = r7.getId()
        int r1 = com.qiyukf.unicorn.C5961R.C5963id.record_btn
        r2 = 9
        r3 = 1
        if (r0 != r1) goto L_0x0157
        boolean r7 = r6.f17710t
        if (r7 == 0) goto L_0x002b
        r6.m22391h()
        return
    L_0x002b:
        r7 = 0
        r6.m22397m()     // Catch:{ Exception -> 0x012a }
        boolean r0 = r6.m22396l()     // Catch:{ Exception -> 0x012a }
        if (r0 == 0) goto L_0x0109
        android.widget.ImageView r0 = r6.f17705o     // Catch:{ Exception -> 0x012a }
        r1 = 8
        r0.setVisibility(r1)     // Catch:{ Exception -> 0x012a }
        android.media.MediaRecorder r0 = new android.media.MediaRecorder     // Catch:{ Exception -> 0x012a }
        r0.<init>()     // Catch:{ Exception -> 0x012a }
        r6.f17698h = r0     // Catch:{ Exception -> 0x012a }
        android.hardware.Camera r0 = r6.f17699i     // Catch:{ Exception -> 0x012a }
        r0.unlock()     // Catch:{ Exception -> 0x012a }
        android.media.MediaRecorder r0 = r6.f17698h     // Catch:{ Exception -> 0x012a }
        android.hardware.Camera r1 = r6.f17699i     // Catch:{ Exception -> 0x012a }
        r0.setCamera(r1)     // Catch:{ Exception -> 0x012a }
        android.media.MediaRecorder r0 = r6.f17698h     // Catch:{ Exception -> 0x012a }
        r1 = 5
        r0.setAudioSource(r1)     // Catch:{ Exception -> 0x012a }
        android.media.MediaRecorder r0 = r6.f17698h     // Catch:{ Exception -> 0x012a }
        r0.setVideoSource(r3)     // Catch:{ Exception -> 0x012a }
        r0 = 4
        android.media.CamcorderProfile r0 = android.media.CamcorderProfile.get(r0)     // Catch:{ Exception -> 0x012a }
        r1 = 2
        if (r0 == 0) goto L_0x00b9
        android.graphics.Point r4 = r6.f17691C     // Catch:{ Exception -> 0x012a }
        if (r4 == 0) goto L_0x0072
        android.graphics.Point r4 = r6.f17691C     // Catch:{ Exception -> 0x012a }
        int r4 = r4.x     // Catch:{ Exception -> 0x012a }
        r0.videoFrameWidth = r4     // Catch:{ Exception -> 0x012a }
        android.graphics.Point r4 = r6.f17691C     // Catch:{ Exception -> 0x012a }
        int r4 = r4.y     // Catch:{ Exception -> 0x012a }
        r0.videoFrameHeight = r4     // Catch:{ Exception -> 0x012a }
    L_0x0072:
        r0.fileFormat = r1     // Catch:{ Exception -> 0x012a }
        java.lang.String r4 = android.os.Build.MODEL     // Catch:{ Exception -> 0x012a }
        java.lang.String r5 = "MB525"
        boolean r4 = r4.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x012a }
        if (r4 != 0) goto L_0x0096
        java.lang.String r4 = android.os.Build.MODEL     // Catch:{ Exception -> 0x012a }
        java.lang.String r5 = "C8812"
        boolean r4 = r4.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x012a }
        if (r4 != 0) goto L_0x0096
        java.lang.String r4 = android.os.Build.MODEL     // Catch:{ Exception -> 0x012a }
        java.lang.String r5 = "C8650"
        boolean r4 = r4.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x012a }
        if (r4 == 0) goto L_0x0093
        goto L_0x0096
    L_0x0093:
        r0.videoCodec = r1     // Catch:{ Exception -> 0x012a }
        goto L_0x0098
    L_0x0096:
        r0.videoCodec = r3     // Catch:{ Exception -> 0x012a }
    L_0x0098:
        int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x012a }
        r4 = 14
        r5 = 3
        if (r1 < r4) goto L_0x00a2
    L_0x009f:
        r0.audioCodec = r5     // Catch:{ Exception -> 0x012a }
        goto L_0x00b3
    L_0x00a2:
        java.lang.String r1 = android.os.Build.DISPLAY     // Catch:{ Exception -> 0x012a }
        if (r1 == 0) goto L_0x00b1
        java.lang.String r1 = android.os.Build.DISPLAY     // Catch:{ Exception -> 0x012a }
        java.lang.String r4 = "MIUI"
        int r1 = r1.indexOf(r4)     // Catch:{ Exception -> 0x012a }
        if (r1 < 0) goto L_0x00b1
        goto L_0x009f
    L_0x00b1:
        r0.audioCodec = r3     // Catch:{ Exception -> 0x012a }
    L_0x00b3:
        android.media.MediaRecorder r1 = r6.f17698h     // Catch:{ Exception -> 0x012a }
        r1.setProfile(r0)     // Catch:{ Exception -> 0x012a }
        goto L_0x00d1
    L_0x00b9:
        android.media.MediaRecorder r0 = r6.f17698h     // Catch:{ Exception -> 0x012a }
        r0.setOutputFormat(r1)     // Catch:{ Exception -> 0x012a }
        android.media.MediaRecorder r0 = r6.f17698h     // Catch:{ Exception -> 0x012a }
        r0.setVideoEncoder(r1)     // Catch:{ Exception -> 0x012a }
        android.media.MediaRecorder r0 = r6.f17698h     // Catch:{ Exception -> 0x012a }
        r0.setAudioEncoder(r3)     // Catch:{ Exception -> 0x012a }
        android.media.MediaRecorder r0 = r6.f17698h     // Catch:{ Exception -> 0x012a }
        r1 = 320(0x140, float:4.48E-43)
        r4 = 240(0xf0, float:3.36E-43)
        r0.setVideoSize(r1, r4)     // Catch:{ Exception -> 0x012a }
    L_0x00d1:
        android.media.MediaRecorder r0 = r6.f17698h     // Catch:{ Exception -> 0x012a }
        android.view.SurfaceHolder r1 = r6.f17701k     // Catch:{ Exception -> 0x012a }
        android.view.Surface r1 = r1.getSurface()     // Catch:{ Exception -> 0x012a }
        r0.setPreviewDisplay(r1)     // Catch:{ Exception -> 0x012a }
        android.media.MediaRecorder r0 = r6.f17698h     // Catch:{ Exception -> 0x012a }
        r1 = 30000(0x7530, float:4.2039E-41)
        r0.setMaxDuration(r1)     // Catch:{ Exception -> 0x012a }
        android.media.MediaRecorder r0 = r6.f17698h     // Catch:{ Exception -> 0x012a }
        java.lang.String r1 = r6.f17707q     // Catch:{ Exception -> 0x012a }
        r0.setOutputFile(r1)     // Catch:{ Exception -> 0x012a }
        int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x012a }
        if (r0 < r2) goto L_0x00ff
        android.hardware.Camera$CameraInfo r0 = new android.hardware.Camera$CameraInfo     // Catch:{ Exception -> 0x012a }
        r0.<init>()     // Catch:{ Exception -> 0x012a }
        int r1 = r6.f17706p     // Catch:{ Exception -> 0x012a }
        android.hardware.Camera.getCameraInfo(r1, r0)     // Catch:{ Exception -> 0x012a }
        android.media.MediaRecorder r1 = r6.f17698h     // Catch:{ Exception -> 0x012a }
        int r0 = r0.orientation     // Catch:{ Exception -> 0x012a }
        r1.setOrientationHint(r0)     // Catch:{ Exception -> 0x012a }
    L_0x00ff:
        android.media.MediaRecorder r0 = r6.f17698h     // Catch:{ Exception -> 0x012a }
        r0.prepare()     // Catch:{ Exception -> 0x012a }
        android.media.MediaRecorder r0 = r6.f17698h     // Catch:{ Exception -> 0x012a }
        r0.start()     // Catch:{ Exception -> 0x012a }
    L_0x0109:
        r6.f17710t = r3
        java.util.Date r0 = new java.util.Date
        r0.<init>()
        long r0 = r0.getTime()
        r6.f17711u = r0
        android.os.Handler r0 = r6.f17692b
        java.lang.Runnable r1 = r6.f17690B
        r2 = 1000(0x3e8, double:4.94E-321)
        r0.postDelayed(r1, r2)
        android.widget.TextView r0 = r6.f17704n
        java.lang.String r1 = "00:00"
        r0.setText(r1)
        r6.updateRecordUI(r7)
        return
    L_0x012a:
        r0 = move-exception
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        java.lang.String r2 = "start MediaRecord failed: "
        r1.<init>(r2)
        r1.append(r0)
        java.lang.String r0 = r1.toString()
        java.lang.String r1 = "video"
        com.qiyukf.basesdk.p393a.C5264a.m21622c(r1, r0)
        int r0 = com.qiyukf.unicorn.C5961R.string.ysf_start_camera_to_record_failed
        android.widget.Toast r7 = android.widget.Toast.makeText(r6, r0, r7)
        r7.show()
        android.media.MediaRecorder r7 = r6.f17698h
        r7.release()
        r7 = 0
        r6.f17698h = r7
        android.hardware.Camera r0 = r6.f17699i
        r0.release()
        r6.f17699i = r7
        return
    L_0x0157:
        int r0 = r7.getId()
        int r1 = com.qiyukf.unicorn.C5961R.C5963id.switch_cameras
        if (r0 != r1) goto L_0x017a
        int r7 = android.os.Build.VERSION.SDK_INT
        if (r7 < r2) goto L_0x016d
        int r7 = r6.f17706p
        int r7 = r7 + r3
        int r0 = android.hardware.Camera.getNumberOfCameras()
        int r7 = r7 % r0
        r6.f17706p = r7
    L_0x016d:
        r6.m22390g()
        r6.m22397m()
        r6.m22396l()
        r6.m22398n()
        return
    L_0x017a:
        int r7 = r7.getId()
        int r0 = com.qiyukf.unicorn.C5961R.C5963id.ysf_iv_capture_video_finish
        if (r7 != r0) goto L_0x0185
        r6.finish()
    L_0x0185:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nim.uikit.session.activity.CaptureVideoActivity.onClick(android.view.View):void");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFormat(-3);
        getWindow().setFlags(1024, 1024);
        setContentView(C5961R.C5964layout.ysf_capture_video_activity);
        this.f17707q = getIntent().getExtras().getString("EXTRA_DATA_FILE_NAME");
        this.f17704n = (TextView) findViewById(C5961R.C5963id.record_times);
        this.f17703m = (ImageView) findViewById(C5961R.C5963id.recording_id);
        this.f17702l = (ImageView) findViewById(C5961R.C5963id.record_btn);
        this.f17705o = (ImageView) findViewById(C5961R.C5963id.switch_cameras);
        this.f17693c = (ProgressBar) findViewById(C5961R.C5963id.ysf_pb_video_progress_bar);
        this.f17693c.setVisibility(0);
        this.f17693c.setMax(30);
        this.f17694d = (TextView) findViewById(C5961R.C5963id.ysf_tv_video_progress_second);
        this.f17694d.setVisibility(0);
        this.f17694d.setText("30秒");
        this.f17696f = (ImageView) findViewById(C5961R.C5963id.ysf_iv_capture_send);
        this.f17696f.setVisibility(8);
        this.f17695e = (ImageView) findViewById(C5961R.C5963id.ysf_iv_capture_cancel);
        this.f17695e.setVisibility(8);
        this.f17697g = (ImageView) findViewById(C5961R.C5963id.ysf_iv_capture_video_finish);
        checkMultiCamera();
        this.f17702l.setOnClickListener(this);
        this.f17705o.setOnClickListener(this);
        this.f17695e.setOnClickListener(this);
        this.f17696f.setOnClickListener(this);
        this.f17697g.setOnClickListener(this);
        updateRecordUI(true);
        this.f17716z.clear();
        this.f17689A.clear();
        m22382a(false);
        if (VERSION.SDK_INT >= 9 && Camera.getNumberOfCameras() >= 2) {
            m22382a(true);
        }
        this.f17700j = (SurfaceView) findViewById(C5961R.C5963id.videoView);
        SurfaceHolder holder = this.f17700j.getHolder();
        holder.setType(3);
        holder.addCallback(this);
        m22390g();
    }

    public void onDestroy() {
        super.onDestroy();
        m22397m();
        this.f17714x = true;
    }

    public void onPause() {
        super.onPause();
        getWindow().setFlags(0, 128);
        if (this.f17710t) {
            m22391h();
            m22393i();
            return;
        }
        m22397m();
    }

    public void onResume() {
        super.onResume();
        getWindow().setFlags(128, 128);
    }

    public int setCameraDisplayOrientation(Context context, int i, Camera camera) {
        int i2;
        int i3 = 0;
        boolean z = i == 1;
        int i4 = 90;
        if (VERSION.SDK_INT >= 9) {
            CameraInfo cameraInfo = new CameraInfo();
            Camera.getCameraInfo(i, cameraInfo);
            i2 = cameraInfo.orientation;
            z = cameraInfo.facing == 1;
        } else {
            i2 = 90;
        }
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        if (rotation != 0) {
            if (rotation == 1) {
                i3 = 90;
            } else if (rotation == 2) {
                i3 = TinkerReport.KEY_APPLIED_VERSION_CHECK;
            } else if (rotation == 3) {
                i3 = 270;
            }
        }
        if (z) {
            i4 = (360 - ((i2 + i3) % 360)) % 360;
        } else {
            int i5 = ((i2 - i3) + 360) % 360;
            StringBuilder sb = new StringBuilder();
            sb.append(Build.MANUFACTURER);
            sb.append("_");
            sb.append(Build.MODEL);
            if (!"Xiaomi_MI-ONE Plus".equalsIgnoreCase(sb.toString())) {
                i4 = i5;
            }
        }
        camera.setDisplayOrientation(i4);
        return i4;
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.f17701k = surfaceHolder;
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f17701k = surfaceHolder;
        m22397m();
        if (m22396l()) {
            m22398n();
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f17701k = null;
        this.f17698h = null;
    }

    public void updateRecordUI(boolean z) {
        if (this.f17710t) {
            this.f17702l.setVisibility(0);
            this.f17697g.setVisibility(8);
            this.f17702l.setBackgroundResource(C5961R.C5962drawable.ysf_ic_video_record_stop);
            this.f17695e.setVisibility(8);
            this.f17696f.setVisibility(8);
        } else if (z) {
            this.f17702l.setVisibility(0);
            this.f17702l.setBackgroundResource(C5961R.C5962drawable.ysf_ic_video_record_start);
            this.f17695e.setVisibility(8);
            this.f17696f.setVisibility(8);
            this.f17697g.setVisibility(0);
        } else {
            this.f17702l.setVisibility(8);
            this.f17695e.setVisibility(0);
            this.f17696f.setVisibility(0);
        }
    }
}
