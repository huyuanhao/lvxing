package com.kwad.sdk.p306a;

import android.database.Cursor;
import android.text.TextUtils;
import java.util.List;

/* renamed from: com.kwad.sdk.a.j */
public class C3807j {
    /* renamed from: a */
    public static void m15781a(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m15782a(Boolean bool, String str) {
        if (bool.booleanValue()) {
            throw new IllegalArgumentException(str);
        }
    }

    /* renamed from: a */
    public static void m15783a(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        } else if ((obj instanceof String) && TextUtils.isEmpty((String) obj)) {
            throw new IllegalArgumentException(str);
        }
    }

    /* renamed from: a */
    public static void m15784a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(str2);
        }
    }

    /* renamed from: a */
    public static boolean m15785a(List list) {
        return list != null && !list.isEmpty();
    }
}
