package com.tencent.stat.event;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mid.util.Util;
import com.tencent.stat.C7614e;
import com.tencent.stat.StatConfig;
import com.tencent.stat.StatServiceImpl;
import com.tencent.stat.StatSpecifyReportedInfo;
import com.tencent.stat.common.DeviceInfo;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.StatConstants;
import com.tencent.stat.common.X5Helper;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class Event {
    /* renamed from: a */
    private static final long f25767a = (System.currentTimeMillis() - SystemClock.elapsedRealtime());
    /* renamed from: m */
    protected static String f25768m;
    /* renamed from: o */
    protected static String f25769o;
    /* renamed from: q */
    protected static int f25770q = -1;
    /* renamed from: b */
    protected int f25771b = 0;
    /* renamed from: c */
    protected boolean f25772c = false;
    /* renamed from: d */
    protected String f25773d = null;
    /* renamed from: e */
    protected long f25774e;
    /* renamed from: f */
    protected long f25775f;
    /* renamed from: g */
    protected int f25776g;
    /* renamed from: h */
    protected DeviceInfo f25777h = null;
    /* renamed from: i */
    protected int f25778i;
    /* renamed from: j */
    protected String f25779j = null;
    /* renamed from: k */
    protected String f25780k = null;
    /* renamed from: l */
    protected String f25781l = null;
    /* renamed from: n */
    protected boolean f25782n = false;
    /* renamed from: p */
    protected Map<String, Object> f25783p = new HashMap();
    /* renamed from: r */
    protected Context f25784r;
    /* renamed from: s */
    protected StatSpecifyReportedInfo f25785s = null;
    /* renamed from: t */
    private boolean f25786t = false;

    public boolean decode(JSONObject jSONObject) {
        return true;
    }

    public abstract EventType getType();

    public abstract boolean onEncode(JSONObject jSONObject) throws JSONException;

    public void addCommonProperty(String str, Object obj) {
        this.f25783p.put(str, obj);
    }

    public Map<String, Object> getCommonProperty() {
        return this.f25783p;
    }

    public int getFromH5() {
        return this.f25771b;
    }

    public void setFromH5(int i) {
        this.f25771b = i;
    }

    public void encodeCommonProperty(JSONObject jSONObject) {
        Map<String, Object> map = this.f25783p;
        if (map != null && map.size() > 0) {
            for (Entry entry : this.f25783p.entrySet()) {
                try {
                    jSONObject.put((String) entry.getKey(), entry.getValue());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        Map customReportMap = StatConfig.getCustomReportMap();
        if (customReportMap != null && customReportMap.size() > 0) {
            for (Entry entry2 : customReportMap.entrySet()) {
                try {
                    jSONObject.put((String) entry2.getKey(), entry2.getValue());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void setFilter(boolean z) {
        this.f25786t = z;
    }

    public String getReportedAppkey() {
        return this.f25773d;
    }

    public long getTimestamp() {
        return this.f25774e;
    }

    public StatSpecifyReportedInfo getStatSpecifyReportedInfo() {
        return this.f25785s;
    }

    Event() {
    }

    public Event(Context context, int i, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (context != null) {
            init(context, i, statSpecifyReportedInfo);
        }
    }

    public void init(Context context, int i, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (context.getApplicationContext() != null) {
            this.f25784r = context.getApplicationContext();
        } else {
            this.f25784r = context;
        }
        this.f25775f = System.currentTimeMillis();
        this.f25774e = this.f25775f / 1000;
        this.f25776g = i;
        this.f25781l = StatCommonHelper.getCurAppVersion(context);
        if (statSpecifyReportedInfo != null) {
            this.f25785s = statSpecifyReportedInfo;
            if (StatCommonHelper.isStringValid(statSpecifyReportedInfo.getAppKey())) {
                this.f25773d = statSpecifyReportedInfo.getAppKey();
            }
            if (StatCommonHelper.isStringValid(statSpecifyReportedInfo.getInstallChannel())) {
                this.f25780k = statSpecifyReportedInfo.getInstallChannel();
            }
            if (StatCommonHelper.isStringValid(statSpecifyReportedInfo.getVersion())) {
                this.f25781l = statSpecifyReportedInfo.getVersion();
            }
            this.f25782n = statSpecifyReportedInfo.isImportant();
        } else {
            this.f25773d = StatConfig.getAppKey(context);
            this.f25780k = StatConfig.getInstallChannel(context);
        }
        this.f25779j = StatConfig.getCustomUserId(context);
        this.f25777h = C7614e.m32812a(context).mo37149b(context);
        if (getType() != EventType.NETWORK_DETECTOR) {
            this.f25778i = StatCommonHelper.getNextEventIndexNo(context).intValue();
        } else {
            this.f25778i = -EventType.NETWORK_DETECTOR.GetIntValue();
        }
        if (!Util.isMidValid(f25768m)) {
            f25768m = StatConfig.getLocalMidOnly(context);
            if (!StatCommonHelper.isStringValid(f25768m)) {
                f25768m = "0";
            }
        }
        if (f25770q == -1) {
            f25770q = StatCommonHelper.hasRootAccess(context);
        }
        if (statSpecifyReportedInfo != null) {
            this.f25771b = statSpecifyReportedInfo.getFromH5();
        }
        if (TextUtils.isEmpty(f25769o)) {
            f25769o = com.tencent.stat.common.Util.getDeviceID(getContext());
        }
    }

    public Context getContext() {
        return this.f25784r;
    }

    public boolean isImportant() {
        return this.f25782n;
    }

    public boolean encode(JSONObject jSONObject) {
        try {
            com.tencent.stat.common.Util.jsonPut(jSONObject, "ky", this.f25773d);
            jSONObject.put("et", getType().GetIntValue());
            int i = 1;
            if (this.f25777h != null) {
                String imei = this.f25777h.getImei();
                jSONObject.put(DeviceInfo.TAG_IMEI, imei);
                if (!com.tencent.stat.common.Util.isIMEI(imei)) {
                    com.tencent.stat.common.Util.jsonPut(jSONObject, "nui", com.tencent.stat.common.Util.getNewUi(getContext()));
                }
                com.tencent.stat.common.Util.jsonPut(jSONObject, DeviceInfo.TAG_MAC, this.f25777h.getMac());
                int userType = this.f25777h.getUserType();
                jSONObject.put("ut", userType);
                if (userType == 0 && StatCommonHelper.isTheFirstTimeActivate(this.f25784r) == 1) {
                    jSONObject.put("ia", 1);
                }
            }
            com.tencent.stat.common.Util.jsonPut(jSONObject, "cui", this.f25779j);
            String appVersion = StatConfig.getAppVersion();
            String str = "av";
            if (!StatCommonHelper.isStringValid(appVersion)) {
                com.tencent.stat.common.Util.jsonPut(jSONObject, str, this.f25781l);
            } else {
                com.tencent.stat.common.Util.jsonPut(jSONObject, str, appVersion);
                com.tencent.stat.common.Util.jsonPut(jSONObject, "appv", this.f25781l);
            }
            com.tencent.stat.common.Util.jsonPut(jSONObject, "osn", VERSION.RELEASE);
            jSONObject.put("midver", String.valueOf(4.07f));
            com.tencent.stat.common.Util.jsonPut(jSONObject, "ch", this.f25780k);
            if (this.f25782n) {
                jSONObject.put("impt", 1);
            }
            if (this.f25786t) {
                jSONObject.put("ft", 1);
            }
            com.tencent.stat.common.Util.jsonPut(jSONObject, "cch", "");
            com.tencent.stat.common.Util.jsonPut(jSONObject, "mid", f25768m);
            jSONObject.put("idx", this.f25778i);
            jSONObject.put("si", this.f25776g);
            jSONObject.put("ts", this.f25774e);
            jSONObject.put("lts", this.f25775f);
            jSONObject.put("dts", StatCommonHelper.getDiffTime(this.f25784r, false));
            jSONObject.put("os", 1);
            jSONObject.put("osst", f25767a);
            jSONObject.put("sut", f25767a);
            com.tencent.stat.common.Util.jsonPut(jSONObject, "pcn", StatCommonHelper.getCurProcessName(this.f25784r));
            com.tencent.stat.common.Util.jsonPut(jSONObject, "new_mid", StatCommonHelper.getNewMid(this.f25784r));
            com.tencent.stat.common.Util.jsonPut(jSONObject, "nowui", f25769o);
            com.tencent.stat.common.Util.jsonPut(jSONObject, "ov", Integer.toString(VERSION.SDK_INT));
            com.tencent.stat.common.Util.jsonPut(jSONObject, "md", Build.MODEL);
            jSONObject.put("jb", f25770q);
            com.tencent.stat.common.Util.jsonPut(jSONObject, "mf", Build.MANUFACTURER);
            JSONObject customGlobalReportContent = StatConfig.getCustomGlobalReportContent();
            if (customGlobalReportContent != null && customGlobalReportContent.length() > 0) {
                jSONObject.put("cc", customGlobalReportContent.toString());
            }
            if (StatServiceImpl.isEnableAutoMonitorActivityCycle()) {
                if (!StatServiceImpl.isForeground()) {
                    i = 0;
                }
                jSONObject.put("ifg", i);
            }
            com.tencent.stat.common.Util.jsonPut(jSONObject, "sv", StatConstants.VERSION);
            jSONObject.put("ot", StatCommonHelper.getRunningCounter(getContext()));
            encodeCommonProperty(jSONObject);
            jSONObject.put("h5", this.f25771b);
            m32859b(jSONObject);
            mo37187a(jSONObject);
            StatCommonHelper.encodeMultiAccount(jSONObject, StatServiceImpl.getMultiAccount());
            return onEncode(jSONObject);
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: a */
    private void mo37187a(JSONObject jSONObject) {
        Map customReportMap = StatConfig.getCustomReportMap();
        if (customReportMap != null && customReportMap.size() > 0) {
            for (Entry entry : customReportMap.entrySet()) {
                try {
                    jSONObject.put((String) entry.getKey(), entry.getValue());
                } catch (Exception unused) {
                }
            }
        }
    }

    /* renamed from: b */
    private void m32859b(JSONObject jSONObject) {
        if (this.f25772c) {
            com.tencent.stat.common.Util.jsonPut(jSONObject, "ua", StatCommonHelper.getUserAgent(this.f25784r));
            X5Helper.encodeX5(getContext(), jSONObject);
        }
    }

    public String toJsonString() {
        try {
            JSONObject jSONObject = new JSONObject();
            encode(jSONObject);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }
}
