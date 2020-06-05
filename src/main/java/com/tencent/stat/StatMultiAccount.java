package com.tencent.stat;

import android.text.TextUtils;
import androidx.core.view.PointerIconCompat;
import com.tencent.stat.common.Util;
import org.json.JSONException;
import org.json.JSONObject;

public class StatMultiAccount {
    /* renamed from: a */
    private AccountType f25401a = AccountType.UNDEFINED;
    /* renamed from: b */
    private String f25402b;
    /* renamed from: c */
    private AccountRequestType f25403c = AccountRequestType.UNDEFINED;
    /* renamed from: d */
    private AccountStatus f25404d = AccountStatus.UNDEFINED;
    /* renamed from: e */
    private long f25405e;
    /* renamed from: f */
    private long f25406f = (System.currentTimeMillis() / 1000);
    /* renamed from: g */
    private String f25407g;

    /* renamed from: com.tencent.stat.StatMultiAccount$AccountRequestType */
    public enum AccountRequestType {
        UNDEFINED(-1),
        NORMAL_LOGIN(1),
        REFLESH_TOKEN(2),
        EXCH_SHORT_TOKEN(3),
        EXCH_3PART_TOKEN(4);
        
        /* renamed from: a */
        private int f25409a;

        private AccountRequestType(int i) {
            this.f25409a = i;
        }

        public int getIntValue() {
            return this.f25409a;
        }

        public static AccountRequestType fromInt(int i) {
            AccountRequestType[] values;
            for (AccountRequestType accountRequestType : values()) {
                if (i == accountRequestType.getIntValue()) {
                    return accountRequestType;
                }
            }
            return null;
        }
    }

    /* renamed from: com.tencent.stat.StatMultiAccount$AccountStatus */
    public enum AccountStatus {
        UNDEFINED(-1),
        NORMAL(1),
        LOGOUT(0);
        
        /* renamed from: a */
        private int f25411a;

        private AccountStatus(int i) {
            this.f25411a = i;
        }

        public int getIntValue() {
            return this.f25411a;
        }

        public static AccountStatus fromInt(int i) {
            AccountStatus[] values;
            for (AccountStatus accountStatus : values()) {
                if (i == accountStatus.getIntValue()) {
                    return accountStatus;
                }
            }
            return null;
        }
    }

    /* renamed from: com.tencent.stat.StatMultiAccount$AccountType */
    public enum AccountType {
        UNDEFINED(0),
        PHONE_NO(1),
        EMAIL(2),
        QQ_NUM(3),
        OPEN_WEIXIN(1000),
        OPEN_QQ(1001),
        OPEN_WEIBO(PointerIconCompat.TYPE_HAND),
        OPEN_ALIPAY(PointerIconCompat.TYPE_HELP),
        OPEN_TAOBAO(1004),
        OPEN_DOUBAN(1005),
        OPEN_FACEBOOK(PointerIconCompat.TYPE_CELL),
        OPEN_TWITTER(PointerIconCompat.TYPE_CROSSHAIR),
        OPEN_GOOGLE(PointerIconCompat.TYPE_TEXT),
        OPEN_BAIDU(PointerIconCompat.TYPE_VERTICAL_TEXT),
        OPEN_JINGDONG(PointerIconCompat.TYPE_ALIAS),
        OPEN_DINGDING(PointerIconCompat.TYPE_COPY),
        OPEN_XIAOMI(PointerIconCompat.TYPE_NO_DROP),
        OPEN_LINKIN(PointerIconCompat.TYPE_ALL_SCROLL),
        OPEN_LINE(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW),
        OPEN_INSTAGRAM(PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW),
        GUEST_MODE(2000),
        CUSTOM(2001);
        
        /* renamed from: a */
        private int f25413a;

        private AccountType(int i) {
            this.f25413a = i;
        }

        public int getIntValue() {
            return this.f25413a;
        }

        public static AccountType fromInt(int i) {
            AccountType[] values;
            for (AccountType accountType : values()) {
                if (i == accountType.getIntValue()) {
                    return accountType;
                }
            }
            return null;
        }
    }

    private StatMultiAccount() {
    }

    public StatMultiAccount(AccountType accountType, String str) {
        this.f25401a = accountType;
        this.f25402b = str;
    }

    public AccountType getType() {
        return this.f25401a;
    }

    public StatMultiAccount setType(AccountType accountType) {
        this.f25401a = accountType;
        return this;
    }

    public String getId() {
        return this.f25402b;
    }

    public StatMultiAccount setId(String str) {
        this.f25402b = str;
        return this;
    }

    public AccountRequestType getRequestType() {
        return this.f25403c;
    }

    public StatMultiAccount setRequestType(AccountRequestType accountRequestType) {
        this.f25403c = accountRequestType;
        return this;
    }

    public AccountStatus getCurrentStatusType() {
        return this.f25404d;
    }

    public StatMultiAccount setCurrentStatusType(AccountStatus accountStatus) {
        this.f25404d = accountStatus;
        return this;
    }

    public long getExpireTimeSec() {
        return this.f25405e;
    }

    public StatMultiAccount setExpireTimeSec(long j) {
        this.f25405e = j;
        return this;
    }

    public long getLastTimeSec() {
        return this.f25406f;
    }

    public StatMultiAccount setLastTimeSec(long j) {
        this.f25406f = j;
        return this;
    }

    public String getBind() {
        return this.f25407g;
    }

    public StatMultiAccount setBind(String str) {
        this.f25407g = str;
        return this;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", this.f25401a.getIntValue());
            jSONObject.put("rty", this.f25403c.getIntValue());
            jSONObject.put("csts", this.f25404d.getIntValue());
            jSONObject.put("exp", this.f25405e);
            jSONObject.put("tm", this.f25406f);
            Util.jsonPut(jSONObject, "a", this.f25402b);
            Util.jsonPut(jSONObject, "bind", this.f25407g);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static StatMultiAccount parse(String str) {
        StatMultiAccount statMultiAccount = new StatMultiAccount();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                statMultiAccount.f25402b = jSONObject.optString("a");
                statMultiAccount.f25407g = jSONObject.optString("bind");
                statMultiAccount.f25405e = jSONObject.optLong("exp");
                statMultiAccount.f25406f = jSONObject.optLong("tm");
                statMultiAccount.f25401a = AccountType.fromInt(jSONObject.optInt("t"));
                statMultiAccount.f25403c = AccountRequestType.fromInt(jSONObject.optInt("rty"));
                statMultiAccount.f25404d = AccountStatus.fromInt(jSONObject.optInt("csts"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return statMultiAccount;
    }
}
