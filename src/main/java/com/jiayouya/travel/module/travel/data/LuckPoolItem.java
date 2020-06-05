package com.jiayouya.travel.module.travel.data;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p244b.GloblaEx;
import com.jiayouya.travel.common.p246d.ImageUtil;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0017\u001a\u00020\tJ\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0006H\u0002R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/data/LuckPoolItem;", "", "id", "", "name", "image", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "getId", "()Ljava/lang/String;", "getImage", "()I", "getName", "rotateAngel", "getRotateAngel", "setRotateAngel", "(I)V", "getRotateBitmap", "rotateBitmap", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: LuckPoolItem.kt */
public final class LuckPoolItem {
    private Bitmap bitmap;
    /* renamed from: id */
    private final String f11907id;
    private final int image;
    private final String name;
    private int rotateAngel;

    public LuckPoolItem(String str, String str2, int i) {
        C8271i.m35386b(str, "id");
        C8271i.m35386b(str2, ArgKey.KEY_NAME);
        this.f11907id = str;
        this.name = str2;
        this.image = i;
    }

    public final String getId() {
        return this.f11907id;
    }

    public final int getImage() {
        return this.image;
    }

    public final String getName() {
        return this.name;
    }

    public final int getRotateAngel() {
        return this.rotateAngel;
    }

    public final void setRotateAngel(int i) {
        this.rotateAngel = i;
    }

    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final void setBitmap(Bitmap bitmap2) {
        this.bitmap = bitmap2;
    }

    public final Bitmap getRotateBitmap() {
        if (this.bitmap == null) {
            this.bitmap = rotateBitmap(this.rotateAngel);
        }
        Bitmap bitmap2 = this.bitmap;
        if (bitmap2 == null) {
            C8271i.m35380a();
        }
        return bitmap2;
    }

    private final Bitmap rotateBitmap(int i) {
        int i2;
        switch (this.image) {
            case 1:
                i2 = R.mipmap.ic_little_coin;
                break;
            case 2:
                i2 = R.mipmap.ic_middle_coin;
                break;
            case 3:
                i2 = R.mipmap.ic_many_coin;
                break;
            case 4:
                i2 = R.mipmap.ic_supper_many_coin;
                break;
            case 5:
                i2 = R.mipmap.ic_box_silver;
                break;
            case 6:
                i2 = R.mipmap.ic_box_gold;
                break;
            default:
                i2 = R.mipmap.ic_luck_hb;
                break;
        }
        Drawable c = GloblaEx.m12820c(i2);
        if (c != null) {
            Bitmap bitmap2 = ((BitmapDrawable) c).getBitmap();
            if (i == 0 || i == 360) {
                C8271i.m35382a((Object) bitmap2, "bitmap");
                return bitmap2;
            }
            Bitmap a = ImageUtil.m12960a(bitmap2, i);
            C8271i.m35382a((Object) a, "ImageUtil.rotate(bitmap, rotateAngel)");
            return a;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
    }
}
