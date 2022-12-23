class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        vis = set()
        def solve(i, j):
            if not (0 <= i < len(grid)) or not (0 <= j < len(grid[0])):
                return
            
            if (i,j) in vis:
                return
            
            vis.add((i,j))
            if grid[i][j] == "1":
                solve(i-1, j)
                solve(i+1, j)
                solve(i, j+1)
                solve(i, j-1)
            return

        count = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if (i,j) not in vis and grid[i][j] == '1':
                    count += 1
                    solve(i, j)
        return count
        