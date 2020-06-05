package com.tencent.android.tpush.service.channel.p592b;

import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.service.channel.exception.IORefusedException;
import com.tencent.android.tpush.service.channel.exception.InnerException;
import com.tencent.android.tpush.service.channel.exception.UnexpectedDataException;
import com.tencent.android.tpush.service.channel.p593c.C7036c;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.service.channel.b.h */
public class C7028h extends C7029i implements C7025e {
    /* renamed from: a */
    protected HashMap<String, Object> f23352a;
    /* renamed from: b */
    protected int f23353b;
    /* renamed from: c */
    protected int f23354c;

    public C7028h(int i) {
        this.f23352a = new HashMap<>(4);
        this.f23353b = 0;
        this.f23354c = -1;
        this.f23356d = 80;
        this.f23357e = i;
    }

    /* renamed from: d */
    public synchronized void mo33426d() {
        super.mo33426d();
        this.f23352a.clear();
    }

    /* renamed from: a */
    public int mo33416a(OutputStream outputStream) {
        int i;
        int i2;
        mo33425c();
        int i3 = 0;
        try {
            this.f23353b = 0;
            while (!mo33424b()) {
                int i4 = this.f23353b;
                this.f23353b = i4 + 1;
                if (i4 <= 2) {
                    int i5 = this.f23354c;
                    if (i5 == -5) {
                        i2 = mo33440f(outputStream);
                    } else if (i5 == -4) {
                        i2 = mo33439e(outputStream);
                    } else if (i5 == -3) {
                        i2 = mo33438d(outputStream);
                    } else if (i5 == -2) {
                        i2 = mo33437c(outputStream);
                    } else if (i5 == -1) {
                        i2 = mo33436b(outputStream);
                    } else if (i5 == 0) {
                        mo33426d();
                    } else {
                        throw new InnerException("illegal step value!");
                    }
                    i3 += i2;
                } else {
                    throw new InnerException("the duration of the current step is too long!");
                }
            }
        } catch (IORefusedException e) {
            C6864a.m29302d("Channel.SendPacket", "write >>> IORefusedException thrown", e);
        }
        return i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo33435a(int i) {
        if (this.f23354c != i) {
            this.f23353b = 0;
        }
        this.f23354c = i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo33436b(OutputStream outputStream) {
        C7036c.m30087a(outputStream, (int) this.f23356d);
        mo33435a(-2);
        return 1;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public int mo33437c(OutputStream outputStream) {
        C7036c.m30087a(outputStream, (int) this.f23362k);
        short s = this.f23362k;
        if (s == 1 || s == 10) {
            mo33435a(-3);
        } else if (s == 20) {
            mo33435a(0);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("protocol: ");
            sb.append(this.f23362k);
            throw new UnexpectedDataException(sb.toString());
        }
        return 1;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public int mo33438d(OutputStream outputStream) {
        C7036c.m30092b(outputStream, this.f23357e);
        mo33435a(-5);
        return 4;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public int mo33439e(OutputStream outputStream) {
        C7036c.m30088a(outputStream, this.f23358f);
        mo33435a(-5);
        return 4;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public int mo33440f(OutputStream outputStream) {
        String str = "packetData";
        byte[] bArr = (byte[]) this.f23352a.get(str);
        String str2 = "packetDataLeftLength";
        if (bArr == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                if (this.f23362k == 10) {
                    m30040h(byteArrayOutputStream);
                } else {
                    m30039g(byteArrayOutputStream);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                this.f23358f = (long) (byteArray.length + 10);
                this.f23352a.put(str, byteArray);
                this.f23352a.put(str2, Integer.valueOf(byteArray.length));
                mo33435a(-4);
                return 0;
            } catch (IOException e) {
                throw new UnexpectedDataException("packetData can not be write correctly!", e);
            }
        } else {
            int intValue = ((Integer) this.f23352a.get(str2)).intValue();
            if (intValue == 0) {
                mo33435a(0);
                return 0;
            }
            int a = C7036c.m30089a(outputStream, bArr);
            this.f23352a.put(str2, Integer.valueOf(intValue - a));
            return a;
        }
    }

    /* renamed from: g */
    private void m30039g(OutputStream outputStream) {
        this.f23361i = 0;
        if (this.f23348j.needsUpdate()) {
            this.f23361i = 1;
            this.f23348j.update();
        }
        C7036c.m30087a(outputStream, (int) this.f23361i);
        this.f23359g = this.f23348j.getRandom();
        C7036c.m30088a(outputStream, this.f23359g);
        if (this.f23361i != 0) {
            C7036c.m30089a(outputStream, this.f23348j.getEncKey());
        }
        m30040h(outputStream);
    }

    /* renamed from: h */
    private void m30040h(OutputStream outputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        C7036c.m30088a((OutputStream) byteArrayOutputStream, this.f23362k != 1 ? 0 : this.f23348j.getInc());
        C7036c.m30087a((OutputStream) byteArrayOutputStream, (int) this.f23363l);
        C7036c.m30087a((OutputStream) byteArrayOutputStream, (int) this.f23360h);
        C7036c.m30087a((OutputStream) byteArrayOutputStream, (int) this.f23364m);
        byteArrayOutputStream.write(this.f23365n);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (this.f23362k == 1) {
            byteArray = this.f23348j.encryptData(byteArray);
        }
        C7036c.m30089a(outputStream, byteArray);
    }
}
