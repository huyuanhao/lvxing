package com.bytedance.sdk.openadsdk.multipro.p204c;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.p168b.FrequentCallController;
import com.bytedance.sdk.openadsdk.multipro.ITTProvider;
import com.bytedance.sdk.openadsdk.multipro.TTPathConst;
import com.bytedance.sdk.openadsdk.utils.C2564t;

/* renamed from: com.bytedance.sdk.openadsdk.multipro.c.b */
public class FrequentCallProviderImpl implements ITTProvider {
    /* renamed from: a */
    private Context f9094a;

    /* renamed from: a */
    public int mo16847a(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    /* renamed from: a */
    public int mo16848a(Uri uri, String str, String[] strArr) {
        return 0;
    }

    /* renamed from: a */
    public Cursor mo16849a(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    /* renamed from: a */
    public Uri mo16850a(Uri uri, ContentValues contentValues) {
        return null;
    }

    /* renamed from: a */
    public String mo16851a() {
        return "t_frequent";
    }

    /* renamed from: b */
    public void mo16854b() {
    }

    /* renamed from: e */
    private static ContentResolver m11853e() {
        try {
            if (InternalContainer.m10059a() != null) {
                return InternalContainer.m10059a().getContentResolver();
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    /* renamed from: a */
    public static boolean m11850a(String str) {
        if (InternalContainer.m10059a() == null) {
            return false;
        }
        try {
            ContentResolver e = m11853e();
            if (e != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(m11854f());
                sb.append("checkFrequency");
                sb.append("?rit=");
                sb.append(String.valueOf(str));
                return "true".equals(e.getType(Uri.parse(sb.toString())));
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    /* renamed from: c */
    public static boolean m11851c() {
        if (InternalContainer.m10059a() == null) {
            return false;
        }
        try {
            ContentResolver e = m11853e();
            if (e != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(m11854f());
                sb.append("isSilent");
                return "true".equals(e.getType(Uri.parse(sb.toString())));
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    /* renamed from: d */
    public static String m11852d() {
        if (InternalContainer.m10059a() == null) {
            return null;
        }
        try {
            ContentResolver e = m11853e();
            if (e != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(m11854f());
                sb.append("maxRit");
                return e.getType(Uri.parse(sb.toString()));
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    /* renamed from: f */
    private static String m11854f() {
        StringBuilder sb = new StringBuilder();
        sb.append(TTPathConst.f9099b);
        String str = "/";
        sb.append(str);
        sb.append("t_frequent");
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: a */
    public void mo16853a(Context context) {
        this.f9094a = context;
    }

    /* renamed from: a */
    public String mo16852a(Uri uri) {
        StringBuilder sb = new StringBuilder();
        sb.append("get type uri: ");
        sb.append(String.valueOf(uri));
        C2564t.m12220b("FrequentCallProviderImpl", sb.toString());
        String str = uri.getPath().split("/")[2];
        String str2 = "true";
        String str3 = "false";
        if ("checkFrequency".equals(str)) {
            if (!FrequentCallController.m9090a().mo15290a(uri.getQueryParameter("rit"))) {
                str2 = str3;
            }
            return str2;
        } else if ("isSilent".equals(str)) {
            if (!FrequentCallController.m9090a().mo15291b()) {
                str2 = str3;
            }
            return str2;
        } else if ("maxRit".equals(str)) {
            return FrequentCallController.m9090a().mo15292c();
        } else {
            return null;
        }
    }
}
