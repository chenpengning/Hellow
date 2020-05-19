package com.fly.fox.comilper;

import com.fly.fox.annotation.ARouter;
import com.google.auto.service.AutoService;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import java.io.IOException;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedOptions;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;

// 编译器  干活的
@AutoService(Processor.class) // 编译期 绑定 干活
@SupportedAnnotationTypes({"com.fly.fox.annotation.ARouter"}) // 监控这个注解
@SupportedSourceVersion(SourceVersion.RELEASE_7) // 必须写
@SupportedOptions("myvalue")// 接收值
public class ARouterProcessor extends AbstractProcessor {

    // 操作Element的工具类（类，函数，属性，其实都是Element）
    private Elements elementTool;

    // type(类信息)的工具类，包含用于操作TypeMirror的工具方法
    private Types typeTool;

    // Message用来打印 日志相关信息  == Log.i
    private Messager messager;  // Gradle 日志中输出

    // 文件生成器， 类 资源 等，就是最终要生成的文件 是需要Filer来完成的
    private Filer filer;

    // 做初始化工作，就相当于 Activity中的 onCreate函数一样的作用
    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);

        elementTool = processingEnvironment.getElementUtils();
        messager = processingEnvironment.getMessager();
        filer = processingEnvironment.getFiler();

        String myvalue = processingEnvironment.getOptions().get("myvalue");
        // messager.printMessage(Diagnostic.Kind.ERROR); // 注意：会报错  Log.e
        messager.printMessage(Diagnostic.Kind.NOTE, ">>>>>>>>>" + myvalue);
    }

    // 编译器 来到这个函数
    @Override // set.size = 1
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        if (set.isEmpty()) {
            messager.printMessage(Diagnostic.Kind.NOTE, "并没有发现 被@ARouter注解的地方呀");
            return false; // 我根本就没有机会处理  你还没有干活
        }

        // 获取被 ARouter注解的 "类节点信息"
        Set<? extends Element> elements = roundEnvironment.getElementsAnnotatedWith(ARouter.class);

        // 遍历所有的类节点
        for (Element element : elements) {
            // 获取类节点，获取包节点 （com.xiangxue.xxxxxx）
            String packageName = elementTool.getPackageOf(element).getQualifiedName().toString();

            // 获取简单类名，例如：MainActivity
            String className = element.getSimpleName().toString();
            messager.printMessage(Diagnostic.Kind.NOTE, "被@ARetuer注解的类有：" + className);

            // 拿注解
            ARouter aRouter = element.getAnnotation(ARouter.class);

            // JavaPoet
            /**
             * package com.example.helloworld;
             *
             * public final class HelloWorld {
             *   public static void main(String[] args) {
             *     System.out.println("Hello, JavaPoet!");
             *   }
             * }
             */
            /*// 1.方法
            MethodSpec mainMethod = MethodSpec.methodBuilder("main")
                    .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                    .returns(void.class)
                    .addParameter(String[].class, "args")
                    .addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!")
                    .build();

            // 2.类
            TypeSpec testClass = TypeSpec.classBuilder("HelloWorld")
                    .addMethod(mainMethod)
                    .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                    .build();

            // 3.包
            JavaFile packf = JavaFile.builder("com.example.helloworld", testClass).build();

            // 开始生成文件
            try {
                packf.writeTo(filer);
            } catch (IOException e) {
                e.printStackTrace();
                messager.printMessage(Diagnostic.Kind.NOTE, "HelloWorld 生成 失败...");
            }*/


            // =====================================================

            /**
             * public class MainActivity$$$$$$$$$ARouter {
             *   public static Class findTargetClass(String path) {
             *     return path.equals("app/MainActivity") ? MainActivity.class : null;
             *   }
             * }
             */

            // 定义要给类名 动态
            String finalClassName = className + "$$$$$$$$$ARouter";

            // 1.方法
            MethodSpec findTargetClass = MethodSpec.methodBuilder("findTargetClass")
                    .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                    .returns(Class.class)
                    .addParameter(String.class, "path")
                    .addStatement("return path.equals($S) ? $T.class : null" , aRouter.path(), ClassName.get((TypeElement)element)) // element == MainActivity
                    .build();

            // 2.类
            TypeSpec myClass = TypeSpec.classBuilder(finalClassName)
                    .addMethod(findTargetClass)
                    .addModifiers(Modifier.PUBLIC)
                    .build();

            // 3.包
            JavaFile packf = JavaFile.builder(packageName, myClass).build();

            // 开始生成
            try {
                packf.writeTo(filer);
            } catch (IOException e) {
                e.printStackTrace();
                messager.printMessage(Diagnostic.Kind.NOTE,  finalClassName + "创建失败");
            }
        }

        return true; // 处理完成，后续如果没有变动，service不会处理了，干的漂亮
    }
}
