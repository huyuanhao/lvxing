package com.p522qq.p523e.comm.managers;

import android.content.Context;
import android.os.Build.VERSION;
import com.p522qq.p523e.comm.constants.CustomPkgConstants;
import com.p522qq.p523e.comm.managers.plugin.C6413PM;
import com.p522qq.p523e.comm.managers.plugin.C6413PM.C6416a.C6417a;
import com.p522qq.p523e.comm.managers.setting.C6424SM;
import com.p522qq.p523e.comm.managers.status.APPStatus;
import com.p522qq.p523e.comm.managers.status.DeviceStatus;
import com.p522qq.p523e.comm.net.C6432a;
import com.p522qq.p523e.comm.services.C6437a;
import com.p522qq.p523e.comm.util.GDTLogger;
import com.p522qq.p523e.comm.util.StringUtil;
import com.p522qq.p523e.comm.util.SystemUtil;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.qq.e.comm.managers.GDTADManager */
public class GDTADManager {
    public static final ExecutorService INIT_EXECUTOR = Executors.newSingleThreadExecutor();
    /* renamed from: a */
    private volatile Boolean f20181a;
    /* renamed from: b */
    private volatile Context f20182b;
    /* renamed from: c */
    private volatile C6424SM f20183c;
    /* renamed from: d */
    private volatile C6413PM f20184d;
    /* renamed from: e */
    private volatile APPStatus f20185e;
    /* renamed from: f */
    private volatile DeviceStatus f20186f;
    /* renamed from: g */
    private volatile String f20187g;
    /* renamed from: h */
    private C6417a f20188h;

    /* renamed from: com.qq.e.comm.managers.GDTADManager$a */
    static final class C6412a {
        /* access modifiers changed from: private|static */
        /* renamed from: a */
        public static GDTADManager f20189a = new GDTADManager(0);
    }

    private GDTADManager() {
        this.f20181a = Boolean.FALSE;
    }

    /* synthetic */ GDTADManager(byte b) {
        this();
    }

    public static GDTADManager getInstance() {
        return C6412a.f20189a;
    }

    public JSONObject buildS2SSBaseInfo() throws JSONException {
        if (!isInitialized()) {
            return null;
        }
        JSONObject a = C6432a.m25242a(this.f20183c);
        a.put("app", C6432a.m25243a(this.f20185e));
        a.put("c", C6432a.m25244a(this.f20186f));
        a.put("sdk", C6432a.m25241a(this.f20184d));
        return a;
    }

    public String getADActivityClazz() {
        return CustomPkgConstants.getADActivityName();
    }

    public Context getAppContext() {
        return this.f20182b;
    }

    public APPStatus getAppStatus() {
        return this.f20185e;
    }

    public DeviceStatus getDeviceStatus() {
        return this.f20186f;
    }

    public String getDownLoadClazz() {
        return CustomPkgConstants.getDownLoadServiceName();
    }

    public String getLandscapeADActivityClazz() {
        return CustomPkgConstants.getLandscapeADActivityName();
    }

    public C6413PM getPM() {
        return this.f20184d;
    }

    public String getPortraitADActivityClazz() {
        return CustomPkgConstants.getPortraitADActivityName();
    }

    public String getProcessName() {
        return this.f20187g;
    }

    public String getRewardvideoLandscapeADActivityClazz() {
        return CustomPkgConstants.getRewardvideoLandscapeADActivityName();
    }

    public String getRewardvideoPortraitADActivityClazz() {
        return CustomPkgConstants.getRewardvideoPortraitADActivityName();
    }

    public C6424SM getSM() {
        return this.f20183c;
    }

    public synchronized boolean initWith(Context context, String str) {
        if (VERSION.SDK_INT < 14) {
            GDTLogger.m25260e("system version not support !");
            return false;
        } else if (this.f20181a.booleanValue()) {
            return true;
        } else {
            if (context != null) {
                if (!StringUtil.isEmpty(str)) {
                    try {
                        long nanoTime = System.nanoTime();
                        this.f20187g = SystemUtil.getProcessName(context);
                        this.f20182b = context.getApplicationContext();
                        this.f20183c = new C6424SM(this.f20182b);
                        this.f20184d = new C6413PM(this.f20182b, this.f20188h);
                        this.f20185e = new APPStatus(str, this.f20182b);
                        this.f20186f = new DeviceStatus(this.f20182b);
                        if (VERSION.SDK_INT > 7) {
                            C6437a.m25254a().mo30389a(this.f20182b, this.f20183c, this.f20184d, this.f20186f, this.f20185e, nanoTime);
                        }
                        this.f20181a = Boolean.TRUE;
                        return true;
                    } catch (Throwable th) {
                        GDTLogger.report("ADManager init error", th);
                        return false;
                    }
                }
            }
            GDTLogger.m25260e("Context And APPID should Never Be NULL while init GDTADManager");
            return false;
        }
    }

    public boolean isInitialized() {
        if (this.f20181a == null) {
            return false;
        }
        return this.f20181a.booleanValue();
    }

    public void setPluginLoadListener(C6417a aVar) {
        this.f20188h = aVar;
    }
}
