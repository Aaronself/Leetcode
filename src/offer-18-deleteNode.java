class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if (val == head.val) return head.next;
        ListNode former = head.next;
        ListNode latter = head;
        while (former != null) {
            if (former.val == val) {
                latter.next = former.next;
            }
            former = former.next;
            latter = latter.next;
        }
        return head;
    }
}