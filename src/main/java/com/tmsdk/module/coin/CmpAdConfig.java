package com.tmsdk.module.coin;

import android.os.Bundle;
import android.text.TextUtils;
import btmsdkobf.C0638c;
import com.tmsdk.module.coin.AdConfig.BUSINESS;
import java.util.Arrays;

public class CmpAdConfig {
    /* renamed from: F */
    private AdConfig f25875F;
    /* renamed from: G */
    private String f25876G;

    public CmpAdConfig(AdConfig adConfig) {
        this.f25876G = C0638c.m79c();
        this.f25875F = adConfig;
        this.f25876G = AdConfigManager.GZMD_ID;
    }

    CmpAdConfig(String str, int i, Bundle bundle) {
        this.f25876G = str;
        this.f25875F = new AdConfig(i, bundle);
    }

    CmpAdConfig(String str, BUSINESS business, Bundle bundle) {
        this(str, business, "0000", bundle);
    }

    CmpAdConfig(String str, BUSINESS business, String str2, Bundle bundle) {
        this.f25876G = str;
        this.f25875F = new AdConfig(business, str2, bundle);
    }

    public static boolean valid(CmpAdConfig cmpAdConfig) {
        if (cmpAdConfig == null || cmpAdConfig.f25875F == null || TextUtils.isEmpty(cmpAdConfig.f25876G)) {
            return false;
        }
        C0638c.m79c();
        AdConfig adConfig = cmpAdConfig.f25875F;
        if (!AdConfigManager.GZMD_ID.equals(cmpAdConfig.f25876G)) {
            return false;
        }
        return AdConfigManager.m32910a(cmpAdConfig);
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CmpAdConfig)) {
            return false;
        }
        CmpAdConfig cmpAdConfig = (CmpAdConfig) obj;
        if (cmpAdConfig.f25875F.getTaskType() == this.f25875F.getTaskType()) {
            return true;
        }
        if ((cmpAdConfig.f25875F.getBusiness() == null && this.f25875F.getBusiness() != null) || ((cmpAdConfig.f25875F.getBusiness() != null && this.f25875F.getBusiness() == null) || cmpAdConfig.f25875F.getSceneId() == null || this.f25875F.getSceneId() == null || (!(cmpAdConfig.f25875F.getBusiness() == null && this.f25875F.getBusiness() == null) ? !(!cmpAdConfig.f25875F.getBusiness().equals(this.f25875F.getBusiness()) || !cmpAdConfig.f25875F.getSceneId().equals(this.f25875F.getSceneId()) || !this.f25876G.equals(cmpAdConfig.f25876G)) : !(cmpAdConfig.f25875F.getTaskType() != this.f25875F.getTaskType() || !this.f25876G.equals(cmpAdConfig.f25876G))))) {
            z = false;
        }
        return z;
    }

    public AdConfig getAdConfig() {
        return this.f25875F;
    }

    public String getManufacturer() {
        return this.f25876G;
    }

    public int hashCode() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f25875F.getBusiness());
        sb.append("");
        return Arrays.hashCode(new String[]{this.f25876G, sb.toString()});
    }
}
