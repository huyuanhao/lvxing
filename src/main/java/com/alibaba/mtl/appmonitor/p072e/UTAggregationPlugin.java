package com.alibaba.mtl.appmonitor.p072e;

import com.alibaba.mtl.log.UTDC;
import com.alibaba.mtl.log.model.LogField;
import com.alibaba.mtl.log.p077d.Logger;
import com.alibaba.mtl.log.p077d.UTAdapter;
import java.util.Map;

/* renamed from: com.alibaba.mtl.appmonitor.e.a */
public class UTAggregationPlugin {
    /* renamed from: a */
    private static final String f3229a = null;
    /* renamed from: b */
    private static UTAggregationPlugin f3230b;

    private UTAggregationPlugin() {
    }

    /* renamed from: a */
    public static synchronized UTAggregationPlugin m3583a() {
        UTAggregationPlugin aVar;
        synchronized (UTAggregationPlugin.class) {
            if (f3230b == null) {
                f3230b = new UTAggregationPlugin();
            }
            aVar = f3230b;
        }
        return aVar;
    }

    /* renamed from: a */
    public void mo11655a(Map<String, String> map) {
        if (map != null) {
            Logger.m3833a(f3229a, "[sendToUT]:", " args:", map);
            if (!UTDC.f3277h) {
                map.put("_fuamf", "yes");
                UTAdapter.m3876a(map);
            } else if (map != null) {
                UTDC.m3695a((String) map.get(LogField.PAGE.toString()), (String) map.get(LogField.EVENTID.toString()), (String) map.get(LogField.ARG1.toString()), (String) map.get(LogField.ARG2.toString()), (String) map.get(LogField.ARG3.toString()), map);
            }
        }
    }
}
