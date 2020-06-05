package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.as */
public class C7234as extends Thread {
    /* renamed from: a */
    final List<C7233ar> f24434a = Collections.synchronizedList(new ArrayList());
    /* renamed from: b */
    private boolean f24435b = false;
    /* renamed from: c */
    private List<C7235at> f24436c = Collections.synchronizedList(new ArrayList());

    /* renamed from: a */
    public void mo34848a() {
        mo34849a(new Handler(Looper.getMainLooper()));
    }

    /* renamed from: b */
    public void mo34852b() {
        mo34853b(new Handler(Looper.getMainLooper()));
    }

    /* renamed from: a */
    public void mo34849a(Handler handler) {
        mo34850a(handler, 5000);
    }

    /* renamed from: a */
    public void mo34850a(Handler handler, long j) {
        if (handler == null) {
            C7226an.m31149e("addThread handler should not be null", new Object[0]);
            return;
        }
        String name = handler.getLooper().getThread().getName();
        for (int i = 0; i < this.f24434a.size(); i++) {
            if (((C7233ar) this.f24434a.get(i)).mo34845e().equals(handler.getLooper().getThread().getName())) {
                C7226an.m31149e("addThread fail ,this thread has been added in monitor queue", new Object[0]);
                return;
            }
        }
        this.f24434a.add(new C7233ar(handler, name, j));
    }

    /* renamed from: b */
    public void mo34853b(Handler handler) {
        if (handler == null) {
            C7226an.m31149e("removeThread handler should not be null", new Object[0]);
            return;
        }
        for (int i = 0; i < this.f24434a.size(); i++) {
            if (((C7233ar) this.f24434a.get(i)).mo34845e().equals(handler.getLooper().getThread().getName())) {
                C7226an.m31147c("remove handler::%s", this.f24434a.get(i));
                this.f24434a.remove(i);
            }
        }
    }

    /* renamed from: c */
    public boolean mo34855c() {
        this.f24435b = true;
        if (!isAlive()) {
            return false;
        }
        try {
            interrupt();
        } catch (Exception e) {
            C7226an.m31149e(e.getStackTrace().toString(), new Object[0]);
        }
        return true;
    }

    /* renamed from: d */
    public boolean mo34856d() {
        boolean z = false;
        if (isAlive()) {
            return false;
        }
        try {
            start();
            z = true;
        } catch (Exception e) {
            C7226an.m31149e(e.getStackTrace().toString(), new Object[0]);
        }
        return z;
    }

    /* renamed from: e */
    private int m31232e() {
        int i = 0;
        for (int i2 = 0; i2 < this.f24434a.size(); i2++) {
            i = Math.max(i, ((C7233ar) this.f24434a.get(i2)).mo34843c());
        }
        return i;
    }

    /* renamed from: a */
    public void mo34851a(C7235at atVar) {
        if (this.f24436c.contains(atVar)) {
            C7226an.m31149e("addThreadMonitorListeners fail ,this threadMonitorListener has been added in monitor queue", new Object[0]);
            return;
        }
        this.f24436c.add(atVar);
    }

    /* renamed from: b */
    public void mo34854b(C7235at atVar) {
        this.f24436c.remove(atVar);
    }

    public void run() {
        while (!this.f24435b) {
            for (int i = 0; i < this.f24434a.size(); i++) {
                ((C7233ar) this.f24434a.get(i)).mo34840a();
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            for (long j = 2000; j > 0 && !isInterrupted(); j = 2000 - (SystemClock.uptimeMillis() - uptimeMillis)) {
                try {
                    sleep(j);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            int e2 = m31232e();
            if (e2 != 0) {
                if (e2 != 1) {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < this.f24434a.size(); i2++) {
                        C7233ar arVar = (C7233ar) this.f24434a.get(i2);
                        if (arVar.mo34842b()) {
                            arrayList.add(arVar);
                            arVar.mo34841a(Long.MAX_VALUE);
                        }
                    }
                    int i3 = 0;
                    boolean z = false;
                    while (i3 < arrayList.size()) {
                        C7233ar arVar2 = (C7233ar) arrayList.get(i3);
                        Thread d = arVar2.mo34844d();
                        boolean z2 = z;
                        for (int i4 = 0; i4 < this.f24436c.size(); i4++) {
                            if (((C7235at) this.f24436c.get(i4)).mo34656a(d)) {
                                z2 = true;
                            }
                        }
                        if (!z2) {
                            m31231a(arVar2);
                        }
                        i3++;
                        z = z2;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m31231a(C7233ar arVar) {
        if (arVar.mo34845e().contains("main")) {
            arVar.mo34846f();
            C7226an.m31148d("although thread is blocked ,may not be anr error,so restore handler check wait time and restart check main thread", new Object[0]);
        }
    }
}
