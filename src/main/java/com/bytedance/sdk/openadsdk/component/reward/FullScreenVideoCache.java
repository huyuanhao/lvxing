package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.core.C1982p;
import com.bytedance.sdk.adnet.p159b.C1948b.C1950a;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.AdInfoFactory;
import com.bytedance.sdk.openadsdk.core.GlobalInfo;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.core.p170d.VideoInfo;
import com.bytedance.sdk.openadsdk.multipro.MultiGlobalInfo;
import com.bytedance.sdk.openadsdk.p165c.AdEventManager;
import com.bytedance.sdk.openadsdk.p188g.TTNetClient;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.DigestUtils;
import com.bytedance.sdk.openadsdk.utils.FileUtils;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.component.reward.a */
class FullScreenVideoCache {
    /* renamed from: a */
    private static volatile FullScreenVideoCache f6905a;
    /* renamed from: b */
    private final Context f6906b;
    /* renamed from: c */
    private final SpCache f6907c;
    /* renamed from: d */
    private Map<MaterialMeta, Long> f6908d = Collections.synchronizedMap(new HashMap());

    /* compiled from: FullScreenVideoCache */
    /* renamed from: com.bytedance.sdk.openadsdk.component.reward.a$a */
    interface C2133a<T> {
        /* renamed from: a */
        void mo15105a(boolean z, T t);
    }

    /* renamed from: a */
    public void mo15098a(String str) {
        this.f6907c.mo15155d(str);
    }

    /* renamed from: a */
    public void mo15094a() {
        File file;
        File file2;
        try {
            String str = "shared_prefs";
            if (VERSION.SDK_INT >= 24) {
                file2 = new File(this.f6906b.getDataDir(), str);
            } else {
                file2 = new File(this.f6906b.getDatabasePath("1").getParentFile().getParentFile(), str);
            }
            if (file2.exists() && file2.isDirectory()) {
                File[] listFiles = file2.listFiles(new FileFilter() {
                    public boolean accept(File file) {
                        if (file != null) {
                            return file.getName().contains("sp_full_screen_video");
                        }
                        return false;
                    }
                });
                if (listFiles != null) {
                    for (File file3 : listFiles) {
                        try {
                            String replace = file3.getName().replace(".xml", "");
                            if (VERSION.SDK_INT >= 24) {
                                this.f6906b.deleteSharedPreferences(replace);
                            } else {
                                this.f6906b.getSharedPreferences(replace, 0).edit().clear().apply();
                                FileUtils.m12176c(file3);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        try {
            if (("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) && this.f6906b.getExternalCacheDir() != null) {
                file = this.f6906b.getExternalCacheDir();
            } else {
                file = this.f6906b.getCacheDir();
            }
            if (file != null && file.exists() && file.isDirectory()) {
                File[] listFiles2 = file.listFiles(new FileFilter() {
                    public boolean accept(File file) {
                        if (file != null) {
                            return file.getName().contains("full_screen_video_cache");
                        }
                        return false;
                    }
                });
                if (listFiles2 != null && listFiles2.length > 0) {
                    for (File c : listFiles2) {
                        try {
                            FileUtils.m12176c(c);
                        } catch (Throwable unused3) {
                        }
                    }
                }
            }
        } catch (Throwable unused4) {
        }
    }

    /* renamed from: a */
    public void mo15096a(AdSlot adSlot, MaterialMeta kVar) {
        mo15095a(adSlot);
        if (kVar != null) {
            try {
                this.f6907c.mo15151a(adSlot.getCodeId(), kVar.mo15459ae().toString());
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: b */
    public AdSlot mo15100b(String str) {
        return this.f6907c.mo15156e(str);
    }

    /* renamed from: a */
    public void mo15095a(AdSlot adSlot) {
        this.f6907c.mo15150a(adSlot);
    }

    /* renamed from: b */
    public void mo15101b(AdSlot adSlot) {
        this.f6907c.mo15153b(adSlot);
    }

    /* renamed from: b */
    public AdSlot mo15099b() {
        return this.f6907c.mo15148a();
    }

    /* renamed from: a */
    public static FullScreenVideoCache m8664a(Context context) {
        if (f6905a == null) {
            synchronized (FullScreenVideoCache.class) {
                if (f6905a == null) {
                    f6905a = new FullScreenVideoCache(context);
                }
            }
        }
        return f6905a;
    }

    private FullScreenVideoCache(Context context) {
        this.f6906b = context == null ? InternalContainer.m10059a() : context.getApplicationContext();
        this.f6907c = new SpCache(this.f6906b, "sp_full_screen_video");
    }

    /* renamed from: a */
    public String mo15092a(MaterialMeta kVar) {
        if (kVar == null || kVar.mo15512z() == null || TextUtils.isEmpty(kVar.mo15512z().mo15603g())) {
            return null;
        }
        return mo15093a(kVar.mo15512z().mo15603g(), kVar.mo15512z().mo15606j(), String.valueOf(ToolUtils.m12018d(kVar.mo15428P())));
    }

    /* renamed from: a */
    public String mo15093a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = DigestUtils.m12169a(str);
        }
        File a = m8665a(this.f6906b, m8666a(String.valueOf(str3), MultiGlobalInfo.m11808b()), str2);
        if (a == null || !a.exists() || !a.isFile()) {
            return null;
        }
        return a.getAbsolutePath();
    }

    /* renamed from: c */
    public MaterialMeta mo15102c(String str) {
        long b = this.f6907c.mo15152b(str);
        boolean c = this.f6907c.mo15154c(str);
        if ((System.currentTimeMillis() - b < 10800000) && !c) {
            try {
                String a = this.f6907c.mo15149a(str);
                if (!TextUtils.isEmpty(a)) {
                    MaterialMeta a2 = AdInfoFactory.m9163a(new JSONObject(a));
                    if (!(a2 == null || a2.mo15512z() == null)) {
                        VideoInfo z = a2.mo15512z();
                        if (!TextUtils.isEmpty(mo15093a(z.mo15603g(), z.mo15606j(), str))) {
                            return a2;
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* renamed from: a */
    private String m8666a(String str, boolean z) {
        String str2 = "/";
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append("full_screen_video_cache_");
            sb.append(str);
            sb.append(str2);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("/full_screen_video_cache_");
        sb2.append(str);
        sb2.append(str2);
        return sb2.toString();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8670a(boolean z, MaterialMeta kVar, long j, C1982p pVar) {
        long j2;
        Long l = (Long) this.f6908d.remove(kVar);
        if (l == null) {
            j2 = 0;
        } else {
            j2 = SystemClock.elapsedRealtime() - l.longValue();
        }
        long j3 = j2;
        String str = z ? "load_video_success" : "load_video_error";
        String message = (z || pVar == null || pVar.f6295c == null) ? null : pVar.f6295c.getMessage();
        AdEventManager.m8414m(this.f6906b, kVar, "fullscreen_interstitial_ad", str, ToolUtils.m11998a(z, kVar, j3, j, message));
    }

    /* renamed from: a */
    public void mo15097a(MaterialMeta kVar, C2133a<Object> aVar) {
        this.f6908d.put(kVar, Long.valueOf(SystemClock.elapsedRealtime()));
        if (kVar == null || kVar.mo15512z() == null || TextUtils.isEmpty(kVar.mo15512z().mo15603g())) {
            if (aVar != null) {
                aVar.mo15105a(false, null);
            }
            m8670a(false, kVar, -1, null);
            return;
        }
        String g = kVar.mo15512z().mo15603g();
        String j = kVar.mo15512z().mo15606j();
        if (TextUtils.isEmpty(j)) {
            j = DigestUtils.m12169a(g);
        }
        final String str = j;
        int d = ToolUtils.m12018d(kVar.mo15428P());
        String a = m8666a(String.valueOf(d), MultiGlobalInfo.m11808b());
        StringBuilder sb = new StringBuilder();
        sb.append("ritId:");
        sb.append(d);
        sb.append(",cacheDirPath=");
        sb.append(a);
        C2564t.m12226e("FullScreenVideoCache", sb.toString());
        final File a2 = m8665a(this.f6906b, a, str);
        TTNetClient a3 = TTNetClient.m11428a(this.f6906b);
        final C2133a<Object> aVar2 = aVar;
        final MaterialMeta kVar2 = kVar;
        C21323 r2 = new C1950a() {
            /* renamed from: a */
            public void mo14187a(long j, long j2) {
            }

            /* renamed from: a */
            public File mo14181a(String str) {
                try {
                    File parentFile = a2.getParentFile();
                    if (parentFile != null && parentFile.exists()) {
                        return GlobalInfo.m9616c().mo15686p().mo14987a(str, parentFile);
                    }
                } catch (IOException e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("datastoreGet throw IOException : ");
                    sb.append(e.toString());
                    C2564t.m12226e("FullScreenVideoCache", sb.toString());
                }
                return null;
            }

            /* renamed from: a */
            public void mo14182a(String str, File file) {
                if (file != null) {
                    FullScreenVideoCache.this.m8669a(file);
                }
            }

            /* renamed from: b */
            public File mo14183b(String str) {
                return a2;
            }

            /* renamed from: a */
            public void mo14171a(C1982p<File> pVar) {
                if (pVar == null || pVar.f6293a == null) {
                    C2133a aVar = aVar2;
                    if (aVar != null) {
                        aVar.mo15105a(false, null);
                    }
                    FullScreenVideoCache.this.m8670a(false, kVar2, pVar == null ? -3 : pVar.f6300h, pVar);
                    return;
                }
                C2133a aVar2 = aVar2;
                if (aVar2 != null) {
                    aVar2.mo15105a(true, null);
                }
                FullScreenVideoCache.this.m8670a(true, kVar2, 0, pVar);
            }

            /* renamed from: b */
            public void mo14172b(C1982p<File> pVar) {
                C2133a aVar = aVar2;
                if (aVar != null) {
                    aVar.mo15105a(false, null);
                }
                FullScreenVideoCache.this.m8670a(false, kVar2, pVar == null ? -2 : pVar.f6300h, pVar);
            }
        };
        a3.mo16655a(g, (C1950a) r2);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8669a(File file) {
        try {
            GlobalInfo.m9616c().mo15686p().mo14986a(file);
        } catch (IOException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("trimFileCache IOException:");
            sb.append(e.toString());
            C2564t.m12226e("FullScreenVideoCache", sb.toString());
        }
    }

    /* renamed from: a */
    private File m8665a(Context context, String str, String str2) {
        return FileUtils.m12172a(context, MultiGlobalInfo.m11808b(), str, str2);
    }
}
