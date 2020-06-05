package com.kwai.filedownloader.message;

import com.kwai.filedownloader.message.C4698e.C4700b;
import com.kwai.filedownloader.p358f.C4652b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* renamed from: com.kwai.filedownloader.message.g */
public class C4702g {
    /* renamed from: a */
    private final List<C4703a> f15231a = new ArrayList();
    /* access modifiers changed from: private|final */
    /* renamed from: b */
    public final C4700b f15232b;

    /* renamed from: com.kwai.filedownloader.message.g$a */
    public class C4703a {
        /* access modifiers changed from: private|final */
        /* renamed from: b */
        public final List<Integer> f15234b = new ArrayList();
        /* renamed from: c */
        private final Executor f15235c;

        public C4703a(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append("Flow-");
            sb.append(i);
            this.f15235c = C4652b.m19102a(1, sb.toString());
        }

        /* renamed from: a */
        public void mo25292a(int i) {
            this.f15234b.add(Integer.valueOf(i));
        }

        /* renamed from: a */
        public void mo25293a(final MessageSnapshot messageSnapshot) {
            this.f15235c.execute(new Runnable() {
                public void run() {
                    C4702g.this.f15232b.mo25290a(messageSnapshot);
                    try {
                        C4703a.this.f15234b.remove(Integer.valueOf(messageSnapshot.mo25278m()));
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    C4702g(int i, C4700b bVar) {
        this.f15232b = bVar;
        for (int i2 = 0; i2 < i; i2++) {
            this.f15231a.add(new C4703a(i2));
        }
    }

    /* renamed from: a */
    public void mo25291a(MessageSnapshot messageSnapshot) {
        C4703a aVar;
        C4703a aVar2 = null;
        try {
            synchronized (this.f15231a) {
                int m = messageSnapshot.mo25278m();
                Iterator it = this.f15231a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    C4703a aVar3 = (C4703a) it.next();
                    if (aVar3.f15234b.contains(Integer.valueOf(m))) {
                        aVar2 = aVar3;
                        break;
                    }
                }
                if (aVar == null) {
                    int i = 0;
                    Iterator it2 = this.f15231a.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        C4703a aVar4 = (C4703a) it2.next();
                        if (aVar4.f15234b.size() <= 0) {
                            aVar = aVar4;
                            break;
                        } else if (i == 0 || aVar4.f15234b.size() < i) {
                            i = aVar4.f15234b.size();
                            aVar = aVar4;
                        }
                    }
                }
                aVar.mo25292a(m);
            }
            aVar.mo25293a(messageSnapshot);
        } catch (Throwable th) {
            aVar2.mo25293a(messageSnapshot);
            throw th;
        }
    }
}
