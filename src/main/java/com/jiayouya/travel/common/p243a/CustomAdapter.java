package com.jiayouya.travel.common.p243a;

import android.widget.Switch;
import androidx.databinding.BindingAdapter;
import com.elvishew.xlog.XLog;
import com.jiayouya.travel.common.widget.RndCornerProgressBar;
import com.jiayouya.travel.common.widget.countdownview.CountdownView;
import com.jiayouya.travel.module.p281tb.widget.CircleProgressBar;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\u0010\tJ\u001f\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\rJ\u001f\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\u0010\u0011J3\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019J\u001a\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0007¨\u0006\u001e"}, mo39189d2 = {"Lcom/jiayouya/travel/common/adapter/CustomAdapter;", "", "()V", "adapt", "", "view", "Landroid/widget/Switch;", "isChecked", "", "(Landroid/widget/Switch;Ljava/lang/Boolean;)V", "Lcom/jiayouya/travel/common/widget/RndCornerProgressBar;", "rcProgress", "", "(Lcom/jiayouya/travel/common/widget/RndCornerProgressBar;Ljava/lang/Float;)V", "adaptCircleProgress", "Lcom/jiayouya/travel/module/tb/widget/CircleProgressBar;", "isAutoPlay", "(Lcom/jiayouya/travel/module/tb/widget/CircleProgressBar;Ljava/lang/Boolean;)V", "adaptTime", "Lcom/jiayouya/travel/common/widget/countdownview/CountdownView;", "time", "", "isStart", "speed", "", "(Lcom/jiayouya/travel/common/widget/countdownview/CountdownView;Ljava/lang/Long;Ljava/lang/Boolean;I)V", "adaptWebView", "Landroid/webkit/WebView;", "url", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.common.a.a */
public final class CustomAdapter {
    /* renamed from: a */
    public static final CustomAdapter f9557a = new CustomAdapter();

    private CustomAdapter() {
    }

    @JvmStatic
    @BindingAdapter({"rcProgress"})
    /* renamed from: a */
    public static final void m12777a(RndCornerProgressBar rndCornerProgressBar, Float f) {
        C8271i.m35386b(rndCornerProgressBar, "view");
        if (f != null) {
            float floatValue = f.floatValue();
            StringBuilder sb = new StringBuilder();
            sb.append("progress2===");
            sb.append(floatValue);
            XLog.m12691a(sb.toString());
            rndCornerProgressBar.setProgress(floatValue);
        }
    }

    @JvmStatic
    @BindingAdapter({"isChecked"})
    /* renamed from: a */
    public static final void m12776a(Switch switchR, Boolean bool) {
        C8271i.m35386b(switchR, "view");
        if (bool != null) {
            switchR.setChecked(bool.booleanValue());
        }
    }

    @JvmStatic
    @BindingAdapter(requireAll = false, value = {"time", "isStart", "speed"})
    /* renamed from: a */
    public static final void m12778a(CountdownView countdownView, Long l, Boolean bool, int i) {
        C8271i.m35386b(countdownView, "view");
        if (l != null) {
            long longValue = l.longValue();
            countdownView.setSpeed(i);
            if (C8271i.m35384a((Object) bool, (Object) Boolean.valueOf(true))) {
                countdownView.mo20033a(l.longValue());
            } else {
                countdownView.mo20032a();
            }
            if (longValue <= 0) {
                countdownView.mo20034b();
            }
        }
    }

    @JvmStatic
    @BindingAdapter({"isAutoPlay"})
    /* renamed from: a */
    public static final void m12779a(CircleProgressBar circleProgressBar, Boolean bool) {
        C8271i.m35386b(circleProgressBar, "view");
        if (bool != null) {
            circleProgressBar.setAutoPlay(bool.booleanValue());
        }
    }
}
