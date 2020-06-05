package com.alibaba.baichuan.trade.biz.core.p054b;

import android.text.TextUtils;
import com.alibaba.baichuan.trade.biz.core.config.model.ConfigDO;
import com.alibaba.baichuan.trade.biz.core.p054b.p055a.C1176a;
import com.alibaba.baichuan.trade.biz.core.p054b.p055a.C1179d;
import com.alibaba.baichuan.trade.biz.core.p054b.p055a.C1180e;
import com.alibaba.baichuan.trade.biz.core.p054b.p056b.C1183b;
import com.alibaba.baichuan.trade.biz.core.p054b.p056b.C1184c;
import com.alibaba.baichuan.trade.common.utils.C1224a;
import java.util.HashMap;

/* renamed from: com.alibaba.baichuan.trade.biz.core.b.b */
public class C1181b implements C1176a {
    /* renamed from: a */
    private C1176a f2439a;

    /* renamed from: a */
    public C1179d mo10750a(ConfigDO configDO, C1179d dVar, C1184c cVar, C1183b bVar) {
        int i;
        String a = dVar.mo10752a();
        if (a == null || a.length() == 0) {
            cVar.mo10664a(1600);
            return null;
        }
        if (configDO != null) {
            String a2 = C1180e.m2317a(a, configDO);
            HashMap b = dVar.mo10754b();
            String str = "urlType";
            if (TextUtils.isEmpty(a2)) {
                a2 = "h5";
            }
            b.put(str, a2);
            C1176a aVar = this.f2439a;
            if (aVar != null) {
                aVar.mo10750a(configDO, dVar, cVar, bVar);
                return dVar;
            }
            i = 2000;
        } else {
            C1224a.m2402a("UrlTypeConfigParseImpl", "配置数据获取为空");
            i = 1100;
        }
        cVar.mo10664a(i);
        return null;
    }

    /* renamed from: a */
    public void mo10751a(C1176a aVar) {
        this.f2439a = aVar;
    }
}
