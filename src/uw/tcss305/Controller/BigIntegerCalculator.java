package uw.tcss305.Controller;

import uw.tcss305.Model.BigIntNum;

import java.math.BigInteger;

public class BigIntegerCalculator extends NumericCalculator{

    public static BigIntNum add(BigIntNum num1, BigIntNum num2){
        BigIntNum b = new BigIntNum();
        BigInteger bigInt1 = new BigInteger(num1.bigIntNum);
        BigInteger bigInt2 = new BigInteger(num2.bigIntNum);
        b = new BigIntNum(String.valueOf(bigInt1.add(bigInt2)));
        return b;
    }

    public static BigIntNum subtract(BigIntNum num1, BigIntNum num2){
        BigIntNum b = new BigIntNum();
        BigInteger bigInt1 = new BigInteger(num1.bigIntNum);
        BigInteger bigInt2 = new BigInteger(num2.bigIntNum);
        b = new BigIntNum(String.valueOf(bigInt1.subtract(bigInt2)));
        return b;
    }

    public static BigIntNum multiply(BigIntNum num1, BigIntNum num2){
        BigIntNum b = new BigIntNum();
        BigInteger bigInt1 = new BigInteger(num1.bigIntNum);
        BigInteger bigInt2 = new BigInteger(num2.bigIntNum);
        b = new BigIntNum(String.valueOf(bigInt1.multiply(bigInt2)));
        return b;
    }

    public static BigIntNum divide(BigIntNum num1, BigIntNum num2){
        BigIntNum b = new BigIntNum();
        BigInteger bigInt1 = new BigInteger(num1.bigIntNum);
        BigInteger bigInt2 = new BigInteger(num2.bigIntNum);
        if (num2.bigIntNum.equals("0")){
            b = new BigIntNum("-Z");
        } else {
            b = new BigIntNum(String.valueOf(bigInt1.divide(bigInt2)));
        }
        return b;
    }

    public static BigIntNum remainder(BigIntNum num1, BigIntNum num2) {
        BigIntNum b = new BigIntNum();
        BigInteger bigInt1 = new BigInteger(num1.bigIntNum);
        BigInteger bigInt2 = new BigInteger(num2.bigIntNum);
        if (num2.bigIntNum.equals("0")){
            b = new BigIntNum("-Z");
        } else {
            b = new BigIntNum(String.valueOf(bigInt1.mod(bigInt2)));
        }
        return b;
    }

}
