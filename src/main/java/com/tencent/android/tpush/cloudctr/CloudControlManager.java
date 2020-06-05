package com.tencent.android.tpush.cloudctr;

import android.content.Context;
import android.util.Log;
import androidx.core.p003os.EnvironmentCompat;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.cloudctr.network.C6894a;
import com.tencent.android.tpush.cloudctr.network.CloudControlDownloadService;
import com.tencent.android.tpush.cloudctr.network.DownloadItem;
import com.tencent.android.tpush.cloudctr.p582a.C6887a;
import com.tencent.android.tpush.cloudctr.p582a.C6888b;
import com.tencent.android.tpush.cloudctr.p583b.C6889a;
import com.tencent.android.tpush.cloudctr.p583b.C6891c;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.stat.XGPatchMonitor;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.io.File;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class CloudControlManager {
    /* renamed from: e */
    private static CloudControlManager f22926e = new CloudControlManager();
    /* renamed from: a */
    private C6891c f22927a = new C6891c("cloud control cmd thread");
    /* access modifiers changed from: private */
    /* renamed from: b */
    public ConcurrentMap<String, ICloudControlDispatcher> f22928b = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    /* renamed from: c */
    public C6894a f22929c = new C6894a(this.f22930d);
    /* access modifiers changed from: private */
    /* renamed from: d */
    public C6887a f22930d = new C6887a();

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.android.tpush.cloudctr.CloudControlManager$ICloudControlDispatcher */
    public interface ICloudControlDispatcher {

        /* compiled from: ProGuard */
        /* renamed from: com.tencent.android.tpush.cloudctr.CloudControlManager$ICloudControlDispatcher$DownloadStatus */
        public enum DownloadStatus {
            Start,
            Success,
            Error
        }

        /* compiled from: ProGuard */
        /* renamed from: com.tencent.android.tpush.cloudctr.CloudControlManager$ICloudControlDispatcher$ErrorResponse */
        public static final class ErrorResponse {
            /* access modifiers changed from: private */
            /* renamed from: a */
            public Response f22946a = Response.Cancel;

            /* compiled from: ProGuard */
            /* renamed from: com.tencent.android.tpush.cloudctr.CloudControlManager$ICloudControlDispatcher$ErrorResponse$Response */
            enum Response {
                Retry,
                Cancel
            }

            ErrorResponse() {
            }
        }

        /* renamed from: a */
        void mo32899a(String str);

        /* renamed from: a */
        void mo32900a(String str, String str2, String str3, DownloadStatus downloadStatus, ErrorResponse errorResponse);
    }

    private CloudControlManager() {
    }

    /* renamed from: a */
    public static CloudControlManager m29396a() {
        return f22926e;
    }

    /* renamed from: a */
    public void mo33062a(Context context, String str, String str2, ICloudControlDispatcher iCloudControlDispatcher) {
        final Context applicationContext = context.getApplicationContext();
        C6891c cVar = this.f22927a;
        final ICloudControlDispatcher iCloudControlDispatcher2 = iCloudControlDispatcher;
        final String str3 = str2;
        final String str4 = str;
        C68831 r0 = new Runnable() {
            public void run() {
                String str = "CloudControlManager";
                try {
                    if (iCloudControlDispatcher2 != null) {
                        String str2 = str3;
                        if (str3 == null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(applicationContext.getFilesDir().getAbsolutePath());
                            sb.append(File.separator);
                            sb.append(".mta");
                            sb.append(File.separator);
                            sb.append("cc");
                            str2 = sb.toString();
                        }
                        if (CloudControlManager.this.f22928b.containsKey(str4)) {
                            C6864a.m29298c(str, "business code already registered, this might be a bug");
                            return;
                        }
                        CloudControlManager.this.f22928b.put(str4, iCloudControlDispatcher2);
                        CloudControlManager.this.f22930d.mo33073a(str4, str2);
                        CloudControlManager.this.f22929c.mo33095a(applicationContext, str4, CloudControlManager.this.f22930d.mo33067a(applicationContext, str4));
                        CloudControlManager.this.m29400b(applicationContext, str4);
                    }
                } catch (Exception e) {
                    C6864a.m29308i(str, e.toString());
                }
            }
        };
        cVar.mo33077a(r0);
    }

    /* renamed from: a */
    public void mo33060a(final Context context, final DownloadItem downloadItem, final boolean z) {
        this.f22927a.mo33077a(new Runnable() {
            public void run() {
                String str = "CloudControlManager";
                try {
                    String businessCode = downloadItem.getBusinessCode();
                    String fileName = downloadItem.getFileName();
                    String downloadSavedDir = downloadItem.getDownloadSavedDir();
                    ICloudControlDispatcher iCloudControlDispatcher = (ICloudControlDispatcher) CloudControlManager.this.f22928b.get(businessCode);
                    if (iCloudControlDispatcher != null) {
                        String str2 = "md5";
                        String str3 = "from cache";
                        String str4 = "downloadUrl";
                        String str5 = "fileName";
                        if (downloadItem.isDownloadSucceed()) {
                            String c = CloudControlManager.this.f22930d.mo33075c(context, businessCode);
                            if (c != null) {
                                try {
                                    JSONObject jSONObject = new JSONObject(c);
                                    jSONObject.remove(downloadItem.getMd5());
                                    CloudControlManager.this.f22930d.mo33072a(context, businessCode, jSONObject.toString());
                                } catch (Exception unused) {
                                    C6864a.m29308i(str, "read download info error");
                                }
                                if (!z) {
                                    C6888b.m29425a(context, new File(downloadSavedDir, fileName));
                                }
                                iCloudControlDispatcher.mo32900a(fileName, downloadSavedDir, downloadItem.getMd5(), DownloadStatus.Success, null);
                                Properties properties = new Properties();
                                properties.put(str5, fileName);
                                if (downloadItem.getDownloadUrl() == null) {
                                    str3 = downloadItem.getDownloadUrl();
                                }
                                properties.put(str4, str3);
                                properties.put(str2, downloadItem.getMd5());
                                XGPatchMonitor.onConfigAction(context, XGPushConfig.getAccessId(context), businessCode, XGPatchMonitor.ActionVerifyFile, 0, "finish download file", properties);
                            }
                        } else {
                            ErrorResponse errorResponse = new ErrorResponse();
                            iCloudControlDispatcher.mo32900a(fileName, null, downloadItem.getMd5(), DownloadStatus.Error, errorResponse);
                            if (errorResponse.f22946a == Response.Retry) {
                                CloudControlDownloadService.m29447a(context, downloadItem);
                            }
                            Properties properties2 = new Properties();
                            properties2.put(str5, fileName);
                            if (downloadItem.getDownloadUrl() == null) {
                                str3 = downloadItem.getDownloadUrl();
                            }
                            properties2.put(str4, str3);
                            properties2.put(str2, downloadItem.getMd5());
                            XGPatchMonitor.onConfigAction(context, XGPushConfig.getAccessId(context), businessCode, XGPatchMonitor.ActionVerifyFile, 1, "download file error", properties2);
                        }
                    }
                } catch (Exception e) {
                    C6864a.m29308i(str, e.toString());
                }
            }
        });
    }

    /* renamed from: a */
    public void mo33061a(Context context, final String str) {
        if (context != null) {
            final Context applicationContext = context.getApplicationContext();
            this.f22927a.mo33077a(new Runnable() {
                public void run() {
                    String str = "md5";
                    String str2 = "conf";
                    String str3 = "file";
                    String str4 = "cccfgver";
                    String str5 = "ccver";
                    String str6 = "CloudControlManager";
                    try {
                        StringBuilder sb = new StringBuilder();
                        sb.append("receive config: ");
                        sb.append(str);
                        Log.d(str6, sb.toString());
                        JSONObject jSONObject = new JSONObject(str);
                        String string = jSONObject.getString("ccbuscode");
                        if (string == null) {
                            XGPatchMonitor.onConfigAction(applicationContext, XGPushConfig.getAccessId(applicationContext), EnvironmentCompat.MEDIA_UNKNOWN, XGPatchMonitor.ActionParseConfig, 1, "missing business code", null);
                        } else if (!jSONObject.has(str5)) {
                            XGPatchMonitor.onConfigAction(applicationContext, XGPushConfig.getAccessId(applicationContext), string, XGPatchMonitor.ActionParseConfig, 1, "missing protocol ver", null);
                        } else if (1 != jSONObject.getInt(str5)) {
                            XGPatchMonitor.onConfigAction(applicationContext, XGPushConfig.getAccessId(applicationContext), string, XGPatchMonitor.ActionParseConfig, 1, "protocol ver not supported", null);
                        } else {
                            ICloudControlDispatcher iCloudControlDispatcher = (ICloudControlDispatcher) CloudControlManager.this.f22928b.get(string);
                            if (iCloudControlDispatcher != null) {
                                if (!jSONObject.has(str4)) {
                                    XGPatchMonitor.onConfigAction(applicationContext, XGPushConfig.getAccessId(applicationContext), string, XGPatchMonitor.ActionParseConfig, 1, "missing server conf ver", null);
                                    return;
                                }
                                XGPatchMonitor.onConfigAction(applicationContext, XGPushConfig.getAccessId(applicationContext), string, XGPatchMonitor.ActionParseConfig, 0, "json format ok", null);
                                long a = CloudControlManager.this.f22930d.mo33067a(applicationContext, string);
                                long j = jSONObject.getLong(str4);
                                int i = (j > a ? 1 : (j == a ? 0 : -1));
                                if (i != 0) {
                                    XGPatchMonitor.onConfigAction(applicationContext, XGPushConfig.getAccessId(applicationContext), string, XGPatchMonitor.ActionLoadConfig, 0, "start load config", null);
                                    if (i < 0) {
                                        C6864a.m29308i(str6, "服务器配置版本小于本地配置版本，如果你最近切换了 appkey，则这是正常现象");
                                    }
                                    CloudControlManager.this.f22930d.mo33074b(applicationContext, string);
                                    CloudControlManager.this.f22930d.mo33071a(applicationContext, string, j, true);
                                    JSONObject jSONObject2 = jSONObject.getJSONObject("cccfg");
                                    if (jSONObject2.has(str3)) {
                                        JSONArray jSONArray = jSONObject2.getJSONArray(str3);
                                        if (jSONArray != null) {
                                            XGPatchMonitor.onConfigAction(applicationContext, XGPushConfig.getAccessId(applicationContext), string, XGPatchMonitor.ActionRequestFile, 0, jSONArray.toString(), null);
                                            JSONObject jSONObject3 = new JSONObject();
                                            int length = jSONArray.length();
                                            for (int i2 = 0; i2 < length; i2++) {
                                                JSONObject jSONObject4 = jSONArray.getJSONObject(i2);
                                                String string2 = jSONObject4.getString("url_type");
                                                if (string2 != null) {
                                                    if (string2.equalsIgnoreCase("http") || string2.equalsIgnoreCase("https")) {
                                                        if (jSONObject4.has("url") && jSONObject4.has(ArgKey.KEY_NAME)) {
                                                            if (jSONObject4.has(str)) {
                                                                String string3 = jSONObject4.getString(str);
                                                                if (string3 != null) {
                                                                    jSONObject4.put("download_finish", false);
                                                                    jSONObject3.put(string3, jSONObject4);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            CloudControlManager.this.f22930d.mo33072a(applicationContext, string, jSONObject3.toString());
                                            CloudControlManager.this.m29400b(applicationContext, string);
                                        }
                                    }
                                    if (jSONObject2.has(str2)) {
                                        JSONObject jSONObject5 = jSONObject2.getJSONObject(str2);
                                        if (jSONObject5 != null) {
                                            iCloudControlDispatcher.mo32899a(jSONObject5.toString());
                                        }
                                    }
                                } else {
                                    CloudControlManager.this.m29400b(applicationContext, string);
                                }
                            }
                        }
                    } catch (JSONException unused) {
                        C6864a.m29308i(str6, "parse json conf error");
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m29400b(final Context context, final String str) {
        this.f22927a.mo33077a(new Runnable() {
            public void run() {
                String str = "CloudControlManager";
                try {
                    String c = CloudControlManager.this.f22930d.mo33075c(context, str);
                    if (c != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("download info: ");
                        sb.append(c);
                        Log.d(str, sb.toString());
                        try {
                            JSONObject jSONObject = new JSONObject(c);
                            Iterator keys = jSONObject.keys();
                            while (keys.hasNext()) {
                                String str2 = (String) keys.next();
                                JSONObject jSONObject2 = jSONObject.getJSONObject(str2);
                                String string = jSONObject2.getString("url");
                                String string2 = jSONObject2.getString(ArgKey.KEY_NAME);
                                String d = CloudControlManager.this.f22930d.mo33076d(context, str);
                                if (!(string == null || string2 == null || str2 == null)) {
                                    if (d != null) {
                                        String a = C6888b.m29423a(context, string2, str2);
                                        if (a != null) {
                                            C6889a.m29429a(new File(a), new File(d, string2));
                                            DownloadItem downloadItem = new DownloadItem();
                                            downloadItem.setMd5(str2);
                                            downloadItem.setDownloadUrl(string);
                                            downloadItem.setDownloadSavedDir(d);
                                            downloadItem.setFileName(string2);
                                            downloadItem.setBusinessCode(str);
                                            downloadItem.setDownloadSucceed(true);
                                            CloudControlManager.this.mo33060a(context, downloadItem, true);
                                            StringBuilder sb2 = new StringBuilder();
                                            sb2.append("use file in public cache: ");
                                            sb2.append(string2);
                                            Log.d(str, sb2.toString());
                                            return;
                                        }
                                        Properties properties = new Properties();
                                        properties.put("fileName", string2);
                                        properties.put("downloadUrl", string);
                                        properties.put("md5", str2);
                                        XGPatchMonitor.onConfigAction(context, XGPushConfig.getAccessId(context), str, XGPatchMonitor.ActionDownloadFile, 0, "start download file", properties);
                                        CloudControlDownloadService.m29448a(context, string, string2, d, str, str2);
                                    }
                                }
                            }
                        } catch (JSONException unused) {
                            C6864a.m29308i(str, "get download info error");
                            CloudControlManager.this.f22930d.mo33074b(context, str);
                        }
                    }
                } catch (Exception e) {
                    C6864a.m29308i(str, e.toString());
                }
            }
        });
    }
}
