package com.tencent.mta.track;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.ap */
class C7356ap implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C7355ao f24903a;

    C7356ap(C7355ao aoVar) {
        this.f24903a = aoVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        if (this.f24903a.f24895c != null) {
            this.f24903a.f24895c.mo35929a(true);
        }
    }
}
