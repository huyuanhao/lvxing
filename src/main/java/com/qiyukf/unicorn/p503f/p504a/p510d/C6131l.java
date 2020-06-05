package com.qiyukf.unicorn.p503f.p504a.p510d;

import android.content.Context;
import android.text.TextUtils;
import com.qiyukf.basesdk.p412c.C5366b;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.p502e.C6050h;
import com.qiyukf.unicorn.p503f.p504a.C6113c;
import com.qiyukf.unicorn.p503f.p504a.C6144e;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6110a;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6111b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@C6111b(mo29052a = 60)
/* renamed from: com.qiyukf.unicorn.f.a.d.l */
public class C6131l extends C6144e implements C6113c {
    @C6110a(mo29051a = "answer_label")
    /* renamed from: a */
    private String f19161a;
    @C6110a(mo29051a = "answer_flag")
    /* renamed from: b */
    private int f19162b;
    @C6110a(mo29051a = "answer_list")
    /* renamed from: c */
    private String f19163c;
    @C6110a(mo29051a = "operator_hint_desc")
    /* renamed from: d */
    private String f19164d;
    @C6110a(mo29051a = "evaluation")
    /* renamed from: e */
    private int f19165e;
    @C6110a(mo29051a = "evaluation_reason")
    /* renamed from: f */
    private int f19166f;
    @C6110a(mo29051a = "evaluation_guide")
    /* renamed from: g */
    private String f19167g;
    @C6110a(mo29051a = "evaluation_content")
    /* renamed from: h */
    private String f19168h;
    /* renamed from: i */
    private List<C6050h> f19169i;
    /* renamed from: j */
    private long f19170j;

    /* renamed from: a */
    public final String mo29124a() {
        return this.f19161a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0063  */
    /* renamed from: a */
    public final java.lang.String mo29035a(android.content.Context r5) {
        /*
        r4 = this;
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r1 = r4.f19161a
        boolean r1 = android.text.TextUtils.isEmpty(r1)
        java.lang.String r2 = "\r\n"
        if (r1 == 0) goto L_0x002d
        java.util.List<com.qiyukf.unicorn.e.h> r1 = r4.f19169i
        if (r1 == 0) goto L_0x002d
        int r1 = r1.size()
        r3 = 1
        if (r1 != r3) goto L_0x002d
        java.util.List<com.qiyukf.unicorn.e.h> r1 = r4.f19169i
        r3 = 0
        java.lang.Object r1 = r1.get(r3)
        com.qiyukf.unicorn.e.h r1 = (com.qiyukf.unicorn.p502e.C6050h) r1
        java.lang.String r1 = r1.f18929c
        java.lang.String r1 = com.qiyukf.unicorn.p516j.C6211c.m24638a(r1)
        r0.append(r1)
        goto L_0x005b
    L_0x002d:
        java.lang.String r1 = r4.f19161a
        boolean r1 = android.text.TextUtils.isEmpty(r1)
        if (r1 != 0) goto L_0x003e
        java.lang.String r1 = r4.f19161a
        java.lang.String r1 = com.qiyukf.unicorn.p516j.C6211c.m24638a(r1)
        r0.append(r1)
    L_0x003e:
        java.util.List<com.qiyukf.unicorn.e.h> r1 = r4.f19169i
        if (r1 == 0) goto L_0x005b
        java.util.Iterator r1 = r1.iterator()
    L_0x0046:
        boolean r3 = r1.hasNext()
        if (r3 == 0) goto L_0x005b
        java.lang.Object r3 = r1.next()
        com.qiyukf.unicorn.e.h r3 = (com.qiyukf.unicorn.p502e.C6050h) r3
        r0.append(r2)
        java.lang.String r3 = r3.f18928b
        r0.append(r3)
        goto L_0x0046
    L_0x005b:
        java.lang.String r1 = r4.f19164d
        boolean r1 = android.text.TextUtils.isEmpty(r1)
        if (r1 != 0) goto L_0x007e
        int r1 = r0.length()
        if (r1 <= 0) goto L_0x006c
        r0.append(r2)
    L_0x006c:
        boolean r1 = r4.mo29129b()
        if (r1 == 0) goto L_0x0079
        java.lang.String r1 = r4.f19164d
        java.lang.String r1 = com.qiyukf.unicorn.p516j.C6211c.m24638a(r1)
        goto L_0x007b
    L_0x0079:
        java.lang.String r1 = r4.f19164d
    L_0x007b:
        r0.append(r1)
    L_0x007e:
        java.lang.String r0 = r0.toString()
        r1 = 0
        android.text.SpannableString r5 = com.qiyukf.nim.uikit.session.emoji.C5543f.m22548b(r5, r0, r1)
        java.lang.String r5 = r5.toString()
        return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.unicorn.p503f.p504a.p510d.C6131l.mo29035a(android.content.Context):java.lang.String");
    }

    /* renamed from: a */
    public final void mo29125a(int i) {
        this.f19165e = i;
    }

    /* renamed from: a */
    public final void mo29126a(long j) {
        this.f19170j = j;
    }

    /* renamed from: a */
    public final void mo29127a(String str) {
        this.f19168h = str;
    }

    /* access modifiers changed from: protected */
    public void afterParse(JSONObject jSONObject) {
        this.f19170j = C5366b.m22037c(jSONObject, "sessionid");
        JSONArray b = C5366b.m22035b(this.f19163c);
        if (b != null) {
            this.f19169i = new ArrayList(b.length());
            for (int i = 0; i < b.length(); i++) {
                JSONObject b2 = C5366b.m22036b(b, i);
                C6050h hVar = new C6050h();
                hVar.f18927a = C5366b.m22037c(b2, "id");
                hVar.f18928b = C5366b.m22039e(b2, "question");
                hVar.f18929c = C5366b.m22039e(b2, "answer");
                hVar.f18930d = C5366b.m22034b(b2, "answer_flag");
                this.f19169i.add(hVar);
            }
        }
    }

    /* renamed from: b */
    public final String mo29128b(Context context) {
        return TextUtils.isEmpty(this.f19167g) ? context.getString(C5961R.string.ysf_message_robot_evaluation_guide) : this.f19167g;
    }

    /* renamed from: b */
    public final boolean mo29129b() {
        return (this.f19162b & 2) == 2;
    }

    /* renamed from: c */
    public final String mo29130c() {
        return this.f19164d;
    }

    public boolean countToUnread() {
        return true;
    }

    /* renamed from: d */
    public final List<C6050h> mo29131d() {
        return this.f19169i;
    }

    /* renamed from: e */
    public final int mo29132e() {
        return this.f19165e;
    }

    /* renamed from: f */
    public final String mo29133f() {
        return this.f19168h;
    }

    /* renamed from: g */
    public final long mo29134g() {
        return this.f19170j;
    }

    public String getContent(Context context) {
        return mo29035a(context).replace("\n", " ");
    }

    /* renamed from: h */
    public final boolean mo29135h() {
        return this.f19166f == 1;
    }

    /* access modifiers changed from: protected */
    public JSONObject toJsonObject(boolean z) {
        JSONObject jsonObject = super.toJsonObject(z);
        if (!z) {
            C5366b.m22030a(jsonObject, "sessionid", this.f19170j);
        }
        return jsonObject;
    }
}
