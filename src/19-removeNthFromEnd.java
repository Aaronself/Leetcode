/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第N个节点
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

// class ListNode {
//     int val;
//     ListNode next;
//     ListNode(int x){ val = x; }
// }

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode former = dummy;
        ListNode latter = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            former = former.next;
        }
        // Move first to the end, maintaining the gap
        while (former != null) {
            former = former.next;
            latter = latter.next;
        }
        latter.next = latter.next.next;
        return dummy.next;
    }
}
// @lc code=end

