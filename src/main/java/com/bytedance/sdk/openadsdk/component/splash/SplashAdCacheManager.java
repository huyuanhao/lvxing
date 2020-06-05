package com.bytedance.sdk.openadsdk.component.splash;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.GlobalInfo;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.NetApi.C2287b;
import com.bytedance.sdk.openadsdk.core.NetApiImpl.C2294a;
import com.bytedance.sdk.openadsdk.core.p170d.AdInfo;
import com.bytedance.sdk.openadsdk.core.p170d.Image;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.core.p170d.NetExtParams;
import com.bytedance.sdk.openadsdk.core.p170d.SplashAdCache;
import com.bytedance.sdk.openadsdk.multipro.MultiGlobalInfo;
import com.bytedance.sdk.openadsdk.multipro.p205d.SPMultiHelper;
import com.bytedance.sdk.openadsdk.p165c.AdEventManager;
import com.bytedance.sdk.openadsdk.p185f.StatsLogManager;
import com.bytedance.sdk.openadsdk.p185f.p186a.LogStatsBase;
import com.bytedance.sdk.openadsdk.p198i.TTExecutor;
import com.bytedance.sdk.openadsdk.utils.C2538ak;
import com.bytedance.sdk.openadsdk.utils.C2538ak.C2539a;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.DigestUtils;
import com.bytedance.sdk.openadsdk.utils.FileUtils;
import com.bytedance.sdk.openadsdk.utils.ImageBytesHelper;
import com.bytedance.sdk.openadsdk.utils.ImageBytesHelper.C2558a;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.component.splash.a */
class SplashAdCacheManager implements C2539a {
    /* renamed from: a */
    private static final Integer f7059a = Integer.valueOf(1);
    /* renamed from: b */
    private static final Integer f7060b = Integer.valueOf(2);
    /* renamed from: c */
    private static volatile SplashAdCacheManager f7061c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public Context f7062d;
    /* access modifiers changed from: private|final */
    /* renamed from: e */
    public final C2538ak f7063e = new C2538ak(Looper.getMainLooper(), this);
    /* renamed from: f */
    private final WeakHashMap<Integer, C2179b> f7064f = new WeakHashMap<>();
    /* renamed from: g */
    private C2180c f7065g;
    /* renamed from: h */
    private C2181d f7066h;
    /* access modifiers changed from: private */
    /* renamed from: i */
    public long f7067i = 0;
    /* access modifiers changed from: private */
    /* renamed from: j */
    public long f7068j = 0;
    /* access modifiers changed from: private */
    /* renamed from: k */
    public AtomicBoolean f7069k = new AtomicBoolean(false);

    /* compiled from: SplashAdCacheManager */
    /* renamed from: com.bytedance.sdk.openadsdk.component.splash.a$a */
    static class C2178a {
        /* renamed from: a */
        boolean f7078a = true;
        /* renamed from: b */
        long f7079b = 0;
        /* renamed from: c */
        long f7080c = 0;
        /* renamed from: d */
        long f7081d = 0;

        C2178a() {
        }
    }

    /* compiled from: SplashAdCacheManager */
    /* renamed from: com.bytedance.sdk.openadsdk.component.splash.a$b */
    interface C2179b {
        /* renamed from: a */
        void mo15241a();

        /* renamed from: a */
        void mo15242a(SplashAdCache nVar);
    }

    /* compiled from: SplashAdCacheManager */
    /* renamed from: com.bytedance.sdk.openadsdk.component.splash.a$c */
    private class C2180c implements Runnable {
        /* renamed from: b */
        private File f7083b;
        /* renamed from: c */
        private String f7084c;

        public C2180c(String str, File file) {
            this.f7084c = str;
            this.f7083b = file;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m8907a(String str, File file) {
            this.f7084c = str;
            this.f7083b = file;
        }

        public void run() {
            Message obtainMessage = SplashAdCacheManager.this.f7063e.obtainMessage();
            obtainMessage.what = 1;
            try {
                AdInfo a = SplashAdCacheManager.this.m8882e(this.f7084c);
                SplashAdCache nVar = new SplashAdCache(a, null, null);
                if (!(a == null || a.mo15336c() == null || a.mo15336c().isEmpty())) {
                    MaterialMeta kVar = (MaterialMeta) a.mo15336c().get(0);
                    if (kVar != null && kVar.mo15455aa()) {
                        byte[] a2 = m8908a(this.f7083b);
                        if (!(a2 == null || a2.length == 0)) {
                            nVar.mo15546a(kVar);
                            nVar.mo15547a(a2);
                        }
                    }
                }
                obtainMessage.obj = nVar;
            } catch (Throwable unused) {
            }
            SplashAdCacheManager.this.f7063e.sendMessage(obtainMessage);
            try {
                SplashAdCacheManager.this.mo15236d(this.f7084c);
            } catch (Throwable unused2) {
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0022, code lost:
            r3.close();
     */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0037, code lost:
            if (r3 == null) goto L_0x003a;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
            r0.flush();
     */
        /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
            r0.close();
     */
        /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0034 */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x002f A[Catch:{ IOException -> 0x0032 }] */
        /* renamed from: a */
        private byte[] m8908a(java.io.File r6) {
            /*
            r5 = this;
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]
            r2 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0033, all -> 0x0028 }
            r3.<init>(r6)     // Catch:{ Exception -> 0x0033, all -> 0x0028 }
        L_0x000f:
            int r6 = r1.length     // Catch:{ Exception -> 0x0034, all -> 0x0026 }
            r2 = 0
            int r6 = r3.read(r1, r2, r6)     // Catch:{ Exception -> 0x0034, all -> 0x0026 }
            r4 = -1
            if (r6 == r4) goto L_0x001c
            r0.write(r1, r2, r6)     // Catch:{ Exception -> 0x0034, all -> 0x0026 }
            goto L_0x000f
        L_0x001c:
            r0.flush()     // Catch:{ Exception -> 0x0034, all -> 0x0026 }
            r0.close()     // Catch:{ IOException -> 0x003a }
        L_0x0022:
            r3.close()     // Catch:{ IOException -> 0x003a }
            goto L_0x003a
        L_0x0026:
            r6 = move-exception
            goto L_0x002a
        L_0x0028:
            r6 = move-exception
            r3 = r2
        L_0x002a:
            r0.close()     // Catch:{ IOException -> 0x0032 }
            if (r3 == 0) goto L_0x0032
            r3.close()     // Catch:{ IOException -> 0x0032 }
        L_0x0032:
            throw r6
        L_0x0033:
            r3 = r2
        L_0x0034:
            r0.close()     // Catch:{ IOException -> 0x003a }
            if (r3 == 0) goto L_0x003a
            goto L_0x0022
        L_0x003a:
            byte[] r6 = r0.toByteArray()
            return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.component.splash.SplashAdCacheManager.C2180c.m8908a(java.io.File):byte[]");
        }
    }

    /* compiled from: SplashAdCacheManager */
    /* renamed from: com.bytedance.sdk.openadsdk.component.splash.a$d */
    private static class C2181d implements Runnable {
        /* renamed from: a */
        private SplashAdCache f7085a;
        /* renamed from: b */
        private File f7086b;

        public C2181d(SplashAdCache nVar, File file) {
            this.f7085a = nVar;
            this.f7086b = file;
        }

        /* renamed from: a */
        public void mo15244a(SplashAdCache nVar) {
            this.f7085a = nVar;
        }

        /* renamed from: a */
        public void mo15245a(File file) {
            this.f7086b = file;
        }

        public void run() {
            m8909a();
            m8910b();
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
        /* renamed from: a */
        private void m8909a() {
            /*
            r4 = this;
            r0 = 0
            com.bytedance.sdk.openadsdk.core.d.n r1 = r4.f7085a     // Catch:{ all -> 0x002f }
            if (r1 == 0) goto L_0x0029
            com.bytedance.sdk.openadsdk.core.d.n r1 = r4.f7085a     // Catch:{ all -> 0x002f }
            byte[] r1 = r1.mo15548b()     // Catch:{ all -> 0x002f }
            if (r1 == 0) goto L_0x0029
            java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x002f }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x002f }
            java.io.File r3 = r4.f7086b     // Catch:{ all -> 0x002f }
            r2.<init>(r3)     // Catch:{ all -> 0x002f }
            r1.<init>(r2)     // Catch:{ all -> 0x002f }
            com.bytedance.sdk.openadsdk.core.d.n r0 = r4.f7085a     // Catch:{ all -> 0x0027 }
            byte[] r0 = r0.mo15548b()     // Catch:{ all -> 0x0027 }
            r1.write(r0)     // Catch:{ all -> 0x0027 }
            r1.flush()     // Catch:{ all -> 0x0027 }
            r0 = r1
            goto L_0x0029
        L_0x0027:
            r0 = r1
            goto L_0x002f
        L_0x0029:
            if (r0 == 0) goto L_0x0032
        L_0x002b:
            r0.close()     // Catch:{ all -> 0x0032 }
            goto L_0x0032
        L_0x002f:
            if (r0 == 0) goto L_0x0032
            goto L_0x002b
        L_0x0032:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.component.splash.SplashAdCacheManager.C2181d.m8909a():void");
        }

        /* renamed from: b */
        private void m8910b() {
            int c = SplashUtils.m8977c(this.f7085a);
            if (c > 0) {
                String str = "materialMeta";
                String str2 = "tt_materialMeta";
                if (MultiGlobalInfo.m11808b()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(c);
                    SPMultiHelper.m11874a(str2, sb.toString(), this.f7085a.mo15549c().mo15338d());
                    return;
                }
                Editor edit = InternalContainer.m10059a().getSharedPreferences(str2, 0).edit();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(c);
                edit.putString(sb2.toString(), this.f7085a.mo15549c().mo15338d()).apply();
            }
        }
    }

    private SplashAdCacheManager(Context context) {
        if (context != null) {
            this.f7062d = context.getApplicationContext();
        }
    }

    /* renamed from: a */
    static SplashAdCacheManager m8869a(Context context) {
        if (f7061c == null) {
            synchronized (SplashAdCacheManager.class) {
                if (f7061c == null) {
                    f7061c = new SplashAdCacheManager(context);
                }
            }
        }
        return f7061c;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public Context m8876b() {
        Context context = this.f7062d;
        return context != null ? context : InternalContainer.m10059a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo15227a(SplashAdCache nVar) {
        if (nVar != null) {
            int c = SplashUtils.m8977c(nVar);
            if (c > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("tt_splash_image_cache_");
                sb.append(c);
                File a = SplashUtils.m8963a(m8876b(), MultiGlobalInfo.m11808b() ? "splash_ad_cache/" : "/splash_ad_cache/", sb.toString());
                if (a != null) {
                    m8873a(c, nVar.mo15545a().mo15431S());
                    m8874a(nVar, a);
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo15232b(SplashAdCache nVar) {
        int c = SplashUtils.m8977c(nVar);
        if (c > 0) {
            String str = "has_video_ad_cache";
            String str2 = "tt_splash";
            if (MultiGlobalInfo.m11808b()) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(c);
                SPMultiHelper.m11870a(str2, sb.toString(), Boolean.valueOf(true));
            } else {
                Editor edit = m8876b().getSharedPreferences(str2, 0).edit();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(c);
                edit.putBoolean(sb2.toString(), true).apply();
            }
        }
    }

    /* renamed from: a */
    private void m8874a(SplashAdCache nVar, File file) {
        C2181d dVar = this.f7066h;
        if (dVar == null) {
            this.f7066h = new C2181d(nVar, file);
        } else {
            dVar.mo15244a(nVar);
            this.f7066h.mo15245a(file);
        }
        TTExecutor.m11692a().mo16808c(this.f7066h, 1);
    }

    /* renamed from: a */
    private void m8873a(int i, long j) {
        String str = "has_ad_cache";
        String str2 = "update";
        String str3 = "expiration";
        String str4 = "tt_splash";
        if (MultiGlobalInfo.m11808b()) {
            StringBuilder sb = new StringBuilder();
            sb.append(str3);
            sb.append(i);
            SPMultiHelper.m11873a(str4, sb.toString(), Long.valueOf(j));
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(i);
            SPMultiHelper.m11873a(str4, sb2.toString(), Long.valueOf(System.currentTimeMillis() / 1000));
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append(i);
            SPMultiHelper.m11870a(str4, sb3.toString(), Boolean.valueOf(true));
            return;
        }
        Editor edit = m8876b().getSharedPreferences(str4, 0).edit();
        StringBuilder sb4 = new StringBuilder();
        sb4.append(str3);
        sb4.append(i);
        Editor putLong = edit.putLong(sb4.toString(), j);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str2);
        sb5.append(i);
        Editor putLong2 = putLong.putLong(sb5.toString(), System.currentTimeMillis() / 1000);
        StringBuilder sb6 = new StringBuilder();
        sb6.append(str);
        sb6.append(i);
        putLong2.putBoolean(sb6.toString(), true).apply();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo15229a(final String str, C2179b bVar) {
        this.f7064f.put(f7060b, bVar);
        if (TextUtils.isEmpty(str)) {
            Message obtainMessage = this.f7063e.obtainMessage();
            obtainMessage.what = 2;
            this.f7063e.sendMessage(obtainMessage);
            return;
        }
        TTExecutor.m11692a().mo16808c(new Runnable() {
            public void run() {
                C2564t.m12220b("TTExecutor", "readSplashMaterialMeta....->run....");
                Message obtainMessage = SplashAdCacheManager.this.f7063e.obtainMessage();
                obtainMessage.what = 2;
                try {
                    AdInfo a = SplashAdCacheManager.this.m8882e(str);
                    SplashAdCache nVar = new SplashAdCache(a, null, null);
                    if (!(a == null || a.mo15336c() == null || a.mo15336c().isEmpty())) {
                        MaterialMeta kVar = (MaterialMeta) a.mo15336c().get(0);
                        if (kVar != null) {
                            nVar.mo15546a(kVar);
                        }
                    }
                    obtainMessage.obj = nVar;
                } catch (Throwable unused) {
                }
                SplashAdCacheManager.this.f7063e.sendMessage(obtainMessage);
                String str = "has_video_ad_cache";
                String str2 = "tt_splash";
                if (MultiGlobalInfo.m11808b()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(str);
                    SPMultiHelper.m11869a(str2, sb.toString());
                    return;
                }
                Editor edit = SplashAdCacheManager.this.m8876b().getSharedPreferences(str2, 0).edit();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(str);
                edit.remove(sb2.toString()).apply();
            }
        }, 10);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo15233b(String str, C2179b bVar) {
        if (TextUtils.isEmpty(str)) {
            bVar.mo15241a();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("tt_splash_image_cache_");
        sb.append(str);
        File a = SplashUtils.m8963a(m8876b(), MultiGlobalInfo.m11808b() ? "splash_ad_cache/" : "/splash_ad_cache/", sb.toString());
        if (a == null || !a.exists() || !a.isFile() || a.length() <= 0) {
            bVar.mo15241a();
            return;
        }
        this.f7064f.put(f7059a, bVar);
        TTExecutor.m11692a().mo16808c(m8872a(str, a), 10);
    }

    /* renamed from: a */
    private Runnable m8872a(String str, File file) {
        C2180c cVar = this.f7065g;
        if (cVar == null) {
            this.f7065g = new C2180c(str, file);
        } else {
            cVar.m8907a(str, file);
        }
        return this.f7065g;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo15231a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String str2 = "has_ad_cache";
        String str3 = "tt_splash";
        if (MultiGlobalInfo.m11808b()) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(str);
            return SPMultiHelper.m11877a(str3, sb.toString(), false);
        }
        SharedPreferences sharedPreferences = m8876b().getSharedPreferences(str3, 0);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append(str);
        return sharedPreferences.getBoolean(sb2.toString(), false);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo15234b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String str2 = "has_video_ad_cache";
        String str3 = "tt_splash";
        if (MultiGlobalInfo.m11808b()) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(str);
            return SPMultiHelper.m11877a(str3, sb.toString(), false);
        }
        SharedPreferences sharedPreferences = m8876b().getSharedPreferences(str3, 0);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append(str);
        return sharedPreferences.getBoolean(sb2.toString(), false);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public C2178a mo15235c(String str) {
        C2178a aVar = new C2178a();
        if (TextUtils.isEmpty(str)) {
            return aVar;
        }
        boolean z = true;
        String str2 = "update";
        String str3 = "expiration";
        String str4 = "tt_splash";
        if (MultiGlobalInfo.m11808b()) {
            StringBuilder sb = new StringBuilder();
            sb.append(str3);
            sb.append(str);
            long a = SPMultiHelper.m11866a(str4, sb.toString(), 0);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(str);
            long a2 = SPMultiHelper.m11866a(str4, sb2.toString(), 0);
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis >= a2 && currentTimeMillis < a) {
                z = false;
            }
            aVar.f7078a = z;
            aVar.f7079b = a2;
            aVar.f7080c = a;
            aVar.f7081d = currentTimeMillis;
            return aVar;
        }
        SharedPreferences sharedPreferences = m8876b().getSharedPreferences(str4, 0);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str3);
        sb3.append(str);
        long j = sharedPreferences.getLong(sb3.toString(), 0);
        StringBuilder sb4 = new StringBuilder();
        sb4.append(str2);
        sb4.append(str);
        long j2 = sharedPreferences.getLong(sb4.toString(), 0);
        long currentTimeMillis2 = System.currentTimeMillis() / 1000;
        if (currentTimeMillis2 >= j2 && currentTimeMillis2 < j) {
            z = false;
        }
        aVar.f7078a = z;
        aVar.f7079b = j2;
        aVar.f7080c = j;
        aVar.f7081d = currentTimeMillis2;
        return aVar;
    }

    /* renamed from: a */
    public String mo15224a(String str, boolean z) {
        String str2 = "/";
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append("splash_video_cache_");
            sb.append(str);
            sb.append(str2);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("/splash_video_cache_");
        sb2.append(str);
        sb2.append(str2);
        return sb2.toString();
    }

    /* renamed from: a */
    public void mo15228a(File file) {
        try {
            GlobalInfo.m9616c().mo15686p().mo14986a(file);
        } catch (IOException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("trimFileCache IOException:");
            sb.append(e.toString());
            C2564t.m12226e("SplashAdCacheManager", sb.toString());
        }
    }

    /* renamed from: a */
    public String mo15222a(MaterialMeta kVar) {
        if (kVar == null || kVar.mo15512z() == null || TextUtils.isEmpty(kVar.mo15512z().mo15603g())) {
            return null;
        }
        return mo15223a(kVar.mo15512z().mo15603g(), kVar.mo15512z().mo15606j(), String.valueOf(ToolUtils.m12018d(kVar.mo15428P())));
    }

    /* renamed from: a */
    public String mo15223a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = DigestUtils.m12169a(str);
        }
        File a = SplashUtils.m8963a(this.f7062d, mo15224a(String.valueOf(str3), MultiGlobalInfo.m11808b()), str2);
        if (a == null || !a.exists() || !a.isFile()) {
            return null;
        }
        return a.getAbsolutePath();
    }

    /* renamed from: a */
    public void mo14813a(Message message) {
        boolean z = false;
        String str = "OnLoadCacheCallback is null: ";
        String str2 = "SplashAdCacheManager";
        if (message.what == 1) {
            C2179b bVar = (C2179b) this.f7064f.remove(f7059a);
            if (bVar != null) {
                if (message.obj == null || !(message.obj instanceof SplashAdCache)) {
                    bVar.mo15241a();
                    C2564t.m12220b(str2, "缓存反序列化失败");
                } else {
                    bVar.mo15242a((SplashAdCache) message.obj);
                    C2564t.m12220b(str2, "缓存反序列化成功");
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            if (bVar == null) {
                z = true;
            }
            sb.append(z);
            C2564t.m12220b(str2, sb.toString());
            this.f7063e.removeCallbacksAndMessages(null);
        } else if (message.what == 2) {
            C2179b bVar2 = (C2179b) this.f7064f.remove(f7060b);
            if (bVar2 != null) {
                if (message.obj == null || !(message.obj instanceof SplashAdCache)) {
                    bVar2.mo15241a();
                    C2564t.m12220b(str2, "视频物料缓存反序列化失败");
                } else {
                    bVar2.mo15242a((SplashAdCache) message.obj);
                    C2564t.m12220b(str2, "视频物料缓存反序列化成功");
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            if (bVar2 == null) {
                z = true;
            }
            sb2.append(z);
            C2564t.m12220b(str2, sb2.toString());
            this.f7063e.removeCallbacksAndMessages(null);
        }
    }

    /* renamed from: a */
    public boolean mo15230a(AdSlot adSlot, boolean z) {
        C2178a c = m8869a(this.f7062d).mo15235c(adSlot.getCodeId());
        if (z && c.f7078a) {
            try {
                long j = c.f7081d - c.f7079b;
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("available_type", Integer.valueOf(0));
                jSONObject.putOpt("creative_timeout_duration", Long.valueOf(j / 3600));
                StatsLogManager.m11278a().mo16582n(LogStatsBase.m11308b().mo16590a(4).mo16595c(adSlot.getCodeId()).mo16593b(jSONObject.toString()));
            } catch (Throwable unused) {
            }
        }
        return c.f7078a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo15236d(String str) {
        if (!TextUtils.isEmpty(str)) {
            String str2 = "has_video_ad_cache";
            String str3 = "has_ad_cache";
            String str4 = "materialMeta";
            String str5 = "tt_materialMeta";
            String str6 = "expiration";
            String str7 = "tt_splash";
            if (MultiGlobalInfo.m11808b()) {
                StringBuilder sb = new StringBuilder();
                sb.append(str4);
                sb.append(str);
                SPMultiHelper.m11869a(str5, sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str3);
                sb2.append(str);
                SPMultiHelper.m11869a(str7, sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str2);
                sb3.append(str);
                SPMultiHelper.m11869a(str7, sb3.toString());
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str6);
                sb4.append(str);
                SPMultiHelper.m11869a(str7, sb4.toString());
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str6);
                sb5.append(str);
                SPMultiHelper.m11869a(str7, sb5.toString());
                return;
            }
            Editor edit = m8876b().getSharedPreferences(str5, 0).edit();
            StringBuilder sb6 = new StringBuilder();
            sb6.append(str4);
            sb6.append(str);
            edit.remove(sb6.toString()).apply();
            Editor edit2 = m8876b().getSharedPreferences(str7, 0).edit();
            StringBuilder sb7 = new StringBuilder();
            sb7.append(str3);
            sb7.append(str);
            Editor remove = edit2.remove(sb7.toString());
            StringBuilder sb8 = new StringBuilder();
            sb8.append(str2);
            sb8.append(str);
            Editor remove2 = remove.remove(sb8.toString());
            StringBuilder sb9 = new StringBuilder();
            sb9.append(str6);
            sb9.append(str);
            Editor remove3 = remove2.remove(sb9.toString());
            StringBuilder sb10 = new StringBuilder();
            sb10.append(str6);
            sb10.append(str);
            remove3.remove(sb10.toString()).apply();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo15225a() {
        File file;
        try {
            String str = "tt_splash";
            String str2 = "tt_materialMeta";
            if (MultiGlobalInfo.m11808b()) {
                SPMultiHelper.m11868a(str2);
                SPMultiHelper.m11868a(str);
            } else {
                m8876b().getSharedPreferences(str2, 0).edit().clear().apply();
                m8876b().getSharedPreferences(str, 0).edit().clear().apply();
            }
        } catch (Throwable unused) {
        }
        try {
            if (("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) && m8876b().getExternalCacheDir() != null) {
                file = m8876b().getExternalCacheDir();
            } else {
                file = m8876b().getCacheDir();
            }
            if (file != null && file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles(new FileFilter() {
                    public boolean accept(File file) {
                        if (file == null) {
                            return false;
                        }
                        String name = file.getName();
                        if (name.contains("splash_ad_cache") || name.contains("splash_video_cache")) {
                            return true;
                        }
                        return false;
                    }
                });
                if (listFiles != null && listFiles.length > 0) {
                    for (File c : listFiles) {
                        try {
                            FileUtils.m12176c(c);
                        } catch (Throwable unused2) {
                        }
                    }
                }
            }
        } catch (Throwable unused3) {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public AdInfo m8882e(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str3 = "materialMeta";
        String str4 = "tt_materialMeta";
        if (MultiGlobalInfo.m11808b()) {
            StringBuilder sb = new StringBuilder();
            sb.append(str3);
            sb.append(str);
            str2 = SPMultiHelper.m11880b(str4, sb.toString(), (String) null);
        } else {
            SharedPreferences sharedPreferences = m8876b().getSharedPreferences(str4, 0);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str3);
            sb2.append(str);
            str2 = sharedPreferences.getString(sb2.toString(), null);
        }
        if (!TextUtils.isEmpty(str2)) {
            try {
                C2294a a = C2294a.m10143a(new JSONObject(str2));
                if (!(a == null || a.f7901h == null)) {
                    return a.f7901h;
                }
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    /* renamed from: b */
    private void m8878b(AdSlot adSlot, NetExtParams lVar) {
        if (this.f7069k.getAndSet(true)) {
            C2564t.m12220b("splashLoad", "已在预加载开屏广告....不再发出");
            return;
        }
        if ((InternalContainer.m10069h().mo15794i(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f) && lVar != null) {
            lVar.f7454e = 2;
        }
        InternalContainer.m10067f().mo15917a(adSlot, lVar, 4, (C2287b) new C2287b() {
            /* renamed from: a */
            public void mo14946a(int i, String str) {
                StringBuilder sb = new StringBuilder();
                sb.append("广告物料预加载失败....");
                sb.append(str);
                sb.append(i);
                C2564t.m12220b("splashLoad", sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(i);
                C2564t.m12220b("SplashAdCacheManager", sb2.toString());
                SplashAdCacheManager.this.f7069k.set(false);
            }

            /* renamed from: a */
            public void mo14947a(final AdInfo aVar) {
                int i = 0;
                if (SplashUtils.m8974b(aVar)) {
                    C2564t.m12220b("splashLoad", "广告物料预加载成功....");
                    final MaterialMeta kVar = (MaterialMeta) aVar.mo15336c().get(0);
                    if (kVar.mo15455aa()) {
                        final boolean z = kVar.mo15512z() != null;
                        Image D = kVar.mo15416D();
                        if (D == null) {
                            D = (Image) kVar.mo15418F().get(0);
                        }
                        String a = D.mo15406a();
                        int b = D.mo15409b();
                        SplashAdCacheManager.this.f7067i = System.currentTimeMillis();
                        if (z) {
                            i = 2;
                        }
                        SplashUtils.m8970a(kVar, i);
                        SplashAdCacheManager.this.f7068j = SystemClock.elapsedRealtime();
                        ImageBytesHelper.m12184a(SplashAdCacheManager.this.f7062d, a, b, new C2558a() {
                            /* renamed from: a */
                            public void mo15240a(byte[] bArr) {
                                SplashUtils.m8968a(aVar);
                                SplashUtils.m8969a(kVar);
                                if (!z) {
                                    AdEventManager.m8393a(kVar, "splash_ad", "download_creative_duration", System.currentTimeMillis() - SplashAdCacheManager.this.f7067i);
                                }
                                SplashAdCacheManager.this.f7067i = 0;
                                C2564t.m12220b("SplashAdCacheManager", "图片数据加载的广告缓存到本地");
                                C2564t.m12220b("splashLoad", "预加载成功，广告缓存到本地----10");
                                SplashAdCacheManager.m8869a(SplashAdCacheManager.this.f7062d).mo15227a(new SplashAdCache(aVar, kVar, bArr));
                                if (z) {
                                    SplashUtils.m8964a(SplashAdCacheManager.this.f7068j, false, true, kVar, 0, null);
                                }
                                SplashAdCacheManager.this.f7069k.set(false);
                            }

                            /* renamed from: a */
                            public void mo15239a() {
                                SplashUtils.m8968a(aVar);
                                C2564t.m12220b("SplashAdCacheManager", "图片数据加载失败");
                                C2564t.m12220b("splashLoad", "图片数据预加载失败....");
                                if (z) {
                                    SplashUtils.m8964a(SplashAdCacheManager.this.f7068j, false, false, kVar, -7, null);
                                }
                                SplashAdCacheManager.this.f7069k.set(false);
                            }
                        });
                        return;
                    }
                    return;
                }
                SplashAdCacheManager.this.f7069k.set(false);
            }
        });
    }

    /* renamed from: a */
    public void mo15226a(AdSlot adSlot, NetExtParams lVar) {
        if (InternalContainer.m10069h().mo15815t() && adSlot != null) {
            NetExtParams lVar2 = lVar == null ? new NetExtParams() : lVar.mo15527a();
            lVar2.f7455f = System.currentTimeMillis();
            m8878b(adSlot, lVar2);
        }
    }
}
