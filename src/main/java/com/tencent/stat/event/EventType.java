package com.tencent.stat.event;

import androidx.core.view.PointerIconCompat;
import com.tencent.p605ep.common.adapt.iservice.profile.ProfileID;
import com.tencent.qqpim.discovery.internal.protocol.C7516p;

public enum EventType {
    PAGE_VIEW(1),
    SESSION_ENV(2),
    ERROR(3),
    BACKGROUND(4),
    ONCE(5),
    CUSTOM_PROPERTY(6),
    CUSTOM(1000),
    ADDITION(1001),
    MONITOR_STAT(PointerIconCompat.TYPE_HAND),
    MTA_GAME_USER(PointerIconCompat.TYPE_HELP),
    NETWORK_MONITOR(1004),
    NETWORK_DETECTOR(1005),
    INSTALL_CHANNEL(2003),
    INSTALL_SOURCE(2002),
    ANTI_CHEAT(2003),
    REG_ACCOUNT(2004),
    PAY_EVENT(2005),
    FBI_EVENT(C7516p.f25219Cf),
    LBS_EVENT(ProfileID.PID_KVProfile_ACCOUNT),
    DATA_EVENT(10002);
    
    /* renamed from: a */
    private int f25788a;

    private EventType(int i) {
        this.f25788a = i;
    }

    public int GetIntValue() {
        return this.f25788a;
    }
}
