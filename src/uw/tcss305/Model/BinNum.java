package uw.tcss305.Model;

import java.math.BigInteger;

public class BinNum extends Number {

    public String binNum;

    public BinNum() {
    }

    public BinNum(String num) {

//        if (num.startsWith("-")){
//            System.out.println("The number need to contain 0 and 1 only.");
//            System.exit(0);
//        } else {
        var chars = num.toCharArray();
        try {
//                Long.parseLong(num);
            new BigInteger(num);
            if (chars.length == 0) {
                this.binNum = "0";
            } else {
                int i = chars.length - 1;
                while (i >= 0) {
                    if (!(chars[i] == '0' || chars[i] == '1')) {
                        this.binNum = "Z";
                        break;
                    } else {
                        this.binNum = num;
                    }
                    i--;
                }
            }
        } catch (NumberFormatException e) {
            this.binNum = "Z";
        }
    }

    public String getBinNum() {
        return binNum;
    }

    public void printBinNum(BinNum b) {
        System.out.println(String.valueOf(b.binNum));
    }
}
