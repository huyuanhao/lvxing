package com.tencent.bugly.beta;

import com.tencent.bugly.proguard.C7282y;

/* compiled from: BUGLY */
public class UpgradeInfo {
    public String apkMd5;
    public String apkUrl;
    public long fileSize;
    /* renamed from: id */
    public String f23669id;
    public String imageUrl;
    public String newFeature;
    public long popInterval = 0;
    public int popTimes = 0;
    public long publishTime = 0;
    public int publishType = 0;
    public String title;
    public int updateType;
    public int upgradeType = 1;
    public int versionCode;
    public String versionName;

    public UpgradeInfo(C7282y yVar) {
        String str = "";
        this.f23669id = str;
        this.title = str;
        this.newFeature = str;
        this.versionName = str;
        if (yVar != null) {
            this.f23669id = yVar.f24665m;
            this.title = yVar.f24653a;
            this.newFeature = yVar.f24654b;
            this.publishTime = yVar.f24655c;
            this.publishType = yVar.f24656d;
            this.upgradeType = yVar.f24659g;
            this.popTimes = yVar.f24660h;
            this.popInterval = yVar.f24661i;
            this.versionCode = yVar.f24657e.f24625c;
            this.versionName = yVar.f24657e.f24626d;
            this.apkMd5 = yVar.f24657e.f24631i;
            this.apkUrl = yVar.f24658f.f24618b;
            this.fileSize = yVar.f24658f.f24620d;
            this.imageUrl = (String) yVar.f24664l.get("IMG_title");
            this.updateType = yVar.f24668p;
        }
    }
}
