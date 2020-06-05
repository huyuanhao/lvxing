package p681me.jessyan.autosize;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import p681me.jessyan.autosize.utils.AutoSizeUtils;

/* renamed from: me.jessyan.autosize.InitProvider */
public class InitProvider extends ContentProvider {
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public boolean onCreate() {
        Object applicationContext = getContext().getApplicationContext();
        if (applicationContext == null) {
            applicationContext = AutoSizeUtils.getApplicationByReflect();
        }
        AutoSizeConfig.getInstance().setLog(true).init((Application) applicationContext).setUseDeviceSize(false);
        return true;
    }
}
