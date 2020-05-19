package com.example.hellow.annotation

import com.fly.fox.annotation.ARouter

//返回类可访问的所有函数和属性，包括继承自基类的，但是不包括构造器
// val members: Collection<KCallable<*>>
//返回类声明的所有函数
//val KClass<*>.declaredFunctions: Collection<KFunction<*>>
//返回类的扩展函数
//val KClass<*>.declaredMemberExtensionFunctions: Collection<KFunction<*>>
//返回类的扩展属性
//val <T : Any> KClass<T>.declaredMemberExtensionProperties: Collection<KProperty2<T, *, *>>
//返回类自身声明的成员函数
//val KClass<*>.declaredMemberFunctions: Collection<KFunction<*>>
//返回类自身声明的成员变量（属性）
//val <T : Any> KClass<T>.declaredMemberProperties: Collection<KProperty1<T, *>>




//1.返回类的名字
//public val simpleName: String?
//2.返回类的全包名
//public val qualifiedName: String?
//3.如果这个类声明为object，则返回其实例，否则返回null
//public val objectInstance: T?
//4.返回类的可见性
//@SinceKotlin("1.1")
//public val visibility: KVisibility?
//5.判断类是否为final类（在Kotlin中，类默认是final的，除非这个类声明为open或者abstract)
//@SinceKotlin("1.1")
//public val isFinal: Boolean
//6.判断类是否是open的(abstract类也是open的），表示这个类可以被继承
//@SinceKotlin("1.1")
//public val isOpen: Boolean
//7.判断类是否为抽象类
//@SinceKotlin("1.1")
//public val isAbstract: Boolean
//8.判断类是否为密封类，密封类:用sealed修饰，其子类只能在其内部定义
//@SinceKotlin("1.1")
//public val isSealed: Boolean
//9.判断类是否为data类
//@SinceKotlin("1.1")
//public val isData: Boolean
//10.判断类是否为成员类
//@SinceKotlin("1.1")
//public val isInner: Boolean
//11.判断类是否为companion object
//@SinceKotlin("1.1")
//public val isCompanion: Boolean
//12.返回类中定义的其他类，包括内部类(inner class声明的)和嵌套类(class声明的)
//public val nestedClasses: Collection<KClass<*>>
//13.判断一个对象是否为此类的实例
//@SinceKotlin("1.1")
//public fun isInstance(value: Any?): Boolean
//14.返回这个类的泛型列表
//@SinceKotlin("1.1")
//public val typeParameters: List<KTypeParameter>
//15.类其直接基类的列表
//@SinceKotlin("1.1")
//public val supertypes: List<KType>
//16.返回类所有的基类
//val KClass<*>.allSuperclasses: Collection<KClass<*>>
//17.返回类的伴生对象companionObject
//val KClass<*>.companionObject: KClass<*>?



fun main(args: Array<String>) {

    //1.通过类::class的方式获取Kclass实例
    val clazz1 = TextAndroid::class.java

    val obj = clazz1.newInstance()

    clazz1.declaredMethods.forEach {
        //println("方法==${it.name}==")
        if(it.name == "play1"){
            println("方法==${it.name}==")
            it.isAccessible = true
            it.invoke(obj,"liudeha")

        }

    }



    println("============")

    clazz1.declaredFields.forEach {

        println("方法==${it.name}==${it.isAccessible}==${it.isAnnotationPresent(MyAnnotation::class.java)}")

        if(it.isAnnotationPresent(KAnnotation::class.java)){
            println("属性==${it.name}==${it.isAccessible}")

            if(it.name == "scode"){
                it.isAccessible = true
                it.set(obj,"Hellow world ....")

            }
        }



    }




    println("====${obj.scode}")






}


class TextAndroid{

    @MyAnnotation(name = "jetpack")
    var namefeil :String = "jett"

    @KAnnotation
    var age :Int = 0

    @KAnnotation
    var scode :String = "jett"

    private fun paly(){

    }

    fun play1(name:String):String{

        println("我是方法，被调用了==name$name")

        return "android ..."
    }



}