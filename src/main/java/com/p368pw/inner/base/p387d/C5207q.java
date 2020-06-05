package com.p368pw.inner.base.p387d;

import android.text.TextUtils;
import com.tencent.mid.sotrage.StorageInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.pw.inner.base.d.q */
public class C5207q {
    /* renamed from: a */
    public static String m21474a(String str, String str2) {
        return TextUtils.isEmpty(str) ? str2 : str;
    }

    /* renamed from: a */
    public static List<String> m21475a(String str) {
        ArrayList arrayList = new ArrayList();
        if (m21476a((CharSequence) str)) {
            return arrayList;
        }
        String[] split = str.split(StorageInterface.KEY_SPLITER);
        return (split == null || str.length() == 0) ? arrayList : Arrays.asList(split);
    }

    /* renamed from: a */
    public static boolean m21476a(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    /* renamed from: b */
    public static String m21477b(String str) {
        if (m21476a((CharSequence) str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int i = 0;
        while (i < length) {
            if (str.charAt(i) == '\\' && i < length - 5) {
                int i2 = i + 1;
                if (str.charAt(i2) == 'u' || str.charAt(i2) == 'U') {
                    try {
                        sb.append((char) Integer.parseInt(str.substring(i + 2, i + 6), 16));
                        i += 5;
                    } catch (NumberFormatException unused) {
                    }
                    i++;
                }
            }
            sb.append(str.charAt(i));
            i++;
        }
        return sb.toString();
    }

    /* renamed from: b */
    public static boolean m21478b(CharSequence charSequence) {
        return !m21476a(charSequence);
    }
}
