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
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode curr = head;
        
        int size = 0;
        
        while(curr != null){
            size++;
            curr = curr.next;
        }
        
        curr = head;
        
        int toRemove = size - n;
        
         while(curr != null && toRemove > 1){
             toRemove--;
             curr = curr.next;
         }
        
        if(toRemove == 0){
            dummy.next = head.next;
            return dummy.next;
        }
        
        if(curr.next == null) return null;
            
        curr.next = curr.next.next;
        
        return dummy.next;
    }
}