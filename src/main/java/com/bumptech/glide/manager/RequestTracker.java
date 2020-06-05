package com.bumptech.glide.manager;

import android.util.Log;
import com.bumptech.glide.p131c.Request;
import com.bumptech.glide.util.C1772j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* renamed from: com.bumptech.glide.manager.n */
public class RequestTracker {
    /* renamed from: a */
    private final Set<Request> f4888a = Collections.newSetFromMap(new WeakHashMap());
    /* renamed from: b */
    private final List<Request> f4889b = new ArrayList();
    /* renamed from: c */
    private boolean f4890c;

    /* renamed from: a */
    public void mo13185a(Request cVar) {
        this.f4888a.add(cVar);
        if (!this.f4890c) {
            cVar.mo12490a();
            return;
        }
        cVar.mo12493b();
        String str = "RequestTracker";
        if (Log.isLoggable(str, 2)) {
            Log.v(str, "Paused, delaying request");
        }
        this.f4889b.add(cVar);
    }

    /* renamed from: b */
    public boolean mo13187b(Request cVar) {
        return m6069a(cVar, true);
    }

    /* renamed from: a */
    private boolean m6069a(Request cVar, boolean z) {
        boolean z2 = true;
        if (cVar == null) {
            return true;
        }
        boolean remove = this.f4888a.remove(cVar);
        if (!this.f4889b.remove(cVar) && !remove) {
            z2 = false;
        }
        if (z2) {
            cVar.mo12493b();
            if (z) {
                cVar.mo12503h();
            }
        }
        return z2;
    }

    /* renamed from: a */
    public void mo13184a() {
        this.f4890c = true;
        for (Request cVar : C1772j.m6152a((Collection<T>) this.f4888a)) {
            if (cVar.mo12495c()) {
                cVar.mo12493b();
                this.f4889b.add(cVar);
            }
        }
    }

    /* renamed from: b */
    public void mo13186b() {
        this.f4890c = false;
        for (Request cVar : C1772j.m6152a((Collection<T>) this.f4888a)) {
            if (!cVar.mo12504h_() && !cVar.mo12495c()) {
                cVar.mo12490a();
            }
        }
        this.f4889b.clear();
    }

    /* renamed from: c */
    public void mo13188c() {
        for (Request a : C1772j.m6152a((Collection<T>) this.f4888a)) {
            m6069a(a, false);
        }
        this.f4889b.clear();
    }

    /* renamed from: d */
    public void mo13189d() {
        for (Request cVar : C1772j.m6152a((Collection<T>) this.f4888a)) {
            if (!cVar.mo12504h_() && !cVar.mo12501f()) {
                cVar.mo12493b();
                if (!this.f4890c) {
                    cVar.mo12490a();
                } else {
                    this.f4889b.add(cVar);
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("{numRequests=");
        sb.append(this.f4888a.size());
        sb.append(", isPaused=");
        sb.append(this.f4890c);
        sb.append("}");
        return sb.toString();
    }
}
