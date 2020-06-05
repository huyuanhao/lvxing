package com.qiyukf.unicorn.p503f.p504a.p510d;

import android.content.Context;
import android.text.TextUtils;
import com.qiyukf.basesdk.p412c.C5366b;
import com.qiyukf.unicorn.p503f.p504a.C6144e;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6110a;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6111b;
import com.qiyukf.unicorn.p516j.C6211c;
import com.tencent.android.tpush.common.MessageKey;
import org.json.JSONArray;

@C6111b(mo29052a = 43)
/* renamed from: com.qiyukf.unicorn.f.a.d.s */
public class C6138s extends C6144e {
    @C6110a(mo29051a = "content")
    /* renamed from: a */
    private String f19196a;
    @C6110a(mo29051a = "type")
    /* renamed from: b */
    private int f19197b;
    @C6110a(mo29051a = "trashWords")
    /* renamed from: c */
    private transient JSONArray f19198c;
    @C6110a(mo29051a = "auditResult")
    /* renamed from: d */
    private int f19199d;

    /* renamed from: a */
    public final void mo29162a() {
        this.f19197b = 1;
    }

    /* renamed from: a */
    public final void mo29163a(int i) {
        this.f19199d = i;
    }

    /* renamed from: a */
    public final void mo29164a(String str) {
        this.f19196a = str;
    }

    /* renamed from: a */
    public final void mo29165a(JSONArray jSONArray) {
        this.f19198c = jSONArray;
    }

    public String getContent(Context context) {
        if (this.f19197b != 1) {
            return this.f19196a;
        }
        String e = C5366b.m22039e(C5366b.m22027a(this.f19196a), MessageKey.MSG_CONTENT);
        if (TextUtils.isEmpty(e)) {
            e = "";
        }
        return C6211c.m24638a(e).replace("\n", " ");
    }
}
