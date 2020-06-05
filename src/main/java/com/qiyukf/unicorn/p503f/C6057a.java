package com.qiyukf.unicorn.p503f;

import android.os.Handler;
import android.text.TextUtils;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p412c.C5361a;
import com.qiyukf.basesdk.p412c.C5366b;
import com.qiyukf.nim.uikit.C5433b;
import com.qiyukf.nimlib.C5718b;
import com.qiyukf.nimlib.C5743d;
import com.qiyukf.nimlib.sdk.NIMClient;
import com.qiyukf.nimlib.sdk.Observer;
import com.qiyukf.nimlib.sdk.RequestCallbackWrapper;
import com.qiyukf.nimlib.sdk.StatusCode;
import com.qiyukf.nimlib.sdk.auth.AuthService;
import com.qiyukf.nimlib.sdk.auth.AuthServiceObserver;
import com.qiyukf.nimlib.sdk.auth.LoginInfo;
import com.qiyukf.nimlib.sdk.msg.MsgService;
import com.qiyukf.nimlib.sdk.msg.MsgServiceObserve;
import com.qiyukf.nimlib.sdk.msg.model.CustomNotification;
import com.qiyukf.unicorn.C6029d;
import com.qiyukf.unicorn.api.RequestCallback;
import com.qiyukf.unicorn.api.YSFUserInfo;
import com.qiyukf.unicorn.p499b.C6014b;
import com.qiyukf.unicorn.p503f.p504a.C6144e;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6120b;
import com.qiyukf.unicorn.p503f.p504a.p511e.C6147c;
import com.qiyukf.unicorn.p503f.p504a.p511e.C6163s;
import com.qiyukf.unicorn.p503f.p512b.C6166a;
import com.qiyukf.unicorn.p513g.C6171b;
import com.qiyukf.unicorn.p514h.C6185c;
import com.qiyukf.unicorn.p516j.C6207a;
import com.qiyukf.unicorn.p516j.C6221h;
import com.tencent.android.tpush.SettingsContentProvider;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import com.tencent.p605ep.commonbase.network.HttpStatus;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.qiyukf.unicorn.f.a */
public final class C6057a {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public String f18951a = C6014b.m23958g();
    /* access modifiers changed from: private */
    /* renamed from: b */
    public AtomicBoolean f18952b = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    /* renamed from: c */
    public Handler f18953c = C5361a.m22014b();
    /* renamed from: d */
    private RequestCallback<Void> f18954d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public int f18955e = 1;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public C6069a f18956f = new C6069a(this, 0);
    /* renamed from: g */
    private Observer<StatusCode> f18957g = new Observer<StatusCode>() {
        public final /* synthetic */ void onEvent(Object obj) {
            StatusCode statusCode = (StatusCode) obj;
            if (statusCode == StatusCode.LOGINED) {
                C6057a.this.f18955e = 0;
                C6057a.this.f18953c.removeCallbacks(C6057a.this.f18956f);
                C6057a.this.f18952b.set(false);
                C6029d.m24048h().mo28855b();
                C6029d.m24047g().mo29304g();
                C6171b.m24486a();
                C6057a.m24123j(C6057a.this);
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - C6014b.m23980r() >= 86400000) {
                    C6185c.m24532a(new C6163s(C6029d.m24039c()), C6185c.m24533a(), true);
                    C6014b.m23923a(currentTimeMillis);
                }
                return;
            }
            if (statusCode.wontAutoLogin()) {
                C6057a.this.m24119f();
            }
        }
    };
    /* renamed from: h */
    private Observer<CustomNotification> f18958h = new Observer<CustomNotification>() {
        public final /* synthetic */ void onEvent(Object obj) {
            C6144e attachment = ((CustomNotification) obj).getAttachment();
            if (attachment.getCmdId() == 41) {
                if (((C6120b) attachment).mo29103a() == 1) {
                    C6057a.this.m24111b(200);
                    return;
                }
                C6057a.this.m24111b((int) HttpStatus.SC_REQUEST_URI_TOO_LONG);
            }
        }
    };
    /* renamed from: i */
    private Runnable f18959i = new Runnable() {
        public final void run() {
            C6057a.this.m24111b((int) HttpStatus.SC_REQUEST_TIMEOUT);
        }
    };

    /* renamed from: com.qiyukf.unicorn.f.a$a */
    private class C6069a implements Runnable {
        private C6069a() {
        }

        /* synthetic */ C6069a(C6057a aVar, byte b) {
            this();
        }

        public final void run() {
            new C6207a<Void, C6165b>("Unicorn-HTTP", C6029d.m24043d()) {
                /* renamed from: a */
                final /* synthetic */ String f18973a;

                {
                    this.f18973a = r3;
                }

                /* access modifiers changed from: protected|final|synthetic */
                /* renamed from: a */
                public final /* synthetic */ Object mo27678a() {
                    return C6168c.m24475a(this.f18973a, C6014b.m23948d());
                }

                /* access modifiers changed from: protected|final|bridge|synthetic */
                /* renamed from: a */
                public final /* bridge */ /* synthetic */ void mo27679a(Object obj) {
                    C6057a.this.mo28912a((C6165b) obj);
                }
            }.mo29406a((Param[]) new Void[0]);
            C6057a.this.f18955e = C6057a.this.f18955e + 1;
        }
    }

    public C6057a() {
        ((AuthServiceObserver) NIMClient.getService(AuthServiceObserver.class)).observeOnlineStatus(this.f18957g, true);
        ((MsgServiceObserve) NIMClient.getService(MsgServiceObserve.class)).observeCustomNotification(this.f18958h, true);
        if (m24109b() == null) {
            m24104a(0);
            String q = C6014b.m23978q();
            if (!TextUtils.isEmpty(q)) {
                JSONObject a = C5366b.m22027a(q);
                if (a != null) {
                    C5366b.m22039e(a, "foreignid");
                    mo28913a();
                }
            }
            return;
        }
        m24117e();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24104a(int i) {
        C6014b.m23953e();
        m24105a((LoginInfo) null);
        this.f18952b.set(true);
        this.f18953c.removeCallbacks(this.f18956f);
        this.f18953c.postDelayed(this.f18956f, (long) i);
    }

    /* access modifiers changed from: private|static */
    /* renamed from: a */
    public static void m24105a(LoginInfo loginInfo) {
        String token;
        if (loginInfo == null) {
            token = null;
            C6014b.m23926a((String) null);
        } else {
            C6014b.m23926a(loginInfo.getAccount());
            token = loginInfo.getToken();
        }
        C6014b.m23935b(token);
    }

    /* renamed from: a */
    static /* synthetic */ void m24107a(C6057a aVar, String str, String str2) {
        aVar.f18951a = str;
        C6014b.m23954e(str);
        if (!TextUtils.isEmpty(str)) {
            C6014b.m23930a(str, str2);
        }
        if (C6029d.m24045e().isPullMessageFromServer) {
            C6221h.m24658a(Boolean.valueOf(true));
        }
    }

    /* renamed from: a */
    private boolean m24108a(final YSFUserInfo ySFUserInfo) {
        String str = ySFUserInfo.data;
        boolean z = TextUtils.isEmpty(str) || C5366b.m22035b(str) != null;
        if (!z) {
            C5264a.m21617a("AM", "user data is not json array");
            return false;
        }
        if (TextUtils.isEmpty(ySFUserInfo.userId)) {
            ySFUserInfo.userId = this.f18951a;
        }
        C6147c cVar = new C6147c();
        cVar.mo29181a(ySFUserInfo.userId);
        cVar.mo29183c(ySFUserInfo.authToken);
        cVar.mo29182b(ySFUserInfo.data);
        final String json = cVar.toJson(true);
        C6014b.m23979q(json);
        if (!mo28913a()) {
            return true;
        }
        final String d = C6029d.m24043d();
        final String d2 = C6014b.m23948d();
        final C60581 r10 = new RequestCallback<C6165b>() {
            public final void onException(Throwable th) {
                if (TextUtils.isEmpty(ySFUserInfo.authToken) || !TextUtils.isEmpty(ySFUserInfo.authToken)) {
                    C5361a.m22014b().post(new Runnable() {
                        public final void run() {
                            C6057a.this.m24111b(1000);
                        }
                    });
                }
            }

            public final void onFailed(final int i) {
                if (TextUtils.isEmpty(ySFUserInfo.authToken) || (!TextUtils.isEmpty(ySFUserInfo.authToken) && i != 200)) {
                    C6057a.this.m24111b(i);
                    C5361a.m22014b().post(new Runnable() {
                        public final void run() {
                            C6057a.this.m24111b(i);
                        }
                    });
                }
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                C6165b bVar = (C6165b) obj;
                if (!bVar.mo29234a().getAccount().equals(C6014b.m23921a())) {
                    C6057a.this.f18952b.set(true);
                    C6057a.this.f18953c.removeCallbacks(C6057a.this.f18956f);
                    C6057a.m24115d(C6057a.this);
                    C6057a.this.mo28912a(bVar);
                }
                if (TextUtils.isEmpty(C6057a.this.f18951a) && !TextUtils.isEmpty(ySFUserInfo.userId)) {
                    String a = C6014b.m23921a();
                    if (!TextUtils.isEmpty(a)) {
                        ((MsgService) NIMClient.getService(MsgService.class)).migrateMessages(a, C5433b.m22192b(), true);
                    }
                }
                if (json.equals(C6014b.m23978q())) {
                    C6014b.m23979q(null);
                }
                C6057a.m24107a(C6057a.this, ySFUserInfo.userId, C5433b.m22192b());
                C6014b.m23957f(ySFUserInfo.data);
                if (ySFUserInfo.authToken != null) {
                    C6014b.m23959g(ySFUserInfo.authToken);
                }
                if (TextUtils.isEmpty(ySFUserInfo.authToken)) {
                    C5361a.m22014b().post(new Runnable() {
                        public final void run() {
                            C6057a.this.m24111b(200);
                        }
                    });
                }
            }
        };
        final YSFUserInfo ySFUserInfo2 = ySFUserInfo;
        C60622 r4 = new C6207a<Void, Void>("Unicorn-HTTP") {
            /* access modifiers changed from: private|varargs */
            /* renamed from: b */
            public Void mo27678a() {
                String str = "fetchCrmData";
                String str2 = d;
                String str3 = d2;
                String str4 = ySFUserInfo2.userId;
                String str5 = ySFUserInfo2.data;
                String str6 = ySFUserInfo2.authToken;
                RequestCallback requestCallback = r10;
                String str7 = "/webapi/user/create.action";
                HashMap hashMap = new HashMap(2);
                hashMap.put("appkey", str2);
                hashMap.put("deviceid", str3);
                hashMap.put("foreignid", str4);
                hashMap.put("crminfo", str5);
                hashMap.put("authtoken", str6);
                try {
                    JSONObject a = C5366b.m22027a(C6166a.m24470b(str7, hashMap));
                    C6165b bVar = new C6165b();
                    int b = C5366b.m22034b(a, "code");
                    if (b == 200) {
                        JSONObject f = C5366b.m22040f(a, "info");
                        C5264a.m21620b("test", f.toString());
                        bVar.mo29235a(new LoginInfo(f.getString("accid"), f.getString("token")));
                        boolean z = true;
                        if (C5366b.m22034b(f, "push") != 1) {
                            z = false;
                        }
                        bVar.mo29236a(z);
                        C6014b.m23943c(C5366b.m22039e(f, "bid"));
                        requestCallback.onSuccess(bVar);
                    } else {
                        StringBuilder sb = new StringBuilder("fetch login data error, code: ");
                        sb.append(b);
                        C5264a.m21617a(str, sb.toString());
                        requestCallback.onFailed(b);
                    }
                } catch (Throwable th) {
                    C5264a.m21621b(str, "is catch", th);
                    requestCallback.onException(th);
                }
                return null;
            }
        };
        r4.mo29406a((Param[]) new Void[0]);
        return true;
    }

    /* renamed from: b */
    public static LoginInfo m24109b() {
        LoginInfo loginInfo = new LoginInfo(C6014b.m23921a(), C6014b.m23934b());
        C5433b.m22191a(loginInfo.getAccount());
        if (loginInfo.valid()) {
            return loginInfo;
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m24111b(int i) {
        RequestCallback<Void> requestCallback = this.f18954d;
        this.f18954d = null;
        if (requestCallback != null) {
            this.f18953c.removeCallbacks(this.f18959i);
            if (i == 200) {
                requestCallback.onSuccess(null);
            } else {
                requestCallback.onFailed(i);
            }
        }
    }

    /* renamed from: d */
    static /* synthetic */ void m24115d(C6057a aVar) {
        C6029d.m24047g().mo29302f();
        ((AuthService) NIMClient.getService(AuthService.class)).logout();
        m24105a((LoginInfo) null);
        C5743d.m23108a(StatusCode.UNLOGIN);
        C5264a.m21617a("setUserLogout status:", "UNLOGIN");
        aVar.f18951a = null;
        C6014b.m23953e();
        C6014b.m23954e(null);
        C6014b.m23957f(null);
        C6014b.m23959g(null);
        if (C6029d.m24048h() != null) {
            C6029d.m24048h().mo28857c();
        }
    }

    /* access modifiers changed from: private|static */
    /* renamed from: e */
    public static void m24117e() {
        C6029d.m24026a();
        C6029d.m24048h().mo28849a();
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m24119f() {
        m24104a(this.f18955e * 10 * 1000);
    }

    /* renamed from: j */
    static /* synthetic */ void m24123j(C6057a aVar) {
        String q = C6014b.m23978q();
        if (!TextUtils.isEmpty(q)) {
            JSONObject a = C5366b.m22027a(q);
            if (a != null) {
                YSFUserInfo ySFUserInfo = new YSFUserInfo();
                ySFUserInfo.userId = C5366b.m22039e(a, "foreignid");
                ySFUserInfo.authToken = C5366b.m22039e(a, "authToken");
                ySFUserInfo.data = C5366b.m22039e(a, "userinfo");
                aVar.m24108a(ySFUserInfo);
            }
        }
    }

    /* renamed from: a */
    public final void mo28912a(C6165b bVar) {
        if (this.f18952b.get()) {
            if (bVar == null || bVar.mo29234a() == null) {
                m24119f();
                return;
            }
            m24105a(bVar.mo29234a());
            if (bVar.mo29237b()) {
                ((AuthService) NIMClient.getService(AuthService.class)).openLocalCache(bVar.mo29234a().getAccount());
            }
            C5433b.m22191a(bVar.mo29234a().getAccount());
            ((AuthService) NIMClient.getService(AuthService.class)).login(bVar.mo29234a()).setCallback(new RequestCallbackWrapper<LoginInfo>() {
                public final /* synthetic */ void onResult(int i, Object obj, Throwable th) {
                    if (i == 200) {
                        C6057a.m24117e();
                    }
                }
            });
            ((AuthService) NIMClient.getService(AuthService.class)).changeSaverMode(0);
            C6171b.m24487a(false);
        }
    }

    /* renamed from: a */
    public final boolean mo28913a() {
        if (C5718b.m23018e() != null) {
            return true;
        }
        if (!this.f18952b.get()) {
            m24104a(0);
        }
        return false;
    }

    /* renamed from: a */
    public final boolean mo28914a(YSFUserInfo ySFUserInfo, RequestCallback<Void> requestCallback) {
        String str;
        if (ySFUserInfo == null) {
            if (this.f18952b.compareAndSet(true, false)) {
                this.f18953c.removeCallbacks(this.f18956f);
            }
            if (!TextUtils.isEmpty(this.f18951a)) {
                C6029d.m24047g().mo29302f();
                this.f18953c.postDelayed(new Runnable() {
                    public final void run() {
                        ((AuthService) NIMClient.getService(AuthService.class)).logout();
                        C6057a.m24105a((LoginInfo) null);
                        C5743d.m23108a(StatusCode.UNLOGIN);
                        C5264a.m21617a("onForeignLogout status:", "UNLOGIN");
                        C6057a.this.f18951a = null;
                        C6014b.m23953e();
                        C6014b.m23954e(null);
                        C6014b.m23957f(null);
                        C6014b.m23959g(null);
                        C6029d.m24048h().mo28857c();
                        C6057a.this.m24104a(0);
                    }
                }, 100);
            }
            if (requestCallback != null) {
                requestCallback.onSuccess(null);
            }
            return true;
        }
        String str2 = ySFUserInfo.userId;
        String str3 = "AM";
        if (TextUtils.isEmpty(this.f18951a) && TextUtils.isEmpty(str2)) {
            str = "anonymous user can not update user info";
        } else if (TextUtils.isEmpty(this.f18951a) || TextUtils.isEmpty(str2) || str2.equals(this.f18951a)) {
            if (requestCallback != null) {
                this.f18953c.postDelayed(this.f18959i, 45000);
                this.f18954d = requestCallback;
            }
            JSONObject jSONObject = new JSONObject();
            String str4 = "sdk_version";
            String str5 = SettingsContentProvider.KEY;
            C5366b.m22032a(jSONObject, str5, str4);
            C5366b.m22032a(jSONObject, ArgKey.KEY_VALUE, "53");
            C5366b.m22031a(jSONObject, "hidden", (Object) Boolean.valueOf(true));
            JSONArray b = C5366b.m22035b(ySFUserInfo.data);
            JSONArray jSONArray = new JSONArray();
            if (b != null) {
                for (int i = 0; i < b.length(); i++) {
                    JSONObject b2 = C5366b.m22036b(b, i);
                    if (!str4.equals(C5366b.m22039e(b2, str5))) {
                        C5366b.m22028a(jSONArray, (Object) b2);
                    }
                }
            }
            C5366b.m22028a(jSONArray, (Object) jSONObject);
            ySFUserInfo.data = jSONArray.toString();
            String h = C6014b.m23961h();
            String i2 = C6014b.m23963i();
            if (TextUtils.isEmpty(this.f18951a) || !TextUtils.equals(h, ySFUserInfo.data) || !TextUtils.equals(i2, ySFUserInfo.authToken)) {
                return m24108a(ySFUserInfo);
            }
            m24111b(200);
            return true;
        } else {
            str = "should logout first before switch userId";
        }
        C5264a.m21617a(str3, str);
        return false;
    }
}
