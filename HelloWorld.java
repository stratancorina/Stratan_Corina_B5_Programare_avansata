//Compulsory1

import java.util.Arrays;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "Go", "PHP", "Swift", "Java"};
        System.out.println(Arrays.toString(languages));

        int n = (int) (Math.random()* 1_000_000);
        System.out.println(n);

        n = 3*n;
        System.out.println(n);
        n = n + Integer.parseInt("10101",2);
        System.out.println(n);
        n = n + Integer.parseInt("FF",16);
        System.out.println(n);
        n = n * 6;
        System.out.println(n);

        int digit;
        int sum = 0;
            while(n > 0)
            {
                digit = n % 10;
                sum = sum + digit;
                n = n / 10;
            }
            System.out.println(sum);


        int digit2;
        int result = 0;
            while(sum > 0) {
                digit2 = sum % 10;
                result = result + digit2;
                sum = sum / 10;
            }
        System.out.println(result);
        System.out.println("Willy-nilly, this semester i will learn " + languages[result]);
    }
}
