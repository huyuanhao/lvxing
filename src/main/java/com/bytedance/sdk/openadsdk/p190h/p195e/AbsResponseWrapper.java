package com.bytedance.sdk.openadsdk.p190h.p195e;

import com.bytedance.sdk.openadsdk.p190h.C2482i.C2484b;
import com.tencent.p605ep.commonbase.network.HttpStatus;
import java.io.InputStream;
import java.util.List;

/* renamed from: com.bytedance.sdk.openadsdk.h.e.a */
public abstract class AbsResponseWrapper {
    /* renamed from: a */
    List<C2484b> f8845a;
    /* renamed from: b */
    VideoRequest f8846b;

    /* renamed from: a */
    public abstract int mo16741a();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo16743a(int i) {
        switch (i) {
            case 200:
                return "OK";
            case 201:
                return "Created";
            case 202:
                return "Accepted";
            case 203:
                return "Non-Authoritative";
            case 204:
                return "No Content";
            case 205:
                return "Reset Content";
            case 206:
                return "Partial Content";
            default:
                switch (i) {
                    case 300:
                        return "Multiple Choices";
                    case 301:
                        return "Moved Permanently";
                    case 302:
                        return "Temporary Redirect";
                    case 303:
                        return "See Other";
                    case 304:
                        return "Not Modified";
                    case 305:
                        return "Use Proxy";
                    default:
                        switch (i) {
                            case 400:
                                return "Bad Request";
                            case 401:
                                return "Unauthorized";
                            case 402:
                                return "Payment Required";
                            case 403:
                                return "Forbidden";
                            case 404:
                                return "Not Found";
                            case 405:
                                return "Method Not Allowed";
                            case 406:
                                return "Not Acceptable";
                            case 407:
                                return "Proxy Authentication Required";
                            case HttpStatus.SC_REQUEST_TIMEOUT /*408*/:
                                return "Request Time-Out";
                            case HttpStatus.SC_CONFLICT /*409*/:
                                return "Conflict";
                            case HttpStatus.SC_GONE /*410*/:
                                return "Gone";
                            case HttpStatus.SC_LENGTH_REQUIRED /*411*/:
                                return "Length Required";
                            case HttpStatus.SC_PRECONDITION_FAILED /*412*/:
                                return "Precondition Failed";
                            case HttpStatus.SC_REQUEST_TOO_LONG /*413*/:
                                return "Request Entity Too Large";
                            case HttpStatus.SC_REQUEST_URI_TOO_LONG /*414*/:
                                return "Request-URI Too Large";
                            case HttpStatus.SC_UNSUPPORTED_MEDIA_TYPE /*415*/:
                                return "Unsupported Media Type";
                            default:
                                switch (i) {
                                    case 500:
                                        return "Internal Server Error";
                                    case 501:
                                        return "Not Implemented";
                                    case 502:
                                        return "Bad Gateway";
                                    case 503:
                                        return "Service Unavailable";
                                    case HttpStatus.SC_GATEWAY_TIMEOUT /*504*/:
                                        return "Gateway Timeout";
                                    case 505:
                                        return "HTTP Version Not Supported";
                                    default:
                                        return "";
                                }
                        }
                }
        }
    }

    /* renamed from: a */
    public abstract String mo16744a(String str, String str2);

    /* renamed from: b */
    public abstract boolean mo16745b();

    /* renamed from: c */
    public abstract List<C2484b> mo16746c();

    /* renamed from: d */
    public abstract InputStream mo16747d();

    /* renamed from: e */
    public abstract String mo16748e();

    /* renamed from: f */
    public abstract String mo16749f();

    /* renamed from: g */
    public VideoRequest mo16750g() {
        return this.f8846b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C2484b mo16742a(String str) {
        if (str == null) {
            return null;
        }
        List<C2484b> list = this.f8845a;
        if (list != null && list.size() > 0) {
            for (C2484b bVar : this.f8845a) {
                if (str.equals(bVar.f8931a)) {
                    return bVar;
                }
            }
        }
        return null;
    }
}
