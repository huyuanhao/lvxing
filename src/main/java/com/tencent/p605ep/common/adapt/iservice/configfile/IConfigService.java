package com.tencent.p605ep.common.adapt.iservice.configfile;

import java.util.List;

/* renamed from: com.tencent.ep.common.adapt.iservice.configfile.IConfigService */
public interface IConfigService {
    void addObserver(int i, IUpdateObserver iUpdateObserver);

    void addObserver(int[] iArr, IUpdateObserver iUpdateObserver);

    void cancel();

    void check(int i, ICheckListener iCheckListener);

    void check(int[] iArr, ICheckListener iCheckListener);

    void checkUpdate(int i, IUpdateListener iUpdateListener);

    void checkUpdate(int[] iArr, IUpdateListener iUpdateListener);

    String getFileSavePath();

    Object readSync(int i);

    void removeObserver(int i);

    void removeObserver(int[] iArr);

    void update(List<UpdateInfo> list, IUpdateListener iUpdateListener);

    void updateObservers(UpdateInfo updateInfo);
}
