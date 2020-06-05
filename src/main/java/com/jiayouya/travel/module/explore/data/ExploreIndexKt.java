package com.jiayouya.travel.module.explore.data;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p244b.GloblaEx;
import com.jiayouya.travel.module.travel.p287c.GoldUtil;
import com.jiayouya.travel.module.travel.p287c.MergeUtil;
import ezy.assist.p648c.DateTime;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.C8271i;
import kotlin.text.C8313m;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0007\u001a\n\u0010\b\u001a\u00020\t*\u00020\u0007\u001a\n\u0010\n\u001a\u00020\t*\u00020\u000b\u001a\n\u0010\f\u001a\u00020\u0001*\u00020\u000b\u001a\n\u0010\r\u001a\u00020\u0003*\u00020\u000b\u001a\n\u0010\u000e\u001a\u00020\u0006*\u00020\u0007\u001a\n\u0010\u000f\u001a\u00020\u0003*\u00020\u0004\u001a\n\u0010\u0010\u001a\u00020\u0003*\u00020\u0007¨\u0006\u0011"}, mo39189d2 = {"defaultPlayImage", "Landroid/graphics/drawable/Drawable;", "content", "", "Lcom/jiayouya/travel/module/explore/data/DynamicItem;", "image", "", "Lcom/jiayouya/travel/module/explore/data/HarvestItem;", "isDog", "", "isPlayEnable", "Lcom/jiayouya/travel/module/explore/data/ExploreIndex;", "playImage", "playText", "textColor", "timeText", "value", "app_grRelease"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* compiled from: ExploreIndex.kt */
public final class ExploreIndexKt {
    public static final boolean isPlayEnable(ExploreIndex exploreIndex) {
        C8271i.m35386b(exploreIndex, "$this$isPlayEnable");
        return exploreIndex.getStatus() != 0;
    }

    public static final Drawable playImage(ExploreIndex exploreIndex) {
        C8271i.m35386b(exploreIndex, "$this$playImage");
        int status = exploreIndex.getStatus();
        if (status == 1 || status == 2 || status == 3) {
            return GloblaEx.m12820c(R.mipmap.ic_tv_small);
        }
        return defaultPlayImage();
    }

    public static final Drawable defaultPlayImage() {
        return new ColorDrawable(0);
    }

    public static final String playText(ExploreIndex exploreIndex) {
        C8271i.m35386b(exploreIndex, "$this$playText");
        int status = exploreIndex.getStatus();
        if (status == 1) {
            return "出发去探险";
        }
        if (status != 2) {
            return status != 3 ? "探险中" : "增加体力";
        }
        return "复活";
    }

    public static final String timeText(DynamicItem dynamicItem) {
        C8271i.m35386b(dynamicItem, "$this$timeText");
        String a = DateTime.m34799a(dynamicItem.getTime() * ((long) 1000));
        C8271i.m35382a((Object) a, "DateTime.toShortTime(time * 1000)");
        return a;
    }

    public static final String content(DynamicItem dynamicItem) {
        C8271i.m35386b(dynamicItem, "$this$content");
        try {
            if (dynamicItem.getType() != 1) {
                return dynamicItem.getText();
            }
            int b = C8313m.m35482b((CharSequence) dynamicItem.getText(), "金币", 0, false, 6, (Object) null);
            String text = dynamicItem.getText();
            int i = b + 2;
            if (text != null) {
                String substring = text.substring(i);
                C8271i.m35382a((Object) substring, "(this as java.lang.String).substring(startIndex)");
                return C8313m.m35461a(dynamicItem.getText(), substring, GoldUtil.f11900a.mo21651a(Double.parseDouble(substring)), false, 4, (Object) null);
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static final String value(HarvestItem harvestItem) {
        C8271i.m35386b(harvestItem, "$this$value");
        int type = harvestItem.getType();
        if (type == -1) {
            return "";
        }
        if (type == 48) {
            return GoldUtil.f11900a.mo21651a(harvestItem.getValue());
        }
        if (type != 49) {
            return String.valueOf((int) harvestItem.getValue());
        }
        String format = new DecimalFormat("#0.00").format(harvestItem.getValue());
        C8271i.m35382a((Object) format, "DecimalFormat(\"#0.00\").format(value)");
        return format;
    }

    public static final int textColor(HarvestItem harvestItem) {
        C8271i.m35386b(harvestItem, "$this$textColor");
        return GloblaEx.m12811a(harvestItem.getType() == 48 ? R.color.orange_FFA229 : R.color.red_F97154);
    }

    public static final boolean isDog(HarvestItem harvestItem) {
        C8271i.m35386b(harvestItem, "$this$isDog");
        return (harvestItem.getType() == 48 || harvestItem.getType() == 49 || harvestItem.getType() == -1) ? false : true;
    }

    public static final int image(HarvestItem harvestItem) {
        C8271i.m35386b(harvestItem, "$this$image");
        int type = harvestItem.getType();
        if (type != 48) {
            return type != 49 ? MergeUtil.m14455b(harvestItem.getType()) : R.mipmap.ic_explore_hb;
        }
        return R.mipmap.ic_explore_coin;
    }
}
