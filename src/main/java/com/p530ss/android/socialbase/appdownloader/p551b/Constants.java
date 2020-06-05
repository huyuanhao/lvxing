package com.p530ss.android.socialbase.appdownloader.p551b;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;

/* renamed from: com.ss.android.socialbase.appdownloader.b.a */
public class Constants {
    /* renamed from: a */
    public static final String f21502a;

    static {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(VERSION.RELEASE);
        boolean z3 = !TextUtils.isEmpty(Build.ID);
        if (!"REL".equals(VERSION.CODENAME) || TextUtils.isEmpty(Build.MODEL)) {
            z = false;
        }
        sb.append("AppDownloader");
        if (z2) {
            sb.append("/");
            sb.append(VERSION.RELEASE);
        }
        sb.append(" (Linux; U; Android");
        String str = " ";
        if (z2) {
            sb.append(str);
            sb.append(VERSION.RELEASE);
        }
        if (z || z3) {
            sb.append(";");
            if (z) {
                sb.append(str);
                sb.append(Build.MODEL);
            }
            if (z3) {
                sb.append(" Build/");
                sb.append(Build.ID);
            }
        }
        sb.append(")");
        f21502a = sb.toString();
    }
}
