package uw.tcss305.Test;

import org.junit.jupiter.api.Test;
import uw.tcss305.Controller.BigIntegerCalculator;
import uw.tcss305.Controller.ConsoleColors;
import uw.tcss305.Model.BigIntNum;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BigIntegerCalculatorTest {

    private BigIntNum num1 = new BigIntNum("6");
    private BigIntNum num2 = new BigIntNum("6");
    private BigIntNum addResult = new BigIntNum("12");
    private BigIntNum subResult = new BigIntNum("0");
    private BigIntNum mulResult = new BigIntNum("36");
    private BigIntNum divResult = new BigIntNum("1");
    private BigIntNum divRemainderResult = new BigIntNum("0");

    @Test
    void add() {
        assertEquals(addResult.bigIntNum, BigIntegerCalculator.add(num1,num2).bigIntNum);
        System.out.println("\tBig Integer Calculator -- Add Function -- "
                + ConsoleColors.GREEN_BOLD + "\u2705 Pass" + ConsoleColors.RESET);
    }

    @Test
    void subtract() {
        assertEquals(subResult.bigIntNum, BigIntegerCalculator.subtract(num1,num2).bigIntNum);
        System.out.println("\tBig Integer Calculator -- Subtract Function -- "
                + ConsoleColors.GREEN_BOLD + "\u2705 Pass" + ConsoleColors.RESET);
    }

    @Test
    void multiply() {
        assertEquals(mulResult.bigIntNum, BigIntegerCalculator.multiply(num1,num2).bigIntNum);
        System.out.println("\tBig Integer Calculator -- Multiply Function -- "
                + ConsoleColors.GREEN_BOLD + "\u2705 Pass" + ConsoleColors.RESET);
    }


    @Test
    void divide() {
        assertEquals(divResult.bigIntNum, BigIntegerCalculator.divide(num1,num2).bigIntNum);
        System.out.println("\tBig Integer Calculator -- Divide Function -- "
                + ConsoleColors.GREEN_BOLD + "\u2705 Pass" + ConsoleColors.RESET);
    }

    @Test
    void remainder() {
        assertEquals(divRemainderResult.bigIntNum, BigIntegerCalculator.remainder(num1,num2).bigIntNum);
        System.out.println("\tBig Integer Calculator -- Division Remainder Function -- "
                + ConsoleColors.GREEN_BOLD + "\u2705 Pass" + ConsoleColors.RESET);
    }
}