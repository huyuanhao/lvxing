package com.p530ss.android.socialbase.downloader.impls;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.p530ss.android.socialbase.downloader.downloader.C6694b;
import com.p530ss.android.socialbase.downloader.downloader.DownloadStatusHandler;
import com.p530ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.p530ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.p530ss.android.socialbase.downloader.p557b.DownloadStatus;
import com.p530ss.android.socialbase.downloader.p557b.EnqueueType;
import com.p530ss.android.socialbase.downloader.p557b.ListenerType;
import com.p530ss.android.socialbase.downloader.p557b.RetryDelayStatus;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadFileUriProvider;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadListener;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadNotificationEventListener;
import com.p530ss.android.socialbase.downloader.p559d.INotificationClickCallback;
import com.p530ss.android.socialbase.downloader.p560e.BaseException;
import com.p530ss.android.socialbase.downloader.p561f.C6704a;
import com.p530ss.android.socialbase.downloader.p562g.C6712d;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import com.p530ss.android.socialbase.downloader.p567k.DownloadSetting;
import com.p530ss.android.socialbase.downloader.p568l.DownloadRunnable;
import com.p530ss.android.socialbase.downloader.p568l.WeakDownloadHandler;
import com.p530ss.android.socialbase.downloader.p568l.WeakDownloadHandler.C6749a;
import com.p530ss.android.socialbase.downloader.p569m.C6791h;
import com.p530ss.android.socialbase.downloader.p569m.DownloadExpSwitchCode;
import com.p530ss.android.socialbase.downloader.p569m.DownloadListenerUtils;
import com.p530ss.android.socialbase.downloader.p569m.DownloadUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;

/* renamed from: com.ss.android.socialbase.downloader.impls.a */
public abstract class AbsDownloadEngine implements C6749a {
    /* renamed from: a */
    protected final WeakDownloadHandler f22169a = new WeakDownloadHandler(Looper.getMainLooper(), this);
    /* renamed from: b */
    private final SparseArray<C6712d> f22170b = new SparseArray<>();
    /* renamed from: c */
    private final SparseArray<C6712d> f22171c = new SparseArray<>();
    /* renamed from: d */
    private final SparseArray<C6712d> f22172d = new SparseArray<>();
    /* renamed from: e */
    private final SparseArray<C6712d> f22173e = new SparseArray<>();
    /* renamed from: f */
    private final SparseArray<C6712d> f22174f = new SparseArray<>();
    /* renamed from: g */
    private final C6791h<Integer, C6712d> f22175g = new C6791h<>();
    /* renamed from: h */
    private final SparseArray<Long> f22176h = new SparseArray<>();
    /* renamed from: i */
    private final LinkedBlockingDeque<C6712d> f22177i = new LinkedBlockingDeque<>();
    /* renamed from: j */
    private final IDownloadCache f22178j = C6694b.m27384p();

    /* renamed from: a */
    public abstract List<Integer> mo32479a();

    /* renamed from: a */
    public abstract void mo32484a(int i, C6712d dVar);

    /* renamed from: a */
    public abstract void mo32486a(DownloadRunnable cVar);

    /* renamed from: a */
    public abstract boolean mo32488a(int i);

    /* renamed from: b */
    public abstract void mo32492b(int i);

    /* renamed from: c */
    public abstract DownloadRunnable mo32495c(int i);

    protected AbsDownloadEngine() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x01b8  */
    /* renamed from: a */
    private void m28230a(com.p530ss.android.socialbase.downloader.p562g.C6712d r12, boolean r13) {
        /*
        r11 = this;
        if (r12 != 0) goto L_0x0003
        return
    L_0x0003:
        com.ss.android.socialbase.downloader.g.c r0 = r12.mo32357a()
        if (r0 != 0) goto L_0x000a
        return
    L_0x000a:
        boolean r1 = r0.mo32205aH()
        r2 = 1003(0x3eb, float:1.406E-42)
        r3 = 0
        if (r1 == 0) goto L_0x0053
        com.ss.android.socialbase.downloader.d.ae r12 = r12.mo32401e()
        com.ss.android.socialbase.downloader.e.a r13 = new com.ss.android.socialbase.downloader.e.a
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        java.lang.String r4 = "downloadInfo is Invalid, url is "
        r1.append(r4)
        java.lang.String r4 = r0.mo32295j()
        r1.append(r4)
        java.lang.String r4 = " name is "
        r1.append(r4)
        java.lang.String r4 = r0.mo32287h()
        r1.append(r4)
        java.lang.String r4 = " savePath is "
        r1.append(r4)
        java.lang.String r4 = r0.mo32297k()
        r1.append(r4)
        java.lang.String r1 = r1.toString()
        r13.m51543init(r2, r1)
        if (r0 == 0) goto L_0x004f
        int r3 = r0.mo32308q()
    L_0x004f:
        com.p530ss.android.socialbase.downloader.p563h.DownloadMonitorHelper.m28177a(r12, r0, r13, r3)
        return
    L_0x0053:
        int r1 = r0.mo32283g()
        if (r13 == 0) goto L_0x005c
        r11.m28229a(r0)
    L_0x005c:
        android.util.SparseArray<com.ss.android.socialbase.downloader.g.d> r13 = r11.f22172d
        monitor-enter(r13)
        android.util.SparseArray<com.ss.android.socialbase.downloader.g.d> r4 = r11.f22172d     // Catch:{ all -> 0x01e9 }
        java.lang.Object r4 = r4.get(r1)     // Catch:{ all -> 0x01e9 }
        if (r4 == 0) goto L_0x006c
        android.util.SparseArray<com.ss.android.socialbase.downloader.g.d> r4 = r11.f22172d     // Catch:{ all -> 0x01e9 }
        r4.remove(r1)     // Catch:{ all -> 0x01e9 }
    L_0x006c:
        monitor-exit(r13)     // Catch:{ all -> 0x01e9 }
        android.util.SparseArray<com.ss.android.socialbase.downloader.g.d> r4 = r11.f22171c
        monitor-enter(r4)
        android.util.SparseArray<com.ss.android.socialbase.downloader.g.d> r13 = r11.f22171c     // Catch:{ all -> 0x01e6 }
        java.lang.Object r13 = r13.get(r1)     // Catch:{ all -> 0x01e6 }
        if (r13 == 0) goto L_0x007d
        android.util.SparseArray<com.ss.android.socialbase.downloader.g.d> r13 = r11.f22171c     // Catch:{ all -> 0x01e6 }
        r13.remove(r1)     // Catch:{ all -> 0x01e6 }
    L_0x007d:
        monitor-exit(r4)     // Catch:{ all -> 0x01e6 }
        android.util.SparseArray<com.ss.android.socialbase.downloader.g.d> r13 = r11.f22173e
        monitor-enter(r13)
        android.util.SparseArray<com.ss.android.socialbase.downloader.g.d> r4 = r11.f22173e     // Catch:{ all -> 0x01e3 }
        java.lang.Object r4 = r4.get(r1)     // Catch:{ all -> 0x01e3 }
        if (r4 == 0) goto L_0x008e
        android.util.SparseArray<com.ss.android.socialbase.downloader.g.d> r4 = r11.f22173e     // Catch:{ all -> 0x01e3 }
        r4.remove(r1)     // Catch:{ all -> 0x01e3 }
    L_0x008e:
        monitor-exit(r13)     // Catch:{ all -> 0x01e3 }
        android.util.SparseArray<com.ss.android.socialbase.downloader.g.d> r4 = r11.f22174f
        monitor-enter(r4)
        android.util.SparseArray<com.ss.android.socialbase.downloader.g.d> r13 = r11.f22174f     // Catch:{ all -> 0x01e0 }
        java.lang.Object r13 = r13.get(r1)     // Catch:{ all -> 0x01e0 }
        if (r13 == 0) goto L_0x009f
        android.util.SparseArray<com.ss.android.socialbase.downloader.g.d> r13 = r11.f22174f     // Catch:{ all -> 0x01e0 }
        r13.remove(r1)     // Catch:{ all -> 0x01e0 }
    L_0x009f:
        monitor-exit(r4)     // Catch:{ all -> 0x01e0 }
        r13 = 512(0x200, float:7.175E-43)
        boolean r13 = com.p530ss.android.socialbase.downloader.p569m.DownloadExpSwitchCode.m28744a(r13)
        if (r13 == 0) goto L_0x00c9
        boolean r13 = r11.mo32488a(r1)
        if (r13 == 0) goto L_0x00c9
        android.util.SparseArray<com.ss.android.socialbase.downloader.g.d> r13 = r11.f22170b
        monitor-enter(r13)
        android.util.SparseArray<com.ss.android.socialbase.downloader.g.d> r4 = r11.f22170b     // Catch:{ all -> 0x00c6 }
        java.lang.Object r4 = r4.get(r1)     // Catch:{ all -> 0x00c6 }
        com.ss.android.socialbase.downloader.g.d r4 = (com.p530ss.android.socialbase.downloader.p562g.C6712d) r4     // Catch:{ all -> 0x00c6 }
        if (r4 == 0) goto L_0x00bf
        r4.mo32378a(r12)     // Catch:{ all -> 0x00c6 }
        goto L_0x00c4
    L_0x00bf:
        android.util.SparseArray<com.ss.android.socialbase.downloader.g.d> r4 = r11.f22170b     // Catch:{ all -> 0x00c6 }
        r4.put(r1, r12)     // Catch:{ all -> 0x00c6 }
    L_0x00c4:
        monitor-exit(r13)     // Catch:{ all -> 0x00c6 }
        goto L_0x00c9
    L_0x00c6:
        r12 = move-exception
        monitor-exit(r13)     // Catch:{ all -> 0x00c6 }
        throw r12
    L_0x00c9:
        boolean r13 = r11.mo32488a(r1)
        if (r13 == 0) goto L_0x00fa
        boolean r13 = r0.mo32245av()
        if (r13 != 0) goto L_0x00fa
        java.lang.String r13 = "AbsDownloadEngine"
        java.lang.String r1 = "another task with same id is downloading when tryDownload"
        com.p530ss.android.socialbase.downloader.p561f.C6704a.m27758b(r13, r1)
        boolean r13 = r0.mo32178X()
        if (r13 == 0) goto L_0x00e5
        r12.mo32427p()
    L_0x00e5:
        com.ss.android.socialbase.downloader.d.ae r12 = r12.mo32401e()
        com.ss.android.socialbase.downloader.e.a r13 = new com.ss.android.socialbase.downloader.e.a
        java.lang.String r1 = "downloadInfo is isDownloading and addListenerToSameTask is false"
        r13.m51543init(r2, r1)
        if (r0 == 0) goto L_0x00f6
        int r3 = r0.mo32308q()
    L_0x00f6:
        com.p530ss.android.socialbase.downloader.p563h.DownloadMonitorHelper.m28177a(r12, r0, r13, r3)
        return
    L_0x00fa:
        boolean r13 = r0.mo32245av()
        if (r13 == 0) goto L_0x0105
        com.ss.android.socialbase.downloader.b.a r13 = com.p530ss.android.socialbase.downloader.p557b.AsyncHandleStatus.ASYNC_HANDLE_RESTART
        r0.mo32186a(r13)
    L_0x0105:
        r13 = 32768(0x8000, float:4.5918E-41)
        boolean r13 = com.p530ss.android.socialbase.downloader.p569m.DownloadExpSwitchCode.m28744a(r13)
        if (r13 == 0) goto L_0x0127
        com.ss.android.socialbase.downloader.m.h<java.lang.Integer, com.ss.android.socialbase.downloader.g.d> r13 = r11.f22175g
        monitor-enter(r13)
        com.ss.android.socialbase.downloader.m.h<java.lang.Integer, com.ss.android.socialbase.downloader.g.d> r4 = r11.f22175g     // Catch:{ all -> 0x0124 }
        java.lang.Integer r5 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0124 }
        java.lang.Object r4 = r4.remove(r5)     // Catch:{ all -> 0x0124 }
        com.ss.android.socialbase.downloader.g.d r4 = (com.p530ss.android.socialbase.downloader.p562g.C6712d) r4     // Catch:{ all -> 0x0124 }
        monitor-exit(r13)     // Catch:{ all -> 0x0124 }
        if (r4 == 0) goto L_0x0127
        r12.mo32389b(r4)
        goto L_0x0127
    L_0x0124:
        r12 = move-exception
        monitor-exit(r13)     // Catch:{ all -> 0x0124 }
        throw r12
    L_0x0127:
        android.util.SparseArray<com.ss.android.socialbase.downloader.g.d> r13 = r11.f22170b
        monitor-enter(r13)
        android.util.SparseArray<java.lang.Long> r4 = r11.f22176h     // Catch:{ all -> 0x01dd }
        java.lang.Object r4 = r4.get(r1)     // Catch:{ all -> 0x01dd }
        java.lang.Long r4 = (java.lang.Long) r4     // Catch:{ all -> 0x01dd }
        if (r4 == 0) goto L_0x0139
        long r4 = r4.longValue()     // Catch:{ all -> 0x01dd }
        goto L_0x013b
    L_0x0139:
        r4 = 0
    L_0x013b:
        long r6 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x01dd }
        long r4 = r6 - r4
        r8 = 50
        int r10 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
        if (r10 >= 0) goto L_0x01ca
        android.util.SparseArray<com.ss.android.socialbase.downloader.g.d> r4 = r11.f22170b     // Catch:{ all -> 0x01dd }
        java.lang.Object r4 = r4.get(r1)     // Catch:{ all -> 0x01dd }
        com.ss.android.socialbase.downloader.g.d r4 = (com.p530ss.android.socialbase.downloader.p562g.C6712d) r4     // Catch:{ all -> 0x01dd }
        if (r4 == 0) goto L_0x0165
        com.ss.android.socialbase.downloader.g.c r4 = r4.mo32357a()     // Catch:{ all -> 0x01dd }
        if (r4 == 0) goto L_0x0165
        int r4 = r4.mo32308q()     // Catch:{ all -> 0x01dd }
        if (r4 != 0) goto L_0x0166
        boolean r5 = com.p530ss.android.socialbase.downloader.p557b.DownloadStatus.m26982b(r4)     // Catch:{ all -> 0x01dd }
        if (r5 == 0) goto L_0x0166
        r5 = 1
        goto L_0x0167
    L_0x0165:
        r4 = 0
    L_0x0166:
        r5 = 0
    L_0x0167:
        if (r5 == 0) goto L_0x01b8
        java.lang.String r5 = "AbsDownloadEngine"
        java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x01dd }
        r8.<init>()     // Catch:{ all -> 0x01dd }
        java.lang.String r9 = "can add listener, oldTaskStatus is :"
        r8.append(r9)     // Catch:{ all -> 0x01dd }
        r8.append(r4)     // Catch:{ all -> 0x01dd }
        java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x01dd }
        com.p530ss.android.socialbase.downloader.p561f.C6704a.m27758b(r5, r8)     // Catch:{ all -> 0x01dd }
        if (r4 < 0) goto L_0x0188
        r5 = 2
        if (r4 >= r5) goto L_0x0188
        r12.mo32427p()     // Catch:{ all -> 0x01dd }
        goto L_0x01db
    L_0x0188:
        boolean r4 = r0.mo32178X()     // Catch:{ all -> 0x01dd }
        if (r4 == 0) goto L_0x0192
        r12.mo32427p()     // Catch:{ all -> 0x01dd }
        goto L_0x01db
    L_0x0192:
        com.ss.android.socialbase.downloader.d.ae r4 = r12.mo32401e()     // Catch:{ all -> 0x01dd }
        com.ss.android.socialbase.downloader.e.a r5 = new com.ss.android.socialbase.downloader.e.a     // Catch:{ all -> 0x01dd }
        java.lang.String r8 = "has another same task within 50 milliseconds and addListenerToSameTask is false"
        r5.m51543init(r2, r8)     // Catch:{ all -> 0x01dd }
        if (r0 == 0) goto L_0x01a3
        int r3 = r0.mo32308q()     // Catch:{ all -> 0x01dd }
    L_0x01a3:
        com.p530ss.android.socialbase.downloader.p563h.DownloadMonitorHelper.m28177a(r4, r0, r5, r3)     // Catch:{ all -> 0x01dd }
        android.util.SparseArray<com.ss.android.socialbase.downloader.g.d> r0 = r11.f22170b     // Catch:{ all -> 0x01dd }
        r0.put(r1, r12)     // Catch:{ all -> 0x01dd }
        android.util.SparseArray<java.lang.Long> r0 = r11.f22176h     // Catch:{ all -> 0x01dd }
        java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x01dd }
        r0.put(r1, r2)     // Catch:{ all -> 0x01dd }
        r11.mo32484a(r1, r12)     // Catch:{ all -> 0x01dd }
        goto L_0x01db
    L_0x01b8:
        android.util.SparseArray<com.ss.android.socialbase.downloader.g.d> r0 = r11.f22170b     // Catch:{ all -> 0x01dd }
        r0.put(r1, r12)     // Catch:{ all -> 0x01dd }
        android.util.SparseArray<java.lang.Long> r0 = r11.f22176h     // Catch:{ all -> 0x01dd }
        java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x01dd }
        r0.put(r1, r2)     // Catch:{ all -> 0x01dd }
        r11.mo32484a(r1, r12)     // Catch:{ all -> 0x01dd }
        goto L_0x01db
    L_0x01ca:
        android.util.SparseArray<com.ss.android.socialbase.downloader.g.d> r0 = r11.f22170b     // Catch:{ all -> 0x01dd }
        r0.put(r1, r12)     // Catch:{ all -> 0x01dd }
        android.util.SparseArray<java.lang.Long> r0 = r11.f22176h     // Catch:{ all -> 0x01dd }
        java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x01dd }
        r0.put(r1, r2)     // Catch:{ all -> 0x01dd }
        r11.mo32484a(r1, r12)     // Catch:{ all -> 0x01dd }
    L_0x01db:
        monitor-exit(r13)     // Catch:{ all -> 0x01dd }
        return
    L_0x01dd:
        r12 = move-exception
        monitor-exit(r13)     // Catch:{ all -> 0x01dd }
        throw r12
    L_0x01e0:
        r12 = move-exception
        monitor-exit(r4)     // Catch:{ all -> 0x01e0 }
        throw r12
    L_0x01e3:
        r12 = move-exception
        monitor-exit(r13)     // Catch:{ all -> 0x01e3 }
        throw r12
    L_0x01e6:
        r12 = move-exception
        monitor-exit(r4)     // Catch:{ all -> 0x01e6 }
        throw r12
    L_0x01e9:
        r12 = move-exception
        monitor-exit(r13)     // Catch:{ all -> 0x01e9 }
        throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.socialbase.downloader.impls.AbsDownloadEngine.m28230a(com.ss.android.socialbase.downloader.g.d, boolean):void");
    }

    /* renamed from: a */
    public void mo32485a(C6712d dVar) {
        if (dVar != null) {
            DownloadInfo a = dVar.mo32357a();
            if (a != null) {
                if (a.mo32309r() != EnqueueType.ENQUEUE_NONE) {
                    m28232b(dVar);
                } else {
                    m28230a(dVar, true);
                }
            }
        }
    }

    /* renamed from: b */
    private void m28232b(C6712d dVar) {
        if (dVar != null) {
            DownloadInfo a = dVar.mo32357a();
            if (a != null) {
                try {
                    synchronized (this.f22177i) {
                        if (this.f22177i.isEmpty()) {
                            m28230a(dVar, true);
                            this.f22177i.put(dVar);
                        } else if (a.mo32309r() != EnqueueType.ENQUEUE_TAIL) {
                            C6712d dVar2 = (C6712d) this.f22177i.getFirst();
                            if (dVar2.mo32426o() != dVar.mo32426o() || !mo32488a(dVar.mo32426o())) {
                                mo32497e(dVar2.mo32426o());
                                m28230a(dVar, true);
                                if (dVar2.mo32426o() != dVar.mo32426o()) {
                                    this.f22177i.putFirst(dVar);
                                }
                            }
                        } else if (((C6712d) this.f22177i.getFirst()).mo32426o() != dVar.mo32426o() || !mo32488a(dVar.mo32426o())) {
                            Iterator it = this.f22177i.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                C6712d dVar3 = (C6712d) it.next();
                                if (dVar3 != null && dVar3.mo32426o() == dVar.mo32426o()) {
                                    it.remove();
                                    break;
                                }
                            }
                            this.f22177i.put(dVar);
                            new DownloadStatusHandler(dVar, this.f22169a).mo31896a();
                        }
                    }
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    /* renamed from: d */
    public DownloadInfo mo32496d(int i) {
        DownloadInfo b = this.f22178j.mo31677b(i);
        if (b == null) {
            synchronized (this.f22170b) {
                C6712d dVar = (C6712d) this.f22170b.get(i);
                if (dVar != null) {
                    b = dVar.mo32357a();
                }
            }
        }
        return b;
    }

    /* renamed from: a */
    public List<DownloadInfo> mo32480a(String str) {
        ArrayList arrayList;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        List<DownloadInfo> a = this.f22178j.mo31667a(str);
        if (a != null && !a.isEmpty()) {
            return a;
        }
        synchronized (this.f22170b) {
            arrayList = new ArrayList();
            int size = this.f22170b.size();
            for (int i = 0; i < size; i++) {
                C6712d dVar = (C6712d) this.f22170b.valueAt(i);
                if (!(dVar == null || dVar.mo32357a() == null || !str.equals(dVar.mo32357a().mo32295j()))) {
                    arrayList.add(dVar.mo32357a());
                }
            }
        }
        return arrayList;
    }

    /* renamed from: e */
    public boolean mo32497e(int i) {
        C6704a.m27758b("AbsDownloadEngine", "pause id");
        mo32492b(i);
        DownloadInfo b = this.f22178j.mo31677b(i);
        if (b == null) {
            synchronized (this.f22170b) {
                C6712d dVar = (C6712d) this.f22170b.get(i);
                if (dVar != null) {
                    new DownloadStatusHandler(dVar, this.f22169a).mo31905d();
                    return true;
                }
            }
        } else {
            m28229a(b);
            if (b.mo32308q() == 1) {
                synchronized (this.f22170b) {
                    C6712d dVar2 = (C6712d) this.f22170b.get(i);
                    if (dVar2 != null) {
                        new DownloadStatusHandler(dVar2, this.f22169a).mo31905d();
                        return true;
                    }
                }
            } else if (DownloadStatus.m26982b(b.mo32308q())) {
                b.mo32251b(-2);
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo32489a(int i, boolean z) {
        C6712d dVar = (C6712d) this.f22170b.get(i);
        if (dVar == null && DownloadExpSwitchCode.m28744a(65536)) {
            dVar = m28234o(i);
        }
        if (dVar != null) {
            new DownloadStatusHandler(dVar, this.f22169a).mo31904c();
            final DownloadInfo a = dVar.mo32357a();
            final SparseArray a2 = dVar.mo32355a(ListenerType.MAIN);
            final SparseArray a3 = dVar.mo32355a(ListenerType.NOTIFICATION);
            this.f22169a.post(new Runnable() {
                public void run() {
                    SparseArray sparseArray = a2;
                    if (sparseArray != null) {
                        synchronized (sparseArray) {
                            for (int i = 0; i < a2.size(); i++) {
                                IDownloadListener adVar = (IDownloadListener) a2.get(a2.keyAt(i));
                                if (adVar != null) {
                                    adVar.mo31356f(a);
                                }
                            }
                        }
                    }
                    DownloadInfo cVar = a;
                    if (cVar != null && cVar.mo32229af()) {
                        SparseArray sparseArray2 = a3;
                        if (sparseArray2 != null) {
                            synchronized (sparseArray2) {
                                for (int i2 = 0; i2 < a3.size(); i2++) {
                                    IDownloadListener adVar2 = (IDownloadListener) a3.get(a3.keyAt(i2));
                                    if (adVar2 != null) {
                                        adVar2.mo31356f(a);
                                    }
                                }
                            }
                        }
                    }
                }
            });
        }
        DownloadInfo b = this.f22178j.mo31677b(i);
        if (DownloadExpSwitchCode.m28744a(65536)) {
            if (b != null) {
                b.mo32251b(-4);
            }
        } else if (b != null && DownloadStatus.m26982b(b.mo32308q())) {
            b.mo32251b(-4);
        }
        mo32494b(i, z);
        return true;
    }

    /* renamed from: f */
    public synchronized boolean mo32498f(int i) {
        C6712d dVar = (C6712d) this.f22170b.get(i);
        if (dVar != null) {
            mo32485a(dVar);
        } else {
            mo32499g(i);
        }
        return true;
    }

    /* renamed from: g */
    public synchronized boolean mo32499g(int i) {
        C6712d dVar = (C6712d) this.f22172d.get(i);
        if (dVar != null) {
            mo32485a(dVar);
        } else {
            C6712d dVar2 = (C6712d) this.f22173e.get(i);
            if (dVar2 == null) {
                return false;
            }
            mo32485a(dVar2);
        }
        return true;
    }

    /* renamed from: a */
    private void m28229a(DownloadInfo cVar) {
        if (cVar != null) {
            try {
                if (cVar.mo32308q() == 7 || cVar.mo32240aq() != RetryDelayStatus.DELAY_RETRY_NONE) {
                    cVar.mo32251b(5);
                    cVar.mo32188a(RetryDelayStatus.DELAY_RETRY_NONE);
                    AlarmManager h = C6694b.m27376h();
                    Intent intent = new Intent("com.ss.android.downloader.action.DOWNLOAD_WAKEUP");
                    intent.putExtra("extra_download_id", cVar.mo32283g());
                    intent.setClass(C6694b.m27342B(), DownloadHandleService.class);
                    h.cancel(PendingIntent.getService(C6694b.m27342B(), cVar.mo32283g(), intent, 1073741824));
                    C6704a.m27758b("AbsDownloadEngine", "cancelAlarm");
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public void mo32483a(int i, IDownloadNotificationEventListener agVar) {
        synchronized (this.f22170b) {
            C6712d dVar = (C6712d) this.f22170b.get(i);
            if (dVar != null) {
                dVar.mo32388b(agVar);
            }
        }
    }

    /* renamed from: h */
    public synchronized INotificationClickCallback mo32500h(int i) {
        C6712d dVar = (C6712d) this.f22170b.get(i);
        if (dVar != null) {
            return dVar.mo32418k();
        }
        C6712d dVar2 = (C6712d) this.f22171c.get(i);
        if (dVar2 != null) {
            return dVar2.mo32418k();
        }
        C6712d dVar3 = (C6712d) this.f22172d.get(i);
        if (dVar3 != null) {
            return dVar3.mo32418k();
        }
        C6712d dVar4 = (C6712d) this.f22173e.get(i);
        if (dVar4 != null) {
            return dVar4.mo32418k();
        }
        C6712d dVar5 = (C6712d) this.f22174f.get(i);
        if (dVar5 == null) {
            return null;
        }
        return dVar5.mo32418k();
    }

    /* renamed from: i */
    public synchronized IDownloadNotificationEventListener mo32501i(int i) {
        C6712d dVar = (C6712d) this.f22170b.get(i);
        if (dVar != null) {
            return dVar.mo32416j();
        }
        C6712d dVar2 = (C6712d) this.f22171c.get(i);
        if (dVar2 != null) {
            return dVar2.mo32416j();
        }
        C6712d dVar3 = (C6712d) this.f22172d.get(i);
        if (dVar3 != null) {
            return dVar3.mo32416j();
        }
        C6712d dVar4 = (C6712d) this.f22173e.get(i);
        if (dVar4 != null) {
            return dVar4.mo32416j();
        }
        C6712d dVar5 = (C6712d) this.f22174f.get(i);
        if (dVar5 == null) {
            return null;
        }
        return dVar5.mo32416j();
    }

    /* renamed from: j */
    public synchronized IDownloadFileUriProvider mo32502j(int i) {
        C6712d dVar = (C6712d) this.f22170b.get(i);
        if (dVar != null) {
            return dVar.mo32420l();
        }
        C6712d dVar2 = (C6712d) this.f22171c.get(i);
        if (dVar2 != null) {
            return dVar2.mo32420l();
        }
        C6712d dVar3 = (C6712d) this.f22172d.get(i);
        if (dVar3 != null) {
            return dVar3.mo32420l();
        }
        C6712d dVar4 = (C6712d) this.f22173e.get(i);
        if (dVar4 != null) {
            return dVar4.mo32420l();
        }
        C6712d dVar5 = (C6712d) this.f22174f.get(i);
        if (dVar5 == null) {
            return null;
        }
        return dVar5.mo32420l();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0035, code lost:
            return false;
     */
    /* renamed from: k */
    public synchronized boolean mo32503k(int r4) {
        /*
        r3 = this;
        monitor-enter(r3)
        android.util.SparseArray<com.ss.android.socialbase.downloader.g.d> r0 = r3.f22173e     // Catch:{ all -> 0x0036 }
        java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x0036 }
        com.ss.android.socialbase.downloader.g.d r0 = (com.p530ss.android.socialbase.downloader.p562g.C6712d) r0     // Catch:{ all -> 0x0036 }
        r1 = 0
        if (r0 == 0) goto L_0x001e
        com.ss.android.socialbase.downloader.g.c r2 = r0.mo32357a()     // Catch:{ all -> 0x0036 }
        if (r2 == 0) goto L_0x001e
        boolean r4 = r2.mo32244au()     // Catch:{ all -> 0x0036 }
        if (r4 == 0) goto L_0x001b
        r3.m28230a(r0, r1)     // Catch:{ all -> 0x0036 }
    L_0x001b:
        r4 = 1
        monitor-exit(r3)
        return r4
    L_0x001e:
        com.ss.android.socialbase.downloader.downloader.k r0 = r3.f22178j     // Catch:{ all -> 0x0036 }
        com.ss.android.socialbase.downloader.g.c r4 = r0.mo31677b(r4)     // Catch:{ all -> 0x0036 }
        if (r4 == 0) goto L_0x0034
        boolean r0 = r4.mo32244au()     // Catch:{ all -> 0x0036 }
        if (r0 == 0) goto L_0x0034
        com.ss.android.socialbase.downloader.g.d r0 = new com.ss.android.socialbase.downloader.g.d     // Catch:{ all -> 0x0036 }
        r0.m51574init(r4)     // Catch:{ all -> 0x0036 }
        r3.m28230a(r0, r1)     // Catch:{ all -> 0x0036 }
    L_0x0034:
        monitor-exit(r3)
        return r1
    L_0x0036:
        r4 = move-exception
        monitor-exit(r3)
        throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.socialbase.downloader.impls.AbsDownloadEngine.mo32503k(int):boolean");
    }

    /* renamed from: l */
    public synchronized boolean mo32504l(int i) {
        C6712d dVar = (C6712d) this.f22174f.get(i);
        if (dVar != null) {
            DownloadInfo a = dVar.mo32357a();
            if (a != null) {
                if (a.mo32245av()) {
                    mo32485a(dVar);
                }
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public synchronized void mo32487a(List<String> list) {
        try {
            boolean a = DownloadExpSwitchCode.m28744a(1048576) ? DownloadUtils.m28773a(C6694b.m27342B()) : true;
            for (int i = 0; i < this.f22172d.size(); i++) {
                C6712d dVar = (C6712d) this.f22172d.get(this.f22172d.keyAt(i));
                if (dVar != null) {
                    DownloadInfo a2 = dVar.mo32357a();
                    if (a2 != null && list.contains(a2.mo32231ah())) {
                        if (!a2.mo32317x() || a) {
                            a2.mo32194a(true);
                            a2.mo32254b(true);
                            mo32485a(dVar);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    /* renamed from: b */
    public void mo32491b() {
        List<Integer> a = mo32479a();
        if (a != null) {
            for (Integer intValue : a) {
                mo32497e(intValue.intValue());
            }
        }
    }

    /* renamed from: b */
    public void mo32494b(final int i, final boolean z) {
        DownloadInfo b = this.f22178j.mo31677b(i);
        if (b != null) {
            m28229a(b);
        }
        mo32495c(i);
        this.f22169a.post(new Runnable() {
            public void run() {
                DownloadNotificationManager.m28984a().mo32648f(i);
            }
        });
        if (DownloadUtils.m28807d()) {
            C67243 r0 = new Runnable() {
                public void run() {
                    AbsDownloadEngine.this.m28233c(i, z);
                }
            };
            ExecutorService k = C6694b.m27379k();
            if (k != null) {
                k.execute(r0);
                return;
            }
            return;
        }
        m28233c(i, z);
    }

    /* access modifiers changed from: private|declared_synchronized */
    /* renamed from: c */
    public synchronized void m28233c(int i, boolean z) {
        try {
            DownloadInfo b = this.f22178j.mo31677b(i);
            if (b != null) {
                if (z) {
                    DownloadUtils.m28800c(b.mo32297k(), b.mo32287h());
                }
                DownloadUtils.m28800c(b.mo32300l(), b.mo32303m());
                b.mo32222aY();
            }
            this.f22178j.mo31694f(i);
        } catch (SQLiteException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        mo32481a(i, -4);
        if (this.f22172d.get(i) != null) {
            this.f22172d.remove(i);
        }
        if (this.f22171c.get(i) != null) {
            this.f22171c.remove(i);
        }
        synchronized (this.f22175g) {
            this.f22175g.remove(Integer.valueOf(i));
        }
        DownloadSetting.m28619b(i);
        return;
    }

    /* renamed from: m */
    public synchronized void mo32505m(int i) {
        C6712d dVar = (C6712d) this.f22170b.get(i);
        if (dVar != null) {
            DownloadInfo a = dVar.mo32357a();
            if (a != null) {
                a.mo32293i(true);
                mo32485a(dVar);
            }
        }
    }

    /* renamed from: n */
    public synchronized boolean mo32506n(int i) {
        boolean z;
        if (i != 0) {
            if (!((this.f22170b == null || this.f22170b.get(i) == null) && (this.f22172d == null || this.f22172d.get(i) == null))) {
                z = true;
            }
        }
        z = false;
        return z;
    }

    /* renamed from: a */
    public synchronized void mo32482a(int i, int i2, IDownloadListener adVar, ListenerType hVar, boolean z) {
        C6712d o = m28234o(i);
        if (o == null) {
            o = (C6712d) this.f22175g.get(Integer.valueOf(i));
        }
        if (o != null) {
            o.mo32376a(i2, adVar, hVar, z);
        }
    }

    /* renamed from: b */
    public synchronized void mo32493b(int i, int i2, final IDownloadListener adVar, ListenerType hVar, boolean z) {
        C6712d o = m28234o(i);
        if (o != null) {
            o.mo32387b(i2, adVar, hVar, z);
            final DownloadInfo a = o.mo32357a();
            if (a != null && !mo32488a(i) && (hVar == ListenerType.MAIN || hVar == ListenerType.NOTIFICATION)) {
                boolean z2 = true;
                if (hVar == ListenerType.NOTIFICATION && !a.mo32229af()) {
                    z2 = false;
                }
                if (z2) {
                    this.f22169a.post(new Runnable() {
                        public void run() {
                            DownloadInfo cVar = a;
                            if (cVar != null && adVar != null) {
                                if (cVar.mo32308q() == -3) {
                                    adVar.mo31355e(a);
                                } else if (a.mo32308q() == -1) {
                                    adVar.mo31351a(a, new BaseException(1000, "尝试为failed的任务add listener"));
                                }
                            }
                        }
                    });
                }
            }
        } else if (DownloadExpSwitchCode.m28744a(32768)) {
            DownloadInfo b = this.f22178j.mo31677b(i);
            if (!(b == null || b.mo32308q() == -3)) {
                C6712d dVar = (C6712d) this.f22175g.get(Integer.valueOf(i));
                if (dVar == null) {
                    dVar = new C6712d(b);
                    synchronized (this.f22175g) {
                        this.f22175g.put(Integer.valueOf(i), dVar);
                    }
                }
                dVar.mo32387b(i2, adVar, hVar, z);
            }
        }
    }

    /* renamed from: o */
    private C6712d m28234o(int i) {
        C6712d dVar = (C6712d) this.f22170b.get(i);
        if (dVar != null) {
            return dVar;
        }
        C6712d dVar2 = (C6712d) this.f22172d.get(i);
        if (dVar2 != null) {
            return dVar2;
        }
        C6712d dVar3 = (C6712d) this.f22171c.get(i);
        if (dVar3 != null) {
            return dVar3;
        }
        C6712d dVar4 = (C6712d) this.f22173e.get(i);
        return dVar4 == null ? (C6712d) this.f22174f.get(i) : dVar4;
    }

    /* renamed from: b */
    public List<DownloadInfo> mo32490b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Integer intValue : mo32479a()) {
            DownloadInfo d = mo32496d(intValue.intValue());
            if (d != null && str.equals(d.mo32231ah())) {
                arrayList.add(d);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m28228a(int i, BaseException aVar, C6712d dVar) {
        if (dVar != null) {
            DownloadInfo a = dVar.mo32357a();
            SparseArray a2 = dVar.mo32355a(ListenerType.MAIN);
            SparseArray a3 = dVar.mo32355a(ListenerType.NOTIFICATION);
            boolean m = dVar.mo32423m();
            DownloadListenerUtils.m28746a(i, a2, true, a, aVar);
            DownloadListenerUtils.m28746a(i, a3, m, a, aVar);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003a, code lost:
            return;
     */
    /* renamed from: p */
    private void m28235p(int r3) {
        /*
        r2 = this;
        java.util.concurrent.LinkedBlockingDeque<com.ss.android.socialbase.downloader.g.d> r0 = r2.f22177i
        boolean r0 = r0.isEmpty()
        if (r0 == 0) goto L_0x0009
        return
    L_0x0009:
        java.util.concurrent.LinkedBlockingDeque<com.ss.android.socialbase.downloader.g.d> r0 = r2.f22177i
        monitor-enter(r0)
        java.util.concurrent.LinkedBlockingDeque<com.ss.android.socialbase.downloader.g.d> r1 = r2.f22177i     // Catch:{ all -> 0x003b }
        java.lang.Object r1 = r1.getFirst()     // Catch:{ all -> 0x003b }
        com.ss.android.socialbase.downloader.g.d r1 = (com.p530ss.android.socialbase.downloader.p562g.C6712d) r1     // Catch:{ all -> 0x003b }
        if (r1 == 0) goto L_0x0021
        int r1 = r1.mo32426o()     // Catch:{ all -> 0x003b }
        if (r1 != r3) goto L_0x0021
        java.util.concurrent.LinkedBlockingDeque<com.ss.android.socialbase.downloader.g.d> r3 = r2.f22177i     // Catch:{ all -> 0x003b }
        r3.poll()     // Catch:{ all -> 0x003b }
    L_0x0021:
        java.util.concurrent.LinkedBlockingDeque<com.ss.android.socialbase.downloader.g.d> r3 = r2.f22177i     // Catch:{ all -> 0x003b }
        boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x003b }
        if (r3 == 0) goto L_0x002b
        monitor-exit(r0)     // Catch:{ all -> 0x003b }
        return
    L_0x002b:
        java.util.concurrent.LinkedBlockingDeque<com.ss.android.socialbase.downloader.g.d> r3 = r2.f22177i     // Catch:{ all -> 0x003b }
        java.lang.Object r3 = r3.getFirst()     // Catch:{ all -> 0x003b }
        com.ss.android.socialbase.downloader.g.d r3 = (com.p530ss.android.socialbase.downloader.p562g.C6712d) r3     // Catch:{ all -> 0x003b }
        if (r3 == 0) goto L_0x0039
        r1 = 1
        r2.m28230a(r3, r1)     // Catch:{ all -> 0x003b }
    L_0x0039:
        monitor-exit(r0)     // Catch:{ all -> 0x003b }
        return
    L_0x003b:
        r3 = move-exception
        monitor-exit(r0)     // Catch:{ all -> 0x003b }
        throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.socialbase.downloader.impls.AbsDownloadEngine.m28235p(int):void");
    }

    /* renamed from: a */
    public synchronized void mo32481a(int i, int i2) {
        if (i2 != -7) {
            if (i2 == -6) {
                this.f22171c.put(i, (C6712d) this.f22170b.get(i));
                this.f22170b.remove(i);
            } else if (i2 == -4) {
                this.f22170b.remove(i);
                m28235p(i);
            } else if (i2 == -3) {
                this.f22171c.put(i, (C6712d) this.f22170b.get(i));
                this.f22170b.remove(i);
                m28235p(i);
            } else if (i2 != -1) {
                if (i2 == 7) {
                    C6712d dVar = (C6712d) this.f22170b.get(i);
                    if (dVar != null) {
                        if (this.f22173e.get(i) == null) {
                            this.f22173e.put(i, dVar);
                        }
                        this.f22170b.remove(i);
                    }
                    m28235p(i);
                } else if (i2 == 8) {
                    C6712d dVar2 = (C6712d) this.f22170b.get(i);
                    if (dVar2 != null && this.f22174f.get(i) == null) {
                        this.f22174f.put(i, dVar2);
                    }
                    m28235p(i);
                }
            }
        }
        C6712d dVar3 = (C6712d) this.f22170b.get(i);
        if (dVar3 != null) {
            if (this.f22172d.get(i) == null) {
                this.f22172d.put(i, dVar3);
            }
            this.f22170b.remove(i);
        }
        m28235p(i);
    }

    /* renamed from: a */
    public void mo31460a(Message message) {
        int i = message.arg1;
        BaseException aVar = message.obj instanceof Exception ? (BaseException) message.obj : null;
        synchronized (AbsDownloadEngine.class) {
            C6712d dVar = (C6712d) this.f22170b.get(i);
            if (dVar != null) {
                m28228a(message.what, aVar, dVar);
                mo32481a(i, message.what);
            }
        }
    }
}
