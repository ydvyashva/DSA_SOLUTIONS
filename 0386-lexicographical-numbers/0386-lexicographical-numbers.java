class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=9; i++){
             solve(n,i,list);
        }
        return list;
        
    }
    public void solve(int n ,int cur, List<Integer>list){
        if(cur>n){
            return ;
        }
        list.add(cur);
        for(int i = 0; i<=9; i++){
            solve(n, cur*10+i, list);
        }
    }
}