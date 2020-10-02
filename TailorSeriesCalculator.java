import java.util.Scanner;

public class TailorSeriesCalculator {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Enter k: ");
            int k = in.nextInt();
            if (k < 0) {
                throw new Exception("Error: k should be more than zero!");
            }
            System.out.println("Enter x (-1, 1): ");
            double x = in.nextDouble();
            if (x <= -1 || x >= 1) {
                throw new Exception("Error: x is out of range!");
            }

            double eps = Math.pow(10, -k);
            double actualSum = getActualSum(x);
            double calculatedSum = getTailorSum(eps, x);

            System.out.printf("Actual sum is: %.3f\n", actualSum);
            System.out.printf("Calculated sum is: %.3f\n", calculatedSum);

        } catch (Exception ex) {
            System.out.println("Range error: " + ex);
        }
    }

    static double getActualSum(double x) {
        return Math.atan(x);
    }

    static double getTailorSum(double eps, double x) {
        double elem = 100;
        double calculatedSum = 0;
        int n = 1;
        while (Math.abs(elem) >= Math.abs(eps)) {
            elem = Math.pow(-1, n - 1) * Math.pow(x, n) / n;
            calculatedSum += elem;
            n++;
        }
        return calculatedSum;
    }
}
