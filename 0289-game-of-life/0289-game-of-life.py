class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        if not board or not board[0]:
            return
        
        m = len(board)
        n = len(board[0])
        
        # Directions for all 8 neighbors
        dr = [-1, -1, -1, 0, 1, 1, 1, 0]
        dc = [-1, 0, 1, 1, 1, 0, -1, -1]
        
        for r in range(m):
            for c in range(n):
                live_neighbors = 0
                
                # Count live neighbors from the original state
                for i in range(8):
                    nr, nc = r + dr[i], c + dc[i]
                    if 0 <= nr < m and 0 <= nc < n:
                        if board[nr][nc] % 2 == 1:
                            live_neighbors += 1
                            
                # Apply Conway's rules
                if board[r][c] == 1:
                    if live_neighbors == 2 or live_neighbors == 3:
                        board[r][c] = 3 # Live now, live next
                else:
                    if live_neighbors == 3:
                        board[r][c] = 2 # Dead now, live next
                        
        # Second pass: Update to the final state
        for r in range(m):
            for c in range(n):
                board[r][c] >>= 1