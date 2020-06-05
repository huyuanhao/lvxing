package com.tencent.stat;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.provider.Settings.System;
import androidx.core.app.NotificationCompat;
import com.kwad.sdk.core.imageloader.core.download.BaseImageDownloader;
import com.p522qq.p523e.comm.constants.Constants.KEYS;
import com.tencent.mid.api.MidService;
import com.tencent.mid.sotrage.StorageInterface;
import com.tencent.mid.util.Util;
import com.tencent.qqpim.discovery.internal.protocol.C7516p;
import com.tencent.stat.common.C7597d;
import com.tencent.stat.common.C7598e;
import com.tencent.stat.common.C7600g;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.StatConstants;
import com.tencent.stat.common.StatLogger;
import com.tencent.stat.event.Event;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
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

/* renamed from: com.tencent.stat.d */
class C7608d {
    /* renamed from: d */
    private static StatLogger f25700d = StatCommonHelper.getLogger();
    /* renamed from: e */
    private static C7608d f25701e = null;
    /* renamed from: f */
    private static Context f25702f = null;
    /* renamed from: a */
    DefaultHttpClient f25703a = null;
    /* renamed from: b */
    Handler f25704b = null;
    /* renamed from: c */
    StringBuilder f25705c = new StringBuilder(4096);
    /* renamed from: g */
    private long f25706g = 0;

    private C7608d(Context context) {
        try {
            HandlerThread handlerThread = new HandlerThread("StatDispatcher");
            handlerThread.start();
            this.f25704b = new Handler(handlerThread.getLooper());
            m32795a(context);
            this.f25706g = System.currentTimeMillis() / 1000;
            BasicHttpParams basicHttpParams = new BasicHttpParams();
            HttpConnectionParams.setStaleCheckingEnabled(basicHttpParams, false);
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, C7516p.f25219Cf);
            HttpConnectionParams.setSoTimeout(basicHttpParams, C7516p.f25219Cf);
            this.f25703a = new DefaultHttpClient(basicHttpParams);
            this.f25703a.setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy() {
                public long getKeepAliveDuration(HttpResponse httpResponse, HttpContext httpContext) {
                    long keepAliveDuration = C7608d.super.getKeepAliveDuration(httpResponse, httpContext);
                    if (keepAliveDuration == -1) {
                        return 30000;
                    }
                    return keepAliveDuration;
                }
            });
        } catch (Throwable th) {
            f25700d.mo37104e(th);
        }
    }

    /* renamed from: a */
    static void m32795a(Context context) {
        if (context == null) {
            return;
        }
        if (context.getApplicationContext() != null) {
            f25702f = context.getApplicationContext();
        } else {
            f25702f = context;
        }
    }

    /* renamed from: a */
    static Context m32792a() {
        return f25702f;
    }

    /* renamed from: b */
    static C7608d m32797b(Context context) {
        if (f25701e == null) {
            synchronized (C7608d.class) {
                if (f25701e == null) {
                    f25701e = new C7608d(context);
                }
            }
        }
        return f25701e;
    }

    /* renamed from: a */
    private void m32796a(JSONObject jSONObject) {
        String str = "ncts";
        String str2 = "cfg";
        try {
            String optString = jSONObject.optString("mid");
            if (Util.isMidValid(optString)) {
                if (StatConfig.isDebugEnable()) {
                    StatLogger statLogger = f25700d;
                    StringBuilder sb = new StringBuilder();
                    sb.append("update mid:");
                    sb.append(optString);
                    statLogger.mo37108i(sb.toString());
                }
                Util.updateIfLocalInvalid(f25702f, optString);
            }
            if (!jSONObject.isNull(str2)) {
                StatConfig.m32591a(f25702f, jSONObject.getJSONObject(str2));
            }
            if (!jSONObject.isNull(str)) {
                int i = jSONObject.getInt(str);
                int currentTimeMillis = (int) (((long) i) - (System.currentTimeMillis() / 1000));
                if (StatConfig.isDebugEnable()) {
                    StatLogger statLogger2 = f25700d;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("server time:");
                    sb2.append(i);
                    sb2.append(", diff time:");
                    sb2.append(currentTimeMillis);
                    statLogger2.mo37108i(sb2.toString());
                }
                StatCommonHelper.updateCheckTime(f25702f);
                StatCommonHelper.writeDiffTimeFromServer(f25702f, currentTimeMillis);
            }
        } catch (Throwable th) {
            f25700d.mo37116w(th);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37132a(List<?> list, StatDispatchCallback statDispatchCallback) {
        Throwable th;
        List<?> list2 = list;
        String str = "gzip";
        String str2 = "rc4";
        String str3 = "[";
        String str4 = "UTF-8";
        String str5 = "Content-Encoding";
        if (list2 != null && !list.isEmpty()) {
            int size = list.size();
            try {
                this.f25705c.delete(0, this.f25705c.length());
                this.f25705c.append(str3);
                for (int i = 0; i < size; i++) {
                    this.f25705c.append(list2.get(i).toString());
                    if (i != size - 1) {
                        this.f25705c.append(StorageInterface.KEY_SPLITER);
                    }
                }
                this.f25705c.append("]");
                String sb = this.f25705c.toString();
                int length = sb.length();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(StatConfig.getStatReportUrl());
                sb2.append("/?index=");
                sb2.append(this.f25706g);
                String sb3 = sb2.toString();
                this.f25706g++;
                if (StatConfig.isDebugEnable()) {
                    StatLogger statLogger = f25700d;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(str3);
                    sb4.append(sb3);
                    sb4.append("]Send request(");
                    sb4.append(length);
                    sb4.append("bytes), content:");
                    sb4.append(sb);
                    statLogger.mo37108i(sb4.toString());
                }
                HttpPost httpPost = new HttpPost(sb3);
                httpPost.addHeader("Accept-Encoding", str);
                httpPost.setHeader("Connection", "Keep-Alive");
                httpPost.removeHeaders("Cache-Control");
                HttpHost httpProxy = NetworkManager.getInstance(f25702f).getHttpProxy();
                httpPost.addHeader(str5, str2);
                String str6 = "http.route.default-proxy";
                String str7 = "X-Content-Encoding";
                if (httpProxy == null) {
                    this.f25703a.getParams().removeParameter(str6);
                } else {
                    if (StatConfig.isDebugEnable()) {
                        StatLogger statLogger2 = f25700d;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("proxy:");
                        sb5.append(httpProxy.toHostString());
                        statLogger2.mo37101d(sb5.toString());
                    }
                    httpPost.addHeader(str7, str2);
                    this.f25703a.getParams().setParameter(str6, httpProxy);
                    httpPost.addHeader("X-Online-Host", StatConfig.f25366k);
                    httpPost.addHeader("Accept", "*/*");
                    httpPost.addHeader("Content-Type", "json");
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
                byte[] bytes = sb.getBytes(str4);
                int length2 = bytes.length;
                if (length > StatConfig.f25370o) {
                    httpPost.removeHeaders(str5);
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(str2);
                    sb6.append(",gzip");
                    String sb7 = sb6.toString();
                    httpPost.addHeader(str5, sb7);
                    if (httpProxy != null) {
                        httpPost.removeHeaders(str7);
                        httpPost.addHeader(str7, sb7);
                    }
                    byteArrayOutputStream.write(new byte[4]);
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    gZIPOutputStream.write(bytes);
                    gZIPOutputStream.close();
                    bytes = byteArrayOutputStream.toByteArray();
                    ByteBuffer.wrap(bytes, 0, 4).putInt(length2);
                    if (StatConfig.isDebugEnable()) {
                        StatLogger statLogger3 = f25700d;
                        StringBuilder sb8 = new StringBuilder();
                        sb8.append("before Gzip:");
                        sb8.append(length2);
                        sb8.append(" bytes, after Gzip:");
                        sb8.append(bytes.length);
                        sb8.append(" bytes");
                        statLogger3.mo37101d(sb8.toString());
                    }
                }
                httpPost.setEntity(new ByteArrayEntity(C7598e.m32760a(bytes)));
                HttpResponse execute = this.f25703a.execute(httpPost);
                HttpEntity entity = execute.getEntity();
                int statusCode = execute.getStatusLine().getStatusCode();
                long contentLength = entity.getContentLength();
                if (StatConfig.isDebugEnable()) {
                    StatLogger statLogger4 = f25700d;
                    StringBuilder sb9 = new StringBuilder();
                    sb9.append("http recv response status code:");
                    sb9.append(statusCode);
                    sb9.append(", content length:");
                    sb9.append(contentLength);
                    statLogger4.mo37108i(sb9.toString());
                }
                int i2 = (contentLength > 0 ? 1 : (contentLength == 0 ? 0 : -1));
                if (i2 == 0) {
                    f25700d.mo37103e((Object) "Server response no data.");
                    if (statDispatchCallback != null) {
                        statDispatchCallback.onDispatchFailure();
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
                    Header firstHeader = execute.getFirstHeader(str5);
                    if (firstHeader != null) {
                        if (firstHeader.getValue().equalsIgnoreCase("gzip,rc4")) {
                            bArr = C7598e.m32762b(StatCommonHelper.deocdeGZipContent(bArr));
                        } else if (firstHeader.getValue().equalsIgnoreCase("rc4,gzip")) {
                            bArr = StatCommonHelper.deocdeGZipContent(C7598e.m32762b(bArr));
                        } else if (firstHeader.getValue().equalsIgnoreCase(str)) {
                            bArr = StatCommonHelper.deocdeGZipContent(bArr);
                        } else if (firstHeader.getValue().equalsIgnoreCase(str2)) {
                            bArr = C7598e.m32762b(bArr);
                        }
                    }
                    String str8 = new String(bArr, str4);
                    if (StatConfig.isDebugEnable()) {
                        StatLogger statLogger5 = f25700d;
                        StringBuilder sb10 = new StringBuilder();
                        sb10.append("http get response data:");
                        sb10.append(str8);
                        statLogger5.mo37108i(sb10.toString());
                    }
                    JSONObject jSONObject = new JSONObject(str8);
                    if (statusCode == 200) {
                        m32796a(jSONObject);
                        if (statDispatchCallback != null) {
                            if (jSONObject.optInt(KEYS.RET) == 0) {
                                statDispatchCallback.onDispatchSuccess();
                            } else {
                                f25700d.error((Object) "response error data.");
                                statDispatchCallback.onDispatchFailure();
                            }
                        }
                    } else {
                        StatLogger statLogger6 = f25700d;
                        StringBuilder sb11 = new StringBuilder();
                        sb11.append("Server response error code:");
                        sb11.append(statusCode);
                        sb11.append(", error:");
                        sb11.append(new String(bArr, str4));
                        statLogger6.error((Object) sb11.toString());
                        if (statDispatchCallback != null) {
                            statDispatchCallback.onDispatchFailure();
                        }
                    }
                    content.close();
                } else {
                    EntityUtils.toString(entity);
                }
                byteArrayOutputStream.close();
                th = null;
                if (th != null) {
                    f25700d.error(th);
                    if (statDispatchCallback != null) {
                        try {
                            statDispatchCallback.onDispatchFailure();
                        } catch (Throwable th2) {
                            f25700d.mo37104e(th2);
                        }
                    }
                    if (th instanceof OutOfMemoryError) {
                        this.f25705c = null;
                        System.gc();
                        this.f25705c = new StringBuilder(2048);
                    } else if (!(th instanceof UnknownHostException)) {
                        boolean z = th instanceof SocketTimeoutException;
                    }
                    NetworkManager.getInstance(f25702f).onDispatchFailed();
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    /* renamed from: c */
    private long m32798c() {
        try {
            return System.currentTimeMillis() / 1000;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m32793a(int i, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("data", "null");
            String str2 = NotificationCompat.CATEGORY_MESSAGE;
            StringBuilder sb = new StringBuilder();
            sb.append("error:");
            sb.append(str);
            jSONObject.put(str2, sb.toString());
            jSONObject.put("code", String.valueOf(i));
            return jSONObject.toString();
        } catch (Throwable th) {
            f25700d.mo37104e(th);
            return "{\"code\":-1,\"msg\":\"调用失败\",\"data\":null}";
        }
    }

    /* renamed from: a */
    public String mo37125a(String str, String str2) throws IOException {
        String appKey = StatConfig.getAppKey(f25702f);
        String localMidOnly = MidService.getLocalMidOnly(f25702f);
        String curAppVersion = StatCommonHelper.getCurAppVersion(f25702f);
        String str3 = VERSION.RELEASE;
        String deviceModel = StatCommonHelper.getDeviceModel(f25702f);
        String linkedWay = StatCommonHelper.getLinkedWay(f25702f);
        StringBuilder sb = new StringBuilder();
        sb.append(m32798c());
        sb.append("");
        String sb2 = sb.toString();
        HashMap hashMap = new HashMap();
        hashMap.put("UserName", "user");
        hashMap.put("AppKey", appKey);
        hashMap.put("Mid", localMidOnly);
        hashMap.put("Content", str);
        hashMap.put("AppVersion", curAppVersion);
        hashMap.put("OSVersion", str3);
        hashMap.put("Model", deviceModel);
        hashMap.put("NetWork", linkedWay);
        hashMap.put("FileType", "img");
        hashMap.put("TimeStamp", sb2);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(com.tencent.stat.common.Util.decode(StatConstants.FB_KEY));
        StringBuilder sb4 = new StringBuilder();
        sb4.append("AppKey=");
        sb4.append(appKey);
        sb3.append(sb4.toString());
        StringBuilder sb5 = new StringBuilder();
        sb5.append("AppVersion=");
        sb5.append(curAppVersion);
        sb3.append(sb5.toString());
        StringBuilder sb6 = new StringBuilder();
        sb6.append("Mid=");
        sb6.append(localMidOnly);
        sb3.append(sb6.toString());
        StringBuilder sb7 = new StringBuilder();
        sb7.append("Model=");
        sb7.append(deviceModel);
        sb3.append(sb7.toString());
        StringBuilder sb8 = new StringBuilder();
        sb8.append("NetWork=");
        sb8.append(linkedWay);
        sb3.append(sb8.toString());
        StringBuilder sb9 = new StringBuilder();
        sb9.append("OSVersion=");
        sb9.append(str3);
        sb3.append(sb9.toString());
        StringBuilder sb10 = new StringBuilder();
        sb10.append("TimeStamp=");
        sb10.append(sb2);
        sb3.append(sb10.toString());
        hashMap.put("Sign", StatCommonHelper.md5sum(sb3.toString()));
        C7597d.m32759a(f25702f);
        StringBuilder sb11 = new StringBuilder();
        sb11.append(f25702f.getFilesDir());
        sb11.append("/feedback.log");
        String sb12 = sb11.toString();
        HashMap hashMap2 = new HashMap();
        hashMap2.put("log", new File(sb12));
        if (str2 != null && str2.trim().length() > 0) {
            StringBuilder sb13 = new StringBuilder();
            sb13.append(f25702f.getFilesDir());
            sb13.append("/feedback.png");
            File file = new File(sb13.toString());
            C7600g.m32773a(str2, file);
            hashMap2.put("screenshot", file);
        }
        return mo37126a((Map<String, String>) hashMap, (Map<String, File>) hashMap2);
    }

    /* renamed from: a */
    public String mo37126a(Map<String, String> map, Map<String, File> map2) throws IOException {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String uuid = UUID.randomUUID().toString();
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://mta.qq.com/mta/api/ctr_feedback/add_feedback").openConnection();
        httpURLConnection.setReadTimeout(BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("connection", "keep-alive");
        String str6 = "UTF-8";
        httpURLConnection.setRequestProperty("Charsert", str6);
        StringBuilder sb = new StringBuilder();
        sb.append("multipart/form-data");
        sb.append(";boundary=");
        sb.append(uuid);
        httpURLConnection.setRequestProperty("Content-Type", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        Iterator it = map.entrySet().iterator();
        while (true) {
            str = "\"";
            str2 = "Content-Disposition: form-data; name=\"";
            str3 = "--";
            str4 = "\r\n";
            if (!it.hasNext()) {
                break;
            }
            Entry entry = (Entry) it.next();
            sb2.append(str3);
            sb2.append(uuid);
            sb2.append(str4);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str2);
            sb3.append((String) entry.getKey());
            sb3.append(str);
            sb3.append(str4);
            sb2.append(sb3.toString());
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Content-Type: text/plain; charset=");
            sb4.append(str6);
            sb4.append(str4);
            sb2.append(sb4.toString());
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Content-Transfer-Encoding: 8bit");
            sb5.append(str4);
            sb2.append(sb5.toString());
            sb2.append(str4);
            sb2.append((String) entry.getValue());
            sb2.append(str4);
        }
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        dataOutputStream.write(sb2.toString().getBytes());
        if (map2 != null) {
            for (Entry entry2 : map2.entrySet()) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append(str3);
                sb6.append(uuid);
                sb6.append(str4);
                StringBuilder sb7 = new StringBuilder();
                sb7.append(str2);
                sb7.append((String) entry2.getKey());
                sb7.append("\"; filename=\"");
                sb7.append(((File) entry2.getValue()).getName());
                sb7.append(str);
                sb7.append(str4);
                sb6.append(sb7.toString());
                StringBuilder sb8 = new StringBuilder();
                sb8.append("Content-Type: application/octet-stream; charset=");
                sb8.append(str6);
                sb8.append(str4);
                sb6.append(sb8.toString());
                sb6.append(str4);
                dataOutputStream.write(sb6.toString().getBytes());
                FileInputStream fileInputStream = new FileInputStream((File) entry2.getValue());
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    dataOutputStream.write(bArr, 0, read);
                }
                fileInputStream.close();
                dataOutputStream.write(str4.getBytes());
            }
        }
        StringBuilder sb9 = new StringBuilder();
        sb9.append(str3);
        sb9.append(uuid);
        sb9.append(str3);
        sb9.append(str4);
        dataOutputStream.write(sb9.toString().getBytes());
        dataOutputStream.flush();
        StringBuilder sb10 = new StringBuilder();
        if (httpURLConnection.getResponseCode() == 200) {
            InputStream inputStream = httpURLConnection.getInputStream();
            while (true) {
                int read2 = inputStream.read();
                if (read2 == -1) {
                    break;
                }
                sb10.append((char) read2);
            }
            str5 = sb10.toString();
        } else {
            StringBuilder sb11 = new StringBuilder();
            sb11.append("");
            sb11.append(httpURLConnection.getResponseCode());
            str5 = m32793a(-1, sb11.toString());
        }
        dataOutputStream.close();
        httpURLConnection.disconnect();
        return str5;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01c3 A[Catch:{ all -> 0x0204 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01c6 A[Catch:{ all -> 0x0204 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01ea  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01ef  */
    /* JADX WARNING: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    public void mo37131a(java.lang.String r13, java.util.Map<java.lang.String, java.lang.String> r14, com.tencent.stat.StatFBDispatchCallback r15) {
        /*
        r12 = this;
        java.lang.String r0 = "UTF-8"
        java.lang.String r1 = "Content-Encoding"
        java.lang.String r2 = "rc4"
        java.lang.String r3 = ""
        r4 = -1
        org.apache.http.client.methods.HttpPost r5 = new org.apache.http.client.methods.HttpPost     // Catch:{ all -> 0x01bd }
        r5.<init>(r13)     // Catch:{ all -> 0x01bd }
        java.lang.String r13 = "Connection"
        java.lang.String r6 = "Keep-Alive"
        r5.setHeader(r13, r6)     // Catch:{ all -> 0x01bd }
        java.lang.String r13 = "Cache-Control"
        r5.removeHeaders(r13)     // Catch:{ all -> 0x01bd }
        android.content.Context r13 = f25702f     // Catch:{ all -> 0x01bd }
        com.tencent.stat.NetworkManager r13 = com.tencent.stat.NetworkManager.getInstance(r13)     // Catch:{ all -> 0x01bd }
        org.apache.http.HttpHost r13 = r13.getHttpProxy()     // Catch:{ all -> 0x01bd }
        r5.addHeader(r1, r2)     // Catch:{ all -> 0x01bd }
        java.lang.String r6 = "http.route.default-proxy"
        if (r13 != 0) goto L_0x0035
        org.apache.http.impl.client.DefaultHttpClient r13 = r12.f25703a     // Catch:{ all -> 0x01bd }
        org.apache.http.params.HttpParams r13 = r13.getParams()     // Catch:{ all -> 0x01bd }
        r13.removeParameter(r6)     // Catch:{ all -> 0x01bd }
        goto L_0x0073
    L_0x0035:
        boolean r7 = com.tencent.stat.StatConfig.isDebugEnable()     // Catch:{ all -> 0x01bd }
        if (r7 == 0) goto L_0x0055
        com.tencent.stat.common.StatLogger r7 = f25700d     // Catch:{ all -> 0x01bd }
        java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x01bd }
        r8.<init>()     // Catch:{ all -> 0x01bd }
        java.lang.String r9 = "proxy:"
        r8.append(r9)     // Catch:{ all -> 0x01bd }
        java.lang.String r9 = r13.toHostString()     // Catch:{ all -> 0x01bd }
        r8.append(r9)     // Catch:{ all -> 0x01bd }
        java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x01bd }
        r7.mo37101d(r8)     // Catch:{ all -> 0x01bd }
    L_0x0055:
        org.apache.http.impl.client.DefaultHttpClient r7 = r12.f25703a     // Catch:{ all -> 0x01bd }
        org.apache.http.params.HttpParams r7 = r7.getParams()     // Catch:{ all -> 0x01bd }
        r7.setParameter(r6, r13)     // Catch:{ all -> 0x01bd }
        java.lang.String r13 = "X-Online-Host"
        java.lang.String r6 = "mta.qq.com:80"
        r5.addHeader(r13, r6)     // Catch:{ all -> 0x01bd }
        java.lang.String r13 = "Accept"
        java.lang.String r6 = "*/*"
        r5.addHeader(r13, r6)     // Catch:{ all -> 0x01bd }
        java.lang.String r13 = "Content-Type"
        java.lang.String r6 = "text/plain"
        r5.addHeader(r13, r6)     // Catch:{ all -> 0x01bd }
    L_0x0073:
        java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ all -> 0x01bd }
        r13.<init>()     // Catch:{ all -> 0x01bd }
        java.util.Set r14 = r14.entrySet()     // Catch:{ all -> 0x01bd }
        java.util.Iterator r14 = r14.iterator()     // Catch:{ all -> 0x01bd }
    L_0x0080:
        boolean r6 = r14.hasNext()     // Catch:{ all -> 0x01bd }
        if (r6 == 0) goto L_0x00a1
        java.lang.Object r6 = r14.next()     // Catch:{ all -> 0x01bd }
        java.util.Map$Entry r6 = (java.util.Map.Entry) r6     // Catch:{ all -> 0x01bd }
        org.apache.http.message.BasicNameValuePair r7 = new org.apache.http.message.BasicNameValuePair     // Catch:{ all -> 0x01bd }
        java.lang.Object r8 = r6.getKey()     // Catch:{ all -> 0x01bd }
        java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x01bd }
        java.lang.Object r6 = r6.getValue()     // Catch:{ all -> 0x01bd }
        java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x01bd }
        r7.<init>(r8, r6)     // Catch:{ all -> 0x01bd }
        r13.add(r7)     // Catch:{ all -> 0x01bd }
        goto L_0x0080
    L_0x00a1:
        org.apache.http.client.entity.UrlEncodedFormEntity r14 = new org.apache.http.client.entity.UrlEncodedFormEntity     // Catch:{ all -> 0x01bd }
        r14.<init>(r13, r0)     // Catch:{ all -> 0x01bd }
        r5.setEntity(r14)     // Catch:{ all -> 0x01bd }
        org.apache.http.impl.client.DefaultHttpClient r13 = r12.f25703a     // Catch:{ all -> 0x01bd }
        org.apache.http.HttpResponse r13 = r13.execute(r5)     // Catch:{ all -> 0x01bd }
        org.apache.http.HttpEntity r14 = r13.getEntity()     // Catch:{ all -> 0x01bd }
        org.apache.http.StatusLine r5 = r13.getStatusLine()     // Catch:{ all -> 0x01bd }
        int r5 = r5.getStatusCode()     // Catch:{ all -> 0x01bd }
        long r6 = r14.getContentLength()     // Catch:{ all -> 0x01bd }
        boolean r8 = com.tencent.stat.StatConfig.isDebugEnable()     // Catch:{ all -> 0x01bd }
        if (r8 == 0) goto L_0x00e3
        com.tencent.stat.common.StatLogger r8 = f25700d     // Catch:{ all -> 0x01bd }
        java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x01bd }
        r9.<init>()     // Catch:{ all -> 0x01bd }
        java.lang.String r10 = "http recv response status code:"
        r9.append(r10)     // Catch:{ all -> 0x01bd }
        r9.append(r5)     // Catch:{ all -> 0x01bd }
        java.lang.String r10 = ", content length:"
        r9.append(r10)     // Catch:{ all -> 0x01bd }
        r9.append(r6)     // Catch:{ all -> 0x01bd }
        java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x01bd }
        r8.mo37108i(r9)     // Catch:{ all -> 0x01bd }
    L_0x00e3:
        r8 = 0
        int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
        if (r10 <= 0) goto L_0x01a1
        java.io.InputStream r6 = r14.getContent()     // Catch:{ all -> 0x01bd }
        java.io.DataInputStream r7 = new java.io.DataInputStream     // Catch:{ all -> 0x01bd }
        r7.<init>(r6)     // Catch:{ all -> 0x01bd }
        long r8 = r14.getContentLength()     // Catch:{ all -> 0x01bd }
        int r14 = (int) r8     // Catch:{ all -> 0x01bd }
        byte[] r14 = new byte[r14]     // Catch:{ all -> 0x01bd }
        r7.readFully(r14)     // Catch:{ all -> 0x01bd }
        r6.close()     // Catch:{ all -> 0x01bd }
        r7.close()     // Catch:{ all -> 0x01bd }
        org.apache.http.Header r13 = r13.getFirstHeader(r1)     // Catch:{ all -> 0x01bd }
        if (r13 == 0) goto L_0x0151
        java.lang.String r1 = r13.getValue()     // Catch:{ all -> 0x01bd }
        java.lang.String r6 = "gzip,rc4"
        boolean r1 = r1.equalsIgnoreCase(r6)     // Catch:{ all -> 0x01bd }
        if (r1 == 0) goto L_0x011d
        byte[] r13 = com.tencent.stat.common.StatCommonHelper.deocdeGZipContent(r14)     // Catch:{ all -> 0x01bd }
        byte[] r14 = com.tencent.stat.common.C7598e.m32762b(r13)     // Catch:{ all -> 0x01bd }
        goto L_0x0151
    L_0x011d:
        java.lang.String r1 = r13.getValue()     // Catch:{ all -> 0x01bd }
        java.lang.String r6 = "rc4,gzip"
        boolean r1 = r1.equalsIgnoreCase(r6)     // Catch:{ all -> 0x01bd }
        if (r1 == 0) goto L_0x0132
        byte[] r13 = com.tencent.stat.common.C7598e.m32762b(r14)     // Catch:{ all -> 0x01bd }
        byte[] r14 = com.tencent.stat.common.StatCommonHelper.deocdeGZipContent(r13)     // Catch:{ all -> 0x01bd }
        goto L_0x0151
    L_0x0132:
        java.lang.String r1 = r13.getValue()     // Catch:{ all -> 0x01bd }
        java.lang.String r6 = "gzip"
        boolean r1 = r1.equalsIgnoreCase(r6)     // Catch:{ all -> 0x01bd }
        if (r1 == 0) goto L_0x0143
        byte[] r14 = com.tencent.stat.common.StatCommonHelper.deocdeGZipContent(r14)     // Catch:{ all -> 0x01bd }
        goto L_0x0151
    L_0x0143:
        java.lang.String r13 = r13.getValue()     // Catch:{ all -> 0x01bd }
        boolean r13 = r13.equalsIgnoreCase(r2)     // Catch:{ all -> 0x01bd }
        if (r13 == 0) goto L_0x0151
        byte[] r14 = com.tencent.stat.common.C7598e.m32762b(r14)     // Catch:{ all -> 0x01bd }
    L_0x0151:
        r13 = 200(0xc8, float:2.8E-43)
        if (r5 != r13) goto L_0x0177
        java.lang.String r13 = new java.lang.String     // Catch:{ all -> 0x01bd }
        r13.<init>(r14, r0)     // Catch:{ all -> 0x01bd }
        boolean r14 = com.tencent.stat.StatConfig.isDebugEnable()     // Catch:{ all -> 0x01b8 }
        if (r14 == 0) goto L_0x01b1
        com.tencent.stat.common.StatLogger r14 = f25700d     // Catch:{ all -> 0x01b8 }
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b8 }
        r0.<init>()     // Catch:{ all -> 0x01b8 }
        java.lang.String r1 = "http get response data:"
        r0.append(r1)     // Catch:{ all -> 0x01b8 }
        r0.append(r13)     // Catch:{ all -> 0x01b8 }
        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x01b8 }
        r14.mo37108i(r0)     // Catch:{ all -> 0x01b8 }
        goto L_0x01b1
    L_0x0177:
        com.tencent.stat.common.StatLogger r13 = f25700d     // Catch:{ all -> 0x01bd }
        java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x01bd }
        r14.<init>()     // Catch:{ all -> 0x01bd }
        java.lang.String r0 = "Server response error code:"
        r14.append(r0)     // Catch:{ all -> 0x01bd }
        r14.append(r5)     // Catch:{ all -> 0x01bd }
        java.lang.String r14 = r14.toString()     // Catch:{ all -> 0x01bd }
        r13.error(r14)     // Catch:{ all -> 0x01bd }
        java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x01bd }
        r13.<init>()     // Catch:{ all -> 0x01bd }
        r13.append(r3)     // Catch:{ all -> 0x01bd }
        r13.append(r5)     // Catch:{ all -> 0x01bd }
        java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x01bd }
        java.lang.String r13 = r12.m32793a(r4, r13)     // Catch:{ all -> 0x01bd }
        goto L_0x01b1
    L_0x01a1:
        com.tencent.stat.common.StatLogger r13 = f25700d     // Catch:{ all -> 0x01bd }
        java.lang.String r0 = "Server response no data."
        r13.mo37103e(r0)     // Catch:{ all -> 0x01bd }
        java.lang.String r13 = "no data"
        java.lang.String r13 = r12.m32793a(r4, r13)     // Catch:{ all -> 0x01bd }
        org.apache.http.util.EntityUtils.toString(r14)     // Catch:{ all -> 0x01b8 }
    L_0x01b1:
        if (r15 == 0) goto L_0x01b6
        r15.onFBDispatch(r13)
    L_0x01b6:
        r13 = 0
        goto L_0x01ed
    L_0x01b8:
        r14 = move-exception
        r11 = r14
        r14 = r13
        r13 = r11
        goto L_0x01bf
    L_0x01bd:
        r13 = move-exception
        r14 = r3
    L_0x01bf:
        boolean r0 = r13 instanceof java.lang.OutOfMemoryError     // Catch:{ all -> 0x0204 }
        if (r0 == 0) goto L_0x01c6
        java.lang.String r3 = "OOM"
        goto L_0x01d3
    L_0x01c6:
        boolean r0 = r13 instanceof java.net.UnknownHostException     // Catch:{ all -> 0x0204 }
        if (r0 == 0) goto L_0x01cd
        java.lang.String r3 = "UnknownHost"
        goto L_0x01d3
    L_0x01cd:
        boolean r0 = r13 instanceof java.net.SocketTimeoutException     // Catch:{ all -> 0x0204 }
        if (r0 == 0) goto L_0x01d3
        java.lang.String r3 = "SocketTimeOut"
    L_0x01d3:
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0204 }
        r0.<init>()     // Catch:{ all -> 0x0204 }
        r0.append(r3)     // Catch:{ all -> 0x0204 }
        java.lang.String r1 = "exception happen"
        r0.append(r1)     // Catch:{ all -> 0x0204 }
        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0204 }
        java.lang.String r14 = r12.m32793a(r4, r0)     // Catch:{ all -> 0x0204 }
        if (r15 == 0) goto L_0x01ed
        r15.onFBDispatch(r14)
    L_0x01ed:
        if (r13 == 0) goto L_0x0203
        com.tencent.stat.common.StatLogger r14 = f25700d
        r14.error(r13)
        boolean r14 = r13 instanceof java.lang.OutOfMemoryError
        if (r14 == 0) goto L_0x01fc
        java.lang.System.gc()
        goto L_0x0203
    L_0x01fc:
        boolean r14 = r13 instanceof java.net.UnknownHostException
        if (r14 == 0) goto L_0x0201
        goto L_0x0203
    L_0x0201:
        boolean r13 = r13 instanceof java.net.SocketTimeoutException
    L_0x0203:
        return
    L_0x0204:
        r13 = move-exception
        if (r15 == 0) goto L_0x020a
        r15.onFBDispatch(r14)
    L_0x020a:
        throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.C7608d.mo37131a(java.lang.String, java.util.Map, com.tencent.stat.StatFBDispatchCallback):void");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37127a(int i, int i2, StatFBDispatchCallback statFBDispatchCallback) {
        String appKey = StatConfig.getAppKey(f25702f);
        String localMidOnly = MidService.getLocalMidOnly(f25702f);
        StringBuilder sb = new StringBuilder();
        sb.append(m32798c());
        sb.append("");
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(com.tencent.stat.common.Util.decode(StatConstants.FB_KEY));
        StringBuilder sb4 = new StringBuilder();
        sb4.append("AppKey=");
        sb4.append(appKey);
        sb3.append(sb4.toString());
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Mid=");
        sb5.append(localMidOnly);
        sb3.append(sb5.toString());
        StringBuilder sb6 = new StringBuilder();
        sb6.append("TimeStamp=");
        sb6.append(sb2);
        sb3.append(sb6.toString());
        String md5sum = StatCommonHelper.md5sum(sb3.toString());
        HashMap hashMap = new HashMap();
        hashMap.put("AppKey", appKey);
        hashMap.put("Limit", Integer.toString(i2));
        hashMap.put("Mid", localMidOnly);
        hashMap.put("Offset", Integer.toString(i));
        hashMap.put("TimeStamp", sb2);
        hashMap.put("Sign", md5sum);
        mo37131a("http://mta.qq.com/mta/api/ctr_feedback/get_feedback", (Map<String, String>) hashMap, statFBDispatchCallback);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37130a(String str, String str2, StatFBDispatchCallback statFBDispatchCallback) {
        String appKey = StatConfig.getAppKey(f25702f);
        String localMidOnly = MidService.getLocalMidOnly(f25702f);
        StringBuilder sb = new StringBuilder();
        sb.append(m32798c());
        sb.append("");
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(com.tencent.stat.common.Util.decode(StatConstants.FB_KEY));
        StringBuilder sb4 = new StringBuilder();
        sb4.append("AppKey=");
        sb4.append(appKey);
        sb3.append(sb4.toString());
        StringBuilder sb5 = new StringBuilder();
        sb5.append("FeedbackId=");
        sb5.append(str);
        sb3.append(sb5.toString());
        StringBuilder sb6 = new StringBuilder();
        sb6.append("Mid=");
        sb6.append(localMidOnly);
        sb3.append(sb6.toString());
        StringBuilder sb7 = new StringBuilder();
        sb7.append("TimeStamp=");
        sb7.append(sb2);
        sb3.append(sb7.toString());
        String md5sum = StatCommonHelper.md5sum(sb3.toString());
        HashMap hashMap = new HashMap();
        hashMap.put("AppKey", appKey);
        hashMap.put("Mid", localMidOnly);
        hashMap.put("FeedbackId", str);
        hashMap.put("Content", str2);
        hashMap.put("TimeStamp", sb2);
        hashMap.put("Sign", md5sum);
        mo37131a("http://mta.qq.com/mta/api/ctr_feedback/reply_feedback", (Map<String, String>) hashMap, statFBDispatchCallback);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo37136b(final List<?> list, final StatDispatchCallback statDispatchCallback) {
        Handler handler = this.f25704b;
        if (handler != null) {
            handler.post(new Runnable() {
                public void run() {
                    C7608d.this.mo37132a(list, statDispatchCallback);
                }
            });
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo37133b() {
        System.putString(f25702f.getContentResolver(), "a", "b");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37128a(Event event, StatDispatchCallback statDispatchCallback) {
        mo37136b(Arrays.asList(new String[]{event.toJsonString()}), statDispatchCallback);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37129a(String str, StatDispatchCallback statDispatchCallback) {
        mo37136b(Arrays.asList(new String[]{str}), statDispatchCallback);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo37135b(final String str, final String str2, final StatFBDispatchCallback statFBDispatchCallback) {
        Handler handler = this.f25704b;
        if (handler != null) {
            handler.post(new Runnable() {
                public void run() {
                    StatFBDispatchCallback statFBDispatchCallback;
                    String str = "";
                    try {
                        str = C7608d.this.mo37125a(str, str2);
                        statFBDispatchCallback = statFBDispatchCallback;
                        if (statFBDispatchCallback == null) {
                            return;
                        }
                    } catch (Exception e) {
                        str = C7608d.this.m32793a(-1, "IOException happen");
                        e.printStackTrace();
                        statFBDispatchCallback = statFBDispatchCallback;
                        if (statFBDispatchCallback == null) {
                            return;
                        }
                    } catch (Throwable th) {
                        StatFBDispatchCallback statFBDispatchCallback2 = statFBDispatchCallback;
                        if (statFBDispatchCallback2 != null) {
                            statFBDispatchCallback2.onFBDispatch(str);
                        }
                        throw th;
                    }
                    statFBDispatchCallback.onFBDispatch(str);
                }
            });
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo37134b(final int i, final int i2, final StatFBDispatchCallback statFBDispatchCallback) {
        Handler handler = this.f25704b;
        if (handler != null) {
            handler.post(new Runnable() {
                public void run() {
                    C7608d.this.mo37127a(i, i2, statFBDispatchCallback);
                }
            });
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo37137c(final String str, final String str2, final StatFBDispatchCallback statFBDispatchCallback) {
        Handler handler = this.f25704b;
        if (handler != null) {
            handler.post(new Runnable() {
                public void run() {
                    C7608d.this.mo37130a(str, str2, statFBDispatchCallback);
                }
            });
        }
    }
}
