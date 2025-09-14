// Last updated: 9/14/2025, 12:54:11 PM
/*
// Definition for a Node.
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
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> mapping = new HashMap<>();
        // iterate over the original list, build a mapping from orig nodes to copied nodes
        Node original = head;
        while (original != null) {
            mapping.put(original, new Node(original.val));
            original = original.next;
        }
        // while building the new list, set the random node of the copied nodes through finding 
        // the corresponding nodes in the mapping
        original = head;
        Node copied = mapping.get(original);
        Node head1 = copied;

        while (original != null) {
            copied.next = mapping.get(original.next);
            copied.random = mapping.get(original.random);
            copied = copied.next;
            original = original.next;
        }
        return head1;
    }
}