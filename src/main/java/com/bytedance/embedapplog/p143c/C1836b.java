package com.bytedance.embedapplog.p143c;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.embed_device_register.C1779b;
import com.bytedance.embedapplog.AppLog;
import com.bytedance.embedapplog.IAppParam;
import com.bytedance.embedapplog.util.C1852d;
import com.bytedance.embedapplog.util.C1856h;
import com.bytedance.embedapplog.util.C1857i;
import com.tencent.stat.apkreader.ChannelReader;
import com.tencent.stat.common.DeviceInfo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.bytedance.embedapplog.c.b */
public class C1836b {
    /* renamed from: a */
    private static final String[] f5140a = {"ab_version", "device_brand", "language", "os_api", "resolution", "google_aid", "build_serial", "carrier", "install_id", "package", "app_version", "device_model", "udid", "density_dpi", "aliyun_uuid", "mcc_mnc", "sim_region", "ab_client", "ab_group", "ab_feature", "device_id", "openudid", "clientudid", DeviceInfo.TAG_ANDROID_ID};
    /* renamed from: b */
    private static final String[] f5141b = {"ab_version", "device_brand", "language", "os_api", "resolution", "google_aid", "build_serial", "carrier", "iid", "app_name", "version_name", "device_type", "uuid", "dpi", "aliyun_uuid", "mcc_mnc", "sim_region", "ab_client", "ab_group", "ab_feature", "device_id", "openudid", "clientudid", DeviceInfo.TAG_ANDROID_ID};

    /* renamed from: a */
    public static String m6441a(Context context, JSONObject jSONObject, String str, boolean z, IAppParam iAppParam) {
        Map map;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        HashMap hashMap = new HashMap(f5140a.length + 10);
        int i = 0;
        while (true) {
            String[] strArr = f5140a;
            if (i >= strArr.length) {
                break;
            }
            String optString = jSONObject.optString(strArr[i], null);
            if (!TextUtils.isEmpty(optString)) {
                hashMap.put(f5141b[i], optString);
            }
            i++;
        }
        if (iAppParam != null) {
            try {
                map = iAppParam.getAppSSIDs(context);
            } catch (Exception e) {
                C1856h.m6582a(e);
            }
        } else {
            map = null;
        }
        if (C1857i.m6594b(context) && map != null) {
            hashMap.putAll(map);
        }
        try {
            Map extraParams = AppLog.getExtraParams() == null ? null : AppLog.getExtraParams().getExtraParams();
            if (extraParams != null) {
                hashMap.putAll(extraParams);
            }
        } catch (Exception e2) {
            C1856h.m6582a(e2);
        }
        if (AppLog.sCustomNetParams.size() > 0) {
            hashMap.putAll(AppLog.sCustomNetParams);
        }
        if (z) {
            hashMap.put("ssmix", "a");
        }
        String c = C1852d.m6566c(context);
        if (!TextUtils.isEmpty(c)) {
            hashMap.put("ac", c);
        }
        String str2 = "";
        String str3 = (String) AppLog.getHeaderValue("tweaked_channel", str2);
        boolean isEmpty = TextUtils.isEmpty(str3);
        String str4 = ChannelReader.CHANNEL_KEY;
        if (isEmpty) {
            str3 = (String) AppLog.getHeaderValue(str4, str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put(str4, str3);
        }
        String str5 = "os_version";
        String optString2 = jSONObject.optString(str5, null);
        if (optString2 != null && optString2.length() > 10) {
            optString2 = optString2.substring(0, 10);
        }
        hashMap.put(str5, optString2);
        hashMap.put("_rticket", String.valueOf(System.currentTimeMillis()));
        hashMap.put("device_platform", "android");
        String str6 = "version_code";
        int intValue = ((Integer) AppLog.getHeaderValue(str6, Integer.valueOf(-1))).intValue();
        if (intValue != -1) {
            hashMap.put(str6, String.valueOf(intValue));
        }
        String str7 = "manifest_version_code";
        int intValue2 = ((Integer) AppLog.getHeaderValue(str7, Integer.valueOf(-1))).intValue();
        if (intValue2 != -1) {
            hashMap.put(str7, String.valueOf(intValue2));
        }
        String str8 = "update_version_code";
        int intValue3 = ((Integer) AppLog.getHeaderValue(str8, Integer.valueOf(-1))).intValue();
        if (intValue3 != -1) {
            hashMap.put(str8, String.valueOf(intValue3));
        }
        String str9 = "oaid";
        String a = C1779b.m6170a(jSONObject.optJSONObject(str9));
        if (!TextUtils.isEmpty(a)) {
            hashMap.put(str9, a);
        }
        String str10 = "cdid";
        String optString3 = jSONObject.optString(str10);
        if (!TextUtils.isEmpty(optString3)) {
            hashMap.put(str10, optString3);
        }
        String str11 = "/";
        if (!str.endsWith(str11)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(str11);
            str = sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        char c2 = '?';
        if (str.indexOf(63) >= 0) {
            c2 = '&';
        }
        sb2.append(c2);
        return C1857i.m6589a(sb2.toString(), hashMap, "UTF-8");
    }

    /* renamed from: a */
    public static String[] m6442a(Context context, JSONObject jSONObject) {
        String[] strArr = new String[C1835a.m6431a().getSendHeadersUris().length];
        String str = AppLog.getEncryptAndCompress() ? "/service/2/app_log/?tt_data=a" : "/service/2/app_log/?";
        for (int i = 0; i < C1835a.m6431a().getSendHeadersUris().length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(C1835a.m6431a().getSendHeadersUris()[i]);
            sb.append(str);
            strArr[i] = m6441a(context, jSONObject, sb.toString(), true, AppLog.getIAppParam());
            strArr[i] = C1835a.m6434a(strArr[i], C1835a.f5135b);
        }
        return strArr;
    }

    /* renamed from: b */
    public static String m6443b(Context context, JSONObject jSONObject) {
        String str = AppLog.getEncryptAndCompress() ? "/service/2/app_log/?tt_data=a" : "/service/2/app_log/?";
        StringBuilder sb = new StringBuilder();
        sb.append(C1835a.m6431a().getSuccRateUri());
        sb.append(str);
        return m6441a(context, jSONObject, sb.toString(), true, AppLog.getIAppParam());
    }
}
