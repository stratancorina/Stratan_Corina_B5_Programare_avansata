package examples;


import annotations.Test;
import lombok.extern.java.Log;

@Log
public class DemoClass {
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

    public static void printBoundaries(){
        System.out.printf("Max number is %d%n", MAX_NUMBER);
        System.out.printf("Max number is %d%n", MAX_NUMBER);
    }

    @Test
    public static void checkBoundaries(){
        log.info("Checking max and min number boundaries\n");
        assert(MAX_NUMBER == 1000);
        assert(MIN_NUMBER == 0);
    }
}