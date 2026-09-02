class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int low =0;
        int high= 1;
        int count=0;
        int sum = Integer.MIN_VALUE;
        while(high<nums.length){
            if(nums[high]-nums[low]==k && nums[low]+nums[high]!= sum){
                sum=nums[low]+nums[high];
                low++;
                high++;
                count++;
            }   
            else if (nums[high]-nums[low]<k){
                high++;
            }
            else{
                low++;
            }
            if (low==high){
                high++;
            }    
            }    
            return count ;

            }
        }
        
