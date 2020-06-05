package com.bytedance.sdk.p145a.p147b.p148a.p151c;

import com.bytedance.sdk.p145a.p147b.Protocol;
import com.bytedance.sdk.p145a.p147b.Response;
import java.io.IOException;
import java.net.ProtocolException;

/* renamed from: com.bytedance.sdk.a.b.a.c.k */
public final class StatusLine {
    /* renamed from: a */
    public final Protocol f5445a;
    /* renamed from: b */
    public final int f5446b;
    /* renamed from: c */
    public final String f5447c;

    public StatusLine(Protocol wVar, int i, String str) {
        this.f5445a = wVar;
        this.f5446b = i;
        this.f5447c = str;
    }

    /* renamed from: a */
    public static StatusLine m7028a(Response bVar) {
        return new StatusLine(bVar.mo13940b(), bVar.mo13941c(), bVar.mo13943d());
    }

    /* renamed from: a */
    public static StatusLine m7029a(String str) throws IOException {
        Protocol wVar;
        String str2;
        int i = 9;
        String str3 = "Unexpected status line: ";
        if (str.startsWith("HTTP/1.")) {
            if (str.length() < 9 || str.charAt(8) != ' ') {
                StringBuilder sb = new StringBuilder();
                sb.append(str3);
                sb.append(str);
                throw new ProtocolException(sb.toString());
            }
            int charAt = str.charAt(7) - '0';
            if (charAt == 0) {
                wVar = Protocol.HTTP_1_0;
            } else if (charAt == 1) {
                wVar = Protocol.HTTP_1_1;
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str3);
                sb2.append(str);
                throw new ProtocolException(sb2.toString());
            }
        } else if (str.startsWith("ICY ")) {
            wVar = Protocol.HTTP_1_0;
            i = 4;
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str3);
            sb3.append(str);
            throw new ProtocolException(sb3.toString());
        }
        int i2 = i + 3;
        if (str.length() >= i2) {
            try {
                int parseInt = Integer.parseInt(str.substring(i, i2));
                if (str.length() <= i2) {
                    str2 = "";
                } else if (str.charAt(i2) == ' ') {
                    str2 = str.substring(i + 4);
                } else {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(str3);
                    sb4.append(str);
                    throw new ProtocolException(sb4.toString());
                }
                return new StatusLine(wVar, parseInt, str2);
            } catch (NumberFormatException unused) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str3);
                sb5.append(str);
                throw new ProtocolException(sb5.toString());
            }
        } else {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(str3);
            sb6.append(str);
            throw new ProtocolException(sb6.toString());
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f5445a == Protocol.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.f5446b);
        if (this.f5447c != null) {
            sb.append(' ');
            sb.append(this.f5447c);
        }
        return sb.toString();
    }
}
