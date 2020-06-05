package com.tencent.p607mm.opensdk.diffdev.p609a;

import com.tencent.p607mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.p607mm.opensdk.diffdev.OAuthListener;
import com.tencent.p607mm.opensdk.utils.Log;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.opensdk.diffdev.a.b */
final class C7326b implements OAuthListener {
    /* renamed from: f */
    final /* synthetic */ C7325a f24801f;

    C7326b(C7325a aVar) {
        this.f24801f = aVar;
    }

    public final void onAuthFinish(OAuthErrCode oAuthErrCode, String str) {
        Log.m31626d("MicroMsg.SDK.ListenerWrapper", String.format("onAuthFinish, errCode = %s, authCode = %s", new Object[]{oAuthErrCode.toString(), str}));
        this.f24801f.f24799d = null;
        ArrayList<OAuthListener> arrayList = new ArrayList<>();
        arrayList.addAll(this.f24801f.f24798c);
        for (OAuthListener onAuthFinish : arrayList) {
            onAuthFinish.onAuthFinish(oAuthErrCode, str);
        }
    }

    public final void onAuthGotQrcode(String str, byte[] bArr) {
        StringBuilder sb = new StringBuilder("onAuthGotQrcode, qrcodeImgPath = ");
        sb.append(str);
        Log.m31626d("MicroMsg.SDK.ListenerWrapper", sb.toString());
        ArrayList<OAuthListener> arrayList = new ArrayList<>();
        arrayList.addAll(this.f24801f.f24798c);
        for (OAuthListener onAuthGotQrcode : arrayList) {
            onAuthGotQrcode.onAuthGotQrcode(str, bArr);
        }
    }

    public final void onQrcodeScanned() {
        Log.m31626d("MicroMsg.SDK.ListenerWrapper", "onQrcodeScanned");
        if (this.f24801f.handler != null) {
            this.f24801f.handler.post(new C7327c(this));
        }
    }
}
