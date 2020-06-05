package com.p530ss.android.socialbase.appdownloader;

import android.content.Context;
import com.p530ss.android.socialbase.downloader.downloader.C6694b;
import com.tencent.android.tpush.SettingsContentProvider;

/* renamed from: com.ss.android.socialbase.appdownloader.k */
public class ResourceUtils {
    /* renamed from: a */
    public static int m26945a(String str) {
        try {
            return C6694b.m27342B().getResources().getIdentifier(str, "layout", C6694b.m27342B().getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: a */
    public static int m26944a(Context context, String str) {
        try {
            return context.getResources().getIdentifier(str, SettingsContentProvider.STRING_TYPE, context.getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: b */
    public static int m26947b(String str) {
        return m26944a(C6694b.m27342B(), str);
    }

    /* renamed from: a */
    public static int m26946a(String str, String str2) {
        try {
            return C6694b.m27342B().getResources().getIdentifier(str, "drawable", str2);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: c */
    public static int m26949c(String str) {
        try {
            return C6694b.m27342B().getResources().getIdentifier(str, "style", C6694b.m27342B().getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: d */
    public static int m26950d(String str) {
        try {
            return C6694b.m27342B().getResources().getIdentifier(str, "id", C6694b.m27342B().getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: e */
    public static int m26951e(String str) {
        try {
            return C6694b.m27342B().getResources().getIdentifier(str, "color", C6694b.m27342B().getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: b */
    public static int m26948b(String str, String str2) {
        try {
            return C6694b.m27342B().getResources().getIdentifier(str, "attr", str2);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
