package com.tencent.android.tpush.service.channel.p592b;

import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.service.channel.exception.IORefusedException;
import com.tencent.android.tpush.service.channel.exception.InnerException;
import com.tencent.android.tpush.service.channel.exception.UnexpectedDataException;
import com.tencent.android.tpush.service.channel.p593c.C7036c;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.service.channel.b.b */
public class C7022b extends C7026f implements C7025e {
    /* renamed from: a */
    protected HashMap<String, Object> f23339a = new HashMap<>(4);
    /* renamed from: b */
    protected int f23340b = 0;
    /* renamed from: c */
    protected int f23341c = -1;
    /* renamed from: d */
    public ArrayList<C7025e> f23342d = new ArrayList<>(1);
    /* renamed from: e */
    protected String f23343e = null;
    /* renamed from: f */
    protected String f23344f = null;
    /* renamed from: g */
    protected final HashMap<String, String> f23345g = new HashMap<>(8);

    public C7022b(String str, String str2) {
        this.f23343e = str;
        this.f23344f = str2;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo33417a(int i) {
        if (this.f23341c != i) {
            this.f23340b = 0;
        }
        this.f23341c = i;
    }

    /* renamed from: a */
    public int mo33416a(OutputStream outputStream) {
        int i;
        mo33425c();
        int i2 = 0;
        try {
            this.f23340b = 0;
            while (!mo33424b()) {
                int i3 = this.f23340b;
                this.f23340b = i3 + 1;
                if (i3 <= 2) {
                    int i4 = this.f23341c;
                    if (i4 == -1) {
                        i2 += mo33420b(outputStream);
                    } else if (i4 == 0) {
                        mo33426d();
                    } else {
                        throw new InnerException("illegal step value!");
                    }
                } else {
                    throw new InnerException("the duration of the current step is too long!");
                }
            }
        } catch (IORefusedException e) {
            C6864a.m29302d("Channel.HttpSendPacket", "write >>> IORefusedException thrown", e);
        }
        return i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo33420b(OutputStream outputStream) {
        String str;
        String str2 = "httpData";
        byte[] bArr = (byte[]) this.f23339a.get(str2);
        String str3 = "httpDataLeftLength";
        if (bArr == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                mo33421c(byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                mo33419a("Content-Length", String.valueOf(byteArray.length));
                StringBuilder sb = new StringBuilder();
                sb.append("POST ");
                sb.append(this.f23344f);
                sb.append(" HTTP/1.1\r\n");
                String sb2 = sb.toString();
                Iterator it = this.f23345g.entrySet().iterator();
                while (true) {
                    str = "\r\n";
                    if (!it.hasNext()) {
                        break;
                    }
                    Entry entry = (Entry) it.next();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(sb2);
                    sb3.append((String) entry.getKey());
                    sb3.append(": ");
                    sb3.append((String) entry.getValue());
                    sb3.append(str);
                    sb2 = sb3.toString();
                }
                StringBuilder sb4 = new StringBuilder();
                sb4.append(sb2);
                sb4.append(str);
                byte[] bytes = sb4.toString().getBytes("UTF-8");
                byte[] bArr2 = new byte[(bytes.length + byteArray.length)];
                System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
                System.arraycopy(byteArray, 0, bArr2, bytes.length, byteArray.length);
                this.f23339a.put(str2, bArr2);
                this.f23339a.put(str3, Integer.valueOf(bArr2.length));
                bArr = bArr2;
            } catch (IOException e) {
                throw new UnexpectedDataException("http content can not be write correctly!", e);
            }
        }
        int intValue = ((Integer) this.f23339a.get(str3)).intValue();
        if (intValue == 0) {
            mo33417a(0);
            return 0;
        }
        int a = C7036c.m30089a(outputStream, bArr);
        this.f23339a.put(str3, Integer.valueOf(intValue - a));
        return a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo33421c(OutputStream outputStream) {
        Iterator it = this.f23342d.iterator();
        while (it.hasNext()) {
            C7025e eVar = (C7025e) it.next();
            eVar.mo33423a(this.f23348j);
            eVar.mo33416a(outputStream);
        }
    }

    /* renamed from: a */
    public void mo33419a(String str, String str2) {
        this.f23345g.put(str, str2);
    }

    /* renamed from: a */
    public void mo33418a(C7025e eVar) {
        this.f23342d.add(eVar);
    }
}
