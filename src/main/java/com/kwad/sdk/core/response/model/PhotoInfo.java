package com.kwad.sdk.core.response.model;

import com.kwad.sdk.core.response.p341a.C4321b;
import com.kwad.sdk.p306a.C3800e;
import com.tencent.p605ep.commonbase.software.AppEntity;
import java.io.Serializable;
import org.json.JSONObject;

public class PhotoInfo implements C4321b, Serializable {
    private static final long serialVersionUID = -4483350806354759008L;
    public AuthorInfo authorInfo = new AuthorInfo();
    public BaseInfo baseInfo = new BaseInfo();
    public CoverInfo coverInfo = new CoverInfo();
    public VideoInfo videoInfo = new VideoInfo();

    /* renamed from: com.kwad.sdk.core.response.model.PhotoInfo$AuthorInfo */
    public static class AuthorInfo implements C4321b, Serializable {
        private static final long serialVersionUID = 3647144332352243129L;
        public String authorIcon;
        public long authorId;
        public String authorName;

        public void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.authorId = jSONObject.optLong("authorId");
                this.authorName = jSONObject.optString("authorName");
                this.authorIcon = jSONObject.optString("authorIcon");
            }
        }

        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            C3800e.m15750a(jSONObject, "authorId", this.authorId);
            C3800e.m15752a(jSONObject, "authorName", this.authorName);
            C3800e.m15752a(jSONObject, "authorIcon", this.authorIcon);
            return jSONObject;
        }
    }

    /* renamed from: com.kwad.sdk.core.response.model.PhotoInfo$BaseInfo */
    public static class BaseInfo implements C4321b, Serializable {
        private static final long serialVersionUID = 2257669583403371065L;
        public long commentCount;
        public long likeCount;
        public long photoId;
        public String recoExt;
        public String shareUrl;
        public String title;
        public int waterMarkPosition;

        public void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.photoId = jSONObject.optLong("photoId");
                this.title = jSONObject.optString("title");
                this.shareUrl = jSONObject.optString("shareUrl");
                this.waterMarkPosition = jSONObject.optInt("waterMarkPosition", 1);
                this.recoExt = jSONObject.optString("recoExt");
                this.likeCount = jSONObject.optLong("likeCount");
                this.commentCount = jSONObject.optLong("commentCount");
            }
        }

        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            C3800e.m15750a(jSONObject, "photoId", this.photoId);
            C3800e.m15752a(jSONObject, "title", this.title);
            C3800e.m15752a(jSONObject, "shareUrl", this.shareUrl);
            C3800e.m15749a(jSONObject, "waterMarkPosition", this.waterMarkPosition);
            C3800e.m15752a(jSONObject, "recoExt", this.recoExt);
            C3800e.m15750a(jSONObject, "likeCount", this.likeCount);
            C3800e.m15750a(jSONObject, "commentCount", this.commentCount);
            return jSONObject;
        }
    }

    /* renamed from: com.kwad.sdk.core.response.model.PhotoInfo$CoverInfo */
    public static class CoverInfo implements C4321b, Serializable {
        private static final long serialVersionUID = 9136122984250063738L;
        public String coverUrl;
        public int height;
        public int width;

        public void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.coverUrl = jSONObject.optString("coverUrl");
                this.width = jSONObject.optInt("width");
                this.height = jSONObject.optInt("height");
            }
        }

        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            C3800e.m15752a(jSONObject, "coverUrl", this.coverUrl);
            C3800e.m15749a(jSONObject, "width", this.width);
            C3800e.m15749a(jSONObject, "height", this.height);
            return jSONObject;
        }
    }

    /* renamed from: com.kwad.sdk.core.response.model.PhotoInfo$VideoInfo */
    public static class VideoInfo implements C4321b, Serializable {
        private static final long serialVersionUID = 1395696168725754442L;
        public long duration;
        public String firstFrame;
        public int height;
        public int size;
        public String videoUrl;
        public int width;

        public void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.videoUrl = jSONObject.optString(C7887a.f26830Fh);
                this.firstFrame = jSONObject.optString("firstFrame");
                this.duration = jSONObject.optLong("duration");
                this.size = jSONObject.optInt(AppEntity.KEY_SIZE_LONG);
                this.width = jSONObject.optInt("width");
                this.height = jSONObject.optInt("height");
            }
        }

        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            C3800e.m15752a(jSONObject, C7887a.f26830Fh, this.videoUrl);
            C3800e.m15752a(jSONObject, "firstFrame", this.firstFrame);
            C3800e.m15750a(jSONObject, "duration", this.duration);
            C3800e.m15749a(jSONObject, AppEntity.KEY_SIZE_LONG, this.size);
            C3800e.m15749a(jSONObject, "width", this.width);
            C3800e.m15749a(jSONObject, "height", this.height);
            return jSONObject;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.baseInfo.parseJson(jSONObject.optJSONObject("baseInfo"));
            this.videoInfo.parseJson(jSONObject.optJSONObject("videoInfo"));
            this.coverInfo.parseJson(jSONObject.optJSONObject("coverInfo"));
            this.authorInfo.parseJson(jSONObject.optJSONObject("authorInfo"));
        }
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        C3800e.m15751a(jSONObject, "baseInfo", (C4321b) this.baseInfo);
        C3800e.m15751a(jSONObject, "videoInfo", (C4321b) this.videoInfo);
        C3800e.m15751a(jSONObject, "coverInfo", (C4321b) this.coverInfo);
        C3800e.m15751a(jSONObject, "authorInfo", (C4321b) this.authorInfo);
        return jSONObject;
    }
}
