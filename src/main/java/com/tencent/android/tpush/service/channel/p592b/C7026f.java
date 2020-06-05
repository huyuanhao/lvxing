package com.tencent.android.tpush.service.channel.p592b;

import com.tencent.android.tpush.service.C6973b;
import com.tencent.android.tpush.service.channel.security.TpnsSecurity;
import com.tencent.android.tpush.service.p588a.C6971a;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.service.channel.b.f */
public class C7026f implements C7023c {
    /* renamed from: a */
    private long f23346a = Long.MAX_VALUE;
    /* renamed from: b */
    private boolean f23347b = false;
    /* renamed from: j */
    protected TpnsSecurity f23348j;

    /* renamed from: a */
    public void mo33423a(TpnsSecurity tpnsSecurity) {
        this.f23348j = tpnsSecurity;
    }

    /* renamed from: c */
    public void mo33425c() {
        if (this.f23346a == Long.MAX_VALUE) {
            this.f23346a = System.currentTimeMillis();
        }
    }

    /* renamed from: a */
    public long mo33422a() {
        long currentTimeMillis = (this.f23346a + ((long) C6971a.m29749a(C6973b.m29776f()).f23143b)) - System.currentTimeMillis();
        if (currentTimeMillis < 0) {
            return 0;
        }
        return currentTimeMillis;
    }

    /* renamed from: d */
    public synchronized void mo33426d() {
        this.f23347b = true;
    }

    /* renamed from: b */
    public synchronized boolean mo33424b() {
        return this.f23347b;
    }
}
