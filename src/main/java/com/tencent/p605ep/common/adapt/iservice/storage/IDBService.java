package com.tencent.p605ep.common.adapt.iservice.storage;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import java.util.ArrayList;

/* renamed from: com.tencent.ep.common.adapt.iservice.storage.IDBService */
public interface IDBService {
    ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList);

    void close();

    int delete(String str, String str2, String[] strArr);

    void execSQL(String str);

    Uri getDeleteUri(String str);

    Uri getExeSqlUri(String str);

    ContentProviderOperation getExecSQLOperation(String str);

    Uri getInsertUri(String str);

    Uri getUpdateUri(String str);

    long insert(String str, ContentValues contentValues);

    Cursor query(String str);

    Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3);

    long replace(String str, ContentValues contentValues);

    int update(String str, ContentValues contentValues, String str2, String[] strArr);
}
