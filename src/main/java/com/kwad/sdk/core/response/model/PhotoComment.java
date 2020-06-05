package com.kwad.sdk.core.response.model;

import com.kwad.sdk.core.response.p341a.C4321b;
import com.tencent.android.tpush.common.MessageKey;
import discoveryAD.C7880W.C7881a;
import java.io.Serializable;
import org.json.JSONObject;

public class PhotoComment implements C4321b, Serializable {
    private static final long serialVersionUID = -8159360430336434144L;
    public long author_id;
    public String author_name;
    public long comment_id;
    public String content;
    public String headurl;
    public boolean hot;
    public long likedCount;
    public long photo_id;
    public long subCommentCount;
    public String time;
    public long timestamp;
    public long user_id;
    public String user_sex;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.subCommentCount = jSONObject.optLong("subCommentCount");
            this.hot = jSONObject.optBoolean("hot");
            this.likedCount = jSONObject.optLong("likedCount");
            this.time = jSONObject.optString("time");
            this.timestamp = jSONObject.optLong(C7881a.TIMESTAMP);
            this.content = jSONObject.optString(MessageKey.MSG_CONTENT);
            this.photo_id = jSONObject.optLong("photo_id");
            this.author_id = jSONObject.optLong("author_id");
            this.user_id = jSONObject.optLong("user_id");
            this.user_sex = jSONObject.optString("user_sex");
            this.comment_id = jSONObject.optLong("comment_id");
            this.headurl = jSONObject.optString("headurl");
            this.author_name = jSONObject.optString("author_name");
        }
    }

    public JSONObject toJson() {
        return null;
    }
}
