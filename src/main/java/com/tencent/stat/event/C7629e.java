package com.tencent.stat.event;

import android.content.Context;
import android.os.Process;
import com.tencent.stat.StatConfig;
import com.tencent.stat.StatNativeCrashReport;
import com.tencent.stat.StatServiceImpl;
import com.tencent.stat.StatSpecifyReportedInfo;
import com.tencent.stat.StatTrackLog;
import com.tencent.stat.common.C7592a;
import com.tencent.stat.common.C7597d;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.Util;
import java.io.File;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.stat.event.e */
public class C7629e extends Event {
    /* renamed from: a */
    private String f25798a;
    /* renamed from: t */
    private JSONArray f25799t;
    /* renamed from: u */
    private int f25800u;
    /* renamed from: v */
    private Thread f25801v = null;
    /* renamed from: w */
    private String f25802w = null;
    /* renamed from: x */
    private long f25803x = -1;
    /* renamed from: y */
    private String f25804y = null;

    /* renamed from: a */
    public void mo37189a(long j) {
        this.f25803x = j;
    }

    /* renamed from: a */
    public void mo37190a(String str) {
        this.f25802w = str;
    }

    public C7629e(Context context, int i, int i2, Throwable th, Thread thread, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
        this.f25800u = i2;
        m32865a(i2, th);
        this.f25801v = thread;
    }

    public C7629e(Context context, int i, int i2, JSONArray jSONArray, Thread thread, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
        this.f25800u = i2;
        this.f25799t = jSONArray;
        this.f25801v = thread;
    }

    /* renamed from: b */
    public void mo37191b(String str) {
        try {
            this.f25804y = StatNativeCrashReport.readFile(new File(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public String mo37188a() {
        return this.f25804y;
    }

    /* renamed from: a */
    private void m32865a(int i, Throwable th) {
        if (th != null) {
            this.f25800u = i;
            this.f25799t = StatCommonHelper.formatThrowable(th);
        }
    }

    public C7629e(Context context, int i, String str, int i2, int i3, Thread thread, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
        if (str != null) {
            if (i3 <= 0) {
                i3 = StatConfig.getMaxReportEventLength();
            }
            if (str.length() <= i3) {
                this.f25798a = str;
            } else {
                this.f25798a = str.substring(0, i3);
            }
        }
        this.f25801v = thread;
        this.f25800u = i2;
    }

    public EventType getType() {
        return EventType.ERROR;
    }

    public boolean onEncode(JSONObject jSONObject) throws JSONException {
        jSONObject.put("cmode", 2);
        jSONObject.put("ea", this.f25800u);
        jSONObject.put("prcp", Process.myPid());
        jSONObject.put("prct", Process.myTid());
        long currentTimeMillis = System.currentTimeMillis();
        jSONObject.put("prts", (currentTimeMillis - StatServiceImpl.getAppStartupTime()) / 1000);
        jSONObject.put("fgts", (currentTimeMillis - StatServiceImpl.getFrontgroundStartupTime()) / 1000);
        jSONObject.put("tpg", StatServiceImpl.fetchPageFlows());
        jSONObject.put("ckv", StatConfig.getCrashKeyValue());
        new C7592a(this.f25784r).mo37120a(jSONObject, this.f25801v);
        m32868b(jSONObject);
        m32866a(jSONObject);
        m32869c(jSONObject);
        m32870d(jSONObject);
        return true;
    }

    /* renamed from: a */
    private void m32866a(JSONObject jSONObject) throws JSONException {
        jSONObject.put("md5", StatCommonHelper.md5sum(this.f25798a));
        jSONObject.put("ct", this.f25800u);
        jSONObject.put("bid", this.f25784r.getPackageName());
        jSONObject.put("dt", System.currentTimeMillis() / 1000);
    }

    /* renamed from: b */
    private void m32868b(JSONObject jSONObject) throws JSONException {
        JSONObject a = m32864a(this.f25801v);
        JSONArray jSONArray = this.f25799t;
        String str = "gfra";
        String str2 = "fra";
        if (jSONArray != null) {
            a.put(str2, jSONArray);
            if (this.f25803x > -1) {
                a.put(str, this.f25799t);
            }
        } else {
            a.put(str2, this.f25798a);
            if (this.f25803x > -1) {
                a.put(str, this.f25798a);
            }
        }
        int i = this.f25800u;
        if (i >= 4 && i <= 10) {
            a.put(str2, this.f25798a);
            if (this.f25803x > -1) {
                a.put(str, this.f25798a);
            }
        }
        Util.jsonPut(a, "des", this.f25802w);
        jSONObject.put("cth", a);
        if (this.f25800u == 3) {
            a.put("nfra", this.f25804y);
        }
    }

    /* renamed from: a */
    private JSONObject m32864a(Thread thread) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("thn", thread.getId());
        jSONObject.put("na", thread.getName());
        jSONObject.put("pr", thread.getPriority());
        long j = this.f25803x;
        if (j > -1) {
            jSONObject.put("gthn", j);
        }
        return jSONObject;
    }

    /* renamed from: c */
    private void m32869c(JSONObject jSONObject) {
        Map allStackTraces = Thread.getAllStackTraces();
        if (allStackTraces != null && allStackTraces.size() != 0) {
            JSONArray jSONArray = new JSONArray();
            for (Entry entry : allStackTraces.entrySet()) {
                try {
                    Thread thread = (Thread) entry.getKey();
                    if (thread.getId() != this.f25801v.getId()) {
                        JSONObject a = m32864a(thread);
                        JSONArray jSONArray2 = new JSONArray();
                        StatCommonHelper.formatStackTraceElement(jSONArray2, (StackTraceElement[]) entry.getValue());
                        if (jSONArray2.length() != 0) {
                            a.put("fra", jSONArray2);
                            jSONArray.put(a);
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (jSONArray.length() > 0) {
                try {
                    jSONObject.put("oth", jSONArray);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: b */
    private String m32867b() {
        return C7597d.m32758a(50);
    }

    /* renamed from: d */
    private void m32870d(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        Util.jsonPut(jSONObject2, "clog", StatTrackLog.fetchLog());
        Util.jsonPut(jSONObject2, "llog", m32867b());
        try {
            jSONObject.put("ext", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
