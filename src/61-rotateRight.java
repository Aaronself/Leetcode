import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
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

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        ListNode pre = head;
        int listNum = 0;
        while (pre != null) {
            pre = pre.next;
            listNum++;
        }
        int t = k % listNum;
        if (t == 0) return head;
        pre = head;
        ListNode dramme = new ListNode(0);
        ListNode former = head;
        ListNode latter = head;
        for (int i = 0; i < t; i++) {
            former = former.next;
        }
        while (former.next != null) {
            former = former.next;
            latter = latter.next;
        }
        dramme.next = latter.next;
        latter.next = null;
        former.next = head;
        
        return dramme.next;
    }
}
// @lc code=end

