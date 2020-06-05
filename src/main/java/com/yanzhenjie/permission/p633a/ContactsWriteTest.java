package com.yanzhenjie.permission.p633a;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;

/* renamed from: com.yanzhenjie.permission.a.g */
class ContactsWriteTest implements PermissionTest {
    /* renamed from: a */
    private ContentResolver f26620a;

    ContactsWriteTest(ContentResolver contentResolver) {
        this.f26620a = contentResolver;
    }

    /* renamed from: a */
    public boolean mo38007a() throws Throwable {
        long[] b = m33953b();
        long j = b[0];
        long j2 = b[1];
        if (j <= 0 || j2 <= 0) {
            return false;
        }
        return m33952a(j, j2);
    }

    /* renamed from: b */
    private long[] m33953b() {
        ContentValues contentValues = new ContentValues();
        long parseId = ContentUris.parseId(this.f26620a.insert(RawContacts.CONTENT_URI, contentValues));
        contentValues.put("raw_contact_id", Long.valueOf(parseId));
        String str = "PERMISSION";
        contentValues.put("data1", str);
        contentValues.put("data2", str);
        contentValues.put("mimetype", "vnd.android.cursor.item/name");
        return new long[]{parseId, ContentUris.parseId(this.f26620a.insert(Data.CONTENT_URI, contentValues))};
    }

    /* renamed from: a */
    private boolean m33952a(long j, long j2) {
        String[] strArr = {Long.toString(j2)};
        String str = "_id=?";
        int delete = this.f26620a.delete(Data.CONTENT_URI, str, strArr);
        if (this.f26620a.delete(RawContacts.CONTENT_URI, str, new String[]{Long.toString(j)}) <= 0 || delete <= 0) {
            return false;
        }
        return true;
    }
}
