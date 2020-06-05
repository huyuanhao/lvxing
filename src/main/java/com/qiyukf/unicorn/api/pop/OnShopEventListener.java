package com.qiyukf.unicorn.api.pop;

import android.content.Context;

public abstract class OnShopEventListener {
    public String getNotificationTitle(Context context, String str) {
        return null;
    }

    public boolean onSessionListEntranceClick(Context context) {
        return false;
    }

    public boolean onShopEntranceClick(Context context, String str) {
        return false;
    }
}
