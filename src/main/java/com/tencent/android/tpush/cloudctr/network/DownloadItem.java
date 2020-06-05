package com.tencent.android.tpush.cloudctr.network;

import java.io.Serializable;

/* compiled from: ProGuard */
public class DownloadItem implements Serializable {
    static final int DOWNLOAD_RETRY_TIMES_NOT_SET = -1;
    int _downloadRetryTimes = -1;
    boolean _isDownloadFinished = false;
    boolean _isDownloadInterrupted = false;
    boolean _isEverDownloadFailed = false;
    private String businessCode = null;
    private String downloadSavedDir = null;
    private boolean downloadSucceed = false;
    private String downloadUrl = null;
    private String fileName = null;
    private String md5 = null;

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public void setDownloadUrl(String str) {
        this.downloadUrl = str;
    }

    public String getMd5() {
        return this.md5;
    }

    public void setMd5(String str) {
        this.md5 = str;
    }

    public String getDownloadSavedDir() {
        return this.downloadSavedDir;
    }

    public void setDownloadSavedDir(String str) {
        this.downloadSavedDir = str;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public String getBusinessCode() {
        return this.businessCode;
    }

    public void setBusinessCode(String str) {
        this.businessCode = str;
    }

    public boolean isDownloadSucceed() {
        return this.downloadSucceed;
    }

    public void setDownloadSucceed(boolean z) {
        this.downloadSucceed = z;
    }
}
