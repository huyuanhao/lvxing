package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.sdk.openadsdk.multipro.MultiGlobalInfo;
import com.bytedance.sdk.openadsdk.multipro.p205d.SPMultiHelper;

/* renamed from: com.bytedance.sdk.openadsdk.core.d */
public class AdPreference {
    /* renamed from: a */
    private static volatile AdPreference f7313a;
    /* renamed from: b */
    private final SharedPreferences f7314b;

    private AdPreference(Context context) {
        this.f7314b = context.getSharedPreferences("ttopenadsdk", 0);
    }

    /* renamed from: a */
    public static AdPreference m9212a(Context context) {
        if (f7313a == null) {
            synchronized (AdPreference.class) {
                if (f7313a == null) {
                    f7313a = new AdPreference(context);
                }
            }
        }
        return f7313a;
    }

    /* renamed from: a */
    public void mo15322a(String str, String str2) {
        if (MultiGlobalInfo.m11808b()) {
            SPMultiHelper.m11874a("ttopenadsdk", str, str2);
        } else {
            this.f7314b.edit().putString(str, str2).apply();
        }
    }

    /* renamed from: b */
    public String mo15327b(String str, String str2) {
        if (MultiGlobalInfo.m11808b()) {
            return SPMultiHelper.m11880b("ttopenadsdk", str, str2);
        }
        return this.f7314b.getString(str, str2);
    }

    /* renamed from: a */
    public void mo15320a(String str, int i) {
        if (MultiGlobalInfo.m11808b()) {
            SPMultiHelper.m11872a("ttopenadsdk", str, Integer.valueOf(i));
            return;
        }
        this.f7314b.edit().putInt(str, i).apply();
    }

    /* renamed from: b */
    public int mo15325b(String str, int i) {
        if (MultiGlobalInfo.m11808b()) {
            return SPMultiHelper.m11865a("ttopenadsdk", str, i);
        }
        return this.f7314b.getInt(str, i);
    }

    /* renamed from: a */
    public void mo15323a(String str, boolean z) {
        if (MultiGlobalInfo.m11808b()) {
            SPMultiHelper.m11870a("ttopenadsdk", str, Boolean.valueOf(z));
            return;
        }
        this.f7314b.edit().putBoolean(str, z).apply();
    }

    /* renamed from: b */
    public boolean mo15328b(String str, boolean z) {
        if (MultiGlobalInfo.m11808b()) {
            return SPMultiHelper.m11877a("ttopenadsdk", str, z);
        }
        return this.f7314b.getBoolean(str, z);
    }

    /* renamed from: a */
    public void mo15321a(String str, long j) {
        if (MultiGlobalInfo.m11808b()) {
            SPMultiHelper.m11873a("ttopenadsdk", str, Long.valueOf(j));
            return;
        }
        this.f7314b.edit().putLong(str, j).apply();
    }

    /* renamed from: b */
    public Long mo15326b(String str, long j) {
        long j2;
        if (MultiGlobalInfo.m11808b()) {
            j2 = SPMultiHelper.m11866a("ttopenadsdk", str, j);
        } else {
            j2 = this.f7314b.getLong(str, j);
        }
        return Long.valueOf(j2);
    }

    /* renamed from: a */
    public void mo15319a(String str, float f) {
        if (MultiGlobalInfo.m11808b()) {
            SPMultiHelper.m11871a("ttopenadsdk", str, Float.valueOf(f));
            return;
        }
        this.f7314b.edit().putFloat(str, f).apply();
    }

    /* renamed from: b */
    public float mo15324b(String str, float f) {
        if (MultiGlobalInfo.m11808b()) {
            return SPMultiHelper.m11864a("ttopenadsdk", str, f);
        }
        return this.f7314b.getFloat(str, f);
    }
}
