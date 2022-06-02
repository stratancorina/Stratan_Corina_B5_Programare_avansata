package examples;



import annotations.Test;
import lombok.extern.java.Log;

@Log
public class SecondDemoClass {
    private static final int MAX_NUMBER = 1000;
    public static final int MIN_NUMBER = 0;

    public int subtract(int leftOperand, int rightOperand){
        int result = leftOperand - rightOperand;
        return result;
    }

    public int add(int leftOperand, int rightOperand){
        int result = leftOperand + rightOperand;
        return result;
    }

    public static int addition(int leftOperand, int rightOperand){
        int result = leftOperand + rightOperand;
        return result;
    }


    public static void printBoundaries(){
        System.out.printf("Max number is %d%n", MAX_NUMBER);
        System.out.printf("Min number is %d%n", MIN_NUMBER);
    }

    @Test
    public static void checkingTheAddition(){
        log.info("Checking the addition\n");
        assert(addition(5,6) == (5+6));
    }
}