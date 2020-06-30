package cn.fv.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) //方法注解
@Retention(RetentionPolicy.RUNTIME) //运行时可见
public @interface LogAnno {
    String operateType() default ""; //操作类型
}
