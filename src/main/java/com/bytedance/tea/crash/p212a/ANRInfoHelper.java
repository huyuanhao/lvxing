package com.bytedance.tea.crash.p212a;

import android.app.ActivityManager.ProcessErrorStateInfo;

/* renamed from: com.bytedance.tea.crash.a.b */
public class ANRInfoHelper {
    /* renamed from: a */
    static String m12273a(ProcessErrorStateInfo processErrorStateInfo) {
        StringBuilder sb = new StringBuilder();
        sb.append("|------------- processErrorStateInfo--------------|\n");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("condition: ");
        sb2.append(processErrorStateInfo.condition);
        String str = "\n";
        sb2.append(str);
        sb.append(sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append("processName: ");
        sb3.append(processErrorStateInfo.processName);
        sb3.append(str);
        sb.append(sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append("pid: ");
        sb4.append(processErrorStateInfo.pid);
        sb4.append(str);
        sb.append(sb4.toString());
        StringBuilder sb5 = new StringBuilder();
        sb5.append("uid: ");
        sb5.append(processErrorStateInfo.uid);
        sb5.append(str);
        sb.append(sb5.toString());
        StringBuilder sb6 = new StringBuilder();
        sb6.append("tag: ");
        sb6.append(processErrorStateInfo.tag);
        sb6.append(str);
        sb.append(sb6.toString());
        StringBuilder sb7 = new StringBuilder();
        sb7.append("shortMsg : ");
        sb7.append(processErrorStateInfo.shortMsg);
        sb7.append(str);
        sb.append(sb7.toString());
        StringBuilder sb8 = new StringBuilder();
        sb8.append("longMsg : ");
        sb8.append(processErrorStateInfo.longMsg);
        sb8.append(str);
        sb.append(sb8.toString());
        sb.append("-----------------------end----------------------------");
        return sb.toString();
    }
}
