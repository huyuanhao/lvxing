package com.jiayouya.travel.module.travel.p290vm;

import androidx.lifecycle.MutableLiveData;
import com.jiayouya.travel.common.base.BaseViewModel;
import com.jiayouya.travel.module.common.data.Resource;
import com.jiayouya.travel.module.travel.data.BuyDogRsp;
import com.jiayouya.travel.module.travel.data.DogShopItem;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u000eR\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\b¨\u0006\u0013"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/vm/DogShopVM;", "Lcom/jiayouya/travel/common/base/BaseViewModel;", "()V", "buyData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/jiayouya/travel/module/common/data/Resource;", "Lcom/jiayouya/travel/module/travel/data/BuyDogRsp;", "getBuyData", "()Landroidx/lifecycle/MutableLiveData;", "listData", "", "Lcom/jiayouya/travel/module/travel/data/DogShopItem;", "getListData", "buyDog", "", "item", "position", "", "list", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: DogShopVM.kt */
/* renamed from: com.jiayouya.travel.module.travel.vm.DogShopVM */
public final class DogShopVM extends BaseViewModel {
    /* renamed from: a */
    private final MutableLiveData<List<DogShopItem>> f12147a = new MutableLiveData<>();
    /* renamed from: b */
    private final MutableLiveData<Resource<BuyDogRsp>> f12148b = new MutableLiveData<>();
}
