package com.jiayouya.travel.common.widget;

import com.jiayouya.travel.R;
import com.jiayouya.travel.common.binding.BindingType;
import com.jiayouya.travel.module.common.data.ListEmptyData;
import kotlin.Metadata;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, mo39189d2 = {"Lcom/jiayouya/travel/common/widget/ItemTypes;", "", "()V", "EMPTY", "Lcom/jiayouya/travel/common/binding/BindingType;", "kotlin.jvm.PlatformType", "getEMPTY", "()Lcom/jiayouya/travel/common/binding/BindingType;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.common.widget.a */
public final class ItemTypes {
    /* renamed from: a */
    public static final ItemTypes f9670a = new ItemTypes();
    /* renamed from: b */
    private static final BindingType f9671b = BindingType.create(ListEmptyData.class, (int) R.layout.item_list_empty);

    private ItemTypes() {
    }

    /* renamed from: a */
    public final BindingType mo20024a() {
        return f9671b;
    }
}
