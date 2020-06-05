package com.qiyukf.unicorn.api;

import com.qiyukf.unicorn.api.customization.input.InputPanelOptions;
import com.qiyukf.unicorn.api.customization.page_ad.IMPageViewConfig;
import com.qiyukf.unicorn.api.customization.title_bar.TitleBarConfig;
import com.qiyukf.unicorn.api.event.SDKEvents;
import com.qiyukf.unicorn.api.pop.OnShopEventListener;
import java.io.Serializable;

public class YSFOptions implements Serializable {
    public static YSFOptions DEFAULT = new YSFOptions();
    public boolean autoTrackUser = true;
    public int categoryDialogStyle;
    @Deprecated
    public String externalStoragePath;
    public UnicornGifImageLoader gifImageLoader;
    public transient IMPageViewConfig imPageViewConfig;
    public transient InputPanelOptions inputPanelOptions;
    public boolean isDefaultLoadMsg = true;
    public boolean isPullMessageFromServer = false;
    public boolean logSwitch = true;
    public transient OnBotEventListener onBotEventListener;
    public transient OnMessageItemClickListener onMessageItemClickListener;
    public transient OnShopEventListener onShopEventListener;
    public transient QuickEntryListener quickEntryListener;
    public SavePowerConfig savePowerConfig = null;
    public transient SDKEvents sdkEvents;
    public StatusBarNotificationConfig statusBarNotificationConfig;
    public transient TitleBarConfig titleBarConfig;
    public transient UICustomization uiCustomization;
}
