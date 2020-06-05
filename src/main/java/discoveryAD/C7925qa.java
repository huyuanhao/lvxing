package discoveryAD;

import com.p522qq.taf.jce.JceStruct;
import com.tencent.p605ep.commonbase.api.Log;
import com.tencent.qqpim.discovery.IProRequestCallback;

/* renamed from: discoveryAD.qa */
class C7925qa implements IProRequestCallback {
    C7925qa() {
    }

    public void onCallback(int i, JceStruct jceStruct) {
        StringBuilder sb = new StringBuilder();
        sb.append("outer interrface : ");
        sb.append(i);
        Log.m31477d("sendAdReport", sb.toString());
    }
}
