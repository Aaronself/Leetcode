import sun.security.x509.NetscapeCertTypeExtension;

// Definition for singly-linked list.

class Solution {
    public static void main(String agrs[]){
        
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        
        while(l1 != null || l2 != null){
            ListNode newnode = new ListNode(0);
            int L1val = l1 != null ? l1.val : 0;
            int L2val = l2 != null ? l2.val : 0;
            int sum = L1val + L2val + carry;
            if(sum >= 10){
                sum = sum % 10;
                carry = 1;
            }
            else
                carry = 0;
            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;

            newnode.val = sum;
            newnode.next = null;
            cursor.next = newnode;
            cursor = cursor.next;
        }
        if(carry == 1){
            ListNode newnode = new ListNode(carry);
            newnode.next = null;
            cursor.next = newnode;
            cursor = cursor.next;
        }

        return root.next;
    }
    
}