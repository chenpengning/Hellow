package com.example.hellow.annotation



@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class MyAnnotation (val name :String ="jetpack")

