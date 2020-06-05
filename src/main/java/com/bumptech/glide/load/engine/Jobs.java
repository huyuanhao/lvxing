package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.bumptech.glide.load.engine.r */
final class Jobs {
    /* renamed from: a */
    private final Map<Key, EngineJob<?>> f4706a = new HashMap();
    /* renamed from: b */
    private final Map<Key, EngineJob<?>> f4707b = new HashMap();

    Jobs() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public EngineJob<?> mo12908a(Key cVar, boolean z) {
        return (EngineJob) m5731a(z).get(cVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo12909a(Key cVar, EngineJob<?> lVar) {
        m5731a(lVar.mo12874a()).put(cVar, lVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo12910b(Key cVar, EngineJob<?> lVar) {
        Map a = m5731a(lVar.mo12874a());
        if (lVar.equals(a.get(cVar))) {
            a.remove(cVar);
        }
    }

    /* renamed from: a */
    private Map<Key, EngineJob<?>> m5731a(boolean z) {
        return z ? this.f4707b : this.f4706a;
    }
}
