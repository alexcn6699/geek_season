class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0;i < nums.length;i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (j - i <= nums[i]) {
                    if (dp[j] == 0) {
                        dp[j] = 1 + dp[i];
                    }
                }
            }   
            if (dp[nums.length - 1] != 0) {
                return dp[nums.length-1];
            }
        }
        return 0;
        
    }
}