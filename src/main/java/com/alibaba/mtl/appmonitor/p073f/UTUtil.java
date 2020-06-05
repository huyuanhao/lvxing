package com.alibaba.mtl.appmonitor.p073f;

import com.alibaba.mtl.appmonitor.SdkMeta;
import com.alibaba.mtl.appmonitor.model.UTDimensionValueSet;
import com.alibaba.mtl.appmonitor.p068a.Event;
import com.alibaba.mtl.appmonitor.p068a.EventType;
import com.alibaba.mtl.appmonitor.p068a.UTEvent;
import com.alibaba.mtl.appmonitor.p070c.BalancedPool;
import com.alibaba.mtl.appmonitor.p070c.ReuseJSONArray;
import com.alibaba.mtl.appmonitor.p072e.UTAggregationPlugin;
import com.alibaba.mtl.log.UTDC;
import com.alibaba.mtl.log.model.LogField;
import com.alibaba.mtl.log.p077d.Logger;
import com.tencent.mid.sotrage.StorageInterface;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONObject;

/* renamed from: com.alibaba.mtl.appmonitor.f.c */
public class UTUtil {
    /* renamed from: a */
    public static void m3593a(Map<UTDimensionValueSet, List<Event>> map) {
        for (Entry entry : map.entrySet()) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            UTDimensionValueSet uTDimensionValueSet = (UTDimensionValueSet) entry.getKey();
            List<Event> list = (List) entry.getValue();
            if (list.size() != 0) {
                Integer c = uTDimensionValueSet.mo11746c();
                if (c != null) {
                    EventType a = EventType.m3341a(c.intValue());
                    int i = 0;
                    UTEvent hVar = (UTEvent) BalancedPool.m3491a().mo11627a(UTEvent.class, new Object[0]);
                    hVar.f3182b = c.intValue();
                    if (uTDimensionValueSet.mo11689b() != null) {
                        hVar.f3186f.putAll(uTDimensionValueSet.mo11689b());
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("meta", SdkMeta.m3582a());
                    ReuseJSONArray dVar = (ReuseJSONArray) BalancedPool.m3491a().mo11627a(ReuseJSONArray.class, new Object[0]);
                    for (Event dVar2 : list) {
                        dVar.put(dVar2.mo11545c());
                        if (i == 0) {
                            sb.append(dVar2.f3151e);
                            sb2.append(dVar2.f3152f);
                        } else {
                            String str = StorageInterface.KEY_SPLITER;
                            sb.append(str);
                            sb.append(dVar2.f3151e);
                            sb2.append(str);
                            sb2.append(dVar2.f3152f);
                        }
                        i++;
                        BalancedPool.m3491a().mo11628a(dVar2);
                    }
                    hashMap.put("data", dVar);
                    hVar.f3186f.put(a.mo11568a(), new JSONObject(hashMap).toString());
                    String sb3 = sb.toString();
                    String sb4 = sb2.toString();
                    hVar.f3186f.put(LogField.ARG1.toString(), sb3);
                    hVar.f3186f.put(LogField.ARG2.toString(), sb4);
                    hVar.f3183c = sb3;
                    hVar.f3184d = sb4;
                    m3594b(hVar);
                    BalancedPool.m3491a().mo11628a(dVar);
                }
            }
            BalancedPool.m3491a().mo11628a(uTDimensionValueSet);
        }
    }

    /* renamed from: a */
    public static void m3592a(UTDimensionValueSet uTDimensionValueSet, Event dVar) {
        Integer c = uTDimensionValueSet.mo11746c();
        if (c != null) {
            EventType a = EventType.m3341a(c.intValue());
            UTEvent hVar = (UTEvent) BalancedPool.m3491a().mo11627a(UTEvent.class, new Object[0]);
            hVar.f3182b = 6699;
            if (uTDimensionValueSet.mo11689b() != null) {
                hVar.f3186f.putAll(uTDimensionValueSet.mo11689b());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("meta", SdkMeta.m3582a());
            hashMap.put("_event_id", c);
            ReuseJSONArray dVar2 = (ReuseJSONArray) BalancedPool.m3491a().mo11627a(ReuseJSONArray.class, new Object[0]);
            dVar2.put(dVar.mo11545c());
            BalancedPool.m3491a().mo11628a(dVar);
            hashMap.put("data", dVar2);
            hVar.f3186f.put(a.mo11568a(), new JSONObject(hashMap).toString());
            hVar.f3186f.put(LogField.EVENTID.toString(), String.valueOf(6699));
            m3594b(hVar);
            BalancedPool.m3491a().mo11628a(dVar2);
        }
    }

    /* renamed from: a */
    public static void m3591a(UTEvent hVar) {
        if (hVar != null) {
            UTDC.m3695a(hVar.f3181a, String.valueOf(hVar.f3182b), hVar.f3183c, hVar.f3184d, hVar.f3185e, hVar.f3186f);
            BalancedPool.m3491a().mo11628a(hVar);
        }
    }

    /* renamed from: b */
    public static void m3594b(UTEvent hVar) {
        Logger.m3833a("UTUtil", "upload without flowback. args:", hVar.f3186f);
        UTAggregationPlugin.m3583a().mo11655a(hVar.f3186f);
        BalancedPool.m3491a().mo11628a(hVar);
    }
}
