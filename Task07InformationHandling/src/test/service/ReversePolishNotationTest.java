import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReversePolishNotationTest {

    private ReversePolishNotation reversePolishNotation = new ReversePolishNotation();

    @Test
    public void testPositiveParse1() {
        String input = " 13<<2";
        String expected = "13 2 <<";
        String actual = reversePolishNotation.getPolishNotation(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testPositiveParse2() {
        String input = "~6&9|(3&4)";
        String expected = "6 ~ 9 & 3 4 & |";
        String actual = reversePolishNotation.getPolishNotation(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testPositiveParse3() {
        String input = "5|(1&2&(3|(4&(25^5|6&47)|3)|2)|1)";
        String expected = "5 1 2 & 3 4 25 5 ^ 6 47 & | & 3 | | 2 | & 1 | |";
        String actual = reversePolishNotation.getPolishNotation(input);
        Assertions.assertEquals(expected, actual);
    }

}
