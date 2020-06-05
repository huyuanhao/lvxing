package com.kwad.sdk.core.p317a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.kwad.sdk.core.response.model.AdConfigData.AdConfigs;
import com.kwad.sdk.p306a.C3800e;
import com.kwad.sdk.p306a.C3807j;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kwad.sdk.core.a.a */
public class C4057a {
    /* renamed from: a */
    private static volatile AdConfigs f13645a;

    /* renamed from: a */
    public static int m16818a() {
        if (f13645a == null) {
            return 1;
        }
        return f13645a.toolbarSwitch;
    }

    /* renamed from: a */
    public static void m16819a(Context context) {
        f13645a = m16826c(context);
    }

    /* renamed from: a */
    public static void m16820a(Context context, int i) {
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("ksadsdk_rep", 0);
            if (sharedPreferences != null) {
                Editor edit = sharedPreferences.edit();
                edit.putInt("reportCacheType", i);
                edit.apply();
            }
        }
    }

    /* renamed from: a */
    public static void m16821a(Context context, AdConfigs adConfigs) {
        m16824b(context, adConfigs);
    }

    /* renamed from: b */
    public static int m16822b(Context context) {
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("ksadsdk_rep", 0);
            if (sharedPreferences != null) {
                return sharedPreferences.getInt("reportCacheType", 0);
            }
        }
        return 0;
    }

    /* renamed from: b */
    public static boolean m16823b() {
        return m16818a() == 1;
    }

    /* renamed from: b */
    private static boolean m16824b(Context context, AdConfigs adConfigs) {
        if (context == null) {
            return false;
        }
        Editor edit = context.getSharedPreferences("ksadsdk_config", 0).edit();
        edit.putInt("toolbarSwitch", adConfigs.toolbarSwitch);
        edit.putInt("likeButtonSwitch", adConfigs.likeButtonSwitch);
        edit.putInt("moreButtonSwitch", adConfigs.moreButtonSwitch);
        edit.putInt("commentButtonSwitch", adConfigs.commentButtonSwitch);
        edit.putInt("seekBarSwitch", adConfigs.seekBarSwitch);
        edit.putInt("videoCacheSwitch", adConfigs.videoCacheSwitch);
        if (C3807j.m15785a((List) adConfigs.pkgNameList)) {
            edit.putString("pldat", C3800e.m15745a(adConfigs.pkgNameList).toString());
        }
        edit.putInt("reportCatch", adConfigs.batchReportCatchLimit);
        m16820a(context, adConfigs.batchReportCacheType);
        if (C3807j.m15785a((List) adConfigs.hostList)) {
            edit.putString("hostList", C3800e.m15745a(adConfigs.hostList).toString());
        }
        return edit.commit();
    }

    /* renamed from: c */
    public static int m16825c() {
        if (f13645a == null) {
            return 1;
        }
        return f13645a.likeButtonSwitch;
    }

    /* renamed from: c */
    private static AdConfigs m16826c(Context context) {
        AdConfigs adConfigs = new AdConfigs();
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("ksadsdk_config", 0);
            if (sharedPreferences != null) {
                adConfigs.toolbarSwitch = sharedPreferences.getInt("toolbarSwitch", 1);
                adConfigs.likeButtonSwitch = sharedPreferences.getInt("likeButtonSwitch", 1);
                adConfigs.moreButtonSwitch = sharedPreferences.getInt("moreButtonSwitch", 1);
                adConfigs.moreButtonSwitch = sharedPreferences.getInt("commentButtonSwitch", 1);
                adConfigs.seekBarSwitch = sharedPreferences.getInt("seekBarSwitch", 59);
                adConfigs.videoCacheSwitch = sharedPreferences.getInt("videoCacheSwitch", 0);
                String str = "";
                adConfigs.pkgNameList = C3800e.m15744a(sharedPreferences.getString("pldat", str));
                adConfigs.batchReportCatchLimit = sharedPreferences.getInt("reportCatch", 20);
                adConfigs.hostList = C3800e.m15744a(sharedPreferences.getString("hostList", str));
            }
        }
        return adConfigs;
    }

    /* renamed from: d */
    public static boolean m16827d() {
        return m16825c() == 1;
    }

    /* renamed from: e */
    public static int m16828e() {
        if (f13645a == null) {
            return 1;
        }
        return f13645a.moreButtonSwitch;
    }

    /* renamed from: f */
    public static boolean m16829f() {
        return m16828e() == 1;
    }

    /* renamed from: g */
    public static int m16830g() {
        if (f13645a == null) {
            return 1;
        }
        return f13645a.commentButtonSwitch;
    }

    /* renamed from: h */
    public static boolean m16831h() {
        return m16830g() == 1;
    }

    /* renamed from: i */
    public static int m16832i() {
        if (f13645a == null) {
            return 59;
        }
        return f13645a.seekBarSwitch;
    }

    /* renamed from: j */
    public static boolean m16833j() {
        boolean z = false;
        if (f13645a == null) {
            return false;
        }
        if (f13645a.videoCacheSwitch == 1) {
            z = true;
        }
        return z;
    }

    /* renamed from: k */
    public static List<String> m16834k() {
        return f13645a == null ? new ArrayList() : f13645a.pkgNameList;
    }

    /* renamed from: l */
    public static int m16835l() {
        if (f13645a == null) {
            return 20;
        }
        return f13645a.batchReportCatchLimit;
    }

    /* renamed from: m */
    public static List<String> m16836m() {
        return f13645a == null ? new ArrayList() : f13645a.hostList;
    }
}
