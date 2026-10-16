class Solution {
    private static final int MOD = 1000000007;
    
    // Segment Tree arrays
    long[] tree;
    long[] lazy;
    long[] sumSquares;

    // Push lazy updates down the segment tree
    private void push(int node, int l, int r) {
        if (lazy[node] != 0) {
            int mid = l + (r - l) / 2;
            apply(2 * node, l, mid, lazy[node]);
            apply(2 * node + 1, mid + 1, r, lazy[node]);
            lazy[node] = 0;
        }
    }

    private void apply(int node, int l, int r, long val) {
        long len = (r - l + 1);
        tree[node] = (tree[node] + 2 * val * sumSquares[node] + val * val % MOD * len) % MOD;
        lazy[node] = (lazy[node] + val) % MOD;
        sumSquares[node] = (sumSquares[node] + val * len) % MOD;
    }

    // Range update: add val to range [ql, qr]
    private void update(int node, int l, int r, int ql, int qr, long val) {
        if (ql > r || qr < l) return;
        if (ql <= l && r <= qr) {
            apply(node, l, r, val);
            return;
        }
        push(node, l, r);
        int mid = l + (r - l) / 2;
        update(2 * node, l, mid, ql, qr, val);
        update(2 * node + 1, mid + 1, r, ql, qr, val);
        tree[node] = (tree[2 * node] + tree[2 * node + 1]) % MOD;
        sumSquares[node] = (sumSquares[2 * node] + sumSquares[2 * node + 1]) % MOD;
    }

    public int sumCounts(int[] nums) {
        int n = nums.length;
        tree = new long[4 * n];
        lazy = new long[4 * n];
        sumSquares = new long[4 * n];

        // Coordinate compression or a map for last seen indices of elements
        java.util.HashMap<Integer, Integer> lastSeen = new java.util.HashMap<>();
        
        long totalSum = 0;
        long currentSum = 0;

        for (int j = 0; j < n; j++) {
            int last = lastSeen.getOrDefault(nums[j], -1);
            
            // Update range [last + 1, j] with +1
            update(1, 0, n - 1, last + 1, j, 1);
            
            // tree[1] now holds the sum of squares of all subarrays ending at index j
            totalSum = (totalSum + tree[1]) % MOD;
            
            lastSeen.put(nums[j], j);
        }

        return (int) totalSum;
    }
}