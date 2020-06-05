package com.qiyukf.nim.uikit.common.p424ui.listview;

import android.os.Build.VERSION;
import android.widget.ListView;

/* renamed from: com.qiyukf.nim.uikit.common.ui.listview.a */
public final class C5487a {

    /* renamed from: com.qiyukf.nim.uikit.common.ui.listview.a$a */
    public interface C5489a {
    }

    /* renamed from: a */
    public static void m22377a(final ListView listView) {
        final int count = listView.getAdapter().getCount() - 1;
        listView.post(new Runnable() {
            /* renamed from: c */
            final /* synthetic */ int f17678c = 0;
            /* renamed from: d */
            final /* synthetic */ C5489a f17679d = null;

            public final void run() {
                if (VERSION.SDK_INT >= 11) {
                    listView.setSelectionFromTop(count, this.f17678c);
                } else {
                    listView.setSelection(count);
                }
            }
        });
    }
}
