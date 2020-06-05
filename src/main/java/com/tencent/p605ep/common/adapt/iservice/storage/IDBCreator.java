package com.tencent.p605ep.common.adapt.iservice.storage;

/* renamed from: com.tencent.ep.common.adapt.iservice.storage.IDBCreator */
public interface IDBCreator {

    /* renamed from: com.tencent.ep.common.adapt.iservice.storage.IDBCreator$DBType */
    public enum DBType {
        DB_DEFAULT,
        DB_ENCRYPT_DEFAULT
    }

    DBType getDBType();

    String getGroupName();

    int getGroupVersion();

    void onCreate(IDBService iDBService);

    void onDowngrade(IDBService iDBService, int i, int i2);

    void onUpgrade(IDBService iDBService, int i, int i2);
}
