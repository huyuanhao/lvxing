package com.tencent.mta.track;

import android.util.Log;
import com.tencent.mta.track.exceptions.InvalidDataException;
import java.util.Iterator;
import java.util.Map.Entry;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.k */
final class C7380k implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C7378i f24961a;

    private C7380k(C7378i iVar) {
        this.f24961a = iVar;
    }

    public void run() {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.f24961a.f24960d) {
            Iterator it = this.f24961a.f24960d.entrySet().iterator();
            while (it.hasNext()) {
                C7382m mVar = (C7382m) ((Entry) it.next()).getValue();
                if (currentTimeMillis - mVar.f24963a > 3000) {
                    try {
                        StatisticsDataAPI.sharedInstance(this.f24961a.f24957a).track(mVar.f24964b.f24999b, mVar.f24965c);
                    } catch (InvalidDataException e) {
                        Log.w("Unexpected exception", e);
                    }
                    it.remove();
                }
            }
            if (!this.f24961a.f24960d.isEmpty()) {
                this.f24961a.f24958b.postDelayed(this, 1500);
            }
        }
    }
}
