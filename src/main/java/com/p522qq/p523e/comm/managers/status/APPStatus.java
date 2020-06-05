package com.p522qq.p523e.comm.managers.status;

import android.content.Context;
import com.p522qq.p523e.comm.util.StringUtil;

/* renamed from: com.qq.e.comm.managers.status.APPStatus */
public class APPStatus {
    /* renamed from: a */
    private String f20243a;
    /* renamed from: b */
    private Context f20244b;

    public APPStatus(String str, Context context) {
        this.f20243a = str;
        this.f20244b = context;
    }

    public String getAPPID() {
        return this.f20243a;
    }

    public String getAPPName() {
        return this.f20244b.getPackageName();
    }

    public String getAPPRealName() {
        String aPPName = getAPPName();
        if (!StringUtil.isEmpty(aPPName)) {
            try {
                return this.f20244b.getPackageManager().getPackageInfo(aPPName, 0).applicationInfo.loadLabel(this.f20244b.getPackageManager()).toString();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public String getAPPVersion() {
        String aPPName = getAPPName();
        if (!StringUtil.isEmpty(aPPName)) {
            try {
                return this.f20244b.getPackageManager().getPackageInfo(aPPName, 0).versionName;
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
