package com.tencent.qqpim.discovery.internal.protocol;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: com.tencent.qqpim.discovery.internal.protocol.j */
public final class C7510j extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!C7510j.class.desiredAssertionStatus());
    /* renamed from: Sa */
    static int f25182Sa = 0;
    /* renamed from: Ta */
    static ArrayList<String> f25183Ta = new ArrayList<>();
    /* renamed from: Ua */
    public String f25184Ua;
    /* renamed from: Va */
    public String f25185Va;
    /* renamed from: Wa */
    public String f25186Wa;
    /* renamed from: Xa */
    public int f25187Xa = 0;
    /* renamed from: Ya */
    public String f25188Ya;
    /* renamed from: Za */
    public long f25189Za;
    /* renamed from: _a */
    public int f25190_a;
    /* renamed from: ab */
    public int f25191ab;
    public ArrayList<String> imgList;
    public String text1;
    public String text2;
    public String text3;
    public String text4;
    public String videoUrl;
    public String zipUrl;

    static {
        f25183Ta.add("");
    }

    public C7510j() {
        String str = "";
        this.text1 = str;
        this.text2 = str;
        this.text3 = str;
        this.f25184Ua = str;
        this.f25185Va = str;
        this.f25186Wa = str;
        this.text4 = str;
        this.videoUrl = str;
        this.zipUrl = str;
        this.imgList = null;
        this.f25188Ya = str;
        this.f25189Za = 0;
        this.f25190_a = 0;
        this.f25191ab = 0;
    }

    public C7510j(String str, String str2, String str3, String str4, String str5, String str6, int i, String str7, String str8, String str9, ArrayList<String> arrayList, String str10, long j, int i2, int i3) {
        String str11 = "";
        this.text1 = str11;
        this.text2 = str11;
        this.text3 = str11;
        this.f25184Ua = str11;
        this.f25185Va = str11;
        this.f25186Wa = str11;
        this.text4 = str11;
        this.videoUrl = str11;
        this.zipUrl = str11;
        this.imgList = null;
        this.f25188Ya = str11;
        this.f25189Za = 0;
        this.f25190_a = 0;
        this.f25191ab = 0;
        this.text1 = str;
        this.text2 = str2;
        this.text3 = str3;
        this.f25184Ua = str4;
        this.f25185Va = str5;
        this.f25186Wa = str6;
        this.f25187Xa = i;
        this.text4 = str7;
        this.videoUrl = str8;
        this.zipUrl = str9;
        this.imgList = arrayList;
        this.f25188Ya = str10;
        this.f25189Za = j;
        this.f25190_a = i2;
        this.f25191ab = i3;
    }

    /* renamed from: A */
    public void mo36765A(String str) {
        this.text3 = str;
    }

    /* renamed from: B */
    public void mo36766B(String str) {
        this.text4 = str;
    }

    /* renamed from: C */
    public void mo36767C(String str) {
        this.videoUrl = str;
    }

    /* renamed from: D */
    public void mo36768D(String str) {
        this.zipUrl = str;
    }

    /* renamed from: Z */
    public String mo36769Z() {
        return this.f25188Ya;
    }

    /* renamed from: aa */
    public long mo36770aa() {
        return this.f25189Za;
    }

    /* renamed from: ba */
    public ArrayList<String> mo36771ba() {
        return this.imgList;
    }

    /* renamed from: ca */
    public String mo36772ca() {
        return this.f25184Ua;
    }

    public String className() {
        return "ADV.Display";
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

    /* renamed from: da */
    public String mo36775da() {
        return this.f25185Va;
    }

    public void display(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.display(this.text1, C7887a.f26861mh);
        jceDisplayer.display(this.text2, C7887a.f26862nh);
        jceDisplayer.display(this.text3, C7887a.f26863oh);
        jceDisplayer.display(this.f25184Ua, "imgUrl1");
        jceDisplayer.display(this.f25185Va, "imgUrl2");
        jceDisplayer.display(this.f25186Wa, "imgUrl3");
        jceDisplayer.display(this.f25187Xa, "positionFormatType");
        jceDisplayer.display(this.text4, C7887a.f26872xh);
        jceDisplayer.display(this.videoUrl, C7887a.f26830Fh);
        jceDisplayer.display(this.zipUrl, C7887a.f26831Gh);
        jceDisplayer.display((Collection<T>) this.imgList, "imgList");
        jceDisplayer.display(this.f25188Ya, "authorName");
        jceDisplayer.display(this.f25189Za, "commentNum");
        jceDisplayer.display(this.f25190_a, "picWidth");
        jceDisplayer.display(this.f25191ab, "picHeight");
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.text1, true);
        jceDisplayer.displaySimple(this.text2, true);
        jceDisplayer.displaySimple(this.text3, true);
        jceDisplayer.displaySimple(this.f25184Ua, true);
        jceDisplayer.displaySimple(this.f25185Va, true);
        jceDisplayer.displaySimple(this.f25186Wa, true);
        jceDisplayer.displaySimple(this.f25187Xa, true);
        jceDisplayer.displaySimple(this.text4, true);
        jceDisplayer.displaySimple(this.videoUrl, true);
        jceDisplayer.displaySimple(this.zipUrl, true);
        jceDisplayer.displaySimple((Collection<T>) this.imgList, true);
        jceDisplayer.displaySimple(this.f25188Ya, true);
        jceDisplayer.displaySimple(this.f25189Za, true);
        jceDisplayer.displaySimple(this.f25190_a, true);
        jceDisplayer.displaySimple(this.f25191ab, false);
    }

    /* renamed from: ea */
    public String mo36776ea() {
        return this.f25186Wa;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        C7510j jVar = (C7510j) obj;
        if (JceUtil.equals((Object) this.text1, (Object) jVar.text1) && JceUtil.equals((Object) this.text2, (Object) jVar.text2) && JceUtil.equals((Object) this.text3, (Object) jVar.text3) && JceUtil.equals((Object) this.f25184Ua, (Object) jVar.f25184Ua) && JceUtil.equals((Object) this.f25185Va, (Object) jVar.f25185Va) && JceUtil.equals((Object) this.f25186Wa, (Object) jVar.f25186Wa) && JceUtil.equals(this.f25187Xa, jVar.f25187Xa) && JceUtil.equals((Object) this.text4, (Object) jVar.text4) && JceUtil.equals((Object) this.videoUrl, (Object) jVar.videoUrl) && JceUtil.equals((Object) this.zipUrl, (Object) jVar.zipUrl) && JceUtil.equals((Object) this.imgList, (Object) jVar.imgList) && JceUtil.equals((Object) this.f25188Ya, (Object) jVar.f25188Ya) && JceUtil.equals(this.f25189Za, jVar.f25189Za) && JceUtil.equals(this.f25190_a, jVar.f25190_a) && JceUtil.equals(this.f25191ab, jVar.f25191ab)) {
            z = true;
        }
        return z;
    }

    /* renamed from: fa */
    public int mo36778fa() {
        return this.f25191ab;
    }

    public String fullClassName() {
        return "com.tencent.qqpim.discovery.internal.protocol.Display";
    }

    /* renamed from: g */
    public void mo36780g(ArrayList<String> arrayList) {
        this.imgList = arrayList;
    }

    /* renamed from: ga */
    public int mo36781ga() {
        return this.f25190_a;
    }

    public String getText1() {
        return this.text1;
    }

    public String getText2() {
        return this.text2;
    }

    /* renamed from: ha */
    public int mo36784ha() {
        return this.f25187Xa;
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: i */
    public void mo36786i(long j) {
        this.f25189Za = j;
    }

    /* renamed from: ia */
    public String mo36787ia() {
        return this.text3;
    }

    /* renamed from: ja */
    public String mo36788ja() {
        return this.text4;
    }

    /* renamed from: ka */
    public String mo36789ka() {
        return this.videoUrl;
    }

    /* renamed from: la */
    public String mo36790la() {
        return this.zipUrl;
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.text1 = jceInputStream.readString(0, false);
        this.text2 = jceInputStream.readString(1, false);
        this.text3 = jceInputStream.readString(2, false);
        this.f25184Ua = jceInputStream.readString(3, false);
        this.f25185Va = jceInputStream.readString(4, false);
        this.f25186Wa = jceInputStream.readString(5, false);
        this.f25187Xa = jceInputStream.read(this.f25187Xa, 6, false);
        this.text4 = jceInputStream.readString(7, false);
        this.videoUrl = jceInputStream.readString(8, false);
        this.zipUrl = jceInputStream.readString(9, false);
        this.imgList = (ArrayList) jceInputStream.read(f25183Ta, 10, false);
        this.f25188Ya = jceInputStream.readString(11, false);
        this.f25189Za = jceInputStream.read(this.f25189Za, 12, false);
        this.f25190_a = jceInputStream.read(this.f25190_a, 13, false);
        this.f25191ab = jceInputStream.read(this.f25191ab, 14, false);
    }

    /* renamed from: s */
    public void mo36791s(int i) {
        this.f25191ab = i;
    }

    /* renamed from: t */
    public void mo36792t(int i) {
        this.f25190_a = i;
    }

    /* renamed from: u */
    public void mo36793u(int i) {
        this.f25187Xa = i;
    }

    /* renamed from: u */
    public void mo36794u(String str) {
        this.f25188Ya = str;
    }

    /* renamed from: v */
    public void mo36795v(String str) {
        this.f25184Ua = str;
    }

    /* renamed from: w */
    public void mo36796w(String str) {
        this.f25185Va = str;
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.text1;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.text2;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.text3;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.f25184Ua;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
        String str5 = this.f25185Va;
        if (str5 != null) {
            jceOutputStream.write(str5, 4);
        }
        String str6 = this.f25186Wa;
        if (str6 != null) {
            jceOutputStream.write(str6, 5);
        }
        jceOutputStream.write(this.f25187Xa, 6);
        String str7 = this.text4;
        if (str7 != null) {
            jceOutputStream.write(str7, 7);
        }
        String str8 = this.videoUrl;
        if (str8 != null) {
            jceOutputStream.write(str8, 8);
        }
        String str9 = this.zipUrl;
        if (str9 != null) {
            jceOutputStream.write(str9, 9);
        }
        ArrayList<String> arrayList = this.imgList;
        if (arrayList != null) {
            jceOutputStream.write((Collection<T>) arrayList, 10);
        }
        String str10 = this.f25188Ya;
        if (str10 != null) {
            jceOutputStream.write(str10, 11);
        }
        jceOutputStream.write(this.f25189Za, 12);
        jceOutputStream.write(this.f25190_a, 13);
        jceOutputStream.write(this.f25191ab, 14);
    }

    /* renamed from: x */
    public void mo36797x(String str) {
        this.f25186Wa = str;
    }

    /* renamed from: y */
    public void mo36798y(String str) {
        this.text1 = str;
    }

    /* renamed from: z */
    public void mo36799z(String str) {
        this.text2 = str;
    }
}
