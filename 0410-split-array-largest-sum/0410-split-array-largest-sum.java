class Solution {
    public int splitArray(int[] nums, int k) {
        int left = 0;
        int right = 0;
        
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }
        
        int result = right;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (canSplit(nums, k, mid)) {
                result = mid;
                right = mid - 1; // Try to find a smaller maximum sum
            } else {
                left = mid + 1;  // Increase target max sum
            }
        }
        
        return result;
    }
    
    private boolean canSplit(int[] nums, int k, int maxSum) {
        int count = 1;
        int currentSum = 0;
        
        for (int num : nums) {
            if (currentSum + num > maxSum) {
                count++;
                currentSum = num;
                if (count > k) {
                    return false;
                }
            } else {
                currentSum += num;
            }
        }
        
        return true;
    }
}