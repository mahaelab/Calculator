import org.example.Calc;
import org.testng.annotations.Test;
import static org.junit.Assert.assertEquals;

public class CalcTest {
    @Test
    public void testAddition() {
        Calc calc = new Calc();
        assertEquals(5, calc.add(2, 3));
    }

    @Test
    public void testSubtraction() {
        Calc calc = new Calc();
        assertEquals(1, calc.subtract(5, 4));
    }

    @Test
    public void testMultiplication() {
        Calc calc = new Calc();
        assertEquals(6, calc.multiply(2, 3));
    }

    @Test
    public void testDivision() {
        Calc calc = new Calc();
        assertEquals(2.0, calc.divide(6, 3), 0.001);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivisionByZero() {
        Calc calc = new Calc();
        calc.divide(5, 0); // Should throw ArithmeticException
    }
}
