package com.qiyukf.nim.uikit.common.media.picker.model;

import java.io.Serializable;

public class PhotoInfo implements Serializable {
    private static final long serialVersionUID = 1;
    private String absolutePath;
    private boolean choose = false;
    private String filePath;
    private int imageId;
    private long size;

    public boolean equals(Object obj) {
        return (obj instanceof PhotoInfo) && ((PhotoInfo) obj).imageId == this.imageId;
    }

    public String getAbsolutePath() {
        return this.absolutePath;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public int getImageId() {
        return this.imageId;
    }

    public long getSize() {
        return this.size;
    }

    public boolean isChoose() {
        return this.choose;
    }

    public void setAbsolutePath(String str) {
        this.absolutePath = str;
    }

    public void setChoose(boolean z) {
        this.choose = z;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public void setImageId(int i) {
        this.imageId = i;
    }

    public void setSize(long j) {
        this.size = j;
    }
}
