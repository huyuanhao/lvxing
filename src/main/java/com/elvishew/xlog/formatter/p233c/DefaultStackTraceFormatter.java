package com.elvishew.xlog.formatter.p233c;

import com.elvishew.xlog.p224c.SystemCompat;

/* renamed from: com.elvishew.xlog.formatter.c.a */
public class DefaultStackTraceFormatter implements StackTraceFormatter {
    /* renamed from: a */
    public String mo17099a(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder(256);
        if (stackTraceElementArr == null || stackTraceElementArr.length == 0) {
            return null;
        }
        if (stackTraceElementArr.length == 1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("\t─ ");
            sb2.append(stackTraceElementArr[0].toString());
            return sb2.toString();
        }
        int length = stackTraceElementArr.length;
        for (int i = 0; i < length; i++) {
            if (i != length - 1) {
                sb.append("\t├ ");
                sb.append(stackTraceElementArr[i].toString());
                sb.append(SystemCompat.f9456a);
            } else {
                sb.append("\t└ ");
                sb.append(stackTraceElementArr[i].toString());
            }
        }
        return sb.toString();
    }
}
