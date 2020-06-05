package com.tencent.p607mm.opensdk.channel.p608a;

import com.tencent.p607mm.opensdk.utils.C7335b;

/* renamed from: com.tencent.mm.opensdk.channel.a.b */
public final class C7324b {
    /* renamed from: a */
    public static byte[] m31613a(String str, int i, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        if (str != null) {
            stringBuffer.append(str);
        }
        stringBuffer.append(i);
        stringBuffer.append(str2);
        stringBuffer.append("mMcShCsTr");
        return C7335b.m31633c(stringBuffer.toString().substring(1, 9).getBytes()).getBytes();
    }
}
