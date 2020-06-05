package com.kwad.sdk.video;

import java.io.Serializable;

public class VideoPlayConfig implements Serializable {
    private static final long serialVersionUID = -7203854889686049813L;
    public boolean showLandscape;
    public String showScene;
    public boolean skipThirtySecond;

    /* renamed from: com.kwad.sdk.video.VideoPlayConfig$Builder */
    public static class Builder {
        /* access modifiers changed from: private */
        public boolean showLandscape;
        /* access modifiers changed from: private */
        public String showScene;
        /* access modifiers changed from: private */
        public boolean skipLongTime;

        public VideoPlayConfig build() {
            return new VideoPlayConfig(this);
        }

        public Builder showLandscape(boolean z) {
            this.showLandscape = z;
            return this;
        }

        public Builder showScene(String str) {
            this.showScene = str;
            return this;
        }

        public Builder skipThirtySecond(boolean z) {
            this.skipLongTime = z;
            return this;
        }
    }

    private VideoPlayConfig(Builder builder) {
        this.showScene = builder.showScene;
        this.showLandscape = builder.showLandscape;
        this.skipThirtySecond = builder.skipLongTime;
    }
}
