package org.slf4j.helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.C8580b;
import org.slf4j.ILoggerFactory;
import org.slf4j.event.SubstituteLoggingEvent;

/* renamed from: org.slf4j.helpers.d */
public class SubstituteLoggerFactory implements ILoggerFactory {
    /* renamed from: a */
    boolean f29234a = false;
    /* renamed from: b */
    final Map<String, SubstituteLogger> f29235b = new HashMap();
    /* renamed from: c */
    final LinkedBlockingQueue<SubstituteLoggingEvent> f29236c = new LinkedBlockingQueue<>();

    /* renamed from: a */
    public synchronized C8580b mo41031a(String str) {
        SubstituteLogger cVar;
        cVar = (SubstituteLogger) this.f29235b.get(str);
        if (cVar == null) {
            cVar = new SubstituteLogger(str, this.f29236c, this.f29234a);
            this.f29235b.put(str, cVar);
        }
        return cVar;
    }

    /* renamed from: a */
    public List<SubstituteLogger> mo41116a() {
        return new ArrayList(this.f29235b.values());
    }

    /* renamed from: b */
    public LinkedBlockingQueue<SubstituteLoggingEvent> mo41117b() {
        return this.f29236c;
    }

    /* renamed from: c */
    public void mo41118c() {
        this.f29234a = true;
    }

    /* renamed from: d */
    public void mo41119d() {
        this.f29235b.clear();
        this.f29236c.clear();
    }
}
