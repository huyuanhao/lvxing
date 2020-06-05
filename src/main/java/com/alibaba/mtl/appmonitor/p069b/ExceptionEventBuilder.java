package com.alibaba.mtl.appmonitor.p069b;

import android.content.Context;
import com.alibaba.mtl.appmonitor.SdkMeta;
import com.alibaba.mtl.appmonitor.p068a.EventType;
import com.alibaba.mtl.appmonitor.p068a.UTEvent;
import com.alibaba.mtl.appmonitor.p070c.BalancedPool;
import com.alibaba.mtl.appmonitor.p070c.ReuseJSONArray;
import com.alibaba.mtl.appmonitor.p070c.ReuseJSONObject;
import com.alibaba.mtl.appmonitor.p073f.StringUtils;
import com.alibaba.mtl.appmonitor.p073f.UTUtil;
import com.alibaba.mtl.log.p077d.AppInfoUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.alibaba.mtl.appmonitor.b.b */
public class ExceptionEventBuilder {
    /* renamed from: a */
    public static void m3404a(Context context, Throwable th) {
        if (th != null) {
            try {
                UTEvent hVar = (UTEvent) BalancedPool.m3491a().mo11627a(UTEvent.class, new Object[0]);
                hVar.f3182b = EventType.ALARM.mo11568a();
                HashMap hashMap = new HashMap();
                hashMap.put("meta", SdkMeta.m3582a());
                ReuseJSONArray dVar = (ReuseJSONArray) BalancedPool.m3491a().mo11627a(ReuseJSONArray.class, new Object[0]);
                dVar.put(m3407b(context, th));
                hashMap.put("data", dVar);
                hVar.f3186f.put(EventType.ALARM.mo11568a(), new JSONObject(hashMap).toString());
                hVar.f3183c = "APPMONITOR";
                hVar.f3184d = "sdk-exception";
                UTUtil.m3591a(hVar);
                BalancedPool.m3491a().mo11628a(dVar);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static void m3405a(Throwable th) {
        m3404a(null, th);
    }

    /* renamed from: b */
    private static JSONObject m3407b(Context context, Throwable th) throws IOException {
        JSONObject jSONObject = (JSONObject) BalancedPool.m3491a().mo11627a(ReuseJSONObject.class, new Object[0]);
        if (context != null) {
            try {
                jSONObject.put("pname", AppInfoUtil.m3794b(context));
            } catch (Exception unused) {
            }
        }
        jSONObject.put("page", "APPMONITOR");
        jSONObject.put("monitorPoint", "sdk-exception");
        jSONObject.put("arg", th.getClass().getSimpleName());
        jSONObject.put("successCount", 0);
        jSONObject.put("failCount", 1);
        ArrayList arrayList = new ArrayList();
        String b = m3406b(th);
        if (b != null) {
            JSONObject jSONObject2 = (JSONObject) BalancedPool.m3491a().mo11627a(ReuseJSONObject.class, new Object[0]);
            jSONObject2.put("errorCode", b);
            jSONObject2.put("errorCount", 1);
            arrayList.add(jSONObject2);
        }
        jSONObject.put("errors", arrayList);
        return jSONObject;
    }

    /* renamed from: b */
    private static String m3406b(Throwable th) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(th.getClass().getName());
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace != null) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                sb.append(stackTraceElement.toString());
            }
        }
        String sb2 = sb.toString();
        return StringUtils.m3590b(sb2) ? th.toString() : sb2;
    }
}
