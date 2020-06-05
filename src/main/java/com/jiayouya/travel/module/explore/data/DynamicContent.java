package com.jiayouya.travel.module.explore.data;

import android.text.TextUtils;
import com.jiayouya.travel.common.p246d.TimeUtil;
import ezy.assist.p648c.DateTime;
import ezy.p653ui.widget.recyclerview.item.Classifiable;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J1\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\u0006\u0010\u0012\u001a\u00020\u0005J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\b\u0010\"\u001a\u00020\u0007H\u0016R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006#"}, mo39189d2 = {"Lcom/jiayouya/travel/module/explore/data/DynamicContent;", "Lezy/ui/widget/recyclerview/item/Classifiable;", "type", "", "text", "", "time", "", "isFirst", "", "(ILjava/lang/String;JZ)V", "()Z", "setFirst", "(Z)V", "getText", "()Ljava/lang/String;", "getTime", "()J", "timeText", "getTimeText", "setTimeText", "(Ljava/lang/String;)V", "getType", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "toString", "toSubtypeId", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: DynamicContent.kt */
public final class DynamicContent implements Classifiable {
    private boolean isFirst;
    private final String text;
    private final long time;
    private String timeText;
    private final int type;

    public static /* synthetic */ DynamicContent copy$default(DynamicContent dynamicContent, int i, String str, long j, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = dynamicContent.type;
        }
        if ((i2 & 2) != 0) {
            str = dynamicContent.text;
        }
        String str2 = str;
        if ((i2 & 4) != 0) {
            j = dynamicContent.time;
        }
        long j2 = j;
        if ((i2 & 8) != 0) {
            z = dynamicContent.isFirst;
        }
        return dynamicContent.copy(i, str2, j2, z);
    }

    public final int component1() {
        return this.type;
    }

    public final String component2() {
        return this.text;
    }

    public final long component3() {
        return this.time;
    }

    public final boolean component4() {
        return this.isFirst;
    }

    public final DynamicContent copy(int i, String str, long j, boolean z) {
        C8271i.m35386b(str, "text");
        DynamicContent dynamicContent = new DynamicContent(i, str, j, z);
        return dynamicContent;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof DynamicContent) {
                DynamicContent dynamicContent = (DynamicContent) obj;
                if ((this.type == dynamicContent.type) && C8271i.m35384a((Object) this.text, (Object) dynamicContent.text)) {
                    if (this.time == dynamicContent.time) {
                        if (this.isFirst == dynamicContent.isFirst) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.type * 31;
        String str = this.text;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        long j = this.time;
        int i2 = (hashCode + ((int) (j ^ (j >>> 32)))) * 31;
        boolean z = this.isFirst;
        if (z) {
            z = true;
        }
        return i2 + z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DynamicContent(type=");
        sb.append(this.type);
        sb.append(", text=");
        sb.append(this.text);
        sb.append(", time=");
        sb.append(this.time);
        sb.append(", isFirst=");
        sb.append(this.isFirst);
        sb.append(")");
        return sb.toString();
    }

    public long toSubtypeId() {
        return 1;
    }

    public DynamicContent(int i, String str, long j, boolean z) {
        C8271i.m35386b(str, "text");
        this.type = i;
        this.text = str;
        this.time = j;
        this.isFirst = z;
        this.timeText = "";
    }

    public final int getType() {
        return this.type;
    }

    public final String getText() {
        return this.text;
    }

    public final long getTime() {
        return this.time;
    }

    public /* synthetic */ DynamicContent(int i, String str, long j, boolean z, int i2, DefaultConstructorMarker fVar) {
        this(i, str, j, (i2 & 8) != 0 ? false : z);
    }

    public final boolean isFirst() {
        return this.isFirst;
    }

    public final void setFirst(boolean z) {
        this.isFirst = z;
    }

    public final String getTimeText() {
        return this.timeText;
    }

    public final void setTimeText(String str) {
        C8271i.m35386b(str, "<set-?>");
        this.timeText = str;
    }

    public final String timeText() {
        String str;
        if (TextUtils.isEmpty(this.timeText)) {
            long j = (long) 1000;
            if (TimeUtil.m12974a(new Date(this.time * j))) {
                str = "今天";
            } else if (TimeUtil.m12975b(new Date(this.time * j))) {
                str = "昨天";
            } else {
                str = DateTime.m34800a("MM-dd", this.time * j);
                C8271i.m35382a((Object) str, "DateTime.format(\n       … * 1000\n                )");
            }
            this.timeText = str;
        }
        return this.timeText;
    }
}
