package org.slf4j.event;

import org.slf4j.Marker;
import org.slf4j.helpers.SubstituteLogger;

/* renamed from: org.slf4j.event.c */
public class SubstituteLoggingEvent implements LoggingEvent {
    /* renamed from: a */
    Level f29218a;
    /* renamed from: b */
    Marker f29219b;
    /* renamed from: c */
    String f29220c;
    /* renamed from: d */
    SubstituteLogger f29221d;
    /* renamed from: e */
    String f29222e;
    /* renamed from: f */
    String f29223f;
    /* renamed from: g */
    Object[] f29224g;
    /* renamed from: h */
    long f29225h;
    /* renamed from: i */
    Throwable f29226i;

    /* renamed from: a */
    public void mo41070a(Level level) {
        this.f29218a = level;
    }

    /* renamed from: a */
    public void mo41069a(Marker marker) {
        this.f29219b = marker;
    }

    /* renamed from: a */
    public void mo41067a(String str) {
        this.f29220c = str;
    }

    /* renamed from: a */
    public SubstituteLogger mo41065a() {
        return this.f29221d;
    }

    /* renamed from: a */
    public void mo41071a(SubstituteLogger cVar) {
        this.f29221d = cVar;
    }

    /* renamed from: b */
    public void mo41073b(String str) {
        this.f29223f = str;
    }

    /* renamed from: a */
    public void mo41072a(Object[] objArr) {
        this.f29224g = objArr;
    }

    /* renamed from: a */
    public void mo41066a(long j) {
        this.f29225h = j;
    }

    /* renamed from: c */
    public void mo41074c(String str) {
        this.f29222e = str;
    }

    /* renamed from: a */
    public void mo41068a(Throwable th) {
        this.f29226i = th;
    }
}
