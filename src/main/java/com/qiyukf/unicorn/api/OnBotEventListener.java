package com.qiyukf.unicorn.api;

import android.content.Context;

public abstract class OnBotEventListener {
    public boolean onUrlClick(Context context, String str) {
        return false;
    }
}
