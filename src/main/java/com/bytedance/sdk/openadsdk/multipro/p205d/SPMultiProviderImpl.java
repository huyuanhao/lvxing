package com.bytedance.sdk.openadsdk.multipro.p205d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.multipro.ITTProvider;
import com.tencent.android.tpush.SettingsContentProvider;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.util.Map;

/* renamed from: com.bytedance.sdk.openadsdk.multipro.d.c */
public class SPMultiProviderImpl implements ITTProvider {
    /* renamed from: a */
    private Context f9097a;

    /* renamed from: a */
    public String mo16851a() {
        return "t_sp";
    }

    /* renamed from: b */
    public void mo16854b() {
    }

    /* renamed from: a */
    public void mo16853a(Context context) {
        this.f9097a = context;
    }

    /* renamed from: c */
    private Context m11901c() {
        Context context = this.f9097a;
        return context == null ? InternalContainer.m10059a() : context;
    }

    /* renamed from: a */
    public Cursor mo16849a(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (uri.getPath().split("/")[2].equals("get_all")) {
            Map b = SPMultiHelperImpl.m11896b(m11901c(), uri.getQueryParameter("sp_file_name"));
            if (b != null) {
                MatrixCursor matrixCursor = new MatrixCursor(new String[]{"cursor_name", "cursor_type", "cursor_value"});
                for (String str3 : b.keySet()) {
                    Object[] objArr = new Object[3];
                    objArr[0] = str3;
                    objArr[2] = b.get(str3);
                    if (objArr[2] instanceof Boolean) {
                        objArr[1] = SettingsContentProvider.BOOLEAN_TYPE;
                    } else if (objArr[2] instanceof String) {
                        objArr[1] = SettingsContentProvider.STRING_TYPE;
                    } else if (objArr[2] instanceof Integer) {
                        objArr[1] = "int";
                    } else if (objArr[2] instanceof Long) {
                        objArr[1] = SettingsContentProvider.LONG_TYPE;
                    } else if (objArr[2] instanceof Float) {
                        objArr[1] = SettingsContentProvider.FLOAT_TYPE;
                    }
                    matrixCursor.addRow(objArr);
                }
                return matrixCursor;
            }
        }
        return null;
    }

    /* renamed from: a */
    public String mo16852a(Uri uri) {
        String[] split = uri.getPath().split("/");
        String str = split[2];
        String str2 = split[3];
        String str3 = "sp_file_name";
        String str4 = "";
        if (str.equals("contain")) {
            StringBuilder sb = new StringBuilder();
            sb.append(SPMultiHelperImpl.m11893a(InternalContainer.m10059a(), uri.getQueryParameter(str3), str2));
            sb.append(str4);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str4);
        sb2.append(SPMultiHelperImpl.m11888a(m11901c(), uri.getQueryParameter(str3), str2, str));
        return sb2.toString();
    }

    /* renamed from: a */
    public Uri mo16850a(Uri uri, ContentValues contentValues) {
        if (contentValues == null) {
            return null;
        }
        String[] split = uri.getPath().split("/");
        String str = split[2];
        String str2 = split[3];
        Object obj = contentValues.get(ArgKey.KEY_VALUE);
        if (obj != null) {
            SPMultiHelperImpl.m11891a(m11901c(), uri.getQueryParameter("sp_file_name"), str2, obj);
        }
        return null;
    }

    /* renamed from: a */
    public int mo16848a(Uri uri, String str, String[] strArr) {
        String[] split = uri.getPath().split("/");
        String str2 = "sp_file_name";
        if (split[2].equals("clean")) {
            SPMultiHelperImpl.m11890a(m11901c(), uri.getQueryParameter(str2));
            return 0;
        }
        String str3 = split[3];
        if (SPMultiHelperImpl.m11893a(m11901c(), uri.getQueryParameter(str2), str3)) {
            SPMultiHelperImpl.m11897b(m11901c(), uri.getQueryParameter(str2), str3);
        }
        return 0;
    }

    /* renamed from: a */
    public int mo16847a(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (contentValues == null) {
            return 0;
        }
        mo16850a(uri, contentValues);
        return 0;
    }
}
