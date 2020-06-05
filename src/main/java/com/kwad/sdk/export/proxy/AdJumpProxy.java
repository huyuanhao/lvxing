package com.kwad.sdk.export.proxy;

import android.content.Context;
import android.os.Bundle;
import com.kwad.sdk.core.response.model.AdInfo.AdvertiserInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

public interface AdJumpProxy {
    boolean handleAdWebViewJump(Context context, String str, AdTemplate adTemplate, Bundle bundle);

    boolean handleUserInfoJump(Context context, AdvertiserInfo advertiserInfo, Bundle bundle);
}
