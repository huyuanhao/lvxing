package com.jiayouya.travel.module.travel.p287c;

import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/util/GoldUtil;", "", "()V", "format1", "Ljava/text/DecimalFormat;", "format2", "format3", "format", "", "value", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.travel.c.a */
public final class GoldUtil {
    /* renamed from: a */
    public static final GoldUtil f11900a = new GoldUtil();
    /* renamed from: b */
    private static final DecimalFormat f11901b = new DecimalFormat("0.00");
    /* renamed from: c */
    private static final DecimalFormat f11902c = new DecimalFormat("0.0");
    /* renamed from: d */
    private static final DecimalFormat f11903d = new DecimalFormat("0");

    private GoldUtil() {
    }

    /* renamed from: a */
    public final String mo21651a(double d) {
        String format = f11903d.format(d);
        int length = format.length();
        if (length >= 0 && 6 >= length) {
            C8271i.m35382a((Object) format, "s");
            return format;
        }
        String str = "k";
        if (length == 7) {
            StringBuilder sb = new StringBuilder();
            sb.append(f11902c.format(d / Math.pow(10.0d, 3.0d)));
            sb.append(str);
            return sb.toString();
        } else if (length == 8) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(f11903d.format(d / Math.pow(10.0d, 3.0d)));
            sb2.append(str);
            return sb2.toString();
        } else {
            String str2 = "m";
            if (length == 9) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(f11901b.format(d / Math.pow(10.0d, 6.0d)));
                sb3.append(str2);
                return sb3.toString();
            } else if (length == 10) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(f11902c.format(d / Math.pow(10.0d, 6.0d)));
                sb4.append(str2);
                return sb4.toString();
            } else if (length == 11) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(f11903d.format(d / Math.pow(10.0d, 6.0d)));
                sb5.append(str2);
                return sb5.toString();
            } else {
                String str3 = "b";
                if (length == 12) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(f11901b.format(d / Math.pow(10.0d, 9.0d)));
                    sb6.append(str3);
                    return sb6.toString();
                } else if (length == 13) {
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(f11902c.format(d / Math.pow(10.0d, 9.0d)));
                    sb7.append(str3);
                    return sb7.toString();
                } else if (length == 14) {
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append(f11903d.format(d / Math.pow(10.0d, 9.0d)));
                    sb8.append(str3);
                    return sb8.toString();
                } else {
                    String str4 = "t";
                    if (length == 15) {
                        StringBuilder sb9 = new StringBuilder();
                        sb9.append(f11901b.format(d / Math.pow(10.0d, 12.0d)));
                        sb9.append(str4);
                        return sb9.toString();
                    } else if (length == 16) {
                        StringBuilder sb10 = new StringBuilder();
                        sb10.append(f11902c.format(d / Math.pow(10.0d, 12.0d)));
                        sb10.append(str4);
                        return sb10.toString();
                    } else if (length == 17) {
                        StringBuilder sb11 = new StringBuilder();
                        sb11.append(f11903d.format(d / Math.pow(10.0d, 12.0d)));
                        sb11.append(str4);
                        return sb11.toString();
                    } else {
                        String str5 = "aa";
                        if (length == 18) {
                            StringBuilder sb12 = new StringBuilder();
                            sb12.append(f11901b.format(d / Math.pow(10.0d, 15.0d)));
                            sb12.append(str5);
                            return sb12.toString();
                        } else if (length == 19) {
                            StringBuilder sb13 = new StringBuilder();
                            sb13.append(f11902c.format(d / Math.pow(10.0d, 15.0d)));
                            sb13.append(str5);
                            return sb13.toString();
                        } else if (length == 20) {
                            StringBuilder sb14 = new StringBuilder();
                            sb14.append(f11903d.format(d / Math.pow(10.0d, 15.0d)));
                            sb14.append(str5);
                            return sb14.toString();
                        } else {
                            String str6 = "ab";
                            if (length == 21) {
                                StringBuilder sb15 = new StringBuilder();
                                sb15.append(f11901b.format(d / Math.pow(10.0d, 18.0d)));
                                sb15.append(str6);
                                return sb15.toString();
                            } else if (length == 22) {
                                StringBuilder sb16 = new StringBuilder();
                                sb16.append(f11902c.format(d / Math.pow(10.0d, 18.0d)));
                                sb16.append(str6);
                                return sb16.toString();
                            } else {
                                StringBuilder sb17 = new StringBuilder();
                                sb17.append(f11903d.format(d / Math.pow(10.0d, 18.0d)));
                                sb17.append(str6);
                                return sb17.toString();
                            }
                        }
                    }
                }
            }
        }
    }
}
