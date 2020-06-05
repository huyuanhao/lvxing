package com.travel.adlibrary.p612a;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.core.imageloader.core.download.BaseImageDownloader;
import com.tencent.android.tpush.common.Constants;
import com.travel.adlibrary.AdSdk.AdType;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.p679a.C8258m;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b,\b\b\u0018\u00002\u00020\u0001BÁ\u0001\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012:\b\u0002\u0010\u0017\u001a4\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0018¢\u0006\u0002\u0010\u001eJ\t\u00107\u001a\u00020\u0003HÆ\u0003J\u0011\u00108\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0016HÆ\u0003J;\u0010;\u001a4\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0018HÆ\u0003J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\t\u0010=\u001a\u00020\u0007HÆ\u0003J\t\u0010>\u001a\u00020\u0007HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010C\u001a\u00020\u0010HÆ\u0003JË\u0001\u0010D\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00162:\b\u0002\u0010\u0017\u001a4\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0018HÆ\u0001J\u0013\u0010E\u001a\u00020\u00162\b\u0010F\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010G\u001a\u00020\u0003HÖ\u0001J\t\u0010H\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0019\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$RC\u0010\u0017\u001a4\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\"R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010,\"\u0004\b-\u0010.R\u001a\u0010\u0014\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010/\"\u0004\b0\u00101R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010/R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010/R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\"¨\u0006I"}, mo39189d2 = {"Lcom/travel/adlibrary/common/AdOptions;", "", "type", "", "activity", "Landroid/app/Activity;", "adId", "", "userId", "container", "Landroid/view/ViewGroup;", "showTime", "skipView", "Landroid/view/View;", "extra", "infoFlowWidth", "", "adVideoList", "Ljava/util/LinkedList;", "Lcom/travel/adlibrary/common/AdPlatform;", "isUseBack", "isOnlyPreLoad", "", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "rewardVerify", "isLong", "", "(ILandroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Landroid/view/ViewGroup;ILandroid/view/View;Ljava/lang/String;FLjava/util/LinkedList;IZLkotlin/jvm/functions/Function2;)V", "getActivity", "()Landroid/app/Activity;", "getAdId", "()Ljava/lang/String;", "getAdVideoList", "()Ljava/util/LinkedList;", "getCallback", "()Lkotlin/jvm/functions/Function2;", "getContainer", "()Landroid/view/ViewGroup;", "getExtra", "getInfoFlowWidth", "()F", "()Z", "setOnlyPreLoad", "(Z)V", "()I", "setUseBack", "(I)V", "getShowTime", "getSkipView", "()Landroid/view/View;", "getType", "getUserId", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "lib.ad_release"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.travel.adlibrary.a.a */
public final class AdOptions {
    /* renamed from: a */
    private final int f25909a;
    /* renamed from: b */
    private final Activity f25910b;
    /* renamed from: c */
    private final String f25911c;
    /* renamed from: d */
    private final String f25912d;
    /* renamed from: e */
    private final ViewGroup f25913e;
    /* renamed from: f */
    private final int f25914f;
    /* renamed from: g */
    private final View f25915g;
    /* renamed from: h */
    private final String f25916h;
    /* renamed from: i */
    private final float f25917i;
    /* renamed from: j */
    private final LinkedList<C7670b> f25918j;
    /* renamed from: k */
    private int f25919k;
    /* renamed from: l */
    private boolean f25920l;
    /* renamed from: m */
    private final C8258m<Boolean, Boolean, Unit> f25921m;

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof AdOptions) {
                AdOptions aVar = (AdOptions) obj;
                if ((this.f25909a == aVar.f25909a) && C8271i.m35384a((Object) this.f25910b, (Object) aVar.f25910b) && C8271i.m35384a((Object) this.f25911c, (Object) aVar.f25911c) && C8271i.m35384a((Object) this.f25912d, (Object) aVar.f25912d) && C8271i.m35384a((Object) this.f25913e, (Object) aVar.f25913e)) {
                    if ((this.f25914f == aVar.f25914f) && C8271i.m35384a((Object) this.f25915g, (Object) aVar.f25915g) && C8271i.m35384a((Object) this.f25916h, (Object) aVar.f25916h) && Float.compare(this.f25917i, aVar.f25917i) == 0 && C8271i.m35384a((Object) this.f25918j, (Object) aVar.f25918j)) {
                        if (this.f25919k == aVar.f25919k) {
                            if (!(this.f25920l == aVar.f25920l) || !C8271i.m35384a((Object) this.f25921m, (Object) aVar.f25921m)) {
                                return false;
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.f25909a * 31;
        Activity activity = this.f25910b;
        int i2 = 0;
        int hashCode = (i + (activity != null ? activity.hashCode() : 0)) * 31;
        String str = this.f25911c;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f25912d;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        ViewGroup viewGroup = this.f25913e;
        int hashCode4 = (((hashCode3 + (viewGroup != null ? viewGroup.hashCode() : 0)) * 31) + this.f25914f) * 31;
        View view = this.f25915g;
        int hashCode5 = (hashCode4 + (view != null ? view.hashCode() : 0)) * 31;
        String str3 = this.f25916h;
        int hashCode6 = (((hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31) + Float.floatToIntBits(this.f25917i)) * 31;
        LinkedList<C7670b> linkedList = this.f25918j;
        int hashCode7 = (((hashCode6 + (linkedList != null ? linkedList.hashCode() : 0)) * 31) + this.f25919k) * 31;
        boolean z = this.f25920l;
        if (z) {
            z = true;
        }
        int i3 = (hashCode7 + z) * 31;
        C8258m<Boolean, Boolean, Unit> mVar = this.f25921m;
        if (mVar != null) {
            i2 = mVar.hashCode();
        }
        return i3 + i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AdOptions(type=");
        sb.append(this.f25909a);
        sb.append(", activity=");
        sb.append(this.f25910b);
        sb.append(", adId=");
        sb.append(this.f25911c);
        sb.append(", userId=");
        sb.append(this.f25912d);
        sb.append(", container=");
        sb.append(this.f25913e);
        sb.append(", showTime=");
        sb.append(this.f25914f);
        sb.append(", skipView=");
        sb.append(this.f25915g);
        sb.append(", extra=");
        sb.append(this.f25916h);
        sb.append(", infoFlowWidth=");
        sb.append(this.f25917i);
        sb.append(", adVideoList=");
        sb.append(this.f25918j);
        sb.append(", isUseBack=");
        sb.append(this.f25919k);
        sb.append(", isOnlyPreLoad=");
        sb.append(this.f25920l);
        sb.append(", callback=");
        sb.append(this.f25921m);
        sb.append(")");
        return sb.toString();
    }

    public AdOptions(@AdType int i, Activity activity, String str, String str2, ViewGroup viewGroup, int i2, View view, String str3, float f, LinkedList<C7670b> linkedList, int i3, boolean z, C8258m<? super Boolean, ? super Boolean, Unit> mVar) {
        C8271i.m35386b(activity, Constants.FLAG_ACTIVITY_NAME);
        C8271i.m35386b(str, "adId");
        C8271i.m35386b(str2, "userId");
        this.f25909a = i;
        this.f25910b = activity;
        this.f25911c = str;
        this.f25912d = str2;
        this.f25913e = viewGroup;
        this.f25914f = i2;
        this.f25915g = view;
        this.f25916h = str3;
        this.f25917i = f;
        this.f25918j = linkedList;
        this.f25919k = i3;
        this.f25920l = z;
        this.f25921m = mVar;
    }

    /* renamed from: a */
    public final int mo37301a() {
        return this.f25909a;
    }

    /* renamed from: b */
    public final Activity mo37304b() {
        return this.f25910b;
    }

    /* renamed from: c */
    public final String mo37305c() {
        return this.f25911c;
    }

    /* renamed from: d */
    public final String mo37306d() {
        return this.f25912d;
    }

    public /* synthetic */ AdOptions(int i, Activity activity, String str, String str2, ViewGroup viewGroup, int i2, View view, String str3, float f, LinkedList linkedList, int i3, boolean z, C8258m mVar, int i4, DefaultConstructorMarker fVar) {
        int i5 = i4;
        this(i, activity, str, str2, (i5 & 16) != 0 ? null : viewGroup, (i5 & 32) != 0 ? BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT : i2, (i5 & 64) != 0 ? null : view, (i5 & 128) != 0 ? null : str3, (i5 & 256) != 0 ? 274.0f : f, (i5 & 512) != 0 ? null : linkedList, (i5 & 1024) != 0 ? 0 : i3, (i5 & 2048) != 0 ? false : z, (i5 & 4096) != 0 ? null : mVar);
    }

    /* renamed from: e */
    public final ViewGroup mo37307e() {
        return this.f25913e;
    }

    /* renamed from: f */
    public final int mo37309f() {
        return this.f25914f;
    }

    /* renamed from: g */
    public final String mo37310g() {
        return this.f25916h;
    }

    /* renamed from: h */
    public final float mo37311h() {
        return this.f25917i;
    }

    /* renamed from: i */
    public final LinkedList<C7670b> mo37313i() {
        return this.f25918j;
    }

    /* renamed from: a */
    public final void mo37302a(int i) {
        this.f25919k = i;
    }

    /* renamed from: j */
    public final int mo37314j() {
        return this.f25919k;
    }

    /* renamed from: a */
    public final void mo37303a(boolean z) {
        this.f25920l = z;
    }

    /* renamed from: k */
    public final boolean mo37315k() {
        return this.f25920l;
    }

    /* renamed from: l */
    public final C8258m<Boolean, Boolean, Unit> mo37316l() {
        return this.f25921m;
    }
}
