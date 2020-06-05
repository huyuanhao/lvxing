package com.p522qq.p523e.ads.nativ;

import com.p522qq.p523e.ads.AbstractAD.BasicADListener;
import java.util.List;

/* renamed from: com.qq.e.ads.nativ.NativeADUnifiedListener */
public interface NativeADUnifiedListener extends BasicADListener {
    void onADLoaded(List<NativeUnifiedADData> list);
}
