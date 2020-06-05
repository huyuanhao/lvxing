package com.elvishew.xlog.p224c.p225a;

import com.elvishew.xlog.XLog;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

/* renamed from: com.elvishew.xlog.c.a.b */
public class StackTraceUtil {
    /* renamed from: a */
    private static final String f9454a;

    static {
        String name = XLog.class.getName();
        f9454a = name.substring(0, name.lastIndexOf(46) + 1);
    }

    /* renamed from: a */
    public static String m12666a(Throwable th) {
        String str = "";
        if (th == null) {
            return str;
        }
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof UnknownHostException) {
                return str;
            }
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }

    /* renamed from: a */
    public static StackTraceElement[] m12669a(StackTraceElement[] stackTraceElementArr, String str, int i) {
        return m12667a(m12668a(stackTraceElementArr, str), i);
    }

    /* renamed from: a */
    private static StackTraceElement[] m12668a(StackTraceElement[] stackTraceElementArr, String str) {
        int i;
        int length = stackTraceElementArr.length;
        int i2 = length - 1;
        while (true) {
            if (i2 < 0) {
                i = 0;
                break;
            }
            String className = stackTraceElementArr[i2].getClassName();
            if (className.startsWith(f9454a) || (str != null && className.startsWith(str))) {
                i = i2 + 1;
            } else {
                i2--;
            }
        }
        i = i2 + 1;
        int i3 = length - i;
        StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[i3];
        System.arraycopy(stackTraceElementArr, i, stackTraceElementArr2, 0, i3);
        return stackTraceElementArr2;
    }

    /* renamed from: a */
    private static StackTraceElement[] m12667a(StackTraceElement[] stackTraceElementArr, int i) {
        int length = stackTraceElementArr.length;
        if (i > 0) {
            length = Math.min(i, length);
        }
        StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[length];
        System.arraycopy(stackTraceElementArr, 0, stackTraceElementArr2, 0, length);
        return stackTraceElementArr2;
    }
}
