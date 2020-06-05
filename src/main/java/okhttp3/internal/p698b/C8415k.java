package okhttp3.internal.p698b;

import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.Protocol;

/* compiled from: StatusLine */
/* renamed from: okhttp3.internal.b.k */
public final class C8415k {
    /* renamed from: a */
    public final Protocol f28525a;
    /* renamed from: b */
    public final int f28526b;
    /* renamed from: c */
    public final String f28527c;

    public C8415k(Protocol protocol, int i, String str) {
        this.f28525a = protocol;
        this.f28526b = i;
        this.f28527c = str;
    }

    /* renamed from: a */
    public static C8415k m36021a(String str) throws IOException {
        Protocol protocol;
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
                protocol = Protocol.HTTP_1_0;
            } else if (charAt == 1) {
                protocol = Protocol.HTTP_1_1;
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str3);
                sb2.append(str);
                throw new ProtocolException(sb2.toString());
            }
        } else if (str.startsWith("ICY ")) {
            protocol = Protocol.HTTP_1_0;
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
                return new C8415k(protocol, parseInt, str2);
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
        sb.append(this.f28525a == Protocol.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.f28526b);
        if (this.f28527c != null) {
            sb.append(' ');
            sb.append(this.f28527c);
        }
        return sb.toString();
    }
}
