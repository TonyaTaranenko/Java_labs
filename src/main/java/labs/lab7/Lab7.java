package labs.lab7;

public class Lab7 {
    public static void main(String[] args) throws Exception {
        int nThreads = 8;
        int nPoints = 1000000000;

        long start = System.currentTimeMillis();
        double result = PiCalculatorRunnable.calculatePi(nThreads, nPoints);
        long time = System.currentTimeMillis() - start;

        System.out.println("PI is " + result);
        System.out.println("THREADS " + nThreads);
        System.out.println("ITERATIONS " + nPoints);
        System.out.println("TIME " + time + "ms");
    }
}
