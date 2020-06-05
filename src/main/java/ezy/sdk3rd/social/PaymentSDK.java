package ezy.sdk3rd.social;

import ezy.sdk3rd.social.payment.IPayable;
import ezy.sdk3rd.social.sdk.C8036h;

/* renamed from: ezy.sdk3rd.social.b */
public class PaymentSDK {
    /* renamed from: a */
    static C8036h<IPayable> f27276a = new C8036h<>();

    /* renamed from: a */
    public static <T extends IPayable> void m34814a(String str, Class<T> cls) {
        f27276a.mo38621a(str, "", cls);
    }
}
