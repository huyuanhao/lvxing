package com.tencent.otherpush.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Looper;
import android.widget.Toast;
import java.io.FileWriter;
import java.io.IOException;

/* compiled from: ProGuard */
public class HwReceiver extends BroadcastReceiver {
    public void onEvent(Context context) {
    }

    public void onPushMsg(Context context, byte[] bArr, String str) {
    }

    public boolean onPushMsg(Context context, byte[] bArr, Bundle bundle) {
        return false;
    }

    public void onPushState(Context context, boolean z) {
    }

    public void onToken(Context context, String str, Bundle bundle) {
        showToast(str, context);
    }

    public void onToken(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        String str2 = "receiver ";
        sb.append(str2);
        sb.append(str);
        showToast(sb.toString(), context);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append(str);
        m32359a(sb2.toString());
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            try {
                String action = intent.getAction();
                if ("com.huawei.android.push.intent.REGISTRATION".equals(action)) {
                    byte[] byteArrayExtra = intent.getByteArrayExtra("device_token");
                    if (byteArrayExtra != null) {
                        new String(byteArrayExtra, "UTF-8");
                    }
                } else if (!"com.huawei.android.push.intent.RECEIVE".equals(action)) {
                    "com.huawei.intent.action.PUSH_STATE".equals(action);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void showToast(final String str, final Context context) {
        new Thread(new Runnable() {
            public void run() {
                Looper.prepare();
                Toast.makeText(context, str, 0).show();
                Looper.loop();
            }
        }).start();
    }

    /* renamed from: a */
    private void m32359a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStorageDirectory());
        sb.append("/huawei.txt");
        try {
            FileWriter fileWriter = new FileWriter(sb.toString(), true);
            fileWriter.write(str);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
