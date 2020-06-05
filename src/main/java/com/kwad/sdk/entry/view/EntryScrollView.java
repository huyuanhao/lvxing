package com.kwad.sdk.entry.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.kwad.sdk.core.p333g.C4145c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.C4329d;
import com.kwad.sdk.core.scene.C4331a;
import com.kwad.sdk.core.scene.PageScene.PageSource;
import com.kwad.sdk.entry.C4402a;
import com.kwad.sdk.entry.model.C4403a;
import com.kwad.sdk.export.p347i.KsEntryElement.OnFeedClickListener;
import com.kwad.sdk.p306a.C3809l;
import com.kwad.sdk.p306a.C3817t;
import com.kwad.sdk.widget.C4581b;
import java.util.ArrayList;
import java.util.List;

public class EntryScrollView extends C4581b implements C4408b {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public C4329d f14442a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public List<AdTemplate> f14443b = new ArrayList();
    /* renamed from: c */
    private EntryViewPager f14444c;
    /* renamed from: d */
    private C4406a f14445d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public OnFeedClickListener f14446e;
    /* renamed from: f */
    private TextView f14447f;
    /* renamed from: g */
    private TextView f14448g;
    /* renamed from: h */
    private float f14449h = 0.68f;
    /* access modifiers changed from: private */
    /* renamed from: i */
    public OnClickListener f14450i = new OnClickListener() {
        public void onClick(View view) {
            if (EntryScrollView.this.f14446e != null) {
                EntryPhotoView entryPhotoView = (EntryPhotoView) view;
                AdTemplate templateData = entryPhotoView.getTemplateData();
                C4403a aVar = new C4403a(EntryScrollView.this.f14442a);
                aVar.mo24604a(templateData);
                C4402a.m17970a(aVar);
                C4145c.m17164b(templateData, entryPhotoView.getPosition(), entryPhotoView.getEntryId());
                C4331a.m17707a().mo24480a(templateData.mAdScene, PageSource.ENTRYWIDGET, String.valueOf(EntryScrollView.this.hashCode()));
                EntryScrollView.this.f14446e.handleFeedClick(EntryScrollView.this.f14442a.f14224a, EntryScrollView.this.f14443b, entryPhotoView.getPosition(), view);
            }
        }
    };

    /* renamed from: com.kwad.sdk.entry.view.EntryScrollView$a */
    private class C4406a extends PagerAdapter {
        /* renamed from: b */
        private List<EntryPhotoView> f14453b;

        private C4406a() {
            this.f14453b = new ArrayList();
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            if (obj instanceof View) {
                viewGroup.removeView((View) obj);
                this.f14453b.add((EntryPhotoView) obj);
            }
        }

        public int getCount() {
            return EntryScrollView.this.f14443b.size();
        }

        public float getPageWidth(int i) {
            return 0.4f;
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            EntryPhotoView entryPhotoView = (EntryPhotoView) (this.f14453b.size() > 0 ? this.f14453b.remove(0) : View.inflate(EntryScrollView.this.getContext(), C3809l.m15792b(EntryScrollView.this.getContext(), "ksad_view_entryphoto"), null));
            viewGroup.addView(entryPhotoView);
            entryPhotoView.setTemplateData((AdTemplate) EntryScrollView.this.f14443b.get(i));
            entryPhotoView.mo24611a(i, EntryScrollView.this.f14442a.f14228e);
            entryPhotoView.setLikeViewPos(EntryScrollView.this.f14442a.f14227d);
            entryPhotoView.setOnClickListener(EntryScrollView.this.f14450i);
            if (i == getCount() - 1) {
                entryPhotoView.setLookMoreVisiable(0);
            } else {
                entryPhotoView.setLookMoreVisiable(8);
            }
            return entryPhotoView;
        }

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    public EntryScrollView(Context context) {
        super(context);
    }

    public EntryScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* renamed from: e */
    private void m17989e() {
        this.f14444c = (EntryViewPager) findViewById(C3809l.m15789a(getContext(), "ksad_entry_viewpager"));
        this.f14444c.setPageMargin(C3817t.m15862a(getContext(), 7.0f));
        this.f14444c.setOffscreenPageLimit(3);
        this.f14447f = (TextView) findViewById(C3809l.m15789a(getContext(), "ksad_entryscroll_sourceDescLeft"));
        this.f14448g = (TextView) findViewById(C3809l.m15789a(getContext(), "ksad_entryscroll_sourceDescRight"));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo24605a() {
        super.mo24605a();
        C4145c.m17163a(this.f14442a);
    }

    /* renamed from: a */
    public boolean mo24606a(C4329d dVar) {
        this.f14442a = dVar;
        for (AdTemplate adTemplate : this.f14442a.f14229f) {
            if (!adTemplate.needHide) {
                this.f14443b.add(adTemplate);
            }
        }
        if (this.f14443b.size() < 3) {
            setVisibility(8);
            return false;
        }
        setVisibility(0);
        this.f14445d = new C4406a();
        this.f14444c.setAdapter(this.f14445d);
        this.f14448g.setText(dVar.f14225b);
        this.f14447f.setText(dVar.f14225b);
        int i = dVar.f14226c;
        if (i == 0) {
            this.f14448g.setVisibility(8);
        } else if (i != 1) {
            this.f14448g.setVisibility(0);
        } else {
            this.f14448g.setVisibility(8);
            this.f14447f.setVisibility(0);
            return true;
        }
        this.f14447f.setVisibility(8);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        m17989e();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.f14449h != 0.0f) {
            i2 = MeasureSpec.makeMeasureSpec((int) (((float) MeasureSpec.getSize(i)) * this.f14449h), 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public void setOnfeedClickListener(OnFeedClickListener onFeedClickListener) {
        this.f14446e = onFeedClickListener;
    }

    public void setTouchIntercept(boolean z) {
        EntryViewPager entryViewPager = this.f14444c;
        if (entryViewPager != null) {
            entryViewPager.setDragMode(z);
        }
    }
}
