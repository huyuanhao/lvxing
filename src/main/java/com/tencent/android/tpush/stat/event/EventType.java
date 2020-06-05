package com.tencent.android.tpush.stat.event;

import androidx.core.view.PointerIconCompat;
import com.tencent.p605ep.common.adapt.iservice.profile.ProfileID;

/* compiled from: ProGuard */
public enum EventType {
    PAGE_VIEW(1),
    SESSION_ENV(2),
    ERROR(3),
    CUSTOM(1000),
    ADDITION(1001),
    MONITOR_STAT(PointerIconCompat.TYPE_HAND),
    MTA_GAME_USER(PointerIconCompat.TYPE_HELP),
    NETWORK_MONITOR(1004),
    NETWORK_DETECTOR(1005),
    LBS(ProfileID.PID_KVProfile_ACCOUNT);
    
    /* renamed from: v */
    private int f23591v;

    private EventType(int i) {
        this.f23591v = i;
    }

    public int GetIntValue() {
        return this.f23591v;
    }
}
