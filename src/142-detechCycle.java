/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
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
import java.util.Set;
import java.util.HashSet;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
}
class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> list = new HashSet<ListNode>();
        ListNode pre = head;
        while (pre != null) {
            if (!list.contains(pre)) {
                list.add(pre);
            } else
                return pre;
            pre = pre.next;
        }
        return null;
    }
}
// @lc code=end

