package com.kwad.sdk.contentalliance.detail.photo.p313b;

import android.widget.FrameLayout.LayoutParams;
import com.kwad.sdk.contentalliance.detail.C3872b;
import com.kwad.sdk.contentalliance.watermark.WaterMarkView;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.core.response.p342b.C4324c;
import com.kwad.sdk.core.response.p342b.C4325d;
import com.kwad.sdk.p306a.C3817t;

/* renamed from: com.kwad.sdk.contentalliance.detail.photo.b.h */
public class C3935h extends C3872b {
    /* renamed from: c */
    private WaterMarkView f13282c;
    /* renamed from: d */
    private long f13283d = 0;
    /* renamed from: e */
    private boolean f13284e;
    /* renamed from: f */
    private int f13285f = 2;

    /* renamed from: b */
    private boolean m16324b(int i) {
        return i == 1;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23338a() {
        int i;
        WaterMarkView waterMarkView;
        super.mo23338a();
        PhotoInfo f = C4324c.m17669f(this.f13125b.f13133g);
        this.f13284e = C4325d.m17688q(f);
        if (this.f13284e) {
            this.f13285f = C4325d.m17689r(f);
            this.f13283d = C4325d.m17684m(f);
            this.f13282c.setAuthorId(this.f13283d);
            this.f13282c.setAlignment(m16324b(this.f13285f));
            mo23443a(this.f13285f);
            waterMarkView = this.f13282c;
            i = 0;
        } else {
            waterMarkView = this.f13282c;
            i = 4;
        }
        waterMarkView.setVisibility(i);
    }

    /* renamed from: a */
    public void mo23443a(int i) {
        LayoutParams layoutParams = (LayoutParams) this.f13282c.getLayoutParams();
        if (i == 2) {
            layoutParams.gravity = 3;
            layoutParams.leftMargin = C3817t.m15862a(mo24770p(), 35.0f);
        } else {
            layoutParams.gravity = 5;
            layoutParams.rightMargin = C3817t.m15862a(mo24770p(), 35.0f);
        }
        this.f13282c.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo23339b() {
        super.mo23339b();
        this.f13282c = (WaterMarkView) mo24760a("ksad_video_water_mark");
    }
}
