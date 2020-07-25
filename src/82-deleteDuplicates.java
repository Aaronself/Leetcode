/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
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

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

class ListNode {
    int val;
    ListNode next;
    ListNode (int x) {val = x;}
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        HashMap<Integer, Integer> mapNoDulicate = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> mapDulicate = new HashMap<Integer, Integer>();
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode dramme = new ListNode(0);
        dramme.next = head;
        ListNode pre = dramme;
        int k = 0;
        while (head != null) {
            if (mapNoDulicate.get(head.val) == null) {
                if (mapDulicate.get(head.val) == null) {
                    mapNoDulicate.put(head.val, k);
                    list.add(head);
                    k++;
                }
                head = head.next;
            } else {
                list.remove(list.size() - 1);
                mapNoDulicate.remove(head.val);
                if (mapDulicate.get(head.val) == null) {
                    mapDulicate.put(head.val, k);
                    k++;
                }
                head = head.next;
            }
        }
        if (list.size() == 0)
            return null;
        for(ListNode q : list){
            pre.next = q;
            pre = pre.next;
        }
        pre.next = null;

        return dramme.next;
    }
}
// @lc code=end

