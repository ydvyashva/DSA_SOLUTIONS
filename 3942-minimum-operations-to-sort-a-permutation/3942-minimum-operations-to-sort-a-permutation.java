class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        
        // Helper to check if array is a cyclic rotation of a target array
        int incShift = getCyclicShift(nums, true);
        int decShift = getCyclicShift(nums, false);
        
        int minOps = Integer.MAX_VALUE;
        
        // Case 1: Can be sorted via rotations of the original array (type = 0)
        if (incShift != -1) {
            // Option A: Just rotate left 'incShift' times
            minOps = Math.min(minOps, incShift);
            // Option B: Reverse -> Rotate left (n - incShift) % n -> Reverse (takes 2 extra ops)
            minOps = Math.min(minOps, 2 + ((n - incShift) % n));
        }
        
        // Case 2: Can be sorted via rotations of the reversed array (type = 1)
        if (decShift != -1) {
            // Option A: Reverse first (1 op), then rotate left 'decShift' times
            minOps = Math.min(minOps, 1 + decShift);
            // Option B: Rotate left first '(n - decShift) % n' times, then reverse (1 op)
            minOps = Math.min(minOps, 1 + ((n - decShift) % n));
        }
        
        return minOps == Integer.MAX_VALUE ? -1 : minOps;
    }
    
    private int getCyclicShift(int[] nums, boolean increasing) {
        int n = nums.length;
        int startVal = increasing ? 0 : n - 1;
        int startIndex = -1;
        
        for (int i = 0; i < n; i++) {
            if (nums[i] == startVal) {
                startIndex = i;
                break;
            }
        }
        
        // Verify if the rest of the array matches the cyclic pattern
        for (int i = 0; i < n; i++) {
            int expected = increasing ? (startVal + i) % n : (startVal - i + n) % n;
            if (nums[(startIndex + i) % n] != expected) {
                return -1;
            }
        }
        
        return startIndex;
    }
}