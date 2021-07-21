package uw.tcss305.Test;

import org.junit.jupiter.api.Test;
import uw.tcss305.Controller.ConsoleColors;
import uw.tcss305.Controller.HexadecimalCalculator;
import uw.tcss305.Model.BigIntNum;
import uw.tcss305.Model.DecNum;
import uw.tcss305.Model.HexNum;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HexadecimalCalculatorTest {

    private final HexNum num1 = new HexNum("8AB");
    private final HexNum num2 = new HexNum("B78");
    private final HexNum num3 = new HexNum("DAD");
    private final DecNum decNum = new DecNum("170");
    private final DecNum decNum1 = new DecNum("-170");
    private final BigIntNum bigIntNum = new BigIntNum("170");
    private final BigIntNum bigIntNum2 = new BigIntNum("-170");
    private final HexadecimalCalculator test = new HexadecimalCalculator();
    private final HexNum convResult1 = new HexNum("AA");
    private final DecNum convResult2 = new DecNum("3501");
    private final BigIntNum convResult3 = new BigIntNum("3501");
    private final HexNum addResult = new HexNum("1423");
    private final HexNum subResult = new HexNum("-2CD");
    private final HexNum mulResult = new HexNum("636928");
    private final HexNum divResult = new HexNum("0");
    private final HexNum divRemainderResult = new HexNum("8AB");

    @Test
    void dec2Hex() {
        assertEquals(convResult1.hexNum, test.Dec2Hex(decNum).hexNum);
        System.out.println("\tHexadecimal Calculator -- Convert Decimal to Hexadecimal Function -- "
                + ConsoleColors.GREEN_BOLD + "\u2705 Pass" + ConsoleColors.RESET);
    }

    @Test
    void hex2Dec() {
        assertEquals(convResult2.decNum, test.Hex2Dec(num3).decNum);
        System.out.println("\tHexadecimal Calculator -- Convert Hexadecimal to Decimal Function -- "
                + ConsoleColors.GREEN_BOLD + "\u2705 Pass" + ConsoleColors.RESET);
    }

    @Test
    void bigInt2Hex() {
        assertEquals(convResult1.hexNum, test.BigInt2Hex(bigIntNum).hexNum);
        System.out.println("\tHexadecimal Calculator -- Convert Big Integer to Hexadecimal Function -- "
                + ConsoleColors.GREEN_BOLD + "\u2705 Pass" + ConsoleColors.RESET);
    }

    @Test
    void hex2BigInt() {
        assertEquals(convResult3.bigIntNum, test.Hex2BigInt(num3).bigIntNum);
        System.out.println("\tHexadecimal Calculator -- Convert Hexadecimal to Bit Integer Function -- "
                + ConsoleColors.GREEN_BOLD + "\u2705 Pass" + ConsoleColors.RESET);
    }

    @Test
    void add() {
        assertEquals(addResult.hexNum, test.add(num1, num2).hexNum);
        System.out.println("\tHexadecimal Calculator -- Add Function -- "
                + ConsoleColors.GREEN_BOLD + "\u2705 Pass" + ConsoleColors.RESET);
    }

    @Test
    void subtract() {
        assertEquals(subResult.hexNum, test.subtract(num1,num2).hexNum);
        System.out.println("\tHexadecimal Calculator -- Subtract Function -- "
                + ConsoleColors.GREEN_BOLD + "\u2705 Pass" + ConsoleColors.RESET);
    }

    @Test
    void multiply() {
        assertEquals(mulResult.hexNum, test.multiply(num1, num2).hexNum);
        System.out.println("\tHexadecimal Calculator -- Multiply Function -- "
                + ConsoleColors.GREEN_BOLD + "\u2705 Pass" + ConsoleColors.RESET);
    }

    @Test
    void divide() {
        assertEquals(divResult.hexNum, test.divide(num1, num2).hexNum);
        System.out.println("\tHexadecimal Calculator -- Divide Function -- "
                + ConsoleColors.GREEN_BOLD + "\u2705 Pass" + ConsoleColors.RESET);
    }

    @Test
    void remainder() {
        assertEquals(divRemainderResult.hexNum, test.remainder(num1, num2).hexNum);
        System.out.println("\tHexadecimal Calculator -- Division Remainder Function -- "
                + ConsoleColors.GREEN_BOLD + "\u2705 Pass" + ConsoleColors.RESET);
    }
}