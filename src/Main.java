import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int[][] test = new int[5][10];
        System.out.println(test.length);
        System.out.println(test[0].length);
        System.out.println(test[1].length);
        System.out.println(test[5].length);

        // i was misunderstanding how the .length works in a matrix. i thought [m][n] was [y][x]  [column][row] where
        // test.length defaulted to retrieving roow and test[0].length got the depth of m.
        // what is actually happening is in defining the matrix likee [5][10] we are saying that that are 5 rows
        // and each row has a length of 10. so calling test[0] through test[4] will all result in 10 since all rows
        // same length. test[5] OOB since 4 is final row index. test.length gets # of rows.
    }
}
//
//class Solution {
//    public int[][] updateMatrix(int[][] mat) {
//        if (mat == null || mat.length == 0 || mat[0].length == 0)
//            return new int[0][0];
//
//        int m = mat.length, n = mat[0].length; // create variables for bounds
//        Queue<int[]> queue = new LinkedList<>(); // queue to store grid points
//
//        for (int i = 0; i < m; i++) { // loop grid in BFS manner and add grid point to queue is point value == 0
//            for (int j = 0; j < n; j++) {
//                if (mat[i][j] == 0) {
//                    queue.offer(new int[]{i, j});
//                } else {
//                    mat[i][j] = -1; // otherwise mark as -1 to later indicate non-visited cell
//                }
//            }
//        }
//
//        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; //up, down, left, right directions to derive adjacent cell
//        // coordinates from current cell
//
//        while (!queue.isEmpty()) { // loop through queue
//            int[] cell = queue.poll();
//            for (int[] d : dirs) {
//                int r = cell[0] + d[0], c = cell[1] + d[1]; //derive adjacent cells
//                if (r < 0 || r >= m || c < 0 || c >= n || mat[r][c] != -1) continue; // if OOB of val of adjacent cell != -1 then cont
//                queue.add(new int[]{r, c}); // else add cell coord
//                mat[r][c] = mat[cell[0]][cell[1]] + 1; // and change its val from -1 to current cell val +1 which
//                // will either be changed from 0 -> 1 if current cell was originally of 0 val or from 1,2,3, etc. val
//                // in case where current cell already changed from -1 to >0 val and now its neighbor who's val is -1
//                // will be +1 from whatevr >0 val of current cell
//            }
//        }
//        return mat;
//    }
//}