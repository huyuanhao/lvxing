package com.kwad.sdk.p306a;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;

/* renamed from: com.kwad.sdk.a.b */
public class C3796b {
    /* renamed from: a */
    public static void m15732a(Context context, CharSequence charSequence, CharSequence charSequence2) {
        if (context != null && !TextUtils.isEmpty(charSequence) && !TextUtils.isEmpty(charSequence2)) {
            ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(charSequence, charSequence2));
        }
    }
}
