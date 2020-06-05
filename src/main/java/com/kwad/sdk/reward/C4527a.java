package com.kwad.sdk.reward;

import com.kwad.sdk.core.download.p323a.C4089b;
import com.kwad.sdk.core.p320d.C4067b;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.p307b.C3823a;
import com.kwad.sdk.reward.p351a.C4528a;
import com.kwad.sdk.reward.p351a.C4529b;
import com.kwad.sdk.reward.p351a.C4530c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.reward.a */
public class C4527a extends C4067b {
    /* renamed from: a */
    public List<C4528a> f14757a = new ArrayList();
    /* renamed from: b */
    public C4529b f14758b;
    /* renamed from: c */
    public JSONObject f14759c;
    /* renamed from: d */
    public AdTemplate f14760d;
    /* renamed from: e */
    public int f14761e;
    /* renamed from: f */
    public C4089b f14762f;
    /* renamed from: g */
    public C3823a f14763g;
    /* renamed from: h */
    public Set<C4530c> f14764h = new HashSet();

    /* renamed from: a */
    public void mo23367a() {
        this.f14757a.clear();
        this.f14764h.clear();
        C4089b bVar = this.f14762f;
        if (bVar != null) {
            bVar.mo23782d();
        }
        C3823a aVar = this.f14763g;
        if (aVar != null) {
            aVar.mo23222d();
        }
    }
}
