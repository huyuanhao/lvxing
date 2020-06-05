package com.kwad.sdk.core.download;

import com.kwad.sdk.KsAdSDK;

/* renamed from: com.kwad.sdk.core.download.a */
public class C4086a {
    /* renamed from: a */
    public static final String f13735a;
    /* renamed from: b */
    public static final String f13736b;
    /* renamed from: c */
    public static final String f13737c;
    /* renamed from: d */
    public static final String f13738d;
    /* renamed from: e */
    public static final String f13739e;
    /* renamed from: f */
    public static final String f13740f;
    /* renamed from: g */
    public static final String f13741g;
    /* renamed from: h */
    public static final String f13742h;
    /* renamed from: i */
    public static final String f13743i;
    /* renamed from: j */
    public static final String f13744j;
    /* renamed from: k */
    public static final String f13745k;
    /* renamed from: l */
    public static final String f13746l;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(KsAdSDK.getAppId());
        sb.append("2.6.5.2");
        f13735a = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f13735a);
        sb2.append("ACTION_DOWNLOAD_ONDOWNLOAD");
        f13736b = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(f13735a);
        sb3.append("ACTION_DOWNLOAD_ONPROGRESSUPDATE");
        f13737c = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        sb4.append(f13735a);
        sb4.append("ACTION_DOWNLOAD_ONDOWNLOADFINISHED");
        f13738d = sb4.toString();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(f13735a);
        sb5.append("ACTION_DOWNLOAD_ONDOWNLOADFAILED");
        f13739e = sb5.toString();
        StringBuilder sb6 = new StringBuilder();
        sb6.append(f13735a);
        sb6.append("ACTION_DOWNLOAD_ONDOWNLOADPAUSEED");
        f13740f = sb6.toString();
        StringBuilder sb7 = new StringBuilder();
        sb7.append(f13735a);
        sb7.append("ACTION_DOWNLOAD_ONDOWNLOADRESUMEED");
        f13741g = sb7.toString();
        StringBuilder sb8 = new StringBuilder();
        sb8.append(f13735a);
        sb8.append("ACTION_DOWNLOAD_ONDOWNLOADCANCELED");
        f13742h = sb8.toString();
        StringBuilder sb9 = new StringBuilder();
        sb9.append(f13735a);
        sb9.append("ACTION_DOWNLOAD_ONSTARTINSTALLAPK");
        f13743i = sb9.toString();
        StringBuilder sb10 = new StringBuilder();
        sb10.append(f13735a);
        sb10.append("ACTION_DOWNLOAD_ONINSTALLINGAPK");
        f13744j = sb10.toString();
        StringBuilder sb11 = new StringBuilder();
        sb11.append(f13735a);
        sb11.append("ACTION_DOWNLOAD_ONAPKINSTALLED");
        f13745k = sb11.toString();
        StringBuilder sb12 = new StringBuilder();
        sb12.append(f13735a);
        sb12.append("ACTION_DOWNLOAD_ONAPKINSTALLFAILED");
        f13746l = sb12.toString();
    }
}
