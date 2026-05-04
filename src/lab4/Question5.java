package lab4;

public class Question5 {

    public int climbStairs(int n) {
        if (n <= 2) return n;
        int prev2 = 1, prev1 = 2;
        for (int i = 3; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    public static void main(String[] args) {
        Question5 sol = new Question5();
        System.out.println("n=2 -> " + sol.climbStairs(2));
        System.out.println("n=3 -> " + sol.climbStairs(3));
        System.out.println("n=45 -> " + sol.climbStairs(45));
    }
}
