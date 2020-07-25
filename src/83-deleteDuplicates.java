/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode former = head.next;
        ListNode latter = head;
        while (former.next != null) {
            if (former.val == latter.val) {
                former = former.next;
            } else {
                latter.next = former;
                latter = latter.next;
                former = former.next;
            }
        }
        if (former.val == latter.val)
            latter.next = null;
        else
            latter.next = former;
        return head;
    }
}
// @lc code=end

