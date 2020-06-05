package com.p368pw;

import android.app.Activity;
import android.app.Application;
import com.p368pw.inner.C5229d;
import com.p368pw.inner.C5233e;
import com.p368pw.p392us.Setting;

/* renamed from: com.pw.WinLib */
public class WinLib {
    public static void init(Application application, String str, String str2) {
        C5233e.m21558a().mo26925a(application, str, str2);
    }

    @Deprecated
    public static void load(Activity activity, Setting setting) {
        C5229d.m21541a().mo26920b(setting);
    }

    public static void load(Setting setting) {
        C5229d.m21541a().mo26920b(setting);
    }

    @Deprecated
    public static void regView(Activity activity, Setting setting) {
        C5229d.m21541a().mo26923d(setting);
    }

    public static void regView(Setting setting) {
        C5229d.m21541a().mo26923d(setting);
    }

    public static void setDebug(boolean z) {
        C5233e.m21558a().mo26926a(z);
    }

    public static void setTestMode(boolean z) {
        C5233e.m21558a().mo26927b(z);
    }

    @Deprecated
    public static void show(Activity activity, Setting setting) {
        C5229d.m21541a().mo26922c(setting);
    }

    public static void show(Setting setting) {
        C5229d.m21541a().mo26922c(setting);
    }
}
