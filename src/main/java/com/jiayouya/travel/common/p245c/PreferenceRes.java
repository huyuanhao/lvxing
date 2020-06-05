package com.jiayouya.travel.common.p245c;

import com.jiayouya.travel.module.common.data.LaunchConfig;
import ezy.app.data.Token;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.C8272k;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.reflect.C8280j;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0002¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR+\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0002¢\u0006\u0012\n\u0004\b\r\u0010\n\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR+\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\bR+\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00118F@FX\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R+\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\n\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR+\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u001c8F@FX\u0002¢\u0006\u0012\n\u0004\b\"\u0010\n\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006#"}, mo39189d2 = {"Lcom/jiayouya/travel/common/preference/PreferenceRes;", "", "()V", "<set-?>", "", "isAgreeProtocol", "()Z", "setAgreeProtocol", "(Z)V", "isAgreeProtocol$delegate", "Lcom/jiayouya/travel/common/preference/PreferenceProperty;", "isGuideShowed", "setGuideShowed", "isGuideShowed$delegate", "isPlayerEnable", "setPlayerEnable", "isPlayerEnable$delegate", "Lcom/jiayouya/travel/module/common/data/LaunchConfig;", "launchConfig", "getLaunchConfig", "()Lcom/jiayouya/travel/module/common/data/LaunchConfig;", "setLaunchConfig", "(Lcom/jiayouya/travel/module/common/data/LaunchConfig;)V", "launchConfig$delegate", "tbAuth", "getTbAuth", "setTbAuth", "tbAuth$delegate", "Lezy/app/data/Token;", "token", "getToken", "()Lezy/app/data/Token;", "setToken", "(Lezy/app/data/Token;)V", "token$delegate", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.common.c.b */
public final class PreferenceRes {
    /* renamed from: a */
    static final /* synthetic */ C8280j[] f9604a;
    /* renamed from: b */
    public static final PreferenceRes f9605b = new PreferenceRes();
    /* renamed from: c */
    private static final PreferenceProperty f9606c;
    /* renamed from: d */
    private static final PreferenceProperty f9607d;
    /* renamed from: e */
    private static final PreferenceProperty f9608e;
    /* renamed from: f */
    private static final PreferenceProperty f9609f;
    /* renamed from: g */
    private static final PreferenceProperty f9610g;
    /* renamed from: h */
    private static final PreferenceProperty f9611h;

    /* renamed from: a */
    public final Token mo19920a() {
        return (Token) f9606c.mo19917a((Object) this, f9604a[0]);
    }

    /* renamed from: a */
    public final void mo19921a(LaunchConfig launchConfig) {
        C8271i.m35386b(launchConfig, "<set-?>");
        f9607d.mo19919a(this, f9604a[1], launchConfig);
    }

    /* renamed from: a */
    public final void mo19922a(Token token) {
        C8271i.m35386b(token, "<set-?>");
        f9606c.mo19919a(this, f9604a[0], token);
    }

    /* renamed from: a */
    public final void mo19923a(boolean z) {
        f9608e.mo19919a(this, f9604a[2], Boolean.valueOf(z));
    }

    /* renamed from: b */
    public final LaunchConfig mo19924b() {
        return (LaunchConfig) f9607d.mo19917a((Object) this, f9604a[1]);
    }

    /* renamed from: b */
    public final void mo19925b(boolean z) {
        f9609f.mo19919a(this, f9604a[3], Boolean.valueOf(z));
    }

    /* renamed from: c */
    public final void mo19926c(boolean z) {
        f9610g.mo19919a(this, f9604a[4], Boolean.valueOf(z));
    }

    /* renamed from: c */
    public final boolean mo19927c() {
        return ((Boolean) f9608e.mo19917a((Object) this, f9604a[2])).booleanValue();
    }

    /* renamed from: d */
    public final boolean mo19928d() {
        return ((Boolean) f9609f.mo19917a((Object) this, f9604a[3])).booleanValue();
    }

    /* renamed from: e */
    public final boolean mo19929e() {
        return ((Boolean) f9610g.mo19917a((Object) this, f9604a[4])).booleanValue();
    }

    static {
        Class<PreferenceRes> cls = PreferenceRes.class;
        C8280j a = C8272k.m35397a((MutablePropertyReference1) new MutablePropertyReference1Impl(C8272k.m35394a((Class) cls), "token", "getToken()Lezy/app/data/Token;"));
        Boolean valueOf = Boolean.valueOf(false);
        String str = "isPlayerEnable";
        String str2 = "isGuideShowed";
        String str3 = "isAgreeProtocol";
        String str4 = "tbAuth";
        f9604a = new C8280j[]{a, C8272k.m35397a((MutablePropertyReference1) new MutablePropertyReference1Impl(C8272k.m35394a((Class) cls), "launchConfig", "getLaunchConfig()Lcom/jiayouya/travel/module/common/data/LaunchConfig;")), C8272k.m35397a((MutablePropertyReference1) new MutablePropertyReference1Impl(C8272k.m35394a((Class) cls), str, "isPlayerEnable()Z")), C8272k.m35397a((MutablePropertyReference1) new MutablePropertyReference1Impl(C8272k.m35394a((Class) cls), str2, "isGuideShowed()Z")), C8272k.m35397a((MutablePropertyReference1) new MutablePropertyReference1Impl(C8272k.m35394a((Class) cls), str3, "isAgreeProtocol()Z")), C8272k.m35397a((MutablePropertyReference1) new MutablePropertyReference1Impl(C8272k.m35394a((Class) cls), str4, "getTbAuth()Z"))};
        Token token = new Token(null, null, 0, 7, null);
        f9606c = new PreferenceProperty("lxsj-token", token);
        LaunchConfig launchConfig = new LaunchConfig(null, null, false, null, null, false, false, null, false, false, false, null, 4095, null);
        f9607d = new PreferenceProperty("lxsj-config", launchConfig);
        f9608e = new PreferenceProperty(str, Boolean.valueOf(true));
        f9609f = new PreferenceProperty(str2, valueOf);
        f9610g = new PreferenceProperty(str3, valueOf);
        f9611h = new PreferenceProperty(str4, valueOf);
    }

    private PreferenceRes() {
    }
}
