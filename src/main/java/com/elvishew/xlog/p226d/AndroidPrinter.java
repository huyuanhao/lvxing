package com.elvishew.xlog.p226d;

import android.util.Log;

/* renamed from: com.elvishew.xlog.d.a */
public class AndroidPrinter implements Printer {
    /* renamed from: a */
    private int f9459a;

    public AndroidPrinter() {
        this(4063);
    }

    public AndroidPrinter(int i) {
        this.f9459a = i;
    }

    /* renamed from: a */
    public void mo17097a(int i, String str, String str2) {
        if (str2.length() <= this.f9459a) {
            mo17098b(i, str, str2);
            return;
        }
        int length = str2.length();
        int i2 = 0;
        while (i2 < length) {
            int a = m12682a(str2, i2, Math.min(this.f9459a + i2, length));
            mo17098b(i, str, str2.substring(i2, a));
            i2 = a;
        }
    }

    /* renamed from: a */
    static int m12682a(String str, int i, int i2) {
        if (i2 == str.length() || str.charAt(i2) == 10) {
            return i2;
        }
        for (int i3 = i2 - 1; i < i3; i3--) {
            if (str.charAt(i3) == 10) {
                return i3 + 1;
            }
        }
        return i2;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo17098b(int i, String str, String str2) {
        Log.println(i, str, str2);
    }
}
