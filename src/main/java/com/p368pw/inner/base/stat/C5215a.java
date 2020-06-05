package com.p368pw.inner.base.stat;

import android.content.Context;
import android.text.TextUtils;
import com.p368pw.inner.base.p387d.C5191i;
import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.base.p387d.C5206p;
import com.tencent.mid.sotrage.StorageInterface;
import java.util.Collections;
import java.util.List;

/* renamed from: com.pw.inner.base.stat.a */
public class C5215a {
    /* renamed from: a */
    private String f16941a;

    /* renamed from: com.pw.inner.base.stat.a$a */
    private static class C5217a {
        /* access modifiers changed from: private|static */
        /* renamed from: a */
        public static C5215a f16942a = new C5215a();
    }

    private C5215a() {
        this.f16941a = "";
    }

    /* renamed from: a */
    public static C5215a m21489a() {
        return C5217a.f16942a;
    }

    /* renamed from: a */
    public String mo26887a(Context context) {
        List<String> B = C5191i.m21382B(context);
        String str = "";
        if (B == null || B.isEmpty()) {
            return str;
        }
        Collections.sort(B);
        StringBuilder sb = new StringBuilder();
        for (String append : B) {
            sb.append(append);
            sb.append(StorageInterface.KEY_SPLITER);
        }
        sb.deleteCharAt(sb.length() - 1);
        String b = C5191i.m21395b(sb.toString());
        synchronized (this) {
            if (TextUtils.isEmpty(this.f16941a)) {
                this.f16941a = C5206p.m21472b(context, "key_i_l_m");
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(b);
            sb2.append(" ");
            sb2.append(this.f16941a);
            C5205o.m21462a(sb2.toString());
            if (b.equals(this.f16941a)) {
                return str;
            }
            String sb3 = sb.toString();
            this.f16941a = b;
            C5206p.m21471a(context, "key_i_l_m", b);
            return sb3;
        }
    }
}
