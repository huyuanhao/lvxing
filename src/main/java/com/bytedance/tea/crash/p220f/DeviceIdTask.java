package com.bytedance.tea.crash.p220f;

import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.tea.crash.NpthBus;
import com.bytedance.tea.crash.p221g.NpthLog;

/* renamed from: com.bytedance.tea.crash.f.b */
public class DeviceIdTask extends BaseTask {
    DeviceIdTask(Handler handler, long j, long j2) {
        super(handler, j, j2);
    }

    public void run() {
        String e = NpthBus.m12591a().mo17023e();
        if (TextUtils.isEmpty(e) || "0".equals(e)) {
            mo17062a(mo17064c());
            NpthLog.m12548a("[DeviceIdTask] did is null, continue check.");
            return;
        }
        NpthBus.m12594c().mo17060a(e);
        StringBuilder sb = new StringBuilder();
        sb.append("[DeviceIdTask] did is ");
        sb.append(e);
        NpthLog.m12548a(sb.toString());
    }
}
