package com.tencent.p605ep.shanhuad.adpublic.models;

/* renamed from: com.tencent.ep.shanhuad.adpublic.models.AdID */
public class AdID {
    public int height;
    public int posID;
    public Integer[] styleArray;
    public int width;

    public AdID(int i, int i2, int i3) {
        this(i, null, i2, i3);
    }

    public AdID(int i, Integer[] numArr, int i2, int i3) {
        this.posID = 0;
        this.posID = i;
        this.styleArray = numArr;
        this.width = i2;
        this.height = i3;
    }
}
