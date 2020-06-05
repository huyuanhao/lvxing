package com.kwad.sdk.feed;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.p333g.C4143b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p342b.C4322a;
import com.kwad.sdk.core.response.p342b.C4324c;
import com.kwad.sdk.export.p347i.KsFeedAd;
import com.kwad.sdk.export.p347i.KsFeedAd.AdInteractionListener;
import com.kwad.sdk.feed.widget.C4415a;
import com.kwad.sdk.feed.widget.C4416b;
import com.kwad.sdk.feed.widget.C4422c;
import com.kwad.sdk.feed.widget.C4427d;
import com.kwad.sdk.feed.widget.C4430e;
import com.kwad.sdk.feed.widget.C4435f;
import com.kwad.sdk.feed.widget.C4436g;
import com.kwad.sdk.feed.widget.C4437h;
import com.kwad.sdk.feed.widget.base.C4419a;
import com.kwad.sdk.feed.widget.base.C4419a.C4421a;

/* renamed from: com.kwad.sdk.feed.a */
public class C4412a implements KsFeedAd {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public AdInteractionListener f14469a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public C4419a f14470b;
    /* renamed from: c */
    private boolean f14471c;
    /* renamed from: d */
    private AdTemplate f14472d;
    /* renamed from: e */
    private AdInfo f14473e;
    /* renamed from: f */
    private FeedType f14474f = FeedType.fromInt(this.f14472d.type);

    public C4412a(AdTemplate adTemplate) {
        this.f14472d = adTemplate;
        this.f14473e = C4324c.m17668e(adTemplate);
    }

    /* renamed from: a */
    private C4419a m18005a(Context context) {
        int i = C44142.f14476a[this.f14474f.ordinal()];
        if (i == 1) {
            return new C4435f(context);
        }
        if (i == 2) {
            return new C4416b(context);
        }
        if (i == 3) {
            return new C4427d(context);
        }
        if (i == 4) {
            return new C4436g(context);
        }
        if (i == 5) {
            return new C4437h(context);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getSingleImageView type is unknown:");
        sb.append(this.f14474f);
        C4065b.m16869d("KSFeedAdControl", sb.toString());
        return null;
    }

    /* renamed from: a */
    private void m18006a() {
        C4419a aVar = this.f14470b;
        if (aVar != null) {
            aVar.setAdClickListener(new C4421a() {
                /* renamed from: a */
                public void mo24709a() {
                    if (C4412a.this.f14469a != null) {
                        C4412a.this.f14469a.onAdClicked();
                    }
                }

                /* renamed from: b */
                public void mo24710b() {
                    if (C4412a.this.f14469a != null) {
                        C4412a.this.f14469a.onAdShow();
                    }
                }

                /* renamed from: c */
                public void mo24711c() {
                    if (C4412a.this.f14469a != null) {
                        C4412a.this.f14469a.onDislikeClicked();
                        if (C4412a.this.f14470b.getParent() instanceof ViewGroup) {
                            ((ViewGroup) C4412a.this.f14470b.getParent()).removeView(C4412a.this.f14470b);
                        }
                    }
                }
            });
        }
    }

    /* renamed from: b */
    private C4419a m18007b(Context context) {
        switch (this.f14474f) {
            case FEED_TYPE_TEXT_IMMERSE:
                return new C4435f(context);
            case FEED_TYPE_TEXT_ABOVE:
                return new C4416b(context);
            case FEED_TYPE_TEXT_BELOW:
                return new C4427d(context);
            case FEED_TYPE_TEXT_LEFT:
                return new C4436g(context);
            case FEED_TYPE_TEXT_RIGHT:
                return new C4437h(context);
            case FEED_TYPE_TEXT_ABOVE_GROUP:
                return new C4415a(context);
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("getVideoView type is unknown");
                sb.append(this.f14474f);
                C4065b.m16869d("KSFeedAdControl", sb.toString());
                return null;
        }
    }

    /* renamed from: c */
    private C4419a m18009c(Context context) {
        int i = C44142.f14476a[this.f14474f.ordinal()];
        if (i == 2) {
            return new C4422c(context);
        }
        if (i == 3) {
            return new C4430e(context);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getVideoView type is unknown:");
        sb.append(this.f14474f);
        C4065b.m16869d("KSFeedAdControl", sb.toString());
        return null;
    }

    /* renamed from: d */
    private C4419a m18010d(Context context) {
        int z = C4322a.m17658z(this.f14473e);
        if (z == 1) {
            return m18009c(context);
        }
        if (z == 2) {
            return m18005a(context);
        }
        if (z == 3) {
            return m18007b(context);
        }
        C4065b.m16869d("KSFeedAdControl", "getNewFeedView materialType is unknown");
        return null;
    }

    public int getECPM() {
        return C4322a.m17653u(this.f14473e);
    }

    public View getFeedView(Context context) {
        C4419a aVar = this.f14470b;
        if (aVar == null) {
            this.f14470b = m18010d(context);
        } else if (aVar.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.f14470b.getParent()).removeView(this.f14470b);
        }
        C4419a aVar2 = this.f14470b;
        if (aVar2 != null) {
            aVar2.mo24713a(this.f14472d);
            C4419a aVar3 = this.f14470b;
            if (aVar3 instanceof C4422c) {
                ((C4422c) aVar3).mo24726a(this.f14471c);
            } else if (aVar3 instanceof C4430e) {
                ((C4430e) aVar3).mo24730a(this.f14471c);
            }
            m18006a();
        }
        return this.f14470b;
    }

    public void setAdInteractionListener(AdInteractionListener adInteractionListener) {
        this.f14469a = adInteractionListener;
    }

    public void setBidEcpm(int i) {
        AdTemplate adTemplate = this.f14472d;
        adTemplate.mBidEcpm = i;
        C4143b.m17150m(adTemplate);
    }

    public void setVideoSoundEnable(boolean z) {
        this.f14471c = z;
    }
}
