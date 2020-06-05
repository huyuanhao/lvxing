package com.qiyukf.nim.uikit.common.media.p421b;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Images.Thumbnails;
import com.qiyukf.basesdk.p393a.C5264a;

/* renamed from: com.qiyukf.nim.uikit.common.media.b.a */
public final class C5448a {
    /* renamed from: a */
    public static Cursor m22248a(Context context) {
        String[] strArr = {C7887a.f26833ID, "image_id", "_data"};
        try {
            return context.getContentResolver().query(Thumbnails.EXTERNAL_CONTENT_URI, strArr, null, null, "_id DESC");
        } catch (Exception e) {
            C5264a.m21621b("MediaDAO", "getAllMediaThumbnails exception", e);
            return null;
        }
    }

    /* renamed from: b */
    public static Cursor m22249b(Context context) {
        try {
            return context.getContentResolver().query(Media.EXTERNAL_CONTENT_URI, null, null, null, "date_modified DESC");
        } catch (Exception e) {
            C5264a.m21621b("MediaDAO", "getAllMediaPhotos exception", e);
            return null;
        }
    }
}
