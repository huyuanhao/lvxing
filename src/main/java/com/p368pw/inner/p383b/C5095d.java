package com.p368pw.inner.p383b;

import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.base.p387d.C5208r;
import com.p368pw.p392us.IRewardAdListener;
import com.p368pw.p392us.Setting;

/* renamed from: com.pw.inner.b.d */
public class C5095d implements IRewardAdListener {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public IRewardAdListener f16623a;

    public C5095d(IRewardAdListener iRewardAdListener) {
        this.f16623a = iRewardAdListener;
    }

    public void onClosed() {
        C5205o.m21461a();
        if (this.f16623a != null) {
            C5208r.m21479a(new Runnable() {
                public void run() {
                    C5095d.this.f16623a.onClosed();
                }
            });
        }
    }

    public void onDownloadFinished(final String str, final String str2) {
        C5205o.m21462a(String.format("pkgName:%s,apkPath:%s", new Object[]{str, str2}));
        if (this.f16623a != null) {
            C5208r.m21479a(new Runnable() {
                public void run() {
                    C5095d.this.f16623a.onDownloadFinished(str, str2);
                }
            });
        }
    }

    public void onDownloadStarted(final String str) {
        C5205o.m21462a(str);
        if (this.f16623a != null) {
            C5208r.m21479a(new Runnable() {
                public void run() {
                    C5095d.this.f16623a.onDownloadStarted(str);
                }
            });
        }
    }

    public void onError(final String str) {
        C5205o.m21466c(str);
        C5205o.m21462a(str);
        if (this.f16623a != null) {
            C5208r.m21479a(new Runnable() {
                public void run() {
                    C5095d.this.f16623a.onError(str);
                }
            });
        }
    }

    public void onInstalled(final String str, final String str2) {
        C5205o.m21462a(String.format("pkgName:%s,apkPath:%s", new Object[]{str, str2}));
        if (this.f16623a != null) {
            C5208r.m21479a(new Runnable() {
                public void run() {
                    C5095d.this.f16623a.onInstalled(str, str2);
                }
            });
        }
    }

    public void onLoaded(final Setting setting) {
        C5205o.m21461a();
        if (this.f16623a != null) {
            C5208r.m21479a(new Runnable() {
                public void run() {
                    C5095d.this.f16623a.onLoaded(setting);
                }
            });
        }
    }

    public void onShowed() {
        C5205o.m21461a();
        if (this.f16623a != null) {
            C5208r.m21479a(new Runnable() {
                public void run() {
                    C5095d.this.f16623a.onShowed();
                }
            });
        }
    }

    public void onVideoComplete() {
        C5205o.m21461a();
        if (this.f16623a != null) {
            C5208r.m21479a(new Runnable() {
                public void run() {
                    C5095d.this.f16623a.onVideoComplete();
                }
            });
        }
    }
}
