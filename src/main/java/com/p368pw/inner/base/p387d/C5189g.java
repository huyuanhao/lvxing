package com.p368pw.inner.base.p387d;

import java.util.Calendar;
import java.util.Date;

/* renamed from: com.pw.inner.base.d.g */
public class C5189g {
    /* renamed from: a */
    public static boolean m21380a(Date date, Date date2) {
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance.setTime(date);
        instance2.setTime(date2);
        return instance.get(1) == instance2.get(1) && instance.get(6) == instance2.get(6);
    }
}
