package com.tencent.mid.api;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.mid.core.Constants.ERROR;
import com.tencent.mid.sotrage.UnifiedStorage;
import com.tencent.mid.util.Util;

public class MidProvider extends ContentProvider {
    public static final int CMD_GET_PRIVATE_MID = 1;
    public static final int CMD_GET_PRIVATE_MID_ENTITY = 2;
    public static final int CMD_GET_PRIVATE_NEW_VERSION_MID_ENTITY = 3;
    public static final int CMD_INSERT_NEW_VERSION_MID_ENTITY = 10;
    public static final int CMD_INSERT_NEW_VERSION_MID_OLD_ENTITY = 11;

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public boolean onCreate() {
        return false;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        Context applicationContext = getContext().getApplicationContext();
        applicationContext.getPackageName();
        if (Util.isEmpty(lastPathSegment)) {
            return ERROR.CMD_FORMAT_ERROR;
        }
        try {
            int parseInt = Integer.parseInt(lastPathSegment);
            String str = null;
            if (parseInt != 1) {
                String str2 = "";
                if (parseInt == 2) {
                    MidEntity readPrivateMidEntity = UnifiedStorage.getInstance(applicationContext).readPrivateMidEntity();
                    if (readPrivateMidEntity == null) {
                        return null;
                    }
                    readPrivateMidEntity.setImei(str2);
                    readPrivateMidEntity.setImsi(str2);
                    readPrivateMidEntity.setMac(str2);
                    return readPrivateMidEntity.toString();
                } else if (parseInt != 3) {
                    return str2;
                } else {
                    MidEntity readPrivateNewVersionMidEntity = UnifiedStorage.getInstance(applicationContext).readPrivateNewVersionMidEntity();
                    if (readPrivateNewVersionMidEntity == null) {
                        return null;
                    }
                    readPrivateNewVersionMidEntity.setImei(str2);
                    readPrivateNewVersionMidEntity.setImsi(str2);
                    readPrivateNewVersionMidEntity.setMac(str2);
                    return readPrivateNewVersionMidEntity.toString();
                }
            } else {
                MidEntity readPrivateMidEntity2 = UnifiedStorage.getInstance(applicationContext).readPrivateMidEntity();
                if (readPrivateMidEntity2 != null) {
                    str = readPrivateMidEntity2.getMid();
                }
                return str;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return ERROR.CMD_NO_CMD;
        }
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        String lastPathSegment = uri.getLastPathSegment();
        Context applicationContext = getContext().getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        applicationContext.getPackageName();
        if (Util.isEmpty(lastPathSegment)) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(lastPathSegment);
            String str = "mid";
            if (parseInt == 10) {
                String asString = contentValues.getAsString(str);
                if (!Util.isMidValid(MidService.getLocalMidOnly(getContext().getApplicationContext()))) {
                    UnifiedStorage.getInstance(applicationContext).writeMidEntityWithProvide(MidEntity.parse(asString), false);
                }
            } else if (parseInt == 11) {
                try {
                    String asString2 = contentValues.getAsString(str);
                    if (!Util.isMidValid(MidService.getLocalMidOnly(getContext().getApplicationContext()))) {
                        UnifiedStorage.getInstance(applicationContext).writeNewVersionMidEntityWithProvider(MidEntity.parse(asString2), false);
                    }
                } catch (Throwable unused) {
                }
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
