package com.bytedance.sdk.openadsdk.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import androidx.core.p003os.EnvironmentCompat;
import com.bytedance.sdk.openadsdk.core.AES;
import com.bytedance.sdk.openadsdk.core.AESKey;
import com.bytedance.sdk.openadsdk.core.AdPreference;
import com.bytedance.sdk.openadsdk.core.GlobalInfo;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.WebHelper;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.core.p170d.VideoInfo;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.INativeVideoController;
import com.bytedance.sdk.openadsdk.core.video.p177c.SSMediaPlayerWrapper;
import com.bytedance.sdk.openadsdk.p198i.TTExecutor;
import com.tencent.p605ep.commonbase.software.AppEntity;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.utils.ah */
public class ToolUtils {
    /* renamed from: a */
    private static String f9122a;
    /* renamed from: b */
    private static String f9123b;
    /* renamed from: c */
    private static String f9124c;

    /* renamed from: a */
    public static String m11993a(int i) {
        switch (i) {
            case 1:
                return "embeded_ad_landingpage";
            case 2:
                return "banner_ad_landingpage";
            case 3:
                return "interaction_landingpage";
            case 4:
                return "splash_ad_landingpage";
            case 5:
                return "fullscreen_interstitial_ad_landingpage";
            case 6:
                return "draw_ad_landingpage";
            case 7:
                return "rewarded_video_landingpage";
            default:
                return null;
        }
    }

    /* renamed from: b */
    public static String m12009b(int i) {
        return i != 1 ? i != 2 ? (i == 3 || i == 4) ? "splash_ad" : i != 7 ? i != 8 ? i != 9 ? "embeded_ad" : "draw_ad" : "fullscreen_interstitial_ad" : "rewarded_video" : "interaction" : "banner_ad";
    }

    /* renamed from: a */
    public static boolean m12005a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                if (m12016c(context, str)) {
                    Intent b = m12007b(context, str);
                    if (b == null) {
                        return false;
                    }
                    b.putExtra("START_ONLY_FOR_ANDROID", true);
                    ActivityUtil.m12108a(context, b, null);
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    /* renamed from: b */
    public static Intent m12007b(Context context, String str) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        String str2 = "android.intent.category.LAUNCHER";
        if (!launchIntentForPackage.hasCategory(str2)) {
            launchIntentForPackage.addCategory(str2);
        }
        launchIntentForPackage.setPackage(null);
        launchIntentForPackage.addFlags(2097152);
        launchIntentForPackage.addFlags(268435456);
        return launchIntentForPackage;
    }

    /* renamed from: c */
    public static boolean m12016c(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (context.getPackageManager().getPackageInfo(str, 0) != null) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m12004a(Context context, Intent intent) {
        boolean z = false;
        if (intent == null) {
            return false;
        }
        List queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
            z = true;
        }
        return z;
    }

    /* renamed from: d */
    public static boolean m12020d(Context context, String str) {
        return GlobalInfo.m9616c() != null && !GlobalInfo.m9616c().mo15664a();
    }

    /* renamed from: e */
    public static boolean m12024e(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("tel:");
                sb.append(Uri.encode(str));
                Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(sb.toString()));
                if (!(context instanceof Activity)) {
                    intent.setFlags(268435456);
                }
                ActivityUtil.m12108a(context, intent, null);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    /* renamed from: a */
    public static int m11991a(java.lang.String r8) {
        /*
        int r0 = r8.hashCode()
        r1 = 7
        r2 = 5
        r3 = 4
        r4 = 3
        r5 = 2
        r6 = 6
        r7 = 1
        switch(r0) {
            case -1695837674: goto L_0x0055;
            case -1364000502: goto L_0x004b;
            case -764631662: goto L_0x0041;
            case -712491894: goto L_0x0037;
            case 174971131: goto L_0x002d;
            case 564365438: goto L_0x0023;
            case 1844104722: goto L_0x0019;
            case 1912999166: goto L_0x000f;
            default: goto L_0x000e;
        }
    L_0x000e:
        goto L_0x005f
    L_0x000f:
        java.lang.String r0 = "draw_ad"
        boolean r8 = r8.equals(r0)
        if (r8 == 0) goto L_0x005f
        r8 = 1
        goto L_0x0060
    L_0x0019:
        java.lang.String r0 = "interaction"
        boolean r8 = r8.equals(r0)
        if (r8 == 0) goto L_0x005f
        r8 = 3
        goto L_0x0060
    L_0x0023:
        java.lang.String r0 = "cache_splash_ad"
        boolean r8 = r8.equals(r0)
        if (r8 == 0) goto L_0x005f
        r8 = 5
        goto L_0x0060
    L_0x002d:
        java.lang.String r0 = "splash_ad"
        boolean r8 = r8.equals(r0)
        if (r8 == 0) goto L_0x005f
        r8 = 4
        goto L_0x0060
    L_0x0037:
        java.lang.String r0 = "embeded_ad"
        boolean r8 = r8.equals(r0)
        if (r8 == 0) goto L_0x005f
        r8 = 0
        goto L_0x0060
    L_0x0041:
        java.lang.String r0 = "fullscreen_interstitial_ad"
        boolean r8 = r8.equals(r0)
        if (r8 == 0) goto L_0x005f
        r8 = 6
        goto L_0x0060
    L_0x004b:
        java.lang.String r0 = "rewarded_video"
        boolean r8 = r8.equals(r0)
        if (r8 == 0) goto L_0x005f
        r8 = 7
        goto L_0x0060
    L_0x0055:
        java.lang.String r0 = "banner_ad"
        boolean r8 = r8.equals(r0)
        if (r8 == 0) goto L_0x005f
        r8 = 2
        goto L_0x0060
    L_0x005f:
        r8 = -1
    L_0x0060:
        switch(r8) {
            case 0: goto L_0x006a;
            case 1: goto L_0x0069;
            case 2: goto L_0x0068;
            case 3: goto L_0x0067;
            case 4: goto L_0x0066;
            case 5: goto L_0x0066;
            case 6: goto L_0x0065;
            case 7: goto L_0x0064;
            default: goto L_0x0063;
        }
    L_0x0063:
        return r7
    L_0x0064:
        return r1
    L_0x0065:
        return r2
    L_0x0066:
        return r3
    L_0x0067:
        return r4
    L_0x0068:
        return r5
    L_0x0069:
        return r6
    L_0x006a:
        return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.ToolUtils.m11991a(java.lang.String):int");
    }

    /* renamed from: b */
    public static JSONObject m12012b(String str) {
        if (str != null) {
            try {
                return new JSONObject(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: a */
    public static boolean m12006a(MaterialMeta kVar) {
        return kVar != null && m12014c(kVar.mo15428P()) == 9;
    }

    /* renamed from: b */
    public static boolean m12013b(MaterialMeta kVar) {
        if (kVar != null) {
            return m12014c(kVar.mo15428P()) == 3 || m12014c(kVar.mo15428P()) == 4;
        }
        return false;
    }

    /* renamed from: c */
    public static boolean m12017c(MaterialMeta kVar) {
        return kVar != null && m12014c(kVar.mo15428P()) == 7;
    }

    /* renamed from: d */
    public static boolean m12021d(MaterialMeta kVar) {
        return kVar != null && m12014c(kVar.mo15428P()) == 8;
    }

    /* renamed from: e */
    public static boolean m12025e(MaterialMeta kVar) {
        return (kVar == null || kVar.mo15427O() == null || TextUtils.isEmpty(kVar.mo15427O().mo15376a())) ? false : true;
    }

    /* renamed from: f */
    public static String m12029f(MaterialMeta kVar) {
        return m12025e(kVar) ? "deeplink_fail" : "installed";
    }

    /* renamed from: c */
    public static int m12014c(String str) {
        JSONObject b = m12012b(str);
        if (b != null) {
            return b.optInt("ad_slot_type", 0);
        }
        return 0;
    }

    /* renamed from: d */
    public static int m12018d(String str) {
        JSONObject b = m12012b(str);
        if (b != null) {
            return b.optInt("rit", 0);
        }
        return 0;
    }

    /* renamed from: e */
    public static long m12022e(String str) {
        JSONObject b = m12012b(str);
        if (b != null) {
            return b.optLong(AppEntity.KEY_UID, 0);
        }
        return 0;
    }

    /* renamed from: f */
    public static int m12026f(String str) {
        JSONObject b = m12012b(str);
        if (b != null) {
            return b.optInt("ut", 0);
        }
        return 0;
    }

    /* renamed from: g */
    public static double m12030g(String str) {
        JSONObject b = m12012b(str);
        if (b != null) {
            return b.optDouble("pack_time", 0.0d);
        }
        return 0.0d;
    }

    /* renamed from: h */
    public static String m12034h(String str) {
        JSONObject b = m12012b(str);
        String str2 = "";
        return b != null ? b.optString("req_id", str2) : str2;
    }

    /* renamed from: g */
    public static String m12032g(MaterialMeta kVar) {
        if (kVar == null || kVar.mo15426N() == null || TextUtils.isEmpty(kVar.mo15426N().mo15342b())) {
            return null;
        }
        return kVar.mo15426N().mo15342b();
    }

    /* renamed from: a */
    public static void m12001a(final MaterialMeta kVar, final View view) {
        TTExecutor.m11692a().mo16808c(new Runnable() {
            public void run() {
                JSONObject b = ToolUtils.m12012b(kVar.mo15428P());
                if (b != null) {
                    InternalContainer.m10067f().mo15916a(b.optInt("rit", 0), b.optString("req_id", ""), kVar.mo15425M(), UIUtils.m12069b(view.getRootView(), 1048576));
                }
            }
        }, 5);
    }

    /* renamed from: a */
    public static String m11992a() {
        String str;
        try {
            str = System.getProperty("http.agent");
        } catch (Exception unused) {
            str = "unKnow";
        }
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            return "";
        }
        String str2 = ";";
        int lastIndexOf = str.lastIndexOf(str2);
        if (lastIndexOf != -1 && str.length() > lastIndexOf) {
            int i = lastIndexOf + 1;
            String substring = str.substring(0, i);
            String substring2 = str.substring(i);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" ");
            sb2.append(Locale.getDefault().getLanguage());
            sb2.append("-");
            sb2.append(Locale.getDefault().getCountry());
            sb2.append(str2);
            str = substring.concat(sb2.toString()).concat(substring2);
        }
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt <= 31 || charAt >= 127) {
                sb.append(String.format("\\u%04x", new Object[]{Integer.valueOf(charAt)}));
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    /* renamed from: b */
    public static String m12008b() {
        return UUID.randomUUID().toString();
    }

    /* renamed from: c */
    public static String m12015c() {
        try {
            byte[] bArr = new byte[8];
            new SecureRandom().nextBytes(bArr);
            return DigestUtils.m12170a(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: d */
    public static synchronized String m12019d() {
        String str;
        synchronized (ToolUtils.class) {
            if (TextUtils.isEmpty(f9122a) && InternalContainer.m10059a() != null) {
                try {
                    f9122a = InternalContainer.m10059a().getPackageName();
                } catch (Throwable th) {
                    C2564t.m12223c("ToolUtils", "ToolUtils getPackageName throws exception :", th);
                }
            }
            str = f9122a;
        }
        return str;
    }

    /* renamed from: e */
    public static synchronized String m12023e() {
        String str;
        synchronized (ToolUtils.class) {
            if (TextUtils.isEmpty(f9123b) && InternalContainer.m10059a() != null) {
                try {
                    PackageInfo packageInfo = InternalContainer.m10059a().getPackageManager().getPackageInfo(m12019d(), 0);
                    f9123b = String.valueOf(packageInfo.versionCode);
                    f9124c = packageInfo.versionName;
                } catch (Throwable th) {
                    C2564t.m12223c("ToolUtils", "ToolUtils getVersionCode throws exception :", th);
                }
            }
            str = f9123b;
        }
        return str;
    }

    /* renamed from: f */
    public static synchronized String m12027f() {
        String str;
        synchronized (ToolUtils.class) {
            if (TextUtils.isEmpty(f9124c) && InternalContainer.m10059a() != null) {
                try {
                    PackageInfo packageInfo = InternalContainer.m10059a().getPackageManager().getPackageInfo(m12019d(), 0);
                    f9123b = String.valueOf(packageInfo.versionCode);
                    f9124c = packageInfo.versionName;
                } catch (Throwable th) {
                    C2564t.m12223c("ToolUtils", "ToolUtils getVersionName throws exception :", th);
                }
            }
            str = f9124c;
        }
        return str;
    }

    /* renamed from: a */
    public static String m11994a(Context context) {
        String str = "total_memory";
        String b = AdPreference.m9212a(context).mo15327b(str, (String) null);
        if (b != null) {
            return b;
        }
        String f = m12028f(context, "MemTotal");
        AdPreference.m9212a(context).mo15322a(str, f);
        return f;
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r0v1 */
    /* JADX WARNING: type inference failed for: r1v1 */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:17|18|19|20|21|22|23|24) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0020 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0048 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0059 A[SYNTHETIC, Splitter:B:34:0x0059] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0060 A[SYNTHETIC, Splitter:B:38:0x0060] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* renamed from: f */
    public static java.lang.String m12028f(android.content.Context r6, java.lang.String r7) {
        /*
        r6 = 0
        java.io.FileReader r0 = new java.io.FileReader     // Catch:{ all -> 0x0051 }
        java.lang.String r1 = "/proc/meminfo"
        r0.<init>(r1)     // Catch:{ all -> 0x0051 }
        java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ all -> 0x004e }
        r2 = 4096(0x1000, float:5.74E-42)
        r1.<init>(r0, r2)     // Catch:{ all -> 0x004e }
    L_0x000f:
        java.lang.String r2 = r1.readLine()     // Catch:{ all -> 0x004c }
        if (r2 == 0) goto L_0x001b
        boolean r3 = r2.contains(r7)     // Catch:{ all -> 0x004c }
        if (r3 == 0) goto L_0x000f
    L_0x001b:
        if (r2 != 0) goto L_0x0024
        r1.close()     // Catch:{ Exception -> 0x0020 }
    L_0x0020:
        r0.close()     // Catch:{ Exception -> 0x0023 }
    L_0x0023:
        return r6
    L_0x0024:
        java.lang.String r7 = "\\s+"
        java.lang.String[] r7 = r2.split(r7)     // Catch:{ all -> 0x004c }
        java.lang.String r2 = "ToolUtils"
        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x004c }
        r3.<init>()     // Catch:{ all -> 0x004c }
        java.lang.String r4 = "getTotalMemory = "
        r3.append(r4)     // Catch:{ all -> 0x004c }
        r4 = 1
        r5 = r7[r4]     // Catch:{ all -> 0x004c }
        r3.append(r5)     // Catch:{ all -> 0x004c }
        java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x004c }
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r2, r3)     // Catch:{ all -> 0x004c }
        r6 = r7[r4]     // Catch:{ all -> 0x004c }
        r1.close()     // Catch:{ Exception -> 0x0048 }
    L_0x0048:
        r0.close()     // Catch:{ Exception -> 0x004b }
    L_0x004b:
        return r6
    L_0x004c:
        r7 = move-exception
        goto L_0x0054
    L_0x004e:
        r7 = move-exception
        r1 = r6
        goto L_0x0054
    L_0x0051:
        r7 = move-exception
        r0 = r6
        r1 = r0
    L_0x0054:
        r7.printStackTrace()     // Catch:{ all -> 0x0064 }
        if (r1 == 0) goto L_0x005e
        r1.close()     // Catch:{ Exception -> 0x005d }
        goto L_0x005e
    L_0x005e:
        if (r0 == 0) goto L_0x0063
        r0.close()     // Catch:{ Exception -> 0x0063 }
    L_0x0063:
        return r6
    L_0x0064:
        r6 = move-exception
        if (r1 == 0) goto L_0x006c
        r1.close()     // Catch:{ Exception -> 0x006b }
        goto L_0x006c
    L_0x006c:
        if (r0 == 0) goto L_0x0071
        r0.close()     // Catch:{ Exception -> 0x0071 }
    L_0x0071:
        throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.ToolUtils.m12028f(android.content.Context, java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public static Map<String, Object> m11995a(long j, MaterialMeta kVar, SSMediaPlayerWrapper dVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("video_start_duration", Long.valueOf(j));
        if (kVar != null) {
            if (!TextUtils.isEmpty(kVar.mo15425M())) {
                hashMap.put("creative_id", kVar.mo15425M());
            }
            VideoInfo z = kVar.mo15512z();
            if (z != null) {
                hashMap.put("video_resolution", z.mo15599e());
                hashMap.put("video_size", Long.valueOf(z.mo15593c()));
            }
        }
        m12003a((Map<String, Object>) hashMap, dVar);
        return hashMap;
    }

    /* renamed from: a */
    public static Map<String, Object> m11998a(boolean z, MaterialMeta kVar, long j, long j2, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("creative_id", kVar.mo15425M());
        hashMap.put("load_time", Long.valueOf(j));
        VideoInfo z2 = kVar.mo15512z();
        if (z2 != null) {
            hashMap.put("video_size", Long.valueOf(z2.mo15593c()));
            hashMap.put("video_resolution", z2.mo15599e());
        }
        if (!z) {
            hashMap.put("error_code", Long.valueOf(j2));
            if (TextUtils.isEmpty(str)) {
                str = EnvironmentCompat.MEDIA_UNKNOWN;
            }
            hashMap.put("error_message", str);
        }
        return hashMap;
    }

    /* renamed from: b */
    public static Map<String, Object> m12011b(boolean z, MaterialMeta kVar, long j, long j2, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("creative_id", kVar.mo15425M());
        hashMap.put("load_time", Long.valueOf(j));
        if (!z) {
            hashMap.put("error_code", Long.valueOf(j2));
            if (TextUtils.isEmpty(str)) {
                str = EnvironmentCompat.MEDIA_UNKNOWN;
            }
            hashMap.put("error_message", str);
        }
        return hashMap;
    }

    /* renamed from: a */
    public static Map<String, Object> m11996a(MaterialMeta kVar, int i, int i2, SSMediaPlayerWrapper dVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("creative_id", kVar.mo15425M());
        hashMap.put("error_code", Integer.valueOf(i));
        hashMap.put("extra_error_code", Integer.valueOf(i2));
        VideoInfo z = kVar.mo15512z();
        if (z != null) {
            hashMap.put("video_size", Long.valueOf(z.mo15593c()));
            hashMap.put("video_resolution", z.mo15599e());
        }
        m12003a((Map<String, Object>) hashMap, dVar);
        return hashMap;
    }

    /* renamed from: a */
    public static Map<String, Object> m11997a(MaterialMeta kVar, long j, SSMediaPlayerWrapper dVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("creative_id", kVar.mo15425M());
        hashMap.put("buffers_time", Long.valueOf(j));
        VideoInfo z = kVar.mo15512z();
        if (z != null) {
            hashMap.put("video_size", Long.valueOf(z.mo15593c()));
            hashMap.put("video_resolution", z.mo15599e());
        }
        m12003a((Map<String, Object>) hashMap, dVar);
        return hashMap;
    }

    /* renamed from: a */
    private static void m12003a(Map<String, Object> map, SSMediaPlayerWrapper dVar) {
        String str = "video_resolution";
        if (!map.containsKey(str) && dVar != null) {
            try {
                if (dVar.mo16055a() != null) {
                    map.put(str, String.format(Locale.getDefault(), "%d×%d", new Object[]{Integer.valueOf(dVar.mo16055a().getVideoWidth()), Integer.valueOf(dVar.mo16055a().getVideoHeight())}));
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: i */
    public static byte[] m12037i(String str) throws IOException {
        if (str == null || str.length() == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        try {
            gZIPOutputStream.write(str.getBytes());
            try {
            } catch (Exception e) {
                C2564t.m12219b(e.toString());
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e2) {
            C2564t.m12219b(e2.toString());
            try {
            } catch (Exception e3) {
                C2564t.m12219b(e3.toString());
            }
            return null;
        } finally {
            try {
                gZIPOutputStream.close();
            } catch (Exception e4) {
                C2564t.m12219b(e4.toString());
            }
        }
    }

    /* renamed from: j */
    public static boolean m12039j(String str) {
        try {
            if (Pattern.compile("[一-龥]").matcher(str).find()) {
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    /* renamed from: b */
    public static String m12010b(Context context) {
        Locale locale;
        try {
            if (VERSION.SDK_INT >= 24) {
                locale = context.getResources().getConfiguration().getLocales().get(0);
            } else {
                locale = Locale.getDefault();
            }
            return locale.getLanguage();
        } catch (Exception e) {
            C2564t.m12226e("ToolUtils", e.toString());
            return "";
        }
    }

    /* renamed from: a */
    public static int m11990a(INativeVideoController cVar, boolean z) {
        if (cVar == null || cVar.mo15996t() == null || !cVar.mo15996t().mo16067g()) {
            return 3;
        }
        return !z;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:9|10) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
            r2.put(r1, r8.toString());
            r2.put(r0, 0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0048 */
    /* renamed from: a */
    public static org.json.JSONObject m12000a(org.json.JSONObject r8) {
        /*
        java.lang.String r0 = "cypher"
        java.lang.String r1 = "message"
        org.json.JSONObject r2 = new org.json.JSONObject
        r2.<init>()
        if (r8 != 0) goto L_0x000c
        return r2
    L_0x000c:
        r3 = 0
        java.lang.String r4 = com.bytedance.sdk.openadsdk.core.AES.m9048a()     // Catch:{ all -> 0x0048 }
        java.lang.String r5 = com.bytedance.sdk.openadsdk.core.AES.m9049a(r4)     // Catch:{ all -> 0x0048 }
        java.lang.String r6 = r8.toString()     // Catch:{ all -> 0x0048 }
        java.lang.String r5 = com.bytedance.sdk.openadsdk.core.AES.m9050a(r6, r5)     // Catch:{ all -> 0x0048 }
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0048 }
        r6.<init>()     // Catch:{ all -> 0x0048 }
        r7 = 2
        r6.append(r7)     // Catch:{ all -> 0x0048 }
        r6.append(r4)     // Catch:{ all -> 0x0048 }
        r6.append(r5)     // Catch:{ all -> 0x0048 }
        java.lang.String r4 = r6.toString()     // Catch:{ all -> 0x0048 }
        boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0048 }
        if (r5 != 0) goto L_0x003d
        r2.put(r1, r4)     // Catch:{ all -> 0x0048 }
        r2.put(r0, r7)     // Catch:{ all -> 0x0048 }
        goto L_0x0052
    L_0x003d:
        java.lang.String r4 = r8.toString()     // Catch:{ all -> 0x0048 }
        r2.put(r1, r4)     // Catch:{ all -> 0x0048 }
        r2.put(r0, r3)     // Catch:{ all -> 0x0048 }
        goto L_0x0052
    L_0x0048:
        java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0052 }
        r2.put(r1, r8)     // Catch:{ all -> 0x0052 }
        r2.put(r0, r3)     // Catch:{ all -> 0x0052 }
    L_0x0052:
        return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.ToolUtils.m12000a(org.json.JSONObject):org.json.JSONObject");
    }

    /* renamed from: k */
    public static String m12040k(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 17) {
            return str;
        }
        return AES.m9052b(str.substring(17), m12047r(str.substring(1, 17)));
    }

    /* renamed from: r */
    private static String m12047r(String str) {
        String a = AES.m9049a(str);
        if (str != null) {
            return a;
        }
        String a2 = AESKey.m9086a();
        return a2.concat(a2).substring(8, 24);
    }

    /* renamed from: a */
    public static JSONObject m11999a(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                for (Entry entry : map.entrySet()) {
                    jSONObject.put((String) entry.getKey(), entry.getValue());
                }
            } catch (Exception unused) {
            }
            return jSONObject;
        } catch (Exception unused2) {
            return null;
        }
    }

    /* renamed from: l */
    public static boolean m12041l(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (m12042m(str) || m12043n(str)) {
            z = true;
        }
        return z;
    }

    /* renamed from: m */
    public static boolean m12042m(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.matches("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}", str);
    }

    /* renamed from: n */
    public static boolean m12043n(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (m12044o(str) || m12045p(str)) {
            z = true;
        }
        return z;
    }

    /* renamed from: o */
    public static boolean m12044o(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.matches("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$", str);
    }

    /* renamed from: p */
    public static boolean m12045p(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.matches("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$", str);
    }

    /* renamed from: a */
    public static void m12002a(MaterialMeta kVar, String str) {
        if (kVar != null) {
            try {
                String E = kVar.mo15417E();
                if (TextUtils.isEmpty(E) && kVar.mo15427O() != null && kVar.mo15427O().mo15381c() == 1 && !TextUtils.isEmpty(kVar.mo15427O().mo15379b())) {
                    E = kVar.mo15427O().mo15379b();
                }
                String str2 = E;
                if (!TextUtils.isEmpty(str2)) {
                    WebHelper.m11012a(InternalContainer.m10059a(), str2, kVar, m11991a(str), str, false);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: h */
    public static boolean m12035h(MaterialMeta kVar) {
        boolean z = true;
        if (kVar == null) {
            return true;
        }
        int c = InternalContainer.m10069h().mo15779c(m12018d(kVar.mo15428P()));
        if (c == 1) {
            return C2566w.m12245d(InternalContainer.m10059a());
        }
        if (c == 2) {
            if (!C2566w.m12246e(InternalContainer.m10059a()) && !C2566w.m12245d(InternalContainer.m10059a())) {
                z = false;
            }
            return z;
        } else if (c == 3) {
            return false;
        } else {
            if (c != 4) {
            }
            return true;
        }
    }

    /* renamed from: q */
    public static String m12046q(String str) {
        return String.format("https://%s%s", new Object[]{InternalContainer.m10069h().mo15776b(), str});
    }

    /* renamed from: g */
    public static String m12031g() {
        return String.format("https://%s", new Object[]{InternalContainer.m10069h().mo15781c()});
    }

    /* renamed from: h */
    public static int m12033h() {
        try {
            return (int) ((((double) Runtime.getRuntime().maxMemory()) * 1.0d) / 1048576.0d);
        } catch (Exception unused) {
            return -1;
        }
    }

    /* renamed from: i */
    public static int m12036i() {
        try {
            return (int) ((((double) Runtime.getRuntime().freeMemory()) * 1.0d) / 1048576.0d);
        } catch (Exception unused) {
            return -1;
        }
    }

    /* renamed from: j */
    public static int m12038j() {
        try {
            return (int) ((((double) Runtime.getRuntime().totalMemory()) * 1.0d) / 1048576.0d);
        } catch (Exception unused) {
            return -1;
        }
    }
}
