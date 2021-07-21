package uw.tcss305.Model;

import java.math.BigInteger;

public class DecNum extends Number {

    public String decNum;

    public DecNum() {

    }

    public DecNum(String num) {
        try {
            new BigInteger(num);
            this.decNum = num;
        } catch (NumberFormatException e) {
            try{
                Double.parseDouble(num);
                this.decNum = num;
            } catch (NumberFormatException exception) {
                this.decNum = "Z";
            }
        }
    }

    public String getDecNum() {
        return decNum;
    }

    public void printDecNum(DecNum d) {
        System.out.println(d.decNum);
    }
}
