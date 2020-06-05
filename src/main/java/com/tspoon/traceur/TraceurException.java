package com.tspoon.traceur;

import com.tspoon.traceur.Traceur.LogLevel;
import java.util.ArrayList;

public class TraceurException extends RuntimeException {
    private final LogLevel logLevel;
    private final boolean shouldFilterStackTraces;

    public static TraceurException create() {
        TraceurConfig a = Traceur.m33054a();
        return new TraceurException(a.mo37352a(), a.mo37353b());
    }

    TraceurException(boolean z, LogLevel logLevel2) {
        super("Debug Exception generated at call site");
        this.shouldFilterStackTraces = z;
        this.logLevel = logLevel2;
        setStackTrace(createStackTrace());
    }

    public Throwable appendTo(Throwable th) {
        Throwable th2 = th;
        while (th2.getCause() != null) {
            th2 = th2.getCause();
            if (th2 == this) {
                return th;
            }
            if (this.logLevel == LogLevel.SHOW_ONLY_FIRST && (th2 instanceof TraceurException)) {
                return th;
            }
        }
        th2.initCause(this);
        return th;
    }

    private StackTraceElement[] createStackTrace() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (!this.shouldFilterStackTraces) {
            return stackTrace;
        }
        ArrayList arrayList = new ArrayList(stackTrace.length);
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (filterLine(stackTraceElement)) {
                arrayList.add(stackTraceElement);
            }
        }
        return (StackTraceElement[]) arrayList.toArray(new StackTraceElement[arrayList.size()]);
    }

    private boolean filterLine(StackTraceElement stackTraceElement) {
        String className = stackTraceElement.getClassName();
        return !className.contains(".Traceur") && !className.contains("OnAssembly") && !className.endsWith(".RxJavaPlugins");
    }
}
