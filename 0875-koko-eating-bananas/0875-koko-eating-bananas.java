class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for(int pile : piles){
            high = Math.max(high, pile);
        }
        int ans = high;
        while(low<=high){
            int mid = low + (high -low)/2;

            if(Eat(piles, mid,h)){
                ans = mid;
                high = mid - 1 ;
            }
            else{
                low = mid + 1;
            }
        }
        return ans ;
    }
    private boolean Eat(int [] piles, int k , int h){
        long totalhours = 0;
        for(int pile: piles){
            totalhours +=(pile + k -1)/k;
        }
        return totalhours <= h ;
    }
}