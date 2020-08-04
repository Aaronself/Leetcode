/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode preA = headA;
        ListNode preB = headB;

        while (preA != preB) {
            preA = (preA == null) ? headB : preA.next;
            preB = (preB == null) ? headA : preB.next;
        }

        return preA;
    }
}
// @lc code=end

