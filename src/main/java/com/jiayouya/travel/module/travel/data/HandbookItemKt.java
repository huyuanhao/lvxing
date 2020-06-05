package com.jiayouya.travel.module.travel.data;

import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p246d.NumPrefixUtil;
import kotlin.Metadata;
import kotlin.collections.C8187k;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0002¨\u0006\u0005"}, mo39189d2 = {"loversImage", "", "Lcom/jiayouya/travel/module/travel/data/HandbookItem;", "way", "", "app_grRelease"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* compiled from: HandbookItem.kt */
public final class HandbookItemKt {
    public static final int loversImage(HandbookItem handbookItem) {
        C8271i.m35386b(handbookItem, "$this$loversImage");
        int id = handbookItem.getId();
        if (id == 43) {
            return R.mipmap.ic_lovers_women;
        }
        if (id != 44) {
            return -1;
        }
        return R.mipmap.ic_lovers_man;
    }

    public static final String way(HandbookItem handbookItem) {
        C8271i.m35386b(handbookItem, "$this$way");
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Object next : handbookItem.getIntro()) {
            int i2 = i + 1;
            if (i < 0) {
                C8187k.m35272b();
            }
            String str = (String) next;
            sb.append(NumPrefixUtil.m12967a(i));
            sb.append(str);
            if (i != handbookItem.getIntro().size() - 1) {
                sb.append("\n");
            }
            i = i2;
        }
        String sb2 = sb.toString();
        C8271i.m35382a((Object) sb2, "s.toString()");
        return sb2;
    }
}
