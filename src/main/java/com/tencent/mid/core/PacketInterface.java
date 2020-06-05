package com.tencent.mid.core;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class PacketInterface {
    public static final int TYPE_CHECK_MID = 3;
    public static final int TYPE_REQUEST_MID = 2;
    protected Context context = null;

    public abstract int getType();

    public abstract void onEncode(JSONObject jSONObject) throws JSONException;

    protected PacketInterface(Context context2) {
        this.context = context2.getApplicationContext();
    }

    public JSONObject encode(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        jSONObject.put("et", getType());
        onEncode(jSONObject);
        return jSONObject;
    }
}
