package com.tencent.p605ep.common.adapt.iservice.configfile;

import java.util.List;

/* renamed from: com.tencent.ep.common.adapt.iservice.configfile.IUpdateListener */
public interface IUpdateListener {
    void onProgressChanged(UpdateInfo updateInfo, int i);

    void onUpdateCanceled();

    void onUpdateEvent(UpdateInfo updateInfo, int i);

    void onUpdateFinished(List<UpdateInfo> list);

    void onUpdateStarted();
}
