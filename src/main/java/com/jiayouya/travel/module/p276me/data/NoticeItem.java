package com.jiayouya.travel.module.p276me.data;

import androidx.core.app.NotificationCompat;
import com.tencent.android.tpush.common.MessageKey;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/data/NoticeItem;", "", "id", "", "title", "route", "status", "content", "time", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getId", "getRoute", "getStatus", "getTime", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: NoticeItem.kt */
/* renamed from: com.jiayouya.travel.module.me.data.NoticeItem */
public final class NoticeItem {
    private final String content;
    /* renamed from: id */
    private final String f11568id;
    private final String route;
    private final String status;
    private final String time;
    private final String title;

    public static /* synthetic */ NoticeItem copy$default(NoticeItem noticeItem, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = noticeItem.f11568id;
        }
        if ((i & 2) != 0) {
            str2 = noticeItem.title;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = noticeItem.route;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = noticeItem.status;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = noticeItem.content;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = noticeItem.time;
        }
        return noticeItem.copy(str, str7, str8, str9, str10, str6);
    }

    public final String component1() {
        return this.f11568id;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.route;
    }

    public final String component4() {
        return this.status;
    }

    public final String component5() {
        return this.content;
    }

    public final String component6() {
        return this.time;
    }

    public final NoticeItem copy(String str, String str2, String str3, String str4, String str5, String str6) {
        C8271i.m35386b(str, "id");
        C8271i.m35386b(str2, "title");
        C8271i.m35386b(str3, "route");
        C8271i.m35386b(str4, NotificationCompat.CATEGORY_STATUS);
        C8271i.m35386b(str5, MessageKey.MSG_CONTENT);
        C8271i.m35386b(str6, "time");
        NoticeItem noticeItem = new NoticeItem(str, str2, str3, str4, str5, str6);
        return noticeItem;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0042, code lost:
            if (kotlin.jvm.internal.C8271i.m35384a((java.lang.Object) r2.time, (java.lang.Object) r3.time) != false) goto L_0x0047;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x0047
        boolean r0 = r3 instanceof com.jiayouya.travel.module.p276me.data.NoticeItem
        if (r0 == 0) goto L_0x0045
        com.jiayouya.travel.module.me.data.NoticeItem r3 = (com.jiayouya.travel.module.p276me.data.NoticeItem) r3
        java.lang.String r0 = r2.f11568id
        java.lang.String r1 = r3.f11568id
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x0045
        java.lang.String r0 = r2.title
        java.lang.String r1 = r3.title
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x0045
        java.lang.String r0 = r2.route
        java.lang.String r1 = r3.route
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x0045
        java.lang.String r0 = r2.status
        java.lang.String r1 = r3.status
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x0045
        java.lang.String r0 = r2.content
        java.lang.String r1 = r3.content
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x0045
        java.lang.String r0 = r2.time
        java.lang.String r3 = r3.time
        boolean r3 = kotlin.jvm.internal.C8271i.m35384a(r0, r3)
        if (r3 == 0) goto L_0x0045
        goto L_0x0047
    L_0x0045:
        r3 = 0
        return r3
    L_0x0047:
        r3 = 1
        return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.p276me.data.NoticeItem.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.f11568id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.route;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.status;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.content;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.time;
        if (str6 != null) {
            i = str6.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NoticeItem(id=");
        sb.append(this.f11568id);
        sb.append(", title=");
        sb.append(this.title);
        sb.append(", route=");
        sb.append(this.route);
        sb.append(", status=");
        sb.append(this.status);
        sb.append(", content=");
        sb.append(this.content);
        sb.append(", time=");
        sb.append(this.time);
        sb.append(")");
        return sb.toString();
    }

    public NoticeItem(String str, String str2, String str3, String str4, String str5, String str6) {
        C8271i.m35386b(str, "id");
        C8271i.m35386b(str2, "title");
        C8271i.m35386b(str3, "route");
        C8271i.m35386b(str4, NotificationCompat.CATEGORY_STATUS);
        C8271i.m35386b(str5, MessageKey.MSG_CONTENT);
        C8271i.m35386b(str6, "time");
        this.f11568id = str;
        this.title = str2;
        this.route = str3;
        this.status = str4;
        this.content = str5;
        this.time = str6;
    }

    public final String getId() {
        return this.f11568id;
    }

    public final String getRoute() {
        return this.route;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getTime() {
        return this.time;
    }
}
