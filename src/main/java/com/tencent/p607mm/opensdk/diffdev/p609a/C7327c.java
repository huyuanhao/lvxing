package com.tencent.p607mm.opensdk.diffdev.p609a;

import com.tencent.p607mm.opensdk.diffdev.OAuthListener;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.opensdk.diffdev.a.c */
final class C7327c implements Runnable {
    /* renamed from: g */
    final /* synthetic */ C7326b f24802g;

    C7327c(C7326b bVar) {
        this.f24802g = bVar;
    }

    public final void run() {
        ArrayList<OAuthListener> arrayList = new ArrayList<>();
        arrayList.addAll(this.f24802g.f24801f.f24798c);
        for (OAuthListener onQrcodeScanned : arrayList) {
            onQrcodeScanned.onQrcodeScanned();
        }
    }
}
