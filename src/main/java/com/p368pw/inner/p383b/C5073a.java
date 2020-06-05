package com.p368pw.inner.p383b;

import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.base.p387d.C5208r;
import com.p368pw.p392us.AdInfo;
import com.p368pw.p392us.IAdListener;
import com.p368pw.p392us.Setting;

/* renamed from: com.pw.inner.b.a */
public class C5073a implements IAdListener {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public IAdListener f16585a;

    public C5073a(IAdListener iAdListener) {
        this.f16585a = iAdListener;
    }

    public void onClicked() {
        C5205o.m21461a();
        if (this.f16585a != null) {
            C5208r.m21479a(new Runnable() {
                public void run() {
                    C5073a.this.f16585a.onClicked();
                }
            });
        }
    }

    public void onDownloadFinished(final String str) {
        C5205o.m21462a(str);
        if (this.f16585a != null) {
            C5208r.m21479a(new Runnable() {
                public void run() {
                    C5073a.this.f16585a.onDownloadFinished(str);
                }
            });
        }
    }

    public void onDownloadStarted() {
        C5205o.m21461a();
        if (this.f16585a != null) {
            C5208r.m21479a(new Runnable() {
                public void run() {
                    C5073a.this.f16585a.onDownloadStarted();
                }
            });
        }
    }

    public void onError(final String str) {
        C5205o.m21466c(str);
        C5205o.m21462a(str);
        if (this.f16585a != null) {
            C5208r.m21479a(new Runnable() {
                public void run() {
                    C5073a.this.f16585a.onError(str);
                }
            });
        }
    }

    public void onInstalled() {
        C5205o.m21461a();
        if (this.f16585a != null) {
            C5208r.m21479a(new Runnable() {
                public void run() {
                    C5073a.this.f16585a.onInstalled();
                }
            });
        }
    }

    public void onLoaded(final AdInfo adInfo, final Setting setting) {
        C5205o.m21461a();
        if (this.f16585a != null) {
            C5208r.m21479a(new Runnable() {
                public void run() {
                    C5073a.this.f16585a.onLoaded(adInfo, setting);
                }
            });
        }
    }

    public void onShowed() {
        C5205o.m21461a();
        if (this.f16585a != null) {
            C5208r.m21479a(new Runnable() {
                public void run() {
                    C5073a.this.f16585a.onShowed();
                }
            });
        }
    }
}
