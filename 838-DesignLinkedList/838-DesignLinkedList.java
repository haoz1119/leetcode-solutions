// Last updated: 9/14/2025, 12:53:25 PM
class Node{
    int val;
    Node prev;
    Node next;
    public Node(int val){this.val=val;}
    public Node(int val, Node prev, Node next){
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
    public int get(){
        return val;
    }
}
class MyLinkedList {
    Node head;
    Node tail;
    int size;
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    
    public int get(int index) {
        if(head == null) return -1;
        if(index < 0 || index > size - 1) return -1;
        Node cur = head;
        for(int i = 0; i <= index; i++){
            if(i == index) return cur.get();
            cur = cur.next;
        }
        return cur.val;
    }
    
    public void addAtHead(int val) {
        if(size == 0) {
            head = new Node(val);
            tail = head;
        }else{
            head.prev = new Node(val, null, head);
            head = head.prev;
        }
        size++;
    }
    
    public void addAtTail(int val) {
        if(size == 0){
            head = new Node(val);
            tail = head;
        }else{
            tail.next = new Node(val, tail, null);
            tail = tail.next;
        }
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index > size) return;
        if (index == 0){
            if(size == 0){
                head = new Node(val);
                tail = head;
            }else{
                head.prev = new Node(val, null, head);
                head = head.prev;
            }
            size++;
        }
        else if(index == size){
            if(size == 0){
                head = new Node(val);
                tail = head;
            }else{
                tail.next = new Node(val, tail, null);
                tail = tail.next;
            }
            size++;
        }
        else{
            Node cur = head;
            for(int i = 0; i < index - 1; i++){
                cur = cur.next;
            }
            Node next = cur.next;
            cur.next = new Node(val, cur, next);
            next.prev = cur.next;
            size++;
        }
    }
    
    public void deleteAtIndex(int index) {
        if(index < 0 || index > size - 1) return;
        // size = 1
        if(index == 0 && index == size - 1){
            head = null;
            tail = null;
            size--;
        }else{
            if(index == 0){
                head = head.next;
                head.prev = null;
                size--;
            }
            else if(index == size-1) {
                tail = tail.prev;
                tail.next = null;
                size--;
            }
            else{
                Node cur = head;
                for(int i = 0; i < index - 1; i++){
                    cur = cur.next;
                }
                Node next = cur.next.next;
                cur.next = next;
                next.prev = cur;
                size--;
            }
        }
        
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */