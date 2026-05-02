package lab3;

public class DACSearchSS {

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

    public static void DACsearchSS(int[][] M, int key) {
        int[] pos = dac(M, key, 0, M.length - 1, 0, M[0].length - 1);
        if (pos != null)
            System.out.println("Found at (" + pos[0] + ", " + pos[1] + ")");
        else
            System.out.println("Not Found");
    }

    public static void main(String[] args) {
        int[][] M2 = GenerateSortedSquare.generateM2(5, 5);
        System.out.println("Matrix M2:");
        GenerateSortedSquare.print(M2);

        System.out.print("\nDACsearchSS(M2, 23) → ");
        DACsearchSS(M2, 23);

        System.out.print("DACsearchSS(M2, 34) → ");
        DACsearchSS(M2, 34);

        System.out.print("DACsearchSS(M2, 5)  → ");
        DACsearchSS(M2, 5);

        System.out.print("DACsearchSS(M2, 29) → ");
        DACsearchSS(M2, 29);
    }
}
