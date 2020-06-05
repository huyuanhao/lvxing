package com.jiayouya.travel.module.p276me.p280vm;

import androidx.lifecycle.MutableLiveData;
import com.jiayouya.travel.common.base.BaseViewModel;
import com.jiayouya.travel.common.p244b.ObservableEx;
import com.jiayouya.travel.common.p245c.PreferenceRes;
import com.jiayouya.travel.module.p276me.data.VoiceStatus;
import com.jiayouya.travel.module.p276me.p277a.C3109b;
import ezy.app.p643a.API;
import kotlin.Metadata;
import okhttp3.C8364ac;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\tR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/vm/SettingVM;", "Lcom/jiayouya/travel/common/base/BaseViewModel;", "()V", "liveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/jiayouya/travel/module/me/data/VoiceStatus;", "getLiveData", "()Landroidx/lifecycle/MutableLiveData;", "editVoice", "", "status", "", "voice", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: SettingVM.kt */
/* renamed from: com.jiayouya.travel.module.me.vm.SettingVM */
public final class SettingVM extends BaseViewModel {
    /* renamed from: a */
    private final MutableLiveData<VoiceStatus> f11754a = new MutableLiveData<>();

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lokhttp3/ResponseBody;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: SettingVM.kt */
    /* renamed from: com.jiayouya.travel.module.me.vm.SettingVM$a */
    static final class C3260a<T> implements Consumer<C8364ac> {
        /* renamed from: a */
        final /* synthetic */ int f11755a;

        C3260a(int i) {
            this.f11755a = i;
        }

        /* renamed from: a */
        public final void accept(C8364ac acVar) {
            PreferenceRes bVar = PreferenceRes.f9605b;
            boolean z = true;
            if (this.f11755a != 1) {
                z = false;
            }
            bVar.mo19923a(z);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/me/data/VoiceStatus;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: SettingVM.kt */
    /* renamed from: com.jiayouya.travel.module.me.vm.SettingVM$b */
    static final class C3261b<T> implements Consumer<VoiceStatus> {
        /* renamed from: a */
        final /* synthetic */ SettingVM f11756a;

        C3261b(SettingVM settingVM) {
            this.f11756a = settingVM;
        }

        /* renamed from: a */
        public final void accept(VoiceStatus voiceStatus) {
            this.f11756a.mo21503b().postValue(voiceStatus);
            PreferenceRes bVar = PreferenceRes.f9605b;
            boolean z = true;
            if (voiceStatus.getStatus() != 1) {
                z = false;
            }
            bVar.mo19923a(z);
        }
    }

    /* renamed from: b */
    public final MutableLiveData<VoiceStatus> mo21503b() {
        return this.f11754a;
    }

    /* renamed from: c */
    public final void mo21504c() {
        C3109b.m13925a(API.f27251a).mo21212d().mo38904c((Consumer<? super T>) new C3261b<Object>(this));
    }

    /* renamed from: a */
    public final void mo21502a(int i) {
        ObservableEx.m12824a(C3109b.m13925a(API.f27251a).mo21209b(i), mo19904a()).mo38904c((Consumer<? super T>) new C3260a<Object>(i));
    }
}
