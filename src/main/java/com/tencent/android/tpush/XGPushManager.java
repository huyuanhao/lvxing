package com.tencent.android.tpush;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.bytedance.embedapplog.GameReportHelper;
import com.tencent.android.tpush.cloudctr.CloudControlManager;
import com.tencent.android.tpush.cloudctr.CloudControlManager.ICloudControlDispatcher;
import com.tencent.android.tpush.cloudctr.CloudControlManager.ICloudControlDispatcher.DownloadStatus;
import com.tencent.android.tpush.cloudctr.CloudControlManager.ICloudControlDispatcher.ErrorResponse;
import com.tencent.android.tpush.cloudctr.p583b.C6889a;
import com.tencent.android.tpush.common.C6896a;
import com.tencent.android.tpush.common.C6901c;
import com.tencent.android.tpush.common.C6907g;
import com.tencent.android.tpush.common.C6908h;
import com.tencent.android.tpush.common.C6909i;
import com.tencent.android.tpush.common.C6913k;
import com.tencent.android.tpush.common.C6914l;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.common.ReturnCode;
import com.tencent.android.tpush.data.MessageId;
import com.tencent.android.tpush.data.RegisterEntity;
import com.tencent.android.tpush.encrypt.C6931a;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.p581c.C6868b;
import com.tencent.android.tpush.p581c.C6871c;
import com.tencent.android.tpush.p581c.C6876f;
import com.tencent.android.tpush.p581c.C6881g;
import com.tencent.android.tpush.p584d.C6924b;
import com.tencent.android.tpush.p584d.C6927d;
import com.tencent.android.tpush.service.C6973b;
import com.tencent.android.tpush.service.C6982c;
import com.tencent.android.tpush.service.C7059f;
import com.tencent.android.tpush.service.XGPushServiceV4;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.android.tpush.service.channel.C7000a;
import com.tencent.android.tpush.service.channel.protocol.TpnsPushMsg;
import com.tencent.android.tpush.service.channel.security.TpnsSecurity;
import com.tencent.android.tpush.service.p594d.C7046a;
import com.tencent.android.tpush.service.p595e.C7051d;
import com.tencent.android.tpush.service.p595e.C7055h;
import com.tencent.android.tpush.service.p595e.C7056i;
import com.tencent.bugly.beta.tinker.TinkerManager;
import com.tencent.mid.sotrage.StorageInterface;
import com.tencent.p605ep.commonbase.software.AppEntity;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
import org.slf4j.Marker;

/* compiled from: ProGuard */
public class XGPushManager {
    public static final String ENABLE_SERVICE_SUFFIX = ".enableService";
    public static final int OPERATION_FAIL = 1;
    public static final int OPERATION_REQ_REGISTER = 100;
    public static final int OPERATION_REQ_UNREGISTER = 101;
    public static final int OPERATION_SUCCESS = 0;
    /* access modifiers changed from: private|static|final */
    /* renamed from: a */
    public static final String f22726a = XGPushManager.class.getSimpleName();
    /* renamed from: b */
    private static boolean f22727b = false;
    /* renamed from: c */
    private static Context f22728c = null;
    /* renamed from: d */
    private static XGPushNotifactionCallback f22729d = null;
    /* renamed from: e */
    private static Long f22730e = Long.valueOf(0);
    public static int enableService = -1;
    /* access modifiers changed from: private|static */
    /* renamed from: f */
    public static Map<C6857b, C6858c> f22731f = new ConcurrentHashMap();
    public static Map<String, Long> lastSuccessRegisterMap = new HashMap();

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.android.tpush.XGPushManager$a */
    private static class C6853a implements Runnable {
        /* access modifiers changed from: private */
        /* renamed from: a */
        public Context f22761a;
        /* renamed from: b */
        private Intent f22762b;
        /* renamed from: c */
        private XGIOperateCallback f22763c;
        /* renamed from: d */
        private int f22764d;
        /* renamed from: e */
        private int f22765e = 0;

        public C6853a(XGIOperateCallback xGIOperateCallback, Context context, Intent intent, int i, int i2) {
            this.f22763c = xGIOperateCallback;
            this.f22761a = context;
            this.f22762b = intent;
            this.f22764d = i;
            this.f22765e = i2;
        }

        public void run() {
            try {
                this.f22762b.removeExtra("storage");
                String str = "operation";
                if (this.f22764d == 1) {
                    final String absolutePath = this.f22761a.getDir(TinkerManager.PATCH_DIR, 0).getAbsolutePath();
                    C6901c.m29459a().mo33104a((Runnable) new Runnable() {
                        public void run() {
                            CloudControlManager.m29396a().mo33062a(C6853a.this.f22761a, "XG", absolutePath, new ICloudControlDispatcher() {
                                /* renamed from: a */
                                public void mo32899a(String str) {
                                    Context a = C6853a.this.f22761a;
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(C6853a.this.f22761a.getPackageName());
                                    sb.append("_ccConfig");
                                    C7055h.m30172b(a, sb.toString(), str);
                                }

                                /* renamed from: a */
                                public void mo32900a(String str, String str2, String str3, DownloadStatus downloadStatus, ErrorResponse errorResponse) {
                                    String str4 = "test";
                                    String str5 = " to ";
                                    if (downloadStatus == DownloadStatus.Success) {
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("Download file Success");
                                        sb.append(str);
                                        sb.append(str5);
                                        sb.append(str2);
                                        Log.i(str4, sb.toString());
                                        Context a = C6853a.this.f22761a;
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append(C6853a.this.f22761a.getPackageName());
                                        sb2.append("_dexPath");
                                        C7055h.m30172b(a, sb2.toString(), new File(str2, str).getAbsolutePath());
                                        return;
                                    }
                                    StringBuilder sb3 = new StringBuilder();
                                    String str6 = "Download file error";
                                    sb3.append(str6);
                                    sb3.append(str);
                                    sb3.append(str5);
                                    sb3.append(str2);
                                    Log.i(str4, sb3.toString());
                                    String a2 = XGPushManager.f22726a;
                                    StringBuilder sb4 = new StringBuilder();
                                    sb4.append(str6);
                                    sb4.append(str);
                                    sb4.append(str5);
                                    sb4.append(str2);
                                    C6864a.m29298c(a2, sb4.toString());
                                }
                            });
                            CloudControlManager.m29396a().mo33062a(C6853a.this.f22761a, "TryDyLoad", null, new ICloudControlDispatcher() {
                                /* renamed from: a */
                                public void mo32899a(String str) {
                                    C7055h.m30172b(C6853a.this.f22761a, "TryDyLoad_ccConfig", str);
                                }

                                /* renamed from: a */
                                public void mo32900a(String str, String str2, String str3, DownloadStatus downloadStatus, ErrorResponse errorResponse) {
                                    String str4 = "TryDyLoad";
                                    if (downloadStatus == DownloadStatus.Success) {
                                        try {
                                            File file = new File(str2, str);
                                            Class cls = Class.forName("com.tencent.xg.trydyload_api.TryDyLoader");
                                            String str5 = (String) cls.getMethod("getTryDyLoadBundlePath", new Class[0]).invoke(cls.getMethod("getInstance", new Class[]{Context.class}).invoke(null, new Object[]{C6853a.this.f22761a}), new Object[0]);
                                            StringBuilder sb = new StringBuilder();
                                            sb.append(str5);
                                            sb.append("/");
                                            sb.append(str);
                                            C6889a.m29429a(file, new File(sb.toString()));
                                            StringBuilder sb2 = new StringBuilder();
                                            sb2.append("下载文件成功，path");
                                            sb2.append(file);
                                            C6864a.m29298c(str4, sb2.toString());
                                        } catch (Exception e) {
                                            StringBuilder sb3 = new StringBuilder();
                                            sb3.append("拷贝文件失败，path");
                                            sb3.append(e.getMessage());
                                            C6864a.m29298c(str4, sb3.toString());
                                        }
                                    } else {
                                        StringBuilder sb4 = new StringBuilder();
                                        sb4.append("下载文件失败");
                                        sb4.append(new File(str2, str).getAbsolutePath());
                                        C6864a.m29298c(str4, sb4.toString());
                                    }
                                }
                            });
                        }
                    });
                    String stringExtra = this.f22762b.getStringExtra("data");
                    int intExtra = this.f22762b.getIntExtra(str, -1);
                    if (intExtra == 0) {
                        String stringExtra2 = this.f22762b.getStringExtra("otherPushToken");
                        Long valueOf = Long.valueOf(this.f22762b.getLongExtra("otherPushType", -1));
                        valueOf.longValue();
                        if (valueOf.longValue() > 0) {
                            if (!C6914l.m29521c(stringExtra2) && !C6914l.m29521c(stringExtra.toString())) {
                                C7055h.m30172b(this.f22761a, stringExtra2, stringExtra.toString());
                            }
                            stringExtra = stringExtra2;
                        }
                        this.f22763c.onSuccess(stringExtra, this.f22762b.getIntExtra("flag", -1));
                        RegisterEntity registerEntity = new RegisterEntity();
                        if (this.f22765e == 0) {
                            C6908h.m29485b(this.f22761a, ".firstregister", 0);
                            registerEntity.state = 0;
                        } else {
                            registerEntity.state = 1;
                        }
                        registerEntity.accessId = this.f22762b.getLongExtra("accId", 0);
                        registerEntity.packageName = this.f22761a.getPackageName();
                        registerEntity.token = stringExtra;
                        registerEntity.timestamp = System.currentTimeMillis() / 1000;
                        registerEntity.xgSDKVersion = 4.03f;
                        registerEntity.appVersion = C6914l.m29525f(this.f22761a);
                        CacheManager.setCurrentAppRegisterEntity(this.f22761a, registerEntity);
                        if (!C6914l.m29521c(registerEntity.packageName)) {
                            XGPushManager.lastSuccessRegisterMap.put(registerEntity.packageName, Long.valueOf(System.currentTimeMillis() / 1000));
                        }
                        if ((XGPushConfig.isUsedOtherPush(this.f22761a) && C6927d.m29569a(this.f22761a).mo33137g()) || (XGPushConfig.isUsedFcmPush(this.f22761a) && C6913k.m29501a(this.f22761a).mo33121c())) {
                            C6924b.m29561a(this.f22761a);
                        }
                    } else if (intExtra == 1) {
                        this.f22763c.onFail(stringExtra, this.f22762b.getIntExtra("code", -1), this.f22762b.getStringExtra(NotificationCompat.CATEGORY_MESSAGE));
                    }
                } else if (this.f22764d == 0) {
                    int intExtra2 = this.f22762b.getIntExtra(str, -1);
                    if (intExtra2 == 100) {
                        XGPushManager.m29239c(this.f22761a, this.f22762b, this.f22763c);
                    } else if (intExtra2 == 101) {
                        XGPushManager.m29240d(this.f22761a, this.f22762b, this.f22763c);
                    }
                }
                C6896a.m29454a(this.f22761a);
                C7059f.m30231a(this.f22761a).mo34155a();
            } catch (Throwable th) {
                C6864a.m29302d(XGPushManager.f22726a, "OperateRunnable", th);
            }
        }
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.android.tpush.XGPushManager$b */
    static class C6857b extends BroadcastReceiver {
        /* renamed from: a */
        Context f22770a = null;
        /* renamed from: b */
        Intent f22771b = null;
        /* renamed from: c */
        XGIOperateCallback f22772c = null;
        /* renamed from: d */
        int f22773d = 0;

        public C6857b(Context context, Intent intent, XGIOperateCallback xGIOperateCallback) {
            this.f22770a = context;
            this.f22771b = intent;
            this.f22772c = xGIOperateCallback;
            this.f22773d = intent.getIntExtra("opType", 0);
        }

        public void onReceive(Context context, Intent intent) {
            try {
                C6901c.m29459a().mo33107b().removeCallbacks((C6858c) XGPushManager.f22731f.remove(this));
                int i = this.f22773d;
                if (i == 0) {
                    XGPushManager.m29239c(this.f22770a, this.f22771b, this.f22772c);
                } else if (i != 1) {
                    String a = XGPushManager.f22726a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("RegisterStartReceiver error optype:");
                    sb.append(this.f22773d);
                    C6864a.m29308i(a, sb.toString());
                } else {
                    XGPushManager.m29240d(this.f22770a, this.f22771b, this.f22772c);
                }
                C6914l.m29513a(this.f22770a, (BroadcastReceiver) this);
            } catch (Exception e) {
                C6864a.m29302d(XGPushManager.f22726a, "RegisterStartReceiver error", e);
            }
        }
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.android.tpush.XGPushManager$c */
    static class C6858c implements Runnable {
        /* renamed from: a */
        Context f22774a = null;
        /* renamed from: b */
        Intent f22775b = null;
        /* renamed from: c */
        XGIOperateCallback f22776c = null;
        /* renamed from: d */
        int f22777d = 0;

        public C6858c(Context context, Intent intent, XGIOperateCallback xGIOperateCallback) {
            this.f22774a = context;
            this.f22775b = intent;
            this.f22776c = xGIOperateCallback;
            this.f22777d = intent.getIntExtra("opType", 0);
        }

        public void run() {
            try {
                int i = this.f22777d;
                if (i == 0) {
                    XGPushManager.m29239c(this.f22774a, this.f22775b, this.f22776c);
                } else if (i != 1) {
                    String a = XGPushManager.f22726a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("TimeoutRunnable error optype:");
                    sb.append(this.f22777d);
                    C6864a.m29308i(a, sb.toString());
                } else {
                    XGPushManager.m29240d(this.f22774a, this.f22775b, this.f22776c);
                }
                for (C6857b a2 : XGPushManager.f22731f.keySet()) {
                    C6914l.m29513a(this.f22774a, (BroadcastReceiver) a2);
                }
                XGPushManager.f22731f.clear();
            } catch (Exception e) {
                C6864a.m29302d(XGPushManager.f22726a, " RegisterTimeoutRunnable run error", e);
            }
        }
    }

    public static void onActivityStoped(Activity activity) {
        if (activity == null) {
        }
    }

    private XGPushManager() {
    }

    public static Context getContext() {
        return f22728c;
    }

    public static void setContext(Context context) {
        if (f22728c == null && context != null) {
            f22728c = context.getApplicationContext();
        }
    }

    public static void startPushService(Context context) {
        if (context != null) {
            setContext(context);
            if (XGPushConfig.enableDebug) {
                String str = f22726a;
                StringBuilder sb = new StringBuilder();
                sb.append(context.getPackageName());
                sb.append("call start Push Service");
                C6864a.m29305f(str, sb.toString());
            }
            C6914l.m29526g(context);
            if (C6914l.m29520c(context) == 0) {
                C6914l.m29524e(context);
            }
        }
    }

    /* renamed from: a */
    static void m29227a(Context context) {
        if (context != null) {
            if (XGPushConfig.enableDebug) {
                String str = f22726a;
                StringBuilder sb = new StringBuilder();
                sb.append(context.getPackageName());
                sb.append(" call stop Push Service");
                C6864a.m29305f(str, sb.toString());
            }
            Intent intent = new Intent();
            intent.setClass(context.getApplicationContext(), XGPushServiceV4.class);
            context.stopService(intent);
        }
    }

    public static int getServiceStatus(Context context) {
        if (context != null) {
            return C6914l.m29520c(context);
        }
        return 0;
    }

    public static void registerPush(Context context) {
        registerPush(context, (XGIOperateCallback) new XGIOperateCallback() {
            public void onSuccess(Object obj, int i) {
                String a = XGPushManager.f22726a;
                StringBuilder sb = new StringBuilder();
                sb.append("XG register push success with token : ");
                sb.append(obj);
                C6864a.m29305f(a, sb.toString());
            }

            public void onFail(Object obj, int i, String str) {
                String a = XGPushManager.f22726a;
                StringBuilder sb = new StringBuilder();
                sb.append("XG register push failed with token : ");
                sb.append(obj);
                sb.append(", errCode : ");
                sb.append(i);
                sb.append(" , msg : ");
                sb.append(str);
                C6864a.m29309j(a, sb.toString());
            }
        });
    }

    public static void registerPush(Context context, XGIOperateCallback xGIOperateCallback) {
        if (xGIOperateCallback != null) {
            m29234a(context, null, null, -1, null, xGIOperateCallback, -1, null, null, null, null, 0);
            return;
        }
        throw new IllegalArgumentException("The callback parameter can not be null!");
    }

    public static void registerPush(Context context, String str, XGIOperateCallback xGIOperateCallback) {
        if (xGIOperateCallback != null) {
            registerPush(context, str, "0", 0, (String) null, xGIOperateCallback);
            return;
        }
        throw new IllegalArgumentException("The callback parameter can not be null!");
    }

    public static void registerPush(Context context, String str, int i, XGIOperateCallback xGIOperateCallback) {
        if (xGIOperateCallback != null) {
            m29234a(context, str, null, -1, null, xGIOperateCallback, -1, null, null, null, null, i);
            return;
        }
        throw new IllegalArgumentException("The callback parameter can not be null!");
    }

    public static void registerPush(Context context, String str, String str2, String str3, String str4, XGIOperateCallback xGIOperateCallback) {
        if (xGIOperateCallback != null) {
            m29234a(context, str, null, -1, null, xGIOperateCallback, -1, null, str2, str3, str4, 0);
            return;
        }
        throw new IllegalArgumentException("The callback parameter can not be null!");
    }

    public static void registerPush(Context context, String str, String str2, String str3, XGIOperateCallback xGIOperateCallback) {
        if (xGIOperateCallback != null) {
            m29234a(context, null, null, -1, null, xGIOperateCallback, -1, null, str, str2, str3, 0);
            return;
        }
        throw new IllegalArgumentException("The callback parameter can not be null!");
    }

    public static void registerPush(Context context, String str) {
        if (context == null || str == null) {
            C6864a.m29309j(Constants.LogTag, "the parameter context or account of registerPush is invalid.");
        } else {
            registerPush(context, str, new XGIOperateCallback() {
                public void onSuccess(Object obj, int i) {
                    String a = XGPushManager.f22726a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("XG register push success with token = ");
                    sb.append(obj);
                    C6864a.m29305f(a, sb.toString());
                }

                public void onFail(Object obj, int i, String str) {
                    String a = XGPushManager.f22726a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("XG register push failed with token = ");
                    sb.append(obj);
                    sb.append(", errCode =  ");
                    sb.append(i);
                    sb.append(", msg = ");
                    sb.append(str);
                    C6864a.m29309j(a, sb.toString());
                }
            });
        }
    }

    public static void bindAccount(Context context, String str, XGIOperateCallback xGIOperateCallback) {
        if (context == null || str == null) {
            C6864a.m29309j(Constants.LogTag, "the parameter context or account of registerPush is invalid.");
            return;
        }
        registerPush(context, str, "0", 32, (String) null, xGIOperateCallback);
    }

    public static void bindAccount(Context context, String str, int i, XGIOperateCallback xGIOperateCallback) {
        if (context == null || str == null) {
            C6864a.m29309j(Constants.LogTag, "the parameter context or account of registerPush is invalid.");
            return;
        }
        registerPush(context, str, "0", 32, null, xGIOperateCallback, i);
    }

    public static void bindAccount(Context context, final String str, int i) {
        if (context == null || str == null) {
            C6864a.m29309j(Constants.LogTag, "the parameter context or account of registerPush is invalid.");
        } else {
            bindAccount(context, str, i, new XGIOperateCallback() {
                public void onSuccess(Object obj, int i) {
                    String a = XGPushManager.f22726a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("XG binderAccount  ");
                    sb.append(str);
                    sb.append(" success with token = ");
                    sb.append(obj);
                    C6864a.m29305f(a, sb.toString());
                }

                public void onFail(Object obj, int i, String str) {
                    String a = XGPushManager.f22726a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("XG binderAccount ");
                    sb.append(str);
                    sb.append(" failed with token = ");
                    sb.append(obj);
                    sb.append(", errCode =  ");
                    sb.append(i);
                    sb.append(", msg = ");
                    sb.append(str);
                    C6864a.m29309j(a, sb.toString());
                }
            });
        }
    }

    public static void bindAccount(Context context, final String str) {
        if (context == null || str == null) {
            C6864a.m29309j(Constants.LogTag, "the parameter context or account of registerPush is invalid.");
        } else {
            bindAccount(context, str, (XGIOperateCallback) new XGIOperateCallback() {
                public void onSuccess(Object obj, int i) {
                    String a = XGPushManager.f22726a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("XG binderAccount  ");
                    sb.append(str);
                    sb.append(" success with token = ");
                    sb.append(obj);
                    C6864a.m29305f(a, sb.toString());
                }

                public void onFail(Object obj, int i, String str) {
                    String a = XGPushManager.f22726a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("XG binderAccount ");
                    sb.append(str);
                    sb.append(" failed with token = ");
                    sb.append(obj);
                    sb.append(", errCode =  ");
                    sb.append(i);
                    sb.append(", msg = ");
                    sb.append(str);
                    C6864a.m29309j(a, sb.toString());
                }
            });
        }
    }

    public static void appendAccount(Context context, String str, XGIOperateCallback xGIOperateCallback) {
        if (context == null || str == null) {
            C6864a.m29309j(Constants.LogTag, "the parameter context or account of registerPush is invalid.");
            return;
        }
        registerPush(context, str, "0", 48, (String) null, xGIOperateCallback);
    }

    public static void appendAccount(Context context, String str, int i, XGIOperateCallback xGIOperateCallback) {
        if (context == null || str == null) {
            C6864a.m29309j(Constants.LogTag, "the parameter context or account of registerPush is invalid.");
            return;
        }
        registerPush(context, str, "0", 48, null, xGIOperateCallback, i);
    }

    public static void appendAccount(Context context, final String str, int i) {
        appendAccount(context, str, i, new XGIOperateCallback() {
            public void onSuccess(Object obj, int i) {
                String a = XGPushManager.f22726a;
                StringBuilder sb = new StringBuilder();
                sb.append("XG appendAccount ");
                sb.append(str);
                sb.append(" success with token = ");
                sb.append(obj);
                C6864a.m29305f(a, sb.toString());
            }

            public void onFail(Object obj, int i, String str) {
                String a = XGPushManager.f22726a;
                StringBuilder sb = new StringBuilder();
                sb.append("XG appendAccount failed with token = ");
                sb.append(obj);
                sb.append(", errCode =  ");
                sb.append(i);
                sb.append(", msg = ");
                sb.append(str);
                C6864a.m29309j(a, sb.toString());
            }
        });
    }

    public static void appendAccount(Context context, final String str) {
        appendAccount(context, str, (XGIOperateCallback) new XGIOperateCallback() {
            public void onSuccess(Object obj, int i) {
                String a = XGPushManager.f22726a;
                StringBuilder sb = new StringBuilder();
                sb.append("XG appendAccount ");
                sb.append(str);
                sb.append(" success with token = ");
                sb.append(obj);
                C6864a.m29305f(a, sb.toString());
            }

            public void onFail(Object obj, int i, String str) {
                String a = XGPushManager.f22726a;
                StringBuilder sb = new StringBuilder();
                sb.append("XG appendAccount failed with token = ");
                sb.append(obj);
                sb.append(", errCode =  ");
                sb.append(i);
                sb.append(", msg = ");
                sb.append(str);
                C6864a.m29309j(a, sb.toString());
            }
        });
    }

    public static void delAccount(Context context, String str, XGIOperateCallback xGIOperateCallback) {
        String str2 = Constants.LogTag;
        if (context == null || str == null) {
            C6864a.m29309j(str2, "the parameter context or account of registerPush is invalid.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Action delAccout ");
        sb.append(str);
        C6864a.m29305f(str2, sb.toString());
        registerPush(context, str, "0", 16, (String) null, xGIOperateCallback);
    }

    public static void delAccount(Context context, String str, int i, XGIOperateCallback xGIOperateCallback) {
        String str2 = Constants.LogTag;
        if (context == null || str == null) {
            C6864a.m29309j(str2, "the parameter context or account of registerPush is invalid.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Action delAccout ");
        sb.append(str);
        C6864a.m29305f(str2, sb.toString());
        registerPush(context, str, "0", 16, null, xGIOperateCallback, i);
    }

    public static void delAccount(Context context, final String str) {
        delAccount(context, str, new XGIOperateCallback() {
            public void onSuccess(Object obj, int i) {
                String a = XGPushManager.f22726a;
                StringBuilder sb = new StringBuilder();
                sb.append("XG deleteAccout ");
                sb.append(str);
                sb.append(" success  with token = ");
                sb.append(obj);
                C6864a.m29305f(a, sb.toString());
            }

            public void onFail(Object obj, int i, String str) {
                String a = XGPushManager.f22726a;
                StringBuilder sb = new StringBuilder();
                sb.append("XG deleteAccout ");
                sb.append(str);
                sb.append(" failed with token = ");
                sb.append(obj);
                sb.append(", errCode =  ");
                sb.append(i);
                sb.append(", msg = ");
                sb.append(str);
                C6864a.m29309j(a, sb.toString());
            }
        });
    }

    public static void delAllAccount(Context context) {
        delAllAccount(context, new XGIOperateCallback() {
            public void onSuccess(Object obj, int i) {
                String a = XGPushManager.f22726a;
                StringBuilder sb = new StringBuilder();
                sb.append("XG deleteAllAccout  success with token = ");
                sb.append(obj);
                C6864a.m29305f(a, sb.toString());
            }

            public void onFail(Object obj, int i, String str) {
                String a = XGPushManager.f22726a;
                StringBuilder sb = new StringBuilder();
                sb.append("XG deleteAllAccout failed with token = ");
                sb.append(obj);
                sb.append(", errCode =  ");
                sb.append(i);
                sb.append(", msg = ");
                sb.append(str);
                C6864a.m29309j(a, sb.toString());
            }
        });
    }

    public static void delAllAccount(Context context, XGIOperateCallback xGIOperateCallback) {
        delAccount(context, Marker.ANY_MARKER, xGIOperateCallback);
    }

    public static void registerPush(Context context, String str, String str2, int i, String str3, XGIOperateCallback xGIOperateCallback) {
        XGIOperateCallback xGIOperateCallback2 = xGIOperateCallback;
        if (xGIOperateCallback2 == null) {
            throw new IllegalArgumentException("The callback parameter can not be null!");
        } else if (context == null || C6914l.m29521c(str) || C6914l.m29521c(str2) || i < 0) {
            xGIOperateCallback2.onFail(null, ReturnCode.CODE_LOGIC_ILLEGAL_ARGUMENT.getType(), "The context, account, ticket or ticketType is(are) invalid!");
        } else {
            m29234a(context, str, str2, i, str3, xGIOperateCallback, -1, null, null, null, null, 0);
        }
    }

    public static void registerPush(Context context, String str, String str2, int i, String str3, XGIOperateCallback xGIOperateCallback, int i2) {
        XGIOperateCallback xGIOperateCallback2 = xGIOperateCallback;
        if (xGIOperateCallback2 == null) {
            throw new IllegalArgumentException("The callback parameter can not be null!");
        } else if (context == null || C6914l.m29521c(str) || C6914l.m29521c(str2) || i < 0) {
            xGIOperateCallback2.onFail(null, ReturnCode.CODE_LOGIC_ILLEGAL_ARGUMENT.getType(), "The context, account, ticket or ticketType is(are) invalid!");
        } else {
            m29234a(context, str, str2, i, str3, xGIOperateCallback, -1, null, null, null, null, i2);
        }
    }

    public static void unregisterPush(Context context) {
        if (context == null) {
            C6864a.m29308i(Constants.LogTag, "the context of unregisterPush is null");
        } else {
            unregisterPush(context, new XGIOperateCallback() {
                public void onSuccess(Object obj, int i) {
                    String a = XGPushManager.f22726a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("UnRegisterPush push succeed with token = ");
                    sb.append(obj);
                    sb.append(" flag = ");
                    sb.append(i);
                    C6864a.m29305f(a, sb.toString());
                }

                public void onFail(Object obj, int i, String str) {
                    String a = XGPushManager.f22726a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("UnRegisterPush push failed with token = ");
                    sb.append(obj);
                    sb.append(" , errCode = ");
                    sb.append(i);
                    sb.append(" , msg = ");
                    sb.append(str);
                    C6864a.m29309j(a, sb.toString());
                }
            });
        }
    }

    public static void unregisterPush(Context context, String str, String str2, String str3, XGIOperateCallback xGIOperateCallback) {
        m29232a(context, xGIOperateCallback, XGPushConfig.getAccessId(context), XGPushConfig.getAccessKey(context), str, str2, str3);
    }

    public static void unregisterPush(Context context, XGIOperateCallback xGIOperateCallback) {
        m29232a(context, xGIOperateCallback, XGPushConfig.getAccessId(context), XGPushConfig.getAccessKey(context), null, null, null);
    }

    /* renamed from: a */
    static void m29232a(Context context, XGIOperateCallback xGIOperateCallback, long j, String str, String str2, String str3, String str4) {
        if (context == null) {
            String str5 = "The context parameter can not be null!";
            if (xGIOperateCallback != null) {
                xGIOperateCallback.onFail(null, ReturnCode.CODE_LOGIC_ILLEGAL_ARGUMENT.getType(), str5);
                return;
            }
            throw new IllegalArgumentException(str5);
        }
        final Context applicationContext = context.getApplicationContext();
        C6901c a = C6901c.m29459a();
        final XGIOperateCallback xGIOperateCallback2 = xGIOperateCallback;
        final long j2 = j;
        final String str6 = str;
        C68442 r0 = new Runnable() {
            public void run() {
                try {
                    int a = C6914l.m29505a(applicationContext);
                    if (a != 0) {
                        if (xGIOperateCallback2 != null) {
                            xGIOperateCallback2.onFail(null, a, "XINGE SDK config error");
                        }
                        return;
                    }
                    long accessId = j2 <= 0 ? XGPushConfig.getAccessId(applicationContext) : j2;
                    String accessKey = C6914l.m29521c(str6) ? XGPushConfig.getAccessKey(applicationContext) : str6;
                    String token = XGPushConfig.getToken(applicationContext);
                    if ((accessId <= 0 || C6914l.m29521c(accessKey) || C6914l.m29521c(token)) && xGIOperateCallback2 != null) {
                        XGIOperateCallback xGIOperateCallback = xGIOperateCallback2;
                        int type = ReturnCode.CODE_LOGIC_ILLEGAL_ARGUMENT.getType();
                        StringBuilder sb = new StringBuilder();
                        sb.append("The accessId, accessKey or token is invalid! accessId=");
                        sb.append(accessId);
                        sb.append(",accessKey=");
                        sb.append(accessKey);
                        sb.append(",token=");
                        sb.append(token);
                        xGIOperateCallback.onFail(null, type, sb.toString());
                        throw new IllegalArgumentException("accessId, accessKey or token is invalid.");
                    }
                    Intent intent = new Intent("com.tencent.android.tpush.action.UNREGISTER.V4");
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("");
                    sb2.append(accessId);
                    intent.putExtra("accId", Rijndael.encrypt(sb2.toString()));
                    intent.putExtra("accKey", Rijndael.encrypt(accessKey));
                    intent.putExtra("token", Rijndael.encrypt(token));
                    intent.putExtra(Constants.FLAG_PACK_NAME, Rijndael.encrypt(applicationContext.getPackageName()));
                    intent.putExtra("operation", 101);
                    intent.putExtra("opType", 1);
                    boolean b = C6913k.m29501a(applicationContext).mo33120b();
                    if (C6914l.m29520c(applicationContext) != 1 || b) {
                        XGPushManager.m29230a(applicationContext, intent, xGIOperateCallback2, b);
                    } else {
                        XGPushManager.m29240d(applicationContext, intent, xGIOperateCallback2);
                    }
                } catch (Throwable th) {
                    C6864a.m29304e(Constants.LogTag, "unregisterPush", th);
                }
            }
        };
        a.mo33104a((Runnable) r0);
    }

    public static void setTag(Context context, String str) {
        if (XGPushConfig.enableDebug) {
            String str2 = f22726a;
            StringBuilder sb = new StringBuilder();
            sb.append("Action -> setTag with tag = ");
            sb.append(str);
            C6864a.m29305f(str2, sb.toString());
        }
        m29233a(context, str, 1, -1, str);
    }

    /* renamed from: a */
    static String m29226a(Set<String> set, String str) {
        if (set == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" -> the parameter tags is null.");
            C6864a.m29309j(Constants.LogTag, sb.toString());
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        int i = 0;
        Iterator it = set.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String str2 = " ";
            String replaceAll = ((String) it.next()).replaceAll(str2, "");
            if (replaceAll.length() > 40) {
                String str3 = f22726a;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(" -> the tag:");
                sb3.append(replaceAll);
                sb3.append(" length is more than 40, discard it");
                C6864a.m29307h(str3, sb3.toString());
            } else {
                if (i >= 1000) {
                    if (!XGPushConfig.enableDebug) {
                        String str4 = f22726a;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(str);
                        sb4.append(" -> tags size is more than 1000, discard some tags");
                        C6864a.m29307h(str4, sb4.toString());
                        break;
                    }
                    String str5 = f22726a;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(str);
                    sb5.append(" -> tags size is ");
                    sb5.append(i + 1);
                    sb5.append(", so discard tag:");
                    sb5.append(replaceAll);
                    C6864a.m29307h(str5, sb5.toString());
                } else {
                    if (i != 0) {
                        sb2.append(str2);
                    }
                    sb2.append(replaceAll);
                }
                i++;
            }
        }
        return sb2.toString();
    }

    public static void setTags(Context context, String str, Set<String> set) {
        if (context == null || set == null || set.isEmpty()) {
            C6864a.m29309j(f22726a, "the parameter context or tags of setTags is invalid.");
            return;
        }
        String a = m29226a(set, "setTags");
        if (a == null) {
            C6864a.m29309j(f22726a, "setTags -> getTagsFromSet return null!!!");
            return;
        }
        if (XGPushConfig.enableDebug) {
            String str2 = f22726a;
            StringBuilder sb = new StringBuilder();
            sb.append("Action -> setTags with all tags = ");
            sb.append(a);
            C6864a.m29305f(str2, sb.toString());
        }
        m29233a(context, a, 6, -1, str);
    }

    public static void addTags(Context context, String str, Set<String> set) {
        if (context == null || set == null || set.isEmpty()) {
            C6864a.m29309j(f22726a, "the parameter context or tags of addTags is invalid.");
            return;
        }
        String a = m29226a(set, "addTags");
        if (a == null) {
            C6864a.m29309j(f22726a, "addTags -> getTagsFromSet return null!!!");
            return;
        }
        if (XGPushConfig.enableDebug) {
            String str2 = f22726a;
            StringBuilder sb = new StringBuilder();
            sb.append("addTags -> setTags with all tags = ");
            sb.append(a);
            C6864a.m29305f(str2, sb.toString());
        }
        m29233a(context, a, 5, -1, str);
    }

    public static void setKeyValueTag(Context context, String str, String str2) {
        if (context == null || str == null || str.trim().length() == 0 || str2 == null || str2.trim().length() == 0) {
            C6864a.m29309j(f22726a, "setKeyValueTag context or tagKey or tagValue invalid.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("::::");
        sb.append(str2);
        String sb2 = sb.toString();
        String str3 = f22726a;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Action -> setKeyValueTag with tag = ");
        sb3.append(sb2);
        C6864a.m29305f(str3, sb3.toString());
        m29233a(context, sb2, 3, -1, sb2);
    }

    public static void sendCommReport2Service(Context context, String str, String str2) {
        long accessId = XGPushConfig.getAccessId(context);
        Intent intent = new Intent("com.tencent.android.tpush.action.COMM_REPORT.V4");
        intent.putExtra("type", 1);
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(accessId);
        intent.putExtra("accessId", Rijndael.encrypt(sb.toString()));
        intent.putExtra(MessageKey.MSG_ID, 1000);
        intent.putExtra("broadcastId", 0);
        intent.putExtra("msgTimestamp", System.currentTimeMillis() / 1000);
        intent.putExtra("clientTimestamp", System.currentTimeMillis() / 1000);
        intent.putExtra(AppEntity.KEY_PKG_NAME_STR, context.getPackageName());
        intent.putExtra(NotificationCompat.CATEGORY_MESSAGE, Rijndael.encrypt(str));
        intent.putExtra("ext", Rijndael.encrypt(str2));
        context.sendBroadcast(intent);
    }

    public static void deleteKeyValueTag(Context context, String str, String str2) {
        if (context == null || str == null || str.trim().length() == 0) {
            C6864a.m29309j(f22726a, "deleteKeyValueTag context or tagKey invalid.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("::::");
        sb.append(str2);
        String sb2 = sb.toString();
        String str3 = f22726a;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Action -> deleteKeyValueTag with tag = ");
        sb3.append(sb2);
        C6864a.m29305f(str3, sb3.toString());
        m29233a(context, sb2, 4, -1, sb2);
    }

    public static void deleteTag(Context context, String str) {
        if (XGPushConfig.enableDebug) {
            String str2 = f22726a;
            StringBuilder sb = new StringBuilder();
            sb.append("Action -> deleteTag with tag = ");
            sb.append(str);
            C6864a.m29305f(str2, sb.toString());
        }
        if (context == null || str == null || str.trim().length() == 0) {
            C6864a.m29309j(f22726a, "context is null or tagName invalid.");
        } else {
            m29233a(context, str, 2, -1, str);
        }
    }

    public static void deleteTags(Context context, String str, Set<String> set) {
        if (context == null || set == null || set.isEmpty()) {
            C6864a.m29309j(f22726a, "the parameter context or tags of deleteTags is invalid.");
            return;
        }
        String a = m29226a(set, "deleteTags");
        if (a == null) {
            C6864a.m29309j(f22726a, "deleteTags -> getTagsFromSet return null!!!");
            return;
        }
        if (XGPushConfig.enableDebug) {
            String str2 = f22726a;
            StringBuilder sb = new StringBuilder();
            sb.append("deleteTags -> setTags with all tags = ");
            sb.append(a);
            C6864a.m29305f(str2, sb.toString());
        }
        m29233a(context, a, 7, -1, str);
    }

    public static void cleanTags(Context context, String str) {
        if (context == null) {
            C6864a.m29309j(f22726a, "the parameter context of cleanTags is invalid");
            return;
        }
        if (XGPushConfig.enableDebug) {
            C6864a.m29305f(f22726a, "Action -> cleanTags");
        }
        m29233a(context, Marker.ANY_MARKER, 8, -1, str);
    }

    /* renamed from: a */
    static void m29233a(Context context, String str, int i, long j, String str2) {
        if (context == null) {
            throw new IllegalArgumentException("The context parameter can not be null!");
        } else if (C6914l.m29505a(context) <= 0) {
            if (str != null) {
                if (j <= 0) {
                    j = XGPushConfig.getAccessId(context);
                }
                if (j >= 0) {
                    Intent intent = new Intent("com.tencent.android.tpush.action.TAG.V4");
                    intent.putExtra("accId", j);
                    intent.putExtra(Constants.FLAG_PACK_NAME, Rijndael.encrypt(context.getPackageName()));
                    intent.putExtra(Constants.FLAG_TAG_TYPE, i);
                    intent.putExtra(Constants.FLAG_TAG_NAME, Rijndael.encrypt(str));
                    intent.putExtra(Constants.FLAG_TAG_OPER_NAME, str2);
                    context.sendBroadcast(intent);
                    return;
                }
                throw new IllegalArgumentException("The accessId not set!");
            }
            throw new IllegalArgumentException("The tagName parameter can not be null!");
        }
    }

    /* renamed from: a */
    static XGPushClickedResult m29223a(final Activity activity) {
        if (XGPushConfig.enableDebug) {
            StringBuilder sb = new StringBuilder();
            sb.append(">>> onActivityStarted activity=");
            sb.append(activity);
            C6864a.m29305f(Constants.LogTag, sb.toString());
        }
        XGPushClickedResult xGPushClickedResult = null;
        if (!(activity == null || activity.getIntent() == null)) {
            final Intent intent = activity.getIntent();
            String str = Constants.TAG_TPUSH_MESSAGE;
            String stringExtra = intent.getStringExtra(str);
            if (stringExtra != null && stringExtra.equalsIgnoreCase("true")) {
                if (C6914l.m29505a(activity.getApplicationContext()) > 0) {
                    return null;
                }
                xGPushClickedResult = new XGPushClickedResult();
                xGPushClickedResult.parseIntent(intent);
                intent.removeExtra(str);
                C6901c.m29459a().mo33104a((Runnable) new Runnable() {
                    public void run() {
                        XGPushManager.m29228a((Context) activity, intent);
                        XGPushManager.m29238c(activity, intent);
                    }
                });
            }
        }
        return xGPushClickedResult;
    }

    public static boolean isNotificationOpened(Context context) {
        return C7051d.m30147a(context);
    }

    public static XGPushClickedResult onActivityStarted(Activity activity) {
        String str = Constants.TAG_TPUSH_NOTIFICATION;
        if (XGPushConfig.enableDebug) {
            StringBuilder sb = new StringBuilder();
            sb.append(">>> onActivityStarted ");
            sb.append(activity);
            C6864a.m29305f(Constants.PushMessageLogTag, sb.toString());
        }
        if (!(activity == null || activity.getIntent() == null || !C6914l.m29527h(activity))) {
            Intent intent = activity.getIntent();
            if (intent != null) {
                try {
                    if (intent.hasExtra(str)) {
                        Serializable serializableExtra = intent.getSerializableExtra(str);
                        intent.removeExtra(str);
                        if (serializableExtra != null && (serializableExtra instanceof XGPushClickedResult)) {
                            XGPushClickedResult xGPushClickedResult = (XGPushClickedResult) serializableExtra;
                            xGPushClickedResult.parseIntent(intent);
                            return xGPushClickedResult;
                        }
                    }
                } catch (Exception e) {
                    C6864a.m29302d(f22726a, "onActivityStarted", e);
                }
            }
        }
        return null;
    }

    public static long addLocalNotification(Context context, XGLocalMessage xGLocalMessage) {
        return m29222a(context, xGLocalMessage, -1);
    }

    /* renamed from: a */
    static long m29222a(Context context, XGLocalMessage xGLocalMessage, long j) {
        Context context2 = context;
        String str = Constants.LogTag;
        if (context2 == null || xGLocalMessage == null) {
            C6864a.m29308i(f22726a, "addLocalNotification context == null or msg == null");
            return -1;
        }
        try {
            if (!TpnsSecurity.checkTpnsSecurityLibSo(context)) {
                return -1;
            }
            long accessId = j <= 0 ? XGPushConfig.getAccessId(context) : j;
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder sb = new StringBuilder(64);
            sb.append(accessId);
            sb.append(xGLocalMessage.getMsgId());
            sb.append(context.getPackageName());
            String str2 = "";
            sb.append(TextUtils.isEmpty(xGLocalMessage.getTitle()) ? str2 : xGLocalMessage.getTitle());
            sb.append(TextUtils.isEmpty(xGLocalMessage.getContent()) ? str2 : xGLocalMessage.getContent());
            String custom_content = xGLocalMessage.getCustom_content();
            if (TextUtils.isEmpty(custom_content) || new JSONObject(custom_content).length() == 0) {
                custom_content = str2;
            }
            sb.append(custom_content);
            if (xGLocalMessage.getType() == 1) {
                sb.append(TextUtils.isEmpty(xGLocalMessage.getUrl()) ? str2 : xGLocalMessage.getUrl());
                sb.append(TextUtils.isEmpty(xGLocalMessage.getIntent()) ? str2 : xGLocalMessage.getIntent());
                if (!TextUtils.isEmpty(xGLocalMessage.getActivity())) {
                    str2 = xGLocalMessage.getActivity();
                }
                sb.append(str2);
            }
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(Constants.LOCAL_MESSAGE_FLAG);
            sb3.append(C6931a.m29598a(sb2));
            String sb4 = sb3.toString();
            long expirationTimeMs = xGLocalMessage.getExpirationTimeMs();
            C6908h.m29486b(context2, sb4, expirationTimeMs);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(sb2);
            sb5.append(",tag:");
            sb5.append(sb4);
            sb5.append(",exp:");
            sb5.append(expirationTimeMs);
            C6864a.m29303e(str, sb5.toString());
            TpnsPushMsg tpnsPushMsg = new TpnsPushMsg();
            tpnsPushMsg.msgId = xGLocalMessage.getMsgId();
            tpnsPushMsg.accessId = accessId;
            tpnsPushMsg.appPkgName = context.getPackageName();
            tpnsPushMsg.busiMsgId = xGLocalMessage.getBusiMsgId();
            tpnsPushMsg.timestamp = currentTimeMillis / 1000;
            long j2 = -currentTimeMillis;
            tpnsPushMsg.serverTime = j2;
            tpnsPushMsg.ttl = xGLocalMessage.getTtl();
            tpnsPushMsg.type = (long) xGLocalMessage.getType();
            tpnsPushMsg.multiPkg = 0;
            tpnsPushMsg.date = xGLocalMessage.getDate();
            StringBuilder sb6 = new StringBuilder();
            sb6.append("{\"title\":\"");
            sb6.append(xGLocalMessage.getTitle());
            sb6.append("\",\"content\":\"");
            sb6.append(m29225a(xGLocalMessage.getContent()));
            sb6.append("\",\"builder_id\":");
            sb6.append(xGLocalMessage.getBuilderId());
            sb6.append(",\"custom_content\":");
            sb6.append(xGLocalMessage.getCustom_content());
            sb6.append(",\"ring\":");
            sb6.append(xGLocalMessage.getRing());
            sb6.append(",\"vibrate\":");
            sb6.append(xGLocalMessage.getVibrate());
            sb6.append(",\"lights\":");
            sb6.append(xGLocalMessage.getLights());
            sb6.append(",\"n_id\":");
            sb6.append(xGLocalMessage.getNotificationId());
            sb6.append(",\"ring_raw\":\"");
            sb6.append(xGLocalMessage.getRing_raw());
            sb6.append("\",\"icon_type\":");
            sb6.append(xGLocalMessage.getIcon_type());
            sb6.append(",\"icon_res\":\"");
            sb6.append(xGLocalMessage.getIcon_res());
            sb6.append("\",\"style_id\":");
            sb6.append(xGLocalMessage.getStyle_id());
            sb6.append(",\"small_icon\":\"");
            sb6.append(xGLocalMessage.getSmall_icon());
            sb6.append("\",\"clearable\":1,\"accept_time\":[{\"start\":{\"hour\":\"");
            sb6.append(xGLocalMessage.getHour());
            sb6.append("\",\"min\":\"");
            sb6.append(xGLocalMessage.getMin());
            sb6.append("\"},\"end\":{\"hour\":\"23\",\"min\":\"59\"}}],\"action\":{\"action_type\":");
            sb6.append(xGLocalMessage.getAction_type());
            sb6.append(",\"activity\":\"");
            sb6.append(xGLocalMessage.getActivity());
            sb6.append("\",\"browser\":{\"url\":\"");
            sb6.append(xGLocalMessage.getUrl());
            sb6.append("\"},\"intent\":\"");
            sb6.append(xGLocalMessage.getIntent());
            sb6.append("\",\"package_name\":{\"packageDownloadUrl\":\"");
            sb6.append(xGLocalMessage.getPackageDownloadUrl());
            sb6.append("\",\"packageName\":\"");
            sb6.append(xGLocalMessage.getPackageName());
            sb6.append("\"}}}");
            tpnsPushMsg.content = sb6.toString();
            C7000a aVar = new C7000a(Integer.valueOf(0), "127.0.0.1");
            Intent intent = new Intent(Constants.ACTION_INTERNAL_PUSH_MESSAGE);
            intent.setPackage(tpnsPushMsg.appPkgName);
            intent.putExtra(MessageKey.MSG_ID, tpnsPushMsg.msgId);
            intent.putExtra(MessageKey.MSG_CONTENT, Rijndael.encrypt(tpnsPushMsg.content));
            intent.putExtra(MessageKey.MSG_DATE, tpnsPushMsg.date);
            C7000a aVar2 = aVar;
            intent.putExtra("type", tpnsPushMsg.type);
            intent.putExtra("accId", tpnsPushMsg.accessId);
            intent.putExtra(MessageKey.MSG_BUSI_MSG_ID, tpnsPushMsg.busiMsgId);
            intent.putExtra(MessageKey.MSG_CREATE_TIMESTAMPS, tpnsPushMsg.timestamp);
            intent.putExtra(MessageKey.MSG_CREATE_MULTIPKG, tpnsPushMsg.multiPkg);
            intent.putExtra(MessageKey.MSG_SERVER_TIME, tpnsPushMsg.serverTime * 1000);
            intent.putExtra(MessageKey.MSG_TTL, tpnsPushMsg.ttl);
            intent.putExtra(MessageKey.MSG_SERVICE_ACK, true);
            intent.putExtra(MessageKey.MSG_EXTRA_HOST, C7056i.m30195c(aVar2.mo33365d()));
            intent.putExtra(MessageKey.MSG_EXTRA_PORT, aVar2.mo33366e());
            intent.putExtra(MessageKey.MSG_EXTRA_PACT, C6982c.m29814a(aVar2.mo33363b()));
            intent.putExtra(MessageKey.MSG_EXTRA_PUSHTIME, currentTimeMillis);
            C6876f.m29376a(context).mo33046b(intent);
            return j2;
        } catch (Throwable th) {
            C6864a.m29302d(str, "addLocalNotification ", th);
            return 0;
        }
    }

    public static XGPushNotifactionCallback getNotifactionCallback() {
        return f22729d;
    }

    public static void setNotifactionCallback(XGPushNotifactionCallback xGPushNotifactionCallback) {
        f22729d = xGPushNotifactionCallback;
    }

    public static void clearLocalNotifications(Context context) {
        if (context == null) {
            C6864a.m29308i(f22726a, "clearLocalNotifications  context==null.");
        } else if (C6914l.m29505a(context) <= 0) {
            final Context applicationContext = context.getApplicationContext();
            C6901c.m29459a().mo33104a((Runnable) new Runnable() {
                public void run() {
                    C6871c.m29327a().mo33020c(applicationContext);
                }
            });
        }
    }

    /* renamed from: a */
    static void m29228a(Context context, Intent intent) {
        C6871c.m29327a().mo33026e(context, intent.getLongExtra(MessageKey.MSG_ID, -1));
        Intent intent2 = new Intent("com.tencent.android.tpush.action.PUSH_CLICK.RESULT.V4");
        intent2.putExtras(intent);
        intent2.putExtra(Constants.FLAG_PACK_NAME, context.getPackageName());
        intent2.putExtra(Constants.FLAG_CLICK_TIME, System.currentTimeMillis() / 1000);
        C7046a.m30135e(context, intent2);
        context.sendBroadcast(intent2);
    }

    public static void onMessageClicked(Context context, XGPushTextMessage xGPushTextMessage) {
        m29231a(context, xGPushTextMessage.getSimpleIntent(), "com.tencent.android.tpush.action.PUSH_CLICK.RESULT.V4");
    }

    public static void onMessageCleared(Context context, XGPushTextMessage xGPushTextMessage) {
        m29231a(context, xGPushTextMessage.getSimpleIntent(), "com.tencent.android.tpush.action.PUSH_CANCELLED.RESULT.V4");
    }

    /* renamed from: a */
    private static void m29231a(Context context, Intent intent, String str) {
        if (context != null && intent != null && str != null) {
            Intent intent2 = new Intent(str);
            intent2.putExtras(intent);
            if ("com.tencent.android.tpush.action.PUSH_CANCELLED.RESULT.V4".equals(str)) {
                intent2.putExtra("action", NotificationAction.delete.getType());
            }
            intent2.putExtra(Constants.FLAG_PACK_NAME, context.getPackageName());
            intent2.putExtra(Constants.FLAG_CLICK_TIME, System.currentTimeMillis() / 1000);
            C7046a.m30135e(context, intent2);
            context.sendBroadcast(intent2);
        }
    }

    /* access modifiers changed from: private|static */
    /* renamed from: c */
    public static void m29238c(Context context, Intent intent) {
        if (intent != null) {
            Intent intent2 = new Intent(Constants.ACTION_FEEDBACK);
            intent2.setPackage(context.getPackageName());
            intent2.putExtra(Constants.FEEDBACK_TAG, 4);
            intent2.putExtra(Constants.FEEDBACK_ERROR_CODE, 0);
            intent2.putExtras(intent);
            context.sendBroadcast(intent2);
        }
    }

    public static void setPushNotificationBuilder(Context context, int i, XGPushNotificationBuilder xGPushNotificationBuilder) {
        if (context == null) {
            throw new IllegalArgumentException("context is null.");
        } else if (i < 1 || i > 4096) {
            throw new IllegalArgumentException("notificationBulderId不在范围[1, 4096].");
        } else if (xGPushNotificationBuilder != null) {
            C6868b.m29321a(context, i, xGPushNotificationBuilder);
        }
    }

    public static void setDefaultNotificationBuilder(Context context, XGPushNotificationBuilder xGPushNotificationBuilder) {
        if (context != null && xGPushNotificationBuilder != null) {
            C6868b.m29321a(context, 0, xGPushNotificationBuilder);
        }
    }

    public static XGPushNotificationBuilder getDefaultNotificationBuilder(Context context) {
        XGPushNotificationBuilder notificationBuilder = getNotificationBuilder(context, 0);
        if (notificationBuilder == null) {
            C6868b.m29318a(context);
        }
        return notificationBuilder;
    }

    public static XGPushNotificationBuilder getNotificationBuilder(Context context, int i) {
        if (context != null) {
            return C6868b.m29319a(context, i);
        }
        Log.e(Constants.LogTag, "getNotificationBuilder  context == null");
        return null;
    }

    public static void cancelNotifaction(Context context, int i) {
        try {
            ((NotificationManager) context.getSystemService("notification")).cancel(i);
        } catch (Exception unused) {
        }
    }

    public static void cancelAllNotifaction(Context context) {
        try {
            ((NotificationManager) context.getSystemService("notification")).cancelAll();
        } catch (Exception unused) {
        }
    }

    public static void msgAck(Context context, C6881g gVar) {
        if (!(context == null || gVar == null)) {
            boolean z = XGPushConfig.enableDebug;
            String str = StorageInterface.KEY_SPLITER;
            String str2 = "Action -> msgAck(";
            if (z) {
                String str3 = f22726a;
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append(context.getPackageName());
                sb.append(str);
                sb.append(gVar.mo33052b());
                sb.append(")");
                C6864a.m29286a(str3, sb.toString());
            }
            C6864a.m29283a(3, gVar.mo33052b());
            if (gVar.mo33052b() > 0) {
                MessageId a = C6871c.m29327a().mo33005a(context, context.getPackageName(), gVar.mo33052b());
                if (a == null) {
                    String str4 = f22726a;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str2);
                    sb2.append(context.getPackageName());
                    sb2.append(str);
                    sb2.append(gVar.mo33052b());
                    sb2.append(")error, no the id: ");
                    sb2.append(gVar.mo33052b());
                    C6864a.m29307h(str4, sb2.toString());
                    return;
                }
                Intent intent = new Intent("com.tencent.android.tpush.action.MSG_ACK.V4");
                intent.putExtra(MessageKey.MSG_ID, gVar.mo33052b());
                intent.putExtra(Constants.FLAG_PACK_NAME, context.getPackageName());
                intent.putExtra("MessageId", a);
                intent.putExtra(MessageKey.MSG_CHANNEL_ID, gVar.mo33058h());
                context.sendBroadcast(intent);
            }
        }
    }

    public static String getServiceTag(Context context) {
        String str = "xg_service_enable";
        if (!TpnsSecurity.checkTpnsSecurityLibSo(context)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(XGPushConfig.getAccessId(context));
        sb.append(StorageInterface.KEY_SPLITER);
        sb.append(str);
        return Rijndael.encrypt(sb.toString());
    }

    public static void enableService(final Context context, boolean z) {
        if (context != null) {
            if (!z) {
                C6864a.m29308i(Constants.LogTag, "XG is disable.");
                unregisterPush(context, new XGIOperateCallback() {
                    public void onSuccess(Object obj, int i) {
                        XGPushManager.m29227a(context);
                    }

                    public void onFail(Object obj, int i, String str) {
                        XGPushManager.m29227a(context);
                    }
                });
            }
            enableService = z;
            if (XGPushConfig.enableDebug) {
                String str = f22726a;
                StringBuilder sb = new StringBuilder();
                sb.append("enableService=");
                sb.append(enableService);
                C6864a.m29305f(str, sb.toString());
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(context.getPackageName());
            sb2.append(ENABLE_SERVICE_SUFFIX);
            C6907g.m29477a(context, sb2.toString(), enableService);
        }
    }

    /* renamed from: a */
    static void m29234a(Context context, String str, String str2, int i, String str3, XGIOperateCallback xGIOperateCallback, long j, String str4, String str5, String str6, String str7, int i2) {
        XGIOperateCallback xGIOperateCallback2 = xGIOperateCallback;
        setContext(context);
        if (context == null) {
            xGIOperateCallback2.onFail(null, ReturnCode.CODE_LOGIC_ILLEGAL_ARGUMENT.getType(), "The context parameter can not be null!");
            return;
        }
        if (!f22727b) {
            C7046a.m30128b(context);
            f22727b = true;
        }
        int i3 = i >> 4;
        String str8 = "duplicate register request";
        if ((i3 <= 0 || i3 > 4) && Math.abs(System.currentTimeMillis() - f22730e.longValue()) < ((long) 1000)) {
            xGIOperateCallback2.onFail(null, ReturnCode.CODE_LOGIC_REGISTER_IN_PROCESS.getType(), str8);
            return;
        }
        f22730e = Long.valueOf(System.currentTimeMillis());
        Long l = (Long) lastSuccessRegisterMap.get(context.getPackageName());
        if (l == null || Math.abs((System.currentTimeMillis() / 1000) - l.longValue()) >= 3) {
            C6901c a = C6901c.m29459a();
            final Context context2 = context;
            final XGIOperateCallback xGIOperateCallback3 = xGIOperateCallback;
            final long j2 = j;
            final String str9 = str4;
            final String str10 = str;
            final int i4 = i2;
            final int i5 = i;
            final String str11 = str2;
            final String str12 = str3;
            final String str13 = str5;
            final String str14 = str7;
            final String str15 = str6;
            C68486 r0 = new Runnable() {
                public void run() {
                    long j;
                    long j2;
                    String str = Constants.OTHER_PUSH_TAG;
                    try {
                        int a = C6914l.m29505a(context2);
                        if (a != 0) {
                            if (xGIOperateCallback3 != null) {
                                xGIOperateCallback3.onFail(null, a, ReturnCode.errCodeToMsg(a));
                            }
                            return;
                        }
                        long j3 = 0;
                        if (j2 > 0) {
                            j = j2;
                        } else {
                            j = XGPushConfig.getAccessId(context2);
                        }
                        String accessKey = C6914l.m29521c(str9) ? XGPushConfig.getAccessKey(context2) : str9;
                        if (j <= 0 || C6914l.m29521c(accessKey)) {
                            XGIOperateCallback xGIOperateCallback = xGIOperateCallback3;
                            int type = ReturnCode.CODE_LOGIC_ILLEGAL_ARGUMENT.getType();
                            StringBuilder sb = new StringBuilder();
                            sb.append("The accessId or accessKey is(are) invalid!@accessId:");
                            sb.append(j);
                            sb.append(", @accessKey:");
                            sb.append(accessKey);
                            xGIOperateCallback.onFail(null, type, sb.toString());
                            return;
                        }
                        if ((XGPushConfig.isUsedOtherPush(context2) && C6927d.m29569a(context2).mo33137g()) || (XGPushConfig.isUsedFcmPush(context2) && C6913k.m29501a(context2).mo33121c())) {
                            C6927d.m29569a(context2).mo33133b();
                            long currentTimeMillis = System.currentTimeMillis();
                            while (true) {
                                if (System.currentTimeMillis() - currentTimeMillis >= 30000) {
                                    break;
                                }
                                try {
                                    Thread.sleep(200);
                                    String d = C6927d.m29569a(context2).mo33135d();
                                    if (!C6914l.m29521c(d)) {
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append("get otherToken is : ");
                                        sb2.append(d);
                                        C6864a.m29303e(str, sb2.toString());
                                        break;
                                    }
                                } catch (InterruptedException unused) {
                                } catch (Exception unused2) {
                                    C6864a.m29308i(str, "OtherPush: call getToken Error!.");
                                }
                            }
                        }
                        C6914l.m29526g(context2);
                        Intent intent = new Intent("com.tencent.android.tpush.action.REGISTER.V4");
                        StringBuilder sb3 = new StringBuilder();
                        String str2 = "";
                        sb3.append(str2);
                        sb3.append(j);
                        intent.putExtra("accId", Rijndael.encrypt(sb3.toString()));
                        intent.putExtra("accChannel", XGPushConfig.getChannelId(context2));
                        intent.putExtra("accKey", Rijndael.encrypt(accessKey));
                        String str3 = str10;
                        if (str3 != null) {
                            intent.putExtra("account", Rijndael.encrypt(str3));
                            intent.putExtra("accountType", i4);
                        }
                        if ((i5 >> 4) != 1) {
                            intent.putExtra("appVer", C6914l.m29525f(context2));
                            intent.putExtra(Constants.FLAG_PACK_NAME, Rijndael.encrypt(context2.getPackageName()));
                            if (C6909i.m29488a(context2) != null) {
                                intent.putExtra("reserved", Rijndael.encrypt(C6909i.m29488a(context2).mo33108a()));
                            }
                            String str4 = str11;
                            if (str4 != null) {
                                intent.putExtra(Constants.FLAG_TICKET, Rijndael.encrypt(str4));
                            }
                            String str5 = str12;
                            if (str5 != null) {
                                intent.putExtra("qua", Rijndael.encrypt(str5));
                            }
                            intent.putExtra("operation", 100);
                            intent.putExtra("aidl", C6914l.m29518b(context2));
                        }
                        intent.putExtra(Constants.FLAG_TICKET_TYPE, i5);
                        intent.putExtra("currentTimeMillis", System.currentTimeMillis());
                        intent.putExtra("opType", 0);
                        if (!C6914l.m29521c(str13)) {
                            intent.putExtra("url", str13);
                            j3 = 4;
                        }
                        if (!C6914l.m29521c(str14)) {
                            intent.putExtra("otherToken", str14);
                            j2 = !C7055h.m30169a(context2, str14, str2).equals(CacheManager.getToken(context2)) ? 2 : 3;
                        } else {
                            j2 = 1;
                        }
                        if (!C6914l.m29521c(str15)) {
                            intent.putExtra("payload", str15);
                        }
                        intent.putExtra("otherPushTokenOpType", j2);
                        intent.putExtra("otherPushType", j3);
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("url = ");
                        sb4.append(str13);
                        sb4.append(" payload = ");
                        sb4.append(str15);
                        sb4.append(" otherPushType ");
                        sb4.append(j3);
                        sb4.append(" otherPushTokenOpType ");
                        sb4.append(j2);
                        C6864a.m29298c("XGPushManager", sb4.toString());
                        boolean a2 = C6913k.m29501a(context2).mo33119a();
                        if (C6914l.m29520c(context2) != 1 || a2 || !C7056i.m30228v(context2)) {
                            XGPushManager.m29230a(context2, intent, xGIOperateCallback3, a2);
                        } else {
                            XGPushManager.m29239c(context2, intent, xGIOperateCallback3);
                            C6973b.m29770b(context2);
                        }
                        if (XGPushConfig.isReportNotificationStatusEnable(context2)) {
                            C7056i.m30198c(context2);
                        }
                        if (XGPushConfig.isReportApplistEnable(context2)) {
                            C7056i.m30191b(context2);
                        }
                    } catch (Throwable th) {
                        C6864a.m29302d(XGPushManager.f22726a, GameReportHelper.REGISTER, th);
                    }
                }
            };
            a.mo33104a((Runnable) r0);
            return;
        }
        xGIOperateCallback2.onFail(null, ReturnCode.CODE_LOGIC_REGISTER_IN_PROCESS.getType(), str8);
    }

    /* renamed from: a */
    static void m29230a(Context context, Intent intent, XGIOperateCallback xGIOperateCallback, boolean z) {
        String str = Constants.LogTag;
        C6914l.m29524e(context);
        C6857b bVar = new C6857b(context, intent, xGIOperateCallback);
        try {
            context.registerReceiver(bVar, new IntentFilter("com.tencent.android.tpush.action.SERVICE_START.V4"));
        } catch (Throwable th) {
            C6864a.m29302d(str, "Receiver not registered exception error : ", th);
        }
        C6858c cVar = new C6858c(context, intent, xGIOperateCallback);
        try {
            f22731f.put(bVar, cVar);
            C6901c.m29459a().mo33106a(cVar, 10000);
        } catch (Exception e) {
            C6864a.m29302d(str, "mapTimeRunnableOfMessage error", e);
        }
    }

    /* access modifiers changed from: private|static|declared_synchronized */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:2|3|(1:5)|(2:7|8)|9|10|(2:11|12)|17) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001f */
    /* renamed from: c */
    public static synchronized void m29239c(android.content.Context r13, android.content.Intent r14, final com.tencent.android.tpush.XGIOperateCallback r15) {
        /*
        java.lang.Class<com.tencent.android.tpush.XGPushManager> r0 = com.tencent.android.tpush.XGPushManager.class
        monitor-enter(r0)
        boolean r1 = com.tencent.android.tpush.XGPushConfig.enableDebug     // Catch:{ all -> 0x0092 }
        if (r1 == 0) goto L_0x000e
        java.lang.String r1 = f22726a     // Catch:{ all -> 0x0092 }
        java.lang.String r2 = "Action -> Register to xinge server"
        com.tencent.android.tpush.p580b.C6864a.m29305f(r1, r2)     // Catch:{ all -> 0x0092 }
    L_0x000e:
        if (r15 == 0) goto L_0x001f
        com.tencent.android.tpush.XGPushManager$7 r1 = new com.tencent.android.tpush.XGPushManager$7     // Catch:{ all -> 0x001f }
        r1.m51836init(r15)     // Catch:{ all -> 0x001f }
        android.content.IntentFilter r15 = new android.content.IntentFilter     // Catch:{ all -> 0x001f }
        java.lang.String r2 = "com.tencent.android.tpush.action.REGISTER.RESULT.V4"
        r15.<init>(r2)     // Catch:{ all -> 0x001f }
        r13.registerReceiver(r1, r15)     // Catch:{ all -> 0x001f }
    L_0x001f:
        r13.sendBroadcast(r14)     // Catch:{ all -> 0x0092 }
        long r4 = com.tencent.android.tpush.XGPushConfig.getAccessId(r13)     // Catch:{ all -> 0x0075 }
        java.lang.String r6 = "ptTry"
        java.lang.String r7 = "readyPatch"
        r8 = 0
        java.lang.String r9 = "XGPushManager load Start"
        r10 = 0
        r3 = r13
        com.tencent.android.tpush.stat.XGPatchMonitor.onConfigAction(r3, r4, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0075 }
        java.lang.String r14 = "com.tencent.xg.trydyload_api.TryDyLoader"
        java.lang.Class r14 = java.lang.Class.forName(r14)     // Catch:{ all -> 0x0075 }
        java.lang.String r15 = "getInstance"
        r1 = 1
        java.lang.Class[] r2 = new java.lang.Class[r1]     // Catch:{ all -> 0x0075 }
        java.lang.Class<android.content.Context> r3 = android.content.Context.class
        r4 = 0
        r2[r4] = r3     // Catch:{ all -> 0x0075 }
        java.lang.reflect.Method r15 = r14.getMethod(r15, r2)     // Catch:{ all -> 0x0075 }
        r2 = 0
        java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ all -> 0x0075 }
        r3[r4] = r13     // Catch:{ all -> 0x0075 }
        java.lang.Object r15 = r15.invoke(r2, r3)     // Catch:{ all -> 0x0075 }
        java.lang.String r2 = "doSomething"
        java.lang.Class[] r3 = new java.lang.Class[r1]     // Catch:{ all -> 0x0075 }
        java.lang.Class<java.lang.String> r5 = java.lang.String.class
        r3[r4] = r5     // Catch:{ all -> 0x0075 }
        java.lang.reflect.Method r14 = r14.getMethod(r2, r3)     // Catch:{ all -> 0x0075 }
        java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0075 }
        java.lang.String r2 = "XGPushManager register"
        r1[r4] = r2     // Catch:{ all -> 0x0075 }
        r14.invoke(r15, r1)     // Catch:{ all -> 0x0075 }
        long r6 = com.tencent.android.tpush.XGPushConfig.getAccessId(r13)     // Catch:{ all -> 0x0075 }
        java.lang.String r8 = "ptTry"
        java.lang.String r9 = "parsePatch"
        r10 = 0
        java.lang.String r11 = "XGPushManager loaded"
        r12 = 0
        r5 = r13
        com.tencent.android.tpush.stat.XGPatchMonitor.onConfigAction(r5, r6, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x0075 }
        goto L_0x0090
    L_0x0075:
        r14 = move-exception
        java.lang.String r15 = "xiangchen"
        java.lang.String r14 = r14.getMessage()     // Catch:{ all -> 0x0092 }
        com.tencent.android.tpush.p580b.C6864a.m29298c(r15, r14)     // Catch:{ all -> 0x0092 }
        long r2 = com.tencent.android.tpush.XGPushConfig.getAccessId(r13)     // Catch:{ all -> 0x0092 }
        java.lang.String r4 = "ptTry"
        java.lang.String r5 = "parsePatch"
        r6 = 1801(0x709, float:2.524E-42)
        java.lang.String r7 = "XGPushManager load failed"
        r8 = 0
        r1 = r13
        com.tencent.android.tpush.stat.XGPatchMonitor.onConfigAction(r1, r2, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0092 }
    L_0x0090:
        monitor-exit(r0)
        return
    L_0x0092:
        r13 = move-exception
        monitor-exit(r0)
        throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.XGPushManager.m29239c(android.content.Context, android.content.Intent, com.tencent.android.tpush.XGIOperateCallback):void");
    }

    /* access modifiers changed from: private|static */
    /* renamed from: d */
    public static void m29240d(Context context, Intent intent, final XGIOperateCallback xGIOperateCallback) {
        try {
            context.registerReceiver(new BroadcastReceiver() {
                public void onReceive(final Context context, Intent intent) {
                    C6914l.m29513a(context, (BroadcastReceiver) this);
                    if ((C6913k.m29501a(context).mo33121c() && XGPushConfig.isUsedFcmPush(context)) || (XGPushConfig.isUsedOtherPush(context) && C6927d.m29569a(context).mo33132a())) {
                        try {
                            C6901c.m29459a().mo33104a((Runnable) new Runnable() {
                                public void run() {
                                    try {
                                        C6927d.m29569a(context).mo33134c();
                                    } catch (Throwable unused) {
                                    }
                                }
                            });
                        } catch (Exception unused) {
                        }
                    }
                    if (xGIOperateCallback != null) {
                        try {
                            C6901c a = C6901c.m29459a();
                            C6853a aVar = new C6853a(xGIOperateCallback, context, intent, 1, 1);
                            a.mo33104a((Runnable) aVar);
                        } catch (Exception unused2) {
                        }
                    }
                }
            }, new IntentFilter("com.tencent.android.tpush.action.UNREGISTER.RESULT.V4"));
            context.sendBroadcast(intent);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    private static String m29225a(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == 12) {
                sb.append("\\f");
            } else if (charAt != 13) {
                if (charAt != '\"' && charAt != '/' && charAt != '\\') {
                    switch (charAt) {
                        case 8:
                            sb.append("\\b");
                            break;
                        case 9:
                            sb.append("\\t");
                            break;
                        case 10:
                            sb.append("\\n");
                            break;
                        default:
                            if (charAt > 31) {
                                sb.append(charAt);
                                break;
                            } else {
                                sb.append(String.format("\\u%04x", new Object[]{Integer.valueOf(charAt)}));
                                break;
                            }
                    }
                } else {
                    sb.append('\\');
                    sb.append(charAt);
                }
            } else {
                sb.append("\\r");
            }
        }
        return sb.toString();
    }

    public static void openNotification(Context context) {
        C6914l.m29530k(context);
    }

    public static void openNotificationSettings(Context context) {
        C6914l.m29531l(context);
    }
}
