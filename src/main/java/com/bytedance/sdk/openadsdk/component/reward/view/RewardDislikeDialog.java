package com.bytedance.sdk.openadsdk.component.reward.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.dislike.TTDislikeDialogDefault.C2394b;
import com.bytedance.sdk.openadsdk.dislike.TTDislikeListView;
import com.bytedance.sdk.openadsdk.utils.ResourceHelp;
import com.bytedance.sdk.openadsdk.utils.UIUtils;
import java.util.ArrayList;

public class RewardDislikeDialog extends FrameLayout {
    /* renamed from: a */
    private View f7032a;
    /* renamed from: b */
    private TTDislikeListView f7033b;
    /* renamed from: c */
    private TTDislikeListView f7034c;
    /* renamed from: d */
    private RelativeLayout f7035d;
    /* renamed from: e */
    private View f7036e;
    /* renamed from: f */
    private C2394b f7037f;
    /* renamed from: g */
    private C2394b f7038g;
    /* access modifiers changed from: private */
    /* renamed from: h */
    public MaterialMeta f7039h;
    /* access modifiers changed from: private */
    /* renamed from: i */
    public C2167a f7040i;
    /* renamed from: j */
    private boolean f7041j;

    /* renamed from: com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeDialog$a */
    public interface C2167a {
        /* renamed from: a */
        void mo14876a(int i, FilterWord filterWord);

        /* renamed from: a */
        void mo14877a(View view);

        /* renamed from: b */
        void mo14878b(View view);

        /* renamed from: c */
        void mo14879c(View view);
    }

    public RewardDislikeDialog(Context context, MaterialMeta kVar) {
        this(context);
        this.f7039h = kVar;
        m8853c();
    }

    public RewardDislikeDialog(Context context) {
        this(context, (AttributeSet) null);
    }

    public RewardDislikeDialog(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RewardDislikeDialog(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7041j = false;
        m8847a(context, attributeSet);
    }

    /* renamed from: a */
    private void m8847a(Context context, AttributeSet attributeSet) {
        setClickable(true);
        setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                RewardDislikeDialog.this.mo15192b();
            }
        });
        setBackgroundColor(Color.parseColor("#80000000"));
        this.f7032a = LayoutInflater.from(context).inflate(ResourceHelp.m11936f(context, "tt_dislike_dialog_layout"), this, false);
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.leftMargin = UIUtils.m12079c(getContext(), 20.0f);
        layoutParams.rightMargin = UIUtils.m12079c(getContext(), 20.0f);
        this.f7032a.setLayoutParams(layoutParams);
        this.f7032a.setClickable(true);
        m8854d();
        m8853c();
    }

    /* renamed from: c */
    private void m8853c() {
        if (this.f7039h != null) {
            LayoutInflater from = LayoutInflater.from(getContext());
            this.f7037f = new C2394b(from, this.f7039h.mo15430R());
            this.f7033b.setAdapter(this.f7037f);
            this.f7038g = new C2394b(from, new ArrayList());
            this.f7038g.mo16468a(false);
            this.f7034c.setAdapter(this.f7038g);
            this.f7033b.setMaterialMeta(this.f7039h);
            this.f7034c.setMaterialMeta(this.f7039h);
        }
    }

    /* renamed from: d */
    private void m8854d() {
        this.f7035d = (RelativeLayout) this.f7032a.findViewById(ResourceHelp.m11935e(getContext(), "tt_dislike_title_content"));
        this.f7036e = this.f7032a.findViewById(ResourceHelp.m11935e(getContext(), "tt_dislike_line1"));
        this.f7032a.findViewById(ResourceHelp.m11935e(getContext(), "tt_dislike_header_back")).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                RewardDislikeDialog.this.m8855e();
                if (RewardDislikeDialog.this.f7040i != null) {
                    RewardDislikeDialog.this.f7040i.mo14879c(view);
                }
            }
        });
        this.f7033b = (TTDislikeListView) this.f7032a.findViewById(ResourceHelp.m11935e(getContext(), "tt_filer_words_lv"));
        this.f7033b.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                try {
                    FilterWord filterWord = (FilterWord) adapterView.getAdapter().getItem(i);
                    if (filterWord.hasSecondOptions()) {
                        RewardDislikeDialog.this.m8848a(filterWord);
                        if (RewardDislikeDialog.this.f7040i != null) {
                            RewardDislikeDialog.this.f7040i.mo14876a(i, filterWord);
                        }
                        return;
                    }
                } catch (Throwable unused) {
                }
                if (RewardDislikeDialog.this.f7040i != null) {
                    try {
                        RewardDislikeDialog.this.f7040i.mo14876a(i, (FilterWord) RewardDislikeDialog.this.f7039h.mo15430R().get(i));
                    } catch (Throwable unused2) {
                    }
                }
                RewardDislikeDialog.this.mo15192b();
            }
        });
        this.f7034c = (TTDislikeListView) this.f7032a.findViewById(ResourceHelp.m11935e(getContext(), "tt_filer_words_lv_second"));
        this.f7034c.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (RewardDislikeDialog.this.f7040i != null) {
                    try {
                        RewardDislikeDialog.this.f7040i.mo14876a(i, (FilterWord) adapterView.getAdapter().getItem(i));
                    } catch (Throwable unused) {
                    }
                }
                RewardDislikeDialog.this.mo15192b();
            }
        });
    }

    /* renamed from: a */
    public void mo15191a() {
        if (this.f7032a.getParent() == null) {
            addView(this.f7032a);
        }
        m8855e();
        setVisibility(0);
        this.f7041j = true;
        C2167a aVar = this.f7040i;
        if (aVar != null) {
            aVar.mo14877a(this);
        }
    }

    /* renamed from: b */
    public void mo15192b() {
        setVisibility(8);
        this.f7041j = false;
        C2167a aVar = this.f7040i;
        if (aVar != null) {
            aVar.mo14878b(this);
        }
    }

    public void setCallback(C2167a aVar) {
        this.f7040i = aVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m8855e() {
        RelativeLayout relativeLayout = this.f7035d;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        View view = this.f7036e;
        if (view != null) {
            view.setVisibility(8);
        }
        TTDislikeListView tTDislikeListView = this.f7033b;
        if (tTDislikeListView != null) {
            tTDislikeListView.setVisibility(0);
        }
        C2394b bVar = this.f7038g;
        if (bVar != null) {
            bVar.mo16466a();
        }
        TTDislikeListView tTDislikeListView2 = this.f7034c;
        if (tTDislikeListView2 != null) {
            tTDislikeListView2.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8848a(FilterWord filterWord) {
        if (filterWord != null) {
            C2394b bVar = this.f7038g;
            if (bVar != null) {
                bVar.mo16467a(filterWord.getOptions());
            }
            RelativeLayout relativeLayout = this.f7035d;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
            View view = this.f7036e;
            if (view != null) {
                view.setVisibility(0);
            }
            TTDislikeListView tTDislikeListView = this.f7033b;
            if (tTDislikeListView != null) {
                tTDislikeListView.setVisibility(8);
            }
            TTDislikeListView tTDislikeListView2 = this.f7034c;
            if (tTDislikeListView2 != null) {
                tTDislikeListView2.setVisibility(0);
            }
        }
    }
}
