package com.jiayouya.travel.module.p293ws.data;

import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, mo39189d2 = {"Lcom/jiayouya/travel/module/ws/data/RespPacket;", "Type", "", "()V", "api", "", "getApi", "()Ljava/lang/String;", "setApi", "(Ljava/lang/String;)V", "data", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: RespPacket.kt */
/* renamed from: com.jiayouya.travel.module.ws.data.RespPacket */
public final class RespPacket<Type> {
    private String api = "";
    private Type data;

    public final String getApi() {
        return this.api;
    }

    public final void setApi(String str) {
        C8271i.m35386b(str, "<set-?>");
        this.api = str;
    }

    public final Type getData() {
        return this.data;
    }

    public final void setData(Type type) {
        this.data = type;
    }
}
