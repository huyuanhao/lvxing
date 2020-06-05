package com.p522qq.p523e.comm.net.p524rr;

import android.net.Uri;
import android.net.Uri.Builder;
import com.p522qq.p523e.comm.net.p524rr.Request.Method;
import com.p522qq.p523e.comm.util.StringUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.qq.e.comm.net.rr.AbstractRequest */
public abstract class AbstractRequest implements Request {
    /* renamed from: a */
    private boolean f20277a = true;
    /* renamed from: b */
    private int f20278b;
    /* renamed from: c */
    private int f20279c;
    /* renamed from: d */
    private int f20280d;
    /* renamed from: e */
    private String f20281e;
    /* renamed from: f */
    private Map<String, String> f20282f = new HashMap();
    /* renamed from: g */
    private Map<String, String> f20283g = new HashMap();
    /* renamed from: h */
    private Map<String, String> f20284h = Collections.unmodifiableMap(this.f20282f);
    /* renamed from: i */
    private Map<String, String> f20285i = Collections.unmodifiableMap(this.f20283g);
    /* renamed from: j */
    private Method f20286j;
    /* renamed from: k */
    private byte[] f20287k;

    public AbstractRequest(String str, Method method, byte[] bArr) {
        this.f20281e = str;
        this.f20286j = method;
        this.f20287k = bArr == null ? null : (byte[]) bArr.clone();
    }

    public AbstractRequest(String str, Map<String, String> map, Method method) {
        String str2;
        this.f20281e = str;
        this.f20286j = method;
        if (Method.POST == method) {
            StringBuilder sb = new StringBuilder();
            try {
                Iterator it = map.entrySet().iterator();
                while (true) {
                    str2 = "utf-8";
                    if (!it.hasNext()) {
                        break;
                    }
                    Entry entry = (Entry) it.next();
                    String encode = URLEncoder.encode((String) entry.getKey(), str2);
                    String encode2 = URLEncoder.encode((String) entry.getValue(), str2);
                    if (sb.length() > 0) {
                        sb.append("&");
                    }
                    sb.append(encode);
                    sb.append("=");
                    sb.append(encode2);
                }
                if (sb.length() > 0) {
                    this.f20287k = sb.toString().getBytes(str2);
                    addHeader("Content-Type", "application/x-www-form-urlencoded");
                }
            } catch (UnsupportedEncodingException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

    public void addHeader(String str, String str2) {
        if (!StringUtil.isEmpty(str) && !StringUtil.isEmpty(str2)) {
            this.f20282f.put(str, str2);
        }
    }

    public void addQuery(String str, String str2) {
        this.f20283g.put(str, str2);
    }

    public int getConnectionTimeOut() {
        return this.f20279c;
    }

    public Map<String, String> getHeaders() {
        return this.f20284h;
    }

    public Method getMethod() {
        return this.f20286j;
    }

    public byte[] getPostData() throws Exception {
        return this.f20287k;
    }

    public int getPriority() {
        return this.f20278b;
    }

    public Map<String, String> getQuerys() {
        return this.f20285i;
    }

    public int getSocketTimeOut() {
        return this.f20280d;
    }

    public String getUrl() {
        return this.f20281e;
    }

    public String getUrlWithParas() {
        if (getQuerys().isEmpty()) {
            return getUrl();
        }
        Builder buildUpon = Uri.parse(getUrl()).buildUpon();
        for (Entry entry : getQuerys().entrySet()) {
            buildUpon.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
        }
        return buildUpon.build().toString();
    }

    public boolean isAutoClose() {
        return this.f20277a;
    }

    public void setAutoClose(boolean z) {
        this.f20277a = z;
    }

    public void setConnectionTimeOut(int i) {
        this.f20279c = i;
    }

    public void setPriority(int i) {
        this.f20278b = i;
    }

    public void setSocketTimeOut(int i) {
        this.f20280d = i;
    }
}
