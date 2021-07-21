package uw.tcss305.Controller;

import uw.tcss305.Model.BigIntNum;
import uw.tcss305.Model.DecNum;
import uw.tcss305.Model.HexNum;

import java.math.BigInteger;

public class HexadecimalCalculator extends NumericCalculator implements HexadecimalConverter{

    @Override
    public HexNum Dec2Hex(DecNum number) {
        long decimalNumber = (long) Math.floor(Double.parseDouble(number.decNum));
        String result = "";
        long remainder = 0;   //store the remainder and use as the index of the hexList

        StringBuilder hexNumber = new StringBuilder();  // store the hexNumber
        char[] hexList = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        if (decimalNumber == 0){
            result = "0";
        } else if (decimalNumber > 0) {
            while (decimalNumber > 0) {
                remainder = (decimalNumber % 16);
                hexNumber.insert(0, hexList[(int) remainder]);
                decimalNumber /= 16;
            }
            result += hexNumber;
        } else {
            int posDec = (int) Math.abs(decimalNumber);
            while (posDec > 0) {
                remainder = posDec % 16;
                hexNumber.insert(0, hexList[(int) remainder]);
                posDec /= 16;
            }
            System.out.print("-");
            result += hexNumber;
        }
        return new HexNum(result);
    }

    @Override
    public DecNum Hex2Dec(HexNum number) {
        String hex = number.hexNum.toUpperCase();
        String hexList = "0123456789ABCDEF";
        long decSum = 0;
        DecNum result = new DecNum();
        if(number.hexNum.equals("Z")){
            return new DecNum("Z");
        } else {
            if (number.hexNum.equals("0")) {
                result = new DecNum(number.hexNum);
            } else if (hex.startsWith("-")) {
                hex = hex.substring(1);
                for (int i = 0; i < hex.length(); i++) {
                    char c = hex.charAt(i);
                    int dec = hexList.indexOf(c);
                    decSum = 16 * decSum + dec;
                }
                result = new DecNum("-" + decSum);
            } else {
                for (int i = 0; i < hex.length(); i++) {
                    char c = hex.charAt(i);
                    int dec = hexList.indexOf(c);
                    decSum = 16 * decSum + dec;
                }
                result = new DecNum("" + decSum);
            }
            return result;
        }
    }

    @Override
    public HexNum BigInt2Hex(BigIntNum number) {
        BigInteger bigInteger = new BigInteger(number.bigIntNum);
        String result = "";
        if (number.bigIntNum.equals("0")) {
            result = "0";
        } else {
            result += (bigInteger.toString(16)).toUpperCase();
        }
        return new HexNum(result);
    }

    @Override
    public BigIntNum Hex2BigInt(HexNum number) {
        if(number.hexNum.equals("Z")){
            return new BigIntNum("Z");
        } else {
            String result = "";
            if (number.hexNum.equals("0")) {
                result = "0";
            } else {
                BigInteger bigInt = new BigInteger(number.hexNum, 16);
                result += bigInt;
            }
            return new BigIntNum(result);
        }
    }

    public HexNum add(HexNum num1, HexNum num2){
        if(num1.hexNum.equals("Z") || num2.hexNum.equals("Z")){
            return new HexNum("Z");
        } else {
            HexadecimalCalculator hex = new HexadecimalCalculator();
            BigIntNum bigIntNum1 = hex.Hex2BigInt(num1);
            BigIntNum bigIntNum2 = hex.Hex2BigInt(num2);
            BigIntNum addBigInt = new BigIntNum();
            addBigInt = BigIntegerCalculator.add(bigIntNum1, bigIntNum2);
            HexadecimalCalculator result = new HexadecimalCalculator();
            return result.BigInt2Hex(addBigInt);
        }
    }

    public HexNum subtract(HexNum num1, HexNum num2){
        if(num1.hexNum.equals("Z") || num2.hexNum.equals("Z")){
            return new HexNum("Z");
        } else {
            HexadecimalCalculator hex = new HexadecimalCalculator();
            BigIntNum bigIntNum1 = hex.Hex2BigInt(num1);
            BigIntNum bigIntNum2 = hex.Hex2BigInt(num2);
            BigIntNum addBigInt = new BigIntNum();
            addBigInt = BigIntegerCalculator.subtract(bigIntNum1, bigIntNum2);
            HexadecimalCalculator result = new HexadecimalCalculator();
            return result.BigInt2Hex(addBigInt);
        }
    }

    public HexNum multiply(HexNum num1, HexNum num2){
        if(num1.hexNum.equals("Z") || num2.hexNum.equals("Z")){
            return new HexNum("Z");
        } else {
            HexadecimalCalculator hex = new HexadecimalCalculator();
            BigIntNum bigIntNum1 = hex.Hex2BigInt(num1);
            BigIntNum bigIntNum2 = hex.Hex2BigInt(num2);
            BigIntNum mulBigInt = new BigIntNum();
            mulBigInt = BigIntegerCalculator.multiply(bigIntNum1, bigIntNum2);
            HexadecimalCalculator result = new HexadecimalCalculator();
            return result.BigInt2Hex(mulBigInt);
        }
    }

    public HexNum divide(HexNum num1, HexNum num2){
        if(num1.hexNum.equals("Z") || num2.hexNum.equals("Z")){
            return new HexNum("Z");
        } else {
            HexadecimalCalculator hex = new HexadecimalCalculator();
            BigIntNum bigIntNum1 = hex.Hex2BigInt(num1);
            BigIntNum bigIntNum2 = hex.Hex2BigInt(num2);
            BigIntNum divBigInt = new BigIntNum();
            divBigInt = BigIntegerCalculator.divide(bigIntNum1, bigIntNum2);
            HexadecimalCalculator result = new HexadecimalCalculator();
            return result.BigInt2Hex(divBigInt);
        }
    }

    public HexNum remainder(HexNum num1, HexNum num2){
        if(num1.hexNum.equals("Z") || num2.hexNum.equals("Z")){
            return new HexNum("Z");
        } else {
            HexadecimalCalculator hex = new HexadecimalCalculator();
            BigIntNum bigIntNum1 = hex.Hex2BigInt(num1);
            BigIntNum bigIntNum2 = hex.Hex2BigInt(num2);
            BigIntNum divRemainderBigInt = new BigIntNum();
            divRemainderBigInt = BigIntegerCalculator.remainder(bigIntNum1, bigIntNum2);
            HexadecimalCalculator result = new HexadecimalCalculator();
            return result.BigInt2Hex(divRemainderBigInt);
        }
    }
}
