/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int prev = nums[0];
        int[] newArray = new int[nums.length];
        int length = 0;
        newArray[0] = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (prev != nums[i]) {
                prev = nums[i];
                newArray[++length] = nums[i];
            }
        }
        
        for (int i = 0; i <= length; i++) {
            nums[i] = newArray[i];
        }

        return length + 1;
    }
}
// @lc code=end

