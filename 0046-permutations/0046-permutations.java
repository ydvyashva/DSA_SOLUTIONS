class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        solve(nums, ans, list, 0);
        return ans;
    }

    public void solve(int[] nums, List<List<Integer>> ans, List<Integer> list, int index) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int pos = 0; pos <= list.size(); pos++) {
            list.add(pos, nums[index]);
            solve(nums, ans, list, index + 1);
            list.remove(pos);
        }
    }
}