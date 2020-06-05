package com.jiayouya.travel.common.net;

import android.content.Context;
import android.util.Base64;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.jiayouya.travel.C2835b;
import com.jiayouya.travel.C2914d;
import com.jiayouya.travel.Launcher;
import com.jiayouya.travel.common.p244b.GloblaEx;
import com.jiayouya.travel.common.p246d.C2895d;
import com.readystatesoftware.chuck.ChuckInterceptor;
import ezy.app.data.Error;
import ezy.app.data.Token;
import ezy.app.p643a.Session;
import ezy.app.p643a.p644a.CryptoInterceptor;
import ezy.app.p643a.p644a.MockInterceptor;
import ezy.app.p643a.p644a.SignInterceptor;
import java.io.File;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;
import kotlin.text.C8313m;
import okhttp3.C8362ab;
import okhttp3.C8364ac;
import okhttp3.C8368b;
import okhttp3.C8370c;
import okhttp3.C8508u;
import okhttp3.C8508u.C8509a;
import okhttp3.C8513x.C8515a;
import okhttp3.C8518z.C8519a;
import p655io.reactivex.p667g.Schedulers;
import p681me.jessyan.retrofiturlmanager.RetrofitUrlManager;
import retrofit2.CallAdapter.C8624a;
import retrofit2.Converter.C8626a;
import retrofit2.Retrofit;
import retrofit2.Retrofit.C8660a;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.p708a.p709a.GsonConverterFactory;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo39189d2 = {"Lcom/jiayouya/travel/common/net/RetrofitFactory;", "", "()V", "INSTANCE", "Lretrofit2/Retrofit;", "getINSTANCE", "()Lretrofit2/Retrofit;", "errorText", "", "getErrorText", "()Ljava/lang/String;", "setErrorText", "(Ljava/lang/String;)V", "gson", "Lcom/google/gson/Gson;", "create", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.common.net.b */
public final class RetrofitFactory {
    /* renamed from: a */
    public static final RetrofitFactory f9659a;
    /* renamed from: b */
    private static final Retrofit f9660b;
    /* renamed from: c */
    private static String f9661c;
    /* access modifiers changed from: private|static|final */
    /* renamed from: d */
    public static final Gson f9662d = new Gson();

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "Lokhttp3/Response;", "kotlin.jvm.PlatformType", "chain", "Lokhttp3/Interceptor$Chain;", "intercept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: RetrofitFactory.kt */
    /* renamed from: com.jiayouya.travel.common.net.b$a */
    static final class C2906a implements C8508u {
        /* renamed from: a */
        final /* synthetic */ String f9663a;

        @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, mo39189d2 = {"<anonymous>", "", "run", "com/jiayouya/travel/common/net/RetrofitFactory$create$client$1$1$1$1"}, mo39190k = 3, mo39191mv = {1, 1, 15})
        /* compiled from: RetrofitFactory.kt */
        /* renamed from: com.jiayouya.travel.common.net.b$a$a */
        static final class C2907a implements Runnable {
            /* renamed from: a */
            final /* synthetic */ Error f9664a;

            C2907a(Error error) {
                this.f9664a = error;
            }

            public final void run() {
                GloblaEx.m12816a(this.f9664a.getMessage(), 0, 0, 6, null);
            }
        }

        C2906a(String str) {
            this.f9663a = str;
        }

        public final C8362ab intercept(C8509a aVar) {
            Error error;
            C8519a e = aVar.mo40246a().mo40650e();
            e.mo40662b("User-Agent", this.f9663a);
            e.mo40662b("DEVICEID", C2895d.f9632a.mo19948a());
            String str = null;
            if (Session.f27256a.mo38538b()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Bearer ");
                Token a = Session.f27256a.mo38534a();
                sb.append(a != null ? a.getAccessToken() : null);
                e.mo40662b("Authorization", sb.toString());
            }
            C8362ab a2 = aVar.mo40244a(e.mo40663b());
            if (!(a2.mo40091c() == 200 || a2.mo40091c() == 401)) {
                C8364ac h = a2.mo40097h();
                if (h != null) {
                    try {
                        error = (Error) RetrofitFactory.f9662d.fromJson(h.mo40127g(), Error.class);
                    } catch (JsonSyntaxException unused) {
                        error = null;
                    }
                    RetrofitFactory bVar = RetrofitFactory.f9659a;
                    if (error != null) {
                        str = error.getMessage();
                    }
                    bVar.mo20015a(str);
                    if (error != null) {
                        String message = error.getMessage();
                        if (message != null && (!C8313m.m35462a(message))) {
                            Launcher.f9545a.mo19814a().post(new C2907a(error));
                        }
                    }
                }
            }
            return a2;
        }
    }

    static {
        RetrofitFactory bVar = new RetrofitFactory();
        f9659a = bVar;
        RetrofitUrlManager.getInstance().putDomain("staticUrl", "https://android-common.lxsjgo.cn/");
        f9660b = bVar.m13096c();
    }

    private RetrofitFactory() {
    }

    /* renamed from: a */
    public final Retrofit mo20014a() {
        return f9660b;
    }

    /* renamed from: a */
    public final void mo20015a(String str) {
        f9661c = str;
    }

    /* renamed from: b */
    public final String mo20016b() {
        return f9661c;
    }

    /* renamed from: c */
    private final Retrofit m13096c() {
        byte[] decode = Base64.decode("4fabc0605e2d3f8b986dcf94610b36c5", 0);
        String a = C2914d.m13176a((Context) C2835b.f9544a);
        C8370c cVar = new C8370c(new File(C2835b.f9544a.getCacheDir(), "okhttp"), 209715200);
        C8515a b = RetrofitUrlManager.getInstance().with(new C8515a()).mo40622a(30, TimeUnit.SECONDS).mo40636c(30, TimeUnit.SECONDS).mo40633b(30, TimeUnit.SECONDS).mo40634b((C8508u) new ChuckInterceptor(C2835b.f9544a));
        C8271i.m35382a((Object) decode, "rsaPublicKey");
        Retrofit a2 = new C8660a().mo41371a(b.mo40630a((C8508u) new CryptoInterceptor(decode)).mo40630a((C8508u) new ParameterInterceptor()).mo40630a((C8508u) new SignInterceptor("2179a2684d5b28623802399f6f9038f7", null, 2, null)).mo40630a((C8508u) new MockInterceptor()).mo40630a((C8508u) new C2906a(a)).mo40627a(cVar).mo40626a((C8368b) new TokenAuthenticator(C2835b.f9544a)).mo40632a()).mo41368a("https://android-common.lxsjgo.cn/").mo41373a((C8626a) GsonConverterFactory.m37471a()).mo41372a((C8624a) RxJava2CallAdapterFactory.m37491a(Schedulers.m34968b())).mo41374a();
        C8271i.m35382a((Object) a2, "Retrofit.Builder().clien…()))\n            .build()");
        return a2;
    }
}
