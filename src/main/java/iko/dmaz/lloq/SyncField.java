package iko.dmaz.lloq;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SyncField {
    /* renamed from: a */
    boolean mo38800a() default false;

    /* renamed from: b */
    int mo38801b() default -1;
}
