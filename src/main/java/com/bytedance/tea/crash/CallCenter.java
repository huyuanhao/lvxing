package com.bytedance.tea.crash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.bytedance.tea.crash.b */
public class CallCenter {
    /* renamed from: a */
    private Map<CrashType, List<AttachUserData>> f9248a = new HashMap();
    /* renamed from: b */
    private Map<String, String> f9249b = new HashMap();
    /* renamed from: c */
    private final List<ICrashCallback> f9250c = new CopyOnWriteArrayList();
    /* renamed from: d */
    private final List<ICrashCallback> f9251d = new CopyOnWriteArrayList();
    /* renamed from: e */
    private final List<ICrashCallback> f9252e = new CopyOnWriteArrayList();
    /* renamed from: f */
    private final List<ICrashCallback> f9253f = new CopyOnWriteArrayList();
    /* renamed from: g */
    private ICrashFilter f9254g = null;

    /* renamed from: a */
    public List<AttachUserData> mo16970a(CrashType cVar) {
        return (List) this.f9248a.get(cVar);
    }

    /* renamed from: a */
    public Map<String, String> mo16971a() {
        return this.f9249b;
    }

    /* renamed from: b */
    public List<ICrashCallback> mo16973b() {
        return this.f9251d;
    }

    /* renamed from: c */
    public List<ICrashCallback> mo16974c() {
        return this.f9253f;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo16972a(ICrashFilter fVar) {
        this.f9254g = fVar;
    }

    /* renamed from: d */
    public ICrashFilter mo16975d() {
        return this.f9254g;
    }
}
