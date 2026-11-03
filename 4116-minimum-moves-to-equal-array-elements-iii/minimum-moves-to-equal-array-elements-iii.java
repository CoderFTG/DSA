class Solution {
    public int minMoves(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            max = Math.max(nums[i], max);
            sum += nums[i];
        }

        return n*max - sum;
    }
}