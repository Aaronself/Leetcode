class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode former = head;
        ListNode latter = head;
        int firstMoveStep = k;
        while (firstMoveStep > 0) {
            former = former.next;
            firstMoveStep--;
        }
        while (former != null) {
            former = former.next;
            latter = latter.next;
        }

        return latter;
    }
}