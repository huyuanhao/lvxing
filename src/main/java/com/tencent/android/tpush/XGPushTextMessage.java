package com.tencent.android.tpush;

import android.content.Intent;
import com.tencent.android.tpush.common.MessageKey;
import java.io.Serializable;

/* compiled from: ProGuard */
public class XGPushTextMessage implements Serializable {
    private static final long serialVersionUID = -1854661081378847806L;
    String content;
    String customContent;
    int pushChannel = 0;
    private Intent simpleIntent = null;
    String title;

    public XGPushTextMessage() {
        String str = "";
        this.title = str;
        this.content = str;
        this.customContent = str;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public String getCustomContent() {
        return this.customContent;
    }

    public int getPushChannel() {
        return this.pushChannel;
    }

    /* access modifiers changed from: 0000 */
    public void setSimpleIntent(Intent intent) {
        this.simpleIntent = intent;
        if (intent != null) {
            this.simpleIntent.removeExtra(MessageKey.MSG_CONTENT);
        }
    }

    /* access modifiers changed from: 0000 */
    public Intent getSimpleIntent() {
        return this.simpleIntent;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("XGPushShowedResult [title=");
        sb.append(this.title);
        sb.append(", content=");
        sb.append(this.content);
        sb.append(", customContent=");
        sb.append(this.customContent);
        sb.append("]");
        return sb.toString();
    }
}
