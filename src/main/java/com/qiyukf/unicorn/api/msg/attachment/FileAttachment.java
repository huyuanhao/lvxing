package com.qiyukf.unicorn.api.msg.attachment;

import android.content.Context;
import android.text.TextUtils;
import com.qiyukf.basesdk.p412c.C5366b;
import com.qiyukf.basesdk.p412c.p416c.C5405c;
import com.qiyukf.basesdk.p412c.p416c.C5406d;
import com.qiyukf.nimlib.p488k.p491c.C5944b;
import com.qiyukf.nimlib.p488k.p491c.C5946c;
import com.qiyukf.unicorn.C5961R;
import java.io.File;
import org.json.JSONObject;

public class FileAttachment implements MsgAttachment {
    private static final String KEY_EXPIRE = "expire";
    private static final String KEY_EXT = "ext";
    private static final String KEY_MD5 = "md5";
    private static final String KEY_NAME = "name";
    private static final String KEY_PATH = "path";
    private static final String KEY_SIZE = "size";
    private static final String KEY_URL = "url";
    protected String displayName;
    private long expire;
    protected String extension;
    protected String md5;
    protected String path;
    protected long size;
    protected String url;

    public FileAttachment() {
    }

    public FileAttachment(String str) {
        fromJson(str);
    }

    private void fromJson(String str) {
        JSONObject a = C5366b.m22027a(str);
        this.path = C5366b.m22039e(a, KEY_PATH);
        this.md5 = C5366b.m22039e(a, KEY_MD5);
        this.url = C5366b.m22039e(a, KEY_URL);
        this.displayName = C5366b.m22039e(a, "name");
        this.size = C5366b.m22037c(a, "size");
        this.extension = C5366b.m22039e(a, KEY_EXT);
        this.expire = C5366b.m22037c(a, KEY_EXPIRE);
        load(a);
    }

    public boolean countToUnread() {
        return true;
    }

    public String getContent(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getString(C5961R.string.ysf_msg_notify_file));
        sb.append(getDisplayName());
        return sb.toString();
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public long getExpire() {
        return this.expire;
    }

    public String getExtension() {
        return this.extension;
    }

    public String getFileName() {
        return !TextUtils.isEmpty(this.path) ? C5406d.m22121b(this.path) : TextUtils.isEmpty(this.md5) ? C5405c.m22113a(this.url) : this.md5;
    }

    public String getMd5() {
        return this.md5;
    }

    public String getPath() {
        String pathForSave = getPathForSave();
        if (new File(pathForSave).exists()) {
            return pathForSave;
        }
        return null;
    }

    public String getPathForSave() {
        return !TextUtils.isEmpty(this.path) ? this.path : C5946c.m23834a(getFileName(), storageType());
    }

    public long getSize() {
        return this.size;
    }

    public String getThumbPath() {
        String thumbPathForSave = getThumbPathForSave();
        if (!new File(thumbPathForSave).exists()) {
            thumbPathForSave = null;
        }
        return thumbPathForSave != null ? thumbPathForSave : getPath();
    }

    public String getThumbPathForSave() {
        return C5946c.m23834a(getFileName(), C5944b.TYPE_THUMB_IMAGE);
    }

    public String getUrl() {
        return this.url;
    }

    /* access modifiers changed from: protected */
    public void load(JSONObject jSONObject) {
    }

    /* access modifiers changed from: protected */
    public void save(JSONObject jSONObject, boolean z) {
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public void setExtension(String str) {
        this.extension = str;
    }

    public void setMd5(String str) {
        this.md5 = str;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setSize(long j) {
        this.size = j;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    /* access modifiers changed from: protected */
    public C5944b storageType() {
        return C5944b.TYPE_FILE;
    }

    public String toJson(boolean z) {
        JSONObject jSONObject = new JSONObject();
        if (!z) {
            try {
                if (!TextUtils.isEmpty(this.path)) {
                    jSONObject.put(KEY_PATH, this.path);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(this.md5)) {
            jSONObject.put(KEY_MD5, this.md5);
        }
        if (!TextUtils.isEmpty(this.displayName)) {
            jSONObject.put("name", this.displayName);
        }
        jSONObject.put(KEY_URL, this.url);
        jSONObject.put("size", this.size);
        if (!TextUtils.isEmpty(this.extension)) {
            jSONObject.put(KEY_EXT, this.extension);
        }
        if (this.expire > 0) {
            jSONObject.put(KEY_EXPIRE, this.expire);
        }
        save(jSONObject, z);
        return jSONObject.toString();
    }
}
