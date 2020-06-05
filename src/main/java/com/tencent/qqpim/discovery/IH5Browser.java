package com.tencent.qqpim.discovery;

import android.os.Bundle;

public interface IH5Browser {
    void openAppDetailPage(AdDisplayModel adDisplayModel);

    void openH5(String str, boolean z, int i, boolean z2, Bundle bundle);

    void openMiniProgram(String str, String str2);
}
