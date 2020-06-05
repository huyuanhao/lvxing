package com.qiyukf.unicorn.widget.p521a;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.qiyukf.unicorn.C5961R;

/* renamed from: com.qiyukf.unicorn.widget.a.f */
public final class C6362f extends Dialog {
    /* renamed from: a */
    private ProgressBar f19848a;
    /* renamed from: b */
    private TextView f19849b;
    /* renamed from: c */
    private Handler f19850c;

    public C6362f(Context context) {
        super(context, C5961R.style.ysf_dialog_default_style);
        View inflate = LayoutInflater.from(getContext()).inflate(C5961R.C5964layout.ysf_progress_dialog, null);
        this.f19848a = (ProgressBar) inflate.findViewById(C5961R.C5963id.ysf_progress_dialog_progress);
        this.f19849b = (TextView) inflate.findViewById(C5961R.C5963id.ysf_progress_dialog_message);
        setContentView(inflate);
        setCancelable(false);
    }

    /* renamed from: a */
    public final void mo29584a() {
        this.f19848a.setVisibility(8);
    }

    /* renamed from: a */
    public final void mo29585a(String str) {
        this.f19849b.setText(str);
    }

    /* renamed from: b */
    public final void mo29586b() {
        if (!isShowing()) {
            show();
        }
        if (this.f19850c == null) {
            this.f19850c = new Handler(Looper.getMainLooper());
        }
        this.f19850c.postDelayed(new Runnable() {
            public final void run() {
                if (C6362f.this.isShowing()) {
                    C6362f.this.cancel();
                }
            }
        }, 1000);
    }
}
