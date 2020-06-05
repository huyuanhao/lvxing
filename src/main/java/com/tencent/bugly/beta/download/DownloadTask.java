package com.tencent.bugly.beta.download;

import java.io.File;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: BUGLY */
public abstract class DownloadTask {
    public static final int COMPLETE = 1;
    public static final int DELETED = 4;
    public static final int DOWNLOADING = 2;
    public static final int FAILED = 5;
    public static final int INIT = 0;
    public static final int PAUSED = 3;
    public static final int TYPE_HOTFIX = 2;
    public static final int TYPE_UPGRADE = 1;
    /* renamed from: a */
    protected String f23673a;
    /* renamed from: b */
    protected String f23674b;
    /* renamed from: c */
    protected String f23675c;
    /* renamed from: d */
    protected List<DownloadListener> f23676d = new CopyOnWriteArrayList();
    /* renamed from: e */
    protected long f23677e;
    /* renamed from: f */
    protected long f23678f;
    /* renamed from: g */
    protected boolean f23679g = true;
    /* renamed from: h */
    protected String f23680h = "";
    /* renamed from: i */
    protected int f23681i = 0;
    /* renamed from: j */
    protected int f23682j = 1;

    public abstract void delete(boolean z);

    public abstract void download();

    public abstract long getCostTime();

    public abstract File getSaveFile();

    public abstract int getStatus();

    public abstract void stop();

    protected DownloadTask(String str, String str2, String str3, String str4) {
        this.f23673a = str;
        this.f23674b = str2;
        this.f23675c = str3;
        this.f23680h = str4;
    }

    public long getTotalLength() {
        return this.f23678f;
    }

    public void setTotalLength(long j) {
        this.f23678f = j;
    }

    public long getSavedLength() {
        return this.f23677e;
    }

    public void setSavedLength(long j) {
        this.f23677e = j;
    }

    public String getDownloadUrl() {
        return this.f23673a;
    }

    public void setNeededNotify(boolean z) {
        this.f23679g = z;
    }

    public String getMD5() {
        return this.f23680h;
    }

    public int getDownloadType() {
        return this.f23682j;
    }

    public void setDownloadType(int i) {
        this.f23682j = i;
    }

    public void addListener(DownloadListener downloadListener) {
        if (downloadListener != null && !this.f23676d.contains(downloadListener)) {
            this.f23676d.add(downloadListener);
        }
    }

    public boolean removeListener(DownloadListener downloadListener) {
        return downloadListener != null && this.f23676d.remove(downloadListener);
    }

    public boolean isNeededNotify() {
        return this.f23679g;
    }
}
