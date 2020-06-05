package com.kwai.filedownloader;

import android.os.Handler;
import android.util.SparseArray;
import java.util.List;

/* renamed from: com.kwai.filedownloader.aa */
class C4594aa implements C4742v {
    /* renamed from: a */
    private final SparseArray<Handler> f14961a = new SparseArray<>();

    C4594aa() {
    }

    /* renamed from: a */
    private void m18658a(Handler handler) {
        handler.sendEmptyMessage(2);
    }

    /* renamed from: b */
    private void m18659b(Handler handler) {
        handler.sendEmptyMessage(3);
    }

    /* renamed from: a */
    public void mo24951a() {
        for (int i = 0; i < this.f14961a.size(); i++) {
            m18658a((Handler) this.f14961a.get(this.f14961a.keyAt(i)));
        }
    }

    /* renamed from: a */
    public void mo24952a(List<Integer> list) {
        for (Integer intValue : list) {
            m18659b((Handler) this.f14961a.get(intValue.intValue()));
        }
    }

    /* renamed from: a */
    public boolean mo24953a(int i) {
        return this.f14961a.get(i) != null;
    }

    /* renamed from: b */
    public int mo24954b() {
        return this.f14961a.size();
    }
}
