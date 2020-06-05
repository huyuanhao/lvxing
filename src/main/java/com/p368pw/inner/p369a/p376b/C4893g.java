package com.p368pw.inner.p369a.p376b;

import com.p368pw.p392us.Setting;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.pw.inner.a.b.g */
public class C4893g {
    /* renamed from: a */
    private static final Map<Integer, SoftReference<Setting>> f15817a = new HashMap();

    /* renamed from: a */
    public static int m20176a(Setting setting) {
        int identityHashCode = System.identityHashCode(setting);
        f15817a.put(Integer.valueOf(identityHashCode), new SoftReference(setting));
        return identityHashCode;
    }

    /* renamed from: a */
    public static Setting m20177a(int i) {
        SoftReference softReference = (SoftReference) f15817a.remove(Integer.valueOf(i));
        if (softReference == null) {
            return null;
        }
        return (Setting) softReference.get();
    }
}
