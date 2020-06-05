package com.jiayouya.travel;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.Observer;
import com.alibaba.android.arouter.p043a.ARouter;
import com.bumptech.glide.Glide;
import com.elvishew.xlog.LogConfiguration.C2603a;
import com.elvishew.xlog.XLog;
import com.elvishew.xlog.formatter.p227a.BorderFormatter;
import com.elvishew.xlog.formatter.p227a.DefaultBorderFormatter;
import com.elvishew.xlog.formatter.p228b.p229a.DefaultJsonFormatter;
import com.elvishew.xlog.formatter.p228b.p229a.JsonFormatter;
import com.jiayouya.travel.common.callback.EmptyCallback;
import com.jiayouya.travel.common.callback.ErrorCallback;
import com.jiayouya.travel.common.callback.LoadingCallback;
import com.jiayouya.travel.common.p245c.PreferenceRes;
import com.jiayouya.travel.common.p246d.InviteCodeUtil;
import com.jiayouya.travel.module.common.data.LaunchConfig;
import com.jiayouya.travel.module.common.data.User;
import com.jiayouya.travel.module.common.p257a.C2959f;
import com.jiayouya.travel.module.common.p257a.C2961h;
import com.jiayouya.travel.module.common.p258b.LauncherConfigEvent;
import com.jiayouya.travel.module.common.p260vm.ResidentMemoryModel;
import com.jiayouya.travel.module.p276me.p277a.C3109b;
import com.jiayouya.travel.module.travel.p286b.LogoutEvent;
import com.kingja.loadsir.callback.Callback;
import com.kingja.loadsir.core.LoadSir;
import com.qiyukf.unicorn.api.OnBotEventListener;
import com.qiyukf.unicorn.api.StatusBarNotificationConfig;
import com.qiyukf.unicorn.api.Unicorn;
import com.qiyukf.unicorn.api.YSFOptions;
import com.scwang.smartrefresh.header.PhoenixHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.p527a.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.p527a.RefreshLayout;
import com.tencent.android.tpush.XGIOperateCallback;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.CrashReport.UserStrategy;
import com.tencent.stat.StatAccount;
import com.tencent.stat.StatConfig;
import com.tencent.stat.StatService;
import com.travel.adlibrary.AdSdk;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.AlbumConfig;
import com.yanzhenjie.album.AlbumFile;
import com.yanzhenjie.album.AlbumLoader;
import ezy.app.data.Token;
import ezy.app.p643a.API;
import ezy.app.p643a.Session;
import ezy.app.p643a.Session.C8017a;
import ezy.app.p643a.Session.C8018b;
import ezy.app.p645rx.RxBus;
import ezy.assist.p647b.PhoneUtil;
import ezy.sdk3rd.social.PlatformConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8247b;
import p655io.reactivex.p664d.Consumer;
import p655io.reactivex.p666f.RxJavaPlugins;
import p681me.jessyan.retrofiturlmanager.RetrofitUrlManager;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0003J\b\u0010\u000f\u001a\u00020\bH\u0002J\b\u0010\u0010\u001a\u00020\bH\u0002J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u0014\u001a\u00020\bH\u0002J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u000e\u0010\u0018\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0019"}, mo39189d2 = {"Lcom/jiayouya/travel/Launcher;", "", "()V", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "initAlbum", "", "context", "Landroid/content/Context;", "initBugly", "app", "Landroid/app/Application;", "initFirst", "initLaunchConfig", "initLoadSir", "initMta", "initOpenInstall", "initQiyu", "initRefreshHeader", "initRouter", "initSession", "initXGPush", "initialize", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.c */
public final class Launcher {
    /* renamed from: a */
    public static final Launcher f9545a = new Launcher();
    /* renamed from: b */
    private static final Handler f9546b = new Handler(Looper.getMainLooper());

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, mo39189d2 = {"com/jiayouya/travel/Launcher$initAlbum$config$1", "Lcom/yanzhenjie/album/AlbumLoader;", "load", "", "imageView", "Landroid/widget/ImageView;", "albumFile", "Lcom/yanzhenjie/album/AlbumFile;", "url", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: Launcher.kt */
    /* renamed from: com.jiayouya.travel.c$a */
    public static final class C2836a implements AlbumLoader {
        C2836a() {
        }

        /* renamed from: a */
        public void mo19816a(ImageView imageView, AlbumFile albumFile) {
            mo19817a(imageView, albumFile != null ? albumFile.mo37485a() : null);
        }

        /* renamed from: a */
        public void mo19817a(ImageView imageView, String str) {
            if (imageView != null) {
                Glide.m5170a((View) imageView).mo12591a(str).mo12582a(imageView);
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/common/data/LaunchConfig;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: Launcher.kt */
    /* renamed from: com.jiayouya.travel.c$b */
    static final class C2837b<T> implements Consumer<LaunchConfig> {
        /* renamed from: a */
        public static final C2837b f9547a = new C2837b();

        C2837b() {
        }

        /* renamed from: a */
        public final void accept(LaunchConfig launchConfig) {
            PreferenceRes bVar = PreferenceRes.f9605b;
            C8271i.m35382a((Object) launchConfig, "it");
            bVar.mo19921a(launchConfig);
            RxBus.f27263a.mo38572a((Object) new LauncherConfigEvent());
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "run"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: Launcher.kt */
    /* renamed from: com.jiayouya.travel.c$c */
    static final class C2838c implements Runnable {
        /* renamed from: a */
        final /* synthetic */ Application f9548a;

        C2838c(Application application) {
            this.f9548a = application;
        }

        public final void run() {
            ResidentMemoryModel.f11323a.mo20739d().observeForever(new Observer<String>(this) {
                /* renamed from: a */
                final /* synthetic */ C2838c f9549a;

                {
                    this.f9549a = r1;
                }

                /* renamed from: a */
                public final void onChanged(String str) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("reportAccount uid:");
                    sb.append(str);
                    XLog.m12692b(sb.toString());
                    StatConfig.setCustomUserId(this.f9549a.f9548a, str);
                    StatService.reportAccount(this.f9549a.f9548a, new StatAccount(str, 7));
                }
            });
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, mo39189d2 = {"com/jiayouya/travel/Launcher$initQiyu$1", "Lcom/qiyukf/unicorn/api/OnBotEventListener;", "onUrlClick", "", "context", "Landroid/content/Context;", "url", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: Launcher.kt */
    /* renamed from: com.jiayouya.travel.c$d */
    public static final class C2840d extends OnBotEventListener {
        C2840d() {
        }

        public boolean onUrlClick(Context context, String str) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            if (context == null) {
                C8271i.m35380a();
            }
            context.startActivity(intent);
            return true;
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, mo39189d2 = {"<anonymous>", "Lcom/scwang/smartrefresh/header/PhoenixHeader;", "context", "Landroid/content/Context;", "layout", "Lcom/scwang/smartrefresh/layout/api/RefreshLayout;", "createRefreshHeader"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: Launcher.kt */
    /* renamed from: com.jiayouya.travel.c$e */
    static final class C2841e implements DefaultRefreshHeaderCreator {
        /* renamed from: a */
        public static final C2841e f9550a = new C2841e();

        C2841e() {
        }

        /* renamed from: b */
        public final PhoenixHeader mo19823a(Context context, RefreshLayout jVar) {
            C8271i.m35386b(context, "context");
            C8271i.m35386b(jVar, "layout");
            return new PhoenixHeader(context);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, mo39189d2 = {"com/jiayouya/travel/Launcher$initSession$1", "Lezy/app/net/Session$TokenStore;", "read", "Lezy/app/data/Token;", "save", "", "token", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: Launcher.kt */
    /* renamed from: com.jiayouya.travel.c$f */
    public static final class C2842f implements C8018b {
        C2842f() {
        }

        /* renamed from: a */
        public Token mo19825a() {
            return PreferenceRes.f9605b.mo19920a();
        }

        /* renamed from: a */
        public void mo19826a(Token token) {
            C8271i.m35386b(token, "token");
            PreferenceRes.f9605b.mo19922a(token);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b"}, mo39189d2 = {"com/jiayouya/travel/Launcher$initSession$2", "Lezy/app/net/Session$Callback;", "onAuthorised", "", "type", "", "onExpired", "onUnauthorised", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: Launcher.kt */
    /* renamed from: com.jiayouya.travel.c$g */
    public static final class C2843g implements C8017a {

        @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/common/data/User;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
        /* compiled from: Launcher.kt */
        /* renamed from: com.jiayouya.travel.c$g$a */
        static final class C2844a extends Lambda implements C8247b<User, Unit> {
            public static final C2844a INSTANCE = new C2844a();

            C2844a() {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((User) obj);
                return Unit.f27778a;
            }

            public final void invoke(User user) {
                C8271i.m35386b(user, "it");
                InviteCodeUtil.m12963a();
                C3109b.m13925a(API.f27251a).mo21212d().mo38904c((Consumer<? super T>) C28451.f9551a);
            }
        }

        @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "tk", "Lezy/app/data/Token;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
        /* compiled from: Launcher.kt */
        /* renamed from: com.jiayouya.travel.c$g$b */
        static final class C2846b<T> implements Consumer<Token> {
            /* renamed from: a */
            public static final C2846b f9552a = new C2846b();

            C2846b() {
            }

            /* renamed from: a */
            public final void accept(Token token) {
                Session bVar = Session.f27256a;
                C8271i.m35382a((Object) token, "tk");
                bVar.mo38539c(token);
            }
        }

        C2843g() {
        }

        /* renamed from: a */
        public void mo19827a() {
            Token a = Session.f27256a.mo38534a();
            if (a != null) {
                String refreshToken = a.getRefreshToken();
                if (refreshToken != null) {
                    C2959f.m13538a(API.f27251a).mo20411b(refreshToken).mo38904c((Consumer<? super T>) C2846b.f9552a);
                }
            }
        }

        /* renamed from: a */
        public void mo19828a(int i) {
            ResidentMemoryModel.m13597a(ResidentMemoryModel.f11323a, null, C2844a.INSTANCE, null, 5, null);
        }

        /* renamed from: b */
        public void mo19829b() {
            RetrofitUrlManager.getInstance().setGlobalDomain("https://android-common.lxsjgo.cn/");
            RxBus.f27263a.mo38572a((Object) new LogoutEvent());
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, mo39189d2 = {"com/jiayouya/travel/Launcher$initXGPush$1", "Lcom/tencent/android/tpush/XGIOperateCallback;", "onFail", "", "p0", "", "p1", "", "p2", "", "onSuccess", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: Launcher.kt */
    /* renamed from: com.jiayouya.travel.c$h */
    public static final class C2847h implements XGIOperateCallback {
        C2847h() {
        }

        public void onSuccess(Object obj, int i) {
            StringBuilder sb = new StringBuilder();
            sb.append("注册成功，设备token为：");
            sb.append(obj);
            XLog.m12691a(sb.toString());
        }

        public void onFail(Object obj, int i, String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("注册失败，错误码：");
            sb.append(i);
            sb.append(",错误信息：");
            sb.append(str);
            XLog.m12691a(sb.toString());
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "uid", "", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: Launcher.kt */
    /* renamed from: com.jiayouya.travel.c$i */
    static final class C2848i<T> implements Observer<String> {
        /* renamed from: a */
        final /* synthetic */ Application f9553a;

        C2848i(Application application) {
            this.f9553a = application;
        }

        /* renamed from: a */
        public final void onChanged(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("bind account ");
            sb.append(str);
            XLog.m12691a(sb.toString());
            XGPushManager.bindAccount(this.f9553a.getApplicationContext(), str);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: Launcher.kt */
    /* renamed from: com.jiayouya.travel.c$j */
    static final class C2849j<T> implements Consumer<Throwable> {
        /* renamed from: a */
        public static final C2849j f9554a = new C2849j();

        C2849j() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            XLog.m12692b(th.getMessage());
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "run"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: Launcher.kt */
    /* renamed from: com.jiayouya.travel.c$k */
    static final class C2850k implements Runnable {
        /* renamed from: a */
        final /* synthetic */ Application f9555a;

        C2850k(Application application) {
            this.f9555a = application;
        }

        public final void run() {
            Process.setThreadPriority(10);
            Thread.sleep(1000);
            Launcher.f9545a.m12747c(this.f9555a);
            Launcher.f9545a.m12753g(this.f9555a);
            Launcher.f9545a.m12754h(this.f9555a);
        }
    }

    /* renamed from: b */
    private final void m12744b(Application application) {
    }

    private Launcher() {
    }

    /* renamed from: a */
    public final Handler mo19814a() {
        return f9546b;
    }

    /* renamed from: a */
    public final void mo19815a(Application application) {
        C8271i.m35386b(application, "app");
        Context context = application;
        if (ezy.p642a.Context.m34746b(context)) {
            RxJavaPlugins.m34958a((Consumer<? super Throwable>) C2849j.f9554a);
            m12750d(application);
            m12751e(application);
            m12749d();
            m12746c();
            m12752f(application);
            m12741a(context);
            m12755i(application);
            m12743b();
            AdSdk.f25896a.mo37290a(application, false);
            m12744b(application);
            new Thread(new C2850k(application)).start();
        }
    }

    /* renamed from: b */
    private final void m12743b() {
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(C2841e.f9550a);
    }

    /* access modifiers changed from: private|final */
    /* renamed from: c */
    public final void m12747c(Application application) {
        StatConfig.setDebugEnable(true);
        StatConfig.isAutoExceptionCaught = false;
        Context context = application;
        StatConfig.setInstallChannel(context, C2914d.m13178a(context, null, 1, null));
        StatService.registerActivityLifecycleCallbacks(application);
        f9546b.post(new C2838c(application));
    }

    /* renamed from: d */
    private final void m12750d(Application application) {
        Context context = application;
        System.setProperty("http.agent", C2914d.m13176a(context));
        PlatformConfig.m34816a("wx9174e16b93c55a75");
        PlatformConfig.m34815a();
        XLog.m12689a(new C2603a().mo17086a("lxsj").mo17084a((BorderFormatter) new DefaultBorderFormatter()).mo17085a((JsonFormatter) new DefaultJsonFormatter()).mo17087a());
        PhoneUtil.m34785a(context);
    }

    /* renamed from: e */
    private final void m12751e(Application application) {
        ARouter.m2128a(application);
    }

    /* renamed from: c */
    private final void m12746c() {
        LoadSir.m14999b().mo22633a((Callback) new ErrorCallback()).mo22633a((Callback) new EmptyCallback()).mo22633a((Callback) new LoadingCallback()).mo22634a(LoadingCallback.class).mo22637c();
    }

    /* renamed from: d */
    private final void m12749d() {
        C2961h.m13543a(API.f27251a).mo20414a().mo38904c((Consumer<? super T>) C2837b.f9547a);
    }

    /* renamed from: f */
    private final void m12752f(Application application) {
        Session.f27256a.mo38535a(new C2842f(), new C2843g());
        Session.f27256a.mo38541d();
    }

    /* renamed from: a */
    private final void m12741a(Context context) {
        Album.m33247a(AlbumConfig.m33528a(context).mo37675a((AlbumLoader) new C2836a()).mo37676a());
    }

    /* access modifiers changed from: private|final */
    /* renamed from: g */
    public final void m12753g(Application application) {
        Context context = application;
        String a = C2914d.m13178a(context, null, 1, null);
        StringBuilder sb = new StringBuilder();
        sb.append("==========> channel = ");
        sb.append(a);
        XLog.m12691a(sb.toString());
        Beta.autoInit = true;
        Beta.autoCheckUpgrade = true;
        Beta.autoDownloadOnWifi = true;
        Beta.enableHotfix = false;
        Beta.appChannel = a;
        String str = "9c760292ff";
        Bugly.init(context, str, false);
        UserStrategy userStrategy = new UserStrategy(context);
        userStrategy.setAppChannel(a);
        userStrategy.setAppVersion("1.4.8");
        userStrategy.setDeviceID(PhoneUtil.f27267c);
        CrashReport.initCrashReport(context, str, false, userStrategy);
    }

    /* access modifiers changed from: private|final */
    /* renamed from: h */
    public final void m12754h(Application application) {
        YSFOptions ySFOptions = new YSFOptions();
        ySFOptions.statusBarNotificationConfig = new StatusBarNotificationConfig();
        ySFOptions.statusBarNotificationConfig.notificationSmallIconId = R.mipmap.ic_launcher;
        ySFOptions.onBotEventListener = new C2840d();
        Context context = application;
        Unicorn.init(context, "4ace4554575f3f3192f0da6ec596f645", ySFOptions, new GlideImageLoader(context));
    }

    /* renamed from: i */
    private final void m12755i(Application application) {
        Context context = application;
        XGPushConfig.enableOtherPush(context, true);
        XGPushConfig.enableDebug(context, false);
        XGPushConfig.setInstallChannel(context, C2914d.m13178a(context, null, 1, null));
        XGPushConfig.setHuaweiDebug(false);
        XGPushConfig.setMiPushAppId(context, "2882303761517974803");
        XGPushConfig.setMiPushAppKey(context, "5711797480803");
        StringBuilder sb = new StringBuilder();
        sb.append("push token：");
        sb.append(XGPushConfig.getToken(context));
        XLog.m12691a(sb.toString());
        XGPushManager.registerPush(context, (XGIOperateCallback) new C2847h());
        ResidentMemoryModel.f11323a.mo20739d().observeForever(new C2848i(application));
    }
}
