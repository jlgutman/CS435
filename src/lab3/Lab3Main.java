package lab3;

public class Lab3Main {

    public static void main(String[] args) {
        System.out.println("============================================================");
        System.out.println(" PART (a) — Generate Sorted Squares");
        System.out.println("============================================================");

        int n = 5, start = 5;

        System.out.println("\nM1 (row-by-row fill):");
        int[][] M1 = GenerateSortedSquare.generateM1(n, start);
        GenerateSortedSquare.print(M1);

        System.out.println("\nM2 (diagonal zigzag fill):");
        int[][] M2 = GenerateSortedSquare.generateM2(n, start);
        GenerateSortedSquare.print(M2);

        System.out.println("\nM3 (column-by-column fill):");
        int[][] M3 = GenerateSortedSquare.generateM3(n, start);
        GenerateSortedSquare.print(M3);

        System.out.println("\n============================================================");
        System.out.println(" PART (b) — searchSS (no DAC) on M2");
        System.out.println("============================================================");
        System.out.print("searchSS(M2, 23) → "); SearchSS.searchSS(M2, 23);
        System.out.print("searchSS(M2, 34) → "); SearchSS.searchSS(M2, 34);
        System.out.print("searchSS(M2,  5) → "); SearchSS.searchSS(M2, 5);
        System.out.print("searchSS(M2, 29) → "); SearchSS.searchSS(M2, 29);

        System.out.println("\n============================================================");
        System.out.println(" PART (c) — DACsearchSS on M2");
        System.out.println("============================================================");
        System.out.print("DACsearchSS(M2, 23) → "); DACSearchSS.DACsearchSS(M2, 23);
        System.out.print("DACsearchSS(M2, 34) → "); DACSearchSS.DACsearchSS(M2, 34);
        System.out.print("DACsearchSS(M2,  5) → "); DACSearchSS.DACsearchSS(M2, 5);
        System.out.print("DACsearchSS(M2, 29) → "); DACSearchSS.DACsearchSS(M2, 29);

        System.out.println("\n============================================================");
        System.out.println(" PART (d2) — Empirical Comparison");
        System.out.println("============================================================");
        EmpiricalComparison.main(null);

        System.out.println("\n============================================================");
        System.out.println(" QUESTION 2 — Complexity Ordering");
        System.out.println("============================================================");
        System.out.println("Order (slowest growth to fastest growth):");
        System.out.println("  2^n  ≡  2^(n+1)  [same Θ class, constant factor 2]");
        System.out.println("  <  2^(2n)  [= 4^n, grows as exponential base 4]");
        System.out.println("  <  2^(2^n) [doubly exponential]");
        System.out.println();
        System.out.println("Formal ordering: 2^(n+1) = Θ(2^n) < 2^(2n) < 2^(2^n)");
    }
}
