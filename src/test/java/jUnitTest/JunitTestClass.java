package jUnitTest;


import org.example.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class JunitTestClass {


    @DisplayName("test adding two numbers function")
    @RepeatedTest(value = 5)
    public void testMinusNumbers() {
        Random random = new Random();
        int a = random.nextInt(10);
        int b = random.nextInt(10);

        int result = Main.addNumbers(a,b);
        System.out.println("Number 1: " + a);
        System.out.println("Number 2: " + b);
        System.out.println("Expected: " + (a-b));
        System.out.println("Actual: " + result);

        Assertions.assertEquals((a-b), result);



    }
}
