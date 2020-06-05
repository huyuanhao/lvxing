package ezy.sdk3rd.social.sdk;

import android.app.Activity;
import ezy.sdk3rd.social.sdk.IResult;
import java.lang.reflect.Constructor;

/* renamed from: ezy.sdk3rd.social.sdk.b */
public class DefaultFactory<T extends IResult> implements IFactory<T> {
    /* renamed from: a */
    final Platform f27297a;
    /* renamed from: b */
    final Class<T> f27298b;

    public DefaultFactory(String str, String str2, Class<T> cls) {
        this.f27297a = new Platform(str, str2);
        this.f27298b = cls;
    }

    /* renamed from: a */
    public T mo38618a(Activity activity) {
        try {
            Constructor declaredConstructor = this.f27298b.getDeclaredConstructor(new Class[]{Activity.class, Platform.class});
            declaredConstructor.setAccessible(true);
            return (IResult) declaredConstructor.newInstance(new Object[]{activity, this.f27297a});
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
