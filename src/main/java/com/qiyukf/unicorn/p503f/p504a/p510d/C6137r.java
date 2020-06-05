package com.qiyukf.unicorn.p503f.p504a.p510d;

import android.content.Context;
import android.text.TextUtils;
import com.qiyukf.basesdk.p412c.C5366b;
import com.qiyukf.nim.uikit.session.emoji.C5543f;
import com.qiyukf.unicorn.p502e.C6043b;
import com.qiyukf.unicorn.p502e.C6052j;
import com.qiyukf.unicorn.p503f.p504a.C6113c;
import com.qiyukf.unicorn.p503f.p504a.C6144e;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6110a;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6111b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@C6111b(mo29052a = 90)
/* renamed from: com.qiyukf.unicorn.f.a.d.r */
public class C6137r extends C6144e implements C6113c {
    @C6110a(mo29051a = "message")
    /* renamed from: a */
    private String f19188a;
    @C6110a(mo29051a = "iconurl")
    /* renamed from: b */
    private String f19189b;
    @C6110a(mo29051a = "entries")
    /* renamed from: c */
    private String f19190c;
    @C6110a(mo29051a = "shop")
    /* renamed from: d */
    private String f19191d;
    /* renamed from: e */
    private List<C6043b> f19192e;
    /* renamed from: f */
    private boolean f19193f;
    /* renamed from: g */
    private C6052j f19194g;
    @C6110a(mo29051a = "isShown")
    /* renamed from: h */
    private boolean f19195h;

    /* renamed from: a */
    public final String mo29154a() {
        return this.f19188a;
    }

    /* renamed from: a */
    public final String mo29035a(Context context) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.f19188a)) {
            sb.append(this.f19188a);
        }
        List<C6043b> list = this.f19192e;
        if (list != null) {
            for (C6043b bVar : list) {
                sb.append("\r\n");
                sb.append(bVar.f18900c);
            }
        }
        return C5543f.m22548b(context, sb.toString(), null).toString();
    }

    /* access modifiers changed from: protected */
    public void afterParse(JSONObject jSONObject) {
        JSONArray b = C5366b.m22035b(this.f19190c);
        if (b != null) {
            this.f19192e = new ArrayList(b.length());
            for (int i = 0; i < b.length(); i++) {
                C6043b bVar = new C6043b();
                JSONObject b2 = C5366b.m22036b(b, i);
                bVar.f18898a = C5366b.m22034b(b2, "type");
                bVar.f18899b = C5366b.m22037c(b2, "id");
                if (bVar.f18898a == 1) {
                    bVar.mo28884a(bVar.f18899b);
                } else if (bVar.f18898a == 2) {
                    bVar.mo28886b(bVar.f18899b);
                }
                bVar.f18900c = C5366b.m22039e(b2, "label");
                bVar.f18901d = C5366b.m22037c(b2, "entryid");
                this.f19192e.add(bVar);
            }
        }
        if (!TextUtils.isEmpty(this.f19191d)) {
            this.f19194g = new C6052j();
            this.f19194g.mo28907a(this.f19191d);
        }
        String str = "clickable";
        if (jSONObject.has(str)) {
            this.f19193f = C5366b.m22033a(jSONObject, str);
        } else {
            this.f19193f = true;
        }
    }

    /* renamed from: b */
    public final String mo29155b() {
        return this.f19189b;
    }

    /* renamed from: c */
    public final List<C6043b> mo29156c() {
        return this.f19192e;
    }

    /* renamed from: d */
    public final boolean mo29157d() {
        return this.f19193f;
    }

    /* renamed from: e */
    public final void mo29158e() {
        this.f19193f = false;
    }

    /* renamed from: f */
    public final C6052j mo29159f() {
        return this.f19194g;
    }

    /* renamed from: g */
    public final boolean mo29160g() {
        return this.f19195h;
    }

    public String getContent(Context context) {
        StringBuilder sb = new StringBuilder("[");
        sb.append(mo29035a(context).replace("\n", " "));
        sb.append("]");
        return sb.toString();
    }

    /* renamed from: h */
    public final void mo29161h() {
        this.f19195h = true;
    }

    /* access modifiers changed from: protected */
    public JSONObject toJsonObject(boolean z) {
        JSONObject jsonObject = super.toJsonObject(z);
        if (!z) {
            C5366b.m22031a(jsonObject, "clickable", (Object) Boolean.valueOf(this.f19193f));
            C5366b.m22031a(jsonObject, "isShown", (Object) Boolean.valueOf(this.f19195h));
        }
        return jsonObject;
    }
}
