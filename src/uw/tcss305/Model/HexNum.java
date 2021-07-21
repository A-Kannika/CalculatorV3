package uw.tcss305.Model;

public class HexNum extends Number{

    public String hexNum;

    public HexNum(){
    }

    public HexNum(String num){
        String input = num.toUpperCase();
        if (input.startsWith("-")){
            input = input.substring(1);
        }
        try {
            if (input.equals("")) {
                this.hexNum = "0";
            } else {
                int i = input.length() - 1;
                while (i >= 0) {
                    var c = input.charAt(i);
                    if (!(c >= '0' && c <= '9' || c >= 'A' && c <= 'F')) {
                        this.hexNum = "Z";
                        break;
                    } else {
                        this.hexNum = num;
                    }
                    i--;
                }
            }
        } catch (NumberFormatException e) {
            this.hexNum = "Z";
        }
    }

    public String getHexNum() {
        return hexNum;
    }

    public void printHexNum(HexNum h){
        System.out.println(h.hexNum);
    }
}
