package com.ksad.lottie.p298a.p299a;

import com.ksad.lottie.model.content.ShapeTrimPath;
import com.ksad.lottie.model.content.ShapeTrimPath.Type;
import com.ksad.lottie.model.layer.C3774a;
import com.ksad.lottie.p298a.p300b.C3646a;
import com.ksad.lottie.p298a.p300b.C3646a.C3647a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.ksad.lottie.a.a.r */
public class C3645r implements C3627b, C3647a {
    /* renamed from: a */
    private final String f12523a;
    /* renamed from: b */
    private final List<C3647a> f12524b = new ArrayList();
    /* renamed from: c */
    private final Type f12525c;
    /* renamed from: d */
    private final C3646a<?, Float> f12526d;
    /* renamed from: e */
    private final C3646a<?, Float> f12527e;
    /* renamed from: f */
    private final C3646a<?, Float> f12528f;

    public C3645r(C3774a aVar, ShapeTrimPath shapeTrimPath) {
        this.f12523a = shapeTrimPath.mo23078a();
        this.f12525c = shapeTrimPath.mo23079b();
        this.f12526d = shapeTrimPath.mo23081d().mo23036a();
        this.f12527e = shapeTrimPath.mo23080c().mo23036a();
        this.f12528f = shapeTrimPath.mo23082e().mo23036a();
        aVar.mo23169a(this.f12526d);
        aVar.mo23169a(this.f12527e);
        aVar.mo23169a(this.f12528f);
        this.f12526d.mo22827a((C3647a) this);
        this.f12527e.mo22827a((C3647a) this);
        this.f12528f.mo22827a((C3647a) this);
    }

    /* renamed from: a */
    public void mo22811a() {
        for (int i = 0; i < this.f12524b.size(); i++) {
            ((C3647a) this.f12524b.get(i)).mo22811a();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo22819a(C3647a aVar) {
        this.f12524b.add(aVar);
    }

    /* renamed from: a */
    public void mo22814a(List<C3627b> list, List<C3627b> list2) {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Type mo22820b() {
        return this.f12525c;
    }

    /* renamed from: c */
    public C3646a<?, Float> mo22821c() {
        return this.f12526d;
    }

    /* renamed from: d */
    public C3646a<?, Float> mo22822d() {
        return this.f12527e;
    }

    /* renamed from: e */
    public C3646a<?, Float> mo22823e() {
        return this.f12528f;
    }
}
