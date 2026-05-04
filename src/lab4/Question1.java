package lab4;

import java.util.ArrayList;
import java.util.List;

public class Question1 {

    static boolean hasSubset(int[] S, int index, int remaining) {
        if (remaining == 0) return true;
        if (index == S.length || remaining < 0) return false;
        return hasSubset(S, index + 1, remaining - S[index])
            || hasSubset(S, index + 1, remaining);
    }

    static List<Integer> oneSolution(int[] S, int index, int remaining, List<Integer> current) {
        if (remaining == 0) return new ArrayList<>(current);
        if (index == S.length || remaining < 0) return null;
        current.add(S[index]);
        List<Integer> res = oneSolution(S, index + 1, remaining - S[index], current);
        if (res != null) { current.remove(current.size() - 1); return res; }
        current.remove(current.size() - 1);
        return oneSolution(S, index + 1, remaining, current);
    }

    static void allSolutions(int[] S, int index, int remaining, List<Integer> current, List<List<Integer>> results) {
        if (remaining == 0) { results.add(new ArrayList<>(current)); return; }
        if (index == S.length || remaining < 0) return;
        current.add(S[index]);
        allSolutions(S, index + 1, remaining - S[index], current, results);
        current.remove(current.size() - 1);
        allSolutions(S, index + 1, remaining, current, results);
    }

    public static void main(String[] args) {
        int[] S = {3, 4, 7, 8};
        int k = 11;

        System.out.println("S = {3, 4, 7, 8}, k = " + k);

        System.out.println("(a) " + hasSubset(S, 0, k));

        List<Integer> one = oneSolution(S, 0, k, new ArrayList<>());
        System.out.println("(b) " + (one != null ? one : "No solution"));

        List<List<Integer>> all = new ArrayList<>();
        allSolutions(S, 0, k, new ArrayList<>(), all);
        System.out.println("(c) " + all);
    }
}
