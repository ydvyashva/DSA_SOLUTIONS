class Solution {
    private int[] rows = new int[9];
    private int[] cols = new int[9];
    private int[] boxes = new int[9];

    public void solveSudoku(char[][] board) {
        // Initialize bitmasks with existing numbers on the board
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') {
                    int val = board[r][c] - '1';
                    int mask = 1 << val;
                    int boxIdx = (r / 3) * 3 + (c / 3);
                    
                    rows[r] |= mask;
                    cols[c] |= mask;
                    boxes[boxIdx] |= mask;
                }
            }
        }
        
        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int row, int col) {
        // Move to next row if we reach the end of a column
        if (col == 9) {
            row++;
            col = 0;
        }
        
        // Base case: filled all cells successfully
        if (row == 9) return true;

        // Skip pre-filled cells
        if (board[row][col] != '.') {
            return solve(board, row, col + 1);
        }

        int boxIdx = (row / 3) * 3 + (col / 3);

        for (int val = 0; val < 9; val++) {
            int mask = 1 << val;

            // O(1) bitwise check: verify if 'val' is available in row, col, and box
            if ((rows[row] & mask) == 0 && (cols[col] & mask) == 0 && (boxes[boxIdx] & mask) == 0) {
                // Place digit & set bitmasks
                board[row][col] = (char) ('1' + val);
                rows[row] |= mask;
                cols[col] |= mask;
                boxes[boxIdx] |= mask;

                if (solve(board, row, col + 1)) return true;

                // Backtrack: remove digit & clear bitmasks
                board[row][col] = '.';
                rows[row] ^= mask;
                cols[col] ^= mask;
                boxes[boxIdx] ^= mask;
            }
        }

        return false;
    }
}