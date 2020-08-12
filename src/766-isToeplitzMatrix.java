/*
 * @lc app=leetcode.cn id=766 lang=java
 *
 * [766] 托普利茨矩阵
 */

// @lc code=start
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int row = matrix.length;
        if (row == 0 || row == 1) return true;
        int column = matrix[0].length;
        int cycles = row + column - 2;

        int x = row - 2, y = 0;
        int prex, prey;
        while (cycles != 0) {
            prex = x; prey = y;
            while (x + 1 <= row - 1 && y + 1 <= column - 1){
                if (matrix[x][y] != matrix[x + 1][y + 1]) {
                    return false;
                }
                x = x + 1;
                y = y + 1;
            }
            x = prex == 0 ? 0 : prex - 1;
            y = prex != 0 ? 0 : prey + 1;
            cycles--;
        }

        return true;
    }
}
// @lc code=end

