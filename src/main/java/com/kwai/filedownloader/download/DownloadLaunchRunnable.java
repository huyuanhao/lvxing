package com.kwai.filedownloader.download;

import com.kwai.filedownloader.C4746x;
import com.kwai.filedownloader.download.C4631c.C4633a;
import com.kwai.filedownloader.download.C4636e.C4638a;
import com.kwai.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwai.filedownloader.exception.FileDownloadHttpException;
import com.kwai.filedownloader.exception.FileDownloadNetworkPolicyException;
import com.kwai.filedownloader.exception.FileDownloadOutOfSpaceException;
import com.kwai.filedownloader.p353a.C4589b;
import com.kwai.filedownloader.p354b.C4596a;
import com.kwai.filedownloader.p356d.C4618a;
import com.kwai.filedownloader.p356d.C4619b;
import com.kwai.filedownloader.p356d.C4621c;
import com.kwai.filedownloader.p357e.C4641a;
import com.kwai.filedownloader.p358f.C4652b;
import com.kwai.filedownloader.p358f.C4654c;
import com.kwai.filedownloader.p358f.C4660d;
import com.kwai.filedownloader.p358f.C4661e;
import com.kwai.filedownloader.p358f.C4664f;
import com.tencent.mid.core.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

public class DownloadLaunchRunnable implements C4639f, Runnable {
    /* renamed from: o */
    private static final ThreadPoolExecutor f15060o = C4652b.m19104a("ConnectionBlock");
    /* renamed from: A */
    private long f15061A;
    /* renamed from: a */
    int f15062a;
    /* renamed from: b */
    private final C4634d f15063b;
    /* renamed from: c */
    private final int f15064c;
    /* renamed from: d */
    private final C4621c f15065d;
    /* renamed from: e */
    private final C4619b f15066e;
    /* renamed from: f */
    private final boolean f15067f;
    /* renamed from: g */
    private final boolean f15068g;
    /* renamed from: h */
    private final C4596a f15069h;
    /* renamed from: i */
    private final C4746x f15070i;
    /* renamed from: j */
    private boolean f15071j;
    /* renamed from: k */
    private final boolean f15072k;
    /* renamed from: l */
    private final ArrayList<C4631c> f15073l;
    /* renamed from: m */
    private C4636e f15074m;
    /* renamed from: n */
    private boolean f15075n;
    /* renamed from: p */
    private boolean f15076p;
    /* renamed from: q */
    private boolean f15077q;
    /* renamed from: r */
    private boolean f15078r;
    /* renamed from: s */
    private final AtomicBoolean f15079s;
    /* renamed from: t */
    private volatile boolean f15080t;
    /* renamed from: u */
    private volatile boolean f15081u;
    /* renamed from: v */
    private volatile Exception f15082v;
    /* renamed from: w */
    private String f15083w;
    /* renamed from: x */
    private long f15084x;
    /* renamed from: y */
    private long f15085y;
    /* renamed from: z */
    private long f15086z;

    /* renamed from: com.kwai.filedownloader.download.DownloadLaunchRunnable$DiscardSafely */
    class DiscardSafely extends Throwable {
        DiscardSafely() {
        }
    }

    /* renamed from: com.kwai.filedownloader.download.DownloadLaunchRunnable$RetryDirectly */
    class RetryDirectly extends Throwable {
        RetryDirectly() {
        }
    }

    /* renamed from: com.kwai.filedownloader.download.DownloadLaunchRunnable$a */
    public static class C4627a {
        /* renamed from: a */
        private C4621c f15087a;
        /* renamed from: b */
        private C4619b f15088b;
        /* renamed from: c */
        private C4746x f15089c;
        /* renamed from: d */
        private Integer f15090d;
        /* renamed from: e */
        private Integer f15091e;
        /* renamed from: f */
        private Boolean f15092f;
        /* renamed from: g */
        private Boolean f15093g;
        /* renamed from: h */
        private Integer f15094h;

        /* renamed from: a */
        public C4627a mo25129a(C4619b bVar) {
            this.f15088b = bVar;
            return this;
        }

        /* renamed from: a */
        public C4627a mo25130a(C4621c cVar) {
            this.f15087a = cVar;
            return this;
        }

        /* renamed from: a */
        public C4627a mo25131a(C4746x xVar) {
            this.f15089c = xVar;
            return this;
        }

        /* renamed from: a */
        public C4627a mo25132a(Boolean bool) {
            this.f15092f = bool;
            return this;
        }

        /* renamed from: a */
        public C4627a mo25133a(Integer num) {
            this.f15090d = num;
            return this;
        }

        /* renamed from: a */
        public DownloadLaunchRunnable mo25134a() {
            C4621c cVar = this.f15087a;
            if (cVar != null) {
                C4746x xVar = this.f15089c;
                if (xVar != null) {
                    Integer num = this.f15090d;
                    if (!(num == null || this.f15091e == null || this.f15092f == null || this.f15093g == null || this.f15094h == null)) {
                        DownloadLaunchRunnable downloadLaunchRunnable = new DownloadLaunchRunnable(cVar, this.f15088b, xVar, num.intValue(), this.f15091e.intValue(), this.f15092f.booleanValue(), this.f15093g.booleanValue(), this.f15094h.intValue());
                        return downloadLaunchRunnable;
                    }
                }
            }
            throw new IllegalArgumentException();
        }

        /* renamed from: b */
        public C4627a mo25135b(Boolean bool) {
            this.f15093g = bool;
            return this;
        }

        /* renamed from: b */
        public C4627a mo25136b(Integer num) {
            this.f15091e = num;
            return this;
        }

        /* renamed from: c */
        public C4627a mo25137c(Integer num) {
            this.f15094h = num;
            return this;
        }
    }

    private DownloadLaunchRunnable(C4621c cVar, C4619b bVar, C4746x xVar, int i, int i2, boolean z, boolean z2, int i3) {
        this.f15064c = 5;
        this.f15073l = new ArrayList<>(5);
        this.f15084x = 0;
        this.f15085y = 0;
        this.f15086z = 0;
        this.f15061A = 0;
        this.f15079s = new AtomicBoolean(true);
        this.f15080t = false;
        this.f15071j = false;
        this.f15065d = cVar;
        this.f15066e = bVar;
        this.f15067f = z;
        this.f15068g = z2;
        this.f15069h = C4629b.m18995a().mo25145c();
        this.f15072k = C4629b.m18995a().mo25147e();
        this.f15070i = xVar;
        this.f15062a = i3;
        this.f15063b = new C4634d(cVar, i3, i, i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0067  */
    /* renamed from: a */
    private com.kwai.filedownloader.download.C4628a m18965a(java.util.List<com.kwai.filedownloader.p356d.C4618a> r21) {
        /*
        r20 = this;
        r0 = r20
        com.kwai.filedownloader.d.c r1 = r0.f15065d
        int r1 = r1.mo25096n()
        com.kwai.filedownloader.d.c r2 = r0.f15065d
        java.lang.String r2 = r2.mo25087e()
        com.kwai.filedownloader.d.c r3 = r0.f15065d
        java.lang.String r3 = r3.mo25084d()
        r4 = 0
        r5 = 1
        if (r1 <= r5) goto L_0x001a
        r6 = 1
        goto L_0x001b
    L_0x001a:
        r6 = 0
    L_0x001b:
        r7 = 0
        if (r6 == 0) goto L_0x0024
        boolean r9 = r0.f15072k
        if (r9 != 0) goto L_0x0024
        goto L_0x0056
    L_0x0024:
        com.kwai.filedownloader.d.c r9 = r0.f15065d
        int r9 = r9.mo25071a()
        com.kwai.filedownloader.d.c r10 = r0.f15065d
        boolean r9 = com.kwai.filedownloader.p358f.C4664f.m19138a(r9, r10)
        if (r9 == 0) goto L_0x0056
        boolean r9 = r0.f15072k
        if (r9 != 0) goto L_0x0041
        java.io.File r1 = new java.io.File
        r1.<init>(r2)
        long r9 = r1.length()
    L_0x003f:
        r14 = r9
        goto L_0x0057
    L_0x0041:
        if (r6 == 0) goto L_0x004f
        int r6 = r21.size()
        if (r1 == r6) goto L_0x004a
        goto L_0x0056
    L_0x004a:
        long r9 = com.kwai.filedownloader.p356d.C4618a.m18899a(r21)
        goto L_0x003f
    L_0x004f:
        com.kwai.filedownloader.d.c r1 = r0.f15065d
        long r9 = r1.mo25089g()
        goto L_0x003f
    L_0x0056:
        r14 = r7
    L_0x0057:
        com.kwai.filedownloader.d.c r1 = r0.f15065d
        r1.mo25074a(r14)
        int r1 = (r14 > r7 ? 1 : (r14 == r7 ? 0 : -1))
        if (r1 <= 0) goto L_0x0061
        r4 = 1
    L_0x0061:
        r0.f15076p = r4
        boolean r1 = r0.f15076p
        if (r1 != 0) goto L_0x0075
        com.kwai.filedownloader.b.a r1 = r0.f15069h
        com.kwai.filedownloader.d.c r4 = r0.f15065d
        int r4 = r4.mo25071a()
        r1.mo24976d(r4)
        com.kwai.filedownloader.p358f.C4664f.m19152c(r3, r2)
    L_0x0075:
        com.kwai.filedownloader.download.a r1 = new com.kwai.filedownloader.download.a
        r12 = 0
        r16 = 0
        com.kwai.filedownloader.d.c r2 = r0.f15065d
        long r2 = r2.mo25090h()
        long r18 = r2 - r14
        r11 = r1
        r11.m48662init(r12, r14, r16, r18)
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.filedownloader.download.DownloadLaunchRunnable.m18965a(java.util.List):com.kwai.filedownloader.download.a");
    }

    /* renamed from: a */
    private void m18966a(int i, List<C4618a> list) {
        if (i <= 1 || list.size() != i) {
            throw new IllegalArgumentException();
        }
        m18970a(list, this.f15065d.mo25090h());
    }

    /* renamed from: a */
    private void m18967a(long j, int i) {
        long j2 = j;
        int i2 = i;
        long j3 = j2 / ((long) i2);
        int a = this.f15065d.mo25071a();
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        long j4 = 0;
        while (i3 < i2) {
            long j5 = i3 == i2 + -1 ? 0 : (j4 + j3) - 1;
            C4618a aVar = new C4618a();
            aVar.mo25050a(a);
            aVar.mo25053b(i3);
            aVar.mo25051a(j4);
            aVar.mo25054b(j4);
            aVar.mo25056c(j5);
            arrayList.add(aVar);
            this.f15069h.mo24969a(aVar);
            j4 += j3;
            i3++;
        }
        this.f15065d.mo25078b(i2);
        this.f15069h.mo24962a(a, i2);
        m18970a((List<C4618a>) arrayList, j2);
    }

    /* renamed from: a */
    private void m18968a(long j, String str) {
        C4641a aVar = null;
        if (j != -1) {
            try {
                aVar = C4664f.m19163l(this.f15065d.mo25087e());
                long length = new File(str).length();
                long j2 = j - length;
                long f = C4664f.m19157f(str);
                if (f < j2) {
                    FileDownloadOutOfSpaceException fileDownloadOutOfSpaceException = new FileDownloadOutOfSpaceException(f, j2, length);
                    throw fileDownloadOutOfSpaceException;
                } else if (!C4661e.m19127a().f15185f) {
                    aVar.mo25198b(j);
                }
            } catch (Throwable th) {
                if (aVar != null) {
                    aVar.mo25197b();
                }
                throw th;
            }
        }
        if (aVar != null) {
            aVar.mo25197b();
        }
    }

    /* renamed from: a */
    private void m18969a(C4628a aVar, C4589b bVar) {
        if (!this.f15077q) {
            this.f15065d.mo25074a(0);
            C4628a aVar2 = new C4628a(0, 0, aVar.f15097c, aVar.f15098d);
            aVar = aVar2;
        }
        C4638a aVar3 = new C4638a();
        aVar3.mo25185a((C4639f) this).mo25189b(this.f15065d.mo25071a()).mo25181a(-1).mo25187a(this.f15068g).mo25182a(bVar).mo25183a(aVar).mo25186a(this.f15065d.mo25087e());
        this.f15065d.mo25078b(1);
        this.f15069h.mo24962a(this.f15065d.mo25071a(), 1);
        this.f15074m = aVar3.mo25188a();
        if (this.f15080t) {
            this.f15065d.mo25072a(-2);
            this.f15074m.mo25179a();
            return;
        }
        this.f15074m.mo25180b();
    }

    /* renamed from: a */
    private void m18970a(List<C4618a> list, long j) {
        int a = this.f15065d.mo25071a();
        String j2 = this.f15065d.mo25092j();
        String str = this.f15083w;
        if (str == null) {
            str = this.f15065d.mo25077b();
        }
        String e = this.f15065d.mo25087e();
        if (C4660d.f15179a) {
            C4660d.m19123c(this, "fetch data with multiple connection(count: [%d]) for task[%d] totalLength[%d]", Integer.valueOf(list.size()), Integer.valueOf(a), Long.valueOf(j));
        }
        boolean z = this.f15076p;
        long j3 = 0;
        long j4 = 0;
        for (C4618a aVar : list) {
            long d = aVar.mo25058e() == j3 ? j - aVar.mo25057d() : (aVar.mo25058e() - aVar.mo25057d()) + 1;
            j4 += aVar.mo25057d() - aVar.mo25055c();
            if (d != j3) {
                C4633a aVar2 = new C4633a();
                C4628a aVar3 = new C4628a(aVar.mo25055c(), aVar.mo25057d(), aVar.mo25058e(), d);
                C4631c a2 = aVar2.mo25151a(a).mo25155a(Integer.valueOf(aVar.mo25052b())).mo25154a((C4639f) this).mo25156a(str).mo25159b(z ? j2 : null).mo25152a(this.f15066e).mo25157a(this.f15068g).mo25153a(aVar3).mo25160c(e).mo25158a();
                if (C4660d.f15179a) {
                    C4660d.m19123c(this, "enable multiple connection: %s", aVar);
                }
                if (a2 != null) {
                    this.f15073l.add(a2);
                } else {
                    throw new IllegalArgumentException("the download runnable must not be null!");
                }
            } else if (C4660d.f15179a) {
                C4660d.m19123c(this, "pass connection[%d-%d], because it has been completed", Integer.valueOf(aVar.mo25049a()), Integer.valueOf(aVar.mo25052b()));
            }
            j3 = 0;
        }
        if (j4 != this.f15065d.mo25089g()) {
            C4660d.m19124d(this, "correct the sofar[%d] from connection table[%d]", Long.valueOf(this.f15065d.mo25089g()), Long.valueOf(j4));
            this.f15065d.mo25074a(j4);
        }
        ArrayList arrayList = new ArrayList(this.f15073l.size());
        Iterator it = this.f15073l.iterator();
        while (it.hasNext()) {
            C4631c cVar = (C4631c) it.next();
            if (this.f15080t) {
                cVar.mo25148a();
            } else {
                arrayList.add(Executors.callable(cVar));
            }
        }
        if (this.f15080t) {
            this.f15065d.mo25072a(-2);
            return;
        }
        List<Future> invokeAll = f15060o.invokeAll(arrayList);
        if (C4660d.f15179a) {
            for (Future future : invokeAll) {
                C4660d.m19123c(this, "finish sub-task for [%d] %B %B", Integer.valueOf(a), Boolean.valueOf(future.isDone()), Boolean.valueOf(future.isCancelled()));
            }
        }
    }

    /* renamed from: a */
    private void m18971a(Map<String, List<String>> map, ConnectTask connectTask, C4589b bVar) {
        C4589b bVar2 = bVar;
        int a = this.f15065d.mo25071a();
        int e = bVar.mo22746e();
        boolean z = e == 206 || e == 1;
        this.f15077q = z;
        boolean z2 = e == 200 || e == 201 || e == 0;
        String j = this.f15065d.mo25092j();
        String a2 = C4664f.m19131a(a, bVar2);
        boolean z3 = e == 412 || (j != null && !j.equals(a2) && (z2 || this.f15077q)) || ((e == 201 && connectTask.mo25107b()) || (e == 416 && this.f15065d.mo25089g() > 0));
        if (z3) {
            if (this.f15076p) {
                C4660d.m19124d(this, "there is precondition failed on this request[%d] with old etag[%s]、new etag[%s]、response requestHttpCode is %d", Integer.valueOf(a), j, a2, Integer.valueOf(e));
            }
            this.f15069h.mo24976d(this.f15065d.mo25071a());
            C4664f.m19152c(this.f15065d.mo25084d(), this.f15065d.mo25087e());
            this.f15076p = false;
            if (j != null && j.equals(a2)) {
                C4660d.m19124d(this, "the old etag[%s] is the same to the new etag[%s], but the response status requestHttpCode is %d not Partial(206), so wo have to start this task from very beginning for task[%d]!", j, a2, Integer.valueOf(e), Integer.valueOf(a));
                a2 = null;
            }
            this.f15065d.mo25074a(0);
            this.f15065d.mo25082c(0);
            this.f15065d.mo25080b(a2);
            this.f15065d.mo25097o();
            this.f15069h.mo24966a(a, this.f15065d.mo25092j(), this.f15065d.mo25089g(), this.f15065d.mo25090h(), this.f15065d.mo25096n());
            throw new RetryDirectly();
        }
        this.f15083w = connectTask.mo25108c();
        if (this.f15077q || z2) {
            long b = C4664f.m19146b(a, bVar2);
            String a3 = this.f15065d.mo25094l() ? C4664f.m19132a(bVar2, this.f15065d.mo25077b()) : null;
            this.f15078r = b == -1;
            long g = !this.f15078r ? this.f15065d.mo25089g() + b : b;
            C4634d dVar = this.f15063b;
            boolean z4 = this.f15076p && this.f15077q;
            dVar.mo25164a(z4, g, a2, a3);
            return;
        }
        throw new FileDownloadHttpException(e, map, bVar.mo22744c());
    }

    /* renamed from: g */
    private boolean m18972g() {
        boolean z = false;
        if (this.f15076p && this.f15065d.mo25096n() <= 1) {
            return false;
        }
        if (this.f15077q && this.f15072k && !this.f15078r) {
            z = true;
        }
        return z;
    }

    /* renamed from: h */
    private void m18973h() {
        if (this.f15068g) {
            String str = Constants.PERMISSION_ACCESS_NETWORK_STATE;
            if (!C4664f.m19161j(str)) {
                throw new FileDownloadGiveUpRetryException(C4664f.m19135a("Task[%d] can't start the download runnable, because this task require wifi, but user application nor current process has %s, so we can't check whether the network type connection.", Integer.valueOf(this.f15065d.mo25071a()), str));
            }
        }
        if (this.f15068g && C4664f.m19154d()) {
            throw new FileDownloadNetworkPolicyException();
        }
    }

    /* renamed from: i */
    private void m18974i() {
        int a = this.f15065d.mo25071a();
        if (this.f15065d.mo25094l()) {
            String d = this.f15065d.mo25084d();
            int b = C4664f.m19144b(this.f15065d.mo25077b(), d);
            if (!C4654c.m19109a(a, d, this.f15067f, false)) {
                C4621c b2 = this.f15069h.mo24972b(b);
                if (b2 != null) {
                    if (!C4654c.m19108a(a, b2, this.f15070i, false)) {
                        List<C4618a> c = this.f15069h.mo24974c(b);
                        this.f15069h.mo24977e(b);
                        this.f15069h.mo24976d(b);
                        C4664f.m19165n(this.f15065d.mo25084d());
                        if (C4664f.m19138a(b, b2)) {
                            this.f15065d.mo25074a(b2.mo25089g());
                            this.f15065d.mo25082c(b2.mo25090h());
                            this.f15065d.mo25080b(b2.mo25092j());
                            this.f15065d.mo25078b(b2.mo25096n());
                            this.f15069h.mo24970a(this.f15065d);
                            if (c != null) {
                                for (C4618a aVar : c) {
                                    aVar.mo25050a(a);
                                    this.f15069h.mo24969a(aVar);
                                }
                            }
                            throw new RetryDirectly();
                        }
                    } else {
                        this.f15069h.mo24977e(a);
                        this.f15069h.mo24976d(a);
                        throw new DiscardSafely();
                    }
                }
                if (C4654c.m19107a(a, this.f15065d.mo25089g(), this.f15065d.mo25087e(), d, this.f15070i)) {
                    this.f15069h.mo24977e(a);
                    this.f15069h.mo24976d(a);
                    throw new DiscardSafely();
                }
                return;
            }
            this.f15069h.mo24977e(a);
            this.f15069h.mo24976d(a);
            throw new DiscardSafely();
        }
    }

    /* renamed from: a */
    public void mo25117a() {
        this.f15080t = true;
        C4636e eVar = this.f15074m;
        if (eVar != null) {
            eVar.mo25179a();
        }
        Iterator it = ((ArrayList) this.f15073l.clone()).iterator();
        while (it.hasNext()) {
            C4631c cVar = (C4631c) it.next();
            if (cVar != null) {
                cVar.mo25148a();
            }
        }
    }

    /* renamed from: a */
    public void mo25118a(long j) {
        if (!this.f15080t) {
            this.f15063b.mo25161a(j);
        }
    }

    /* renamed from: a */
    public void mo25119a(C4631c cVar, long j, long j2) {
        if (this.f15080t) {
            if (C4660d.f15179a) {
                C4660d.m19123c(this, "the task[%d] has already been paused, so pass the completed callback", Integer.valueOf(this.f15065d.mo25071a()));
            }
            return;
        }
        int i = cVar == null ? -1 : cVar.f15106a;
        if (C4660d.f15179a) {
            C4660d.m19123c(this, "the connection has been completed(%d): [%d, %d)  %d", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(this.f15065d.mo25090h()));
        }
        if (!this.f15075n) {
            synchronized (this.f15073l) {
                this.f15073l.remove(cVar);
            }
        } else if (!(j == 0 || j2 == this.f15065d.mo25090h())) {
            C4660d.m19120a(this, "the single task not completed corrected(%d, %d != %d) for task(%d)", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(this.f15065d.mo25090h()), Integer.valueOf(this.f15065d.mo25071a()));
        }
    }

    /* renamed from: a */
    public void mo25120a(Exception exc, long j) {
        if (this.f15080t) {
            if (C4660d.f15179a) {
                C4660d.m19123c(this, "the task[%d] has already been paused, so pass the retry callback", Integer.valueOf(this.f15065d.mo25071a()));
            }
            return;
        }
        int i = this.f15062a;
        this.f15062a = i - 1;
        if (i < 0) {
            C4660d.m19120a(this, "valid retry times is less than 0(%d) for download task(%d)", Integer.valueOf(this.f15062a), Integer.valueOf(this.f15065d.mo25071a()));
        }
        this.f15063b.mo25163a(exc, this.f15062a, j);
    }

    /* renamed from: a */
    public boolean mo25121a(Exception exc) {
        boolean z = true;
        if (exc instanceof FileDownloadHttpException) {
            int code = ((FileDownloadHttpException) exc).getCode();
            if (this.f15075n && code == 416 && !this.f15071j) {
                C4664f.m19152c(this.f15065d.mo25084d(), this.f15065d.mo25087e());
                this.f15071j = true;
                return true;
            }
        }
        if (this.f15062a <= 0 || (exc instanceof FileDownloadGiveUpRetryException)) {
            z = false;
        }
        return z;
    }

    /* renamed from: b */
    public void mo25122b() {
        if (this.f15065d.mo25096n() > 1) {
            List c = this.f15069h.mo24974c(this.f15065d.mo25071a());
            if (this.f15065d.mo25096n() == c.size()) {
                this.f15065d.mo25074a(C4618a.m18899a(c));
            } else {
                this.f15065d.mo25074a(0);
                this.f15069h.mo24976d(this.f15065d.mo25071a());
            }
        }
        this.f15063b.mo25167c();
    }

    /* renamed from: b */
    public void mo25123b(Exception exc) {
        this.f15081u = true;
        this.f15082v = exc;
        if (this.f15080t) {
            if (C4660d.f15179a) {
                C4660d.m19123c(this, "the task[%d] has already been paused, so pass the error callback", Integer.valueOf(this.f15065d.mo25071a()));
            }
            return;
        }
        Iterator it = ((ArrayList) this.f15073l.clone()).iterator();
        while (it.hasNext()) {
            C4631c cVar = (C4631c) it.next();
            if (cVar != null) {
                cVar.mo25149b();
            }
        }
    }

    /* renamed from: c */
    public void mo25124c() {
        this.f15069h.mo24964a(this.f15065d.mo25071a(), this.f15065d.mo25089g());
    }

    /* renamed from: d */
    public int mo25125d() {
        return this.f15065d.mo25071a();
    }

    /* renamed from: e */
    public boolean mo25126e() {
        return this.f15079s.get() || this.f15063b.mo25165a();
    }

    /* renamed from: f */
    public String mo25127f() {
        return this.f15065d.mo25087e();
    }

    /* JADX INFO: used method not loaded: com.kwai.filedownloader.download.d.a(java.lang.Exception):null, types can be incorrect */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0253, code lost:
            if (r6 != null) goto L_0x01e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0256, code lost:
            r1.f15063b.mo25166b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x025d, code lost:
            if (r1.f15080t == false) goto L_0x0265;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x025f, code lost:
            r1.f15063b.mo25170f();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x0267, code lost:
            if (r1.f15081u == false) goto L_0x0271;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0269, code lost:
            r1.f15063b.mo25162a(r1.f15082v);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:?, code lost:
            r1.f15063b.mo25171g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0277, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0278, code lost:
            r1.f15063b.mo25162a((java.lang.Exception) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01de, code lost:
            if (r6 != null) goto L_0x01e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:?, code lost:
            r6.mo22747f();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:108:0x020b */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x021b A[Catch:{ FileDownloadGiveUpRetryException | IOException | IllegalAccessException | IllegalArgumentException | InterruptedException -> 0x0239, DiscardSafely -> 0x0218, RetryDirectly -> 0x020b, all -> 0x0289 }] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0229  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0248 A[Catch:{ all -> 0x0207 }] */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0285 A[SYNTHETIC, Splitter:B:146:0x0285] */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0250 A[SYNTHETIC] */
    public void run() {
        /*
        r18 = this;
        r1 = r18
        r0 = 10
        r2 = 0
        android.os.Process.setThreadPriority(r0)     // Catch:{ all -> 0x0289 }
        com.kwai.filedownloader.d.c r0 = r1.f15065d     // Catch:{ all -> 0x0289 }
        byte r0 = r0.mo25088f()     // Catch:{ all -> 0x0289 }
        java.lang.String r3 = "High concurrent cause, start runnable but already paused %d"
        r4 = -2
        r5 = 1
        if (r0 == r5) goto L_0x008f
        com.kwai.filedownloader.d.c r0 = r1.f15065d     // Catch:{ all -> 0x0289 }
        byte r0 = r0.mo25088f()     // Catch:{ all -> 0x0289 }
        if (r0 != r4) goto L_0x0032
        boolean r0 = com.kwai.filedownloader.p358f.C4660d.f15179a     // Catch:{ all -> 0x0289 }
        if (r0 == 0) goto L_0x0062
        java.lang.Object[] r0 = new java.lang.Object[r5]     // Catch:{ all -> 0x0289 }
        com.kwai.filedownloader.d.c r4 = r1.f15065d     // Catch:{ all -> 0x0289 }
        int r4 = r4.mo25071a()     // Catch:{ all -> 0x0289 }
        java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0289 }
        r0[r2] = r4     // Catch:{ all -> 0x0289 }
        com.kwai.filedownloader.p358f.C4660d.m19123c(r1, r3, r0)     // Catch:{ all -> 0x0289 }
        goto L_0x0062
    L_0x0032:
        java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ all -> 0x0289 }
        java.lang.String r3 = "Task[%d] can't start the download runnable, because its status is %d not %d"
        r4 = 3
        java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x0289 }
        com.kwai.filedownloader.d.c r6 = r1.f15065d     // Catch:{ all -> 0x0289 }
        int r6 = r6.mo25071a()     // Catch:{ all -> 0x0289 }
        java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0289 }
        r4[r2] = r6     // Catch:{ all -> 0x0289 }
        com.kwai.filedownloader.d.c r6 = r1.f15065d     // Catch:{ all -> 0x0289 }
        byte r6 = r6.mo25088f()     // Catch:{ all -> 0x0289 }
        java.lang.Byte r6 = java.lang.Byte.valueOf(r6)     // Catch:{ all -> 0x0289 }
        r4[r5] = r6     // Catch:{ all -> 0x0289 }
        r6 = 2
        java.lang.Byte r5 = java.lang.Byte.valueOf(r5)     // Catch:{ all -> 0x0289 }
        r4[r6] = r5     // Catch:{ all -> 0x0289 }
        java.lang.String r3 = com.kwai.filedownloader.p358f.C4664f.m19135a(r3, r4)     // Catch:{ all -> 0x0289 }
        r0.<init>(r3)     // Catch:{ all -> 0x0289 }
        r1.mo25123b(r0)     // Catch:{ all -> 0x0289 }
    L_0x0062:
        com.kwai.filedownloader.download.d r0 = r1.f15063b
        r0.mo25166b()
        boolean r0 = r1.f15080t
        if (r0 == 0) goto L_0x0071
    L_0x006b:
        com.kwai.filedownloader.download.d r0 = r1.f15063b
        r0.mo25170f()
        goto L_0x0089
    L_0x0071:
        boolean r0 = r1.f15081u
        if (r0 == 0) goto L_0x007d
    L_0x0075:
        com.kwai.filedownloader.download.d r0 = r1.f15063b
        java.lang.Exception r3 = r1.f15082v
        r0.mo25162a(r3)
        goto L_0x0089
    L_0x007d:
        com.kwai.filedownloader.download.d r0 = r1.f15063b     // Catch:{ IOException -> 0x0083 }
        r0.mo25171g()     // Catch:{ IOException -> 0x0083 }
        goto L_0x0089
    L_0x0083:
        r0 = move-exception
    L_0x0084:
        com.kwai.filedownloader.download.d r3 = r1.f15063b
        r3.mo25162a(r0)
    L_0x0089:
        java.util.concurrent.atomic.AtomicBoolean r0 = r1.f15079s
        r0.set(r2)
        return
    L_0x008f:
        boolean r0 = r1.f15080t     // Catch:{ all -> 0x0289 }
        if (r0 != 0) goto L_0x0098
        com.kwai.filedownloader.download.d r0 = r1.f15063b     // Catch:{ all -> 0x0289 }
        r0.mo25168d()     // Catch:{ all -> 0x0289 }
    L_0x0098:
        boolean r0 = r1.f15080t     // Catch:{ all -> 0x0289 }
        if (r0 == 0) goto L_0x00c8
        boolean r0 = com.kwai.filedownloader.p358f.C4660d.f15179a     // Catch:{ all -> 0x0289 }
        if (r0 == 0) goto L_0x00b1
        java.lang.Object[] r0 = new java.lang.Object[r5]     // Catch:{ all -> 0x0289 }
        com.kwai.filedownloader.d.c r4 = r1.f15065d     // Catch:{ all -> 0x0289 }
        int r4 = r4.mo25071a()     // Catch:{ all -> 0x0289 }
        java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0289 }
        r0[r2] = r4     // Catch:{ all -> 0x0289 }
        com.kwai.filedownloader.p358f.C4660d.m19123c(r1, r3, r0)     // Catch:{ all -> 0x0289 }
    L_0x00b1:
        com.kwai.filedownloader.download.d r0 = r1.f15063b
        r0.mo25166b()
        boolean r0 = r1.f15080t
        if (r0 == 0) goto L_0x00bb
        goto L_0x006b
    L_0x00bb:
        boolean r0 = r1.f15081u
        if (r0 == 0) goto L_0x00c0
        goto L_0x0075
    L_0x00c0:
        com.kwai.filedownloader.download.d r0 = r1.f15063b     // Catch:{ IOException -> 0x00c6 }
        r0.mo25171g()     // Catch:{ IOException -> 0x00c6 }
        goto L_0x0089
    L_0x00c6:
        r0 = move-exception
        goto L_0x0084
    L_0x00c8:
        r6 = 0
        r18.m18973h()     // Catch:{ IOException -> 0x0241, IllegalAccessException -> 0x023f, InterruptedException -> 0x023d, IllegalArgumentException -> 0x023b, FileDownloadGiveUpRetryException -> 0x0239, DiscardSafely -> 0x0218, RetryDirectly -> 0x020b }
        com.kwai.filedownloader.b.a r0 = r1.f15069h     // Catch:{ IOException -> 0x0241, IllegalAccessException -> 0x023f, InterruptedException -> 0x023d, IllegalArgumentException -> 0x023b, FileDownloadGiveUpRetryException -> 0x0239, DiscardSafely -> 0x0218, RetryDirectly -> 0x020b }
        com.kwai.filedownloader.d.c r7 = r1.f15065d     // Catch:{ IOException -> 0x0241, IllegalAccessException -> 0x023f, InterruptedException -> 0x023d, IllegalArgumentException -> 0x023b, FileDownloadGiveUpRetryException -> 0x0239, DiscardSafely -> 0x0218, RetryDirectly -> 0x020b }
        int r7 = r7.mo25071a()     // Catch:{ IOException -> 0x0241, IllegalAccessException -> 0x023f, InterruptedException -> 0x023d, IllegalArgumentException -> 0x023b, FileDownloadGiveUpRetryException -> 0x0239, DiscardSafely -> 0x0218, RetryDirectly -> 0x020b }
        java.util.List r0 = r0.mo24974c(r7)     // Catch:{ IOException -> 0x0241, IllegalAccessException -> 0x023f, InterruptedException -> 0x023d, IllegalArgumentException -> 0x023b, FileDownloadGiveUpRetryException -> 0x0239, DiscardSafely -> 0x0218, RetryDirectly -> 0x020b }
        com.kwai.filedownloader.download.a r7 = r1.m18965a(r0)     // Catch:{ IOException -> 0x0241, IllegalAccessException -> 0x023f, InterruptedException -> 0x023d, IllegalArgumentException -> 0x023b, FileDownloadGiveUpRetryException -> 0x0239, DiscardSafely -> 0x0218, RetryDirectly -> 0x020b }
        com.kwai.filedownloader.download.ConnectTask$a r8 = new com.kwai.filedownloader.download.ConnectTask$a     // Catch:{ IOException -> 0x0241, IllegalAccessException -> 0x023f, InterruptedException -> 0x023d, IllegalArgumentException -> 0x023b, FileDownloadGiveUpRetryException -> 0x0239, DiscardSafely -> 0x0218, RetryDirectly -> 0x020b }
        r8.m48655init()     // Catch:{ IOException -> 0x0241, IllegalAccessException -> 0x023f, InterruptedException -> 0x023d, IllegalArgumentException -> 0x023b, FileDownloadGiveUpRetryException -> 0x0239, DiscardSafely -> 0x0218, RetryDirectly -> 0x020b }
        com.kwai.filedownloader.d.c r9 = r1.f15065d     // Catch:{ IOException -> 0x0241, IllegalAccessException -> 0x023f, InterruptedException -> 0x023d, IllegalArgumentException -> 0x023b, FileDownloadGiveUpRetryException -> 0x0239, DiscardSafely -> 0x0218, RetryDirectly -> 0x020b }
        int r9 = r9.mo25071a()     // Catch:{ IOException -> 0x0241, IllegalAccessException -> 0x023f, InterruptedException -> 0x023d, IllegalArgumentException -> 0x023b, FileDownloadGiveUpRetryException -> 0x0239, DiscardSafely -> 0x0218, RetryDirectly -> 0x020b }
        com.kwai.filedownloader.download.ConnectTask$a r8 = r8.mo25111a(r9)     // Catch:{ IOException -> 0x0241, IllegalAccessException -> 0x023f, InterruptedException -> 0x023d, IllegalArgumentException -> 0x023b, FileDownloadGiveUpRetryException -> 0x0239, DiscardSafely -> 0x0218, RetryDirectly -> 0x020b }
        com.kwai.filedownloader.d.c r9 = r1.f15065d     // Catch:{ IOException -> 0x0241, IllegalAccessException -> 0x023f, InterruptedException -> 0x023d, IllegalArgumentException -> 0x023b, FileDownloadGiveUpRetryException -> 0x0239, DiscardSafely -> 0x0218, RetryDirectly -> 0x020b }
        java.lang.String r9 = r9.mo25077b()     // Catch:{ IOException -> 0x0241, IllegalAccessException -> 0x023f, InterruptedException -> 0x023d, IllegalArgumentException -> 0x023b, FileDownloadGiveUpRetryException -> 0x0239, DiscardSafely -> 0x0218, RetryDirectly -> 0x020b }
        com.kwai.filedownloader.download.ConnectTask$a r8 = r8.mo25114a(r9)     // Catch:{ IOException -> 0x0241, IllegalAccessException -> 0x023f, InterruptedException -> 0x023d, IllegalArgumentException -> 0x023b, FileDownloadGiveUpRetryException -> 0x0239, DiscardSafely -> 0x0218, RetryDirectly -> 0x020b }
        com.kwai.filedownloader.d.c r9 = r1.f15065d     // Catch:{ IOException -> 0x0241, IllegalAccessException -> 0x023f, InterruptedException -> 0x023d, IllegalArgumentException -> 0x023b, FileDownloadGiveUpRetryException -> 0x0239, DiscardSafely -> 0x0218, RetryDirectly -> 0x020b }
        java.lang.String r9 = r9.mo25092j()     // Catch:{ IOException -> 0x0241, IllegalAccessException -> 0x023f, InterruptedException -> 0x023d, IllegalArgumentException -> 0x023b, FileDownloadGiveUpRetryException -> 0x0239, DiscardSafely -> 0x0218, RetryDirectly -> 0x020b }
        com.kwai.filedownloader.download.ConnectTask$a r8 = r8.mo25116b(r9)     // Catch:{ IOException -> 0x0241, IllegalAccessException -> 0x023f, InterruptedException -> 0x023d, IllegalArgumentException -> 0x023b, FileDownloadGiveUpRetryException -> 0x0239, DiscardSafely -> 0x0218, RetryDirectly -> 0x020b }
        com.kwai.filedownloader.d.b r9 = r1.f15066e     // Catch:{ IOException -> 0x0241, IllegalAccessException -> 0x023f, InterruptedException -> 0x023d, IllegalArgumentException -> 0x023b, FileDownloadGiveUpRetryException -> 0x0239, DiscardSafely -> 0x0218, RetryDirectly -> 0x020b }
        com.kwai.filedownloader.download.ConnectTask$a r8 = r8.mo25112a(r9)     // Catch:{ IOException -> 0x0241, IllegalAccessException -> 0x023f, InterruptedException -> 0x023d, IllegalArgumentException -> 0x023b, FileDownloadGiveUpRetryException -> 0x0239, DiscardSafely -> 0x0218, RetryDirectly -> 0x020b }
        com.kwai.filedownloader.download.ConnectTask$a r7 = r8.mo25113a(r7)     // Catch:{ IOException -> 0x0241, IllegalAccessException -> 0x023f, InterruptedException -> 0x023d, IllegalArgumentException -> 0x023b, FileDownloadGiveUpRetryException -> 0x0239, DiscardSafely -> 0x0218, RetryDirectly -> 0x020b }
        com.kwai.filedownloader.download.ConnectTask r7 = r7.mo25115a()     // Catch:{ IOException -> 0x0241, IllegalAccessException -> 0x023f, InterruptedException -> 0x023d, IllegalArgumentException -> 0x023b, FileDownloadGiveUpRetryException -> 0x0239, DiscardSafely -> 0x0218, RetryDirectly -> 0x020b }
        com.kwai.filedownloader.a.b r8 = r7.mo25106a()     // Catch:{ IOException -> 0x0241, IllegalAccessException -> 0x023f, InterruptedException -> 0x023d, IllegalArgumentException -> 0x023b, FileDownloadGiveUpRetryException -> 0x0239, DiscardSafely -> 0x0218, RetryDirectly -> 0x020b }
        java.util.Map r9 = r7.mo25109d()     // Catch:{ IOException -> 0x0204, IllegalAccessException -> 0x0202, InterruptedException -> 0x0200, IllegalArgumentException -> 0x01fe, FileDownloadGiveUpRetryException -> 0x01fc, DiscardSafely -> 0x01fa, RetryDirectly -> 0x01f8, all -> 0x01f5 }
        r1.m18971a(r9, r7, r8)     // Catch:{ IOException -> 0x0204, IllegalAccessException -> 0x0202, InterruptedException -> 0x0200, IllegalArgumentException -> 0x01fe, FileDownloadGiveUpRetryException -> 0x01fc, DiscardSafely -> 0x01fa, RetryDirectly -> 0x01f8, all -> 0x01f5 }
        boolean r9 = r1.f15080t     // Catch:{ IOException -> 0x0204, IllegalAccessException -> 0x0202, InterruptedException -> 0x0200, IllegalArgumentException -> 0x01fe, FileDownloadGiveUpRetryException -> 0x01fc, DiscardSafely -> 0x01fa, RetryDirectly -> 0x01f8, all -> 0x01f5 }
        if (r9 == 0) goto L_0x0141
        com.kwai.filedownloader.d.c r0 = r1.f15065d     // Catch:{ IOException -> 0x0204, IllegalAccessException -> 0x0202, InterruptedException -> 0x0200, IllegalArgumentException -> 0x01fe, FileDownloadGiveUpRetryException -> 0x01fc, DiscardSafely -> 0x01fa, RetryDirectly -> 0x01f8, all -> 0x01f5 }
        r0.mo25072a(r4)     // Catch:{ IOException -> 0x0204, IllegalAccessException -> 0x0202, InterruptedException -> 0x0200, IllegalArgumentException -> 0x01fe, FileDownloadGiveUpRetryException -> 0x01fc, DiscardSafely -> 0x01fa, RetryDirectly -> 0x01f8, all -> 0x01f5 }
        if (r8 == 0) goto L_0x0126
        r8.mo22747f()     // Catch:{ all -> 0x0289 }
    L_0x0126:
        com.kwai.filedownloader.download.d r0 = r1.f15063b
        r0.mo25166b()
        boolean r0 = r1.f15080t
        if (r0 == 0) goto L_0x0131
        goto L_0x006b
    L_0x0131:
        boolean r0 = r1.f15081u
        if (r0 == 0) goto L_0x0137
        goto L_0x0075
    L_0x0137:
        com.kwai.filedownloader.download.d r0 = r1.f15063b     // Catch:{ IOException -> 0x013e }
        r0.mo25171g()     // Catch:{ IOException -> 0x013e }
        goto L_0x0089
    L_0x013e:
        r0 = move-exception
        goto L_0x0084
    L_0x0141:
        r18.m18974i()     // Catch:{ IOException -> 0x0204, IllegalAccessException -> 0x0202, InterruptedException -> 0x0200, IllegalArgumentException -> 0x01fe, FileDownloadGiveUpRetryException -> 0x01fc, DiscardSafely -> 0x01fa, RetryDirectly -> 0x01f8, all -> 0x01f5 }
        com.kwai.filedownloader.d.c r9 = r1.f15065d     // Catch:{ IOException -> 0x0204, IllegalAccessException -> 0x0202, InterruptedException -> 0x0200, IllegalArgumentException -> 0x01fe, FileDownloadGiveUpRetryException -> 0x01fc, DiscardSafely -> 0x01fa, RetryDirectly -> 0x01f8, all -> 0x01f5 }
        long r14 = r9.mo25090h()     // Catch:{ IOException -> 0x0204, IllegalAccessException -> 0x0202, InterruptedException -> 0x0200, IllegalArgumentException -> 0x01fe, FileDownloadGiveUpRetryException -> 0x01fc, DiscardSafely -> 0x01fa, RetryDirectly -> 0x01f8, all -> 0x01f5 }
        com.kwai.filedownloader.d.c r9 = r1.f15065d     // Catch:{ IOException -> 0x0204, IllegalAccessException -> 0x0202, InterruptedException -> 0x0200, IllegalArgumentException -> 0x01fe, FileDownloadGiveUpRetryException -> 0x01fc, DiscardSafely -> 0x01fa, RetryDirectly -> 0x01f8, all -> 0x01f5 }
        java.lang.String r9 = r9.mo25087e()     // Catch:{ IOException -> 0x0204, IllegalAccessException -> 0x0202, InterruptedException -> 0x0200, IllegalArgumentException -> 0x01fe, FileDownloadGiveUpRetryException -> 0x01fc, DiscardSafely -> 0x01fa, RetryDirectly -> 0x01f8, all -> 0x01f5 }
        r1.m18968a(r14, r9)     // Catch:{ IOException -> 0x0204, IllegalAccessException -> 0x0202, InterruptedException -> 0x0200, IllegalArgumentException -> 0x01fe, FileDownloadGiveUpRetryException -> 0x01fc, DiscardSafely -> 0x01fa, RetryDirectly -> 0x01f8, all -> 0x01f5 }
        boolean r9 = r18.m18972g()     // Catch:{ IOException -> 0x0204, IllegalAccessException -> 0x0202, InterruptedException -> 0x0200, IllegalArgumentException -> 0x01fe, FileDownloadGiveUpRetryException -> 0x01fc, DiscardSafely -> 0x01fa, RetryDirectly -> 0x01f8, all -> 0x01f5 }
        if (r9 == 0) goto L_0x0183
        boolean r9 = r1.f15076p     // Catch:{ IOException -> 0x0204, IllegalAccessException -> 0x0202, InterruptedException -> 0x0200, IllegalArgumentException -> 0x01fe, FileDownloadGiveUpRetryException -> 0x01fc, DiscardSafely -> 0x01fa, RetryDirectly -> 0x01f8, all -> 0x01f5 }
        if (r9 == 0) goto L_0x0166
        com.kwai.filedownloader.d.c r9 = r1.f15065d     // Catch:{ IOException -> 0x0204, IllegalAccessException -> 0x0202, InterruptedException -> 0x0200, IllegalArgumentException -> 0x01fe, FileDownloadGiveUpRetryException -> 0x01fc, DiscardSafely -> 0x01fa, RetryDirectly -> 0x01f8, all -> 0x01f5 }
        int r9 = r9.mo25096n()     // Catch:{ IOException -> 0x0204, IllegalAccessException -> 0x0202, InterruptedException -> 0x0200, IllegalArgumentException -> 0x01fe, FileDownloadGiveUpRetryException -> 0x01fc, DiscardSafely -> 0x01fa, RetryDirectly -> 0x01f8, all -> 0x01f5 }
        r16 = r14
        goto L_0x0186
    L_0x0166:
        com.kwai.filedownloader.download.b r10 = com.kwai.filedownloader.download.C4629b.m18995a()     // Catch:{ IOException -> 0x0204, IllegalAccessException -> 0x0202, InterruptedException -> 0x0200, IllegalArgumentException -> 0x01fe, FileDownloadGiveUpRetryException -> 0x01fc, DiscardSafely -> 0x01fa, RetryDirectly -> 0x01f8, all -> 0x01f5 }
        com.kwai.filedownloader.d.c r9 = r1.f15065d     // Catch:{ IOException -> 0x0204, IllegalAccessException -> 0x0202, InterruptedException -> 0x0200, IllegalArgumentException -> 0x01fe, FileDownloadGiveUpRetryException -> 0x01fc, DiscardSafely -> 0x01fa, RetryDirectly -> 0x01f8, all -> 0x01f5 }
        int r11 = r9.mo25071a()     // Catch:{ IOException -> 0x0204, IllegalAccessException -> 0x0202, InterruptedException -> 0x0200, IllegalArgumentException -> 0x01fe, FileDownloadGiveUpRetryException -> 0x01fc, DiscardSafely -> 0x01fa, RetryDirectly -> 0x01f8, all -> 0x01f5 }
        com.kwai.filedownloader.d.c r9 = r1.f15065d     // Catch:{ IOException -> 0x0204, IllegalAccessException -> 0x0202, InterruptedException -> 0x0200, IllegalArgumentException -> 0x01fe, FileDownloadGiveUpRetryException -> 0x01fc, DiscardSafely -> 0x01fa, RetryDirectly -> 0x01f8, all -> 0x01f5 }
        java.lang.String r12 = r9.mo25077b()     // Catch:{ IOException -> 0x0204, IllegalAccessException -> 0x0202, InterruptedException -> 0x0200, IllegalArgumentException -> 0x01fe, FileDownloadGiveUpRetryException -> 0x01fc, DiscardSafely -> 0x01fa, RetryDirectly -> 0x01f8, all -> 0x01f5 }
        com.kwai.filedownloader.d.c r9 = r1.f15065d     // Catch:{ IOException -> 0x0204, IllegalAccessException -> 0x0202, InterruptedException -> 0x0200, IllegalArgumentException -> 0x01fe, FileDownloadGiveUpRetryException -> 0x01fc, DiscardSafely -> 0x01fa, RetryDirectly -> 0x01f8, all -> 0x01f5 }
        java.lang.String r13 = r9.mo25081c()     // Catch:{ IOException -> 0x0204, IllegalAccessException -> 0x0202, InterruptedException -> 0x0200, IllegalArgumentException -> 0x01fe, FileDownloadGiveUpRetryException -> 0x01fc, DiscardSafely -> 0x01fa, RetryDirectly -> 0x01f8, all -> 0x01f5 }
        r16 = r14
        int r9 = r10.mo25139a(r11, r12, r13, r14)     // Catch:{ IOException -> 0x0204, IllegalAccessException -> 0x0202, InterruptedException -> 0x0200, IllegalArgumentException -> 0x01fe, FileDownloadGiveUpRetryException -> 0x01fc, DiscardSafely -> 0x01fa, RetryDirectly -> 0x01f8, all -> 0x01f5 }
        goto L_0x0186
    L_0x0183:
        r16 = r14
        r9 = 1
    L_0x0186:
        if (r9 <= 0) goto L_0x01e5
        boolean r10 = r1.f15080t     // Catch:{ IOException -> 0x0204, IllegalAccessException -> 0x0202, InterruptedException -> 0x0200, IllegalArgumentException -> 0x01fe, FileDownloadGiveUpRetryException -> 0x01fc, DiscardSafely -> 0x01fa, RetryDirectly -> 0x01f8, all -> 0x01f5 }
        if (r10 == 0) goto L_0x01b1
        com.kwai.filedownloader.d.c r0 = r1.f15065d     // Catch:{ IOException -> 0x0204, IllegalAccessException -> 0x0202, InterruptedException -> 0x0200, IllegalArgumentException -> 0x01fe, FileDownloadGiveUpRetryException -> 0x01fc, DiscardSafely -> 0x01fa, RetryDirectly -> 0x01f8, all -> 0x01f5 }
        r0.mo25072a(r4)     // Catch:{ IOException -> 0x0204, IllegalAccessException -> 0x0202, InterruptedException -> 0x0200, IllegalArgumentException -> 0x01fe, FileDownloadGiveUpRetryException -> 0x01fc, DiscardSafely -> 0x01fa, RetryDirectly -> 0x01f8, all -> 0x01f5 }
        if (r8 == 0) goto L_0x0196
        r8.mo22747f()     // Catch:{ all -> 0x0289 }
    L_0x0196:
        com.kwai.filedownloader.download.d r0 = r1.f15063b
        r0.mo25166b()
        boolean r0 = r1.f15080t
        if (r0 == 0) goto L_0x01a1
        goto L_0x006b
    L_0x01a1:
        boolean r0 = r1.f15081u
        if (r0 == 0) goto L_0x01a7
        goto L_0x0075
    L_0x01a7:
        com.kwai.filedownloader.download.d r0 = r1.f15063b     // Catch:{ IOException -> 0x01ae }
        r0.mo25171g()     // Catch:{ IOException -> 0x01ae }
        goto L_0x0089
    L_0x01ae:
        r0 = move-exception
        goto L_0x0084
    L_0x01b1:
        if (r9 != r5) goto L_0x01b5
        r10 = 1
        goto L_0x01b6
    L_0x01b5:
        r10 = 0
    L_0x01b6:
        r1.f15075n = r10     // Catch:{ IOException -> 0x0204, IllegalAccessException -> 0x0202, InterruptedException -> 0x0200, IllegalArgumentException -> 0x01fe, FileDownloadGiveUpRetryException -> 0x01fc, DiscardSafely -> 0x01fa, RetryDirectly -> 0x01f8, all -> 0x01f5 }
        boolean r10 = r1.f15075n     // Catch:{ IOException -> 0x0204, IllegalAccessException -> 0x0202, InterruptedException -> 0x0200, IllegalArgumentException -> 0x01fe, FileDownloadGiveUpRetryException -> 0x01fc, DiscardSafely -> 0x01fa, RetryDirectly -> 0x01f8, all -> 0x01f5 }
        if (r10 == 0) goto L_0x01c5
        com.kwai.filedownloader.download.a r0 = r7.mo25110e()     // Catch:{ IOException -> 0x0204, IllegalAccessException -> 0x0202, InterruptedException -> 0x0200, IllegalArgumentException -> 0x01fe, FileDownloadGiveUpRetryException -> 0x01fc, DiscardSafely -> 0x01fa, RetryDirectly -> 0x01f8, all -> 0x01f5 }
        r1.m18969a(r0, r8)     // Catch:{ IOException -> 0x0204, IllegalAccessException -> 0x0202, InterruptedException -> 0x0200, IllegalArgumentException -> 0x01fe, FileDownloadGiveUpRetryException -> 0x01fc, DiscardSafely -> 0x01fa, RetryDirectly -> 0x01f8, all -> 0x01f5 }
        r6 = r8
        goto L_0x01de
    L_0x01c5:
        if (r8 == 0) goto L_0x01cb
        r8.mo22747f()     // Catch:{ IOException -> 0x0204, IllegalAccessException -> 0x0202, InterruptedException -> 0x0200, IllegalArgumentException -> 0x01fe, FileDownloadGiveUpRetryException -> 0x01fc, DiscardSafely -> 0x01fa, RetryDirectly -> 0x01f8, all -> 0x01f5 }
        goto L_0x01cc
    L_0x01cb:
        r6 = r8
    L_0x01cc:
        com.kwai.filedownloader.download.d r7 = r1.f15063b     // Catch:{ IOException -> 0x0241, IllegalAccessException -> 0x023f, InterruptedException -> 0x023d, IllegalArgumentException -> 0x023b, FileDownloadGiveUpRetryException -> 0x0239, DiscardSafely -> 0x0218, RetryDirectly -> 0x020b }
        r7.mo25169e()     // Catch:{ IOException -> 0x0241, IllegalAccessException -> 0x023f, InterruptedException -> 0x023d, IllegalArgumentException -> 0x023b, FileDownloadGiveUpRetryException -> 0x0239, DiscardSafely -> 0x0218, RetryDirectly -> 0x020b }
        boolean r7 = r1.f15076p     // Catch:{ IOException -> 0x0241, IllegalAccessException -> 0x023f, InterruptedException -> 0x023d, IllegalArgumentException -> 0x023b, FileDownloadGiveUpRetryException -> 0x0239, DiscardSafely -> 0x0218, RetryDirectly -> 0x020b }
        if (r7 == 0) goto L_0x01d9
        r1.m18966a(r9, r0)     // Catch:{ IOException -> 0x0241, IllegalAccessException -> 0x023f, InterruptedException -> 0x023d, IllegalArgumentException -> 0x023b, FileDownloadGiveUpRetryException -> 0x0239, DiscardSafely -> 0x0218, RetryDirectly -> 0x020b }
        goto L_0x01de
    L_0x01d9:
        r7 = r16
        r1.m18967a(r7, r9)     // Catch:{ IOException -> 0x0241, IllegalAccessException -> 0x023f, InterruptedException -> 0x023d, IllegalArgumentException -> 0x023b, FileDownloadGiveUpRetryException -> 0x0239, DiscardSafely -> 0x0218, RetryDirectly -> 0x020b }
    L_0x01de:
        if (r6 == 0) goto L_0x0256
    L_0x01e0:
        r6.mo22747f()     // Catch:{ all -> 0x0289 }
        goto L_0x0256
    L_0x01e5:
        java.lang.IllegalAccessException r0 = new java.lang.IllegalAccessException     // Catch:{ IOException -> 0x0204, IllegalAccessException -> 0x0202, InterruptedException -> 0x0200, IllegalArgumentException -> 0x01fe, FileDownloadGiveUpRetryException -> 0x01fc, DiscardSafely -> 0x01fa, RetryDirectly -> 0x01f8, all -> 0x01f5 }
        java.lang.String r6 = "invalid connection count %d, the connection count must be larger than 0"
        java.lang.Object[] r7 = new java.lang.Object[r5]     // Catch:{ IOException -> 0x0204, IllegalAccessException -> 0x0202, InterruptedException -> 0x0200, IllegalArgumentException -> 0x01fe, FileDownloadGiveUpRetryException -> 0x01fc, DiscardSafely -> 0x01fa, RetryDirectly -> 0x01f8, all -> 0x01f5 }
        r7[r2] = r8     // Catch:{ IOException -> 0x0204, IllegalAccessException -> 0x0202, InterruptedException -> 0x0200, IllegalArgumentException -> 0x01fe, FileDownloadGiveUpRetryException -> 0x01fc, DiscardSafely -> 0x01fa, RetryDirectly -> 0x01f8, all -> 0x01f5 }
        java.lang.String r6 = com.kwai.filedownloader.p358f.C4664f.m19135a(r6, r7)     // Catch:{ IOException -> 0x0204, IllegalAccessException -> 0x0202, InterruptedException -> 0x0200, IllegalArgumentException -> 0x01fe, FileDownloadGiveUpRetryException -> 0x01fc, DiscardSafely -> 0x01fa, RetryDirectly -> 0x01f8, all -> 0x01f5 }
        r0.<init>(r6)     // Catch:{ IOException -> 0x0204, IllegalAccessException -> 0x0202, InterruptedException -> 0x0200, IllegalArgumentException -> 0x01fe, FileDownloadGiveUpRetryException -> 0x01fc, DiscardSafely -> 0x01fa, RetryDirectly -> 0x01f8, all -> 0x01f5 }
        throw r0     // Catch:{ IOException -> 0x0204, IllegalAccessException -> 0x0202, InterruptedException -> 0x0200, IllegalArgumentException -> 0x01fe, FileDownloadGiveUpRetryException -> 0x01fc, DiscardSafely -> 0x01fa, RetryDirectly -> 0x01f8, all -> 0x01f5 }
    L_0x01f5:
        r0 = move-exception
        goto L_0x0283
    L_0x01f8:
        r6 = r8
        goto L_0x020b
        goto L_0x0219
    L_0x01fc:
        r0 = move-exception
        goto L_0x0205
    L_0x01fe:
        r0 = move-exception
        goto L_0x0205
    L_0x0200:
        r0 = move-exception
        goto L_0x0205
    L_0x0202:
        r0 = move-exception
        goto L_0x0205
    L_0x0204:
        r0 = move-exception
    L_0x0205:
        r6 = r8
        goto L_0x0242
    L_0x0207:
        r0 = move-exception
        r8 = r6
        goto L_0x0283
    L_0x020b:
        com.kwai.filedownloader.d.c r0 = r1.f15065d     // Catch:{ all -> 0x0207 }
        r7 = 5
        r0.mo25072a(r7)     // Catch:{ all -> 0x0207 }
        if (r6 == 0) goto L_0x0098
    L_0x0213:
        r6.mo22747f()     // Catch:{ all -> 0x0289 }
        goto L_0x0098
    L_0x0218:
        r8 = r6
    L_0x0219:
        if (r8 == 0) goto L_0x021e
        r8.mo22747f()     // Catch:{ all -> 0x0289 }
    L_0x021e:
        com.kwai.filedownloader.download.d r0 = r1.f15063b
        r0.mo25166b()
        boolean r0 = r1.f15080t
        if (r0 == 0) goto L_0x0229
        goto L_0x006b
    L_0x0229:
        boolean r0 = r1.f15081u
        if (r0 == 0) goto L_0x022f
        goto L_0x0075
    L_0x022f:
        com.kwai.filedownloader.download.d r0 = r1.f15063b     // Catch:{ IOException -> 0x0236 }
        r0.mo25171g()     // Catch:{ IOException -> 0x0236 }
        goto L_0x0089
    L_0x0236:
        r0 = move-exception
        goto L_0x0084
    L_0x0239:
        r0 = move-exception
        goto L_0x0242
    L_0x023b:
        r0 = move-exception
        goto L_0x0242
    L_0x023d:
        r0 = move-exception
        goto L_0x0242
    L_0x023f:
        r0 = move-exception
        goto L_0x0242
    L_0x0241:
        r0 = move-exception
    L_0x0242:
        boolean r7 = r1.mo25121a(r0)     // Catch:{ all -> 0x0207 }
        if (r7 == 0) goto L_0x0250
        r7 = 0
        r1.mo25120a(r0, r7)     // Catch:{ all -> 0x0207 }
        if (r6 == 0) goto L_0x0098
        goto L_0x0213
    L_0x0250:
        r1.mo25123b(r0)     // Catch:{ all -> 0x0207 }
        if (r6 == 0) goto L_0x0256
        goto L_0x01e0
    L_0x0256:
        com.kwai.filedownloader.download.d r0 = r1.f15063b
        r0.mo25166b()
        boolean r0 = r1.f15080t
        if (r0 == 0) goto L_0x0265
        com.kwai.filedownloader.download.d r0 = r1.f15063b
        r0.mo25170f()
        goto L_0x027d
    L_0x0265:
        boolean r0 = r1.f15081u
        if (r0 == 0) goto L_0x0271
        com.kwai.filedownloader.download.d r0 = r1.f15063b
        java.lang.Exception r3 = r1.f15082v
        r0.mo25162a(r3)
        goto L_0x027d
    L_0x0271:
        com.kwai.filedownloader.download.d r0 = r1.f15063b     // Catch:{ IOException -> 0x0277 }
        r0.mo25171g()     // Catch:{ IOException -> 0x0277 }
        goto L_0x027d
    L_0x0277:
        r0 = move-exception
        com.kwai.filedownloader.download.d r3 = r1.f15063b
        r3.mo25162a(r0)
    L_0x027d:
        java.util.concurrent.atomic.AtomicBoolean r0 = r1.f15079s
        r0.set(r2)
        return
    L_0x0283:
        if (r8 == 0) goto L_0x0288
        r8.mo22747f()     // Catch:{ all -> 0x0289 }
    L_0x0288:
        throw r0     // Catch:{ all -> 0x0289 }
    L_0x0289:
        r0 = move-exception
        r3 = r0
        com.kwai.filedownloader.download.d r0 = r1.f15063b
        r0.mo25166b()
        boolean r0 = r1.f15080t
        if (r0 != 0) goto L_0x02ad
        boolean r0 = r1.f15081u
        if (r0 == 0) goto L_0x02a0
        com.kwai.filedownloader.download.d r0 = r1.f15063b
        java.lang.Exception r4 = r1.f15082v
        r0.mo25162a(r4)
        goto L_0x02b2
    L_0x02a0:
        com.kwai.filedownloader.download.d r0 = r1.f15063b     // Catch:{ IOException -> 0x02a6 }
        r0.mo25171g()     // Catch:{ IOException -> 0x02a6 }
        goto L_0x02b2
    L_0x02a6:
        r0 = move-exception
        com.kwai.filedownloader.download.d r4 = r1.f15063b
        r4.mo25162a(r0)
        goto L_0x02b2
    L_0x02ad:
        com.kwai.filedownloader.download.d r0 = r1.f15063b
        r0.mo25170f()
    L_0x02b2:
        java.util.concurrent.atomic.AtomicBoolean r0 = r1.f15079s
        r0.set(r2)
        throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.filedownloader.download.DownloadLaunchRunnable.run():void");
    }
}
