package com.p620ut.mini.p625c;

import android.text.TextUtils;
import com.p620ut.mini.UTHitBuilders.C7713b;
import java.util.Map;

/* renamed from: com.ut.mini.c.a */
public class UTOriginalCustomHitBuilder extends C7713b {
    public UTOriginalCustomHitBuilder(String str, int i, String str2, String str3, String str4, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            super.mo37427a("_field_page", str);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(i);
        super.mo37427a("_field_event_id", sb.toString());
        if (!TextUtils.isEmpty(str2)) {
            super.mo37427a("_field_arg1", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            super.mo37427a("_field_arg2", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            super.mo37427a("_field_arg3", str4);
        }
        super.mo37428a(map);
    }
}
