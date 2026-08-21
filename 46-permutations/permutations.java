class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> path, int[] nums) {
        int n = nums.length;

        if(path.size() == n) {
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < n; i++) {
            if(path.contains(nums[i])) continue;
            
            path.add(nums[i]);
            backtrack(result, path, nums);
            path.remove(path.size() - 1);
        }
    }
}