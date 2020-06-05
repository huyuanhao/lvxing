package com.tencent.p605ep.common.adapt.iservice.storage;

import android.util.Pair;
import java.util.List;

/* renamed from: com.tencent.ep.common.adapt.iservice.storage.IStorageService */
public interface IStorageService {
    public static final String AUTHORITY_DB_DEFAULT = "DefaultDBProvider";
    public static final String AUTHORITY_DB_ENCRYPT_DEFAULT = "EncryptDefaultDBProvider";

    void createCustomDB(boolean z, String str, String str2, int i, ISqliteFactor iSqliteFactor);

    void createDefaultDBTables(List<Pair<IDBCreator, Integer>> list);

    IDBService getDBService(String str);

    IPreferenceService getPreferenceService(String str);

    ISysDBService getSysDBService();

    boolean isEncryptDBAvailable();
}
