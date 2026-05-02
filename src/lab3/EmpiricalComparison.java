package lab3;

public class EmpiricalComparison {

    // --- searchSS (staircase) ---
    private static int[] searchSSInternal(int[][] M, int key) {
        int n = M.length;
        int r = 0, c = n - 1;
        while (r < n && c >= 0) {
            if (M[r][c] == key) return new int[]{r, c};
            else if (M[r][c] > key) c--;
            else r++;
        }
        return null;
    }

    // --- DACsearchSS ---
    private static int[] dac(int[][] M, int key, int r1, int r2, int c1, int c2) {
        if (r1 > r2 || c1 > c2) return null;
        int midR = (r1 + r2) / 2;
        int midC = (c1 + c2) / 2;
        if (M[midR][midC] == key) return new int[]{midR, midC};
        int[] result;
        if (M[midR][midC] > key) {
            result = dac(M, key, r1, midR - 1, c1, midC - 1);
            if (result != null) return result;
            result = dac(M, key, r1, midR - 1, midC, c2);
            if (result != null) return result;
            return dac(M, key, midR, r2, c1, midC - 1);
        } else {
            result = dac(M, key, r1, midR, midC + 1, c2);
            if (result != null) return result;
            result = dac(M, key, midR + 1, r2, c1, midC);
            if (result != null) return result;
            return dac(M, key, midR + 1, r2, midC + 1, c2);
        }
    }

    private static int[] DACsearchSSInternal(int[][] M, int key) {
        return dac(M, key, 0, M.length - 1, 0, M[0].length - 1);
    }

    public static void main(String[] args) {
        int[] sizes = {50, 100, 200, 500, 1000};
        int trials  = 500;

        System.out.printf("%-8s  %-20s  %-20s%n", "n", "searchSS (ns/op)", "DACsearchSS (ns/op)");
        System.out.println("-".repeat(52));

        for (int n : sizes) {
            int[][] M = GenerateSortedSquare.generateM1(n, 1);
            int minVal = M[0][0];
            int maxVal = M[n - 1][n - 1];

            int[] keys = new int[trials];
            java.util.Random rng = new java.util.Random(42);
            for (int i = 0; i < trials; i++) {
                if (i % 2 == 0) {
                    int r = rng.nextInt(n);
                    int c = rng.nextInt(n);
                    keys[i] = M[r][c];
                } else {
                    keys[i] = minVal - 1 - rng.nextInt(1000);
                }
            }

            for (int k : keys) { searchSSInternal(M, k); DACsearchSSInternal(M, k); }

            long t0 = System.nanoTime();
            for (int k : keys) searchSSInternal(M, k);
            long ssTime = (System.nanoTime() - t0) / trials;

            t0 = System.nanoTime();
            for (int k : keys) DACsearchSSInternal(M, k);
            long dacTime = (System.nanoTime() - t0) / trials;

            System.out.printf("%-8d  %-20d  %-20d%n", n, ssTime, dacTime);
        }
    }
}
