package com.tencent.android.tpush.service;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import androidx.core.app.NotificationCompat;
import com.p522qq.taf.jce.JceStruct;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.common.C6908h;
import com.tencent.android.tpush.common.C6914l;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.data.MessageId;
import com.tencent.android.tpush.data.RegisterEntity;
import com.tencent.android.tpush.encrypt.C6931a;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.horse.DefaultServer;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.android.tpush.service.channel.C7000a;
import com.tencent.android.tpush.service.channel.C7005b;
import com.tencent.android.tpush.service.channel.C7030c;
import com.tencent.android.tpush.service.channel.C7030c.C7031a;
import com.tencent.android.tpush.service.channel.exception.ChannelException;
import com.tencent.android.tpush.service.channel.protocol.AppInfo;
import com.tencent.android.tpush.service.channel.protocol.DeviceInfo;
import com.tencent.android.tpush.service.channel.protocol.MutableInfo;
import com.tencent.android.tpush.service.channel.protocol.NetworkInfo;
import com.tencent.android.tpush.service.channel.protocol.TpnsClickClientReport;
import com.tencent.android.tpush.service.channel.protocol.TpnsConfigReq;
import com.tencent.android.tpush.service.channel.protocol.TpnsConfigRsp;
import com.tencent.android.tpush.service.channel.protocol.TpnsGetApListReq;
import com.tencent.android.tpush.service.channel.protocol.TpnsGetApListRsp;
import com.tencent.android.tpush.service.channel.protocol.TpnsPushClickReq;
import com.tencent.android.tpush.service.channel.protocol.TpnsPushClientReport;
import com.tencent.android.tpush.service.channel.protocol.TpnsPushClientReq;
import com.tencent.android.tpush.service.channel.protocol.TpnsPushCommReportReq;
import com.tencent.android.tpush.service.channel.protocol.TpnsPushVerifyReq;
import com.tencent.android.tpush.service.channel.protocol.TpnsReconnectReq;
import com.tencent.android.tpush.service.channel.protocol.TpnsReconnectRsp;
import com.tencent.android.tpush.service.channel.protocol.TpnsRegisterReq;
import com.tencent.android.tpush.service.channel.protocol.TpnsTokenTagReq;
import com.tencent.android.tpush.service.channel.protocol.TpnsUnregisterReq;
import com.tencent.android.tpush.service.channel.protocol.TpnsUpdateTokenReq;
import com.tencent.android.tpush.service.channel.protocol.UnregInfo;
import com.tencent.android.tpush.service.channel.security.TpnsSecurity;
import com.tencent.android.tpush.service.p588a.C6971a;
import com.tencent.android.tpush.service.p590c.C6987a;
import com.tencent.android.tpush.service.p595e.C7050c;
import com.tencent.android.tpush.service.p595e.C7053f;
import com.tencent.android.tpush.service.p595e.C7056i;
import com.tencent.android.tpush.stat.p597b.C7074c;
import com.tencent.bigdata.dataacquisition.CustomDeviceInfos;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import com.tencent.mid.api.MidService;
import com.tencent.mid.sotrage.StorageInterface;
import com.tencent.p605ep.commonbase.software.AppEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Marker;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.service.c */
public class C6982c {
    /* renamed from: a */
    private static C6982c f23194a = new C6982c();
    /* renamed from: b */
    private static JSONArray f23195b = new JSONArray();
    /* renamed from: c */
    private static final String f23196c = C6931a.m29598a("com.tencent.tpush.last_wifi_ts");
    /* renamed from: d */
    private C7031a f23197d = new C7031a() {
        /* renamed from: a */
        public void mo33270a(JceStruct jceStruct, C7000a aVar) {
        }

        /* renamed from: a */
        public void mo33271a(JceStruct jceStruct, ChannelException channelException, C7000a aVar) {
        }

        /* renamed from: a */
        public void mo33269a(JceStruct jceStruct, int i, JceStruct jceStruct2, C7000a aVar) {
            StringBuilder sb = new StringBuilder();
            sb.append("reconnCallback onResponse request:");
            sb.append(jceStruct);
            sb.append(", responseCode:");
            sb.append(i);
            sb.append(", response:");
            sb.append(jceStruct2);
            String str = "PushServiceNetworkHandler";
            C6864a.m29298c(str, sb.toString());
            if (i == 0) {
                if (jceStruct != null) {
                    TpnsReconnectReq tpnsReconnectReq = (TpnsReconnectReq) jceStruct;
                    C6864a.m29284a(7, (List<TpnsPushClientReport>) tpnsReconnectReq.recvMsgList);
                    CacheManager.updateUnregUninList(C6973b.m29776f(), tpnsReconnectReq.unregInfoList);
                    C6987a.m29846a().mo33351d(C6973b.m29776f(), (List<TpnsPushClientReport>) tpnsReconnectReq.recvMsgList);
                    C6987a.m29846a().mo33342b(C6973b.m29776f(), tpnsReconnectReq.msgClickList);
                }
                TpnsReconnectRsp tpnsReconnectRsp = (TpnsReconnectRsp) jceStruct2;
                if (!(tpnsReconnectRsp == null || tpnsReconnectRsp.appOfflinePushMsgList == null || tpnsReconnectRsp.appOfflinePushMsgList.size() <= 0)) {
                    C6987a.m29846a().mo33336a(tpnsReconnectRsp.appOfflinePushMsgList, tpnsReconnectRsp.timeUs, aVar);
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("reconnCallback onResponse rsp==null?:");
                sb2.append(tpnsReconnectRsp == null);
                C6864a.m29298c(str, sb2.toString());
                if (tpnsReconnectRsp != null) {
                    C6982c.this.mo33320a(aVar.mo33363b(), tpnsReconnectRsp.confVersion);
                    return;
                }
                return;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append(">> reconn failed responseCode=");
            sb3.append(i);
            C6864a.m29308i(str, sb3.toString());
        }
    };

    /* renamed from: a */
    public static byte m29814a(boolean z) {
        return z ? (byte) 1 : 0;
    }

    /* renamed from: a */
    public static C6982c m29815a() {
        return f23194a;
    }

    /* renamed from: a */
    public void mo33316a(JceStruct jceStruct, C7000a aVar) {
        if (jceStruct != null) {
            if (jceStruct instanceof TpnsPushClientReq) {
                TpnsPushClientReq tpnsPushClientReq = (TpnsPushClientReq) jceStruct;
                C6987a.m29846a().mo33336a(tpnsPushClientReq.msgList, tpnsPushClientReq.timeUs, aVar);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("onReceivedServicePush unhandle message type");
                sb.append(jceStruct.getClass().getName());
                C6864a.m29308i("PushServiceNetworkHandler", sb.toString());
            }
        }
    }

    /* renamed from: b */
    public C7030c mo33321b() {
        String str = "PushServiceNetworkHandler";
        if (!C7056i.m30216j(C6973b.m29776f())) {
            C6864a.m29308i(str, ">> no app registered!");
            return null;
        }
        TpnsReconnectReq tpnsReconnectReq = new TpnsReconnectReq();
        tpnsReconnectReq.deviceId = C7050c.m30146a();
        tpnsReconnectReq.networkType = (short) DeviceInfos.getNetworkType(C6973b.m29776f());
        tpnsReconnectReq.token = CacheManager.getToken(C6973b.m29776f());
        tpnsReconnectReq.unregInfoList = CacheManager.getUninstallAndUnregisterInfo(C6973b.m29776f());
        tpnsReconnectReq.recvMsgList = C6987a.m29846a().mo33345c(C6973b.m29776f(), (List<MessageId>) C6987a.m29846a().mo33337b(C6973b.m29776f()));
        tpnsReconnectReq.msgClickList = C6987a.m29846a().mo33323a(C6973b.m29776f());
        tpnsReconnectReq.sdkVersion = String.valueOf(4.03f);
        tpnsReconnectReq.connVersion = 4;
        tpnsReconnectReq.guid = CacheManager.getGuid(C6973b.m29776f());
        tpnsReconnectReq.configVersion = (long) C6908h.m29480a(C6973b.m29776f(), "GroupKeysConfigVersion", -1);
        Context f = C6973b.m29776f();
        MutableInfo mutableInfo = new MutableInfo();
        if (DeviceInfos.isNetworkAvailable(f) && DeviceInfos.isWifiNet(f)) {
            mutableInfo.bssid = CustomDeviceInfos.getWiFiBBSID(f);
            mutableInfo.ssid = CustomDeviceInfos.getWiFiSSID(f);
        }
        mutableInfo.mac = CustomDeviceInfos.getMacAddress(f);
        try {
            mutableInfo.wflist = m29821b(f);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append(">> getWifiList(");
            sb.append(f);
            sb.append(")");
            sb.append(e);
            C6864a.m29308i(str, sb.toString());
        }
        JSONObject jSONObject = new JSONObject();
        String newMid = MidService.getNewMid(f);
        if (newMid != null && newMid.trim().length() == 40) {
            try {
                jSONObject.put("new_mid", newMid);
                jSONObject.put("new_mid_v", String.valueOf(4.07f));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (jSONObject.length() > 0) {
            tpnsReconnectReq.reserved = jSONObject.toString();
        }
        tpnsReconnectReq.mutableInfo = mutableInfo;
        return new C7030c(tpnsReconnectReq, this.f23197d);
    }

    /* renamed from: b */
    private String m29821b(Context context) {
        int i;
        String str = "";
        if (context != null) {
            JSONArray wifiTopN = CustomDeviceInfos.getWifiTopN(context, 10);
            if (wifiTopN != null && wifiTopN.length() > 0) {
                long b = C7053f.m30157b(context, f23196c, 0);
                JSONArray jSONArray = f23195b;
                boolean z = false;
                if (jSONArray == null || jSONArray.length() <= 0) {
                    i = 0;
                } else if (f23195b.toString().equalsIgnoreCase(wifiTopN.toString())) {
                    return str;
                } else {
                    i = Math.abs(f23195b.length() - wifiTopN.length());
                }
                long currentTimeMillis = System.currentTimeMillis();
                if ((i >= 3) || Math.abs(currentTimeMillis - b) > 1800000) {
                    z = true;
                }
                if (z) {
                    C7053f.m30154a(context, f23196c, currentTimeMillis);
                    str = wifiTopN.toString();
                    f23195b = wifiTopN;
                }
            }
        }
        return str;
    }

    /* renamed from: a */
    public static DeviceInfo m29816a(Context context) {
        DeviceInfo deviceInfo = new DeviceInfo();
        StringBuilder sb = new StringBuilder();
        String str = "";
        sb.append(str);
        sb.append(C7056i.m30204e());
        deviceInfo.apiLevel = sb.toString();
        deviceInfo.imei = CustomDeviceInfos.getDeviceId(context);
        deviceInfo.model = DeviceInfos.getDeviceModel(context);
        deviceInfo.manu = Build.MANUFACTURER;
        deviceInfo.model = Build.MODEL;
        deviceInfo.network = DeviceInfos.getLinkedWay(context);
        deviceInfo.f23397os = "android";
        DisplayMetrics displayMetrics = DeviceInfos.getDisplayMetrics(context);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(displayMetrics.widthPixels);
        sb2.append(Marker.ANY_MARKER);
        sb2.append(displayMetrics.heightPixels);
        deviceInfo.resolution = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append(VERSION.SDK_INT);
        deviceInfo.apiLevel = sb3.toString();
        deviceInfo.sdCard = DeviceInfos.getExternalStorageInfo(context);
        deviceInfo.sdDouble = CustomDeviceInfos.getSimOperator(context);
        deviceInfo.sdkVersion = String.valueOf(4.03f);
        deviceInfo.sdkVersionName = VERSION.RELEASE;
        deviceInfo.isRooted = (long) DeviceInfos.hasRootAccess(context);
        deviceInfo.language = Locale.getDefault().getLanguage();
        deviceInfo.timezone = TimeZone.getDefault().getID();
        deviceInfo.launcherName = C7056i.m30220n(context);
        return deviceInfo;
    }

    /* renamed from: a */
    public void mo33314a(long j, String str, String str2, String str3, String str4, int i, String str5, String str6, String str7, long j2, String str8, String str9, String str10, long j3, long j4, int i2, C7031a aVar) {
        String str11;
        long j5 = j;
        String str12 = str2;
        String str13 = str3;
        String str14 = str4;
        int i3 = i;
        TpnsRegisterReq tpnsRegisterReq = new TpnsRegisterReq();
        tpnsRegisterReq.accessId = j5;
        tpnsRegisterReq.accessKey = str;
        tpnsRegisterReq.deviceId = str12;
        tpnsRegisterReq.appCert = str5;
        tpnsRegisterReq.account = str13;
        tpnsRegisterReq.ticket = str14;
        tpnsRegisterReq.ticketType = (short) i3;
        tpnsRegisterReq.deviceInfo = m29816a(C6973b.m29776f());
        tpnsRegisterReq.token = CacheManager.getToken(C6973b.m29776f());
        tpnsRegisterReq.version = 4;
        tpnsRegisterReq.appVersion = str6;
        tpnsRegisterReq.reserved = str7;
        tpnsRegisterReq.otherPushTokenType = j2;
        tpnsRegisterReq.otherPushToken = str10;
        tpnsRegisterReq.otherPushTokenOpType = j3;
        tpnsRegisterReq.channelId = j4;
        tpnsRegisterReq.accountType = (long) i2;
        if (!C6914l.m29521c(str8)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", str8);
                if (!C6914l.m29521c(str9)) {
                    jSONObject.put("payload", str9);
                }
            } catch (JSONException unused) {
            }
            tpnsRegisterReq.otherPushData = jSONObject.toString();
        }
        if (XGPushConfig.enableDebug) {
            StringBuilder sb = new StringBuilder();
            sb.append("Register(");
            sb.append(j);
            String str15 = StorageInterface.KEY_SPLITER;
            sb.append(str15);
            sb.append(str2);
            sb.append(str15);
            sb.append(str3);
            sb.append(str15);
            sb.append(str14);
            sb.append(str15);
            sb.append(i3);
            sb.append("),token: ");
            sb.append(tpnsRegisterReq.token);
            sb.append(",payload: ");
            sb.append(tpnsRegisterReq.otherPushData);
            sb.append(" channel id");
            sb.append(tpnsRegisterReq.channelId);
            C6864a.m29293b("PushServiceNetworkHandler", sb.toString());
        }
        int i4 = 0;
        tpnsRegisterReq.guid = CacheManager.getGuid(C6973b.m29776f());
        while (true) {
            str11 = "0";
            if (!str11.equals(CacheManager.getToken(C6973b.m29776f())) || C7074c.m30318a()) {
                break;
            }
            int i5 = i4 + 1;
            if (i4 >= 8) {
                break;
            }
            try {
                Thread.sleep(500);
            } catch (Exception unused2) {
            }
            i4 = i5;
        }
        tpnsRegisterReq.token = CacheManager.getToken(C6973b.m29776f());
        tpnsRegisterReq.guid = CacheManager.getGuid(C6973b.m29776f());
        C7005b.m29964a().mo33389a((JceStruct) tpnsRegisterReq, aVar);
        if (!str11.equals(CacheManager.getToken(C6973b.m29776f()))) {
            C7074c.m30321b();
        }
    }

    /* renamed from: a */
    public void mo33318a(String str, String str2, long j, String str3, String str4, C7031a aVar) {
        TpnsUnregisterReq tpnsUnregisterReq = new TpnsUnregisterReq();
        try {
            str4 = TpnsSecurity.getEncryptAPKSignature(C6973b.m29776f().createPackageContext(str4, 0));
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append(">> create context [for: ");
            sb.append(str4);
            sb.append("] fail.");
            C6864a.m29302d("PushServiceNetworkHandler", sb.toString(), e);
            str4 = "";
        }
        AppInfo appInfo = new AppInfo(j, str3, str4, 0);
        tpnsUnregisterReq.unregInfo = new UnregInfo(appInfo, 0, 0);
        C7005b.m29964a().mo33389a((JceStruct) tpnsUnregisterReq, aVar);
    }

    /* renamed from: a */
    public void mo33311a(long j) {
        C7005b.m29964a().mo33389a((JceStruct) new TpnsConfigReq(j), (C7031a) new C7031a() {
            /* renamed from: a */
            public void mo33270a(JceStruct jceStruct, C7000a aVar) {
            }

            /* renamed from: a */
            public void mo33269a(JceStruct jceStruct, int i, JceStruct jceStruct2, C7000a aVar) {
                if (i == 0) {
                    C6971a.m29749a(C6973b.m29776f()).mo33280a(((TpnsConfigRsp) jceStruct2).confContent);
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(">> loadConfig fail responseCode=");
                sb.append(i);
                C6864a.m29308i("PushServiceNetworkHandler", sb.toString());
                C6982c.this.m29817a(i, "", aVar);
            }

            /* renamed from: a */
            public void mo33271a(JceStruct jceStruct, ChannelException channelException, C7000a aVar) {
                StringBuilder sb = new StringBuilder();
                sb.append("@@ loadConfiguration.onMessageSendFailed ");
                sb.append(channelException.errorCode);
                sb.append(StorageInterface.KEY_SPLITER);
                sb.append(channelException.getMessage());
                C6864a.m29308i("PushServiceNetworkHandler", sb.toString());
                C6982c.this.m29817a(channelException.errorCode, channelException.getMessage(), aVar);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m29817a(int i, String str, C7000a aVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("@@ loadConfiguraionFailHandler(");
        sb.append(i);
        sb.append(StorageInterface.KEY_SPLITER);
        sb.append(str);
        sb.append(")");
        C6864a.m29308i("PushServiceNetworkHandler", sb.toString());
    }

    /* renamed from: a */
    public void mo33317a(final String str) {
        String str2 = "PushServiceNetworkHandler";
        if (XGPushConfig.enableDebug) {
            StringBuilder sb = new StringBuilder();
            sb.append("Action uninstallReport : pkgName = ");
            sb.append(str);
            C6864a.m29298c(str2, sb.toString());
        }
        RegisterEntity registerInfoByPkgName = CacheManager.getRegisterInfoByPkgName(str);
        if (registerInfoByPkgName != null) {
            TpnsUnregisterReq tpnsUnregisterReq = new TpnsUnregisterReq();
            AppInfo appInfo = new AppInfo(registerInfoByPkgName.accessId, registerInfoByPkgName.accessKey, "", 0);
            tpnsUnregisterReq.unregInfo = new UnregInfo(appInfo, 1, System.currentTimeMillis());
            CacheManager.UninstallInfoByPkgName(str);
            C7005b.m29964a().mo33389a((JceStruct) tpnsUnregisterReq, (C7031a) new C7031a() {
                /* renamed from: a */
                public void mo33270a(JceStruct jceStruct, C7000a aVar) {
                }

                /* renamed from: a */
                public void mo33269a(JceStruct jceStruct, int i, JceStruct jceStruct2, C7000a aVar) {
                    String str = "PushServiceNetworkHandler";
                    if (XGPushConfig.enableDebug) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Report uninstall with pkgName = ");
                        sb.append(str);
                        sb.append(", reponseCode = ");
                        sb.append(i);
                        C6864a.m29298c(str, sb.toString());
                    }
                    if (i == 0) {
                        CacheManager.UninstallInfoSuccessByPkgName(str);
                        return;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(" uninstall report fail responseCode=");
                    sb2.append(i);
                    C6864a.m29308i(str, sb2.toString());
                    int i2 = i;
                    C6982c.this.m29818a(i2, "服务器处理失败，返回错误", str, (TpnsUnregisterReq) jceStruct, aVar);
                }

                /* renamed from: a */
                public void mo33271a(JceStruct jceStruct, ChannelException channelException, C7000a aVar) {
                    C6982c.this.m29818a(channelException.errorCode, channelException.getMessage(), str, (TpnsUnregisterReq) jceStruct, aVar);
                }
            });
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("The RegisterEntity entity is null, PkgName = ");
        sb2.append(str);
        C6864a.m29298c(str2, sb2.toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m29818a(int i, String str, String str2, TpnsUnregisterReq tpnsUnregisterReq, C7000a aVar) {
        if (XGPushConfig.enableDebug) {
            StringBuilder sb = new StringBuilder();
            sb.append("@@ uninstallReportFailedHandler(");
            sb.append(i);
            String str3 = StorageInterface.KEY_SPLITER;
            sb.append(str3);
            sb.append(str);
            sb.append(str3);
            sb.append(str2);
            sb.append(str3);
            sb.append(tpnsUnregisterReq);
            sb.append(")");
            C6864a.m29286a(Constants.ServiceLogTag, sb.toString());
        }
    }

    /* renamed from: a */
    public void mo33319a(ArrayList<TpnsPushClientReport> arrayList, C7031a aVar) {
        if (arrayList != null && arrayList.size() > 0) {
            C7005b.m29964a().mo33389a((JceStruct) new TpnsPushVerifyReq(arrayList), aVar);
        }
    }

    /* renamed from: a */
    public void mo33312a(long j, String str, int i, String str2, C7031a aVar) {
        TpnsTokenTagReq tpnsTokenTagReq = new TpnsTokenTagReq();
        tpnsTokenTagReq.accessId = j;
        tpnsTokenTagReq.flag = i;
        tpnsTokenTagReq.tag = str2;
        if (XGPushConfig.enableDebug) {
            StringBuilder sb = new StringBuilder();
            sb.append("Action -> sendTag to server (");
            sb.append(j);
            sb.append(StorageInterface.KEY_SPLITER);
            sb.append(str);
            sb.append(")");
            C6864a.m29298c("PushServiceNetworkHandler", sb.toString());
        }
        C7005b.m29964a().mo33389a((JceStruct) tpnsTokenTagReq, aVar);
    }

    /* renamed from: b */
    public void mo33322b(ArrayList<TpnsClickClientReport> arrayList, C7031a aVar) {
        if (arrayList != null && arrayList.size() != 0) {
            TpnsPushClickReq tpnsPushClickReq = new TpnsPushClickReq();
            tpnsPushClickReq.msgClickList = arrayList;
            C7005b.m29964a().mo33389a((JceStruct) tpnsPushClickReq, aVar);
        }
    }

    /* renamed from: a */
    public void mo33320a(boolean z, long j) {
        StringBuilder sb = new StringBuilder();
        sb.append("loadIPList :");
        sb.append(j);
        String str = "PushServiceNetworkHandler";
        C6864a.m29298c(str, sb.toString());
        long lastLoadIpTime = CacheManager.getLastLoadIpTime(C6973b.m29776f());
        if (z) {
            if (System.currentTimeMillis() - lastLoadIpTime > ((long) C6971a.m29749a(C6973b.m29776f()).f23155n) && C6971a.m29749a(C6973b.m29776f()).mo33281b() != j) {
                m29815a().mo33311a(j);
            }
        } else if (C6971a.m29749a(C6973b.m29776f()).mo33281b() != j) {
            m29815a().mo33311a(j);
        }
        if (System.currentTimeMillis() - lastLoadIpTime >= ((long) C6971a.m29749a(C6973b.m29776f()).f23155n)) {
            TpnsGetApListReq tpnsGetApListReq = new TpnsGetApListReq();
            NetworkInfo networkInfo = new NetworkInfo();
            networkInfo.network = DeviceInfos.getNetworkType(C6973b.m29776f());
            networkInfo.f23399op = C7056i.m30217k(C6973b.m29776f());
            tpnsGetApListReq.netInfo = networkInfo;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("sendMessage TpnsGetApListReq:");
            sb2.append(tpnsGetApListReq);
            C6864a.m29298c(str, sb2.toString());
            C7005b.m29964a().mo33389a((JceStruct) tpnsGetApListReq, (C7031a) new C7031a() {
                /* renamed from: a */
                public void mo33270a(JceStruct jceStruct, C7000a aVar) {
                }

                /* renamed from: a */
                public void mo33269a(JceStruct jceStruct, int i, JceStruct jceStruct2, C7000a aVar) {
                    if (i == 0) {
                        DefaultServer.m29602a(((TpnsGetApListRsp) jceStruct2).apList);
                        CacheManager.saveLoadIpTime(C6973b.m29776f(), System.currentTimeMillis());
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(">> loadIPList fail responseCode=");
                    sb.append(i);
                    C6864a.m29308i("PushServiceNetworkHandler", sb.toString());
                }

                /* renamed from: a */
                public void mo33271a(JceStruct jceStruct, ChannelException channelException, C7000a aVar) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("@@ loadIPList.onMessageSendFailed ");
                    sb.append(channelException.errorCode);
                    sb.append(StorageInterface.KEY_SPLITER);
                    sb.append(channelException.getMessage());
                    C6864a.m29308i("PushServiceNetworkHandler", sb.toString());
                }
            });
        }
    }

    /* renamed from: a */
    public void mo33313a(long j, String str, String str2, String str3, C7031a aVar) {
        TpnsUpdateTokenReq tpnsUpdateTokenReq = new TpnsUpdateTokenReq(j, str, str2, str3);
        C7005b.m29964a().mo33389a((JceStruct) tpnsUpdateTokenReq, aVar);
    }

    /* renamed from: a */
    public void mo33315a(Intent intent, C7031a aVar) {
        TpnsPushCommReportReq tpnsPushCommReportReq = new TpnsPushCommReportReq();
        tpnsPushCommReportReq.type = intent.getLongExtra("type", 0);
        try {
            tpnsPushCommReportReq.accessId = Long.parseLong(Rijndael.decrypt(intent.getStringExtra("accessId")));
        } catch (NumberFormatException unused) {
            C6864a.m29308i("PushServiceNetworkHandler", "sendCommReportMessage NumberFormatException");
        }
        tpnsPushCommReportReq.msgId = intent.getLongExtra(MessageKey.MSG_ID, 0);
        tpnsPushCommReportReq.broadcastId = intent.getLongExtra("broadcastId", 0);
        tpnsPushCommReportReq.msgTimestamp = intent.getLongExtra("msgTimestamp", 0);
        tpnsPushCommReportReq.clientTimestamp = intent.getLongExtra("clientTimestamp", 0);
        tpnsPushCommReportReq.pkgName = intent.getStringExtra(AppEntity.KEY_PKG_NAME_STR);
        String decrypt = Rijndael.decrypt(intent.getStringExtra(NotificationCompat.CATEGORY_MESSAGE));
        if (decrypt != null) {
            tpnsPushCommReportReq.msg = decrypt;
        }
        String decrypt2 = Rijndael.decrypt(intent.getStringExtra("ext"));
        if (decrypt2 != null) {
            tpnsPushCommReportReq.ext = decrypt2;
        }
        C7005b.m29964a().mo33389a((JceStruct) tpnsPushCommReportReq, aVar);
    }
}
