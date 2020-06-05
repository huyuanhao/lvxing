package com.p522qq.p523e.comm.constants;

import com.p522qq.p523e.ads.ADActivity;
import com.p522qq.p523e.ads.LandscapeADActivity;
import com.p522qq.p523e.ads.PortraitADActivity;
import com.p522qq.p523e.ads.RewardvideoLandscapeADActivity;
import com.p522qq.p523e.ads.RewardvideoPortraitADActivity;
import com.p522qq.p523e.comm.DownloadService;
import com.p522qq.p523e.comm.managers.setting.GlobalSetting;
import com.p522qq.p523e.comm.util.StringUtil;

/* renamed from: com.qq.e.comm.constants.CustomPkgConstants */
public class CustomPkgConstants {
    /* renamed from: a */
    private static final String f20162a = DownloadService.class.getName();
    /* renamed from: b */
    private static final String f20163b = ADActivity.class.getName();
    /* renamed from: c */
    private static final String f20164c = PortraitADActivity.class.getName();
    /* renamed from: d */
    private static final String f20165d = RewardvideoPortraitADActivity.class.getName();
    /* renamed from: e */
    private static final String f20166e = LandscapeADActivity.class.getName();
    /* renamed from: f */
    private static final String f20167f = RewardvideoLandscapeADActivity.class.getName();

    public static String getADActivityName() {
        String customADActivityClassName = GlobalSetting.getCustomADActivityClassName();
        return !StringUtil.isEmpty(customADActivityClassName) ? customADActivityClassName : f20163b;
    }

    public static String getAssetPluginDir() {
        return "gdt_plugin";
    }

    public static String getAssetPluginName() {
        return "gdtadv2.jar";
    }

    public static String getAssetPluginXorKey() {
        return "";
    }

    public static String getDownLoadServiceName() {
        return f20162a;
    }

    public static String getLandscapeADActivityName() {
        String customLandscapeActivityClassName = GlobalSetting.getCustomLandscapeActivityClassName();
        return !StringUtil.isEmpty(customLandscapeActivityClassName) ? customLandscapeActivityClassName : f20166e;
    }

    public static String getPortraitADActivityName() {
        String customPortraitActivityClassName = GlobalSetting.getCustomPortraitActivityClassName();
        return !StringUtil.isEmpty(customPortraitActivityClassName) ? customPortraitActivityClassName : f20164c;
    }

    public static String getRewardvideoLandscapeADActivityName() {
        String customRewardvideoLandscapeActivityClassName = GlobalSetting.getCustomRewardvideoLandscapeActivityClassName();
        return !StringUtil.isEmpty(customRewardvideoLandscapeActivityClassName) ? customRewardvideoLandscapeActivityClassName : f20167f;
    }

    public static String getRewardvideoPortraitADActivityName() {
        String customRewardvideoPortraitActivityClassName = GlobalSetting.getCustomRewardvideoPortraitActivityClassName();
        return !StringUtil.isEmpty(customRewardvideoPortraitActivityClassName) ? customRewardvideoPortraitActivityClassName : f20165d;
    }
}
