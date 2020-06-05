package com.bytedance.embedapplog.util;

public class UriConfig {
    public static final int AMERICA = 2;
    public static final int DEFAULT = 0;
    public static final int SINGAPORE = 1;
    /* renamed from: a */
    private static final String[] f5209a = {"https://toblog.ctobsnssdk.com", "https://tobapplog.ctobsnssdk.com"};
    /* renamed from: b */
    private static final String[] f5210b = {"https://toblog.tobsnssdk.com", "https://tobapplog.tobsnssdk.com"};
    /* renamed from: c */
    private static final String[] f5211c = {"https://toblog.itobsnssdk.com", "https://tobapplog.itobsnssdk.com"};
    /* renamed from: d */
    private String f5212d;
    /* renamed from: e */
    private String f5213e;
    /* renamed from: f */
    private String f5214f;
    /* renamed from: g */
    private String f5215g;
    /* renamed from: h */
    private String[] f5216h;
    /* renamed from: i */
    private String f5217i;

    /* renamed from: a */
    private void m6554a() {
        this.f5212d = "https://toblog.ctobsnssdk.com/service/2/device_register_only/";
        this.f5213e = "https://toblog.ctobsnssdk.com/service/2/app_alert_check/";
        this.f5214f = "https://toblog.ctobsnssdk.com/service/2/log_settings/";
        this.f5215g = "https://toblog.ctobsnssdk.com/service/2/abtest_config/";
        this.f5216h = f5209a;
        this.f5217i = "https://success.ctobsnssdk.com";
    }

    /* renamed from: b */
    private void m6555b() {
        this.f5212d = "https://toblog.tobsnssdk.com/service/2/device_register_only/";
        this.f5213e = "https://toblog.tobsnssdk.com/service/2/app_alert_check/";
        this.f5214f = "https://toblog.tobsnssdk.com/service/2/log_settings/";
        this.f5215g = "https://toblog.tobsnssdk.com/service/2/abtest_config/";
        this.f5216h = f5210b;
        this.f5217i = "https://success.tobsnssdk.com";
    }

    /* renamed from: c */
    private void m6556c() {
        this.f5212d = "https://toblog.itobsnssdk.com/service/2/device_register_only/";
        this.f5213e = "https://toblog.itobsnssdk.com/service/2/app_alert_check/";
        this.f5214f = "https://toblog.itobsnssdk.com/service/2/log_settings/";
        this.f5215g = "https://toblog.itobsnssdk.com/service/2/abtest_config/";
        this.f5216h = f5211c;
        this.f5217i = "https://success.itobsnssdk.com";
    }

    private UriConfig() {
        m6554a();
    }

    public static UriConfig creatUriConfig(int i) {
        UriConfig uriConfig = new UriConfig();
        if (i == 0) {
            uriConfig.m6554a();
        } else if (i == 1) {
            uriConfig.m6555b();
        } else if (i != 2) {
            uriConfig.m6554a();
        } else {
            uriConfig.m6556c();
        }
        return uriConfig;
    }

    public String getRegisterUri() {
        return this.f5212d;
    }

    public String getActiveUri() {
        return this.f5213e;
    }

    public String getSettingUri() {
        return this.f5214f;
    }

    public String getABConfigUri() {
        return this.f5215g;
    }

    public String[] getSendHeadersUris() {
        return this.f5216h;
    }

    public String getSuccRateUri() {
        return this.f5217i;
    }
}
