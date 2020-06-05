package com.bytedance.tea.crash.p221g;

import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.bytedance.tea.crash.g.m */
public final class Stack {

    /* compiled from: Stack */
    /* renamed from: com.bytedance.tea.crash.g.m$a */
    private static class C2599a {
        /* renamed from: a */
        private final PrintWriter f9379a;

        C2599a(PrintWriter printWriter) {
            this.f9379a = printWriter;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public Object mo17072a() {
            return this.f9379a;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo17073a(Object obj) {
            this.f9379a.println(obj);
        }
    }

    /* renamed from: a */
    public static String m12570a(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement a : stackTraceElementArr) {
            m12571a(a, sb);
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static StringBuilder m12571a(StackTraceElement stackTraceElement, StringBuilder sb) {
        String className = stackTraceElement.getClassName();
        sb.append("  at ");
        sb.append(className);
        sb.append(".");
        sb.append(stackTraceElement.getMethodName());
        sb.append("(");
        sb.append(stackTraceElement.getFileName());
        sb.append(":");
        sb.append(stackTraceElement.getLineNumber());
        sb.append(")\n");
        return sb;
    }

    /* JADX INFO: unreachable blocks removed: 1, instructions: 1 */
    /*  JADX ERROR: JadxRuntimeException in pass: BlockFinish
        jadx.core.utils.exceptions.JadxRuntimeException: Dominance frontier not set for block: B:13:0x0027
        	at jadx.core.dex.nodes.BlockNode.lock(BlockNode.java:73)
        	at jadx.core.utils.ImmutableList.forEach(ImmutableList.java:108)
        	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:432)
        	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.util.ArrayList.forEach(ArrayList.java:1249)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:30)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
        	at java.util.ArrayList.forEach(ArrayList.java:1249)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
        	at jadx.core.ProcessClass.process(ProcessClass.java:35)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        */
    /* renamed from: a */
    public static java.lang.String m12569a(java.lang.Throwable r3) {
        /*
        java.io.StringWriter r0 = new java.io.StringWriter
        r0.<init>()
        java.io.PrintWriter r1 = new java.io.PrintWriter
        r1.<init>(r0)
        boolean r2 = m12577c(r3)     // Catch:{ Exception -> 0x0021 }
        if (r2 == 0) goto L_0x0014     // Catch:{ Exception -> 0x0021 }
        m12574a(r3, r1)     // Catch:{ Exception -> 0x0021 }
        goto L_0x0017     // Catch:{ Exception -> 0x0021 }
    L_0x0014:
        r3.printStackTrace(r1)     // Catch:{ Exception -> 0x0021 }
    L_0x0017:
        java.lang.String r3 = r0.toString()     // Catch:{ Exception -> 0x0021 }
        r1.close()
        return r3
    L_0x001f:
        r3 = move-exception
        goto L_0x0027
    L_0x0021:
        java.lang.String r3 = ""
        r1.close()
        return r3
    L_0x0027:
        r1.close()
        throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.tea.crash.p221g.Stack.m12569a(java.lang.Throwable):java.lang.String");
    }

    /* renamed from: a */
    public static JSONObject m12572a(String str) {
        boolean z;
        String str2 = str;
        String str3 = ")";
        String str4 = "(";
        try {
            Map allStackTraces = Thread.getAllStackTraces();
            JSONObject jSONObject = new JSONObject();
            if (allStackTraces == null) {
                return null;
            }
            jSONObject.put("thread_all_count", allStackTraces.size());
            JSONArray jSONArray = new JSONArray();
            for (Entry entry : allStackTraces.entrySet()) {
                JSONObject jSONObject2 = new JSONObject();
                Thread thread = (Thread) entry.getKey();
                String name = thread.getName();
                if (!m12575b(name)) {
                    if (str2 != null) {
                        if (!str2.equals(name) && !name.startsWith(str2)) {
                            if (name.endsWith(str2)) {
                            }
                        }
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(thread.getName());
                    sb.append(str4);
                    sb.append(thread.getId());
                    sb.append(str3);
                    jSONObject2.put("thread_name", sb.toString());
                    StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) entry.getValue();
                    if (stackTraceElementArr != null) {
                        JSONArray jSONArray2 = new JSONArray();
                        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                            String className = stackTraceElement.getClassName();
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(className);
                            sb2.append(".");
                            sb2.append(stackTraceElement.getMethodName());
                            sb2.append(str4);
                            sb2.append(stackTraceElement.getLineNumber());
                            sb2.append(str3);
                            jSONArray2.put(sb2.toString());
                        }
                        jSONObject2.put("thread_stack", jSONArray2);
                        z = jSONArray2.length() > 0;
                    } else {
                        z = true;
                    }
                    if (z) {
                        jSONArray.put(jSONObject2);
                    }
                }
            }
            jSONObject.put("thread_stacks", jSONArray);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: b */
    private static boolean m12575b(String str) {
        Set<String> a = Filters.m12534a();
        if (a.contains(str)) {
            return true;
        }
        for (String str2 : a) {
            if (!TextUtils.isEmpty(str) && str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m12576b(Throwable th) {
        if (th == null) {
            return false;
        }
        int i = 0;
        while (th != null) {
            try {
                if (th instanceof OutOfMemoryError) {
                    return true;
                }
                if (i > 20) {
                    return false;
                }
                i++;
                th = th.getCause();
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    /* renamed from: a */
    private static void m12574a(Throwable th, PrintWriter printWriter) {
        if (th != null && printWriter != null) {
            C2599a aVar = new C2599a(printWriter);
            Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
            newSetFromMap.add(th);
            synchronized (aVar.mo17072a()) {
                aVar.mo17073a(th);
                StackTraceElement[] stackTrace = th.getStackTrace();
                int length = stackTrace.length;
                int i = 0;
                int i2 = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    StackTraceElement stackTraceElement = stackTrace[i];
                    if (i2 > 256) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("\t... skip ");
                        sb.append(stackTrace.length - i2);
                        sb.append(" lines");
                        aVar.mo17073a(sb.toString());
                        break;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("\tat ");
                    sb2.append(stackTraceElement);
                    aVar.mo17073a(sb2.toString());
                    i2++;
                    i++;
                }
                if (VERSION.SDK_INT >= 19) {
                    for (Throwable a : th.getSuppressed()) {
                        m12573a(a, aVar, stackTrace, "Suppressed: ", "\t", newSetFromMap);
                    }
                }
                Throwable cause = th.getCause();
                if (cause != null) {
                    m12573a(cause, aVar, stackTrace, "Caused by: ", "", newSetFromMap);
                }
            }
        }
    }

    /* renamed from: a */
    private static void m12573a(Throwable th, C2599a aVar, StackTraceElement[] stackTraceElementArr, String str, String str2, Set<Throwable> set) {
        Throwable[] suppressed;
        if (set.contains(th)) {
            StringBuilder sb = new StringBuilder();
            sb.append("\t[CIRCULAR REFERENCE:");
            sb.append(th);
            sb.append("]");
            aVar.mo17073a(sb.toString());
            return;
        }
        set.add(th);
        StackTraceElement[] stackTrace = th.getStackTrace();
        int min = Math.min(stackTrace.length, 256);
        int i = min - 1;
        int min2 = Math.min(stackTraceElementArr.length, 256) - 1;
        int i2 = i;
        while (i2 >= 0 && min2 >= 0 && stackTrace[i2].equals(stackTraceElementArr[min2])) {
            i2--;
            min2--;
        }
        int i3 = i - i2;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append(str);
        sb2.append(th);
        aVar.mo17073a(sb2.toString());
        for (int i4 = 0; i4 <= i2; i4++) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str2);
            sb3.append("\tat ");
            sb3.append(stackTrace[i4]);
            aVar.mo17073a(sb3.toString());
        }
        if (min < stackTrace.length) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("\t... skip ");
            sb4.append(stackTrace.length - min);
            sb4.append(" lines");
            aVar.mo17073a(sb4.toString());
        }
        if (i3 != 0) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str2);
            sb5.append("\t... ");
            sb5.append(i3);
            sb5.append(" more");
            aVar.mo17073a(sb5.toString());
        }
        if (VERSION.SDK_INT >= 19) {
            for (Throwable th2 : th.getSuppressed()) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append(str2);
                sb6.append("\t");
                m12573a(th2, aVar, stackTrace, "Suppressed: ", sb6.toString(), set);
            }
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            m12573a(cause, aVar, stackTrace, "Caused by: ", str2, set);
        }
    }

    /* renamed from: c */
    private static boolean m12577c(Throwable th) {
        int i = 0;
        while (th != null) {
            if (th instanceof StackOverflowError) {
                return true;
            }
            if (i > 20) {
                return false;
            }
            th = th.getCause();
            i++;
        }
        return false;
    }
}
