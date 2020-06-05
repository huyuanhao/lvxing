package com.tencent.stat.common;

import android.util.Log;
import com.tencent.p605ep.commonbase.api.ConfigManager.OEM;
import com.tencent.stat.StatConfig;
import com.tencent.stat.StatCustomLogger;

public final class StatLogger {
    /* renamed from: a */
    private String f25644a = OEM.DEFAULT;
    /* renamed from: b */
    private boolean f25645b = true;
    /* renamed from: c */
    private int f25646c = 2;

    public boolean isDebugEnable() {
        return this.f25645b;
    }

    public void setDebugEnable(boolean z) {
        this.f25645b = z;
    }

    public int getLogLevel() {
        return this.f25646c;
    }

    public void setLogLevel(int i) {
        this.f25646c = i;
    }

    public StatLogger() {
    }

    public StatLogger(String str) {
        this.f25644a = str;
    }

    public void setTag(String str) {
        this.f25644a = str;
    }

    /* renamed from: a */
    private String m32734a() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null) {
            return null;
        }
        int length = stackTrace.length;
        for (int i = 0; i < length; i++) {
            StackTraceElement stackTraceElement = stackTrace[i];
            if (!stackTraceElement.isNativeMethod() && !stackTraceElement.getClassName().equals(Thread.class.getName()) && !stackTraceElement.getClassName().equals(getClass().getName())) {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                sb.append(Thread.currentThread().getName());
                sb.append("(");
                sb.append(Thread.currentThread().getId());
                sb.append("): ");
                sb.append(stackTraceElement.getFileName());
                sb.append(":");
                sb.append(stackTraceElement.getLineNumber());
                sb.append("]");
                return sb.toString();
            }
        }
        return null;
    }

    public void info(Object obj) {
        String str;
        if (obj != null && this.f25646c <= 4) {
            String a = m32734a();
            if (a == null) {
                str = obj.toString();
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(a);
                sb.append(" - ");
                sb.append(obj);
                str = sb.toString();
            }
            Log.i(this.f25644a, str);
            StatCustomLogger customLogger = StatConfig.getCustomLogger();
            if (customLogger != null) {
                customLogger.info(str);
            }
        }
    }

    /* renamed from: i */
    public void mo37108i(Object obj) {
        if (isDebugEnable()) {
            info(obj);
        }
    }

    public void verbose(Object obj) {
        String str;
        if (this.f25646c <= 2) {
            String a = m32734a();
            if (a == null) {
                str = obj.toString();
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(a);
                sb.append(" - ");
                sb.append(obj);
                str = sb.toString();
            }
            Log.v(this.f25644a, str);
            StatCustomLogger customLogger = StatConfig.getCustomLogger();
            if (customLogger != null) {
                customLogger.verbose(str);
            }
        }
    }

    /* renamed from: v */
    public void mo37114v(Object obj) {
        if (isDebugEnable()) {
            verbose(obj);
        }
    }

    public void warn(Object obj) {
        String str;
        if (this.f25646c <= 5) {
            String a = m32734a();
            if (a == null) {
                str = obj.toString();
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(a);
                sb.append(" - ");
                sb.append(obj);
                str = sb.toString();
            }
            Log.w(this.f25644a, str);
            StatCustomLogger customLogger = StatConfig.getCustomLogger();
            if (customLogger != null) {
                customLogger.warn(str);
            }
        }
    }

    /* renamed from: w */
    public void mo37116w(Object obj) {
        if (isDebugEnable()) {
            warn(obj);
        }
    }

    public void error(Object obj) {
        String str;
        if (this.f25646c <= 6) {
            String a = m32734a();
            if (a == null) {
                str = obj.toString();
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(a);
                sb.append(" - ");
                sb.append(obj);
                str = sb.toString();
            }
            Log.e(this.f25644a, str);
            StatCustomLogger customLogger = StatConfig.getCustomLogger();
            if (customLogger != null) {
                customLogger.error((Object) str);
            }
        }
    }

    public void error(Throwable th) {
        if (this.f25646c <= 6) {
            Log.e(this.f25644a, "", th);
            StatCustomLogger customLogger = StatConfig.getCustomLogger();
            if (customLogger != null) {
                customLogger.error((Object) th);
            }
        }
    }

    /* renamed from: e */
    public void mo37103e(Object obj) {
        if (isDebugEnable()) {
            error(obj);
        }
    }

    /* renamed from: e */
    public void mo37104e(Throwable th) {
        if (isDebugEnable()) {
            error(th);
        }
    }

    public void debug(Object obj) {
        String str;
        if (this.f25646c <= 3) {
            String a = m32734a();
            if (a == null) {
                str = obj.toString();
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(a);
                sb.append(" - ");
                sb.append(obj);
                str = sb.toString();
            }
            Log.d(this.f25644a, str);
            StatCustomLogger customLogger = StatConfig.getCustomLogger();
            if (customLogger != null) {
                customLogger.debug(str);
            }
        }
    }

    /* renamed from: d */
    public void mo37101d(Object obj) {
        if (isDebugEnable()) {
            debug(obj);
        }
    }
}
