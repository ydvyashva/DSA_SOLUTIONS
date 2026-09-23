class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if not grid or not grid[0]:
            return 0

        rows, cols = len(grid), len(grid[0])
        islands = 0

        def dfs(r, c):
            # Base cases: out of bounds or water ('0')
            if r < 0 or r >= rows or c < 0 or c >= cols or grid[r][c] == '0':
                return

            # Mark current cell as visited by sinking it
            grid[r][c] = '0'

            # Visit all 4 adjacent cells (up, down, left, right)
            dfs(r + 1, c)
            dfs(r - 1, c)
            dfs(r, c + 1)
            dfs(r, c - 1)

        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == '1':
                    islands += 1
                    dfs(r, c)  # Traverses and sinks the entire connected island

        return islands 