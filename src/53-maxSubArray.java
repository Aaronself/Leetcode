/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int thisSum = 0, maxSum = 0, M = nums[0];

        for (int vals : nums) {
            thisSum += vals;
            if (vals > M)
                M = vals;
            if (thisSum > maxSum)
                maxSum = thisSum;
            if (thisSum < 0)
                thisSum = 0;
        }
        if (M < 0)
            return M;
        else
            return maxSum;
    }
}
// @lc code=end

