package com.p368pw.inner.p369a.p379e.p380a.p382b;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.view.OrientationEventListener;
import com.p368pw.inner.base.p387d.C5205o;

/* renamed from: com.pw.inner.a.e.a.b.c */
public class C4927c extends OrientationEventListener {
    /* renamed from: a */
    private Context f15941a;
    /* renamed from: b */
    private boolean f15942b = false;
    /* renamed from: c */
    private int f15943c = -1;
    /* renamed from: d */
    private long f15944d = 0;
    /* renamed from: e */
    private boolean f15945e = true;
    /* renamed from: f */
    private C4928a f15946f;

    /* renamed from: com.pw.inner.a.e.a.b.c$a */
    public interface C4928a {
        void onChanged(int i);
    }

    public C4927c(Context context, int i) {
        super(context, i);
        this.f15941a = context.getApplicationContext();
    }

    /* renamed from: a */
    private boolean m20450a() {
        int i;
        Context context = this.f15941a;
        boolean z = false;
        if (context == null) {
            return false;
        }
        try {
            i = System.getInt(context.getContentResolver(), "accelerometer_rotation");
        } catch (SettingNotFoundException e) {
            C5205o.m21464a((Throwable) e);
            i = 0;
        }
        if (i == 1) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    public void mo26119a(C4928a aVar) {
        this.f15946f = aVar;
    }

    public void onOrientationChanged(int i) {
        int i2;
        if (this.f15945e) {
            if (this.f15941a == null) {
                C5205o.m21462a("onOrientationChanged: ");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f15944d > 3000) {
                this.f15942b = m20450a();
                this.f15944d = currentTimeMillis;
            }
            if (this.f15942b && i != -1) {
                boolean z = false;
                if (i > 350 || i < 10) {
                    i2 = 1;
                } else if (i > 80 && i < 100) {
                    i2 = 8;
                } else if (i > 260 && i < 280) {
                    i2 = 0;
                } else {
                    return;
                }
                int i3 = this.f15943c;
                if (i2 != i3) {
                    if (i3 != -1) {
                        z = true;
                    }
                    this.f15943c = i2;
                    if (z) {
                        C4928a aVar = this.f15946f;
                        if (aVar != null) {
                            aVar.onChanged(i2);
                        } else {
                            C5205o.m21462a("mChangeListener = null ");
                            ((Activity) this.f15941a).setRequestedOrientation(i2);
                        }
                    }
                }
            }
        }
    }
}
