package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.multipro.MultiGlobalInfo;
import com.bytedance.sdk.openadsdk.multipro.p205d.SPMultiHelper;
import com.bytedance.sdk.openadsdk.utils.SlotUtils;

/* renamed from: com.bytedance.sdk.openadsdk.component.reward.h */
class SpCache {
    /* renamed from: a */
    private String f6974a;
    /* renamed from: b */
    private Context f6975b;

    SpCache(Context context, String str) {
        this.f6975b = context;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.f6974a = str;
    }

    /* renamed from: b */
    private Context m8773b() {
        Context context = this.f6975b;
        return context == null ? InternalContainer.m10059a() : context;
    }

    /* renamed from: f */
    private SharedPreferences m8776f(String str) {
        try {
            if (m8773b() != null) {
                return m8773b().getSharedPreferences(str, 0);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    /* renamed from: g */
    private String m8777g(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f6974a);
        sb.append("_cache_");
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: c */
    private String m8774c() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f6974a);
        sb.append("_adslot");
        return sb.toString();
    }

    /* renamed from: d */
    private String m8775d() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f6974a);
        sb.append("_adslot_preload");
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo15149a(String str) {
        String str2;
        try {
            String str3 = "material_data";
            if (MultiGlobalInfo.m11808b()) {
                str2 = SPMultiHelper.m11880b(m8777g(str), str3, (String) null);
            } else {
                str2 = m8776f(m8777g(str)).getString(str3, null);
            }
            return str2;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public long mo15152b(String str) {
        try {
            String str2 = "create_time";
            if (MultiGlobalInfo.m11808b()) {
                return SPMultiHelper.m11866a(m8777g(str), str2, 0);
            }
            return m8776f(m8777g(str)).getLong(str2, 0);
        } catch (Throwable unused) {
            return 0;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo15154c(String str) {
        boolean z;
        try {
            String str2 = "has_played";
            if (MultiGlobalInfo.m11808b()) {
                z = SPMultiHelper.m11877a(m8777g(str), str2, true);
            } else {
                z = m8776f(m8777g(str)).getBoolean(str2, true);
            }
            return z;
        } catch (Throwable unused) {
            return true;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo15151a(String str, String str2) {
        try {
            String str3 = "material_data";
            String str4 = "create_time";
            String str5 = "has_played";
            if (MultiGlobalInfo.m11808b()) {
                SPMultiHelper.m11870a(m8777g(str), str5, Boolean.valueOf(false));
                SPMultiHelper.m11873a(m8777g(str), str4, Long.valueOf(System.currentTimeMillis()));
                SPMultiHelper.m11874a(m8777g(str), str3, str2);
                return;
            }
            m8776f(m8777g(str)).edit().putBoolean(str5, false).putLong(str4, System.currentTimeMillis()).putString(str3, str2).apply();
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo15155d(String str) {
        try {
            if (MultiGlobalInfo.m11808b()) {
                SPMultiHelper.m11868a(m8777g(str));
            } else {
                m8776f(m8777g(str)).edit().clear().apply();
            }
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public AdSlot mo15156e(String str) {
        String str2;
        try {
            if (MultiGlobalInfo.m11808b()) {
                str2 = SPMultiHelper.m11880b(m8774c(), str, (String) null);
            } else {
                str2 = m8776f(m8774c()).getString(str, null);
            }
            return SlotUtils.m11980a(str2);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo15150a(AdSlot adSlot) {
        if (adSlot != null) {
            try {
                if (!TextUtils.isEmpty(adSlot.getCodeId())) {
                    String a = SlotUtils.m11982a(adSlot);
                    if (MultiGlobalInfo.m11808b()) {
                        SPMultiHelper.m11874a(m8774c(), adSlot.getCodeId(), a);
                    } else {
                        m8776f(m8774c()).edit().putString(adSlot.getCodeId(), a).apply();
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo15153b(AdSlot adSlot) {
        if (adSlot != null) {
            try {
                if (!TextUtils.isEmpty(adSlot.getCodeId())) {
                    String a = SlotUtils.m11982a(adSlot);
                    String str = "preload_data";
                    if (MultiGlobalInfo.m11808b()) {
                        SPMultiHelper.m11874a(m8775d(), str, a);
                    } else {
                        m8776f(m8775d()).edit().putString(str, a).apply();
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public AdSlot mo15148a() {
        String str;
        try {
            String str2 = "preload_data";
            if (MultiGlobalInfo.m11808b()) {
                str = SPMultiHelper.m11880b(m8775d(), str2, (String) null);
                SPMultiHelper.m11868a(m8775d());
            } else {
                SharedPreferences f = m8776f(m8775d());
                String string = f.getString(str2, null);
                f.edit().clear().apply();
                str = string;
            }
            return SlotUtils.m11980a(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
