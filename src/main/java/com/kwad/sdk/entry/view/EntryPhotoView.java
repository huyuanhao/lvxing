package com.kwad.sdk.entry.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.p333g.C4143b;
import com.kwad.sdk.core.p333g.C4145c;
import com.kwad.sdk.core.page.widget.RoundAngleImageView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.core.response.p342b.C4324c;
import com.kwad.sdk.core.response.p342b.C4325d;
import com.kwad.sdk.p306a.C3809l;
import com.kwad.sdk.p306a.C3811n;
import com.kwad.sdk.p306a.C3817t;
import com.kwad.sdk.widget.C4579a;
import org.json.JSONObject;

public class EntryPhotoView extends C4579a {
    /* renamed from: a */
    private RoundAngleImageView f14435a;
    /* renamed from: b */
    private TextView f14436b;
    /* renamed from: c */
    private AdTemplate f14437c;
    /* renamed from: d */
    private PhotoInfo f14438d;
    /* renamed from: e */
    private View f14439e;
    /* renamed from: f */
    private int f14440f;
    /* renamed from: g */
    private String f14441g;

    public EntryPhotoView(Context context) {
        super(context);
    }

    public EntryPhotoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo24610a() {
        this.f14435a = (RoundAngleImageView) findViewById(C3809l.m15789a(getContext(), "ksad_entryitem_photocover"));
        this.f14435a.setRadius(C3817t.m15862a(getContext(), 4.0f));
        this.f14436b = (TextView) findViewById(C3809l.m15789a(getContext(), "ksad_entryitem_lickcount"));
        this.f14439e = findViewById(C3809l.m15789a(getContext(), "ksad_entryitem_lookmore"));
    }

    /* renamed from: a */
    public void mo24611a(int i, String str) {
        this.f14440f = i;
        this.f14441g = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo24612b() {
        super.mo24612b();
        if (!this.f14437c.mPvReported) {
            AdTemplate adTemplate = this.f14437c;
            adTemplate.mPvReported = true;
            if (C4324c.m17664a(adTemplate)) {
                C4143b.m17123a(this.f14437c, (JSONObject) null);
            } else {
                C4145c.m17155a(this.f14437c, this.f14440f, this.f14441g);
            }
        }
    }

    public String getEntryId() {
        return this.f14441g;
    }

    public int getPosition() {
        return this.f14440f;
    }

    public AdTemplate getTemplateData() {
        return this.f14437c;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        mo24610a();
    }

    public void setLikeViewPos(int i) {
        LayoutParams layoutParams;
        int i2;
        if (i != 0) {
            if (i == 1) {
                this.f14436b.setVisibility(0);
                layoutParams = (LayoutParams) this.f14436b.getLayoutParams();
                i2 = 83;
            } else if (i == 2) {
                this.f14436b.setVisibility(0);
                layoutParams = (LayoutParams) this.f14436b.getLayoutParams();
                i2 = 85;
            } else {
                return;
            }
            layoutParams.gravity = i2;
            return;
        }
        this.f14436b.setVisibility(8);
    }

    public void setLookMoreVisiable(int i) {
        this.f14439e.setVisibility(i);
    }

    public void setTemplateData(AdTemplate adTemplate) {
        this.f14437c = adTemplate;
        this.f14438d = adTemplate.photoInfo;
        if (this.f14438d != null) {
            String f = C4325d.m17677f(adTemplate.photoInfo);
            if (TextUtils.isEmpty(f)) {
                f = C4325d.m17674c(this.f14438d);
            }
            KSImageLoader.loadImage((ImageView) this.f14435a, f, KSImageLoader.IMGOPTION_ENTRY);
            this.f14436b.setText(C3811n.m15809a(C4325d.m17682k(adTemplate.photoInfo), "0"));
        }
    }
}
