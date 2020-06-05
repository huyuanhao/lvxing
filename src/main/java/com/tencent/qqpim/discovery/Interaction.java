package com.tencent.qqpim.discovery;

import android.os.Bundle;
import android.view.View;

public interface Interaction {
    void notifyClose(boolean z, AdDisplayModel adDisplayModel);

    void registerViewForInteraction(View view, AdDisplayModel adDisplayModel);

    void registerViewForInteraction(View view, AdDisplayModel adDisplayModel, Bundle bundle);

    void unregisterViewForInteraction(View view);
}
