package com.qiyukf.nim.uikit.common.activity;

import android.widget.ImageView;
import android.widget.TextView;
import com.qiyukf.unicorn.C5961R;

public abstract class BlackFragmentActivity extends BaseFragmentActivity {
    /* access modifiers changed from: protected|final */
    /* renamed from: e */
    public final void mo27416e() {
        this.f17438a.setBackgroundResource(C5961R.C5962drawable.ysf_title_bar_bg_black);
        TextView textView = (TextView) findViewById(C5961R.C5963id.ysf_title_bar_title);
        ((ImageView) findViewById(C5961R.C5963id.ysf_title_bar_back_view)).setImageResource(C5961R.C5962drawable.ysf_title_bar_back_icon_white);
        textView.setTextColor(-1);
    }
}
