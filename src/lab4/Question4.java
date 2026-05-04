package lab4;

import java.util.Arrays;
import java.util.Comparator;

public class Question4 {

    static final String[] names   = {"a", "b", "c", "d", "e"};
    static final int[]    values  = {25, 12, 24, 16, 28};
    static final int[]    weights = {5,   6,  8,  2,  7};
    static final int      WMAX   = 20;

    public static void main(String[] args) {
        int n = names.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;

        Arrays.sort(idx, Comparator.comparingDouble((Integer i) -> (double) values[i] / weights[i]).reversed());

        System.out.printf("%-6s %-8s %-8s %-10s%n", "Item", "Value", "Weight", "Ratio");
        for (int i : idx) {
            System.out.printf("%-6s %-8d %-8d %-10.4f%n",
                names[i], values[i], weights[i], (double) values[i] / weights[i]);
        }

        double totalValue = 0;
        double remaining = WMAX;
        System.out.println();
        for (int i : idx) {
            if (remaining <= 0) break;
            double take = Math.min(weights[i], remaining);
            double gained = take * ((double) values[i] / weights[i]);
            totalValue += gained;
            remaining -= take;
            System.out.printf("Take %.2f of item %s -> value = %.4f%n", take, names[i], gained);
        }

        System.out.printf("%nMaximum value: %.4f%n", totalValue);
    }
}
