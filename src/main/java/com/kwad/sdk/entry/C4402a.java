package com.kwad.sdk.entry;

import android.content.Context;
import android.view.View;
import com.kwad.sdk.core.response.model.C4329d;
import com.kwad.sdk.entry.model.C4403a;
import com.kwad.sdk.entry.view.C4408b;
import com.kwad.sdk.entry.view.EntryScrollView;
import com.kwad.sdk.export.p347i.KsEntryElement;
import com.kwad.sdk.export.p347i.KsEntryElement.OnFeedClickListener;

/* renamed from: com.kwad.sdk.entry.a */
public class C4402a implements KsEntryElement {
    /* renamed from: a */
    private static C4403a f14420a;
    /* renamed from: b */
    private C4329d f14421b;
    /* renamed from: c */
    private C4408b f14422c;
    /* renamed from: d */
    private boolean f14423d = false;

    /* renamed from: a */
    public static C4403a m17968a() {
        return f14420a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0044  */
    /* renamed from: a */
    private void m17969a(android.content.Context r4, com.kwad.sdk.export.p347i.KsEntryElement.OnFeedClickListener r5) {
        /*
        r3 = this;
        com.kwad.sdk.entry.view.b r0 = r3.f14422c
        if (r0 == 0) goto L_0x0005
        return
    L_0x0005:
        com.kwad.sdk.core.response.model.d r0 = r3.f14421b
        if (r0 != 0) goto L_0x000a
        return
    L_0x000a:
        int r0 = r0.f14224a
        r1 = 1
        r2 = 0
        if (r0 == r1) goto L_0x0033
        r1 = 2
        if (r0 == r1) goto L_0x001b
        com.kwad.sdk.entry.view.a r0 = new com.kwad.sdk.entry.view.a
        r0.m48383init(r4)
    L_0x0018:
        r3.f14422c = r0
        goto L_0x0040
    L_0x001b:
        java.lang.String r0 = "ksad_view_entry_viewpager"
        int r0 = com.kwad.sdk.p306a.C3809l.m15792b(r4, r0)
        android.view.View r0 = android.view.View.inflate(r4, r0, r2)
        com.kwad.sdk.entry.view.b r0 = (com.kwad.sdk.entry.view.C4408b) r0
        r3.f14422c = r0
        com.kwad.sdk.entry.view.b r0 = r3.f14422c
        com.kwad.sdk.entry.view.EntryScrollView r0 = (com.kwad.sdk.entry.view.EntryScrollView) r0
        boolean r1 = r3.f14423d
        r0.setTouchIntercept(r1)
        goto L_0x0040
    L_0x0033:
        java.lang.String r0 = "ksad_view_entry_twophoto"
        int r0 = com.kwad.sdk.p306a.C3809l.m15792b(r4, r0)
        android.view.View r0 = android.view.View.inflate(r4, r0, r2)
        com.kwad.sdk.entry.view.b r0 = (com.kwad.sdk.entry.view.C4408b) r0
        goto L_0x0018
    L_0x0040:
        com.kwad.sdk.entry.view.b r0 = r3.f14422c
        if (r0 == 0) goto L_0x0058
        com.kwad.sdk.core.response.model.d r1 = r3.f14421b
        boolean r0 = r0.mo24606a(r1)
        if (r0 != 0) goto L_0x0053
        com.kwad.sdk.entry.view.a r0 = new com.kwad.sdk.entry.view.a
        r0.m48383init(r4)
        r3.f14422c = r0
    L_0x0053:
        com.kwad.sdk.entry.view.b r4 = r3.f14422c
        r4.setOnfeedClickListener(r5)
    L_0x0058:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.entry.C4402a.m17969a(android.content.Context, com.kwad.sdk.export.i.KsEntryElement$OnFeedClickListener):void");
    }

    /* renamed from: a */
    public static void m17970a(C4403a aVar) {
        f14420a = aVar;
    }

    /* renamed from: b */
    public static void m17971b() {
        f14420a = null;
    }

    /* renamed from: a */
    public void mo24600a(C4329d dVar) {
        this.f14421b = dVar;
    }

    public View getEntryView(Context context, OnFeedClickListener onFeedClickListener) {
        m17969a(context, onFeedClickListener);
        return (View) this.f14422c;
    }

    public void setTouchIntercept(boolean z) {
        this.f14423d = z;
        C4408b bVar = this.f14422c;
        if (bVar instanceof EntryScrollView) {
            ((EntryScrollView) bVar).setTouchIntercept(this.f14423d);
        }
    }
}
