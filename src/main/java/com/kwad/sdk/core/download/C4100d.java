package com.kwad.sdk.core.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.kwad.sdk.KsAdSDK;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.p333g.C4143b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p342b.C4322a;
import com.kwad.sdk.core.response.p342b.C4324c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.kwad.sdk.core.download.d */
public class C4100d {
    /* renamed from: a */
    private static final ArrayList<WeakReference<C4103e>> f13758a = new ArrayList<>();
    /* renamed from: b */
    private static AtomicBoolean f13759b = new AtomicBoolean(false);
    /* renamed from: c */
    private static final Map<String, AdTemplate> f13760c = new HashMap();
    /* renamed from: d */
    private static final BroadcastReceiver f13761d = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            C4100d.m17035c(intent);
        }
    };
    /* renamed from: e */
    private static final BroadcastReceiver f13762e = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            C4100d.m17036d(intent);
        }
    };

    /* renamed from: a */
    public static final void m17027a() {
        if (!f13759b.get() && KsAdSDK.getContext() != null) {
            f13759b.set(true);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(C4086a.f13736b);
            intentFilter.addAction(C4086a.f13737c);
            intentFilter.addAction(C4086a.f13738d);
            intentFilter.addAction(C4086a.f13739e);
            intentFilter.addAction(C4086a.f13740f);
            intentFilter.addAction(C4086a.f13741g);
            intentFilter.addAction(C4086a.f13742h);
            intentFilter.addAction(C4086a.f13743i);
            intentFilter.addAction(C4086a.f13744j);
            intentFilter.addAction(C4086a.f13745k);
            intentFilter.addAction(C4086a.f13746l);
            KsAdSDK.getContext().registerReceiver(f13761d, intentFilter);
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter2.addDataScheme("package");
            KsAdSDK.getContext().registerReceiver(f13762e, intentFilter2);
        }
    }

    /* renamed from: a */
    public static void m17028a(Context context) {
        try {
            context.unregisterReceiver(f13761d);
            context.unregisterReceiver(f13762e);
            f13758a.clear();
            f13760c.clear();
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public static void m17030a(C4103e eVar) {
        m17027a();
        synchronized (f13758a) {
            m17033b();
            Iterator it = f13758a.iterator();
            while (it.hasNext()) {
                if (((C4103e) ((WeakReference) it.next()).get()) == eVar) {
                    return;
                }
            }
            f13758a.add(new WeakReference(eVar));
        }
    }

    /* renamed from: a */
    public static void m17031a(AdTemplate adTemplate) {
        m17027a();
        synchronized (f13760c) {
            try {
                String n = C4322a.m17646n(C4324c.m17668e(adTemplate));
                if (!TextUtils.isEmpty(n)) {
                    f13760c.put(n, adTemplate);
                }
            } catch (Exception e) {
                C4065b.m16865a(e);
            }
        }
    }

    /* renamed from: a */
    private static void m17032a(String str) {
        for (Entry entry : f13760c.entrySet()) {
            if (entry != null) {
                AdTemplate adTemplate = (AdTemplate) entry.getValue();
                if (adTemplate != null) {
                    AdInfo e = C4324c.m17668e(adTemplate);
                    if (!TextUtils.isEmpty(str) && e.downloadId.equals(str) && !adTemplate.mDownloadFinishReported) {
                        C4143b.m17130c(adTemplate);
                        adTemplate.mDownloadFinishReported = true;
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private static final void m17033b() {
        Iterator it = f13758a.iterator();
        while (it.hasNext()) {
            if (((C4103e) ((WeakReference) it.next()).get()) == null) {
                it.remove();
            }
        }
    }

    /* access modifiers changed from: private|static|final */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c7 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x013f  */
    /* renamed from: c */
    public static final void m17035c(android.content.Intent r19) {
        /*
        android.os.Bundle r0 = r19.getExtras()
        if (r0 != 0) goto L_0x0007
        return
    L_0x0007:
        java.lang.String r1 = "RESULT_DOWNLOAD_ID"
        java.lang.String r1 = r0.getString(r1)
        java.lang.String r2 = r19.getAction()
        java.lang.String r3 = com.kwad.sdk.core.download.C4086a.f13736b
        boolean r3 = android.text.TextUtils.equals(r3, r2)
        r6 = 9
        r7 = 8
        r8 = 7
        r9 = 6
        r10 = 5
        r11 = 4
        r12 = 2
        r13 = 1
        r14 = 3
        r15 = 0
        r16 = 0
        if (r3 == 0) goto L_0x002e
        r3 = r16
        r0 = 1
    L_0x002a:
        r2 = 0
    L_0x002b:
        r4 = 0
        goto L_0x00c4
    L_0x002e:
        java.lang.String r3 = com.kwad.sdk.core.download.C4086a.f13737c
        boolean r3 = android.text.TextUtils.equals(r3, r2)
        if (r3 == 0) goto L_0x0041
        java.lang.String r2 = "KEY_RESULT_PROGRESS"
        int r0 = r0.getInt(r2, r15)
        r2 = r0
        r3 = r16
        r0 = 2
        goto L_0x002b
    L_0x0041:
        java.lang.String r3 = com.kwad.sdk.core.download.C4086a.f13738d
        boolean r3 = android.text.TextUtils.equals(r3, r2)
        if (r3 == 0) goto L_0x0053
        java.lang.String r2 = "KEY_REUSLT_FILEPATH"
        java.lang.String r16 = r0.getString(r2)
        r3 = r16
        r0 = 3
        goto L_0x002a
    L_0x0053:
        java.lang.String r3 = com.kwad.sdk.core.download.C4086a.f13739e
        boolean r3 = android.text.TextUtils.equals(r3, r2)
        if (r3 == 0) goto L_0x0067
        java.lang.String r2 = "KEY_RESULT_ERROR_CODE"
        int r0 = r0.getInt(r2, r15)
        r4 = r0
        r3 = r16
        r0 = 4
        r2 = 0
        goto L_0x00c4
    L_0x0067:
        java.lang.String r0 = com.kwad.sdk.core.download.C4086a.f13740f
        boolean r0 = android.text.TextUtils.equals(r0, r2)
        if (r0 == 0) goto L_0x0073
        r3 = r16
        r0 = 5
        goto L_0x002a
    L_0x0073:
        java.lang.String r0 = com.kwad.sdk.core.download.C4086a.f13741g
        boolean r0 = android.text.TextUtils.equals(r0, r2)
        if (r0 == 0) goto L_0x007f
        r3 = r16
        r0 = 6
        goto L_0x002a
    L_0x007f:
        java.lang.String r0 = com.kwad.sdk.core.download.C4086a.f13742h
        boolean r0 = android.text.TextUtils.equals(r0, r2)
        if (r0 == 0) goto L_0x008b
        r3 = r16
        r0 = 7
        goto L_0x002a
    L_0x008b:
        java.lang.String r0 = com.kwad.sdk.core.download.C4086a.f13743i
        boolean r0 = android.text.TextUtils.equals(r0, r2)
        if (r0 == 0) goto L_0x0098
        r3 = r16
        r0 = 8
        goto L_0x002a
    L_0x0098:
        java.lang.String r0 = com.kwad.sdk.core.download.C4086a.f13744j
        boolean r0 = android.text.TextUtils.equals(r0, r2)
        if (r0 == 0) goto L_0x00a5
        r3 = r16
        r0 = 9
        goto L_0x002a
    L_0x00a5:
        java.lang.String r0 = com.kwad.sdk.core.download.C4086a.f13745k
        boolean r0 = android.text.TextUtils.equals(r0, r2)
        if (r0 == 0) goto L_0x00b3
        r3 = r16
        r0 = 10
        goto L_0x002a
    L_0x00b3:
        java.lang.String r0 = com.kwad.sdk.core.download.C4086a.f13746l
        boolean r0 = android.text.TextUtils.equals(r0, r2)
        r3 = r16
        if (r0 == 0) goto L_0x00c1
        r0 = 11
        goto L_0x002a
    L_0x00c1:
        r0 = 0
        goto L_0x002a
    L_0x00c4:
        java.util.ArrayList<java.lang.ref.WeakReference<com.kwad.sdk.core.download.e>> r16 = f13758a
        monitor-enter(r16)
        m17033b()     // Catch:{ all -> 0x0143 }
        java.util.ArrayList<java.lang.ref.WeakReference<com.kwad.sdk.core.download.e>> r17 = f13758a     // Catch:{ all -> 0x0143 }
        java.util.Iterator r17 = r17.iterator()     // Catch:{ all -> 0x0143 }
    L_0x00d0:
        boolean r18 = r17.hasNext()     // Catch:{ all -> 0x0143 }
        if (r18 == 0) goto L_0x013c
        java.lang.Object r18 = r17.next()     // Catch:{ all -> 0x0143 }
        java.lang.ref.WeakReference r18 = (java.lang.ref.WeakReference) r18     // Catch:{ all -> 0x0143 }
        java.lang.Object r18 = r18.get()     // Catch:{ all -> 0x0143 }
        r15 = r18
        com.kwad.sdk.core.download.e r15 = (com.kwad.sdk.core.download.C4103e) r15     // Catch:{ all -> 0x0143 }
        if (r15 != 0) goto L_0x00e8
    L_0x00e6:
        r15 = 0
        goto L_0x00d0
    L_0x00e8:
        java.lang.String r5 = r15.mo23769a()     // Catch:{ all -> 0x0143 }
        boolean r5 = android.text.TextUtils.equals(r5, r1)     // Catch:{ all -> 0x0143 }
        if (r5 == 0) goto L_0x0139
        if (r0 != r13) goto L_0x00f8
        r15.mo23771a(r1)     // Catch:{ all -> 0x0143 }
        goto L_0x0139
    L_0x00f8:
        if (r0 != r12) goto L_0x00fe
        r15.mo23772a(r1, r2)     // Catch:{ all -> 0x0143 }
        goto L_0x0139
    L_0x00fe:
        if (r0 != r14) goto L_0x0104
        r15.mo23773a(r1, r3)     // Catch:{ all -> 0x0143 }
        goto L_0x0139
    L_0x0104:
        if (r0 != r11) goto L_0x010a
        r15.mo23777b(r1, r4)     // Catch:{ all -> 0x0143 }
        goto L_0x0139
    L_0x010a:
        if (r0 != r10) goto L_0x0110
        r15.mo23776b(r1)     // Catch:{ all -> 0x0143 }
        goto L_0x0139
    L_0x0110:
        if (r0 != r9) goto L_0x0116
        r15.mo23780c(r1)     // Catch:{ all -> 0x0143 }
        goto L_0x0139
    L_0x0116:
        if (r0 != r8) goto L_0x011c
        r15.mo23783d(r1)     // Catch:{ all -> 0x0143 }
        goto L_0x0139
    L_0x011c:
        if (r0 != r7) goto L_0x0122
        r15.mo23784e(r1)     // Catch:{ all -> 0x0143 }
        goto L_0x0139
    L_0x0122:
        if (r0 != r6) goto L_0x0128
        r15.mo23785f(r1)     // Catch:{ all -> 0x0143 }
        goto L_0x0139
    L_0x0128:
        r5 = 10
        if (r0 != r5) goto L_0x0131
        r5 = 0
        r15.mo23781c(r1, r5)     // Catch:{ all -> 0x0143 }
        goto L_0x0139
    L_0x0131:
        r5 = 11
        if (r0 != r5) goto L_0x00e6
        r15.mo23786g(r1)     // Catch:{ all -> 0x0143 }
        goto L_0x00e6
    L_0x0139:
        r5 = 11
        goto L_0x00e6
    L_0x013c:
        monitor-exit(r16)     // Catch:{ all -> 0x0143 }
        if (r0 != r14) goto L_0x0142
        m17032a(r1)
    L_0x0142:
        return
    L_0x0143:
        r0 = move-exception
        monitor-exit(r16)     // Catch:{ all -> 0x0143 }
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.download.C4100d.m17035c(android.content.Intent):void");
    }

    /* access modifiers changed from: private|static */
    /* renamed from: d */
    public static void m17036d(Intent intent) {
        CharSequence schemeSpecificPart = TextUtils.equals("android.intent.action.PACKAGE_ADDED", intent.getAction()) ? intent.getData().getSchemeSpecificPart() : null;
        if (!TextUtils.isEmpty(schemeSpecificPart)) {
            synchronized (f13758a) {
                m17033b();
                Iterator it = f13758a.iterator();
                while (it.hasNext()) {
                    C4103e eVar = (C4103e) ((WeakReference) it.next()).get();
                    if (eVar != null) {
                        if (!TextUtils.isEmpty(schemeSpecificPart) && TextUtils.equals(schemeSpecificPart, eVar.mo23774b())) {
                            eVar.mo23781c(null, 0);
                        }
                    }
                }
            }
            synchronized (f13760c) {
                Iterator it2 = f13760c.entrySet().iterator();
                while (it2.hasNext()) {
                    Entry entry = (Entry) it2.next();
                    if (entry != null) {
                        String str = (String) entry.getKey();
                        AdTemplate adTemplate = (AdTemplate) entry.getValue();
                        if (!TextUtils.isEmpty(schemeSpecificPart) && TextUtils.equals(schemeSpecificPart, str)) {
                            C4143b.m17133d(adTemplate);
                            it2.remove();
                        }
                    }
                }
            }
        }
    }
}
