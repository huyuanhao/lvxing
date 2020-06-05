package com.tencent.p605ep.commonbase.api;

/* renamed from: com.tencent.ep.commonbase.api.ConfigManager */
public final class ConfigManager {
    /* renamed from: j */
    private static final String f24693j = "oms";
    /* renamed from: k */
    private static final String f24694k = "sub_platform";
    /* renamed from: l */
    private static final String f24695l = "channel";
    /* renamed from: m */
    private static final String f24696m = "lc";
    /* renamed from: n */
    private static final String f24697n = "version";
    /* renamed from: o */
    private static final String f24698o = "build";
    /* renamed from: p */
    private static final String f24699p = "debug";
    /* renamed from: q */
    private static final String f24700q = "rule_store_time";
    /* renamed from: r */
    private static final String f24701r = "fake_version";
    /* renamed from: s */
    private static final String f24702s = "tool_wandoujia";
    /* renamed from: t */
    private static final String f24703t = "pkgkey";
    /* renamed from: u */
    private static ConfigManager f24704u;
    /* renamed from: a */
    private String f24705a;
    /* renamed from: b */
    private String f24706b;
    /* renamed from: c */
    private String f24707c;
    /* renamed from: d */
    private String f24708d;
    /* renamed from: e */
    private String f24709e;
    /* renamed from: f */
    private String f24710f;
    /* renamed from: g */
    private String f24711g;
    /* renamed from: h */
    private String f24712h = "false";
    /* renamed from: i */
    private String f24713i;

    /* renamed from: com.tencent.ep.commonbase.api.ConfigManager$OEM */
    public static final class OEM {
        public static final String APP_CHINA = "app_china";
        public static final String CHINATELECOM = "chinaTelecom";
        public static final String DEFAULT = "default";
        public static final String DUALSIMMTK = "dualsimmtk";
        public static final String HTC = "htc";
        public static final String HUAWEI = "huawei";
        public static final String JINLI = "jinli";
        public static final String JINSHAN = "jinshan";
        public static final String KONKA = "konka";
        public static final String LEPHONE = "lephone";
        public static final String MARKET = "market";
        public static final String MEIZU = "MeiZu";
        public static final String MOTO = "moto";
        public static final String PHILIPS = "philips";
        public static final String SAMSUNG = "samsung";
        public static final String TIANYU = "tianyu";
        public static final String ZTE = "ZTE";
    }

    /* renamed from: com.tencent.ep.commonbase.api.ConfigManager$PLATFORM_OEM */
    public static final class PLATFORM_OEM {
        public static final int PAD_DEFAULT = "202default".hashCode();
        public static final int PHONE_APP_CHINA = "201app_china".hashCode();
        public static final int PHONE_CHINATELECOM = "201chinaTelecom".hashCode();
        public static final int PHONE_DEFAULT = "201default".hashCode();
        public static final int PHONE_DUALSIMMTK = "201dualsimmtk".hashCode();
        public static final int PHONE_HTC = "201htc".hashCode();
        public static final int PHONE_HUAWEI = "201huawei".hashCode();
        public static final int PHONE_JINLI = "201jinli".hashCode();
        public static final int PHONE_JINSHAN = "201jinshan".hashCode();
        public static final int PHONE_KONKA = "201konka".hashCode();
        public static final int PHONE_LEPHONE = "201lephone".hashCode();
        public static final int PHONE_MARKET = "201market".hashCode();
        public static final int PHONE_MEIZU = "201MeiZu".hashCode();
        public static final int PHONE_MOTO = "201moto".hashCode();
        public static final int PHONE_PHILIPS = "201philips".hashCode();
        public static final int PHONE_SAMSUNG = "201samsung".hashCode();
        public static final int PHONE_TIANYU = "201tianyu".hashCode();
        public static final int PHONE_ZTE = "201ZTE".hashCode();
    }

    /* renamed from: com.tencent.ep.commonbase.api.ConfigManager$SUB_PLATFORM */
    public static final class SUB_PLATFORM {
        public static final String PAD = "202";
        public static final String PHONE = "201";
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x010a A[SYNTHETIC, Splitter:B:28:0x010a] */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    private ConfigManager(android.content.Context r14) {
        /*
        r13 = this;
        java.lang.String r0 = "fake_version"
        java.lang.String r1 = "error"
        java.lang.String r2 = "0.0.0"
        java.lang.String r3 = "pkgkey"
        r13.<init>()
        java.lang.String r4 = "0.0"
        r13.f24705a = r4
        r13.f24706b = r4
        java.lang.String r4 = "0"
        r13.f24707c = r4
        java.lang.String r5 = "null"
        r13.f24708d = r5
        r13.f24709e = r5
        java.lang.String r6 = "default"
        r13.f24710f = r6
        java.lang.String r7 = "201"
        r13.f24711g = r7
        java.lang.String r8 = "false"
        r13.f24712h = r8
        r13.f24713i = r5
        android.content.res.AssetManager r14 = r14.getAssets()
        r8 = 0
        java.lang.String r9 = "config.properties"
        java.io.InputStream r14 = r14.open(r9)     // Catch:{ IOException -> 0x00d8 }
        r9 = 1024(0x400, float:1.435E-42)
        byte[] r9 = new byte[r9]     // Catch:{ IOException -> 0x00d2, all -> 0x00d0 }
        java.io.ByteArrayOutputStream r10 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x00d2, all -> 0x00d0 }
        r10.<init>()     // Catch:{ IOException -> 0x00d2, all -> 0x00d0 }
    L_0x003d:
        int r11 = r14.read(r9)     // Catch:{ IOException -> 0x00d2, all -> 0x00d0 }
        if (r11 <= 0) goto L_0x0048
        r12 = 0
        r10.write(r9, r12, r11)     // Catch:{ IOException -> 0x00d2, all -> 0x00d0 }
        goto L_0x003d
    L_0x0048:
        byte[] r9 = r10.toByteArray()     // Catch:{ IOException -> 0x00d2, all -> 0x00d0 }
        byte[] r8 = com.tencent.p605ep.commonbase.utils.XxteaCryptor.decryptV2(r9, r8)     // Catch:{ IOException -> 0x00d2, all -> 0x00d0 }
        r10.close()     // Catch:{ IOException -> 0x00d2, all -> 0x00d0 }
        java.util.Properties r9 = new java.util.Properties     // Catch:{ IOException -> 0x00d2, all -> 0x00d0 }
        r9.<init>()     // Catch:{ IOException -> 0x00d2, all -> 0x00d0 }
        java.io.ByteArrayInputStream r10 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x00d2, all -> 0x00d0 }
        r10.<init>(r8)     // Catch:{ IOException -> 0x00d2, all -> 0x00d0 }
        r9.load(r10)     // Catch:{ IOException -> 0x00d2, all -> 0x00d0 }
        java.lang.String r8 = "version"
        java.lang.String r8 = r9.getProperty(r8)     // Catch:{ IOException -> 0x00d2, all -> 0x00d0 }
        r13.f24705a = r8     // Catch:{ IOException -> 0x00d2, all -> 0x00d0 }
        java.lang.String r8 = "build"
        java.lang.String r8 = r9.getProperty(r8)     // Catch:{ IOException -> 0x00d2, all -> 0x00d0 }
        r13.f24707c = r8     // Catch:{ IOException -> 0x00d2, all -> 0x00d0 }
        java.lang.String r8 = "lc"
        java.lang.String r8 = r9.getProperty(r8)     // Catch:{ IOException -> 0x00d2, all -> 0x00d0 }
        r13.f24708d = r8     // Catch:{ IOException -> 0x00d2, all -> 0x00d0 }
        java.lang.String r8 = "channel"
        java.lang.String r8 = r9.getProperty(r8)     // Catch:{ IOException -> 0x00d2, all -> 0x00d0 }
        r13.f24709e = r8     // Catch:{ IOException -> 0x00d2, all -> 0x00d0 }
        java.lang.String r8 = "oms"
        java.lang.String r8 = r9.getProperty(r8)     // Catch:{ IOException -> 0x00d2, all -> 0x00d0 }
        r13.f24710f = r8     // Catch:{ IOException -> 0x00d2, all -> 0x00d0 }
        java.lang.String r8 = "sub_platform"
        java.lang.String r8 = r9.getProperty(r8)     // Catch:{ IOException -> 0x00d2, all -> 0x00d0 }
        r13.f24711g = r8     // Catch:{ IOException -> 0x00d2, all -> 0x00d0 }
        java.lang.String r8 = r9.getProperty(r0)     // Catch:{ IOException -> 0x00d2, all -> 0x00d0 }
        if (r8 == 0) goto L_0x00a9
        java.lang.String r8 = new java.lang.String     // Catch:{ IOException -> 0x00d2, all -> 0x00d0 }
        java.lang.String r0 = r9.getProperty(r0)     // Catch:{ IOException -> 0x00d2, all -> 0x00d0 }
        java.lang.String r10 = "ISO-8859-1"
        byte[] r0 = r0.getBytes(r10)     // Catch:{ IOException -> 0x00d2, all -> 0x00d0 }
        java.lang.String r10 = "UTF8"
        r8.<init>(r0, r10)     // Catch:{ IOException -> 0x00d2, all -> 0x00d0 }
        r13.f24706b = r8     // Catch:{ IOException -> 0x00d2, all -> 0x00d0 }
    L_0x00a9:
        java.lang.String r0 = "debug"
        java.lang.String r0 = r9.getProperty(r0)     // Catch:{ IOException -> 0x00d2, all -> 0x00d0 }
        r13.f24712h = r0     // Catch:{ IOException -> 0x00d2, all -> 0x00d0 }
        java.lang.String r0 = r9.getProperty(r3)     // Catch:{ IOException -> 0x00d2, all -> 0x00d0 }
        r13.f24713i = r0     // Catch:{ IOException -> 0x00d2, all -> 0x00d0 }
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00d2, all -> 0x00d0 }
        r0.<init>()     // Catch:{ IOException -> 0x00d2, all -> 0x00d0 }
        java.lang.String r8 = "mPkgKey: "
        r0.append(r8)     // Catch:{ IOException -> 0x00d2, all -> 0x00d0 }
        java.lang.String r8 = r13.f24713i     // Catch:{ IOException -> 0x00d2, all -> 0x00d0 }
        r0.append(r8)     // Catch:{ IOException -> 0x00d2, all -> 0x00d0 }
        java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x00d2, all -> 0x00d0 }
        com.tencent.p605ep.commonbase.api.Log.m31483i(r3, r0)     // Catch:{ IOException -> 0x00d2, all -> 0x00d0 }
        if (r14 == 0) goto L_0x0107
        goto L_0x0104
    L_0x00d0:
        r0 = move-exception
        goto L_0x0108
    L_0x00d2:
        r0 = move-exception
        r8 = r14
        goto L_0x00d9
    L_0x00d5:
        r0 = move-exception
        r14 = r8
        goto L_0x0108
    L_0x00d8:
        r0 = move-exception
    L_0x00d9:
        java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d5 }
        r14.<init>()     // Catch:{ all -> 0x00d5 }
        java.lang.String r9 = "e: "
        r14.append(r9)     // Catch:{ all -> 0x00d5 }
        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00d5 }
        r14.append(r0)     // Catch:{ all -> 0x00d5 }
        java.lang.String r14 = r14.toString()     // Catch:{ all -> 0x00d5 }
        com.tencent.p605ep.commonbase.api.Log.m31479e(r3, r14)     // Catch:{ all -> 0x00d5 }
        r13.f24710f = r6     // Catch:{ all -> 0x00d5 }
        r13.f24711g = r7     // Catch:{ all -> 0x00d5 }
        r13.f24705a = r2     // Catch:{ all -> 0x00d5 }
        r13.f24706b = r2     // Catch:{ all -> 0x00d5 }
        r13.f24707c = r4     // Catch:{ all -> 0x00d5 }
        r13.f24713i = r5     // Catch:{ all -> 0x00d5 }
        r13.f24708d = r1     // Catch:{ all -> 0x00d5 }
        r13.f24709e = r1     // Catch:{ all -> 0x00d5 }
        if (r8 == 0) goto L_0x0107
        r14 = r8
    L_0x0104:
        r14.close()     // Catch:{ IOException -> 0x0107 }
    L_0x0107:
        return
    L_0x0108:
        if (r14 == 0) goto L_0x010d
        r14.close()     // Catch:{ IOException -> 0x010d }
    L_0x010d:
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.p605ep.commonbase.api.ConfigManager.m52716init(android.content.Context):void");
    }

    /* renamed from: a */
    private String m31475a() {
        this.f24711g = SUB_PLATFORM.PHONE;
        return this.f24711g;
    }

    public static synchronized ConfigManager getConfigManager() {
        ConfigManager configManager;
        synchronized (ConfigManager.class) {
            if (f24704u == null) {
                f24704u = new ConfigManager(AppContext.getAppContext());
            }
            configManager = f24704u;
        }
        return configManager;
    }

    public String getBuild() {
        return this.f24707c;
    }

    public String getChannel() {
        return this.f24709e;
    }

    public String getLc() {
        return this.f24708d;
    }

    public String getOEM() {
        return this.f24710f;
    }

    public int getOEMHashCode() {
        return getOEM().hashCode();
    }

    public String getPkgKey() {
        return this.f24713i;
    }

    public String getPlatform() {
        return this.f24710f;
    }

    public int getPlatformAndOEM() {
        StringBuilder sb = new StringBuilder();
        sb.append(m31475a());
        sb.append(getOEM());
        return sb.toString().hashCode();
    }

    public String getSoftFakeVersion() {
        return this.f24706b;
    }

    public String getSoftVersion() {
        return this.f24705a;
    }

    public int getSubPlatformHashCode() {
        return m31475a().hashCode();
    }

    public boolean isDebug() {
        String str = this.f24712h;
        Boolean bool = (str == null || str.equals("1")) ? Boolean.TRUE : Boolean.FALSE;
        return bool.booleanValue();
    }
}
