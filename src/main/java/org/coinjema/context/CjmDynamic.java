package org.coinjema.context;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value=ElementType.METHOD)
@Retention(value=RetentionPolicy.RUNTIME)
public @interface CjmDynamic {
	String type() default "";
    String method() default "";
    String alias() default "";
    String contextMethod() default "";
}
