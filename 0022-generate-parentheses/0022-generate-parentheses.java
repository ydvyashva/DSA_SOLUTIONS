class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList<>();
        solve(n,0,0, "", list);
        return list;
    }
    public void solve(int n , int open,int close, String ans, List<String> list){
        //if(open==n && close==n){
          //  list.add(ans);
            //return ;
        if(ans.length()==2*n){
            list.add(ans);
            return;  
        }
        if(open<n){
            solve(n,open+1,close, ans+"(" ,list);
        }
        if(close<open){    
            solve(n,open,close+1,ans+")",list);
        }    
    }
}