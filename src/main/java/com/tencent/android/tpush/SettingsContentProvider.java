package com.tencent.android.tpush;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.MatrixCursor.RowBuilder;
import android.net.Uri;
import android.os.Build.VERSION;
import com.tencent.android.tpush.p580b.C6864a;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public class SettingsContentProvider extends ContentProvider {
    public static Uri BASE_URI = null;
    public static final String BOOLEAN_TYPE = "boolean";
    public static final String FLOAT_TYPE = "float";
    public static final String INT_TYPE = "integer";
    public static final String KEY = "key";
    public static final String LONG_TYPE = "long";
    public static final String PREFFERENCE_AUTHORITY = "TPUSH_PROVIDER";
    public static final String STRING_TYPE = "string";
    public static final String TYPE = "type";
    /* renamed from: a */
    private static UriMatcher f22620a;
    /* renamed from: b */
    private static String f22621b;
    /* renamed from: c */
    private SharedPreferences f22622c = null;

    public String getType(Uri uri) {
        return "vnd.android.cursor.item/vnd.TPUSH_PROVIDER.item";
    }

    /* renamed from: a */
    private void m29187a(Context context) {
        if (f22621b == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(context.getPackageName());
            sb.append(".");
            sb.append(PREFFERENCE_AUTHORITY);
            f22621b = sb.toString();
        }
        if (f22620a == null) {
            f22620a = new UriMatcher(-1);
            f22620a.addURI(f22621b, "*/*", 65536);
        }
        if (BASE_URI == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("content://");
            sb2.append(f22621b);
            BASE_URI = Uri.parse(sb2.toString());
        }
        if (this.f22622c == null) {
            this.f22622c = context.getApplicationContext().getSharedPreferences(".tpns.settings.xml", 0);
        }
    }

    public boolean onCreate() {
        m29187a(getContext());
        return true;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        if (f22620a.match(uri) != 65536) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unsupported uri ");
            sb.append(uri);
            C6864a.m29308i("SettingsContentProvider", sb.toString());
        } else {
            this.f22622c.edit().clear().commit();
        }
        return 0;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        String str = "SettingsContentProvider";
        if (f22620a.match(uri) != 65536) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unsupported uri ");
            sb.append(uri);
            C6864a.m29308i(str, sb.toString());
        } else {
            Editor edit = this.f22622c.edit();
            for (Entry entry : contentValues.valueSet()) {
                Object value = entry.getValue();
                String str2 = (String) entry.getKey();
                if (value == null) {
                    edit.remove(str2);
                } else if (value instanceof String) {
                    edit.putString(str2, (String) value);
                } else if (value instanceof Boolean) {
                    edit.putBoolean(str2, ((Boolean) value).booleanValue());
                } else if (value instanceof Long) {
                    edit.putLong(str2, ((Long) value).longValue());
                } else if (value instanceof Integer) {
                    edit.putInt(str2, ((Integer) value).intValue());
                } else if (value instanceof Float) {
                    edit.putFloat(str2, ((Float) value).floatValue());
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Unsupported type ");
                    sb2.append(uri);
                    C6864a.m29308i(str, sb2.toString());
                }
            }
            if (VERSION.SDK_INT > 8) {
                edit.apply();
            } else {
                edit.commit();
            }
        }
        return null;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Object obj;
        String str3 = "SettingsContentProvider";
        MatrixCursor matrixCursor = null;
        if (f22620a.match(uri) != 65536) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unsupported uri ");
            sb.append(uri);
            C6864a.m29308i(str3, sb.toString());
        } else {
            String str4 = (String) uri.getPathSegments().get(0);
            String str5 = (String) uri.getPathSegments().get(1);
            MatrixCursor matrixCursor2 = new MatrixCursor(new String[]{str4});
            if (!this.f22622c.contains(str4)) {
                return matrixCursor2;
            }
            RowBuilder newRow = matrixCursor2.newRow();
            if (STRING_TYPE.equals(str5)) {
                obj = this.f22622c.getString(str4, null);
            } else if (BOOLEAN_TYPE.equals(str5)) {
                obj = Integer.valueOf(this.f22622c.getBoolean(str4, false));
            } else if (LONG_TYPE.equals(str5)) {
                obj = Long.valueOf(this.f22622c.getLong(str4, 0));
            } else if (INT_TYPE.equals(str5)) {
                obj = Integer.valueOf(this.f22622c.getInt(str4, 0));
            } else if (FLOAT_TYPE.equals(str5)) {
                obj = Float.valueOf(this.f22622c.getFloat(str4, 0.0f));
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unsupported type ");
                sb2.append(uri);
                C6864a.m29308i(str3, sb2.toString());
                matrixCursor = matrixCursor2;
            }
            newRow.add(obj);
            matrixCursor = matrixCursor2;
        }
        return matrixCursor;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        C6864a.m29308i("SettingsContentProvider", "UnsupportedOperation: update!");
        return 0;
    }

    public static String getStringValue(Cursor cursor, String str) {
        if (cursor == null) {
            return str;
        }
        if (cursor.moveToFirst()) {
            str = cursor.getString(0);
        }
        cursor.close();
        return str;
    }

    public static boolean getBooleanValue(Cursor cursor, boolean z) {
        if (cursor == null) {
            return z;
        }
        if (cursor.moveToFirst()) {
            z = false;
            if (cursor.getInt(0) > 0) {
                z = true;
            }
        }
        cursor.close();
        return z;
    }

    public static int getIntValue(Cursor cursor, int i) {
        if (cursor == null) {
            return i;
        }
        if (cursor.moveToFirst()) {
            i = cursor.getInt(0);
        }
        cursor.close();
        return i;
    }

    public static long getLongValue(Cursor cursor, long j) {
        if (cursor == null) {
            return j;
        }
        if (cursor.moveToFirst()) {
            j = cursor.getLong(0);
        }
        cursor.close();
        return j;
    }

    public static float getFloatValue(Cursor cursor, float f) {
        if (cursor == null) {
            return f;
        }
        if (cursor.moveToFirst()) {
            f = cursor.getFloat(0);
        }
        cursor.close();
        return f;
    }

    public static final Uri getContentUri(Context context, String str, String str2) {
        if (BASE_URI == null) {
            if (f22621b == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(context.getPackageName());
                sb.append(".");
                sb.append(PREFFERENCE_AUTHORITY);
                f22621b = sb.toString();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("content://");
            sb2.append(f22621b);
            BASE_URI = Uri.parse(sb2.toString());
        }
        return BASE_URI.buildUpon().appendPath(str).appendPath(str2).build();
    }
}
