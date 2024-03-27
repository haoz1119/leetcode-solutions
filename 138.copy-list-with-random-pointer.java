/*
 * @lc app=leetcode id=138 lang=java
 *
 * [138] Copy List with Random Pointer
 */

// @lc code=start
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
        if(head == null) return null;
        Node cur = head;
        Node head1 = new Node(head.val);
        Node prev = head1;
        Node temp = null;
        HashMap<Node, Node> map = new HashMap<>();
        map.put(head, head1);
        while(cur.next != null){
            cur = cur.next;
            temp = new Node(cur.val);
            map.put(cur, temp);
            prev.next = temp;
            prev = temp;
        }
        cur = head;
        Node cur1 = head1;
        while(cur != null){
            temp = cur.random;
            if(temp == null) cur1.random = null;
            else cur1.random = map.get(temp);
            cur = cur.next;
            cur1 = cur1.next;
        }
        return head1;
    }
}

// easier solution
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
// @lc code=end

