package com.tencent.android.tpush.stat.event;

import android.content.Context;
import com.tencent.mid.sotrage.StorageInterface;
import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.stat.event.a */
public class C7098a extends C7100b {
    /* renamed from: a */
    protected C7099a f23592a = new C7099a();
    /* renamed from: b */
    protected long f23593b = -1;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.android.tpush.stat.event.a$a */
    public static class C7099a {
        /* renamed from: a */
        public String f23594a;
        /* renamed from: b */
        public JSONArray f23595b;
        /* renamed from: c */
        public JSONObject f23596c;
        /* renamed from: d */
        public boolean f23597d;

        public C7099a(String str, String[] strArr, Properties properties) {
            this.f23596c = null;
            this.f23597d = false;
            this.f23594a = str;
            if (properties != null) {
                this.f23596c = new JSONObject(properties);
            } else if (strArr != null) {
                this.f23595b = new JSONArray();
                for (String put : strArr) {
                    this.f23595b.put(put);
                }
            } else {
                this.f23596c = new JSONObject();
            }
        }

        public C7099a() {
            this.f23596c = null;
            this.f23597d = false;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.f23594a);
            sb.append(StorageInterface.KEY_SPLITER);
            JSONArray jSONArray = this.f23595b;
            if (jSONArray != null) {
                sb.append(jSONArray.toString());
            }
            JSONObject jSONObject = this.f23596c;
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
            if (!(obj instanceof C7099a)) {
                return false;
            }
            return toString().equals(((C7099a) obj).toString());
        }
    }

    /* renamed from: a */
    public C7099a mo34231a() {
        return this.f23592a;
    }

    public C7098a(Context context, String str, JSONObject jSONObject, String str2, boolean z) {
        super(context, str2);
        C7099a aVar = this.f23592a;
        aVar.f23594a = str;
        aVar.f23596c = jSONObject;
        aVar.f23597d = z;
    }

    public C7098a(Context context, int i, String str, long j, long j2) {
        super(context, i, j);
        this.f23592a.f23594a = str;
        this.f23606k = j2;
    }

    /* renamed from: b */
    public EventType mo34233b() {
        return EventType.CUSTOM;
    }

    /* renamed from: a */
    public boolean mo34232a(JSONObject jSONObject) {
        jSONObject.put("ei", this.f23592a.f23594a);
        long j = this.f23593b;
        if (j > 0) {
            jSONObject.put("du", j);
        }
        if (this.f23592a.f23595b != null) {
            jSONObject.put("ar", this.f23592a.f23595b);
        } else if (this.f23592a.f23597d) {
            jSONObject.put("kv2", this.f23592a.f23596c);
        } else {
            jSONObject.put("kv", this.f23592a.f23596c);
        }
        return true;
    }
}
