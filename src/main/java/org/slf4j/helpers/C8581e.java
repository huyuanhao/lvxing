package org.slf4j.helpers;

import java.io.PrintStream;

/* compiled from: Util */
/* renamed from: org.slf4j.helpers.e */
public final class C8581e {
    /* renamed from: a */
    private static C8583a f29237a = null;
    /* renamed from: b */
    private static boolean f29238b = false;

    /* compiled from: Util */
    /* renamed from: org.slf4j.helpers.e$a */
    private static final class C8583a extends SecurityManager {
        private C8583a() {
        }

        /* access modifiers changed from: protected */
        public Class<?>[] getClassContext() {
            return super.getClassContext();
        }
    }

    private C8581e() {
    }

    /* renamed from: a */
    public static String m37360a(String str) {
        if (str != null) {
            String str2 = null;
            try {
                str2 = System.getProperty(str);
                return str2;
            } catch (SecurityException unused) {
                return str2;
            }
        } else {
            throw new IllegalArgumentException("null input");
        }
    }

    /* renamed from: b */
    public static boolean m37363b(String str) {
        String a = m37360a(str);
        if (a == null) {
            return false;
        }
        return a.equalsIgnoreCase("true");
    }

    /* renamed from: b */
    private static C8583a m37362b() {
        C8583a aVar = f29237a;
        if (aVar != null) {
            return aVar;
        }
        if (f29238b) {
            return null;
        }
        f29237a = m37364c();
        f29238b = true;
        return f29237a;
    }

    /* renamed from: c */
    private static C8583a m37364c() {
        try {
            return new C8583a();
        } catch (SecurityException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static Class<?> m37359a() {
        C8583a b = m37362b();
        if (b == null) {
            return null;
        }
        Class<?>[] classContext = b.getClassContext();
        String name = C8581e.class.getName();
        int i = 0;
        while (i < classContext.length && !name.equals(classContext[i].getName())) {
            i++;
        }
        if (i < classContext.length) {
            int i2 = i + 2;
            if (i2 < classContext.length) {
                return classContext[i2];
            }
        }
        throw new IllegalStateException("Failed to find org.slf4j.helpers.Util or its caller in the stack; this should not happen");
    }

    /* renamed from: a */
    public static final void m37361a(String str, Throwable th) {
        System.err.println(str);
        System.err.println("Reported exception:");
        th.printStackTrace();
    }

    /* renamed from: c */
    public static final void m37365c(String str) {
        PrintStream printStream = System.err;
        StringBuilder sb = new StringBuilder();
        sb.append("SLF4J: ");
        sb.append(str);
        printStream.println(sb.toString());
    }
}
