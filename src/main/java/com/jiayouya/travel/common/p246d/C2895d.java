package com.jiayouya.travel.common.p246d;

import android.os.Build;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, mo39189d2 = {"Lcom/jiayouya/travel/common/util/DeviceUtil;", "", "()V", "getNetWorkType", "", "getUniqueID", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: DeviceUtil.kt */
/* renamed from: com.jiayouya.travel.common.d.d */
public final class C2895d {
    /* renamed from: a */
    public static final C2895d f9632a = new C2895d();

    private C2895d() {
    }

    /* renamed from: a */
    public final String mo19948a() {
        String str = "UUID(devIDShort.hashCode…de().toLong()).toString()";
        StringBuilder sb = new StringBuilder();
        sb.append("35");
        sb.append(Build.BOARD.length() % 10);
        sb.append(Build.BRAND.length() % 10);
        sb.append(Build.CPU_ABI.length() % 10);
        sb.append(Build.DEVICE.length() % 10);
        sb.append(Build.MANUFACTURER.length() % 10);
        sb.append(Build.MODEL.length() % 10);
        sb.append(Build.PRODUCT.length() % 10);
        String sb2 = sb.toString();
        try {
            String uuid = new UUID((long) sb2.hashCode(), (long) Build.class.getField("SERIAL").get(null).toString().hashCode()).toString();
            C8271i.m35382a((Object) uuid, str);
            return uuid;
        } catch (Exception unused) {
            String uuid2 = new UUID((long) sb2.hashCode(), (long) "serial".hashCode()).toString();
            C8271i.m35382a((Object) uuid2, str);
            return uuid2;
        }
    }
}
