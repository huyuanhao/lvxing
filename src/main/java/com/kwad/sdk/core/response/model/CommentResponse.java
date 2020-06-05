package com.kwad.sdk.core.response.model;

import com.kwad.sdk.core.p318b.C4062b;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.response.p341a.C4321b;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class CommentResponse implements C4321b, Serializable {
    private static final long serialVersionUID = 7438022026198734874L;
    public long commentCount;
    public String errorMsg;
    private long llsid;
    public int result;
    public List<PhotoComment> rootComments = new ArrayList();

    public boolean isResultDataEmpty() {
        List<PhotoComment> list = this.rootComments;
        return list == null || list.isEmpty();
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.llsid = jSONObject.optLong("llsid");
            this.result = jSONObject.optInt(ArgKey.KEY_RESULT);
            this.errorMsg = jSONObject.optString("errorMsg");
            try {
                JSONObject jSONObject2 = new JSONObject(C4062b.m16853b(jSONObject.optString("data")));
                this.commentCount = jSONObject2.optLong("commentCount");
                JSONArray jSONArray = jSONObject2.getJSONArray("rootComments");
                if (jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i);
                        PhotoComment photoComment = new PhotoComment();
                        photoComment.parseJson(optJSONObject);
                        this.rootComments.add(photoComment);
                    }
                }
            } catch (Exception e) {
                C4065b.m16865a(e);
            }
        }
    }

    public JSONObject toJson() {
        return null;
    }
}
