package com.kwad.sdk.contentalliance.home.viewpager.p316a;

import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.kwad.sdk.contentalliance.home.viewpager.C4028c;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.contentalliance.p309b.C3835b.C3844f;

/* renamed from: com.kwad.sdk.contentalliance.home.viewpager.a.b */
public class C4023b extends C4028c {
    /* access modifiers changed from: private */
    /* renamed from: b */
    public int f13497b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public int f13498c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public SlidePlayViewPager f13499d;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23338a() {
        super.mo23338a();
        this.f13499d = this.f13512a.f13515c;
        this.f13499d.mo23259a((OnPageChangeListener) new OnPageChangeListener() {
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
                C4023b.this.f13498c = i;
                if (C4023b.this.f13499d.getAdapter() != null) {
                    C4023b.this.f13499d.getAdapter().mo23610a(i, false);
                }
            }
        });
        this.f13499d.setOnPageScrollEndListener(new C3844f() {
            /* renamed from: a */
            public void mo23321a() {
                int currentItem = C4023b.this.f13512a.f13515c.getCurrentItem();
                if (C4023b.this.f13497b != currentItem) {
                    C4023b.this.f13497b = currentItem;
                    if (C4023b.this.f13499d.getAdapter() != null) {
                        C4023b.this.f13499d.getAdapter().mo23610a(currentItem, true);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo23421f() {
        super.mo23421f();
        if (this.f13499d.getAdapter() != null) {
            this.f13499d.getAdapter().mo23612a(true);
        }
    }
}
