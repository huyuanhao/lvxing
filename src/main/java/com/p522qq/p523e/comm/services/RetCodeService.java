package com.p522qq.p523e.comm.services;

import com.p522qq.p523e.comm.managers.status.SDKStatus;
import com.p522qq.p523e.comm.net.NetworkClient.Priority;
import com.p522qq.p523e.comm.net.NetworkClientImpl;
import com.p522qq.p523e.comm.net.p524rr.PlainRequest;
import com.p522qq.p523e.comm.net.p524rr.Request;
import com.p522qq.p523e.comm.net.p524rr.Request.Method;
import com.p522qq.p523e.comm.p525pi.ACTD;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.Random;

/* renamed from: com.qq.e.comm.services.RetCodeService */
public class RetCodeService {
    /* renamed from: a */
    private final String f20297a;
    /* renamed from: b */
    private final String f20298b;
    /* renamed from: c */
    private final Random f20299c;
    /* renamed from: d */
    private final String f20300d;

    /* renamed from: com.qq.e.comm.services.RetCodeService$Holder */
    private static class Holder {
        /* renamed from: a */
        static final RetCodeService f20301a = new RetCodeService(0);

        private Holder() {
        }
    }

    /* renamed from: com.qq.e.comm.services.RetCodeService$RetCodeInfo */
    public static class RetCodeInfo {
        /* renamed from: a */
        final String f20302a;
        /* renamed from: b */
        final String f20303b;
        /* renamed from: c */
        final String f20304c;
        /* renamed from: d */
        final int f20305d;
        /* renamed from: e */
        final int f20306e;
        /* renamed from: f */
        final int f20307f;
        /* renamed from: g */
        final int f20308g;
        /* renamed from: h */
        final int f20309h;

        public RetCodeInfo(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5) {
            this.f20302a = str;
            this.f20303b = str2;
            this.f20304c = str3;
            this.f20305d = i;
            this.f20306e = i2;
            this.f20307f = i3;
            this.f20308g = i4;
            this.f20309h = i5;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("RetCodeInfo [host=");
            sb.append(this.f20302a);
            sb.append(", commandid=");
            sb.append(this.f20303b);
            sb.append(", releaseversion=");
            sb.append(this.f20304c);
            sb.append(", resultcode=");
            sb.append(this.f20305d);
            sb.append(", tmcost=");
            sb.append(this.f20306e);
            sb.append(", reqsize=");
            sb.append(this.f20307f);
            sb.append(", rspsize=");
            sb.append(this.f20308g);
            sb.append("]");
            return sb.toString();
        }
    }

    /* renamed from: com.qq.e.comm.services.RetCodeService$SendTask */
    class SendTask implements Runnable {
        /* renamed from: a */
        private RetCodeInfo f20310a;
        /* renamed from: b */
        private int f20311b = 100;

        SendTask(RetCodeInfo retCodeInfo, int i) {
            this.f20310a = retCodeInfo;
        }

        public void run() {
            RetCodeService.m25252a(RetCodeService.this, this.f20310a, this.f20311b);
        }
    }

    private RetCodeService() {
        this.f20297a = "1000162";
        this.f20298b = "http://wspeed.qq.com/w.cgi";
        this.f20299c = new Random(System.currentTimeMillis());
        this.f20300d = "http://c.isdspeed.qq.com/code.cgi";
    }

    /* synthetic */ RetCodeService(byte b) {
        this();
    }

    /* renamed from: a */
    private static String m25251a(String str) {
        try {
            return InetAddress.getByName(str).getHostAddress();
        } catch (UnknownHostException unused) {
            return "0.0.0.0";
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m25252a(RetCodeService retCodeService, RetCodeInfo retCodeInfo, int i) {
        String str = "utf-8";
        if (retCodeService.m25253a(i)) {
            PlainRequest plainRequest = new PlainRequest("http://wspeed.qq.com/w.cgi", Method.GET, (byte[]) null);
            plainRequest.addQuery(ACTD.APPID_KEY, "1000162");
            plainRequest.addQuery("resultcode", String.valueOf(retCodeInfo.f20305d));
            plainRequest.addQuery("sdkversion", SDKStatus.getSDKVersion());
            plainRequest.addQuery("touin", "");
            plainRequest.addQuery("tmcost", String.valueOf(retCodeInfo.f20306e));
            plainRequest.addQuery("reqsize", String.valueOf(retCodeInfo.f20307f));
            plainRequest.addQuery("rspsize", String.valueOf(retCodeInfo.f20308g));
            plainRequest.addQuery("frequency", String.valueOf(i));
            try {
                plainRequest.addQuery("commandid", URLEncoder.encode(retCodeInfo.f20303b, str));
                plainRequest.addQuery("releaseversion", URLEncoder.encode(retCodeInfo.f20304c, str));
                plainRequest.addQuery("serverip", URLEncoder.encode(m25251a(retCodeInfo.f20302a), str));
                NetworkClientImpl.getInstance().submit((Request) plainRequest, Priority.Low);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        if (retCodeService.m25253a(i)) {
            PlainRequest plainRequest2 = new PlainRequest("http://c.isdspeed.qq.com/code.cgi", Method.GET, (byte[]) null);
            plainRequest2.addQuery("domain", retCodeInfo.f20302a);
            plainRequest2.addQuery("cgi", retCodeInfo.f20303b);
            plainRequest2.addQuery("type", String.valueOf(retCodeInfo.f20309h));
            plainRequest2.addQuery("code", String.valueOf(retCodeInfo.f20305d));
            plainRequest2.addQuery("time", String.valueOf(retCodeInfo.f20306e));
            plainRequest2.addQuery("rate", String.valueOf(i));
            NetworkClientImpl.getInstance().submit((Request) plainRequest2, Priority.Low);
        }
    }

    /* renamed from: a */
    private boolean m25253a(int i) {
        return this.f20299c.nextDouble() < 1.0d / ((double) i);
    }

    public static RetCodeService getInstance() {
        return Holder.f20301a;
    }

    public void send(RetCodeInfo retCodeInfo) {
        new Thread(new SendTask(retCodeInfo, 100)).start();
    }
}
