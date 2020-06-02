package labs.lab1;

public class PrimeNumberUtils {
    public static int findPrimeNumberWithMaximumBitCount(int n) {
        int ret = 0;
        for (int x = 2; x < n; x++) {
            if (isPrime(x) && Integer.bitCount(x) > Integer.bitCount(ret)) {
                ret = x;
            }
        }
        return ret;
    }

    public static boolean isPrime(int x) {
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
