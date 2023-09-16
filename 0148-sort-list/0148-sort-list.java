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
    
    public ListNode sortList(ListNode head) {
        
        ListNode headNode = null, tailNode = null, curr = head;
        
        while(curr != null){
            
            ListNode newNode = new ListNode(curr.val);
            
            if(headNode == null && tailNode == null){
                headNode = newNode;
                tailNode = newNode;
            } else if(headNode.val >= newNode.val){
                newNode.next = headNode;
                headNode = newNode;
            } else if(tailNode.val <= newNode.val){
                tailNode.next = newNode;
                tailNode = newNode;
            } else if(newNode.val > headNode.val) {
                
                ListNode temp = headNode, prev = null;
                
                while(temp != null && temp.val < curr.val){
                    prev = temp;
                    temp = temp.next;
                }
                
                prev.next = newNode;
                newNode.next = temp;
            }
            
            curr = curr.next;
        }
        
        return headNode;
    }
}