package com.tencent.stat.event;

import android.content.Context;
import com.tencent.stat.StatConfig.CurrencyType;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.Util;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.stat.event.l */
public class C7636l extends Event {
    /* renamed from: a */
    private String f25816a;
    /* renamed from: t */
    private String f25817t;
    /* renamed from: u */
    private String f25818u;
    /* renamed from: v */
    private double f25819v = 0.0d;

    /* renamed from: com.tencent.stat.event.l$1 */
    static /* synthetic */ class C76371 {
        /* renamed from: a */
        static final /* synthetic */ int[] f25820a = new int[CurrencyType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
     */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
            com.tencent.stat.StatConfig$CurrencyType[] r0 = com.tencent.stat.StatConfig.CurrencyType.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f25820a = r0
            int[] r0 = f25820a     // Catch:{ NoSuchFieldError -> 0x0014 }
            com.tencent.stat.StatConfig$CurrencyType r1 = com.tencent.stat.StatConfig.CurrencyType.CNY     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = f25820a     // Catch:{ NoSuchFieldError -> 0x001f }
            com.tencent.stat.StatConfig$CurrencyType r1 = com.tencent.stat.StatConfig.CurrencyType.USD     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.event.C7636l.C76371.m53689clinit():void");
        }
    }

    public boolean equals(Object obj) {
        return obj != null && this == obj;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public C7636l(Context context, int i, String str, String str2, double d, CurrencyType currencyType) {
        super(context, i, null);
        String str3 = "";
        this.f25816a = str3;
        this.f25817t = str3;
        this.f25818u = str3;
        int i2 = C76371.f25820a[currencyType.ordinal()];
        if (i2 == 1) {
            str3 = "CNY";
        } else if (i2 == 2) {
            str3 = "USD";
        }
        this.f25816a = str3;
        this.f25817t = str2;
        this.f25818u = str;
        this.f25819v = d;
    }

    public EventType getType() {
        return EventType.PAY_EVENT;
    }

    public boolean onEncode(JSONObject jSONObject) throws JSONException {
        Util.jsonPut(jSONObject, "ua", StatCommonHelper.getUserAgent(this.f25784r));
        JSONObject jSONObject2 = new JSONObject();
        Util.jsonPut(jSONObject2, "type", this.f25818u);
        Util.jsonPut(jSONObject2, "id", this.f25817t);
        Util.jsonPut(jSONObject2, "cy", this.f25816a);
        Util.safeJsonPut(jSONObject2, "num", Double.valueOf(this.f25819v));
        jSONObject.put("pay", jSONObject2);
        return true;
    }
}
