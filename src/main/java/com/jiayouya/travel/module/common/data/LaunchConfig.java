package com.jiayouya.travel.module.common.data;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0012\u0018\u0000 !2\u00020\u0001:\u0001!B\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u000e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001f¨\u0006\""}, mo39189d2 = {"Lcom/jiayouya/travel/module/common/data/LaunchConfig;", "Ljava/io/Serializable;", "privacyUrl", "", "protocolUrl", "androidAppraisal", "", "iosAppVersion", "adIdOpenApp", "iosAppraisal", "mustBandPhone", "adIdBanner", "allowPhoneLogin", "openRobotInShuntMode", "isUseLocal", "serverGroupId", "", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZZLjava/lang/String;ZZZLjava/lang/Long;)V", "getAdIdBanner", "()Ljava/lang/String;", "getAdIdOpenApp", "getAllowPhoneLogin", "()Z", "getAndroidAppraisal", "getIosAppVersion", "getIosAppraisal", "getMustBandPhone", "getOpenRobotInShuntMode", "getPrivacyUrl", "getProtocolUrl", "getServerGroupId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "Companion", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: LaunchConfig.kt */
public final class LaunchConfig implements Serializable {
    public static final Companion Companion = new Companion(null);
    public static final long serialVersionUID = 4;
    private final String adIdBanner;
    private final String adIdOpenApp;
    private final boolean allowPhoneLogin;
    private final boolean androidAppraisal;
    private final String iosAppVersion;
    private final boolean iosAppraisal;
    private final boolean isUseLocal;
    private final boolean mustBandPhone;
    private final boolean openRobotInShuntMode;
    private final String privacyUrl;
    private final String protocolUrl;
    private final Long serverGroupId;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo39189d2 = {"Lcom/jiayouya/travel/module/common/data/LaunchConfig$Companion;", "", "()V", "serialVersionUID", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: LaunchConfig.kt */
    /* renamed from: com.jiayouya.travel.module.common.data.LaunchConfig$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker fVar) {
            this();
        }
    }

    public LaunchConfig() {
        this(null, null, false, null, null, false, false, null, false, false, false, null, 4095, null);
    }

    public LaunchConfig(String str, String str2, boolean z, String str3, String str4, boolean z2, boolean z3, String str5, boolean z4, boolean z5, boolean z6, Long l) {
        C8271i.m35386b(str, "privacyUrl");
        C8271i.m35386b(str2, "protocolUrl");
        C8271i.m35386b(str3, "iosAppVersion");
        C8271i.m35386b(str4, "adIdOpenApp");
        C8271i.m35386b(str5, "adIdBanner");
        this.privacyUrl = str;
        this.protocolUrl = str2;
        this.androidAppraisal = z;
        this.iosAppVersion = str3;
        this.adIdOpenApp = str4;
        this.iosAppraisal = z2;
        this.mustBandPhone = z3;
        this.adIdBanner = str5;
        this.allowPhoneLogin = z4;
        this.openRobotInShuntMode = z5;
        this.isUseLocal = z6;
        this.serverGroupId = l;
    }

    public final String getPrivacyUrl() {
        return this.privacyUrl;
    }

    public final String getProtocolUrl() {
        return this.protocolUrl;
    }

    public final boolean getAndroidAppraisal() {
        return this.androidAppraisal;
    }

    public final String getAdIdOpenApp() {
        return this.adIdOpenApp;
    }

    public final String getIosAppVersion() {
        return this.iosAppVersion;
    }

    public final boolean getIosAppraisal() {
        return this.iosAppraisal;
    }

    public final boolean getMustBandPhone() {
        return this.mustBandPhone;
    }

    public final String getAdIdBanner() {
        return this.adIdBanner;
    }

    public final boolean getAllowPhoneLogin() {
        return this.allowPhoneLogin;
    }

    public /* synthetic */ LaunchConfig(String str, String str2, boolean z, String str3, String str4, boolean z2, boolean z3, String str5, boolean z4, boolean z5, boolean z6, Long l, int i, DefaultConstructorMarker fVar) {
        int i2 = i;
        String str6 = "";
        String str7 = (i2 & 1) != 0 ? str6 : str;
        String str8 = (i2 & 2) != 0 ? str6 : str2;
        boolean z7 = false;
        boolean z8 = (i2 & 4) != 0 ? false : z;
        String str9 = (i2 & 8) != 0 ? str6 : str3;
        String str10 = (i2 & 16) != 0 ? str6 : str4;
        boolean z9 = (i2 & 32) != 0 ? false : z2;
        boolean z10 = (i2 & 64) != 0 ? false : z3;
        if ((i2 & 128) == 0) {
            str6 = str5;
        }
        boolean z11 = (i2 & 256) != 0 ? false : z4;
        if ((i2 & 512) == 0) {
            z7 = z5;
        }
        this(str7, str8, z8, str9, str10, z9, z10, str6, z11, z7, (i2 & 1024) != 0 ? true : z6, (i2 & 2048) != 0 ? null : l);
    }

    public final boolean getOpenRobotInShuntMode() {
        return this.openRobotInShuntMode;
    }

    public final Long getServerGroupId() {
        return this.serverGroupId;
    }

    public final boolean isUseLocal() {
        return this.isUseLocal;
    }
}
