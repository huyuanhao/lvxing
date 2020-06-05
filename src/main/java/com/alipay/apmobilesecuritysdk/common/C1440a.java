package com.alipay.apmobilesecuritysdk.common;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.p107e.C1453h;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* renamed from: com.alipay.apmobilesecuritysdk.common.a */
public final class C1440a {
    /* renamed from: a */
    public static boolean m4171a(Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(C1453h.m4223e(context));
        return m4172a((List<String>) arrayList) || m4172a((List<String>) new RushTimeUtil$1<String>());
    }

    /* renamed from: a */
    private static boolean m4172a(List<String> list) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setLenient(false);
        int random = ((int) (Math.random() * 24.0d * 60.0d * 60.0d)) * 1;
        try {
            for (String split : list) {
                String[] split2 = split.split("&");
                if (split2 != null && split2.length == 2) {
                    Date date = new Date();
                    StringBuilder sb = new StringBuilder();
                    sb.append(split2[0]);
                    sb.append(" 00:00:00");
                    Date parse = simpleDateFormat.parse(sb.toString());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(split2[1]);
                    sb2.append(" 23:59:59");
                    Date parse2 = simpleDateFormat.parse(sb2.toString());
                    Calendar instance = Calendar.getInstance();
                    instance.setTime(parse2);
                    instance.add(13, random);
                    Date time = instance.getTime();
                    if (date.after(parse) && date.before(time)) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
