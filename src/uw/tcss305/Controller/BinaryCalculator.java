package uw.tcss305.Controller;

import uw.tcss305.Model.BigIntNum;
import uw.tcss305.Model.BinNum;
import uw.tcss305.Model.DecNum;

import java.math.BigInteger;

public class BinaryCalculator extends NumericCalculator implements BinaryConverter{

    @Override
    public BinNum Dec2Bin(DecNum number) {
        String result = "";
        StringBuilder binary = new StringBuilder();
        if (Double.parseDouble(String.valueOf(number.decNum)) == 0){
            result += binary.insert(0, "0");
        } else {
            long decimalNumber = (long) Math.floor(Double.parseDouble(String.valueOf(number.decNum)));
            if (decimalNumber > 0) {
                while (decimalNumber > 0) {
                    if (decimalNumber % 2 == 0) {
                        binary.insert(0, "0");
                    } else {
                        binary.insert(0, "1");
                    }
                    decimalNumber /= 2;
                }
                result += binary;
            } else {
                while (decimalNumber < 0) {
                    if (decimalNumber % 2 == 0) {
                        binary.insert(0, "0");
                    } else {
                        binary.insert(0, "1");
                    }
                    decimalNumber /= 2;
                }
                result += binary;
            }
        }
        return new BinNum(result);
    }

    @Override
    public DecNum Bin2Dec(BinNum number) {
        DecNum result = new DecNum();
        long decNum = 0;
        if (number.binNum.equals("Z")){
            result = new DecNum("Z");
        } else if (number.binNum.equals("0")) {
            result = new DecNum(number.binNum);
        } else {
            long binaryNumber = Long.parseLong(number.binNum);
            for (int i = 0; i < number.binNum.length(); i++) {
                long base = binaryNumber % 10;
                long pow = (long) Math.pow(2, i);
                decNum += base * pow;
                binaryNumber /= 10;
            }
            result = new DecNum("" + decNum);
        }
        return result;
    }

    @Override
    public BinNum BigInt2Bin(BigIntNum number) {
        BinNum result = new BinNum();
        String binary = "";
        if (number.bigIntNum.equals("-Z")){
            result = new BinNum("-Z");
        } else if (number.bigIntNum.equals("0")) {
            result = new BinNum("0");
        } else {
            BigInteger bigInteger = new BigInteger(number.bigIntNum);
            if (number.bigIntNum.startsWith("-")){
                bigInteger = bigInteger.abs();
                binary = bigInteger.toString(2);
                System.out.print("-");
            } else {
                binary += bigInteger.toString(2);
            }
            result = new BinNum(binary);
        }
        return result;
    }

    @Override
    public BigIntNum Bin2BigInt(BinNum number) {
        BigIntNum result = new BigIntNum();
        BigInteger bigInteger = new BigInteger("0");
        if (number.binNum.equals("0")) {
            result = new BigIntNum("0") ;
        } else {
            bigInteger = new BigInteger(number.binNum, 2);
            result = new BigIntNum("" + bigInteger);
        }
        return result;
    }

    public BinNum add(BinNum num1, BinNum num2){
        if(num1.binNum.equals("Z") || num2.binNum.equals("Z")){
            return new BinNum("Z");
        } else {
            BinaryCalculator bi = new BinaryCalculator();
            BigIntNum bigIntNum1 = bi.Bin2BigInt(num1);
            BigIntNum bigIntNum2 = bi.Bin2BigInt(num2);
            BigIntNum addBigInt = new BigIntNum();
            addBigInt = BigIntegerCalculator.add(bigIntNum1, bigIntNum2);
            BinaryCalculator result = new BinaryCalculator();
            return result.BigInt2Bin(addBigInt);
        }
    }

    public BinNum subtract(BinNum num1, BinNum num2) {
        if(num1.binNum.equals("Z") || num2.binNum.equals("Z")){
            return new BinNum("Z");
        } else {
            BinaryCalculator bi = new BinaryCalculator();
            BigIntNum bigIntNum1 = bi.Bin2BigInt(num1);
            BigIntNum bigIntNum2 = bi.Bin2BigInt(num2);
            BigIntNum subBigInt = new BigIntNum();
            subBigInt = BigIntegerCalculator.subtract(bigIntNum1, bigIntNum2);
            if (String.valueOf(subBigInt.bigIntNum).startsWith("-")) {
                subBigInt = new BigIntNum(subBigInt.bigIntNum.substring(1));
                System.out.print("-");
            }
            BinaryCalculator result = new BinaryCalculator();
            return result.BigInt2Bin(subBigInt);
        }
    }

    public BinNum multiply(BinNum num1, BinNum num2) {
        if(num1.binNum.equals("Z") || num2.binNum.equals("Z")){
            return new BinNum("Z");
        } else {
            BinaryCalculator bi = new BinaryCalculator();
            BigIntNum bigIntNum1 = bi.Bin2BigInt(num1);
            BigIntNum bigIntNum2 = bi.Bin2BigInt(num2);
            BigIntNum mulBigInt = new BigIntNum();
            mulBigInt = BigIntegerCalculator.multiply(bigIntNum1, bigIntNum2);
            BinaryCalculator result = new BinaryCalculator();
            return result.BigInt2Bin(mulBigInt);
        }
    }

    public BinNum divide(BinNum num1, BinNum num2) {
        if(num1.binNum.equals("Z") || num2.binNum.equals("Z")){
            return new BinNum("Z");
        } else {
            BinaryCalculator bi = new BinaryCalculator();
            BigIntNum bigIntNum1 = bi.Bin2BigInt(num1);
            BigIntNum bigIntNum2 = bi.Bin2BigInt(num2);
            BigIntNum divBigInt = new BigIntNum();
            divBigInt = BigIntegerCalculator.divide(bigIntNum1, bigIntNum2);
            if (divBigInt.bigIntNum.equals("-Z")){
                divBigInt = new BigIntNum("-Z");
            }
            BinaryCalculator result = new BinaryCalculator();
            return result.BigInt2Bin(divBigInt);
        }
    }

    public BinNum remainder(BinNum num1, BinNum num2) {
        if(num1.binNum.equals("Z") || num2.binNum.equals("Z")){
            return new BinNum("Z");
        } else {
            BinaryCalculator bi = new BinaryCalculator();
            BigIntNum bigIntNum1 = bi.Bin2BigInt(num1);
            BigIntNum bigIntNum2 = bi.Bin2BigInt(num2);
            BigIntNum divRemainderBigInt = new BigIntNum();
            divRemainderBigInt = BigIntegerCalculator.remainder(bigIntNum1, bigIntNum2);
            if (divRemainderBigInt.bigIntNum.equals("-Z")){
                divRemainderBigInt = new BigIntNum("-Z");
            }
            BinaryCalculator result = new BinaryCalculator();
            return result.BigInt2Bin(divRemainderBigInt);
        }
    }
}
