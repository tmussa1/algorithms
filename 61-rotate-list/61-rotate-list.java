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
    
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head == null || head.next == null) return head;
        
        int length = 0;
        
        ListNode curr = head, prev = null;
        
        while(curr != null){
            length++;
            prev = curr;
            curr = curr.next;
        }
        
        curr = head;
        
        int counter = 0;
        
        k = k % length;
        
        if(k == 0){
            return head;
        }
        
        while(curr != null && counter < length - k - 1){
            counter++;
            curr = curr.next;
        }
        
        ListNode newHead = curr.next;
        
        curr.next = null;
        prev.next = head;
        
        head = newHead;
        
        return head;
    }
}