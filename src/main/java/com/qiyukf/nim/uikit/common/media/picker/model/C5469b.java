package com.qiyukf.nim.uikit.common.media.picker.model;

import android.content.Intent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.qiyukf.nim.uikit.common.media.picker.model.b */
public final class C5469b {
    /* renamed from: a */
    public static Intent m22297a(List<PhotoInfo> list, boolean z) {
        Intent intent = new Intent();
        intent.putExtra("photo_list", new ArrayList(list));
        intent.putExtra("is_original", z);
        return intent;
    }

    /* renamed from: a */
    public static List<PhotoInfo> m22298a(Intent intent) {
        return m22299a(intent.getSerializableExtra("photo_list"));
    }

    /* renamed from: a */
    private static List<PhotoInfo> m22299a(Serializable serializable) {
        if (serializable == null || !(serializable instanceof List)) {
            return null;
        }
        return (List) serializable;
    }

    /* renamed from: b */
    public static List<PhotoInfo> m22300b(Intent intent) {
        return m22299a(intent.getSerializableExtra("selected_photo_list"));
    }
}
