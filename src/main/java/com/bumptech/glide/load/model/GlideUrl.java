package com.bumptech.glide.load.model;

import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

/* renamed from: com.bumptech.glide.load.model.g */
public class GlideUrl implements Key {
    /* renamed from: b */
    private final Headers f4773b;
    /* renamed from: c */
    private final URL f4774c;
    /* renamed from: d */
    private final String f4775d;
    /* renamed from: e */
    private String f4776e;
    /* renamed from: f */
    private URL f4777f;
    /* renamed from: g */
    private volatile byte[] f4778g;
    /* renamed from: h */
    private int f4779h;

    public GlideUrl(URL url) {
        this(url, Headers.f4781b);
    }

    public GlideUrl(String str) {
        this(str, Headers.f4781b);
    }

    public GlideUrl(URL url, Headers hVar) {
        this.f4774c = (URL) Preconditions.m6138a(url);
        this.f4775d = null;
        this.f4773b = (Headers) Preconditions.m6138a(hVar);
    }

    public GlideUrl(String str, Headers hVar) {
        this.f4774c = null;
        this.f4775d = Preconditions.m6140a(str);
        this.f4773b = (Headers) Preconditions.m6138a(hVar);
    }

    /* renamed from: a */
    public URL mo12957a() throws MalformedURLException {
        return m5860e();
    }

    /* renamed from: e */
    private URL m5860e() throws MalformedURLException {
        if (this.f4777f == null) {
            this.f4777f = new URL(m5861f());
        }
        return this.f4777f;
    }

    /* renamed from: b */
    public String mo12958b() {
        return m5861f();
    }

    /* renamed from: f */
    private String m5861f() {
        if (TextUtils.isEmpty(this.f4776e)) {
            String str = this.f4775d;
            if (TextUtils.isEmpty(str)) {
                str = ((URL) Preconditions.m6138a(this.f4774c)).toString();
            }
            this.f4776e = Uri.encode(str, "@#&=*+-_.,:!?()/~'%;$");
        }
        return this.f4776e;
    }

    /* renamed from: c */
    public Map<String, String> mo12959c() {
        return this.f4773b.mo12962a();
    }

    /* renamed from: d */
    public String mo12960d() {
        String str = this.f4775d;
        return str != null ? str : ((URL) Preconditions.m6138a(this.f4774c)).toString();
    }

    public String toString() {
        return mo12960d();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(m5862g());
    }

    /* renamed from: g */
    private byte[] m5862g() {
        if (this.f4778g == null) {
            this.f4778g = mo12960d().getBytes(f4426a);
        }
        return this.f4778g;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GlideUrl)) {
            return false;
        }
        GlideUrl gVar = (GlideUrl) obj;
        if (!mo12960d().equals(gVar.mo12960d()) || !this.f4773b.equals(gVar.f4773b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        if (this.f4779h == 0) {
            this.f4779h = mo12960d().hashCode();
            this.f4779h = (this.f4779h * 31) + this.f4773b.hashCode();
        }
        return this.f4779h;
    }
}
