package com.jiayouya.travel.module.common.data;

import com.tencent.android.tpush.common.MessageKey;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0015"}, mo39189d2 = {"Lcom/jiayouya/travel/module/common/data/ServerStatus;", "", "isNormal", "", "title", "", "content", "(ZLjava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "()Z", "getTitle", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: ServerStatus.kt */
public final class ServerStatus {
    private final String content;
    private final boolean isNormal;
    private final String title;

    public static /* synthetic */ ServerStatus copy$default(ServerStatus serverStatus, boolean z, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = serverStatus.isNormal;
        }
        if ((i & 2) != 0) {
            str = serverStatus.title;
        }
        if ((i & 4) != 0) {
            str2 = serverStatus.content;
        }
        return serverStatus.copy(z, str, str2);
    }

    public final boolean component1() {
        return this.isNormal;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.content;
    }

    public final ServerStatus copy(boolean z, String str, String str2) {
        C8271i.m35386b(str, "title");
        C8271i.m35386b(str2, MessageKey.MSG_CONTENT);
        return new ServerStatus(z, str, str2);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ServerStatus) {
                ServerStatus serverStatus = (ServerStatus) obj;
                if (!(this.isNormal == serverStatus.isNormal) || !C8271i.m35384a((Object) this.title, (Object) serverStatus.title) || !C8271i.m35384a((Object) this.content, (Object) serverStatus.content)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        boolean z = this.isNormal;
        if (z) {
            z = true;
        }
        int i = z * true;
        String str = this.title;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.content;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ServerStatus(isNormal=");
        sb.append(this.isNormal);
        sb.append(", title=");
        sb.append(this.title);
        sb.append(", content=");
        sb.append(this.content);
        sb.append(")");
        return sb.toString();
    }

    public ServerStatus(boolean z, String str, String str2) {
        C8271i.m35386b(str, "title");
        C8271i.m35386b(str2, MessageKey.MSG_CONTENT);
        this.isNormal = z;
        this.title = str;
        this.content = str2;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean isNormal() {
        return this.isNormal;
    }
}
