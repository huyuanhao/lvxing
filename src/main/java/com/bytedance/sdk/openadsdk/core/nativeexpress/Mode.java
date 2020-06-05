package com.bytedance.sdk.openadsdk.core.nativeexpress;

import com.p522qq.p523e.comm.constants.ErrorCode.OtherError;
import com.tencent.bugly.beta.tinker.TinkerReport;

/* renamed from: com.bytedance.sdk.openadsdk.core.nativeexpress.i */
public class Mode {
    /* renamed from: a */
    public int f7846a = 1;
    /* renamed from: b */
    public float f7847b = 1.0f;
    /* renamed from: c */
    public int f7848c = OtherError.CONTAINER_INVISIBLE_ERROR;
    /* renamed from: d */
    public int f7849d = TinkerReport.KEY_APPLIED_PACKAGE_CHECK_SIGNATURE;

    public Mode(int i, float f, int i2, int i3) {
        this.f7846a = i;
        this.f7847b = f;
        this.f7848c = i2;
        this.f7849d = i3;
    }
}
