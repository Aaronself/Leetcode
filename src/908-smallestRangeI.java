/*
 * @lc app=leetcode.cn id=908 lang=java
 *
 * [908] 最小差值 I
 */

// @lc code=start
class Solution {
    public int smallestRangeI(int[] A, int K) {
        if (A.length == 1) return 0;
        int min = A[0], max = A[0];
        for (int a : A) {
            if(a > max) max = a;
            if(a < min) min = a;
        }
        if (max - min >= 2 * K)
            return (max - min - 2 * K);
        else
            return 0;
    }
}
// @lc code=end

