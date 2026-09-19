class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();
        solve(nums,0,ans,ll);
        return ans;
}
public void solve(int nums[], int i , List<List<Integer>> ans, List<Integer> ll){
    if(i==nums.length){
        ans.add(ll);
        return;
    }
    //not pick 
    solve( nums , i+1 , ans , new  ArrayList<>(ll));
    //pick
    int ele = nums[i];
    ll.add(ele);
    solve(nums, i+1,ans,new ArrayList<>(ll));


    }
}