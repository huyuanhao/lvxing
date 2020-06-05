package com.alibaba.android.arouter.p045c;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.android.arouter.facade.template.ILogger;

/* renamed from: com.alibaba.android.arouter.c.b */
public class DefaultLogger implements ILogger {
    /* renamed from: a */
    private static boolean f2277a = false;
    /* renamed from: b */
    private static boolean f2278b = false;
    /* renamed from: c */
    private static boolean f2279c = false;
    /* renamed from: d */
    private String f2280d = "ARouter";

    public void showLog(boolean z) {
        f2277a = z;
    }

    public void showStackTrace(boolean z) {
        f2278b = z;
    }

    public DefaultLogger() {
    }

    public DefaultLogger(String str) {
        this.f2280d = str;
    }

    public void debug(String str, String str2) {
        if (f2277a) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            if (TextUtils.isEmpty(str)) {
                str = getDefaultTag();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(m2158a(stackTraceElement));
            Log.d(str, sb.toString());
        }
    }

    public void info(String str, String str2) {
        if (f2277a) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            if (TextUtils.isEmpty(str)) {
                str = getDefaultTag();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(m2158a(stackTraceElement));
            Log.i(str, sb.toString());
        }
    }

    public void warning(String str, String str2) {
        if (f2277a) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            if (TextUtils.isEmpty(str)) {
                str = getDefaultTag();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(m2158a(stackTraceElement));
            Log.w(str, sb.toString());
        }
    }

    public void error(String str, String str2) {
        if (f2277a) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            if (TextUtils.isEmpty(str)) {
                str = getDefaultTag();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(m2158a(stackTraceElement));
            Log.e(str, sb.toString());
        }
    }

    public void monitor(String str) {
        if (f2277a && isMonitorMode()) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            StringBuilder sb = new StringBuilder();
            sb.append(this.f2280d);
            sb.append("::monitor");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append(m2158a(stackTraceElement));
            Log.d(sb2, sb3.toString());
        }
    }

    public boolean isMonitorMode() {
        return f2279c;
    }

    public String getDefaultTag() {
        return this.f2280d;
    }

    /* renamed from: a */
    public static String m2158a(StackTraceElement stackTraceElement) {
        StringBuilder sb = new StringBuilder("[");
        if (f2278b) {
            String name = Thread.currentThread().getName();
            String fileName = stackTraceElement.getFileName();
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            long id = Thread.currentThread().getId();
            int lineNumber = stackTraceElement.getLineNumber();
            sb.append("ThreadId=");
            sb.append(id);
            String str = " & ";
            sb.append(str);
            sb.append("ThreadName=");
            sb.append(name);
            sb.append(str);
            sb.append("FileName=");
            sb.append(fileName);
            sb.append(str);
            sb.append("ClassName=");
            sb.append(className);
            sb.append(str);
            sb.append("MethodName=");
            sb.append(methodName);
            sb.append(str);
            sb.append("LineNumber=");
            sb.append(lineNumber);
        }
        sb.append(" ] ");
        return sb.toString();
    }
}
