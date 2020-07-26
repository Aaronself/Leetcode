/*
 * @lc app=leetcode.cn id=138 lang=java
 *
 * [138] 复制带随机指针的链表
 */

// @lc code=start

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node pre = head;
        while (pre != null) {
            Node newNode = new Node(pre.val);
            newNode.next = pre.next;
            pre.next = newNode;
            pre = pre.next.next;
        }
        pre = head;
        while (pre != null) {
            if (pre.random != null)
                pre.next.random = pre.random.next;
            pre = pre.next.next;
        }
        Node dummy = new Node(0);
        Node cur = dummy;
        pre = head;
        while (pre != null) {
            cur.next = pre.next;
            cur = cur.next;
            pre.next = cur.next;
            pre = pre.next;
        }
        return dummy.next;
    }
}
// @lc code=end

