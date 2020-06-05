package com.tencent.mid.core;

import org.json.JSONException;
import org.json.JSONObject;

public class HttpResponseResult {
    private int code = -1;
    private JSONObject data = null;

    public HttpResponseResult(int i, String str) {
        this.code = i;
        try {
            this.data = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public int getCode() {
        return this.code;
    }

    public JSONObject getData() {
        return this.data;
    }
}
