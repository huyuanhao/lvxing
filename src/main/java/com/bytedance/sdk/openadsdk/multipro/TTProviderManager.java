package com.bytedance.sdk.openadsdk.multipro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.multipro.p200a.DBMultiProviderImpl;
import com.bytedance.sdk.openadsdk.multipro.p204c.AdEventProviderImpl;
import com.bytedance.sdk.openadsdk.multipro.p204c.FrequentCallProviderImpl;
import com.bytedance.sdk.openadsdk.multipro.p205d.SPMultiProviderImpl;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.bytedance.sdk.openadsdk.multipro.f */
public class TTProviderManager implements ITTProvider {
    /* renamed from: a */
    private static volatile TTProviderManager f9100a;
    /* renamed from: b */
    private static WeakReference<Context> f9101b;
    /* renamed from: c */
    private static List<ITTProvider> f9102c = Collections.synchronizedList(new ArrayList());

    /* renamed from: c */
    private boolean m11913c(Uri uri) {
        return true;
    }

    /* renamed from: a */
    public String mo16851a() {
        return "";
    }

    /* renamed from: b */
    public void mo16854b() {
    }

    static {
        f9102c.add(new SPMultiProviderImpl());
        f9102c.add(new DBMultiProviderImpl());
        f9102c.add(new FrequentCallProviderImpl());
        f9102c.add(new AdEventProviderImpl());
        for (ITTProvider b : f9102c) {
            b.mo16854b();
        }
    }

    /* renamed from: b */
    public static TTProviderManager m11912b(Context context) {
        if (context != null) {
            f9101b = new WeakReference<>(context.getApplicationContext());
        }
        if (f9100a == null) {
            synchronized (TTProviderManager.class) {
                if (f9100a == null) {
                    f9100a = new TTProviderManager();
                }
            }
        }
        return f9100a;
    }

    private TTProviderManager() {
    }

    /* renamed from: b */
    private ITTProvider m11911b(Uri uri) {
        if (uri == null) {
            return null;
        }
        String str = "TTProviderManager";
        if (!m11913c(uri)) {
            C2564t.m12220b(str, "uri is error1");
            return null;
        }
        String[] split = uri.getPath().split("/");
        if (split.length < 2) {
            C2564t.m12220b(str, "uri is error2");
            return null;
        }
        String str2 = split[1];
        if (TextUtils.isEmpty(str2)) {
            C2564t.m12220b(str, "uri is error3");
            return null;
        }
        for (ITTProvider aVar : f9102c) {
            if (str2.equals(aVar.mo16851a())) {
                return aVar;
            }
        }
        C2564t.m12220b(str, "uri is error4");
        return null;
    }

    /* renamed from: a */
    public void mo16853a(Context context) {
        for (ITTProvider a : f9102c) {
            a.mo16853a(context);
        }
    }

    /* renamed from: a */
    public Cursor mo16849a(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        try {
            ITTProvider b = m11911b(uri);
            if (b != null) {
                return b.mo16849a(uri, strArr, str, strArr2, str2);
            }
            return null;
        } catch (Throwable th) {
            C2564t.m12216a("TTProviderManager", "==provider query error==", th);
            return null;
        }
    }

    /* renamed from: a */
    public String mo16852a(Uri uri) {
        try {
            ITTProvider b = m11911b(uri);
            if (b != null) {
                return b.mo16852a(uri);
            }
            return null;
        } catch (Throwable th) {
            C2564t.m12216a("TTProviderManager", "==provider getType error==", th);
            return null;
        }
    }

    /* renamed from: a */
    public Uri mo16850a(Uri uri, ContentValues contentValues) {
        try {
            ITTProvider b = m11911b(uri);
            if (b != null) {
                return b.mo16850a(uri, contentValues);
            }
            return null;
        } catch (Throwable th) {
            C2564t.m12216a("TTProviderManager", "==provider insert error==", th);
            return null;
        }
    }

    /* renamed from: a */
    public int mo16848a(Uri uri, String str, String[] strArr) {
        try {
            ITTProvider b = m11911b(uri);
            if (b != null) {
                return b.mo16848a(uri, str, strArr);
            }
            return 0;
        } catch (Throwable th) {
            C2564t.m12216a("TTProviderManager", "==provider delete error==", th);
            return 0;
        }
    }

    /* renamed from: a */
    public int mo16847a(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        try {
            ITTProvider b = m11911b(uri);
            if (b != null) {
                return b.mo16847a(uri, contentValues, str, strArr);
            }
            return 0;
        } catch (Throwable th) {
            C2564t.m12216a("TTProviderManager", "==provider update error==", th);
            return 0;
        }
    }
}
