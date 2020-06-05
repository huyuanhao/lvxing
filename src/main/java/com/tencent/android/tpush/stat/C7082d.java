package com.tencent.android.tpush.stat;

import android.content.Context;
import com.p522qq.p523e.comm.constants.Constants.KEYS;
import com.tencent.android.tpush.stat.event.C7100b;
import com.tencent.android.tpush.stat.p596a.C7065b;
import com.tencent.android.tpush.stat.p596a.C7066c;
import com.tencent.android.tpush.stat.p596a.C7067d;
import com.tencent.mid.sotrage.StorageInterface;
import com.tencent.qqpim.discovery.internal.protocol.C7516p;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.stat.d */
public class C7082d {
    /* renamed from: c */
    private static C7067d f23546c = C7066c.m30259b();
    /* renamed from: d */
    private static volatile C7082d f23547d = null;
    /* renamed from: e */
    private static Context f23548e = null;
    /* renamed from: a */
    DefaultHttpClient f23549a = null;
    /* renamed from: b */
    StringBuilder f23550b = new StringBuilder(4096);
    /* renamed from: f */
    private long f23551f = 0;

    private C7082d(Context context) {
        try {
            f23548e = context.getApplicationContext();
            this.f23551f = System.currentTimeMillis() / 1000;
            BasicHttpParams basicHttpParams = new BasicHttpParams();
            HttpConnectionParams.setStaleCheckingEnabled(basicHttpParams, false);
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, C7516p.f25219Cf);
            HttpConnectionParams.setSoTimeout(basicHttpParams, C7516p.f25219Cf);
            this.f23549a = new DefaultHttpClient(basicHttpParams);
            this.f23549a.setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy() {
                public long getKeepAliveDuration(HttpResponse httpResponse, HttpContext httpContext) {
                    long keepAliveDuration = C7082d.super.getKeepAliveDuration(httpResponse, httpContext);
                    if (keepAliveDuration == -1) {
                        return 30000;
                    }
                    return keepAliveDuration;
                }
            });
        } catch (Throwable th) {
            f23546c.mo34170b(th);
        }
    }

    /* renamed from: a */
    static void m30378a(Context context) {
        f23548e = context.getApplicationContext();
    }

    /* renamed from: a */
    static Context m30377a() {
        return f23548e;
    }

    /* renamed from: b */
    public static C7082d m30380b(Context context) {
        if (f23547d == null) {
            synchronized (C7082d.class) {
                if (f23547d == null) {
                    f23547d = new C7082d(context);
                }
            }
        }
        return f23547d;
    }

    /* renamed from: a */
    private void m30379a(JSONObject jSONObject) {
        String str = "ncts";
        String str2 = "cfg";
        try {
            if (!jSONObject.isNull(str2)) {
                C7070b.m30298a(f23548e, jSONObject.getJSONObject(str2));
            }
            if (!jSONObject.isNull(str)) {
                int i = jSONObject.getInt(str);
                int currentTimeMillis = (int) (((long) i) - (System.currentTimeMillis() / 1000));
                if (C7070b.m30304b()) {
                    C7067d dVar = f23546c;
                    StringBuilder sb = new StringBuilder();
                    sb.append("server time:");
                    sb.append(i);
                    sb.append(", diff time:");
                    sb.append(currentTimeMillis);
                    dVar.mo34169b((Object) sb.toString());
                }
                C7066c.m30267e(f23548e);
                C7066c.m30257a(f23548e, currentTimeMillis);
            }
        } catch (Throwable th) {
            f23546c.mo34172d(th);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo34217a(List<?> list, C7081c cVar) {
        Throwable th;
        String str;
        List<?> list2 = list;
        String str2 = "gzip";
        String str3 = "rc4";
        String str4 = "[";
        String str5 = "UTF-8";
        String str6 = "Content-Encoding";
        if (list2 != null && !list.isEmpty()) {
            int size = list.size();
            try {
                this.f23550b.delete(0, this.f23550b.length());
                this.f23550b.append(str4);
                int i = 0;
                while (true) {
                    str = StorageInterface.KEY_SPLITER;
                    if (i >= size) {
                        break;
                    }
                    this.f23550b.append(list2.get(i).toString());
                    if (i != size - 1) {
                        this.f23550b.append(str);
                    }
                    i++;
                }
                this.f23550b.append("]");
                String sb = this.f23550b.toString();
                int length = sb.length();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(C7070b.m30306d());
                sb2.append("/?index=");
                sb2.append(this.f23551f);
                String sb3 = sb2.toString();
                this.f23551f++;
                if (C7070b.m30304b()) {
                    C7067d dVar = f23546c;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(str4);
                    sb4.append(sb3);
                    sb4.append("]Send request(eventsize:");
                    sb4.append(size);
                    sb4.append(str);
                    sb4.append(length);
                    sb4.append("bytes), content:");
                    sb4.append(sb);
                    dVar.mo34169b((Object) sb4.toString());
                }
                HttpPost httpPost = new HttpPost(sb3);
                httpPost.addHeader("Accept-Encoding", str2);
                httpPost.setHeader("Connection", "Keep-Alive");
                httpPost.removeHeaders("Cache-Control");
                HttpHost b = C7066c.m30261b(f23548e);
                httpPost.addHeader(str6, str3);
                String str7 = "http.route.default-proxy";
                String str8 = "X-Content-Encoding";
                if (b == null) {
                    this.f23549a.getParams().removeParameter(str7);
                } else {
                    if (C7070b.m30304b()) {
                        C7067d dVar2 = f23546c;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("proxy:");
                        sb5.append(b.toHostString());
                        dVar2.mo34176h(sb5.toString());
                    }
                    httpPost.addHeader(str8, str3);
                    this.f23549a.getParams().setParameter(str7, b);
                    httpPost.addHeader("X-Online-Host", C7070b.f23503d);
                    httpPost.addHeader("Accept", "*/*");
                    httpPost.addHeader("Content-Type", "json");
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
                byte[] bytes = sb.getBytes(str5);
                int length2 = bytes.length;
                if (length > 512) {
                    httpPost.removeHeaders(str6);
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(str3);
                    sb6.append(",gzip");
                    String sb7 = sb6.toString();
                    httpPost.addHeader(str6, sb7);
                    if (b != null) {
                        httpPost.removeHeaders(str8);
                        httpPost.addHeader(str8, sb7);
                    }
                    byteArrayOutputStream.write(new byte[4]);
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    gZIPOutputStream.write(bytes);
                    gZIPOutputStream.close();
                    bytes = byteArrayOutputStream.toByteArray();
                    ByteBuffer.wrap(bytes, 0, 4).putInt(length2);
                    if (C7070b.m30304b()) {
                        C7067d dVar3 = f23546c;
                        StringBuilder sb8 = new StringBuilder();
                        sb8.append("before Gzip:");
                        sb8.append(length2);
                        sb8.append(" bytes, after Gzip:");
                        sb8.append(bytes.length);
                        sb8.append(" bytes");
                        dVar3.mo34176h(sb8.toString());
                    }
                }
                httpPost.setEntity(new ByteArrayEntity(C7065b.m30246a(bytes)));
                HttpResponse execute = this.f23549a.execute(httpPost);
                HttpEntity entity = execute.getEntity();
                int statusCode = execute.getStatusLine().getStatusCode();
                long contentLength = entity.getContentLength();
                if (C7070b.m30304b()) {
                    C7067d dVar4 = f23546c;
                    StringBuilder sb9 = new StringBuilder();
                    sb9.append("http recv response status code:");
                    sb9.append(statusCode);
                    sb9.append(", content length:");
                    sb9.append(contentLength);
                    dVar4.mo34169b((Object) sb9.toString());
                }
                int i2 = (contentLength > 0 ? 1 : (contentLength == 0 ? 0 : -1));
                if (i2 <= 0) {
                    f23546c.mo34174f("Server response no data.");
                    if (cVar != null) {
                        cVar.mo34215b();
                    }
                    EntityUtils.toString(entity);
                    return;
                }
                if (i2 > 0) {
                    InputStream content = entity.getContent();
                    DataInputStream dataInputStream = new DataInputStream(content);
                    byte[] bArr = new byte[((int) entity.getContentLength())];
                    dataInputStream.readFully(bArr);
                    content.close();
                    dataInputStream.close();
                    Header firstHeader = execute.getFirstHeader(str6);
                    if (firstHeader != null) {
                        if (firstHeader.getValue().equalsIgnoreCase("gzip,rc4")) {
                            bArr = C7065b.m30248b(C7066c.m30258a(bArr));
                        } else if (firstHeader.getValue().equalsIgnoreCase("rc4,gzip")) {
                            bArr = C7066c.m30258a(C7065b.m30248b(bArr));
                        } else if (firstHeader.getValue().equalsIgnoreCase(str2)) {
                            bArr = C7066c.m30258a(bArr);
                        } else if (firstHeader.getValue().equalsIgnoreCase(str3)) {
                            bArr = C7065b.m30248b(bArr);
                        }
                    }
                    String str9 = new String(bArr, str5);
                    if (C7070b.m30304b()) {
                        C7067d dVar5 = f23546c;
                        StringBuilder sb10 = new StringBuilder();
                        sb10.append("http get response data:");
                        sb10.append(str9);
                        dVar5.mo34169b((Object) sb10.toString());
                    }
                    JSONObject jSONObject = new JSONObject(str9);
                    if (statusCode == 200) {
                        m30379a(jSONObject);
                        if (cVar != null) {
                            if (jSONObject.optInt(KEYS.RET) == 0) {
                                cVar.mo34214a();
                            } else {
                                f23546c.mo34173e("response error data.");
                                cVar.mo34215b();
                            }
                        }
                    } else {
                        C7067d dVar6 = f23546c;
                        StringBuilder sb11 = new StringBuilder();
                        sb11.append("Server response error code:");
                        sb11.append(statusCode);
                        sb11.append(", error:");
                        sb11.append(new String(bArr, str5));
                        dVar6.mo34173e(sb11.toString());
                        if (cVar != null) {
                            cVar.mo34215b();
                        }
                    }
                    content.close();
                } else {
                    EntityUtils.toString(entity);
                }
                byteArrayOutputStream.close();
                th = null;
                if (th != null) {
                    f23546c.mo34166a(th);
                    if (cVar != null) {
                        try {
                            cVar.mo34215b();
                        } catch (Throwable th2) {
                            f23546c.mo34170b(th2);
                        }
                    }
                    if (th instanceof OutOfMemoryError) {
                        System.gc();
                        this.f23550b = null;
                        this.f23550b = new StringBuilder(2048);
                    } else if (!(th instanceof UnknownHostException)) {
                        boolean z = th instanceof SocketTimeoutException;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo34218b(List<?> list, C7081c cVar) {
        mo34217a(list, cVar);
    }

    /* renamed from: a */
    public void mo34216a(C7100b bVar, C7081c cVar) {
        mo34218b(Arrays.asList(new String[]{bVar.mo34239d()}), cVar);
    }
}
