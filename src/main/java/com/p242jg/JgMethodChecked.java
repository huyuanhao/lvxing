package com.p242jg;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.CLASS)
/* renamed from: com.jg.JgMethodChecked */
public @interface JgMethodChecked {
    int author();

    String fComment();

    String lastDate();

    int level() default 1;

    int reviewer();

    EType[] vComment();
}
