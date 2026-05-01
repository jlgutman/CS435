package lab2;

import java.util.TreeMap;
import java.util.TreeSet;

public class Algorithm3 {

    public static int findThirdLargest1(int[] array) {
        TreeMap<Integer, Integer> top3 = new TreeMap<>();
        int count = 0;

        for (int num : array) {
            top3.merge(num, 1, Integer::sum);
            count++;
            while (count > 3) {
                int smallest = top3.firstKey();
                int freq = top3.get(smallest);
                if (freq == 1) {
                    top3.pollFirstEntry();
                } else {
                    top3.put(smallest, freq - 1);
                }
                count--;
            }
        }
        return top3.firstKey();
    }

    public static int findThirdLargest(int[] array) {
        TreeSet<Integer> top3 = new TreeSet<>();

        for (int num : array) {
            top3.add(num);
            if (top3.size() > 3) {
                top3.pollFirst();
            }
        }
        return top3.first();
    }

    static void main(String[] args) {
        System.out.println(findThirdLargest(new int[]{7, 20, 18, 4, 20, 19, 20, 3}));
        System.out.println(findThirdLargest(new int[]{7, 20, 18, 4, 22, 19, 21, 3}));
    }

}
