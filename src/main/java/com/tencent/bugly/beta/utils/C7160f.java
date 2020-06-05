package com.tencent.bugly.beta.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.beta.utils.f */
public class C7160f {
    /* renamed from: a */
    private static Toast f23905a;

    /* renamed from: a */
    public static void m30684a(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            Toast toast = f23905a;
            if (toast == null) {
                f23905a = Toast.makeText(context, str, 0);
            } else {
                toast.setText(str);
            }
            f23905a.show();
        }
    }
}
