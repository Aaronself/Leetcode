/**
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
import java.util.HashMap;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) { val = x; next = null; }
}
class Solution {
    public boolean hasCycle(ListNode head) {
        HashMap<ListNode, Integer> list = new HashMap<ListNode, Integer>();
        ListNode pre = head;
        int k = 0;
        while (pre != null) {
            if (list.get(pre) == null) {
                list.put(pre, k);
                k++;
            } else
                return true;
            pre = pre.next;
        }
        return false;
    }
}
// @lc code=end

