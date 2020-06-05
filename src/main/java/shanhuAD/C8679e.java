package shanhuAD;

import android.os.Bundle;
import com.tencent.p605ep.shanhuad.adpublic.H5BrowserListener;
import com.tencent.p605ep.shanhuad.adpublic.models.AdMetaInfo;
import com.tencent.qqpim.discovery.AdDisplayModel;
import com.tencent.qqpim.discovery.IH5Browser;

/* renamed from: shanhuAD.e */
public class C8679e implements IH5Browser {
    /* renamed from: gk */
    private H5BrowserListener f29535gk;

    public C8679e(H5BrowserListener h5BrowserListener) {
        this.f29535gk = h5BrowserListener;
    }

    public void openAppDetailPage(AdDisplayModel adDisplayModel) {
        if (this.f29535gk != null) {
            this.f29535gk.openAppDetailPage(new AdMetaInfo(adDisplayModel));
        }
    }

    public void openH5(String str, boolean z, int i, boolean z2, Bundle bundle) {
        H5BrowserListener h5BrowserListener = this.f29535gk;
        if (h5BrowserListener != null) {
            h5BrowserListener.openH5(str);
        }
    }

    public void openMiniProgram(String str, String str2) {
    }
}
