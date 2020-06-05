package com.kwad.sdk.core.videocache.p343a;

import android.text.TextUtils;
import com.kwad.sdk.core.videocache.C4366l;

/* renamed from: com.kwad.sdk.core.videocache.a.f */
public class C4341f implements C4335c {
    /* renamed from: b */
    private String m17741b(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return (lastIndexOf == -1 || lastIndexOf <= str.lastIndexOf(47) || lastIndexOf + 2 + 4 <= str.length()) ? "" : str.substring(lastIndexOf + 1, str.length());
    }

    /* renamed from: a */
    public String mo24489a(String str) {
        String b = m17741b(str);
        String d = C4366l.m17830d(str);
        if (TextUtils.isEmpty(b)) {
            return d;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(d);
        sb.append(".");
        sb.append(b);
        return sb.toString();
    }
}
