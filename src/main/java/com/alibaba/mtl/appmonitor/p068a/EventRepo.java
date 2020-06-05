package com.alibaba.mtl.appmonitor.p068a;

import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alibaba.mtl.appmonitor.model.Metric;
import com.alibaba.mtl.appmonitor.model.MetricRepo;
import com.alibaba.mtl.appmonitor.model.MetricValueSet;
import com.alibaba.mtl.appmonitor.model.UTDimensionValueSet;
import com.alibaba.mtl.appmonitor.p070c.BalancedPool;
import com.alibaba.mtl.appmonitor.p073f.StringUtils;
import com.alibaba.mtl.appmonitor.p073f.UTUtil;
import com.alibaba.mtl.log.UTDC;
import com.alibaba.mtl.log.model.LogField;
import com.alibaba.mtl.log.p074a.Config;
import com.alibaba.mtl.log.p077d.Logger;
import com.alibaba.mtl.log.p077d.TaskExecutor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.alibaba.mtl.appmonitor.a.e */
public class EventRepo {
    /* renamed from: c */
    private static EventRepo f3155c;
    /* renamed from: a */
    private Map<String, DurationEvent> f3156a = new ConcurrentHashMap();
    /* renamed from: b */
    private Map<UTDimensionValueSet, MetricValueSet> f3157b = new ConcurrentHashMap();
    /* renamed from: d */
    private AtomicInteger f3158d = new AtomicInteger(0);
    /* renamed from: e */
    private AtomicInteger f3159e = new AtomicInteger(0);
    /* renamed from: f */
    private AtomicInteger f3160f = new AtomicInteger(0);

    /* renamed from: a */
    public static synchronized EventRepo m3324a() {
        EventRepo eVar;
        synchronized (EventRepo.class) {
            if (f3155c == null) {
                f3155c = new EventRepo();
            }
            eVar = f3155c;
        }
        return eVar;
    }

    private EventRepo() {
    }

    /* renamed from: a */
    private UTDimensionValueSet m3325a(int i, Map<String, String> map) {
        UTDimensionValueSet uTDimensionValueSet = (UTDimensionValueSet) BalancedPool.m3491a().mo11627a(UTDimensionValueSet.class, new Object[0]);
        if (map != null) {
            uTDimensionValueSet.mo11686a(map);
        }
        uTDimensionValueSet.mo11685a(LogField.ACCESS.toString(), UTDC.m3699e());
        uTDimensionValueSet.mo11685a(LogField.ACCESS_SUBTYPE.toString(), UTDC.m3700f());
        uTDimensionValueSet.mo11685a(LogField.USERID.toString(), UTDC.m3701g());
        uTDimensionValueSet.mo11685a(LogField.USERNICK.toString(), UTDC.m3702h());
        uTDimensionValueSet.mo11685a(LogField.EVENTID.toString(), String.valueOf(i));
        return uTDimensionValueSet;
    }

    /* renamed from: a */
    public void mo11559a(int i, String str, String str2, String str3, Map<String, String> map) {
        UTDimensionValueSet a = m3325a(i, map);
        ((AlarmEvent) m3323a(a, str, str2, str3, AlarmEvent.class)).mo11542a();
        if (Config.m3709b()) {
            AlarmEvent aVar = (AlarmEvent) BalancedPool.m3491a().mo11627a(AlarmEvent.class, Integer.valueOf(i), str, str2, str3);
            aVar.mo11542a();
            UTUtil.m3592a(a, aVar);
        }
        m3327a(EventType.m3341a(i), this.f3158d);
    }

    /* renamed from: a */
    public void mo11558a(int i, String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        UTDimensionValueSet a = m3325a(i, map);
        AlarmEvent aVar = (AlarmEvent) m3323a(a, str, str2, str3, AlarmEvent.class);
        aVar.mo11544b();
        aVar.mo11543a(str4, str5);
        if (Config.m3709b()) {
            AlarmEvent aVar2 = (AlarmEvent) BalancedPool.m3491a().mo11627a(AlarmEvent.class, Integer.valueOf(i), str, str2, str3);
            aVar2.mo11544b();
            aVar2.mo11543a(str4, str5);
            UTUtil.m3592a(a, aVar2);
        }
        m3327a(EventType.m3341a(i), this.f3158d);
    }

    /* renamed from: a */
    public void mo11557a(int i, String str, String str2, String str3, double d, Map<String, String> map) {
        UTDimensionValueSet a = m3325a(i, map);
        ((CountEvent) m3323a(a, str, str2, str3, CountEvent.class)).mo11547a(d);
        if (Config.m3709b()) {
            CountEvent bVar = (CountEvent) BalancedPool.m3491a().mo11627a(CountEvent.class, Integer.valueOf(i), str, str2, str3);
            bVar.mo11547a(d);
            UTUtil.m3592a(a, bVar);
        }
        m3327a(EventType.m3341a(i), this.f3159e);
    }

    /* renamed from: a */
    public void mo11556a(int i, String str, String str2, MeasureValueSet measureValueSet, DimensionValueSet dimensionValueSet, Map<String, String> map) {
        Metric a = MetricRepo.m3683a().mo11758a(str, str2);
        if (a != null) {
            if (a.mo11754f() != null) {
                a.mo11754f().mo11677b(dimensionValueSet);
            }
            if (a.mo11755g() != null) {
                a.mo11755g().mo11714b(measureValueSet);
            }
            UTDimensionValueSet a2 = m3325a(i, map);
            ((StatEvent) m3323a(a2, str, str2, (String) null, StatEvent.class)).mo11578a(dimensionValueSet, measureValueSet);
            if (Config.m3709b()) {
                StatEvent gVar = (StatEvent) BalancedPool.m3491a().mo11627a(StatEvent.class, Integer.valueOf(i), str, str2);
                gVar.mo11578a(dimensionValueSet, measureValueSet);
                UTUtil.m3592a(a2, gVar);
            }
            m3327a(EventType.m3341a(i), this.f3160f);
            return;
        }
        Logger.m3831a("EventRepo", (Object) "metric is null");
    }

    /* renamed from: a */
    public void mo11560a(Integer num, String str, String str2, String str3) {
        String a = m3326a(str, str2);
        if (a != null) {
            mo11562a(a, num, str, str2, str3);
        }
    }

    /* renamed from: a */
    public void mo11562a(String str, Integer num, String str2, String str3, String str4) {
        DurationEvent cVar;
        Metric a = MetricRepo.m3683a().mo11758a(str2, str3);
        if (a != null && a.mo11755g() != null && a.mo11755g().mo11710a(str4) != null) {
            synchronized (DurationEvent.class) {
                cVar = (DurationEvent) this.f3156a.get(str);
                if (cVar == null) {
                    cVar = (DurationEvent) BalancedPool.m3491a().mo11627a(DurationEvent.class, num, str2, str3);
                    this.f3156a.put(str, cVar);
                }
            }
            cVar.mo11550a(str4);
        }
    }

    /* renamed from: a */
    public void mo11563a(String str, String str2, String str3) {
        String a = m3326a(str, str2);
        if (a != null) {
            mo11564a(a, str3, true, null);
        }
    }

    /* renamed from: a */
    public void mo11564a(String str, String str2, boolean z, Map<String, String> map) {
        DurationEvent cVar = (DurationEvent) this.f3156a.get(str);
        if (cVar != null && cVar.mo11553b(str2)) {
            this.f3156a.remove(str);
            if (z) {
                m3328b(cVar.f3151e, cVar.f3152f);
            }
            mo11556a(cVar.f3154h, cVar.f3151e, cVar.f3152f, cVar.mo11552b(), cVar.mo11554e(), map);
            BalancedPool.m3491a().mo11628a(cVar);
        }
    }

    /* renamed from: a */
    public void mo11561a(String str, Integer num, String str2, String str3, DimensionValueSet dimensionValueSet) {
        DurationEvent cVar;
        synchronized (DurationEvent.class) {
            cVar = (DurationEvent) this.f3156a.get(str);
            if (cVar == null) {
                cVar = (DurationEvent) BalancedPool.m3491a().mo11627a(DurationEvent.class, num, str2, str3);
                this.f3156a.put(str, cVar);
            }
        }
        cVar.mo11549a(dimensionValueSet);
    }

    /* renamed from: a */
    private String m3326a(String str, String str2) {
        Metric a = MetricRepo.m3683a().mo11758a(str, str2);
        if (a != null) {
            return a.mo11747a();
        }
        return null;
    }

    /* renamed from: b */
    private void m3328b(String str, String str2) {
        Metric a = MetricRepo.m3683a().mo11758a(str, str2);
        if (a != null) {
            a.mo11750b();
        }
    }

    /* renamed from: a */
    private Event m3323a(UTDimensionValueSet uTDimensionValueSet, String str, String str2, String str3, Class<? extends Event> cls) {
        MetricValueSet dVar;
        if (StringUtils.m3589a(str) && StringUtils.m3589a(str2)) {
            Integer c = uTDimensionValueSet.mo11746c();
            if (c != null) {
                synchronized (this.f3157b) {
                    dVar = (MetricValueSet) this.f3157b.get(uTDimensionValueSet);
                    if (dVar == null) {
                        dVar = (MetricValueSet) BalancedPool.m3491a().mo11627a(MetricValueSet.class, new Object[0]);
                        this.f3157b.put(uTDimensionValueSet, dVar);
                    }
                }
                return dVar.mo11761a(c, str, str2, str3, cls);
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m3327a(EventType fVar, AtomicInteger atomicInteger) {
        int incrementAndGet = atomicInteger.incrementAndGet();
        String str = "EventRepo";
        Logger.m3834a(str, fVar.toString(), " EVENT size:", String.valueOf(incrementAndGet));
        if (incrementAndGet >= fVar.mo11569b()) {
            Logger.m3833a(str, fVar.toString(), " event size exceed trigger count.");
            atomicInteger.set(0);
            mo11566b(fVar.mo11568a());
        }
    }

    /* renamed from: a */
    public Map<UTDimensionValueSet, List<Event>> mo11555a(int i) {
        HashMap hashMap = new HashMap();
        synchronized (this.f3157b) {
            ArrayList arrayList = new ArrayList(this.f3157b.keySet());
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                UTDimensionValueSet uTDimensionValueSet = (UTDimensionValueSet) arrayList.get(i2);
                if (uTDimensionValueSet != null && uTDimensionValueSet.mo11746c().intValue() == i) {
                    hashMap.put(uTDimensionValueSet, ((MetricValueSet) this.f3157b.get(uTDimensionValueSet)).mo11762a());
                    this.f3157b.remove(uTDimensionValueSet);
                }
            }
        }
        return hashMap;
    }

    /* renamed from: b */
    public void mo11565b() {
        ArrayList arrayList = new ArrayList(this.f3156a.keySet());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            String str = (String) arrayList.get(i);
            DurationEvent cVar = (DurationEvent) this.f3156a.get(str);
            if (cVar != null && cVar.mo11551a()) {
                this.f3156a.remove(str);
            }
        }
    }

    /* renamed from: b */
    public void mo11566b(int i) {
        final Map a = mo11555a(i);
        TaskExecutor.m3867a().mo11811a((Runnable) new Runnable() {
            public void run() {
                UTUtil.m3593a(a);
            }
        });
    }
}
