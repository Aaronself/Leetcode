/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head1 = l1;        
        ListNode head2 = l2;
        ListNode newList = new ListNode(0, null);
        ListNode pre = newList;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                pre.next = head1;
                head1 = head1.next;
                pre = pre.next;
            }
            else {
                pre.next = head2;
                head2 = head2.next;
                pre = pre.next;
            }
        }

        while (head1 != null) {
            pre.next = head1;
            head1 = head1.next;
            pre = pre.next;
        }

        while (head2 != null) {
            pre.next = head2;
            head2 = head2.next;
            pre = pre.next;
        }

        return newList.next;
    }
}
// @lc code=end

