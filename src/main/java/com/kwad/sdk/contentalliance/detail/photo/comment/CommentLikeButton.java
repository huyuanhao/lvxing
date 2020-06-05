package com.kwad.sdk.contentalliance.detail.photo.comment;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ksad.lottie.LottieAnimationView;
import com.kwad.sdk.p306a.C3809l;
import com.kwad.sdk.p306a.C3811n;

public class CommentLikeButton extends LinearLayout implements OnClickListener {
    /* renamed from: a */
    private int f13301a = 1;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public ImageView f13302b = null;
    /* renamed from: c */
    private TextView f13303c = null;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public LottieAnimationView f13304d;
    /* renamed from: e */
    private long f13305e;
    /* renamed from: f */
    private C3949a f13306f;

    /* renamed from: com.kwad.sdk.contentalliance.detail.photo.comment.CommentLikeButton$a */
    public interface C3949a {
        /* renamed from: a */
        void mo23472a(int i);
    }

    public CommentLikeButton(Context context) {
        super(context);
        m16368c();
    }

    public CommentLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m16368c();
    }

    public CommentLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m16368c();
    }

    /* renamed from: a */
    private void m16365a(final int i) {
        this.f13304d.mo22762d();
        boolean z = i == 2;
        this.f13304d.mo22758a(true);
        this.f13304d.setAnimation(C3809l.m15798g(getContext(), z ? "ksad_detail_comment_like_anim" : "ksad_detail_comment_unlike_anim"));
        this.f13304d.setVisibility(0);
        this.f13304d.mo22755a((AnimatorListener) new AnimatorListenerAdapter() {
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                CommentLikeButton.this.setImageView(i);
                CommentLikeButton.this.f13302b.setVisibility(0);
                CommentLikeButton.this.f13304d.setVisibility(8);
            }

            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                CommentLikeButton.this.setImageView(i);
                CommentLikeButton.this.f13302b.setVisibility(0);
                CommentLikeButton.this.f13304d.setVisibility(8);
            }

            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                CommentLikeButton.this.f13302b.setVisibility(8);
            }
        });
        this.f13304d.mo22759b();
    }

    /* renamed from: c */
    private void m16368c() {
        LayoutInflater.from(getContext()).inflate(C3809l.m15792b(getContext(), "ksad_content_alliance_comment_like_button"), this, true);
        this.f13302b = (ImageView) findViewById(C3809l.m15789a(getContext(), "ksad_photo_comment_like_button_image"));
        this.f13303c = (TextView) findViewById(C3809l.m15789a(getContext(), "ksad_photo_comment_like_count_text"));
        this.f13304d = (LottieAnimationView) findViewById(C3809l.m15789a(getContext(), "ksad_photo_comment_like_animation_view"));
        setOnClickListener(this);
    }

    /* access modifiers changed from: private */
    public void setImageView(int i) {
        this.f13302b.setImageResource(C3809l.m15795d(getContext(), i == 1 ? "ksad_photo_comment_like_button_normal" : "ksad_photo_comment_like_button_selected"));
    }

    private void setImageViewWithAnimator(int i) {
        setImageView(i);
        m16365a(i);
    }

    /* renamed from: a */
    public void mo23459a(int i, long j) {
        this.f13301a = i;
        setImageView(i);
        this.f13304d.setVisibility(8);
        this.f13305e = j;
        setLikeCount(j);
        setLikeCountColor(i);
    }

    /* renamed from: a */
    public boolean mo23460a() {
        return this.f13301a == 2;
    }

    /* renamed from: b */
    public void mo23461b() {
        if (this.f13304d.mo22761c()) {
            this.f13304d.mo22762d();
        }
    }

    public int getLikeState() {
        return this.f13301a;
    }

    public void onClick(View view) {
        long j;
        if (mo23460a()) {
            setLikeState(1);
            C3949a aVar = this.f13306f;
            if (aVar != null) {
                aVar.mo23472a(1);
            }
            j = this.f13305e - 1;
        } else {
            setLikeState(2);
            C3949a aVar2 = this.f13306f;
            if (aVar2 != null) {
                aVar2.mo23472a(2);
            }
            j = this.f13305e + 1;
        }
        this.f13305e = j;
        setLikeCount(j);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mo23461b();
    }

    public void setLikeCount(long j) {
        this.f13303c.setText(C3811n.m15809a(j, ""));
    }

    public void setLikeCountColor(int i) {
        this.f13303c.setTextColor(i == 2 ? -46004 : -3750202);
    }

    public void setLikeState(int i) {
        this.f13301a = i;
        setImageViewWithAnimator(i);
        setLikeCountColor(i);
    }

    public void setLikeStateListener(C3949a aVar) {
        this.f13306f = aVar;
    }
}
