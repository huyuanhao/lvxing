package com.kwad.sdk.contentalliance.detail.photo.p314c;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ksad.lottie.LottieAnimationView;
import com.kwad.sdk.p306a.C3809l;
import com.kwad.sdk.p306a.C3811n;

/* renamed from: com.kwad.sdk.contentalliance.detail.photo.c.h */
public class C3945h extends LinearLayout {
    /* renamed from: a */
    private int f13295a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public ImageView f13296b;
    /* renamed from: c */
    private TextView f13297c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public LottieAnimationView f13298d;

    public C3945h(Context context) {
        this(context, null);
    }

    public C3945h(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13295a = 1;
        this.f13296b = null;
        this.f13297c = null;
        m16356c();
    }

    /* renamed from: a */
    private void m16353a(final int i) {
        this.f13298d.mo22762d();
        boolean z = i == 2;
        this.f13298d.setSpeed(z ? 1.2f : 1.0f);
        this.f13298d.mo22758a(true);
        this.f13298d.setAnimation(C3809l.m15798g(getContext(), z ? "ksad_detail_right_button_like_anim" : "ksad_detail_right_button_unlike_anim"));
        this.f13298d.setVisibility(0);
        this.f13298d.mo22755a((AnimatorListener) new AnimatorListenerAdapter() {
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                C3945h.this.setImageView(i);
                C3945h.this.f13296b.setVisibility(0);
                C3945h.this.f13298d.setVisibility(8);
            }

            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                C3945h.this.setImageView(i);
                C3945h.this.f13296b.setVisibility(0);
                C3945h.this.f13298d.setVisibility(8);
            }

            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                C3945h.this.f13296b.setVisibility(8);
            }
        });
        this.f13298d.mo22759b();
    }

    /* renamed from: c */
    private void m16356c() {
        LayoutInflater.from(getContext()).inflate(C3809l.m15792b(getContext(), "ksad_content_alliance_photo_like_button"), this, true);
        this.f13296b = (ImageView) findViewById(C3809l.m15789a(getContext(), "ksad_photo_like_button_image"));
        this.f13297c = (TextView) findViewById(C3809l.m15789a(getContext(), "ksad_photo_like_count_text"));
        this.f13298d = (LottieAnimationView) findViewById(C3809l.m15789a(getContext(), "ksad_photo_like_animation_view"));
    }

    /* access modifiers changed from: private */
    public void setImageView(int i) {
        this.f13296b.setImageResource(C3809l.m15795d(getContext(), i == 1 ? "ksad_photo_like_button_normal" : "ksad_photo_like_button_selected"));
    }

    private void setImageViewWithAnimator(int i) {
        setImageView(i);
        m16353a(i);
    }

    /* renamed from: a */
    public void mo23449a(int i, long j) {
        this.f13295a = i;
        setImageView(i);
        setLikeCount(j);
    }

    /* renamed from: a */
    public boolean mo23450a() {
        return this.f13295a == 2;
    }

    /* renamed from: b */
    public void mo23451b() {
        if (this.f13298d.mo22761c()) {
            this.f13298d.mo22762d();
        }
    }

    public int getLikeState() {
        return this.f13295a;
    }

    public void setLikeCount(long j) {
        this.f13297c.setText(C3811n.m15809a(j, "0"));
    }

    public void setLikeState(int i) {
        this.f13295a = i;
        setImageViewWithAnimator(i);
    }
}
