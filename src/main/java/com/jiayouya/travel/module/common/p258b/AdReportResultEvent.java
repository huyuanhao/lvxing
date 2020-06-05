package com.jiayouya.travel.module.common.p258b;

import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, mo39189d2 = {"Lcom/jiayouya/travel/module/common/event/AdReportResultEvent;", "", "isSucceed", "", "coin", "", "logId", "", "(ZDLjava/lang/String;)V", "getCoin", "()D", "()Z", "getLogId", "()Ljava/lang/String;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.common.b.a */
public final class AdReportResultEvent {
    /* renamed from: a */
    private final boolean f11288a;
    /* renamed from: b */
    private final double f11289b;
    /* renamed from: c */
    private final String f11290c;

    public AdReportResultEvent(boolean z, double d, String str) {
        C8271i.m35386b(str, "logId");
        this.f11288a = z;
        this.f11289b = d;
        this.f11290c = str;
    }

    /* renamed from: a */
    public final boolean mo20434a() {
        return this.f11288a;
    }

    /* renamed from: b */
    public final String mo20435b() {
        return this.f11290c;
    }
}
