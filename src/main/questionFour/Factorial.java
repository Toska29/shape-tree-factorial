package main.questionFour;

import java.math.BigInteger;

public class Factorial {
    public static BigInteger getFactorial(int number){
        BigInteger result = BigInteger.ONE;
        for (; number > 0 ; number--) {
            result = result.multiply(BigInteger.valueOf(number));
        }

        return result;
    }

    public static void main(String[] args) {
        int number = 25;
        BigInteger result = getFactorial(number);

        System.out.println(result);
    }
}
