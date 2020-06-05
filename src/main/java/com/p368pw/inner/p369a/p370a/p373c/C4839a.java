package com.p368pw.inner.p369a.p370a.p373c;

import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.base.p387d.C5207q;
import com.p522qq.p523e.ads.nativ.NativeUnifiedADDataAdapter;
import com.tencent.p605ep.shanhuad.adpublic.models.AdMetaInfo;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.pw.inner.a.a.c.a */
public class C4839a {
    /* renamed from: a */
    private static final Map<Integer, String> f15597a = new HashMap();
    /* renamed from: b */
    private static final Map<Integer, String> f15598b = new HashMap();

    /* renamed from: a */
    public static String m19864a(int i) {
        String str = "";
        return (i != -1 && f15598b.containsKey(Integer.valueOf(i))) ? (String) f15598b.get(Integer.valueOf(i)) : str;
    }

    /* renamed from: a */
    public static String m19865a(AdMetaInfo adMetaInfo) {
        return adMetaInfo.getAdDisplayModel() == null ? "" : adMetaInfo.getAdDisplayModel().uniqueKey;
    }

    /* renamed from: a */
    public static void m19866a(AdMetaInfo adMetaInfo, String str) {
        if (adMetaInfo.getAdDisplayModel() == null) {
            if (C5207q.m21476a((CharSequence) str)) {
                f15597a.remove(Integer.valueOf(System.identityHashCode(adMetaInfo)));
            } else {
                f15597a.put(Integer.valueOf(System.identityHashCode(adMetaInfo)), str);
            }
            return;
        }
        adMetaInfo.getAdDisplayModel().videoUrl = str;
    }

    /* renamed from: b */
    public static String m19867b(AdMetaInfo adMetaInfo) {
        String str = adMetaInfo.getAdDisplayModel() == null ? "" : adMetaInfo.getAdDisplayModel().videoUrl;
        return C5207q.m21476a((CharSequence) str) ? (String) f15597a.get(Integer.valueOf(System.identityHashCode(adMetaInfo))) : str;
    }

    /* renamed from: b */
    public static void m19868b(AdMetaInfo adMetaInfo, String str) {
        if (adMetaInfo != null) {
            if (C5207q.m21476a((CharSequence) adMetaInfo.getPackageName()) && C5207q.m21476a((CharSequence) str)) {
                str = m19871e(adMetaInfo);
            }
            Map<Integer, String> map = f15598b;
            Integer valueOf = Integer.valueOf(System.identityHashCode(adMetaInfo));
            if (C5207q.m21478b((CharSequence) adMetaInfo.getPackageName())) {
                str = adMetaInfo.getPackageName();
            }
            map.put(valueOf, str);
        }
    }

    /* renamed from: c */
    public static String m19869c(AdMetaInfo adMetaInfo) {
        return adMetaInfo.getAdDisplayModel() == null ? "" : adMetaInfo.getAdDisplayModel().jumpUrl;
    }

    /* renamed from: d */
    public static String m19870d(AdMetaInfo adMetaInfo) {
        return adMetaInfo == null ? "" : C5207q.m21478b((CharSequence) adMetaInfo.getPackageName()) ? adMetaInfo.getPackageName() : m19864a(System.identityHashCode(adMetaInfo));
    }

    /* renamed from: e */
    private static String m19871e(AdMetaInfo adMetaInfo) {
        if (adMetaInfo == null || C5207q.m21478b((CharSequence) adMetaInfo.getPackageName()) || adMetaInfo.mNativeUnifiedADData == null) {
            return null;
        }
        try {
            Field declaredField = NativeUnifiedADDataAdapter.class.getDeclaredField("a");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(adMetaInfo.mNativeUnifiedADData);
            if (obj == null) {
                return null;
            }
            Field declaredField2 = obj.getClass().getDeclaredField("c");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            if (obj2 == null) {
                return null;
            }
            Field declaredField3 = obj2.getClass().getDeclaredField("M");
            declaredField3.setAccessible(true);
            String str = (String) declaredField3.get(obj2);
            if (C5207q.m21478b((CharSequence) str)) {
                StringBuilder sb = new StringBuilder();
                sb.append("反射获取包名成功：");
                sb.append(str);
                C5205o.m21462a(sb.toString());
                return str;
            }
            C5205o.m21462a("反射获取包名失败");
            return null;
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }
}
