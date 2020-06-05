package com.p368pw.inner.base.p387d;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;
import com.pw.R;

/* renamed from: com.pw.inner.base.d.s */
public class C5211s {
    /* renamed from: a */
    public static void m21484a(final Context context, final CharSequence charSequence, final int i) {
        C5208r.m21479a(new Runnable() {
            public void run() {
                if (!TextUtils.isEmpty(charSequence)) {
                    Context context = context;
                    if (context != null) {
                        if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                            TextView textView = new TextView(context);
                            textView.setTextSize(15.0f);
                            textView.setPadding(C5191i.m21391b(context, 26), C5191i.m21391b(context, 16), C5191i.m21391b(context, 26), C5191i.m21391b(context, 16));
                            textView.setBackgroundResource(R.drawable.win_sdk_toast_bg);
                            textView.setTextColor(Color.parseColor("#ffffff"));
                            textView.setText(charSequence);
                            Toast toast = new Toast(context);
                            toast.setView(textView);
                            toast.setDuration(i);
                            toast.setGravity(17, 0, 0);
                            toast.show();
                        }
                    }
                }
            }
        });
    }
}
