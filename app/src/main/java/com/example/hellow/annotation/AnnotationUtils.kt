package com.example.hellow.annotation

/*不接收参数的注解*/
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.BINARY)
annotation class MyAnnotation4

/*接受参数的注解*/
annotation class MyAnnotation2(val name : String)

/*接受多个参数的注解*/
annotation class MyAnnotation3(vararg val name : String)