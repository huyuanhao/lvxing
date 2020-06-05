package com.kwai.filedownloader.message;

/* renamed from: com.kwai.filedownloader.message.e */
public class C4698e {
    /* renamed from: a */
    private volatile C4702g f15228a;
    /* renamed from: b */
    private volatile C4700b f15229b;

    /* renamed from: com.kwai.filedownloader.message.e$a */
    public static final class C4699a {
        /* access modifiers changed from: private|static|final */
        /* renamed from: a */
        public static final C4698e f15230a = new C4698e();
    }

    /* renamed from: com.kwai.filedownloader.message.e$b */
    public interface C4700b {
        /* renamed from: a */
        void mo25290a(MessageSnapshot messageSnapshot);
    }

    /* renamed from: a */
    public static C4698e m19280a() {
        return C4699a.f15230a;
    }

    /* renamed from: a */
    public void mo25288a(MessageSnapshot messageSnapshot) {
        if (messageSnapshot instanceof C4685b) {
            if (this.f15229b != null) {
                this.f15229b.mo25290a(messageSnapshot);
            }
        } else if (this.f15228a != null) {
            this.f15228a.mo25291a(messageSnapshot);
        }
    }

    /* renamed from: a */
    public void mo25289a(C4700b bVar) {
        this.f15229b = bVar;
        if (bVar == null) {
            this.f15228a = null;
        } else {
            this.f15228a = new C4702g(5, bVar);
        }
    }
}
