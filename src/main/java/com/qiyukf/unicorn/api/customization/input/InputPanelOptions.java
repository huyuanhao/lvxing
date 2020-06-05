package com.qiyukf.unicorn.api.customization.input;

import java.io.Serializable;

public class InputPanelOptions implements Serializable {
    public transient ActionPanelOptions actionPanelOptions;
    public int emojiIconResId;
    public int moreIconResId;
    public int photoIconResId;
    public boolean showActionPanel = false;
    public int voiceIconResId;
}
