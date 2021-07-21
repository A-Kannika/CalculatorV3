package uw.tcss305.Test;

import org.junit.jupiter.api.Test;
import uw.tcss305.Controller.BinaryCalculator;
import uw.tcss305.Controller.ConsoleColors;
import uw.tcss305.Model.BigIntNum;
import uw.tcss305.Model.BinNum;
import uw.tcss305.Model.DecNum;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryCalculatorTest{

    private final BinNum num1 = new BinNum("10101010");
    private final BinNum num2 = new BinNum("11001100");
    private final DecNum decNum = new DecNum("170");
    private final BigIntNum bigIntNum = new BigIntNum("170");
    private final BinaryCalculator test = new BinaryCalculator();
    private final BinNum addResult = new BinNum("101110110");
    private final BinNum subResult = new BinNum("100010");
    private final BinNum mulResult = new BinNum("1000011101111000");
    private final BinNum divResult = new BinNum("0");
    private final BinNum divRemainderResult = new BinNum("10101010");

    @Test
    void dec2Bin() {
        assertEquals(num1.binNum, test.Dec2Bin(decNum).binNum);
        System.out.println("\tBinary Calculator -- Convert Decimal to Binary Function -- "
                + ConsoleColors.GREEN_BOLD + "\u2705 Pass" + ConsoleColors.RESET);
    }

    @Test
    void bin2Dec() {
        assertEquals(decNum.decNum, test.Bin2Dec(num1).decNum);
        System.out.println("\tBinary Calculator -- Convert Binary to Decimal Function -- "
                + ConsoleColors.GREEN_BOLD + "\u2705 Pass" + ConsoleColors.RESET);
    }

    @Test
    void bigInt2Bin() {
        assertEquals(num1.binNum, test.BigInt2Bin(bigIntNum).binNum);
        System.out.println("\tBinary Calculator -- Convert Big Integer to Binary Function -- "
                + ConsoleColors.GREEN_BOLD + "\u2705 Pass" + ConsoleColors.RESET);
    }

    @Test
    void bin2BigInt() {
        assertEquals(bigIntNum.bigIntNum, test.Bin2BigInt(num1).bigIntNum);
        System.out.println("\tBinary Calculator -- Convert Binary to Big Integer Function -- "
                + ConsoleColors.GREEN_BOLD + "\u2705 Pass" + ConsoleColors.RESET);
    }

    @Test
    void add() {
        assertEquals(addResult.binNum, test.add(num1,num2).binNum);
        System.out.println("\tBinary Calculator -- Add Function -- "
                + ConsoleColors.GREEN_BOLD + "\u2705 Pass" + ConsoleColors.RESET);
    }

    @Test
    void subtract() {
        assertEquals(subResult.binNum, test.subtract(num2, num1).binNum);
        System.out.println("\tBinary Calculator -- Subtract Function -- "
                + ConsoleColors.GREEN_BOLD + "\u2705 Pass" + ConsoleColors.RESET);
    }

    @Test
    void multiply() {
        assertEquals(mulResult.binNum, test.multiply(num1, num2).binNum);
        System.out.println("\tBinary Calculator -- Multiply Function -- "
                + ConsoleColors.GREEN_BOLD + "\u2705 Pass" + ConsoleColors.RESET);
    }

    @Test
    void divide() {
        assertEquals(divResult.binNum, test.divide(num1, num2).binNum);
        System.out.println("\tBinary Calculator -- Divide Function -- "
                + ConsoleColors.GREEN_BOLD + "\u2705 Pass" + ConsoleColors.RESET);
    }

    @Test
    void remainder() {
        assertEquals(divRemainderResult.binNum, test.remainder(num1, num2).binNum);
        System.out.println("\tBinary Calculator -- Division Remainder Function -- "
                + ConsoleColors.GREEN_BOLD + "\u2705 Pass" + ConsoleColors.RESET);
    }
}