package com.qiyukf.nim.uikit.common.media.picker.p423b;

import android.text.TextUtils;
import android.util.SparseArray;
import com.qiyukf.basesdk.p393a.C5264a;
import java.io.File;

/* renamed from: com.qiyukf.nim.uikit.common.media.picker.b.c */
public final class C5464c {
    /* renamed from: a */
    private static SparseArray<String> f17545a = new SparseArray<>();

    /* renamed from: a */
    public static String m22276a(int i, String str) {
        SparseArray<String> sparseArray = f17545a;
        if (sparseArray != null && sparseArray.indexOfKey(i) >= 0) {
            try {
                String str2 = (String) f17545a.get(i);
                if (!TextUtils.isEmpty(str2) && new File(str2.substring(7)).exists()) {
                    return str2;
                }
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder("thumbFilePath :");
                sb.append((String) f17545a.get(i));
                C5264a.m21621b("getThumbnailWithImageID is error", sb.toString(), e);
            }
        }
        return str;
    }

    /* renamed from: a */
    public static void m22277a() {
        f17545a.clear();
    }

    /* renamed from: a */
    public static void m22278a(Integer num, String str) {
        f17545a.put(num.intValue(), str);
    }
}
