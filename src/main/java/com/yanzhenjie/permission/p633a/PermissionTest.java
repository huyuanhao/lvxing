package com.yanzhenjie.permission.p633a;

import android.database.Cursor;

/* renamed from: com.yanzhenjie.permission.a.l */
interface PermissionTest {

    /* compiled from: PermissionTest */
    /* renamed from: com.yanzhenjie.permission.a.l$a */
    public static class C7824a {
        /* renamed from: a */
        public static void m33960a(Cursor cursor) {
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                int type = cursor.getType(0);
                if (type != 0 && type != 4) {
                    cursor.getString(0);
                }
            }
        }
    }

    /* renamed from: a */
    boolean mo38007a() throws Throwable;
}
