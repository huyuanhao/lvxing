package com.tencent.mid.core;

import android.content.Context;
import com.tencent.bigdata.dataacquisition.CustomDeviceInfos;
import com.tencent.mid.api.MidConstants;
import com.tencent.mid.api.MidEntity;
import com.tencent.mid.sotrage.UnifiedStorage;
import com.tencent.mid.util.Env;
import com.tencent.mid.util.Util;
import org.json.JSONException;
import org.json.JSONObject;

public class RequestPacket extends PacketInterface {
    /* access modifiers changed from: protected */
    public int getType() {
        return 2;
    }

    protected RequestPacket(Context context) {
        super(context);
    }

    private String getJsonStr(String str) {
        return !Util.isEmpty(str) ? str : "-";
    }

    /* access modifiers changed from: protected */
    public void onEncode(JSONObject jSONObject) throws JSONException {
        String str = "0";
        String str2 = "mid";
        jSONObject.put(str2, str);
        jSONObject.put(MidEntity.TAG_IMEI, getJsonStr(CustomDeviceInfos.getDeviceId(this.context)));
        jSONObject.put("imsi", getJsonStr(CustomDeviceInfos.getImsi(this.context)));
        jSONObject.put(MidEntity.TAG_MAC, getJsonStr(CustomDeviceInfos.getMacAddress(this.context)));
        jSONObject.put("ts", System.currentTimeMillis() / 1000);
        MidEntity localMidEntity = ServiceIMPL.getLocalMidEntity(this.context);
        if (localMidEntity != null && localMidEntity.isMidValid()) {
            jSONObject.put(str2, localMidEntity.getMid());
        }
        String readNewVersionMidStr = UnifiedStorage.getInstance(this.context).readNewVersionMidStr();
        boolean isMidValid = Util.isMidValid(readNewVersionMidStr);
        String str3 = MidConstants.NEW_MID_TAG;
        if (isMidValid) {
            jSONObject.put(str3, readNewVersionMidStr);
        } else {
            jSONObject.put(str3, str);
        }
        try {
            new Env(this.context).encode(jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
