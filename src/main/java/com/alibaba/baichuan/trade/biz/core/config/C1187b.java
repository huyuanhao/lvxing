package com.alibaba.baichuan.trade.biz.core.config;

import com.alibaba.baichuan.trade.biz.core.config.model.ConfigDO;
import com.alibaba.baichuan.trade.biz.core.config.model.ExtendDO;

/* renamed from: com.alibaba.baichuan.trade.biz.core.config.b */
public class C1187b {
    /* renamed from: e */
    private static boolean f2454e = false;
    /* renamed from: f */
    private static C1187b f2455f;
    /* renamed from: a */
    public String f2456a = "1.0.0";
    /* renamed from: b */
    public long f2457b = (System.currentTimeMillis() + 3600000);
    /* renamed from: c */
    private final long f2458c = 21600000;
    /* renamed from: d */
    private final long f2459d = 3600000;
    /* renamed from: g */
    private ConfigDO f2460g;

    /* renamed from: a */
    public static synchronized C1187b m2322a() {
        C1187b bVar;
        synchronized (C1187b.class) {
            if (f2455f == null) {
                f2455f = new C1187b();
            }
            bVar = f2455f;
        }
        return bVar;
    }

    /* renamed from: a */
    public boolean mo10755a(boolean z) {
        ConfigDO configDO = this.f2460g;
        if (configDO == null) {
            return z;
        }
        ExtendDO misc = configDO.getMisc();
        if (misc == null) {
            return z;
        }
        return "YES".equals(misc.getLoginDegarade());
    }
}
