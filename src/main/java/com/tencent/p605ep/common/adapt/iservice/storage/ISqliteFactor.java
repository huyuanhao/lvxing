package com.tencent.p605ep.common.adapt.iservice.storage;

/* renamed from: com.tencent.ep.common.adapt.iservice.storage.ISqliteFactor */
public interface ISqliteFactor {
    void onCreate(Object obj);

    void onDowngrade(Object obj, int i, int i2);

    void onUpgrade(Object obj, int i, int i2);
}
