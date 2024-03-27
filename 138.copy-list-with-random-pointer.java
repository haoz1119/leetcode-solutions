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
// @lc code=end

