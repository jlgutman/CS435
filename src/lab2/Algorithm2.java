package lab2;

public class Algorithm2 {

    public static int findThirdLargest(int[] array) {
        int max = 0, preMax = 0, prePreMax = 0;
        for (int num : array) {
            if (num > max) {
                prePreMax = preMax;
                preMax = max;
                max = num;
            } else if (num > preMax) {
                prePreMax = preMax;
                preMax = num;
            } else if (num > prePreMax) {
                prePreMax = num;
            }
        }
        return prePreMax;
    }

    static void main(String[] args) {
        System.out.println(findThirdLargest(new int[]{7, 20, 18, 4, 20, 19, 20, 3}));
        System.out.println(findThirdLargest(new int[]{7, 20, 18, 4, 22, 19, 21, 3}));
    }

}
