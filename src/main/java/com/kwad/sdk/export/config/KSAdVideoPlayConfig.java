package com.kwad.sdk.export.config;

import java.io.Serializable;

public class KSAdVideoPlayConfig implements Serializable {
    private static final long serialVersionUID = -154151744722615768L;
    public boolean dataFlowAutoStart;
    public boolean videoSoundEnable;

    /* renamed from: com.kwad.sdk.export.config.KSAdVideoPlayConfig$Builder */
    public static class Builder {
        /* access modifiers changed from: private */
        public boolean dataFlowAutoStart;
        /* access modifiers changed from: private */
        public boolean videoSoundEnable;

        public KSAdVideoPlayConfig build() {
            return new KSAdVideoPlayConfig(this);
        }

        public Builder setDataFlowAutoStart(boolean z) {
            this.dataFlowAutoStart = z;
            return this;
        }

        public Builder setVideoSoundEnable(boolean z) {
            this.videoSoundEnable = z;
            return this;
        }
    }

    private KSAdVideoPlayConfig(Builder builder) {
        this.videoSoundEnable = builder.videoSoundEnable;
        this.dataFlowAutoStart = builder.dataFlowAutoStart;
    }
}
