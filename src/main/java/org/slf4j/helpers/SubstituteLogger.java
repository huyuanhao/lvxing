package org.slf4j.helpers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Queue;
import org.slf4j.C8580b;
import org.slf4j.event.EventRecodingLogger;
import org.slf4j.event.LoggingEvent;
import org.slf4j.event.SubstituteLoggingEvent;

/* renamed from: org.slf4j.helpers.c */
public class SubstituteLogger implements C8580b {
    /* renamed from: a */
    private final String f29227a;
    /* renamed from: b */
    private volatile C8580b f29228b;
    /* renamed from: c */
    private Boolean f29229c;
    /* renamed from: d */
    private Method f29230d;
    /* renamed from: e */
    private EventRecodingLogger f29231e;
    /* renamed from: f */
    private Queue<SubstituteLoggingEvent> f29232f;
    /* renamed from: g */
    private final boolean f29233g;

    public SubstituteLogger(String str, Queue<SubstituteLoggingEvent> queue, boolean z) {
        this.f29227a = str;
        this.f29232f = queue;
        this.f29233g = z;
    }

    public String getName() {
        return this.f29227a;
    }

    public boolean isTraceEnabled() {
        return mo41108a().isTraceEnabled();
    }

    public void trace(String str) {
        mo41108a().trace(str);
    }

    public void trace(String str, Object obj) {
        mo41108a().trace(str, obj);
    }

    public void trace(String str, Object obj, Object obj2) {
        mo41108a().trace(str, obj, obj2);
    }

    public void trace(String str, Object... objArr) {
        mo41108a().trace(str, objArr);
    }

    public void trace(String str, Throwable th) {
        mo41108a().trace(str, th);
    }

    public boolean isDebugEnabled() {
        return mo41108a().isDebugEnabled();
    }

    public void debug(String str) {
        mo41108a().debug(str);
    }

    public void debug(String str, Object obj) {
        mo41108a().debug(str, obj);
    }

    public void debug(String str, Object obj, Object obj2) {
        mo41108a().debug(str, obj, obj2);
    }

    public void debug(String str, Object... objArr) {
        mo41108a().debug(str, objArr);
    }

    public void debug(String str, Throwable th) {
        mo41108a().debug(str, th);
    }

    public boolean isInfoEnabled() {
        return mo41108a().isInfoEnabled();
    }

    public void info(String str) {
        mo41108a().info(str);
    }

    public void info(String str, Object obj) {
        mo41108a().info(str, obj);
    }

    public void info(String str, Object obj, Object obj2) {
        mo41108a().info(str, obj, obj2);
    }

    public void info(String str, Object... objArr) {
        mo41108a().info(str, objArr);
    }

    public void info(String str, Throwable th) {
        mo41108a().info(str, th);
    }

    public boolean isWarnEnabled() {
        return mo41108a().isWarnEnabled();
    }

    public void warn(String str) {
        mo41108a().warn(str);
    }

    public void warn(String str, Object obj) {
        mo41108a().warn(str, obj);
    }

    public void warn(String str, Object obj, Object obj2) {
        mo41108a().warn(str, obj, obj2);
    }

    public void warn(String str, Object... objArr) {
        mo41108a().warn(str, objArr);
    }

    public void warn(String str, Throwable th) {
        mo41108a().warn(str, th);
    }

    public boolean isErrorEnabled() {
        return mo41108a().isErrorEnabled();
    }

    public void error(String str) {
        mo41108a().error(str);
    }

    public void error(String str, Object obj) {
        mo41108a().error(str, obj);
    }

    public void error(String str, Object obj, Object obj2) {
        mo41108a().error(str, obj, obj2);
    }

    public void error(String str, Object... objArr) {
        mo41108a().error(str, objArr);
    }

    public void error(String str, Throwable th) {
        mo41108a().error(str, th);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f29227a.equals(((SubstituteLogger) obj).f29227a);
    }

    public int hashCode() {
        return this.f29227a.hashCode();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C8580b mo41108a() {
        if (this.f29228b != null) {
            return this.f29228b;
        }
        if (this.f29233g) {
            return NOPLogger.NOP_LOGGER;
        }
        return m37347e();
    }

    /* renamed from: e */
    private C8580b m37347e() {
        if (this.f29231e == null) {
            this.f29231e = new EventRecodingLogger(this, this.f29232f);
        }
        return this.f29231e;
    }

    /* renamed from: a */
    public void mo41109a(C8580b bVar) {
        this.f29228b = bVar;
    }

    /* renamed from: b */
    public boolean mo41111b() {
        Boolean bool = this.f29229c;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            this.f29230d = this.f29228b.getClass().getMethod("log", new Class[]{LoggingEvent.class});
            this.f29229c = Boolean.TRUE;
        } catch (NoSuchMethodException unused) {
            this.f29229c = Boolean.FALSE;
        }
        return this.f29229c.booleanValue();
    }

    /* renamed from: a */
    public void mo41110a(LoggingEvent bVar) {
        if (mo41111b()) {
            try {
                this.f29230d.invoke(this.f29228b, new Object[]{bVar});
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
        }
    }

    /* renamed from: c */
    public boolean mo41112c() {
        return this.f29228b == null;
    }

    /* renamed from: d */
    public boolean mo41113d() {
        return this.f29228b instanceof NOPLogger;
    }
}
