package com.qiyukf.unicorn.api.lifecycle;

import java.io.Serializable;

public class SessionLifeCycleOptions implements Serializable {
    private boolean canCloseSession;
    private boolean canQuitQueue;
    private String quitQueuePrompt;
    private transient SessionLifeCycleListener sessionLifeCycleListener;

    public boolean canCloseSession() {
        return this.canCloseSession;
    }

    public boolean canQuitQueue() {
        return this.canQuitQueue;
    }

    public String getQuitQueuePrompt() {
        return this.quitQueuePrompt;
    }

    public SessionLifeCycleListener getSessionLifeCycleListener() {
        return this.sessionLifeCycleListener;
    }

    public SessionLifeCycleOptions setCanCloseSession(boolean z) {
        this.canCloseSession = z;
        return this;
    }

    public SessionLifeCycleOptions setCanQuitQueue(boolean z) {
        this.canQuitQueue = z;
        return this;
    }

    public SessionLifeCycleOptions setQuitQueuePrompt(String str) {
        this.quitQueuePrompt = str;
        return this;
    }

    public SessionLifeCycleOptions setSessionLifeCycleListener(SessionLifeCycleListener sessionLifeCycleListener2) {
        this.sessionLifeCycleListener = sessionLifeCycleListener2;
        return this;
    }
}
