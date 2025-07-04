import org.example.StringCalculator;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringCalculatorTest {

    StringCalculator calculator = new StringCalculator();

    @Test
    public void testEmptyStringReturnsZero() {
        assertEquals(0, calculator.add(""));
    }

    @Test
    public void testSingleNumber() {
        assertEquals(1, calculator.add("1"));
    }

    @Test
    public void testTwoNumbers() {
        assertEquals(6, calculator.add("1,5"));
    }

    @Test
    public void testMultipleNumbers() {
        assertEquals(15, calculator.add("1,2,3,4,5"));
    }

    @Test
    public void testNewlineAsDelimiter() {
        assertEquals(6, calculator.add("1\n2,3"));
    }


}
