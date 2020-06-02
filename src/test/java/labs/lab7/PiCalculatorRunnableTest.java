package labs.lab7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PiCalculatorRunnableTest {
    @Test
    void testCalculatePi() throws Exception {
        double result = PiCalculatorRunnable.calculatePi(8, 500_000_000);
        assertEquals(Math.PI, result, 0.01);
    }
}
