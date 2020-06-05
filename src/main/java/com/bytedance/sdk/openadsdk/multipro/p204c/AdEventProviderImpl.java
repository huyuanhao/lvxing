package com.bytedance.sdk.openadsdk.multipro.p204c;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.multipro.ITTProvider;
import com.bytedance.sdk.openadsdk.multipro.ParamEncode;
import com.bytedance.sdk.openadsdk.multipro.TTPathConst;
import com.bytedance.sdk.openadsdk.p165c.AdEvent;
import com.bytedance.sdk.openadsdk.p165c.AdEventDispatcher;
import com.bytedance.sdk.openadsdk.p165c.AdEventRepertory;
import com.bytedance.sdk.openadsdk.p165c.AdEventRepertoryImpl;
import com.bytedance.sdk.openadsdk.p165c.AdEventThread.C2086a;
import com.bytedance.sdk.openadsdk.p165c.AdEventThread.C2087b;
import com.bytedance.sdk.openadsdk.p165c.StatsBatchEventRepertoryImpl;
import com.bytedance.sdk.openadsdk.p165c.StatsEventRepertoryImpl;
import com.bytedance.sdk.openadsdk.p165c.StatsEventThread;
import com.bytedance.sdk.openadsdk.p185f.p186a.ILogStats;
import com.bytedance.sdk.openadsdk.p185f.p187b.LogUploaderImpl;
import com.bytedance.sdk.openadsdk.p185f.p187b.LogUploaderImpl.C2424a;
import com.bytedance.sdk.openadsdk.p199j.TrackAdUrl;
import com.bytedance.sdk.openadsdk.p199j.TrackAdUrlImpl;
import com.bytedance.sdk.openadsdk.p199j.TrackRetryRepertoryImpl;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.C2566w;
import com.tencent.mid.sotrage.StorageInterface;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.multipro.c.a */
public class AdEventProviderImpl implements ITTProvider {
    /* renamed from: a */
    private Context f9087a;

    /* compiled from: AdEventProviderImpl */
    /* renamed from: com.bytedance.sdk.openadsdk.multipro.c.a$a */
    private static class C2524a implements ILogStats {
        /* renamed from: a */
        JSONObject f9088a;

        /* access modifiers changed from: private|static */
        /* renamed from: b */
        public static C2524a m11840b(String str) {
            return new C2524a(str);
        }

        private C2524a(String str) {
            try {
                this.f9088a = new JSONObject(str);
            } catch (Throwable unused) {
            }
        }

        /* renamed from: a */
        public JSONObject mo16587a() {
            return this.f9088a;
        }
    }

    /* compiled from: AdEventProviderImpl */
    /* renamed from: com.bytedance.sdk.openadsdk.multipro.c.a$b */
    private static class C2525b {
        /* renamed from: a */
        private static volatile AdEventDispatcher<AdEvent> f9089a;
        /* renamed from: b */
        private static volatile AdEventDispatcher<C2424a> f9090b;
        /* renamed from: c */
        private static volatile AdEventDispatcher<C2424a> f9091c;

        /* renamed from: a */
        static AdEventDispatcher<AdEvent> m11842a() {
            if (f9089a == null) {
                synchronized (InternalContainer.class) {
                    if (f9089a == null) {
                        f9089a = new AdEventDispatcher<>(new AdEventRepertoryImpl(InternalContainer.m10059a()), InternalContainer.m10067f(), C2087b.m8469a(), m11846d());
                    }
                }
            }
            return f9089a;
        }

        /* renamed from: b */
        public static AdEventDispatcher<C2424a> m11844b() {
            if (f9091c == null) {
                synchronized (InternalContainer.class) {
                    if (f9091c == null) {
                        f9091c = m11843a("ttad_bk_batch_stats", "AdStatsEventBatchThread", false);
                    }
                }
            }
            return f9091c;
        }

        /* renamed from: c */
        public static AdEventDispatcher<C2424a> m11845c() {
            if (f9090b == null) {
                synchronized (InternalContainer.class) {
                    if (f9090b == null) {
                        f9090b = m11843a("ttad_bk_stats", "AdStatsEventThread", true);
                    }
                }
            }
            return f9090b;
        }

        /* renamed from: a */
        public static AdEventDispatcher<C2424a> m11843a(String str, String str2, boolean z) {
            AdEventRepertory eVar;
            C2087b bVar;
            if (z) {
                eVar = new StatsEventRepertoryImpl(InternalContainer.m10059a());
                bVar = C2087b.m8469a();
            } else {
                bVar = C2087b.m8470b();
                eVar = new StatsBatchEventRepertoryImpl(InternalContainer.m10059a());
            }
            C2086a d = m11846d();
            StatsEventThread oVar = new StatsEventThread(str, str2, eVar, null, bVar, d);
            AdEventDispatcher bVar2 = new AdEventDispatcher(eVar, null, bVar, d, oVar);
            return bVar2;
        }

        /* renamed from: d */
        private static C2086a m11846d() {
            return new C2086a() {
                /* renamed from: a */
                public boolean mo15017a() {
                    return C2566w.m12241a(InternalContainer.m10059a());
                }
            };
        }
    }

    /* compiled from: AdEventProviderImpl */
    /* renamed from: com.bytedance.sdk.openadsdk.multipro.c.a$c */
    private static class C2527c {
        /* renamed from: a */
        private static volatile LogUploaderImpl f9092a;

        /* renamed from: a */
        public static LogUploaderImpl m11848a() {
            if (f9092a == null) {
                synchronized (LogUploaderImpl.class) {
                    if (f9092a == null) {
                        f9092a = new LogUploaderImpl();
                    }
                }
            }
            return f9092a;
        }
    }

    /* compiled from: AdEventProviderImpl */
    /* renamed from: com.bytedance.sdk.openadsdk.multipro.c.a$d */
    private static class C2528d {
        /* renamed from: a */
        private static volatile TrackAdUrl f9093a;

        /* renamed from: a */
        public static TrackAdUrl m11849a() {
            if (f9093a == null) {
                synchronized (TrackAdUrl.class) {
                    if (f9093a == null) {
                        f9093a = new TrackAdUrlImpl(InternalContainer.m10059a(), new TrackRetryRepertoryImpl(InternalContainer.m10059a()));
                    }
                }
            }
            return f9093a;
        }
    }

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
        return "t_event_ad_event";
    }

    /* renamed from: b */
    public void mo16854b() {
    }

    /* renamed from: e */
    private static ContentResolver m11829e() {
        try {
            if (InternalContainer.m10059a() != null) {
                return InternalContainer.m10059a().getContentResolver();
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    /* renamed from: c */
    public static void m11826c() {
        if (InternalContainer.m10059a() != null) {
            try {
                ContentResolver e = m11829e();
                if (e != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(m11830f());
                    sb.append("adEventStart");
                    e.getType(Uri.parse(sb.toString()));
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m11824a(boolean z) {
        if (InternalContainer.m10059a() != null) {
            try {
                ContentResolver e = m11829e();
                if (e != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("?isRealTime=");
                    sb.append(String.valueOf(z));
                    String sb2 = sb.toString();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(m11830f());
                    sb3.append("logStatusStart");
                    sb3.append(sb2);
                    e.getType(Uri.parse(sb3.toString()));
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m11821a(String str) {
        if (!TextUtils.isEmpty(str)) {
            String str2 = "AdEventProviderImpl";
            C2564t.m12220b(str2, "dispatch event");
            try {
                ContentResolver e = m11829e();
                if (e != null) {
                    String a = ParamEncode.m11819a(str);
                    StringBuilder sb = new StringBuilder();
                    sb.append(m11830f());
                    sb.append("adEventDispatch");
                    sb.append("?event=");
                    sb.append(a);
                    e.getType(Uri.parse(sb.toString()));
                }
            } catch (Throwable th) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("dispatch event Throwable:");
                sb2.append(th.toString());
                C2564t.m12226e(str2, sb2.toString());
            }
        }
    }

    /* renamed from: a */
    public static void m11822a(String str, List<String> list, boolean z) {
        if (!TextUtils.isEmpty(str) && list != null && !list.isEmpty()) {
            try {
                StringBuilder sb = new StringBuilder();
                for (String a : list) {
                    sb.append(ParamEncode.m11819a(a));
                    sb.append(StorageInterface.KEY_SPLITER);
                }
                String a2 = ParamEncode.m11819a(sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("?did=");
                sb2.append(String.valueOf(str));
                sb2.append("&track=");
                sb2.append(String.valueOf(a2));
                sb2.append("&replace=");
                sb2.append(String.valueOf(z));
                String sb3 = sb2.toString();
                ContentResolver e = m11829e();
                if (e != null) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(m11830f());
                    sb4.append("trackUrl");
                    sb4.append(sb3);
                    e.getType(Uri.parse(sb4.toString()));
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: b */
    public static void m11825b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                ContentResolver e = m11829e();
                if (e != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(m11830f());
                    sb.append("trackFailed");
                    sb.append("?did=");
                    sb.append(String.valueOf(str));
                    e.getType(Uri.parse(sb.toString()));
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: d */
    public static void m11828d() {
        try {
            ContentResolver e = m11829e();
            if (e != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(m11830f());
                sb.append("logStatusInit");
                e.getType(Uri.parse(sb.toString()));
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: c */
    public static void m11827c(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                ContentResolver e = m11829e();
                if (e != null) {
                    String a = ParamEncode.m11819a(str);
                    StringBuilder sb = new StringBuilder();
                    sb.append(m11830f());
                    sb.append("logStatusUpload");
                    sb.append("?event=");
                    sb.append(a);
                    e.getType(Uri.parse(sb.toString()));
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m11823a(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            try {
                ContentResolver e = m11829e();
                if (e != null) {
                    String a = ParamEncode.m11819a(str);
                    StringBuilder sb = new StringBuilder();
                    sb.append("?event=");
                    sb.append(a);
                    sb.append("&isRealTime=");
                    sb.append(String.valueOf(z));
                    String sb2 = sb.toString();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(m11830f());
                    sb3.append("logStatusDispatch");
                    sb3.append(sb2);
                    e.getType(Uri.parse(sb3.toString()));
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: f */
    private static String m11830f() {
        StringBuilder sb = new StringBuilder();
        sb.append(TTPathConst.f9099b);
        String str = "/";
        sb.append(str);
        sb.append("t_event_ad_event");
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: a */
    public void mo16853a(Context context) {
        this.f9087a = context;
    }

    /* renamed from: a */
    public String mo16852a(Uri uri) {
        String str = uri.getPath().split("/")[2];
        String str2 = "AdEventProviderImpl";
        if ("adEventStart".equals(str)) {
            C2564t.m12220b(str2, "====ad event function will be start====");
            C2525b.m11842a().mo14997a();
        } else {
            String str3 = "isRealTime";
            if ("logStatusStart".equals(str)) {
                C2564t.m12220b(str2, "====log stats function will be start====");
                if (Boolean.valueOf(uri.getQueryParameter(str3)).booleanValue()) {
                    C2525b.m11845c().mo14997a();
                } else {
                    C2525b.m11844b().mo14997a();
                }
            } else {
                boolean equals = "adEventDispatch".equals(str);
                String str4 = NotificationCompat.CATEGORY_EVENT;
                if (equals) {
                    C2564t.m12220b(str2, "dispatch FUN_AD_EVENT_DISPATCH");
                    AdEvent a = AdEvent.m8354a(ParamEncode.m11820b(uri.getQueryParameter(str4)));
                    if (a != null) {
                        C2525b.m11842a().mo14998a(a);
                    }
                } else if ("logStatusDispatch".equals(str)) {
                    Boolean valueOf = Boolean.valueOf(uri.getQueryParameter(str3));
                    C2424a a2 = C2424a.m11352a(ParamEncode.m11820b(uri.getQueryParameter(str4)));
                    if (a2 == null) {
                        return null;
                    }
                    if (valueOf.booleanValue()) {
                        C2525b.m11845c().mo14998a(a2);
                    } else {
                        C2525b.m11844b().mo14998a(a2);
                    }
                } else {
                    String str5 = "did";
                    if ("trackUrl".equals(str)) {
                        try {
                            String queryParameter = uri.getQueryParameter(str5);
                            boolean booleanValue = Boolean.valueOf(uri.getQueryParameter("replace")).booleanValue();
                            String[] split = ParamEncode.m11820b(uri.getQueryParameter("track")).split(StorageInterface.KEY_SPLITER);
                            if (split.length > 0) {
                                ArrayList arrayList = new ArrayList();
                                for (String b : split) {
                                    String b2 = ParamEncode.m11820b(b);
                                    if (!TextUtils.isEmpty(b2)) {
                                        arrayList.add(b2);
                                    }
                                }
                                C2528d.m11849a().mo16824a(queryParameter, arrayList, booleanValue);
                            }
                        } catch (Throwable unused) {
                        }
                    } else if ("trackFailed".equals(str)) {
                        String queryParameter2 = uri.getQueryParameter(str5);
                        C2528d.m11849a().mo16823a(queryParameter2);
                        StringBuilder sb = new StringBuilder();
                        sb.append("track failed: ");
                        sb.append(String.valueOf(queryParameter2));
                        C2564t.m12220b(str2, sb.toString());
                    } else if ("logStatusInit".equals(str)) {
                        C2527c.m11848a().mo16615a();
                    } else if ("logStatusUpload".equals(str)) {
                        String b3 = ParamEncode.m11820b(uri.getQueryParameter(str4));
                        if (!TextUtils.isEmpty(b3)) {
                            C2527c.m11848a().mo16616a((ILogStats) C2524a.m11840b(b3));
                        }
                    }
                }
            }
        }
        return null;
    }
}
