package ezy.sdk3rd.social.payment;

import ezy.sdk3rd.social.sdk.IResult;
import ezy.sdk3rd.social.sdk.OnCallback;

public interface IPayable extends IResult {
    void pay(String str, OnCallback<String> fVar);
}
