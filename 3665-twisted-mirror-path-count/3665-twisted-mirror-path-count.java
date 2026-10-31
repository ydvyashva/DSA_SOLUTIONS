class Solution {
    public int uniquePaths(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int MOD = 1_000_000_007;

        // dpRight[j]: ways entering current cell from left
        // dpDown[j]: ways entering current cell from above
        int[] dpRight = new int[n];
        int[] dpDown = new int[n];

        // Starting position
        dpRight[0] = 1;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                int right = dpRight[j];
                int down = dpDown[j];

                // Destination reached
                if (i == m - 1 && j == n - 1) {
                    return (right + down) % MOD;
                }

                // Clear current states
                dpRight[j] = 0;
                dpDown[j] = 0;

                int total = (right + down) % MOD;

                if (grid[i][j] == 0) {

                    // Empty cell: move right
                    if (j + 1 < n) {
                        dpRight[j + 1] =
                            (dpRight[j + 1] + total) % MOD;
                    }

                    // Empty cell: move down
                    if (i + 1 < m) {
                        dpDown[j] =
                            (dpDown[j] + total) % MOD;
                    }

                } else {

                    // Mirror: right becomes down
                    if (i + 1 < m) {
                        dpDown[j] =
                            (dpDown[j] + right) % MOD;
                    }

                    // Mirror: down becomes right
                    if (j + 1 < n) {
                        dpRight[j + 1] =
                            (dpRight[j + 1] + down) % MOD;
                    }
                }
            }
        }

        return 0;
    }
}