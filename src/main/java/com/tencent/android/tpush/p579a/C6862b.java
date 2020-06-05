package com.tencent.android.tpush.p579a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.a.b */
public class C6862b {
    /* renamed from: a */
    private static ConcurrentHashMap<String, List<Long>> f22830a = new ConcurrentHashMap<>();

    /* renamed from: a */
    public static Uri m29274a(Context context, Uri uri, ContentValues contentValues) {
        System.currentTimeMillis();
        Uri insert = context.getContentResolver().insert(uri, contentValues);
        System.currentTimeMillis();
        return insert;
    }

    /* renamed from: a */
    public static String m29275a(Context context, Uri uri) {
        System.currentTimeMillis();
        String type = context.getContentResolver().getType(uri);
        System.currentTimeMillis();
        return type;
    }

    /* renamed from: a */
    public static int m29272a(Context context, Uri uri, ContentValues contentValues, String str, String[] strArr) {
        System.currentTimeMillis();
        int update = context.getContentResolver().update(uri, contentValues, str, strArr);
        System.currentTimeMillis();
        return update;
    }

    /* renamed from: a */
    public static Cursor m29273a(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        System.currentTimeMillis();
        Cursor query = context.getContentResolver().query(uri, strArr, str, strArr2, str2);
        System.currentTimeMillis();
        return query;
    }
}
