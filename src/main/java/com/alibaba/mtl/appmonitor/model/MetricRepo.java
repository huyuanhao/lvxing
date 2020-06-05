package com.alibaba.mtl.appmonitor.model;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.alibaba.mtl.appmonitor.model.c */
public class MetricRepo {
    /* renamed from: b */
    private static MetricRepo f3267b;
    /* renamed from: a */
    public List<Metric> f3268a;

    /* renamed from: a */
    public static MetricRepo m3683a() {
        if (f3267b == null) {
            f3267b = new MetricRepo(3);
        }
        return f3267b;
    }

    private MetricRepo(int i) {
        this.f3268a = new ArrayList(i);
    }

    /* renamed from: a */
    public void mo11759a(Metric bVar) {
        if (!this.f3268a.contains(bVar)) {
            this.f3268a.add(bVar);
        }
    }

    /* renamed from: b */
    public boolean mo11760b(Metric bVar) {
        if (this.f3268a.contains(bVar)) {
            return this.f3268a.remove(bVar);
        }
        return true;
    }

    /* renamed from: a */
    public Metric mo11758a(String str, String str2) {
        if (!(str == null || str2 == null)) {
            List<Metric> list = this.f3268a;
            if (list != null) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    Metric bVar = (Metric) this.f3268a.get(i);
                    if (bVar != null && bVar.mo11751c().equals(str) && bVar.mo11752e().equals(str2)) {
                        return bVar;
                    }
                }
            }
        }
        return null;
    }
}
