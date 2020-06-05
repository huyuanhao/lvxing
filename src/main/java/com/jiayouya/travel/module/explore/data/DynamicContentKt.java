package com.jiayouya.travel.module.explore.data;

import com.jiayouya.travel.R;
import com.jiayouya.travel.module.travel.p287c.GoldUtil;
import ezy.assist.p648c.DateTime;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.C8271i;
import kotlin.text.C8313m;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0005\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0005\u001a\n\u0010\u0007\u001a\u00020\u0001*\u00020\u0005\u001a\n\u0010\b\u001a\u00020\u0004*\u00020\u0005¨\u0006\t"}, mo39189d2 = {"dynamicTypeImage", "", "type", "content", "", "Lcom/jiayouya/travel/module/explore/data/DynamicContent;", "image", "marginTop", "time", "app_grRelease"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* compiled from: DynamicContent.kt */
public final class DynamicContentKt {
    public static final int dynamicTypeImage(int i) {
        if (i == 1) {
            return R.mipmap.ic_explore_money;
        }
        if (i == 2) {
            return R.mipmap.ic_explore_foot;
        }
        if (i == 3) {
            return R.drawable.ic_dynamic_hb;
        }
        switch (i) {
            case 7:
                return R.mipmap.ic_back_gogogo_icon;
            case 8:
            case 9:
            case 11:
                return R.mipmap.ic_back_home_icon;
            case 10:
                return R.mipmap.ic_back_home_live;
            default:
                return R.mipmap.ic_explore_cup;
        }
    }

    public static final String time(DynamicContent dynamicContent) {
        C8271i.m35386b(dynamicContent, "$this$time");
        String a = DateTime.m34799a(dynamicContent.getTime() * ((long) 1000));
        C8271i.m35382a((Object) a, "DateTime.toShortTime(time * 1000)");
        return a;
    }

    public static final int image(DynamicContent dynamicContent) {
        C8271i.m35386b(dynamicContent, "$this$image");
        return dynamicTypeImage(dynamicContent.getType());
    }

    public static final String content(DynamicContent dynamicContent) {
        C8271i.m35386b(dynamicContent, "$this$content");
        try {
            if (dynamicContent.getType() != 1) {
                return dynamicContent.getText();
            }
            int b = C8313m.m35482b((CharSequence) dynamicContent.getText(), "金币", 0, false, 6, (Object) null);
            String text = dynamicContent.getText();
            int i = b + 2;
            if (text != null) {
                String substring = text.substring(i);
                C8271i.m35382a((Object) substring, "(this as java.lang.String).substring(startIndex)");
                return C8313m.m35461a(dynamicContent.getText(), substring, GoldUtil.f11900a.mo21651a(Double.parseDouble(substring)), false, 4, (Object) null);
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static final int marginTop(DynamicContent dynamicContent) {
        C8271i.m35386b(dynamicContent, "$this$marginTop");
        return dynamicContent.isFirst() ? 21 : 13;
    }
}
