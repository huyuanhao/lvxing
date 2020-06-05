package com.p368pw.inner.p383b;

import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.base.p387d.C5208r;
import com.p368pw.p392us.IInterstitialAdListener;
import com.p368pw.p392us.Setting;

/* renamed from: com.pw.inner.b.c */
public class C5087c implements IInterstitialAdListener {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public IInterstitialAdListener f16608a;

    public C5087c(IInterstitialAdListener iInterstitialAdListener) {
        this.f16608a = iInterstitialAdListener;
    }

    public void onClosed() {
        C5205o.m21461a();
        if (this.f16608a != null) {
            C5208r.m21479a(new Runnable() {
                public void run() {
                    C5087c.this.f16608a.onClosed();
                }
            });
        }
    }

    public void onDownloadFinished(final String str, final String str2) {
        C5205o.m21462a(String.format("pkgName:%s,apkPath:%s", new Object[]{str, str2}));
        if (this.f16608a != null) {
            C5208r.m21479a(new Runnable() {
                public void run() {
                    C5087c.this.f16608a.onDownloadFinished(str, str2);
                }
            });
        }
    }

    public void onDownloadStarted(final String str) {
        C5205o.m21462a(str);
        if (this.f16608a != null) {
            C5208r.m21479a(new Runnable() {
                public void run() {
                    C5087c.this.f16608a.onDownloadStarted(str);
                }
            });
        }
    }

    public void onError(final String str) {
        C5205o.m21466c(str);
        C5205o.m21462a(str);
        if (this.f16608a != null) {
            C5208r.m21479a(new Runnable() {
                public void run() {
                    C5087c.this.f16608a.onError(str);
                }
            });
        }
    }

    public void onInstalled(final String str, final String str2) {
        C5205o.m21462a(String.format("pkgName:%s,apkPath:%s", new Object[]{str, str2}));
        if (this.f16608a != null) {
            C5208r.m21479a(new Runnable() {
                public void run() {
                    C5087c.this.f16608a.onInstalled(str, str2);
                }
            });
        }
    }

    public void onLoaded(final Setting setting) {
        C5205o.m21461a();
        if (this.f16608a != null) {
            C5208r.m21479a(new Runnable() {
                public void run() {
                    C5087c.this.f16608a.onLoaded(setting);
                }
            });
        }
    }

    public void onShowed() {
        C5205o.m21461a();
        if (this.f16608a != null) {
            C5208r.m21479a(new Runnable() {
                public void run() {
                    C5087c.this.f16608a.onShowed();
                }
            });
        }
    }
}
