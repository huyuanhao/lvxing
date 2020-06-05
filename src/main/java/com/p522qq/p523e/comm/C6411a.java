package com.p522qq.p523e.comm;

import android.content.Context;
import android.content.Intent;
import com.p522qq.p523e.comm.constants.CustomPkgConstants;
import com.p522qq.p523e.comm.util.GDTLogger;
import com.tencent.mid.core.Constants;

/* renamed from: com.qq.e.comm.a */
public class C6411a {
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x01cf, code lost:
            r5 = new com.p522qq.p523e.comm.util.AdError(2001, "初始化错误，详细码：200103");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x01d7, code lost:
            r5 = new com.p522qq.p523e.comm.util.AdError(2001, "初始化错误，详细码：200102");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x01df, code lost:
            r5 = new com.p522qq.p523e.comm.util.AdError(2001, "初始化错误，详细码：200101");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01e7, code lost:
            r5 = new com.p522qq.p523e.comm.util.AdError(2001, "初始化错误");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
            return new com.p522qq.p523e.comm.util.AdError(5001, "服务端数据错误");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
            return new com.p522qq.p523e.comm.util.AdError(5004, "没有广告");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
            return new com.p522qq.p523e.comm.util.AdError(5008, "图片加载错误");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
            return new com.p522qq.p523e.comm.util.AdError(5007, "资源加载错误");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
            return new com.p522qq.p523e.comm.util.AdError(2002, "内部错误，详细码：200202");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
            return new com.p522qq.p523e.comm.util.AdError(2002, "内部错误，详细码：200201");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
            return new com.p522qq.p523e.comm.util.AdError(5009, "广告请求量或者消耗等超过小时限额，请一小时后再请求广告");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
            return new com.p522qq.p523e.comm.util.AdError(5005, "广告请求量或者消耗等超过日限额，请明天再请求广告");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:?, code lost:
            return new com.p522qq.p523e.comm.util.AdError(5006, "包名校验错误，当前App的包名和广点通移动联盟官网注册的媒体包名不一致，因此无广告返回");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:?, code lost:
            return new com.p522qq.p523e.comm.util.AdError(4011, "开屏广告拉取超时");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:?, code lost:
            return new com.p522qq.p523e.comm.util.AdError(4009, "开屏广告的自定义跳过按钮尺寸小于3x3dp");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:?, code lost:
            return new com.p522qq.p523e.comm.util.AdError(4006, "原生广告接口调用顺序错误，调用点击接口前未调用曝光接口");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:?, code lost:
            return new com.p522qq.p523e.comm.util.AdError(discoveryAD.C7929sa.f26957pg, "开屏广告容器的高度低于400dp");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:?, code lost:
            return new com.p522qq.p523e.comm.util.AdError(4004, "开屏广告容器不可见");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:?, code lost:
            return new com.p522qq.p523e.comm.util.AdError(discoveryAD.C7929sa.f26956og, "广告位错误");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:?, code lost:
            return new com.p522qq.p523e.comm.util.AdError(4002, "Manifest文件中Activity/Service/Permission的声明有问题或者Permission权限未授予");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:?, code lost:
            return new com.p522qq.p523e.comm.util.AdError(com.tmsdk.module.coin.ErrorCode.ERC_TASK_ACCOUNT_INVALID, "网络不可用");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:?, code lost:
            return new com.p522qq.p523e.comm.util.AdError(com.tmsdk.module.coin.ErrorCode.ERC_TASK_PARAM_INVALID, "网络异常");
     */
    /* renamed from: a */
    public static com.p522qq.p523e.comm.util.AdError m25175a(int r5) {
        /*
        r0 = 700(0x2bc, float:9.81E-43)
        if (r5 == r0) goto L_0x020a
        r0 = 701(0x2bd, float:9.82E-43)
        if (r5 == r0) goto L_0x0200
        r0 = 4014(0xfae, float:5.625E-42)
        if (r5 == r0) goto L_0x01f8
        r0 = 4015(0xfaf, float:5.626E-42)
        if (r5 == r0) goto L_0x01f0
        r0 = 2001(0x7d1, float:2.804E-42)
        switch(r5) {
            case 300: goto L_0x01e7;
            case 301: goto L_0x01df;
            case 302: goto L_0x01d7;
            case 303: goto L_0x01cf;
            default: goto L_0x0015;
        }
    L_0x0015:
        r1 = 5010(0x1392, float:7.02E-42)
        r2 = 2002(0x7d2, float:2.805E-42)
        java.lang.String r3 = "传入的参数有错误，详细码："
        r4 = 4001(0xfa1, float:5.607E-42)
        switch(r5) {
            case 400: goto L_0x01c5;
            case 800: goto L_0x01bb;
            case 3001: goto L_0x01c5;
            case 3003: goto L_0x01b1;
            case 4001: goto L_0x01a9;
            case 4002: goto L_0x019e;
            case 4003: goto L_0x0193;
            case 4004: goto L_0x0188;
            case 4005: goto L_0x017d;
            case 4006: goto L_0x0172;
            case 4007: goto L_0x0167;
            case 4008: goto L_0x015c;
            case 4009: goto L_0x0151;
            case 4011: goto L_0x0146;
            case 5011: goto L_0x013d;
            case 5012: goto L_0x0132;
            case 5021: goto L_0x0127;
            case 100159: goto L_0x011c;
            case 107030: goto L_0x0111;
            case 107034: goto L_0x0108;
            case 107035: goto L_0x00fd;
            case 109506: goto L_0x00f2;
            case 109507: goto L_0x00e7;
            case 200101: goto L_0x01df;
            case 200102: goto L_0x01d7;
            case 200103: goto L_0x01cf;
            case 200201: goto L_0x00de;
            case 200202: goto L_0x00d5;
            case 400101: goto L_0x00c2;
            case 400102: goto L_0x00af;
            case 400103: goto L_0x009c;
            case 400104: goto L_0x0089;
            default: goto L_0x0020;
        }
    L_0x0020:
        switch(r5) {
            case 403: goto L_0x01c5;
            case 404: goto L_0x0146;
            case 405: goto L_0x007e;
            case 406: goto L_0x0073;
            default: goto L_0x0023;
        }
    L_0x0023:
        switch(r5) {
            case 500: goto L_0x0193;
            case 501: goto L_0x0068;
            case 502: goto L_0x005d;
            default: goto L_0x0026;
        }
    L_0x0026:
        switch(r5) {
            case 600: goto L_0x0188;
            case 601: goto L_0x01b1;
            case 602: goto L_0x019e;
            case 603: goto L_0x00de;
            case 604: goto L_0x00d5;
            default: goto L_0x0029;
        }
    L_0x0029:
        switch(r5) {
            case 606: goto L_0x017d;
            case 607: goto L_0x0172;
            case 608: goto L_0x0151;
            default: goto L_0x002c;
        }
    L_0x002c:
        switch(r5) {
            case 2001: goto L_0x01e7;
            case 2002: goto L_0x0054;
            case 2003: goto L_0x0049;
            default: goto L_0x002f;
        }
    L_0x002f:
        switch(r5) {
            case 5001: goto L_0x005d;
            case 5002: goto L_0x020a;
            case 5003: goto L_0x0200;
            case 5004: goto L_0x0068;
            case 5005: goto L_0x00f2;
            case 5006: goto L_0x0111;
            case 5007: goto L_0x007e;
            case 5008: goto L_0x0073;
            case 5009: goto L_0x00e7;
            default: goto L_0x0032;
        }
    L_0x0032:
        com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
        r1 = 6000(0x1770, float:8.408E-42)
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        java.lang.String r3 = "未知错误，详细码："
        r2.<init>(r3)
        r2.append(r5)
        java.lang.String r5 = r2.toString()
        r0.m50909init(r1, r5)
        goto L_0x0213
    L_0x0049:
        com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
        r5 = 2003(0x7d3, float:2.807E-42)
        java.lang.String r1 = "SDK未初始化"
        r0.m50909init(r5, r1)
        goto L_0x0213
    L_0x0054:
        com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
        java.lang.String r5 = "内部错误"
        r0.m50909init(r2, r5)
        goto L_0x0213
    L_0x005d:
        com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
        r5 = 5001(0x1389, float:7.008E-42)
        java.lang.String r1 = "服务端数据错误"
        r0.m50909init(r5, r1)
        goto L_0x0213
    L_0x0068:
        com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
        r5 = 5004(0x138c, float:7.012E-42)
        java.lang.String r1 = "没有广告"
        r0.m50909init(r5, r1)
        goto L_0x0213
    L_0x0073:
        com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
        r5 = 5008(0x1390, float:7.018E-42)
        java.lang.String r1 = "图片加载错误"
        r0.m50909init(r5, r1)
        goto L_0x0213
    L_0x007e:
        com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
        r5 = 5007(0x138f, float:7.016E-42)
        java.lang.String r1 = "资源加载错误"
        r0.m50909init(r5, r1)
        goto L_0x0213
    L_0x0089:
        com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>(r3)
        r1.append(r5)
        java.lang.String r5 = r1.toString()
        r0.m50909init(r4, r5)
        goto L_0x0213
    L_0x009c:
        com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>(r3)
        r1.append(r5)
        java.lang.String r5 = r1.toString()
        r0.m50909init(r4, r5)
        goto L_0x0213
    L_0x00af:
        com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>(r3)
        r1.append(r5)
        java.lang.String r5 = r1.toString()
        r0.m50909init(r4, r5)
        goto L_0x0213
    L_0x00c2:
        com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>(r3)
        r1.append(r5)
        java.lang.String r5 = r1.toString()
        r0.m50909init(r4, r5)
        goto L_0x0213
    L_0x00d5:
        com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
        java.lang.String r5 = "内部错误，详细码：200202"
        r0.m50909init(r2, r5)
        goto L_0x0213
    L_0x00de:
        com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
        java.lang.String r5 = "内部错误，详细码：200201"
        r0.m50909init(r2, r5)
        goto L_0x0213
    L_0x00e7:
        com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
        r5 = 5009(0x1391, float:7.019E-42)
        java.lang.String r1 = "广告请求量或者消耗等超过小时限额，请一小时后再请求广告"
        r0.m50909init(r5, r1)
        goto L_0x0213
    L_0x00f2:
        com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
        r5 = 5005(0x138d, float:7.013E-42)
        java.lang.String r1 = "广告请求量或者消耗等超过日限额，请明天再请求广告"
        r0.m50909init(r5, r1)
        goto L_0x0213
    L_0x00fd:
        com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
        r5 = 4013(0xfad, float:5.623E-42)
        java.lang.String r1 = "使用支持视频素材的原生模板广告位前，请升级您的SDK"
        r0.m50909init(r5, r1)
        goto L_0x0213
    L_0x0108:
        com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
        java.lang.String r5 = "广告样式校验失败，请检查广告位与接口使用是否一致"
        r0.m50909init(r1, r5)
        goto L_0x0213
    L_0x0111:
        com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
        r5 = 5006(0x138e, float:7.015E-42)
        java.lang.String r1 = "包名校验错误，当前App的包名和广点通移动联盟官网注册的媒体包名不一致，因此无广告返回"
        r0.m50909init(r5, r1)
        goto L_0x0213
    L_0x011c:
        com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
        r5 = 4016(0xfb0, float:5.628E-42)
        java.lang.String r1 = "应用横竖方向参数与广告位支持方向不匹配"
        r0.m50909init(r5, r1)
        goto L_0x0213
    L_0x0127:
        com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
        r5 = 5021(0x139d, float:7.036E-42)
        java.lang.String r1 = "该类型广告已废弃，请使用其他类型的广告"
        r0.m50909init(r5, r1)
        goto L_0x0213
    L_0x0132:
        com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
        r5 = 5012(0x1394, float:7.023E-42)
        java.lang.String r1 = "广告数据已过期，请重新拉取广告"
        r0.m50909init(r5, r1)
        goto L_0x0213
    L_0x013d:
        com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
        java.lang.String r5 = "原生模版渲染失败"
        r0.m50909init(r1, r5)
        goto L_0x0213
    L_0x0146:
        com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
        r5 = 4011(0xfab, float:5.62E-42)
        java.lang.String r1 = "开屏广告拉取超时"
        r0.m50909init(r5, r1)
        goto L_0x0213
    L_0x0151:
        com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
        r5 = 4009(0xfa9, float:5.618E-42)
        java.lang.String r1 = "开屏广告的自定义跳过按钮尺寸小于3x3dp"
        r0.m50909init(r5, r1)
        goto L_0x0213
    L_0x015c:
        com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
        r5 = 4008(0xfa8, float:5.616E-42)
        java.lang.String r1 = "设备方向不适合展示广告"
        r0.m50909init(r5, r1)
        goto L_0x0213
    L_0x0167:
        com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
        r5 = 4007(0xfa7, float:5.615E-42)
        java.lang.String r1 = "当前设备或系统不支持"
        r0.m50909init(r5, r1)
        goto L_0x0213
    L_0x0172:
        com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
        r5 = 4006(0xfa6, float:5.614E-42)
        java.lang.String r1 = "原生广告接口调用顺序错误，调用点击接口前未调用曝光接口"
        r0.m50909init(r5, r1)
        goto L_0x0213
    L_0x017d:
        com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
        r5 = 4005(0xfa5, float:5.612E-42)
        java.lang.String r1 = "开屏广告容器的高度低于400dp"
        r0.m50909init(r5, r1)
        goto L_0x0213
    L_0x0188:
        com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
        r5 = 4004(0xfa4, float:5.611E-42)
        java.lang.String r1 = "开屏广告容器不可见"
        r0.m50909init(r5, r1)
        goto L_0x0213
    L_0x0193:
        com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
        r5 = 4003(0xfa3, float:5.61E-42)
        java.lang.String r1 = "广告位错误"
        r0.m50909init(r5, r1)
        goto L_0x0213
    L_0x019e:
        com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
        r5 = 4002(0xfa2, float:5.608E-42)
        java.lang.String r1 = "Manifest文件中Activity/Service/Permission的声明有问题或者Permission权限未授予"
        r0.m50909init(r5, r1)
        goto L_0x0213
    L_0x01a9:
        com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
        java.lang.String r5 = "传入的参数有错误"
        r0.m50909init(r4, r5)
        goto L_0x0213
    L_0x01b1:
        com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
        r5 = 3003(0xbbb, float:4.208E-42)
        java.lang.String r1 = "网络不可用"
        r0.m50909init(r5, r1)
        goto L_0x0213
    L_0x01bb:
        com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
        r5 = 4012(0xfac, float:5.622E-42)
        java.lang.String r1 = "内容接口调用顺序错误，调用点击接口前未调用曝光接口"
        r0.m50909init(r5, r1)
        goto L_0x0213
    L_0x01c5:
        com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
        r5 = 3001(0xbb9, float:4.205E-42)
        java.lang.String r1 = "网络异常"
        r0.m50909init(r5, r1)
        goto L_0x0213
    L_0x01cf:
        com.qq.e.comm.util.AdError r5 = new com.qq.e.comm.util.AdError
        java.lang.String r1 = "初始化错误，详细码：200103"
        r5.m50909init(r0, r1)
        goto L_0x01ee
    L_0x01d7:
        com.qq.e.comm.util.AdError r5 = new com.qq.e.comm.util.AdError
        java.lang.String r1 = "初始化错误，详细码：200102"
        r5.m50909init(r0, r1)
        goto L_0x01ee
    L_0x01df:
        com.qq.e.comm.util.AdError r5 = new com.qq.e.comm.util.AdError
        java.lang.String r1 = "初始化错误，详细码：200101"
        r5.m50909init(r0, r1)
        goto L_0x01ee
    L_0x01e7:
        com.qq.e.comm.util.AdError r5 = new com.qq.e.comm.util.AdError
        java.lang.String r1 = "初始化错误"
        r5.m50909init(r0, r1)
    L_0x01ee:
        r0 = r5
        goto L_0x0213
    L_0x01f0:
        com.qq.e.comm.util.AdError r5 = new com.qq.e.comm.util.AdError
        java.lang.String r1 = "同一条广告不允许多次展示，请再次拉取后展示"
        r5.m50909init(r0, r1)
        goto L_0x01ee
    L_0x01f8:
        com.qq.e.comm.util.AdError r5 = new com.qq.e.comm.util.AdError
        java.lang.String r1 = "广告数据尚未准备好"
        r5.m50909init(r0, r1)
        goto L_0x01ee
    L_0x0200:
        com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
        r5 = 5003(0x138b, float:7.01E-42)
        java.lang.String r1 = "视频素材播放错误"
        r0.m50909init(r5, r1)
        goto L_0x0213
    L_0x020a:
        com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
        r5 = 5002(0x138a, float:7.009E-42)
        java.lang.String r1 = "视频素材下载错误"
        r0.m50909init(r5, r1)
    L_0x0213:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p522qq.p523e.comm.C6411a.m25175a(int):com.qq.e.comm.util.AdError");
    }

    /* renamed from: a */
    public static boolean m25176a(Context context) {
        try {
            if (m25179b(context)) {
                if (m25177a(context, Class.forName(CustomPkgConstants.getADActivityName()))) {
                    if (m25177a(context, Class.forName(CustomPkgConstants.getPortraitADActivityName()))) {
                        if (m25177a(context, Class.forName(CustomPkgConstants.getLandscapeADActivityName()))) {
                            if (m25180b(context, Class.forName(CustomPkgConstants.getDownLoadServiceName()))) {
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            GDTLogger.m25261e("Exception While check SDK Env", th);
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m25177a(Context context, Class<?>... clsArr) {
        int i = 0;
        while (i <= 0) {
            try {
                Intent intent = new Intent();
                intent.setClass(context, clsArr[0]);
                if (context.getPackageManager().resolveActivity(intent, 65536) == null) {
                    GDTLogger.m25260e(String.format("Activity[%s] is required in AndroidManifest.xml", new Object[]{clsArr[0].getName()}));
                    return false;
                }
                i++;
            } catch (Throwable th) {
                GDTLogger.m25261e("Exception while checking required activities", th);
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0033 A[SYNTHETIC, Splitter:B:20:0x0033] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x003d A[SYNTHETIC, Splitter:B:26:0x003d] */
    /* renamed from: a */
    public static byte[] m25178a(byte[] r3) {
        /*
        if (r3 == 0) goto L_0x0049
        int r0 = r3.length
        if (r0 != 0) goto L_0x0006
        goto L_0x0049
    L_0x0006:
        java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
        r0.<init>()
        r1 = 0
        java.util.zip.GZIPOutputStream r2 = new java.util.zip.GZIPOutputStream     // Catch:{ Exception -> 0x002c, all -> 0x0029 }
        r2.<init>(r0)     // Catch:{ Exception -> 0x002c, all -> 0x0029 }
        r2.write(r3)     // Catch:{ Exception -> 0x0027 }
        r2.finish()     // Catch:{ Exception -> 0x0027 }
        byte[] r1 = r0.toByteArray()     // Catch:{ Exception -> 0x0027 }
        r2.close()     // Catch:{ Exception -> 0x0022 }
        r0.close()     // Catch:{ Exception -> 0x0022 }
        goto L_0x0039
    L_0x0022:
        r3 = move-exception
        r3.printStackTrace()
        goto L_0x0039
    L_0x0027:
        r3 = move-exception
        goto L_0x002e
    L_0x0029:
        r3 = move-exception
        r2 = r1
        goto L_0x003b
    L_0x002c:
        r3 = move-exception
        r2 = r1
    L_0x002e:
        r3.printStackTrace()     // Catch:{ all -> 0x003a }
        if (r2 == 0) goto L_0x0036
        r2.close()     // Catch:{ Exception -> 0x0022 }
    L_0x0036:
        r0.close()     // Catch:{ Exception -> 0x0022 }
    L_0x0039:
        return r1
    L_0x003a:
        r3 = move-exception
    L_0x003b:
        if (r2 == 0) goto L_0x0040
        r2.close()     // Catch:{ Exception -> 0x0044 }
    L_0x0040:
        r0.close()     // Catch:{ Exception -> 0x0044 }
        goto L_0x0048
    L_0x0044:
        r0 = move-exception
        r0.printStackTrace()
    L_0x0048:
        throw r3
    L_0x0049:
        return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p522qq.p523e.comm.C6411a.m25178a(byte[]):byte[]");
    }

    /* renamed from: b */
    private static boolean m25179b(Context context) {
        String[] strArr = {Constants.PERMISSION_INTERNET, Constants.PERMISSION_ACCESS_NETWORK_STATE, Constants.PERMISSION_ACCESS_WIFI_STATE};
        int i = 0;
        while (i < 3) {
            try {
                String str = strArr[i];
                if (context.checkCallingOrSelfPermission(str) == -1) {
                    GDTLogger.m25260e(String.format("Permission %s is required in AndroidManifest.xml", new Object[]{str}));
                    return false;
                }
                i++;
            } catch (Throwable th) {
                GDTLogger.m25261e("Check required Permissions error", th);
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    private static boolean m25180b(Context context, Class<?>... clsArr) {
        int i = 0;
        while (i <= 0) {
            try {
                Class<?> cls = clsArr[0];
                Intent intent = new Intent();
                intent.setClass(context, cls);
                if (context.getPackageManager().resolveService(intent, 65536) == null) {
                    GDTLogger.m25260e(String.format("Service[%s] is required in AndroidManifest.xml", new Object[]{cls.getName()}));
                    return false;
                }
                i++;
            } catch (Throwable th) {
                GDTLogger.m25261e("Exception while checking required services", th);
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0048 A[SYNTHETIC, Splitter:B:23:0x0048] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0055 A[SYNTHETIC, Splitter:B:29:0x0055] */
    /* renamed from: b */
    public static byte[] m25181b(byte[] r6) {
        /*
        if (r6 == 0) goto L_0x0064
        int r0 = r6.length
        if (r0 != 0) goto L_0x0006
        goto L_0x0064
    L_0x0006:
        java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream
        r0.<init>(r6)
        java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream
        r6.<init>()
        r1 = 1024(0x400, float:1.435E-42)
        byte[] r1 = new byte[r1]
        r2 = 0
        java.util.zip.GZIPInputStream r3 = new java.util.zip.GZIPInputStream     // Catch:{ Exception -> 0x0041, all -> 0x003e }
        r3.<init>(r0)     // Catch:{ Exception -> 0x0041, all -> 0x003e }
    L_0x001a:
        int r4 = r3.read(r1)     // Catch:{ Exception -> 0x003c }
        r5 = -1
        if (r4 == r5) goto L_0x0026
        r5 = 0
        r6.write(r1, r5, r4)     // Catch:{ Exception -> 0x003c }
        goto L_0x001a
    L_0x0026:
        r6.flush()     // Catch:{ Exception -> 0x003c }
        byte[] r2 = r6.toByteArray()     // Catch:{ Exception -> 0x003c }
        r3.close()     // Catch:{ Exception -> 0x0037 }
        r0.close()     // Catch:{ Exception -> 0x0037 }
        r6.close()     // Catch:{ Exception -> 0x0037 }
        goto L_0x0051
    L_0x0037:
        r6 = move-exception
        r6.printStackTrace()
        goto L_0x0051
    L_0x003c:
        r1 = move-exception
        goto L_0x0043
    L_0x003e:
        r1 = move-exception
        r3 = r2
        goto L_0x0053
    L_0x0041:
        r1 = move-exception
        r3 = r2
    L_0x0043:
        r1.printStackTrace()     // Catch:{ all -> 0x0052 }
        if (r3 == 0) goto L_0x004b
        r3.close()     // Catch:{ Exception -> 0x0037 }
    L_0x004b:
        r0.close()     // Catch:{ Exception -> 0x0037 }
        r6.close()     // Catch:{ Exception -> 0x0037 }
    L_0x0051:
        return r2
    L_0x0052:
        r1 = move-exception
    L_0x0053:
        if (r3 == 0) goto L_0x0058
        r3.close()     // Catch:{ Exception -> 0x005f }
    L_0x0058:
        r0.close()     // Catch:{ Exception -> 0x005f }
        r6.close()     // Catch:{ Exception -> 0x005f }
        goto L_0x0063
    L_0x005f:
        r6 = move-exception
        r6.printStackTrace()
    L_0x0063:
        throw r1
    L_0x0064:
        return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p522qq.p523e.comm.C6411a.m25181b(byte[]):byte[]");
    }
}
