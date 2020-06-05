package com.kwad.sdk.core.response.p342b;

import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.response.model.C4330e;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.p306a.C3811n;

/* renamed from: com.kwad.sdk.core.response.b.d */
public class C4325d {
    /* renamed from: a */
    public static String m17672a(PhotoInfo photoInfo) {
        return photoInfo.videoInfo.videoUrl;
    }

    /* renamed from: b */
    public static Long m17673b(PhotoInfo photoInfo) {
        return Long.valueOf(photoInfo.videoInfo.duration);
    }

    /* renamed from: c */
    public static String m17674c(PhotoInfo photoInfo) {
        return photoInfo.videoInfo.firstFrame;
    }

    /* renamed from: d */
    public static int m17675d(PhotoInfo photoInfo) {
        return photoInfo.videoInfo.width;
    }

    /* renamed from: e */
    public static int m17676e(PhotoInfo photoInfo) {
        return photoInfo.videoInfo.height;
    }

    /* renamed from: f */
    public static String m17677f(PhotoInfo photoInfo) {
        return photoInfo.coverInfo.coverUrl;
    }

    /* renamed from: g */
    public static int m17678g(PhotoInfo photoInfo) {
        return photoInfo.coverInfo.width;
    }

    /* renamed from: h */
    public static int m17679h(PhotoInfo photoInfo) {
        return photoInfo.coverInfo.height;
    }

    /* renamed from: i */
    public static long m17680i(PhotoInfo photoInfo) {
        return photoInfo.baseInfo.photoId;
    }

    /* renamed from: j */
    public static String m17681j(PhotoInfo photoInfo) {
        return photoInfo.baseInfo.recoExt;
    }

    /* renamed from: k */
    public static long m17682k(PhotoInfo photoInfo) {
        return photoInfo.baseInfo.likeCount;
    }

    /* renamed from: l */
    public static long m17683l(PhotoInfo photoInfo) {
        return photoInfo.baseInfo.commentCount;
    }

    /* renamed from: m */
    public static long m17684m(PhotoInfo photoInfo) {
        return photoInfo.authorInfo.authorId;
    }

    /* renamed from: n */
    public static String m17685n(PhotoInfo photoInfo) {
        return photoInfo.authorInfo.authorName;
    }

    /* renamed from: o */
    public static String m17686o(PhotoInfo photoInfo) {
        return photoInfo.authorInfo.authorIcon;
    }

    /* renamed from: p */
    public static String m17687p(PhotoInfo photoInfo) {
        return photoInfo.baseInfo.title;
    }

    /* renamed from: q */
    public static boolean m17688q(PhotoInfo photoInfo) {
        return photoInfo.baseInfo.waterMarkPosition != 0;
    }

    /* renamed from: r */
    public static int m17689r(PhotoInfo photoInfo) {
        return photoInfo.baseInfo.waterMarkPosition;
    }

    /* renamed from: s */
    public static C4330e m17690s(PhotoInfo photoInfo) {
        boolean z;
        int i;
        int i2;
        String str;
        String c = m17674c(photoInfo);
        int d = m17675d(photoInfo);
        int e = m17676e(photoInfo);
        if (C3811n.m15812a(c) || C3811n.m15814b(c) || d == 0 || e == 0) {
            String f = m17677f(photoInfo);
            str = f;
            i2 = m17678g(photoInfo);
            i = m17679h(photoInfo);
            z = true;
        } else {
            str = c;
            i2 = d;
            i = e;
            z = false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("frameUrl=");
        sb.append(str);
        sb.append(" useCover=");
        sb.append(z);
        sb.append(" isAd=");
        sb.append(false);
        C4065b.m16863a("PhotoInfoHelper", sb.toString());
        C4330e eVar = new C4330e(str, i2, i, false, z);
        return eVar;
    }
}
