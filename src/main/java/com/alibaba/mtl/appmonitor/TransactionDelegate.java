package com.alibaba.mtl.appmonitor;

import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.p068a.EventRepo;
import com.alibaba.mtl.appmonitor.p068a.EventType;
import com.alibaba.mtl.appmonitor.p069b.ExceptionEventBuilder;
import com.alibaba.mtl.appmonitor.p071d.SampleRules;
import com.alibaba.mtl.log.p077d.Logger;

/* renamed from: com.alibaba.mtl.appmonitor.f */
public class TransactionDelegate {
    /* renamed from: a */
    public static void m3586a(Transaction transaction, String str) {
        String str2 = " measureName: ";
        String str3 = " monitorPoint: ";
        String str4 = "TransactionDelegate";
        try {
            if (AppMonitorDelegate.f3188b && transaction != null) {
                Logger.m3833a(str4, "statEvent begin. module: ", transaction.f3088b, str3, transaction.f3089c, str2, str);
                if (!EventType.STAT.isOpen() || (!AppMonitorDelegate.f3187a && !SampleRules.m3573a(EventType.STAT, transaction.f3088b, transaction.f3089c))) {
                    Logger.m3833a(str4, "log discard", transaction.f3088b, str3, transaction.f3089c, str2, str);
                } else {
                    EventRepo.m3324a().mo11562a(transaction.f3091e, transaction.f3087a, transaction.f3088b, transaction.f3089c, str);
                    m3585a(transaction);
                }
            }
        } catch (Throwable th) {
            ExceptionEventBuilder.m3405a(th);
        }
    }

    /* renamed from: a */
    private static void m3585a(Transaction transaction) {
        if (!(transaction == null || transaction.f3090d == null)) {
            EventRepo.m3324a().mo11561a(transaction.f3091e, transaction.f3087a, transaction.f3088b, transaction.f3089c, DimensionValueSet.m3615a().mo11684a(transaction.f3090d));
        }
    }

    /* renamed from: b */
    public static void m3587b(Transaction transaction, String str) {
        String str2 = " measureName: ";
        String str3 = " monitorPoint: ";
        String str4 = "TransactionDelegate";
        try {
            if (AppMonitorDelegate.f3188b && transaction != null) {
                Logger.m3833a(str4, "statEvent end. module: ", transaction.f3088b, str3, transaction.f3089c, str2, str);
                if (!EventType.STAT.isOpen() || (!AppMonitorDelegate.f3187a && !SampleRules.m3573a(EventType.STAT, transaction.f3088b, transaction.f3089c))) {
                    Logger.m3833a(str4, "log discard", transaction.f3088b, str3, transaction.f3089c, str2, str);
                } else {
                    m3585a(transaction);
                    EventRepo.m3324a().mo11564a(transaction.f3091e, str, false, transaction.f3092f);
                }
            }
        } catch (Throwable th) {
            ExceptionEventBuilder.m3405a(th);
        }
    }
}
