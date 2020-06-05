package com.travel.adlibrary;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog.Builder;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.elvishew.xlog.XLog;
import com.tencent.mid.core.Constants;
import com.travel.adlibrary.p612a.AdOptions;
import com.travel.adlibrary.p612a.C7670b;
import com.travel.adlibrary.p612a.IAd;
import com.travel.adlibrary.p612a.IImageTextView;
import com.travel.adlibrary.p613b.KsAd;
import com.travel.adlibrary.p614c.TencentAd;
import com.travel.adlibrary.p615d.TTAd;
import com.travel.adlibrary.p617f.ZzAd;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.C7822a;
import com.yanzhenjie.permission.C7837e;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.runtime.Permission;
import com.yanzhenjie.permission.runtime.p640b.SettingRequest;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.C8187k;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.p679a.C8263r;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u0011\n\u0002\b\u000f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002STB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0002J\u0010\u0010;\u001a\u00020.2\b\b\u0001\u0010<\u001a\u00020\u000bJ\u0016\u0010=\u001a\u00020\u000f2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u000208J\u0010\u0010A\u001a\u0002082\u0006\u0010B\u001a\u00020CH\u0002J\u000e\u0010D\u001a\u0002082\u0006\u00109\u001a\u00020:J\b\u0010E\u001a\u00020\u000fH\u0002J\u0016\u0010F\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020C2\u0006\u0010G\u001a\u00020\u0005J\u0010\u0010H\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0002J\u000e\u0010I\u001a\u00020\u000f2\u0006\u0010J\u001a\u00020KJ&\u0010L\u001a\u00020\u000f2\u0006\u0010J\u001a\u00020K2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00050N2\u0006\u0010O\u001a\u00020PH\u0002J\u001e\u0010Q\u001a\u00020\u000f2\u0006\u0010J\u001a\u00020K2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00050NH\u0002R~\u0010\u0003\u001ao\u0012\u0004\u0012\u00020\u0005\u0012e\u0012c\u0012\u0018\u0012\u00160\u0005¢\u0006\u0002\b\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u001dX\u0004¢\u0006\u0004\n\u0002\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002020100¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u000e\u00105\u001a\u000206X\u000e¢\u0006\u0002\n\u0000¨\u0006U"}, mo39189d2 = {"Lcom/travel/adlibrary/AdSdk;", "", "()V", "CALL_BACK_MAP", "Ljava/util/WeakHashMap;", "", "Lkotlin/Function4;", "Lcom/travel/adlibrary/AdSdk$AdMethod;", "Lkotlin/ParameterName;", "name", "methodName", "", "adPlat", "isBack", "extra", "", "getCALL_BACK_MAP", "()Ljava/util/WeakHashMap;", "METHOD_ON_CLICKED", "METHOD_ON_COMPLETED", "METHOD_ON_DISMISS", "METHOD_ON_DOWNLOADED", "METHOD_ON_ERROR", "METHOD_ON_NO_AD", "METHOD_ON_SHOW", "METHOD_ON_TICK", "METHOD_ON_VIDEO_DISMISS", "METHOD_ON_VIDEO_LOADING", "PERMISSIONS", "", "[Ljava/lang/String;", "SPLASH_CALL_BACK_KEY", "TEXT_CALL_BACK_KEY", "TYPE_KS_VIDEO", "TYPE_TENCENT_IMAGE_TEXT", "TYPE_TENCENT_SPLASH", "TYPE_TENCENT_VIDEO", "TYPE_TT_IMAGE_TEXT", "TYPE_TT_INFO_FLOW", "TYPE_TT_SPLASH", "TYPE_TT_VIDEO", "TYPE_ZZ_VIDEO", "VIDEO_CALL_BACK_KEY", "VIDEO_LOADING_CALL_BACK_KEY", "ads", "", "Lcom/travel/adlibrary/common/IAd;", "imageTextViewList", "Ljava/util/LinkedList;", "Ljava/lang/ref/WeakReference;", "Lcom/travel/adlibrary/common/IImageTextView;", "getImageTextViewList", "()Ljava/util/LinkedList;", "lastShowVideo", "", "doLoadAction", "", "options", "Lcom/travel/adlibrary/common/AdOptions;", "getAdPlatform", "type", "init", "app", "Landroid/app/Application;", "isDebug", "isCanShow", "activity", "Landroid/app/Activity;", "loadAd", "onVideoLoading", "preLoadImageText", "adId", "processVideo", "requestPermission", "context", "Landroid/content/Context;", "showDefaultRationale", "permission", "", "executor", "Lcom/yanzhenjie/permission/RequestExecutor;", "showSetting", "permissions", "AdMethod", "AdType", "lib.ad_release"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: AdSdk.kt */
public final class AdSdk {
    /* renamed from: a */
    public static final AdSdk f25896a = new AdSdk();
    /* renamed from: b */
    private static final LinkedList<WeakReference<IImageTextView>> f25897b = new LinkedList<>();
    /* renamed from: c */
    private static final WeakHashMap<String, C8263r<String, Integer, Integer, Object, Unit>> f25898c = new WeakHashMap<>();
    /* renamed from: d */
    private static final String[] f25899d = {Constants.PERMISSION_READ_PHONE_STATE, "android.permission.ACCESS_FINE_LOCATION", Constants.PERMISSION_WRITE_EXTERNAL_STORAGE};
    /* renamed from: e */
    private static final List<IAd> f25900e = C8187k.m35271b(TTAd.f25945a, TencentAd.f25936a, ZzAd.f25966a, KsAd.f25928a);
    /* access modifiers changed from: private|static */
    /* renamed from: f */
    public static long f25901f;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, mo39189d2 = {"Lcom/travel/adlibrary/AdSdk$AdMethod;", "", "lib.ad_release"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    @Retention(RetentionPolicy.RUNTIME)
    /* compiled from: AdSdk.kt */
    /* renamed from: com.travel.adlibrary.AdSdk$AdMethod */
    public @interface AdMethod {
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, mo39189d2 = {"Lcom/travel/adlibrary/AdSdk$AdType;", "", "lib.ad_release"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    @Retention(RetentionPolicy.RUNTIME)
    /* compiled from: AdSdk.kt */
    /* renamed from: com.travel.adlibrary.AdSdk$AdType */
    public @interface AdType {
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "run"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: AdSdk.kt */
    /* renamed from: com.travel.adlibrary.AdSdk$a */
    static final class C7658a implements Runnable {
        /* renamed from: a */
        final /* synthetic */ Activity f25902a;

        C7658a(Activity activity) {
            this.f25902a = activity;
        }

        public final void run() {
            long currentTimeMillis = (((long) 60000) - (System.currentTimeMillis() - AdSdk.f25901f)) / ((long) 1000);
            Context context = this.f25902a;
            StringBuilder sb = new StringBuilder();
            sb.append("不能频繁观看视频，请在");
            sb.append(currentTimeMillis);
            sb.append("秒后再次观看");
            Toast.makeText(context, sb.toString(), 0).show();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032*\u0010\u0005\u001a&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\b0\u00062\u000e\u0010\t\u001a\n \u0004*\u0004\u0018\u00010\n0\nH\n¢\u0006\u0002\b\u000b"}, mo39189d2 = {"<anonymous>", "", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "data", "", "", "", "executor", "Lcom/yanzhenjie/permission/RequestExecutor;", "showRationale"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: AdSdk.kt */
    /* renamed from: com.travel.adlibrary.AdSdk$b */
    static final class C7659b<T> implements Rationale<List<String>> {
        /* renamed from: a */
        public static final C7659b f25903a = new C7659b();

        C7659b() {
        }

        /* renamed from: a */
        public final void mo19846a(Context context, List<String> list, C7837e eVar) {
            AdSdk adSdk = AdSdk.f25896a;
            C8271i.m35382a((Object) context, "context");
            C8271i.m35382a((Object) list, "data");
            C8271i.m35382a((Object) eVar, "executor");
            adSdk.m32948a(context, list, eVar);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00060\u0003H\n¢\u0006\u0002\b\u0007"}, mo39189d2 = {"<anonymous>", "", "perms", "", "", "kotlin.jvm.PlatformType", "", "onAction"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: AdSdk.kt */
    /* renamed from: com.travel.adlibrary.AdSdk$c */
    static final class C7660c<T> implements C7822a<List<String>> {
        /* renamed from: a */
        final /* synthetic */ Context f25904a;

        C7660c(Context context) {
            this.f25904a = context;
        }

        /* renamed from: a */
        public final void mo20720a(List<String> list) {
            XLog.m12692b("Permission onDenied");
            if (AndPermission.m33996a(this.f25904a, list)) {
                AdSdk adSdk = AdSdk.f25896a;
                Context context = this.f25904a;
                C8271i.m35382a((Object) list, "perms");
                adSdk.m32947a(context, list);
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00060\u0003H\n¢\u0006\u0002\b\u0007"}, mo39189d2 = {"<anonymous>", "", "it", "", "", "kotlin.jvm.PlatformType", "", "onAction"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: AdSdk.kt */
    /* renamed from: com.travel.adlibrary.AdSdk$d */
    static final class C7661d<T> implements C7822a<List<String>> {
        /* renamed from: a */
        final /* synthetic */ Context f25905a;

        C7661d(Context context) {
            this.f25905a = context;
        }

        /* renamed from: a */
        public final void mo20720a(List<String> list) {
            TTAdSdk.getAdManager().requestPermissionIfNecessary(this.f25905a);
            XLog.m12692b("Permission Granted");
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, mo39189d2 = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: AdSdk.kt */
    /* renamed from: com.travel.adlibrary.AdSdk$e */
    static final class C7662e implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C7837e f25906a;

        C7662e(C7837e eVar) {
            this.f25906a = eVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            this.f25906a.mo38051a();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, mo39189d2 = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: AdSdk.kt */
    /* renamed from: com.travel.adlibrary.AdSdk$f */
    static final class C7663f implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C7837e f25907a;

        C7663f(C7837e eVar) {
            this.f25907a = eVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            this.f25907a.mo38052b();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, mo39189d2 = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: AdSdk.kt */
    /* renamed from: com.travel.adlibrary.AdSdk$g */
    static final class C7664g implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ SettingRequest f25908a;

        C7664g(SettingRequest cVar) {
            this.f25908a = cVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            this.f25908a.mo38069a(100);
        }
    }

    private AdSdk() {
    }

    /* renamed from: a */
    public final LinkedList<WeakReference<IImageTextView>> mo37289a() {
        return f25897b;
    }

    /* renamed from: b */
    public final WeakHashMap<String, C8263r<String, Integer, Integer, Object, Unit>> mo37293b() {
        return f25898c;
    }

    /* renamed from: a */
    public final void mo37291a(Context context) {
        C8271i.m35386b(context, "context");
        AndPermission.m33993a(context).mo38048a().mo38062a(f25899d).mo38054a((Rationale<List<String>>) C7659b.f25903a).mo38057b(new C7660c(context)).mo38053a((C7822a<List<String>>) new C7661d<List<String>>(context)).mo38064l_();
    }

    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final void m32948a(Context context, List<String> list, C7837e eVar) {
        List a = Permission.m34115a(context, list);
        StringBuilder sb = new StringBuilder();
        sb.append("需要允许以下权限以便程序继续执行：\n\n");
        sb.append(TextUtils.join("\n", a));
        new Builder(context).setTitle((CharSequence) "提示").setMessage((CharSequence) sb.toString()).setPositiveButton((CharSequence) "确定", (OnClickListener) new C7662e(eVar)).setNegativeButton((CharSequence) "取消", (OnClickListener) new C7663f(eVar)).setCancelable(false).show();
    }

    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final void m32947a(Context context, List<String> list) {
        List a = Permission.m34115a(context, list);
        StringBuilder sb = new StringBuilder();
        sb.append("我们需要以下权限，请在设置中为我们开启：\n\n");
        sb.append(TextUtils.join("\n", a));
        new Builder(context).setTitle((CharSequence) "提示").setMessage((CharSequence) sb.toString()).setPositiveButton((CharSequence) "设置", (OnClickListener) new C7664g(AndPermission.m33993a(context).mo38048a().mo38060a())).setNegativeButton((CharSequence) "取消", (OnClickListener) null).setCancelable(false).show();
    }

    /* renamed from: a */
    public final boolean mo37292a(AdOptions aVar) {
        C8271i.m35386b(aVar, "options");
        return m32952b(aVar);
    }

    /* renamed from: a */
    public final void mo37290a(Application application, boolean z) {
        C8271i.m35386b(application, "app");
        for (IAd a : f25900e) {
            a.mo37324a(application, z);
        }
    }

    /* renamed from: b */
    private final boolean m32952b(AdOptions aVar) {
        if (aVar.mo37313i() != null) {
            return m32954c(aVar);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("adId==");
        sb.append(aVar.mo37305c());
        sb.append(" type==");
        sb.append(aVar.mo37301a());
        XLog.m12692b(sb.toString());
        int a = aVar.mo37301a();
        if (a != 2) {
            if (a != 3) {
                if (a != 5) {
                    if (a != 6) {
                        if (a == 7) {
                            mo37288a(aVar.mo37301a()).mo37330c(aVar);
                        }
                        return true;
                    }
                }
            }
            mo37288a(aVar.mo37301a()).mo37325a(aVar);
            return true;
        }
        mo37288a(aVar.mo37301a()).mo37329b(aVar);
        return true;
    }

    /* renamed from: c */
    private final boolean m32954c(AdOptions aVar) {
        if (!m32951a(aVar.mo37304b())) {
            return false;
        }
        if (aVar.mo37313i() != null && !aVar.mo37313i().isEmpty()) {
            C7670b bVar = (C7670b) aVar.mo37313i().poll();
            if (bVar != null) {
                m32953c();
                StringBuilder sb = new StringBuilder();
                sb.append("adPlat==");
                sb.append(mo37288a(bVar.mo37319b()).getClass().getName());
                sb.append("  ,id==");
                sb.append(bVar.mo37318a());
                XLog.m12692b(sb.toString());
                mo37288a(bVar.mo37319b()).mo37326a(aVar, bVar.mo37318a());
            }
        }
        return true;
    }

    /* renamed from: c */
    private final void m32953c() {
        XLog.m12692b("onVideoLoading");
        C8263r rVar = (C8263r) f25898c.get("VIDEO_LOADING_CALL_BACK_KEY");
        if (rVar != null) {
            Unit jVar = (Unit) rVar.invoke("METHOD_ON_VIDEO_LOADING", Integer.valueOf(0), Integer.valueOf(0), null);
        }
    }

    /* renamed from: a */
    public final IAd mo37288a(@AdType int i) {
        if (i == 1) {
            return TencentAd.f25936a;
        }
        if (i == 8) {
            return ZzAd.f25966a;
        }
        if (i != 9) {
            return TTAd.f25945a;
        }
        return KsAd.f25928a;
    }

    /* renamed from: a */
    private final boolean m32951a(Activity activity) {
        boolean z = System.currentTimeMillis() - f25901f >= ((long) 60000);
        if (!z) {
            activity.runOnUiThread(new C7658a(activity));
        } else {
            f25901f = System.currentTimeMillis();
        }
        return z;
    }
}
