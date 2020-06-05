package com.tencent.p605ep.common.adapt.iservice.configfile;

/* renamed from: com.tencent.ep.common.adapt.iservice.configfile.ICheckListener */
public interface ICheckListener {
    void onCheckCanceled();

    void onCheckEvent(int i);

    void onCheckFinished(CheckResult checkResult);

    void onCheckStarted();
}
