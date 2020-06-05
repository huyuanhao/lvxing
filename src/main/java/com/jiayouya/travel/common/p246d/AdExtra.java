package com.jiayouya.travel.common.p246d;

import android.view.View;
import androidx.core.app.NotificationCompat;
import com.elvishew.xlog.XLog;
import com.jiayouya.travel.Launcher;
import com.jiayouya.travel.module.common.data.User;
import com.jiayouya.travel.module.common.p257a.C2957b;
import com.jiayouya.travel.module.common.p258b.AdReportResultEvent;
import com.jiayouya.travel.module.common.p260vm.ResidentMemoryModel;
import com.travel.adlibrary.AdSdk;
import ezy.app.p643a.API;
import ezy.app.p645rx.RxBus;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8263r;
import okhttp3.C8364ac;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000.\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\u001a&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u001a\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0001\u001a0\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0007\u001a\u0016\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo39189d2 = {"AD_SHOW_TIME", "", "adExtra", "", "adLogId", "uid", "others", "dismissTextAdAuto", "", "adContainer", "Landroid/view/View;", "showTime", "reportEvent", "isBak", "", "adPlat", "event", "coin", "", "reportVideoEvent", "app_grRelease"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.common.d.a */
public final class AdExtra {

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: AdExtra.kt */
    /* renamed from: com.jiayouya.travel.common.d.a$a */
    static final class C2880a<T> implements Consumer<Throwable> {
        /* renamed from: a */
        final /* synthetic */ String f9612a;
        /* renamed from: b */
        final /* synthetic */ double f9613b;
        /* renamed from: c */
        final /* synthetic */ String f9614c;

        C2880a(String str, double d, String str2) {
            this.f9612a = str;
            this.f9613b = d;
            this.f9614c = str2;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            if (C8271i.m35384a((Object) this.f9612a, (Object) "show")) {
                XLog.m12692b("汇报失败");
                RxBus.f27263a.mo38572a((Object) new AdReportResultEvent(false, this.f9613b, this.f9614c));
                Launcher.f9545a.mo19814a().post(C28811.f9615a);
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lokhttp3/ResponseBody;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: AdExtra.kt */
    /* renamed from: com.jiayouya.travel.common.d.a$b */
    static final class C2882b<T> implements Consumer<C8364ac> {
        /* renamed from: a */
        final /* synthetic */ String f9616a;
        /* renamed from: b */
        final /* synthetic */ double f9617b;
        /* renamed from: c */
        final /* synthetic */ String f9618c;

        C2882b(String str, double d, String str2) {
            this.f9616a = str;
            this.f9617b = d;
            this.f9618c = str2;
        }

        /* renamed from: a */
        public final void accept(C8364ac acVar) {
            if (C8271i.m35384a((Object) this.f9616a, (Object) "show")) {
                RxBus.f27263a.mo38572a((Object) new AdReportResultEvent(true, this.f9617b, this.f9618c));
                StringBuilder sb = new StringBuilder();
                sb.append("汇报成功 刷新金币数量 coin==");
                sb.append(this.f9617b);
                XLog.m12691a(sb.toString());
                ResidentMemoryModel.f11323a.mo20733a(this.f9617b, 1);
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\n¢\u0006\u0002\b\n"}, mo39189d2 = {"<anonymous>", "", "methodName", "", "Lcom/travel/adlibrary/AdSdk$AdMethod;", "adPlat", "", "isBak", "extra", "", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: AdExtra.kt */
    /* renamed from: com.jiayouya.travel.common.d.a$c */
    static final class C2883c extends Lambda implements C8263r<String, Integer, Integer, Object, Unit> {
        final /* synthetic */ String $adLogId;
        final /* synthetic */ double $coin;

        C2883c(double d, String str) {
            this.$coin = d;
            this.$adLogId = str;
            super(4);
        }

        public /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            invoke((String) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue(), obj4);
            return Unit.f27778a;
        }

        public final void invoke(String str, int i, int i2, Object obj) {
            boolean z;
            C8271i.m35386b(str, "methodName");
            double d = this.$coin;
            if (obj != null) {
                try {
                    z = ((Boolean) obj).booleanValue();
                } catch (Exception unused) {
                    z = false;
                }
                if (z) {
                    d *= (double) 2;
                }
                double d2 = d;
                int hashCode = str.hashCode();
                if (hashCode != -1278354839) {
                    if (hashCode != 1606054569) {
                        if (hashCode == 1919870917 && str.equals("METHOD_ON_CLICKED")) {
                            int i3 = i2;
                            int i4 = i;
                            AdExtra.m12932a(i3, i4, "click", this.$adLogId, d2);
                        }
                    } else if (str.equals("METHOD_ON_DOWNLOADED")) {
                        int i5 = i2;
                        int i6 = i;
                        AdExtra.m12932a(i5, i6, "download", this.$adLogId, d2);
                    }
                } else if (str.equals("METHOD_ON_COMPLETED")) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("汇报开始 show  coin==");
                    sb.append(d2);
                    XLog.m12691a(sb.toString());
                    int i7 = i2;
                    int i8 = i;
                    AdExtra.m12932a(i7, i8, "show", this.$adLogId, d2);
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
            }
        }
    }

    /* renamed from: a */
    public static final void m12933a(View view, long j) {
        C8271i.m35386b(view, "adContainer");
    }

    /* renamed from: a */
    public static /* synthetic */ String m12931a(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        return m12930a(str, str2, str3);
    }

    /* renamed from: a */
    public static final String m12930a(String str, String str2, String str3) {
        C8271i.m35386b(str, "adLogId");
        if (str2 == null) {
            User user = (User) ResidentMemoryModel.f11323a.mo20737b().getValue();
            str2 = user != null ? user.getUid() : null;
        }
        String str4 = "";
        if (str2 == null) {
            str2 = str4;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{\"platform\":\"android\",\"appVersion\":\"1.4.8\",\"uid\":\"");
        sb.append(str2);
        sb.append("\",\"adId\":\"adIdValue\",\"adLogId\":\"");
        sb.append(str);
        sb.append('\"');
        if (str3 != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(',');
            sb2.append(str3);
            str4 = sb2.toString();
        }
        sb.append(str4);
        sb.append('}');
        return sb.toString();
    }

    /* renamed from: a */
    public static final void m12932a(int i, int i2, String str, String str2, double d) {
        C8271i.m35386b(str, NotificationCompat.CATEGORY_EVENT);
        C8271i.m35386b(str2, "adLogId");
        C2957b.m13527a(API.f27251a).mo20404a(i, i2, str, str2).mo38884a((Consumer<? super Throwable>) new C2880a<Object>(str, d, str2)).mo38904c((Consumer<? super T>) new C2882b<Object>(str, d, str2));
    }

    /* renamed from: a */
    public static final void m12935a(String str, double d) {
        C8271i.m35386b(str, "adLogId");
        AdSdk.f25896a.mo37293b().put("VIDEO_CALL_BACK_KEY", new C2883c(d, str));
    }

    /* renamed from: a */
    public static /* synthetic */ void m12934a(View view, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 6;
        }
        m12933a(view, j);
    }
}
