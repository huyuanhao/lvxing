package com.qiyukf.nimlib.p473h.p478b.p480b;

import android.text.TextUtils;

/* renamed from: com.qiyukf.nimlib.h.b.b.b */
public final class C5877b {
    /* renamed from: a */
    public String f18606a;
    /* renamed from: b */
    public int f18607b;

    C5877b(String str) {
        if (!TextUtils.isEmpty(str)) {
            int indexOf = str.indexOf(58);
            if (indexOf != -1) {
                this.f18606a = str.substring(0, indexOf);
                try {
                    this.f18607b = Integer.parseInt(str.substring(indexOf + 1));
                } catch (Exception unused) {
                }
                return;
            }
            this.f18606a = str;
        }
    }

    public final String toString() {
        String str;
        if (!(!TextUtils.isEmpty(this.f18606a))) {
            return "INVALID";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f18606a);
        if (this.f18607b > 0) {
            StringBuilder sb2 = new StringBuilder(":");
            sb2.append(this.f18607b);
            str = sb2.toString();
        } else {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }
}
