package com.yanzhenjie.permission.p633a;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.Telephony.Sms;
import com.yanzhenjie.permission.p633a.PermissionTest.C7824a;

/* renamed from: com.yanzhenjie.permission.a.r */
class SmsReadTest implements PermissionTest {
    /* renamed from: a */
    private ContentResolver f26636a;

    SmsReadTest(Context context) {
        this.f26636a = context.getContentResolver();
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    public boolean mo38007a() throws Throwable {
        Cursor query = this.f26636a.query(Sms.CONTENT_URI, new String[]{C7887a.f26833ID, "address", "person", "body"}, null, null, null);
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
