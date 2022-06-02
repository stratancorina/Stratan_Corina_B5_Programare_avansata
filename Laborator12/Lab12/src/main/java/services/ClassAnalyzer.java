package services;

import annotations.Test;
import examples.DemoClass;
import lombok.extern.java.Log;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Log
public class ClassAnalyzer {

    public static Class<?> loadClassFromPath(String path) {
        try {
            File parentFolderPath = new File(new File(path).getParent());
            URL parentFolderUrl = parentFolderPath.toURI().toURL();
            URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{
                    parentFolderUrl
            });
            String classParentFolderName = parentFolderPath.getName();
            String classFileName = new File(path).getName();
            classFileName = classFileName.substring(0, classFileName.indexOf('.'));
            return urlClassLoader.loadClass(classParentFolderName + "." + classFileName);
        } catch (MalformedURLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void printClassInfo(Class<?> clazz) {
        log.info(String.format("Methods for class %s are:", clazz.getName()));
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            log.info(String.valueOf(method));
        }
    }

    public static void invokeStaticTestMethodsWithoutArguments(Class<?> clazz) {
        for (Method method : clazz.getMethods()) {
            if (method.isAnnotationPresent(Test.class) && Modifier.isStatic(method.getModifiers()) && method.getParameterCount() == 0) {
                log.info(String.format("Executing method %s from class %s", method.getName(), clazz.getName()));
                try {
                    method.invoke(null);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static List<Class<?>> exploreFolderOfClassesRecursively(String folderName){
        List<Path> listOfFiles;
        try {
            listOfFiles = Files.find(Paths.get(folderName),
                            Integer.MAX_VALUE,
                            (filePath, fileAttr) -> fileAttr.isRegularFile())
                    .toList();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<Class<?>> classList = new ArrayList<>();
        for(Path path : listOfFiles){
            System.out.println(path.toString());
            Class<?> clazz = Objects.requireNonNull(loadClassFromPath(path.toString()));
            printClassInfo(clazz);
            invokeStaticTestMethodsWithoutArguments(clazz);
            classList.add(clazz);
        }
        return classList;
    }

    public static void compileTestMethodsFromTestClasses(List<Class<?>> classList) {
        int totalNumberOfRuns = 0, successCases = 0;
        for (var currentClass : classList) {
            Annotation[] classAnnotations = currentClass.getAnnotations();
            for (Annotation classAnnotation : classAnnotations) {
                if (classAnnotation.annotationType().equals(Test.class)) {
                    System.out.println("Class Annotation: " + classAnnotation.annotationType());
                }
            }
            List<Method> methodList = List.of(currentClass.getMethods());
            for (Method method : methodList) {
                Annotation[] methodAnnotations = method.getDeclaredAnnotations();
                for (Annotation methodAnnotation : methodAnnotations) {
                    if (methodAnnotation.annotationType().equals(Test.class)) {
                        totalNumberOfRuns++;
                        try {
                            method.invoke(new Object[]{null});
                            successCases++;
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
        System.out.println("Success cases: " + successCases + " out of " + totalNumberOfRuns);
    }

    public static void decompileClass(List<Class<?>> classList){
        System.out.println();
        for (var currentClass : classList) {
            List<Method> methodList = List.of(currentClass.getMethods());
            System.out.println("Decompiled from " + currentClass.getName());
            for (Method method : methodList) {
                System.out.println(method.getReturnType() + " " + method.getName());
                System.out.print("(");
                for(var parameter : method.getParameterTypes()){
                    System.out.print(parameter+",");
                }
                System.out.print(")");
            }
        }
    }
}
