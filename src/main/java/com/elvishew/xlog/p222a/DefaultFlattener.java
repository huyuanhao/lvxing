package com.elvishew.xlog.p222a;

import com.elvishew.xlog.LogLevel;

/* renamed from: com.elvishew.xlog.a.a */
public class DefaultFlattener implements Flattener {
    /* renamed from: a */
    public CharSequence mo17088a(int i, String str, String str2) {
        return mo17089a(System.currentTimeMillis(), i, str, str2);
    }

    /* renamed from: a */
    public CharSequence mo17089a(long j, int i, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(Long.toString(j));
        sb.append('|');
        sb.append(LogLevel.m12651a(i));
        sb.append('|');
        sb.append(str);
        sb.append('|');
        sb.append(str2);
        return sb.toString();
    }
}
