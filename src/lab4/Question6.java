package lab4;

public class Question6 {

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int curr = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    public static void main(String[] args) {
        Question6 sol = new Question6();
        System.out.println(sol.rob(new int[]{1, 2, 3, 1}));
        System.out.println(sol.rob(new int[]{2, 7, 9, 3, 1}));
    }
}
