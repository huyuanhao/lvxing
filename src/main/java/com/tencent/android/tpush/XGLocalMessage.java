package com.tencent.android.tpush;

import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.service.p595e.C7056i;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class XGLocalMessage {
    /* renamed from: a */
    private static final String f22646a = XGLocalMessage.class.getSimpleName();
    /* renamed from: A */
    private int f22647A;
    /* renamed from: B */
    private long f22648B;
    /* renamed from: b */
    private int f22649b = 1;
    /* renamed from: c */
    private String f22650c;
    /* renamed from: d */
    private String f22651d;
    /* renamed from: e */
    private String f22652e;
    /* renamed from: f */
    private String f22653f;
    /* renamed from: g */
    private String f22654g;
    /* renamed from: h */
    private int f22655h;
    /* renamed from: i */
    private int f22656i;
    /* renamed from: j */
    private int f22657j;
    /* renamed from: k */
    private int f22658k;
    /* renamed from: l */
    private int f22659l;
    /* renamed from: m */
    private String f22660m;
    /* renamed from: n */
    private String f22661n;
    /* renamed from: o */
    private String f22662o;
    /* renamed from: p */
    private int f22663p;
    /* renamed from: q */
    private String f22664q;
    /* renamed from: r */
    private String f22665r;
    /* renamed from: s */
    private String f22666s;
    /* renamed from: t */
    private String f22667t;
    /* renamed from: u */
    private String f22668u;
    /* renamed from: v */
    private String f22669v;
    /* renamed from: w */
    private long f22670w;
    /* renamed from: x */
    private int f22671x;
    /* renamed from: y */
    private long f22672y;
    /* renamed from: z */
    private long f22673z;

    public XGLocalMessage() {
        String str = "";
        this.f22650c = str;
        this.f22651d = str;
        this.f22652e = str;
        String str2 = "00";
        this.f22653f = str2;
        this.f22654g = str2;
        this.f22655h = 1;
        this.f22656i = 1;
        this.f22657j = 1;
        this.f22658k = 0;
        this.f22659l = 1;
        this.f22660m = str;
        this.f22661n = str;
        this.f22662o = str;
        this.f22663p = 1;
        this.f22664q = str;
        this.f22665r = str;
        this.f22666s = str;
        this.f22667t = str;
        this.f22668u = str;
        this.f22669v = "{}";
        this.f22671x = 0;
        this.f22672y = System.currentTimeMillis() * -1;
        this.f22673z = 0;
        this.f22647A = 2592000;
        this.f22648B = System.currentTimeMillis() + (((long) this.f22647A) * 1000);
    }

    public long getExpirationTimeMs() {
        return this.f22648B;
    }

    public void setExpirationTimeMs(long j) {
        if (j > System.currentTimeMillis()) {
            this.f22647A = (int) ((j - System.currentTimeMillis()) / 1000);
            if (this.f22647A < 0) {
                this.f22647A = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
            this.f22648B = j;
        }
    }

    public int getTtl() {
        return this.f22647A;
    }

    public int getType() {
        return this.f22649b;
    }

    public void setType(int i) {
        this.f22649b = i;
    }

    public String getTitle() {
        return this.f22650c;
    }

    public void setTitle(String str) {
        this.f22650c = str;
    }

    public String getContent() {
        return this.f22651d;
    }

    public void setContent(String str) {
        this.f22651d = str;
    }

    public void setCustomContent(HashMap<String, Object> hashMap) {
        this.f22669v = new JSONObject(hashMap).toString();
    }

    public String getCustom_content() {
        return this.f22669v;
    }

    public String getHour() {
        if (this.f22653f.length() < 1) {
            return "00";
        }
        if (this.f22653f.length() <= 0 || this.f22653f.length() >= 2) {
            return this.f22653f;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("0");
        sb.append(this.f22653f);
        return sb.toString();
    }

    public void setHour(String str) {
        this.f22653f = str;
    }

    public String getMin() {
        if (this.f22654g.length() < 1) {
            return "00";
        }
        if (this.f22654g.length() <= 0 || this.f22654g.length() >= 2) {
            return this.f22654g;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("0");
        sb.append(this.f22654g);
        return sb.toString();
    }

    public void setMin(String str) {
        this.f22654g = str;
    }

    public long getBuilderId() {
        return this.f22670w;
    }

    public void setBuilderId(long j) {
        this.f22670w = j;
    }

    public String getDate() {
        String str = "XGLocalMessage.getDate()";
        String str2 = "yyyyMMdd";
        if (!C7056i.m30194b(this.f22652e)) {
            try {
                this.f22652e = this.f22652e.substring(0, 8);
                Long.parseLong(this.f22652e);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2);
                simpleDateFormat.setLenient(false);
                simpleDateFormat.parse(this.f22652e);
            } catch (ParseException e) {
                C6864a.m29302d(f22646a, str, e);
                return new SimpleDateFormat(str2).format(new Date());
            } catch (Exception e2) {
                C6864a.m29302d(f22646a, str, e2);
                return new SimpleDateFormat(str2).format(new Date());
            }
        }
        return this.f22652e;
    }

    public void setDate(String str) {
        this.f22652e = str;
    }

    public void setRing(int i) {
        this.f22655h = i;
    }

    public int getRing() {
        return this.f22655h;
    }

    public void setVibrate(int i) {
        this.f22656i = i;
    }

    public int getVibrate() {
        return this.f22656i;
    }

    public void setLights(int i) {
        this.f22657j = i;
    }

    public int getLights() {
        return this.f22657j;
    }

    public void setIcon_type(int i) {
        this.f22658k = i;
    }

    public int getIcon_type() {
        return this.f22658k;
    }

    public void setStyle_id(int i) {
        this.f22659l = i;
    }

    public int getStyle_id() {
        return this.f22659l;
    }

    public void setRing_raw(String str) {
        this.f22660m = str;
    }

    public String getRing_raw() {
        return this.f22660m;
    }

    public void setIcon_res(String str) {
        this.f22661n = str;
    }

    public String getIcon_res() {
        return this.f22661n;
    }

    public void setSmall_icon(String str) {
        this.f22662o = str;
    }

    public String getSmall_icon() {
        return this.f22662o;
    }

    public void setAction_type(int i) {
        this.f22663p = i;
    }

    public int getAction_type() {
        return this.f22663p;
    }

    public void setActivity(String str) {
        this.f22664q = str;
    }

    public String getActivity() {
        return this.f22664q;
    }

    public void setUrl(String str) {
        this.f22665r = str;
    }

    public String getUrl() {
        return this.f22665r;
    }

    public void setIntent(String str) {
        this.f22666s = str;
    }

    public String getIntent() {
        return this.f22666s;
    }

    public void setPackageDownloadUrl(String str) {
        this.f22667t = str;
    }

    public String getPackageDownloadUrl() {
        return this.f22667t;
    }

    public void setPackageName(String str) {
        this.f22668u = str;
    }

    public String getPackageName() {
        return this.f22668u;
    }

    public int getNotificationId() {
        return this.f22671x;
    }

    public void setNotificationId(int i) {
        this.f22671x = i;
    }

    public long getMsgId() {
        return this.f22672y;
    }

    public void setMsgId(long j) {
        this.f22672y = j;
    }

    public long getBusiMsgId() {
        return this.f22673z;
    }

    public void setBusiMsgId(long j) {
        this.f22673z = j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("XGLocalMessage [type=");
        sb.append(this.f22649b);
        sb.append(", title=");
        sb.append(this.f22650c);
        sb.append(", content=");
        sb.append(this.f22651d);
        sb.append(", date=");
        sb.append(this.f22652e);
        sb.append(", hour=");
        sb.append(this.f22653f);
        sb.append(", min=");
        sb.append(this.f22654g);
        sb.append(", builderId=");
        sb.append(this.f22670w);
        sb.append(", msgid=");
        sb.append(this.f22672y);
        sb.append(", busiMsgId=");
        sb.append(this.f22673z);
        sb.append("]");
        return sb.toString();
    }
}
