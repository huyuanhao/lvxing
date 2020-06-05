package com.p522qq.p523e.comm.services;

import android.content.Context;
import android.os.Build;
import com.p522qq.p523e.comm.constants.Constants.KEYS;
import com.p522qq.p523e.comm.managers.GDTADManager;
import com.p522qq.p523e.comm.managers.plugin.C6413PM;
import com.p522qq.p523e.comm.managers.plugin.C6422c;
import com.p522qq.p523e.comm.managers.setting.C6424SM;
import com.p522qq.p523e.comm.managers.status.APPStatus;
import com.p522qq.p523e.comm.managers.status.DeviceStatus;
import com.p522qq.p523e.comm.net.C6432a;
import com.p522qq.p523e.comm.net.NetworkCallBack;
import com.p522qq.p523e.comm.net.NetworkClient.Priority;
import com.p522qq.p523e.comm.net.NetworkClientImpl;
import com.p522qq.p523e.comm.net.p524rr.Request;
import com.p522qq.p523e.comm.net.p524rr.Response;
import com.p522qq.p523e.comm.net.p524rr.S2SSRequest;
import com.p522qq.p523e.comm.services.RetCodeService.RetCodeInfo;
import com.p522qq.p523e.comm.util.GDTLogger;
import com.p522qq.p523e.comm.util.StringUtil;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.qq.e.comm.services.a */
public class C6437a {
    /* renamed from: a */
    private static final C6437a f20313a = new C6437a();
    /* renamed from: b */
    private volatile Boolean f20314b = Boolean.FALSE;

    /* renamed from: a */
    public static C6437a m25254a() {
        return f20313a;
    }

    /* renamed from: a */
    private static String m25255a(C6424SM sm, C6413PM pm, DeviceStatus deviceStatus, APPStatus aPPStatus, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject = C6432a.m25242a(sm);
            String str = "sig";
            JSONObject jSONObject2 = new JSONObject();
            String str2 = "sdk";
            String str3 = "app";
            if (sm != null) {
                jSONObject2.putOpt(str3, sm.getDevCloudSettingSig());
                jSONObject2.putOpt(str2, sm.getSdkCloudSettingSig());
            }
            if (pm != null) {
                jSONObject2.putOpt("jar", pm.getLocalSig());
                jSONObject2.putOpt(KEYS.PLUGIN_VERSION, Integer.valueOf(pm.getPluginVersion()));
            }
            jSONObject.put(str, jSONObject2);
            String str4 = "dev";
            JSONObject jSONObject3 = new JSONObject();
            if (deviceStatus != null) {
                jSONObject3.putOpt("did", deviceStatus.getPlainDid());
                jSONObject3.putOpt("md", deviceStatus.model);
                jSONObject3.putOpt("lg", deviceStatus.getLanguage());
                jSONObject3.putOpt("w", Integer.valueOf(deviceStatus.getDeviceWidth()));
                jSONObject3.putOpt("h", Integer.valueOf(deviceStatus.getDeviceHeight()));
                jSONObject3.putOpt("dd", Integer.valueOf(deviceStatus.getDeviceDensity()));
                jSONObject3.putOpt("apil", Integer.valueOf(deviceStatus.getVersion()));
                jSONObject3.putOpt("os", "android");
                jSONObject3.putOpt("op", deviceStatus.getOperator());
                jSONObject3.putOpt("mf", Build.MANUFACTURER);
            }
            jSONObject.put(str4, jSONObject3);
            jSONObject.put(str3, C6432a.m25243a(aPPStatus));
            jSONObject.put("c", C6432a.m25244a(deviceStatus));
            jSONObject.put(str2, C6432a.m25241a(pm));
            JSONObject jSONObject4 = new JSONObject();
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("sdk_init_time", (System.nanoTime() - j) / 1000000);
            jSONObject4.put("performance", jSONObject5);
            jSONObject.put(KEYS.BIZ, jSONObject4);
        } catch (JSONException e) {
            GDTLogger.m25261e("JSONException while build init req", e);
        }
        return jSONObject.toString();
    }

    /* renamed from: a */
    public static void m25256a(String str, Throwable th) {
        String str2 = "\r";
        if (GDTADManager.getInstance() == null || !GDTADManager.getInstance().isInitialized()) {
            GDTLogger.m25263w("Report Not Work while  ADManager  not Inited");
            return;
        }
        try {
            JSONObject a = C6432a.m25242a(GDTADManager.getInstance().getSM());
            a.put("c", C6432a.m25244a(GDTADManager.getInstance().getDeviceStatus()));
            a.put("app", C6432a.m25243a(GDTADManager.getInstance().getAppStatus()));
            HashMap hashMap = new HashMap();
            String str3 = "extype";
            if (th != null) {
                hashMap.put(str3, th.getClass().getName());
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(str2);
                sb.append(th.getMessage());
                sb.append(str2);
                sb.append(Arrays.toString(th.getStackTrace()));
                hashMap.put("ext", sb.toString());
            } else {
                hashMap.put(str3, "");
                hashMap.put("ex", str);
            }
            a.put(KEYS.BIZ, new JSONObject(hashMap));
            NetworkClientImpl.getInstance().submit(new S2SSRequest("http://sdk.e.qq.com/err", a.toString().getBytes(Charset.forName("UTF-8"))));
        } catch (Throwable th2) {
            GDTLogger.m25264w("Exception While build s2ss error report req", th2);
        }
    }

    /* renamed from: a */
    public final void mo30389a(Context context, C6424SM sm, final C6413PM pm, DeviceStatus deviceStatus, APPStatus aPPStatus, long j) {
        if (!this.f20314b.booleanValue()) {
            synchronized (C6437a.class) {
                if (!this.f20314b.booleanValue()) {
                    String a = m25255a(sm, pm, deviceStatus, aPPStatus, j);
                    StringBuilder sb = new StringBuilder("launch request: ");
                    sb.append(a);
                    GDTLogger.m25258d(sb.toString());
                    String str = "http://sdk.e.qq.com/activate";
                    if (!StringUtil.isEmpty(sm.getSuid())) {
                        str = "http://sdk.e.qq.com/launch";
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    C64381 r3 = new NetworkCallBack() {
                        public final void onException(Exception exc) {
                            GDTLogger.m25261e("ActivateError", exc);
                            RetCodeService instance = RetCodeService.getInstance();
                            RetCodeInfo retCodeInfo = new RetCodeInfo("sdk.e.qq.com", "launch", "", -1, (int) (System.currentTimeMillis() - currentTimeMillis), 0, 0, 1);
                            instance.send(retCodeInfo);
                        }

                        public final void onResponse(Request request, Response response) {
                            RetCodeService instance;
                            RetCodeInfo retCodeInfo;
                            String sb;
                            String str = "url";
                            String str2 = "jar";
                            String str3 = "sig";
                            String str4 = KEYS.RET;
                            try {
                                if (response.getStatusCode() == 200) {
                                    String stringContent = response.getStringContent();
                                    StringBuilder sb2 = new StringBuilder("ACTIVERESPONSE:");
                                    sb2.append(stringContent);
                                    GDTLogger.m25258d(sb2.toString());
                                    if (StringUtil.isEmpty(stringContent)) {
                                        GDTLogger.report("SDK Server response empty string,maybe zip or tea format error");
                                        instance = RetCodeService.getInstance();
                                        retCodeInfo = new RetCodeInfo("sdk.e.qq.com", "launch", "", response.getStatusCode(), (int) (System.currentTimeMillis() - currentTimeMillis), 0, 0, 1);
                                        instance.send(retCodeInfo);
                                    }
                                    JSONObject jSONObject = new JSONObject(stringContent);
                                    int i = -1;
                                    if (jSONObject.has(str4)) {
                                        i = jSONObject.getInt(str4);
                                    }
                                    if (i != 0) {
                                        StringBuilder sb3 = new StringBuilder("Response Error,retCode=");
                                        sb3.append(i);
                                        sb = sb3.toString();
                                    } else {
                                        if (pm != null) {
                                            try {
                                                pm.getPOFactory().config(1, stringContent);
                                            } catch (C6422c e) {
                                                e.printStackTrace();
                                            }
                                            if (jSONObject.has(str3)) {
                                                JSONObject jSONObject2 = jSONObject.getJSONObject(str3);
                                                if (jSONObject2.has(str2) && jSONObject2.has(str)) {
                                                    pm.update(jSONObject2.getString(str2), jSONObject2.getString(str));
                                                }
                                            }
                                        }
                                        instance = RetCodeService.getInstance();
                                        retCodeInfo = new RetCodeInfo("sdk.e.qq.com", "launch", "", response.getStatusCode(), (int) (System.currentTimeMillis() - currentTimeMillis), 0, 0, 1);
                                        instance.send(retCodeInfo);
                                    }
                                } else {
                                    StringBuilder sb4 = new StringBuilder("SDK server response code error while launch or activate,code:");
                                    sb4.append(response.getStatusCode());
                                    sb = sb4.toString();
                                }
                                GDTLogger.m25260e(sb);
                                instance = RetCodeService.getInstance();
                                retCodeInfo = new RetCodeInfo("sdk.e.qq.com", "launch", "", response.getStatusCode(), (int) (System.currentTimeMillis() - currentTimeMillis), 0, 0, 1);
                            } catch (IOException e2) {
                                GDTLogger.m25261e("ActivateError", e2);
                                instance = RetCodeService.getInstance();
                                retCodeInfo = new RetCodeInfo("sdk.e.qq.com", "launch", "", response.getStatusCode(), (int) (System.currentTimeMillis() - currentTimeMillis), 0, 0, 1);
                            } catch (JSONException e3) {
                                GDTLogger.m25261e("Parse Active or launch response exception", e3);
                                instance = RetCodeService.getInstance();
                                retCodeInfo = new RetCodeInfo("sdk.e.qq.com", "launch", "", response.getStatusCode(), (int) (System.currentTimeMillis() - currentTimeMillis), 0, 0, 1);
                            } catch (Throwable th) {
                                RetCodeService instance2 = RetCodeService.getInstance();
                                RetCodeInfo retCodeInfo2 = new RetCodeInfo("sdk.e.qq.com", "launch", "", response.getStatusCode(), (int) (System.currentTimeMillis() - currentTimeMillis), 0, 0, 1);
                                instance2.send(retCodeInfo2);
                                throw th;
                            }
                            instance.send(retCodeInfo);
                        }
                    };
                    NetworkClientImpl.getInstance().submit(new S2SSRequest(str, a.getBytes(Charset.forName("UTF-8"))), Priority.High, r3);
                    this.f20314b = Boolean.TRUE;
                }
            }
        }
    }
}
