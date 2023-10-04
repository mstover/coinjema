package org.coinjema.cjm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value=ElementType.METHOD)
@Retention(value=RetentionPolicy.RUNTIME)
public @interface CjmDependency {

    public static enum Order {NA,LAST};
    
    String method() default "";
    String type() default "";
    String alias() default "";
    Order order() default Order.NA;
    boolean hasDefault() default false;
}
