package com.qiyukf.unicorn;

import android.app.Instrumentation;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p412c.p417d.C5412d;
import com.qiyukf.basesdk.p412c.p417d.C5415g;
import com.qiyukf.nim.uikit.C5433b;
import com.qiyukf.nim.uikit.session.emoji.C5548i;
import com.qiyukf.nimlib.C5718b;
import com.qiyukf.nimlib.C5729c;
import com.qiyukf.nimlib.C5743d;
import com.qiyukf.nimlib.p453d.C5744a;
import com.qiyukf.nimlib.p453d.p463d.p464a.C5779b;
import com.qiyukf.nimlib.p453d.p463d.p464a.C5780c;
import com.qiyukf.nimlib.sdk.NIMClient;
import com.qiyukf.nimlib.sdk.SDKOptions;
import com.qiyukf.nimlib.sdk.auth.AuthService;
import com.qiyukf.unicorn.analytics.C5973a;
import com.qiyukf.unicorn.api.RequestCallback;
import com.qiyukf.unicorn.api.StatusBarNotificationConfig;
import com.qiyukf.unicorn.api.UnicornImageLoader;
import com.qiyukf.unicorn.api.YSFOptions;
import com.qiyukf.unicorn.api.YSFUserInfo;
import com.qiyukf.unicorn.apicloud.QYResUtils;
import com.qiyukf.unicorn.p499b.C6013a;
import com.qiyukf.unicorn.p499b.C6014b;
import com.qiyukf.unicorn.p500c.C6024a;
import com.qiyukf.unicorn.p501d.C6037a;
import com.qiyukf.unicorn.p503f.C6057a;
import com.qiyukf.unicorn.p503f.p512b.C6166a;
import com.qiyukf.unicorn.p513g.C6177d;
import com.qiyukf.unicorn.p514h.C6187d;
import com.qiyukf.unicorn.p515i.C6199a;
import com.qiyukf.unicorn.p515i.C6200b;
import com.qiyukf.unicorn.p516j.C6207a;
import com.qiyukf.unicorn.p516j.C6216d;
import com.qiyukf.unicorn.p516j.C6218e;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.qiyukf.unicorn.d */
public final class C6029d {
    /* renamed from: h */
    private static boolean f18846h = false;
    /* access modifiers changed from: private|static */
    /* renamed from: i */
    public static boolean f18847i = false;
    /* access modifiers changed from: private|static|final */
    /* renamed from: j */
    public static final Object f18848j = new Object();
    /* access modifiers changed from: private|static */
    /* renamed from: k */
    public static C6029d f18849k;
    /* access modifiers changed from: private|static */
    /* renamed from: l */
    public static List<C6036a> f18850l = new ArrayList();
    /* renamed from: a */
    private Context f18851a;
    /* renamed from: b */
    private String f18852b;
    /* renamed from: c */
    private YSFOptions f18853c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public UnicornImageLoader f18854d;
    /* renamed from: e */
    private C6187d f18855e;
    /* renamed from: f */
    private C6015c f18856f;
    /* renamed from: g */
    private C6057a f18857g;

    /* renamed from: com.qiyukf.unicorn.d$a */
    public interface C6036a {
        /* renamed from: a */
        void mo27687a();
    }

    private C6029d() {
    }

    /* renamed from: a */
    public static C6029d m24026a() {
        C6029d dVar = f18849k;
        if (dVar != null) {
            return dVar;
        }
        throw new IllegalStateException("QIYU not initialized!");
    }

    /* renamed from: a */
    public static C6029d m24027a(Context context, final String str, final YSFOptions ySFOptions, final UnicornImageLoader unicornImageLoader) {
        final Context applicationContext = context.getApplicationContext();
        if (Looper.myLooper() == Looper.getMainLooper()) {
            m24041c(applicationContext, str, ySFOptions, unicornImageLoader);
        } else {
            C6218e.m24652b(new Runnable() {
                public final void run() {
                    C6029d.m24041c(applicationContext, str, ySFOptions, unicornImageLoader);
                    synchronized (C6029d.f18848j) {
                        C6029d.f18848j.notifyAll();
                    }
                }
            });
            try {
                synchronized (f18848j) {
                    f18848j.wait();
                }
            } catch (InterruptedException unused) {
                C5264a.m21626e("QIYU", "init in background thread interrupt");
            }
        }
        return f18849k;
    }

    /* renamed from: a */
    public static void m24028a(final Context context) {
        if (!f18847i) {
            final C6013a a = C6013a.m23916a(context);
            if (a != null) {
                C6218e.m24652b(new Runnable() {
                    public final void run() {
                        C6029d.m24040c(context, a.mo28846a(), a.mo28847b());
                    }
                });
            }
        }
    }

    /* renamed from: a */
    public static void m24031a(C6036a aVar) {
        if (!f18850l.contains(aVar)) {
            f18850l.add(aVar);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m24032a(C6029d dVar, Context context) {
        C6024a.m24013a(context);
        dVar.f18855e = new C6187d(context);
        dVar.f18856f = new C6015c();
        dVar.f18857g = new C6057a();
        C5548i.m22560a().mo27673b();
        C6200b.m24602a();
        if (m24026a().f18853c.autoTrackUser) {
            try {
                Class cls = Class.forName("android.app.ActivityThread");
                Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(cls, new Object[0]);
                Field declaredField = cls.getDeclaredField("mInstrumentation");
                declaredField.setAccessible(true);
                declaredField.set(invoke, new C6199a((Instrumentation) declaredField.get(invoke)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        C5433b.m22190a(context, dVar.f18855e.mo29278a());
    }

    /* renamed from: b */
    static /* synthetic */ void m24033b(Context context, String str, YSFOptions ySFOptions) {
        StatusBarNotificationConfig statusBarNotificationConfig = ySFOptions.statusBarNotificationConfig;
        SDKOptions sDKOptions = new SDKOptions();
        sDKOptions.appKey = str;
        sDKOptions.statusBarNotificationConfig = statusBarNotificationConfig;
        sDKOptions.userInfoProvider = null;
        NIMClient.init(context, C6057a.m24109b(), sDKOptions, ySFOptions.logSwitch);
    }

    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static void m24035b(Context context, Throwable th) {
        C5264a.m21625d("QIYU", "init error.", th);
        if (C5743d.m23121f()) {
            C6037a.m24064a(th);
        }
        C5973a.m23882a(context);
        C5973a.m23884a(th);
    }

    /* renamed from: b */
    public static void m24037b(C6036a aVar) {
        f18850l.remove(aVar);
    }

    /* renamed from: b */
    public static boolean m24038b() {
        return f18847i;
    }

    /* renamed from: c */
    public static Context m24039c() {
        return m24026a().f18851a;
    }

    /* access modifiers changed from: private|static */
    /* renamed from: c */
    public static void m24040c(final Context context, final String str, final YSFOptions ySFOptions) {
        try {
            if (f18846h) {
                C5264a.m21626e("QIYU", "initialize has started");
                return;
            }
            f18846h = true;
            C5743d.m23107a(context);
            C6216d.m24649a(context);
            C6014b.m23924a(context, str);
            if (C5743d.m23121f()) {
                C5415g.m22162a(context);
                C5412d.m22147a(context);
                QYResUtils.init(context);
                C6029d dVar = new C6029d();
                f18849k = dVar;
                dVar.f18851a = context;
                f18849k.f18852b = str;
                f18849k.f18853c = ySFOptions == null ? YSFOptions.DEFAULT : ySFOptions;
            }
            C6218e.m24651a(new Runnable() {
                public final void run() {
                    try {
                        if (C5743d.m23121f()) {
                            C6013a.m23917a(context, str, ySFOptions);
                        }
                        C6029d.m24033b(context, str, ySFOptions == null ? YSFOptions.DEFAULT : ySFOptions);
                        if (C5743d.m23121f()) {
                            C6029d.m24032a(C6029d.f18849k, context);
                            C6037a.m24064a((Throwable) null);
                            C5780c cVar = new C5780c();
                            cVar.f18410b = false;
                            cVar.f18412d = false;
                            cVar.f18411c = false;
                            C5744a.m23125d().mo28020a(context, new C5779b("qy", C6029d.m24043d(), "4.10.0"), cVar);
                        }
                        C6029d.f18847i = true;
                        C6218e.m24652b(new Runnable() {
                            public final void run() {
                                for (C6036a aVar : C6029d.f18850l) {
                                    if (aVar != null) {
                                        aVar.mo27687a();
                                    }
                                }
                            }
                        });
                    } catch (Throwable th) {
                        C6029d.m24035b(context, th);
                    }
                }
            });
        } catch (Throwable th) {
            m24035b(context, th);
        }
    }

    /* access modifiers changed from: private|static */
    /* renamed from: c */
    public static void m24041c(Context context, String str, final YSFOptions ySFOptions, final UnicornImageLoader unicornImageLoader) {
        try {
            if (f18847i) {
                m24042c(ySFOptions);
            } else {
                m24040c(context, str, ySFOptions);
            }
            C6218e.m24651a(new Runnable() {
                public final void run() {
                    try {
                        if (C5743d.m23121f()) {
                            C6029d.m24044d(ySFOptions);
                            C6029d.f18849k.f18854d = unicornImageLoader;
                        }
                        if (C5743d.m23122g()) {
                            C6177d.m24495a().mo29246a(ySFOptions.savePowerConfig);
                        }
                    } catch (Throwable th) {
                        C5264a.m21625d("QIYU", "init error", th);
                    }
                }
            });
        } catch (Throwable th) {
            C5264a.m21625d("QIYU", "init error", th);
        }
    }

    /* renamed from: c */
    private static void m24042c(YSFOptions ySFOptions) {
        if (ySFOptions == null) {
            return;
        }
        if (C5743d.m23121f() || C5743d.m23122g()) {
            C5718b.m23017d().statusBarNotificationConfig = ySFOptions.statusBarNotificationConfig;
            C5729c.m23062a(ySFOptions.logSwitch);
            if (C5743d.m23121f()) {
                f18849k.f18853c = ySFOptions;
            }
        }
    }

    /* renamed from: d */
    public static String m24043d() {
        return m24026a().f18852b;
    }

    /* access modifiers changed from: private|static */
    /* renamed from: d */
    public static void m24044d(YSFOptions ySFOptions) {
        if (ySFOptions != null && ySFOptions.savePowerConfig != null && !TextUtils.equals(C6014b.m23970m(), ySFOptions.savePowerConfig.deviceIdentifier)) {
            C6014b.m23946c(false);
            C6014b.m23972n(ySFOptions.savePowerConfig.deviceIdentifier);
        }
    }

    /* renamed from: e */
    public static YSFOptions m24045e() {
        return m24026a().f18853c;
    }

    /* renamed from: f */
    public static UnicornImageLoader m24046f() {
        return m24026a().f18854d;
    }

    /* renamed from: g */
    public static C6187d m24047g() {
        return m24026a().f18855e;
    }

    /* renamed from: h */
    public static C6015c m24048h() {
        C6029d dVar = f18849k;
        if (dVar == null) {
            return null;
        }
        return dVar.f18856f;
    }

    /* renamed from: a */
    public final void mo28870a(YSFOptions ySFOptions) {
        if (f18847i && ySFOptions != null) {
            try {
                m24042c(ySFOptions);
                if (C5743d.m23121f()) {
                    C6013a.m23917a(this.f18851a, this.f18852b, ySFOptions);
                    m24044d(ySFOptions);
                    ((AuthService) NIMClient.getService(AuthService.class)).updateSavePowerConfig(ySFOptions.savePowerConfig);
                }
            } catch (Throwable th) {
                C5264a.m21625d("QIYU", "update options error.", th);
            }
        }
    }

    /* renamed from: a */
    public final void mo28871a(final String str, final String str2) {
        new C6207a<Void, Void>("Unicorn-HTTP") {
            /* access modifiers changed from: private|varargs */
            /* renamed from: b */
            public Void mo27678a() {
                String d = C6014b.m23948d();
                String d2 = C6029d.m24043d();
                String str = str;
                String str2 = str2;
                String str3 = "/webapi/user/accesshistory.action";
                HashMap hashMap = new HashMap(4);
                hashMap.put("appkey", d2);
                hashMap.put("deviceid", d);
                hashMap.put("uri", str);
                hashMap.put("title", str2);
                try {
                    C6166a.m24467a(str3, hashMap);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                return null;
            }
        }.mo29406a((Param[]) new Void[0]);
    }

    /* renamed from: a */
    public final boolean mo28872a(YSFUserInfo ySFUserInfo, RequestCallback<Void> requestCallback) {
        try {
            ((AuthService) NIMClient.getService(AuthService.class)).changeSaverMode(1);
            return this.f18857g.mo28914a(ySFUserInfo, requestCallback);
        } catch (Throwable th) {
            C5264a.m21625d("QIYU", "setUserInfo exception.", th);
            return false;
        }
    }

    /* renamed from: i */
    public final boolean mo28873i() {
        return this.f18857g.mo28913a();
    }
}
