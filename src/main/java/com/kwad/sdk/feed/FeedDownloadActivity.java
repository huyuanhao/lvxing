package com.kwad.sdk.feed;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.kwad.sdk.core.download.p323a.C4087a;
import com.kwad.sdk.core.download.p323a.C4087a.C4088a;
import com.kwad.sdk.core.download.p323a.C4089b;
import com.kwad.sdk.core.p333g.C4143b;
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p342b.C4322a;
import com.kwad.sdk.core.response.p342b.C4324c;
import com.kwad.sdk.core.view.KsAdContainer;
import com.kwad.sdk.feed.widget.base.C4419a.C4421a;
import com.kwad.sdk.nativead.KsAppDownloadListener;
import com.kwad.sdk.p306a.C3809l;
import com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppPortraitVertical;
import java.io.Serializable;

public class FeedDownloadActivity extends Activity implements OnClickListener {
    /* renamed from: a */
    private static C4421a f14460a;
    /* renamed from: b */
    private AdTemplate f14461b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public AdInfo f14462c;
    /* renamed from: d */
    private C4089b f14463d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public TailFrameBarAppPortraitVertical f14464e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public TextProgressBar f14465f;
    /* renamed from: g */
    private KsAdContainer f14466g;

    /* renamed from: a */
    public static void m17995a(Context context, AdTemplate adTemplate, C4421a aVar) {
        Intent intent = new Intent(context, FeedDownloadActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("key_template", adTemplate);
        f14460a = aVar;
        context.startActivity(intent);
    }

    /* renamed from: a */
    private boolean m17996a() {
        Serializable serializableExtra = getIntent().getSerializableExtra("key_template");
        if (!(serializableExtra instanceof AdTemplate)) {
            finish();
            return false;
        }
        this.f14461b = (AdTemplate) serializableExtra;
        this.f14462c = C4324c.m17668e(this.f14461b);
        return true;
    }

    /* renamed from: b */
    private void m17998b() {
        this.f14466g = (KsAdContainer) findViewById(C3809l.m15789a(this, "ksad_container"));
        this.f14466g.setOnClickListener(this);
        this.f14464e = (TailFrameBarAppPortraitVertical) findViewById(C3809l.m15789a(this, "ksad_download_container"));
        this.f14464e.mo24863a(this.f14461b);
        this.f14464e.mo24862a(C4324c.m17668e(this.f14461b));
        this.f14464e.setVisibility(0);
        this.f14465f = this.f14464e.getTextProgressBar();
        m18000c();
    }

    /* renamed from: c */
    private void m18000c() {
        this.f14463d = new C4089b(this.f14461b, null, new KsAppDownloadListener() {
            public void onDownloadFinished() {
                FeedDownloadActivity.this.f14464e.mo24862a(FeedDownloadActivity.this.f14462c);
                FeedDownloadActivity.this.f14465f.mo24328a(C4322a.m17630a(), FeedDownloadActivity.this.f14465f.getMax());
            }

            public void onIdle() {
                FeedDownloadActivity.this.f14464e.mo24862a(FeedDownloadActivity.this.f14462c);
                FeedDownloadActivity.this.f14465f.mo24328a(C4322a.m17650r(FeedDownloadActivity.this.f14462c), FeedDownloadActivity.this.f14465f.getMax());
            }

            public void onInstalled() {
                FeedDownloadActivity.this.f14464e.mo24862a(FeedDownloadActivity.this.f14462c);
                FeedDownloadActivity.this.f14465f.mo24328a(C4322a.m17634b(), FeedDownloadActivity.this.f14465f.getMax());
            }

            public void onProgressUpdate(int i) {
                FeedDownloadActivity.this.f14464e.mo24862a(FeedDownloadActivity.this.f14462c);
                FeedDownloadActivity.this.f14465f.mo24328a(C4322a.m17631a(i), i);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m18001d() {
        C4143b.m17122a(this.f14461b, this.f14466g.getTouchCoords());
        C4421a aVar = f14460a;
        if (aVar != null) {
            aVar.mo24709a();
        }
    }

    public void onClick(View view) {
        C4087a.m16967a(view.getContext(), this.f14461b, new C4088a() {
            /* renamed from: a */
            public void mo23360a() {
                FeedDownloadActivity.this.m18001d();
            }
        }, this.f14463d);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!m17996a()) {
            finish();
            return;
        }
        setContentView(C3809l.m15792b(this, "ksad_activity_feed_download"));
        m17998b();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }
}
