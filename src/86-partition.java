/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) { val = x; }
}
class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode pre = head;
        ListNode dummyA = new ListNode(0);
        ListNode dummyB = new ListNode(0);
        ListNode preA = dummyA, preB = dummyB;
        while (pre != null) {
            if (pre.val < x) {
                preA.next = pre;
                preA = preA.next;
            } else if (pre.val >= x) {
                preB.next = pre;
                preB = preB.next;
            }
            pre = pre.next;
        }
        preB.next = null;
        preA.next = dummyB.next;
        return dummyA.next;
    }
}
// @lc code=end

