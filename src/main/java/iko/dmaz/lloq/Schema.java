package iko.dmaz.lloq;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Schema {
    /* renamed from: a */
    String mo38797a() default "";

    /* renamed from: b */
    String mo38798b() default "";

    /* renamed from: c */
    int mo38799c() default -1;
}
