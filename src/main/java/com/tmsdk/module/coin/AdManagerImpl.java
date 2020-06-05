package com.tmsdk.module.coin;

import com.tmsdk.module.coin.AdConfig.BUSINESS;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AdManagerImpl {
    /* renamed from: A */
    private Map<Integer, AdCoinConfigItem> f25867A = new HashMap();
    /* renamed from: y */
    private final Object f25868y = new Object();
    /* renamed from: z */
    private List<AdCoinConfigItem> f25869z = new ArrayList();

    public AdManagerImpl() {
        String str = "AdManagerImpl";
        TmsLog.m32944v(str, str);
        try {
            m32914a(TMSDKContext.getsExtraJO().getJSONArray("adconfig"));
            AdConfigManager.configCoinAd(this.f25869z);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m32914a(JSONArray jSONArray) {
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                AdCoinConfigItem adCoinConfigItem = new AdCoinConfigItem();
                adCoinConfigItem.business = BUSINESS.valueOf(jSONObject.getString("business"));
                adCoinConfigItem.positionId = jSONObject.getInt("positionId");
                adCoinConfigItem.taskType = jSONObject.getInt("taskType");
                adCoinConfigItem.sceneId = jSONObject.getString("sceneID");
                JSONArray jSONArray2 = jSONObject.getJSONArray("styleId");
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    adCoinConfigItem.styleIds.add(Integer.valueOf(jSONArray2.getInt(i2)));
                }
                this.f25869z.add(adCoinConfigItem);
                this.f25867A.put(Integer.valueOf(adCoinConfigItem.taskType), adCoinConfigItem);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void init() {
        TmsLog.m32944v("AdManagerImpl", "init");
    }

    public synchronized void release() {
        TmsLog.m32944v("AdManagerImpl", "release");
    }
}
