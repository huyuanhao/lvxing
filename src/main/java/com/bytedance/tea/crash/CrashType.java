package com.bytedance.tea.crash;

import com.qiyukf.nimlib.sdk.msg.MsgService;

/* renamed from: com.bytedance.tea.crash.c */
public enum CrashType {
    LAUNCH("launch"),
    JAVA("java"),
    NATIVE("native"),
    ANR("anr"),
    BLOCK("block"),
    ENSURE("ensure"),
    DART("dart"),
    CUSTOM_JAVA("custom_java"),
    ALL(MsgService.MSG_CHATTING_ACCOUNT_ALL);
    
    /* renamed from: j */
    private String f9272j;

    private CrashType(String str) {
        this.f9272j = str;
    }

    /* renamed from: a */
    public String mo16988a() {
        return this.f9272j;
    }
}
