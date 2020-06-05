package com.elvishew.xlog.formatter.p234d;

/* renamed from: com.elvishew.xlog.formatter.d.a */
public class DefaultThreadFormatter implements ThreadFormatter {
    /* renamed from: a */
    public String mo17099a(Thread thread) {
        StringBuilder sb = new StringBuilder();
        sb.append("Thread: ");
        sb.append(thread.getName());
        return sb.toString();
    }
}
