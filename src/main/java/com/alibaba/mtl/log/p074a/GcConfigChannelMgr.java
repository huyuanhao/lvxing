package com.alibaba.mtl.log.p074a;

import com.alibaba.mtl.log.p077d.HttpUtils;
import com.alibaba.mtl.log.p077d.HttpUtils.C1319a;
import com.alibaba.mtl.log.p077d.Logger;
import com.alibaba.mtl.log.p077d.NetworkUtil;
import com.alibaba.mtl.log.p077d.TaskExecutor;
import com.alibaba.mtl.log.p077d.UrlWrapper;
import java.util.HashMap;

/* renamed from: com.alibaba.mtl.log.a.b */
public class GcConfigChannelMgr {
    /* renamed from: a */
    private static GcConfigChannelMgr f3300a = new GcConfigChannelMgr();
    /* renamed from: b */
    private static String f3301b = "adashxgc.ut.taobao.com";

    /* compiled from: GcConfigChannelMgr */
    /* renamed from: com.alibaba.mtl.log.a.b$a */
    class C1309a implements Runnable {
        C1309a() {
        }

        public void run() {
            if (NetworkUtil.m3847b()) {
                int i = 0;
                while (true) {
                    if (i >= 8) {
                        break;
                    }
                    HashMap hashMap = new HashMap();
                    String e = Config.m3715e("b01n15");
                    String e2 = Config.m3715e("b01na");
                    hashMap.put("_b01n15", e);
                    hashMap.put("_b01na", e2);
                    try {
                        String b = UrlWrapper.m3880b(GcConfigChannelMgr.m3722d(), hashMap, null);
                        StringBuilder sb = new StringBuilder();
                        sb.append("config:");
                        sb.append(b);
                        Logger.m3833a("ConfigMgr", sb.toString());
                        C1319a a = HttpUtils.m3819a(1, b, null, false);
                        if (a.f3398b != null) {
                            Config.m3713d(new String(a.f3398b, 0, a.f3398b.length));
                            Config.m3719g();
                            break;
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    try {
                        Thread.sleep(10000);
                    } catch (Exception unused) {
                    }
                    i++;
                }
            }
        }
    }

    /* access modifiers changed from: private|static */
    /* renamed from: d */
    public static String m3722d() {
        StringBuilder sb = new StringBuilder();
        sb.append("https://");
        sb.append(f3301b);
        sb.append("/rest/gc2");
        return sb.toString();
    }

    /* renamed from: a */
    public static GcConfigChannelMgr m3720a() {
        return f3300a;
    }

    /* renamed from: b */
    public void mo11763b() {
        TaskExecutor.m3867a().mo11811a((Runnable) new C1309a());
    }
}
