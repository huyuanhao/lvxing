package com.jiayouya.travel.common.p246d;

import com.tencent.android.tpush.common.MessageKey;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0005H\u0002\u001a\u000e\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0003\u001a\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003\u001a\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003\u001a\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0003\u001a\u000e\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0003\u001a\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012\u001a\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012\u001a\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002\u001a\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012\u001a\u000e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012¨\u0006\u0017"}, mo39189d2 = {"chatTime", "", "time", "", "formatTime", "", "getCountTimeByLong", "finishTime", "getHourMinute", "Lcom/jiayouya/travel/common/util/Time;", "second", "getHourMinuteSecound", "millisecond", "getMinuteSecond", "getTimeByLong", "isAm", "", "date", "Ljava/util/Date;", "isThisWeek", "isThisYear", "isToday", "isYesterday", "app_grRelease"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.common.d.o */
public final class TimeUtil {
    /* renamed from: a */
    public static final boolean m12974a(Date date) {
        C8271i.m35386b(date, MessageKey.MSG_DATE);
        Date date2 = new Date();
        return date.getYear() == date2.getYear() && date.getMonth() == date2.getMonth() && date.getDate() == date2.getDate();
    }

    /* renamed from: b */
    public static final boolean m12975b(Date date) {
        C8271i.m35386b(date, MessageKey.MSG_DATE);
        Date date2 = new Date();
        return date.getYear() == date2.getYear() && date.getMonth() == date2.getMonth() && date.getDate() + 1 == date2.getDate();
    }
}
