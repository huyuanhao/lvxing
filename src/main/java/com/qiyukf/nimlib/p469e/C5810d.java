package com.qiyukf.nimlib.p469e;

import android.os.Handler;
import com.qiyukf.nimlib.C5743d;
import com.qiyukf.nimlib.sdk.Observer;
import com.qiyukf.nimlib.sdk.auth.AuthServiceObserver;
import java.util.ArrayList;

/* renamed from: com.qiyukf.nimlib.e.d */
final class C5810d {
    /* renamed from: a */
    private Handler f18472a;

    C5810d(Handler handler) {
        this.f18472a = handler;
    }

    /* renamed from: a */
    public final void mo28106a(String str, final Observer observer) {
        StringBuilder sb = new StringBuilder();
        sb.append(AuthServiceObserver.class.getSimpleName());
        sb.append("/observeOtherClients");
        if (str.equals(sb.toString())) {
            final ArrayList i = C5743d.m23124i();
            this.f18472a.post(new Runnable() {
                public final void run() {
                    observer.onEvent(i);
                }
            });
        }
    }
}
