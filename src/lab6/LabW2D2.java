package lab6;
import java.util.Arrays;

public class LabW2D2 {

    // ─── Q1: Radix Sort (radix = 9) ───────────────────────────────────────────

    static int[] countingSort(int[] arr, int radix, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[radix];

        for (int val : arr)
            count[(val / exp) % radix]++;
        for (int i = 1; i < radix; i++)
            count[i] += count[i - 1];
        for (int i = n - 1; i >= 0; i--)
            output[--count[(arr[i] / exp) % radix]] = arr[i];

        return output;
    }

    static int[] radixSort(int[] arr, int radix) {
        int max = Arrays.stream(arr).max().getAsInt();
        int[] result = arr.clone();
        for (int exp = 1; max / exp > 0; exp *= radix)
            result = countingSort(result, radix, exp);
        return result;
    }

    // ─── Q2: Sort 4 elements in at most 5 comparisons ─────────────────────────

    static void swap(int[] a, int i, int j) {
        int t = a[i]; a[i] = a[j]; a[j] = t;
    }

    static void sort4(int[] a) {
        if (a[0] > a[1]) swap(a, 0, 1);                // 1
        if (a[2] > a[3]) swap(a, 2, 3);                // 2
        if (a[0] > a[2]) { swap(a, 0, 2); swap(a, 1, 3); } // 3  →  a[0] ≤ a[2] ≤ a[3], a[0] ≤ a[1]
        if (a[1] <= a[3]) {                             // 4
            if (a[1] > a[2]) swap(a, 1, 2);            // 5
        } else {
            int t = a[1]; a[1] = a[2]; a[2] = a[3]; a[3] = t;
        }
    }

    // ─── Q3: FBS Sort ─────────────────────────────────────────────────────────

    static void fbsSort(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int[] tmp = arr.clone();
        int oddCount = (n + 1) / 2;
        for (int i = 0; i < oddCount; i++)
            arr[2 * i] = tmp[i];
        for (int i = 0; i < n / 2; i++)
            arr[2 * i + 1] = tmp[n - 1 - i];
    }

    // ─── Main ──────────────────────────────────────────────────────────────────

    public static void main(String[] args) {
        System.out.println("=== Q1: Radix Sort (radix = 9) ===");
        int[] arr1 = {179, 721, 639, 549, 292, 427, 335, 435, 62};
        System.out.println("Before: " + Arrays.toString(arr1));
        System.out.println("After:  " + Arrays.toString(radixSort(arr1, 9)));

        System.out.println("\n=== Q2: Sort 4 Elements in 5 Comparisons Worst Case ===");
        int[] arr2 = {4, 2, 3, 1};
        System.out.println("Before: " + Arrays.toString(arr2));
        sort4(arr2);
        System.out.println("After:  " + Arrays.toString(arr2));
        System.out.println("Lower bound: ceil(log2(4!)) = ceil(log2(24)) = 5 comparisons.");
        System.out.println("5 comparisons == lower bound → no violation.");

        System.out.println("\n=== Q3: FBS Sort ===");
        int[] arr3 = {7, 20, 10, 19, 10, 17, 14, 15, 15};
        System.out.println("Before: " + Arrays.toString(arr3));
        fbsSort(arr3);
        System.out.println("After:  " + Arrays.toString(arr3));
    }
}
