package com.p530ss.android.downloadlib.p541a.p543b;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.p530ss.android.downloadad.p538a.p540b.NativeDownloadModel;
import com.p530ss.android.downloadlib.DownloadComponentManager;
import com.p530ss.android.downloadlib.p541a.C6565j;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.a.b.e */
public class SharedPrefsManager {

    /* compiled from: SharedPrefsManager */
    /* renamed from: com.ss.android.downloadlib.a.b.e$a */
    private static class C6550a {
        /* access modifiers changed from: private|static */
        /* renamed from: a */
        public static SharedPrefsManager f21330a = new SharedPrefsManager();
    }

    /* renamed from: a */
    public static SharedPrefsManager m26192a() {
        return C6550a.f21330a;
    }

    private SharedPrefsManager() {
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public SharedPreferences m26193c() {
        return C6565j.m26357a().getSharedPreferences("sp_ad_download_event", 0);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public ConcurrentHashMap<Long, NativeDownloadModel> mo31283b() {
        ConcurrentHashMap<Long, NativeDownloadModel> concurrentHashMap = new ConcurrentHashMap<>();
        try {
            for (Entry entry : m26193c().getAll().entrySet()) {
                try {
                    long longValue = Long.valueOf((String) entry.getKey()).longValue();
                    NativeDownloadModel b = NativeDownloadModel.m26068b(new JSONObject((String) entry.getValue()));
                    if (longValue > 0 && b != null) {
                        concurrentHashMap.put(Long.valueOf(longValue), b);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return concurrentHashMap;
    }

    /* renamed from: a */
    public void mo31281a(NativeDownloadModel aVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVar);
        mo31282a((List<NativeDownloadModel>) arrayList);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001c, code lost:
            return;
     */
    /* renamed from: a */
    public synchronized void mo31282a(final java.util.List<com.p530ss.android.downloadad.p538a.p540b.NativeDownloadModel> r3) {
        /*
        r2 = this;
        monitor-enter(r2)
        if (r3 == 0) goto L_0x001b
        boolean r0 = r3.isEmpty()     // Catch:{ all -> 0x0018 }
        if (r0 == 0) goto L_0x000a
        goto L_0x001b
    L_0x000a:
        com.ss.android.downloadlib.d r0 = com.p530ss.android.downloadlib.DownloadComponentManager.m26440a()     // Catch:{ all -> 0x0018 }
        com.ss.android.downloadlib.a.b.e$1 r1 = new com.ss.android.downloadlib.a.b.e$1     // Catch:{ all -> 0x0018 }
        r1.m51263init(r3)     // Catch:{ all -> 0x0018 }
        r0.mo31388b(r1)     // Catch:{ all -> 0x0018 }
        monitor-exit(r2)
        return
    L_0x0018:
        r3 = move-exception
        monitor-exit(r2)
        throw r3
    L_0x001b:
        monitor-exit(r2)
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.downloadlib.p541a.p543b.SharedPrefsManager.mo31282a(java.util.List):void");
    }

    /* renamed from: b */
    public void mo31284b(final List<String> list) {
        if (list != null && !list.isEmpty()) {
            DownloadComponentManager.m26440a().mo31388b(new Runnable() {
                public void run() {
                    Editor edit = SharedPrefsManager.this.m26193c().edit();
                    for (String remove : list) {
                        edit.remove(remove);
                    }
                    edit.apply();
                }
            });
        }
    }
}
