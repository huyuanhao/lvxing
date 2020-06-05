package com.tencent.android.tpush.service.channel.p592b;

import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.service.channel.exception.IORefusedException;
import com.tencent.android.tpush.service.channel.exception.InnerException;
import com.tencent.android.tpush.service.channel.exception.UnexpectedDataException;
import com.tencent.android.tpush.service.channel.p593c.C7036c;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.service.channel.b.g */
public class C7027g extends C7029i implements C7024d {
    /* renamed from: a */
    protected HashMap<String, Object> f23349a = new HashMap<>(4);
    /* renamed from: b */
    protected int f23350b = 0;
    /* renamed from: c */
    protected int f23351c = -1;

    /* renamed from: d */
    public synchronized void mo33426d() {
        super.mo33426d();
        this.f23349a.clear();
    }

    /* renamed from: a */
    public int mo33411a(InputStream inputStream) {
        int i;
        int i2;
        mo33425c();
        int i3 = 0;
        if (inputStream.available() == 0) {
            return 0;
        }
        try {
            this.f23350b = 0;
            while (!mo33424b()) {
                int i4 = this.f23350b;
                this.f23350b = i4 + 1;
                if (i4 <= 2) {
                    switch (this.f23351c) {
                        case -7:
                            i2 = mo33434h(inputStream);
                            break;
                        case -6:
                            i2 = mo33433g(inputStream);
                            break;
                        case -5:
                            i2 = mo33432f(inputStream);
                            break;
                        case -4:
                            i2 = mo33431e(inputStream);
                            break;
                        case -3:
                            i2 = mo33430d(inputStream);
                            break;
                        case -2:
                            i2 = mo33429c(inputStream);
                            break;
                        case -1:
                            i2 = mo33428b(inputStream);
                            break;
                        case 0:
                            mo33426d();
                            break;
                        default:
                            throw new InnerException("illegal step value!");
                    }
                    i3 += i2;
                    if (this.f23351c != 0 && inputStream.available() == 0) {
                        return i3;
                    }
                } else {
                    throw new InnerException("the duration of the current step is too long!");
                }
            }
        } catch (IORefusedException e) {
            C6864a.m29302d("Channel.RecvPacket", "read >>> IORefusedException thrown", e);
        }
        return i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo33427a(int i) {
        if (this.f23351c != i) {
            this.f23350b = 0;
        }
        this.f23351c = i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo33428b(InputStream inputStream) {
        this.f23356d = C7036c.m30090a(inputStream);
        if (this.f23356d == 80) {
            mo33427a(-2);
            return 1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("soh: ");
        sb.append(this.f23356d);
        sb.append(" != TPNS_SOH");
        throw new UnexpectedDataException(sb.toString());
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public int mo33429c(InputStream inputStream) {
        this.f23362k = C7036c.m30090a(inputStream);
        short s = this.f23362k;
        if (s == 1 || s == 10) {
            mo33427a(-3);
        } else if (s == 20) {
            mo33427a(0);
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
    public int mo33430d(InputStream inputStream) {
        this.f23357e = C7036c.m30094c(inputStream);
        mo33427a(-4);
        return 4;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public int mo33431e(InputStream inputStream) {
        this.f23358f = C7036c.m30093b(inputStream);
        this.f23358f -= 10;
        if (this.f23358f > 10485760 || this.f23358f < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("packetLength: ");
            sb.append(this.f23358f);
            throw new UnexpectedDataException(sb.toString());
        }
        if (this.f23362k == 1) {
            mo33427a(-5);
        } else {
            mo33427a(-7);
        }
        return 4;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public int mo33432f(InputStream inputStream) {
        this.f23358f--;
        this.f23361i = C7036c.m30090a(inputStream);
        if (this.f23361i == 0) {
            mo33427a(-6);
            return 1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("negotiateSecurity: ");
        sb.append(this.f23361i);
        sb.append(" != 0");
        throw new UnexpectedDataException(sb.toString());
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public int mo33433g(InputStream inputStream) {
        this.f23358f -= 4;
        this.f23359g = C7036c.m30093b(inputStream);
        if (this.f23359g == this.f23348j.getRandom()) {
            mo33427a(-7);
            return 4;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("unexpected random: ");
        sb.append(this.f23359g);
        throw new UnexpectedDataException(sb.toString());
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public int mo33434h(InputStream inputStream) {
        String str = "contentData";
        byte[] bArr = (byte[]) this.f23349a.get(str);
        String str2 = "contentDataLeftLength";
        if (bArr == null) {
            if (this.f23358f >= 0) {
                bArr = new byte[((int) this.f23358f)];
                this.f23349a.put(str, bArr);
                this.f23349a.put(str2, Integer.valueOf(bArr.length));
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("unexpected packetLength: ");
                sb.append(this.f23358f);
                sb.append(" < 0");
                throw new UnexpectedDataException(sb.toString());
            }
        }
        int intValue = ((Integer) this.f23349a.get(str2)).intValue();
        int a = C7036c.m30086a(inputStream, bArr, bArr.length - intValue);
        int i = intValue - a;
        this.f23349a.put(str2, Integer.valueOf(i));
        if (i == 0) {
            if (this.f23362k == 1) {
                bArr = this.f23348j.decryptData(bArr);
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                long b = C7036c.m30093b(byteArrayInputStream);
                if (this.f23362k == 1) {
                    this.f23348j.checkRemoteInc(b);
                }
                this.f23363l = C7036c.m30090a(byteArrayInputStream);
                this.f23360h = C7036c.m30090a(byteArrayInputStream);
                this.f23364m = C7036c.m30090a(byteArrayInputStream);
                if (byteArrayInputStream.available() > 0) {
                    this.f23365n = new byte[byteArrayInputStream.available()];
                    C7036c.m30086a(byteArrayInputStream, this.f23365n, 0);
                }
                mo33427a(0);
            } catch (IOException e) {
                throw new UnexpectedDataException("contentData can not be read correctly!", e);
            }
        }
        return a;
    }
}
