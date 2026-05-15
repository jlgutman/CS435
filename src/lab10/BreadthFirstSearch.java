package lab10;

import java.util.PriorityQueue;
import java.util.Queue;

public class BreadthFirstSearch {

    static void main(String[] args) {
        int[][] adjMatrix = {
                //A  B  C  D  E  F  G  H  I
                {0, 1, 1, 0, 0, 1, 0, 0, 0}, // A
                {1, 0, 0, 0, 0, 1, 0, 0, 0}, // B
                {1, 0, 0, 0, 0, 1, 1, 0, 0}, // C
                {0, 0, 0, 0, 1, 0, 0, 0, 1}, // D
                {0, 0, 0, 1, 0, 0, 0, 0, 1}, // E
                {1, 1, 1, 0, 0, 0, 0, 1, 0}, // F
                {0, 0, 1, 0, 0, 0, 0, 1, 0}, // G
                {0, 0, 0, 0, 0, 1, 1, 0, 0}, // H
                {0, 0, 0, 1, 1, 0, 0, 0, 0}  // I
        };

        String[] labels = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};

        int[] result = findComponents(adjMatrix);

        for (int i = 0; i < result.length; i++) {
            System.out.println(labels[i] + " -> Component " + result[i]);
        }

    }

    private static void dfs(int[][] adjMatrix, boolean[] visited, int[] components, int s, int compNumber) {
        Queue<Integer> Q = new PriorityQueue<>();
        visited[s] = true;
        components[s] = compNumber;
        Q.add(s);
        while (!Q.isEmpty()) {
            int v = Q.poll();
            for (int w = 0; w < adjMatrix[v].length; w++) {
                if (adjMatrix[v][w] == 1 && !visited[w]) {
                    visited[w] = true;
                    components[w] = compNumber;
                    Q.add(w);
                }
            }
        }
    }

    public static int[] findComponents(int[][] adjMatrix) {
        int n = adjMatrix.length;
        int numComponents = 0;
        int[] componentNumbers = new int[n];
        boolean[] visited = new boolean[n];
        for (int v = 0; v < n; v++) {
            if (!visited[v]) {
                numComponents++;
                dfs(adjMatrix, visited, componentNumbers, v, numComponents);
            }
        }
        return componentNumbers;
    }
}
