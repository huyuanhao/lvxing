package com.kwad.sdk.entry.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.kwad.sdk.core.p333g.C4145c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.C4329d;
import com.kwad.sdk.core.scene.C4331a;
import com.kwad.sdk.core.scene.PageScene.PageSource;
import com.kwad.sdk.entry.C4402a;
import com.kwad.sdk.entry.model.C4403a;
import com.kwad.sdk.export.p347i.KsEntryElement.OnFeedClickListener;
import com.kwad.sdk.p306a.C3809l;
import com.kwad.sdk.widget.C4581b;
import java.util.ArrayList;
import java.util.List;

public class EntryLinearView extends C4581b implements C4408b {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public C4329d f14426a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public List<AdTemplate> f14427b = new ArrayList();
    /* renamed from: c */
    private EntryPhotoView f14428c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public EntryPhotoView f14429d;
    /* renamed from: e */
    private TextView f14430e;
    /* renamed from: f */
    private TextView f14431f;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public OnFeedClickListener f14432g;
    /* renamed from: h */
    private OnClickListener f14433h = new OnClickListener() {
        public void onClick(View view) {
            if (EntryLinearView.this.f14432g != null) {
                EntryPhotoView entryPhotoView = (EntryPhotoView) view;
                AdTemplate templateData = entryPhotoView.getTemplateData();
                C4403a aVar = new C4403a(EntryLinearView.this.f14426a);
                aVar.mo24604a(templateData);
                C4402a.m17970a(aVar);
                int i = 0;
                if (view == EntryLinearView.this.f14429d) {
                    i = 1;
                }
                C4145c.m17164b(templateData, i, entryPhotoView.getEntryId());
                C4331a.m17707a().mo24480a(templateData.mAdScene, PageSource.ENTRYWIDGET, String.valueOf(EntryLinearView.this.hashCode()));
                EntryLinearView.this.f14432g.handleFeedClick(EntryLinearView.this.f14426a.f14224a, EntryLinearView.this.f14427b, i, view);
            }
        }
    };

    public EntryLinearView(Context context) {
        super(context);
    }

    public EntryLinearView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* renamed from: e */
    private void m17979e() {
        this.f14428c = (EntryPhotoView) findViewById(C3809l.m15789a(getContext(), "ksad_entry2_photoleft"));
        this.f14428c.setRatio(1.42f);
        this.f14429d = (EntryPhotoView) findViewById(C3809l.m15789a(getContext(), "ksad_entry2_photoright"));
        this.f14429d.setRatio(1.42f);
        this.f14430e = (TextView) findViewById(C3809l.m15789a(getContext(), "ksad_entry2_sourceDescLeft"));
        this.f14431f = (TextView) findViewById(C3809l.m15789a(getContext(), "ksad_entry2_sourceDescRight"));
        this.f14429d.setOnClickListener(this.f14433h);
        this.f14428c.setOnClickListener(this.f14433h);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo24605a() {
        super.mo24605a();
        C4145c.m17163a(this.f14426a);
    }

    /* renamed from: a */
    public boolean mo24606a(C4329d dVar) {
        this.f14426a = dVar;
        if (this.f14426a == null) {
            removeAllViews();
            return false;
        }
        this.f14427b.clear();
        for (AdTemplate adTemplate : this.f14426a.f14229f) {
            if (!adTemplate.needHide) {
                this.f14427b.add(adTemplate);
            }
            if (this.f14427b.size() >= 2) {
                break;
            }
        }
        List<AdTemplate> list = this.f14427b;
        if (list == null || list.size() <= 1) {
            setVisibility(8);
            return false;
        }
        this.f14428c.setTemplateData((AdTemplate) this.f14427b.get(0));
        this.f14428c.mo24611a(0, this.f14426a.f14228e);
        this.f14428c.setLikeViewPos(this.f14426a.f14227d);
        this.f14429d.setTemplateData((AdTemplate) this.f14427b.get(1));
        this.f14429d.mo24611a(1, this.f14426a.f14228e);
        this.f14429d.setLikeViewPos(this.f14426a.f14227d);
        setVisibility(0);
        this.f14431f.setText(dVar.f14225b);
        this.f14430e.setText(dVar.f14225b);
        int i = dVar.f14226c;
        if (i == 0) {
            this.f14431f.setVisibility(8);
        } else if (i != 1) {
            this.f14431f.setVisibility(0);
        } else {
            this.f14431f.setVisibility(8);
            this.f14430e.setVisibility(0);
            return true;
        }
        this.f14430e.setVisibility(8);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        m17979e();
    }

    public void setOnfeedClickListener(OnFeedClickListener onFeedClickListener) {
        this.f14432g = onFeedClickListener;
    }
}
