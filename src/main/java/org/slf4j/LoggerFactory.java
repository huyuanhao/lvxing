package org.slf4j;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.event.LoggingEvent;
import org.slf4j.event.SubstituteLoggingEvent;
import org.slf4j.helpers.C8581e;
import org.slf4j.helpers.NOPLoggerFactory;
import org.slf4j.helpers.SubstituteLogger;
import org.slf4j.helpers.SubstituteLoggerFactory;
import org.slf4j.impl.StaticLoggerBinder;

/* renamed from: org.slf4j.c */
public final class LoggerFactory {
    /* renamed from: a */
    static volatile int f29209a;
    /* renamed from: b */
    static final SubstituteLoggerFactory f29210b = new SubstituteLoggerFactory();
    /* renamed from: c */
    static final NOPLoggerFactory f29211c = new NOPLoggerFactory();
    /* renamed from: d */
    static boolean f29212d = C8581e.m37363b("slf4j.detectLoggerNameMismatch");
    /* renamed from: e */
    private static final String[] f29213e = {"1.6", "1.7"};
    /* renamed from: f */
    private static String f29214f = "org/slf4j/impl/StaticLoggerBinder.class";

    private LoggerFactory() {
    }

    /* renamed from: c */
    private static final void m37326c() {
        m37328d();
        if (f29209a == 3) {
            m37332h();
        }
    }

    /* renamed from: b */
    private static boolean m37325b(String str) {
        if (str == null) {
            return false;
        }
        return str.contains("org/slf4j/impl/StaticLoggerBinder") || str.contains("org.slf4j.impl.StaticLoggerBinder");
    }

    /* renamed from: d */
    private static final void m37328d() {
        Set set = null;
        try {
            if (!m37333i()) {
                set = m37314a();
                m37324b(set);
            }
            StaticLoggerBinder.getSingleton();
            f29209a = 3;
            m37327c(set);
            m37329e();
            m37330f();
            f29210b.mo41119d();
        } catch (NoClassDefFoundError e) {
            if (m37325b(e.getMessage())) {
                f29209a = 4;
                C8581e.m37365c("Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".");
                C8581e.m37365c("Defaulting to no-operation (NOP) logger implementation");
                C8581e.m37365c("See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.");
                return;
            }
            m37318a((Throwable) e);
            throw e;
        } catch (NoSuchMethodError e2) {
            String message = e2.getMessage();
            if (message != null && message.contains("org.slf4j.impl.StaticLoggerBinder.getSingleton()")) {
                f29209a = 2;
                C8581e.m37365c("slf4j-api 1.6.x (or later) is incompatible with this binding.");
                C8581e.m37365c("Your binding is version 1.5.5 or earlier.");
                C8581e.m37365c("Upgrade your binding to version 1.6.x.");
            }
            throw e2;
        } catch (Exception e3) {
            m37318a((Throwable) e3);
            throw new IllegalStateException("Unexpected initialization failure", e3);
        }
    }

    /* renamed from: e */
    private static void m37329e() {
        synchronized (f29210b) {
            f29210b.mo41118c();
            for (SubstituteLogger cVar : f29210b.mo41116a()) {
                cVar.mo41109a(m37316a(cVar.getName()));
            }
        }
    }

    /* renamed from: a */
    static void m37318a(Throwable th) {
        f29209a = 2;
        C8581e.m37361a("Failed to instantiate SLF4J LoggerFactory", th);
    }

    /* renamed from: f */
    private static void m37330f() {
        LinkedBlockingQueue b = f29210b.mo41117b();
        int size = b.size();
        ArrayList<SubstituteLoggingEvent> arrayList = new ArrayList<>(128);
        int i = 0;
        while (b.drainTo(arrayList, 128) != 0) {
            for (SubstituteLoggingEvent cVar : arrayList) {
                m37319a(cVar);
                int i2 = i + 1;
                if (i == 0) {
                    m37320a(cVar, size);
                }
                i = i2;
            }
            arrayList.clear();
        }
    }

    /* renamed from: a */
    private static void m37320a(SubstituteLoggingEvent cVar, int i) {
        if (cVar.mo41065a().mo41111b()) {
            m37317a(i);
        } else if (!cVar.mo41065a().mo41113d()) {
            m37331g();
        }
    }

    /* renamed from: a */
    private static void m37319a(SubstituteLoggingEvent cVar) {
        if (cVar != null) {
            SubstituteLogger a = cVar.mo41065a();
            String name = a.getName();
            if (!a.mo41112c()) {
                if (!a.mo41113d()) {
                    if (a.mo41111b()) {
                        a.mo41110a((LoggingEvent) cVar);
                    } else {
                        C8581e.m37365c(name);
                    }
                }
                return;
            }
            throw new IllegalStateException("Delegate logger cannot be null at this state.");
        }
    }

    /* renamed from: g */
    private static void m37331g() {
        C8581e.m37365c("The following set of substitute loggers may have been accessed");
        C8581e.m37365c("during the initialization phase. Logging calls during this");
        C8581e.m37365c("phase were not honored. However, subsequent logging calls to these");
        C8581e.m37365c("loggers will work as normally expected.");
        C8581e.m37365c("See also http://www.slf4j.org/codes.html#substituteLogger");
    }

    /* renamed from: a */
    private static void m37317a(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("A number (");
        sb.append(i);
        sb.append(") of logging calls during the initialization phase have been intercepted and are");
        C8581e.m37365c(sb.toString());
        C8581e.m37365c("now being replayed. These are subject to the filtering rules of the underlying logging system.");
        C8581e.m37365c("See also http://www.slf4j.org/codes.html#replay");
    }

    /* renamed from: h */
    private static final void m37332h() {
        try {
            String str = StaticLoggerBinder.REQUESTED_API_VERSION;
            boolean z = false;
            for (String startsWith : f29213e) {
                if (str.startsWith(startsWith)) {
                    z = true;
                }
            }
            if (!z) {
                StringBuilder sb = new StringBuilder();
                sb.append("The requested version ");
                sb.append(str);
                sb.append(" by your slf4j binding is not compatible with ");
                sb.append(Arrays.asList(f29213e).toString());
                C8581e.m37365c(sb.toString());
                C8581e.m37365c("See http://www.slf4j.org/codes.html#version_mismatch for further details.");
            }
        } catch (NoSuchFieldError unused) {
        } catch (Throwable th) {
            C8581e.m37361a("Unexpected problem occured during version sanity check", th);
        }
    }

    /* renamed from: a */
    static Set<URL> m37314a() {
        Enumeration enumeration;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        try {
            ClassLoader classLoader = LoggerFactory.class.getClassLoader();
            if (classLoader == null) {
                enumeration = ClassLoader.getSystemResources(f29214f);
            } else {
                enumeration = classLoader.getResources(f29214f);
            }
            while (enumeration.hasMoreElements()) {
                linkedHashSet.add((URL) enumeration.nextElement());
            }
        } catch (IOException e) {
            C8581e.m37361a("Error getting resources from path", e);
        }
        return linkedHashSet;
    }

    /* renamed from: a */
    private static boolean m37322a(Set<URL> set) {
        return set.size() > 1;
    }

    /* renamed from: b */
    private static void m37324b(Set<URL> set) {
        if (m37322a(set)) {
            C8581e.m37365c("Class path contains multiple SLF4J bindings.");
            for (URL url : set) {
                StringBuilder sb = new StringBuilder();
                sb.append("Found binding in [");
                sb.append(url);
                sb.append("]");
                C8581e.m37365c(sb.toString());
            }
            C8581e.m37365c("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }

    /* renamed from: i */
    private static boolean m37333i() {
        String a = C8581e.m37360a("java.vendor.url");
        if (a == null) {
            return false;
        }
        return a.toLowerCase().contains("android");
    }

    /* renamed from: c */
    private static void m37327c(Set<URL> set) {
        if (set != null && m37322a(set)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Actual binding is of type [");
            sb.append(StaticLoggerBinder.getSingleton().getLoggerFactoryClassStr());
            sb.append("]");
            C8581e.m37365c(sb.toString());
        }
    }

    /* renamed from: a */
    public static C8580b m37316a(String str) {
        return m37323b().mo41031a(str);
    }

    /* renamed from: a */
    public static C8580b m37315a(Class<?> cls) {
        C8580b a = m37316a(cls.getName());
        if (f29212d) {
            Class a2 = C8581e.m37359a();
            if (a2 != null && m37321a(cls, a2)) {
                C8581e.m37365c(String.format("Detected logger name mismatch. Given name: \"%s\"; computed name: \"%s\".", new Object[]{a.getName(), a2.getName()}));
                C8581e.m37365c("See http://www.slf4j.org/codes.html#loggerNameMismatch for an explanation");
            }
        }
        return a;
    }

    /* renamed from: a */
    private static boolean m37321a(Class<?> cls, Class<?> cls2) {
        return !cls2.isAssignableFrom(cls);
    }

    /* renamed from: b */
    public static ILoggerFactory m37323b() {
        if (f29209a == 0) {
            synchronized (LoggerFactory.class) {
                if (f29209a == 0) {
                    f29209a = 1;
                    m37326c();
                }
            }
        }
        int i = f29209a;
        if (i == 1) {
            return f29210b;
        }
        if (i == 2) {
            throw new IllegalStateException("org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER. See also http://www.slf4j.org/codes.html#unsuccessfulInit");
        } else if (i == 3) {
            return StaticLoggerBinder.getSingleton().getLoggerFactory();
        } else {
            if (i == 4) {
                return f29211c;
            }
            throw new IllegalStateException("Unreachable code");
        }
    }
}
