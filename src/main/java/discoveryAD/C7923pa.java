package discoveryAD;

import com.p522qq.taf.jce.JceStruct;
import com.tencent.p605ep.common.adapt.iservice.net.ISharkCallBack;
import com.tencent.p605ep.commonbase.api.Log;
import com.tencent.qqpim.discovery.IProRequestCallback;

/* renamed from: discoveryAD.pa */
class C7923pa implements ISharkCallBack {
    /* renamed from: mg */
    final /* synthetic */ IProRequestCallback f26945mg;

    C7923pa(IProRequestCallback iProRequestCallback) {
        this.f26945mg = iProRequestCallback;
    }

    public void onFinish(int i, int i2, int i3, int i4, JceStruct jceStruct) {
        StringBuilder sb = new StringBuilder();
        sb.append("seqNo : ");
        sb.append(i);
        sb.append(" , cmdID : ");
        sb.append(i2);
        sb.append(" , retCode : ");
        sb.append(i3);
        String str = " ,dataRetCode : ";
        sb.append(str);
        sb.append(i4);
        Log.m31477d("sharkInfo", sb.toString());
        if (!(i3 == 0 && i4 == 0)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("网络错误 ,retCode : ");
            sb2.append(i3);
            sb2.append(str);
            sb2.append(i4);
            sb2.append(" ,id : ");
            sb2.append(i2);
            C7852Aa.m34150L(sb2.toString());
        }
        this.f26945mg.onCallback(C7929sa.m34343e(i3, i4), jceStruct);
    }
}
