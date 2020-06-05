package com.jiayouya.travel.module.common.data;

import com.travel.adlibrary.p612a.C7670b;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u001a\u0012\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004*\u00020\u0006¨\u0006\u0007"}, mo39189d2 = {"getAdType", "", "platform", "adVideoPlats", "Ljava/util/LinkedList;", "Lcom/travel/adlibrary/common/AdPlatform;", "Lcom/jiayouya/travel/module/common/data/AdRsp;", "app_grRelease"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* compiled from: AdRsp.kt */
public final class AdRspKt {
    private static final int getAdType(int i) {
        if (i == 2) {
            return 1;
        }
        if (i != 3) {
            return i != 4 ? 4 : 9;
        }
        return 8;
    }

    public static final LinkedList<C7670b> adVideoPlats(AdRsp adRsp) {
        C8271i.m35386b(adRsp, "$this$adVideoPlats");
        LinkedList<C7670b> linkedList = new LinkedList<>();
        linkedList.add(new C7670b(adRsp.getAdIdVideo(), getAdType(adRsp.getAdPlat())));
        List<Platform> adVideoList = adRsp.getAdVideoList();
        if (adVideoList != null) {
            for (Platform platform : adVideoList) {
                linkedList.add(new C7670b(platform.getId(), getAdType(platform.getPlat())));
            }
        }
        return linkedList;
    }
}
