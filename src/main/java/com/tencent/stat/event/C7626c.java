package com.tencent.stat.event;

import android.content.Context;
import com.tencent.mid.sotrage.StorageInterface;
import com.tencent.stat.StatServiceImpl;
import com.tencent.stat.StatSpecifyReportedInfo;
import java.util.Map.Entry;
import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.stat.event.c */
public class C7626c extends Event {
    /* renamed from: a */
    protected C7627a f25792a = new C7627a();
    /* renamed from: t */
    private double f25793t = 0.0d;

    /* renamed from: com.tencent.stat.event.c$a */
    public static class C7627a {
        /* renamed from: a */
        public String f25794a;
        /* renamed from: b */
        public JSONArray f25795b;
        /* renamed from: c */
        public JSONObject f25796c = null;

        public C7627a(String str, String[] strArr, Properties properties) {
            this.f25794a = str;
            if (properties != null) {
                this.f25796c = new JSONObject(properties);
            } else if (strArr != null) {
                this.f25795b = new JSONArray();
                for (String put : strArr) {
                    this.f25795b.put(put);
                }
            } else {
                this.f25796c = new JSONObject();
            }
        }

        public C7627a() {
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.f25794a);
            sb.append(StorageInterface.KEY_SPLITER);
            JSONArray jSONArray = this.f25795b;
            if (jSONArray != null) {
                sb.append(jSONArray.toString());
            }
            JSONObject jSONObject = this.f25796c;
            if (jSONObject != null) {
                sb.append(jSONObject.toString());
            }
            return sb.toString();
        }

        public int hashCode() {
            return toString().hashCode();
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C7627a)) {
                return false;
            }
            return toString().equals(((C7627a) obj).toString());
        }
    }

    /* renamed from: a */
    public C7627a mo37182a() {
        return this.f25792a;
    }

    /* renamed from: a */
    public void mo37183a(double d) {
        this.f25793t = d;
    }

    public C7626c(Context context, int i, String str, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
        this.f25792a.f25794a = str;
    }

    public EventType getType() {
        return EventType.CUSTOM;
    }

    /* renamed from: b */
    private void m32860b() {
        if (this.f25792a.f25794a != null) {
            Properties commonKeyValueForKVEvent = StatServiceImpl.getCommonKeyValueForKVEvent(this.f25792a.f25794a);
            if (commonKeyValueForKVEvent != null && commonKeyValueForKVEvent.size() > 0) {
                if (this.f25792a.f25796c == null || this.f25792a.f25796c.length() == 0) {
                    this.f25792a.f25796c = new JSONObject(commonKeyValueForKVEvent);
                    return;
                }
                for (Entry entry : commonKeyValueForKVEvent.entrySet()) {
                    try {
                        this.f25792a.f25796c.put(entry.getKey().toString(), entry.getValue());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public boolean onEncode(JSONObject jSONObject) throws JSONException {
        jSONObject.put("ei", this.f25792a.f25794a);
        double d = this.f25793t;
        if (d > 0.0d) {
            jSONObject.put("du", d);
        }
        if (this.f25792a.f25795b == null) {
            m32860b();
            jSONObject.put("kv", this.f25792a.f25796c);
        } else {
            jSONObject.put("ar", this.f25792a.f25795b);
        }
        return true;
    }
}
