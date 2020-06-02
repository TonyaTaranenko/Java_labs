package labs.lab1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PrimeNumberUtilsTest {
    @Test
    void testFindPrimeNumberWithMaximumBitCount() {
        assertEquals(7, PrimeNumberUtils.findPrimeNumberWithMaximumBitCount(10));
        assertEquals(7, PrimeNumberUtils.findPrimeNumberWithMaximumBitCount(20));
        assertEquals(23, PrimeNumberUtils.findPrimeNumberWithMaximumBitCount(30));
        assertEquals(31, PrimeNumberUtils.findPrimeNumberWithMaximumBitCount(40));
        assertTrue(PrimeNumberUtils.isPrime(PrimeNumberUtils.findPrimeNumberWithMaximumBitCount(100)));
    }
}
