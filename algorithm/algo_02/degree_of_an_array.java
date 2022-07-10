class Solution {
    public int findShortestSubArray(int[] nums) {
        // hash map
        // key: num
        // val: freq [freq, start, end, end - start];
        // maxFreqNum
        // return minLen maintain
        HashMap<Integer, int[]> map = new HashMap<Integer, int[]>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new int[]{1,i,i});
            } else {
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            }
        }
        int maxFreqNum = 0;
        int minLen = 0;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] array = entry.getValue();
            if (maxFreqNum < array[0]) {
                maxFreqNum = array[0];
                minLen = array[2] - array[1] + 1;
            } else if (maxFreqNum == array[0]) {
                if (minLen > array[2] - array[1] + 1) {
                    minLen = array[2] - array[1] + 1;
                }
            }
        }
        return minLen;
    }
}