package com.kwad.sdk.p306a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/* renamed from: com.kwad.sdk.a.f */
public class C3801f {
    /* renamed from: a */
    private static Handler f12915a = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private|static|volatile */
    /* renamed from: b */
    public static volatile boolean f12916b = false;

    /* renamed from: a */
    public static void m15757a(Context context, String str) {
        m15758a(context, str, "ksad_content_alliance_toast");
    }

    /* renamed from: a */
    private static void m15758a(Context context, String str, String str2) {
        if (!f12916b) {
            f12916b = true;
            View inflate = LayoutInflater.from(context).inflate(C3809l.m15792b(context, str2), null);
            ((TextView) inflate.findViewById(C3809l.m15789a(context, "ksad_message_toast_txt"))).setText(str);
            Toast toast = new Toast(context);
            toast.setGravity(17, 0, 0);
            toast.setDuration(0);
            toast.setView(inflate);
            toast.show();
            f12915a.postDelayed(new Runnable() {
                public void run() {
                    C3801f.f12916b = false;
                }
            }, 800);
        }
    }

    /* renamed from: b */
    public static void m15760b(Context context, String str) {
        m15758a(context, str, "ksad_content_alliance_toast_light");
    }
}
