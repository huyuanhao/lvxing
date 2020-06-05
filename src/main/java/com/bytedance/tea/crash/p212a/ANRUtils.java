package com.bytedance.tea.crash.p212a;

import android.app.ActivityManager.ProcessErrorStateInfo;
import android.content.Context;
import android.os.Looper;
import android.os.Process;
import com.bytedance.tea.crash.p221g.App;
import com.bytedance.tea.crash.p221g.Stack;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.bytedance.tea.crash.a.e */
public class ANRUtils {
    /* renamed from: a */
    public static JSONObject m12284a(boolean z) throws JSONException {
        StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("thread_number", 1);
        jSONObject.put("mainStackFromTrace", Stack.m12570a(stackTrace));
        return jSONObject;
    }

    /* renamed from: a */
    static String m12283a(Context context, int i) {
        ProcessErrorStateInfo a = App.m12495a(context, i);
        if (a == null || Process.myPid() != a.pid) {
            return null;
        }
        return ANRInfoHelper.m12273a(a);
    }
}
