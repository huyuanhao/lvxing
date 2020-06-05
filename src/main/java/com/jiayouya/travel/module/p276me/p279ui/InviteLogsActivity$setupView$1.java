package com.jiayouya.travel.module.p276me.p279ui;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p244b.GloblaEx;
import ezy.p642a.Context;
import ezy.p653ui.widget.round.RoundText;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\f"}, mo39189d2 = {"com/jiayouya/travel/module/me/ui/InviteLogsActivity$setupView$1", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: InviteLogsActivity.kt */
/* renamed from: com.jiayouya.travel.module.me.ui.InviteLogsActivity$setupView$1 */
public final class InviteLogsActivity$setupView$1 implements OnPageChangeListener {
    /* renamed from: a */
    final /* synthetic */ InviteLogsActivity f11596a;

    public void onPageScrollStateChanged(int i) {
    }

    InviteLogsActivity$setupView$1(InviteLogsActivity inviteLogsActivity) {
        this.f11596a = inviteLogsActivity;
    }

    public void onPageScrolled(int i, float f, int i2) {
        RoundText roundText = (RoundText) this.f11596a.mo19852a(R.id.tab_indicator);
        C8271i.m35382a((Object) roundText, "tab_indicator");
        roundText.setTranslationX(((((float) i) + f) * ((float) (GloblaEx.m12809a() - Context.m34741a(this.f11596a, 30.0f)))) / 3.0f);
    }

    public void onPageSelected(int i) {
        InviteLogsActivity inviteLogsActivity = this.f11596a;
        View childAt = ((LinearLayout) inviteLogsActivity.mo19852a(R.id.lyt_tab)).getChildAt(i);
        C8271i.m35382a((Object) childAt, "lyt_tab.getChildAt(position)");
        inviteLogsActivity.m14001a(childAt);
    }
}
