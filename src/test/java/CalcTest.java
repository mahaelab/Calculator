import org.example.Calc;
import org.testng.annotations.Test;
import static org.junit.Assert.assertEquals;

public class CalcTest {
    @Test
    public void testAddition() {
        Calc calc = new Calc();
        assertEquals(5, calc.add(2, 3));
    }
}
