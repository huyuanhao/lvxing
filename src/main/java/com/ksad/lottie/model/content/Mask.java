package com.ksad.lottie.model.content;

import com.ksad.lottie.model.p305a.C3746d;
import com.ksad.lottie.model.p305a.C3750h;

public class Mask {
    /* renamed from: a */
    private final MaskMode f12739a;
    /* renamed from: b */
    private final C3750h f12740b;
    /* renamed from: c */
    private final C3746d f12741c;

    /* renamed from: com.ksad.lottie.model.content.Mask$MaskMode */
    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, C3750h hVar, C3746d dVar) {
        this.f12739a = maskMode;
        this.f12740b = hVar;
        this.f12741c = dVar;
    }

    /* renamed from: a */
    public MaskMode mo23052a() {
        return this.f12739a;
    }

    /* renamed from: b */
    public C3750h mo23053b() {
        return this.f12740b;
    }

    /* renamed from: c */
    public C3746d mo23054c() {
        return this.f12741c;
    }
}
