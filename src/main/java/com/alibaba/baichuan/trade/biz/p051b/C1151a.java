package com.alibaba.baichuan.trade.biz.p051b;

import android.webkit.WebView;
import com.alibaba.baichuan.trade.biz.core.config.C1186a;
import com.alibaba.baichuan.trade.biz.core.config.model.ConfigDO;
import com.alibaba.baichuan.trade.biz.core.p054b.p055a.C1177b;
import com.alibaba.baichuan.trade.biz.core.p054b.p055a.C1179d;
import com.alibaba.baichuan.trade.biz.core.p054b.p056b.C1182a;
import com.alibaba.baichuan.trade.biz.core.p054b.p056b.C1183b;
import com.alibaba.baichuan.trade.biz.core.p054b.p056b.C1184c;
import com.alibaba.baichuan.trade.common.C1223b;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.alibaba.baichuan.trade.biz.b.a */
public class C1151a {
    /* renamed from: a */
    private static List<C1154a> f2372a = new ArrayList();

    /* renamed from: com.alibaba.baichuan.trade.biz.b.a$a */
    public interface C1154a {
        /* renamed from: a */
        boolean mo10665a(WebView webView, String str, C1182a aVar, C1179d dVar);
    }

    /* renamed from: a */
    static synchronized boolean m2244a(WebView webView, String str, C1182a aVar) {
        boolean z;
        synchronized (C1151a.class) {
            z = false;
            C1179d a = C1177b.m2313a((ConfigDO) C1186a.m2321a(C1223b.f2466f, "bc_config"), new C1184c() {
                /* renamed from: a */
                public void mo10664a(int i) {
                }
            }, new C1179d(str), new C1183b() {
            });
            if (a != null) {
                for (C1154a a2 : f2372a) {
                    z = a2.mo10665a(webView, str, aVar, a);
                    if (z) {
                        break;
                    }
                }
            }
        }
        return z;
    }
}
