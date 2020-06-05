package com.p368pw.inner.p383b;

import android.view.View;
import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.base.p387d.C5208r;
import com.p368pw.p392us.ISplashAdListener;
import com.p368pw.p392us.Setting;

/* renamed from: com.pw.inner.b.e */
public class C5104e implements ISplashAdListener {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public ISplashAdListener f16639a;

    public C5104e(ISplashAdListener iSplashAdListener) {
        this.f16639a = iSplashAdListener;
    }

    public void onClicked() {
        C5205o.m21461a();
        if (this.f16639a != null) {
            C5208r.m21479a(new Runnable() {
                public void run() {
                    C5104e.this.f16639a.onClicked();
                }
            });
        }
    }

    public void onDownloadFinished(final String str, final String str2) {
        C5205o.m21462a(String.format("pkgName:%s,apkPath:%s", new Object[]{str, str2}));
        if (this.f16639a != null) {
            C5208r.m21479a(new Runnable() {
                public void run() {
                    C5104e.this.f16639a.onDownloadFinished(str, str2);
                }
            });
        }
    }

    public void onDownloadStarted(final String str) {
        C5205o.m21462a(str);
        if (this.f16639a != null) {
            C5208r.m21479a(new Runnable() {
                public void run() {
                    C5104e.this.f16639a.onDownloadStarted(str);
                }
            });
        }
    }

    public void onError(final String str) {
        C5205o.m21466c(str);
        C5205o.m21462a(str);
        if (this.f16639a != null) {
            C5208r.m21479a(new Runnable() {
                public void run() {
                    C5104e.this.f16639a.onError(str);
                }
            });
        }
    }

    public void onInstalled(final String str, final String str2) {
        C5205o.m21462a(String.format("pkgName:%s,apkPath:%s", new Object[]{str, str2}));
        if (this.f16639a != null) {
            C5208r.m21479a(new Runnable() {
                public void run() {
                    C5104e.this.f16639a.onInstalled(str, str2);
                }
            });
        }
    }

    public void onLoaded(final View view, final Setting setting) {
        C5205o.m21461a();
        if (this.f16639a != null) {
            C5208r.m21479a(new Runnable() {
                public void run() {
                    C5104e.this.f16639a.onLoaded(view, setting);
                }
            });
        }
    }

    public void onShowed() {
        C5205o.m21461a();
        if (this.f16639a != null) {
            C5208r.m21479a(new Runnable() {
                public void run() {
                    C5104e.this.f16639a.onShowed();
                }
            });
        }
    }

    public void onSkip() {
        C5205o.m21461a();
        if (this.f16639a != null) {
            C5208r.m21479a(new Runnable() {
                public void run() {
                    C5104e.this.f16639a.onSkip();
                }
            });
        }
    }

    public void onTimeOver() {
        C5205o.m21461a();
        if (this.f16639a != null) {
            C5208r.m21479a(new Runnable() {
                public void run() {
                    C5104e.this.f16639a.onTimeOver();
                }
            });
        }
    }
}
