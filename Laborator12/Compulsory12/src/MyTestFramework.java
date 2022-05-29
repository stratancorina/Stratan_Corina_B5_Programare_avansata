import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Scanner;

public class MyTestFramework {
    public static void main(String[] args) throws Exception {
        int passed = 0, failed = 0;

        //read input
        Scanner sc = new Scanner(System.in);
        String projectURL = sc.nextLine();//get URL to project/jar
        String className = sc.nextLine();//get name for class

        com.company.MyClassLoader myLoader = new com.company.MyClassLoader();
        File path = new File(projectURL);
        if (path.exists()) {
            URL url = path.toURI().toURL();
            myLoader.addURL(url);//add URL to CLASSPATH
        }

        //load class
        Class newClass = myLoader.loadClass(className);
        System.out.println(newClass.getPackage());
        //check if class is an interface
        if (newClass.isInterface()) {
            System.out.println("This is an interface");
        } else {
            System.out.println("This is NOT an interface");
        }

        //get all class fields
        System.out.println("\nFields:");
        for (Field field : newClass.getDeclaredFields()) {
            System.out.println(field);
        }
        //get all class methods
        System.out.println("\nMethods:");
        for (Method method : newClass.getMethods()) {
            System.out.println(method);
        }

        System.out.println("\nExecuting Tests:");
        for (Method m : newClass.getMethods()) {
            //if class has Test annotation
            //execute test
            if (m.isAnnotationPresent(com.company.Test.class)) {
                // System.out.println(1);
                try {
                    m.invoke(null);
                    passed++;
                } catch (Throwable ex) {
                    System.out.printf("Test %s failed: %s %n",
                            m, ex.getCause());
                    failed++;
                }
            }
        }
        System.out.printf("Passed: %d, Failed %d%n", passed, failed);
    }
}