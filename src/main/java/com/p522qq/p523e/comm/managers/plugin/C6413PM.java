package com.p522qq.p523e.comm.managers.plugin;

import android.content.Context;
import com.p522qq.p523e.comm.constants.Sig;
import com.p522qq.p523e.comm.p525pi.POFactory;
import com.p522qq.p523e.comm.util.GDTLogger;
import com.p522qq.p523e.comm.util.StringUtil;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.qq.e.comm.managers.plugin.PM */
public class C6413PM {
    /* renamed from: l */
    private static final Map<Class<?>, String> f20190l = new HashMap<Class<?>, String>() {
        {
            put(POFactory.class, "com.qq.e.comm.plugin.POFactoryImpl");
        }
    };
    /* renamed from: a */
    private ExecutorService f20191a = Executors.newSingleThreadExecutor();
    /* renamed from: b */
    private final Context f20192b;
    /* renamed from: c */
    private String f20193c;
    /* renamed from: d */
    private File f20194d;
    /* renamed from: e */
    private int f20195e;
    /* renamed from: f */
    private DexClassLoader f20196f;
    /* renamed from: g */
    private RandomAccessFile f20197g;
    /* renamed from: h */
    private FileLock f20198h;
    /* renamed from: i */
    private boolean f20199i;
    /* renamed from: j */
    private C6417a f20200j;
    /* renamed from: k */
    private C6418b f20201k = new C6418b() {
        /* renamed from: a */
        public final void mo30126a() {
            C6413PM.m25184a(C6413PM.this);
        }

        /* renamed from: b */
        public final void mo30127b() {
            C6413PM.this.m25190f();
        }
    };

    /* renamed from: com.qq.e.comm.managers.plugin.PM$a */
    public interface C6416a {

        /* renamed from: com.qq.e.comm.managers.plugin.PM$a$a */
        public interface C6417a {
            void onLoadFail();

            void onLoadSuccess();
        }

        /* renamed from: com.qq.e.comm.managers.plugin.PM$a$b */
        public interface C6418b {
            /* renamed from: a */
            void mo30126a();

            /* renamed from: b */
            void mo30127b();
        }
    }

    public C6413PM(Context context, C6417a aVar) {
        this.f20192b = context.getApplicationContext();
        this.f20200j = aVar;
        this.f20199i = m25188d();
        if (m25186b()) {
            m25183a();
        }
    }

    /* renamed from: a */
    private void m25183a() {
        StringBuilder sb = new StringBuilder("PluginFile:\t");
        File file = this.f20194d;
        sb.append(file == null ? "null" : file.getAbsolutePath());
        GDTLogger.m25258d(sb.toString());
        if (this.f20193c != null) {
            File file2 = this.f20194d;
            if (file2 != null) {
                try {
                    this.f20196f = new DexClassLoader(file2.getAbsolutePath(), C6423d.m25207a(this.f20192b).getAbsolutePath(), null, getClass().getClassLoader());
                    m25189e();
                    return;
                } catch (Throwable th) {
                    GDTLogger.m25261e("exception while init plugin class loader", th);
                    m25190f();
                    return;
                }
            }
        }
        this.f20196f = null;
    }

    /* renamed from: a */
    static /* synthetic */ void m25184a(C6413PM pm) {
        try {
            if (pm.f20196f == null && pm.m25187c()) {
                pm.m25183a();
            }
        } catch (Exception e) {
            GDTLogger.report("Exception while init online plugin: ", e);
            pm.m25190f();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0051, code lost:
            if (r2 == false) goto L_0x0054;
     */
    /* renamed from: b */
    private boolean m25186b() {
        /*
        r6 = this;
        java.lang.String r0 = "TimeStap_AFTER_PLUGIN_INIT:"
        r1 = 0
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0068 }
        java.lang.String r3 = "TimeStap_BEFORE_PLUGIN_INIT:"
        r2.<init>(r3)     // Catch:{ all -> 0x0068 }
        long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0068 }
        r2.append(r3)     // Catch:{ all -> 0x0068 }
        java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0068 }
        com.p522qq.p523e.comm.util.GDTLogger.m25258d(r2)     // Catch:{ all -> 0x0068 }
        boolean r2 = r6.m25187c()     // Catch:{ all -> 0x0068 }
        r3 = 1
        if (r2 != 0) goto L_0x0053
        boolean r2 = r6.f20199i     // Catch:{ all -> 0x0068 }
        if (r2 != 0) goto L_0x0025
    L_0x0023:
        r2 = 0
        goto L_0x0051
    L_0x0025:
        android.content.Context r2 = r6.f20192b     // Catch:{ all -> 0x0068 }
        android.content.Context r4 = r6.f20192b     // Catch:{ all -> 0x0068 }
        java.io.File r4 = com.p522qq.p523e.comm.managers.plugin.C6423d.m25208b(r4)     // Catch:{ all -> 0x0068 }
        android.content.Context r5 = r6.f20192b     // Catch:{ all -> 0x0068 }
        java.io.File r5 = com.p522qq.p523e.comm.managers.plugin.C6423d.m25211e(r5)     // Catch:{ all -> 0x0068 }
        boolean r2 = com.p522qq.p523e.comm.managers.plugin.C6419a.m25195a(r2, r4, r5)     // Catch:{ all -> 0x0068 }
        if (r2 == 0) goto L_0x004b
        java.lang.String r2 = com.p522qq.p523e.comm.constants.Sig.ASSET_PLUGIN_SIG     // Catch:{ all -> 0x0068 }
        r6.f20193c = r2     // Catch:{ all -> 0x0068 }
        android.content.Context r2 = r6.f20192b     // Catch:{ all -> 0x0068 }
        java.io.File r2 = com.p522qq.p523e.comm.managers.plugin.C6423d.m25208b(r2)     // Catch:{ all -> 0x0068 }
        r6.f20194d = r2     // Catch:{ all -> 0x0068 }
        r2 = 1081(0x439, float:1.515E-42)
        r6.f20195e = r2     // Catch:{ all -> 0x0068 }
        r2 = 1
        goto L_0x0051
    L_0x004b:
        java.lang.String r2 = "Fail to prepair Defult plugin "
        com.p522qq.p523e.comm.util.GDTLogger.m25260e(r2)     // Catch:{ all -> 0x0068 }
        goto L_0x0023
    L_0x0051:
        if (r2 == 0) goto L_0x0054
    L_0x0053:
        r1 = 1
    L_0x0054:
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>(r0)
    L_0x0059:
        long r3 = java.lang.System.currentTimeMillis()
        r2.append(r3)
        java.lang.String r0 = r2.toString()
        com.p522qq.p523e.comm.util.GDTLogger.m25258d(r0)
        return r1
    L_0x0068:
        r2 = move-exception
        java.lang.String r3 = "Exception while init plugin manager"
        com.p522qq.p523e.comm.util.GDTLogger.report(r3, r2)     // Catch:{ all -> 0x0074 }
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>(r0)
        goto L_0x0059
    L_0x0074:
        r1 = move-exception
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>(r0)
        long r3 = java.lang.System.currentTimeMillis()
        r2.append(r3)
        java.lang.String r0 = r2.toString()
        com.p522qq.p523e.comm.util.GDTLogger.m25258d(r0)
        throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p522qq.p523e.comm.managers.plugin.C6413PM.m25186b():boolean");
    }

    /* renamed from: c */
    private boolean m25187c() {
        if (this.f20199i) {
            C6419a aVar = new C6419a(C6423d.m25210d(this.f20192b), C6423d.m25213g(this.f20192b));
            if (aVar.mo30128a()) {
                boolean a = aVar.mo30129a(C6423d.m25208b(this.f20192b), C6423d.m25211e(this.f20192b));
                StringBuilder sb = new StringBuilder("NextExist,Updated=");
                sb.append(a);
                GDTLogger.m25258d(sb.toString());
            }
        }
        C6419a aVar2 = new C6419a(C6423d.m25208b(this.f20192b), C6423d.m25211e(this.f20192b));
        if (!aVar2.mo30128a()) {
            return false;
        }
        if (aVar2.mo30130b() < 1081) {
            StringBuilder sb2 = new StringBuilder("last updated plugin version =");
            sb2.append(this.f20195e);
            sb2.append(";asset plugin version=1081");
            GDTLogger.m25258d(sb2.toString());
            return false;
        }
        this.f20193c = aVar2.mo30131c();
        this.f20195e = aVar2.mo30130b();
        this.f20194d = C6423d.m25208b(this.f20192b);
        return true;
    }

    /* renamed from: d */
    private boolean m25188d() {
        boolean z = false;
        try {
            File h = C6423d.m25214h(this.f20192b);
            if (!h.exists()) {
                h.createNewFile();
                StringUtil.writeTo("lock", h);
            }
            if (!h.exists()) {
                return false;
            }
            this.f20197g = new RandomAccessFile(h, "rw");
            this.f20198h = this.f20197g.getChannel().tryLock();
            if (this.f20198h != null) {
                this.f20197g.writeByte(37);
                z = true;
            }
            return z;
        } catch (Throwable unused) {
        }
    }

    /* renamed from: e */
    private void m25189e() {
        C6417a aVar = this.f20200j;
        if (aVar != null) {
            aVar.onLoadSuccess();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m25190f() {
        C6417a aVar = this.f20200j;
        if (aVar != null) {
            aVar.onLoadFail();
        }
    }

    public <T> T getFactory(Class<T> cls) throws C6422c {
        StringBuilder sb = new StringBuilder("GetFactoryInstaceforInterface:");
        sb.append(cls);
        GDTLogger.m25258d(sb.toString());
        ClassLoader classLoader = Sig.ASSET_PLUGIN_SIG == null ? getClass().getClassLoader() : this.f20196f;
        StringBuilder sb2 = new StringBuilder("PluginClassLoader is parent");
        sb2.append(getClass().getClassLoader() == classLoader);
        GDTLogger.m25258d(sb2.toString());
        if (classLoader != null) {
            try {
                String str = (String) f20190l.get(cls);
                if (!StringUtil.isEmpty(str)) {
                    Class loadClass = classLoader.loadClass(str);
                    T cast = cls.cast(loadClass.getDeclaredMethod("getInstance", new Class[0]).invoke(loadClass, new Object[0]));
                    StringBuilder sb3 = new StringBuilder("ServiceDelegateFactory =");
                    sb3.append(cast);
                    GDTLogger.m25258d(sb3.toString());
                    return cast;
                }
                StringBuilder sb4 = new StringBuilder("factory  implemention name is not specified for interface:");
                sb4.append(cls.getName());
                throw new C6422c(sb4.toString());
            } catch (Throwable th) {
                StringBuilder sb5 = new StringBuilder("Fail to getfactory implement instance for interface:");
                sb5.append(cls.getName());
                throw new C6422c(sb5.toString(), th);
            }
        } else {
            StringBuilder sb6 = new StringBuilder("Fail to init GDTADPLugin,PluginClassLoader == null;while loading factory impl for:");
            sb6.append(cls);
            throw new C6422c(sb6.toString());
        }
    }

    public String getLocalSig() {
        return this.f20193c;
    }

    public POFactory getPOFactory() throws C6422c {
        return (POFactory) getFactory(POFactory.class);
    }

    public int getPluginVersion() {
        return this.f20195e;
    }

    public void update(String str, String str2) {
        if (this.f20199i) {
            C6420b bVar = new C6420b(this.f20192b, this.f20191a);
            bVar.mo30132a(this.f20201k);
            bVar.mo30133a(str, str2);
        }
    }
}
