package com.kwad.sdk;

import com.kwad.sdk.export.proxy.AdDownloadProxy;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.export.proxy.AdInstallProxy;
import com.kwad.sdk.export.proxy.AdJumpProxy;
import com.kwad.sdk.export.proxy.AdLocationProxy;
import com.kwad.sdk.export.proxy.AdRequestExtentParamsProxy;

public class SdkConfig {
    AdRequestExtentParamsProxy adRequestExtentParamsProxy;
    String appId;
    String appName;
    AdDownloadProxy downloadProxy;
    boolean enableDebug;
    AdHttpProxy httpProxy;
    AdInstallProxy installProxy;
    AdJumpProxy jumpProxy;
    AdLocationProxy locationProxy;
    boolean showNotification;

    /* renamed from: com.kwad.sdk.SdkConfig$Builder */
    public static class Builder {
        /* access modifiers changed from: private */
        public AdRequestExtentParamsProxy adRequestExtentParamsProxy;
        /* access modifiers changed from: private */
        public String appId;
        /* access modifiers changed from: private */
        public String appName;
        /* access modifiers changed from: private */
        public AdDownloadProxy downloadProxy;
        /* access modifiers changed from: private */
        public boolean enableDebug;
        /* access modifiers changed from: private */
        public AdHttpProxy httpProxy;
        /* access modifiers changed from: private */
        public AdInstallProxy installProxy;
        /* access modifiers changed from: private */
        public AdJumpProxy jumpProxy;
        /* access modifiers changed from: private */
        public AdLocationProxy locationProxy;
        /* access modifiers changed from: private */
        public boolean showNotification = true;

        public Builder appId(String str) {
            this.appId = str;
            return this;
        }

        public Builder appName(String str) {
            this.appName = str;
            return this;
        }

        public SdkConfig build() {
            return new SdkConfig(this);
        }

        public Builder debug(boolean z) {
            this.enableDebug = z;
            return this;
        }

        public Builder setAdRequestExtentParamsProxy(AdRequestExtentParamsProxy adRequestExtentParamsProxy2) {
            this.adRequestExtentParamsProxy = adRequestExtentParamsProxy2;
            return this;
        }

        public Builder setDownloadProxy(AdDownloadProxy adDownloadProxy) {
            this.downloadProxy = adDownloadProxy;
            return this;
        }

        public Builder setHttpProxy(AdHttpProxy adHttpProxy) {
            this.httpProxy = adHttpProxy;
            return this;
        }

        public Builder setInstallProxy(AdInstallProxy adInstallProxy) {
            this.installProxy = adInstallProxy;
            return this;
        }

        public Builder setJumpProxy(AdJumpProxy adJumpProxy) {
            this.jumpProxy = adJumpProxy;
            return this;
        }

        public Builder setLocationProxy(AdLocationProxy adLocationProxy) {
            this.locationProxy = adLocationProxy;
            return this;
        }

        public Builder showNotification(boolean z) {
            this.showNotification = z;
            return this;
        }
    }

    private SdkConfig(Builder builder) {
        this.enableDebug = builder.enableDebug;
        this.appId = builder.appId;
        this.appName = builder.appName;
        this.httpProxy = builder.httpProxy;
        this.downloadProxy = builder.downloadProxy;
        this.jumpProxy = builder.jumpProxy;
        this.locationProxy = builder.locationProxy;
        this.installProxy = builder.installProxy;
        this.adRequestExtentParamsProxy = builder.adRequestExtentParamsProxy;
        this.showNotification = builder.showNotification;
    }
}
