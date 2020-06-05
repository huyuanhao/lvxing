package com.bytedance.tea.crash.p221g;

import android.text.TextUtils;
import com.bytedance.tea.crash.CrashType;
import com.bytedance.tea.crash.NpthBus;
import com.bytedance.tea.crash.p216c.C2578b;
import com.bytedance.tea.crash.p216c.CrashBody;
import com.tencent.stat.common.DeviceInfo;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.bytedance.tea.crash.g.k */
public final class PackUtil {
    /* renamed from: a */
    public static void m12552a(CrashBody aVar, C2578b bVar, CrashType cVar) {
        String str = "_";
        if (aVar != null && aVar.mo16997a() != null && cVar != null) {
            JSONObject a = aVar.mo16997a();
            long optLong = a.optLong("crash_time");
            int b = m12553b(m12551a(DeviceInfo.TAG_ANDROID_ID));
            String a2 = NpthBus.m12594c().mo17059a();
            if (optLong > 0 && b > 0 && !TextUtils.isEmpty(a2) && !"0".equals(a2) && !TextUtils.isEmpty(cVar.mo16988a())) {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("android_");
                    sb.append(b);
                    sb.append(str);
                    sb.append(a2);
                    sb.append(str);
                    sb.append(optLong);
                    sb.append(str);
                    sb.append(cVar);
                    String sb2 = sb.toString();
                    String str2 = "unique_key";
                    if (bVar != null) {
                        JSONObject a3 = bVar.mo17002a();
                        if (a3 != null) {
                            a3.put(str2, sb2);
                            return;
                        }
                        return;
                    }
                    a.put(str2, sb2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    public static String m12551a(String str) {
        if (NpthBus.m12591a() != null) {
            Map a = NpthBus.m12591a().mo17019a();
            if (a != null) {
                Object obj = a.get(str);
                if (obj instanceof String) {
                    return (String) obj;
                }
            }
        }
        return null;
    }

    /* renamed from: b */
    public static int m12553b(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            NpthLog.m12550b(e);
            return 0;
        }
    }
}
