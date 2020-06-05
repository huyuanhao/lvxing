package com.bytedance.tea.crash.p220f;

import android.content.Context;
import android.os.Handler;
import com.bytedance.tea.crash.p221g.NpthLog;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bytedance.tea.crash.f.c */
public final class ScheduleTaskManager {
    /* renamed from: a */
    private List<BaseTask> f9358a = new ArrayList(3);

    private ScheduleTaskManager(Handler handler, Context context) {
        List<BaseTask> list = this.f9358a;
        DeviceIdTask bVar = new DeviceIdTask(handler, 0, 15000);
        list.add(bVar);
    }

    /* renamed from: a */
    public static ScheduleTaskManager m12488a(Handler handler, Context context) {
        return new ScheduleTaskManager(handler, context);
    }

    /* renamed from: a */
    public void mo17066a() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ScheduleTaskManager] execute, task size=");
        sb.append(this.f9358a.size());
        NpthLog.m12548a(sb.toString());
        for (BaseTask a : this.f9358a) {
            try {
                a.mo17061a();
            } catch (Throwable unused) {
            }
        }
    }
}
