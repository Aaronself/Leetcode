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
        if (head == null)
            return null;
        // 1-2-3  -> 1-1'-2-2'-3-3'
        for (Node node = head, copy = null; node != null; node = node.next.next) {
            copy = new Node(node.val);
            copy.next = node.next;
            node.next = copy;
        }
        // copy the random node
        for (Node node = head; node != null; node = node.next.next) {
            if (node.random != null)
                node.next.random = node.random.next;
        }

        Node newHead = head.next;
        for (Node node = head, temp = null; node != null && node.next != null;){
            temp = node.next;
            node.next = temp.next;
            node = temp;
        }

        return newHead;
    }
}