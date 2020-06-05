package com.qiyukf.unicorn.p513g;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.qiyukf.basesdk.p412c.C5407d;
import com.qiyukf.nimlib.C5718b;
import com.qiyukf.unicorn.api.SavePowerConfig;

/* renamed from: com.qiyukf.unicorn.g.d */
public final class C6177d {
    /* renamed from: a */
    private SharedPreferences f19290a;

    private C6177d(Context context, String str) {
        StringBuilder sb = new StringBuilder("qiyu_save_");
        sb.append(str);
        this.f19290a = context.getSharedPreferences(sb.toString(), 0);
    }

    /* renamed from: a */
    public static C6177d m24495a() {
        return new C6177d(C5718b.m23009a(), C5718b.m23020g());
    }

    /* renamed from: a */
    public final void mo29244a(int i) {
        C5407d.m22125a(this.f19290a, "saver_mode", i);
    }

    /* renamed from: a */
    public final void mo29245a(long j) {
        C5407d.m22126a(this.f19290a, "last_session_time", j);
    }

    /* renamed from: a */
    public final void mo29246a(SavePowerConfig savePowerConfig) {
        int i;
        Editor editor;
        String str = "check_interval";
        String str2 = "saver_delay";
        if (savePowerConfig == null) {
            editor = this.f19290a.edit().putLong(str2, -1).putLong(str, -1);
        } else {
            editor = this.f19290a.edit().putLong(str2, savePowerConfig.activeDelay).putLong(str, savePowerConfig.checkInterval);
            if (savePowerConfig.customPush) {
                i = 1;
                C5407d.m22124a(editor.putInt("smp_cp", i));
            }
        }
        i = 0;
        C5407d.m22124a(editor.putInt("smp_cp", i));
    }

    /* renamed from: a */
    public final void mo29247a(boolean z) {
        C5407d.m22128a(this.f19290a, "YSF_PUSH_TOGGLE", z);
    }

    /* renamed from: b */
    public final void mo29248b() {
        C5407d.m22124a(this.f19290a.edit().clear());
    }

    /* renamed from: b */
    public final void mo29249b(long j) {
        C5407d.m22126a(this.f19290a, "last_check_time", j);
    }

    /* renamed from: c */
    public final long mo29250c() {
        String str = "last_session_time";
        if (!this.f19290a.contains(str)) {
            mo29245a(System.currentTimeMillis());
        }
        return this.f19290a.getLong(str, System.currentTimeMillis());
    }

    /* renamed from: c */
    public final void mo29251c(long j) {
        C5407d.m22126a(this.f19290a, "k_latest_msg", j);
    }

    /* renamed from: d */
    public final long mo29252d() {
        return this.f19290a.getLong("last_check_time", System.currentTimeMillis());
    }

    /* renamed from: d */
    public final void mo29253d(long j) {
        C5407d.m22126a(this.f19290a, "ysf_visitor", j);
    }

    /* renamed from: e */
    public final int mo29254e() {
        return this.f19290a.getInt("saver_mode", 0);
    }

    /* renamed from: e */
    public final void mo29255e(long j) {
        C5407d.m22126a(this.f19290a, "ysf_pkg", j);
    }

    /* renamed from: f */
    public final SavePowerConfig mo29256f() {
        long j = this.f19290a.getLong("saver_delay", -1);
        long j2 = this.f19290a.getLong("check_interval", -1);
        int i = this.f19290a.getInt("smp_cp", 0);
        if (j < 0 || j2 < 0) {
            return null;
        }
        SavePowerConfig savePowerConfig = new SavePowerConfig(i == 1, j, j2);
        return savePowerConfig;
    }

    /* renamed from: g */
    public final boolean mo29257g() {
        return this.f19290a.getLong("saver_delay", -1) > 0 && this.f19290a.getLong("check_interval", -1) > 0;
    }

    /* renamed from: h */
    public final long mo29258h() {
        return this.f19290a.getLong("k_latest_msg", 0);
    }

    /* renamed from: i */
    public final boolean mo29259i() {
        return this.f19290a.getBoolean("YSF_PUSH_TOGGLE", false);
    }

    /* renamed from: j */
    public final long mo29260j() {
        return this.f19290a.getLong("ysf_visitor", 0);
    }

    /* renamed from: k */
    public final long mo29261k() {
        return this.f19290a.getLong("ysf_pkg", 0);
    }
}
