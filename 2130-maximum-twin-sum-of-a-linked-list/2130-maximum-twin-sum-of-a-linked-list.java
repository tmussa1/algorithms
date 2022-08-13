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
    
    public int pairSum(ListNode head) {
        
       ListNode curr = head;
       ListNode clone = cloneLinkedList(head);
       ListNode reverse = reverseLinkedList(clone);
        
       int max = 0;
        
       while(curr != null){
           max = Math.max(max, curr.val + reverse.val);
           curr = curr.next;
           reverse = reverse.next;
       }
        
       return max;
    }
    
    ListNode cloneLinkedList(ListNode head){
        
        ListNode clone = new ListNode();
        
        ListNode result = clone;
        
        while(head != null){
            clone.next = new ListNode(head.val);
            clone = clone.next;
            head = head.next;
        }
        
        return result.next;
    }
    
    ListNode reverseLinkedList(ListNode head){
        
        ListNode curr = head, prev = null;
        
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        return prev;
    }
}