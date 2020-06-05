package com.tencent.android.tpush.service.p595e;

import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.service.e.b */
public class C7049b {
    /* renamed from: a */
    public static String f23431a = "yyyyMMdd_HHmm";

    /* renamed from: a */
    public static String m30143a() {
        return new SimpleDateFormat(f23431a).format(new Date());
    }

    /* renamed from: a */
    public static Date m30144a(String str) {
        try {
            r3 = str;
            r3 = new SimpleDateFormat(f23431a).parse(str);
            r3 = r3;
            return r3;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("parse filename datetime error - ");
            sb.append(r3);
            Log.e("XGLogger", sb.toString(), e);
            return null;
        }
    }

    /* renamed from: a */
    public static boolean m30145a(Date date, int i) {
        if (date == null) {
            return false;
        }
        try {
            Calendar instance = Calendar.getInstance();
            Calendar instance2 = Calendar.getInstance();
            instance2.setTimeInMillis(date.getTime());
            instance.add(5, -i);
            return instance.after(instance2);
        } catch (Exception e) {
            Log.e("XGLogger", "DateUtils -> isDaysAgo ", e);
            return false;
        }
    }
}
