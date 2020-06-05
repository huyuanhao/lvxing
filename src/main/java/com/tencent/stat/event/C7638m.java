package com.tencent.stat.event;

import android.content.Context;
import com.tencent.android.tpush.common.Constants;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import com.tencent.stat.StatConfig.AccountType;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.Util;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.stat.event.m */
public class C7638m extends Event {
    /* renamed from: a */
    private String f25821a;
    /* renamed from: t */
    private String f25822t;

    /* renamed from: com.tencent.stat.event.m$1 */
    static /* synthetic */ class C76391 {
        /* renamed from: a */
        static final /* synthetic */ int[] f25823a = new int[AccountType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
     */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
            com.tencent.stat.StatConfig$AccountType[] r0 = com.tencent.stat.StatConfig.AccountType.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f25823a = r0
            int[] r0 = f25823a     // Catch:{ NoSuchFieldError -> 0x0014 }
            com.tencent.stat.StatConfig$AccountType r1 = com.tencent.stat.StatConfig.AccountType.QQ     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = f25823a     // Catch:{ NoSuchFieldError -> 0x001f }
            com.tencent.stat.StatConfig$AccountType r1 = com.tencent.stat.StatConfig.AccountType.MOBILE     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            int[] r0 = f25823a     // Catch:{ NoSuchFieldError -> 0x002a }
            com.tencent.stat.StatConfig$AccountType r1 = com.tencent.stat.StatConfig.AccountType.MAIL     // Catch:{ NoSuchFieldError -> 0x002a }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            int[] r0 = f25823a     // Catch:{ NoSuchFieldError -> 0x0035 }
            com.tencent.stat.StatConfig$AccountType r1 = com.tencent.stat.StatConfig.AccountType.WX     // Catch:{ NoSuchFieldError -> 0x0035 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            int[] r0 = f25823a     // Catch:{ NoSuchFieldError -> 0x0040 }
            com.tencent.stat.StatConfig$AccountType r1 = com.tencent.stat.StatConfig.AccountType.ELSE     // Catch:{ NoSuchFieldError -> 0x0040 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
            r2 = 5
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
        L_0x0040:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.event.C7638m.C76391.m53691clinit():void");
        }
    }

    public boolean equals(Object obj) {
        return obj != null && this == obj;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public C7638m(Context context, int i, String str, AccountType accountType) {
        super(context, i, null);
        String str2 = "";
        this.f25821a = str2;
        this.f25822t = str2;
        int i2 = C76391.f25823a[accountType.ordinal()];
        if (i2 == 1) {
            str2 = "qq";
        } else if (i2 == 2) {
            str2 = ArgKey.KEY_MOBILE;
        } else if (i2 == 3) {
            str2 = "mail";
        } else if (i2 == 4) {
            str2 = "wx";
        } else if (i2 == 5) {
            str2 = "else";
        }
        this.f25821a = str2;
        this.f25822t = str;
    }

    public EventType getType() {
        return EventType.REG_ACCOUNT;
    }

    public boolean onEncode(JSONObject jSONObject) throws JSONException {
        Util.jsonPut(jSONObject, "ua", StatCommonHelper.getUserAgent(this.f25784r));
        JSONObject jSONObject2 = new JSONObject();
        Util.jsonPut(jSONObject2, "acct", this.f25822t);
        Util.jsonPut(jSONObject2, "type", this.f25821a);
        jSONObject.put(Constants.SHARED_PREFS_KEY_REGISTER, jSONObject2);
        return true;
    }
}
