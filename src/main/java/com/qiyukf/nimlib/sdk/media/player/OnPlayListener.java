package com.qiyukf.nimlib.sdk.media.player;

public interface OnPlayListener {
    void onCompletion();

    void onError(String str);

    void onInterrupt();

    void onPlaying(long j);

    void onPrepared();
}
