package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.utils.ResourceHelp;
import java.util.Locale;

public class PlayableLoadingView extends FrameLayout {
    /* renamed from: a */
    private ProgressBar f8234a;
    /* renamed from: b */
    private TextView f8235b;
    /* renamed from: c */
    private TextView f8236c;

    public PlayableLoadingView(Context context) {
        super(context);
        m10745a(context);
    }

    public PlayableLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10745a(context);
    }

    public PlayableLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10745a(context);
    }

    /* renamed from: a */
    private void m10745a(Context context) {
        setBackgroundColor(Color.parseColor("#0D1833"));
        setClickable(true);
        setVisibility(8);
        LayoutInflater.from(context).inflate(ResourceHelp.m11936f(context, "tt_playable_loading_layout"), this, true);
        this.f8234a = (ProgressBar) findViewById(ResourceHelp.m11935e(context, "tt_playable_pb_view"));
        this.f8235b = (TextView) findViewById(ResourceHelp.m11935e(context, "tt_playable_progress_tip"));
        this.f8236c = (TextView) findViewById(ResourceHelp.m11935e(context, "tt_playable_play"));
    }

    public void setProgress(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i > 100) {
            i = 100;
        }
        ProgressBar progressBar = this.f8234a;
        if (progressBar != null) {
            progressBar.setProgress(i);
        }
        TextView textView = this.f8235b;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%d%%", new Object[]{Integer.valueOf(i)}));
        }
    }

    /* renamed from: a */
    public void mo16239a() {
        setVisibility(8);
    }

    /* renamed from: b */
    public void mo16240b() {
        setVisibility(0);
    }

    public TextView getPlayView() {
        return this.f8236c;
    }
}
