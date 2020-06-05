package com.qiyukf.nim.uikit.p418a;

import android.content.Context;
import android.os.Handler;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.qiyukf.nim.uikit.a.b */
public final class C5431b {
    /* renamed from: a */
    private List<C5432a> f17424a = new ArrayList();
    /* renamed from: b */
    private Handler f17425b;

    /* renamed from: com.qiyukf.nim.uikit.a.b$a */
    public interface C5432a {
    }

    public C5431b(Context context) {
        this.f17425b = new Handler(context.getMainLooper());
    }

    /* renamed from: a */
    public final synchronized void mo27375a(C5432a aVar) {
        if (aVar != null) {
            this.f17424a.add(aVar);
        }
    }

    /* renamed from: b */
    public final synchronized void mo27376b(C5432a aVar) {
        if (aVar != null) {
            this.f17424a.remove(aVar);
        }
    }
}
