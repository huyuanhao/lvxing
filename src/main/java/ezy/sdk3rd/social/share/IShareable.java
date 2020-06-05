package ezy.sdk3rd.social.share;

import ezy.sdk3rd.social.sdk.IResult;
import ezy.sdk3rd.social.sdk.OnCallback;

public interface IShareable extends IResult {
    void share(ShareData aVar, OnCallback<String> fVar);
}
