// 50. Pow(x, n)
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

public class Pow {

    static double myPow(double x, int n) {
        long nn = n;
        double ans = 1.0;

        if (nn < 0) {
            nn = -1 * nn;
        }

        while (nn > 0) {
            if (nn % 2 == 0) {
                x = x * x;
                nn /= 2;
            } else {
                ans = x * ans;
                nn = nn - 1;
            }
        }

        if (n < 0) {
            ans = (double)(1.0) / (double)(ans);
        }

        return ans;
    }

    static void test(double x, int n, double expected) {
        double result = myPow(x, n);
        boolean passed = Math.abs(result - expected) < 0.001;
        System.out.printf("myPow(%.2f, %d) => %.5f | Expected: %.5f | %s%n",
                x, n, result, expected, passed ? "PASS ✓" : "FAIL ✗");
    }

    public static void main(String[] args) {

        System.out.println("===== Pow(x, n) Test Cases =====\n");

        // Basic cases
        test(2.0,    10,   1024.0);        // 2^10
        test(2.1,     3,      9.261);      // 2.1^3
        test(2.0,    -2,      0.25);       // 2^-2 = 1/4

        // Edge cases
        test(1.0,   100,      1.0);        // 1^anything = 1
        test(0.0,     5,      0.0);        // 0^n = 0
        test(2.0,     0,      1.0);        // x^0 = 1
        test(2.0,     1,      2.0);        // x^1 = x

        // Negative exponents
        test(2.0,    -1,      0.5);        // 2^-1 = 0.5
        test(2.0,   -10,      0.0009765625); // 2^-10

        // Negative base
        test(-2.0,   3,     -8.0);         // (-2)^3 = -8  (odd power, stays negative)
        test(-2.0,   4,     16.0);         // (-2)^4 = 16  (even power, positive)

        // Large exponent
        test(1.00001, 100000, 2.71827);    // approaches e

        System.out.println("\n================================");
    }
}