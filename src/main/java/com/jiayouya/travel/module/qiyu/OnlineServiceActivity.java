package com.jiayouya.travel.module.qiyu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.SoftKeyBroadManager;
import com.jiayouya.travel.common.SoftKeyBroadManager.C2878a;
import com.jiayouya.travel.common.base.BaseActivity;
import com.jiayouya.travel.common.base.BaseViewModel;
import com.jiayouya.travel.common.p245c.PreferenceRes;
import com.jiayouya.travel.databinding.QiyuActivityOnlineServiceBinding;
import com.jiayouya.travel.module.common.data.User;
import com.jiayouya.travel.module.common.p260vm.ResidentMemoryModel;
import com.jiayouya.travel.module.common.widget.FragmentSwitcher;
import com.qiyukf.unicorn.api.ConsultSource;
import com.qiyukf.unicorn.api.Unicorn;
import com.qiyukf.unicorn.api.YSFUserInfo;
import com.tencent.p605ep.commonbase.software.AppEntity;
import ezy.assist.p647b.SoftInputUtil;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.C8185c;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\rH\u0016¨\u0006\u000f"}, mo39189d2 = {"Lcom/jiayouya/travel/module/qiyu/OnlineServiceActivity;", "Lcom/jiayouya/travel/common/base/BaseActivity;", "Lcom/jiayouya/travel/databinding/QiyuActivityOnlineServiceBinding;", "Lcom/jiayouya/travel/common/base/BaseViewModel;", "()V", "getLayoutId", "", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "providerViewModelClass", "Ljava/lang/Class;", "Companion", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: OnlineServiceActivity.kt */
public final class OnlineServiceActivity extends BaseActivity<QiyuActivityOnlineServiceBinding, BaseViewModel> {
    /* renamed from: c */
    public static final C3271a f11795c = new C3271a(null);
    /* renamed from: d */
    private HashMap f11796d;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo39189d2 = {"Lcom/jiayouya/travel/module/qiyu/OnlineServiceActivity$Companion;", "", "()V", "launchActivity", "", "context", "Landroid/content/Context;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: OnlineServiceActivity.kt */
    /* renamed from: com.jiayouya.travel.module.qiyu.OnlineServiceActivity$a */
    public static final class C3271a {
        private C3271a() {
        }

        public /* synthetic */ C3271a(DefaultConstructorMarker fVar) {
            this();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/common/data/User;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: OnlineServiceActivity.kt */
    /* renamed from: com.jiayouya.travel.module.qiyu.OnlineServiceActivity$b */
    static final class C3272b<T> implements Observer<User> {
        /* renamed from: a */
        final /* synthetic */ OnlineServiceActivity f11797a;

        C3272b(OnlineServiceActivity onlineServiceActivity) {
            this.f11797a = onlineServiceActivity;
        }

        /* renamed from: a */
        public final void onChanged(User user) {
            if (user != null) {
                YSFUserInfo ySFUserInfo = new YSFUserInfo();
                ySFUserInfo.userId = user.getUid();
                String avatar = user.getAvatar();
                StringBuilder sb = new StringBuilder();
                sb.append("{\"key\":\"");
                sb.append("avatar");
                String str = "\", \"value\":\"";
                sb.append(str);
                sb.append(avatar);
                String str2 = "\"}";
                sb.append(str2);
                String str3 = "来源";
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.f11797a.getString(R.string.app_name));
                sb2.append("Android-V1.4.8");
                String sb3 = sb2.toString();
                StringBuilder sb4 = new StringBuilder();
                String str4 = "{\"index\": ";
                sb4.append(str4);
                sb4.append(0);
                String str5 = ", \"key\":\"";
                sb4.append(str5);
                sb4.append(str3);
                sb4.append(str);
                sb4.append(sb3);
                String str6 = "\", \"label\":\"";
                sb4.append(str6);
                sb4.append(str3);
                sb4.append(str2);
                String str7 = AppEntity.KEY_UID;
                String uid = user.getUid();
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str4);
                sb5.append(1);
                sb5.append(str5);
                sb5.append(str7);
                sb5.append(str);
                sb5.append(uid);
                sb5.append(str6);
                sb5.append(str7);
                sb5.append(str2);
                String str8 = "手机号";
                String mobile = user.getMobile();
                StringBuilder sb6 = new StringBuilder();
                sb6.append(str4);
                sb6.append(2);
                sb6.append(str5);
                sb6.append(str8);
                sb6.append(str);
                sb6.append(mobile);
                sb6.append(str6);
                sb6.append(str8);
                sb6.append(str2);
                String str9 = "昵称";
                String nickname = user.getNickname();
                StringBuilder sb7 = new StringBuilder();
                sb7.append(str4);
                sb7.append(3);
                sb7.append(str5);
                sb7.append(str9);
                sb7.append(str);
                sb7.append(nickname);
                sb7.append(str6);
                sb7.append(str9);
                sb7.append(str2);
                ySFUserInfo.data = C8185c.m35258a(new String[]{sb.toString(), sb4.toString(), sb5.toString(), sb6.toString(), sb7.toString()}, ", ", "[", "]", 0, null, null, 56, null);
                Unicorn.setUserInfo(ySFUserInfo);
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, mo39189d2 = {"com/jiayouya/travel/module/qiyu/OnlineServiceActivity$onCreate$2", "Lcom/jiayouya/travel/common/SoftKeyBroadManager$SoftKeyboardStateListener;", "onSoftKeyboardClosed", "", "onSoftKeyboardOpened", "keyboardHeightInPx", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: OnlineServiceActivity.kt */
    /* renamed from: com.jiayouya.travel.module.qiyu.OnlineServiceActivity$c */
    public static final class C3273c implements C2878a {
        /* renamed from: a */
        final /* synthetic */ OnlineServiceActivity f11798a;

        C3273c(OnlineServiceActivity onlineServiceActivity) {
            this.f11798a = onlineServiceActivity;
        }

        /* renamed from: a */
        public void mo19916a(int i) {
            FrameLayout frameLayout = (FrameLayout) this.f11798a.mo19852a(R.id.container);
            C8271i.m35382a((Object) frameLayout, "container");
            LayoutParams layoutParams = frameLayout.getLayoutParams();
            if (layoutParams != null) {
                ((MarginLayoutParams) layoutParams).bottomMargin = i;
                ((FrameLayout) this.f11798a.mo19852a(R.id.container)).requestLayout();
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }

        /* renamed from: a */
        public void mo19915a() {
            FrameLayout frameLayout = (FrameLayout) this.f11798a.mo19852a(R.id.container);
            C8271i.m35382a((Object) frameLayout, "container");
            LayoutParams layoutParams = frameLayout.getLayoutParams();
            if (layoutParams != null) {
                ((MarginLayoutParams) layoutParams).bottomMargin = 0;
                ((FrameLayout) this.f11798a.mo19852a(R.id.container)).requestLayout();
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
    }

    /* renamed from: a */
    public View mo19852a(int i) {
        if (this.f11796d == null) {
            this.f11796d = new HashMap();
        }
        View view = (View) this.f11796d.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f11796d.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* renamed from: f */
    public int mo19863f() {
        return R.layout.qiyu_activity_online_service;
    }

    /* renamed from: d */
    public Class<BaseViewModel> mo19861d() {
        return BaseViewModel.class;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ResidentMemoryModel.f11323a.mo20737b().observe(this, new C3272b(this));
        String str = "会话";
        ConsultSource consultSource = new ConsultSource(null, str, null);
        Long serverGroupId = PreferenceRes.f9605b.mo19924b().getServerGroupId();
        consultSource.groupId = serverGroupId != null ? serverGroupId.longValue() : 398179586;
        consultSource.robotFirst = PreferenceRes.f9605b.mo19924b().getOpenRobotInShuntMode();
        String str2 = "fragment";
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(str2);
        if (findFragmentByTag == null) {
            findFragmentByTag = Unicorn.newServiceFragment(str, consultSource, (FrameLayout) mo19852a(R.id.sdkIconContainer));
        }
        FragmentSwitcher aVar = new FragmentSwitcher(this, R.id.container);
        aVar.mo20756a(str2, findFragmentByTag);
        aVar.mo20755a(str2);
        View root = ((QiyuActivityOnlineServiceBinding) mo19857b()).getRoot();
        C8271i.m35382a((Object) root, "binding.root");
        new SoftKeyBroadManager(root, false, 2, null).mo19913a((C2878a) new C3273c(this));
    }

    public void onBackPressed() {
        super.onBackPressed();
        SoftInputUtil.m34789a((Activity) this);
    }
}
