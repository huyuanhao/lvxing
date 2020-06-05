package com.tencent.android.tpush.service.cache;

import android.content.Context;
import com.tencent.android.tpush.C6860a;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.common.C6905e;
import com.tencent.android.tpush.common.C6908h;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.MobileType;
import com.tencent.android.tpush.data.RegisterEntity;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.horse.data.OptStrategyList;
import com.tencent.android.tpush.horse.data.ServerItem;
import com.tencent.android.tpush.horse.data.StrategyItem;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.service.C6973b;
import com.tencent.android.tpush.service.channel.exception.NullReturnException;
import com.tencent.android.tpush.service.channel.protocol.AppInfo;
import com.tencent.android.tpush.service.channel.protocol.UnregInfo;
import com.tencent.android.tpush.service.p595e.C7056i;
import com.tencent.android.tpush.stat.p597b.C7074c;
import com.tencent.mid.api.MidService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public class CacheManager {
    /* renamed from: a */
    private static Map<Long, RegisterEntity> f23241a;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.android.tpush.service.cache.CacheManager$a */
    static class C6998a implements Runnable {
        /* renamed from: a */
        private Context f23242a;
        /* renamed from: b */
        private Map<Long, RegisterEntity> f23243b;

        public C6998a(Context context) {
            this.f23242a = context;
        }

        public void run() {
            try {
                mo33360a(C6860a.m29263e(CacheManager.getContext()));
            } catch (Exception unused) {
            }
        }

        /* renamed from: a */
        public synchronized void mo33360a(Map<Long, RegisterEntity> map) {
            this.f23243b = map;
        }

        /* renamed from: a */
        public synchronized Map<Long, RegisterEntity> mo33359a() {
            return this.f23243b;
        }
    }

    /* renamed from: a */
    private static void m29925a(String str) {
    }

    /* renamed from: a */
    private static void m29927a(String str, String str2, int i) {
    }

    private CacheManager() {
    }

    public static Map<Long, RegisterEntity> getRegInfoByApps(Context context) {
        C6998a aVar = new C6998a(context);
        Thread thread = new Thread(aVar);
        thread.start();
        try {
            thread.join(3500);
        } catch (Throwable th) {
            C6864a.m29308i(Constants.ServiceLogTag, th.toString());
        }
        return aVar.mo33359a();
    }

    public static String findValidPackageByAccessid(long j) {
        RegisterEntity registerEntity = (RegisterEntity) getRegisterEntityMap().get(Long.valueOf(j));
        if (registerEntity == null || !registerEntity.isRegistered()) {
            return null;
        }
        return registerEntity.packageName;
    }

    public static RegisterEntity findValidRegisterEntityByPkg(String str) {
        if (C7056i.m30194b(str)) {
            return null;
        }
        for (Entry value : getRegisterEntityMap().entrySet()) {
            RegisterEntity registerEntity = (RegisterEntity) value.getValue();
            if (registerEntity != null && str.equals(registerEntity.packageName)) {
                return registerEntity;
            }
        }
        return null;
    }

    public static void removeRegisterInfos(String str) {
        m29926a(str, 1);
    }

    public static List<String> getRegisterInfos(Context context) {
        ArrayList arrayList = new ArrayList();
        try {
            for (Entry value : getRegisterEntityMap().entrySet()) {
                RegisterEntity registerEntity = (RegisterEntity) value.getValue();
                if (registerEntity != null && !C7056i.m30194b(registerEntity.packageName) && registerEntity.isRegistered()) {
                    arrayList.add(registerEntity.packageName);
                }
            }
        } catch (Exception e) {
            C6864a.m29302d(Constants.ServiceLogTag, "", e);
            arrayList = new ArrayList();
        }
        if (!arrayList.contains(context.getPackageName())) {
            arrayList.add(context.getPackageName());
        }
        return arrayList;
    }

    public static synchronized Map<Long, RegisterEntity> getRegisterEntityMap() {
        Map<Long, RegisterEntity> map;
        synchronized (CacheManager.class) {
            if (f23241a == null) {
                f23241a = getRegInfoByApps(getContext());
            }
            map = f23241a;
        }
        return map;
    }

    public static RegisterEntity getCurrentAppRegisterEntity(Context context) {
        String a = C6908h.m29483a(context, m29924a("cur.register", ".reg"), "");
        if (!C7056i.m30194b(a)) {
            return RegisterEntity.decode(a);
        }
        return null;
    }

    public static void setCurrentAppRegisterEntity(Context context, RegisterEntity registerEntity) {
        C6908h.m29487b(context, m29924a("cur.register", ".reg"), RegisterEntity.encode(registerEntity));
    }

    public static Context getContext() {
        if (C6973b.m29776f() != null) {
            return C6973b.m29776f();
        }
        return XGPushManager.getContext();
    }

    public static void addRegisterInfo(RegisterEntity registerEntity) {
        if (registerEntity != null && registerEntity.accessId > 0) {
            getRegisterEntityMap().put(Long.valueOf(registerEntity.accessId), registerEntity);
        }
    }

    public static List<RegisterEntity> getRegisterInfo(Context context) {
        ArrayList arrayList = new ArrayList();
        if (context != null) {
            for (Entry value : getRegisterEntityMap().entrySet()) {
                RegisterEntity registerEntity = (RegisterEntity) value.getValue();
                if (registerEntity != null && registerEntity.isRegistered()) {
                    arrayList.add(registerEntity);
                }
            }
        }
        return arrayList;
    }

    public static List<RegisterEntity> getUnregisterInfo(Context context) {
        ArrayList arrayList = new ArrayList();
        if (context != null) {
            for (Entry value : getRegisterEntityMap().entrySet()) {
                RegisterEntity registerEntity = (RegisterEntity) value.getValue();
                if (registerEntity != null && !C7056i.m30194b(registerEntity.packageName) && registerEntity.isUnregistered()) {
                    arrayList.add(registerEntity);
                }
            }
        }
        return arrayList;
    }

    public static List<RegisterEntity> getUninstallInfo(Context context) {
        ArrayList arrayList = new ArrayList();
        if (context != null) {
            for (Entry value : getRegisterEntityMap().entrySet()) {
                RegisterEntity registerEntity = (RegisterEntity) value.getValue();
                if (registerEntity != null && !C7056i.m30194b(registerEntity.packageName) && registerEntity.isUnstalled()) {
                    arrayList.add(registerEntity);
                }
            }
        }
        return arrayList;
    }

    public static ArrayList<UnregInfo> getUninstallAndUnregisterInfo(Context context) {
        ArrayList<UnregInfo> arrayList = new ArrayList<>();
        if (context != null) {
            for (Entry value : getRegisterEntityMap().entrySet()) {
                RegisterEntity registerEntity = (RegisterEntity) value.getValue();
                if (registerEntity != null && (registerEntity.isUnregistered() || registerEntity.isUnstalled())) {
                    UnregInfo unregInfo = new UnregInfo();
                    AppInfo appInfo = new AppInfo(registerEntity.accessId, registerEntity.accessKey, C7056i.m30201d(registerEntity.packageName), 0);
                    unregInfo.appInfo = appInfo;
                    unregInfo.isUninstall = (byte) registerEntity.state;
                    unregInfo.timestamp = registerEntity.timestamp;
                    arrayList.add(unregInfo);
                }
            }
        }
        return arrayList;
    }

    public static RegisterEntity getRegisterInfoByPkgName(String str) {
        return findValidRegisterEntityByPkg(str);
    }

    public static void UnregisterInfoByPkgName(String str) {
        m29926a(str, 1);
    }

    public static void UnregisterInfoSuccessByPkgName(String str) {
        m29926a(str, 3);
    }

    /* renamed from: a */
    private static void m29926a(String str, byte b) {
        if (!C7056i.m30194b(str)) {
            for (Entry value : getRegisterEntityMap().entrySet()) {
                RegisterEntity registerEntity = (RegisterEntity) value.getValue();
                if (registerEntity != null && !C7056i.m30194b(registerEntity.packageName) && str.equals(registerEntity.packageName)) {
                    registerEntity.state = b;
                }
            }
        }
    }

    public static void UninstallInfoByPkgName(String str) {
        m29926a(str, 2);
    }

    public static void UninstallInfoSuccessByPkgName(String str) {
        m29926a(str, 4);
    }

    public static void removeRegisterInfoByPkgName(String str) {
        m29925a(str);
    }

    public static void updateUnregUninList(Context context, ArrayList<UnregInfo> arrayList) {
        if (context != null && arrayList != null && arrayList.size() > 0) {
            List unregisterInfo = getUnregisterInfo(context);
            List<RegisterEntity> uninstallInfo = getUninstallInfo(context);
            if (unregisterInfo != null) {
                for (int i = 0; i < arrayList.size(); i++) {
                    UnregInfo unregInfo = (UnregInfo) arrayList.get(i);
                    String str = ".reg";
                    if (unregInfo.isUninstall == 1) {
                        for (int i2 = 0; i2 < unregisterInfo.size(); i2++) {
                            RegisterEntity registerEntity = (RegisterEntity) unregisterInfo.get(i2);
                            if (registerEntity.accessId == unregInfo.appInfo.accessId) {
                                m29927a(registerEntity.packageName, m29924a(registerEntity.packageName, str), 3);
                            }
                        }
                    }
                    if (unregInfo.isUninstall == 2) {
                        for (RegisterEntity registerEntity2 : uninstallInfo) {
                            if (registerEntity2.accessId == unregInfo.appInfo.accessId) {
                                m29927a(registerEntity2.packageName, m29924a(registerEntity2.packageName, str), 4);
                            }
                        }
                    }
                }
            }
        }
    }

    public static String getToken(Context context) {
        String b = C7074c.m30320b(context);
        return MidService.isMidValid(b) ? b : MidService.getLocalMidOnly(context);
    }

    public static long getGuid(Context context) {
        return C7074c.m30315a(context);
    }

    public static boolean setToken(Context context, String str) {
        if (context == null || C7056i.m30194b(str) || str.equals(getToken(context))) {
            return false;
        }
        C7074c.m30317a(context, str);
        return true;
    }

    public static boolean setTokenAndGuid(Context context, String str, long j) {
        if (context != null) {
            try {
                if (!C7056i.m30194b(str)) {
                    long guid = getGuid(context);
                    String token = getToken(context);
                    if (j != guid || !str.equals(token)) {
                        if (j < 0) {
                            j = guid;
                        }
                        if (C7056i.m30194b(str) || !C7074c.m30319a(str)) {
                            str = token;
                        }
                        C7074c.m30316a(context, j, str);
                        return true;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static String getQua(Context context, long j) {
        String str = "";
        if (context == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(".com.tencent.tpush.cache.qua.");
        sb.append(j);
        return Rijndael.decrypt(C6908h.m29483a(context, sb.toString(), str));
    }

    public static void setQua(Context context, long j, String str) {
        if (context != null && !C7056i.m30194b(str) && j > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(".com.tencent.tpush.cache.qua.");
            sb.append(j);
            C6908h.m29487b(context, sb.toString(), str);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003d, code lost:
            return;
     */
    public static synchronized void addOptStrategyList(android.content.Context r3, java.lang.String r4, com.tencent.android.tpush.horse.data.OptStrategyList r5) {
        /*
        java.lang.Class<com.tencent.android.tpush.service.cache.CacheManager> r0 = com.tencent.android.tpush.service.cache.CacheManager.class
        monitor-enter(r0)
        if (r3 == 0) goto L_0x003c
        if (r4 != 0) goto L_0x0008
        goto L_0x003c
    L_0x0008:
        addOptKey(r3, r4)     // Catch:{ all -> 0x0039 }
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0039 }
        r1.<init>()     // Catch:{ all -> 0x0039 }
        r1.append(r4)     // Catch:{ all -> 0x0039 }
        java.lang.String r4 = ".com.tencent.tpush.cache.redirect"
        r1.append(r4)     // Catch:{ all -> 0x0039 }
        java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x0039 }
        long r1 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x002f }
        r5.setTimestamp(r1)     // Catch:{ Exception -> 0x002f }
        java.lang.String r5 = com.tencent.android.tpush.common.C6905e.m29468a(r5)     // Catch:{ Exception -> 0x002f }
        java.lang.String r5 = com.tencent.android.tpush.encrypt.Rijndael.encrypt(r5)     // Catch:{ Exception -> 0x002f }
        com.tencent.android.tpush.common.C6908h.m29487b(r3, r4, r5)     // Catch:{ Exception -> 0x002f }
        goto L_0x0037
    L_0x002f:
        r3 = move-exception
        java.lang.String r4 = "XGService"
        java.lang.String r5 = ""
        com.tencent.android.tpush.p580b.C6864a.m29302d(r4, r5, r3)     // Catch:{ all -> 0x0039 }
    L_0x0037:
        monitor-exit(r0)
        return
    L_0x0039:
        r3 = move-exception
        monitor-exit(r0)
        throw r3
    L_0x003c:
        monitor-exit(r0)
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.service.cache.CacheManager.addOptStrategyList(android.content.Context, java.lang.String, com.tencent.android.tpush.horse.data.OptStrategyList):void");
    }

    public static synchronized void removeOptStrategyList(Context context, String str) {
        synchronized (CacheManager.class) {
            addOptStrategyList(context, str, new OptStrategyList());
        }
    }

    public static OptStrategyList getOptStrategyList(Context context, String str) {
        if (context == null || str == null) {
            StringBuffer stringBuffer = new StringBuffer("getStrategy return null,contex is null(");
            stringBuffer.append(context == null);
            stringBuffer.append(") and key=");
            stringBuffer.append(str);
            throw new NullReturnException(stringBuffer.toString());
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(".com.tencent.tpush.cache.redirect");
            Object a = C6905e.m29467a(Rijndael.decrypt(C6908h.m29483a(context, sb.toString(), "")));
            if (a instanceof OptStrategyList) {
                return (OptStrategyList) a;
            }
            throw new NullReturnException("getStrategy return null, because serializer object is not instanceof OptStrategyList");
        } catch (Exception e) {
            throw new NullReturnException("getOptStrategyList return null,deserialize err", e);
        }
    }

    public static synchronized void addOptStrategy(StrategyItem strategyItem) {
        OptStrategyList optStrategyList;
        synchronized (CacheManager.class) {
            String l = C7056i.m30218l(C6973b.m29776f());
            try {
                optStrategyList = getOptStrategyList(C6973b.m29776f(), l);
            } catch (Exception e) {
                C6864a.m29302d(Constants.ServiceLogTag, ">> Can not get OptStrategyList from local", e);
                optStrategyList = new OptStrategyList();
            }
            if (strategyItem.getProtocolType() == 1) {
                if (strategyItem.getRedirect() == 0) {
                    optStrategyList.setHttpItem(strategyItem);
                } else {
                    optStrategyList.setHttpRedirectItem(strategyItem);
                }
            } else if (strategyItem.getRedirect() == 0) {
                optStrategyList.setTcpItem(strategyItem);
            } else {
                optStrategyList.setTcpRedirectItem(strategyItem);
            }
            addOptStrategyList(C6973b.m29776f(), l, optStrategyList);
        }
    }

    public static void addServerItems(Context context, String str, ArrayList<ServerItem> arrayList) {
        if (context != null && str != null) {
            saveDomainKey(context, str);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(".com.tencent.tpush.cache.server");
            try {
                C6908h.m29487b(context, sb.toString(), Rijndael.encrypt(C6905e.m29468a((Serializable) arrayList)));
            } catch (Exception e) {
                C6864a.m29302d(Constants.ServiceLogTag, "", e);
            }
        }
    }

    public static ArrayList<ServerItem> getServerItems(Context context, String str) {
        if (str != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(".com.tencent.tpush.cache.server");
            try {
                Object a = C6905e.m29467a(Rijndael.decrypt(C6908h.m29483a(context, sb.toString(), "")));
                if (a != null && (a instanceof ArrayList)) {
                    return (ArrayList) a;
                }
                throw new NullReturnException("getServerItems return null,because object not instance of Arraylist<?>");
            } catch (Exception e) {
                throw new NullReturnException("getServerItem return null,deseriallize err", e);
            }
        } else {
            throw new NullReturnException("getServerItems return null,because key is null");
        }
    }

    public static void addOptKeyList(Context context, HashSet<String> hashSet) {
        if (context != null) {
            try {
                C6908h.m29487b(context, ".com.tencent.tpush.cache.keylist", Rijndael.encrypt(C6905e.m29468a((Serializable) hashSet)));
            } catch (Exception e) {
                C6864a.m29302d(Constants.ServiceLogTag, "", e);
            }
        }
    }

    public static void addOptKey(Context context, String str) {
        HashSet hashSet;
        try {
            hashSet = getOptKeyList(context);
        } catch (Exception unused) {
            hashSet = new HashSet();
        }
        hashSet.add(str);
        addOptKeyList(context, hashSet);
    }

    public static HashSet<String> getOptKeyList(Context context) {
        if (context != null) {
            try {
                Object a = C6905e.m29467a(Rijndael.decrypt(C6908h.m29483a(context, ".com.tencent.tpush.cache.keylist", "")));
                if (a instanceof HashSet) {
                    return (HashSet) a;
                }
                throw new NullReturnException("getOptKeyList return null,because object not instance of ArrayList<?>");
            } catch (Exception e) {
                throw new NullReturnException("getOptKeyList return null，deseriallize err", e);
            }
        } else {
            throw new NullReturnException("getOptKeyList return null,because ctx is null");
        }
    }

    public static void clearOptKeyList(Context context) {
        if (context != null) {
            C6908h.m29487b(context, ".com.tencent.tpush.cache.keylist", "");
        }
    }

    public static void saveLoadIpTime(Context context, long j) {
        if (context != null && j > 0) {
            C6908h.m29486b(context, ".com.tencent.tpush.cache.load.ip.last.time", j);
        }
    }

    public static long getLastLoadIpTime(Context context) {
        if (context != null) {
            return C6908h.m29481a(context, ".com.tencent.tpush.cache.load.ip.last.time", 0);
        }
        return 0;
    }

    public static void saveSpeedTestList(Context context, ArrayList<ServerItem> arrayList) {
        if (context != null) {
            try {
                C6908h.m29487b(context, ".com.tencent.tpush.cache.speed.test", Rijndael.encrypt(C6905e.m29468a((Serializable) arrayList)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static ArrayList<ServerItem> getSpeedTestList(Context context) {
        if (context != null) {
            try {
                Object a = C6905e.m29467a(Rijndael.decrypt(C6908h.m29483a(context, ".com.tencent.tpush.cache.speed.test", "")));
                if (a instanceof ArrayList) {
                    return (ArrayList) a;
                }
                throw new NullReturnException("getSpeedTestList return null ,because instanceof err");
            } catch (Exception e) {
                throw new NullReturnException("getSpeedTestList return null ,because deserialize err", e);
            }
        } else {
            throw new NullReturnException("getSpeedTestList return null ,because ctx is null");
        }
    }

    public static void saveDomain(Context context, String str) {
        if (context != null && str != null) {
            C6908h.m29487b(context, ".com.tencent.tpush.cache.domain", str);
        }
    }

    public static String getDomain(Context context) {
        String str = "";
        if (context != null) {
            C6908h.m29483a(context, ".com.tencent.tpush.cache.domain", str);
        }
        return str;
    }

    public static void saveDomainKeyList(Context context, ArrayList<String> arrayList) {
        String str;
        String str2 = "";
        if (context != null) {
            if (arrayList != null) {
                try {
                    str = C6905e.m29468a((Serializable) arrayList);
                } catch (Exception e) {
                    C6864a.m29302d(Constants.ServiceLogTag, str2, e);
                    return;
                }
            } else {
                str = str2;
            }
            C6908h.m29487b(context, ".com.tencent.tpush.cache.domain.key", Rijndael.encrypt(str));
        }
    }

    public static void saveDomainKey(Context context, String str) {
        ArrayList arrayList;
        if (context != null) {
            try {
                arrayList = getDomainKeyList(context);
            } catch (Exception unused) {
                arrayList = new ArrayList();
            }
            arrayList.add(str);
            saveDomainKeyList(context, arrayList);
        }
    }

    public static ArrayList<String> getDomainKeyList(Context context) {
        if (context != null) {
            try {
                Object a = C6905e.m29467a(Rijndael.decrypt(C6908h.m29483a(context, ".com.tencent.tpush.cache.domain.key", "")));
                if (a instanceof ArrayList) {
                    return (ArrayList) a;
                }
                throw new NullReturnException("getDomainKeyList return null,because object not instance of ArrayList<?>");
            } catch (Exception e) {
                throw new NullReturnException("getDomainKeyList return null，deseriallize err", e);
            }
        } else {
            throw new NullReturnException("getDomainKeyList return null,because ctx is null");
        }
    }

    public static void clearDomainServerItem(Context context) {
        ArrayList arrayList;
        String str = "";
        try {
            arrayList = getDomainKeyList(context);
        } catch (NullReturnException unused) {
            arrayList = new ArrayList();
        }
        arrayList.add(String.valueOf(MobileType.CHINAMOBILE.getType()));
        arrayList.add(String.valueOf(MobileType.TELCOM.getType()));
        arrayList.add(String.valueOf(MobileType.UNICOM.getType()));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(".com.tencent.tpush.cache.server");
            try {
                C6908h.m29487b(context, sb.toString(), str);
            } catch (Exception e) {
                C6864a.m29302d(Constants.ServiceLogTag, str, e);
            }
        }
    }

    /* renamed from: a */
    private static String m29924a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(".com.tencent.tpush.cache");
        sb.append(str2);
        return sb.toString();
    }
}
