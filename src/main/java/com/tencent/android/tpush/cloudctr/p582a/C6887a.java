package com.tencent.android.tpush.cloudctr.p582a;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.tencent.android.tpush.p580b.C6864a;
import java.io.File;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.cloudctr.a.a */
public class C6887a {
    /* renamed from: a */
    private static String f22947a = "CloudControlCacheMgr";
    /* renamed from: b */
    private Map<String, String> f22948b = new ConcurrentHashMap();

    /* renamed from: a */
    private static String m29408a(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getPackageName());
        sb.append(".mta.cloudctr");
        return sb.toString();
    }

    /* renamed from: a */
    private static String m29409a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(".ver");
        return sb.toString();
    }

    /* renamed from: b */
    private static String m29410b(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(".downloadJson");
        return sb.toString();
    }

    /* renamed from: b */
    private static String m29411b(String str, long j) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(j));
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: c */
    private static void m29412c(String str) {
        File file = new File(str);
        boolean exists = file.exists();
        if (exists && !file.isDirectory()) {
            file.delete();
            exists = false;
        }
        if (!exists) {
            file.mkdir();
        }
    }

    /* renamed from: a */
    public void mo33073a(String str, String str2) {
        StringBuilder sb;
        if (this.f22948b.containsKey(str)) {
            String str3 = f22947a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(" 业务已有 cacheDir, 这次设置无效");
            C6864a.m29308i(str3, sb2.toString());
        } else if (str2 == null) {
            String str4 = f22947a;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append(" 业务 cacheDir 为空");
            C6864a.m29308i(str4, sb3.toString());
        } else {
            if (str2.endsWith(File.separator)) {
                sb = new StringBuilder();
                sb.append(str2);
            } else {
                sb = new StringBuilder();
                sb.append(str2);
                sb.append(File.separator);
            }
            sb.append(str);
            m29412c(sb.toString());
            this.f22948b.put(str, str2);
        }
    }

    /* renamed from: a */
    public long mo33067a(Context context, String str) {
        return context.getSharedPreferences(m29408a(context), 0).getLong(m29409a(str), 0);
    }

    /* renamed from: a */
    public void mo33071a(Context context, String str, long j, boolean z) {
        if (((String) this.f22948b.get(str)) != null) {
            long a = mo33067a(context, str);
            if (a != j) {
                Editor edit = context.getSharedPreferences(m29408a(context), 0).edit();
                edit.putLong(m29409a(str), j);
                edit.commit();
                if (z) {
                    String a2 = mo33068a(str, a);
                    if (a2 != null) {
                        new File(a2).delete();
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public void mo33072a(Context context, String str, String str2) {
        String b = m29410b(str);
        Editor edit = context.getSharedPreferences(m29408a(context), 0).edit();
        edit.putString(b, str2);
        edit.commit();
    }

    /* renamed from: b */
    public void mo33074b(Context context, String str) {
        String b = m29410b(str);
        Editor edit = context.getSharedPreferences(m29408a(context), 0).edit();
        edit.remove(b);
        edit.commit();
    }

    /* renamed from: c */
    public String mo33075c(Context context, String str) {
        return context.getSharedPreferences(m29408a(context), 0).getString(m29410b(str), null);
    }

    /* renamed from: d */
    public String mo33076d(Context context, String str) {
        return mo33068a(str, mo33067a(context, str));
    }

    /* renamed from: a */
    public String mo33068a(String str, long j) {
        String str2 = (String) this.f22948b.get(str);
        if (str2 == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(File.separator);
        sb.append(str);
        sb.append(File.separator);
        sb.append(String.valueOf(j));
        sb.append(File.separator);
        String sb2 = sb.toString();
        File file = new File(sb2);
        boolean exists = file.exists();
        if (exists && !file.isDirectory()) {
            file.delete();
            exists = false;
        }
        if (!exists) {
            file.mkdir();
        }
        return sb2;
    }

    /* renamed from: a */
    public Date mo33069a(Context context, String str, long j) {
        long j2 = context.getSharedPreferences(m29408a(context), 0).getLong(m29411b(str, j), 0);
        if (j2 == 0) {
            return null;
        }
        return new Date(j2);
    }

    /* renamed from: a */
    public void mo33070a(Context context, String str, long j, Date date) {
        long time = date.getTime();
        Editor edit = context.getSharedPreferences(m29408a(context), 0).edit();
        edit.putLong(m29411b(str, j), time);
        edit.commit();
    }
}
