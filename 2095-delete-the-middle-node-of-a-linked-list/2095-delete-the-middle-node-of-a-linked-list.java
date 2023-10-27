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
    
    public ListNode deleteMiddle(ListNode head) {
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode slow = head, fast = head, prev = head;
        
        while(slow != null && fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if(slow == head){
            return null;
        }
        
        prev.next = slow.next;
        
        return dummy.next;
    }
}