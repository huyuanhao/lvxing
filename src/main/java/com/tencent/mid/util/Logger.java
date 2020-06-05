package com.tencent.mid.util;

import android.util.Log;
import com.tencent.p605ep.commonbase.api.ConfigManager.OEM;

public final class Logger {
    private static boolean debugEnable = false;
    private int logLevel = 2;
    private String tag = OEM.DEFAULT;

    public boolean isDebugEnable() {
        return debugEnable;
    }

    public void setDebugEnable(boolean z) {
        debugEnable = z;
    }

    public int getLogLevel() {
        return this.logLevel;
    }

    public void setLogLevel(int i) {
        this.logLevel = i;
    }

    public Logger() {
    }

    public Logger(String str) {
        this.tag = str;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    private String getLoggerClassInfo() {
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
        if (this.logLevel <= 4) {
            String loggerClassInfo = getLoggerClassInfo();
            if (loggerClassInfo == null) {
                str = obj.toString();
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(loggerClassInfo);
                sb.append(" - ");
                sb.append(obj);
                str = sb.toString();
            }
            Log.i(this.tag, str);
        }
    }

    /* renamed from: i */
    public void mo35700i(Object obj) {
        if (isDebugEnable()) {
            info(obj);
        }
    }

    public void verbose(Object obj) {
        String str;
        if (this.logLevel <= 2) {
            String loggerClassInfo = getLoggerClassInfo();
            if (loggerClassInfo == null) {
                str = obj.toString();
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(loggerClassInfo);
                sb.append(" - ");
                sb.append(obj);
                str = sb.toString();
            }
            Log.v(this.tag, str);
        }
    }

    /* renamed from: v */
    public void mo35706v(Object obj) {
        if (isDebugEnable()) {
            verbose(obj);
        }
    }

    public void warn(Object obj) {
        String str;
        if (this.logLevel <= 5) {
            String loggerClassInfo = getLoggerClassInfo();
            if (loggerClassInfo == null) {
                str = obj.toString();
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(loggerClassInfo);
                sb.append(" - ");
                sb.append(obj);
                str = sb.toString();
            }
            Log.w(this.tag, str);
        }
    }

    /* renamed from: w */
    public void mo35708w(Object obj) {
        if (isDebugEnable()) {
            warn(obj);
        }
    }

    public void error(Object obj) {
        String str;
        if (this.logLevel <= 6) {
            String loggerClassInfo = getLoggerClassInfo();
            if (loggerClassInfo == null) {
                str = obj.toString();
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(loggerClassInfo);
                sb.append(" - ");
                sb.append(obj);
                str = sb.toString();
            }
            Log.e(this.tag, str);
        }
    }

    public void error(Exception exc) {
        if (this.logLevel <= 6) {
            StringBuffer stringBuffer = new StringBuffer();
            String loggerClassInfo = getLoggerClassInfo();
            StackTraceElement[] stackTrace = exc.getStackTrace();
            String str = "\r\n";
            if (loggerClassInfo != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(loggerClassInfo);
                sb.append(" - ");
                sb.append(exc);
                sb.append(str);
                stringBuffer.append(sb.toString());
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(exc);
                sb2.append(str);
                stringBuffer.append(sb2.toString());
            }
            if (stackTrace != null && stackTrace.length > 0) {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    if (stackTraceElement != null) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("[ ");
                        sb3.append(stackTraceElement.getFileName());
                        sb3.append(":");
                        sb3.append(stackTraceElement.getLineNumber());
                        sb3.append(" ]\r\n");
                        stringBuffer.append(sb3.toString());
                    }
                }
            }
            Log.e(this.tag, stringBuffer.toString());
        }
    }

    /* renamed from: e */
    public void mo35696e(Object obj) {
        if (isDebugEnable()) {
            error(obj);
        }
    }

    /* renamed from: e */
    public void mo35695e(Exception exc) {
        if (isDebugEnable()) {
            error(exc);
        }
    }

    public void debug(Object obj) {
        String str;
        if (this.logLevel <= 3) {
            String loggerClassInfo = getLoggerClassInfo();
            if (loggerClassInfo == null) {
                str = obj.toString();
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(loggerClassInfo);
                sb.append(" - ");
                sb.append(obj);
                str = sb.toString();
            }
            Log.d(this.tag, str);
        }
    }

    /* renamed from: d */
    public void mo35693d(Object obj) {
        if (isDebugEnable()) {
            debug(obj);
        }
    }
}
