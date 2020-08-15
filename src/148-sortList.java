/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
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
    ListNode(int x){val = x;}
}
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        return mergeSort(head);
    }
    
    private ListNode mergeSort(ListNode node) {
        if (node.next == null) return node;
        ListNode fast = node.next, slow = node;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode left = mergeSort(node);
        ListNode right = mergeSort(temp);
        return sort(left, right);
    }

    //判断何时停止
    private ListNode sort(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                pre.next = l1;
                l1 = l1.next;
            }
            else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        if(l1 != null) pre.next = l1;
        if(l2 != null) pre.next = l2;

        return dummy.next;
    }
}
// @lc code=end

