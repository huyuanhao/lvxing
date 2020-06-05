package com.tencent.qqpim.discovery.internal.protocol;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;
import com.tencent.android.tpush.common.Constants;

/* renamed from: com.tencent.qqpim.discovery.internal.protocol.i */
public final class C7509i extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!C7509i.class.desiredAssertionStatus());
    /* renamed from: Ia */
    static int f25172Ia = 0;
    /* renamed from: Ja */
    static int f25173Ja = 0;
    /* renamed from: Ka */
    static C7521u f25174Ka = new C7521u();
    /* renamed from: La */
    static C7523w f25175La = new C7523w();
    /* renamed from: Ma */
    public int f25176Ma;
    /* renamed from: Na */
    public int f25177Na;
    /* renamed from: Oa */
    public String f25178Oa;
    /* renamed from: Pa */
    public int f25179Pa;
    /* renamed from: Qa */
    public C7521u f25180Qa;
    /* renamed from: Ra */
    public C7523w f25181Ra;
    public String appDownloadUrl;
    public String channelId;
    public int contentType = 0;
    public String jumpUrl;
    public String packageName;

    public C7509i() {
        String str = "";
        this.jumpUrl = str;
        this.packageName = str;
        this.appDownloadUrl = str;
        this.f25176Ma = 0;
        this.f25177Na = 0;
        this.f25178Oa = str;
        this.f25179Pa = 0;
        this.channelId = str;
        this.f25180Qa = null;
        this.f25181Ra = null;
    }

    public C7509i(int i, String str, String str2, String str3, int i2, int i3, String str4, int i4, String str5, C7521u uVar, C7523w wVar) {
        String str6 = "";
        this.jumpUrl = str6;
        this.packageName = str6;
        this.appDownloadUrl = str6;
        this.f25176Ma = 0;
        this.f25177Na = 0;
        this.f25178Oa = str6;
        this.f25179Pa = 0;
        this.channelId = str6;
        this.f25180Qa = null;
        this.f25181Ra = null;
        this.contentType = i;
        this.jumpUrl = str;
        this.packageName = str2;
        this.appDownloadUrl = str3;
        this.f25176Ma = i2;
        this.f25177Na = i3;
        this.f25178Oa = str4;
        this.f25179Pa = i4;
        this.channelId = str5;
        this.f25180Qa = uVar;
        this.f25181Ra = wVar;
    }

    /* renamed from: R */
    public int mo36738R() {
        return this.f25179Pa;
    }

    /* renamed from: S */
    public String mo36739S() {
        return this.appDownloadUrl;
    }

    /* renamed from: T */
    public String mo36740T() {
        return this.f25178Oa;
    }

    /* renamed from: U */
    public int mo36741U() {
        return this.f25176Ma;
    }

    /* renamed from: V */
    public C7521u mo36742V() {
        return this.f25180Qa;
    }

    /* renamed from: W */
    public C7523w mo36743W() {
        return this.f25181Ra;
    }

    /* renamed from: X */
    public String mo36744X() {
        return this.jumpUrl;
    }

    /* renamed from: Y */
    public int mo36745Y() {
        return this.f25177Na;
    }

    /* renamed from: a */
    public void mo36746a(C7521u uVar) {
        this.f25180Qa = uVar;
    }

    /* renamed from: a */
    public void mo36747a(C7523w wVar) {
        this.f25181Ra = wVar;
    }

    public String className() {
        return "ADV.Content";
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if ($assertionsDisabled) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public void display(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.display(this.contentType, "contentType");
        jceDisplayer.display(this.jumpUrl, "jumpUrl");
        jceDisplayer.display(this.packageName, Constants.FLAG_PACKAGE_NAME);
        jceDisplayer.display(this.appDownloadUrl, C7887a.f26832Hh);
        jceDisplayer.display(this.f25176Ma, C7887a.f26836Kh);
        jceDisplayer.display(this.f25177Na, "producttype");
        jceDisplayer.display(this.f25178Oa, "customedUrl");
        jceDisplayer.display(this.f25179Pa, "adTagType");
        jceDisplayer.display(this.channelId, C7887a.f26838Mh);
        jceDisplayer.display((JceStruct) this.f25180Qa, "eventTracking");
        jceDisplayer.display((JceStruct) this.f25181Ra, "externalResourceExtraData");
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.contentType, true);
        jceDisplayer.displaySimple(this.jumpUrl, true);
        jceDisplayer.displaySimple(this.packageName, true);
        jceDisplayer.displaySimple(this.appDownloadUrl, true);
        jceDisplayer.displaySimple(this.f25176Ma, true);
        jceDisplayer.displaySimple(this.f25177Na, true);
        jceDisplayer.displaySimple(this.f25178Oa, true);
        jceDisplayer.displaySimple(this.f25179Pa, true);
        jceDisplayer.displaySimple(this.channelId, true);
        jceDisplayer.displaySimple((JceStruct) this.f25180Qa, true);
        jceDisplayer.displaySimple((JceStruct) this.f25181Ra, false);
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        C7509i iVar = (C7509i) obj;
        if (JceUtil.equals(this.contentType, iVar.contentType) && JceUtil.equals((Object) this.jumpUrl, (Object) iVar.jumpUrl) && JceUtil.equals((Object) this.packageName, (Object) iVar.packageName) && JceUtil.equals((Object) this.appDownloadUrl, (Object) iVar.appDownloadUrl) && JceUtil.equals(this.f25176Ma, iVar.f25176Ma) && JceUtil.equals(this.f25177Na, iVar.f25177Na) && JceUtil.equals((Object) this.f25178Oa, (Object) iVar.f25178Oa) && JceUtil.equals(this.f25179Pa, iVar.f25179Pa) && JceUtil.equals((Object) this.channelId, (Object) iVar.channelId) && JceUtil.equals((Object) this.f25180Qa, (Object) iVar.f25180Qa) && JceUtil.equals((Object) this.f25181Ra, (Object) iVar.f25181Ra)) {
            z = true;
        }
        return z;
    }

    public String fullClassName() {
        return "com.tencent.qqpim.discovery.internal.protocol.Content";
    }

    public String getChannelId() {
        return this.channelId;
    }

    public int getContentType() {
        return this.contentType;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: p */
    public void mo36756p(int i) {
        this.f25179Pa = i;
    }

    /* renamed from: q */
    public void mo36757q(int i) {
        this.f25176Ma = i;
    }

    /* renamed from: r */
    public void mo36758r(int i) {
        this.f25177Na = i;
    }

    /* renamed from: r */
    public void mo36759r(String str) {
        this.appDownloadUrl = str;
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.contentType = jceInputStream.read(this.contentType, 0, false);
        this.jumpUrl = jceInputStream.readString(1, false);
        this.packageName = jceInputStream.readString(2, false);
        this.appDownloadUrl = jceInputStream.readString(3, false);
        this.f25176Ma = jceInputStream.read(this.f25176Ma, 4, false);
        this.f25177Na = jceInputStream.read(this.f25177Na, 5, false);
        this.f25178Oa = jceInputStream.readString(6, false);
        this.f25179Pa = jceInputStream.read(this.f25179Pa, 7, false);
        this.channelId = jceInputStream.readString(8, false);
        this.f25180Qa = (C7521u) jceInputStream.read((JceStruct) f25174Ka, 9, false);
        this.f25181Ra = (C7523w) jceInputStream.read((JceStruct) f25175La, 10, false);
    }

    /* renamed from: s */
    public void mo36760s(String str) {
        this.f25178Oa = str;
    }

    public void setChannelId(String str) {
        this.channelId = str;
    }

    public void setContentType(int i) {
        this.contentType = i;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    /* renamed from: t */
    public void mo36764t(String str) {
        this.jumpUrl = str;
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.contentType, 0);
        String str = this.jumpUrl;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.packageName;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.appDownloadUrl;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        jceOutputStream.write(this.f25176Ma, 4);
        jceOutputStream.write(this.f25177Na, 5);
        String str4 = this.f25178Oa;
        if (str4 != null) {
            jceOutputStream.write(str4, 6);
        }
        jceOutputStream.write(this.f25179Pa, 7);
        String str5 = this.channelId;
        if (str5 != null) {
            jceOutputStream.write(str5, 8);
        }
        C7521u uVar = this.f25180Qa;
        if (uVar != null) {
            jceOutputStream.write((JceStruct) uVar, 9);
        }
        C7523w wVar = this.f25181Ra;
        if (wVar != null) {
            jceOutputStream.write((JceStruct) wVar, 10);
        }
    }
}
