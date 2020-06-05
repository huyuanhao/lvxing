package com.ali.auth.third.core.config;

/* renamed from: com.ali.auth.third.core.config.a */
public class C0990a {
    /* renamed from: a */
    public static boolean f1902a = false;
    /* renamed from: b */
    public static final C0991b f1903b = new C0991b(2, 0, 0);
    /* renamed from: c */
    public static String f1904c = "https://login.m.taobao.com/minisdk/login.htm";
    /* renamed from: d */
    public static String f1905d = "http://login.m.taobao.com/cooperation/bindLogin.htm?code=%s&IBB=%s&appkey=%s";
    /* renamed from: e */
    public static String f1906e = "https://accountlink.taobao.com/sdkUnbind.htm";
    /* renamed from: f */
    public static String f1907f = "((https|http)://)login.m.taobao.com/login.htm(.*),((https|http)://)login.tmall.com(.*),((https|http)://)login.taobao.com/member/login.jhtml(.*)";
    /* renamed from: g */
    public static int f1908g = 0;
    /* renamed from: h */
    public static int f1909h = 0;
    /* renamed from: i */
    public static String f1910i = "";
    /* renamed from: j */
    public static String f1911j = "https://qrlogin.taobao.com/qrcodelogin/generateNoLoginQRCode.do?lt=m";
    /* renamed from: k */
    public static String f1912k = "https://login.m.taobao.com/qrcodeShow.htm?appKey=%s&from=bcqrlogin";
    /* renamed from: l */
    public static String f1913l = "http://login.waptest.taobao.com/qrcodeShow.htm?appKey=%s&from=bcqrlogin";
    /* renamed from: m */
    public static String f1914m = "https://login.m.taobao.com/qrcodeLogin.htm?shortURL=%s&from=bcqrlogin";
    /* renamed from: n */
    public static int f1915n = 0;
    /* renamed from: o */
    private static final C0990a f1916o = new C0990a();
    /* renamed from: p */
    private Environment f1917p;
    /* renamed from: q */
    private int f1918q = 3;
    /* renamed from: r */
    private boolean f1919r = true;
    /* renamed from: s */
    private int f1920s = 0;

    private C0990a() {
    }

    /* renamed from: b */
    public static C0990a m1889b() {
        return f1916o;
    }

    /* renamed from: d */
    public static int m1890d() {
        return (m1889b().mo10310a() == null || !m1889b().mo10310a().equals(Environment.TEST)) ? f1908g : f1909h;
    }

    /* renamed from: a */
    public Environment mo10310a() {
        return this.f1917p;
    }

    /* renamed from: c */
    public int mo10311c() {
        return this.f1918q;
    }

    /* renamed from: e */
    public boolean mo10312e() {
        return this.f1919r;
    }
}
