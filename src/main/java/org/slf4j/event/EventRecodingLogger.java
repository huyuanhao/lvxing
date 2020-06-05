package org.slf4j.event;

import java.util.Queue;
import org.slf4j.C8580b;
import org.slf4j.Marker;
import org.slf4j.helpers.SubstituteLogger;

/* renamed from: org.slf4j.event.a */
public class EventRecodingLogger implements C8580b {
    /* renamed from: a */
    String f29215a;
    /* renamed from: b */
    SubstituteLogger f29216b;
    /* renamed from: c */
    Queue<SubstituteLoggingEvent> f29217c;

    public boolean isDebugEnabled() {
        return true;
    }

    public boolean isErrorEnabled() {
        return true;
    }

    public boolean isInfoEnabled() {
        return true;
    }

    public boolean isTraceEnabled() {
        return true;
    }

    public boolean isWarnEnabled() {
        return true;
    }

    public EventRecodingLogger(SubstituteLogger cVar, Queue<SubstituteLoggingEvent> queue) {
        this.f29216b = cVar;
        this.f29215a = cVar.getName();
        this.f29217c = queue;
    }

    public String getName() {
        return this.f29215a;
    }

    /* renamed from: a */
    private void m37334a(Level level, String str, Object[] objArr, Throwable th) {
        m37335a(level, null, str, objArr, th);
    }

    /* renamed from: a */
    private void m37335a(Level level, Marker marker, String str, Object[] objArr, Throwable th) {
        SubstituteLoggingEvent cVar = new SubstituteLoggingEvent();
        cVar.mo41066a(System.currentTimeMillis());
        cVar.mo41070a(level);
        cVar.mo41071a(this.f29216b);
        cVar.mo41067a(this.f29215a);
        cVar.mo41069a(marker);
        cVar.mo41073b(str);
        cVar.mo41072a(objArr);
        cVar.mo41068a(th);
        cVar.mo41074c(Thread.currentThread().getName());
        this.f29217c.add(cVar);
    }

    public void trace(String str) {
        m37334a(Level.TRACE, str, null, null);
    }

    public void trace(String str, Object obj) {
        m37334a(Level.TRACE, str, new Object[]{obj}, null);
    }

    public void trace(String str, Object obj, Object obj2) {
        m37334a(Level.TRACE, str, new Object[]{obj, obj2}, null);
    }

    public void trace(String str, Object... objArr) {
        m37334a(Level.TRACE, str, objArr, null);
    }

    public void trace(String str, Throwable th) {
        m37334a(Level.TRACE, str, null, th);
    }

    public void debug(String str) {
        m37334a(Level.TRACE, str, null, null);
    }

    public void debug(String str, Object obj) {
        m37334a(Level.DEBUG, str, new Object[]{obj}, null);
    }

    public void debug(String str, Object obj, Object obj2) {
        m37334a(Level.DEBUG, str, new Object[]{obj, obj2}, null);
    }

    public void debug(String str, Object... objArr) {
        m37334a(Level.DEBUG, str, objArr, null);
    }

    public void debug(String str, Throwable th) {
        m37334a(Level.DEBUG, str, null, th);
    }

    public void info(String str) {
        m37334a(Level.INFO, str, null, null);
    }

    public void info(String str, Object obj) {
        m37334a(Level.INFO, str, new Object[]{obj}, null);
    }

    public void info(String str, Object obj, Object obj2) {
        m37334a(Level.INFO, str, new Object[]{obj, obj2}, null);
    }

    public void info(String str, Object... objArr) {
        m37334a(Level.INFO, str, objArr, null);
    }

    public void info(String str, Throwable th) {
        m37334a(Level.INFO, str, null, th);
    }

    public void warn(String str) {
        m37334a(Level.WARN, str, null, null);
    }

    public void warn(String str, Object obj) {
        m37334a(Level.WARN, str, new Object[]{obj}, null);
    }

    public void warn(String str, Object obj, Object obj2) {
        m37334a(Level.WARN, str, new Object[]{obj, obj2}, null);
    }

    public void warn(String str, Object... objArr) {
        m37334a(Level.WARN, str, objArr, null);
    }

    public void warn(String str, Throwable th) {
        m37334a(Level.WARN, str, null, th);
    }

    public void error(String str) {
        m37334a(Level.ERROR, str, null, null);
    }

    public void error(String str, Object obj) {
        m37334a(Level.ERROR, str, new Object[]{obj}, null);
    }

    public void error(String str, Object obj, Object obj2) {
        m37334a(Level.ERROR, str, new Object[]{obj, obj2}, null);
    }

    public void error(String str, Object... objArr) {
        m37334a(Level.ERROR, str, objArr, null);
    }

    public void error(String str, Throwable th) {
        m37334a(Level.ERROR, str, null, th);
    }
}
