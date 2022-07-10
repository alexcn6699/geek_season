class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int n = nums.length;
        int[] dp = new int[n];
        int[] counter = new int[n];
        
        Arrays.fill(counter, 1);
        
        dp[0] = 1;
        
        int maxLen = 0;
        
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = Math.max(dp[j] + 1, dp[i]);
                        counter[i] = counter[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        counter[i] += counter[j];
                    }
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxLen) result += counter[i];
        }
        return result;
    }
}