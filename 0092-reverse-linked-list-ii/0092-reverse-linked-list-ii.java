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
    
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        if(head == null || head.next == null || left == right) return head;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode leftPrev = null, rightNext = null, curr = dummy, prev = dummy;
        
        int size = 0;
        
        while(curr != null){
            
            if(size == left){
                leftPrev = prev;
            }
            
            if(size == right){
                rightNext = curr;
            }
            
            prev = curr;
            curr = curr.next;
            size++;
        }
        
        ListNode temp = leftPrev.next, temp2 = rightNext.next;
        leftPrev.next = null;
        rightNext.next = null;
        
        ListNode reversed = reverseList(temp);
        
        leftPrev.next = reversed;
        
        curr = reversed; prev = null;
        
        while(curr != null){
            prev = curr;
            curr = curr.next;
        }
        
        prev.next = temp2;
        
        return dummy.next;
    }
    
    private ListNode reverseList(ListNode head){
        
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