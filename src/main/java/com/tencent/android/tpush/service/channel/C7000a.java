package com.tencent.android.tpush.service.channel;

import android.util.SparseArray;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.service.channel.a */
public class C7000a {
    /* renamed from: b */
    private static C7000a f23245b = new C7000a();
    /* renamed from: a */
    private SparseArray<Object> f23246a = new SparseArray<>();

    /* renamed from: a */
    public static C7000a m29932a() {
        return f23245b;
    }

    public C7000a() {
    }

    public C7000a(Object... objArr) {
        for (int i = 0; i < objArr.length; i += 2) {
            this.f23246a.put(objArr[i].intValue(), objArr[i + 1]);
        }
    }

    /* renamed from: a */
    public void mo33362a(int i, Object obj) {
        this.f23246a.put(i, obj);
    }

    /* renamed from: b */
    public boolean mo33363b() {
        return ((Boolean) this.f23246a.get(2, Boolean.valueOf(false))).booleanValue();
    }

    /* renamed from: c */
    public long mo33364c() {
        return ((Long) this.f23246a.get(3, Long.valueOf(0))).longValue();
    }

    /* renamed from: d */
    public String mo33365d() {
        return (String) this.f23246a.get(0, "");
    }

    /* renamed from: e */
    public int mo33366e() {
        return ((Integer) this.f23246a.get(1, Integer.valueOf(0))).intValue();
    }
}
