package discoveryAD;

import android.content.Context;
import android.os.Bundle;
import com.tencent.qqpim.discovery.AdDisplayModel;
import com.tencent.qqpim.discovery.IH5Browser;

/* renamed from: discoveryAD.Q */
public class C7875Q implements IH5Browser {
    /* renamed from: Nd */
    IH5Browser f26775Nd;
    /* renamed from: Od */
    IH5Browser f26776Od;
    final String TAG = "H5ManagerProxy";
    private Context context;

    public C7875Q(Context context2) {
        this.context = context2.getApplicationContext();
    }

    /* renamed from: a */
    public void mo38150a(IH5Browser iH5Browser) {
        this.f26775Nd = iH5Browser;
    }

    public void openAppDetailPage(AdDisplayModel adDisplayModel) {
        IH5Browser iH5Browser = this.f26775Nd;
        if (iH5Browser == null) {
            C7852Aa.m34154d("H5ManagerProxy", "null == mIH5Browser");
            if (this.f26776Od == null) {
                synchronized (this) {
                    if (this.f26776Od == null) {
                        this.f26776Od = new C7874P(this.context);
                    }
                }
            }
            iH5Browser = this.f26776Od;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("model=");
        sb.append(adDisplayModel);
        C7852Aa.m34154d("H5ManagerProxy", sb.toString());
        iH5Browser.openAppDetailPage(adDisplayModel);
    }

    public void openH5(String str, boolean z, int i, boolean z2, Bundle bundle) {
        IH5Browser iH5Browser = this.f26775Nd;
        if (iH5Browser == null) {
            C7852Aa.m34154d("H5ManagerProxy", "null == mIH5Browser");
            if (this.f26776Od == null) {
                synchronized (this) {
                    if (this.f26776Od == null) {
                        this.f26776Od = new C7874P(this.context);
                    }
                }
            }
            iH5Browser = this.f26776Od;
        }
        IH5Browser iH5Browser2 = iH5Browser;
        StringBuilder sb = new StringBuilder();
        sb.append("url=");
        sb.append(str);
        sb.append(" report=");
        sb.append(z);
        sb.append(" staticpoint=");
        sb.append(i);
        C7852Aa.m34154d("H5ManagerProxy", sb.toString());
        iH5Browser2.openH5(str, z, i, z2, bundle);
    }

    public void openMiniProgram(String str, String str2) {
        IH5Browser iH5Browser = this.f26775Nd;
        if (iH5Browser == null) {
            C7852Aa.m34154d("H5ManagerProxy", "null == mIH5Browser");
            if (this.f26776Od == null) {
                synchronized (this) {
                    if (this.f26776Od == null) {
                        this.f26776Od = new C7874P(this.context);
                    }
                }
            }
            iH5Browser = this.f26776Od;
        }
        iH5Browser.openMiniProgram(str, str2);
    }
}
