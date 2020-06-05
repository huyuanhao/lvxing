package com.yanzhenjie.permission.p633a;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import com.yanzhenjie.permission.p633a.PermissionTest.C7824a;

/* renamed from: com.yanzhenjie.permission.a.f */
class ContactsReadTest implements PermissionTest {
    /* renamed from: a */
    private ContentResolver f26619a;

    ContactsReadTest(Context context) {
        this.f26619a = context.getContentResolver();
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    public boolean mo38007a() throws Throwable {
        Cursor query = this.f26619a.query(Phone.CONTENT_URI, new String[]{C7887a.f26833ID, "data1"}, null, null, null);
        if (query == null) {
            return false;
        }
        try {
            C7824a.m33960a(query);
            query.close();
            return true;
        } catch (Throwable th) {
            query.close();
            throw th;
        }
    }
}
