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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode l1Reversed = reverse(l1), l2Reversed = reverse(l2);
        ListNode trav1 = l1Reversed, trav2 = l2Reversed, head = new ListNode(-1);
        ListNode result = head; 
        
        int carry = 0, sum = 0;
        
        while(trav1 != null && trav2 != null){
            
            sum = trav1.val + trav2.val + carry;
            
            carry = sum / 10;
            sum = sum % 10;
            
            head.next = new ListNode(sum);
            head = head.next;
            
            trav1 = trav1.next;
            trav2 = trav2.next;
        }
        
        while(trav1 != null){
          
            sum = trav1.val + carry;
            
            carry = sum / 10;
            sum = sum % 10;
            
            head.next = new ListNode(sum);
            head = head.next;
            
            trav1 = trav1.next;
        }
        
        while(trav2 != null){
          
            sum = trav2.val + carry;
            
            carry = sum / 10;
            sum = sum % 10;
            
            head.next = new ListNode(sum);
            head = head.next;
            
            trav2 = trav2.next;
        }
        
        if(carry > 0){
           head.next = new ListNode(carry);
           head = head.next; 
        }
        
        return reverse(result.next);
    }
    
    public ListNode reverse(ListNode node){
        
        ListNode curr = node, prev = null;
        
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        return prev;
    }
}