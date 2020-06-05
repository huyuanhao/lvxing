package com.bytedance.sdk.openadsdk.component.splash;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.core.C1982p;
import com.bytedance.sdk.adnet.p159b.C1948b.C1950a;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.C2240g;
import com.bytedance.sdk.openadsdk.core.GlobalInfo;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.p170d.AdInfo;
import com.bytedance.sdk.openadsdk.core.p170d.Image;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.core.p170d.SplashAdCache;
import com.bytedance.sdk.openadsdk.core.p170d.VideoInfo;
import com.bytedance.sdk.openadsdk.multipro.MultiGlobalInfo;
import com.bytedance.sdk.openadsdk.p165c.AdEventManager;
import com.bytedance.sdk.openadsdk.p185f.StatsLogManager;
import com.bytedance.sdk.openadsdk.p185f.p186a.LogStatsBase;
import com.bytedance.sdk.openadsdk.p188g.TTNetClient;
import com.bytedance.sdk.openadsdk.p188g.p189a.GifLoader;
import com.bytedance.sdk.openadsdk.p188g.p189a.GifLoader.C2432b;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.C2566w;
import com.bytedance.sdk.openadsdk.utils.DigestUtils;
import com.bytedance.sdk.openadsdk.utils.FileUtils;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.component.splash.c */
public class SplashUtils {
    /* renamed from: a */
    public static void m8970a(MaterialMeta kVar, int i) {
        int c = C2566w.m12244c(InternalContainer.m10059a());
        int i2 = 4;
        if (c == 2) {
            i2 = 2;
        } else if (c == 3) {
            i2 = 3;
        } else if (c == 4) {
            i2 = 1;
        } else if (c != 5) {
            i2 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("splash_show_type", Integer.valueOf(i));
        hashMap.put("network_status", Integer.valueOf(i2));
        AdEventManager.m8409h(InternalContainer.m10059a(), kVar, "splash_ad", "network_type", hashMap);
    }

    /* renamed from: a */
    public static void m8967a(AdSlot adSlot, boolean z, long j, long j2) {
        int i = z ? 2 : 1;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("available_type", Integer.valueOf(i));
            jSONObject.putOpt("creative_check_duration", Long.valueOf(j2));
            StatsLogManager.m11278a().mo16582n(LogStatsBase.m11308b().mo16590a(4).mo16595c(adSlot.getCodeId()).mo16592b(Long.valueOf(j).intValue()).mo16593b(jSONObject.toString()));
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static void m8971a(LogStatsBase dVar, String str) {
        StatsLogManager.m11278a().mo16574f(dVar.mo16592b(-7).mo16603g(C2240g.m9576a(-7)).mo16608i(str));
    }

    /* renamed from: a */
    public static void m8964a(long j, boolean z, boolean z2, MaterialMeta kVar, long j2, C1982p pVar) {
        MaterialMeta kVar2 = kVar;
        C1982p pVar2 = pVar;
        long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        String str = z ? z2 ? "load_video_success" : "load_video_error" : z2 ? "download_video_image_success" : "download_video_image_fail";
        String str2 = str;
        String message = (z2 || pVar2 == null || pVar2.f6295c == null) ? null : pVar2.f6295c.getMessage();
        String str3 = "splash_ad";
        String str4 = "splash_show_type";
        if (z) {
            Map a = ToolUtils.m11998a(z2, kVar, elapsedRealtime, j2, message);
            a.put(str4, Integer.valueOf(1));
            AdEventManager.m8414m(InternalContainer.m10059a(), kVar, str3, str2, a);
            return;
        }
        Map b = ToolUtils.m12011b(z2, kVar, elapsedRealtime, j2, message);
        b.put(str4, Integer.valueOf(2));
        AdEventManager.m8413l(InternalContainer.m10059a(), kVar, str3, str2, b);
    }

    /* renamed from: a */
    public static void m8968a(AdInfo aVar) {
        if (m8974b(aVar)) {
            final MaterialMeta kVar = (MaterialMeta) aVar.mo15336c().get(0);
            int d = ToolUtils.m12018d(kVar.mo15428P());
            VideoInfo z = kVar.mo15512z();
            if (z != null) {
                final long elapsedRealtime = SystemClock.elapsedRealtime();
                String g = z.mo15603g();
                if (g == null) {
                    m8964a(elapsedRealtime, true, false, kVar, -1, null);
                    return;
                }
                m8970a(kVar, 1);
                String j = z.mo15606j();
                if (TextUtils.isEmpty(j)) {
                    j = DigestUtils.m12169a(g);
                }
                final String str = j;
                final File a = m8963a(InternalContainer.m10059a(), SplashAdCacheManager.m8869a(InternalContainer.m10059a()).mo15224a(String.valueOf(d), MultiGlobalInfo.m11808b()), str);
                if (!InternalContainer.m10069h().mo15786e(String.valueOf(d)) || C2566w.m12245d(InternalContainer.m10059a())) {
                    TTNetClient a2 = TTNetClient.m11428a(InternalContainer.m10059a());
                    final AdInfo aVar2 = aVar;
                    C21921 r1 = new C1950a() {
                        /* renamed from: a */
                        public void mo14187a(long j, long j2) {
                        }

                        /* renamed from: a */
                        public File mo14181a(String str) {
                            try {
                                File parentFile = a.getParentFile();
                                if (parentFile != null && parentFile.exists()) {
                                    return GlobalInfo.m9616c().mo15686p().mo14987a(str, parentFile);
                                }
                            } catch (IOException e) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("datastoreGet throw IOException : ");
                                sb.append(e.toString());
                                C2564t.m12226e("SplashUtils", sb.toString());
                            }
                            return null;
                        }

                        /* renamed from: a */
                        public void mo14182a(String str, File file) {
                            if (file != null) {
                                SplashAdCacheManager.m8869a(InternalContainer.m10059a()).mo15228a(file);
                            }
                        }

                        /* renamed from: b */
                        public File mo14183b(String str) {
                            return a;
                        }

                        /* renamed from: a */
                        public void mo14171a(C1982p<File> pVar) {
                            if (pVar == null || pVar.f6293a == null) {
                                SplashUtils.m8964a(elapsedRealtime, true, false, kVar, pVar == null ? -3 : pVar.f6300h, pVar);
                                return;
                            }
                            SplashAdCacheManager.m8869a(InternalContainer.m10059a()).mo15232b(new SplashAdCache(aVar2, kVar, null));
                            SplashAdCacheManager.m8869a(InternalContainer.m10059a()).mo15227a(new SplashAdCache(aVar2, kVar, null));
                            SplashUtils.m8964a(elapsedRealtime, true, true, kVar, 0, pVar);
                        }

                        /* renamed from: b */
                        public void mo14172b(C1982p<File> pVar) {
                            SplashUtils.m8964a(elapsedRealtime, true, false, kVar, pVar == null ? -2 : pVar.f6300h, pVar);
                        }
                    };
                    a2.mo16655a(g, (C1950a) r1);
                } else {
                    if (str != null && a.exists()) {
                        C2564t.m12220b("preLoadVideo", "非wifi环境，已缓存相同url的视频文件也是可以播放的");
                        SplashAdCacheManager.m8869a(InternalContainer.m10059a()).mo15232b(new SplashAdCache(aVar, kVar, null));
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static void m8969a(MaterialMeta kVar) {
        if (!(kVar == null || kVar.mo15510x() == null)) {
            if (kVar.mo15455aa() && kVar.mo15418F() != null && !kVar.mo15418F().isEmpty()) {
                for (Image jVar : kVar.mo15418F()) {
                    if (!TextUtils.isEmpty(jVar.mo15406a())) {
                        TTNetClient.m11428a(InternalContainer.m10059a()).mo16659f().mo16632a(jVar.mo15406a(), (C2432b) GifLoader.m11378a(), jVar.mo15409b(), jVar.mo15411c());
                    }
                }
            }
            Image C = kVar.mo15415C();
            if (C != null && !TextUtils.isEmpty(C.mo15406a())) {
                TTNetClient.m11428a(InternalContainer.m10059a()).mo16659f().mo16632a(C.mo15406a(), (C2432b) GifLoader.m11378a(), C.mo15409b(), C.mo15411c());
            }
        }
    }

    /* renamed from: a */
    public static boolean m8972a(SplashAdCache nVar) {
        return (nVar == null || nVar.mo15545a() == null) ? false : true;
    }

    /* renamed from: b */
    public static boolean m8975b(SplashAdCache nVar) {
        return (nVar.mo15545a() == null || !nVar.mo15545a().mo15455aa() || nVar.mo15548b() == null || nVar.mo15548b().length == 0) ? false : true;
    }

    /* renamed from: b */
    public static boolean m8974b(AdInfo aVar) {
        return (aVar == null || aVar.mo15336c() == null || aVar.mo15336c().isEmpty() || aVar.mo15336c().get(0) == null) ? false : true;
    }

    /* renamed from: a */
    public static void m8966a(Context context, AdSlot adSlot) {
        try {
            SplashAdCacheManager.m8869a(context).mo15236d(adSlot.getCodeId());
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static void m8965a(Context context) {
        try {
            SplashAdCacheManager.m8869a(context).mo15225a();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static File m8963a(Context context, String str, String str2) {
        return FileUtils.m12172a(context, MultiGlobalInfo.m11808b(), str, str2);
    }

    /* renamed from: c */
    public static int m8977c(SplashAdCache nVar) {
        if (nVar == null) {
            return 0;
        }
        int c = m8976c(nVar.mo15549c());
        if (c <= 0) {
            c = m8973b(nVar.mo15545a());
        }
        return c;
    }

    /* renamed from: b */
    public static int m8973b(MaterialMeta kVar) {
        if (kVar != null) {
            return ToolUtils.m12018d(kVar.mo15428P());
        }
        return 0;
    }

    /* renamed from: c */
    public static int m8976c(AdInfo aVar) {
        if (aVar != null) {
            return aVar.mo15334b();
        }
        return 0;
    }
}
