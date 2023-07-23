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
    
    public boolean isPalindrome(ListNode head) {
        
        
        ListNode fast = head, slow = head, prevSlow = head;
        
        while(fast != null && fast.next != null){
            prevSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prevSlow.next = null;
        
        ListNode prev = null, curr = slow;
        
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        while(head != null){
            
            if(prev.val != head.val) return false;
                
            prev = prev.next;
            head = head.next;
        }
        
        
        return true;
    }
}