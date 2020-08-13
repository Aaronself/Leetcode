import jdk.nashorn.api.tree.IfTree;

/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个排序链表
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
// 分而治之
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        int left = 0, right = lists.length - 1;

        return mergeSort(left, right, lists);
    }

    private ListNode mergeSort(int left, int right, ListNode[] lists) {
        if (left >= right)
            return lists[left];

        int mid = (left + right) / 2;
        // ListNode l1 = mergeSort(left, mid, lists);
        // ListNode l2 = mergeSort(mid + 1, right, lists);
        // return merge(l1, l2);
        lists[left] = mergeSort(left, mid, lists);
        lists[mid + 1] = mergeSort(mid + 1, right, lists);
        return merge(lists[left], lists[mid + 1]);
    }

    private ListNode merge(ListNode pre1, ListNode pre2) {
        if (pre1 == null) return pre2;
        if (pre2 == null) return pre1;
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while (pre1 != null && pre2 != null) {
            if (pre1.val > pre2.val) {
                node.next = pre2;
                pre2 = pre2.next;
            }
            else {
                node.next = pre1;
                pre1 = pre1.next;
            }
            node = node.next;
        }
        if (pre1 != null) node.next = pre1;
        if (pre2 != null) node.next = pre2;

        return dummy.next;
    }
}
// @lc code=end
