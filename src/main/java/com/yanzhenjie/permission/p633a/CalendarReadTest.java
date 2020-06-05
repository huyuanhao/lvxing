package com.yanzhenjie.permission.p633a;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.CalendarContract.Calendars;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import com.yanzhenjie.permission.p633a.PermissionTest.C7824a;

/* renamed from: com.yanzhenjie.permission.a.a */
class CalendarReadTest implements PermissionTest {
    /* renamed from: a */
    private ContentResolver f26611a;

    CalendarReadTest(Context context) {
        this.f26611a = context.getContentResolver();
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    public boolean mo38007a() throws Throwable {
        Cursor query = this.f26611a.query(Calendars.CONTENT_URI, new String[]{C7887a.f26833ID, ArgKey.KEY_NAME}, null, null, null);
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
