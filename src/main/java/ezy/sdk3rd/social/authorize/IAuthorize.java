package ezy.sdk3rd.social.authorize;

import ezy.sdk3rd.social.sdk.IResult;
import ezy.sdk3rd.social.sdk.OnCallback;

public interface IAuthorize extends IResult {
    void authorize(OnCallback<String> fVar);
}
