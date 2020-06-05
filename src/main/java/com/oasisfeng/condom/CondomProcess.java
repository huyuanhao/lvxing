package com.oasisfeng.condom;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.os.Process;
import android.util.Log;
import com.tencent.android.tpush.common.Constants;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CondomProcess {
    static String FULL_TAG = "CondomProcess";
    static String TAG = "CondomProcess";

    /* renamed from: com.oasisfeng.condom.CondomProcess$CondomProcessActivityManager */
    static class CondomProcessActivityManager extends CondomSystemService {
        /* renamed from: a */
        private final CondomCore f15384a;

        /* renamed from: a */
        private java.lang.Object m19569a(final java.lang.Object r8, final java.lang.reflect.Method r9, final java.lang.Object[] r10) throws java.lang.Exception {
            /*
            r7 = this;
            java.lang.String r0 = r9.getName()
            int r1 = r0.hashCode()
            r2 = 3
            r3 = 0
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)
            r5 = 2
            r6 = 1
            switch(r1) {
                case 972810068: goto L_0x0032;
                case 1155315389: goto L_0x0028;
                case 1418030008: goto L_0x001e;
                case 1849706483: goto L_0x0014;
                default: goto L_0x0013;
            }
        L_0x0013:
            goto L_0x003c
        L_0x0014:
            java.lang.String r1 = "startService"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x003c
            r0 = 2
            goto L_0x003d
        L_0x001e:
            java.lang.String r1 = "bindService"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x003c
            r0 = 1
            goto L_0x003d
        L_0x0028:
            java.lang.String r1 = "broadcastIntent"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x003c
            r0 = 0
            goto L_0x003d
        L_0x0032:
            java.lang.String r1 = "getContentProvider"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x003c
            r0 = 3
            goto L_0x003d
        L_0x003c:
            r0 = -1
        L_0x003d:
            if (r0 == 0) goto L_0x00a7
            if (r0 == r6) goto L_0x0080
            r1 = 0
            if (r0 == r5) goto L_0x005d
            if (r0 == r2) goto L_0x0047
            goto L_0x0058
        L_0x0047:
            r0 = r10[r6]
            java.lang.String r0 = (java.lang.String) r0
            com.oasisfeng.condom.CondomCore r2 = r7.f15384a
            android.content.Context r3 = r2.mBase
            r4 = 8192(0x2000, float:1.14794E-41)
            boolean r0 = r2.shouldAllowProvider(r3, r0, r4)
            if (r0 != 0) goto L_0x0058
            return r1
        L_0x0058:
            java.lang.Object r8 = super.invoke(r8, r9, r10)
            return r8
        L_0x005d:
            r0 = r10[r6]
            android.content.Intent r0 = (android.content.Intent) r0
            com.oasisfeng.condom.CondomCore r2 = r7.f15384a
            com.oasisfeng.condom.OutboundType r3 = com.oasisfeng.condom.OutboundType.START_SERVICE
            com.oasisfeng.condom.CondomProcess$CondomProcessActivityManager$3 r4 = new com.oasisfeng.condom.CondomProcess$CondomProcessActivityManager$3
            r4.m48843init(r8, r9, r10)
            java.lang.Object r8 = r2.proceed(r3, r0, r1, r4)
            android.content.ComponentName r8 = (android.content.ComponentName) r8
            if (r8 == 0) goto L_0x007f
            com.oasisfeng.condom.CondomCore r9 = r7.f15384a
            java.lang.String r10 = com.oasisfeng.condom.CondomProcess.FULL_TAG
            java.lang.String r1 = r8.getPackageName()
            com.oasisfeng.condom.CondomCore$CondomEvent r2 = com.oasisfeng.condom.CondomCore.CondomEvent.START_PASS
            r9.logIfOutboundPass(r10, r0, r1, r2)
        L_0x007f:
            return r8
        L_0x0080:
            r0 = r10[r5]
            android.content.Intent r0 = (android.content.Intent) r0
            com.oasisfeng.condom.CondomCore r1 = r7.f15384a
            com.oasisfeng.condom.OutboundType r2 = com.oasisfeng.condom.OutboundType.BIND_SERVICE
            com.oasisfeng.condom.CondomProcess$CondomProcessActivityManager$2 r3 = new com.oasisfeng.condom.CondomProcess$CondomProcessActivityManager$2
            r3.m48842init(r8, r9, r10)
            java.lang.Object r8 = r1.proceed(r2, r0, r4, r3)
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r9 = r8.intValue()
            if (r9 <= 0) goto L_0x00a6
            com.oasisfeng.condom.CondomCore r9 = r7.f15384a
            java.lang.String r10 = com.oasisfeng.condom.CondomProcess.FULL_TAG
            java.lang.String r1 = com.oasisfeng.condom.CondomCore.getTargetPackage(r0)
            com.oasisfeng.condom.CondomCore$CondomEvent r2 = com.oasisfeng.condom.CondomCore.CondomEvent.BIND_PASS
            r9.logIfOutboundPass(r10, r0, r1, r2)
        L_0x00a6:
            return r8
        L_0x00a7:
            com.oasisfeng.condom.CondomCore r0 = r7.f15384a
            com.oasisfeng.condom.OutboundType r1 = com.oasisfeng.condom.OutboundType.BROADCAST
            r2 = r10[r6]
            android.content.Intent r2 = (android.content.Intent) r2
            com.oasisfeng.condom.CondomProcess$CondomProcessActivityManager$1 r3 = new com.oasisfeng.condom.CondomProcess$CondomProcessActivityManager$1
            r3.m48841init(r8, r9, r10)
            java.lang.Object r8 = r0.proceed(r1, r2, r4, r3)
            return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oasisfeng.condom.CondomProcess.CondomProcessActivityManager.m19569a(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object");
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            try {
                obj = m19569a(obj, method, objArr);
                return obj;
            } catch (Exception e) {
                if (this.f15411c) {
                    String str = CondomProcess.TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Error proceeding ");
                    sb.append(method);
                    Log.e(str, sb.toString(), e);
                }
                return super.invoke(obj, method, objArr);
            }
        }

        CondomProcessActivityManager(CondomCore condomCore, Object obj) {
            super(obj, "IActivityManager.", condomCore.DEBUG);
            this.f15384a = condomCore;
        }
    }

    /* renamed from: com.oasisfeng.condom.CondomProcess$CondomProcessPackageManager */
    static class CondomProcessPackageManager extends CondomSystemService {
        /* renamed from: a */
        final Intent f15397a = new Intent();
        /* renamed from: b */
        final CondomCore f15398b;
        /* access modifiers changed from: private */
        /* renamed from: d */
        public Method f15399d;
        /* renamed from: e */
        private Method f15400e;

        /* renamed from: a */
        private java.lang.Object m19579a(java.lang.Object r13, java.lang.reflect.Method r14, java.lang.Object[] r15) throws java.lang.Exception {
            /*
            r12 = this;
            java.lang.String r0 = r14.getName()
            int r1 = r0.hashCode()
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            switch(r1) {
                case -297395415: goto L_0x0044;
                case -150905391: goto L_0x003a;
                case -109758974: goto L_0x0030;
                case 1326102014: goto L_0x0026;
                case 1600494599: goto L_0x001c;
                case 1786110784: goto L_0x0012;
                default: goto L_0x0011;
            }
        L_0x0011:
            goto L_0x004e
        L_0x0012:
            java.lang.String r1 = "queryIntentReceivers"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x004e
            r1 = 1
            goto L_0x004f
        L_0x001c:
            java.lang.String r1 = "getInstalledApplications"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x004e
            r1 = 4
            goto L_0x004f
        L_0x0026:
            java.lang.String r1 = "resolveContentProvider"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x004e
            r1 = 3
            goto L_0x004f
        L_0x0030:
            java.lang.String r1 = "queryIntentServices"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x004e
            r1 = 0
            goto L_0x004f
        L_0x003a:
            java.lang.String r1 = "getInstalledPackages"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x004e
            r1 = 5
            goto L_0x004f
        L_0x0044:
            java.lang.String r1 = "resolveService"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x004e
            r1 = 2
            goto L_0x004f
        L_0x004e:
            r1 = -1
        L_0x004f:
            r8 = 0
            if (r1 == 0) goto L_0x00a9
            if (r1 == r6) goto L_0x00a7
            if (r1 == r5) goto L_0x008b
            if (r1 == r4) goto L_0x007a
            if (r1 == r3) goto L_0x005d
            if (r1 == r2) goto L_0x005d
            goto L_0x0075
        L_0x005d:
            com.oasisfeng.condom.CondomCore r1 = r12.f15398b
            java.lang.String r2 = com.oasisfeng.condom.CondomProcess.FULL_TAG
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "IPackageManager."
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r1.logConcern(r2, r0)
        L_0x0075:
            java.lang.Object r13 = super.invoke(r13, r14, r15)
            return r13
        L_0x007a:
            java.lang.Object r13 = super.invoke(r13, r14, r15)
            android.content.pm.ProviderInfo r13 = (android.content.pm.ProviderInfo) r13
            com.oasisfeng.condom.CondomCore r14 = r12.f15398b
            boolean r14 = r14.shouldAllowProvider(r13)
            if (r14 == 0) goto L_0x0089
            goto L_0x008a
        L_0x0089:
            r13 = r8
        L_0x008a:
            return r13
        L_0x008b:
            r0 = r15[r7]
            android.content.Intent r0 = (android.content.Intent) r0
            int r7 = r0.getFlags()
            com.oasisfeng.condom.CondomCore r9 = r12.f15398b
            com.oasisfeng.condom.OutboundType r10 = com.oasisfeng.condom.OutboundType.QUERY_SERVICES
            com.oasisfeng.condom.CondomProcess$CondomProcessPackageManager$2 r11 = new com.oasisfeng.condom.CondomProcess$CondomProcessPackageManager$2
            r1 = r11
            r2 = r12
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r0
            r1.m48846init(r3, r4, r5, r6, r7)
            java.lang.Object r13 = r9.proceed(r10, r0, r8, r11)
            return r13
        L_0x00a7:
            r0 = r8
            goto L_0x00b8
        L_0x00a9:
            com.oasisfeng.condom.OutboundType r0 = com.oasisfeng.condom.OutboundType.QUERY_SERVICES
            java.lang.reflect.Method r1 = r12.f15399d
            if (r1 != 0) goto L_0x00b1
            r12.f15399d = r14
        L_0x00b1:
            r1 = r15[r7]
            android.content.Intent r2 = r12.f15397a
            if (r1 != r2) goto L_0x00b8
            return r8
        L_0x00b8:
            if (r0 != 0) goto L_0x00bc
            com.oasisfeng.condom.OutboundType r0 = com.oasisfeng.condom.OutboundType.QUERY_RECEIVERS
        L_0x00bc:
            java.lang.Object r13 = super.invoke(r13, r14, r15)
            com.oasisfeng.condom.CondomCore r14 = r12.f15398b
            r15 = r15[r7]
            android.content.Intent r15 = (android.content.Intent) r15
            com.oasisfeng.condom.CondomProcess$CondomProcessPackageManager$1 r1 = new com.oasisfeng.condom.CondomProcess$CondomProcessPackageManager$1
            r1.m48845init(r13)
            java.util.List r14 = r14.proceedQuery(r0, r15, r1)
            boolean r14 = r14.isEmpty()
            if (r14 == 0) goto L_0x00dc
            java.util.List r14 = r12.m19582a(r13)
            r14.clear()
        L_0x00dc:
            return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oasisfeng.condom.CondomProcess.CondomProcessPackageManager.m19579a(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object");
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public <T> List<T> m19582a(Object obj) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
            if (obj instanceof List) {
                return (List) obj;
            }
            Class cls = obj.getClass();
            if ("android.content.pm.ParceledListSlice".equals(cls.getName())) {
                if (this.f15400e == null) {
                    this.f15400e = cls.getMethod("getList", new Class[0]);
                }
                return (List) this.f15400e.invoke(obj, new Object[0]);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Neither List nor ParceledListSlice: ");
            sb.append(cls);
            throw new IllegalArgumentException(sb.toString());
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            try {
                obj = m19579a(obj, method, objArr);
                return obj;
            } catch (Exception e) {
                if (this.f15411c) {
                    String str = CondomProcess.TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Error proceeding ");
                    sb.append(method);
                    Log.e(str, sb.toString(), e);
                }
                return super.invoke(obj, method, objArr);
            }
        }

        CondomProcessPackageManager(CondomCore condomCore, Object obj) {
            super(obj, "IPackageManager.", condomCore.DEBUG);
            this.f15398b = condomCore;
        }
    }

    /* renamed from: com.oasisfeng.condom.CondomProcess$CondomSystemService */
    private static class CondomSystemService implements InvocationHandler {
        /* renamed from: a */
        private final Object f15409a;
        /* renamed from: b */
        private final String f15410b;
        /* renamed from: c */
        final boolean f15411c;

        public Object invoke(Object obj, Method method, Object[] objArr) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (this.f15411c) {
                String str = CondomProcess.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append(this.f15410b);
                sb.append(method.getName());
                sb.append(objArr == null ? "" : Arrays.toString(objArr));
                Log.d(str, sb.toString());
            }
            return method.invoke(this.f15409a, objArr);
        }

        CondomSystemService(Object obj, String str, boolean z) {
            this.f15409a = obj;
            this.f15410b = str;
            this.f15411c = z;
        }
    }

    public static void installExceptDefaultProcess(Application application) {
        installExceptDefaultProcess(application, new CondomOptions());
    }

    public static void installExceptDefaultProcess(Application application, CondomOptions condomOptions) {
        String processName = getProcessName(application);
        if (processName != null && !processName.equals(application.getApplicationInfo().processName)) {
            install(application, processName, condomOptions);
        }
    }

    public static void installExcept(Application application, CondomOptions condomOptions, String... strArr) {
        if (strArr.length != 0) {
            String processName = getProcessName(application);
            if (processName != null) {
                for (String fullProcessName : strArr) {
                    if (!processName.equals(getFullProcessName(application, fullProcessName))) {
                        install(application, processName, condomOptions);
                        return;
                    }
                }
                if ((application.getApplicationInfo().flags & 2) != 0) {
                    validateProcessNames(application, strArr);
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("At lease one process name must be specified");
    }

    private static void validateProcessNames(final Application application, final String[] strArr) {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                CondomProcess.doValidateProcessNames(application, strArr);
            }
        });
        thread.setPriority(1);
        thread.start();
    }

    /* access modifiers changed from: private|static */
    public static void doValidateProcessNames(Application application, String[] strArr) {
        try {
            PackageInfo packageInfo = application.getPackageManager().getPackageInfo(application.getPackageName(), 15);
            HashSet hashSet = new HashSet();
            int i = 0;
            if (packageInfo.activities != null) {
                for (ActivityInfo activityInfo : packageInfo.activities) {
                    hashSet.add(activityInfo.processName);
                }
            }
            if (packageInfo.services != null) {
                for (ServiceInfo serviceInfo : packageInfo.services) {
                    hashSet.add(serviceInfo.processName);
                }
            }
            if (packageInfo.receivers != null) {
                for (ActivityInfo activityInfo2 : packageInfo.receivers) {
                    hashSet.add(activityInfo2.processName);
                }
            }
            if (packageInfo.providers != null) {
                for (ProviderInfo providerInfo : packageInfo.providers) {
                    hashSet.add(providerInfo.processName);
                }
            }
            int length = strArr.length;
            while (i < length) {
                String str = strArr[i];
                if (hashSet.contains(getFullProcessName(application, str))) {
                    i++;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Process name \"");
                    sb.append(str);
                    sb.append("\" is not used by any component in AndroidManifest.xml");
                    throw new IllegalArgumentException(sb.toString());
                }
            }
        } catch (NameNotFoundException unused) {
        }
    }

    private static String getFullProcessName(Context context, String str) {
        if (str.length() <= 0 || str.charAt(0) != ':') {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(context.getPackageName());
        sb.append(str);
        return sb.toString();
    }

    private static String getProcessName(Context context) {
        try {
            List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(Constants.FLAG_ACTIVITY_NAME)).getRunningAppProcesses();
            int myPid = Process.myPid();
            if (runningAppProcesses != null) {
                for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == myPid) {
                        return runningAppProcessInfo.processName;
                    }
                }
            }
            Log.e(TAG, "Error querying the name of current process.");
        } catch (SecurityException unused) {
        }
        return null;
    }

    private static void install(Application application, String str, CondomOptions condomOptions) {
        int indexOf = str.indexOf(58);
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Condom:");
        sb.append(str);
        FULL_TAG = sb.toString();
        TAG = CondomCore.asLogTag(FULL_TAG);
        CondomCore condomCore = new CondomCore(application, condomOptions);
        try {
            installCondomProcessActivityManager(condomCore);
            installCondomProcessPackageManager(condomCore);
            Log.d(TAG, "Global condom is installed in current process");
        } catch (Exception e) {
            Log.e(TAG, "Error installing global condom in current process", e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0017  */
    private static void installCondomProcessActivityManager(com.oasisfeng.condom.CondomCore r7) throws java.lang.ClassNotFoundException, java.lang.NoSuchFieldException, java.lang.NoSuchMethodException, java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
        java.lang.String r0 = "android.app.ActivityManagerNative"
        java.lang.Class r0 = java.lang.Class.forName(r0)
        int r1 = android.os.Build.VERSION.SDK_INT
        r2 = 0
        r3 = 25
        if (r1 > r3) goto L_0x0014
        java.lang.String r1 = "gDefault"
        java.lang.reflect.Field r0 = r0.getDeclaredField(r1)     // Catch:{ NoSuchFieldException -> 0x0014 }
        goto L_0x0015
    L_0x0014:
        r0 = r2
    L_0x0015:
        if (r0 != 0) goto L_0x001f
        java.lang.Class<android.app.ActivityManager> r0 = android.app.ActivityManager.class
        java.lang.String r1 = "IActivityManagerSingleton"
        java.lang.reflect.Field r0 = r0.getDeclaredField(r1)
    L_0x001f:
        r1 = 1
        r0.setAccessible(r1)
        java.lang.String r3 = "android.util.Singleton"
        java.lang.Class r3 = java.lang.Class.forName(r3)
        r4 = 0
        java.lang.Class[] r5 = new java.lang.Class[r4]
        java.lang.String r6 = "get"
        java.lang.reflect.Method r5 = r3.getDeclaredMethod(r6, r5)
        r5.setAccessible(r1)
        java.lang.String r6 = "mInstance"
        java.lang.reflect.Field r3 = r3.getDeclaredField(r6)
        r3.setAccessible(r1)
        java.lang.String r6 = "android.app.IActivityManager"
        java.lang.Class r6 = java.lang.Class.forName(r6)
        java.lang.Object r0 = r0.get(r2)
        if (r0 == 0) goto L_0x008b
        java.lang.Object[] r2 = new java.lang.Object[r4]
        java.lang.Object r2 = r5.invoke(r0, r2)
        if (r2 == 0) goto L_0x0083
        java.lang.Class r5 = r2.getClass()
        boolean r5 = java.lang.reflect.Proxy.isProxyClass(r5)
        if (r5 == 0) goto L_0x006c
        java.lang.reflect.InvocationHandler r5 = java.lang.reflect.Proxy.getInvocationHandler(r2)
        boolean r5 = r5 instanceof com.oasisfeng.condom.CondomProcess.CondomProcessActivityManager
        if (r5 == 0) goto L_0x006c
        java.lang.String r7 = TAG
        java.lang.String r0 = "CondomActivityManager is already installed in this process."
        android.util.Log.d(r7, r0)
        return
    L_0x006c:
        android.content.Context r5 = r7.mBase
        java.lang.ClassLoader r5 = r5.getClassLoader()
        java.lang.Class[] r1 = new java.lang.Class[r1]
        r1[r4] = r6
        com.oasisfeng.condom.CondomProcess$CondomProcessActivityManager r4 = new com.oasisfeng.condom.CondomProcess$CondomProcessActivityManager
        r4.m48840init(r7, r2)
        java.lang.Object r7 = java.lang.reflect.Proxy.newProxyInstance(r5, r1, r4)
        r3.set(r0, r7)
        return
    L_0x0083:
        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
        java.lang.String r0 = "ActivityManagerNative.gDefault.get() returns null"
        r7.<init>(r0)
        throw r7
    L_0x008b:
        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
        java.lang.String r0 = "ActivityManagerNative.gDefault is null"
        r7.<init>(r0)
        throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oasisfeng.condom.CondomProcess.installCondomProcessActivityManager(com.oasisfeng.condom.CondomCore):void");
    }

    private static void installCondomProcessPackageManager(CondomCore condomCore) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Field declaredField = Class.forName("android.app.ActivityThread").getDeclaredField("sPackageManager");
        declaredField.setAccessible(true);
        Class cls = Class.forName("android.content.pm.IPackageManager");
        Object obj = declaredField.get(null);
        if (!Proxy.isProxyClass(obj.getClass()) || !(Proxy.getInvocationHandler(obj) instanceof CondomProcessPackageManager)) {
            declaredField.set(null, Proxy.newProxyInstance(condomCore.mBase.getClassLoader(), new Class[]{cls}, new CondomProcessPackageManager(condomCore, obj)));
            return;
        }
        Log.d(TAG, "CondomPackageManager is already installed in this process.");
    }

    private CondomProcess() {
    }
}
