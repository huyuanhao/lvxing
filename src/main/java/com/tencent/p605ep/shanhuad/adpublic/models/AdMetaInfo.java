package com.tencent.p605ep.shanhuad.adpublic.models;

import com.p522qq.p523e.ads.nativ.NativeUnifiedADData;
import com.tencent.qqpim.discovery.AdDisplayModel;
import java.util.List;

/* renamed from: com.tencent.ep.shanhuad.adpublic.models.AdMetaInfo */
public class AdMetaInfo {
    /* renamed from: Yj */
    private AdDisplayModel f24787Yj;
    public String cta;
    public String desc;
    public String icon;
    public String image;
    public List<String> imageList;
    public NativeUnifiedADData mNativeUnifiedADData;
    public int templateType;
    public String title;

    public AdMetaInfo() {
    }

    public AdDisplayModel getAdDisplayModel() {
        return this.f24787Yj;
    }

    public String getDownLoadUrl() {
        AdDisplayModel adDisplayModel = this.f24787Yj;
        if (adDisplayModel != null) {
            return adDisplayModel.appDownloadUrl;
        }
        return null;
    }

    public String getPackageName() {
        AdDisplayModel adDisplayModel = this.f24787Yj;
        if (adDisplayModel != null) {
            return adDisplayModel.packageName;
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("title : ");
        sb.append(this.title);
        sb.append(" , desc : ");
        sb.append(this.desc);
        String sb2 = sb.toString();
        if (this.icon != null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            sb3.append(" \niconurl : ");
            sb3.append(this.icon);
            sb2 = sb3.toString();
        }
        if (this.image == null) {
            return sb2;
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append(sb2);
        sb4.append(" \nimage : ");
        sb4.append(this.image);
        return sb4.toString();
    }

    public AdMetaInfo(AdDisplayModel adDisplayModel) {
        this.f24787Yj = adDisplayModel;
        this.title = adDisplayModel.text1;
        this.desc = adDisplayModel.text2;
        this.cta = adDisplayModel.text3;
        this.image = adDisplayModel.imageUrl1;
        this.icon = adDisplayModel.imageUrl2;
        this.imageList = adDisplayModel.imgList;
        this.templateType = adDisplayModel.templateType;
    }
}
