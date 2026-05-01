package lab1;

public class Algorithms {

    static void main(String[] args) {
        System.out.println(is235Array(new int[]{2,3,5}));
        System.out.println(is235Array(new int[]{2,3,7}));
        System.out.println(is235Array(new int[]{2,3,10}));

        System.out.println(isNot235Array(new int[]{2,3,5}));

        System.out.println(is123Array(new int[]{2,3,5}));
        System.out.println(is123Array(new int[]{2,3,10}));
        System.out.println(isNot123Array(new int[]{2,3,5}));
        System.out.println(isNot123Array(new int[]{2,3,10}));
        System.out.println(isNot123ArrayOptimal(new int[]{2,3,10}));

    }

    public static int isNot123ArrayOptimal (int A[]) {
        for (int i=0; i < A.length; i++) {
            if (A[i] % 6 == 0 || A[i] % 10 == 0 || A[i] % 15 == 0) {
                return 0;
            }
        }
        return 1;
    }


    static int is123Array(int A[]) {
        int n = A.length;
        int count = 0;
        for (int i = 0; i < n; i++)
            if (divisorCount(A[i]) <= 1) count++;
        return (count == n) ? 1 : 0;
    }

    static int isNot123Array(int A[]) {
        int n = A.length;
        for (int i = 0; i < n; i++)
            if (divisorCount(A[i]) >= 2) return 0;
        return 1;
    }

    static int divisorCount(int x) {
        int c = 0;
        if (x % 2 == 0) c++;
        if (x % 3 == 0) c++;
        if (x % 5 == 0) c++;
        return c;
    }

    public static int is235Array(int[] a) {
        int count2 = 0;
        int count3 = 0;
        int count5 = 0;
        int countNone = 0;
        for (int num : a) {
            boolean divisible = false;
            if (num % 2 == 0) {
                count2++;
                divisible = true;
            }
            if (num % 3 == 0) {
                count3++;
                divisible = true;
            }
            if (num % 5 == 0) {
                count5++;
                divisible = true;
            }
            if (!divisible) {
                countNone++;
            }
        }
        if (count2 + count3 + count5 + countNone == a.length) {
            return 1;
        } else {
            return 0;
        }
    }

    public static boolean isNot235Array(int[] a) {
        int count2 = 0, count3 = 0, count5 = 0, countNone = 0;
        for (int num : a) {
            boolean divisible = false;
            if (num % 2 == 0) {
                count2++;
                divisible = true;
            }
            if (num % 3 == 0) {
                count3++;
                divisible = true;
            }
            if (num % 5 == 0) {
                count5++;
                divisible = true;
            }
            if (!divisible) {
                countNone++;
            }
        }
        return (count2 + count3 + count5 + countNone != a.length);
    }

}
