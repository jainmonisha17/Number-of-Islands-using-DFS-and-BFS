import java.util.*;

public class numOfIslandsDFS {
    public int numIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == 1) {
                    count++;
                    dfs(grid, row, col);
                }
            }
        }

        return count;
    }

    private static void dfs(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length)
            return; // return if it is not valid cell
        if (grid[row][col] == 0)
            return; // return if it is water cell

        grid[row][col] = 0; // mark the cell visited by makeing it a water cell

        // recursively visit all nieghbourig cells(horizantally & vertically)

        dfs(grid, row + 1, col); // lower cell
        dfs(grid, row - 1, col); // upper cell
        dfs(grid, row, col + 1); // right cell
        dfs(grid, row, col - 1); // left cell

    }

    public static void main(String[] args) {
        numOfIslandsDFS sol = new numOfIslandsDFS();
        System.out.println(sol.numIslands(
                new int[][] {
                        { 0, 1, 1, 1, 0 },
                        { 0, 0, 0, 1, 1 },
                        { 0, 1, 1, 1, 0 },
                        { 0, 1, 1, 0, 0 },
                        { 0, 0, 0, 0, 0 }
                }));

        System.out.println(sol.numIslands(
                new int[][] {
                        { 1, 1, 1, 0, 0 },
                        { 0, 1, 0, 0, 1 },
                        { 0, 0, 1, 1, 0 },
                        { 0, 0, 1, 0, 0 },
                        { 0, 0, 1, 0, 0 }
                }));
    }
}


// Time complexity: 
// TC is O(row * col), where rows and cols of the input matrix. This is due to the fact theat we have to traverse the whole matrix to find islands.

// Space Complexity:
// DFS recursion stack can go row * col deep when the whole matrix is filled with '1's
// Hence the SC will be O(row * col) 


-------------------------------------------------------------------------------------------------------------------------


import java.util.*;

public class numOfIslandsBFS {

    public static int numIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        for(int row = 0; row < n; row++) {
            for(int col = 0; col < m; col++) {
                if(grid[row][col] == 1) {
                    count++;
                    bfs(grid, row, col);
                }
            }
        }

        return count;
    }

    private static void bfs(int[][] grid, int ro, int co) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{ro, co});

        while(!queue.isEmpty()) {
            int row = queue.peek()[0];
            int col = queue.peek()[1];
            queue.remove();

            if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) 
                continue;  // continue if it is not a valid cell
            if(grid[row][col] == 0) 
                continue;   // continue if it is a water cell
            
            grid[row][col] = 0;  // mark the cell visited by making it a water cell

            // insert all neighbouring cells to the queue for bfs

            queue.add(new int[] {row + 1, col}); // lower cell
            queue.add(new int[] {row - 1, col}); // upper cell
            queue.add(new int[] {row, col + 1}); // right cell
            queue.add(new int[] {row, col - 1}); // left cell 
        }
    }

    public static void main(String[] args) {
        System.out.println(numOfIslandsBFS.numIslands(
                new int[][] {
                        { 0, 1, 1, 1, 0 },
                        { 0, 0, 0, 1, 1 },
                        { 0, 1, 1, 1, 0 },
                        { 0, 1, 1, 0, 0 },
                        { 0, 0, 0, 0, 0 }
                }));

        System.out.println(numOfIslandsBFS.numIslands(
                new int[][] {
                        { 1, 1, 1, 0, 0 },
                        { 0, 1, 0, 0, 1 },
                        { 0, 0, 1, 1, 0 },
                        { 0, 0, 1, 0, 0 },
                        { 0, 0, 1, 0, 0 }
                }));
    }
}


// Time Complexity
// Time complexity of the above algorithm will be , where ‘M’ is the number of rows and 'N' is the number of columns.

// Space Complexity
// Space complexity of the above algorithm will be . In the worst case, when the matrix is completely filled with land cells, the size of the queue can grow up to .
