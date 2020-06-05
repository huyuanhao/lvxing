package com.alibaba.baichuan.trade.biz.core.p054b.p055a;

import com.alibaba.baichuan.trade.biz.core.config.C1186a;
import com.alibaba.baichuan.trade.biz.core.config.model.ConfigDO;
import com.alibaba.baichuan.trade.biz.core.config.model.UrlTypeDO;
import com.alibaba.baichuan.trade.common.C1223b;
import com.alibaba.baichuan.trade.common.utils.C1224a;

/* renamed from: com.alibaba.baichuan.trade.biz.core.b.a.e */
public class C1180e {
    /* renamed from: a */
    public static String m2317a(String str, ConfigDO configDO) {
        if (configDO == null) {
            configDO = (ConfigDO) C1186a.m2321a(C1223b.f2466f, "bc_config");
        }
        for (UrlTypeDO urlTypeDO : configDO.getUrlTypeConfig()) {
            String[] pattern = urlTypeDO.getPattern();
            int length = pattern.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    if (str.matches(pattern[i])) {
                        return urlTypeDO.getType();
                    }
                    i++;
                }
            }
        }
        C1224a.m2402a("UrlTypeUtil", "没有匹配上对应的url类型");
        return "h5";
    }
}
