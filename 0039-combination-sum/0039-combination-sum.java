class Solution {
    List<List<Integer>>ans=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        solve(candidates, target,0,0,list);
        return ans;
     }
    public void solve(int candidates[], int target, int sum, int i,List<Integer>list){
        if(sum>target || i==candidates.length){
            return ;
        }
        if(target== sum){
            ans.add(new ArrayList<>(list));
            return ;
        }
        
        //pick
        list.add(candidates[i]);
        solve(candidates,target,sum+candidates[i],i,list);
        list.remove(list.size()-1);
        //skip
        solve(candidates,target,sum, i+1, list);
    } 
}