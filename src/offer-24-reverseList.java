import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode list = head;
        while (list != null) {
            stack.push(list);
            list = list.next;
        }
        ListNode newHead = stack.pop();
        ListNode pre = newHead;
        while (stack.isEmpty() != true) {
            pre.next = stack.pop();
            pre = pre.next;
        }
        pre.next = null;

        return newHead;
    }
}