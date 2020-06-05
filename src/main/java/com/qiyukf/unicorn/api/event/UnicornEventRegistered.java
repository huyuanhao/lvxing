package com.qiyukf.unicorn.api.event;

import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.unicorn.C6029d;

public class UnicornEventRegistered {
    public static void registerTypeForEvent(int i, UnicornEventBase unicornEventBase) {
        try {
            if (C6029d.m24038b() && C6029d.m24045e().sdkEvents != null) {
                C6029d.m24045e().sdkEvents.eventMap.append(i, unicornEventBase);
            }
        } catch (IllegalStateException e) {
            C5264a.m21617a("regist event is not init", e.toString());
        }
    }
}
