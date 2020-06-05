package com.jiayouya.travel;

import android.content.Context;
import android.os.Build.VERSION;
import androidx.lifecycle.LifecycleOwner;
import com.jiayouya.travel.common.p246d.C2895d;
import com.meituan.android.walle.WalleChannelReader;
import com.tencent.p605ep.commonbase.api.ConfigManager.OEM;
import ezy.app.p645rx.C8019a;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.p679a.C8246a;
import p655io.reactivex.Observable;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006\u001a$\u0010\u0007\u001a\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b\u001a\n\u0010\f\u001a\u00020\r*\u00020\u000e\u001a\u0014\u0010\u000f\u001a\u00020\r*\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\r¨\u0006\u0011"}, mo39189d2 = {"post", "", "runnable", "Ljava/lang/Runnable;", "postDelayed", "delayMillis", "", "postDelayedWithLifecycle", "action", "Lkotlin/Function0;", "lifecycle", "Landroidx/lifecycle/LifecycleOwner;", "makeUserAgent", "", "Landroid/content/Context;", "resolveChannel", "default", "app_grRelease"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* compiled from: Launcher.kt */
/* renamed from: com.jiayouya.travel.d */
public final class C2914d {

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo39189d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept", "(Ljava/lang/Long;)V"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: Launcher.kt */
    /* renamed from: com.jiayouya.travel.d$a */
    static final class C2915a<T> implements Consumer<Long> {
        /* renamed from: a */
        final /* synthetic */ C8246a f9808a;

        C2915a(C8246a aVar) {
            this.f9808a = aVar;
        }

        /* renamed from: a */
        public final void accept(Long l) {
            this.f9808a.invoke();
        }
    }

    /* renamed from: a */
    public static /* synthetic */ String m13178a(Context context, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = OEM.DEFAULT;
        }
        return m13177a(context, str);
    }

    /* renamed from: a */
    public static final String m13177a(Context context, String str) {
        C8271i.m35386b(context, "$this$resolveChannel");
        C8271i.m35386b(str, OEM.DEFAULT);
        return String.valueOf(WalleChannelReader.m19531a(context, str));
    }

    /* renamed from: a */
    public static final String m13176a(Context context) {
        C8271i.m35386b(context, "$this$makeUserAgent");
        Object[] objArr = new Object[8];
        objArr[0] = "com.jiayouya.travel";
        objArr[1] = "1.4.8";
        objArr[2] = VERSION.RELEASE;
        Locale locale = Locale.getDefault();
        String str = "Locale.getDefault()";
        C8271i.m35382a((Object) locale, str);
        objArr[3] = locale.getLanguage();
        Locale locale2 = Locale.getDefault();
        C8271i.m35382a((Object) locale2, str);
        String country = locale2.getCountry();
        C8271i.m35382a((Object) country, "Locale.getDefault().country");
        if (country != null) {
            String lowerCase = country.toLowerCase();
            C8271i.m35382a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
            objArr[4] = lowerCase;
            objArr[5] = m13178a(context, null, 1, null);
            objArr[6] = Integer.valueOf(1040008);
            objArr[7] = C2895d.f9632a.mo19948a();
            String format = String.format("%s/%s (Linux; U; Android %s; %s-%s) (%s; %s) (DEVICEID %s)", Arrays.copyOf(objArr, objArr.length));
            C8271i.m35382a((Object) format, "java.lang.String.format(this, *args)");
            return format;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: a */
    public static final void m13179a(Runnable runnable) {
        C8271i.m35386b(runnable, "runnable");
        Launcher.f9545a.mo19814a().post(runnable);
    }

    /* renamed from: a */
    public static final void m13180a(Runnable runnable, long j) {
        C8271i.m35386b(runnable, "runnable");
        Launcher.f9545a.mo19814a().postDelayed(runnable, j);
    }

    /* renamed from: a */
    public static final void m13181a(C8246a<Unit> aVar, long j, LifecycleOwner lifecycleOwner) {
        C8271i.m35386b(aVar, "action");
        C8271i.m35386b(lifecycleOwner, "lifecycle");
        Observable a = Observable.m34992a(j, TimeUnit.MILLISECONDS);
        C8271i.m35382a((Object) a, "Observable.timer(delayMi…s, TimeUnit.MILLISECONDS)");
        C8019a.m34778a(a, lifecycleOwner, null, 2, null).mo37374a(new C2915a(aVar));
    }
}
