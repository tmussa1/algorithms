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
    
    public ListNode swapNodes(ListNode head, int k) {
        
        ListNode curr = head, kNode = null, lastNode = head;
        
        int size = 1;
        
        while(curr != null){
            
            if(size == k + 1){
               lastNode = head; 
            }
            
            if(size == k){
                kNode = curr;
            }
            
            size++;
            curr = curr.next;
            lastNode = lastNode.next;
        }
        
        if(lastNode == null) lastNode = head;
        
        int temp = lastNode.val;
        lastNode.val = kNode.val;
        kNode.val = temp;
        
        return head;
    }
}