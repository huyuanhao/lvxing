package org.p703a;

/* renamed from: org.a.b */
public class C8552b extends RuntimeException {
    public C8552b(String str) {
        super(str);
    }

    public C8552b(String str, Throwable th) {
        super(str, th);
    }

    public C8552b(Throwable th) {
        super(th.getMessage(), th);
    }
}
