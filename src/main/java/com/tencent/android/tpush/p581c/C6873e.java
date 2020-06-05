package com.tencent.android.tpush.p581c;

import com.tencent.android.tpush.NotificationAction;
import com.tencent.android.tpush.common.C6914l;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.p580b.C6864a;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.c.e */
public class C6873e extends C6867a {
    /* renamed from: d */
    private int f22874d = 0;
    /* renamed from: e */
    private int f22875e = 1;
    /* renamed from: f */
    private int f22876f = 1;
    /* renamed from: g */
    private int f22877g = 1;
    /* renamed from: h */
    private int f22878h = 0;
    /* renamed from: i */
    private int f22879i = 0;
    /* renamed from: j */
    private String f22880j;
    /* renamed from: k */
    private int f22881k;
    /* renamed from: l */
    private String f22882l;
    /* renamed from: m */
    private String f22883m;
    /* renamed from: n */
    private int f22884n;
    /* renamed from: o */
    private int f22885o;
    /* renamed from: p */
    private String f22886p;
    /* renamed from: q */
    private String f22887q;
    /* renamed from: r */
    private C6874a f22888r;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.android.tpush.c.e$a */
    public static class C6874a {
        /* renamed from: a */
        public int f22889a = NotificationAction.activity.getType();
        /* renamed from: b */
        public String f22890b;
        /* renamed from: c */
        public C6875a f22891c;
        /* renamed from: d */
        public String f22892d;
        /* renamed from: e */
        public String f22893e;
        /* renamed from: f */
        public String f22894f;
        /* renamed from: g */
        public int f22895g;
        /* renamed from: h */
        public String f22896h;
        /* renamed from: i */
        public String f22897i;
        /* renamed from: j */
        public String f22898j;

        /* compiled from: ProGuard */
        /* renamed from: com.tencent.android.tpush.c.e$a$a */
        public static class C6875a {
            /* renamed from: a */
            public int f22899a = 0;
            /* renamed from: b */
            public int f22900b = 0;
        }

        public C6874a() {
            String str = "";
            this.f22890b = str;
            this.f22891c = new C6875a();
            this.f22892d = str;
            this.f22893e = str;
            this.f22894f = str;
            this.f22895g = 0;
            this.f22896h = str;
            this.f22897i = str;
            this.f22898j = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m29374a(String str) {
            JSONObject jSONObject = new JSONObject(str);
            String str2 = Constants.FLAG_ACTION_TYPE;
            if (!jSONObject.isNull(str2)) {
                this.f22889a = jSONObject.getInt(str2);
            }
            String str3 = Constants.FLAG_ACTIVITY_NAME;
            if (!jSONObject.isNull(str3)) {
                this.f22890b = jSONObject.getString(str3);
            }
            String str4 = "aty_attr";
            if (!jSONObject.isNull(str4)) {
                String optString = jSONObject.optString(str4);
                if (!C6914l.m29521c(optString)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(optString);
                        this.f22891c.f22899a = jSONObject2.optInt("if");
                        this.f22891c.f22900b = jSONObject2.optInt("pf");
                    } catch (Exception e) {
                        C6864a.m29302d(Constants.LogTag, "decode activityAttribute error", e);
                    }
                }
            }
            String str5 = "intent";
            if (!jSONObject.isNull(str5)) {
                this.f22892d = jSONObject.getString(str5);
            }
            String str6 = "browser";
            String str7 = "confirm";
            if (!jSONObject.isNull(str6)) {
                this.f22893e = jSONObject.getString(str6);
                JSONObject jSONObject3 = new JSONObject(this.f22893e);
                String str8 = "url";
                if (!jSONObject3.isNull(str8)) {
                    this.f22894f = jSONObject3.getString(str8);
                }
                if (!jSONObject3.isNull(str7)) {
                    this.f22895g = jSONObject3.getInt(str7);
                }
            }
            String str9 = "package_name";
            if (!jSONObject.isNull(str9)) {
                this.f22897i = jSONObject.getString(str9);
                JSONObject jSONObject4 = new JSONObject(this.f22897i);
                String str10 = Constants.FLAG_PACKAGE_DOWNLOAD_URL;
                if (!jSONObject4.isNull(str10)) {
                    this.f22898j = jSONObject4.getString(str10);
                }
                String str11 = Constants.FLAG_PACKAGE_NAME;
                if (!jSONObject4.isNull(str11)) {
                    this.f22896h = jSONObject4.getString(str11);
                }
                if (!jSONObject4.isNull(str7)) {
                    this.f22895g = jSONObject4.getInt(str7);
                }
            }
        }
    }

    /* renamed from: c */
    public int mo32998c() {
        return 1;
    }

    public C6873e(String str) {
        super(str);
        String str2 = "";
        this.f22880j = str2;
        this.f22881k = 1;
        this.f22882l = str2;
        this.f22883m = str2;
        this.f22884n = 0;
        this.f22885o = 0;
        this.f22886p = str2;
        this.f22887q = str2;
        this.f22888r = new C6874a();
    }

    /* renamed from: h */
    public int mo33029h() {
        return this.f22874d;
    }

    /* renamed from: i */
    public int mo33030i() {
        return this.f22875e;
    }

    /* renamed from: j */
    public int mo33031j() {
        return this.f22876f;
    }

    /* renamed from: k */
    public int mo33032k() {
        return this.f22877g;
    }

    /* renamed from: l */
    public int mo33033l() {
        return this.f22878h;
    }

    /* renamed from: m */
    public C6874a mo33034m() {
        return this.f22888r;
    }

    /* renamed from: n */
    public int mo33035n() {
        return this.f22879i;
    }

    /* renamed from: o */
    public int mo33036o() {
        return this.f22881k;
    }

    /* renamed from: p */
    public String mo33037p() {
        return this.f22882l;
    }

    /* renamed from: q */
    public String mo33038q() {
        return this.f22880j;
    }

    /* renamed from: r */
    public String mo33039r() {
        return this.f22883m;
    }

    /* renamed from: s */
    public int mo33040s() {
        return this.f22884n;
    }

    /* renamed from: t */
    public int mo33041t() {
        return this.f22885o;
    }

    /* renamed from: u */
    public String mo33042u() {
        return this.f22886p;
    }

    /* renamed from: v */
    public String mo33043v() {
        return this.f22887q;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo32999d() {
        this.f22874d = this.f22856a.optInt(MessageKey.MSG_BUILDER_ID);
        this.f22875e = this.f22856a.optInt(MessageKey.MSG_RING, 1);
        this.f22882l = this.f22856a.optString(MessageKey.MSG_RING_RAW);
        this.f22880j = this.f22856a.optString(MessageKey.MSG_ICON_RES);
        this.f22883m = this.f22856a.optString(MessageKey.MSG_SMALL_ICON);
        this.f22881k = this.f22856a.optInt(MessageKey.MSG_LIGHTS, 1);
        this.f22876f = this.f22856a.optInt(MessageKey.MSG_VIBRATE, 1);
        this.f22879i = this.f22856a.optInt("icon");
        this.f22884n = this.f22856a.optInt(MessageKey.MSG_ICON_TYPE, 0);
        this.f22878h = this.f22856a.optInt(MessageKey.MSG_NOTIFY_ID);
        this.f22885o = this.f22856a.optInt(MessageKey.MSG_STYLE_ID, 0);
        this.f22886p = this.f22856a.optString(MessageKey.MSG_NOTIFACTION_ID_CHANNEL_ID);
        this.f22887q = this.f22856a.optString(MessageKey.MSG_NOTIFACTION_ID_CHANNEL_NAME);
        JSONObject jSONObject = this.f22856a;
        String str = MessageKey.MSG_CLEARABLE;
        if (!jSONObject.isNull(str)) {
            this.f22877g = this.f22856a.optInt(str);
        } else {
            this.f22877g = 1;
        }
        String str2 = "action";
        if (!this.f22856a.isNull(str2)) {
            this.f22888r.m29374a(this.f22856a.getString(str2));
        }
    }
}
