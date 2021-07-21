package uw.tcss305.Test;

import org.junit.jupiter.api.Test;
import uw.tcss305.Controller.ConsoleColors;
import uw.tcss305.Controller.DecimalCalculator;
import uw.tcss305.Model.DecNum;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DecimalCalculatorTest {

    private DecNum num1 = new DecNum("6.5");
    private DecNum num2 = new DecNum("6.5");
    private DecNum addResult = new DecNum("13.0");
    private DecNum subResult = new DecNum("0.0");
    private DecNum mulResult = new DecNum("42.25");
    private DecNum divResult = new DecNum("1.0");
    private DecNum divRemainderResult = new DecNum("0");
    private DecimalCalculator test = new DecimalCalculator();

    @Test
    void add() {
        assertEquals(addResult.decNum, test.add(num1,num2).decNum);
        System.out.println("\tDecimal Calculator -- Add Function -- "
                + ConsoleColors.GREEN_BOLD + "\u2705 Pass" + ConsoleColors.RESET);
    }

    @Test
    void subtract() {
        assertEquals(subResult.decNum, test.subtract(num1,num2).decNum);
        System.out.println("\tDecimal Calculator -- Subtract Function -- "
                + ConsoleColors.GREEN_BOLD + "\u2705 Pass" + ConsoleColors.RESET);
    }

    @Test
    void multiply() {
        assertEquals(mulResult.decNum, test.multiply(num1, num2).decNum);
        System.out.println("\tDecimal Calculator -- Multiply Function -- "
                + ConsoleColors.GREEN_BOLD + "\u2705 Pass" + ConsoleColors.RESET);
    }

    @Test
    void divide() {
        assertEquals(divResult.decNum, test.divide(num1, num2).decNum);
        System.out.println("\tDecimal Calculator -- Divide Function -- "
                + ConsoleColors.GREEN_BOLD + "\u2705 Pass" + ConsoleColors.RESET);
    }

    @Test
    void remainder() {
        assertEquals(divRemainderResult.decNum, test.remainder(num1, num2).decNum);
        System.out.println("\tDecimal Calculator -- Division Remainder Function -- "
                + ConsoleColors.GREEN_BOLD + "\u2705 Pass" + ConsoleColors.RESET);
    }
}