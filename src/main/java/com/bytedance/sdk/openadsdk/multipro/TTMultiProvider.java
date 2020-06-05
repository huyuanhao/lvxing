package com.bytedance.sdk.openadsdk.multipro;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.sdk.openadsdk.core.p174h.SdkSwitch;

public class TTMultiProvider extends ContentProvider {
    public boolean onCreate() {
        if (!SdkSwitch.m9757a()) {
            return false;
        }
        TTProviderManager.m11912b(getContext()).mo16853a(getContext());
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (!SdkSwitch.m9757a()) {
            return null;
        }
        return TTProviderManager.m11912b(getContext()).mo16849a(uri, strArr, str, strArr2, str2);
    }

    public String getType(Uri uri) {
        if (!SdkSwitch.m9757a()) {
            return null;
        }
        return TTProviderManager.m11912b(getContext()).mo16852a(uri);
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        if (!SdkSwitch.m9757a()) {
            return null;
        }
        return TTProviderManager.m11912b(getContext()).mo16850a(uri, contentValues);
    }

    public int delete(Uri uri, String str, String[] strArr) {
        if (!SdkSwitch.m9757a()) {
            return 0;
        }
        return TTProviderManager.m11912b(getContext()).mo16848a(uri, str, strArr);
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (!SdkSwitch.m9757a()) {
            return 0;
        }
        return TTProviderManager.m11912b(getContext()).mo16847a(uri, contentValues, str, strArr);
    }
}
