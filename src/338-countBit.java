/*
 * @lc app=leetcode.cn id=338 lang=java
 *
 * [338] 比特位计数
 */

// @lc code=start
// 分奇偶来实现
class Solution {
    public int[] countBits(int n) {
        int[] dplist = new int[n+1];

        dplist[0] = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & 1) == 0) {
                dplist[i] = dplist[i / 2];
            } else
                dplist[i] = dplist[i - 1] + 1;
        }
        return dplist;
    }
}
// @lc code=end

