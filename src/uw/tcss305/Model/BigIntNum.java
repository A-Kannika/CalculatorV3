package uw.tcss305.Model;

import java.math.BigInteger;

public class BigIntNum extends Number{

    public String bigIntNum;

    public BigIntNum() { }

    public BigIntNum(String num) {
        try {
            this.bigIntNum = "" + new BigInteger(num);
        } catch (NumberFormatException e) {
            this.bigIntNum = "Z";
        }
    }

    public String getBigIntNum() {
        return bigIntNum;
    }

    public void printBigInt(BigIntNum b){
            System.out.println(b.bigIntNum);
    }

}
