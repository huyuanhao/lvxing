package com.qiyukf.unicorn.api.customization.msg_list.baseviewholder;

import android.content.Context;
import android.view.View;
import com.qiyukf.nim.uikit.session.viewholder.C5622b;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;

public abstract class UnicornMessageViewHolder extends C5622b {
    /* access modifiers changed from: protected|final */
    public final void bindContentView() {
        bindContentView(this.message, this.context);
    }

    public abstract void bindContentView(IMMessage iMMessage, Context context);

    /* access modifiers changed from: protected */
    public <T extends View> T findViewById(int i) {
        return super.findViewById(i);
    }

    /* access modifiers changed from: protected|final */
    public final int getContentResId() {
        return getViewHolderResid();
    }

    public abstract int getViewHolderResid();

    /* access modifiers changed from: protected|final */
    public final void inflateContentView() {
        inflateFindView();
    }

    public abstract void inflateFindView();

    /* access modifiers changed from: protected */
    public boolean isMiddleItem() {
        return super.isMiddleItem();
    }

    /* access modifiers changed from: protected */
    public boolean isReceivedMessage() {
        return super.isReceivedMessage();
    }

    /* access modifiers changed from: protected */
    public int leftBackground() {
        return super.leftBackground();
    }

    /* access modifiers changed from: protected */
    public void onItemClick() {
        super.onItemClick();
    }

    /* access modifiers changed from: protected */
    public boolean onItemLongClick() {
        return super.onItemLongClick();
    }

    /* access modifiers changed from: protected */
    public int rightBackground() {
        return super.rightBackground();
    }

    /* access modifiers changed from: protected */
    public boolean showAvatar() {
        return super.showAvatar();
    }
}
