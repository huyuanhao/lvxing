package com.bytedance.sdk.adnet.core;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* renamed from: com.bytedance.sdk.adnet.core.d */
class ByteArrayPool {
    /* renamed from: a */
    protected static final Comparator<byte[]> f6223a = new Comparator<byte[]>() {
        /* renamed from: a */
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    };
    /* renamed from: b */
    private final List<byte[]> f6224b = new ArrayList();
    /* renamed from: c */
    private final List<byte[]> f6225c = new ArrayList(64);
    /* renamed from: d */
    private int f6226d = 0;
    /* renamed from: e */
    private final int f6227e;

    public ByteArrayPool(int i) {
        this.f6227e = i;
    }

    /* renamed from: a */
    public synchronized byte[] mo14318a(int i) {
        for (int i2 = 0; i2 < this.f6225c.size(); i2++) {
            byte[] bArr = (byte[]) this.f6225c.get(i2);
            if (bArr.length >= i) {
                this.f6226d -= bArr.length;
                this.f6225c.remove(i2);
                this.f6224b.remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
            return;
     */
    /* renamed from: a */
    public synchronized void mo14317a(byte[] r3) {
        /*
        r2 = this;
        monitor-enter(r2)
        if (r3 == 0) goto L_0x002e
        int r0 = r3.length     // Catch:{ all -> 0x002b }
        int r1 = r2.f6227e     // Catch:{ all -> 0x002b }
        if (r0 <= r1) goto L_0x0009
        goto L_0x002e
    L_0x0009:
        java.util.List<byte[]> r0 = r2.f6224b     // Catch:{ all -> 0x002b }
        r0.add(r3)     // Catch:{ all -> 0x002b }
        java.util.List<byte[]> r0 = r2.f6225c     // Catch:{ all -> 0x002b }
        java.util.Comparator<byte[]> r1 = f6223a     // Catch:{ all -> 0x002b }
        int r0 = java.util.Collections.binarySearch(r0, r3, r1)     // Catch:{ all -> 0x002b }
        if (r0 >= 0) goto L_0x001b
        int r0 = -r0
        int r0 = r0 + -1
    L_0x001b:
        java.util.List<byte[]> r1 = r2.f6225c     // Catch:{ all -> 0x002b }
        r1.add(r0, r3)     // Catch:{ all -> 0x002b }
        int r0 = r2.f6226d     // Catch:{ all -> 0x002b }
        int r3 = r3.length     // Catch:{ all -> 0x002b }
        int r0 = r0 + r3
        r2.f6226d = r0     // Catch:{ all -> 0x002b }
        r2.m7823a()     // Catch:{ all -> 0x002b }
        monitor-exit(r2)
        return
    L_0x002b:
        r3 = move-exception
        monitor-exit(r2)
        throw r3
    L_0x002e:
        monitor-exit(r2)
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.adnet.core.ByteArrayPool.mo14317a(byte[]):void");
    }

    /* renamed from: a */
    private synchronized void m7823a() {
        while (this.f6226d > this.f6227e) {
            byte[] bArr = (byte[]) this.f6224b.remove(0);
            this.f6225c.remove(bArr);
            this.f6226d -= bArr.length;
        }
    }
}
