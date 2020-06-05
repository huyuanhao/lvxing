package com.tspoon.traceur;

import java.util.HashSet;

public final class RxJavaAssemblyException extends RuntimeException {
    private static final long serialVersionUID = -6757520270386306081L;
    final String stacktrace = buildStackTrace();

    public static String buildStackTrace() {
        StringBuilder sb = new StringBuilder();
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        sb.append("RxJavaAssemblyException: assembled\r\n");
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (filter(stackTraceElement)) {
                sb.append("at ");
                sb.append(stackTraceElement);
                sb.append("\r\n");
            }
        }
        return sb.toString();
    }

    private static boolean filter(StackTraceElement stackTraceElement) {
        if (stackTraceElement.getLineNumber() == 1) {
            return false;
        }
        String className = stackTraceElement.getClassName();
        return !className.contains("java.lang.Thread") && !className.contains("junit.runner") && !className.contains("org.junit.internal") && !className.contains("junit4.runner") && !className.contains("java.lang.reflect") && !className.contains("sun.reflect") && !className.contains(".RxJavaAssemblyException") && !className.contains("OnAssembly") && !className.contains("RxJavaAssemblyTracking") && !className.contains("RxJavaPlugins");
    }

    public String stacktrace() {
        return this.stacktrace;
    }

    public synchronized Throwable fillInStackTrace() {
        return this;
    }

    public Throwable appendLast(Throwable th) {
        HashSet hashSet = new HashSet();
        Throwable th2 = th;
        while (th2.getCause() != null) {
            if (!hashSet.add(th2)) {
                return th;
            }
            th2 = th2.getCause();
        }
        try {
            th2.initCause(this);
        } catch (Throwable unused) {
        }
        return th;
    }

    public static RxJavaAssemblyException find(Throwable th) {
        HashSet hashSet = new HashSet();
        while (th != null) {
            if (!(th instanceof RxJavaAssemblyException)) {
                if (!hashSet.add(th)) {
                    break;
                }
                th = th.getCause();
            } else {
                return (RxJavaAssemblyException) th;
            }
        }
        return null;
    }
}
