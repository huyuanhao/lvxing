package discoveryAD;

import android.text.TextUtils;
import discoveryAD.C7911ka.C7912a;
import java.io.File;

/* renamed from: discoveryAD.ga */
class C7901ga implements C7912a {
    /* renamed from: he */
    final /* synthetic */ String f26897he;
    final /* synthetic */ C7903ha this$0;

    C7901ga(C7903ha haVar, String str) {
        this.this$0 = haVar;
        this.f26897he = str;
    }

    public boolean isMatch(String str) {
        String fileMD5 = C7906ia.getFileMD5(new File(str));
        return !TextUtils.isEmpty(fileMD5) && fileMD5.equalsIgnoreCase(this.f26897he);
    }
}
