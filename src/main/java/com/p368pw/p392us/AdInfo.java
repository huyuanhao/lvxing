package com.p368pw.p392us;

import com.p368pw.inner.base.p387d.C5207q;
import com.p368pw.inner.p369a.p370a.p373c.C4839a;

/* renamed from: com.pw.us.AdInfo */
public class AdInfo {
    private int adMetaInfoIdentity = -1;
    private String mAdChoice;
    private String mBtnText;
    private String mDesc;
    private String mIconUrl;
    private String mImageUrl;
    private String mPkgName;
    private String mTitle;

    public AdInfo(AdInfo adInfo, String str) {
        this.mTitle = adInfo.getTitle();
        this.mDesc = adInfo.getDesc();
        this.mIconUrl = adInfo.getIconUrl();
        this.mPkgName = adInfo.getPkgName();
        this.mBtnText = adInfo.getBtnText();
        this.mAdChoice = adInfo.getAdChoice();
        if (C5207q.m21476a((CharSequence) str)) {
            String str2 = adInfo.mImageUrl;
        } else {
            this.mImageUrl = str;
        }
    }

    public AdInfo(String str, String str2, String str3, String str4, String str5, String str6) {
        this.mTitle = str;
        this.mDesc = str2;
        this.mIconUrl = str3;
        this.mPkgName = str4;
        this.mBtnText = str5;
        this.mAdChoice = str6;
    }

    public AdInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.mTitle = str;
        this.mDesc = str2;
        this.mIconUrl = str3;
        this.mPkgName = str4;
        this.mBtnText = str5;
        this.mAdChoice = str6;
        this.mImageUrl = str7;
    }

    public String getAdChoice() {
        return this.mAdChoice;
    }

    public String getBtnText() {
        return this.mBtnText;
    }

    public String getDesc() {
        return this.mDesc;
    }

    public String getIconUrl() {
        return this.mIconUrl;
    }

    public String getImageUrl() {
        return this.mImageUrl;
    }

    public String getPkgName() {
        return C5207q.m21478b((CharSequence) this.mPkgName) ? this.mPkgName : C4839a.m19864a(this.adMetaInfoIdentity);
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setAdMetaInfoIdentity(int i) {
        this.adMetaInfoIdentity = i;
    }

    public AdInfo setBtnText(String str) {
        this.mBtnText = str;
        return this;
    }
}
