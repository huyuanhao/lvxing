package com.jiayouya.travel.module.assets.data;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, mo39189d2 = {"Lcom/jiayouya/travel/module/assets/data/LogsItem;", "", "title", "", "time", "(Ljava/lang/String;Ljava/lang/String;)V", "getTime", "()Ljava/lang/String;", "getTitle", "value", "getValue", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: LogsItem.kt */
public final class LogsItem {
    private final String time;
    private final String title;
    @SerializedName(alternate = {"desc"}, value = "value")
    private final String value;

    public LogsItem(String str, String str2) {
        C8271i.m35386b(str, "title");
        C8271i.m35386b(str2, "time");
        this.title = str;
        this.time = str2;
    }

    public final String getTime() {
        return this.time;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getValue() {
        return this.value;
    }
}
