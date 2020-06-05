package com.oasisfeng.condom;

public class CondomOptions {
    boolean mDryRun;
    boolean mExcludeBackgroundReceivers = true;
    boolean mExcludeBackgroundServices = true;
    OutboundJudge mOutboundJudge;

    public CondomOptions preventBroadcastToBackgroundPackages(boolean z) {
        this.mExcludeBackgroundReceivers = z;
        return this;
    }

    public CondomOptions preventServiceInBackgroundPackages(boolean z) {
        this.mExcludeBackgroundServices = z;
        return this;
    }

    public CondomOptions setOutboundJudge(OutboundJudge outboundJudge) {
        this.mOutboundJudge = outboundJudge;
        return this;
    }

    public CondomOptions setDryRun(boolean z) {
        this.mDryRun = z;
        return this;
    }
}
