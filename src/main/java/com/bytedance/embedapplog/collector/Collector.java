package com.bytedance.embedapplog.collector;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.embedapplog.p141a.C1805e;
import com.bytedance.embedapplog.util.C1856h;

public class Collector extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String[] stringArrayExtra = intent.getStringArrayExtra("EMBED_K_DATA");
        if (stringArrayExtra == null || stringArrayExtra.length <= 0) {
            C1856h.m6582a(null);
        } else {
            C1805e.m6274a(stringArrayExtra);
        }
    }
}
