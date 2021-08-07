import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private Calculator calculator;

    @Test
    public void positiveCalculation1() {
        String input = "13 2 <<";
        int expected = 13<<2;
        calculator = new Calculator(input);
        int actual = calculator.calculate();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void positiveCalculation2() {
        String input = "6 ~ 9 & 3 4 & |";
        int expected = ~6&9|(3&4);
        calculator = new Calculator(input);
        int actual = calculator.calculate();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void positiveCalculation3() {
        String input = "5 1 2 & 3 4 25 5 ^ 6 47 & | & 3 | | 2 | & 1 | |";
        int expected = 5|(1&2&(3|(4&(25^5|6&47)|3)|2)|1);
        calculator = new Calculator(input);
        int actual = calculator.calculate();
        Assertions.assertEquals(expected, actual);
    }

}
