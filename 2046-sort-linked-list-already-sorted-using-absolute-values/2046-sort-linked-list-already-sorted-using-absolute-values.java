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
    
    public ListNode sortLinkedList(ListNode head) {
        
        ListNode headNode = null, tailNode = null, curr = head;
        
        while(curr != null){
            
            ListNode newNode = new ListNode(curr.val);
            
            if(headNode == null && tailNode == null){
                headNode = newNode;
                tailNode = newNode;
            } else if(curr.val <= 0){
                newNode.next = headNode;
                headNode = newNode;
            } else if(curr.val > 0){
                tailNode.next = newNode;
                tailNode = tailNode.next;
            }
            
            curr = curr.next;
        }
        
        return headNode;
    }
}