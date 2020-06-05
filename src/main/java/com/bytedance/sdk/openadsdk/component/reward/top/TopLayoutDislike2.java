package com.bytedance.sdk.openadsdk.component.reward.top;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.utils.ResourceHelp;

public class TopLayoutDislike2 extends FrameLayout implements ITopLayout<TopLayoutDislike2> {
    /* renamed from: a */
    private View f7014a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public ImageView f7015b;
    /* renamed from: c */
    private TextView f7016c;
    /* renamed from: d */
    private boolean f7017d;
    /* renamed from: e */
    private MaterialMeta f7018e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public boolean f7019f;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public ITopListener f7020g;
    /* renamed from: h */
    private CharSequence f7021h;
    /* renamed from: i */
    private CharSequence f7022i;

    public void setShowCountDown(boolean z) {
    }

    public TopLayoutDislike2(Context context) {
        this(context, null);
    }

    public TopLayoutDislike2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopLayoutDislike2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        String str = "";
        this.f7021h = str;
        this.f7022i = str;
    }

    /* renamed from: a */
    public TopLayoutDislike2 mo15175a(boolean z, MaterialMeta kVar) {
        this.f7017d = z;
        this.f7018e = kVar;
        LayoutInflater.from(getContext()).inflate(ResourceHelp.m11936f(getContext(), "tt_top_reward_dislike_2"), this, true);
        this.f7014a = findViewById(ResourceHelp.m11935e(getContext(), "tt_top_dislike"));
        this.f7015b = (ImageView) findViewById(ResourceHelp.m11935e(getContext(), "tt_top_mute"));
        this.f7016c = (TextView) findViewById(ResourceHelp.m11935e(getContext(), "tt_top_skip"));
        this.f7016c.setVisibility(0);
        this.f7016c.setText("");
        this.f7016c.setEnabled(false);
        this.f7016c.setClickable(false);
        m8815c();
        return this;
    }

    /* renamed from: c */
    private void m8815c() {
        View view = this.f7014a;
        if (view != null) {
            view.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (TopLayoutDislike2.this.f7020g != null) {
                        TopLayoutDislike2.this.f7020g.mo14933c(view);
                    }
                }
            });
        }
        ImageView imageView = this.f7015b;
        if (imageView != null) {
            imageView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    int i;
                    TopLayoutDislike2 topLayoutDislike2 = TopLayoutDislike2.this;
                    topLayoutDislike2.f7019f = !topLayoutDislike2.f7019f;
                    if (TopLayoutDislike2.this.f7019f) {
                        i = ResourceHelp.m11934d(TopLayoutDislike2.this.getContext(), "tt_mute");
                    } else {
                        i = ResourceHelp.m11934d(TopLayoutDislike2.this.getContext(), "tt_unmute");
                    }
                    TopLayoutDislike2.this.f7015b.setImageResource(i);
                    if (TopLayoutDislike2.this.f7020g != null) {
                        TopLayoutDislike2.this.f7020g.mo14932b(view);
                    }
                }
            });
        }
        TextView textView = this.f7016c;
        if (textView != null) {
            textView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (TopLayoutDislike2.this.f7020g != null) {
                        TopLayoutDislike2.this.f7020g.mo14931a(view);
                    }
                }
            });
        }
    }

    public void setShowSkip(boolean z) {
        TextView textView = this.f7016c;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 8);
        }
    }

    public void setSkipEnable(boolean z) {
        TextView textView = this.f7016c;
        if (textView != null) {
            textView.setEnabled(z);
            this.f7016c.setClickable(z);
        }
    }

    public void setShowSound(boolean z) {
        ImageView imageView = this.f7015b;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    public void setSoundMute(boolean z) {
        int i;
        this.f7019f = z;
        if (this.f7019f) {
            i = ResourceHelp.m11934d(getContext(), "tt_mute");
        } else {
            i = ResourceHelp.m11934d(getContext(), "tt_unmute");
        }
        this.f7015b.setImageResource(i);
    }

    /* renamed from: a */
    public void mo15164a(CharSequence charSequence, CharSequence charSequence2) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.f7021h = charSequence;
        }
        if (!TextUtils.isEmpty(charSequence2)) {
            this.f7022i = charSequence2;
        }
        if (this.f7016c != null) {
            CharSequence charSequence3 = this.f7021h;
            if (!TextUtils.isEmpty(this.f7022i)) {
                StringBuilder sb = new StringBuilder();
                sb.append(charSequence3);
                sb.append(" | ");
                sb.append(this.f7022i);
                charSequence3 = sb.toString();
            }
            this.f7016c.setText(charSequence3);
        }
    }

    public void setShowDislike(boolean z) {
        View view = this.f7014a;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public void setListener(ITopListener bVar) {
        this.f7020g = bVar;
    }

    /* renamed from: a */
    public void mo15163a() {
        TextView textView = this.f7016c;
        if (textView != null) {
            textView.performClick();
        }
    }

    /* renamed from: b */
    public void mo15165b() {
        ImageView imageView = this.f7015b;
        if (imageView != null) {
            imageView.performClick();
        }
    }
}
