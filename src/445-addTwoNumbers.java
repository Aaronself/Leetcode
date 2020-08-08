/*
 * @lc app=leetcode.cn id=445 lang=java
 *
 * [445] 两数相加 II
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

//     ListNode(int x) { val = x; }
// }
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        ListNode res = null;
        int c = 0;
        while(!s1.isEmpty() || !s2.isEmpty() || c > 0) {
            int sum = (s1.isEmpty() ? 0 : s1.pop()) + (s2.isEmpty() ? 0 : s2.pop()) + c;
            ListNode n = new ListNode(sum % 10);
            c = sum / 10;
            n.next = res;
            res = n;
        }
        return res;
    }
}
// @lc code=end

