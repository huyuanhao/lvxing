package com.qiyukf.unicorn.api.msg.attachment;

import android.content.Context;
import com.qiyukf.basesdk.p412c.C5366b;
import com.qiyukf.nimlib.p488k.p491c.C5944b;
import com.qiyukf.unicorn.C5961R;
import org.json.JSONObject;

public class AudioAttachment extends FileAttachment {
    private static final String KEY_DURATION = "dur";
    private static final String KEY_IS_AUTO_TRANSFORM = "auto";
    private static final String KEY_TEXT = "tt";
    private boolean autoTransform;
    private long duration;
    private String text;

    public AudioAttachment() {
    }

    public AudioAttachment(String str) {
        super(str);
    }

    public boolean getAutoTransform() {
        return this.autoTransform;
    }

    public String getContent(Context context) {
        return context.getString(C5961R.string.ysf_msg_notify_audio);
    }

    public long getDuration() {
        return this.duration;
    }

    public String getText() {
        return this.text;
    }

    /* access modifiers changed from: protected */
    public void load(JSONObject jSONObject) {
        this.duration = C5366b.m22037c(jSONObject, KEY_DURATION);
        this.text = C5366b.m22039e(jSONObject, KEY_TEXT);
        this.autoTransform = C5366b.m22033a(jSONObject, KEY_IS_AUTO_TRANSFORM);
    }

    /* access modifiers changed from: protected */
    public void save(JSONObject jSONObject, boolean z) {
        C5366b.m22030a(jSONObject, KEY_DURATION, this.duration);
        if (!z) {
            C5366b.m22032a(jSONObject, KEY_TEXT, this.text);
            C5366b.m22031a(jSONObject, KEY_IS_AUTO_TRANSFORM, (Object) Boolean.valueOf(this.autoTransform));
        }
    }

    public void setAutoTransform(boolean z) {
        this.autoTransform = z;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public void setText(String str) {
        this.text = str;
    }

    /* access modifiers changed from: protected */
    public C5944b storageType() {
        return C5944b.TYPE_AUDIO;
    }
}
