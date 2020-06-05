package com.qiyukf.nim.uikit.session.module;

import com.qiyukf.nimlib.sdk.msg.model.IMMessage;

/* renamed from: com.qiyukf.nim.uikit.session.module.b */
public interface C5591b {
    boolean isAllowSendMessage(boolean z);

    boolean isLongClickEnabled();

    boolean sendMessage(IMMessage iMMessage, boolean z);

    void shouldCollapseInputPanel();
}
