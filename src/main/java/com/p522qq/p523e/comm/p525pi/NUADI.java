package com.p522qq.p523e.comm.p525pi;

import com.p522qq.p523e.comm.constants.LoadAdParams;
import java.util.List;

/* renamed from: com.qq.e.comm.pi.NUADI */
public interface NUADI extends ADI {
    String getAdNetWorkName();

    void loadData(int i);

    void loadData(int i, LoadAdParams loadAdParams);

    void setCategories(List<String> list);

    void setMaxVideoDuration(int i);

    void setMinVideoDuration(int i);

    void setVastClassName(String str);

    void setVideoADContainerRender(int i);

    void setVideoPlayPolicy(int i);
}
