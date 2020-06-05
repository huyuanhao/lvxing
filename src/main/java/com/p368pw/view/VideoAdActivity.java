package com.p368pw.view;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.p369a.p379e.C4933e;
import com.p368pw.inner.p369a.p379e.C4941f;
import com.p368pw.inner.p369a.p379e.C4942g;
import com.p368pw.inner.p369a.p379e.C4942g.C4955d;
import com.p368pw.inner.p369a.p379e.p380a.p382b.C4927c;
import com.p368pw.inner.p369a.p379e.p380a.p382b.C4927c.C4928a;

/* renamed from: com.pw.view.VideoAdActivity */
public class VideoAdActivity extends Activity implements C4955d {
    public static final int ORIENTATION_LANDSCAPE = 0;
    public static final int ORIENTATION_PORTRAIT = 1;
    public static final String PARAMS_IDENTITY_HASHCODE = "identity_hashcode";
    public static final String PARAMS_SETTING_ORIENTATION = "setting_orientation";
    public static final String PARAMS_VIDEO_ORIENTATION = "video_orientation";
    private int identityHashcode;
    private boolean mIsBackPressed;
    /* access modifiers changed from: private */
    public C4942g mVideoAdView;
    private C4927c screenOrientationSwitcher;
    private C4933e videoAd;

    public void finish() {
        C5205o.m21462a("vd act finish");
        C4941f.m20538b(this.identityHashcode);
        super.finish();
    }

    public void onBackControl(boolean z) {
        this.mIsBackPressed = z;
    }

    public void onBackPressed() {
        if (this.mIsBackPressed) {
            super.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            int intExtra = getIntent().getIntExtra(PARAMS_VIDEO_ORIENTATION, 1);
            final int intExtra2 = getIntent().getIntExtra(PARAMS_SETTING_ORIENTATION, -1);
            final boolean z = intExtra2 != -1;
            if (z) {
                setRequestedOrientation(intExtra2);
            } else {
                setRequestedOrientation(intExtra);
            }
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
            getWindow().setFlags(16777216, 16777216);
            if (bundle == null) {
                C5205o.m21462a("vd act ins n");
                this.identityHashcode = getIntent().getIntExtra(PARAMS_IDENTITY_HASHCODE, -1);
                if (z) {
                    setRequestedOrientation(intExtra2);
                } else {
                    Configuration configuration = getResources().getConfiguration();
                    if (configuration.orientation == 2) {
                        intExtra = 0;
                    } else if (configuration.orientation == 1) {
                        intExtra = 1;
                    }
                    setRequestedOrientation(intExtra);
                }
                if (z) {
                    intExtra = intExtra2;
                }
                this.videoAd = C4941f.m20536a(this.identityHashcode);
                this.mVideoAdView = this.videoAd.mo26152f();
                setContentView(this.mVideoAdView);
                this.mVideoAdView.mo26052a(intExtra);
                this.mVideoAdView.mo26174a(intExtra, this);
                this.mVideoAdView.setOnBackControlListener(this);
                this.screenOrientationSwitcher = new C4927c(this, 3);
                this.screenOrientationSwitcher.mo26119a(new C4928a() {
                    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0044, code lost:
            if (r3 == 1) goto L_0x0034;
     */
                    public void onChanged(int r3) {
                        /*
                        r2 = this;
                        boolean r0 = r5
                        if (r0 == 0) goto L_0x000c
                        com.pw.view.VideoAdActivity r3 = com.p368pw.view.VideoAdActivity.this
                        int r0 = r1
                        r3.setRequestedOrientation(r0)
                        goto L_0x0050
                    L_0x000c:
                        java.lang.StringBuilder r0 = new java.lang.StringBuilder
                        r0.<init>()
                        java.lang.String r1 = "vd act screen onchanged: "
                        r0.append(r1)
                        r0.append(r3)
                        java.lang.String r0 = r0.toString()
                        com.p368pw.inner.base.p387d.C5205o.m21462a(r0)
                        com.pw.view.VideoAdActivity r0 = com.p368pw.view.VideoAdActivity.this
                        int r0 = r0.getRequestedOrientation()
                        if (r0 == r3) goto L_0x0050
                        com.pw.view.VideoAdActivity r0 = com.p368pw.view.VideoAdActivity.this
                        com.pw.inner.a.e.g r0 = r0.mVideoAdView
                        if (r0 == 0) goto L_0x0050
                        r0 = 8
                        if (r3 != r0) goto L_0x003a
                    L_0x0034:
                        com.pw.view.VideoAdActivity r1 = com.p368pw.view.VideoAdActivity.this
                        r1.setRequestedOrientation(r0)
                        goto L_0x0047
                    L_0x003a:
                        if (r3 != 0) goto L_0x0043
                        com.pw.view.VideoAdActivity r0 = com.p368pw.view.VideoAdActivity.this
                        r1 = 0
                        r0.setRequestedOrientation(r1)
                        goto L_0x0047
                    L_0x0043:
                        r0 = 1
                        if (r3 != r0) goto L_0x0047
                        goto L_0x0034
                    L_0x0047:
                        com.pw.view.VideoAdActivity r0 = com.p368pw.view.VideoAdActivity.this
                        com.pw.inner.a.e.g r0 = r0.mVideoAdView
                        r0.mo26052a(r3)
                    L_0x0050:
                        return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.p368pw.view.VideoAdActivity.C52611.onChanged(int):void");
                    }
                });
                if (this.screenOrientationSwitcher.canDetectOrientation()) {
                    this.screenOrientationSwitcher.enable();
                }
                return;
            }
            finish();
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    public void onDestroy() {
        try {
            C5205o.m21462a("vd act destroy");
            if (this.screenOrientationSwitcher != null) {
                if (this.screenOrientationSwitcher.canDetectOrientation()) {
                    this.screenOrientationSwitcher.disable();
                }
                this.screenOrientationSwitcher.mo26119a(null);
                this.screenOrientationSwitcher = null;
            }
            if (this.mVideoAdView != null) {
                this.mVideoAdView.mo26064e();
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
        super.onDestroy();
    }

    public void onFinish() {
        finish();
    }

    public void onPause() {
        super.onPause();
        C4942g gVar = this.mVideoAdView;
        if (gVar != null) {
            gVar.mo26063d();
        }
    }

    public void onResume() {
        super.onResume();
        try {
            if (this.mVideoAdView != null) {
                this.mVideoAdView.mo26062c();
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(PARAMS_IDENTITY_HASHCODE, this.identityHashcode);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            try {
                if (VERSION.SDK_INT >= 19) {
                    getWindow().getDecorView().setSystemUiVisibility(5894);
                }
            } catch (Throwable th) {
                C5205o.m21464a(th);
            }
        }
    }
}
