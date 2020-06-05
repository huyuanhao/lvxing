package com.qiyukf.nim.uikit.session.module.p427a;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.qiyukf.nim.uikit.common.p424ui.listview.MessageListView;
import com.qiyukf.nimlib.p453d.p454a.p457c.C5754a;

/* renamed from: com.qiyukf.nim.uikit.session.module.a.a */
public final class C5568a {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public View f17925a;
    /* renamed from: b */
    private Context f17926b;
    /* renamed from: c */
    private View f17927c;
    /* renamed from: d */
    private MessageListView f17928d;
    /* renamed from: e */
    private Handler f17929e;
    /* renamed from: f */
    private int f17930f = 0;
    /* renamed from: g */
    private Runnable f17931g = new Runnable() {
        public final void run() {
            C5568a.this.f17925a.setVisibility(0);
        }
    };

    public C5568a(Context context, View view, MessageListView messageListView) {
        this.f17926b = context;
        this.f17927c = view;
        this.f17928d = messageListView;
        this.f17929e = C5754a.m23152b(messageListView.getContext());
    }
}
