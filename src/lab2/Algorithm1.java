package lab2;

public class Algorithm1 {

    public static int findThirdLargest(int[] array) {
        int currentMax = array[0];
        int indexFirst = 0;
        int indexSecond = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > currentMax) {
                currentMax = array[i];
                indexFirst = i;
            }
        }
        currentMax = 0;
        for (int i = 0; i < array.length; i++) {
            if (i != indexFirst && array[i] >= currentMax) {
                currentMax = array[i];
                indexSecond = i;
            }
        }
        currentMax = 0;
        for (int i = 0; i < array.length; i++) {
            if (i != indexFirst && i != indexSecond && array[i] >= currentMax) {
                currentMax = array[i];
            }
        }
        return currentMax;
    }

    static void main(String[] args) {
        System.out.println(findThirdLargest(new int[]{7, 20, 18, 4, 20, 19, 20, 3}));
        System.out.println(findThirdLargest(new int[]{7, 20, 18, 4, 22, 19, 21, 3}));
    }

}
