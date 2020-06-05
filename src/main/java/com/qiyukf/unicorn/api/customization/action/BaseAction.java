package com.qiyukf.unicorn.api.customization.action;

import android.app.Activity;
import android.content.Intent;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import com.qiyukf.nim.uikit.session.module.C5567a;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.api.msg.UnicornMessageBuilder;
import java.io.File;
import java.io.Serializable;

public abstract class BaseAction implements Serializable {
    private transient C5567a container;
    private int iconResId;
    private transient int index;
    private int titleId;

    public BaseAction(int i, int i2) {
        this.iconResId = i;
        this.titleId = i2;
    }

    public final IMMessage buidlImageMessage(File file) {
        return UnicornMessageBuilder.buildImageMessage(getAccount(), file, file.getName());
    }

    public final IMMessage buildTextMessage(String str) {
        return UnicornMessageBuilder.buildTextMessage(getAccount(), str);
    }

    public final String getAccount() {
        return this.container.f17922c;
    }

    public int getActionFontColor() {
        return -3407617;
    }

    public final Activity getActivity() {
        return this.container.f17920a;
    }

    public final Fragment getFragment() {
        return this.container.f17921b;
    }

    public int getIconResId() {
        return this.iconResId;
    }

    public int getTitleId() {
        return this.titleId;
    }

    /* access modifiers changed from: protected|final */
    public final int makeRequestCode(int i) {
        if ((i & InputDeviceCompat.SOURCE_ANY) == 0) {
            return ((this.index + 1) << 8) + (i & 255);
        }
        throw new IllegalArgumentException("Can only use lower 8 bits for requestCode");
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public abstract void onClick();

    public void setContainer(C5567a aVar) {
        this.container = aVar;
    }

    public void setIndex(int i) {
        this.index = i;
    }
}
