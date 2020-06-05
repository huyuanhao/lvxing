package discoveryAD;

import com.p522qq.taf.jce.JceStruct;
import com.tencent.p605ep.commonbase.api.Log;
import com.tencent.qqpim.discovery.IProRequestCallback;
import com.tencent.qqpim.discovery.internal.protocol.C7494C;

/* renamed from: discoveryAD.ra */
class C7927ra implements IProRequestCallback {
    C7927ra() {
    }

    public void onCallback(int i, JceStruct jceStruct) {
        StringBuilder sb = new StringBuilder();
        sb.append("errorcode : ");
        sb.append(i);
        String sb2 = sb.toString();
        String str = "sendADGDTReport";
        Log.m31477d(str, sb2);
        C7494C c = (C7494C) jceStruct;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("SCGDTSDKAdReport back : ");
        sb3.append(c.f25106ma);
        Log.m31477d(str, sb3.toString());
    }
}
