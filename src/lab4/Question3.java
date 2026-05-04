package lab4;

public class Question3 {

    static final String[] names   = {"a", "b", "c", "d", "e"};
    static final int[]    values  = {25, 12, 24, 16, 28};
    static final int[]    weights = {5,   6,  8,  2,  7};
    static final int      WMAX   = 20;

    public static void main(String[] args) {
        int n = values.length;
        int[][] dp = new int[n + 1][WMAX + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= WMAX; w++) {
                dp[i][w] = dp[i - 1][w];
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
                }
            }
        }

        System.out.println("Maximum value: " + dp[n][WMAX]);

        int w = WMAX;
        System.out.print("Items selected: ");
        for (int i = n; i > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                System.out.print(names[i - 1] + " ");
                w -= weights[i - 1];
            }
        }
        System.out.println();

        System.out.printf("%-6s", "");
        for (int j = 0; j <= WMAX; j++) System.out.printf("%-4d", j);
        System.out.println();
        for (int i = 0; i <= n; i++) {
            System.out.printf("%-6s", i == 0 ? "-" : names[i - 1]);
            for (int j = 0; j <= WMAX; j++) System.out.printf("%-4d", dp[i][j]);
            System.out.println();
        }
    }
}
