package com.fly.fox.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)//作用于类
@Retention(RetentionPolicy.CLASS)//编译期间
public @interface ARouter {

    String path(); // 路径详情
    String group() default "";  // order,app,personal
}
