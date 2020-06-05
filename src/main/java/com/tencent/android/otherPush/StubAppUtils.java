package com.tencent.android.otherPush;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.support.api.push.PushEventReceiver;
import com.meizu.cloud.pushsdk.MzPushMessageReceiver;
import com.meizu.cloud.pushsdk.NotificationService;
import com.meizu.cloud.pushsdk.PushManager;
import com.meizu.cloud.pushsdk.SystemReceiver;
import com.tencent.android.otherPush.p578a.C6813a;
import com.tencent.android.otherPush.p578a.C6816b;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.stat.XGPatchMonitor;
import com.tencent.bugly.beta.tinker.TinkerManager;
import com.tencent.otherpush.receiver.HwReceiver;
import com.tencent.otherpush.receiver.XmReceiver;
import com.tencent.p605ep.commonbase.api.ConfigManager.OEM;
import com.xiaomi.mipush.sdk.MessageHandleService;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.mipush.sdk.PushMessageReceiver;
import com.xiaomi.push.service.XMJobService;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.receivers.NetworkStatusReceiver;
import com.xiaomi.push.service.receivers.PingReceiver;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class StubAppUtils {
    /* renamed from: a */
    private static String f22604a;
    /* renamed from: b */
    private static final String f22605b = StubAppUtils.class.getSimpleName();
    /* renamed from: c */
    private static String f22606c = "";
    /* renamed from: d */
    private static final FilenameFilter f22607d = new FilenameFilter() {
        public boolean accept(File file, String str) {
            return str.endsWith(".so");
        }
    };
    public static int loadFailCount = 0;

    /* renamed from: a */
    private static String m29161a() {
        String str = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str) ? str.trim().toLowerCase() : str;
    }

    public static void attachBaseContext(Context context) {
        int i;
        f22604a = context.getPackageName();
        String absolutePath = context.getDir(TinkerManager.PATCH_DIR, 0).getAbsolutePath();
        String a = m29161a();
        if ("xiaomi".equals(a)) {
            f22606c = XGPatchMonitor.TypeXiaoMi;
            i = 1;
        } else if (OEM.HUAWEI.equals(a)) {
            f22606c = XGPatchMonitor.TypeHauwei;
            i = 5;
        } else {
            if ("meizu".equals(a)) {
                f22606c = XGPatchMonitor.TypeMeizu;
                i = 2;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(f22604a);
        sb.append("_dexPath");
        String str = "";
        String a2 = C6816b.m29185a(context, sb.toString(), str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(context.getPackageName());
        String str2 = "_loadFailCount";
        sb2.append(str2);
        int a3 = C6816b.m29183a(context, sb2.toString(), 0);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(f22604a);
        sb3.append("_ccConfig");
        String a4 = C6816b.m29185a(context, sb3.toString(), str);
        if (!TextUtils.isEmpty(a4)) {
            try {
                if (new JSONObject(a4).optBoolean("enable", true)) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(context.getPackageName());
                    sb4.append(str2);
                    C6816b.m29186b(context, sb4.toString(), 0);
                } else {
                    return;
                }
            } catch (Throwable th) {
                String str3 = f22605b;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("ccConfig paser exception :");
                sb5.append(th);
                Log.e(str3, sb5.toString());
                return;
            }
        }
        if (TextUtils.isEmpty(a2) || a3 >= 1) {
            Log.v(f22605b, "path is null or loadFailCount > = 1");
            return;
        }
        String str4 = f22605b;
        StringBuilder sb6 = new StringBuilder();
        sb6.append("path ");
        sb6.append(a2);
        Log.v(str4, sb6.toString());
        m29166a(context.getCacheDir(), absolutePath, context);
        String str5 = f22605b;
        StringBuilder sb7 = new StringBuilder();
        sb7.append("type = ");
        sb7.append(i);
        Log.v(str5, sb7.toString());
        if (i == 1) {
            try {
                Class.forName(PushMessageHandler.class.getName());
                Class.forName(PushMessageReceiver.class.getName());
                Class.forName(XmReceiver.class.getName());
                Class.forName(NetworkStatusReceiver.class.getName());
                Class.forName(PingReceiver.class.getName());
                Class.forName(MiPushClient.class.getName());
                Class.forName(XMPushService.class.getName());
                Class.forName(XMJobService.class.getName());
                Class.forName(MessageHandleService.class.getName());
            } catch (Throwable unused) {
                StringBuilder sb8 = new StringBuilder();
                sb8.append(context.getPackageName());
                sb8.append(str2);
                String sb9 = sb8.toString();
                int i2 = loadFailCount + 1;
                loadFailCount = i2;
                C6816b.m29186b(context, sb9, i2);
            }
        } else if (i == 2) {
            try {
                Class.forName(MzPushMessageReceiver.class.getName());
                Class.forName("com.tencent.otherpush.receiver.MzReceiver");
                Class.forName(NotificationService.class.getName());
                Class.forName(SystemReceiver.class.getName());
                Class.forName(PushManager.class.getName());
            } catch (Throwable unused2) {
                StringBuilder sb10 = new StringBuilder();
                sb10.append(context.getPackageName());
                sb10.append(str2);
                String sb11 = sb10.toString();
                int i3 = loadFailCount + 1;
                loadFailCount = i3;
                C6816b.m29186b(context, sb11, i3);
            }
        } else if (i == 5) {
            try {
                Class.forName(PushEventReceiver.class.getName());
                Class.forName(HwReceiver.class.getName());
            } catch (Throwable unused3) {
                StringBuilder sb12 = new StringBuilder();
                sb12.append(context.getPackageName());
                sb12.append(str2);
                String sb13 = sb12.toString();
                int i4 = loadFailCount + 1;
                loadFailCount = i4;
                C6816b.m29186b(context, sb13, i4);
            }
        }
    }

    /* renamed from: a */
    private static List<String> m29163a(Context context, String str) {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("_dexPath");
        String a = C6816b.m29185a(context, sb.toString(), "");
        if (!TextUtils.isEmpty(a)) {
            arrayList.add(a);
        }
        return arrayList;
    }

    /* renamed from: a */
    private static void m29166a(File file, String str, Context context) {
        if (context != null) {
            try {
                if (context.getApplicationContext() != null) {
                    XGPatchMonitor.onConfigAction(context, XGPushConfig.getAccessId(context), f22606c, XGPatchMonitor.ActionReadyPatch, 0, "Patch load Start", null);
                }
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append(context.getPackageName());
                sb.append("_loadFailCount");
                String sb2 = sb.toString();
                int i = loadFailCount + 1;
                loadFailCount = i;
                C6816b.m29186b(context, sb2, i);
                String str2 = f22605b;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("instantiateRealApplication :");
                sb3.append(th);
                Log.e(str2, sb3.toString());
                if (context != null && context.getApplicationContext() != null) {
                    XGPatchMonitor.onConfigAction(context, XGPushConfig.getAccessId(context), f22606c, XGPatchMonitor.ActionParsePatch, 1803, "IncrementalClassLoader inject failed", null);
                    return;
                }
                return;
            }
        }
        String a = m29162a(str);
        if (!(context == null || context.getApplicationContext() == null)) {
            XGPatchMonitor.onConfigAction(context, XGPushConfig.getAccessId(context), f22606c, XGPatchMonitor.ActionParsePatch, 0, "IncrementalClassLoader inject", null);
        }
        C6813a.m29182a(ProGuard.class.getClassLoader(), f22604a, file, a, m29163a(context, f22604a));
    }

    /* renamed from: a */
    private static Map<String, String> m29164a(File file) {
        HashMap hashMap = new HashMap();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return hashMap;
                }
                String[] split = readLine.split(" ");
                hashMap.put(split[0], split[1]);
            } finally {
                bufferedReader.close();
            }
        }
    }

    /* renamed from: a */
    private static String m29162a(String str) {
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append("/data/local/tmp/incrementaldeployment/");
        sb.append(f22604a);
        sb.append("/native");
        File file = new File(sb.toString());
        File file2 = new File(file, "native_manifest");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("/incrementallib");
        File file3 = new File(sb2.toString());
        File file4 = new File(file3, "manifest");
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append("/lib");
        String sb4 = sb3.toString();
        if (!file2.exists()) {
            return sb4;
        }
        Map a = m29164a(file2);
        Map hashMap = new HashMap();
        HashSet hashSet = new HashSet();
        HashSet<String> hashSet2 = new HashSet<>();
        if (!a.isEmpty()) {
            sb4 = file3.toString();
        }
        if (!file3.exists() && !file3.mkdirs()) {
            String str3 = f22605b;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Could not mkdir ");
            sb5.append(file3);
            Log.e(str3, sb5.toString());
        }
        if (file4.exists()) {
            hashMap = m29164a(file4);
        } else {
            for (String add : file3.list(f22607d)) {
                hashSet.add(add);
            }
        }
        for (String str4 : hashMap.keySet()) {
            if (!a.containsKey(str4) || !((String) a.get(str4)).equals(hashMap.get(str4))) {
                hashSet.add(str4);
            }
        }
        for (String str5 : a.keySet()) {
            if (!hashMap.containsKey(str5) || !((String) hashMap.get(str5)).equals(a.get(str5))) {
                hashSet2.add(str5);
            }
        }
        if (hashSet.isEmpty() && hashSet2.isEmpty()) {
            return sb4;
        }
        file4.delete();
        Iterator it = hashSet.iterator();
        while (true) {
            str2 = "/";
            if (!it.hasNext()) {
                break;
            }
            String str6 = (String) it.next();
            StringBuilder sb6 = new StringBuilder();
            sb6.append(file3);
            sb6.append(str2);
            sb6.append(str6);
            File file5 = new File(sb6.toString());
            String str7 = f22605b;
            StringBuilder sb7 = new StringBuilder();
            sb7.append("Deleting ");
            sb7.append(file5);
            Log.v(str7, sb7.toString());
            if (file5.exists() && !file5.delete()) {
                String str8 = f22605b;
                StringBuilder sb8 = new StringBuilder();
                sb8.append("Could not delete ");
                sb8.append(file5);
                Log.e(str8, sb8.toString());
            }
        }
        for (String str9 : hashSet2) {
            String str10 = f22605b;
            StringBuilder sb9 = new StringBuilder();
            sb9.append("Copying: ");
            sb9.append(str9);
            Log.v(str10, sb9.toString());
            StringBuilder sb10 = new StringBuilder();
            sb10.append(file);
            sb10.append(str2);
            sb10.append(str9);
            File file6 = new File(sb10.toString());
            StringBuilder sb11 = new StringBuilder();
            sb11.append(file3);
            sb11.append(str2);
            sb11.append(str9);
            m29165a(file6, new File(sb11.toString()));
        }
        try {
            m29165a(file2, file4);
            return sb4;
        } finally {
            file4.delete();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004d  */
    /* renamed from: a */
    private static void m29165a(java.io.File r3, java.io.File r4) {
        /*
        java.lang.String r0 = f22605b
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        java.lang.String r2 = "Copying "
        r1.append(r2)
        r1.append(r3)
        java.lang.String r2 = " -> "
        r1.append(r2)
        r1.append(r4)
        java.lang.String r1 = r1.toString()
        android.util.Log.v(r0, r1)
        r0 = 0
        java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x0044 }
        r1.<init>(r3)     // Catch:{ all -> 0x0044 }
        java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x0042 }
        r3.<init>(r4)     // Catch:{ all -> 0x0042 }
        r4 = 1048576(0x100000, float:1.469368E-39)
        byte[] r4 = new byte[r4]     // Catch:{ all -> 0x003f }
    L_0x002d:
        int r0 = r1.read(r4)     // Catch:{ all -> 0x003f }
        if (r0 <= 0) goto L_0x0038
        r2 = 0
        r3.write(r4, r2, r0)     // Catch:{ all -> 0x003f }
        goto L_0x002d
    L_0x0038:
        r1.close()
        r3.close()
        return
    L_0x003f:
        r4 = move-exception
        r0 = r3
        goto L_0x0046
    L_0x0042:
        r4 = move-exception
        goto L_0x0046
    L_0x0044:
        r4 = move-exception
        r1 = r0
    L_0x0046:
        if (r1 == 0) goto L_0x004b
        r1.close()
    L_0x004b:
        if (r0 == 0) goto L_0x0050
        r0.close()
    L_0x0050:
        throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.otherPush.StubAppUtils.m29165a(java.io.File, java.io.File):void");
    }
}
