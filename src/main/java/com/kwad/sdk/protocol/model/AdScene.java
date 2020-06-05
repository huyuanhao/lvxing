package com.kwad.sdk.protocol.model;

import com.kwad.sdk.p306a.C3800e;
import java.io.Serializable;
import org.json.JSONObject;

public class AdScene implements Serializable {
    private static final long serialVersionUID = 93865491903408451L;
    public int action;
    public int adNum = 1;
    public int adStyle;
    public int height;
    public long posId;
    public int width;

    public AdScene(long j) {
        this.posId = j;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        C3800e.m15750a(jSONObject, "posId", this.posId);
        C3800e.m15749a(jSONObject, "adNum", this.adNum);
        C3800e.m15749a(jSONObject, "action", this.action);
        C3800e.m15749a(jSONObject, "width", this.width);
        C3800e.m15749a(jSONObject, "height", this.height);
        C3800e.m15749a(jSONObject, "adStyle", this.adStyle);
        return jSONObject;
    }
}
