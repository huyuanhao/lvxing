package com.tencent.android.tpush.service.channel;

import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.service.channel.exception.ChannelException;
import com.tencent.android.tpush.service.channel.p592b.C7028h;
import com.tencent.android.tpush.service.channel.p593c.C7035b;
import java.util.Random;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.service.channel.c */
public class C7030c {
    /* renamed from: g */
    private static int f23366g = new Random().nextInt();
    /* renamed from: a */
    public int f23367a = 0;
    /* renamed from: b */
    public long f23368b = Long.MAX_VALUE;
    /* renamed from: c */
    public long f23369c = Long.MAX_VALUE;
    /* renamed from: d */
    public short f23370d;
    /* renamed from: e */
    public JceStruct f23371e = null;
    /* renamed from: f */
    public C7031a f23372f;
    /* renamed from: h */
    private int f23373h = 0;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.android.tpush.service.channel.c$a */
    public interface C7031a {
        /* renamed from: a */
        void mo33269a(JceStruct jceStruct, int i, JceStruct jceStruct2, C7000a aVar);

        /* renamed from: a */
        void mo33270a(JceStruct jceStruct, C7000a aVar);

        /* renamed from: a */
        void mo33271a(JceStruct jceStruct, ChannelException channelException, C7000a aVar);
    }

    public C7030c(JceStruct jceStruct, C7031a aVar) {
        this.f23370d = C7035b.m30084a(jceStruct.getClass());
        this.f23371e = jceStruct;
        this.f23372f = aVar;
    }

    public C7030c(short s, JceStruct jceStruct, C7031a aVar) {
        this.f23370d = s;
        this.f23371e = jceStruct;
        this.f23372f = aVar;
    }

    /* renamed from: a */
    public void mo33454a(C7028h hVar) {
        hVar.mo33441a(this.f23370d);
        if ((this.f23370d & 127) != 7) {
            try {
                hVar.mo33443b(1);
                JceOutputStream jceOutputStream = new JceOutputStream();
                jceOutputStream.setServerEncoding("UTF-8");
                this.f23371e.writeTo(jceOutputStream);
                hVar.mo33442a(jceOutputStream.toByteArray());
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("jceMessage.write Error:");
                sb.append(th.getLocalizedMessage());
                C6864a.m29309j("XINGE", sb.toString());
                if (XGPushConfig.enableDebug) {
                    th.printStackTrace();
                }
            }
        } else {
            hVar.mo33443b(20);
        }
    }

    /* renamed from: a */
    public boolean mo33455a() {
        return (this.f23370d & 127) == 7;
    }

    /* renamed from: b */
    public boolean mo33456b() {
        short s = this.f23370d;
        return (s & 127) == 4 || (s & 127) == 15 || (s & 127) == 5;
    }

    /* renamed from: c */
    public int mo33457c() {
        int i = f23366g + 1;
        f23366g = i;
        this.f23373h = i;
        return this.f23373h;
    }

    /* renamed from: d */
    public int mo33458d() {
        return this.f23373h;
    }

    public String toString() {
        if (this.f23371e == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f23371e.getClass().getSimpleName());
        sb.append(":");
        sb.append(this.f23371e);
        sb.append(", ");
        sb.append(this.f23372f);
        sb.append(" retryTimes ");
        sb.append(this.f23367a);
        return sb.toString();
    }
}
