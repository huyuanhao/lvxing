package discoveryAD;

import com.tencent.qqpim.discovery.IConch.CommonConchArgs;
import com.tencent.qqpim.discovery.IConch.IConchPushListener;

/* renamed from: discoveryAD.E */
class C7860E extends IConchPushListener {
    final /* synthetic */ C7861F this$0;

    C7860E(C7861F f) {
        this.this$0 = f;
    }

    public void onRecvPush(int i, CommonConchArgs commonConchArgs) {
        int i2;
        if (commonConchArgs != null) {
            if (i == 1) {
                try {
                    i2 = Integer.valueOf(commonConchArgs.arg0).intValue();
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    i2 = -1;
                }
                if (-1 != i2) {
                    C7862G.getInstance().mo38133fb().mo38205P(i2);
                }
            } else if (i == 2) {
                try {
                    Integer.valueOf(commonConchArgs.arg0).intValue();
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
