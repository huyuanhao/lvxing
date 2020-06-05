package com.kwai.filedownloader;

import com.kwai.filedownloader.C4743w.C4745b;
import com.kwai.filedownloader.message.C4698e;
import com.kwai.filedownloader.message.C4698e.C4700b;
import com.kwai.filedownloader.p358f.C4652b;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/* renamed from: com.kwai.filedownloader.p */
class C4719p {
    /* renamed from: a */
    private final C4721b f15253a = new C4721b();

    /* renamed from: com.kwai.filedownloader.p$a */
    private static class C4720a {
        /* access modifiers changed from: private|static|final */
        /* renamed from: a */
        public static final C4719p f15254a = new C4719p();

        static {
            C4698e.m19280a().mo25289a((C4700b) new C4748z());
        }
    }

    /* renamed from: com.kwai.filedownloader.p$b */
    private static class C4721b {
        /* renamed from: a */
        private ThreadPoolExecutor f15255a;
        /* renamed from: b */
        private LinkedBlockingQueue<Runnable> f15256b;

        C4721b() {
            m19345a();
        }

        /* renamed from: a */
        private void m19345a() {
            this.f15256b = new LinkedBlockingQueue<>();
            this.f15255a = C4652b.m19103a(3, this.f15256b, "LauncherTask");
        }

        /* renamed from: a */
        public void mo25308a(C4745b bVar) {
            this.f15255a.execute(new C4722c(bVar));
        }

        /* renamed from: b */
        public void mo25309b(C4745b bVar) {
            this.f15256b.remove(bVar);
        }
    }

    /* renamed from: com.kwai.filedownloader.p$c */
    private static class C4722c implements Runnable {
        /* renamed from: a */
        private final C4745b f15257a;
        /* renamed from: b */
        private boolean f15258b = false;

        C4722c(C4745b bVar) {
            this.f15257a = bVar;
        }

        public boolean equals(Object obj) {
            return super.equals(obj) || obj == this.f15257a;
        }

        public void run() {
            if (!this.f15258b) {
                this.f15257a.mo25048p();
            }
        }
    }

    C4719p() {
    }

    /* renamed from: a */
    public static C4719p m19341a() {
        return C4720a.f15254a;
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: a */
    public synchronized void mo25306a(C4745b bVar) {
        this.f15253a.mo25308a(bVar);
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: b */
    public synchronized void mo25307b(C4745b bVar) {
        this.f15253a.mo25309b(bVar);
    }
}
