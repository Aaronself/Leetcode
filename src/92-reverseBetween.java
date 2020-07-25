/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
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
import java.util.Stack;

// class ListNode {
//     int val;
//     ListNode next;
//     ListNode(int x) { val = x; }
// }
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode dramme = new ListNode(0);
        dramme.next = head;
        ListNode former = dramme.next;
        ListNode latter = dramme;
        int k = 1;
        while (k < m) {
            if(k == m - 1) latter = former;
            former = former.next;
            k++;
        }
        while (k <= n) {
            stack.push(former);
            former = former.next;
            k++;
        }
        ListNode pre = latter;
        while (!stack.isEmpty()) {
            pre.next = stack.pop();
            pre = pre.next;
        }
        pre.next = former;

        return dramme.next;
    }
}
// @lc code=end

