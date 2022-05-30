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
        
        ListNode head = l1;
        
        addTwoNumbersRec(l1, l2, 0, l1, l2);
        
        return head;
    }
    
    private void addTwoNumbersRec(ListNode l1, ListNode l2, int carry, 
                                  ListNode prev, ListNode prev2){
       
        if(l1 == null){
            
            if(carry == 1 && l2 == null){
                ListNode l = new ListNode(1);
                prev.next = l;
            } else {
                sumCarry(l2, carry, prev);
            }
            
            return;
        }
        
        if(l2 == null){
            
            if(carry == 1 && l1 == null){
                ListNode l = new ListNode(1);
                prev2.next = l;
            } else {
                sumCarry(l1, carry, prev);
            }
            
            return;
        }
        
        int temp = l1.val;
        int sum = (l1.val + l2.val + carry) % 10;
        l1.val = sum;
        
        if(temp + l2.val + carry >= 10){
            carry = 1;
        } else {
            carry = 0;
        }
        
        addTwoNumbersRec(l1.next, l2.next, carry, l1, l2);
    }
    
    private void sumCarry(ListNode head, int carry, ListNode l1){
        
        ListNode prev = null, curr = head;
        
        while(head != null){
            
            int temp = head.val;
            
            head.val = (head.val + carry) % 10;
            
            if(temp + carry >= 10){
                carry = 1;
            } else {
                carry = 0;
            }
            
            prev = head;
            head = head.next;
        }
        
        if(carry == 1){
            head = new ListNode(1);
            
            if(prev != null) {
              prev.next = head;
            }
        }
        
        l1.next = curr;
    }
}