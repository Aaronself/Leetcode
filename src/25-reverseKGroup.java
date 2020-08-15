/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
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
    ListNode(int x) {val = x;}
}
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        if (k == 1) return head;
        int tmp = k - 1;       
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode left = head, right = head;
        while (true) {
            while (right != null && tmp != 0) {
                right = right.next;
                tmp--;
            }
            if (tmp == 0 && right != null) {
                ListNode nextCycle = right.next;
                right.next = null;
                pre.next = reverse(left);
                left = nextCycle;
                right = nextCycle;
                while (pre.next != null) { pre = pre.next; }
                tmp = k - 1;
            } else {
                pre.next = left;
                break;
            }
        }
        
        return dummy.next;
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode current = node;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }
}
// @lc code=end

