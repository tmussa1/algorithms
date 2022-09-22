/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    private Node findNode(Node node){
        
        if(node.parent != node){
            node.parent = findNode(node.parent);
        }
        
        return node.parent;
    }
    
    private int link(Node node1, Node node2){
        
        Node node1Parent = findNode(node1), node2Parent = findNode(node2);
        
        if(node1Parent == node2Parent){
            return 0;
        }
        
        if(node1Parent.rank > node2Parent.rank){
            node2Parent.parent = node1Parent;
        } else if(node2Parent.rank > node1Parent.rank){
            node1Parent.parent = node2Parent;
        } else {
            node2Parent.parent = node1Parent;
            node1Parent.rank += 1;
        }
        
        return 1;
    }
    
    private Map<Integer, Node> makeSet(int [] nums){
        
        Map<Integer, Node> nodes = new HashMap<>();
            
        for(int num: nums){
            Node node = new Node();
            node.num = num;
            node.parent = node;
            nodes.put(num, node);
        }
        
        return nodes;
    }
    
    public int numComponents(ListNode head, int[] nums) {
        
        Map<Integer, Node> nodes = makeSet(nums);
        
        int components = nums.length;
        
        ListNode curr = head, prev = null;
        
        while(curr != null){
            
            if(!nodes.containsKey(curr.val)){
                prev = null;
                curr = curr.next;
                continue;
            }
            
            if(prev != null){
               Node node1 = nodes.get(prev.val);
               Node node2 = nodes.get(curr.val);
               components -= link(node1, node2);
            }
            
            prev = curr;
            curr = curr.next;
        }
        
        return components;
    }
    
    class Node {
        int num;
        int rank;
        Node parent;
    }
}