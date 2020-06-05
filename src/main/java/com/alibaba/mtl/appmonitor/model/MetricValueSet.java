package com.alibaba.mtl.appmonitor.model;

import com.alibaba.mtl.appmonitor.p068a.Event;
import com.alibaba.mtl.appmonitor.p068a.EventType;
import com.alibaba.mtl.appmonitor.p070c.BalancedPool;
import com.alibaba.mtl.appmonitor.p070c.Reusable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.alibaba.mtl.appmonitor.model.d */
public class MetricValueSet implements Reusable {
    /* renamed from: a */
    private Map<Metric, Event> f3269a = Collections.synchronizedMap(new HashMap());

    /* renamed from: a */
    public List<Event> mo11762a() {
        return new ArrayList(this.f3269a.values());
    }

    /* renamed from: a */
    public Event mo11761a(Integer num, String str, String str2, String str3, Class<? extends Event> cls) {
        boolean z;
        Metric bVar;
        Event dVar;
        if (num.intValue() == EventType.STAT.mo11568a()) {
            bVar = MetricRepo.m3683a().mo11758a(str, str2);
            z = false;
        } else {
            bVar = (Metric) BalancedPool.m3491a().mo11627a(Metric.class, str, str2, str3);
            z = true;
        }
        Event dVar2 = null;
        if (bVar != null) {
            if (this.f3269a.containsKey(bVar)) {
                dVar2 = (Event) this.f3269a.get(bVar);
            } else {
                synchronized (MetricValueSet.class) {
                    dVar = (Event) BalancedPool.m3491a().mo11627a(cls, num, str, str2, str3);
                    this.f3269a.put(bVar, dVar);
                }
                dVar2 = dVar;
                z = false;
            }
            if (z) {
                BalancedPool.m3491a().mo11628a(bVar);
            }
        }
        return dVar2;
    }

    /* renamed from: d */
    public void mo11546d() {
        for (Event a : this.f3269a.values()) {
            BalancedPool.m3491a().mo11628a(a);
        }
        this.f3269a.clear();
    }

    /* renamed from: a */
    public void mo11548a(Object... objArr) {
        if (this.f3269a == null) {
            this.f3269a = Collections.synchronizedMap(new HashMap());
        }
    }
}
