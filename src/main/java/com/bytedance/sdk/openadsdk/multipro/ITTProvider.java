package com.bytedance.sdk.openadsdk.multipro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* renamed from: com.bytedance.sdk.openadsdk.multipro.a */
public interface ITTProvider {
    /* renamed from: a */
    int mo16847a(Uri uri, ContentValues contentValues, String str, String[] strArr);

    /* renamed from: a */
    int mo16848a(Uri uri, String str, String[] strArr);

    /* renamed from: a */
    Cursor mo16849a(Uri uri, String[] strArr, String str, String[] strArr2, String str2);

    /* renamed from: a */
    Uri mo16850a(Uri uri, ContentValues contentValues);

    /* renamed from: a */
    String mo16851a();

    /* renamed from: a */
    String mo16852a(Uri uri);

    /* renamed from: a */
    void mo16853a(Context context);

    /* renamed from: b */
    void mo16854b();
}
