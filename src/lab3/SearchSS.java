package lab3;

public class SearchSS {

    public static void searchSS(int[][] M, int key) {
        int n = M.length;
        int r = 0, c = n - 1;

        while (r < n && c >= 0) {
            if (M[r][c] == key) {
                System.out.println("Found at (" + r + ", " + c + ")");
                return;
            } else if (M[r][c] > key) {
                c--;
            } else {
                r++;
            }
        }
        System.out.println("Not Found");
    }

    public static void main(String[] args) {
        int[][] M2 = GenerateSortedSquare.generateM2(5, 5);
        System.out.println("Matrix M2:");
        GenerateSortedSquare.print(M2);

        System.out.print("\nsearchSS(M2, 23) → ");
        searchSS(M2, 23);

        System.out.print("searchSS(M2, 34) → ");
        searchSS(M2, 34);

        System.out.print("searchSS(M2, 5)  → ");
        searchSS(M2, 5);

        System.out.print("searchSS(M2, 29) → ");
        searchSS(M2, 29);
    }
}
