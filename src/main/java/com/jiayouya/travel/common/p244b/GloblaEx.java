package com.jiayouya.travel.common.p244b;

import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.elvishew.xlog.XLog;
import com.jiayouya.travel.C2835b;
import ezy.p642a.Context;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;
import p681me.jessyan.autosize.AutoSizeConfig;
import p681me.jessyan.autosize.utils.ScreenUtils;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000:\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0010\u0010\u0004\u001a\u00020\u00012\b\b\u0001\u0010\u0005\u001a\u00020\u0001\u001a\u0010\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u0001\u001a\u0010\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\b\u001a\u00020\u0001\u001a)\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u0005\u001a\u00020\u00012\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\f\"\u00020\r¢\u0006\u0002\u0010\u000e\u001a\u0010\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u001a\u0010\u0010\u0012\u001a\u00020\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u001a\u0006\u0010\u0013\u001a\u00020\u0001\u001a\u000e\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0003\u001a\"\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\n2\b\b\u0002\u0010\u0019\u001a\u00020\u00012\b\b\u0002\u0010\u001a\u001a\u00020\u0001¨\u0006\u001b"}, mo39189d2 = {"dp2px", "", "dp", "", "getColorEx", "resId", "getDrawableEx", "Landroid/graphics/drawable/Drawable;", "id", "getStringEx", "", "formatArgs", "", "", "(I[Ljava/lang/Object;)Ljava/lang/String;", "rawScreenHeight", "isIncludeStatusBar", "", "screenHeight", "screenWidth", "sp2px", "sp", "toast", "", "s", "duration", "gravity", "app_grRelease"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.common.b.d */
public final class GloblaEx {
    /* renamed from: a */
    public static final int m12811a(int i) {
        return ContextCompat.getColor(C2835b.f9544a, i);
    }

    /* renamed from: b */
    public static final String m12819b(int i) {
        String string = C2835b.f9544a.getResources().getString(i);
        C8271i.m35382a((Object) string, "AppContext.resources.getString(id)");
        return string;
    }

    /* renamed from: a */
    public static final String m12814a(int i, Object... objArr) {
        C8271i.m35386b(objArr, "formatArgs");
        String string = C2835b.f9544a.getResources().getString(i, Arrays.copyOf(objArr, objArr.length));
        C8271i.m35382a((Object) string, "AppContext.resources.getString(resId, *formatArgs)");
        return string;
    }

    /* renamed from: a */
    public static final int m12810a(float f) {
        return Context.m34741a(C2835b.f9544a, f);
    }

    /* renamed from: b */
    public static final int m12817b(float f) {
        return Context.m34745b(C2835b.f9544a, f);
    }

    /* renamed from: a */
    public static /* synthetic */ void m12816a(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 17;
        }
        m12815a(str, i, i2);
    }

    /* renamed from: a */
    public static final void m12815a(String str, int i, int i2) {
        C8271i.m35386b(str, "s");
        Context.m34743a(C2835b.f9544a, str, i, i2);
    }

    /* renamed from: a */
    public static final int m12809a() {
        AutoSizeConfig instance = AutoSizeConfig.getInstance();
        C8271i.m35382a((Object) instance, "AutoSizeConfig.getInstance()");
        return instance.getScreenWidth();
    }

    /* renamed from: a */
    public static /* synthetic */ int m12813a(boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return m12812a(z);
    }

    /* renamed from: a */
    public static final int m12812a(boolean z) {
        String str = "AutoSizeConfig.getInstance()";
        if (z) {
            AutoSizeConfig instance = AutoSizeConfig.getInstance();
            C8271i.m35382a((Object) instance, str);
            return instance.getScreenHeight() + ScreenUtils.getStatusBarHeight();
        }
        AutoSizeConfig instance2 = AutoSizeConfig.getInstance();
        C8271i.m35382a((Object) instance2, str);
        return instance2.getScreenHeight();
    }

    /* renamed from: b */
    public static final int m12818b(boolean z) {
        int i = ScreenUtils.getRawScreenSize(C2835b.f9544a)[1];
        int statusBarHeight = ScreenUtils.getStatusBarHeight();
        int heightOfNavigationBar = ScreenUtils.getHeightOfNavigationBar(C2835b.f9544a);
        StringBuilder sb = new StringBuilder();
        sb.append("raw height==");
        sb.append(i);
        sb.append(" ,statusBarHeight==");
        sb.append(statusBarHeight);
        sb.append(" ,navigationHeight==");
        sb.append(heightOfNavigationBar);
        XLog.m12691a(sb.toString());
        return !z ? (i - statusBarHeight) - heightOfNavigationBar : i;
    }

    /* renamed from: c */
    public static final Drawable m12820c(int i) {
        Drawable drawable = C2835b.f9544a.getResources().getDrawable(i);
        C8271i.m35382a((Object) drawable, "AppContext.resources.getDrawable(id)");
        return drawable;
    }
}
