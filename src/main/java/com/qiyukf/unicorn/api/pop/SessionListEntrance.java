package com.qiyukf.unicorn.api.pop;

import java.io.Serializable;

public class SessionListEntrance implements Serializable {
    /* access modifiers changed from: private */
    public int imageResId;
    /* access modifiers changed from: private */
    public Position position;

    /* renamed from: com.qiyukf.unicorn.api.pop.SessionListEntrance$Builder */
    public static class Builder {
        private SessionListEntrance sessionListEntrance = new SessionListEntrance();

        public SessionListEntrance build() {
            return this.sessionListEntrance;
        }

        public Builder setImageResId(int i) {
            this.sessionListEntrance.imageResId = i;
            return this;
        }

        public Builder setPosition(Position position) {
            this.sessionListEntrance.position = position;
            return this;
        }
    }

    /* renamed from: com.qiyukf.unicorn.api.pop.SessionListEntrance$Position */
    public enum Position {
        TOP_LEFT,
        TOP_RIGHT
    }

    private SessionListEntrance() {
    }

    public int getImageResId() {
        return this.imageResId;
    }

    public Position getPosition() {
        return this.position;
    }
}
