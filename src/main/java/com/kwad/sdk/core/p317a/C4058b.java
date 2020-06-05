package com.kwad.sdk.core.p317a;

import android.text.TextUtils;
import java.net.URI;

/* renamed from: com.kwad.sdk.core.a.b */
public class C4058b {
    /* renamed from: a */
    private static final String[] f13646a = {"gifshow.com", "kuaishou.com", "static.yximgs.com"};

    /* renamed from: a */
    public static boolean m16837a(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String host = new URI(str).getHost();
            if (m16838b(host) || m16839c(host)) {
                z = true;
            }
        } catch (Exception unused) {
        }
        return z;
    }

    /* renamed from: b */
    private static boolean m16838b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String contains : f13646a) {
            if (str.contains(contains)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    private static boolean m16839c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String contains : C4057a.m16836m()) {
            if (str.contains(contains)) {
                return true;
            }
        }
        return false;
    }
}
