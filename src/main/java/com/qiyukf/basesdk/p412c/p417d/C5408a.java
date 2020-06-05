package com.qiyukf.basesdk.p412c.p417d;

import android.content.Context;
import android.text.ClipboardManager;

/* renamed from: com.qiyukf.basesdk.c.d.a */
public final class C5408a {
    /* renamed from: a */
    public static final void m22129a(Context context, CharSequence charSequence) {
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        if (clipboardManager != null) {
            clipboardManager.setText(charSequence);
        }
    }
}
