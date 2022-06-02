import services.ClassAnalyzer;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        compulsory();
        homework();
    }
    public static void homework(){
        List<Class<?>> classList = ClassAnalyzer.exploreFolderOfClassesRecursively("target/classes/examples");
        ClassAnalyzer.compileTestMethodsFromTestClasses(classList);
        ClassAnalyzer.decompileClass(classList);
    }
    public static void compulsory(){
        Class<?> loadedClass = ClassAnalyzer.loadClassFromPath("target/classes/examples/DemoClass.class");
        ClassAnalyzer.printClassInfo(loadedClass);
        ClassAnalyzer.invokeStaticTestMethodsWithoutArguments(loadedClass);
    }
}
