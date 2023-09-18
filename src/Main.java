import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0)
            return new int[0][0];

        int m = mat.length, n = mat[0].length; // create variables for bounds
        Queue<int[]> queue = new LinkedList<>(); // queue to store grid points

        for (int i = 0; i < m; i++) { // loop grid in BFS manner and add grid point to queue is point value == 0
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    mat[i][j] = -1; // otherwise mark as -1 to later indicate non-visited cell
                }
            }
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; //up, down, left, right directions to derive adjacent cell
        // coordinates from current cell

        while (!queue.isEmpty()) { // loop through queue
            int[] cell = queue.poll();
            for (int[] d : dirs) {
                int r = cell[0] + d[0], c = cell[1] + d[1]; //derive adjacent cells
                if (r < 0 || r >= m || c < 0 || c >= n || mat[r][c] != -1) continue; // if OOB of val of adjacent cell != -1 then cont
                queue.add(new int[]{r, c}); // else add cell coord
                mat[r][c] = mat[cell[0]][cell[1]] + 1; // and change its val from -1 to current cell val +1 which
                // will either be changed from 0 -> 1 if current cell was origianlly of 0 val or from 1,2,3, etc. val
                // in case where current cell already changed from -1 to >0 val and now its neighbor who's val is -1
                // will be +1 from whatevr >0 val of current cell
            }
        }
        return mat;
    }
}