package com.jiayouya.travel.module.p276me.data;

import kotlin.Metadata;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/data/AnalysisItem;", "", "status", "", "percent", "", "(IF)V", "getPercent", "()F", "getStatus", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: AnalysisItem.kt */
/* renamed from: com.jiayouya.travel.module.me.data.AnalysisItem */
public final class AnalysisItem {
    private final float percent;
    private final int status;

    public static /* synthetic */ AnalysisItem copy$default(AnalysisItem analysisItem, int i, float f, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = analysisItem.status;
        }
        if ((i2 & 2) != 0) {
            f = analysisItem.percent;
        }
        return analysisItem.copy(i, f);
    }

    public final int component1() {
        return this.status;
    }

    public final float component2() {
        return this.percent;
    }

    public final AnalysisItem copy(int i, float f) {
        return new AnalysisItem(i, f);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof AnalysisItem) {
                AnalysisItem analysisItem = (AnalysisItem) obj;
                if (!(this.status == analysisItem.status) || Float.compare(this.percent, analysisItem.percent) != 0) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.status * 31) + Float.floatToIntBits(this.percent);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AnalysisItem(status=");
        sb.append(this.status);
        sb.append(", percent=");
        sb.append(this.percent);
        sb.append(")");
        return sb.toString();
    }

    public AnalysisItem(int i, float f) {
        this.status = i;
        this.percent = f;
    }

    public final float getPercent() {
        return this.percent;
    }

    public final int getStatus() {
        return this.status;
    }
}
