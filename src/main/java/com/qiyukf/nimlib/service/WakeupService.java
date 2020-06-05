package com.qiyukf.nimlib.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p412c.p417d.C5413e;
import com.qiyukf.nimlib.C5718b;
import com.qiyukf.nimlib.p429a.C5668c;
import com.qiyukf.unicorn.C6029d;
import com.tencent.stat.common.DeviceInfo;

public class WakeupService extends Service {
    /* renamed from: a */
    public static void m23855a(Context context) {
        if (context == null) {
            C5264a.m21617a("WakeupService", "send back data while context is null.");
        } else {
            C5413e.m22153a(context, new Intent(context, WakeupService.class));
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        C6029d.m24028a((Context) this);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        C5264a.m21617a(DeviceInfo.TAG_IMEI, "Push awake UI by Service success, UI ResponseService onStartCommand");
        if (C5718b.m23009a() != null) {
            C5668c.m22861a().mo27869d();
        }
        return super.onStartCommand(intent, i, i2);
    }
}
