package com.bytedance.sdk.openadsdk.p188g;

import android.content.Context;
import android.location.Address;
import com.bytedance.sdk.adnet.p160c.ITTAdNetDepend;
import com.bytedance.sdk.openadsdk.core.IdUtils;
import com.bytedance.sdk.openadsdk.multipro.p205d.SPMultiHelper;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.bytedance.sdk.openadsdk.g.c */
public class TTAdNetDepend implements ITTAdNetDepend {
    /* renamed from: a */
    String f8718a = "sp_multi_ttadnet_config";
    /* renamed from: b */
    private Context f8719b;

    /* renamed from: a */
    public Address mo14229a(Context context) {
        return null;
    }

    /* renamed from: b */
    public String mo14232b() {
        return "openadsdk";
    }

    /* renamed from: c */
    public String mo14233c() {
        return "android";
    }

    /* renamed from: d */
    public int mo14234d() {
        return 2955;
    }

    public TTAdNetDepend(Context context) {
        this.f8719b = context;
    }

    /* renamed from: a */
    public int mo14228a() {
        return Integer.parseInt("1371");
    }

    /* renamed from: e */
    public String mo14235e() {
        return IdUtils.m9858a(this.f8719b);
    }

    /* renamed from: a */
    public String mo14230a(Context context, String str, String str2) {
        return SPMultiHelper.m11880b(this.f8718a, str, str2);
    }

    /* renamed from: a */
    public void mo14231a(Context context, Map<String, ?> map) {
        if (map != null) {
            try {
                for (Entry entry : map.entrySet()) {
                    Object value = entry.getValue();
                    if (value instanceof Integer) {
                        SPMultiHelper.m11872a(this.f8718a, (String) entry.getKey(), (Integer) value);
                    } else if (value instanceof Long) {
                        SPMultiHelper.m11873a(this.f8718a, (String) entry.getKey(), (Long) value);
                    } else if (value instanceof Float) {
                        SPMultiHelper.m11871a(this.f8718a, (String) entry.getKey(), (Float) value);
                    } else if (value instanceof Boolean) {
                        SPMultiHelper.m11870a(this.f8718a, (String) entry.getKey(), (Boolean) value);
                    } else if (value instanceof String) {
                        SPMultiHelper.m11874a(this.f8718a, (String) entry.getKey(), (String) value);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: f */
    public String[] mo14236f() {
        return new String[]{"dm.toutiao.com", "dm.bytedance.com", "dm.pstatp.com"};
    }
}
