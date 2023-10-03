class MyLinkedList {
    
    class Node {
        int val;
        Node next;
    }
    
    Node head;
    
    int size = 0;

    public MyLinkedList() {
        head = null;
    }
    
    public int get(int index) {
        
        if(index >= size) return -1;
        
        Node curr = head;
        
        while(curr != null){
            System.out.println(curr.val);
            curr = curr.next;
        }
        
        curr = head;
        
        while(index > 0 && curr != null && curr.next != null){
            index--;
            curr = curr.next;
        }
        
        return curr == null ? -1 : curr.val;
    }
    
    public void addAtHead(int val) {
        
        Node newNode = new Node();
        newNode.val = val;
        size++;
        
        if(head == null){
            head = newNode;
            return;
        }
        
        newNode.next = head;
        head = newNode;
    }
    
    public void addAtTail(int val) {
        
        Node newNode = new Node();
        newNode.val = val;
        size++;
        
        if(head == null){
            head = newNode;
            return;
        }
        
        Node curr = head, prev = null;
        
        while(curr != null){
            prev = curr;
            curr = curr.next;
        }
        
        prev.next = newNode;
    }
    
    public void addAtIndex(int index, int val) {
        
        if(index > size) return;
        
        Node newNode = new Node();
        newNode.val = val;
        size++;
        
        if(head == null){
            head = newNode;
            return;
        }
        
        if(index == 0){
            newNode.next = head;
            head = newNode;
            return;
        }
        
        Node curr = head, prev = head;
        
        while(index > 0 && curr != null){
            index--;
            prev = curr;
            curr = curr.next;
        }
        
        prev.next = newNode;
        newNode.next = curr;
    }
    
    public void deleteAtIndex(int index) {
        
        if(index >= size) return;
        
        if(index == 0){
            head = head.next;
            return;
        }
        
        size--;
        
        Node curr = head, prev = null;
        
        while(curr != null && index > 0){
            index--;
            prev = curr;
            curr = curr.next;
        }
        
        if(prev == null){
            head = null;
            return;
        }
        
        prev.next = curr.next;
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