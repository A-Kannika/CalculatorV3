package uw.tcss305.Controller;

import uw.tcss305.Model.DecNum;

public class DecimalCalculator extends NumericCalculator{

    public DecNum add(DecNum num1, DecNum num2) {
        DecNum d;

        try {
            Long.parseLong(num1.decNum);
            Long.parseLong(num2.decNum);
            long dec1 = Long.parseLong(num1.decNum);
            long dec2 = Long.parseLong(num2.decNum);
            d = new DecNum("" + (dec1 + dec2));
        } catch (NumberFormatException e) {
            double dec1 = Double.parseDouble(num1.decNum);
            double dec2 = Double.parseDouble(num2.decNum);
            d = new DecNum("" + (dec1 + dec2));
        }
        return d;
    }

    public DecNum subtract(DecNum num1, DecNum num2){
        DecNum d;
        try {
            Long.parseLong(num1.decNum);
            Long.parseLong(num2.decNum);
            long dec1 = Long.parseLong(num1.decNum);
            long dec2 = Long.parseLong(num2.decNum);
            d = new DecNum("" + (dec1 - dec2));
        } catch (NumberFormatException e) {
            double dec1 = Double.parseDouble(num1.decNum);
            double dec2 = Double.parseDouble(num2.decNum);
            d = new DecNum("" + (dec1 - dec2));
        }
        return d;
    }

    public DecNum multiply(DecNum num1, DecNum num2){
        DecNum d;

        try {
            Long.parseLong(num1.decNum);
            Long.parseLong(num2.decNum);
            long dec1 = Long.parseLong(num1.decNum);
            long dec2 = Long.parseLong(num2.decNum);
            d = new DecNum("" + (dec1 * dec2));
        } catch (NumberFormatException e) {
            double dec1 = Double.parseDouble(num1.decNum);
            double dec2 = Double.parseDouble(num2.decNum);
            d = new DecNum("" + (dec1 * dec2));
        }
        return d;
    }

    public DecNum divide(DecNum num1, DecNum num2){
        DecNum d = new DecNum();

            try {
                Long.parseLong(num1.decNum);
                Long.parseLong(num2.decNum);
                long dec1 = Long.parseLong(num1.decNum);
                long dec2 = Long.parseLong(num2.decNum);
                d = new DecNum("" + (dec1 / dec2));
            } catch (NumberFormatException e) {
                double dec1 = Double.parseDouble(num1.decNum);
                double dec2 = Double.parseDouble(num2.decNum);
                d = new DecNum("" + (dec1 / dec2));
            }

        return d;
    }

    public DecNum remainder(DecNum num1, DecNum num2){
        DecNum d = new DecNum();
            try {
                Long.parseLong(num1.decNum);
                Long.parseLong(num2.decNum);
                long dec1 = Long.parseLong(num1.decNum);
                long dec2 = Long.parseLong(num2.decNum);
                d = new DecNum("" + (dec1 % dec2));
            } catch (NumberFormatException e) {
                double dec1 = Double.parseDouble(num1.decNum);
                double dec2 = Double.parseDouble(num2.decNum);
                d = new DecNum("0");
            }
        return d;
    }
}
