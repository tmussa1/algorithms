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
    
    public void reorderList(ListNode head) {
        
        if(head == null || head.next == null) return;
            
        ListNode slow = head, fast = head, lag = null;
        
        while(fast != null && fast.next != null){
            lag = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        lag.next = null;
        
        ListNode curr = slow, prev = null;
        
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        ListNode trav = prev, temp3 = null;
        curr = head;
        
        while(trav != null && curr != null){
            ListNode temp1 = curr.next, temp2 = trav.next;
            temp3 = curr;
            curr.next = trav;
            if(temp1 != null){
                trav.next = temp1;
            }
            
            curr = temp1;
            trav = temp2;
        }
    }
}