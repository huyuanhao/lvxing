package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.core.GlobalInfo;
import com.bytedance.sdk.openadsdk.core.IdUtils;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.util.HashMap;
import java.util.Map;

public abstract class TTSecAbs {
    public String NM_getAppKey() {
        return "df979cdb-05a7-448c-bece-92d5005a1247";
    }

    public String NM_getInstallId() {
        return null;
    }

    public abstract String NM_pullSg();

    public abstract String NM_pullVer(String str);

    public abstract void NM_reportNow(String str);

    public abstract void NM_setParams(String str);

    public String NM_getDeviceId() {
        return IdUtils.m9858a(InternalContainer.m10059a());
    }

    public Map<String, Object> NM_getCustomInfo() {
        if (GlobalInfo.m9616c().mo15675e() == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(ArgKey.KEY_APP_ID, GlobalInfo.m9616c().mo15675e());
        return hashMap;
    }
}
