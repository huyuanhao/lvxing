package com.alipay.sdk.app;

import android.text.TextUtils;
import com.alipay.sdk.p121b.C1508a.C1509a;
import java.util.Collections;
import java.util.List;

/* renamed from: com.alipay.sdk.app.i */
public class C1502i {
    /* renamed from: a */
    public static List<C1509a> f3836a = Collections.singletonList(f3838c);
    /* renamed from: b */
    private static String f3837b = "";
    /* renamed from: c */
    private static final C1509a f3838c = new C1509a("com.eg.android.AlipayGphone", 73, "b6cbad6cbd5ed0d209afc69ad3b7a617efaae9b3c47eabe0be42d924936fa78c8001b1fd74b079e5ff9690061dacfa4768e981a526b9ca77156ca36251cf2f906d105481374998a7e6e6e18f75ca98b8ed2eaf86ff402c874cca0a263053f22237858206867d210020daa38c48b20cc9dfd82b44a51aeb5db459b22794e2d649");
    /* renamed from: d */
    private static final C1509a f3839d = new C1509a("hk.alipay.wallet", 40, "e6b1bdcb890370f2f2419fe06d0fdf7628ad0083d52da1ecfe991164711bbf9297e75353de96f1740695d07610567b1240549af9cbd87d06919ac31c859ad37ab6907c311b4756e1e208775989a4f691bff4bbbc58174d2a96b1d0d970a05114d7ee57dfc33b1bafaf6e0d820e838427018b6435f903df04ba7fd34d73f843df9434b164e0220baabb10c8978c3f4c6b7da79d8220a968356d15090dea07df9606f665cbec14d218dd3d691cce2866a58840971b6a57b76af88b1a65fdffd2c080281a6ab20be5879e0330eb7ff70871ce684e7174ada5dc3159c461375a0796b17ce7beca83cf34f65976d237aee993db48d34a4e344f4d8b7e99119168bdd7");

    /* renamed from: a */
    public static void m4435a(String str) {
        f3837b = str;
        char c = (str.hashCode() == 3331 && str.equals("hk")) ? (char) 0 : 65535;
        if (c != 0) {
            f3836a = Collections.singletonList(f3838c);
        } else {
            f3836a = Collections.singletonList(f3839d);
        }
    }

    /* renamed from: a */
    public static String m4434a() {
        return f3837b;
    }

    /* renamed from: b */
    public static boolean m4436b() {
        if (!TextUtils.isEmpty(f3837b)) {
            if (!TextUtils.equals("cn", f3837b)) {
                return false;
            }
        }
        return true;
    }
}
