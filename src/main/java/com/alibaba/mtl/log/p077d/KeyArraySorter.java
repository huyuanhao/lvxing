package com.alibaba.mtl.log.p077d;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Comparator;

/* renamed from: com.alibaba.mtl.log.d.g */
public class KeyArraySorter {
    /* renamed from: a */
    private static KeyArraySorter f3399a = new KeyArraySorter();
    /* renamed from: b */
    private C1322b f3400b = new C1322b();
    /* renamed from: c */
    private C1321a f3401c = new C1321a();

    /* compiled from: KeyArraySorter */
    /* renamed from: com.alibaba.mtl.log.d.g$a */
    private class C1321a implements Comparator<String> {
        private C1321a() {
        }

        /* renamed from: a */
        public int compare(String str, String str2) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return 0;
            }
            return str.compareTo(str2);
        }
    }

    /* compiled from: KeyArraySorter */
    /* renamed from: com.alibaba.mtl.log.d.g$b */
    private class C1322b implements Comparator<String> {
        private C1322b() {
        }

        /* renamed from: a */
        public int compare(String str, String str2) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return 0;
            }
            return str.compareTo(str2) * -1;
        }
    }

    private KeyArraySorter() {
    }

    /* renamed from: a */
    public static KeyArraySorter m3821a() {
        return f3399a;
    }

    /* renamed from: a */
    public String[] mo11801a(String[] strArr, boolean z) {
        Comparator comparator;
        if (z) {
            comparator = this.f3401c;
        } else {
            comparator = this.f3400b;
        }
        if (comparator == null || strArr == null || strArr.length <= 0) {
            return null;
        }
        Arrays.sort(strArr, comparator);
        return strArr;
    }
}
