import com.example.FactorialCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigInteger;
import java.util.List;

public class FactorialCalculatorTest
{

    @Test
    public void testCalculateFactorials()
    {
        FactorialCalculator calculator = new FactorialCalculator();

        List<BigInteger> result = calculator.calculateFactorials(5);
        assertNotNull(result);
        assertEquals(5, result.size());

        assertEquals(BigInteger.valueOf(1), result.get(0));
        assertEquals(BigInteger.valueOf(2), result.get(1));
        assertEquals(BigInteger.valueOf(6), result.get(2));
        assertEquals(BigInteger.valueOf(24), result.get(3));
        assertEquals(BigInteger.valueOf(120), result.get(4));
    }

    @Test
    public void testCalculateFactorialsInvalidInput()
    {
        FactorialCalculator calculator = new FactorialCalculator();

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
        {
            calculator.calculateFactorials(0);
        });

        String expectedMessage = "Input must be a natural number greater than zero.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testCalculateFactorialsLargeInput()
    {
        FactorialCalculator calculator = new FactorialCalculator();

        List<BigInteger> result = calculator.calculateFactorials(20);
        assertNotNull(result);
        assertEquals(20, result.size());

        assertEquals(new BigInteger("2432902008176640000"), result.get(19));
    }
}
