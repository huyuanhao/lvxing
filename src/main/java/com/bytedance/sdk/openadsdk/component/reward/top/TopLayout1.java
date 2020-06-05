package com.bytedance.sdk.openadsdk.component.reward.top;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.utils.ResourceHelp;
import com.bytedance.sdk.openadsdk.utils.UIUtils;

public class TopLayout1 extends FrameLayout implements ITopLayout<TopLayout1> {
    /* renamed from: a */
    private TextView f7005a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public ImageView f7006b;
    /* renamed from: c */
    private TextView f7007c;
    /* renamed from: d */
    private boolean f7008d;
    /* renamed from: e */
    private MaterialMeta f7009e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public boolean f7010f;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public ITopListener f7011g;

    public void setShowDislike(boolean z) {
    }

    public TopLayout1(Context context) {
        this(context, null);
    }

    public TopLayout1(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopLayout1(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* renamed from: a */
    public TopLayout1 mo15162a(boolean z, MaterialMeta kVar) {
        int i;
        this.f7008d = z;
        this.f7009e = kVar;
        if (this.f7008d) {
            i = ResourceHelp.m11936f(getContext(), "tt_top_reward_1");
        } else {
            i = ResourceHelp.m11936f(getContext(), "tt_top_full_1");
        }
        LayoutInflater.from(getContext()).inflate(i, this, true);
        String str = "tt_top_skip";
        String str2 = "tt_top_mute";
        String str3 = "tt_top_countdown";
        if (this.f7008d) {
            this.f7005a = (TextView) findViewById(ResourceHelp.m11935e(getContext(), str3));
            this.f7006b = (ImageView) findViewById(ResourceHelp.m11935e(getContext(), str2));
            this.f7007c = (TextView) findViewById(ResourceHelp.m11935e(getContext(), str));
        } else {
            this.f7005a = (TextView) findViewById(ResourceHelp.m11935e(getContext(), str3));
            this.f7006b = (ImageView) findViewById(ResourceHelp.m11935e(getContext(), str2));
            this.f7007c = (TextView) findViewById(ResourceHelp.m11935e(getContext(), str));
        }
        m8806c();
        return this;
    }

    /* renamed from: c */
    private void m8806c() {
        ImageView imageView = this.f7006b;
        if (imageView != null) {
            imageView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    int i;
                    TopLayout1 topLayout1 = TopLayout1.this;
                    topLayout1.f7010f = !topLayout1.f7010f;
                    if (TopLayout1.this.f7010f) {
                        i = ResourceHelp.m11934d(TopLayout1.this.getContext(), "tt_mute");
                    } else {
                        i = ResourceHelp.m11934d(TopLayout1.this.getContext(), "tt_unmute");
                    }
                    TopLayout1.this.f7006b.setImageResource(i);
                    if (TopLayout1.this.f7011g != null) {
                        TopLayout1.this.f7011g.mo14932b(view);
                    }
                }
            });
        }
        TextView textView = this.f7007c;
        if (textView != null) {
            textView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (TopLayout1.this.f7011g != null) {
                        TopLayout1.this.f7011g.mo14931a(view);
                    }
                }
            });
        }
    }

    public void setShowSkip(boolean z) {
        TextView textView = this.f7007c;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 8);
        }
    }

    public void setSkipEnable(boolean z) {
        TextView textView = this.f7007c;
        if (textView != null) {
            textView.setEnabled(z);
            this.f7007c.setClickable(z);
        }
    }

    public void setShowSound(boolean z) {
        ImageView imageView = this.f7006b;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    public void setSoundMute(boolean z) {
        int i;
        this.f7010f = z;
        if (this.f7010f) {
            i = ResourceHelp.m11934d(getContext(), "tt_mute");
        } else {
            i = ResourceHelp.m11934d(getContext(), "tt_unmute");
        }
        this.f7006b.setImageResource(i);
    }

    public void setShowCountDown(boolean z) {
        TextView textView = this.f7005a;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 8);
        }
    }

    /* renamed from: a */
    public void mo15164a(CharSequence charSequence, CharSequence charSequence2) {
        float f;
        if (this.f7005a != null && !TextUtils.isEmpty(charSequence)) {
            this.f7005a.setText(charSequence);
        }
        if (this.f7007c != null && !TextUtils.isEmpty(charSequence2)) {
            this.f7007c.setText(charSequence2);
            if (!this.f7008d) {
                LayoutParams layoutParams = this.f7007c.getLayoutParams();
                if (charSequence2.length() <= 2) {
                    f = UIUtils.m12048a(getContext(), 53.0f);
                } else {
                    f = UIUtils.m12048a(getContext(), 96.0f);
                }
                layoutParams.width = (int) f;
                this.f7007c.setLayoutParams(layoutParams);
            }
        }
    }

    public void setListener(ITopListener bVar) {
        this.f7011g = bVar;
    }

    /* renamed from: a */
    public void mo15163a() {
        TextView textView = this.f7007c;
        if (textView != null) {
            textView.performClick();
        }
    }

    /* renamed from: b */
    public void mo15165b() {
        ImageView imageView = this.f7006b;
        if (imageView != null) {
            imageView.performClick();
        }
    }
}
