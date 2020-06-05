package com.bytedance.sdk.openadsdk.core.widget.webview.p179a;

import android.os.HandlerThread;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.core.C1982p;
import com.bytedance.sdk.adnet.p159b.RequestFuture;
import com.bytedance.sdk.adnet.p159b.StringRequest;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.core.p170d.TmplDiffModel;
import com.bytedance.sdk.openadsdk.core.p174h.TplInfo;
import com.bytedance.sdk.openadsdk.p188g.TTNetClient;
import com.bytedance.sdk.openadsdk.p198i.TTExecutor;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import com.tencent.mid.sotrage.StorageInterface;
import com.tencent.p605ep.commonbase.software.AppEntity;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.core.widget.webview.a.d */
class TmplDiffManager {
    /* renamed from: a */
    private static volatile TmplDiffManager f8395a;
    /* access modifiers changed from: private|final */
    /* renamed from: b */
    public final AtomicLong f8396b = new AtomicLong((long) (InternalContainer.m10069h().mo15803n() * 1000));
    /* renamed from: c */
    private ScheduledFuture<?> f8397c;
    /* renamed from: d */
    private AtomicBoolean f8398d = new AtomicBoolean(false);

    /* compiled from: TmplDiffManager */
    /* renamed from: com.bytedance.sdk.openadsdk.core.widget.webview.a.d$a */
    private class C2371a implements Runnable {
        /* renamed from: b */
        private int f8406b = 0;

        public C2371a(int i) {
            this.f8406b = i;
        }

        public void run() {
            if (this.f8406b == 1) {
                TmplDiffManager.this.m10902d();
                TTExecutor.m11692a().mo16802a((Runnable) new C2371a(1), TmplDiffManager.this.f8396b.get());
            }
        }
    }

    /* renamed from: a */
    public static TmplDiffManager m10896a() {
        if (f8395a == null) {
            synchronized (TmplDiffManager.class) {
                if (f8395a == null) {
                    f8395a = new TmplDiffManager();
                }
            }
        }
        return f8395a;
    }

    private TmplDiffManager() {
        new HandlerThread("TmplDiffManager-Thread").start();
        this.f8397c = TTExecutor.m11692a().mo16802a((Runnable) new C2371a(1), 0);
    }

    /* renamed from: a */
    public TmplDiffModel mo16376a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return TmplDbHelper.m10887a().mo16370a(str);
    }

    /* renamed from: b */
    public void mo16380b() {
        long n = (long) (InternalContainer.m10069h().mo15803n() * 1000);
        if (this.f8396b.get() != n) {
            ScheduledFuture<?> scheduledFuture = this.f8397c;
            if (scheduledFuture != null && scheduledFuture.isCancelled()) {
                this.f8397c.cancel(true);
            }
            this.f8396b.set(n);
            this.f8397c = TTExecutor.m11692a().mo16802a((Runnable) new C2371a(1), 0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m10902d() {
        List<TmplDiffModel> b = TmplDbHelper.m10887a().mo16373b();
        if (!b.isEmpty()) {
            for (TmplDiffModel pVar : b) {
                if (!TextUtils.isEmpty(pVar.mo15574d())) {
                    JSONObject b2 = m10900b(pVar.mo15574d());
                    if (b2 != null) {
                        String optString = b2.optString("md5");
                        String optString2 = b2.optString(AppEntity.KEY_VERSION_STR);
                        String optString3 = b2.optString("data");
                        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                            if (!TextUtils.isEmpty(optString3)) {
                                if (!optString.equals(pVar.mo15572c())) {
                                    pVar.mo15571c(optString).mo15575e(optString3);
                                    if (C2373f.m10916b(optString2)) {
                                        pVar.mo15577f(optString2);
                                        TemplateManager.m10874a().mo16365a(true);
                                    }
                                    TmplDbHelper.m10887a().mo16371a(pVar);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m10903e() {
        String str = "TmplDiffManager";
        C2564t.m12220b(str, "start doCheckAndDeleteTask");
        if (InternalContainer.m10069h() != null) {
            int Q = InternalContainer.m10069h().mo15769Q() * 3;
            if (Q > 0) {
                List b = TmplDbHelper.m10887a().mo16373b();
                boolean isEmpty = b.isEmpty();
                String str2 = StorageInterface.KEY_SPLITER;
                if (isEmpty || Q >= b.size()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("end doCheckAndDeleteTask maxTplCnt,local size");
                    sb.append(Q);
                    sb.append(str2);
                    sb.append(b.size());
                    C2564t.m12220b(str, sb.toString());
                    return;
                }
                int size = (int) (((float) b.size()) - (((float) Q) * 0.75f));
                StringBuilder sb2 = new StringBuilder();
                sb2.append("doCheckAndDeleteTask maxTplCnt,local size,deleteCnt:");
                sb2.append(Q);
                sb2.append(str2);
                sb2.append(b.size());
                sb2.append(str2);
                sb2.append(size);
                C2564t.m12220b(str, sb2.toString());
                HashSet hashSet = new HashSet();
                for (int i = 0; i < size; i++) {
                    hashSet.add(((TmplDiffModel) b.get(i)).mo15570b());
                }
                mo16379a((Set<String>) hashSet);
                C2564t.m12220b(str, "end doCheckAndDeleteTask");
                this.f8398d.set(false);
            }
        }
    }

    /* renamed from: c */
    public void mo16381c() {
        if (!this.f8398d.getAndSet(true)) {
            TTExecutor.m11692a().mo16802a((Runnable) new Runnable() {
                public void run() {
                    TmplDiffManager.this.m10903e();
                }
            }, 60000);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public JSONObject m10900b(String str) {
        RequestFuture a = RequestFuture.m7746a();
        new StringRequest(0, str, a).setShouldCache(false).build(TTNetClient.m11428a(InternalContainer.m10059a()).mo16657d());
        try {
            C1982p b = a.get();
            if (!(b == null || !b.mo14373a() || b.f6293a == null)) {
                return new JSONObject((String) b.f6293a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /* renamed from: a */
    public void mo16377a(MaterialMeta kVar) {
        if (kVar != null && kVar.mo15510x() != null) {
            String b = kVar.mo15510x().mo15515b();
            String d = kVar.mo15510x().mo15519d();
            String c = kVar.mo15510x().mo15517c();
            int d2 = ToolUtils.m12018d(kVar.mo15428P());
            TplInfo c2 = TplInfo.m9852a().mo15822a(b).mo15823b(c).mo15824c(d);
            StringBuilder sb = new StringBuilder();
            sb.append(d2);
            sb.append("");
            mo16378a(c2, sb.toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0040, code lost:
            return;
     */
    /* renamed from: a */
    public synchronized void mo16378a(com.bytedance.sdk.openadsdk.core.p174h.TplInfo r7, java.lang.String r8) {
        /*
        r6 = this;
        monitor-enter(r6)
        if (r7 != 0) goto L_0x0005
        monitor-exit(r6)
        return
    L_0x0005:
        java.lang.String r2 = r7.f7703a     // Catch:{ all -> 0x0041 }
        java.lang.String r4 = r7.f7705c     // Catch:{ all -> 0x0041 }
        java.lang.String r3 = r7.f7704b     // Catch:{ all -> 0x0041 }
        boolean r7 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0041 }
        if (r7 == 0) goto L_0x0019
        com.bytedance.sdk.openadsdk.core.h r7 = com.bytedance.sdk.openadsdk.core.GlobalInfo.m9616c()     // Catch:{ all -> 0x0041 }
        java.lang.String r8 = r7.mo15675e()     // Catch:{ all -> 0x0041 }
    L_0x0019:
        r5 = r8
        boolean r7 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0041 }
        if (r7 != 0) goto L_0x003f
        boolean r7 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0041 }
        if (r7 != 0) goto L_0x003f
        boolean r7 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0041 }
        if (r7 == 0) goto L_0x002d
        goto L_0x003f
    L_0x002d:
        com.bytedance.sdk.openadsdk.i.a r7 = com.bytedance.sdk.openadsdk.p198i.TTExecutor.m11692a()     // Catch:{ all -> 0x0041 }
        com.bytedance.sdk.openadsdk.core.widget.webview.a.d$2 r8 = new com.bytedance.sdk.openadsdk.core.widget.webview.a.d$2     // Catch:{ all -> 0x0041 }
        r0 = r8
        r1 = r6
        r0.m43926init(r2, r3, r4, r5)     // Catch:{ all -> 0x0041 }
        r0 = 10
        r7.mo16808c(r8, r0)     // Catch:{ all -> 0x0041 }
        monitor-exit(r6)
        return
    L_0x003f:
        monitor-exit(r6)
        return
    L_0x0041:
        r7 = move-exception
        monitor-exit(r6)
        throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.widget.webview.p179a.TmplDiffManager.mo16378a(com.bytedance.sdk.openadsdk.core.h.m, java.lang.String):void");
    }

    /* renamed from: a */
    public void mo16379a(Set<String> set) {
        try {
            TmplDbHelper.m10887a().mo16372a(set);
        } catch (Throwable unused) {
        }
    }
}
