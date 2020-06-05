package com.bytedance.sdk.openadsdk.core.p174h;

import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.openadsdk.core.GlobalInfo;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.multipro.p205d.SPMultiHelper;
import com.bytedance.sdk.openadsdk.p185f.StatsLogManager;
import com.bytedance.sdk.openadsdk.p185f.p186a.LogStatsBase;
import com.bytedance.sdk.openadsdk.p198i.TTExecutor;
import com.bytedance.sdk.openadsdk.utils.AdLocation;
import com.bytedance.sdk.openadsdk.utils.AdLocationUtils;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.core.h.f */
public class ProcessPushHelper implements Runnable {
    /* renamed from: a */
    private static volatile ProcessPushHelper f7630a;

    /* renamed from: a */
    public static ProcessPushHelper m9725a() {
        if (f7630a == null) {
            synchronized (SdkSettingsHelper.class) {
                if (f7630a == null) {
                    f7630a = new ProcessPushHelper();
                }
            }
        }
        return f7630a;
    }

    private ProcessPushHelper() {
    }

    /* renamed from: b */
    public void mo15744b() {
        TTExecutor.m11692a().mo16807b(this, 1);
    }

    public void run() {
        String str = "sp_push_time";
        if (!m9728d()) {
            try {
                wait(1000);
            } catch (Exception unused) {
            }
            List T = InternalContainer.m10069h().mo15772T();
            if (T != null) {
                for (int i = 0; i < T.size(); i++) {
                    ProcessPushModel gVar = (ProcessPushModel) T.get(i);
                    if (gVar != null) {
                        try {
                            long currentTimeMillis = System.currentTimeMillis();
                            if (!(gVar.f7632b == null || gVar.f7633c == null || currentTimeMillis - SPMultiHelper.m11866a(str, gVar.f7633c, 0) <= ((long) (gVar.f7634d * 1000)))) {
                                SPMultiHelper.m11873a(str, gVar.f7633c, Long.valueOf(currentTimeMillis));
                                Intent intent = new Intent();
                                intent.setAction(gVar.f7631a);
                                intent.setPackage(gVar.f7633c);
                                InternalContainer.m10059a().startService(intent);
                                mo15743a(gVar, 1);
                            }
                        } catch (Throwable unused2) {
                            mo15743a(gVar, 0);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public void mo15743a(ProcessPushModel gVar, int i) {
        LogStatsBase dVar = new LogStatsBase();
        dVar.mo16593b(m9726b(gVar, i));
        dVar.mo16591a("wk_status");
        dVar.mo16599e("2.9.5.5");
        dVar.mo16594c(System.currentTimeMillis());
        StatsLogManager.m11278a().mo16581m(dVar);
    }

    /* renamed from: b */
    private String m9726b(ProcessPushModel gVar, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wk_status", i);
            jSONObject.put(ArgKey.KEY_APP_ID, GlobalInfo.m9616c().mo15675e());
            jSONObject.put("package_name", ToolUtils.m12019d());
            jSONObject.put("geo", m9727c());
            jSONObject.put("ad_sdk_version", "2.9.5.5");
            jSONObject.put("os", 1);
            StringBuilder sb = new StringBuilder();
            sb.append(VERSION.RELEASE);
            sb.append("");
            jSONObject.put("os_version", sb.toString());
            jSONObject.put("ip", DeviceUtils.m12163a(true));
            jSONObject.put("ua", ToolUtils.m11992a());
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("ad_package_name", gVar.f7633c);
            jSONObject.put("action", gVar.f7631a);
            jSONObject.put(NotificationCompat.CATEGORY_SERVICE, gVar.f7632b);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    /* renamed from: c */
    private JSONObject m9727c() {
        AdLocation a = AdLocationUtils.m12114a(InternalContainer.m10059a());
        if (a != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("latitude", (double) a.f9146a);
                jSONObject.put("longitude", (double) a.f9147b);
                return jSONObject;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* renamed from: d */
    private boolean m9728d() {
        return TextUtils.isEmpty(GlobalInfo.m9616c().mo15675e());
    }
}
