import java.util.Map;
import java.util.HashMap;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) { val = x; next = null;}
}

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<ListNode, Integer> map = new HashMap<ListNode, Integer>();
        int k = 1;
        while (headA != null) {
            map.put(headA, k);
            k++;
            headA = headA.next;
        }
        while (headB != null) {
            if (map.get(headB) != null) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}