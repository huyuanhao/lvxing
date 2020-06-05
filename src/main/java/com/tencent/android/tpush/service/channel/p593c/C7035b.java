package com.tencent.android.tpush.service.channel.p593c;

import android.util.SparseArray;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceStruct;
import com.tencent.android.tpush.service.channel.exception.CommandMappingException;
import com.tencent.android.tpush.service.channel.protocol.TpnsClientReportReq;
import com.tencent.android.tpush.service.channel.protocol.TpnsClientReportRsp;
import com.tencent.android.tpush.service.channel.protocol.TpnsConfigReq;
import com.tencent.android.tpush.service.channel.protocol.TpnsConfigRsp;
import com.tencent.android.tpush.service.channel.protocol.TpnsGetApListReq;
import com.tencent.android.tpush.service.channel.protocol.TpnsGetApListRsp;
import com.tencent.android.tpush.service.channel.protocol.TpnsPushClickReq;
import com.tencent.android.tpush.service.channel.protocol.TpnsPushClickRsp;
import com.tencent.android.tpush.service.channel.protocol.TpnsPushClientReq;
import com.tencent.android.tpush.service.channel.protocol.TpnsPushCommReportReq;
import com.tencent.android.tpush.service.channel.protocol.TpnsPushCommReportRsp;
import com.tencent.android.tpush.service.channel.protocol.TpnsPushVerifyReq;
import com.tencent.android.tpush.service.channel.protocol.TpnsPushVerifyRsp;
import com.tencent.android.tpush.service.channel.protocol.TpnsReconnectReq;
import com.tencent.android.tpush.service.channel.protocol.TpnsReconnectRsp;
import com.tencent.android.tpush.service.channel.protocol.TpnsRedirectReq;
import com.tencent.android.tpush.service.channel.protocol.TpnsRedirectRsp;
import com.tencent.android.tpush.service.channel.protocol.TpnsRegisterReq;
import com.tencent.android.tpush.service.channel.protocol.TpnsRegisterRsp;
import com.tencent.android.tpush.service.channel.protocol.TpnsTokenTagReq;
import com.tencent.android.tpush.service.channel.protocol.TpnsTokenTagRsp;
import com.tencent.android.tpush.service.channel.protocol.TpnsUnregisterReq;
import com.tencent.android.tpush.service.channel.protocol.TpnsUnregisterRsp;
import com.tencent.android.tpush.service.channel.protocol.TpnsUpdateTokenReq;
import com.tencent.android.tpush.service.channel.protocol.TpnsUpdateTokenRsp;
import java.util.HashMap;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.service.channel.c.b */
public class C7035b {
    /* renamed from: a */
    public static final Integer f23387a = Integer.valueOf(0);
    /* renamed from: b */
    public static final Integer f23388b = Integer.valueOf(128);
    /* renamed from: c */
    public static final SparseArray<Class<?>> f23389c = new SparseArray<>();
    /* renamed from: d */
    public static final HashMap<Class<?>, Integer> f23390d = new HashMap<>();

    static {
        m30085a(f23387a, Byte.valueOf(1), TpnsPushClientReq.class);
        Integer num = f23387a;
        Byte valueOf = Byte.valueOf(2);
        m30085a(num, valueOf, TpnsGetApListReq.class);
        m30085a(f23388b, valueOf, TpnsGetApListRsp.class);
        Integer num2 = f23387a;
        Byte valueOf2 = Byte.valueOf(3);
        m30085a(num2, valueOf2, TpnsConfigReq.class);
        m30085a(f23388b, valueOf2, TpnsConfigRsp.class);
        Integer num3 = f23387a;
        Byte valueOf3 = Byte.valueOf(4);
        m30085a(num3, valueOf3, TpnsRegisterReq.class);
        m30085a(f23388b, valueOf3, TpnsRegisterRsp.class);
        Integer num4 = f23387a;
        Byte valueOf4 = Byte.valueOf(5);
        m30085a(num4, valueOf4, TpnsUnregisterReq.class);
        m30085a(f23388b, valueOf4, TpnsUnregisterRsp.class);
        Integer num5 = f23387a;
        Byte valueOf5 = Byte.valueOf(6);
        m30085a(num5, valueOf5, TpnsReconnectReq.class);
        m30085a(f23388b, valueOf5, TpnsReconnectRsp.class);
        Integer num6 = f23387a;
        Byte valueOf6 = Byte.valueOf(9);
        m30085a(num6, valueOf6, TpnsClientReportReq.class);
        m30085a(f23388b, valueOf6, TpnsClientReportRsp.class);
        Integer num7 = f23387a;
        Byte valueOf7 = Byte.valueOf(10);
        m30085a(num7, valueOf7, TpnsRedirectReq.class);
        m30085a(f23388b, valueOf7, TpnsRedirectRsp.class);
        m30085a(f23387a, Byte.valueOf(JceStruct.STRUCT_END), TpnsPushVerifyReq.class);
        m30085a(f23388b, Byte.valueOf(JceStruct.STRUCT_END), TpnsPushVerifyRsp.class);
        m30085a(f23387a, Byte.valueOf(15), TpnsTokenTagReq.class);
        m30085a(f23388b, Byte.valueOf(15), TpnsTokenTagRsp.class);
        m30085a(f23387a, Byte.valueOf(16), TpnsPushClickReq.class);
        m30085a(f23388b, Byte.valueOf(16), TpnsPushClickRsp.class);
        m30085a(f23387a, Byte.valueOf(17), TpnsUpdateTokenReq.class);
        m30085a(f23388b, Byte.valueOf(17), TpnsUpdateTokenRsp.class);
        m30085a(f23387a, Byte.valueOf(18), TpnsPushCommReportReq.class);
        m30085a(f23388b, Byte.valueOf(18), TpnsPushCommReportRsp.class);
    }

    /* renamed from: a */
    public static void m30085a(Integer num, Byte b, Class<?> cls) {
        f23389c.put(num.intValue() | b.byteValue(), cls);
        f23390d.put(cls, Integer.valueOf(num.intValue() | b.byteValue()));
    }

    /* renamed from: a */
    public static short m30084a(Class<?> cls) {
        return ((Integer) f23390d.get(cls)).shortValue();
    }

    /* renamed from: a */
    public static Class<?> m30083a(short s) {
        return (Class) f23389c.get(s);
    }

    /* renamed from: a */
    public static JceStruct m30082a(short s, byte[] bArr) {
        Class a = m30083a(s);
        if (a == null || bArr == null) {
            return null;
        }
        try {
            JceStruct jceStruct = (JceStruct) a.newInstance();
            JceInputStream jceInputStream = new JceInputStream(bArr);
            jceInputStream.setServerEncoding("UTF-8");
            jceStruct.readFrom(jceInputStream);
            return jceStruct;
        } catch (Exception e) {
            throw new CommandMappingException(e.getMessage(), e);
        }
    }
}
