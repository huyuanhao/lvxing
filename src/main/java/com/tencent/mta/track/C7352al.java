package com.tencent.mta.track;

import android.os.Message;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.al */
class C7352al implements C7388s {
    /* renamed from: a */
    final /* synthetic */ C7350aj f24887a;

    private C7352al(C7350aj ajVar) {
        this.f24887a = ajVar;
    }

    /* renamed from: a */
    public void mo35867a(JSONObject jSONObject, int i) {
        Message obtainMessage = this.f24887a.f24883g.obtainMessage(2);
        obtainMessage.obj = jSONObject;
        obtainMessage.arg1 = i;
        this.f24887a.f24883g.sendMessage(obtainMessage);
    }

    /* renamed from: b */
    public void mo35868b(JSONObject jSONObject, int i) {
        Message obtainMessage = this.f24887a.f24883g.obtainMessage(6);
        obtainMessage.obj = jSONObject;
        obtainMessage.arg1 = i;
        this.f24887a.f24883g.sendMessage(obtainMessage);
    }

    /* renamed from: c */
    public void mo35869c(JSONObject jSONObject, int i) {
        Message obtainMessage = this.f24887a.f24883g.obtainMessage(4);
        obtainMessage.obj = jSONObject;
        obtainMessage.arg1 = i;
        this.f24887a.f24883g.sendMessage(obtainMessage);
    }

    /* renamed from: a */
    public void mo35866a() {
        C7350aj.f24877a = false;
        this.f24887a.f24883g.sendMessage(this.f24887a.f24883g.obtainMessage(13));
    }
}
