class Solution {
    static class Element implements Comparable<Element> {
        int val;
        int digitSum;
        int originalIndex;

        public Element(int val, int originalIndex) {
            this.val = val;
            this.digitSum = computeDigitSum(val);
            this.originalIndex = originalIndex;
        }

        private int computeDigitSum(int n) {
            int sum = 0;
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            return sum;
        }

        @Override
        public int compareTo(Element other) {
            if (this.digitSum != other.digitSum) {
                return Integer.compare(this.digitSum, other.digitSum);
            }
            return Integer.compare(this.val, other.val);
        }
    }

    public int minSwaps(int[] nums) {
        int n = nums.length;
        Element[] arr = new Element[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Element(nums[i], i);
        }

        // Sort based on digit sum, then value as tie-breaker
        Arrays.sort(arr);

        boolean[] visited = new boolean[n];
        int totalSwaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || arr[i].originalIndex == i) {
                continue;
            }

            // Find the size of the cycle
            int cycleSize = 0;
            int curr = i;
            while (!visited[curr]) {
                visited[curr] = true;
                curr = arr[curr].originalIndex;
                cycleSize++;
            }

            if (cycleSize > 1) {
                totalSwaps += (cycleSize - 1);
            }
        }

        return totalSwaps;
    }
}