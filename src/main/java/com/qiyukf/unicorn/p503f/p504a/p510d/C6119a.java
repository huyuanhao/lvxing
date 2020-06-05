package com.qiyukf.unicorn.p503f.p504a.p510d;

import android.content.Context;
import android.text.TextUtils;
import com.qiyukf.basesdk.p412c.C5366b;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.p502e.C6042a;
import com.qiyukf.unicorn.p502e.C6052j;
import com.qiyukf.unicorn.p503f.p504a.C6144e;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6110a;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6111b;
import com.qiyukf.unicorn.p503f.p504a.p509c.C6115b;
import org.json.JSONObject;

@C6111b(mo29052a = 2)
/* renamed from: com.qiyukf.unicorn.f.a.d.a */
public class C6119a extends C6144e {
    @C6110a(mo29051a = "code")
    /* renamed from: a */
    private int f19114a;
    @C6110a(mo29051a = "exchange")
    /* renamed from: b */
    private String f19115b;
    @C6110a(mo29051a = "staffid")
    /* renamed from: c */
    private String f19116c;
    @C6110a(mo29051a = "staffname")
    /* renamed from: d */
    private String f19117d;
    @C6110a(mo29051a = "old_sessionid")
    /* renamed from: e */
    private long f19118e;
    @C6110a(mo29051a = "groupname")
    /* renamed from: f */
    private String f19119f;
    @C6110a(mo29051a = "iconurl")
    /* renamed from: g */
    private String f19120g;
    @C6110a(mo29051a = "message")
    /* renamed from: h */
    private String f19121h;
    @C6110a(mo29051a = "sessionid")
    /* renamed from: i */
    private long f19122i;
    @C6110a(mo29051a = "before")
    /* renamed from: j */
    private int f19123j;
    @C6110a(mo29051a = "showNum")
    /* renamed from: k */
    private int f19124k;
    @C6110a(mo29051a = "inqueueNotify")
    /* renamed from: l */
    private String f19125l;
    @C6110a(mo29051a = "stafftype")
    /* renamed from: m */
    private int f19126m;
    @C6110a(mo29051a = "operator_enable")
    /* renamed from: n */
    private int f19127n;
    @C6110a(mo29051a = "realStaffid")
    /* renamed from: o */
    private long f19128o;
    @C6110a(mo29051a = "groupid")
    /* renamed from: p */
    private long f19129p;
    @C6110a(mo29051a = "evaluation")
    /* renamed from: q */
    private String f19130q;
    @C6110a(mo29051a = "shop")
    /* renamed from: r */
    private String f19131r;
    @C6110a(mo29051a = "robotInQueue")
    /* renamed from: s */
    private int f19132s;
    @C6110a(mo29051a = "robotSessionId")
    /* renamed from: t */
    private long f19133t;
    @C6110a(mo29051a = "isvipstaff")
    /* renamed from: u */
    private boolean f19134u = false;
    @C6110a(mo29051a = "vipstaffprompt")
    /* renamed from: v */
    private String f19135v;
    @C6110a(mo29051a = "sessionTransferMessage")
    /* renamed from: w */
    private String f19136w;
    /* renamed from: x */
    private C6115b f19137x;
    /* renamed from: y */
    private C6052j f19138y;
    /* renamed from: z */
    private C6042a f19139z;

    /* renamed from: a */
    public final int mo29075a() {
        return this.f19114a;
    }

    /* renamed from: a */
    public final CharSequence mo29076a(Context context) {
        if (this.f19134u) {
            return this.f19135v;
        }
        if (this.f19118e != 0) {
            C6042a aVar = this.f19139z;
            return (aVar == null || !aVar.mo28882b()) ? "" : this.f19136w;
        }
        String string = !TextUtils.isEmpty(this.f19119f) ? context.getString(C5961R.string.ysf_staff_assigned_with_group, new Object[]{this.f19119f, this.f19117d}) : context.getString(C5961R.string.ysf_staff_assigned, new Object[]{this.f19117d});
        if (this.f19126m != 0 || TextUtils.isEmpty(this.f19121h)) {
            return string;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f19121h);
        sb.append(" ");
        sb.append(string);
        return sb.toString();
    }

    /* renamed from: a */
    public final void mo29077a(int i) {
        this.f19114a = i;
    }

    /* renamed from: a */
    public final void mo29078a(long j) {
        this.f19129p = j;
    }

    /* renamed from: a */
    public final void mo29079a(String str) {
        this.f19115b = str;
    }

    /* access modifiers changed from: protected */
    public void afterParse(JSONObject jSONObject) {
        if (!TextUtils.isEmpty(this.f19130q)) {
            this.f19137x = new C6115b();
            JSONObject a = C5366b.m22027a(this.f19130q);
            if (!TextUtils.isEmpty(this.f19131r)) {
                String str = "setting";
                if (C5366b.m22027a(this.f19131r).has(str)) {
                    JSONObject f = C5366b.m22040f(C5366b.m22027a(this.f19131r), str);
                    String str2 = "evaluation_timeout";
                    C5366b.m22030a(a, str2, C5366b.m22037c(f, str2));
                    String str3 = "enable_evaluation_muttimes";
                    C5366b.m22031a(a, str3, (Object) Boolean.valueOf(C5366b.m22033a(f, str3)));
                    String str4 = "session_end_switch";
                    C5366b.m22031a(a, str4, (Object) Boolean.valueOf(C5366b.m22033a(f, str4)));
                    String str5 = "session_open_switch";
                    C5366b.m22031a(a, str5, (Object) Boolean.valueOf(C5366b.m22033a(f, str5)));
                    String str6 = "session_timeout_switch";
                    C5366b.m22031a(a, str6, (Object) Boolean.valueOf(C5366b.m22033a(f, str6)));
                    String str7 = "show_evaluation_button";
                    C5366b.m22031a(a, str7, (Object) Boolean.valueOf(C5366b.m22033a(f, str7)));
                }
            }
            this.f19137x.mo29058a(a);
        }
        if (!TextUtils.isEmpty(this.f19131r)) {
            this.f19138y = new C6052j();
            this.f19138y.mo28907a(this.f19131r);
            this.f19139z = new C6042a();
            this.f19139z.mo28881a(this.f19131r);
        }
    }

    /* renamed from: b */
    public final String mo29080b() {
        return this.f19116c;
    }

    /* renamed from: b */
    public final void mo29081b(int i) {
        this.f19126m = i;
    }

    /* renamed from: b */
    public final void mo29082b(String str) {
        this.f19135v = str;
    }

    /* renamed from: c */
    public final String mo29083c() {
        return this.f19117d;
    }

    /* renamed from: c */
    public final void mo29084c(String str) {
        this.f19116c = str;
    }

    public boolean countToUnread() {
        return true;
    }

    /* renamed from: d */
    public final String mo29085d() {
        return this.f19121h;
    }

    /* renamed from: d */
    public final void mo29086d(String str) {
        this.f19117d = str;
    }

    /* renamed from: e */
    public final long mo29087e() {
        return this.f19122i;
    }

    /* renamed from: e */
    public final void mo29088e(String str) {
        this.f19120g = str;
    }

    /* renamed from: f */
    public final int mo29089f() {
        return this.f19123j;
    }

    /* renamed from: g */
    public final boolean mo29090g() {
        return this.f19124k == 1;
    }

    public String getContent(Context context) {
        StringBuilder sb = new StringBuilder("[");
        sb.append(mo29076a(context));
        sb.append("]");
        return sb.toString();
    }

    /* renamed from: h */
    public final int mo29091h() {
        return this.f19126m;
    }

    /* renamed from: i */
    public final int mo29092i() {
        return this.f19127n;
    }

    /* renamed from: j */
    public final String mo29093j() {
        return this.f19120g;
    }

    /* renamed from: k */
    public final long mo29094k() {
        return this.f19128o;
    }

    /* renamed from: l */
    public final long mo29095l() {
        return this.f19129p;
    }

    /* renamed from: m */
    public final C6115b mo29096m() {
        return this.f19137x;
    }

    /* renamed from: n */
    public final C6052j mo29097n() {
        return this.f19138y;
    }

    /* renamed from: o */
    public final C6042a mo29098o() {
        return this.f19139z;
    }

    /* renamed from: p */
    public final String mo29099p() {
        return this.f19125l;
    }

    /* renamed from: q */
    public final boolean mo29100q() {
        return this.f19114a == 203 && this.f19132s == 1;
    }

    /* renamed from: r */
    public final long mo29101r() {
        return this.f19133t;
    }

    /* renamed from: s */
    public final void mo29102s() {
        this.f19134u = true;
    }
}
