package com.qiyukf.unicorn.p503f.p504a.p511e;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import com.qiyukf.basesdk.p412c.C5366b;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.C6010b;
import com.qiyukf.unicorn.p503f.p504a.C6144e;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6110a;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6111b;
import com.qiyukf.unicorn.p503f.p504a.p509c.C6115b;
import com.qiyukf.unicorn.p503f.p504a.p509c.C6116c;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@C6111b(mo29052a = 51)
/* renamed from: com.qiyukf.unicorn.f.a.e.d */
public class C6148d extends C6144e {
    @C6110a(mo29051a = "evaluation")
    /* renamed from: a */
    private int f19220a;
    @C6110a(mo29051a = "fromType")
    /* renamed from: b */
    private String f19221b;
    @C6110a(mo29051a = "sessionid")
    /* renamed from: c */
    private long f19222c;
    @C6110a(mo29051a = "remarks")
    /* renamed from: d */
    private String f19223d;
    @C6110a(mo29051a = "evaluationTimes")
    /* renamed from: e */
    private int f19224e;
    /* renamed from: f */
    private C6115b f19225f;
    /* renamed from: g */
    private List<String> f19226g;

    /* renamed from: a */
    public final CharSequence mo29184a(Context context) {
        if (!mo29190a()) {
            return !TextUtils.isEmpty(this.f19225f.mo29061d()) ? this.f19225f.mo29061d() : context.getString(C5961R.string.ysf_evaluation_message_item_text);
        }
        String str = null;
        if (C6010b.m23913a().mo28845b() != null) {
            C6010b.m23913a();
            if (!TextUtils.isEmpty(null)) {
                C6010b.m23913a();
                return null;
            }
        }
        int i = this.f19220a;
        Iterator it = this.f19225f.mo29063f().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            C6116c cVar = (C6116c) it.next();
            if (i == cVar.mo29071d()) {
                str = cVar.mo29070c();
                break;
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = context.getString(i == 1 ? C5961R.string.ysf_evaluation_dissatisfied : C5961R.string.ysf_evaluation_satisfied);
        }
        String str2 = " ";
        if (!TextUtils.isEmpty(this.f19225f.mo29062e())) {
            String e = this.f19225f.mo29062e();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(new StyleSpan(1), 0, spannableStringBuilder.length(), 33);
            String str3 = "#选择项#";
            if (e.contains(str3)) {
                StringBuilder sb = new StringBuilder(str2);
                sb.append(spannableStringBuilder);
                sb.append(str2);
                e = e.replace(str3, sb.toString());
            }
            return e;
        }
        String string = context.getString(C5961R.string.ysf_evaluation_result_default_prefix);
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        spannableStringBuilder2.append(string).append(str2).append(spannableString).append(str2).append(context.getString(C5961R.string.ysf_evaluation_result_suffix));
        return spannableStringBuilder2;
    }

    /* renamed from: a */
    public final void mo29185a(int i) {
        this.f19220a = i;
    }

    /* renamed from: a */
    public final void mo29186a(long j) {
        this.f19222c = j;
    }

    /* renamed from: a */
    public final void mo29187a(C6115b bVar) {
        this.f19225f = bVar;
    }

    /* renamed from: a */
    public final void mo29188a(String str) {
        this.f19221b = str;
    }

    /* renamed from: a */
    public final void mo29189a(List<String> list) {
        this.f19226g = list;
    }

    /* renamed from: a */
    public final boolean mo29190a() {
        return this.f19220a != -1;
    }

    /* access modifiers changed from: protected */
    public void afterParse(JSONObject jSONObject) {
        JSONObject f = C5366b.m22040f(jSONObject, "evaluation_setting");
        if (f != null) {
            this.f19225f = new C6115b();
            this.f19225f.mo29058a(f);
            return;
        }
        this.f19225f = C6115b.m24278a();
    }

    /* renamed from: b */
    public final int mo29191b() {
        return this.f19220a;
    }

    /* renamed from: b */
    public final void mo29192b(int i) {
        this.f19224e = i;
    }

    /* renamed from: b */
    public final void mo29193b(String str) {
        this.f19223d = str;
    }

    /* renamed from: c */
    public final long mo29194c() {
        return this.f19222c;
    }

    public boolean countToUnread() {
        return true;
    }

    /* renamed from: d */
    public final String mo29195d() {
        return this.f19223d;
    }

    /* renamed from: e */
    public final C6115b mo29196e() {
        return this.f19225f;
    }

    /* renamed from: f */
    public final int mo29197f() {
        return this.f19224e;
    }

    public String getContent(Context context) {
        StringBuilder sb = new StringBuilder("[");
        sb.append(mo29184a(context).toString());
        sb.append("]");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public JSONObject toJsonObject(boolean z) {
        String str;
        Object obj;
        JSONObject jsonObject = super.toJsonObject(z);
        if (!z) {
            str = "evaluation_setting";
            obj = this.f19225f.mo29059b();
        } else {
            if (this.f19226g != null) {
                JSONArray jSONArray = new JSONArray();
                for (String put : this.f19226g) {
                    jSONArray.put(put);
                }
                str = "tagList";
                obj = jSONArray;
            }
            return jsonObject;
        }
        C5366b.m22031a(jsonObject, str, obj);
        return jsonObject;
    }
}
