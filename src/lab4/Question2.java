package lab4;

import java.util.ArrayList;
import java.util.List;

public class Question2 {

    static final int[] S = {3, 4, 7, 8};
    static final int K = 15;

    static boolean hasSubset(int index, int remaining) {
        if (remaining == 0) return true;
        if (index == S.length || remaining < 0) return false;
        return hasSubset(index + 1, remaining - S[index])
            || hasSubset(index + 1, remaining);
    }

    static List<Integer> oneSolution(int index, int remaining, List<Integer> current) {
        if (remaining == 0) return new ArrayList<>(current);
        if (index == S.length || remaining < 0) return null;
        current.add(S[index]);
        List<Integer> res = oneSolution(index + 1, remaining - S[index], current);
        if (res != null) { current.remove(current.size() - 1); return res; }
        current.remove(current.size() - 1);
        return oneSolution(index + 1, remaining, current);
    }

    static void allSolutions(int index, int remaining, List<Integer> current, List<List<Integer>> results) {
        if (remaining == 0) { results.add(new ArrayList<>(current)); return; }
        if (index == S.length || remaining < 0) return;
        current.add(S[index]);
        allSolutions(index + 1, remaining - S[index], current, results);
        current.remove(current.size() - 1);
        allSolutions(index + 1, remaining, current, results);
    }

    public static void main(String[] args) {
        System.out.println("S = {3, 4, 7, 8}, k = " + K);

        System.out.println("(a) " + hasSubset(0, K));

        List<Integer> one = oneSolution(0, K, new ArrayList<>());
        System.out.println("(b) " + (one != null ? one : "No solution"));

        List<List<Integer>> all = new ArrayList<>();
        allSolutions(0, K, new ArrayList<>(), all);
        System.out.println("(c) " + all);
    }
}
