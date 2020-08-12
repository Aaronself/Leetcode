/*
 * @lc app=leetcode.cn id=725 lang=java
 *
 * [725] 分隔链表
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
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) { val = x; }
}
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int num = 0;
        int tempK = k;
        int[] numList = new int[k];
        ListNode[] listnode = new ListNode[k];
        ListNode pre = root;
        ListNode temp;
        while (pre != null) {
            pre = pre.next;
            num += 1;
        }
        for (int i = k - 1; i >= 0; i--) {
            numList[i] = num / k;
            k -= 1;
            num -= numList[i];
        }
        pre = root;
        k = tempK;

        for (int i = 0; i < k; i++) {
            ListNode dummy = new ListNode(0);
            if (numList[i] == 0) {
                listnode[i] = null;
                continue;
            }
            dummy.next = pre;
            while (numList[i] > 1) {
                pre = pre.next;
                numList[i]--;
            }
            temp = pre.next;
            pre.next = null;
            pre = temp;
            listnode[i] = dummy.next;
        }

        return listnode;
    }
}
// @lc code=end

