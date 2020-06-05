package com.p522qq.p523e.comm.adevent;

/* renamed from: com.qq.e.comm.adevent.ADEvent */
public class ADEvent {
    /* renamed from: a */
    private final int f20160a;
    /* renamed from: b */
    private final Object[] f20161b;

    public ADEvent(int i) {
        this(i, null);
    }

    public ADEvent(int i, Object[] objArr) {
        this.f20160a = i;
        this.f20161b = objArr;
    }

    public Object[] getParas() {
        Object[] objArr = this.f20161b;
        return objArr == null ? new Object[0] : objArr;
    }

    public int getType() {
        return this.f20160a;
    }
}
