package com.tencent.p605ep.common.adapt.iservice.storage;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import java.io.InputStream;
import java.util.ArrayList;

/* renamed from: com.tencent.ep.common.adapt.iservice.storage.ISysDBService */
public interface ISysDBService {
    ContentProviderResult[] applyBatch(String str, ArrayList<ContentProviderOperation> arrayList);

    int bulkInsert(Uri uri, ContentValues[] contentValuesArr);

    int delete(Uri uri, String str, String[] strArr);

    Uri insert(Uri uri, ContentValues contentValues);

    InputStream openInputStream(Uri uri);

    Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2);

    int update(Uri uri, ContentValues contentValues, String str, String[] strArr);
}
