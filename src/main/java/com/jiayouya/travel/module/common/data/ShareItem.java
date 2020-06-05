package com.jiayouya.travel.module.common.data;

import android.graphics.Bitmap;
import androidx.core.view.ViewCompat;
import com.jiayouya.travel.common.p244b.GloblaEx;
import com.jiayouya.travel.module.travel.data.ShareInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;
import p005cn.bingoogolapple.qrcode.zxing.QRCodeEncoder;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\u001d\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010%\u001a\u00020\b2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010'\u001a\u00020\u0013J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006+"}, mo39189d2 = {"Lcom/jiayouya/travel/module/common/data/ShareItem;", "", "resId", "", "shareInfo", "Lcom/jiayouya/travel/module/travel/data/ShareInfo;", "(ILcom/jiayouya/travel/module/travel/data/ShareInfo;)V", "isEnd", "", "()Z", "setEnd", "(Z)V", "isSelected", "setSelected", "isStart", "setStart", "isUpdated", "setUpdated", "qrBitmap", "Landroid/graphics/Bitmap;", "getQrBitmap", "()Landroid/graphics/Bitmap;", "setQrBitmap", "(Landroid/graphics/Bitmap;)V", "getResId", "()I", "getShareInfo", "()Lcom/jiayouya/travel/module/travel/data/ShareInfo;", "user", "Lcom/jiayouya/travel/module/common/data/User;", "getUser", "()Lcom/jiayouya/travel/module/common/data/User;", "setUser", "(Lcom/jiayouya/travel/module/common/data/User;)V", "component1", "component2", "copy", "equals", "other", "getQrImage", "hashCode", "toString", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: ShareItem.kt */
public final class ShareItem {
    private boolean isEnd;
    private boolean isSelected;
    private boolean isStart;
    private boolean isUpdated;
    private Bitmap qrBitmap;
    private final int resId;
    private final ShareInfo shareInfo;
    private User user;

    public static /* synthetic */ ShareItem copy$default(ShareItem shareItem, int i, ShareInfo shareInfo2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = shareItem.resId;
        }
        if ((i2 & 2) != 0) {
            shareInfo2 = shareItem.shareInfo;
        }
        return shareItem.copy(i, shareInfo2);
    }

    public final int component1() {
        return this.resId;
    }

    public final ShareInfo component2() {
        return this.shareInfo;
    }

    public final ShareItem copy(int i, ShareInfo shareInfo2) {
        C8271i.m35386b(shareInfo2, "shareInfo");
        return new ShareItem(i, shareInfo2);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ShareItem) {
                ShareItem shareItem = (ShareItem) obj;
                if (!(this.resId == shareItem.resId) || !C8271i.m35384a((Object) this.shareInfo, (Object) shareItem.shareInfo)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.resId * 31;
        ShareInfo shareInfo2 = this.shareInfo;
        return i + (shareInfo2 != null ? shareInfo2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ShareItem(resId=");
        sb.append(this.resId);
        sb.append(", shareInfo=");
        sb.append(this.shareInfo);
        sb.append(")");
        return sb.toString();
    }

    public ShareItem(int i, ShareInfo shareInfo2) {
        C8271i.m35386b(shareInfo2, "shareInfo");
        this.resId = i;
        this.shareInfo = shareInfo2;
    }

    public final int getResId() {
        return this.resId;
    }

    public final ShareInfo getShareInfo() {
        return this.shareInfo;
    }

    public final User getUser() {
        return this.user;
    }

    public final void setUser(User user2) {
        this.user = user2;
    }

    public final boolean isStart() {
        return this.isStart;
    }

    public final void setStart(boolean z) {
        this.isStart = z;
    }

    public final boolean isEnd() {
        return this.isEnd;
    }

    public final void setEnd(boolean z) {
        this.isEnd = z;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    public final boolean isUpdated() {
        return this.isUpdated;
    }

    public final void setUpdated(boolean z) {
        this.isUpdated = z;
    }

    public final Bitmap getQrBitmap() {
        return this.qrBitmap;
    }

    public final void setQrBitmap(Bitmap bitmap) {
        this.qrBitmap = bitmap;
    }

    public final Bitmap getQrImage() {
        Bitmap a = QRCodeEncoder.m1056a(this.shareInfo.getUrl(), GloblaEx.m12810a(95.0f), ViewCompat.MEASURED_STATE_MASK);
        C8271i.m35382a((Object) a, "QRCodeEncoder.syncEncode… dp2px(95f), Color.BLACK)");
        return a;
    }
}
