package com.kwad.sdk.contentalliance.detail.photo.comment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.ksad.lottie.LottieAnimationView;
import com.kwad.sdk.core.p333g.C4145c;
import com.kwad.sdk.core.request.C4288g;
import com.kwad.sdk.core.request.C4288g.C4293a;
import com.kwad.sdk.core.request.ErrorCode;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CommentResponse;
import com.kwad.sdk.p306a.C3809l;
import com.kwad.sdk.p306a.C3817t;
import com.kwad.sdk.protocol.model.AdScene;
import java.util.ArrayList;
import java.util.List;

public class CommentListPanel extends LinearLayout {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public C3967d f13309a = null;
    /* renamed from: b */
    private RecyclerView f13310b;
    /* renamed from: c */
    private C3966c f13311c;
    /* renamed from: d */
    private List<C3957a> f13312d = new ArrayList();
    /* renamed from: e */
    private ImageButton f13313e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public LinearLayout f13314f;
    /* renamed from: g */
    private LottieAnimationView f13315g;
    /* access modifiers changed from: private */
    /* renamed from: h */
    public LinearLayout f13316h;
    /* renamed from: i */
    private LinearLayout f13317i;
    /* renamed from: j */
    private Button f13318j;
    /* access modifiers changed from: private */
    /* renamed from: k */
    public boolean f13319k;

    /* renamed from: com.kwad.sdk.contentalliance.detail.photo.comment.CommentListPanel$a */
    public interface C3957a {
        /* renamed from: a */
        void mo23414a();
    }

    public CommentListPanel(Context context) {
        super(context);
        m16378d();
    }

    public CommentListPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m16378d();
    }

    /* renamed from: d */
    private void m16378d() {
        LayoutInflater.from(getContext()).inflate(C3809l.m15792b(getContext(), "ksad_content_alliance_comment_list_panel"), this, true);
        this.f13317i = (LinearLayout) findViewById(C3809l.m15789a(getContext(), "ksad_photo_comment_list_space"));
        this.f13317i.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                CommentListPanel.this.m16383h();
            }
        });
        this.f13310b = (RecyclerView) C3817t.m15863a((View) this, "ksad_photo_comment_list_content");
        this.f13313e = (ImageButton) C3817t.m15863a((View) this, "ksad_photo_comment_list_panel_close");
        this.f13314f = (LinearLayout) C3817t.m15863a((View) this, "ksad_photo_comment_list_no_data_layout");
        this.f13316h = (LinearLayout) C3817t.m15863a((View) this, "ksad_photo_comment_list_no_network_layout");
        this.f13318j = (Button) C3817t.m15863a((View) this.f13316h, "ksad_photo_comment_list_no_network_retry");
        this.f13313e.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                CommentListPanel.this.m16383h();
            }
        });
        this.f13314f.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
            }
        });
        this.f13314f.setVisibility(8);
        this.f13310b.setVisibility(8);
        this.f13316h.setVisibility(8);
        this.f13316h.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
            }
        });
        setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
            }
        });
        this.f13318j.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                CommentListPanel.this.mo23473a();
            }
        });
        m16380e();
    }

    /* renamed from: e */
    private void m16380e() {
        this.f13315g = (LottieAnimationView) findViewById(C3809l.m15789a(getContext(), "ksad_photo_comment_loading_view"));
        int g = C3809l.m15798g(getContext(), "ksad_detail_loading_amin_top");
        this.f13315g.setVisibility(8);
        this.f13315g.setRepeatMode(1);
        this.f13315g.setRepeatCount(-1);
        this.f13315g.setAnimation(g);
    }

    /* renamed from: f */
    private void m16381f() {
        if (this.f13315g.getVisibility() != 0 || !this.f13315g.mo22761c()) {
            this.f13315g.setVisibility(0);
            if (!this.f13315g.mo22761c()) {
                this.f13315g.mo22759b();
            }
            this.f13316h.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m16382g() {
        if (this.f13315g.mo22761c()) {
            this.f13315g.mo22762d();
        }
        this.f13315g.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m16383h() {
        for (C3957a a : this.f13312d) {
            a.mo23414a();
        }
    }

    /* renamed from: a */
    public void mo23473a() {
        this.f13310b.setVisibility(8);
        m16381f();
        C3967d dVar = this.f13309a;
        if (dVar == null) {
            this.f13314f.setVisibility(0);
            this.f13316h.setVisibility(8);
            m16382g();
            return;
        }
        if (!this.f13319k) {
            this.f13319k = true;
            long c = dVar.mo23507c();
            long b = this.f13309a.mo23506b();
            new C4288g().mo24416a(new AdScene(c), b, (C4293a) new C4293a() {
                /* renamed from: a */
                public void mo23488a(int i, String str) {
                    CommentListPanel.this.m16382g();
                    if (ErrorCode.ERROR_DATA_EMPTY.errorCode == i) {
                        CommentListPanel.this.f13314f.setVisibility(0);
                        C4145c.m17173f(CommentListPanel.this.f13309a.mo23504a(), CommentListPanel.this.f13309a.mo23508d());
                    } else {
                        CommentListPanel.this.f13316h.setVisibility(0);
                    }
                    CommentListPanel.this.f13319k = false;
                }

                /* renamed from: a */
                public void mo23489a(CommentResponse commentResponse) {
                    CommentListPanel.this.m16382g();
                    CommentListPanel.this.f13314f.setVisibility(8);
                    CommentListPanel.this.f13316h.setVisibility(8);
                    CommentListPanel.this.mo23476a(commentResponse);
                    CommentListPanel.this.f13319k = false;
                }
            });
        }
    }

    /* renamed from: a */
    public void mo23474a(C3957a aVar) {
        this.f13312d.add(aVar);
    }

    /* renamed from: a */
    public void mo23475a(AdTemplate adTemplate, long j) {
        this.f13309a = new C3967d(adTemplate, j);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23476a(CommentResponse commentResponse) {
        this.f13310b.setItemAnimator(null);
        this.f13310b.setLayoutManager(mo23477b());
        this.f13311c = mo23478b(commentResponse);
        this.f13310b.setAdapter(this.f13311c);
        this.f13310b.setVisibility(0);
        C4145c.m17173f(this.f13309a.mo23504a(), this.f13309a.mo23508d());
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public LayoutManager mo23477b() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        return linearLayoutManager;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C3966c mo23478b(CommentResponse commentResponse) {
        this.f13309a.mo23505a(commentResponse.rootComments);
        return new C3966c(this.f13310b, this.f13309a);
    }

    /* renamed from: b */
    public void mo23479b(C3957a aVar) {
        if (this.f13312d.contains(aVar)) {
            this.f13312d.remove(aVar);
        }
    }

    /* renamed from: c */
    public void mo23480c() {
        C3966c cVar = this.f13311c;
        long a = cVar != null ? cVar.mo23501a() : 0;
        C3967d dVar = this.f13309a;
        if (dVar != null) {
            C4145c.m17172e(dVar.mo23504a(), this.f13309a.mo23508d(), a);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
            if (r0 != 2) goto L_0x001a;
     */
    public boolean dispatchTouchEvent(android.view.MotionEvent r4) {
        /*
        r3 = this;
        int r0 = r4.getAction()
        r1 = 1
        if (r0 == 0) goto L_0x0013
        if (r0 == r1) goto L_0x000d
        r2 = 2
        if (r0 == r2) goto L_0x0013
        goto L_0x001a
    L_0x000d:
        android.view.ViewParent r0 = r3.getParent()
        r1 = 0
        goto L_0x0017
    L_0x0013:
        android.view.ViewParent r0 = r3.getParent()
    L_0x0017:
        r0.requestDisallowInterceptTouchEvent(r1)
    L_0x001a:
        boolean r4 = super.dispatchTouchEvent(r4)
        return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.contentalliance.detail.photo.comment.CommentListPanel.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }
}
