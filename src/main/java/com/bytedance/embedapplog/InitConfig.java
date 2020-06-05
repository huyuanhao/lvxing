package com.bytedance.embedapplog;

import com.bytedance.embedapplog.p143c.C1835a;

public class InitConfig {
    /* renamed from: A */
    private ISensitiveInfoProvider f5009A;
    /* renamed from: a */
    private String f5010a;
    /* renamed from: b */
    private String f5011b;
    /* renamed from: c */
    private String f5012c;
    /* renamed from: d */
    private String f5013d;
    /* renamed from: e */
    private String f5014e;
    /* renamed from: f */
    private String f5015f;
    /* renamed from: g */
    private IPicker f5016g;
    /* renamed from: h */
    private boolean f5017h;
    /* renamed from: i */
    private int f5018i = 0;
    /* renamed from: j */
    private String f5019j;
    /* renamed from: k */
    private String f5020k;
    /* renamed from: l */
    private String f5021l;
    /* renamed from: m */
    private String f5022m;
    /* renamed from: n */
    private int f5023n;
    /* renamed from: o */
    private int f5024o;
    /* renamed from: p */
    private int f5025p;
    /* renamed from: q */
    private String f5026q;
    /* renamed from: r */
    private String f5027r;
    /* renamed from: s */
    private String f5028s;
    /* renamed from: t */
    private String f5029t;
    /* renamed from: u */
    private String f5030u;
    /* renamed from: v */
    private String f5031v;
    /* renamed from: w */
    private String f5032w;
    /* renamed from: x */
    private boolean f5033x = true;
    /* renamed from: y */
    private boolean f5034y = true;
    /* renamed from: z */
    private String f5035z;

    public InitConfig(String str, String str2) {
        this.f5010a = str;
        this.f5011b = str2;
    }

    public InitConfig setReleaseBuild(String str) {
        this.f5019j = str;
        return this;
    }

    public String getReleaseBuild() {
        return this.f5019j;
    }

    public InitConfig setEnablePlay(boolean z) {
        this.f5017h = z;
        return this;
    }

    public boolean isPlayEnable() {
        return this.f5017h;
    }

    public String getAid() {
        return this.f5010a;
    }

    public String getChannel() {
        return this.f5011b;
    }

    public InitConfig setGoogleAid(String str) {
        this.f5012c = str;
        return this;
    }

    public String getGoogleAid() {
        return this.f5012c;
    }

    public InitConfig setLanguage(String str) {
        this.f5013d = str;
        return this;
    }

    public String getLanguage() {
        return this.f5013d;
    }

    public InitConfig setRegion(String str) {
        this.f5014e = str;
        return this;
    }

    public String getRegion() {
        return this.f5014e;
    }

    public InitConfig setAliyunUdid(String str) {
        this.f5015f = str;
        return this;
    }

    public String getAliyunUdid() {
        return this.f5015f;
    }

    public InitConfig setProcess(boolean z) {
        this.f5018i = z ? 1 : 2;
        return this;
    }

    public int getProcess() {
        return this.f5018i;
    }

    public IPicker getPicker() {
        return this.f5016g;
    }

    public InitConfig setPicker(IPicker iPicker) {
        this.f5016g = iPicker;
        return this;
    }

    public InitConfig setUriConfig(int i) {
        C1835a.m6436a(i);
        return this;
    }

    public InitConfig setAppName(String str) {
        this.f5020k = str;
        return this;
    }

    public String getAppName() {
        return this.f5020k;
    }

    public InitConfig setVersion(String str) {
        this.f5021l = str;
        return this;
    }

    public String getVersion() {
        return this.f5021l;
    }

    public InitConfig setTweakedChannel(String str) {
        this.f5022m = str;
        return this;
    }

    public String getTweakedChannel() {
        return this.f5022m;
    }

    public InitConfig setVersionCode(int i) {
        this.f5023n = i;
        return this;
    }

    public int getVersionCode() {
        return this.f5023n;
    }

    public InitConfig setUpdateVersionCode(int i) {
        this.f5024o = i;
        return this;
    }

    public int getUpdateVersionCode() {
        return this.f5024o;
    }

    public InitConfig setManifestVersionCode(int i) {
        this.f5025p = i;
        return this;
    }

    public int getManifestVersionCode() {
        return this.f5025p;
    }

    public InitConfig setManifestVersion(String str) {
        this.f5026q = str;
        return this;
    }

    public String getManifestVersion() {
        return this.f5026q;
    }

    public InitConfig setAbClient(String str) {
        this.f5027r = str;
        return this;
    }

    public String getAbClient() {
        return this.f5027r;
    }

    public InitConfig setAbVersion(String str) {
        this.f5028s = str;
        return this;
    }

    public String getAbVersion() {
        return this.f5028s;
    }

    public InitConfig setAbGroup(String str) {
        this.f5029t = str;
        return this;
    }

    public String getAbGroup() {
        return this.f5029t;
    }

    public InitConfig setAbFeature(String str) {
        this.f5030u = str;
        return this;
    }

    public String getAbFeature() {
        return this.f5030u;
    }

    public InitConfig setVersionMinor(String str) {
        this.f5031v = str;
        return this;
    }

    public String getVersionMinor() {
        return this.f5031v;
    }

    public InitConfig setZiJieCloudPkg(String str) {
        this.f5032w = str;
        return this;
    }

    public String getZiJieCloudPkg() {
        return this.f5032w;
    }

    public boolean isMacEnable() {
        return this.f5033x;
    }

    public void setMacEnable(boolean z) {
        this.f5033x = z;
    }

    public boolean isImeiEnable() {
        return this.f5034y;
    }

    public void setImeiEnable(boolean z) {
        this.f5034y = z;
    }

    public String getAppImei() {
        return this.f5035z;
    }

    public void setAppImei(String str) {
        this.f5035z = str;
    }

    public ISensitiveInfoProvider getSensitiveInfoProvider() {
        return this.f5009A;
    }

    public void setSensitiveInfoProvider(ISensitiveInfoProvider iSensitiveInfoProvider) {
        this.f5009A = iSensitiveInfoProvider;
    }
}
