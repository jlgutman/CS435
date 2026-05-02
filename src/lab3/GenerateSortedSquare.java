package lab3;

public class GenerateSortedSquare {

    // M1: fill row by row with consecutive integers starting at 'start'
    public static int[][] generateM1(int n, int start) {
        int[][] M = new int[n][n];
        int val = start;
        for (int r = 0; r < n; r++)
            for (int c = 0; c < n; c++)
                M[r][c] = val++;
        return M;
    }

    // M2: fill in anti-diagonal zigzag order (even diagonals go down, odd go up)
    public static int[][] generateM2(int n, int start) {
        int[][] M = new int[n][n];
        int val = start;
        for (int d = 0; d <= 2 * n - 2; d++) {
            if (d % 2 == 0) {
                int r = Math.max(0, d - n + 1);
                int c = Math.min(d, n - 1);
                while (r < n && c >= 0) {
                    M[r][c] = val++;
                    r++;
                    c--;
                }
            } else {
                int r = Math.min(d, n - 1);
                int c = Math.max(0, d - n + 1);
                while (r >= 0 && c < n) {
                    M[r][c] = val++;
                    r--;
                    c++;
                }
            }
        }
        return M;
    }

    // M3: fill column by column with consecutive integers starting at 'start'
    public static int[][] generateM3(int n, int start) {
        int[][] M = new int[n][n];
        int val = start;
        for (int c = 0; c < n; c++)
            for (int r = 0; r < n; r++)
                M[r][c] = val++;
        return M;
    }

    public static void print(int[][] M) {
        for (int[] row : M) {
            for (int v : row)
                System.out.printf("%4d", v);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 5, start = 5;

        System.out.println("M1 (row-by-row):");
        print(generateM1(n, start));

        System.out.println("\nM2 (diagonal zigzag):");
        print(generateM2(n, start));

        System.out.println("\nM3 (column-by-column):");
        print(generateM3(n, start));
    }
}
