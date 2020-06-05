package p655io.reactivex.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

/* renamed from: io.reactivex.exceptions.CompositeException */
public final class CompositeException extends RuntimeException {
    private static final long serialVersionUID = 3026362227162912146L;
    private Throwable cause;
    private final List<Throwable> exceptions;
    private final String message;

    /* renamed from: io.reactivex.exceptions.CompositeException$a */
    static final class C8086a extends RuntimeException {
        static final String MESSAGE = "Chain of Causes for CompositeException In Order Received =>";
        private static final long serialVersionUID = 3875212506787802066L;

        public String getMessage() {
            return MESSAGE;
        }

        C8086a() {
        }
    }

    /* renamed from: io.reactivex.exceptions.CompositeException$b */
    static abstract class C8087b {
        /* renamed from: a */
        public abstract void mo38852a(Object obj);

        C8087b() {
        }
    }

    /* renamed from: io.reactivex.exceptions.CompositeException$c */
    static final class C8088c extends C8087b {
        /* renamed from: a */
        private final PrintStream f27414a;

        C8088c(PrintStream printStream) {
            this.f27414a = printStream;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo38852a(Object obj) {
            this.f27414a.println(obj);
        }
    }

    /* renamed from: io.reactivex.exceptions.CompositeException$d */
    static final class C8089d extends C8087b {
        /* renamed from: a */
        private final PrintWriter f27415a;

        C8089d(PrintWriter printWriter) {
            this.f27415a = printWriter;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo38852a(Object obj) {
            this.f27415a.println(obj);
        }
    }

    public CompositeException(Throwable... thArr) {
        this((Iterable<? extends Throwable>) thArr == null ? Collections.singletonList(new NullPointerException("exceptions was null")) : Arrays.asList(thArr));
    }

    public CompositeException(Iterable<? extends Throwable> iterable) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        if (iterable != null) {
            for (Throwable th : iterable) {
                if (th instanceof CompositeException) {
                    linkedHashSet.addAll(((CompositeException) th).getExceptions());
                } else if (th != null) {
                    linkedHashSet.add(th);
                } else {
                    linkedHashSet.add(new NullPointerException("Throwable was null!"));
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException("errors was null"));
        }
        if (!linkedHashSet.isEmpty()) {
            arrayList.addAll(linkedHashSet);
            this.exceptions = Collections.unmodifiableList(arrayList);
            StringBuilder sb = new StringBuilder();
            sb.append(this.exceptions.size());
            sb.append(" exceptions occurred. ");
            this.message = sb.toString();
            return;
        }
        throw new IllegalArgumentException("errors is empty");
    }

    public List<Throwable> getExceptions() {
        return this.exceptions;
    }

    public String getMessage() {
        return this.message;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:10|(4:13|(2:15|34)(3:16|17|35)|33|11)|18|19|20|21|32) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0055 */
    public synchronized java.lang.Throwable getCause() {
        /*
        r8 = this;
        monitor-enter(r8)
        java.lang.Throwable r0 = r8.cause     // Catch:{ all -> 0x0060 }
        if (r0 != 0) goto L_0x005c
        io.reactivex.exceptions.CompositeException$a r0 = new io.reactivex.exceptions.CompositeException$a     // Catch:{ all -> 0x0060 }
        r0.m54661init()     // Catch:{ all -> 0x0060 }
        java.util.HashSet r1 = new java.util.HashSet     // Catch:{ all -> 0x0060 }
        r1.<init>()     // Catch:{ all -> 0x0060 }
        java.util.List<java.lang.Throwable> r2 = r8.exceptions     // Catch:{ all -> 0x0060 }
        java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0060 }
        r3 = r0
    L_0x0016:
        boolean r4 = r2.hasNext()     // Catch:{ all -> 0x0060 }
        if (r4 == 0) goto L_0x005a
        java.lang.Object r4 = r2.next()     // Catch:{ all -> 0x0060 }
        java.lang.Throwable r4 = (java.lang.Throwable) r4     // Catch:{ all -> 0x0060 }
        boolean r5 = r1.contains(r4)     // Catch:{ all -> 0x0060 }
        if (r5 == 0) goto L_0x0029
        goto L_0x0016
    L_0x0029:
        r1.add(r4)     // Catch:{ all -> 0x0060 }
        java.util.List r5 = r8.getListOfCauses(r4)     // Catch:{ all -> 0x0060 }
        java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x0060 }
    L_0x0034:
        boolean r6 = r5.hasNext()     // Catch:{ all -> 0x0060 }
        if (r6 == 0) goto L_0x0052
        java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x0060 }
        java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x0060 }
        boolean r7 = r1.contains(r6)     // Catch:{ all -> 0x0060 }
        if (r7 == 0) goto L_0x004e
        java.lang.RuntimeException r4 = new java.lang.RuntimeException     // Catch:{ all -> 0x0060 }
        java.lang.String r6 = "Duplicate found in causal chain so cropping to prevent loop ..."
        r4.<init>(r6)     // Catch:{ all -> 0x0060 }
        goto L_0x0034
    L_0x004e:
        r1.add(r6)     // Catch:{ all -> 0x0060 }
        goto L_0x0034
    L_0x0052:
        r3.initCause(r4)     // Catch:{ all -> 0x0055 }
    L_0x0055:
        java.lang.Throwable r3 = r8.getRootCause(r3)     // Catch:{ all -> 0x0060 }
        goto L_0x0016
    L_0x005a:
        r8.cause = r0     // Catch:{ all -> 0x0060 }
    L_0x005c:
        java.lang.Throwable r0 = r8.cause     // Catch:{ all -> 0x0060 }
        monitor-exit(r8)
        return r0
    L_0x0060:
        r0 = move-exception
        monitor-exit(r8)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p655io.reactivex.exceptions.CompositeException.getCause():java.lang.Throwable");
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void printStackTrace(PrintStream printStream) {
        printStackTrace((C8087b) new C8088c(printStream));
    }

    public void printStackTrace(PrintWriter printWriter) {
        printStackTrace((C8087b) new C8089d(printWriter));
    }

    private void printStackTrace(C8087b bVar) {
        StackTraceElement[] stackTrace;
        StringBuilder sb = new StringBuilder(128);
        sb.append(this);
        sb.append(10);
        for (StackTraceElement stackTraceElement : getStackTrace()) {
            sb.append("\tat ");
            sb.append(stackTraceElement);
            sb.append(10);
        }
        int i = 1;
        for (Throwable th : this.exceptions) {
            sb.append("  ComposedException ");
            sb.append(i);
            sb.append(" :\n");
            appendStackTrace(sb, th, "\t");
            i++;
        }
        bVar.mo38852a(sb.toString());
    }

    private void appendStackTrace(StringBuilder sb, Throwable th, String str) {
        StackTraceElement[] stackTrace;
        sb.append(str);
        sb.append(th);
        sb.append(10);
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            sb.append("\t\tat ");
            sb.append(stackTraceElement);
            sb.append(10);
        }
        if (th.getCause() != null) {
            sb.append("\tCaused by: ");
            appendStackTrace(sb, th.getCause(), "");
        }
    }

    private List<Throwable> getListOfCauses(Throwable th) {
        ArrayList arrayList = new ArrayList();
        Throwable cause2 = th.getCause();
        if (cause2 != null && cause2 != th) {
            while (true) {
                arrayList.add(cause2);
                Throwable cause3 = cause2.getCause();
                if (cause3 == null || cause3 == cause2) {
                    break;
                }
                cause2 = cause3;
            }
        }
        return arrayList;
    }

    public int size() {
        return this.exceptions.size();
    }

    /* access modifiers changed from: 0000 */
    public Throwable getRootCause(Throwable th) {
        Throwable cause2 = th.getCause();
        if (cause2 == null || this.cause == cause2) {
            return th;
        }
        while (true) {
            Throwable cause3 = cause2.getCause();
            if (cause3 == null || cause3 == cause2) {
                return cause2;
            }
            cause2 = cause3;
        }
        return cause2;
    }
}
