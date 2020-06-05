package com.bytedance.sdk.openadsdk.downloadnew.p181a.p182a;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.GlobalInfo;
import com.p530ss.android.p531a.p532a.p533a.AppStatusChangeListener;
import java.lang.ref.WeakReference;

/* renamed from: com.bytedance.sdk.openadsdk.downloadnew.a.a.a */
public class LibAppStatus implements AppStatusChangeListener {
    /* renamed from: a */
    private final WeakReference<Context> f8524a;

    public LibAppStatus(Context context) {
        this.f8524a = new WeakReference<>(context);
    }

    /* renamed from: a */
    public boolean mo16475a() {
        return GlobalInfo.m9616c().mo15664a();
    }
}
