import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<Integer>();

        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] list = new int[stack.size()];
        int k = 0;
        while (!stack.isEmpty()) {
            list[k] = stack.pop();
            k++;
        }

        return list;
    }
}