class Solution {
    public int search(int[] nums, int target) {
        int minIndex = findMin(nums);

        // Decide which sorted half to perform binary search in
        if (target >= nums[minIndex] && target <= nums[nums.length - 1]) {
            return binarySearch(nums, target, minIndex, nums.length - 1);
        } else {
            return binarySearch(nums, target, 0, minIndex - 1);
        }
    }

    // Finds the index of the minimum element (rotation pivot)
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    // Standard Binary Search returning index or -1
    public int binarySearch(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}