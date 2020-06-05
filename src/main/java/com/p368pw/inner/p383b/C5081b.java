package com.p368pw.inner.p383b;

import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.base.p387d.C5208r;
import com.p368pw.p392us.IAppWallListener;
import com.p368pw.p392us.Setting;

/* renamed from: com.pw.inner.b.b */
public class C5081b implements IAppWallListener {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public IAppWallListener f16597a;

    public C5081b(IAppWallListener iAppWallListener) {
        this.f16597a = iAppWallListener;
    }

    public void onClicked() {
        C5205o.m21461a();
        if (this.f16597a != null) {
            C5208r.m21479a(new Runnable() {
                public void run() {
                    C5081b.this.f16597a.onClicked();
                }
            });
        }
    }

    public void onError(final String str) {
        C5205o.m21466c(str);
        C5205o.m21462a(str);
        if (this.f16597a != null) {
            C5208r.m21479a(new Runnable() {
                public void run() {
                    C5081b.this.f16597a.onError(str);
                }
            });
        }
    }

    public void onLoaded(final Setting setting) {
        C5205o.m21461a();
        if (this.f16597a != null) {
            C5208r.m21479a(new Runnable() {
                public void run() {
                    C5081b.this.f16597a.onLoaded(setting);
                }
            });
        }
    }

    public void onReward(int i, int i2, double d) {
        if (this.f16597a != null) {
            final int i3 = i;
            final int i4 = i2;
            final double d2 = d;
            C50865 r1 = new Runnable() {
                public void run() {
                    C5081b.this.f16597a.onReward(i3, i4, d2);
                }
            };
            C5208r.m21479a(r1);
        }
    }

    public void onShowed() {
        C5205o.m21461a();
        if (this.f16597a != null) {
            C5208r.m21479a(new Runnable() {
                public void run() {
                    C5081b.this.f16597a.onShowed();
                }
            });
        }
    }
}
