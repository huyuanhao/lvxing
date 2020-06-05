package com.qiyukf.unicorn.api.msg.attachment;

import android.content.Context;
import com.qiyukf.basesdk.p412c.C5366b;
import com.qiyukf.nimlib.p488k.p491c.C5944b;
import com.qiyukf.unicorn.C5961R;
import org.json.JSONObject;

public class ImageAttachment extends FileAttachment {
    private static final String KEY_HEIGHT = "h";
    private static final String KEY_WIDTH = "w";
    private int height;
    private int width;

    public ImageAttachment() {
    }

    public ImageAttachment(String str) {
        super(str);
    }

    public String getContent(Context context) {
        return context.getString(C5961R.string.ysf_msg_notify_image);
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
    }

    /* access modifiers changed from: protected */
    public void save(JSONObject jSONObject, boolean z) {
        C5366b.m22029a(jSONObject, KEY_WIDTH, this.width);
        C5366b.m22029a(jSONObject, KEY_HEIGHT, this.height);
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    /* access modifiers changed from: protected */
    public C5944b storageType() {
        return C5944b.TYPE_IMAGE;
    }
}
