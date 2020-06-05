package btmsdkobf;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.p605ep.common.adapt.iservice.net.ESharkCode;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.net.UnknownHostException;

/* renamed from: btmsdkobf.da */
public class C0675da {
    private static String TAG = "HttpNetwork";
    /* renamed from: gV */
    private final int f466gV = 3;
    /* renamed from: gW */
    private final int f467gW = 3;
    /* renamed from: gX */
    private String f468gX = "POST";
    /* renamed from: gY */
    private HttpURLConnection f469gY;
    /* renamed from: gZ */
    private C0695dl f470gZ;
    /* renamed from: ha */
    private C0814ep f471ha;
    /* renamed from: hb */
    private String f472hb;
    /* renamed from: hc */
    private int f473hc = 0;
    /* renamed from: hd */
    private boolean f474hd = false;

    /* renamed from: btmsdkobf.da$a */
    public interface C0676a {
        /* renamed from: a */
        void mo9260a(int i, byte[] bArr);
    }

    public C0675da(Context context, C0695dl dlVar, C0814ep epVar, boolean z) {
        this.f470gZ = dlVar;
        this.f471ha = epVar;
        this.f474hd = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0176, code lost:
            r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
            btmsdkobf.C0849fg.m913e(TAG, "doSend(), Exception: ", r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0181, code lost:
            return com.tencent.p605ep.common.adapt.iservice.net.ESharkCode.ERR_NETWORK_EXCEPTION;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0182, code lost:
            r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0183, code lost:
            btmsdkobf.C0849fg.m913e(TAG, "doSend(), IOException: ", r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x018d, code lost:
            return com.tencent.p605ep.common.adapt.iservice.net.ESharkCode.ERR_NETWORK_IOEXCEPTION;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x018e, code lost:
            r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x018f, code lost:
            btmsdkobf.C0849fg.m913e(TAG, "doSend(), SocketTimeoutException: ", r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0199, code lost:
            return com.tencent.p605ep.common.adapt.iservice.net.ESharkCode.ERR_NETWORK_SOCKETTIMEOUTEXCEPTION;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x019a, code lost:
            r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x019b, code lost:
            btmsdkobf.C0849fg.m913e(TAG, "doSend(), SecurityException: ", r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01ad, code lost:
            return btmsdkobf.C0673cz.m211a(r5.toString(), com.tencent.p605ep.common.adapt.iservice.net.ESharkCode.ERR_NETWORK_SECURITY_ELSE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x01ae, code lost:
            r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x01af, code lost:
            btmsdkobf.C0849fg.m913e(TAG, "doSend(), SocketException: ", r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01c1, code lost:
            return btmsdkobf.C0673cz.m211a(r5.toString(), com.tencent.p605ep.common.adapt.iservice.net.ESharkCode.ERR_NETWORK_SOCKET_ELSE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01c2, code lost:
            r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01c3, code lost:
            btmsdkobf.C0849fg.m913e(TAG, "doSend(), ConnectException: ", r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x01d5, code lost:
            return btmsdkobf.C0673cz.m211a(r5.toString(), com.tencent.p605ep.common.adapt.iservice.net.ESharkCode.ERR_NETWORK_CONNECT_ELSE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01d6, code lost:
            r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01d7, code lost:
            btmsdkobf.C0849fg.m913e(TAG, "doSend(), ProtocolException: ", r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01e1, code lost:
            return com.tencent.p605ep.common.adapt.iservice.net.ESharkCode.ERR_NETWORK_PROTOCOLEXCEPTION;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x01e2, code lost:
            r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01e3, code lost:
            btmsdkobf.C0849fg.m913e(TAG, "doSend(), IllegalStateException: ", r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01ed, code lost:
            return com.tencent.p605ep.common.adapt.iservice.net.ESharkCode.ERR_NETWORK_ILLEGALSTATEEXCEPTION;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01ee, code lost:
            r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01ef, code lost:
            btmsdkobf.C0849fg.m913e(TAG, "doSend(), IllegalAccessError: ", r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01f9, code lost:
            return com.tencent.p605ep.common.adapt.iservice.net.ESharkCode.ERR_NETWORK_ILLEGALACCESSERROR;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01fa, code lost:
            r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01fb, code lost:
            btmsdkobf.C0849fg.m913e(TAG, "doSend(), UnknownHostException: ", r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0205, code lost:
            return com.tencent.p605ep.common.adapt.iservice.net.ESharkCode.ERR_NETWORK_UNKNOWNHOSTEXCEPTION;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0045 */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x008e A[Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00c0 A[Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0182 A[Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }, ExcHandler: IOException (r5v20 'e' java.io.IOException A[CUSTOM_DECLARE, Catch:{  }]), Splitter:B:10:0x0032] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x018e A[Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }, ExcHandler: SocketTimeoutException (r5v18 'e' java.net.SocketTimeoutException A[CUSTOM_DECLARE, Catch:{  }]), Splitter:B:5:0x0010] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x019a A[Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }, ExcHandler: SecurityException (r5v15 'e' java.lang.SecurityException A[CUSTOM_DECLARE, Catch:{  }]), Splitter:B:5:0x0010] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01ae A[Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }, ExcHandler: SocketException (r5v12 'e' java.net.SocketException A[CUSTOM_DECLARE, Catch:{  }]), Splitter:B:5:0x0010] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01c2 A[Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }, ExcHandler: ConnectException (r5v9 'e' java.net.ConnectException A[CUSTOM_DECLARE, Catch:{  }]), Splitter:B:5:0x0010] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01d6 A[Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }, ExcHandler: ProtocolException (r5v7 'e' java.net.ProtocolException A[CUSTOM_DECLARE, Catch:{  }]), Splitter:B:5:0x0010] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01e2 A[Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }, ExcHandler: IllegalStateException (r5v5 'e' java.lang.IllegalStateException A[CUSTOM_DECLARE, Catch:{  }]), Splitter:B:5:0x0010] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01ee A[Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }, ExcHandler: IllegalAccessError (r5v3 'e' java.lang.IllegalAccessError A[CUSTOM_DECLARE, Catch:{  }]), Splitter:B:5:0x0010] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01fa A[Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }, ExcHandler: UnknownHostException (r5v1 'e' java.net.UnknownHostException A[CUSTOM_DECLARE, Catch:{  }]), Splitter:B:5:0x0010] */
    /* renamed from: a */
    private int m221a(byte[] r5, java.util.concurrent.atomic.AtomicReference<byte[]> r6) {
        /*
        r4 = this;
        java.lang.String r0 = TAG
        java.lang.String r1 = "[http_control]doSend()"
        btmsdkobf.C0849fg.m914i(r0, r1)
        java.net.HttpURLConnection r0 = r4.f469gY
        if (r0 != 0) goto L_0x000e
        r5 = -10000(0xffffffffffffd8f0, float:NaN)
        return r5
    L_0x000e:
        java.lang.String r0 = "GET"
        java.lang.String r1 = r4.f468gX     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        boolean r0 = r0.equalsIgnoreCase(r1)     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        if (r0 == 0) goto L_0x0019
        goto L_0x0032
    L_0x0019:
        java.net.HttpURLConnection r0 = r4.f469gY     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        java.lang.String r1 = "Content-length"
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        r2.<init>()     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        java.lang.String r3 = ""
        r2.append(r3)     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        int r3 = r5.length     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        r2.append(r3)     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        java.lang.String r2 = r2.toString()     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        r0.setRequestProperty(r1, r2)     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
    L_0x0032:
        java.lang.String r0 = android.os.Build.VERSION.SDK     // Catch:{ Exception -> 0x0045, UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182 }
        if (r0 == 0) goto L_0x0045
        int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0045, UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182 }
        r1 = 13
        if (r0 <= r1) goto L_0x0045
        java.net.HttpURLConnection r0 = r4.f469gY     // Catch:{ Exception -> 0x0045, UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182 }
        java.lang.String r1 = "Connection"
        java.lang.String r2 = "close"
        r0.setRequestProperty(r1, r2)     // Catch:{ Exception -> 0x0045, UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182 }
    L_0x0045:
        java.lang.String r0 = TAG     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        r1.<init>()     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        java.lang.String r2 = "[http_control]doSend(), bf [http send] bytes: "
        r1.append(r2)     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        int r2 = r5.length     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        r1.append(r2)     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        java.lang.String r1 = r1.toString()     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        btmsdkobf.C0849fg.m914i(r0, r1)     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        java.net.HttpURLConnection r0 = r4.f469gY     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        java.io.OutputStream r0 = r0.getOutputStream()     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        r0.write(r5)     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        r0.flush()     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        r0.close()     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        java.lang.String r0 = TAG     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        r1.<init>()     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        java.lang.String r2 = "[flow_control][http_control]doSend(), [http send] bytes: "
        r1.append(r2)     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        int r5 = r5.length     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        r1.append(r5)     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        java.lang.String r5 = r1.toString()     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        btmsdkobf.C0849fg.m911d(r0, r5)     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        java.net.HttpURLConnection r5 = r4.f469gY     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        int r5 = r5.getResponseCode()     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        boolean r0 = r4.m227n(r5)     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        if (r0 == 0) goto L_0x00c0
        java.lang.String r5 = r4.m225aK()     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        r4.f472hb = r5     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        int r5 = r4.f473hc     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        int r5 = r5 + 1
        r4.f473hc = r5     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        java.lang.String r5 = TAG     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        r6.<init>()     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        java.lang.String r0 = "[http_control]doSend()，需重定向, mRedirectUrl: "
        r6.append(r0)     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        java.lang.String r0 = r4.f472hb     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        r6.append(r0)     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        java.lang.String r0 = " mRedirectTimes: "
        r6.append(r0)     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        int r0 = r4.f473hc     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        r6.append(r0)     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        java.lang.String r6 = r6.toString()     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        btmsdkobf.C0849fg.m911d(r5, r6)     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        r5 = -60000(0xffffffffffff15a0, float:NaN)
        return r5
    L_0x00c0:
        r4.m224aJ()     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        java.lang.String r0 = TAG     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        r1.<init>()     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        java.lang.String r2 = "[http_control]doSend(), resposeCode: "
        r1.append(r2)     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        r1.append(r5)     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        java.lang.String r5 = r1.toString()     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        btmsdkobf.C0849fg.m914i(r0, r5)     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        java.net.HttpURLConnection r5 = r4.f469gY     // Catch:{ Exception -> 0x0165, UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182 }
        java.util.Map r5 = r5.getHeaderFields()     // Catch:{ Exception -> 0x0165, UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182 }
        java.lang.String r0 = TAG     // Catch:{ Exception -> 0x0165, UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182 }
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0165, UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182 }
        r1.<init>()     // Catch:{ Exception -> 0x0165, UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182 }
        java.lang.String r2 = "[http_control]doSend(), HeaderFields: "
        r1.append(r2)     // Catch:{ Exception -> 0x0165, UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182 }
        r1.append(r5)     // Catch:{ Exception -> 0x0165, UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182 }
        java.lang.String r5 = r1.toString()     // Catch:{ Exception -> 0x0165, UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182 }
        btmsdkobf.C0849fg.m914i(r0, r5)     // Catch:{ Exception -> 0x0165, UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182 }
        java.net.HttpURLConnection r5 = r4.f469gY     // Catch:{ Exception -> 0x0165, UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182 }
        java.lang.String r0 = "Server"
        java.lang.String r5 = r5.getHeaderField(r0)     // Catch:{ Exception -> 0x0165, UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182 }
        boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0165, UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182 }
        java.lang.String r1 = "[http_control]doSend(), getHeaderField('BACK_KEY') should be 'QBServer', actually return: "
        if (r0 == 0) goto L_0x011d
        java.lang.String r6 = TAG     // Catch:{ Exception -> 0x0165, UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182 }
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0165, UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182 }
        r0.<init>()     // Catch:{ Exception -> 0x0165, UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182 }
        r0.append(r1)     // Catch:{ Exception -> 0x0165, UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182 }
        r0.append(r5)     // Catch:{ Exception -> 0x0165, UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182 }
        java.lang.String r5 = r0.toString()     // Catch:{ Exception -> 0x0165, UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182 }
        btmsdkobf.C0849fg.m912e(r6, r5)     // Catch:{ Exception -> 0x0165, UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182 }
        r5 = -170000(0xfffffffffffd67f0, float:NaN)
        return r5
    L_0x011d:
        java.lang.String r0 = "QBServer"
        boolean r0 = r5.equals(r0)     // Catch:{ Exception -> 0x0165, UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182 }
        if (r0 != 0) goto L_0x013d
        java.lang.String r6 = TAG     // Catch:{ Exception -> 0x0165, UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182 }
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0165, UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182 }
        r0.<init>()     // Catch:{ Exception -> 0x0165, UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182 }
        r0.append(r1)     // Catch:{ Exception -> 0x0165, UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182 }
        r0.append(r5)     // Catch:{ Exception -> 0x0165, UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182 }
        java.lang.String r5 = r0.toString()     // Catch:{ Exception -> 0x0165, UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182 }
        btmsdkobf.C0849fg.m912e(r6, r5)     // Catch:{ Exception -> 0x0165, UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182 }
        r5 = -560000(0xfffffffffff77480, float:NaN)
        return r5
    L_0x013d:
        java.net.HttpURLConnection r5 = r4.f469gY     // Catch:{ Exception -> 0x0165, UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182 }
        java.io.InputStream r5 = r5.getInputStream()     // Catch:{ Exception -> 0x0165, UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182 }
        byte[] r5 = r4.m222a(r5)     // Catch:{ Exception -> 0x0165, UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182 }
        r6.set(r5)     // Catch:{ Exception -> 0x0165, UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182 }
        if (r5 == 0) goto L_0x0163
        java.lang.String r6 = TAG     // Catch:{ Exception -> 0x0165, UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182 }
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0165, UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182 }
        r0.<init>()     // Catch:{ Exception -> 0x0165, UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182 }
        java.lang.String r1 = "[flow_control][http_control]doSend(), [http receive] bytes: "
        r0.append(r1)     // Catch:{ Exception -> 0x0165, UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182 }
        int r5 = r5.length     // Catch:{ Exception -> 0x0165, UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182 }
        r0.append(r5)     // Catch:{ Exception -> 0x0165, UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182 }
        java.lang.String r5 = r0.toString()     // Catch:{ Exception -> 0x0165, UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182 }
        btmsdkobf.C0849fg.m911d(r6, r5)     // Catch:{ Exception -> 0x0165, UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182 }
    L_0x0163:
        r5 = 0
        return r5
    L_0x0165:
        r5 = move-exception
        java.lang.String r6 = TAG     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        java.lang.String r5 = r5.toString()     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        btmsdkobf.C0849fg.m912e(r6, r5)     // Catch:{ UnknownHostException -> 0x01fa, IllegalAccessError -> 0x01ee, IllegalStateException -> 0x01e2, ProtocolException -> 0x01d6, ConnectException -> 0x01c2, SocketException -> 0x01ae, SecurityException -> 0x019a, SocketTimeoutException -> 0x018e, IOException -> 0x0182, Exception -> 0x0176 }
        r5 = -40000(0xffffffffffff63c0, float:NaN)
        return r5
    L_0x0173:
        r5 = move-exception
        goto L_0x0206
    L_0x0176:
        r5 = move-exception
        java.lang.String r6 = TAG     // Catch:{ all -> 0x0173 }
        java.lang.String r0 = "doSend(), Exception: "
        btmsdkobf.C0849fg.m913e(r6, r0, r5)     // Catch:{ all -> 0x0173 }
        r5 = -150000(0xfffffffffffdb610, float:NaN)
        return r5
    L_0x0182:
        r5 = move-exception
        java.lang.String r6 = TAG     // Catch:{ all -> 0x0173 }
        java.lang.String r0 = "doSend(), IOException: "
        btmsdkobf.C0849fg.m913e(r6, r0, r5)     // Catch:{ all -> 0x0173 }
        r5 = -140000(0xfffffffffffddd20, float:NaN)
        return r5
    L_0x018e:
        r5 = move-exception
        java.lang.String r6 = TAG     // Catch:{ all -> 0x0173 }
        java.lang.String r0 = "doSend(), SocketTimeoutException: "
        btmsdkobf.C0849fg.m913e(r6, r0, r5)     // Catch:{ all -> 0x0173 }
        r5 = -130000(0xfffffffffffe0430, float:NaN)
        return r5
    L_0x019a:
        r5 = move-exception
        java.lang.String r6 = TAG     // Catch:{ all -> 0x0173 }
        java.lang.String r0 = "doSend(), SecurityException: "
        btmsdkobf.C0849fg.m913e(r6, r0, r5)     // Catch:{ all -> 0x0173 }
        java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0173 }
        r6 = -440000(0xfffffffffff94940, float:NaN)
        int r5 = btmsdkobf.C0673cz.m211a(r5, r6)     // Catch:{ all -> 0x0173 }
        return r5
    L_0x01ae:
        r5 = move-exception
        java.lang.String r6 = TAG     // Catch:{ all -> 0x0173 }
        java.lang.String r0 = "doSend(), SocketException: "
        btmsdkobf.C0849fg.m913e(r6, r0, r5)     // Catch:{ all -> 0x0173 }
        java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0173 }
        r6 = -420000(0xfffffffffff99760, float:NaN)
        int r5 = btmsdkobf.C0673cz.m211a(r5, r6)     // Catch:{ all -> 0x0173 }
        return r5
    L_0x01c2:
        r5 = move-exception
        java.lang.String r6 = TAG     // Catch:{ all -> 0x0173 }
        java.lang.String r0 = "doSend(), ConnectException: "
        btmsdkobf.C0849fg.m913e(r6, r0, r5)     // Catch:{ all -> 0x0173 }
        java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0173 }
        r6 = -500000(0xfffffffffff85ee0, float:NaN)
        int r5 = btmsdkobf.C0673cz.m211a(r5, r6)     // Catch:{ all -> 0x0173 }
        return r5
    L_0x01d6:
        r5 = move-exception
        java.lang.String r6 = TAG     // Catch:{ all -> 0x0173 }
        java.lang.String r0 = "doSend(), ProtocolException: "
        btmsdkobf.C0849fg.m913e(r6, r0, r5)     // Catch:{ all -> 0x0173 }
        r5 = -100000(0xfffffffffffe7960, float:NaN)
        return r5
    L_0x01e2:
        r5 = move-exception
        java.lang.String r6 = TAG     // Catch:{ all -> 0x0173 }
        java.lang.String r0 = "doSend(), IllegalStateException: "
        btmsdkobf.C0849fg.m913e(r6, r0, r5)     // Catch:{ all -> 0x0173 }
        r5 = -90000(0xfffffffffffea070, float:NaN)
        return r5
    L_0x01ee:
        r5 = move-exception
        java.lang.String r6 = TAG     // Catch:{ all -> 0x0173 }
        java.lang.String r0 = "doSend(), IllegalAccessError: "
        btmsdkobf.C0849fg.m913e(r6, r0, r5)     // Catch:{ all -> 0x0173 }
        r5 = -80000(0xfffffffffffec780, float:NaN)
        return r5
    L_0x01fa:
        r5 = move-exception
        java.lang.String r6 = TAG     // Catch:{ all -> 0x0173 }
        java.lang.String r0 = "doSend(), UnknownHostException: "
        btmsdkobf.C0849fg.m913e(r6, r0, r5)     // Catch:{ all -> 0x0173 }
        r5 = -70000(0xfffffffffffeee90, float:NaN)
        return r5
    L_0x0206:
        throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: btmsdkobf.C0675da.m221a(byte[], java.util.concurrent.atomic.AtomicReference):int");
    }

    /* renamed from: a */
    private byte[] m222a(InputStream inputStream) {
        byte[] bArr = new byte[2048];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (IOException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("-56get Bytes from inputStream when read buffer: ");
                sb.append(e.getMessage());
                throw new Exception(sb.toString());
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e2) {
                    C0849fg.m912e(TAG, e2.toString());
                }
                throw th;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e3) {
            C0849fg.m912e(TAG, e3.toString());
        }
        return byteArray;
    }

    /* renamed from: aI */
    private boolean m223aI() {
        C0849fg.m914i(TAG, "[http_control]stop()");
        HttpURLConnection httpURLConnection = this.f469gY;
        if (httpURLConnection == null) {
            return false;
        }
        try {
            httpURLConnection.disconnect();
            this.f469gY = null;
        } catch (Throwable unused) {
        }
        return true;
    }

    /* renamed from: aJ */
    private void m224aJ() {
        this.f472hb = null;
        this.f473hc = 0;
    }

    /* renamed from: aK */
    private String m225aK() {
        C0849fg.m911d(TAG, "[http_control]getRedirectUrl()");
        try {
            return this.f469gY.getHeaderField("Location");
        } catch (Exception e) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("getRedirectUrl() e: ");
            sb.append(e.toString());
            C0849fg.m912e(str, sb.toString());
            return null;
        }
    }

    /* renamed from: l */
    private int m226l(String str) {
        String str2 = "GET";
        String str3 = "no-cache";
        C0849fg.m914i(TAG, "[http_control]start()");
        if (this.f473hc >= 3) {
            m224aJ();
        }
        if (!TextUtils.isEmpty(this.f472hb)) {
            str = this.f472hb;
        }
        try {
            URL url = new URL(str);
            int i = 0;
            try {
                C0651ck j = C0871h.m967j();
                if (C0651ck.f409fU == j) {
                    C0849fg.m916w(TAG, "[http_control]start() no network");
                    return ESharkCode.ERR_NETWORK_NO_CONNECT;
                }
                if (C0651ck.f412fX == j) {
                    this.f469gY = (HttpURLConnection) url.openConnection(new Proxy(Type.HTTP, InetSocketAddress.createUnresolved(C0871h.m968k(), C0871h.m969l())));
                } else {
                    this.f469gY = (HttpURLConnection) url.openConnection();
                    this.f469gY.setReadTimeout(15000);
                    this.f469gY.setConnectTimeout(15000);
                }
                if (C0875j.m991v() < 8) {
                    System.setProperty("http.keepAlive", "false");
                }
                this.f469gY.setUseCaches(false);
                this.f469gY.setRequestProperty("Pragma", str3);
                this.f469gY.setRequestProperty("Cache-Control", str3);
                this.f469gY.setInstanceFollowRedirects(false);
                if (str2.equalsIgnoreCase(this.f468gX)) {
                    this.f469gY.setRequestMethod(str2);
                } else {
                    this.f469gY.setRequestMethod("POST");
                    this.f469gY.setDoOutput(true);
                    this.f469gY.setDoInput(true);
                    this.f469gY.setRequestProperty("Accept", "*/*");
                    this.f469gY.setRequestProperty("Accept-Charset", "utf-8");
                    this.f469gY.setRequestProperty("Content-Type", "application/octet-stream");
                }
                return i;
            } catch (UnknownHostException e) {
                e.printStackTrace();
                i = ESharkCode.ERR_NETWORK_UNKNOWNHOSTEXCEPTION_2;
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
                i = ESharkCode.ERR_NETWORK_ILLEGAL_ARGUMENT;
            } catch (SecurityException e3) {
                e3.printStackTrace();
                i = ESharkCode.ERR_NETWORK_SECURITY_ELSE;
            } catch (IOException e4) {
                e4.printStackTrace();
                i = ESharkCode.ERR_NETWORK_IOEXCEPTION;
            }
        } catch (MalformedURLException e5) {
            e5.printStackTrace();
            String str4 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("[http_control]start() MalformedURLException e:");
            sb.append(e5.toString());
            C0849fg.m912e(str4, sb.toString());
            return ESharkCode.ERR_NETWORK_MALFORMEDURLEXCEPTION;
        }
    }

    /* renamed from: n */
    private boolean m227n(int i) {
        return i >= 301 && i <= 305;
    }

    /* access modifiers changed from: declared_synchronized */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004a, code lost:
            return r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00fe, code lost:
            r12 = TAG;
            r13 = new java.lang.StringBuilder();
            r13.append("[http_control]sendData() 发包成功或无网络，不重试， ret: ");
            r13.append(r5);
            r13 = r13.toString();
     */
    /* renamed from: a */
    public synchronized int mo9259a(btmsdkobf.C0718dy.C0738f r12, byte[] r13, java.util.concurrent.atomic.AtomicReference<byte[]> r14) {
        /*
        r11 = this;
        monitor-enter(r11)
        if (r13 == 0) goto L_0x012d
        if (r12 != 0) goto L_0x0007
        goto L_0x012d
    L_0x0007:
        java.lang.String r0 = TAG     // Catch:{ all -> 0x012a }
        java.lang.String r1 = "[http_control]sendData()"
        btmsdkobf.C0849fg.m914i(r0, r1)     // Catch:{ all -> 0x012a }
        int r0 = r12.f637jB     // Catch:{ all -> 0x012a }
        r1 = 2048(0x800, float:2.87E-42)
        r2 = 0
        r3 = 1
        if (r0 != r1) goto L_0x001c
        boolean r0 = r11.f474hd     // Catch:{ all -> 0x012a }
        if (r0 != 0) goto L_0x001c
        r0 = 1
        goto L_0x001d
    L_0x001c:
        r0 = 0
    L_0x001d:
        r1 = 3
        if (r0 == 0) goto L_0x0021
        r1 = 1
    L_0x0021:
        r4 = -1
        r4 = 0
        r5 = -1
    L_0x0024:
        if (r4 >= r1) goto L_0x0112
        btmsdkobf.ck r5 = btmsdkobf.C0871h.m967j()     // Catch:{ all -> 0x012a }
        btmsdkobf.ck r6 = btmsdkobf.C0651ck.f409fU     // Catch:{ all -> 0x012a }
        r7 = -220000(0xfffffffffffca4a0, float:NaN)
        if (r6 != r5) goto L_0x003a
        java.lang.String r12 = TAG     // Catch:{ all -> 0x012a }
        java.lang.String r13 = "[http_control]sendData() no network"
        btmsdkobf.C0849fg.m916w(r12, r13)     // Catch:{ all -> 0x012a }
        monitor-exit(r11)
        return r7
    L_0x003a:
        boolean r5 = r12.mo9364bJ()     // Catch:{ all -> 0x012a }
        if (r5 == 0) goto L_0x004b
        java.lang.String r12 = TAG     // Catch:{ all -> 0x012a }
        java.lang.String r13 = "[http_control][time_out]sendData(), send time out"
        btmsdkobf.C0849fg.m911d(r12, r13)     // Catch:{ all -> 0x012a }
        r12 = -17
    L_0x0049:
        monitor-exit(r11)
        return r12
    L_0x004b:
        if (r0 == 0) goto L_0x007a
        btmsdkobf.dl r5 = r11.f470gZ     // Catch:{ all -> 0x012a }
        java.lang.String r5 = btmsdkobf.C0689dg.m295a(r5)     // Catch:{ all -> 0x012a }
        if (r5 == 0) goto L_0x0080
        int r6 = r5.length()     // Catch:{ all -> 0x012a }
        r8 = 7
        if (r6 < r8) goto L_0x0068
        java.lang.String r6 = r5.substring(r2, r8)     // Catch:{ all -> 0x012a }
        java.lang.String r8 = "http://"
        boolean r6 = r6.equalsIgnoreCase(r8)     // Catch:{ all -> 0x012a }
        if (r6 != 0) goto L_0x0080
    L_0x0068:
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x012a }
        r6.<init>()     // Catch:{ all -> 0x012a }
        java.lang.String r8 = "http://"
        r6.append(r8)     // Catch:{ all -> 0x012a }
        r6.append(r5)     // Catch:{ all -> 0x012a }
        java.lang.String r5 = r6.toString()     // Catch:{ all -> 0x012a }
        goto L_0x0080
    L_0x007a:
        btmsdkobf.ep r5 = r11.f471ha     // Catch:{ all -> 0x012a }
        java.lang.String r5 = r5.mo9282aZ()     // Catch:{ all -> 0x012a }
    L_0x0080:
        int r6 = r11.m226l(r5)     // Catch:{ all -> 0x012a }
        java.lang.String r8 = TAG     // Catch:{ all -> 0x012a }
        java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x012a }
        r9.<init>()     // Catch:{ all -> 0x012a }
        java.lang.String r10 = "[http_control]start(), ret: "
        r9.append(r10)     // Catch:{ all -> 0x012a }
        r9.append(r6)     // Catch:{ all -> 0x012a }
        java.lang.String r10 = " httpUrl: "
        r9.append(r10)     // Catch:{ all -> 0x012a }
        r9.append(r5)     // Catch:{ all -> 0x012a }
        java.lang.String r5 = r9.toString()     // Catch:{ all -> 0x012a }
        btmsdkobf.C0849fg.m914i(r8, r5)     // Catch:{ all -> 0x012a }
        if (r6 != 0) goto L_0x00ab
        r12.f652jQ = r3     // Catch:{ all -> 0x012a }
        int r5 = r11.m221a(r13, r14)     // Catch:{ all -> 0x012a }
        goto L_0x00ac
    L_0x00ab:
        r5 = r6
    L_0x00ac:
        r11.m223aI()     // Catch:{ all -> 0x012a }
        if (r5 == 0) goto L_0x00fe
        if (r5 != r7) goto L_0x00b4
        goto L_0x00fe
    L_0x00b4:
        r6 = -60000(0xffffffffffff15a0, float:NaN)
        if (r5 == r6) goto L_0x00cc
        java.lang.String r7 = "http send"
        boolean r7 = btmsdkobf.C0716dx.m438r(r7)     // Catch:{ all -> 0x012a }
        if (r7 == 0) goto L_0x00cc
        r5 = -160000(0xfffffffffffd8f00, float:NaN)
        java.lang.String r12 = TAG     // Catch:{ all -> 0x012a }
        java.lang.String r13 = "[http_control]sendData() 需要wifi认证，不重试"
    L_0x00c8:
        btmsdkobf.C0849fg.m914i(r12, r13)     // Catch:{ all -> 0x012a }
        goto L_0x0112
    L_0x00cc:
        if (r0 != 0) goto L_0x00d5
        if (r5 == r6) goto L_0x00d5
        btmsdkobf.ep r6 = r11.f471ha     // Catch:{ all -> 0x012a }
        r6.mo9285n(r2)     // Catch:{ all -> 0x012a }
    L_0x00d5:
        int r6 = r1 + -1
        if (r4 >= r6) goto L_0x00fa
        r6 = 300(0x12c, double:1.48E-321)
        java.lang.Thread.sleep(r6)     // Catch:{ InterruptedException -> 0x00df }
        goto L_0x00fa
    L_0x00df:
        r6 = move-exception
        java.lang.String r7 = TAG     // Catch:{ all -> 0x012a }
        java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x012a }
        r8.<init>()     // Catch:{ all -> 0x012a }
        java.lang.String r9 = "[http_control]sendData() InterruptedException e: "
        r8.append(r9)     // Catch:{ all -> 0x012a }
        java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x012a }
        r8.append(r6)     // Catch:{ all -> 0x012a }
        java.lang.String r6 = r8.toString()     // Catch:{ all -> 0x012a }
        btmsdkobf.C0849fg.m912e(r7, r6)     // Catch:{ all -> 0x012a }
    L_0x00fa:
        int r4 = r4 + 1
        goto L_0x0024
    L_0x00fe:
        java.lang.String r12 = TAG     // Catch:{ all -> 0x012a }
        java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x012a }
        r13.<init>()     // Catch:{ all -> 0x012a }
        java.lang.String r14 = "[http_control]sendData() 发包成功或无网络，不重试， ret: "
        r13.append(r14)     // Catch:{ all -> 0x012a }
        r13.append(r5)     // Catch:{ all -> 0x012a }
        java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x012a }
        goto L_0x00c8
    L_0x0112:
        java.lang.String r12 = TAG     // Catch:{ all -> 0x012a }
        java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x012a }
        r13.<init>()     // Catch:{ all -> 0x012a }
        java.lang.String r14 = "[http_control]sendData() ret: "
        r13.append(r14)     // Catch:{ all -> 0x012a }
        r13.append(r5)     // Catch:{ all -> 0x012a }
        java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x012a }
        btmsdkobf.C0849fg.m911d(r12, r13)     // Catch:{ all -> 0x012a }
        monitor-exit(r11)
        return r5
    L_0x012a:
        r12 = move-exception
        monitor-exit(r11)
        throw r12
    L_0x012d:
        r12 = -10
        goto L_0x0049
        */
        throw new UnsupportedOperationException("Method not decompiled: btmsdkobf.C0675da.mo9259a(btmsdkobf.dy$f, byte[], java.util.concurrent.atomic.AtomicReference):int");
    }
}
