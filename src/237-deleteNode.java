/*
 * @lc app=leetcode.cn id=237 lang=java
 *
 * [237] 删除链表中的节点
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
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
        // node = node.next 不可行，node只是函数的一个变量，并不会影响实际的链表结构
    }
}
// @lc code=end

