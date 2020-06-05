package com.qiyukf.nimlib.sdk.msg.attachment;

import com.qiyukf.basesdk.p412c.C5366b;
import com.qiyukf.nimlib.p488k.p491c.C5944b;
import com.qiyukf.unicorn.api.msg.attachment.FileAttachment;
import org.json.JSONObject;

public class VideoAttachment extends FileAttachment {
    private static final String KEY_DURATION = "dur";
    private static final String KEY_HEIGHT = "h";
    private static final String KEY_WIDTH = "w";
    private long duration;
    private int height;
    private int width;

    public VideoAttachment() {
    }

    public VideoAttachment(String str) {
        super(str);
    }

    public long getDuration() {
        return this.duration;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    /* access modifiers changed from: protected */
    public void load(JSONObject jSONObject) {
        this.width = C5366b.m22034b(jSONObject, KEY_WIDTH);
        this.height = C5366b.m22034b(jSONObject, KEY_HEIGHT);
        this.duration = (long) C5366b.m22034b(jSONObject, KEY_DURATION);
    }

    /* access modifiers changed from: protected */
    public void save(JSONObject jSONObject, boolean z) {
        C5366b.m22029a(jSONObject, KEY_WIDTH, this.width);
        C5366b.m22029a(jSONObject, KEY_HEIGHT, this.height);
        C5366b.m22030a(jSONObject, KEY_DURATION, this.duration);
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    /* access modifiers changed from: protected */
    public C5944b storageType() {
        return C5944b.TYPE_VIDEO;
    }
}
