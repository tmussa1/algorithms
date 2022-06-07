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
        
        Map<Node, Node> nodes = new HashMap<>();
        
        Node curr = head;
        
        while(curr != null){
            nodes.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        
        curr = head;
        
        while(curr != null){
            Node newNode = nodes.get(curr);
            newNode.next = nodes.get(curr.next);
            newNode.random = nodes.get(curr.random);
            curr = curr.next;
        }
        
        return nodes.get(head);
    }
}