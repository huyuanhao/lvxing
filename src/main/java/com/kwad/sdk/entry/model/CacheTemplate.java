package com.kwad.sdk.entry.model;

import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.UUID;

public class CacheTemplate extends AdTemplate {
    public long mMirroPosId;

    public CacheTemplate(AdTemplate adTemplate) {
        this.posId = adTemplate.posId;
        this.type = adTemplate.type;
        this.contentType = adTemplate.contentType;
        this.adInfoList = adTemplate.adInfoList;
        this.photoInfo = adTemplate.photoInfo;
        this.needHide = adTemplate.needHide;
        this.llsid = adTemplate.llsid;
        this.mUniqueId = String.valueOf(UUID.randomUUID());
        this.mPvReported = adTemplate.mPvReported;
        this.mDownloadFinishReported = adTemplate.mDownloadFinishReported;
        this.mAdScene = adTemplate.mAdScene;
    }
}
