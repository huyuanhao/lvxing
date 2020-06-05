package com.kwad.sdk.contentalliance.detail.photo.comment;

import android.content.Context;
import android.graphics.Color;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kwad.sdk.contentalliance.detail.photo.comment.CommentLikeButton.C3949a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.p333g.C4145c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoComment;
import com.kwad.sdk.p306a.C3809l;
import com.kwad.sdk.p306a.C3811n;
import com.kwad.sdk.p306a.C3817t;

/* renamed from: com.kwad.sdk.contentalliance.detail.photo.comment.a */
public class C3958a extends RelativeLayout {
    /* renamed from: a */
    boolean f13327a = false;
    /* renamed from: b */
    private RelativeLayout f13328b;
    /* renamed from: c */
    private TextView f13329c;
    /* renamed from: d */
    private ImageView f13330d;
    /* renamed from: e */
    private LinearLayout f13331e;
    /* renamed from: f */
    private TextView f13332f;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public TextView f13333g;
    /* renamed from: h */
    private CommentLikeButton f13334h;
    /* access modifiers changed from: private */
    /* renamed from: i */
    public C3964a f13335i;
    /* renamed from: j */
    private CharSequence f13336j;

    /* renamed from: com.kwad.sdk.contentalliance.detail.photo.comment.a$a */
    public static class C3964a {
        /* renamed from: a */
        public PhotoComment f13342a;
        /* renamed from: b */
        public AdTemplate f13343b;
        /* renamed from: c */
        public long f13344c;
        /* renamed from: d */
        public boolean f13345d = false;
        /* renamed from: e */
        public int f13346e;
        /* renamed from: f */
        public boolean f13347f;
        /* renamed from: g */
        public String f13348g;
    }

    public C3958a(Context context) {
        super(context);
        m16395a();
    }

    /* renamed from: a */
    private void m16395a() {
        C4065b.m16863a("CommentItemView", "initView");
        LayoutInflater.from(getContext()).inflate(C3809l.m15792b(getContext(), "ksad_photo_comment_item"), this, true);
        this.f13328b = (RelativeLayout) C3817t.m15863a((View) this, "ksad_photo_comment_frame");
        this.f13330d = (ImageView) C3817t.m15863a((View) this, "ksad_photo_comment_item_avatar");
        this.f13329c = (TextView) C3817t.m15863a((View) this, "ksad_photo_comment_item_name");
        this.f13331e = (LinearLayout) C3817t.m15863a((View) this, "ksad_photo_comment_item_content_frame");
        this.f13333g = (TextView) C3817t.m15863a((View) this.f13331e, "ksad_photo_comment_item_comment");
        this.f13333g.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                C3958a.this.m16400b();
                C3958a.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
        this.f13332f = (TextView) C3817t.m15863a((View) this.f13331e, "ksad_photo_comment_item_created_time");
        this.f13334h = (CommentLikeButton) C3817t.m15863a((View) this, "ksad_photo_comment_item_like_frame");
    }

    /* renamed from: a */
    private void m16397a(PhotoComment photoComment) {
        if (photoComment != null) {
            setName(photoComment.author_name);
            setAuthorIcon(photoComment.headurl);
            setCommentTime(photoComment.timestamp);
            mo23491a(C3811n.m15816c(photoComment.content), photoComment.timestamp);
            boolean c = C3965b.m16411c(photoComment.photo_id, photoComment.comment_id);
            int i = c ? 2 : 1;
            long j = photoComment.likedCount;
            if (c) {
                j++;
            }
            mo23490a(i, j);
        }
    }

    /* renamed from: b */
    private SpannableStringBuilder m16398b(String str, long j) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        this.f13333g.measure(makeMeasureSpec, makeMeasureSpec);
        int width = this.f13333g.getWidth() - C3817t.m15862a(getContext(), 4.0f);
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize((float) C3817t.m15862a(getContext(), 12.0f));
        StringBuilder sb = new StringBuilder();
        String str2 = "  ";
        sb.append(str2);
        sb.append(C3811n.m15810a(getContext(), j));
        float measureText = textPaint.measureText(sb.toString()) + ((float) C3817t.m15862a(getContext(), 6.0f));
        float measureText2 = this.f13333g.getPaint().measureText(str);
        float a = measureText + measureText2 + ((float) C3817t.m15862a(getContext(), 4.0f));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int i = (int) a;
        int i2 = (i / width) + 1;
        int i3 = i % width;
        int i4 = ((int) measureText2) % width;
        if (!(((float) (width * 3)) - a > 0.0f) || i2 > 3 || ((float) i4) + measureText >= ((float) width) || i3 >= width) {
            this.f13332f.setVisibility(0);
        } else {
            spannableStringBuilder.append(str2);
            spannableStringBuilder.append(C3811n.m15810a(getContext(), j));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#C6C6C6")), str.length(), spannableStringBuilder.length(), 17);
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(12, true), str.length(), spannableStringBuilder.length(), 17);
            this.f13332f.setVisibility(8);
        }
        return spannableStringBuilder;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m16400b() {
        C3964a aVar = this.f13335i;
        if (aVar == null) {
            C4065b.m16863a("CommentItemView", "layoutCommentSpan mCommentItemData == null");
            return;
        }
        if (aVar.f13345d) {
            setCommentText(m16404e());
            m16403d();
        } else {
            m16402c();
        }
    }

    /* renamed from: c */
    private void m16402c() {
        if (this.f13327a) {
            setCommentText(this.f13336j);
            return;
        }
        Layout layout = this.f13333g.getLayout();
        if (layout != null) {
            C3964a aVar = this.f13335i;
            if (!(aVar == null || aVar.f13342a == null)) {
                int lineCount = layout.getLineCount();
                if (lineCount > 3 || layout.getEllipsisCount(lineCount - 1) != 0) {
                    setCommentText(m16405f());
                    this.f13335i.f13347f = true;
                    m16403d();
                    this.f13332f.setVisibility(0);
                } else if (!this.f13335i.f13347f) {
                    setCommentText(m16398b(this.f13335i.f13342a.content, this.f13335i.f13342a.timestamp));
                    this.f13333g.setOnClickListener(null);
                    this.f13327a = true;
                }
            }
        }
    }

    /* renamed from: d */
    private void m16403d() {
        this.f13333g.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C3958a.this.f13333g.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
                    public void onGlobalLayout() {
                        C3958a.this.m16400b();
                        C3958a.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });
                if (C3958a.this.f13335i != null && C3958a.this.f13335i.f13342a != null) {
                    if (!C3958a.this.f13335i.f13345d) {
                        C3958a.this.f13333g.setMaxLines(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                        C3958a aVar = C3958a.this;
                        aVar.setCommentText(aVar.f13335i.f13342a.content);
                        C3958a.this.f13335i.f13345d = true;
                        return;
                    }
                    C3958a.this.f13333g.setMaxLines(3);
                    C3958a.this.f13335i.f13345d = false;
                    C3958a aVar2 = C3958a.this;
                    aVar2.mo23491a(aVar2.f13335i.f13342a.content, C3958a.this.f13335i.f13342a.timestamp);
                }
            }
        });
    }

    /* renamed from: e */
    private SpannableStringBuilder m16404e() {
        C3964a aVar = this.f13335i;
        if (aVar == null || aVar.f13342a == null) {
            return new SpannableStringBuilder();
        }
        if (this.f13333g.getLayout() == null) {
            return new SpannableStringBuilder();
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f13335i.f13342a.content);
        spannableStringBuilder.append(" 收起");
        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#A2B6C2")), spannableStringBuilder.length() - 2, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    /* renamed from: f */
    private SpannableStringBuilder m16405f() {
        C3964a aVar = this.f13335i;
        if (aVar == null || aVar.f13342a == null) {
            return new SpannableStringBuilder();
        }
        Layout layout = this.f13333g.getLayout();
        if (layout == null) {
            return new SpannableStringBuilder();
        }
        int lineCount = layout.getLineCount();
        String str = this.f13335i.f13342a.content;
        int length = (str.length() - layout.getEllipsisCount(lineCount - 1)) - 6;
        if (length > 0 && length <= str.length()) {
            str = str.substring(0, length).concat("... 更多");
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#A2B6C2")), str.length() - 2, str.length(), 17);
        return spannableStringBuilder;
    }

    /* renamed from: a */
    public void mo23490a(int i, long j) {
        this.f13334h.mo23459a(i, j);
        this.f13334h.setLikeStateListener(new C3949a() {
            /* renamed from: a */
            public void mo23472a(int i) {
                if (C3958a.this.f13335i != null && C3958a.this.f13335i.f13342a != null) {
                    if (i == 2) {
                        C3965b.m16409a(C3958a.this.f13335i.f13342a.photo_id, C3958a.this.f13335i.f13342a.comment_id);
                        C4145c.m17168c(C3958a.this.f13335i.f13343b, C3958a.this.f13335i.f13344c, C3958a.this.f13335i.f13342a.comment_id);
                        return;
                    }
                    C3965b.m16410b(C3958a.this.f13335i.f13342a.photo_id, C3958a.this.f13335i.f13342a.comment_id);
                    C4145c.m17170d(C3958a.this.f13335i.f13343b, C3958a.this.f13335i.f13344c, C3958a.this.f13335i.f13342a.comment_id);
                }
            }
        });
    }

    /* renamed from: a */
    public void mo23491a(String str, long j) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        this.f13332f.setVisibility(8);
        boolean z = this.f13335i.f13345d;
        setCommentText(spannableStringBuilder);
        this.f13333g.post(new Runnable() {
            public void run() {
                C3958a.this.m16400b();
            }
        });
    }

    public void setAuthorIcon(String str) {
        KSImageLoader.loadAuthorCircleIcon(this.f13330d, str);
    }

    /* access modifiers changed from: 0000 */
    public void setCommentText(CharSequence charSequence) {
        this.f13336j = charSequence;
        this.f13333g.setText(charSequence);
    }

    public void setCommentTime(long j) {
        TextView textView = this.f13332f;
        textView.setText(C3811n.m15810a(textView.getContext(), j));
    }

    public void setData(C3964a aVar) {
        TextView textView;
        int i;
        StringBuilder sb = new StringBuilder();
        sb.append("bindCommentItemViewData commentHolderData=");
        sb.append(aVar);
        sb.append(" commentPosition=");
        sb.append(aVar.f13346e);
        sb.append(" isCommentOpen=");
        sb.append(aVar.f13345d);
        C4065b.m16863a("CommentItemView", sb.toString());
        this.f13327a = false;
        this.f13335i = aVar;
        if (this.f13335i.f13345d) {
            textView = this.f13333g;
            i = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        } else {
            textView = this.f13333g;
            i = 3;
        }
        textView.setMaxLines(i);
        m16397a(this.f13335i.f13342a);
    }

    public void setName(String str) {
        this.f13329c.setText(str);
    }
}
