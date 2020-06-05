package com.bytedance.sdk.openadsdk.core;

import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.INativeVideoController;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;

/* renamed from: com.bytedance.sdk.openadsdk.core.u */
public class SingleAppData {
    /* renamed from: a */
    private static SingleAppData f7918a;
    /* renamed from: b */
    private INativeVideoController f7919b;
    /* renamed from: c */
    private boolean f7920c = true;
    /* renamed from: d */
    private MaterialMeta f7921d;
    /* renamed from: e */
    private RewardAdInteractionListener f7922e;
    /* renamed from: f */
    private ITTDownloadAdapter f7923f;
    /* renamed from: g */
    private FullScreenVideoAdInteractionListener f7924g;
    /* renamed from: h */
    private boolean f7925h = false;

    private SingleAppData() {
    }

    /* renamed from: a */
    public static SingleAppData m10160a() {
        if (f7918a == null) {
            f7918a = new SingleAppData();
        }
        return f7918a;
    }

    /* renamed from: a */
    public void mo15934a(boolean z) {
        this.f7920c = z;
    }

    /* renamed from: b */
    public boolean mo15936b() {
        return this.f7920c;
    }

    /* renamed from: c */
    public MaterialMeta mo15937c() {
        return this.f7921d;
    }

    /* renamed from: a */
    public void mo15932a(MaterialMeta kVar) {
        this.f7921d = kVar;
    }

    /* renamed from: d */
    public RewardAdInteractionListener mo15938d() {
        return this.f7922e;
    }

    /* renamed from: e */
    public FullScreenVideoAdInteractionListener mo15939e() {
        return this.f7924g;
    }

    /* renamed from: a */
    public void mo15930a(FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.f7924g = fullScreenVideoAdInteractionListener;
    }

    /* renamed from: a */
    public void mo15931a(RewardAdInteractionListener rewardAdInteractionListener) {
        this.f7922e = rewardAdInteractionListener;
    }

    /* renamed from: f */
    public ITTDownloadAdapter mo15940f() {
        return this.f7923f;
    }

    /* renamed from: a */
    public void mo15933a(ITTDownloadAdapter aVar) {
        this.f7923f = aVar;
    }

    /* renamed from: b */
    public void mo15935b(boolean z) {
        this.f7925h = z;
    }

    /* renamed from: g */
    public void mo15941g() {
        this.f7919b = null;
        this.f7921d = null;
        this.f7922e = null;
        this.f7924g = null;
        this.f7923f = null;
        this.f7925h = false;
        this.f7920c = true;
    }
}
