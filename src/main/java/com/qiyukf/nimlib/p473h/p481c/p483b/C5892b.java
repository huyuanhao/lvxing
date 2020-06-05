package com.qiyukf.nimlib.p473h.p481c.p483b;

import android.util.SparseArray;
import com.qiyukf.nimlib.p473h.p481c.p484c.C5894b;
import com.qiyukf.nimlib.p473h.p481c.p484c.C5898f;

/* renamed from: com.qiyukf.nimlib.h.c.b.b */
public final class C5892b implements C5891a {
    /* renamed from: a */
    public SparseArray<String> f18650a = new SparseArray<>();

    /* renamed from: a */
    public final String mo28239a(int i) {
        return (String) this.f18650a.get(i);
    }

    /* renamed from: a */
    public final void mo28240a(int i, int i2) {
        this.f18650a.put(i, String.valueOf(i2));
    }

    /* renamed from: a */
    public final void mo28241a(int i, String str) {
        if (str != null) {
            this.f18650a.put(i, str);
        }
    }

    /* renamed from: a */
    public final void mo28223a(C5894b bVar) {
        bVar.mo28255b(this.f18650a.size());
        for (int i = 0; i < this.f18650a.size(); i++) {
            bVar.mo28255b(this.f18650a.keyAt(i));
            bVar.mo28250a((String) this.f18650a.valueAt(i));
        }
    }

    /* renamed from: a */
    public final void mo28224a(C5898f fVar) {
        int f = fVar.mo28267f();
        for (int i = 0; i < f; i++) {
            mo28241a(fVar.mo28267f(), fVar.mo28262a("utf-8"));
        }
    }

    /* renamed from: b */
    public final int mo28242b(int i) {
        String str = (String) this.f18650a.get(i);
        if (str != null && !str.equals("")) {
            try {
                return Integer.parseInt(str);
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    /* renamed from: c */
    public final long mo28243c(int i) {
        String str = (String) this.f18650a.get(i);
        long j = 0;
        if (str == null || str.equals("")) {
            return 0;
        }
        try {
            j = Long.parseLong(str);
            return j;
        } catch (Exception unused) {
            return j;
        }
    }

    public final String toString() {
        return this.f18650a.toString();
    }
}
