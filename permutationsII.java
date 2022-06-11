class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        helper(nums, 0, result);
        return result;
    }

    private void helper(int[] nums, int index, List<List<Integer>> result) {
        if (index == nums.length) {
            List<Integer> tmp = new ArrayList<>();
            for (int i : nums) {
                tmp.add(i);
            }
            result.add(tmp);
            return;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) { 
            if (set.add(nums[i])) {
                swap(nums, i, index);
                helper(nums, index + 1, result);
                swap(nums, i, index);
            }           
        }
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}