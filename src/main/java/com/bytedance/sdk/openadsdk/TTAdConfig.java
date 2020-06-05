package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.adnet.p162e.IHttpStack;

public final class TTAdConfig {
    /* renamed from: a */
    private String f6374a;
    /* renamed from: b */
    private String f6375b;
    /* renamed from: c */
    private boolean f6376c;
    /* renamed from: d */
    private String f6377d;
    /* renamed from: e */
    private String f6378e;
    /* renamed from: f */
    private int f6379f;
    /* renamed from: g */
    private boolean f6380g;
    /* renamed from: h */
    private boolean f6381h;
    /* renamed from: i */
    private boolean f6382i;
    /* renamed from: j */
    private int[] f6383j;
    /* renamed from: k */
    private boolean f6384k;
    /* renamed from: l */
    private boolean f6385l;
    /* renamed from: m */
    private IHttpStack f6386m;
    /* renamed from: n */
    private TTDownloadEventLogger f6387n;
    /* renamed from: o */
    private TTSecAbs f6388o;
    /* renamed from: p */
    private String[] f6389p;
    /* renamed from: q */
    private boolean f6390q;
    /* renamed from: r */
    private TTCustomController f6391r;

    /* renamed from: com.bytedance.sdk.openadsdk.TTAdConfig$Builder */
    public static class Builder {
        /* renamed from: a */
        private String f6392a;
        /* renamed from: b */
        private String f6393b;
        /* renamed from: c */
        private boolean f6394c = false;
        /* renamed from: d */
        private String f6395d;
        /* renamed from: e */
        private String f6396e;
        /* renamed from: f */
        private int f6397f = 0;
        /* renamed from: g */
        private boolean f6398g = true;
        /* renamed from: h */
        private boolean f6399h = false;
        /* renamed from: i */
        private boolean f6400i = false;
        /* renamed from: j */
        private int[] f6401j;
        /* renamed from: k */
        private boolean f6402k = false;
        /* renamed from: l */
        private boolean f6403l = false;
        /* renamed from: m */
        private IHttpStack f6404m;
        /* renamed from: n */
        private TTDownloadEventLogger f6405n;
        /* renamed from: o */
        private TTSecAbs f6406o;
        /* renamed from: p */
        private String[] f6407p;
        /* renamed from: q */
        private boolean f6408q = false;
        /* renamed from: r */
        private TTCustomController f6409r;

        @Deprecated
        public Builder globalDownloadListener(TTGlobalAppDownloadListener tTGlobalAppDownloadListener) {
            return this;
        }

        public Builder appId(String str) {
            this.f6392a = str;
            return this;
        }

        public Builder appName(String str) {
            this.f6393b = str;
            return this;
        }

        public Builder paid(boolean z) {
            this.f6394c = z;
            return this;
        }

        public Builder keywords(String str) {
            this.f6395d = str;
            return this;
        }

        public Builder data(String str) {
            this.f6396e = str;
            return this;
        }

        public Builder titleBarTheme(int i) {
            this.f6397f = i;
            return this;
        }

        public Builder allowShowNotify(boolean z) {
            this.f6398g = z;
            return this;
        }

        public Builder debug(boolean z) {
            this.f6399h = z;
            return this;
        }

        public Builder allowShowPageWhenScreenLock(boolean z) {
            this.f6400i = z;
            return this;
        }

        public Builder directDownloadNetworkType(int... iArr) {
            this.f6401j = iArr;
            return this;
        }

        public Builder useTextureView(boolean z) {
            this.f6402k = z;
            return this;
        }

        public Builder supportMultiProcess(boolean z) {
            this.f6403l = z;
            return this;
        }

        public Builder httpStack(IHttpStack aVar) {
            this.f6404m = aVar;
            return this;
        }

        public Builder ttDownloadEventLogger(TTDownloadEventLogger tTDownloadEventLogger) {
            this.f6405n = tTDownloadEventLogger;
            return this;
        }

        public Builder ttSecAbs(TTSecAbs tTSecAbs) {
            this.f6406o = tTSecAbs;
            return this;
        }

        public Builder needClearTaskReset(String... strArr) {
            this.f6407p = strArr;
            return this;
        }

        public Builder asyncInit(boolean z) {
            this.f6408q = z;
            return this;
        }

        public Builder customController(TTCustomController tTCustomController) {
            this.f6409r = tTCustomController;
            return this;
        }

        public TTAdConfig build() {
            TTAdConfig tTAdConfig = new TTAdConfig();
            tTAdConfig.setAppId(this.f6392a);
            tTAdConfig.setAppName(this.f6393b);
            tTAdConfig.setPaid(this.f6394c);
            tTAdConfig.setKeywords(this.f6395d);
            tTAdConfig.setData(this.f6396e);
            tTAdConfig.setTitleBarTheme(this.f6397f);
            tTAdConfig.setAllowShowNotify(this.f6398g);
            tTAdConfig.setDebug(this.f6399h);
            tTAdConfig.setAllowShowPageWhenScreenLock(this.f6400i);
            tTAdConfig.setDirectDownloadNetworkType(this.f6401j);
            tTAdConfig.setUseTextureView(this.f6402k);
            tTAdConfig.setSupportMultiProcess(this.f6403l);
            tTAdConfig.setHttpStack(this.f6404m);
            tTAdConfig.setTTDownloadEventLogger(this.f6405n);
            tTAdConfig.setTTSecAbs(this.f6406o);
            tTAdConfig.setNeedClearTaskReset(this.f6407p);
            tTAdConfig.setAsyncInit(this.f6408q);
            tTAdConfig.setCustomController(this.f6409r);
            return tTAdConfig;
        }
    }

    private TTAdConfig() {
        this.f6376c = false;
        this.f6379f = 0;
        this.f6380g = true;
        this.f6381h = false;
        this.f6382i = false;
        this.f6384k = false;
        this.f6385l = false;
        this.f6390q = false;
    }

    public String getAppId() {
        return this.f6374a;
    }

    public void setAppId(String str) {
        this.f6374a = str;
    }

    public String getAppName() {
        return this.f6375b;
    }

    public void setAppName(String str) {
        this.f6375b = str;
    }

    public boolean isPaid() {
        return this.f6376c;
    }

    public void setPaid(boolean z) {
        this.f6376c = z;
    }

    public String getKeywords() {
        return this.f6377d;
    }

    public void setKeywords(String str) {
        this.f6377d = str;
    }

    public String getData() {
        return this.f6378e;
    }

    public void setData(String str) {
        this.f6378e = str;
    }

    public int getTitleBarTheme() {
        return this.f6379f;
    }

    public void setTitleBarTheme(int i) {
        this.f6379f = i;
    }

    public boolean isAllowShowNotify() {
        return this.f6380g;
    }

    public void setAllowShowNotify(boolean z) {
        this.f6380g = z;
    }

    public boolean isDebug() {
        return this.f6381h;
    }

    public void setDebug(boolean z) {
        this.f6381h = z;
    }

    public boolean isAllowShowPageWhenScreenLock() {
        return this.f6382i;
    }

    public void setAllowShowPageWhenScreenLock(boolean z) {
        this.f6382i = z;
    }

    public int[] getDirectDownloadNetworkType() {
        return this.f6383j;
    }

    public void setDirectDownloadNetworkType(int... iArr) {
        this.f6383j = iArr;
    }

    public boolean isUseTextureView() {
        return this.f6384k;
    }

    public void setUseTextureView(boolean z) {
        this.f6384k = z;
    }

    public boolean isSupportMultiProcess() {
        return this.f6385l;
    }

    public void setSupportMultiProcess(boolean z) {
        this.f6385l = z;
    }

    public IHttpStack getHttpStack() {
        return this.f6386m;
    }

    public void setHttpStack(IHttpStack aVar) {
        this.f6386m = aVar;
    }

    public TTDownloadEventLogger getTTDownloadEventLogger() {
        return this.f6387n;
    }

    public void setTTDownloadEventLogger(TTDownloadEventLogger tTDownloadEventLogger) {
        this.f6387n = tTDownloadEventLogger;
    }

    public TTSecAbs getTTSecAbs() {
        return this.f6388o;
    }

    public void setTTSecAbs(TTSecAbs tTSecAbs) {
        this.f6388o = tTSecAbs;
    }

    public String[] getNeedClearTaskReset() {
        return this.f6389p;
    }

    public void setNeedClearTaskReset(String... strArr) {
        this.f6389p = strArr;
    }

    public boolean isAsyncInit() {
        return this.f6390q;
    }

    public void setAsyncInit(boolean z) {
        this.f6390q = z;
    }

    public TTCustomController getCustomController() {
        return this.f6391r;
    }

    public void setCustomController(TTCustomController tTCustomController) {
        this.f6391r = tTCustomController;
    }
}
