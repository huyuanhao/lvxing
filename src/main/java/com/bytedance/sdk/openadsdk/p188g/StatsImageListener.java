package com.bytedance.sdk.openadsdk.p188g;

import android.graphics.Bitmap;
import com.bytedance.sdk.adnet.core.C1982p;
import com.bytedance.sdk.adnet.p159b.ImageLoader.C1963c;
import com.bytedance.sdk.adnet.p159b.ImageLoader.C1964d;
import com.bytedance.sdk.openadsdk.core.C2240g;
import com.bytedance.sdk.openadsdk.p185f.StatsLogManager;
import com.bytedance.sdk.openadsdk.p185f.p186a.LogStatsBase;

/* renamed from: com.bytedance.sdk.openadsdk.g.b */
public class StatsImageListener implements C1964d {
    /* renamed from: a */
    private boolean f8716a;
    /* renamed from: b */
    private LogStatsBase f8717b;

    /* renamed from: a */
    public void mo14215a() {
    }

    /* renamed from: a */
    public void mo14171a(C1982p<Bitmap> pVar) {
    }

    /* renamed from: b */
    public void mo14217b() {
    }

    /* renamed from: a */
    public void mo16647a(String str) {
        if (this.f8716a) {
            LogStatsBase dVar = this.f8717b;
            if (dVar != null) {
                dVar.mo16595c(str);
            }
        }
    }

    /* renamed from: a */
    public void mo16646a(int i) {
        if (this.f8716a) {
            LogStatsBase dVar = this.f8717b;
            if (dVar != null) {
                dVar.mo16590a(i);
            }
        }
    }

    /* renamed from: b */
    public void mo16648b(String str) {
        if (this.f8716a) {
            LogStatsBase dVar = this.f8717b;
            if (dVar != null) {
                dVar.mo16601f(str);
            }
        }
    }

    /* renamed from: c */
    public void mo16649c(String str) {
        if (this.f8716a) {
            LogStatsBase dVar = this.f8717b;
            if (dVar != null) {
                dVar.mo16597d(str);
            }
        }
    }

    /* renamed from: d */
    public void mo16650d(String str) {
        if (this.f8716a) {
            LogStatsBase dVar = this.f8717b;
            if (dVar != null) {
                dVar.mo16605h(str);
            }
        }
    }

    public StatsImageListener(boolean z) {
        this.f8716a = z;
        if (this.f8716a) {
            this.f8717b = LogStatsBase.m11308b();
        }
    }

    /* renamed from: a */
    public void mo14216a(C1963c cVar, boolean z) {
        if (this.f8716a && this.f8717b != null) {
            if (cVar == null || cVar.mo14214a() == null) {
                this.f8717b.mo16592b(202).mo16603g(C2240g.m9576a(202));
                StatsLogManager.m11278a().mo16579k(this.f8717b);
            }
        }
    }

    /* renamed from: b */
    public void mo14172b(C1982p<Bitmap> pVar) {
        if (this.f8716a) {
            LogStatsBase dVar = this.f8717b;
            if (dVar != null) {
                dVar.mo16592b(201).mo16603g(C2240g.m9576a(201));
                StatsLogManager.m11278a().mo16579k(this.f8717b);
            }
        }
    }
}
