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

    @Test
    public void testCustomDelimiter() {
        assertEquals(3, calculator.add("//;\n1;2"));
    }

    @Test
    public void testNegativeNumberThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.add("1,-2");
        });
        assertEquals("negatives not allowed: -2", exception.getMessage());
    }

    @Test
    public void testMultipleNegativesThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.add("-1,2,-3");
        });
        assertEquals("negatives not allowed: -1,-3", exception.getMessage());
    }

    @Test
    public void testNumbersGreaterThan1000() {
        assertEquals(2, calculator.add("2,1001"));
    }

    @Test
    public void testAnyLengthDelimiter() {
        assertEquals(6, calculator.add("//[***]\n1***2***3"));
    }
}