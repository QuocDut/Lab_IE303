package BTTH1_21521842;

public class bai2 {
    //
    public static double calculateS(int n, double x) {
        double sum = 0;
        int denominator = 0;

        for (int i = 1; i <= n; i++) {
            denominator += i;
            sum += Math.pow(x, i) / denominator;
        }

        return sum;
    }

}
