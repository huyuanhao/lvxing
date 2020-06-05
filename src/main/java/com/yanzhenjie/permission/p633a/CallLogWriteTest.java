package com.yanzhenjie.permission.p633a;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.provider.CallLog.Calls;
import com.tencent.android.tpush.common.MessageKey;

/* renamed from: com.yanzhenjie.permission.a.d */
class CallLogWriteTest implements PermissionTest {
    /* renamed from: a */
    private ContentResolver f26616a;

    CallLogWriteTest(Context context) {
        this.f26616a = context.getContentResolver();
    }

    /* renamed from: a */
    public boolean mo38007a() throws Throwable {
        String str = "number=?";
        String str2 = "1";
        try {
            ContentValues contentValues = new ContentValues();
            boolean z = true;
            contentValues.put("type", Integer.valueOf(1));
            contentValues.put("number", str2);
            contentValues.put(MessageKey.MSG_DATE, Integer.valueOf(20080808));
            contentValues.put("new", "0");
            if (ContentUris.parseId(this.f26616a.insert(Calls.CONTENT_URI, contentValues)) <= 0) {
                z = false;
            }
            this.f26616a.delete(Calls.CONTENT_URI, str, new String[]{str2});
            return z;
        } catch (Throwable th) {
            this.f26616a.delete(Calls.CONTENT_URI, str, new String[]{str2});
            throw th;
        }
    }
}
