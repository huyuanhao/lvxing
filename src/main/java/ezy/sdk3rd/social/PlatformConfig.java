package ezy.sdk3rd.social;

import ezy.sdk3rd.social.platforms.alipay.Alipay;
import ezy.sdk3rd.social.platforms.send.SendShare;
import ezy.sdk3rd.social.platforms.weixin.WXAuth;
import ezy.sdk3rd.social.platforms.weixin.WXPayment;
import ezy.sdk3rd.social.platforms.weixin.WXShare;

/* renamed from: ezy.sdk3rd.social.c */
public class PlatformConfig {
    /* renamed from: a */
    public static void m34816a(String str) {
        AuthorizeSDK.m34813a("weixin", str, WXAuth.class);
        ShareSDK.m34818a("wxsession", str, WXShare.class);
        ShareSDK.m34818a("wxtimeline", str, WXShare.class);
        ShareSDK.m34818a("wxfavorite", str, WXShare.class);
        String str2 = "";
        ShareSDK.m34818a("towxsession", str2, SendShare.class);
        ShareSDK.m34818a("towxtimeline", str2, SendShare.class);
    }

    /* renamed from: a */
    public static void m34815a() {
        PaymentSDK.m34814a("wxpay", WXPayment.class);
        PaymentSDK.m34814a("alipay", Alipay.class);
    }
}
