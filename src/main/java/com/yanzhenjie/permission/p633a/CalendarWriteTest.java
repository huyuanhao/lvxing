package com.yanzhenjie.permission.p633a;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.provider.CalendarContract.Calendars;
import com.p522qq.p523e.comm.constants.ErrorCode.OtherError;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import com.yanzhenjie.permission.p638e.C7838a;
import java.util.TimeZone;

/* renamed from: com.yanzhenjie.permission.a.b */
class CalendarWriteTest implements PermissionTest {
    /* renamed from: a */
    private static final String f26612a = C7838a.m34069b("5045524D495353494F4E");
    /* renamed from: b */
    private static final String f26613b = C7838a.m34069b("7065726D697373696F6E40676D61696C2E636F6D");
    /* renamed from: c */
    private ContentResolver f26614c;

    CalendarWriteTest(Context context) {
        this.f26614c = context.getContentResolver();
    }

    /* renamed from: a */
    public boolean mo38007a() throws Throwable {
        String str = "LOCAL";
        String str2 = ArgKey.KEY_ACCOUNT_TYPE;
        String str3 = "account_name";
        String str4 = "account_name=?";
        try {
            TimeZone timeZone = TimeZone.getDefault();
            ContentValues contentValues = new ContentValues();
            contentValues.put(ArgKey.KEY_NAME, f26612a);
            contentValues.put(str3, f26613b);
            contentValues.put(str2, str);
            contentValues.put("calendar_displayName", f26612a);
            contentValues.put("visible", Integer.valueOf(1));
            contentValues.put("calendar_color", Integer.valueOf(-16776961));
            contentValues.put("calendar_access_level", Integer.valueOf(OtherError.VIDEO_DOWNLOAD_ERROR));
            contentValues.put("sync_events", Integer.valueOf(1));
            contentValues.put("calendar_timezone", timeZone.getID());
            contentValues.put("ownerAccount", f26612a);
            contentValues.put("canOrganizerRespond", Integer.valueOf(0));
            boolean z = ContentUris.parseId(this.f26614c.insert(Calendars.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").appendQueryParameter(str3, f26612a).appendQueryParameter(str2, str).build(), contentValues)) > 0;
            this.f26614c.delete(Calendars.CONTENT_URI.buildUpon().build(), str4, new String[]{f26613b});
            return z;
        } catch (Throwable th) {
            this.f26614c.delete(Calendars.CONTENT_URI.buildUpon().build(), str4, new String[]{f26613b});
            throw th;
        }
    }
}
