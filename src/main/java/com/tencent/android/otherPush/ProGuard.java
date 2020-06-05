package com.tencent.android.otherPush;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
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
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.android.otherPush.a */
public class ProGuard extends Application {
    /* renamed from: a */
    public static int f22608a = 0;
    /* renamed from: b */
    private static final String f22609b = ProGuard.class.getSimpleName();
    /* renamed from: c */
    private static final FilenameFilter f22610c = new FilenameFilter() {
        public boolean accept(File file, String str) {
            return str.endsWith(".so");
        }
    };
    /* renamed from: i */
    private static String f22611i = "";
    /* renamed from: d */
    private final String f22612d;
    /* renamed from: e */
    private final String f22613e;
    /* renamed from: f */
    private String f22614f;
    /* renamed from: g */
    private Application f22615g;
    /* renamed from: h */
    private Object f22616h;

    public ProGuard() {
        String[] split = m29168a("assets/stub_application_data.txt").split("\n");
        this.f22612d = split[0].toString().trim();
        this.f22613e = split[1].toString().trim();
        Log.v(f22609b, String.format("StubApplication created. Android package is %s, real application class is %s.", new Object[]{this.f22613e, this.f22612d}));
    }

    /* renamed from: a */
    private String m29167a() {
        StringBuilder sb = new StringBuilder();
        sb.append("/data/local/tmp/incrementaldeployment/");
        sb.append(this.f22613e);
        sb.append("/");
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(sb2);
        sb3.append("resources.ap_");
        String sb4 = sb3.toString();
        if (!new File(sb4).isFile()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(sb2);
            sb5.append("resources");
            sb4 = sb5.toString();
            if (!new File(sb4).isDirectory()) {
                Log.v(f22609b, "Cannot find external resources, not patching them in");
                return null;
            }
        }
        String str = f22609b;
        StringBuilder sb6 = new StringBuilder();
        sb6.append("Found external resources at ");
        sb6.append(sb4);
        Log.v(str, sb6.toString());
        return sb4;
    }

    /* renamed from: a */
    private List<String> m29170a(Context context, String str) {
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
    private String m29168a(String str) {
        InputStream inputStream = null;
        try {
            InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(str);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = resourceAsStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            String str2 = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
            if (resourceAsStream != null) {
                try {
                    resourceAsStream.close();
                } catch (IOException unused) {
                }
            }
            return str2;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    /*  JADX ERROR: NullPointerException in pass: RegionMakerVisitor
        java.lang.NullPointerException
        	at java.util.BitSet.and(BitSet.java:916)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:434)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:962)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.util.ArrayList.forEach(ArrayList.java:1249)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:30)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
        	at java.util.ArrayList.forEach(ArrayList.java:1249)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
        	at jadx.core.ProcessClass.process(ProcessClass.java:35)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        */
    /* renamed from: b */
    private void m29175b() {
        /*
        r12 = this;
        java.lang.String r0 = "android.app.ActivityThread"
        java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        java.lang.String r1 = "currentActivityThread"     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        r2 = 0     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        java.lang.reflect.Method r1 = r0.getMethod(r1, r3)     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        r3 = 1     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        r1.setAccessible(r3)     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        r5 = 0     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        java.lang.Object r1 = r1.invoke(r5, r4)     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        java.lang.String r4 = "mInitialApplication"     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        java.lang.reflect.Field r4 = r0.getDeclaredField(r4)     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        r4.setAccessible(r3)     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        java.lang.Object r6 = r4.get(r1)     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        android.app.Application r6 = (android.app.Application) r6     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        if (r6 != r12) goto L_0x0030     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        android.app.Application r6 = r12.f22615g     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        r4.set(r1, r6)     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
    L_0x0030:
        java.lang.String r4 = "mAllApplications"     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        java.lang.reflect.Field r4 = r0.getDeclaredField(r4)     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        r4.setAccessible(r3)     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        java.lang.Object r4 = r4.get(r1)     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        java.util.List r4 = (java.util.List) r4     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        r6 = 0     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
    L_0x0040:
        int r7 = r4.size()     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        if (r6 >= r7) goto L_0x0054     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        java.lang.Object r7 = r4.get(r6)     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        if (r7 != r12) goto L_0x0051     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        android.app.Application r7 = r12.f22615g     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        r4.set(r6, r7)     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
    L_0x0051:
        int r6 = r6 + 1
        goto L_0x0040
    L_0x0054:
        java.lang.String r4 = "android.app.LoadedApk"
        java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ ClassNotFoundException -> 0x005b, IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, InvocationTargetException -> 0x00d5 }
        goto L_0x0061
    L_0x005b:
        java.lang.String r4 = "android.app.ActivityThread$PackageInfo"
        java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
    L_0x0061:
        java.lang.String r6 = "mApplication"     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        java.lang.reflect.Field r6 = r4.getDeclaredField(r6)     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        r6.setAccessible(r3)     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        java.lang.String r7 = "mResDir"     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        java.lang.reflect.Field r4 = r4.getDeclaredField(r7)     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        r4.setAccessible(r3)     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        java.lang.Class<android.app.Application> r7 = android.app.Application.class
        java.lang.String r8 = "mLoadedApk"
        java.lang.reflect.Field r5 = r7.getDeclaredField(r8)     // Catch:{ NoSuchFieldException -> 0x007b, IllegalAccessException -> 0x00dd, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
    L_0x007b:
        java.lang.String r7 = "mPackages"
        java.lang.String r8 = "mResourcePackages"
        java.lang.String[] r7 = new java.lang.String[]{r7, r8}     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        int r8 = r7.length     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
    L_0x0084:
        if (r2 >= r8) goto L_0x00f4     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        r9 = r7[r2]     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        java.lang.reflect.Field r9 = r0.getDeclaredField(r9)     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        r9.setAccessible(r3)     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        java.lang.Object r9 = r9.get(r1)     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        java.util.Map r9 = (java.util.Map) r9     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        java.util.Set r9 = r9.entrySet()     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        java.util.Iterator r9 = r9.iterator()     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
    L_0x009d:
        boolean r10 = r9.hasNext()     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        if (r10 == 0) goto L_0x00d2     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        java.lang.Object r10 = r9.next()     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        java.util.Map$Entry r10 = (java.util.Map.Entry) r10     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        java.lang.Object r10 = r10.getValue()     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        java.lang.ref.WeakReference r10 = (java.lang.ref.WeakReference) r10     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        java.lang.Object r10 = r10.get()     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        if (r10 != 0) goto L_0x00b6     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        goto L_0x009d     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
    L_0x00b6:
        java.lang.Object r11 = r6.get(r10)     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        if (r11 != r12) goto L_0x009d     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        android.app.Application r11 = r12.f22615g     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        r6.set(r10, r11)     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        java.lang.String r11 = r12.f22614f     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        if (r11 == 0) goto L_0x00ca     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        java.lang.String r11 = r12.f22614f     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        r4.set(r10, r11)     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
    L_0x00ca:
        if (r5 == 0) goto L_0x009d     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        android.app.Application r11 = r12.f22615g     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        r5.set(r11, r10)     // Catch:{ IllegalAccessException -> 0x00dd, NoSuchFieldException -> 0x00db, NoSuchMethodException -> 0x00d9, ClassNotFoundException -> 0x00d7, InvocationTargetException -> 0x00d5 }
        goto L_0x009d
    L_0x00d2:
        int r2 = r2 + 1
        goto L_0x0084
    L_0x00d5:
        r0 = move-exception
        goto L_0x00de
    L_0x00d7:
        r0 = move-exception
        goto L_0x00de
    L_0x00d9:
        r0 = move-exception
        goto L_0x00de
    L_0x00db:
        r0 = move-exception
        goto L_0x00de
    L_0x00dd:
        r0 = move-exception
    L_0x00de:
        java.lang.String r1 = f22609b
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>()
        java.lang.String r3 = "monkeyPatchApplication :"
        r2.append(r3)
        r2.append(r0)
        java.lang.String r0 = r2.toString()
        android.util.Log.e(r1, r0)
    L_0x00f4:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.otherPush.ProGuard.m29175b():void");
    }

    /* JADX WARNING: type inference failed for: r2v4, types: [java.util.Collection] */
    /* JADX WARNING: type inference failed for: r2v8, types: [java.util.Collection] */
    /* JADX WARNING: type inference failed for: r2v9, types: [java.util.Collection] */
    /* JADX WARNING: type inference failed for: r2v11 */
    /* JADX WARNING: type inference failed for: r2v12 */
    /*  JADX ERROR: NullPointerException in pass: RegionMakerVisitor
        java.lang.NullPointerException
        	at java.util.BitSet.and(BitSet.java:916)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:434)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:962)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.util.ArrayList.forEach(ArrayList.java:1249)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:30)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
        	at java.util.ArrayList.forEach(ArrayList.java:1249)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
        	at jadx.core.ProcessClass.process(ProcessClass.java:35)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: c */
    private void m29176c() {
        /*
        r8 = this;
        java.lang.String r0 = "mAssets"
        java.lang.String r1 = r8.f22614f
        if (r1 != 0) goto L_0x0007
        return
    L_0x0007:
        java.lang.Class<android.content.res.AssetManager> r1 = android.content.res.AssetManager.class
        r2 = 0
        java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        java.lang.reflect.Constructor r1 = r1.getConstructor(r3)     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        java.lang.Object r1 = r1.newInstance(r3)     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        android.content.res.AssetManager r1 = (android.content.res.AssetManager) r1     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        java.lang.Class<android.content.res.AssetManager> r3 = android.content.res.AssetManager.class     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        java.lang.String r4 = "addAssetPath"     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        r5 = 1     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        java.lang.Class<java.lang.String> r7 = java.lang.String.class     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        r6[r2] = r7     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r6)     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        r3.setAccessible(r5)     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        java.lang.Object[] r4 = new java.lang.Object[r5]     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        java.lang.String r6 = r8.f22614f     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        r4[r2] = r6     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        java.lang.Object r3 = r3.invoke(r1, r4)     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        int r3 = r3.intValue()     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        if (r3 == 0) goto L_0x00d5     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        java.lang.Class<android.content.res.AssetManager> r3 = android.content.res.AssetManager.class     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        java.lang.String r4 = "ensureStringBlocks"     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r6)     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        r3.setAccessible(r5)     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        r3.invoke(r1, r4)     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        java.lang.String r3 = "android.app.ResourcesManager"     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        java.lang.String r4 = "getInstance"     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        java.lang.reflect.Method r4 = r3.getDeclaredMethod(r4, r6)     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        r4.setAccessible(r5)     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        r6 = 0     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        java.lang.Object r2 = r4.invoke(r6, r2)     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        java.lang.String r4 = "mActiveResources"
        java.lang.reflect.Field r4 = r3.getDeclaredField(r4)     // Catch:{ NoSuchFieldException -> 0x007a, IllegalAccessException -> 0x00e7, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        r4.setAccessible(r5)     // Catch:{ NoSuchFieldException -> 0x007a, IllegalAccessException -> 0x00e7, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        java.lang.Object r4 = r4.get(r2)     // Catch:{ NoSuchFieldException -> 0x007a, IllegalAccessException -> 0x00e7, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        android.util.ArrayMap r4 = (android.util.ArrayMap) r4     // Catch:{ NoSuchFieldException -> 0x007a, IllegalAccessException -> 0x00e7, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        java.util.Collection r2 = r4.values()     // Catch:{ NoSuchFieldException -> 0x007a, IllegalAccessException -> 0x00e7, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        goto L_0x0089
    L_0x007a:
        java.lang.String r4 = "mResourceReferences"
        java.lang.reflect.Field r3 = r3.getDeclaredField(r4)     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        r3.setAccessible(r5)     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        java.lang.Object r2 = r3.get(r2)     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        java.util.Collection r2 = (java.util.Collection) r2     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
    L_0x0089:
        java.util.Iterator r2 = r2.iterator()     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
    L_0x008d:
        boolean r3 = r2.hasNext()     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        if (r3 == 0) goto L_0x00fe     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        java.lang.Object r3 = r2.next()     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        java.lang.ref.WeakReference r3 = (java.lang.ref.WeakReference) r3     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        java.lang.Object r3 = r3.get()     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        android.content.res.Resources r3 = (android.content.res.Resources) r3     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        java.lang.Class<android.content.res.Resources> r4 = android.content.res.Resources.class
        java.lang.reflect.Field r4 = r4.getDeclaredField(r0)     // Catch:{ NoSuchFieldException -> 0x00ac, IllegalAccessException -> 0x00e7, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        r4.setAccessible(r5)     // Catch:{ NoSuchFieldException -> 0x00ac, IllegalAccessException -> 0x00e7, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        r4.set(r3, r1)     // Catch:{ NoSuchFieldException -> 0x00ac, IllegalAccessException -> 0x00e7, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        goto L_0x00c9
    L_0x00ac:
        java.lang.Class<android.content.res.Resources> r4 = android.content.res.Resources.class
        java.lang.String r6 = "mResourcesImpl"
        java.lang.reflect.Field r4 = r4.getDeclaredField(r6)     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        r4.setAccessible(r5)     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        java.lang.Object r4 = r4.get(r3)     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        java.lang.Class r6 = r4.getClass()     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        java.lang.reflect.Field r6 = r6.getDeclaredField(r0)     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        r6.setAccessible(r5)     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        r6.set(r4, r1)     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
    L_0x00c9:
        android.content.res.Configuration r4 = r3.getConfiguration()     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        android.util.DisplayMetrics r6 = r3.getDisplayMetrics()     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        r3.updateConfiguration(r4, r6)     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        goto L_0x008d     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
    L_0x00d5:
        java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        java.lang.String r1 = "Could not create new AssetManager"     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        r0.<init>(r1)     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
        throw r0     // Catch:{ IllegalAccessException -> 0x00e7, NoSuchFieldException -> 0x00e5, NoSuchMethodException -> 0x00e3, ClassNotFoundException -> 0x00e1, InvocationTargetException -> 0x00df, InstantiationException -> 0x00dd }
    L_0x00dd:
        r0 = move-exception
        goto L_0x00e8
    L_0x00df:
        r0 = move-exception
        goto L_0x00e8
    L_0x00e1:
        r0 = move-exception
        goto L_0x00e8
    L_0x00e3:
        r0 = move-exception
        goto L_0x00e8
    L_0x00e5:
        r0 = move-exception
        goto L_0x00e8
    L_0x00e7:
        r0 = move-exception
    L_0x00e8:
        java.lang.String r1 = f22609b
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>()
        java.lang.String r3 = "monkeyPatchExistingResources :"
        r2.append(r3)
        r2.append(r0)
        java.lang.String r0 = r2.toString()
        android.util.Log.e(r1, r0)
    L_0x00fe:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.otherPush.ProGuard.m29176c():void");
    }

    /* renamed from: a */
    private void m29173a(File file, String str, Context context) {
        this.f22614f = m29167a();
        String str2 = "_loadFailCount";
        if (context != null) {
            try {
                if (context.getApplicationContext() != null) {
                    XGPatchMonitor.onConfigAction(context, XGPushConfig.getAccessId(context), f22611i, XGPatchMonitor.ActionReadyPatch, 0, "Patch load Start", null);
                }
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f22613e);
                sb.append(str2);
                String sb2 = sb.toString();
                int i = f22608a + 1;
                f22608a = i;
                C6816b.m29186b(context, sb2, i);
                String str3 = f22609b;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("instantiateRealApplication :");
                sb3.append(th);
                Log.e(str3, sb3.toString());
                if (!(context == null || context.getApplicationContext() == null)) {
                    XGPatchMonitor.onConfigAction(context, XGPushConfig.getAccessId(context), f22611i, XGPatchMonitor.ActionParsePatch, 1803, "IncrementalClassLoader inject failed", null);
                }
            }
        }
        String b = m29174b(str);
        if (!(context == null || context.getApplicationContext() == null)) {
            XGPatchMonitor.onConfigAction(context, XGPushConfig.getAccessId(context), f22611i, XGPatchMonitor.ActionParsePatch, 0, "IncrementalClassLoader inject", null);
        }
        C6813a.m29182a(ProGuard.class.getClassLoader(), this.f22613e, file, b, m29170a(context, this.f22613e));
        try {
            String str4 = f22609b;
            StringBuilder sb4 = new StringBuilder();
            sb4.append("realClassName =  ");
            sb4.append(this.f22612d);
            Log.i(str4, sb4.toString());
            this.f22615g = (Application) Class.forName(this.f22612d).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.f22613e);
            sb5.append(str2);
            String sb6 = sb5.toString();
            int i2 = f22608a + 1;
            f22608a = i2;
            C6816b.m29186b(context, sb6, i2);
            String str5 = f22609b;
            StringBuilder sb7 = new StringBuilder();
            sb7.append("RealApplication :");
            sb7.append(e);
            Log.e(str5, sb7.toString());
        }
    }

    /* renamed from: b */
    private String m29174b(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("/data/local/tmp/incrementaldeployment/");
        sb.append(this.f22613e);
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
        Map a = m29171a(file2);
        Map hashMap = new HashMap();
        HashSet hashSet = new HashSet();
        HashSet<String> hashSet2 = new HashSet<>();
        if (!a.isEmpty()) {
            sb4 = file3.toString();
        }
        if (file3.exists() || file3.mkdirs()) {
            if (file4.exists()) {
                hashMap = m29171a(file4);
            } else {
                for (String add : file3.list(f22610c)) {
                    hashSet.add(add);
                }
            }
            for (String str2 : hashMap.keySet()) {
                if (!a.containsKey(str2) || !((String) a.get(str2)).equals(hashMap.get(str2))) {
                    hashSet.add(str2);
                }
            }
            for (String str3 : a.keySet()) {
                if (!hashMap.containsKey(str3) || !((String) hashMap.get(str3)).equals(a.get(str3))) {
                    hashSet2.add(str3);
                }
            }
            if (hashSet.isEmpty() && hashSet2.isEmpty()) {
                return sb4;
            }
            file4.delete();
            Iterator it = hashSet.iterator();
            while (true) {
                String str4 = "/";
                if (it.hasNext()) {
                    String str5 = (String) it.next();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(file3);
                    sb5.append(str4);
                    sb5.append(str5);
                    File file5 = new File(sb5.toString());
                    String str6 = f22609b;
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("Deleting ");
                    sb6.append(file5);
                    Log.v(str6, sb6.toString());
                    if (file5.exists()) {
                        if (!file5.delete()) {
                            StringBuilder sb7 = new StringBuilder();
                            sb7.append("Could not delete ");
                            sb7.append(file5);
                            throw new IOException(sb7.toString());
                        }
                    }
                } else {
                    for (String str7 : hashSet2) {
                        String str8 = f22609b;
                        StringBuilder sb8 = new StringBuilder();
                        sb8.append("Copying: ");
                        sb8.append(str7);
                        Log.v(str8, sb8.toString());
                        StringBuilder sb9 = new StringBuilder();
                        sb9.append(file);
                        sb9.append(str4);
                        sb9.append(str7);
                        File file6 = new File(sb9.toString());
                        StringBuilder sb10 = new StringBuilder();
                        sb10.append(file3);
                        sb10.append(str4);
                        sb10.append(str7);
                        m29172a(file6, new File(sb10.toString()));
                    }
                    try {
                        m29172a(file2, file4);
                        return sb4;
                    } finally {
                        file4.delete();
                    }
                }
            }
        } else {
            StringBuilder sb11 = new StringBuilder();
            sb11.append("Could not mkdir ");
            sb11.append(file3);
            throw new IOException(sb11.toString());
        }
    }

    /* renamed from: a */
    private static Map<String, String> m29171a(File file) {
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

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004d  */
    /* renamed from: a */
    private static void m29172a(java.io.File r3, java.io.File r4) {
        /*
        java.lang.String r0 = f22609b
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.otherPush.ProGuard.m29172a(java.io.File, java.io.File):void");
    }

    /* renamed from: a */
    private static Field m29169a(Object obj, String str) {
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                declaredField.setAccessible(true);
                return declaredField;
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Field '");
        sb.append(str);
        sb.append("' not found");
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: d */
    private void m29177d() {
        Log.v(f22609b, "enableContentProviders");
        try {
            Class cls = Class.forName("android.app.ActivityThread");
            Method method = cls.getMethod("currentActivityThread", new Class[0]);
            method.setAccessible(true);
            Object invoke = method.invoke(null, new Object[0]);
            Object obj = m29169a(invoke, "mBoundApplication").get(invoke);
            m29169a(obj, "providers").set(obj, this.f22616h);
            if (this.f22616h != null) {
                Method declaredMethod = cls.getDeclaredMethod("installContentProviders", new Class[]{Context.class, List.class});
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(invoke, new Object[]{this.f22615g, this.f22616h});
                this.f22616h = null;
            }
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            String str = f22609b;
            StringBuilder sb = new StringBuilder();
            sb.append("enableContentProviders :");
            sb.append(e);
            Log.e(str, sb.toString());
        }
    }

    /* renamed from: e */
    private void m29178e() {
        Log.v(f22609b, "disableContentProviders");
        try {
            Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
            method.setAccessible(true);
            Object invoke = method.invoke(null, new Object[0]);
            Object obj = m29169a(invoke, "mBoundApplication").get(invoke);
            Field a = m29169a(obj, "providers");
            this.f22616h = a.get(obj);
            a.set(obj, null);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            String str = f22609b;
            StringBuilder sb = new StringBuilder();
            sb.append("disableContentProviders :");
            sb.append(e);
            Log.e(str, sb.toString());
        }
    }

    /* renamed from: f */
    private static String m29179f() {
        String str = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str) ? str.trim().toLowerCase() : str;
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        char c;
        super.attachBaseContext(context);
        String absolutePath = context.getDir(TinkerManager.PATCH_DIR, 0).getAbsolutePath();
        String f = m29179f();
        if ("xiaomi".equals(f)) {
            f22611i = XGPatchMonitor.TypeXiaoMi;
            c = 1;
        } else if (OEM.HUAWEI.equals(f)) {
            f22611i = XGPatchMonitor.TypeHauwei;
            c = 5;
        } else {
            if ("meizu".equals(f)) {
                f22611i = XGPatchMonitor.TypeMeizu;
                c = 2;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f22613e);
        sb.append("_dexPath");
        String str = "";
        String a = C6816b.m29185a(context, sb.toString(), str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f22613e);
        String str2 = "_loadFailCount";
        sb2.append(str2);
        int a2 = C6816b.m29183a(context, sb2.toString(), 0);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(this.f22613e);
        sb3.append("_ccConfig");
        String a3 = C6816b.m29185a(context, sb3.toString(), str);
        if (!TextUtils.isEmpty(a3)) {
            try {
                if (new JSONObject(a3).optBoolean("enable", true)) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(context.getPackageName());
                    sb4.append(str2);
                    C6816b.m29186b(context, sb4.toString(), 0);
                } else {
                    return;
                }
            } catch (Throwable th) {
                String str3 = f22609b;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("ccConfig paser exception :");
                sb5.append(th);
                Log.e(str3, sb5.toString());
                return;
            }
        }
        if (TextUtils.isEmpty(a) || a2 >= 1) {
            Log.v(f22609b, "path is null or loadFailCount > = 1");
            return;
        }
        m29173a(context.getCacheDir(), absolutePath, context);
        if (c == 1) {
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
                StringBuilder sb6 = new StringBuilder();
                sb6.append(this.f22613e);
                sb6.append(str2);
                String sb7 = sb6.toString();
                int i = f22608a + 1;
                f22608a = i;
                C6816b.m29186b(context, sb7, i);
            }
        } else if (c == 2) {
            try {
                Class.forName(MzPushMessageReceiver.class.getName());
                Class.forName("com.tencent.otherpush.receiver.MzReceiver");
                Class.forName(NotificationService.class.getName());
                Class.forName(SystemReceiver.class.getName());
                Class.forName(PushManager.class.getName());
            } catch (Throwable unused2) {
                StringBuilder sb8 = new StringBuilder();
                sb8.append(this.f22613e);
                sb8.append(str2);
                String sb9 = sb8.toString();
                int i2 = f22608a + 1;
                f22608a = i2;
                C6816b.m29186b(context, sb9, i2);
            }
        } else if (c == 5) {
            try {
                Class.forName(PushEventReceiver.class.getName());
                Class.forName(HwReceiver.class.getName());
            } catch (Throwable unused3) {
                StringBuilder sb10 = new StringBuilder();
                sb10.append(this.f22613e);
                sb10.append(str2);
                String sb11 = sb10.toString();
                int i3 = f22608a + 1;
                f22608a = i3;
                C6816b.m29186b(context, sb11, i3);
            }
        }
        try {
            Method declaredMethod = ContextWrapper.class.getDeclaredMethod("attachBaseContext", new Class[]{Context.class});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this.f22615g, new Object[]{context});
            m29178e();
        } catch (Exception e) {
            StringBuilder sb12 = new StringBuilder();
            sb12.append(this.f22613e);
            sb12.append(str2);
            String sb13 = sb12.toString();
            int i4 = f22608a + 1;
            f22608a = i4;
            C6816b.m29186b(context, sb13, i4);
            String str4 = f22609b;
            StringBuilder sb14 = new StringBuilder();
            sb14.append("attachBaseContext :");
            sb14.append(e);
            Log.e(str4, sb14.toString());
        }
    }

    public void onCreate() {
        m29175b();
        m29176c();
        m29177d();
        super.onCreate();
        this.f22615g.onCreate();
    }
}
