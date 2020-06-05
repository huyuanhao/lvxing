package com.qiyukf.unicorn.api.customization.action;

import com.qiyukf.nim.uikit.session.p425a.C5491a;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.api.msg.MessageService;
import java.io.File;

public class ImageAction extends C5491a {
    int actionFontColor = 0;

    public ImageAction() {
        super(C5961R.C5962drawable.ysf_message_plus_photo_selector, C5961R.string.ysf_input_panel_photo, true);
    }

    public ImageAction(int i, int i2) {
        super(i, i2, true);
    }

    public int getActionFontColor() {
        int i = this.actionFontColor;
        return i == 0 ? super.getActionFontColor() : i;
    }

    /* access modifiers changed from: protected */
    public void onPicked(File file) {
        MessageService.sendMessage(buidlImageMessage(file));
    }

    public void setActionFontColor(int i) {
        this.actionFontColor = i;
    }
}
