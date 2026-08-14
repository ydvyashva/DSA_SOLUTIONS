class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low=1;
        int high = position[position.length-1] - position[0];
        int ans =0;
        while(low<=high){
            int mid = (low+high)/2;
            if(isItPossible(position,m,mid)){
                ans=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
        
    }
    public boolean isItPossible(int position[], int m,int mid){
        int pos=position[0];
        int c=1;
        for(int i=1;i<position.length;i++){
            if(position[i]-pos>=mid){
                pos=position[i];
                c++;
            }
            if(c==m){
                return true;
            }
        }
        return false;
        }
    
}